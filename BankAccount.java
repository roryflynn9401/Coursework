package gradedGroupProjectPrincipled;

public abstract class BankAccount {
	
	private int accountNumber;
	private double balance;
	private static int nextAccNumber = 1000;
	private boolean verified;

	public BankAccount(double balance, boolean verified) {
		this.accountNumber = nextAccNumber;
		nextAccNumber++;
		this.balance = balance;
		this.verified = verified;
	}
	
	public int getAccountNumber() {
		return this.accountNumber;
	}
	
	public double getBalance() {
		return this.balance;
	}
	public boolean getVerified() {
		return this.verified;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public void setVerified(boolean verified) {
		this.verified = verified;
	}
}
