package Workout;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class BigBasket 
{
	public static void main(String[] args) throws InterruptedException 
	{
	System.setProperty("webdriver.chrome.driver", "./Drivers/Drivers/chromedriver.exe");
	ChromeOptions options=new ChromeOptions();
	options.addArguments("--disable-notofic  ation");
	ChromeDriver driver=new ChromeDriver(options);
	//maximize the browser
	driver.manage().window().maximize();
	//go to Url
	driver.get("https://www.bigbasket.com/");
	//clear cookies
	driver.manage().deleteAllCookies();
	//implicit wait
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	// mouse over on  Shop by Category 
	WebElement shop = driver.findElementByXPath("//a[@class='dropdown-toggle meganav-shop']");
	Actions builder=new Actions(driver);
	builder.moveToElement(shop).perform();
	//Go to Beverages 
	WebElement beverages = driver.findElementByXPath("(//a[text()='Beverages'])[2]");
	Actions builder1=new Actions(driver);
	builder1.moveToElement(beverages).perform();
	//and Fruit juices & Drinks
	driver.findElementByXPath("(//a[text()='Fruit Juices & Drinks'])[2]").click();
	//Click on JUICES
	driver.findElementByXPath("(//div[@class='ng-scope'])[9]").click();
	driver.findElementByXPath("(//div[@class='ng-scope'])[9]").click();
	//Click Real 
	driver.findElementByXPath("(//span[text()='Real'])[1]").click();
	Thread.sleep(5000);
	String real = driver.findElementById("snowplow_screen_view_totalcount").getAttribute("value");
	int realCount=Integer.parseInt(real);
	System.out.println("The Real product count of product is "+realCount);
	//click Tropicana
	driver.findElementByXPath("(//span[text()='Tropicana'])[1]").click();
	Thread.sleep(3000);
	String tropicana = driver.findElementById("snowplow_screen_view_totalcount").getAttribute("value");
	int tropicanaCount=Integer.parseInt(tropicana)-realCount;
	System.out.println("The Tropicana product count of product is "+tropicanaCount);
	Thread.sleep(3000);
	String total = driver.findElementById("snowplow_screen_view_totalcount").getAttribute("value");
	int totalCount=Integer.parseInt(total);
	System.out.println("The total count of product is "+totalCount);
	Thread.sleep(2000);
	//Check whether the products is availabe with Add button.
	List<WebElement> addButton = driver.findElementsByXPath("//button[@qa='add']");
	System.out.println("The "+addButton.size()+" product have add button");
	//notify me
	List<WebElement> notify = driver.findElementsByXPath("//button[@qa='NM']");
	System.out.println("The "+notify.size()+" product not have add button");
	//Add the First listed available product 
	driver.findElementByXPath("(//button[@qa='add'])[1]").click();
	Thread.sleep(2000);
	//click on Change Address 
	driver.findElementByXPath("(//a[text()='Change Location'])[1]").click();
	//Select CHennai as City
	//driver.findElementByXPath("//input[@type='search']").click();
	//driver.findElementByXPath("//a/span[text()='Chennai']").click();
	//as City, Alandur-600016,Chennai as Area  and click Continue
	driver.findElementByXPath("(//input[@qa='areaInput'])[1]").sendKeys("Alandur");
	Thread.sleep(2000);
	driver.findElementByXPath("(//input[@qa='areaInput'])[1]").sendKeys(Keys.TAB);
	//click Continue
	driver.findElementByXPath("//button[@name='continue']").click();
	//Mouse over on My Basket
	WebElement basket = driver.findElementByXPath("//span[@class='basket-content']");
	Actions builder2=new Actions(driver);
	builder2.moveToElement(basket).perform();
	//print the product name. count and price.
	String mybasketProduct = driver.findElementByXPath("//div[@class='col-md-5 item-info']").getText();
	System.out.println("My Basket details is " +mybasketProduct);
	//Click View Basket and Checkout
	driver.findElementByXPath("//button[@qa='viewBasketMB']").click();
	//Click the close button and close the browser
	driver.findElementByXPath("(//button[@class='close'])[1]").click();
	driver.close();
	
}
}