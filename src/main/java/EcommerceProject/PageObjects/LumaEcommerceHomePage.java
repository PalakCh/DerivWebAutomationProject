package EcommerceProject.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import EcommerceProject.AbstractComponents.AbstractComponents;

public class LumaEcommerceHomePage extends AbstractComponents{
	
	WebDriver driver;
	
	public LumaEcommerceHomePage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	//span[@class='logged-in']
	@FindBy(xpath="//span[@class='logged-in']")
	WebElement welcomeuser;
	
	@FindBy(xpath="(//span[@class='customer-name']/button[@type='button'])[1]")
	WebElement customerdropdownmenu;
	
	@FindBy(xpath="(//li[@class='authorization-link']/a)[1]")
	WebElement signout;
	
	@FindBy(xpath="(//li[@class='link wishlist']/a)[1]")
	WebElement wishlist;
	
	@FindBy(xpath="//span[contains(text(),'Women')]")
	WebElement womentopmenu;
	
	@FindBy(xpath="//span[contains(text(),'Tops')]")
	WebElement Tops;
	
	@FindBy(xpath="//span[contains(text(),'Jackets')]")
	WebElement Jackets;
	
	WebElement homepageitem;
	
	//below few lines are only for reference
	/*
	@FindBy(xpath="//a[contains(text(),'Radiant Tee') and @class='product-item-link']/ancestor::li")
	WebElement firstitem;
	WebElement firstitemsize=firstitem.findElement(By.xpath("//div[contains(text(),'S')]"));
	WebElement firstitematc=firstitem.findElement(By.xpath("//span[contains(text(),'Add to Cart')]"));
	WebElement firstitemcolor=firstitem.findElement(By.xpath("//div[@option-label='Blue']"));
	*/
	
		
	public void ValidateuserloggedIn()
	{
		waitForElementToAppear(welcomeuser);
		Assert.assertEquals(welcomeuser.getText(), "Welcome, Palak Autotest!");
	}
	
	public void selectitem(String title,String size,String color)
	{
		String itemxpath="//a[contains(text(),'"+title+"') and @class='product-item-link']/ancestor::li";
		homepageitem=driver.findElement(By.xpath(itemxpath));
		
		String sizexpath=".//div[contains(text(),'"+size+"')]";
		homepageitem.findElement(By.xpath(sizexpath)).click();
		
		String colorxpath=".//div[@option-label='"+color+"']";
		homepageitem.findElement(By.xpath(colorxpath)).click();
		
		homepageitem.findElement(By.xpath(".//span[contains(text(),'Add to Cart')]")).click();
		
	}
	
	public LunaWishlistPage addItemToWishlist(String title)
	{
		String itemxpath="//a[contains(text(),'"+title+"') and @class='product-item-link']/ancestor::li";
		homepageitem=driver.findElement(By.xpath(itemxpath));
		//hover over the item
		Actions action = new Actions(driver);
		action.moveToElement(homepageitem).perform();
		
		homepageitem.findElement(By.xpath(".//*[@title='Add to Wish List']")).click();
		
		LunaWishlistPage wp = new LunaWishlistPage(driver);
		return wp;
		
	}
	
	public LunaWishlistPage gotowishlist()
	{
		customerdropdownmenu.click();
		wishlist.click();
		LunaWishlistPage wp = new LunaWishlistPage(driver);
		return wp;
	}
	
	public LumaProductPage goToWomensJackets()
	{
		Actions action = new Actions(driver);
		action.moveToElement(womentopmenu).perform();
		action.moveToElement(Tops).perform();
		Jackets.click();
		LumaProductPage pp = new LumaProductPage(driver);
		return pp;
	}
	
	public void signOut()
	{
		customerdropdownmenu.click();
		signout.click();
	}
	
}
