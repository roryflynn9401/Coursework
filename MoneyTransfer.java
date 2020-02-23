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

		for( from = 0; from < bankClient.userAccounts.size(); ++from ) {

			if( bankClient.userAccounts.get( from ).getAccountNumber() == fromAccountNumber  ) {

				
				System.out.println( "\tFrom accountNumber: " + bankClient.userAccounts.get(from).getAccountNumber());
				System.out.println( "\ttFrom accountType: " + bankClient.userAccounts.get(from).getClass());
				System.out.println( "\ttFrom accountVerified: " + bankClient.accountVerified.get( from ) );
				System.out.println( "\ttFrom accountBalance: " + bankClient.userAccounts.get(from).getBalance() );
			}
		}

		int to = 0;

		for( to = 0; to < bankClient.userAccounts.size(); ++to ) {

			if( bankClient.userAccounts.get( to ).getAccountNumber() == toAccountNumber  ) {

				System.out.println( "\tTo accountNumber: " + bankClient.userAccounts.get(from).getAccountNumber());
				System.out.println( "\ttTo accountType: " + bankClient.userAccounts.get(from).getClass());
				System.out.println( "\ttTo accountVerified: " + bankClient.accountVerified.get( from ) );
				System.out.println( "\ttTo accountBalance: " + bankClient.userAccounts.get(from).getBalance() );
			}
		}

		if( from >= 0 && from < bankClient.userAccounts.size() && to >= 0 && to < bankClient.userAccounts.size() && bankClient.userAccounts.get( from ).getBalance() >= amount ) {

			bankClient.userAccounts.get( from ).setBalance(bankClient.userAccounts.get( from ).getBalance() - amount);
			

			bankClient.userAccounts.get( to).setBalance(bankClient.userAccounts.get( to ).getBalance() + amount );

			System.out.println( "Transfer is completed" );
		}

		else System.out.println( "Transfer cannot be made" );
	}
}
