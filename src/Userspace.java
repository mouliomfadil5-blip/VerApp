import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class Userspace {
	Connection con;
	Aktionen mt;
	public Userspace(Connection con) {
		this.con=con;
		this.mt= new Aktionen(con);
 JFrame fern= new JFrame("Window");
 fern.setSize(900,900);
 fern.setLayout(new FlowLayout());
 
 JLabel text = new JLabel("App is starting...");
 JTextField toDel= new JTextField(10);
 JTextField name= new JTextField( 20);
 JTextField preis= new JTextField(10);
 JTextField menge= new JTextField(10);
 JButton but= new JButton("Save");
 JButton but2= new JButton("Cancel");
 JButton butVoir= new JButton("Overview");
 JButton del= new JButton("Delete");
 
 fern.add(text);
 fern.add(butVoir);
 fern.add(new JLabel("Article name: "));
 fern.add(name);
 fern.add(new JLabel("Article price(Euro): "));
 fern.add(preis);
 fern.add(new JLabel("Quantity: "));
 fern.add(menge);

 but.addActionListener(e -> {
	 String n= name.getText();
	 String p= preis.getText();
	 String m= menge.getText();
	 try {
		mt.insert(n, p ,m);
		JOptionPane.showMessageDialog(fern, new JLabel(n + " has been saved"));
	} catch (SQLException e1) {
		e1.printStackTrace();
	}
 });
 but2.addActionListener(e -> {
	 System.exit(0);
 });
 butVoir.addActionListener(e -> {
	    try {
	        ResultSet rs = mt.view();
	        StringBuilder liste = new StringBuilder("ID | NAME | PRICE | QUANTITY\n");
	        while (rs.next()) {
	            liste.append(rs.getInt("id")).append(" | ")
	                 .append(rs.getString("Name")).append(" | ")
	                 .append(rs.getString("Preis")).append(" | ")
	                 .append(rs.getString("Menge")).append("\n");
	        }
	        JOptionPane.showMessageDialog(fern, new JScrollPane(new JTextArea(liste.toString())));
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	});
 del.addActionListener(e ->{
	 String d= toDel.getText();
	 try { mt.delete(d);
	      JOptionPane.showMessageDialog(fern, new JLabel(d + " has been deleted"));
		 }  catch (SQLException e1) {
			e1.printStackTrace();
		}
 });

 fern.add(but);
 fern.add(new JLabel("Delete this article: "));
 fern.add(toDel);
 fern.add(del);
 fern.add(but2);
 
 
 fern.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 fern.setVisible(true);
 
}
}
