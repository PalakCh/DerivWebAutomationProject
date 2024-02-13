package EcommerceProject.tests;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
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
import EcommerceProject.PageObjects.LumaProductPage;
import EcommerceProject.PageObjects.LunaCartPage;
import EcommerceProject.PageObjects.LunaWishlistPage;
import EcommerceProject.testcomponents.baseTest;

public class TestFilterSortFunctionality extends baseTest{
	
	@Test
	public void validateFilter() throws IOException, InterruptedException
	{
		
		LumaEcommerceCustomerLoginPage clp=lp.SignIn();
		clp.enteremail(getPropertyValue("email"));
		clp.enterpassword(getPropertyValue("password"));
		LumaEcommerceHomePage hp=clp.signIn();
		hp.ValidateuserloggedIn();
		
		LumaProductPage pp =hp.goToWomensJackets();
		String filtercount=pp.selectfilter("Style","Insulated");
		Assert.assertEquals(filtercount, pp.countfilteritems());	
	
		hp.signOut();
		
	}

	@Test
	public void validateSort() throws IOException, InterruptedException
	{
		
		LumaEcommerceCustomerLoginPage clp=lp.SignIn();
		clp.enteremail(getPropertyValue("email"));
		clp.enterpassword(getPropertyValue("password"));
		LumaEcommerceHomePage hp=clp.signIn();
		hp.ValidateuserloggedIn();
		
		LumaProductPage pp =hp.goToWomensJackets();
		ArrayList<String> expectedproductnames=pp.getAllProductNamesAndSort();
		pp.selectsort("Product Name");
		ArrayList<String> actualproductnames=pp.getSortedProductNames();
		Assert.assertEquals(expectedproductnames, actualproductnames);
	
		hp.signOut();
		
	}

	
}
