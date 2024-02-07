package EcommerceProject.PageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import EcommerceProject.AbstractComponents.AbstractComponents;

public class LunaCartPage extends AbstractComponents {
	
	WebDriver driver;
	
	public LunaCartPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//tbody[@class='cart item']")
	List<WebElement> cartitems;
	
	@FindBy(xpath="//tbody[@class='cart item']//*[@class='product-item-name']//a")
	List<WebElement> cartitemtitles;
	
	
	public boolean checkItemExistsInCart(String product)
	{
		
		boolean itemexists=false;
		for(int i=0;i<cartitems.size();i++)
		{	
			
			if (cartitems.get(i).findElement(By.xpath(".//*[@class='product-item-name']//a")).getText().equalsIgnoreCase(product))
			{
				System.out.println("Item exists in cart");
				itemexists=true;
				
			}
		}
		return itemexists;
	}
	
	public void removeitemfromcart(String product)
	{
		for(int i=0;i<cartitems.size();i++)
		{
			if (cartitems.get(i).findElement(By.xpath(".//*[@class='product-item-name']//a")).getText().equalsIgnoreCase(product))
			{
				cartitems.get(i).findElement(By.xpath(".//*[@title='Remove item']")).click();
			}
		}
	}
	/*
	@FindBy(xpath="//div[@class='cartSection']/h3")
	List<WebElement> cartitems;
	
	@FindBy(xpath="//button[contains(text(),'Checkout')]")
	WebElement checkout;
		
	public boolean checkItemExistsInCart(String product)
	{
		boolean itemexists=false;
		for(int i=0;i<cartitems.size();i++)
		{
			if (cartitems.get(i).getText().equalsIgnoreCase(product))
			{
				System.out.println("Item exists in cart");
				itemexists=true;
			}
			
		}
		return itemexists;
		
	}
	
	public CheckoutPage clickCheckOut()
	{
		checkout.click();
		CheckoutPage ck=new CheckoutPage(driver);
		return ck;
	}
	
	*/
	
}
