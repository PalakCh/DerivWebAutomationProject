package EcommerceProject.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import EcommerceProject.AbstractComponents.AbstractComponents;

public class ParaBankLandingPage extends AbstractComponents{
	
	WebDriver driver;
	
	public ParaBankLandingPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(name="username")
	WebElement Username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginButton;
	
	@FindBy(xpath="//*[@class='error']")
	WebElement errormessage;
		
	public HomePage Login(String User, String pass)
	{
		Username.sendKeys(User);
		password.sendKeys(pass);
		loginButton.click();	
		HomePage hp =new HomePage(driver);
		return hp;
	}
	
	public String getErrorMessage()
	{
		waitForElementToAppear(errormessage);
		return errormessage.getText();
	}
	
	/*public CatalogPage loginApp(String email,String password)
	{
		useremail.sendKeys(email);
		userPassword.sendKeys(password);
		submit.click();
		
		CatalogPage cp=new CatalogPage(driver);
		return cp;
		
	}
		public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().window().maximize();
	}
	*/	
}
