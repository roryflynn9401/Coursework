package gradedGroupProjectPrincipled;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class BookAppointment {

	String employeeName="Y";
	Date appointmentDate;
	
	public void bookAppointment(int pos, ArrayList<BankClient> bankClients) {
		BankClient bankClient = bankClients.get(pos);
		getDate();
		boolean scheduled = askForSchedulingAppointment(bankClient.clientID, appointmentDate, employeeName);
		
		if( scheduled ) finaliseBookingAppointment(bankClient, appointmentDate, employeeName );
		else System.out.println( "The appointment has not been booked" );
	}
	
	public void getDate() {
		GetInput input = new GetInput();
		
		appointmentDate = null;
		try { appointmentDate = new SimpleDateFormat( "dd/MM/yyyy" ).parse( input.read( "apppoinment date" ) ); }
		catch( ParseException ex ){ ex.printStackTrace(); }
	}	
	
	public boolean askForSchedulingAppointment(int clientID, Date appontmentDate, String employeeName) {

		if( appointmentDate == null || employeeName == null ) {

			System.err.println( "Error schedule appointment transaction" );

			return false;
		}

		else {

			//Assume we sent a message to bank employee

			return true;
		}
	}

	public void finaliseBookingAppointment(BankClient bankClient, Date appointmentDate, String  employeeName) {

		if( appointmentDate == null || employeeName == null ) System.out.println( "Error book appointment transaction" );

		else {

			if( bankClient.appointments == null ) bankClient.appointments = new ArrayList<Date>();

			bankClient.appointments.add( appointmentDate );


			if( bankClient.bankEmployeesWithAppointments == null ) bankClient.bankEmployeesWithAppointments = new ArrayList<String>();

			bankClient.bankEmployeesWithAppointments.add( employeeName );
		}
	}
}
