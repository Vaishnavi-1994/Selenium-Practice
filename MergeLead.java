package Week5;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

@Test
public class MergeLead extends WorkSuite
{
public void Mergelead() throws InterruptedException
		{
		/*
		 * System.setProperty("webdriver.chrome.driver",
		 * "./Drivers/Drivers/chromedriver.exe"); ChromeDriver driver=new
		 * ChromeDriver(); // Launch URL "http://leaftaps.com/opentaps/control/login"
		 * driver.get("http://leaftaps.com/opentaps/control/main");
		 * driver.manage().window().maximize(); //Enter UserName and Password Using Id
		 * Locator WebElement username=driver.findElementById("username");
		 * username.sendKeys("Demosalesmanager");
		 * driver.findElementById("password").sendKeys("crmsfa"); //Login Button using
		 * Class Locator driver.findElementByClassName("decorativeSubmit").click();
		 * //Click on CRM/SFA Link driver.findElementByPartialLinkText("CRM").click();
		 */
			//Click on contacts Button
			driver.findElementByLinkText("Contacts").click();
			//Click on Merge Contacts using Xpath Locator
			driver.findElementByXPath("//a[text()='Merge Contacts']").click();
			//Click on Widget of From Contact
			Thread.sleep(1000);
			WebElement firstWidget = driver.findElementByXPath("(//a)[35]");
			Actions builder=new Actions(driver);
			builder.click(firstWidget).perform();
			Thread.sleep(1000);
			Set<String> firstAndSecond = driver.getWindowHandles();
			List<String> windowList = new ArrayList<String>(firstAndSecond);
			driver.switchTo().window(windowList.get(1));
		
			//Click on First Resulting Contact
			driver.findElementByXPath("(//a[@class='linktext'])[1]").click();
			//Click on Widget of To Contact
			driver.switchTo().window(windowList.get(0));
			driver.findElementByXPath("(//a)[36]").click();
			//Click on Second Resulting Contact
			Thread.sleep(1000);
			Set<String> firstAndThird = driver.getWindowHandles();
			List<String> windowList1 = new ArrayList<String>(firstAndThird);
			driver.switchTo().window(windowList1.get(1));
			
			driver.findElementByXPath("//a[@class='linktext']").click();
			driver.switchTo().window(windowList1.get(0));
			//Click on Merge button using Xpath Locator
			driver.findElementByXPath("//a[@class='buttonDangerous']").click();
			//Accept the Alert	
			Thread.sleep(1000);
			Alert alert=driver.switchTo().alert();
			alert.accept();
			Thread.sleep(1000);
			
			//Verify the title of the page
			String title=driver.getTitle();
			
			if(title.contains("Merge Contacts"))
			{
				System.out.println("Title of the page is "+title);
			}
			else 
				System.out.println("Wrong Title");
			driver.close();
	}

	}


