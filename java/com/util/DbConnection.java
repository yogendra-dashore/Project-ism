package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

	public static final String URLNAME = "jdbc:sqlserver://localhost:50646;DatabaseName=PROJECT_ISM;trustServerCertificate=true";
	public static final String DRIVERCLASS = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	public static final String USERNAME = "sa";
	public static final String PASSWORD = "root";
	
	public static Connection getConnection() {
		
		Connection con = null;
		
		try {
			Class.forName(DRIVERCLASS);
		} catch (ClassNotFoundException e) {
			System.out.println(e);
			System.out.println("driver class not found");
			
		}
		try {
			con = DriverManager.getConnection(URLNAME,USERNAME,PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
//	public static void main(String[] args) {
//		Connection cn= getConnection();
//		if(cn!=null) {
//			System.out.println("database found");
//		}else {
//			System.out.println("database not found");
//		}
//	}
}

