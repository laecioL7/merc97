package com.example.merc97.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	static{
		try {
			Class.forName("com.mysql.jdbc.Driver"); // declara o driver
		} catch (ClassNotFoundException e) {
			e.getException();
			e.printStackTrace();
		}
		
	}
	
	public Connection getConnection(){
		
		String url = "jdbc:mysql://merc97.mysql.uhserver.com/merc97";
		String usuario = "root";
		String senha = "root";
		
		try {
			return DriverManager.getConnection(url,usuario,senha);
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		
			
		}
		
		
		
	}
	
	

}
