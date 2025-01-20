package basicCalculator;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class Calculator extends JFrame {

	JTextField display;
	ButtonPanel buttonPanel;
	ActionHandler actionHandler;

	public Calculator() {
		setLayout(new BorderLayout());
		display = new JTextField();
		display.setEditable(false);
		display.setFont(new Font("Arial", Font.BOLD, 30));
		add(display, BorderLayout.NORTH);
		actionHandler = new ActionHandler(display);
		buttonPanel = new ButtonPanel(actionHandler);
		add(buttonPanel, BorderLayout.CENTER);

		setTitle("Calculator");
		setSize(300, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new Calculator();

	}

}
