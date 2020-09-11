package Week3.Day1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class ClearTrip
{
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./Drivers/Drivers/chromedriver1.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		//launch URL
		driver.get("https://www.cleartrip.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		// Click Round trip
		driver.findElementByXPath("//input[@id='RoundTrip']").click();
		
		//Enter From city (Chennai) and TAB
		driver.findElementByXPath("//input[@id='FromTag']").sendKeys("Chennai",Keys.TAB);
		
		//Enter To city (New York) and TAB
		driver.findElementByXPath("//input[@id='ToTag']").sendKeys("New York",Keys.TAB);
		
		//Click Date (use current date as hardcoded) // Note it is link -> so use linkText
		
		 DateFormat dateFormat = new SimpleDateFormat("dd");
		 Date date = new Date();
		 String date1= dateFormat.format(date);
		 System.out.println(date1);
		 driver.findElementByXPath("//a[text()='" + date1 + "']").click();
		
		//Click Date (10) // Note it is link -> so use linkText
		driver.findElementByLinkText("10").click();
		
		// Select Adults (as 2)
		WebElement source =driver.findElementById("Adults");
		Select dropDown=new Select(source);
		dropDown.selectByVisibleText("2");
		
		//Select Children (as 1)
		WebElement children =driver.findElementById("Childrens");
		Select dropDown2=new Select(children);
		dropDown2.selectByVisibleText("1");
		
		//Select Infant (as 1)
		WebElement infant =driver.findElementById("Infants");
		Select dropDown3=new Select(infant);
		dropDown3.selectByVisibleText("1");
		
		//Click More Options (use id as locator)
		driver.findElementById("MoreOptionsLink").click();
		
		//Select Premium Economy as Class of Travel
		
		WebElement classTravel =driver.findElementById("Class");
		Select dropDown4=new Select(classTravel);
		dropDown4.selectByVisibleText("Premium Economy");
		
		//Enter Preferred Airline as Emirates and TAB
		driver.findElementByXPath("//input[@id='AirlineAutocomplete']").sendKeys("Emirates",Keys.TAB);
		
		//Click Search Flights
		driver.findElementByXPath("//input[@id='SearchBtn']").click();
}

	
	

}