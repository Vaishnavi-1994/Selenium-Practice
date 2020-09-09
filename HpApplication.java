package Workout;

import java.awt.AWTException;
import java.awt.List;
import java.awt.Robot;
import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;
import java.io.File;
import org.apache.commons.io.FileUtils;
import org.bson.Document;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.errorprone.annotations.Var;
import com.graphbuilder.curve.Point;
import com.mongodb.MapReduceCommand.OutputType;

public class HpApplication {
	public static void main(String[] args) throws InterruptedException, Throwable {

		System.setProperty("webdriver.chrome.driver", "./Drivers/Drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Go to URL
		driver.get("https://store.hp.com/in-en/");
		driver.navigate().refresh();
		Thread.sleep(2000);
		// accept cookies
		try {
			Thread.sleep(2000);
			WebElement cookies = driver.findElementByXPath("//button[@class='optanon-allow-all accept-cookies-button']");
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.elementToBeClickable(cookies)).click();
			Thread.sleep(2000);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		/*
		 * try{ driver.findElement(By.xpath("//div[@id='inside_tabs']")); } catch
		 * (ElementNotFoundException e){ if !closethepopup(){print ('Element not
		 * found')} } catch (GeneralException ge){ }
		 */
		/*
		 * try {
		 * 
		 * Delayed delayedClicker = new DelayedClicker(getDriver(),xpath, 30,
		 * log,EnumXpath.POPUP_WINDOW_TITLE, null); ((Thread) delayedClicker).start();
		 * WebElement button = getDriver().findElement(...))); button.click();
		 * 
		 * //WebElement iframeMsg =
		 * driver.findElement(By.xpath("//div[@id='inside_tabs']"));
		 * //driver.switchTo().frame(iframeMsg);
		 * 
		 * WebElement body = driver.findElement(By.cssSelector("body"));
		 * System.out.println(body.getText()); //driver.switchTo().frame(); WebElement
		 * closeBox=driver.
		 * findElementByXPath("//div[@class='inside_closeButton fonticon icon-hclose']"
		 * ); WebDriverWait wait1=new WebDriverWait(driver,60);
		 * wait1.until(ExpectedConditions.elementToBeClickable(closeBox)).click();
		 * 
		 * } catch(Exception e) { e.printStackTrace(); }
		 */
		driver.findElementByXPath("//div[@class='header content']").click();
		// Go to laptops
		WebElement laptops= driver.findElement(By.xpath("(//a[@class='level-top ui-corner-all has-dropdown-menu'])[2]"));
		Actions builder = new Actions(driver);
		builder.moveToElement(laptops).build().perform();
		// click on Pavilion
		driver.findElement(By.xpath("(//span[text()='Pavilion'])[1]")).click();
		Thread.sleep(3500);
		// Under SHOPPING OPTIONS-->Processor
		
		
		if (driver.findElementByXPath("//span[text()='Intel Core i5']").isDisplayed()) {
			driver.findElementByXPath("//span[text()='Intel Core i5']").click();
			
			
			Thread.sleep(3500);
		} else if (driver.findElementByXPath("(//span[text()='Processor'])[2]").isDisplayed()) {
			driver.findElementByXPath("(//span[text()='Processor'])[2]").click();
			driver.findElementByXPath("//span[text()='Intel Core i5']").click();
			Thread.sleep(3500);
		}

		else {

			driver.findElementByXPath("(//span[text()='Processor'])[1]").click();
			driver.findElementByXPath("(//span[text()='Processor'])[2]").click();
			driver.findElementByXPath("//span[text()='Intel Core i5']").click();

		}

		Thread.sleep(5000);
		// Hard Drive Capacity-->500GB to 1TB
		if (driver.findElementByXPath("//span[text()='500 GB to 1 TB']").isDisplayed()) {
			driver.findElementByXPath("//span[text()='500 GB to 1 TB']").click();
		} else if (driver.findElementByXPath("//span[text()='Hard Drive Capacity']").isDisplayed()) {
			Thread.sleep(2000);
			driver.findElementByXPath("//span[text()='500 GB to 1 TB']").click();
		} else {
			driver.findElementByXPath("//span[text()='Hard Drive Capacity']").click();
			Thread.sleep(2000);
			driver.findElementByXPath("//span[text()='500 GB to 1 TB']").click();
		}
		Thread.sleep(2000);
		// Identify the first product which is having in Stock
		String firstproduct = driver.findElementByXPath("//div[@class='product details product-item-details']//a")
				.getText();
		System.out.println("The first product is " + firstproduct);
		// Print the Product Name and Price

		String price1 = driver.findElementByXPath("(//span[@class='price-wrapper ']//span[@class='price'])[1]")
				.getText().replaceAll("[^0-9]", "");
		int price = Integer.parseInt(price1);
		System.out.println("The " + firstproduct + " and the price is Rs." + price);
		Thread.sleep(2000);
		// Click on Add to Cart
		driver.findElementByXPath("//span[text()='In Stock']/following::span[text()='Add To Cart']").click();
		Thread.sleep(4000);
		// Click on Shopping Cart icon
		driver.findElementByXPath("//a[@class='action showcart']").click();
		Thread.sleep(2000);
		// Click on View and Edit Cart
		driver.findElementByXPath("//a[@class='action primary viewcart']").click();
		// Check the Shipping Option-->Check availability at Pincode
		driver.findElementByXPath("//input[@name='pincode']").sendKeys("600119");
		// check button
		driver.findElementByXPath("//button[@class='primary standard_delivery-button']").click();
		// Verify the order Total against the product price
		String fPrice = driver.findElementByXPath("(//span[@class='price'])[7]").getText().replaceAll("[^0-9]", "");
		// System.out.println(fPrice);
		Thread.sleep(2000);
		WebElement proceed = driver.findElementByXPath("(//span[text()='Proceed to Checkout'])[2]");
		int finalPrice = Integer.parseInt(fPrice);
		Thread.sleep(2000);
		if (finalPrice == price) {
			System.out.println("The final price Rs." + finalPrice + " is equal to basic price");
			
			WebDriverWait waitproceed=new WebDriverWait(driver,60);
			waitproceed.until(ExpectedConditions.elementToBeClickable(proceed)).click();
			
		} else
			System.out.println("The prices are not matched");
		// Take snapshot of the Order Summary
		
		// WebElement orderSummary
		// =driver.findElementByXPath("//div[@class='opc-block-summary step-content']");
		// File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		// File target=new File("./snaps/elements.jpg");
		// FileUtils.copyFile(source,target,true);
		Thread.sleep(2000);
		WebElement OrdSummary = driver.findElementByXPath("//div[@class='col-mp mp-12']");
		WebDriverWait waitOrder=new WebDriverWait(driver,60);
		waitOrder.until(ExpectedConditions.visibilityOf(OrdSummary));
		Thread.sleep(3000);
		File src = OrdSummary.getScreenshotAs(OutputType.FILE);
		File dest = new File("src/main/java/LaptopOrder.png");
		FileUtils.copyFile(src, dest);
	}
}