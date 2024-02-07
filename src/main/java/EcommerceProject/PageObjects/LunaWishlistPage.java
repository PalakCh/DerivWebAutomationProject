package EcommerceProject.PageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import EcommerceProject.AbstractComponents.AbstractComponents;

public class LunaWishlistPage extends AbstractComponents {
	
	WebDriver driver;
	
	public LunaWishlistPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//div[@class='products-grid wishlist']//li[@class='product-item']")
	List<WebElement> wishlistitems;
	
	public void validateItemsInWishlist(String product)
	{
		for(int i=0;i<wishlistitems.size();i++)
		{
			if(wishlistitems.get(i).findElement(By.xpath(".//a[@class='product-item-link']")).getText().equalsIgnoreCase(product))
			{
				System.out.println("Item exists in wishlist");
			}
		}
	}
	
	public void removeItemsfromWishlist(String product)
	{
		for(int i=0;i<wishlistitems.size();i++)
		{
			if(wishlistitems.get(i).findElement(By.xpath(".//a[@class='product-item-link']")).getText().equalsIgnoreCase(product))
			{
				Actions action = new Actions(driver);
				action.moveToElement(wishlistitems.get(i).findElement(By.xpath(".//*[@class='product-image-photo']"))).perform();
				wishlistitems.get(i).findElement(By.xpath(".//*[@class='btn-remove action delete']")).click();
				

			}
		}
	}

	
	
}
