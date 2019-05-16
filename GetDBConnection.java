package com.test.dao;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;

public class GetDBConnection {
	

	public Connection getDBConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/user";
			conn = DriverManager.getConnection(url, "root", "123");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void main(String[] args) {
		GetDBConnection getcon = new GetDBConnection();
		if (getcon.getDBConnection() != null)
			System.out.println("连接成功");
	}
}
