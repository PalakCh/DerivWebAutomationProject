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
import EcommerceProject.PageObjects.LandingPage;
import EcommerceProject.testcomponents.baseTest;

public class ErrorValidation extends baseTest{
	
	
	@Test(groups= {"errorvalidation"})
	public void errorValidate() throws IOException
	{
		/*
		String product="zara coat 3";
		CatalogPage cp=lp.loginApp("palak@abc.com", "@123");
		
		Assert.assertEquals("Incorrect email or password.", lp.getErrorMessage());
		
			*/	

	}

}
