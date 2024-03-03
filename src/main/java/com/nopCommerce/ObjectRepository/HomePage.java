package com.nopCommerce.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * this class contain all the HomePage element
 * @author rohit
 *
 */
public class HomePage {

	//Declearation
	
	@FindBy(xpath ="(//a[@class='nav-link'])[4]")
	private WebElement Catalog;
	
	@FindBy(xpath ="//p[normalize-space()='Products']")
	private WebElement products;
	
	@FindBy(xpath = "//a[normalize-space()='Logout']")
	private WebElement LogoutButton;
	
	//Initialition
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver , this);
	}

	
	//Utilization
	

	public WebElement getCatalog() {
		return Catalog;
	}

	public void setCatalog(WebElement catalog) {
		Catalog = catalog;
	}

	public WebElement getProducts() {
		return products;
	}

	public void setProducts(WebElement products) {
		this.products = products;
	}

	public WebElement getLogoutButton() {
		return LogoutButton;
	}

	public void setLogoutButton(WebElement logoutButton) {
		LogoutButton = logoutButton;
	}
	
	
	//Business Library
	
	/**
	 * this method is used to get Title
	 * @param driver
	 * @return
	 */
	public String GetTitleText(WebDriver driver) {
		String title = driver.getTitle();
		return title;
	}
	
	/**
	 * this method is use to Logout
	 */
	public void Logout() {
		LogoutButton.click();
	}
	
	/**
	 * this method is used to click on catalog Button
	 */
	public void ClickOnCatalogButton() {
		Catalog.click();
	}
	
	/**
	 * this method is used to click on products button
	 */
	public void ClickOnProducts() {
		products.click();
	}
	
	
	
	
	
}
