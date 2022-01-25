package com.manoj.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		
		String jdbcurl="jdbc:mysql://localhost:3306/hb-03-one-to-many?useSSL=false";
		String user="hbstudent";
		String pass="hbstudent";
		
		try
		{
			System.out.println("conntecting to database: "+jdbcurl);
			
			Connection myConn=DriverManager.getConnection(jdbcurl,user,pass);
			
			System.out.println("connected to database");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
