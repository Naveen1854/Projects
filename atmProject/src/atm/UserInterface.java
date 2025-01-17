package atm;

import java.util.Scanner;

public class UserInterface {
	private static int status; // create static variable to know the status of transaction

	public static void main(String[] args) { // execution starts from main method

		AtmOperationImp impl = new AtmOperationImp(); // create object for implementation class to access all the
														// present in it

		Scanner scan = new Scanner(System.in); // create Scanner Object to take input from user
		int dbatmNumber = 12345; // create variables of atmNumber, atmPin
		int dbatmPin = 123;

		System.out.println("Welcome to ATM Machine");
		System.out.println("Enter the ATM Number");
		int useratmNum = scan.nextInt(); // take input from user as useratmNum
		System.out.println("Enter the ATM Pin");
		int useratmPin = scan.nextInt(); // take input from user as useratmPin

		if (dbatmNumber == useratmNum && dbatmPin == useratmPin) { // compare dbatmNumber,dbatmPin with useratmNum, useratmPin
			while (true) { 												// if both are equal do the transaction
				System.out.println("1.viewBalance\n2.withdrawAmount\n3.depositAmount\n4.viewMinistatement\n5.exit");
				System.out.println("Enter Your Choice");
				int ch = scan.nextInt();
				if (ch == 1) {
					impl.viewBalance();
				} else if (ch == 2) {
					System.out.println("Enter the amount to withdraw");
					double withdrawamount = scan.nextDouble();
					impl.withdrawAmount(withdrawamount);
				} else if (ch == 3) {
					System.out.println("Enter the amount to Deposit");
					double depositAmount = scan.nextDouble();
					impl.depostiAmount(depositAmount);
				} else if (ch == 4) {
					impl.viewMiniStatement();
				} else if (ch == 5) {
					System.out.println("Collect your ATM card \nThank you for Banking😊");
					System.exit(status);
				}
			}

		} else {
			System.out.println("Incorrect ATM Number or PIN ");
		}

	}

}
