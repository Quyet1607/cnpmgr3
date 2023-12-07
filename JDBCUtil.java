package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCUtil {
	public static Connection getConnection() {
		Connection c = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			/* DriverManager.registerDriver(new com.mysql.jdbc.Driver()); */
			
			String url = "jdbc:mySQL://localhost:3306/cnpm";
			String username = "root";
			String password = "Quyet@1607";
			c = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return c;
	}
	
	public static void closeConnection(Connection c) {
		try {
			if(c!= null) {
				c.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static void printInfo(Connection c) {
		if(c != null) {
			try {
				java.sql.DatabaseMetaData mtdt = c.getMetaData();
				System.out.println(mtdt.getDatabaseProductName());
				System.out.println(mtdt.getDatabaseProductVersion());
				System.out.println(c.getMetaData().toString());
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
}