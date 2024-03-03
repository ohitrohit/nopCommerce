package com.nopCommerce.GenericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.nopCommerce.ObjectRepository.HomePage;
import com.nopCommerce.ObjectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public WebDriverUtility wu = new WebDriverUtility();
	public PropertyFileUtility pu = new PropertyFileUtility();
	public JavaUtility ju = new JavaUtility();
	protected WebDriver driver;
	
	//@BeforeSuite()
	//@BeforeTest()
	@BeforeClass()
	public void BC_Config() throws IOException {
		
		String URL = pu.ReadDatafromPropertiesFile("URL");
		String BROWSER = pu.ReadDatafromPropertiesFile("BROWSER");
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
		
		String ID =pu.ReadDatafromPropertiesFile("ID");
		String PASSWORD = pu.ReadDatafromPropertiesFile("PASSWORD");
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
	//@AfterSuite()
	
}
