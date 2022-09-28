package com.tm.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtility {
	
//	this method will return a connection with database and used at different methods and classes for 
//	Accessing, manipulating data in database with mysql.
	
	public static Connection provideConnection() {
		
		Connection conn = null;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
			
		}
		
		String url = "jdbc:mysql://localhost:3306/tender_management";
		
		try {
			
			conn = DriverManager.getConnection(url, "root", "15Nek#sql");
			
		} catch (SQLException e) {

			e.printStackTrace();
			
		}
		
		
		return conn;
	}

}
