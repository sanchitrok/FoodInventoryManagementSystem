package com.ead.ims.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.ead.ims.dao.ProductDAO;

public class ConnectDatabase {
	

	 private static ConnectDatabase instance;
	    private static Connection connection;
	    private static final String URL = "jdbc:mysql://localhost:3306/gui";
	    private static final String DATABASEDRIVER = "com.mysql.jdbc.Driver";
	    private static final String USERNAME = "root";
	    private static final String PASSWORD = "sanchitrokade4";


	    private ConnectDatabase() throws SQLException {
	        try {
	            Class.forName(DATABASEDRIVER);
	            this.connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
	        } 
	        catch (ClassNotFoundException ex) {
	        	System.out.println("Database Connection Creation Failed : " + ex.getMessage());
	        }
	        catch(Exception e)
	        {
	        	System.out.println("The unknown exception is: "+e);
	        }
	    }

	    //method to get database connection
	    public static Connection getConnection() {
	        return connection;
	    }

	    //static method to create instance of Singleton class
	    public static ConnectDatabase getInstance() throws SQLException {
	    	try
	    	{
		        if (instance == null) {
		            instance = new ConnectDatabase();
		        } else if (instance.getConnection().isClosed()) {
		            instance = new ConnectDatabase();
		        }
	    	}
	    	catch(Exception e)
	    	{
	    		System.out.println("The exception is : "+e);
	    	}
	        return instance;
	    }

	    //static method to close connection
	    public static void closeConnection() throws SQLException {
	        try 
	        {
	            System.out.println("----Connection closed with MYSQL database----");
	            connection.close();
	        }
	        catch (Exception e)
	        {
	        	System.out.println("Close connection failed  : " + e.getMessage());
	        }
	    }
	
}
