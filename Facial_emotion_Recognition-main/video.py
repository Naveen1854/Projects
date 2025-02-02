#shows the code where plot contains emotion names

import os
import cv2
import numpy as np
from keras.preprocessing import image
from keras.models import load_model
import matplotlib.pyplot as plt
from collections import defaultdict

# Load model
model = load_model("emotion_model_mn.h5")

# Load the face cascade
face_haar_cascade = cv2.CascadeClassifier(cv2.data.haarcascades + 'haarcascade_frontalface_default.xml')

# Initialize emotion trends
emotion_trends = defaultdict(list)

cap = cv2.VideoCapture(0)

# Define emotions
emotions = ('angry', 'disguist', 'happy', 'sad', 'surprise')

while True:
    ret, test_img = cap.read()
    if not ret:
        continue

    gray_img = cv2.cvtColor(test_img, cv2.COLOR_BGR2RGB)
    faces_detected = face_haar_cascade.detectMultiScale(gray_img, 1.32, 5)

    for (x, y, w, h) in faces_detected:
        roi_gray = gray_img[y:y + w, x:x + h]
        roi_gray = cv2.resize(roi_gray, (224, 224))
        img_pixels = image.img_to_array(roi_gray)
        img_pixels = np.expand_dims(img_pixels, axis=0)
        img_pixels /= 255

        predictions = model.predict(img_pixels)
        max_index = np.argmax(predictions[0])
        emotions = ('angry', 'disguist', 'happy', 'sad', 'surprise')
        predicted_emotion = emotions[max_index]

        # Update emotion trends for all detected emotions
        for emotion, prob in zip(emotions, predictions[0]):
            emotion_trends[emotion].append(prob)

        # Draw rectangle and emotion text on the frame
        cv2.rectangle(test_img, (x, y), (x + w, y + h), (255, 0, 0), thickness=7)
        predicted_emotion = emotions[np.argmax(predictions[0])]
        cv2.putText(test_img, predicted_emotion, (int(x), int(y)), cv2.FONT_HERSHEY_SIMPLEX, 1, (0, 0, 255), 2)

    # Display the frame
    resized_img = cv2.resize(test_img, (1000, 700))
    cv2.imshow('Facial emotion analysis', resized_img)

    # Check for key press to exit
    if cv2.waitKey(10) == ord('q'):
        break

# Release the camera and close all windows
cap.release()
cv2.destroyAllWindows()

# Plot emotion trends with emotion names
plt.figure(figsize=(10, 6))
for emotion, trend in emotion_trends.items():
    plt.plot(trend, label=emotion)

plt.title('Emotion Trends Analysis')
plt.xlabel('Frames')
plt.ylabel('Emotion Probability')
plt.legend()
plt.show()