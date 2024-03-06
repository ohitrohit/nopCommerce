package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ReadDatafromDatabase {

	public static void main(String[] args) throws SQLException {
	
		System.out.println("===========Database Connection Start============");
		//driver for Mysql database
		Driver driverRef = new Driver();
		
		//step1 :Registor the driver
		DriverManager.registerDriver(driverRef);
		
		//step2: get the Connection from Database- database name
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/learnautomation","root","root");
	
	    //step3 : issue the create statement 
		Statement state = con.createStatement();
		
		//step4 : execute a query-table name
		ResultSet result = state.executeQuery("select * from nopcommerce;");
		
		String email = null;
		String password = null;
		String product_name = null;
		String url = null;
		String browser = null;
		
		while(result.next())
		{
			 email= result.getString(1);
			 password= result.getString(2);
			 product_name= result.getString(3);
			 url= result.getString(4);
			 browser= result.getString(5);
			
		}
		
		System.out.println("Email ID ="+email);
		System.out.println("Password ="+password);
		System.out.println("Product Name ="+product_name);
		System.out.println("URL ="+url);
		System.out.println("Browser ="+browser);
		
		//step 5: close the database
		con.close();
		System.out.println("==============db closed================");
	
	}

	

}