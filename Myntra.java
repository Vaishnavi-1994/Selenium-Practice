package Week4.Day1;

import java.io.IOException;
import java.sql.Driver;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Myntra 
{
public static int productCount(String string)

{

	String totalproduct= string.replaceAll("[^0-9]", "");
	int numberonly=Integer.parseInt(totalproduct);
	return numberonly;
}
	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "./Drivers/Drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.myntra.com/");
		//Mouse over on WOMEN 
		WebElement women = driver.findElementByXPath("(//a[text()='Women'])[1]");
		Actions builder = new Actions(driver);
		builder.moveToElement(women).perform();
		Thread.sleep(1000);
		//Click Jackets & Coats
		//driver.findElementByLinkText("Shrugs").click();
		driver.findElementByLinkText("Jackets & Coats").click();
		Thread.sleep(1000);
		//Find the total count of item 
		String totalCount=driver.findElementByXPath("//span[@class='title-count']").getText();
		System.out.println("Total count of the products Jackets ans Coats : "+productCount(totalCount));
		//Validate the sum of categories count matches
		String totalJackets=driver.findElementByXPath("//div[@class='vertical-filters-filters categories-container']//label[@class='common-customCheckbox vertical-filters-label']").getText();
		System.out.println("Total count of the jackets "+productCount(totalJackets));
		String totalCoats=driver.findElementByXPath("(//div[@class='vertical-filters-filters categories-container']//label[@class='common-customCheckbox vertical-filters-label'])[2]").getText();
		System.out.println("Total count of the Coats : "+productCount(totalCoats));
		
		int TotalProdu=productCount(totalJackets)+productCount(totalCoats);
		System.out.println();
		if(productCount(totalCount)==TotalProdu)
		{
			System.out.println("The total product count matched with the categories total");
		}
		else
			System.out.println("The total product count unmatched with the categories total");
		//Check Coats in CATEGORIES 
		driver.findElementByXPath("(//div[@class='common-checkboxIndicator'])[2]").click();
		//Click + More option under BRAND
		driver.findElementByXPath("//div[@class='brand-more']").click();
		//Type MANGO and click checkbox
		driver.findElementByClassName("FilterDirectory-searchInput").sendKeys("MANGO");
		Thread.sleep(2000);
		  WebElement mango = driver.findElementByXPath("(//input[@value='MANGO'])[2]");
		 Actions builder1=new Actions(driver); 
		 builder1.click(mango).perform();
		 //Close the pop-up x driver.
		 Thread.sleep(3000);
		 driver.findElementByXPath("//span[@class='myntraweb-sprite FilterDirectory-close sprites-remove']").click();
		 //Confirm all the Coats are of brand MANGO  
		 List<WebElement> brandName = driver.findElementsByXPath("//h3[text()='MANGO']");
		 //System.out.println(brandName.size());

		 String name = null;
				for (WebElement webElement : brandName) 
	            
	            {
	                 name = webElement.getText();
	               
	                }
	            if(name.contains("MANGO"))
                {
                System.out.println("All the "+brandName.size()+" coats are 'MANGO' brand");
                }
                else
                {
                	System.out.println("These are not MANGO brand");
	             }
	            //Sort by Better Discount
		/*
		 * WebElement sortBy=driver.findElementByXPath("//div[@class='sort-sortBy']");
		 * Actions builder2=new Actions(driver); builder2.click(sortBy).perform();
		 */
	            driver.findElementByXPath("//div[@class='sort-sortBy']").click();
	          driver.findElementByXPath("//*[text()='Better Discount']").click();
	          Thread.sleep(1000);;
	          //Find the price of first displayed item  
	          String price = driver.findElementByXPath("//span[@class='product-discountedPrice']").getText();
	          Thread.sleep(1000);
	          System.out.println("The price of First displayed item : "+price);
	          //Mouse over on size of the first item
	          WebElement size = driver.findElementByXPath("//div[@class='product-sliderContainer']");
	          Actions builder3 =new Actions(driver);
	          builder3.moveToElement(size).build().perform();
	          //Click on WishList Now
	          driver.findElementByXPath("//span[@class='product-actionsButton product-wishlist ']").click();
	          driver.close();
	          
	}

}

