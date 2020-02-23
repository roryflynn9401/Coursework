package gradedGroupProjectPrincipled;

public class Verification {
	
	public boolean askForVerification( int clientID, int accountNumber, String adminName ){

		//Assume we sent a message to bank admin

		return true;
	}

	public void verify(BankClient bankClient, int accountNumber, boolean verified){

		for( int i = 0; i < bankClient.accountNumbers.size(); ++i ) if( bankClient.accountNumbers.get( i ) == accountNumber ) bankClient.accountVerified.set( i , verified );
	}
}
