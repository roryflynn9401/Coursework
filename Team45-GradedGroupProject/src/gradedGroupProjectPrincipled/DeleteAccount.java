package gradedGroupProjectPrincipled;

import java.util.ArrayList;

public class DeleteAccount {
	
	int pos;
	Print print = new Print();
	
	public void deleteAccount(int pos, ArrayList<BankClient> bankClients) {
		int accountNumber = getAccountNumber(pos, bankClients);
		BankClient bankClient = getClient(pos, bankClients);
		deleteAccountFromClient(bankClient, accountNumber);
		if (bankClients.get(pos).accountNumbers.size() == 0) removeClient(pos, bankClients);		
	}
	
	public int getAccountNumber(int pos, ArrayList<BankClient> bankClients) {
		GetInput input = new GetInput();
		this.pos = pos;
		
		print.printAccounts(bankClients.get( pos ));

		int accountNumber = Integer.parseInt( input.read( "account number" ) );
		return accountNumber;
	}
	
	public BankClient getClient(int pos, ArrayList<BankClient> bankClients) {
		this.pos = pos;
		BankClient bankClient = bankClients.get(pos);
		return bankClient;
	}
	
	public void deleteAccountFromClient(BankClient bankClient, int accountNumber ) {

		int pos = 0;

		for( pos = 0; pos < bankClient.accountNumbers.size(); ++pos ) if( bankClient.accountNumbers.get( pos ) == accountNumber ) break;

		if( pos >= 0 && pos < bankClient.accountNumbers.size() ) {

			bankClient.accountNumbers.remove( pos );
			bankClient.accountTypes.remove( pos );
			bankClient.accountVerified.remove( pos );
			bankClient.accountBalances.remove( pos );
		}
	}
	
	public void removeClient(int pos, ArrayList<BankClient> bankClients) {
		bankClients.remove(pos);
	}
}
