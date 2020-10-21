package Assigment1Vaishnavi;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
@Test (priority=2)
public class VaishnaviSelectable extends CrossBrowserScript
{
	
public void vaishnaviSelectable() throws InterruptedException 
{
		
	//launch the browser
		/*
		 * System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		 * ChromeDriver driver=new ChromeDriver();
		 */
	//maximize the browser
	driver.manage().window().maximize();
	
	//Open Url
	driver.get("https://demoqa.com/selectable/");
	
	//get the size of list items
	List<WebElement> element=driver.findElements(By.xpath("(//ul[@id='verticalListContainer']/li)"));
		
	//Selected using by loop
	for (int i = 1; i <=element.size(); i++) 
	{
	driver.findElement(By.xpath("(//ul[@id='verticalListContainer']/li)["+i+"]"));
	}		
	
	//Go to grid tab
	driver.findElement(By.id("demo-tab-grid")).click();
	
	//get Grid element size
	List<WebElement> gridElements=driver.findElements(By.xpath("//div[@class='grid-container mt-4']/div/li"));
	
	//Select the elements
	for (int i = 1; i <=gridElements.size(); i++)
	{
	driver.findElement(By.xpath("(//div[@class='grid-container mt-4']/div/li)["+i+"]")).click();
	}
	

}
}
