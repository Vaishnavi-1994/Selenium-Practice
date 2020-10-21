package Assigment1Vaishnavi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Test;
@Test (priority=3)
public class DatePicker extends CrossBrowserScript
{
	
public void datePicker()
{
		 
		/*
		 * System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		 * ChromeDriver driver=new ChromeDriver();
		 */
	driver.manage().window().maximize();
	
	Reporter.log("*****************************************************************\nDatePicker - ");
	//Launch URL
	driver.get("https://www.demoqa.com/date-picker");
	
	driver.findElement(By.id("datePickerMonthYearInput")).click();
	
	//Select Month
	Select month=new Select(driver.findElement(By.className("react-datepicker__month-select")));
	month.selectByVisibleText("February");
		
	//Select Year
	Select year=new Select(driver.findElement(By.className("react-datepicker__year-select")));
	year.selectByVisibleText("1994");
		
	//Select date
	driver.findElement(By.xpath("(//div[@class='react-datepicker__month']/div)[2]/div[text()='9']")).click();
	
	//DateAnd
	driver.findElement(By.id("dateAndTimePickerInput")).click();
	
	//Pick drop down
	driver.findElement(By.className("react-datepicker__month-read-view--down-arrow")).click();
	
	//Select Feb
	driver.findElement(By.xpath("//div[text()='February']")).click();
	
	//Select Year
	driver.findElement(By.className("react-datepicker__year-read-view")).click();
	
	for (int i = 0; i<=20; i++) 
	{
		driver.findElement(By.xpath("//a[@class='react-datepicker__navigation react-datepicker__navigation--years react-datepicker__navigation--years-previous']")).click();
	}
	driver.findElement(By.xpath("//div[text()='1994']")).click();
	
	//Select Date
	driver.findElement(By.xpath("//div[@aria-label='Choose Wednesday, February 9th, 1994']")).click();
	
	//Select time
	driver.findElement(By.xpath("//*[contains(text(),'15:45')]")).click();
	
	//validate data
	String getDate = driver.findElement(By.xpath("//input[@id='datePickerMonthYearInput']")).getAttribute("value");
	String getDateTime =driver.findElement(By.xpath("//input[@id='dateAndTimePickerInput']")).getAttribute("value");
	
	if(getDate.contains("02/09/1994") && getDateTime.contains("February 9, 1994 3:45 PM"))
			{
		Reporter.log("Date updated as "+getDate+" and another textbox updated as "+getDateTime);
			}
	else
		Reporter.log("The date and time wrongly updated");
	
	
}

}
