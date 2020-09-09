package Workout;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MakeMyTrip 
{
	
	public static void main(String[] args) throws InterruptedException, IOException 
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/Drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().deleteAllCookies(); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com/ ");
		//System.out.println(getTitle());
		// Click Hotels
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement element = driver.findElement(By.xpath("//span[@class='chNavIcon appendBottom2 chSprite chHotels']"));
		js.executeScript("arguments[0].click();", element);
		Thread.sleep(2000);
		  driver.findElementByXPath("(//div[@class='makeFlex'])//div/label/input[@id='city']").sendKeys("");
		  Thread.sleep(2000);
	
		  //Enter city as Goa,
		  driver.findElementByXPath("//div[@class='hsw_autocomplePopup locus autoSuggestPlugin']/div/input").sendKeys("GOA");
		  Thread.sleep(2000);
		  // choose Goa, India
		  driver.findElementByXPath("//div[@class='hsw_autocomplePopup locus autoSuggestPlugin']/div/input").sendKeys( Keys.ARROW_DOWN,Keys.ENTER);
		  Thread.sleep(3000);
		 // driver.findElementByXPath("//input[@id='checkin']").click();
		  driver.findElementByXPath("(//div[text()='15'])[1]").click();
		  WebDriverWait wait2 = new WebDriverWait(driver, 10);
		  wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("navigationPageButton")));
	}
}

