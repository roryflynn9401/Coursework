package gradedGroupProjectPrincipled;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ChangeClientDetails {
	
	String name;
	String address;
	Date birthDate;
	String username;
	String password;
	
	ErrorMessage error = new ErrorMessage();
	
	public void changeDetails(int pos, ArrayList<BankClient> bankClients) {
		provideDetails();
		String errorMessage = checkTransactionStructure();
		if (error != null) error.printErrorMessage(errorMessage);
		changeDetailsTransaction(pos, bankClients);
	}
	
	public void provideDetails() {
		GetInput input = new GetInput();
		
		name = input.read( "new name" );
		address = input.read( "new address" );
		
		birthDate = null;
		try { birthDate = new SimpleDateFormat( "dd/MM/yyyy" ).parse( input.read( "new birthDate" ) ); }
		catch( ParseException ex ){ ex.printStackTrace(); }
		
		username = input.read( "new username" );
		password = input.read( "new password" );
	}
	
	public String checkTransactionStructure() {
		if( username == null || password == null || name == null || address == null || birthDate == null ) return "Error editing details transaction";
		
		return null;
	}
	
	public void changeDetailsTransaction(int pos, ArrayList<BankClient> bankClients) {
		bankClients.get( pos ).changeClientDetails( name, address, birthDate, username, password );
	}
}
