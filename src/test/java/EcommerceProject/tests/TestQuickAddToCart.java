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
import EcommerceProject.testcomponents.baseTest;

public class TestQuickAddToCart extends baseTest{
	
	@Test
	public void validateQuickAddToCartSingleItem() throws IOException, InterruptedException
	{
		String producttitle="Radiant Tee";
		String size="S";
		String color="Blue";
		
		LumaEcommerceCustomerLoginPage clp=lp.SignIn();
		clp.enteremail(getPropertyValue("email"));
		clp.enterpassword(getPropertyValue("password"));
		LumaEcommerceHomePage hp=clp.signIn();
		hp.ValidateuserloggedIn();
		
		hp.selectitem(producttitle, size, color);
		Thread.sleep(1500);
		LunaCartPage cop=hp.clickCart();
		cop.checkItemExistsInCart(producttitle);
		cop.removeitemfromcart(producttitle);
	
		hp.signOut();
		
	}
	
	@Test
	public void validateQuickAddToCartMulitpleItems() throws IOException, InterruptedException
	{
		String producttitle="Radiant Tee";
		String size="S";
		String color="Blue";
		
		String producttitle2="Hero Hoodie";
		String size2="S";
		String color2="Green";
		
		LumaEcommerceCustomerLoginPage clp=lp.SignIn();
		clp.enteremail(getPropertyValue("email"));
		clp.enterpassword(getPropertyValue("password"));
		LumaEcommerceHomePage hp=clp.signIn();
		hp.ValidateuserloggedIn();
		
		hp.selectitem(producttitle, size, color);
		Thread.sleep(1500);
		hp.selectitem(producttitle2, size2, color2);
		Thread.sleep(1500);
		LunaCartPage cop=hp.clickCart();
		cop.checkItemExistsInCart(producttitle);
		cop.checkItemExistsInCart(producttitle2);
		cop.removeitemfromcart(producttitle);
		cop.removeitemfromcart(producttitle2);
	
		hp.signOut();
		
	}
}
