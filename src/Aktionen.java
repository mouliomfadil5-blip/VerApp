
import java.sql.*;
import java.util.Scanner;
public class Aktionen {
	private Connection con;
	
	public Aktionen(Connection con) {
		this.con = con;
	}
 public void insert(String name, String preis, String menge) throws SQLException{
	 
	 String add= "INSERT OR IGNORE INTO Stock(Name, Preis, Menge) VALUES(?,?,?)";
	 try(PreparedStatement pmt= con.prepareStatement(add)){
		 pmt.setString(1, name);
		 pmt.setString(2, preis);
		 pmt.setString(3, menge);
		 pmt.executeUpdate();
		 
		 
	 }
 }
	 
	 public void delete(String name) throws SQLException{
		 
		 String del= "DELETE FROM Stock WHERE Name=?";
		 try (PreparedStatement pmt= con.prepareStatement(del)){
			 pmt.setString(1, name);
			 pmt.executeUpdate();
				
		 }
				 
	 }
	 public ResultSet view() throws SQLException{
		 String select= "SELECT * FROM Stock";
		 Statement stmt= con.createStatement();
		 ResultSet rs= stmt.executeQuery(select);
			 return rs;
  
	 }
	 public void summe() throws SQLException {
		 String sql = "SELECT SUM(Preis) FROM Stock";
		 try (Statement stmt= con.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
			 System.out.println("Total Spending: ");
			  while(rs.next()) {
				  int sum= rs.getInt("SUM(Preis)");
				  System.out.println(sum);
			  }
		 }
	 }
	 }

