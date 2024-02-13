package EcommerceProject.tests;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import EcommerceProject.PageObjects.LumaEcommerceCreateNewAccPage;
import EcommerceProject.PageObjects.LumaEcommerceCustomerLoginPage;
import EcommerceProject.PageObjects.LumaEcommerceHomePage;
import EcommerceProject.PageObjects.LunaCartPage;
import EcommerceProject.PageObjects.LunaWishlistPage;
import EcommerceProject.testcomponents.baseTest;

public class TestAddItemsToWishlist extends baseTest{
	
	@Test
	public void validateAddItemsToWishlist() throws IOException, InterruptedException
	{
		String producttitle="Radiant Tee";

		
		LumaEcommerceCustomerLoginPage clp=lp.SignIn();
		clp.enteremail(getPropertyValue("email"));
		clp.enterpassword(getPropertyValue("password"));
		LumaEcommerceHomePage hp=clp.signIn();
		hp.ValidateuserloggedIn();
		LunaWishlistPage wp =hp.addItemToWishlist(producttitle);
		wp.validateItemsInWishlist(producttitle);
		
	
		hp.signOut();
		
	}
	@Test
	public void removeItemsToWishlist() throws IOException, InterruptedException
	{
		String producttitle="Radiant Tee";
		
		LumaEcommerceCustomerLoginPage clp=lp.SignIn();
		clp.enteremail(getPropertyValue("email"));
		clp.enterpassword(getPropertyValue("password"));
		LumaEcommerceHomePage hp=clp.signIn();
		hp.ValidateuserloggedIn();
		LunaWishlistPage wp =hp.gotowishlist();
		wp.removeItemsfromWishlist(producttitle);		
	
		hp.signOut();
		
	}
	
	
}
