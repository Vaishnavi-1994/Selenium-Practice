package Week5;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DuplicateLead extends WorkSuite
{
		public void run() throws InterruptedException
{
			

		/*
		 * // Launch the browser System.setProperty("webdriver.chrome.driver",
		 * "./Drivers/Drivers/chromedriver1.exe"); ChromeDriver driver = new
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
			driver.findElementByXPath("//span[text()='Email']").click();
			driver.findElementByXPath("//input[@name='emailAddress']").sendKeys("testleaf@gmail.com");	
			driver.findElementByXPath("(//button[@class='x-btn-text'])[7]").click();
			
		
			Thread.sleep(2000);
			driver.findElementByXPath("(//a[@class='linktext'])[4]").click();	
			String capturename=driver.findElementByXPath("//span[@id='viewLead_firstName_sp']").getText();
			//System.out.println(capturename);
			driver.findElementByXPath("(//a[@class='subMenuButton'])[1]").click();
			WebElement title=driver.findElementByXPath("//div[@class='x-panel-header sectionHeaderTitle']");
			driver.getTitle();
			System.out.println(driver.getTitle());
			driver.findElementByXPath("//input[@name='submitButton']").click();
			String viewLead=driver.findElementByXPath("//span[@id='viewLead_firstName_sp']").getText();
			
			if(capturename.contentEquals(viewLead));
			{
				System.out.println("The duplicate name is same as captured name");
			}
			
	}
	}

