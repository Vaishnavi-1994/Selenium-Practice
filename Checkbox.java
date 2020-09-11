package Week2.Day2;

import java.awt.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment2 
{
public static void main(String[] args) throws InterruptedException
{
	
	
	System.setProperty("webdriver.chrome.driver", "./Drivers/Drivers/chromedriver.exe");
	ChromeDriver driver=new ChromeDriver();
	
	driver.get("http://leafground.com/pages/checkbox.html");
	
	driver.findElementByXPath("//div[text()='Java']").click();
	Thread.sleep(2000);
	
	
	boolean check=driver.findElementByXPath("//div[text()='Selenium']") != null;
	
	if(check==true)
	{
		System.out.println("Selecnium checkbox is selected");

	}
	else
	{
		System.out.println("Selenium checkbox is not selected");
	}
	driver.findElementByXPath("//input[1]").click();
	
	boolean check1=driver.findElementByXPath("(//input)[7]").isSelected();
	
		if(check1==true)
		{
			driver.findElementByXPath("(//input)[7]").click();
		}
		else
		{
			driver.findElementByXPath("(//input)[8]").click();
		}
	
		java.util.List<WebElement> selectAll = driver
				.findElementsByXPath("//label[contains(text(),'Select all')]/parent::div//input");
		for (WebElement sAll : selectAll) {
			sAll.click();
		}
		
		//driver.close();
	
	

}
}
