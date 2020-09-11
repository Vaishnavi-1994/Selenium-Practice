package Week4.Day1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class DragandDrop {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./Drivers/Drivers/chromedriver1.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
	driver.manage().window().maximize();
	driver.get("https://jqueryui.com/sortable/");
	driver.switchTo().frame(0);
WebElement source=driver.findElementByXPath("//li[text()='Item 1']");
WebElement target=driver.findElementByXPath("//li[text()='Item 4']");
	Actions builder=new Actions(driver);
	Thread.sleep(1000);
	//builder.dragAndDrop(source, target).perform();
	builder.click(source).clickAndHold().moveToElement(target).release().perform();
	

}
}
