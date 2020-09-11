package Week4.Day1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForAlert 
{
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./Drivers/Drivers/chromedriver1.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.leafground.com/home.html");
		driver.findElementByXPath("//h5[text()='Wait for Alert']").click();
		driver.findElementByXPath("//button[@id='alert']").click();
		try
		{
			WebDriverWait wait=new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.alertIsPresent());
			
			Alert alert = driver.switchTo().alert();
			System.out.println("The Alert text is "+alert.getText());
			alert.accept();
		}
		catch(NoAlertPresentException noAlert)
		{
			noAlert.getMessage();
		}
}
}