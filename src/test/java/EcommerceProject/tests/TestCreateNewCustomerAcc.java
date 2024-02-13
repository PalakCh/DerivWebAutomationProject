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
import EcommerceProject.PageObjects.LumaEcommerceHomePage;
import EcommerceProject.testcomponents.baseTest;

public class TestCreateNewCustomerAcc extends baseTest{
	
	
	@Test
	public void createAccWithMandatoryFieldsMissingTestCase01() throws IOException
	{
		LumaEcommerceCreateNewAccPage ap=lp.CreateAcc();
		ap.enterfirstname("AutoTest");
		ap.enterlastname("AutoTest");
		ap.enternewemail();
		ap.enterpassword("AutoTest123");
		//ap.enterconfirmpassword("AutoTest123");
		ap.ClickCreateAcc();
		ap.validaterequiredfieldmsg();
	}
	
	
	@Test
	public void createAccWithPasswordandConfirmPasswordMissmatchTestCase02() throws IOException
	{
		LumaEcommerceCreateNewAccPage ap=lp.CreateAcc();
		ap.enterfirstname("AutoTest");
		ap.enterlastname("AutoTest");
		ap.enternewemail();
		ap.enterpassword("AutoTest123");
		ap.enterconfirmpassword("AutoTest1234");
		ap.ClickCreateAcc();
		ap.validateentersamevaluemsg();
	}
	
	@Test
	public void createAccWithAlreadyUsedEmailIdTestCase03() throws IOException
	{
		LumaEcommerceCreateNewAccPage ap=lp.CreateAcc();
		ap.enterfirstname("AutoTest");
		ap.enterlastname("AutoTest");
		ap.enteremail("Palakautotest@gmail.com");
		ap.enterpassword("AutoTest123");
		ap.enterconfirmpassword("AutoTest123");
		ap.ClickCreateAcc();
		ap.validateemailidexistsmsg();
		
	}
	
	@Test
	public void createAccWithAllFieldsCorrectlyTestCase04() throws IOException
	{
		LumaEcommerceCreateNewAccPage ap=lp.CreateAcc();
		ap.enterfirstname("AutoTest");
		ap.enterlastname("AutoTest");
		ap.enternewemail();
		ap.enterpassword("AutoTest123");
		ap.enterconfirmpassword("AutoTest123");
		ap.ClickCreateAcc();
		
	}
	
	
}
