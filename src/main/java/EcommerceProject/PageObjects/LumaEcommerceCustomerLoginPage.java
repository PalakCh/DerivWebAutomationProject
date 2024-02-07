package EcommerceProject.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import EcommerceProject.AbstractComponents.AbstractComponents;

public class LumaEcommerceCustomerLoginPage extends AbstractComponents{
	
	WebDriver driver;
	
	public LumaEcommerceCustomerLoginPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//input[@id='email']")
	WebElement email;
	
	@FindBy(xpath="//input[@name='login[password]']")
	WebElement password;
	
	@FindBy(xpath="//button[@class='action login primary']")
	WebElement SignIn;
	
	@FindBy(xpath="//div[@role='alert']/div/div")
	WebElement IncorrectSignIn;
	
	
	public void enteremail(String emailid)
	{
		email.sendKeys(emailid);
	}
	
	public void enterpassword(String pass)
	{
		password.sendKeys(pass);
	}
	
	public LumaEcommerceHomePage signIn()
	{
		SignIn.click();
		LumaEcommerceHomePage hp = new LumaEcommerceHomePage(driver);
		return hp;
	}
	
	public void validateIncorrectSignInMessage()
	{
		Assert.assertEquals(IncorrectSignIn.getText(), "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.");
	}
	
		
}
