package EcommerceProject.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import EcommerceProject.AbstractComponents.AbstractComponents;

public class HomePage extends AbstractComponents{
	
	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//h1[@class='title']")
	WebElement welcomemsg;
	
	@FindBy(xpath="//a[contains(text(),'Log Out')]")
	WebElement logout;
	
	@FindBy(xpath="//a[contains(text(),'Update Contact Info')]")
	WebElement updatecontactinfo;
	
	
	public void welcomeMessage(String username)
	{
		String message="Welcome "+ username;
		Assert.assertEquals(welcomemsg.getText(), message);
		
	}
	
	public void Logout()
	{
		logout.click();
	}
	
	public UpdateProfilePage clickupdatecontactinfo()
	{
		updatecontactinfo.click();
		UpdateProfilePage up = new UpdateProfilePage(driver);
		return up;
		
	}
		
}
