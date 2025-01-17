package atm;

public interface AtmInterface {

//	abstract methods present inside AtmInterface
//	all the methods must implemented in implementation class
	public void viewBalance();

	public void withdrawAmount(double withdrawAmount);

	public void depostiAmount(double depostiAmount);

	public void viewMiniStatement();
}
