package Week2.Day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Assignment3
{
public static void main(String[] args) throws InterruptedException
{
	System.setProperty("webdriver.chrome.driver","./Drivers/Drivers/chromedriver1.exe");
	ChromeDriver driver=new ChromeDriver();
	
	//Navigate
	driver.get("http://www.leafground.com/pages/Button.html");
	driver.manage().window().maximize();
	driver.findElementByXPath("(//button)[1]").click();
	driver.findElementByXPath("	(//h5)[2]").click();
	driver.findElementByXPath("//button[@id='position']").click();
	
	   //Used points class to get x and y coordinates of element.
		WebElement buttonclick = driver.findElement(By.xpath("//button[@id='position']"));
     org.openqa.selenium.Point classname = buttonclick.getLocation();
     System.out.println("Button X position : "+classname.x);
     System.out.println("Button y position : "+classname.y);
   
     
     //Find color
     String buttonColor=driver.findElementByXPath("(//button)[3]").getCssValue("background-color");
     System.out.println("Button color: " + buttonColor);
     
     //Height and Width
     String buttonHeight=driver.findElementByXPath("//button[@id='size']").getCssValue("Height");
     System.out.println("Button Height : " +buttonHeight);
     String buttonWidth=driver.findElementByXPath("//button[@id='size']").getCssValue("Width");
     System.out.println("Button Width : "+buttonWidth);
     
     
     
}
	
	
}	
	
	
	

