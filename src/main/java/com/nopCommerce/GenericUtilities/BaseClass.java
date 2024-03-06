package com.nopCommerce.GenericUtilities;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.nopCommerce.ObjectRepository.HomePage;
import com.nopCommerce.ObjectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public WebDriverUtility wu = new WebDriverUtility();
	public JavaUtility ju = new JavaUtility();
	protected WebDriver driver;
	
	String ID = null;
	String PASSWORD = null;
	String URL = null;
	String BROWSER = null;
	@BeforeSuite()
	public void BS_Config() throws SQLException {
		DataBaseUtility.connectToDatabase();
		System.out.println("--------DataBase Connected---------");
	}
	//@BeforeTest()
	@BeforeClass()
	public void BC_Config() throws IOException, SQLException {
		
        String sqlQuery = "select url, browser , emailid , password from nopcommerce;";
		ResultSet result = DataBaseUtility.executeQuery(sqlQuery);
        while (result.next()) {
			URL = result.getString("url");
            BROWSER = result.getString("browser");
            ID = result.getString("emailid");
            PASSWORD = result.getString("password");
		}
		
		if(BROWSER.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("------------Browser Lounch Succesfull-----------");
			
		}else{
			System.out.println("-----Browser Name Invalid------");
		}
		wu.MaximizeTheBrowser(driver);
		wu.WaitforSpeceficTiming(driver, 10);
		driver.get(URL);
	}
	
	@BeforeMethod()
	public void BM_Config() throws IOException {

		LoginPage lp = new LoginPage(driver);
		lp.Login(ID, PASSWORD);
		System.out.println("-----------Login Successfull-------------");
		
	}
	
	@AfterMethod()
	public void AM_Config() {
		HomePage hm = new HomePage(driver);
		hm.Logout();
		System.out.println("----------Logout Successfull--------------");
	}
	
	@AfterClass()
		public void AC_Config() {
			driver.quit();
			System.out.println("---------Browser Quit Successfull-------");
		}
	
	//@AfterTest()
	@AfterSuite()
	public void AF_Config() throws SQLException {
		
		        String sqlQuery = "select url, browser , emailid , password from nopcommerce;";
		        ResultSet result = DataBaseUtility.executeQuery(sqlQuery);
				result.close();
                DataBaseUtility.closeConnection(DataBaseUtility.connectToDatabase());
                
	}
	
}
