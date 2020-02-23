package gradedGroupProjectPrincipled;

import java.util.ArrayList;

public class MoneyTransfer {
	
	int pos;
	int fromAccountNumber;
	int toAccountNumber;
	double amount;
	
	ErrorMessage error = new ErrorMessage();
	Print print = new Print();
	
	public void transferMoney(int pos, ArrayList<BankClient> bankClients) {
		this.pos = pos;
		BankClient bankClient = bankClients.get(pos);
		getDetails(bankClients);
		String errorMessage = checkDetails();
		error.printErrorMessage(errorMessage);
		transfer(fromAccountNumber, toAccountNumber, amount, bankClient);
	}
	
	public void getDetails(ArrayList<BankClient> bankClients) {
		GetInput input = new GetInput();
		
		print.printAccounts(bankClients.get( pos ));

		fromAccountNumber = Integer.parseInt( input.read( "from account number" ) );
		toAccountNumber = Integer.parseInt( input.read( "to account number" ) );
		amount = Integer.parseInt( input.read( "amount" ) );
	}
	
	public String checkDetails() {
		if(fromAccountNumber < 0 || toAccountNumber < 0 || amount < 0) return "Error transfering money";
		
		return null;
	}
	
	public void transfer( int fromAccountNumber, int toAccountNumber, double amount, BankClient bankClient ) {

		int from = 0;

		for( from = 0; from < bankClient.accountNumbers.size(); ++from ) {

			if( bankClient.accountNumbers.get( from ) == fromAccountNumber  ) {

				System.out.println( "\tFrom accountNumber: " + bankClient.accountNumbers.get( from ) );
				System.out.println( "\ttFrom accountType: " + bankClient.accountTypes.get( from ) );
				System.out.println( "\ttFrom accountVerified: " + bankClient.accountVerified.get( from ) );
				System.out.println( "\ttFrom accountBalance: " + bankClient.accountBalances.get( from ) );
			}
		}

		int to = 0;

		for( to = 0; to < bankClient.accountNumbers.size(); ++to ) {

			if( bankClient.accountNumbers.get( to ) == toAccountNumber  ) {

				System.out.println( "\tTo accountNumber: " + bankClient.accountNumbers.get( to ) );
				System.out.println( "\tTo accountType: " + bankClient.accountTypes.get( to ) );
				System.out.println( "\tTo accountVerified: " + bankClient.accountVerified.get( to ) );
				System.out.println( "\tTo accountBalance: " + bankClient.accountBalances.get( to ) );
			}
		}

		if( from >= 0 && from < bankClient.accountNumbers.size() && to >= 0 && to < bankClient.accountNumbers.size() && bankClient.accountBalances.get( from ) >= amount ) {

			bankClient.accountBalances.set( from, bankClient.accountBalances.get( from ) - amount );

			bankClient.accountBalances.set( to, bankClient.accountBalances.get( to ) + amount );

			System.out.println( "Transfer is completed" );
		}

		else System.out.println( "Transfer cannot be made" );
	}
}
