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

import EcommerceProject.PageObjects.CartPage;
import EcommerceProject.PageObjects.CatalogPage;
import EcommerceProject.PageObjects.CheckoutPage;
import EcommerceProject.PageObjects.ConfirmationPage;
import EcommerceProject.PageObjects.HomePage;
import EcommerceProject.PageObjects.LandingPage;
import EcommerceProject.PageObjects.OrdersPage;
import EcommerceProject.PageObjects.ParaBankLandingPage;
import EcommerceProject.testcomponents.baseTest;

public class loginFunctionality extends baseTest{
	
	
	@Test
	public void loginWithInValidUsernameTestCase01() throws IOException
	{
		lp.Login("dsfwishf", "fvfdgbeks");
		Assert.assertTrue(lp.getErrorMessage().equalsIgnoreCase("An internal error has occurred and has been logged."));
		/*
		String product="zara coat 3";
		CatalogPage cp=lp.loginApp("palak@abc.com", "Password@123");
		List<WebElement> products=cp.getproductslist();
		cp.searchAndAddProductToCart(product);
		CartPage cop=cp.goToCart();
		boolean checkitem=cop.checkItemExistsInCart(product);
		Assert.assertTrue(checkitem);
		CheckoutPage ck=cop.clickCheckOut();
		
		//select country
		String country="India";
		ck.selectcountry(country);
		ConfirmationPage conp=ck.clickorderconfirm();
			
		//verify the confirmation message
		String ConfirmationMessage=conp.getConfirmMessage();
		Assert.assertTrue(ConfirmationMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		
		//get the order number
		System.out.println(conp.getordernumber());
				
	*/
	}
	
	@Test
	public void loginWithInValidPasswordTestCase02() throws IOException
	{
		lp.Login(getPropertyValue("username"), "fvfdgbeks");
		Assert.assertTrue(lp.getErrorMessage().equalsIgnoreCase("An internal error has occurred and has been logged."));
	}
	
	@Test
	public void loginWithInValidCredentialsTestCase03() throws IOException
	{
		HomePage hp=lp.Login(getPropertyValue("username"), getPropertyValue("password"));
		//hp.welcomeMessage(getPropertyValue("username"));
		hp.Logout();
		
	}
	
}
