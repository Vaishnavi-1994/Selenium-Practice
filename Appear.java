package Week4.Day1;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Appear {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./Drivers/Drivers/chromedriver1.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.leafground.com/home.html");
		driver.findElementByXPath("//h5[text()='Wait to Appear']").click();
	String beforText=driver.findElementByXPath("//div[@class='flex']").getText();
	//System.out.println("Before visibilityOf text is "+beforText);
	WebDriverWait wait=new WebDriverWait(driver,30);
	wait.until(ExpectedConditions.visibilityOf(driver.findElementById("btn")));
	String after=driver.findElementById("btn").getText();
	System.out.println("After the visibilityOf text is "+after);	
	
}
}