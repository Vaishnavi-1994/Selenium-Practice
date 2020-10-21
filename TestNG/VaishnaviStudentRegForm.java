package Assigment1Vaishnavi;


import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class VaishnaviStudentRegForm  extends CrossBrowserScript
{
	@Test (priority=5)
public void studentRegForm() throws InterruptedException
{
		/*
		 * //Launch browser
		 * System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		 * ChromeDriver driver=new ChromeDriver();
		 */
	
	driver.manage().window().maximize();
	
	//driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	
	//Go to Url
	driver.get("https://www.demoqa.com/automation-practice-form");
	
	//Firstname
	driver.findElement(By.id("firstName")).sendKeys("Vaishnavi");
	
	//Enter Last Name
	driver.findElement(By.id("lastName")).sendKeys("Rajendran");
	
	//Enter Email Id
	driver.findElement(By.id("userEmail")).sendKeys("vaishu.cvs@gmail.com");
	
	//Gender
	driver.findElement(By.xpath("//label[text()='Female']")).click();
	
	//Mobile Number
	driver.findElement(By.id("userNumber")).sendKeys("9840072880",Keys.TAB);
	
	//Select Month
	Select month=new Select(driver.findElement(By.className("react-datepicker__month-select")));
	month.selectByVisibleText("February");
	
	//Select Year
	Select year=new Select(driver.findElement(By.className("react-datepicker__year-select")));
	year.selectByVisibleText("1994");
	
	//Select date
	driver.findElement(By.xpath("(//div[@class='react-datepicker__month']/div)[2]/div[text()='9']")).click();
	
	//Subject
	driver.findElement(By.xpath("//div[@class='subjects-auto-complete__input']/input")).sendKeys("Computer Science");
	driver.findElement(By.xpath("//div[@class='subjects-auto-complete__input']/input")).sendKeys(Keys.TAB);
	
	//Select hobbis
	driver.findElement(By.xpath("//label[@for='hobbies-checkbox-2']")).click();
	
	//upload file
	driver.findElement(By.id("uploadPicture")).sendKeys("E:\\Vaishu\\Vaishu.jpg");
	
	//Address
	driver.findElement(By.xpath("//textarea[@id='currentAddress']")).sendKeys("No.15 Royal Hostel\nSholinganallur\nChennai-600119");
	//Scroll down
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,1000)");
	//State
	driver.findElement(By.xpath("//div[text()='Select State']")).click();
	driver.findElement(By.xpath("(//div[@class='css-1g6gooi']/div/input)[2]")).sendKeys(Keys.TAB);
	
	//City
	driver.findElement(By.xpath("//div[text()='Select City']")).click();
	driver.findElement(By.xpath("(//div[@class='css-1g6gooi']/div/input)[3]")).sendKeys(Keys.TAB);
	
	//Submit
	driver.findElement(By.xpath("//button[@id='submit']")).click();
	
	//validate if file uploaded
	String fileName= driver.findElement(By.xpath("//td[text()='Picture']/following-sibling::td")).getText();
	if(fileName.contains("Vaishu.jpg"))
	{
		Reporter.log("The Image "+fileName+ " is uploaded");
	}
	else
	{
		Reporter.log("The Image "+fileName+ "is not uploaded");
	}
	//Details print
	List<WebElement> listoptions=driver.findElements(By.xpath("(//table[@class='table table-dark table-striped table-bordered table-hover']//tbody/tr/td)"));;
	List<String> rowsValue=new ArrayList<>();
	
	
	for (int i = 0+1; i <=listoptions.size(); i++) 
	{
		String tempRows=driver.findElement(By.xpath("(//table[@class='table table-dark table-striped table-bordered table-hover']//tbody/tr/td)["+i+"]")).getText();
		rowsValue.add(tempRows);
	}
	System.out.println(rowsValue);

	Thread.sleep(2000);
	int a=0;
    System.out.println("Student Registration Form Details");    
   for (int i =0;i<rowsValue.size(); i++) 
   {
	if(i%2==0)
	{
	Reporter.log("Label name - "+rowsValue.get(i));
		}
	if(i%2!=0)
	{
		Reporter.log("Value - "+rowsValue.get(i));
	}
   }
		//Close button
	driver.findElement(By.id("closeLargeModal")).click();
	
}
}
