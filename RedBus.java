package Week3.Day1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import freemarker.template.SimpleDate;

public class RedBus 
{
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/Drivers/chromedriver1.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		//Load URL, implicitwait
		driver.get("https://www.redbus.in/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//Enter From (Chennai) and Tab
		driver.findElementByXPath("//input[@id='src']").sendKeys("Chennai");
		Thread.sleep(2000);
		driver.findElementByXPath("//input[@id='src']").sendKeys(Keys.TAB);
		
		
		//Enter To (Trichy) and Tab
		driver.findElementByXPath("//input[@id='dest']").sendKeys("Trichy",Keys.TAB);
		Thread.sleep(2000);
		driver.findElementByXPath("//input[@id='dest']").sendKeys(Keys.TAB);
		
		//Click on current date 
		/*
		 * driver.
		 * findElementByXPath("//span[@class='fl icon-calendar_icon-new icon-onward-calendar icon']"
		 * ).click(); DateFormat dateFormat = new SimpleDateFormat("dd"); Date date =
		 * new Date(); String date1= dateFormat.format(date); System.out.println(date1);
		 * driver.
		 * findElementByXPath("//table[@class='rb-monthTable first last']//tr//td[text()='"
		 * + date1 +"']").click();
		 */
		driver.findElementByXPath("(//td[@class='current day'])[2]").click();
		
		//5) Click on Return Date
		driver.findElementByXPath("//div[@class='fl search-box date-box gtm-returnCalendar']").click();
		driver.findElementByXPath("(//table[@class='rb-monthTable first last'])[2]//td[@class='current day']").click();
		Thread.sleep(2000);
		
		
		//7) Click Search Buses
		
		driver.findElement(By.xpath("//button[@class='fl button']")).click();
		Thread.sleep(3000);
		
	driver.close();
		

}	
}