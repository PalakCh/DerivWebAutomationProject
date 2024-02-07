package EcommerceProject.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import EcommerceProject.AbstractComponents.AbstractComponents;

public class LumaEcommerceCreateNewAccPage extends AbstractComponents{
	
	WebDriver driver;
	
	public LumaEcommerceCreateNewAccPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//input[@id='firstname']")
	WebElement firstname;
	
	@FindBy(xpath="//input[@id='lastname']")
	WebElement lastname;
	
	@FindBy(xpath="//input[@name='email']")
	WebElement email;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement password;
	
	@FindBy(xpath="//input[@name='password_confirmation']")
	WebElement confirmpassword;
	
	@FindBy(xpath="//button[@title='Create an Account']")
	WebElement createaccount;
	
	@FindBy(xpath="//div[contains(text(),'This is a required field.')]")
	WebElement requiredfieldmsg;
	
	@FindBy(xpath="//div[contains(text(),'Please enter the same value again.')]")
	WebElement entersamevaluemsg;
	
	@FindBy(xpath="//div[contains(text(),'There is already an account with this email address. If you are sure that it is your email address, ')]")
	WebElement existsemailidmsg;
	
	public void enterfirstname(String fname)
	{
		firstname.sendKeys(fname);
	}
	
	public void enterlastname(String lname)
	{
		lastname.sendKeys(lname);
	}
	
	public void enteremail(String emailid)
	{
		email.sendKeys(emailid);
	}
	
	public void enternewemail()
	{
		email.sendKeys(generateRandomAlphnumericString(8) + "@gmail.com");
	}
	
	public void enterpassword(String pass)
	{
		password.sendKeys(pass);
	}
	
	public void enterconfirmpassword(String confirmpass)
	{
		confirmpassword.sendKeys(confirmpass);
	}
	
	public LumaEcommerceHomePage ClickCreateAcc()
	{
		createaccount.click();
		LumaEcommerceHomePage hp = new LumaEcommerceHomePage(driver);
		return hp;
	}
	
	public void validaterequiredfieldmsg()
	{
		Assert.assertEquals(requiredfieldmsg.getText(), "This is a required field.");
		Assert.assertEquals(confirmpassword.getCssValue("border-color"),"rgb(237, 131, 128)");
		
	}
	
	public void validateentersamevaluemsg()
	{
		Assert.assertEquals(entersamevaluemsg.getText(), "Please enter the same value again.");
		Assert.assertEquals(confirmpassword.getCssValue("border-color"),"rgb(237, 131, 128)");
		
	}
	
	public void validateemailidexistsmsg()
	{
		Assert.assertEquals(existsemailidmsg.getText(), "There is already an account with this email address. If you are sure that it is your email address, click here to get your password and access your account.");
		
	}
		
}
