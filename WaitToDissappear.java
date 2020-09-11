package Week4.Day1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitToDissappear 
{
	public static void main(String[] args) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "./Drivers/Drivers/chromedriver1.exe");
	ChromeDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://www.leafground.com/home.html");
	driver.findElementByXPath("//h5[text()='Wait to Disappear']").click();

	WebDriverWait wait=new WebDriverWait(driver,30);

	wait.until(ExpectedConditions.invisibilityOf(driver.findElementById("btn")));

	String text = driver.findElementByXPath("//div[@id = 'show']//strong").getText();
	
	System.out.println(text);
	
}
}