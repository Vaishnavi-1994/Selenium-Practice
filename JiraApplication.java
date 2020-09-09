package Workout;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JiraApplication 
{
	public static void main(String[] args) throws InterruptedException, AWTException 
	{
	System.setProperty("webdriver.chrome.driver","./Drivers/Drivers/chromedriver.exe");
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--disable-notifications");
	ChromeDriver driver = new ChromeDriver(options);
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	//1. Go to "https://id.atlassian.com/login"
	driver.get("https://id.atlassian.com/login");
	//2. Enter email "hari.radhakrishnan@testleaf.com"
	driver.findElementByXPath("//input[@id='username']").sendKeys("hari.radhakrishnan@testleaf.com");
	//click continue
	driver.findElementByXPath("//button[@id='login-submit']").click();
	//3. Enter password "India@123" and 
	driver.findElementByXPath("//input[@id='password']").sendKeys("India@123");
	//click sign in
	driver.findElementByXPath("//button[@id='login-submit']").click();
	//4. Select the project "rest-api"
	driver.findElementByXPath("(//span[@class='sc-gPEVay cOqbOW'])[1]").click();
	//5. Get the total number of issues and print the count alone (only number)
	driver.findElementByXPath("//div[text()='Backlog']").click();
	String countIssue = driver.findElement(By.className("ghx-issue-count")).getText().replaceAll("[^0-9]","");
	float totalissueCount=Float.parseFloat(countIssue);
	System.out.println("The total number of issues is "+totalissueCount);
	Thread.sleep(2000);
	//6. Click on Create with  and 
	driver.findElementByXPath("//button[@id='createGlobalItem']").click();
	//Issue type as "Story"
System.out.println("The value is"+driver.findElementByXPath("(//input[@role='combobox'])[2]").getText());
/*f(driver.findElementByXPath("//a[text()='Story'])").isSelected())
	{
		System.out.println("The issue type is Story");
	}
	else
	{
	driver.findElementByXPath("//input[@role='combobox']/parent::div[@class='aui-ss issuetype-ss aui-ss-has-entity-icon']").click();
	driver.findElementByXPath("//input[@role='combobox']/parent::div[@class='aui-ss issuetype-ss aui-ss-has-entity-icon']").sendKeys("Story",Keys.TAB);
	}*/
	//Summary as "Created by <your name>"
	driver.findElementByXPath("//input[@id='summary']").sendKeys("Created by Vaishnavi");
	//7. Attach a image from local directory and Click Create
	driver.findElementByXPath("//button[text()=' browse.']").click();
	Thread.sleep(1000);
	
	
		/*
		 * WebElement addFile = driver.findElement(By.xpath(".//input[@type='file']"));
		 * addFile.sendKeys("/Users/neeraj.kumar/Desktop/c1.jpeg");
		 */
	
		/*
		 * driver.switchTo().frame(1);
		 * 
		 * 
		 * driver.findElementByXPath("//span[text()='Upload a file']/ancestor::button").
		 * click();
		 * 
		 * 
		 * 
		 * StringSelection ss = new StringSelection("G://capture.jpg");
		 * Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		 * 
		 * //native key strokes for CTRL, V and ENTER keys Robot robot = new Robot();
		 * 
		 * robot.keyPress(KeyEvent.VK_CONTROL); robot.keyPress(KeyEvent.VK_V);
		 * robot.keyRelease(KeyEvent.VK_V); robot.keyRelease(KeyEvent.VK_CONTROL);
		 * robot.keyPress(KeyEvent.VK_ENTER); robot.keyRelease(KeyEvent.VK_ENTER);
		 */
	Thread.sleep(3000);
	//cdriver.switchTo().frame(0);  // locating iframe by index
	driver.switchTo().frame(driver.findElement(By.tagName("iframe"))); //locating iframe using webelement
	Thread.sleep(3000);
	//WebElement upload = cdriver.findElementByXPath("//span[text()='Upload a file']");
	//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(cdriver.findElementByXPath("//div[@class='dropzone']//button")));
	
	driver.findElementByXPath("(//div[@class='dropzoneWrapper']//div)[1]");
	WebElement upload = driver.findElementByXPath("//div[@class='dropzone']//button");
	System.out.println("uploade text: "+upload.getText());
	WebDriverWait wait=new WebDriverWait(driver,60);
	wait.until(ExpectedConditions.elementToBeClickable(upload)).click();
	Thread.sleep(3000);
//8. Verify the newly created story by Search your Story and Confirm
//9. Open the newly created story 
//10. Modify the assignee as "Vivek"
//11. Change the Priority as Low
//12. Navigate to the Backlog
//13. Click on Recently Updated	
//14. Validate the Assignee and Priority values for the newly created Story as expected
//15. Click on the Story 
//16. Click on Actions and Delete the Story
//17. Confirm the Delete
//18. Recently Updated section in Backlog should have any items

}
}