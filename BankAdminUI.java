package gradedGroupProjectPrincipled;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class BankAdminUI {

	public String name = "Y";

	public ArrayList<BankClient> bankClientsToVerify = new ArrayList<BankClient>();
	public ArrayList<Integer> accountNumbersToVerify = new ArrayList<Integer>();
	
	public static void main( String[] args ) {

		GetInput input = new GetInput();
		Display display = new Display();
		
		BankAdminUI bankAdminUI = new BankAdminUI();
		Verification toVerify = new Verification();

		bankAdminUI.bankClientsToVerify = new ArrayList<BankClient>();
		bankAdminUI.accountNumbersToVerify = new ArrayList<Integer>();

		BankClient bankClient1 = new BankClient( "u1", "p1" );
		bankAdminUI.bankClientsToVerify.add( bankClient1 );
		bankAdminUI.accountNumbersToVerify.add(1);

		BankClient bankClient2 = new BankClient( "u2", "p2" );
		bankAdminUI.bankClientsToVerify.add( bankClient2 );
		bankAdminUI.accountNumbersToVerify.add(2);


		display.print( bankAdminUI.bankClientsToVerify );

		for( int i = 0; i < bankAdminUI.accountNumbersToVerify.size(); ++i ) {

			int accountNumber = bankAdminUI.accountNumbersToVerify.get( i );

			System.out.println( "\nAccount number = " + accountNumber );

			System.out.println( "1. Verify the opening" );
			System.out.println( "2. Do not verify the opening" );
			String choice = input.read( "choice" );

			if( choice.equals( "1" ) ) {
				BankClient bankClientVerify = bankAdminUI.bankClientsToVerify.get( i );
				toVerify.verify(bankClientVerify, accountNumber, true);
			}
			
			else if( choice.equals( "2" ) ) {
				BankClient bankClientVerify = bankAdminUI.bankClientsToVerify.get( i );
				toVerify.verify(bankClientVerify, accountNumber, false);
			}
		}
	}
}

	
