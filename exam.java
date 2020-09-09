package Workout;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class exam {
	
	public static WebDriverWait wait;
	public static JavascriptExecutor js;
	public static Actions builder;
	
	public static void main(String[] args) throws InterruptedException 
	{
	
		/*  
			1) Go to https://www.bigbasket.com/
			2) mouse over on  Shop by Category 
			3) Go to Beverages and Fruit juices & Drinks
			4) Click on JUICES
			5) click Tropicana and Real under Brand
			6) Check count of the products from each Brands and total count
			6) Check whether the products is availabe with Add button.
			7) Add the First listed available product 
			8) click on Change Address 
			9) Select CHennai as City, Alandur-600016,Chennai as Area  and click Continue
			10) Mouse over on My Basket print the product name. count and price.
			11) Click View Basker and Checkout
			12) Click the close button and close the browser
		*/  
		
		
		System.setProperty("webdriver.chrome.driver", "./Drivers/Drivers/chromedriver.exe");
		ChromeDriver cdriver = new ChromeDriver();
		
		// disable notifications
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		//Get URL
		
		cdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		cdriver.manage().window().maximize();
		cdriver.get("https://www.bigbasket.com/");
		//cdriver.manage().deleteAllCookies();
		Thread.sleep(2000);
		
		builder = new Actions(cdriver);
		//WebElement shopByCategory = cdriver.findElementByXPath("//a[text()=' Shop by Category ']");
		WebElement shopByCategory = cdriver.findElementByXPath("//a[@class='dropdown-toggle meganav-shop']");
		Thread.sleep(5000);
		//wait.until(ExpectedConditions.elementToBeClickable(shopByCategory));
		builder.moveToElement(shopByCategory).pause(2000).perform();
			
		//Go to Beverages and Fruit juices & Drinks
		WebElement beverages = cdriver.findElementByXPath("(//a[@href='/cl/beverages/?nc=nb'])[2]");
		builder.moveToElement(beverages).pause(3000).perform();
		WebElement fruiJuices = cdriver.findElementByXPath("(//a[@href='/pc/beverages/fruit-juices-drinks/?nc=nb'])[2]");
		builder.moveToElement(fruiJuices).click(fruiJuices).perform();
		Thread.sleep(5000);
		
		//selecting Tropicana
		WebElement tropicana = cdriver.findElementByXPath("(//span[text()='Tropicana'])[1]");
		tropicana.click();
		String prod1Name = tropicana.getText();
	
		Thread.sleep(5000);
		//getting count of first product selected
		String prodCount = cdriver.findElementByXPath("//h2[@qa='pageName']").getText();
		int len = prodCount.length();
		String firstCount = prodCount.substring(23, len-1);
		System.out.println("No of "+prod1Name+" products available is: "+firstCount);
		
	
		//Selecting Real 
		WebElement real = cdriver.findElementByXPath("(//span[text()='Real'])[1]");
		real.click();
		String prod2Name = real.getText();
		
		
		//getting the count of second product and overall count
		Thread.sleep(5000);
		String allCount = cdriver.findElementByXPath("//h2[@qa='pageName']").getText();
		int len1 = allCount.length();
		String totalCount = allCount.substring(23, len-1);
		int secondCount = Integer.parseInt(totalCount) - Integer.parseInt(firstCount);
		System.out.println("No of "+prod2Name+" products available is: "+secondCount);
		System.out.println("Total Available products is "+totalCount);
		
		
		//check if add button is enabled?
		List<WebElement> availableProducts = cdriver.findElements(By.xpath("//div[@class='col-xs-12 bskt-opt ng-scope']"));		
		int size = availableProducts.size();
		System.out.println("There are only "+size+" products displayed to the user.");
		
		List<WebElement> addEnabled = cdriver.findElements(By.xpath("//button[@qa='add']"));
		int enabled = addEnabled.size();
		System.out.println(enabled+" out of "+size+ " products has ADD button ENABLED");
		
		List<WebElement> addDisabled = cdriver.findElements(By.xpath("//div[@class='col-xs-12 bskt-opt ng-scope']//button[@qa='NM']"));
		int disabled = addDisabled.size();
		System.out.println(disabled+" out of "+size+ " products has ADD button DISABLED");
		
		
		//clicking Add button
		cdriver.findElementByXPath("(//button[@qa='add'])[1]").click();
		
		//updating address
		Thread.sleep(2000);
		cdriver.findElementByXPath("(//a[text()='Change Location'])[1]").click();
		cdriver.findElementByXPath("(//input[@qa='areaInput'])[1]").sendKeys("Alandur");
		Thread.sleep(2000);
		cdriver.findElementByXPath("(//input[@qa='areaInput'])[1]").sendKeys(Keys.TAB);
		WebElement continueButton = cdriver.findElementByXPath("//button[@name='continue']");
		if(continueButton.isEnabled())
		{
			continueButton.click();
			System.out.println("Valid Address");
		}
		else
		{
			System.out.println(cdriver.findElementByXPath("(//p[@ng-show='vm.showError'])[1]").getText());
		}
		
		Thread.sleep(3000);
		
		
		//mouse hover on myBasket
		WebElement myBasket = cdriver.findElementByXPath("//a[@qa='myBasket']");
		builder.moveToElement(myBasket).pause(3000).perform();
		String productName = cdriver.findElementByXPath("(//a[@qa='prodNameMB'])[1]").getText();
		String count = cdriver.findElementByXPath("(//div[@qa='pcsMB'])[1]").getText();
		char finalCount = count.charAt(0);
		String productPrice = cdriver.findElementByXPath("(//span[@qa='priceMB'])[1]").getText();
		System.out.println("Product name is: "+productName);
		System.out.println("Product price is: "+productPrice);
		System.out.println("Product count is: "+finalCount);
				
		//clicking on view basket
		cdriver.findElementByXPath("(//button[@qa='viewBasketMB'])[1]").click();
		
		//closing the popup
		cdriver.findElementByXPath("(//button[@class='close'])[1]").click();
		
		// closes the window
		cdriver.close();
		

		
	}

}