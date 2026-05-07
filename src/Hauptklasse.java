import java.sql.*;
import java.awt.*;
import javax.swing.*;
public class Hauptklasse {

	public static void main(String[] args) {	
		String url= "jdbc:sqlite:MyBase.db";
		
		try {
			Connection con= DriverManager.getConnection(url);
			new Userspace(con);
			Aktionen methode= new Aktionen(con);
	    String table= "CREATE TABLE IF NOT EXISTS Stock (" + "id INTEGER PRIMARY KEY AUTOINCREMENT, " + "Name TEXT UNIQUE, " + "Preis INTEGER, " + "Menge TEXT)";
	    try (Statement stmt = con.createStatement()){
	    	stmt.executeUpdate(table);
	
	    }
		}catch(SQLException e) {e.printStackTrace();}

	}

}

