package gradedGroupProjectPrincipled;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class BankEmployeeUI {

	public String name = "X";

	public ArrayList<BankClient> bankClientsWithAppointments;
	public ArrayList<Date> appointmentDates;

	public static void main( String[] args ) throws ParseException {
		GetInput input = new GetInput();
		Display display = new Display();
		
		BookAppointment book = new BookAppointment();
		BankEmployeeUI bankEmployeeUI = new BankEmployeeUI();

		bankEmployeeUI.bankClientsWithAppointments = new ArrayList<BankClient>();
		bankEmployeeUI.appointmentDates = new ArrayList<Date>();

		BankClient bankClient1 = new BankClient( "u1", "p1" );
		bankClient1.name = "A";
		bankEmployeeUI.bankClientsWithAppointments.add( bankClient1 );
		bankEmployeeUI.appointmentDates.add( new SimpleDateFormat( "dd/MM/yyyy" ).parse( "20/12/2000" ) );

		BankClient bankClient2 = new BankClient( "u2", "p2" );
		bankClient2.name = "B";
		bankEmployeeUI.bankClientsWithAppointments.add( bankClient2 );
		bankEmployeeUI.appointmentDates.add( new SimpleDateFormat( "dd/MM/yyyy" ).parse( "22/12/2000" ) );


		display.print( bankEmployeeUI.bankClientsWithAppointments );

		for( int i = 0; i < bankEmployeeUI.bankClientsWithAppointments.size(); ++i ) {

			Date date = bankEmployeeUI.appointmentDates.get( i );
			BankClient bankClient = bankEmployeeUI.bankClientsWithAppointments.get( i );

			System.out.println( "\nCandidate date = " + date + " with client = " + bankClient.name );

			System.out.println( "1. Book it" );
			System.out.println( "2. Do not book it" );
			String choice = input.read( "choice" );

			if( choice.equals( "1" ) ) book.finaliseBookingAppointment(bankClient, date, bankEmployeeUI.name ); //we assume that we answer with this call to the client.
		}
	}
}
