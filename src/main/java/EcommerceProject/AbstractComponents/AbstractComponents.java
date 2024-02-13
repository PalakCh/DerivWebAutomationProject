package EcommerceProject.AbstractComponents;

import java.time.Duration;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import EcommerceProject.PageObjects.LunaCartPage;
import EcommerceProject.PageObjects.OrdersPage;

public class AbstractComponents {
	
	WebDriver driver;
	
	public AbstractComponents(WebDriver driver) {
		this.driver=driver;
	}
	
	@FindBy(xpath="//a[@class='action showcart']")
	WebElement Cart;
		
	@FindBy(xpath="//*[contains(text(),'View and Edit Cart')]")
	WebElement viewCart;
	
	public LunaCartPage clickCart()
	{
		Cart.click();
		viewCart.click();
		LunaCartPage cop=new LunaCartPage(driver);
		return cop;
		
	}
	
	/*
	@FindBy(xpath="//button[@routerlink='/dashboard/cart']")
	WebElement Cart;
	
	@FindBy(xpath="//button[@routerlink='/dashboard/myorders']")
	WebElement myorders;
	
	
	public CartPage goToCart()
	{
		Cart.click();
		CartPage cop=new CartPage(driver);
		return cop;
	}
	
	public OrdersPage goToOrders()
	{
		myorders.click();
		OrdersPage op=new OrdersPage(driver);
		return op;
	}
	*/
	
	public void goToUrl(String url)
	{
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	public void waitForElementToAppear(WebElement we1)
	{
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOf(we1));
	}
	public void waitForElementToDisappear(WebElement we2)
	{
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
		w.until(ExpectedConditions.invisibilityOf(we2));
	}
	
	public int generateRandomNumber()
	{
		Random rnd = new Random();
		int n = 100000 + rnd.nextInt(900000);
		return n;
	
	}
	
	public String generateRandomAlphnumericString(int length)
	{
		String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		Random random = new Random();
		StringBuilder builder = new StringBuilder(length);
		 for (int i = 0; i < length; i++) {
		        builder.append(ALPHABET.charAt(random.nextInt(ALPHABET.length())));
		    }

		    return builder.toString();
		    
	
	}
	

}
