package com.simplilearn.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class ConnectionUtil {

	public ConnectionUtil() {
		// TODO Auto-generated constructor stub
	}
// single ton design pattern
	//static Connection connection;
	
	public static Connection getConnection() throws SQLException {
         Connection connection = null;
		
		if(connection==null){
		DriverManager.registerDriver(new Driver());
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/empmgmt?characterEncoding=utf8", "root", "admin123");
		}
		
		return connection;

	}

}
