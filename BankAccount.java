package BankingSystem;

public class BankAccount {
	private int accountNumber;
	private AccountType accType;
	private double balance;
	private static int nextAccNumber = 10000000;
	
	public BankAccount(AccountType accType, double balance) {
		this.accountNumber = nextAccNumber;
		nextAccNumber++;
		this.balance = balance;
		this.accType = accType;
	}
	public int getAccountNumber() {
		return this.accountNumber;
	}
	public AccountType getAccType() {
		return this.accType;
	}
	public double getBalance() {
		return this.balance;
	}
	public void setAccType(AccountType accType) {
		this.accType = accType;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
}
