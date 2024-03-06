package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;
public class ReadDataOnlyURL_Browser {

	public static void main(String[] args) throws SQLException {

        System.out.println("===========Database Connection Start============");
        // driver for MySQL database
        Driver driverRef = new Driver();

        // step1: Register the driver
        DriverManager.registerDriver(driverRef);

        // step2: get the Connection from Database - database name
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/learnautomation", "root", "root");

        // step3: issue the create statement
        Statement state = con.createStatement();

        // step4: execute a query - fetch only URL and Browser columns
        ResultSet result = state.executeQuery("select URL, Browser from nopcommerce;");

        String url = null;
        String browser = null;

        while (result.next()) {
            url = result.getString("URL");
            browser = result.getString("Browser");
        }

        System.out.println("URL = " + url);
        System.out.println("Browser = " + browser);

        // step 5: close the database
        con.close();
        System.out.println("==============db closed================");

    }
}
