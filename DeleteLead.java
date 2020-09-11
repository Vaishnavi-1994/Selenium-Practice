package Week5;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

@Test
public class DeleteLead extends WorkSuite
{

	public void runDeleteLead() throws InterruptedException 
	{
		/*
		 * // Launch the browser System.setProperty("webdriver.chrome.driver",
		 * "./Drivers/Drivers/chromedriver.exe"); ChromeDriver driver = new
		 * ChromeDriver();
		 * 
		 * // Go to URL driver.get("http://leaftaps.com/opentaps/control/main");
		 * driver.manage().window().maximize(); // Enter the username
		 * driver.findElementByXPath("//form[@id='login']//input").sendKeys(
		 * "Demosalesmanager"); // Enter the password
		 * driver.findElementByXPath("(//p)[2]/input[@id='password']").sendKeys("crmsfa"
		 * ); // Click Login driver.findElementByXPath("(//input)[3]").click(); // Click
		 * crm/sfa link driver.findElementByXPath("//div[@id='label']").click();
		 */
			// Click Leads link
			driver.findElementByXPath("(//div[@class='x-panel-header'])[2]").click();
			// Click Find leads
			driver.findElementByLinkText("Find Leads").click();
			driver.findElementByXPath("//span[text()='Phone']").click();
			driver.findElementByXPath("//input[@name='phoneNumber']").sendKeys("98");
			Thread.sleep(2000);
			//Click find leads button
			driver.findElementByXPath("(//button[@class='x-btn-text'])[7]").click();
			Thread.sleep(2000);
			String capturedNum=driver.findElementByXPath("(//a[@class='linktext'])[4]").getText();
			Thread.sleep(2000);
			driver.findElementByXPath("(//a[@class='linktext'])[4]").click();
			//Capture lead ID of First Resulting lead
			System.out.println("The First captured Lead Id is " +capturedNum);
			//Click Delete
			driver.findElementByXPath("//a[@class='subMenuButtonDangerous']").click();
			//Click Find leads
			driver.findElementByXPath("//a[text()='Find Leads']").click();
			Thread.sleep(2000);
			driver.findElementByXPath("//input[@name='id']").sendKeys(capturedNum);
			driver.findElementByXPath("(//button[@class='x-btn-text'])[7]").click();
			String verify=driver.findElementByXPath("//div[@class='x-paging-info']").getText();
			System.out.println(verify);
			//driver.close();
	}		
	}

