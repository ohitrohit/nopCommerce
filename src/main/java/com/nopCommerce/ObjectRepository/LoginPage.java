package com.nopCommerce.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * this Class contail all the login page element 
 * @author rohit
 *
 */
public class LoginPage {

	//Declearation
	@FindBy(xpath = "//input[@id='Email']")
	private WebElement IdTextField;
	
	@FindBy(xpath = "//input[@id='Password']")
	private WebElement PasswordTextField;
	
	@FindBy(xpath = "//button[normalize-space()='Log in']")
	private WebElement LoginButton;
	
	//Initilization
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver , this);
	}

	
	
	//Utilization
	
	public WebElement getIdTextField() {
		return IdTextField;
	}

	public void setIdTextField(WebElement idTextField) {
		IdTextField = idTextField;
	}

	public WebElement getPasswordTextField() {
		return PasswordTextField;
	}

	public void setPasswordTextField(WebElement passwordTextField) {
		PasswordTextField = passwordTextField;
	}

	public WebElement getLoginButton() {
		return LoginButton;
	}

	public void setLoginButton(WebElement loginButton) {
		LoginButton = loginButton;
	}
	
	//Business Library
	
	/**
	 * this method is used to Login to the Application
	 * @param ID
	 * @param PASSWORD
	 */
	public void Login(String ID , String PASSWORD) {
		IdTextField.clear();
		IdTextField.sendKeys(ID);
		PasswordTextField.clear();
		PasswordTextField.sendKeys(PASSWORD);
		LoginButton.click();
	}
	
	
	
	
	
	
	
	
	
	
}
