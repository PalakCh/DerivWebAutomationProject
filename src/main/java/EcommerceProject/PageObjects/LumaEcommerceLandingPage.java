package EcommerceProject.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import EcommerceProject.AbstractComponents.AbstractComponents;

public class LumaEcommerceLandingPage extends AbstractComponents{
	
	WebDriver driver;
	
	public LumaEcommerceLandingPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="(//a[contains(text(),'Sign In')])[1]")
	WebElement SignIn;
	
	@FindBy(xpath="(//a[contains(text(),'Create an Account')])[1]")
	WebElement CreateAcc;
	
	public LumaEcommerceCustomerLoginPage SignIn()
	{
		SignIn.click();
		LumaEcommerceCustomerLoginPage clp = new LumaEcommerceCustomerLoginPage(driver);
		return clp;
	}
	
	public LumaEcommerceCreateNewAccPage CreateAcc()
	{
		CreateAcc.click();
		LumaEcommerceCreateNewAccPage ap = new LumaEcommerceCreateNewAccPage(driver);
		return ap;
	}
		
}
