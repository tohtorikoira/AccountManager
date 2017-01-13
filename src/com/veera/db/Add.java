package com.veera.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import javax.swing.JOptionPane;

import com.mysql.jdbc.UpdatableResultSet;
import com.veera.userform.UserActions;

public class Add {
	
	public Add(String user, String summa, String tapahtuma, String selite){
		
		Double lukusumma = Double.parseDouble(summa);
		
		
		if (tapahtuma == "Osto") {
			
			lukusumma= -lukusumma ;
		} 
		
		JOptionPane.showMessageDialog(null, lukusumma);
		System.out.println("INSERT INTO `accountactions`(`uid`, `tapahtuma`, `summa`, `selite`) VALUES ('"+user+"', '"+tapahtuma+"','"+lukusumma+"', '"+selite+"');");

		
		try {
		Connection conn;
		String databaseName = "tutorialData";
		String url = "jdbc:mysql://localhost/"+databaseName;
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(url, DBdetails.getDbmainuser(), DBdetails.getDbpassw());
		Statement st = conn.createStatement();
		int res = st.executeUpdate("INSERT INTO `accountactions`(`uid`, `tapahtuma`, `summa`, `selite`) VALUES ('"+user+"', '"+tapahtuma+"','"+lukusumma+"', '"+selite+"');");
		System.out.println(res);
		if(res>0){
			JOptionPane.showMessageDialog(null, "Success");

		} else{
			JOptionPane.showMessageDialog(null, "Something went wrong");
		}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		
		
		
		
	}
		
		UserActions.update(user);

	}

}
