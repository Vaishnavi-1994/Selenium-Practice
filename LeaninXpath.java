package Week2.Day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LeaninXpath 
{
public static void main(String[] args) throws InterruptedException
{
	System.setProperty("webdriver.gecko.driver","./Drivers/Drivers/geckodriver_64 bit.exe");
	FirefoxDriver driver=new FirefoxDriver();
	
	driver.get("http://leaftaps.com/opentaps/control/main");
	driver.manage().window().maximize();
	//WebElement username=driver.findElementById("username");
	//username.sendKeys("Demosalesmanager");
	driver.findElement(By.xpath("//input[@id='username']")).sendKeys("Demosalesmanager");
	Thread.sleep(2000);
    //Relative xpath for full name field
		/*
		 * driver.findElementById("password").sendKeys("crmsfa");
		 */
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("crmsfa"); 
	
	/*
		 * driver.findElementByClassName("decorativeSubmit").click();
		 */
		driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click(); 
		driver.findElement(By.xpath("//a[@contains(text(),'CRM']")).click(); 
		/*
		 * driver.findElementByPartialLinkText("CRM").click();
		 * driver.findElementByClassName("x-panel-header").click();
		 * driver.findElementByLinkText("Create Lead").click();
		 * driver.findElementById("createLeadForm_companyName").sendKeys("TestLeaf");
		 * Thread.sleep(2000);
		 * driver.findElementById("createLeadForm_firstName").sendKeys("Vaishnavi");
		 * Thread.sleep(2000);
		 * driver.findElementById("createLeadForm_lastName").sendKeys("Rajendran");
		 * Thread.sleep(2000);
		 */

		
}
}