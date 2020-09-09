package Workout;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EmptyFileException;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Trivago 
{
	public static void main(String[] args) throws InterruptedException 
	{
	System.setProperty("webdriver.chrome.driver", "./Drivers/Drivers/chromedriver.exe");
	ChromeOptions options=new ChromeOptions();
	options.addArguments("--disable-notofication");
	ChromeDriver driver=new ChromeDriver(options);
	//maximize the browser
	driver.manage().window().maximize();
	//go to Url
	driver.get("https://www.trivago.com/");
	//clear cookies
	driver.manage().deleteAllCookies();
	//implicit wait
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	//Type Agra in Destination
	driver.findElementByXPath("//input[@id='querytext']").sendKeys("Agra");
	Thread.sleep(2000);
	//Select Agra, Uttar Pradesh.
	driver.findElementByXPath("//span[text()='City - Uttar Pradesh, India']").click();
	//Choose May 15 as check in
	driver.findElementByXPath("//button[@id='onetrust-accept-btn-handler']").click();
	Thread.sleep(2000);
	int j=1;
	for (int i = 0; i < j; i++) 
	{
		driver.findElementByClassName("cal-btn-next").click();
		String tempyear=driver.findElementById("cal-heading-month").getText();
		Thread.sleep(1000);
		if(tempyear.contains("May 2021"))
		{
		System.out.println(tempyear);
		}
		else
			j++;
	}
	driver.findElement(By.xpath("//time[@datetime='2021-05-15']")).click();
	//May 30 as check out
	Thread.sleep(1000);
	driver.findElement(By.xpath("//time[@datetime='2021-05-30']")).click();
	Thread.sleep(1000);
	try
	{
		//Select Room as Family Room
		driver.findElementByXPath("//span[text()='Family rooms']").click();
		//Choose Number of Adults 2, Childern 1 and set Child's Age as 4
		Select child=new Select(driver.findElementById("select-num-children-2"));
		child.selectByValue("1");
		driver.findElementByXPath("(//span[@class='btn__text'])[2]]").click();
	}
	catch(Exception e)
	{
		
	
	//Thread.sleep(1000);
	//Choose Number of Adults 2, Childern 1 and set Child's Age as 4

	driver.findElementByXPath("(//button[@class='circle-btn circle-btn--plus'])[2]").click();
	//set Child's Age as 4
	Select age=new Select(driver.findElementByXPath("//select[@name='mf-select-children-age-0']"));
	age.selectByValue("4");
	//Click Confirm

	driver.findElementByXPath("//button[text()='Apply']").click();
	Thread.sleep(2000);
	}
	//Select Accommodation type as Hotels only
	driver.findElementByXPath("(//button[@class='filter-item filter-item--select js-toolbar-hover-button'])[1]").click();
	driver.findElement(By.id("acc-type-filter-1")).click();
	Thread.sleep(1000);
	//choose 4 stars
	driver.findElementByXPath("//button[@value='1320/105']//span[1]").click();
	driver.findElementByXPath("//button[text()='Done']").click();
	//Select Guest rating as Very Good
	driver.findElementById("acc-type-filter-1").click();
	//driver.findElementByXPath("//title[text()='4-star hotels']").click();
	driver.findElementByXPath("//button[@value='1320/105']//span[1]").click();
	driver.findElementByXPath("//button[text()='Done']").click();
	//Set Hotel Location as Agra Fort and click Done
	WebElement guestRating = driver.findElementByXPath("(//button[@class='filter-item filter-item--select js-toolbar-hover-button'])[2]");
	guestRating.click();
	//builder.moveToElement(guestRating).perform();
	driver.findElementByXPath("(//li[@class='range__item']//button)[2]").click();
	WebElement location = driver.findElementByXPath("(//button[@class='filter-item filter-item--select js-toolbar-hover-button'])[3]");
	//builder.moveToElement(location).perform();
	location.click();
	WebElement city = driver.findElementById("pois");
	city.click();
	Select cityDropDown = new Select(city);
	cityDropDown.selectByVisibleText("Agra Fort");
	driver.findElementByXPath("//button[text()='Done']").click();
	
	//Sort By
	WebElement sortBy = driver.findElementById("mf-select-sortby");
	sortBy.click();
	Select sortDropDown = new Select(sortBy);
	sortDropDown.selectByVisibleText("Rating & Recommended");
	
	
	//Printing the list of hotels displayed
	List<WebElement> hotelNames = driver.findElements(By.xpath("//h3[@class='m-0']//span"));	
	int size = hotelNames.size();
	System.out.println("Total no of Hotels Fetched is: "+size);
	System.out.println("List of Hotels:");
	System.out.println("***************");
	Thread.sleep(10000);
	for(int i=0;i<size;i++)
	{
		System.out.println((i+1)+". " +hotelNames.get(i).getText());
	}
	
	Thread.sleep(5000);
	String currentURL = driver.getCurrentUrl();
	System.out.println("Current URL is: "+currentURL);
	
	//clicking on the deal of first resulting hotel
	driver.findElementByXPath("(//span[text()='View Deal'])[1]").click();
	
	
	Set<String> setWindowHandles = driver.getWindowHandles();
	List<String> listWindowHandles = new ArrayList<String>(setWindowHandles);
	
	// getting the second window
	String secondWindow = listWindowHandles.get(1);		
	driver.switchTo().window(secondWindow);
	driver.manage().deleteAllCookies();
	driver.navigate().refresh();
	
	//printing price and clicking choose your room
	String price = driver.findElementByXPath("(//div[contains(@class,'bui-price-display__value prco-text-nowrap-helper')])[1]").getText();
	System.out.println("Price of Hotel: "+price.substring(2));
	driver.findElementByXPath("(//span[@class='bui-button__text'])[1]").click();
	
	//Selecting Reseve and I will Reserve
	driver.findElementByXPath("(//span[@class='bui-button__text'])[1]").click();
	Thread.sleep(2000);
	driver.findElementByXPath("(//button[@type='submit'])[3]").click();
	
	// closes the second window
	driver.close();

	// going back to first window again
	driver.switchTo().window(listWindowHandles.get(0));

	// closes the first window
	driver.close();
	

	
	
	}	
}