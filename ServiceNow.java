package Week4.Day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ServiceNow 
{
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./Drivers/Drivers/chromedriver1.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://dev60453.service-now.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.switchTo().frame("gsft_main");
		driver.findElementByXPath("//input[@id='user_name']").sendKeys("admin");
		driver.findElementByXPath("//input[@id='user_password']").sendKeys("India@123");
		driver.findElementByXPath("//button[@id='sysverb_login']").click();
		//Enter Change in filter navigator
		driver.findElementByXPath("//input[@id='filter']").sendKeys("Change");
		driver.findElementByXPath("(//a/div/div[text()='All'])[4]").click();
		Thread.sleep(1000);
		driver.switchTo().frame(0);
	driver.findElementByXPath("//button[@id='sysverb_new']").click();
	Thread.sleep(2000);
	driver.findElementByXPath("//div[@class='container-fluid wizard-container']/a").click();
	//driver.switchTo().frame("gsft_main");
	String changeNumber= driver.findElementByXPath("//input[@id='sys_displayValue']").getAttribute("value");
	System.out.println(changeNumber);
	//Capture the change request Number from the Number Filed
	driver.findElementByXPath("//input[@id='change_request.short_description']").sendKeys("TestLeaf");
	//Click submit button
	driver.findElementByXPath("//button[text()='Submit']").click();
	//Go to the search field and search the captured number
	driver.switchTo().defaultContent();
	driver.findElementByXPath("//label[@for='sysparm_search']").click();
	driver.findElementByXPath("//input[@id='sysparm_search']").sendKeys(changeNumber,Keys.ENTER);
	//Verify the successful creation of change
	driver.switchTo().defaultContent();
	Thread.sleep(2000);
	driver.switchTo().frame("gsft_main");
	String changeRequest = driver.findElementByXPath("//input[@id='change_request.short_description']").getAttribute("value");
	if(changeRequest.contains("TestLeaf"))
	{
		System.out.println("Successful creation of change");
	}
	else
		System.out.println("Failed Change");
	driver.close();
}
	
}