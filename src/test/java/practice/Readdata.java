package practice;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.nopCommerce.GenericUtilities.DataBaseUtility;

public class Readdata {

	public static void main(String[] args) throws SQLException {

		// Your SQL query
		String sqlQuery = "select * from nopcommerce;";

		// Execute the query and get the ResultSet
		ResultSet result = DataBaseUtility.executeQuery(sqlQuery);

		String email = null;
		String password = null;
		String product_name = null;
		String url = null;
		String browser = null;
		// Process the ResultSet as needed
		while (result.next()) {
			// Retrieve data from the ResultSet

			email = result.getString(1);
			password = result.getString(2);
			product_name = result.getString(3);
			url = result.getString(4);
			browser = result.getString(5);

		}

		System.out.println("Email ID =" + email);
		System.out.println("Password =" + password);
		System.out.println("Product Name =" + product_name);
		System.out.println("URL =" + url);
		System.out.println("Browser =" + browser);

		// Close the ResultSet (optional)
		result.close();

		// Close the database connection
		DataBaseUtility.closeConnection(DataBaseUtility.connectToDatabase());

	}
}
