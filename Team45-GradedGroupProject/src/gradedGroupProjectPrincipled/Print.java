package gradedGroupProjectPrincipled;

public class Print {
	
	
	public void toPrint(BankClient bankClient) {

		System.out.println( "clientID = " + bankClient.clientID );
		if( bankClient.name != null ) System.out.println( "name = " + bankClient.name );
		if( bankClient.address != null ) System.out.println( "address = " + bankClient.address );
		if( bankClient.address != null ) System.out.println( "birthDate = " + bankClient.birthDate );

		for( int i = 0; bankClient.accountNumbers != null && i < bankClient.accountNumbers.size(); ++i ) System.out.println( "\taccountNumber: " + bankClient.accountNumbers.get( i ) );
	}

	public void toPrintAccount(BankClient bankClient, int accountNumber ) {

		for( int i = 0; bankClient.accountNumbers != null && i < bankClient.accountNumbers.size(); ++i ) {

			if( bankClient.accountNumbers.get( i ) == accountNumber ) {

				System.out.println( "\taccountNumber: " + bankClient.accountNumbers.get( i ) );
				System.out.println( "\taccountType: " + bankClient.accountTypes.get( i ) );
				System.out.println( "\taccountVerified: " + bankClient.accountVerified.get( i ) );
				System.out.println( "\taccountBalance: " + bankClient.accountBalances.get( i ) );
			}
		}
	}

	public void printAccounts(BankClient bankClient) {

		for( int i = 0; bankClient.accountNumbers != null && i < bankClient.accountNumbers.size(); ++i ) {

			System.out.println( "\taccountNumber: " + bankClient.accountNumbers.get( i ) );
			System.out.println( "\taccountType: " + bankClient.accountTypes.get( i ) );
			System.out.println( "\taccountVerified: " + bankClient.accountVerified.get( i ) );
			System.out.println( "\taccountBalance: " + bankClient.accountBalances.get( i ) );
		}
	}
	
}
