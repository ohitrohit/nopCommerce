package loginModule;

import org.testng.annotations.Test;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.nopCommerce.GenericUtilities.BaseClass;
import com.nopCommerce.ObjectRepository.HomePage;

public class VerifyingLoginLogoutTest extends BaseClass {

	@Test(priority = 1)
	public void VerifyLoginLogout() {
		
		HomePage hm = new HomePage(driver);
		String Title = hm.GetTitleText(driver);
		Reporter.log(Title);
	}
	
}
