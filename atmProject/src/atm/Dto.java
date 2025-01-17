package atm;

public class Dto {
	private double balance; // private variables:balance, depositAmount, withdrawAmount
	private double depositAmount;
	private double withdrawAmount;

	public Dto() { // non parameterized constructor because we use getters & setters
		super();
		this.balance = balance;
		this.depositAmount = depositAmount;
		this.withdrawAmount = withdrawAmount;
	}

	public double getBalance() { // getters & setters
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getDepositAmount() {
		return depositAmount;
	}

	public void setDepositAmount(double depositAmount) {
		this.depositAmount = depositAmount;
	}

	public double getWithdrawAmount() {
		return withdrawAmount;
	}

	public void setWithdrawAmount(double withdrawAmount) {
		this.withdrawAmount = withdrawAmount;
	}

	@Override // toStrting Method to print details instead of object address
	public String toString() {
		return "Dto [balance=" + balance + ", depositAmount=" + depositAmount + ", withdrawAmount=" + withdrawAmount
				+ "]";
	}
}
