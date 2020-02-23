package gradedGroupProjectPrincipled;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class CreateClientAndProfile {
	
BankClient bankClient;
ErrorMessage error = new ErrorMessage();
	
	String username;
	String password;
	String name;
	String address; 
	Date birthDate;
	
	public BankClient createClientAndProfile(ArrayList<BankClient> bankClients) {
		provideDetails();
		String errorMessage = checkTransactionStructure();
		if( errorMessage != null ) error.printErrorMessage(errorMessage);
		else {
			createClient(bankClients);
		}
		return bankClient;
	}
	
	public void provideDetails() {
		GetInput input = new GetInput();
		
		username = input.read( "username" );
		password = input.read( "password" );
		
		name = input.read( "name" );
		address = input.read( "address" );
		birthDate = null;
				
		try { birthDate = new SimpleDateFormat( "dd/MM/yyyy" ).parse( input.read( "birthDate" ) ); }
		catch( ParseException ex ){ ex.printStackTrace(); }		
	}
	
	public String checkTransactionStructure() {
		if( username == null || password == null) return "Error create bank client transaction";
		if( name == null || address == null || birthDate == null ) return "Error create profile transaction";
		
		return null;
	}
	
	public void createClient(ArrayList<BankClient> bankClients) {
		bankClient = new BankClient(username, password);
		bankClients.add(bankClient);
		bankClient.createProfile(name, address, birthDate);
	}
}
