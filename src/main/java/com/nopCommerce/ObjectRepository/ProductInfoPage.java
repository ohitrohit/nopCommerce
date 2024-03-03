package com.nopCommerce.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * this class contain all the element of product info page
 * @author rohit
 *
 */
public class ProductInfoPage {

	//declaearion
	@FindBy(xpath = "//input[@id='Name']")
	private WebElement ProductNameTextFieldinInfoPage;
	
	@FindBy(xpath ="//button[@name='save']//i[@class='far fa-save']")
	private WebElement SaveButtoninInfoPage;
	
	//initiliation
	public ProductInfoPage(WebDriver driver) {
		PageFactory.initElements(driver , this);
	}

	//initiliation
	public WebElement getProductNameTextFieldinInfoPage() {
		return ProductNameTextFieldinInfoPage;
	}

	public void setProductNameTextFieldinInfoPage(WebElement productNameTextFieldinInfoPage) {
		ProductNameTextFieldinInfoPage = productNameTextFieldinInfoPage;
	}

	public WebElement getSaveButtoninInfoPage() {
		return SaveButtoninInfoPage;
	}

	public void setSaveButtoninInfoPage(WebElement saveButtoninInfoPage) {
		SaveButtoninInfoPage = saveButtoninInfoPage;
	}
	
	//utilization
	/**
	 * this method is used to create the product
	 * @param productname
	 */
	public void CreateProductWithName(String productname) {
		ProductNameTextFieldinInfoPage.sendKeys(productname);
		SaveButtoninInfoPage.click();
	}
	
}
