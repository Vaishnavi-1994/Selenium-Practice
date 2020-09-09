package Workout;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AngularApplication
{
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/Drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().deleteAllCookies(); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://juliemr.github.io/protractor-demo/");
		driver.findElementByXPath("//input[@ng-model='first']").sendKeys("5");
		Select operator=new Select(driver.findElementByXPath("//select[@ng-model='operator']"));
		operator.selectByValue("MULTIPLICATION");
		driver.findElementByXPath("//input[@ng-model='second']").sendKeys("5");
		driver.findElementById("gobutton").click();
		WebElement result = driver.findElementByXPath("//h2[@class='ng-binding']");
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.textToBePresentInElement(result,"25"));
		System.out.println(result.getText());
		driver.close();
		
		
		
	
	
		
}
}
