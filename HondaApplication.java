package Workout;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class HondaApplication 
{
	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/Drivers/chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		//1) Go to https://www.honda2wheelersindia.com/
		driver.get("https://www.honda2wheelersindia.com/");
		driver.findElementByXPath("//button[@class='close']").click();
		//2) Click on scooters 
		driver.findElementByXPath("//a[text()='Scooter']").click();
		//and click dio
		driver.findElementByXPath("//div[@class='owl-item']/div/a/img[contains(@src,'/assets/images/thumb/dioBS6-icon.png')]").click();
		Thread.sleep(2000);
		//3) Click on Specifications and mouseover on ENGINE
		driver.findElementByXPath("//a[text()='Specifications']").click();
		Thread.sleep(2000);
		//mouseover on ENGINE
		WebElement engine = driver.findElement(By.linkText("ENGINE"));
		Actions actions=new Actions(driver);
		actions.moveToElement(engine).build().perform();
		//4) Get Displacement value
		String displacementDyo = driver.findElementByXPath("((//div[@class='engine part-2 axx']/ul/li)[3]/span)[2]").getText().replaceAll("[^0-9,.]", "");
		float displacementDyo1=Float.parseFloat(displacementDyo);
		System.out.println("The displacement  value is "+displacementDyo1);
		// Go to Scooters and click Activa 125
		Thread.sleep(2000);
		driver.findElementByXPath("//a[text()='Scooter']").click();
		//click Activa 125
		Thread.sleep(2000);
		driver.findElementByXPath("//div[@class='item']/a/img[contains(@src,'/assets/images/thumb/activa-125new-icon.png')]").click();
		//Click on Specifications and mouseover on ENGINE
		driver.findElementByXPath("//a[text()='Specifications']").click();
		Thread.sleep(2000);
		//mouseover on ENGINE
		WebElement engineActiva = driver.findElementByXPath("//a[text()='ENGINE']");
		Actions actions1=new Actions(driver);
		actions1.moveToElement(engineActiva).build().perform();
		//Get Displacement value
		String displacementActiva = driver.findElementByXPath("((//div[@class='engine part-4 axx']/ul/li)[3]/span)[2]").getText().replaceAll("[^0-9.,]", "");
		float displacementActiva1=Float.parseFloat(displacementActiva);
		System.out.println("The displacement  value is "+displacementActiva1);
		//Compare Displacement of Dio and Activa 125 and print the Scooter name having better Displacement.
		if(displacementDyo1>displacementActiva1)
		{
			System.out.println("The Dyo having a good performing displacement "+displacementDyo1+"CC");
		}
		if(displacementDyo1<displacementActiva1)
		{
			System.out.println("The Activa having a good performing displacement "+displacementActiva1+"CC");
		}
		else
		{
			System.out.println("The Dyo "+displacementDyo1+" and Activa "+displacementActiva1+" having same diplacement value");
		}
		//Click FAQ from Menu 
		driver.findElementByXPath("(//a[text()='FAQ'])[1]").click();
		Thread.sleep(2000);
		//10) Click Activa 125 BS-VI under Browse By Product
		driver.findElementByXPath("//a[text()='Activa 125 BS-VI']").click();
		Thread.sleep(2000);
//		11) Click  Vehicle Price 
		driver.findElementByXPath("//li[@id='li6']/a").click();
//		12) Make sure Activa 125 BS-VI selected and click submit
		driver.findElementByXPath("//button[@id='submit6']").click();
//		13) click the price link
		Thread.sleep(2000);
		driver.findElementByXPath("//a[text()='Click here to know the price of Activa 125 BS-VI.']").click();
//		14) Go to the new Window 
		Thread.sleep(2000);
		Set<String> firstAndSecond = driver.getWindowHandles();
		List<String> listhandles = new ArrayList(firstAndSecond);
		driver.switchTo().window(listhandles.get(1));
	//	and select the state as Tamil Nadu and  city as Chennai
		Select selectState = new Select(driver.findElementByXPath("(//select[@class='form-control'])[1]"));
		selectState.selectByVisibleText("Tamil Nadu");
		Thread.sleep(1000);
		Select selectCity=new Select(driver.findElementByXPath("(//select)[2]"));
		selectCity.selectByValue("1524");
//		15) Click Search
		driver.findElementByXPath("//button[text()='Search']").click();
//		16) Print all the 3 models and their prices
		System.out.println(driver.findElementByXPath("//table[@id='gvshow']").getText());
//		17) Close all the Windows
		driver.close();
		driver.switchTo().window(listhandles.get(0));
		driver.close();
}
}