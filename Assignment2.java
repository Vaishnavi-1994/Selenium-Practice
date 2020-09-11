package Week2.Day1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Assignment2 
{
public static void main(String[] args) throws InterruptedException
{
//Launch Browser
	System.setProperty("webdriver.chrome.driver","./Drivers/Drivers/chromedriver.exe");
	ChromeDriver driver=new ChromeDriver();
//Go to URL
driver.get("http://www.leafground.com/pages/Edit.html");
//Enter your email address
driver.findElementByXPath("//input[1][@id='email']").sendKeys("VAISHU.CVS@GMAIL.COM");
//Append a text and press keyboard tab
driver.findElementByXPath("(//input)[2]").sendKeys("Hello");
driver.findElementByXPath("(//input)[2]").sendKeys(Keys.TAB);
//Get default text entered
driver.findElementByXPath("(//input)[3][@name='username']").sendKeys(Keys.ENTER);
//Clear the text
driver.findElementByXPath("(//input[@name='username'])[2]").clear();
//Confirm that edit field is disabled
driver.findElementByXPath("(//label[@for='disabled'])").isEnabled();

boolean check = driver.findElementByXPath("(//input)[5]").isEnabled();

if(check==true)
{
	System.out.println("The text box is Enabled");

}
else
{
	System.out.println("The text box is Disabled");
}

}
}
