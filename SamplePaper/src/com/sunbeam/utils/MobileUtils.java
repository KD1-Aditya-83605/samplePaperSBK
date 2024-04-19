package com.sunbeam.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MobileUtils {
	
	private static final String DB_STRING = "jdbc:mysql://localhost:3306/mobile";
	private static final String USERNAME = "kd1_aditya_83605";
	private static final String PASSWORD = "kd1";
	
	
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(DB_STRING,USERNAME,PASSWORD);
	}

}
