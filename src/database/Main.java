package database;

import java.sql.*;


public class Main {
	
	

	public static void main(String[] args) {
		
		Data connection = new Data();
		UI userInterface = new UI();

		boolean run = true;
		
		while(run){
			int valg = userInterface.printMenuValg();
			if(valg == 1){
				InsertionData newPerson = userInterface.readPersonData();
				int result = connection.insert(newPerson);
				System.out.println("Result: " + result);
			}else if(valg == 2){
				String kriterium = userInterface.search();
				ResultSet search = connection.search(kriterium);
				userInterface.printData(search);
			}else if(valg == 3){
				ResultSet rapport = connection.rapport();
				userInterface.printData(rapport);
			}else if(valg == 4){
				run = false;
				System.out.println("Shutdown...");
			}
		}
				
		connection.closeConnection();

	}

}
