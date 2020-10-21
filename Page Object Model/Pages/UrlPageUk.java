package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Base.ProjectSpecificMethodsOlay;

public class UrlPageUk extends ProjectSpecificMethodsOlay
{
	
public ClickJoin putUrlUk()
{
	driver.get("https://olay.co.uk/");
	Reporter.log("***********************************************");
	Reporter.log("Website open for UK");
	Reporter.log("***********************************************");
	try 
	{
		driver.findElement(By.xpath("//button[contains(@id,'onetrust-accept-btn-handler')]")).click();
	} catch (Exception e) {
		e.printStackTrace();
	}
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,1000)");

	return new ClickJoin();
}


}