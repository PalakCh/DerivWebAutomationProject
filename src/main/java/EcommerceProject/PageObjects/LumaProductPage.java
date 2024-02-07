package EcommerceProject.PageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import EcommerceProject.AbstractComponents.AbstractComponents;

public class LumaProductPage extends AbstractComponents {
	
	WebDriver driver;
	
	public LumaProductPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//div[contains(text(),'Style')]")
	WebElement filterstyle;
	
	@FindBy(xpath="//li[@class='item product product-item']")
	List<WebElement> productslist;
	
	@FindBy(xpath="(//*[@id='sorter'])[1]")
	WebElement sortbybutton;
	
	@FindBy(xpath="//a[@class='product-item-link']")
	List<WebElement> productsname;
	
	public ArrayList<String> expectedproductnames =new ArrayList<String>();
	public ArrayList<String> actualproductnames =new ArrayList<String>();
	
	public String selectfilter(String filtertype, String filteroption)
	{
		String filterxpath="//div[contains(text(),'"+filtertype+"')]";
		driver.findElement(By.xpath(filterxpath)).click();
		
		String filteroptionxpath="//a[contains(text(),'"+filteroption+"')]";
		String filteroptioncountxpath="//a[contains(text(),'"+filteroption+"')]/span";
		
		String filtercount=driver.findElement(By.xpath(filteroptioncountxpath)).getText();
		
		driver.findElement(By.xpath(filteroptionxpath)).click();
		return filtercount;
		
		
	}
	
	public String countfilteritems()
	{
		
		return Integer.toString(productslist.size())+"\nitem";	
	}
	
	public void selectsort(String sortoption)
	{
		Select s = new Select(sortbybutton);
		s.selectByVisibleText(sortoption);
	}
	
	public ArrayList<String> getAllProductNamesAndSort()
	{
		
		
		for(int i=0;i<productsname.size();i++)
		{
			expectedproductnames.add(productsname.get(i).getText());
		}
		
		Collections.sort(expectedproductnames);
		System.out.println(expectedproductnames);
		return expectedproductnames;
	}
	
	public ArrayList<String> getSortedProductNames()
	{

	
		for(int i=0;i<productsname.size();i++)
		{
			actualproductnames.add(productsname.get(i).getText());
		}
		
		System.out.println(actualproductnames);
		return actualproductnames;
		
	}
	
}
