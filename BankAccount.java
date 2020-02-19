package GroupCW;

public abstract class BankAccount {
	private int accountNumber;
	private double balance;
	private static int nextAccNumber = 10000000;

	public BankAccount(double balance) {
		this.accountNumber = nextAccNumber;
		nextAccNumber++;
		this.balance = balance;
	}
	public int getAccountNumber() {
		return this.accountNumber;
	}
	public double getBalance() {
		return this.balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
}
