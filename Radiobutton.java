package Week2.Day2;

import java.awt.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment1 
{
	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/Drivers/chromedriver1.exe");
		ChromeDriver driver=new ChromeDriver();
		
		driver.get("http://leafground.com/pages/radio.html");
		driver.findElementByXPath("//input[@id='yes']").click();
		
		WebElement radioValue=driver.findElementByXPath("(//input)[3]");
		WebElement radioValue1=driver.findElementByXPath("(//input)[4]");
			
		if(radioValue.isSelected())
		{
			System.out.println("Default value is : "+driver.findElementByXPath("//label[@for='Unchecked']").getText());
		} 
		else
			System.out.println("Default value is : "+driver.findElementByXPath("//label[@for='Checked']").getText());
		
				//Select your age group 
		
				boolean agebutton = driver.findElementByXPath("//input[@name='age']").isSelected();
				boolean agebutton2 = driver.findElementByXPath("(//input[@name='age'])[2]").isSelected();
				boolean agebutton3 = driver.findElementByXPath("(//input[@name='age'])[3]").isSelected();
				if ((agebutton==false) && (agebutton2==false) && (agebutton3==false))
					System.out.println("Please select your age group");
				else if ((agebutton==true) || (agebutton2==true) || (agebutton3==true))
					System.out.println("The age group is already selected");	
	   
	}
}