package gradedGroupProjectPrincipled;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BankClientUI {

	public static void main( String[] args ) throws ParseException {

		ArrayList<BankClient> bankClients = new ArrayList<>();

		String adminName = "X", employeeName = "Y";

		GetInput input = new GetInput();
		Display display = new Display();

		while( true ){

			display.print(bankClients);

			System.out.println( "\n0. Exit" );
			System.out.println( "1. Register" ); //--> Create Profile --> Create Account --> Create Further Accounts
			System.out.println( "2. Login" );
			String choice = input.read( "choice" );


			if( choice.equals( "0" ) ) break;

			else if( choice.equals( "1" ) ) {

				CreateClientAndProfile create = new CreateClientAndProfile();
				BankClient bankClient = create.createClientAndProfile(bankClients);


				while( true ){

					CreateAccount newAccount = new CreateAccount();
					newAccount.createAccount(bankClient);

					System.out.println( "\n0. NO extra account" );
					System.out.println( "1. Extra account" );
					String choice2 = input.read( "choice" );

					if( choice2.equals( "0" ) ) break;
				}
			}

			else if( choice.equals( "2" ) ) {
				Login login = new Login();
				int pos = login.login(bankClients);

				System.out.println( "\n0. Exit" );
				System.out.println( "5. Change Bank Client Details" );
				System.out.println( "6. Delete Bank Account" );
				System.out.println( "7. Money transfer" );
				System.out.println( "8. Book Appoinment" );
				choice = input.read( "choice" );


				if( choice.equals( "5" ) ) {

					ChangeClientDetails change = new ChangeClientDetails();
					change.changeDetails(pos, bankClients);
				}

				else if( choice.equals( "6" ) ) {
					DeleteAccount delete = new DeleteAccount();
					delete.deleteAccount(pos, bankClients);				
				}

				else if( choice.equals( "7" ) ) {

						MoneyTransfer transfer = new MoneyTransfer();
						transfer.transferMoney(pos, bankClients);
				}

				else if( choice.equals( "8" ) ) {

						BookAppointment book = new BookAppointment();
						book.bookAppointment(pos, bankClients);
				}
			}
		}
	}
}
