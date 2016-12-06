package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import java.text.ParsePosition;

public class Data {
	
	private Connection connection;
	private ResultSet resultSet;
	private Statement statement;
	
	public Data(){
		String connectionString =
				"jdbc:sqlserver://localhost:1433;"
				+ "instance=SQLEXPRESS;"	
				+ "databaseName=PersonDatabase;"
				+ "user=javaUser;"
				+ "password=051216;";
			
			try {
				connection = DriverManager.getConnection(connectionString);
			}catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	public ResultSet query(String sql){
		try{
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
		}catch (Exception e) {
			e.printStackTrace();
		}

		return resultSet;
	}
	
	public ResultSet rapport(){
		String rapport = "SELECT * FROM Person p join PersonAdresse pa ON p.PersonID = pa.PersonID join PersonEpostadresse pe ON p.PersonID = pe.PersonID;";
		return query(rapport);
	}
	
	public ResultSet search(String kriterium){
		boolean isInt = isNumeric(kriterium);
		String search = "SELECT * FROM Person p join PersonAdresse pa ON p.PersonID = pa.PersonID join PersonEpostadresse pe ON p.PersonID = pe.PersonID where p.Fornavn ='"+ kriterium 
				+ "' OR p.Mellomnavn ='"+ kriterium 
				+ "' OR p.Etternavn ='"+ kriterium 
				+ "' OR pa.Vei ='"+ kriterium 
				+ "' OR pa.Husnr ='"+ (isInt? Integer.parseInt(kriterium): 0)
				+ "' OR pa.poststed ='"+ kriterium 
				+ "' OR pe.Epostadresse ='"+ kriterium 
				+ "';";
		return query(search);
	}
	
	public int insert(InsertionData personData) {
		int rowsInserted = 0;
		String insertSQLPerson = new String();
		String insertSQLAdresse = new String();
		String insertSQLPersonAdresse = new String();
		String insertSQLEpostadresse = new String();
		String insertSQLPersonEpostadresse = new String();
		String personID = personData.getPersonID();
		String fornavn = personData.getFornavn();
		String mellomnavn = personData.getMellomnavn();
		String etternavn = personData.getEtternavn();
		String vei = personData.getVei();
		int husnr = personData.getHusNr();
		String poststed = personData.getPoststed();
		String epost = personData.getEpost();
		
		insertSQLPerson = "INSERT INTO Person (PersonID, Fornavn, Mellomnavn, Etternavn) VALUES " + "('" + personID + "', '" + fornavn + "', '" + mellomnavn + "', '" + etternavn + "');";
		System.out.println(insertSQLPerson);
		
		insertSQLAdresse = "INSERT INTO Adresse (Vei, Husnr, poststed) VALUES " + "('" + vei + "', '" + husnr + "', '" + poststed + "');";
		System.out.println(insertSQLAdresse);
		
		insertSQLPersonAdresse = "INSERT INTO PersonAdresse (PersonID, Vei, Husnr, poststed) VALUES " + "('" + personID + "', '" + vei + "', '" + husnr + "', '" + poststed + "');";
		System.out.println(insertSQLPersonAdresse);
		
		insertSQLEpostadresse = "INSERT INTO Epostadresse (Epostadresse) VALUES " + "('" + epost + "');";
		System.out.println(insertSQLEpostadresse);
		
		insertSQLPersonEpostadresse = "INSERT INTO PersonEpostadresse (PersonID, Epostadresse) VALUES " + "('" + personID + "', '" + epost + "');";
		System.out.println(insertSQLPersonEpostadresse);
		
		
		try {
			Statement stm = connection.createStatement();
			
			stm.addBatch(insertSQLPerson);
			stm.addBatch(insertSQLAdresse);
			stm.addBatch(insertSQLPersonAdresse);
			stm.addBatch(insertSQLEpostadresse);
			stm.addBatch(insertSQLPersonEpostadresse);
			
			rowsInserted = stm.executeBatch()[0];
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowsInserted;
	}
	
	public void closeConnection(){
		if (connection != null) try { connection.close(); } catch(Exception e) {}
	}
	
	private static boolean isNumeric(String str)
	{
	  NumberFormat formatter = NumberFormat.getInstance();
	  ParsePosition pos = new ParsePosition(0);
	  formatter.parse(str, pos);
	  return str.length() == pos.getIndex();
	}

}
