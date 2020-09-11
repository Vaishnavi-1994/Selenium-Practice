package Week5;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class WorkSuite 
{
	public ChromeDriver driver;
	@BeforeSuite
	public void Login() 
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/Drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		// Go to URL
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		// Enter the username
		driver.findElementByXPath("//form[@id='login']//input").sendKeys("Demosalesmanager");
		// Enter the password
		driver.findElementByXPath("(//p)[2]/input[@id='password']").sendKeys("crmsfa");
		// Click Login
		driver.findElementByXPath("(//input)[3]").click();
		// Click crm/sfa link
		driver.findElementByXPath("//div[@id='label']").click();
	}
	
	@AfterSuite
	public void closeBrowser()
	{
		driver.close();
	}
	

	}
	
