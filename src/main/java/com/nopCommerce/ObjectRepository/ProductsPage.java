package com.nopCommerce.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * this method contain all the element of the products page
 * @author rohit
 *
 */
public class ProductsPage {

	//Decleartion
	@FindBy(xpath ="//img[@class='brand-image-xl logo-xl']")
	private WebElement Logo;
	
	@FindBy(xpath ="//a[normalize-space()='Add new']")
	private WebElement AddNewButton;
	
	@FindBy(xpath ="//input[@id='SearchProductName']")
	private WebElement ProductNameTextField;
	
	@FindBy(xpath = "//input[@id='SearchProductName']")
	private WebElement SearchButton;
	
	//initialition
	public ProductsPage(WebDriver driver) {
		PageFactory.initElements(driver , this);
	}

	
	//utilization
	
	
	

	public WebElement getLogo() {
		return Logo;
	}


	public void setLogo(WebElement logo) {
		Logo = logo;
	}


	public WebElement getAddNewButton() {
		return AddNewButton;
	}
	
	public void setAddNewButton(WebElement addNewButton) {
		AddNewButton = addNewButton;
	}

	public WebElement getProductNameTextField() {
		return ProductNameTextField;
	}

	public void setProductNameTextField(WebElement productNameTextField) {
		ProductNameTextField = productNameTextField;
	}

	public WebElement getSearchButton() {
		return SearchButton;
	}

	public void setSearchButton(WebElement searchButton) {
		SearchButton = searchButton;
	}
	
	//Business library
	
	/**
	 * this method is used to add new product
	 */
	public void ClickOnAddButton() {
		AddNewButton.click();
	}
	
	/**
	 * this method is used to serach the product
	 * @param productname
	 */
	public void SearchtheProduct(String productname) {
		ProductNameTextField.sendKeys(productname);
		SearchButton.click();
	}
	/**
	 * this method help us to click on logo 
	 */
	public void ClickOnLogo() {
		Logo.click();
	}
	
}
