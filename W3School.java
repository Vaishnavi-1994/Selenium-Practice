package Week4.Day1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.chrome.ChromeDriver;

public class W3School 
{
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./Drivers/Drivers/chromedriver1.exe");
		ChromeDriver driver = new ChromeDriver();
	
		driver.manage().window().maximize();
		//url
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
		//Get into frame
driver.switchTo().frame("iframeResult");
//Click Try it button
driver.findElementByXPath("//button[text()='Try it']").click();
//enter your name in the alert
Alert alert=driver.switchTo().alert();
alert.sendKeys("Vaishnavi");
//accept the alert
alert.accept();
//Read the text which has your name
String text1=driver.findElementByXPath("//p[@id='demo']").getText();
System.out.println(text1);
// Verify that the text contains your name or not
if(text1.contains("Vaishnavi"))
{
	System.out.println("Your name has been contains in Text");
}
else
	System.out.println("Your name has not been contains in Text");
	}
}
