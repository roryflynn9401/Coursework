package gradedGroupProjectPrincipled;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


public class BankClient { 

	public static final AtomicInteger clientCount = new AtomicInteger( 0 );

	public int clientID;
	public String name;
	public String address;
	public Date birthDate;

	public String username;
	public String password;

	public ArrayList<BankAccount> userAccounts = new ArrayList<BankAccount>();


	public ArrayList<Date> appointments;
	public ArrayList<String> bankEmployeesWithAppointments;


	public BankClient( String username, String password ){

		this.username = username;
		this.password = password;

		if( username == null || username == null ) System.err.println( "Error register transaction" );


		this.clientID = clientCount.incrementAndGet();
	}

	public void createProfile( String name, String address, Date birthDate ){

		if( name == null || address == null || birthDate == null ) System.err.println( "Error create profile transaction" );

		else {

			this.name = name;
			this.address = address;
			this.birthDate = birthDate;
		}
	}

	public void changeClientDetails( String name, String address, Date birthDate, String username, String password ){

		if( name == null || address == null || birthDate == null || username == null || password == null ) System.err.println( "Error change details transaction" );

		else {

			this.name = name;
			this.address = address;
			this.birthDate = birthDate;
			this.username = username;
			this.password = password;
		}
	}
}
