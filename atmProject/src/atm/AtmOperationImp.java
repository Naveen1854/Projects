package atm;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class AtmOperationImp implements AtmInterface {

//	create object for DTO class
	Dto dto = new Dto();

//	create object for Map Interface 
	Map<Double, String> ministmt = new HashMap<>(); // HashMap is a class which implements Map Interface

//	function for checkBalance
	public void viewBalance() {
		System.out.println("Available Balance: " + dto.getBalance()); // print the available balance to the console

	}

//	function for withdrawAmount
	public void withdrawAmount(double withdrawAmount) {
		if (withdrawAmount % 500 == 0) { // withdrawAmount should always in 500
			if (withdrawAmount <= dto.getBalance()) { // always less than available balance
				System.out.println("collect the cash " + withdrawAmount);
				dto.setBalance(dto.getBalance() - withdrawAmount); // after withdrawn update the balance
				ministmt.put(withdrawAmount, "Amount withdrawn"); // store transaction in Map for miniStatement
				viewBalance();
			} else {
				System.out.println("Insufficient Balance");
			}

		} else {
			System.out.println("Enter the amount in terms of 500");
		}
	}

//	function for depositAmount
	public void depostiAmount(double depostiAmount) {
		System.out.println("Deposited Amount is: " + depostiAmount);
		dto.setBalance(dto.getBalance() + depostiAmount); // add amount to the current balance and update the balance
		ministmt.put(depostiAmount, "Deposited Successfully"); // store transaction in Map for miniStatement
		viewBalance();
	}

//	function for miniStatement
	public void viewMiniStatement() {
		Set<Double> set = ministmt.keySet(); // we use Set interface to keySet from Map
		for (Double d : set) { // Iterate the objects and print the miniStatement
			System.out.println(d + " " + ministmt.get(d));
		}
	}

}
