package gradedGroupProjectPrincipled;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class CreateAccount {
	
	String adminName = "X";
	public static final AtomicInteger accountCount = new AtomicInteger( 0 );
	Verification toVerify = new Verification();
	ErrorMessage error = new ErrorMessage();
	
	
	public void createAccount(BankClient bankClient) {
		String accountType = provideAccountType();
		String errorMessage = checkTransactionStructure(accountType);
		if (errorMessage != null) error.printErrorMessage(errorMessage);
		
		int accountNumber = executeAddAccount(bankClient, accountType);
		boolean verified = toVerify.askForVerification( bankClient.clientID, accountNumber, adminName ); //TODO: contact bank admin
		toVerify.verify(bankClient, accountNumber, verified );
	}
	
	public String provideAccountType() { 
		GetInput input = new GetInput();
		String accountType = input.read( "account type (primary, savings)" );
		
		return accountType;
	}
	
	public String checkTransactionStructure(String accountType) {
		if( accountType == null || (accountType != null && ! accountType.equals( "primary" ) && ! accountType.equals( "savings" ) ) ) return "Error with account type";
		
		return null;
	}
	
	public int executeAddAccount(BankClient bankClient, String accountType){
		if(accountType.toLowerCase() ==  "savings") {
			SavingsAccount temp = new SavingsAccount(0, false);
			bankClient.userAccounts.add(temp);
		}
		/* bankClient.accountNumbers.add( accountCount.incrementAndGet() );
		bankClient.accountTypes.add( accountType );
		bankClient.accountVerified.add( false );
		bankClient.accountBalances.add( 0.0 ); */

		return accountCount.get();
	}
}
