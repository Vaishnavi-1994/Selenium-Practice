package Week2.Day1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment4 
{
public static void main(String[] args) throws InterruptedException
{
	System.setProperty("webdriver.chrome.driver", "./Drivers/Drivers/chromedriver1.exe");
	ChromeDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://www.leafground.com/pages/Link.html");
	driver.findElementByXPath("(//a)[1]").click();
	driver.findElementByXPath("//h5[text()='HyperLink']").click();
	String strValue = driver.findElementByLinkText("Find where am supposed to go without clicking me?").getAttribute("href");
	System.out.println("The page navigate to "+strValue);
	//verify 
	driver.findElementByPartialLinkText("Verify").click();
	String error = driver.getTitle();
	if (error.contains("404")) {
		System.out.println("Link is broken. Error: " + error);
	} else {
		System.out.println("Link is not broken");
	}
driver.navigate().back();

driver.findElementByXPath("(//a[text() = 'Go to Home Page'])[2]").click();
System.out.println("clicked link : Find where am supposed to go without clicking me? ");
Thread.sleep(1000);
driver.navigate().back();

List<WebElement> allLinks = driver.findElements(By.tagName("a"));
System.out.println("Total Links: " + allLinks.size());

driver.close();
}
}
