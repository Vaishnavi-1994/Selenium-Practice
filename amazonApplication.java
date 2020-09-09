package Workout;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class amazonApplication 
{
	@Test 
	//public static String productPrice;
public static void main(String[] args) throws InterruptedException
{
	System.setProperty("webdriver.chrome.driver", "./Drivers/Drivers/chromedriver.exe");
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--disable-notifications");
	ChromeDriver driver = new ChromeDriver(options);
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	// Go to URL
	driver.get("https://www.amazon.in/");
	Thread.sleep(2000);
	System.out.println(driver.getTitle());
	//Search box
	driver.findElementById("twotabsearchtextbox").sendKeys("LG Smart Tv");
	//search option
	driver.findElementByXPath("(//input[@class='nav-input'])[1]").click();
	Thread.sleep(2000);
	ArrayList<WebElement> product = (ArrayList<WebElement>) driver.findElementsByXPath("(//div/h2/a/span)");
		/*
		 * ArrayList<String> product = new ArrayList<>();
		 * System.out.println(driver.getTitle()); do { List<WebElement> tempProductsss =
		 * (ArrayList<WebElement>) driver.findElementsByXPath("(//div/h2/a/span)"); int
		 * temp=tempProductsss.size(); System.out.println(temp);
		 * 
		 * System.out.println("The product count is "+tempProductsss.size());
		 * driver.findElementByXPath("//a[text()='Next']").click(); }
		 * while(driver.findElementByXPath("//a[text()='Next']").isDisplayed());
		 */
	ArrayList<String> webElementList = new ArrayList<>();
	//ArrayList<String> priceList = new ArrayList<>();
	//to store the data in to List
	
	for (int i = 1; i <=product.size(); i++) 
	{
		String tempProduct=driver.findElementByXPath("(//div/h2/a/span)["+i+"]").getText();
		if(tempProduct.contains("LG"))
		{
			webElementList.add(tempProduct);
			
		}
			
	}
	
	//Size of List
		System.out.println("The size of Product count is "+webElementList.size());
		//Print the product name and price
		for (int i=0;i<webElementList.size();i++) 
		{
			try
			{
			if(driver.findElementByXPath("//SPAN[@class='a-size-medium a-color-base a-text-normal'][text()='"+webElementList.get(i)+"']").isDisplayed())
			{
				try
				{
					WebDriverWait wait=new WebDriverWait(driver,10);
					wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//SPAN[@class='a-size-medium a-color-base a-text-normal'][text()='"+webElementList.get(i)+"']/../../../../../../..//SPAN[@class='a-price-whole']")));
				String productPrice = driver.findElementByXPath("//SPAN[@class='a-size-medium a-color-base a-text-normal'][text()='"+webElementList.get(i)+"']/../../../../../../..//SPAN[@class='a-price-whole']").getText().replaceAll("[^0-9]","");
				System.out.println("No."+i+"The product is "+webElementList.get(i)+"\n and amount Rs."+productPrice);
				}
			
			catch(Exception e) 
				{
						 e.printStackTrace();
						 System.out.println("There is no price for element "+webElementList.get(i));
				}
			}
			}
			catch(Exception e)
			{
				System.out.println("Leave it");
				}
		}
	
	
	

	

	
		
	
}
}
