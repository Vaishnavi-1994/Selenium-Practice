package Week5;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

@Test
public class CreateLead extends WorkSuite
{
	public void runCreateLead()
	{
		/*
		 * System.setProperty("webdriver.chrome.driver",
		 * "./Drivers/Drivers/chromedriver.exe"); ChromeDriver driver=new
		 * ChromeDriver(); driver.get("http://leaftaps.com/opentaps/control/main");
		 * driver.manage().window().maximize();
		 * driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		 * 
		 * WebElement username=driver.findElementById("username");
		 * username.sendKeys("Demosalesmanager");
		 * driver.findElementById("password").sendKeys("crmsfa");
		 * driver.findElementByClassName("decorativeSubmit").click();
		 * driver.findElementByPartialLinkText("CRM").click();
		 */
			driver.findElementByClassName("x-panel-header").click();
			driver.findElementByLinkText("Create Lead").click();
			driver.findElementById("createLeadForm_companyName").sendKeys("TestLeaf");
			
			driver.findElementById("createLeadForm_firstName").sendKeys("Vaishnavi");
			
			driver.findElementById("createLeadForm_lastName").sendKeys("Rajendran");
			
		
			
			WebElement source =driver.findElementById("createLeadForm_dataSourceId");
			Select dropDown=new Select(source);
			dropDown.selectByVisibleText("Conference");
			
			
			WebElement MarketCampaign=driver.findElementById("createLeadForm_marketingCampaignId");
			Select dropDown1=new Select(MarketCampaign);
			dropDown1.selectByValue("9001");
			
			
			WebElement ownership=driver.findElementById("createLeadForm_ownershipEnumId");
			Select dropDown2=new Select(ownership);
			dropDown2.selectByIndex(5);
			
			WebElement country =driver.findElementById("createLeadForm_generalCountryGeoId");
			Select dropDown3=new Select(country);
			dropDown3.selectByVisibleText("India");
		//	driver.findElementByXPath("(//input[@name='primaryEmail'])[4]").sendKeys("testleaf@gmail.com");
			
			
					driver.findElementByName("submitButton").click();
			//driver.close();
		}

	}	

