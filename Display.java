package gradedGroupProjectPrincipled;

import java.util.ArrayList;

public class Display {
	
	public void print(ArrayList<BankClient> bankClients) {
		Print print = new Print();
		System.out.println("Bank Clients:\n");
		
		for(int i=0; bankClients != null && i<bankClients.size(); i++) print.toPrint(bankClients.get(i));
	}
}
