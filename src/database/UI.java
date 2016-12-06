package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UI {
	
	private Scanner scan;
	
	UI(){
		scan = new Scanner(System.in);
	}
	
	private String read(){
		return scan.next();
	}
	
	public InsertionData readPersonData(){
		InsertionData personData = new InsertionData();
		
		System.out.println("Tast inn PersonID: ");
		personData.setPersonID( read() );
		
		System.out.println("Tast inn Fornavn: ");
		personData.setFornavn( read() );
		
		System.out.println("Tast inn Mellomnavn: ");
		personData.setMellomnavn( read() );
		
		System.out.println("Tast inn Etternavn: ");
		personData.setEtternavn( read() );
		
		System.out.println("Tast inn Vei: ");
		personData.setVei( read() );
		
		System.out.println("Tast inn Husnr: ");
		personData.setHusNr( Integer.parseInt(read()) );
		
		System.out.println("Tast inn Poststed: ");
		personData.setPoststed( read() );
		
		System.out.println("Tast inn Epostadresse: ");
		personData.setEpost( read() );
		
		return personData;
	}
	
	public void printData(ResultSet sqlData){
		// Print results from select statement
		try {
			while (sqlData.next()) {
				System.out.println(sqlData.getString("PersonID") + " "
					+ sqlData.getString("Fornavn") + " "
					+ sqlData.getString("Mellomnavn") + " "
					+ sqlData.getString("Etternavn") + " "
					+ sqlData.getString("Vei") + " "
					+ sqlData.getString("Husnr") + " "
					+ sqlData.getString("poststed") + " "
					+ sqlData.getString("Epostadresse"));
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public String search(){
		System.out.println("Tast inn nøkkelordet for søket: ");
		String kriterium = read();
		return kriterium;
	}
	
	public int printMenuValg(){
		System.out.println("");
		System.out.println("Menu");
		System.out.println("1. Legg inn ny person");
		System.out.println("2. Søk i person-database");
		System.out.println("3. Rapport av alle personer");
		System.out.println("4. Exit");
		System.out.println("Vennligst tast inn nummer: ");
		return Integer.parseInt(read());
	}

}

