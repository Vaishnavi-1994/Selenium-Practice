package Week4.Day1;

import org.openqa.selenium.chrome.ChromeDriver;

public class ServiceDesk {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./Drivers/Drivers/chromedriver1.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://dev60453.service-now.com/");
		Thread.sleep(1000);
		driver.switchTo().frame("gsft_main");
		driver.findElementByXPath("//input[@id='user_name']").sendKeys("admin");
		driver.findElementByXPath("//input[@id='user_password']").sendKeys("India@123");
		driver.findElementByXPath("//button[@id='sysverb_login']").click();
		String actualTitle = driver.getTitle();
		System.out.println("The Title of the page is "+actualTitle);
		driver.close();
		
}

}