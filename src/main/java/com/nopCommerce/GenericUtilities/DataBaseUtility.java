package com.nopCommerce.GenericUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;
/**
 * this contain all the methods of fetching the data from database
 * @author rohit
 *
 */
public class DataBaseUtility {

	    private static final String DB_URL = "jdbc:mysql://localhost:3307/learnautomation";
	    private static final String DB_USER = "root";
	    private static final String DB_PASSWORD = "root";

	    public static Connection connectToDatabase() throws SQLException {
	        Driver driverRef = new Driver();
	        DriverManager.registerDriver(driverRef);
	        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
	    }

	    public static void closeConnection(Connection connection) throws SQLException {
	        if (connection != null && !connection.isClosed()) {
	            connection.close();
	            System.out.println("--------Database connection closed-----------");
	        }
	    }

	    public static ResultSet executeQuery(String query) throws SQLException {
	        Connection connection = connectToDatabase();
	        Statement statement = connection.createStatement();
	        return statement.executeQuery(query);
	    }
}
