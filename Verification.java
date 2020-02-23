package gradedGroupProjectPrincipled;

public class Verification {
	
	public boolean askForVerification( int clientID, int accountNumber, String adminName ){

		//Assume we sent a message to bank admin

		return true;
	}

	public void verify(BankClient bankClient, int accountNumber, boolean verified){

		for( int i = 0; i < bankClient.userAccounts.size(); ++i ) if( bankClient.userAccounts.get(i).getAccountNumber() == accountNumber ) bankClient.userAccounts.get(i).setVerified(verified);
	}
}
