package productsModule;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.nopCommerce.GenericUtilities.BaseClass;
import com.nopCommerce.ObjectRepository.HomePage;
import com.nopCommerce.ObjectRepository.ProductsPage;

public class SearchProductsTest extends BaseClass{

	@Test(priority = 3)
	public void SearchTheProduct() throws InterruptedException {
		
		HomePage hm = new HomePage(driver);
		hm.ClickOnCatalogButton();
		Thread.sleep(5000);
		
		hm.ClickOnProducts();
		Thread.sleep(5000);
		
		ProductsPage pg = new ProductsPage(driver);
		pg.SearchtheProduct("Rohit"+ju.getRandomNumber());
		Thread.sleep(5000);
		pg.ClickOnLogo();
	}
	
}
