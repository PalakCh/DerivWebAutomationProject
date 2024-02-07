package EcommerceProject.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import EcommerceProject.AbstractComponents.AbstractComponents;

public class UpdateProfilePage extends AbstractComponents{
	
	WebDriver driver;
	int newzipcode;
	
	public UpdateProfilePage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//input[@id='customer.address.zipCode']")
	WebElement zipcode;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement updateprofile;
	
	@FindBy(xpath="//h1[contains(text(),'Profile Updated')]")
	WebElement profileUpdatedMessage;
	
	
	public void updateZipcode()
	{
		newzipcode=generateRandomNumber();
		zipcode.sendKeys(String.valueOf(newzipcode));
		updateprofile.click();	
	}
	
	public void verifyProfileUpdatedMessage()
	{
		Assert.assertEquals(profileUpdatedMessage.getText(),"Profile Updated");
	}
		
	public void verifyZipCodeUpdated()
	{
		
	}
	
}
