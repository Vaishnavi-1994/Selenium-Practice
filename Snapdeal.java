package Week4.Day1;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Snapdeal 
{
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./Drivers/Drivers/chromedriver1.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
	driver.manage().window().maximize();
	driver.get("https://www.snapdeal.com/");
	WebElement men=driver.findElementByXPath("(//span[@class='catText'])[6]");
	
	Actions builder=new Actions(driver);
	builder.moveToElement(men).perform();
	Thread.sleep(1000);
	//builder.click().perform();
	driver.findElementByXPath("//a[text()='Shirts']").click();
	Thread.sleep(1000);
	WebElement qv=driver.findElementByXPath("//picture");
	builder.moveToElement(qv).perform();
	driver.findElementByXPath("//div[@class='center quick-view-bar  btn btn-theme-secondary  ']").click();
	driver.findElementByXPath("//div/i[@class='sd-icon sd-icon-delete-sign']").click();
	driver.quit();
	
	
	}
	
}
