package Week4.Day1;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import Week3.Day1.WebTable;

public class Acme 
{
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./Drivers/Drivers/chromedriver1.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://acme-test.uipath.com/account/login");
		//Enter UserName (kumar.testleaf@gmail.com) and TAB
		driver.findElementByXPath("//input[@id='email']").sendKeys("kumar.testleaf@gmail.com",Keys.TAB);
		//Enter Password (leaf@12)
		driver.findElementByXPath("//input[@id='password']").sendKeys("leaf@12");
		//Click Login
		driver.findElementByXPath("//button[@id='buttonLogin']").click();
		Thread.sleep(1000);
		//Mouse Over on Vendors
	WebElement vendor=driver.findElementByXPath("//button[text()=' Vendors']");
	Actions builder= new Actions(driver);
	builder.moveToElement(vendor).perform();
	//Click Search Vendor
	driver.findElementByXPath("//a[text()='Search for Vendor']").click();
	//Enter Vendor Name (Blue Lagoon)
	driver.findElementByXPath("//input[@id='vendorName']").sendKeys("Blue Lagoon");
	
	//Click Search
	driver.findElementByXPath("//button[@id='buttonSearch']").click();
	//Find the Country Name based on the Vendor
	//Find the Country Name based on the Vendor		
	String country = driver.findElementByXPath("(//table[@class='table']//tr/td)[5]").getText();		
			
	System.out.println("Blue Lagoon vendor country is "  +country);
			
	//Click Logout button
	driver.findElementByXPath("//a[text()='Log Out']").click();
			
	//Close browser
	driver.close();
    }
	
	}

