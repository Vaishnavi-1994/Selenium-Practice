package Base;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class ProjectSpecificMethods 
{
	
public class ProjectSpecificMethods 
	{
		
	public static ChromeDriver driver;
	
	@BeforeMethod
	public void startApp()
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/Drivers/chromedriver1.exe"); 
		driver=new ChromeDriver(); 
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		
	}
	@AfterMethod
	public void closeBrowser() {
		System.out.println("Testcase End and runn success");
	}
	
	}
public class ProjectSpecificMethods 
{
	
public class ProjectSpecificMethods 
	{
		
	public static ChromeDriver driver;
	
	@BeforeMethod
	public void startApp()
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/Drivers/chromedriver1.exe"); 
		driver=new ChromeDriver(); 
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		
	}
	@AfterMethod
	public void closeBrowser() {
		System.out.println("Testcase End and runn success");
	}
	
	}
public static ChromeDriver driver;

@BeforeMethod
public void startApp()
{
	System.setProperty("webdriver.chrome.driver", "./Drivers/Drivers/chromedriver1.exe"); 
	driver=new ChromeDriver(); 
	driver.get("http://leaftaps.com/opentaps/control/main");
	driver.manage().window().maximize();
	
}
@AfterMethod
public void closeBrowser() {
	System.out.println("Testcase End and runn success");
}

}
public static ChromeDriver driver;

@BeforeMethod
public void startApp()
{
	System.setProperty("webdriver.chrome.driver", "./Drivers/Drivers/chromedriver1.exe"); 
	driver=new ChromeDriver(); 
	driver.get("http://leaftaps.com/opentaps/control/main");
	driver.manage().window().maximize();
	
}
@AfterMethod
public void closeBrowser() {
	System.out.println("Testcase End and runn success");
}

}
