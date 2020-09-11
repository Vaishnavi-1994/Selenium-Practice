package Week2.Day1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;
import org.openqa.selenium.support.ui.Select;

public class Assignment1 
{
	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","./Drivers/Drivers/chromedriver1.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		
		WebElement username=driver.findElementById("username");
		username.sendKeys("Demosalesmanager");
		driver.findElementById("password").sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();
		driver.findElementByPartialLinkText("CRM").click();
		driver.findElementByClassName("x-panel-header").click();
		driver.findElementByLinkText("Create Lead").click();
		driver.findElementById("createLeadForm_companyName").sendKeys("TestLeaf");
		Thread.sleep(2000);
		driver.findElementById("createLeadForm_firstName").sendKeys("Vaishnavi");
		Thread.sleep(2000);
		driver.findElementById("createLeadForm_lastName").sendKeys("Rajendran");
		Thread.sleep(2000);
	
		Thread.sleep(2000);
		WebElement source =driver.findElementById("createLeadForm_dataSourceId");
		Select dropDown=new Select(source);
		dropDown.selectByVisibleText("Conference");
		Thread.sleep(2000);
		
		WebElement MarketCampaign=driver.findElementById("createLeadForm_marketingCampaignId");
		Select dropDown1=new Select(MarketCampaign);
		dropDown1.selectByValue("9001");
		Thread.sleep(2000);
		
		WebElement ownership=driver.findElementById("createLeadForm_ownershipEnumId");
		Select dropDown2=new Select(ownership);
		dropDown2.selectByIndex(5);
		
		WebElement country =driver.findElementById("createLeadForm_generalCountryGeoId");
		Select dropDown3=new Select(country);
		dropDown3.selectByVisibleText("India");
	//	driver.findElementByXPath("(//input[@name='primaryEmail'])[4]").sendKeys("testleaf@gmail.com");
		
		Thread.sleep(2000);
				driver.findElementByName("submitButton").click();
		//driver.close();
	}

}	
