package Workout;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class zalando 
{
public static void main(String[] args) throws InterruptedException 
{
	//launch Chrome driver with disable option
	System.setProperty("webdriver.chrome.driver", "./Drivers/Drivers/chromedriver.exe");
	ChromeOptions options=new ChromeOptions();
	options.addArguments("--disable-notofication");
	ChromeDriver driver=new ChromeDriver(options);
	//maximize the browser
	driver.manage().window().maximize();
	//go to Url
	driver.get("https://www.zalando.com/");
	//clear cookies
	driver.manage().deleteAllCookies();
	//implicit wait
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	//Get the Alert text and print it
	Thread.sleep(2000);
	Alert alert=driver.switchTo().alert();
	System.out.println(alert.getText());
	//Close the Alert box
	alert.accept();
	//click on Zalando.uk
	driver.findElementByXPath("//a[text()='Zalando.uk']").click();
	//Click Women-->
	driver.findElementByXPath("(//span[text()='Women'])[2]").click();
	// Clothing 
	WebElement clothing = driver.findElementByXPath("(//a[@class='z-navicat-header_categoryListLink'])[3]");
	Actions builder=new Actions(driver);
	builder.moveToElement(clothing).perform();
	//Click Coats 
	driver.findElementByXPath("//span[text()='Coats']").click();
	Thread.sleep(3000);
	WebDriverWait wait=new WebDriverWait(driver,30);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='uc-btn-accept-banner']"))).click();
	//driver.findElementByXPath("//button[@id='uc-btn-accept-banner']").click();
	Thread.sleep(3000);
	//Choose Material as cotton (100%)
	driver.findElement(By.xpath("(//div[@class='cat_container-109XU']/button)[6]")).click();
	driver.findElementByXPath("(//li[@class='cat_pill-eq1Rc cat_row-36vtu cat_brd-4-27afw']/span)[4]").click();
	driver.findElementByXPath("//button[text()='Save']").click();
	Thread.sleep(3000);
	//Length as thigh-length
	driver.findElementByXPath("(//div[@class='cat_container-109XU']/button)[9]").click();
	driver.findElementByXPath("(//div[@class='cat_itemList-sgr85 cat_scrollbar---3VP']/ul/li)[2]").click();
	driver.findElementByXPath("//button[text()='Save']").click();
	Thread.sleep(3000);
	//Click on JUNAROSE - by VERO MODA
	driver.findElementByXPath("(//div[@class='cat_container-109XU']/button)[3]").click();
	driver.findElementByXPath("//input[@name='search']").sendKeys("JUNAROSE - by VERO MODA",Keys.TAB,Keys.ENTER);
	driver.findElementByXPath("//button[text()='Save']").click();
	Thread.sleep(3000);
	driver.findElementByXPath("//div[@class='cat_cardWrap-2UHT7']/a").click();
	Thread.sleep(3000);
	//Size 
	driver.findElementByXPath("//button[@aria-haspopup='listbox']").click();
	
	Thread.sleep(1000);
	
	driver.findElementByXPath("//span[text()='Manufacturer sizes']").click();
	
	Thread.sleep(1000);
	
	driver.findElementByXPath("//span[text()='M']").click();
	
	Thread.sleep(1000);
	//Add to bag only if Standard Delivery is free);
	String delivery = driver.findElementByXPath("(//span[@class='AtOZbZ'])[2]").getText();
	System.out.println("The Standard delivery is"+delivery);
	if(delivery.contains("Free"))
	{
		driver.findElementByXPath("//div[@class='UyCaZm v9RC-i z-pdp__dx_cta_container']/button").click();
	}
	else
		System.out.println("The standard delivery is not Free delivery");
	//Click on "Go to Bag"
	driver.findElementByXPath("//span[text()='Your bag']").click();
	//Read the Estimated Deliver Date and print
	String estimatDelivery = driver.findElementByXPath("//div[@data-id='delivery-estimation']/span").getText();
	System.out.println("The estimated delivery date is "+estimatDelivery);
	Thread.sleep(1000);
	//Click on 'Go To Checkout'
	driver.findElementByXPath("(//div[text()='Go to checkout'])[1]").click();
	Thread.sleep(3000);
	//Enter your email
	driver.findElementByXPath("//div[@class='rjqNeP Upa9lO']/input").sendKeys("vaishu.cvs@gmail.com");
	//Click on Login button
	driver.findElementByXPath("//span[text()='Login']").click();
	
	String error = driver.findElementByXPath("//span[@class='C5k6gw gQjacQ gM8atJ VcCaWc O82Ha7 UnzkRv P6b3OO febL1w X3ffeU T23wcN NXRGxc h63b42 SFWSLQ YJjAXl TOkEjs ML2DGG']").getText();
	System.err.println(error);
	
	
	
	
}
}
