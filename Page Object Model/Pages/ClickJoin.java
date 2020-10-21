package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Reporter;

import Base.ProjectSpecificMethodsOlay;

public class ClickJoin extends ProjectSpecificMethodsOlay
{
	
public LoginPages clickJoinButton() 
{
	
	JavascriptExecutor jse6 = (JavascriptExecutor) driver;
	jse6.executeScript("window.scrollBy(0,10000)", "");
	String url=driver.getCurrentUrl();
	
	if(url.contains("https://olay.co.uk/"))
	{
		driver.findElement(By.xpath("//*[contains(@class,'event_profile_register')]")).click();
		Reporter.log("Navigate from Home Page to Login Page");
		}
		else if(url.contains("https://olay.es/"))
		{
			driver.findElement(By.xpath("//*[contains(@class,'event_profile_register')]")).click();
			Reporter.log("Navigate from Home Page to Login Page");
		driver.findElement(By.xpath("(//button[@id='onetrust-accept-btn-handler'])[1]")).click();
	}
	else if(url.contains("https://www.olaz.de/de-de"))
	{
		driver.findElement(By.xpath("(//*[contains(@class,'event_profile_register')])[2]")).click();
		
		Reporter.log("Navigate from Home Page to Login Page");
		driver.findElement(By.xpath("(//button[@id='onetrust-accept-btn-handler'])[1]")).click();
	}
	else if(url.contains("https://www.olay.es/es-es"))
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,20000)");
		driver.findElement(By.xpath("(//button[contains(@class,'event_profile_register')])[3]")).click();
		Reporter.log("Navigate to Login Page");
		driver.findElement(By.xpath("(//button[@id='onetrust-accept-btn-handler'])[1]")).click();
	}
	
	return new LoginPages();
}
}
