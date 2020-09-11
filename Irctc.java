package Week4.Day1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Irctc 
{
	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "./Drivers/Drivers/chromedriver1.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.irctc.co.in/nget/train-search");
		Thread.sleep(1000);
		driver.findElementByXPath("//button[text()='Ok']").click();
		Thread.sleep(1000);
		driver.findElementByPartialLinkText("FLIGHTS").click();
		Set<String> firstAndSecond = driver.getWindowHandles();
		List<String> listHandles = new ArrayList<String>(firstAndSecond);
		String secondWindow=listHandles.get(1);
		driver.switchTo().window(secondWindow);
		//System.out.println()driver.get;
		Thread.sleep(1000);
		driver.findElementByXPath("(//div[@class='custom-control custom-checkbox'])[2]").click();
		driver.findElementByXPath("//button[text()='Continue ']").click();
		File source = driver.getScreenshotAs(OutputType.FILE);
		File target = new File("./snapstest/Flights.png");
		FileUtils.copyFile(source, target);
		driver.switchTo().window(listHandles.get(0));
		driver.close();
		
		
}
}