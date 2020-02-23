package gradedGroupProjectPrincipled;

public class Print {
	
	
	public void toPrint(BankClient bankClient) {

		System.out.println( "clientID = " + bankClient.clientID );
		if( bankClient.name != null ) System.out.println( "name = " + bankClient.name );
		if( bankClient.address != null ) System.out.println( "address = " + bankClient.address );
		if( bankClient.address != null ) System.out.println( "birthDate = " + bankClient.birthDate );

		for( int i = 0; bankClient.userAccounts.get(i).getAccountNumber() != 0 && i < bankClient.userAccounts.size(); ++i ) System.out.println( "\taccountNumber: " + bankClient.userAccounts.get(i).getAccountNumber() );
	}

	public void toPrintAccount(BankClient bankClient, int accountNumber ) {

		for( int i = 0; bankClient.userAccounts != null && i < bankClient.userAccounts.size(); ++i ) {

			if( bankClient.userAccounts.get(i).getAccountNumber() == accountNumber ) {
				
				System.out.println( "\taccountNumber: " + bankClient.userAccounts.get(i).getAccountNumber());
				System.out.println( "\taccountType: " + bankClient.userAccounts.get(i).getClass());
				System.out.println( "\taccountVerified: " + bankClient.accountVerified.get( i ) );
				System.out.println( "\taccountBalance: " + bankClient.userAccounts.get(i).getBalance() );
			}
		}
	}

	public void printAccounts(BankClient bankClient) {

		for( int i = 0; bankClient.userAccounts != null && i < bankClient.userAccounts.size(); ++i ) {

			System.out.println( "\taccountNumber: " + bankClient.userAccounts.get(i).getAccountNumber());
			System.out.println( "\taccountType: " + bankClient.userAccounts.get(i).getClass());
			System.out.println( "\taccountVerified: " + bankClient.accountVerified.get( i ) );
			System.out.println( "\taccountBalance: " + bankClient.userAccounts.get(i).getBalance() );
		}
	}
	
}
