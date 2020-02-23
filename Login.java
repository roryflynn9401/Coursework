package gradedGroupProjectPrincipled;

import java.util.ArrayList;

public class Login {
	GetInput input = new GetInput();
	ErrorMessage error = new ErrorMessage();
	
	String username;
	String password;
	int pos = 0;
	
	Print print = new Print();
	
	public int login(ArrayList<BankClient> bankClients) {
		provideLoginDetails();
		pos = search(bankClients);
		
		String errorMessage = checkTransactionStructure(bankClients);
		if (errorMessage != null) error.printErrorMessage(errorMessage);
		System.out.println(pos);
		return pos;
	}
	
	public void provideLoginDetails() {
		username = input.read( "username" );
		password = input.read( "password" );
	}
	
	public int search(ArrayList<BankClient> bankClients) {
		for( pos = 0; pos < bankClients.size(); ++pos ) {
			if( bankClients.get( pos ).username.equals( username ) && bankClients.get( pos ).password.equals( password ) ) {
				print.toPrint(bankClients.get( pos ));

				int accountNumber = Integer.parseInt( input.read( "account number" ) );

				print.toPrintAccount(bankClients.get( pos ), accountNumber );
				break;
			}
		}
		return pos;
	}
	
	public String checkTransactionStructure(ArrayList<BankClient> bankClients) {
		if( pos < 0 || pos > bankClients.size() ) return "Invalid username or password";
		
		return null;
	}
	
}