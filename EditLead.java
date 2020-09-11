package Week5;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class EditLead extends WorkSuite
{
	@Test
	public void	EditLead() throws InterruptedException
{
		/*
		 * System.setProperty("webdriver.chrome.driver",
		 * "./Drivers/Drivers/chromedriver1.exe"); ChromeDriver driver = new
		 * ChromeDriver(); driver.manage().window().maximize(); // Go to URL
		 * driver.get("http://leaftaps.com/opentaps/control/main");
		 * 
		 * // Enter the username
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
			// Enter first name
			driver.findElementByXPath("//span[text()='Name and ID']").click();
			driver.findElementByXPath("//label[contains(text(),'First name:')]/following::input[29]").sendKeys("Vaishnavi");

			driver.findElementByXPath("//button[text()='Find Leads']").click();
			Thread.sleep(5000);
			driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]").click();

			// Verify title of the page
			String title = driver.findElementByXPath("//div[@id='sectionHeaderTitle_leads']").getText();
			System.out.println("Title of the page is " + title);
			// Click Edit
			driver.findElementByXPath("//a[@class='subMenuButton'][3]").click();
			// Change the company name
			driver.findElementByXPath("//input[@id='updateLeadForm_companyName']").clear();
			driver.findElementByXPath("//input[@id='updateLeadForm_companyName']").sendKeys("Wipro");
			
			// Click Update
			driver.findElementByXPath("(//input[@class='smallSubmit'])[1]").click();
			// Confirm the changed name appears
			String updated = driver.findElementByXPath("//span[@id='viewLead_companyName_sp']").getText();
		
			
			if(updated.contains("Wipro"))
			{
				System.out.println("Company name updated as "+updated);
			}
		driver.close();
		}
		
	}


