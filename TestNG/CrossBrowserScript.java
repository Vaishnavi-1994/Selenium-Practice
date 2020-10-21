package Assigment1Vaishnavi;

import java.util.concurrent.TimeUnit;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class CrossBrowserScript
{
	public WebDriver driver;
	
	@BeforeClass
	@Parameters("browser")
	public WebDriver setup(String browser) throws Exception
	{
	if(browser.equalsIgnoreCase("firefox")){
		//create firefox instance
			System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver_64 bit.exe");
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		}
		//Check if parameter passed as 'chrome'
		else if(browser.equalsIgnoreCase("chrome")){
			//set path to chromedriver.exe
			System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
			//create chrome instance
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		}
		//Check if parameter passed as 'Edge'
				else if(browser.equalsIgnoreCase("Edge"))
				{
					//set path to Edge.exe
					System.setProperty("webdriver.edge.driver","./Drivers/MicrosoftWebDriver.exe");
					//create Edge instance
					driver = new EdgeDriver();
					driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
				}
		else{
			//If no browser passed throw exception
			throw new Exception("Browser is not correct");
		}
	return driver;
		
	}
	
	@AfterClass
	public void closeBrowser()
	{
		driver.close();
	}
	
}