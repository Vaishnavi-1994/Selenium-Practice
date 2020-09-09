package Workout;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Azure 

{
	public static void checkfiles(String filename) 
	{
		File f = new File("C:\\Users\\goben\\" + filename);

		if (f.exists() == true) 
		{
			System.out.println("File downloaded sucessfully");
		} else
		{
			System.out.println("File not downloaded");
		}
	}
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/Drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().deleteAllCookies(); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://azure.microsoft.com/en-in/");
		Thread.sleep(2000);
		//Click on Pricing
		driver.findElementByXPath("//a[text()='Pricing']").click();
		Thread.sleep(2000);
		//Click on Pricing Calculator
		driver.findElementByXPath("(//ul[@class='linkList initial-list']/li)[2]").click();
		//Click on Containers
		driver.findElementByXPath("(//div[@class='category-container'])[8]/button").click();
		//Select Container Instances
		driver.findElementByXPath("(//span[text()='Container Instances'])[3]").click();
		//Click on Container Instance Added View
		WebDriverWait wait=new WebDriverWait(driver,50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("new-module-loc"))).click();
		//Select Region as "South India"
		Select dropDown1=new Select(driver.findElementByXPath("(//select[@class='select'])[1]"));
		dropDown1.selectByVisibleText("South India");
		//Set the Duration as 180000 seconds
		driver.findElementByXPath("(//input[@name='seconds'])[1]").clear();
		Thread.sleep(2000);
		driver.findElementByXPath("(//input[@name='seconds'])[1]").sendKeys(Keys.BACK_SPACE);
		driver.findElementByXPath("(//input[@name='seconds'])[1]").sendKeys("18000");
		//Select the Memory as 4GB
		Select dropDown2=new Select(driver.findElementByXPath("(//select[@name='memory'])[1]"));
		dropDown2.selectByVisibleText("4 GB");
		//Enable SHOW DEV/TEST PRICING
		driver.findElementByXPath("//button[@name='devTestSelected']").click();
		//Select Indian Rupee  as currency
		Select dropDown3=new Select(driver.findElementByXPath("//select[@class='select currency-dropdown']"));
		dropDown3.selectByValue("INR");
		//Print the Estimated monthly price
		String monthlyPrice = driver.findElementByXPath("(//span[@class='numeric'])[6]").getText().replaceAll("[^0-9,.]","");
		System.out.println("The monthly estimated cost is Rs."+monthlyPrice);
		// Click on Export to download the estimate as excel
		driver.findElementByXPath("//button[@class='calculator-button button-transparent export-button']").click();
		Thread.sleep(2000);
		//verify the downloded file in the local folder
		checkfiles("ExportedEstimate.xlsx");
	
}
	}
