package productsModule;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.nopCommerce.GenericUtilities.BaseClass;
import com.nopCommerce.ObjectRepository.HomePage;
import com.nopCommerce.ObjectRepository.ProductInfoPage;
import com.nopCommerce.ObjectRepository.ProductsPage;

public class AddProductsTest extends BaseClass {

	@Test(priority = 2)
	public void Addproduct() throws InterruptedException {
		HomePage hm = new HomePage(driver);
		hm.ClickOnCatalogButton();
		Thread.sleep(5000);
		
		hm.ClickOnProducts();
		Thread.sleep(5000);
		
		ProductsPage pg = new ProductsPage(driver);
		pg.ClickOnAddButton();
		Thread.sleep(5000);
		
		ProductInfoPage pig =new ProductInfoPage(driver);
		
	    pig.CreateProductWithName("Rohit"+ju.getRandomNumber());
	    Thread.sleep(5000);
	    
	    pg.ClickOnLogo();
		
	}
	
	
}
