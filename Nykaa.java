package Week4.Day1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Nykaa 
{
	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "./Drivers/Drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.nykaa.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement brands = driver.findElementByXPath("//a[text()='brands']");
		Actions builder=new Actions(driver);
		builder.moveToElement(brands).perform();
		WebElement popular = driver.findElementByXPath("//a[text()='Popular']");
		Actions builder1=new Actions(driver);
		builder1.moveToElement(popular).build().perform();
		driver.findElementByXPath("(//li[@class='brand-logo menu-links'])[5]/a").click();
		////Go to the newly opened window,
		Set<String> firstAndSecond = driver.getWindowHandles();
		List<String> listHandles = new ArrayList<String>(firstAndSecond);
		driver.switchTo().window(listHandles.get(1));
		// check the Page title contains L'Oreal Paris
	String title=driver.getTitle();
	if(title.contains("L'Oreal Paris"))
	{
		System.out.println("Title has contains L'Oreal Paris products");
	}
	else
		System.out.println("Wrong Title");
	
	//close the first window
	driver.switchTo().window(listHandles.get(0));
	driver.close();
	//Click sort By
	driver.switchTo().window(listHandles.get(1));
	driver.findElementByXPath("//span[text()='Sort By : ']").click();
	// and select customer top rated
	driver.findElementByXPath("//span[text()='customer top rated']").click();
	//Click Category 
	driver.findElementByXPath("(//div[@class='brd-sep'])[1]").click();
	//and click Shampoo
	driver.findElementByXPath("(//label[@for='chk_Shampoo_undefined'])[1]").click();
	Thread.sleep(2000);
	//Click the first listed item
	
	driver.findElementByXPath("(//h2)[1]").click();
	// GO to the new window
	Set<String> secondAndThird = driver.getWindowHandles();
	List<String> listHandles1 = new ArrayList<String>(secondAndThird);
	driver.switchTo().window(listHandles1.get(1));
	//click add to bag
	driver.findElementByXPath("//button[text()='ADD TO BAG']").click();
	//Go to Shopping Bag 
	driver.findElementByXPath("//div[@class='AddBagIcon']").click();
	//click Proceed
	driver.findElementByXPath("//div[@class='second-col']").click();
	//Print the error message
	String popUp = driver.findElementByXPath("//div[@class='popup-error']").getText();
	System.out.println(popUp);
	//popUp
	driver.quit();
}
}