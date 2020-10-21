package Assigment1Vaishnavi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.math3.analysis.function.Add;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Test;
@Test (priority=4)
public class SelectAllOptions extends CrossBrowserScript
{
	
public  void selectAllOptions() throws InterruptedException
{

	//Launch browser
		/*
		 * System.setProperty(
		 * "webdriver.gecko.driver","./Drivers/geckodriver_64 bit.exe"); FirefoxDriver
		 * driver=new FirefoxDriver();
		 */
	
	driver.manage().window().maximize();
	
	//driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
	
	//Go to Url
	driver.get("https://demoqa.com/");
	driver.findElement(By.xpath("(//div[@class='card mt-4 top-card'])[4]")).click();
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,1000)");
	driver.findElement(By.xpath("//div[@class='element-list collapse show']/ul/li[@id='item-8']")).click();
	
	
	//click select box
	driver.findElement(By.xpath("//div[@class=' css-1hwfws3']//div")).click();
	
	//get options from list
	String optionList=driver.findElement(By.xpath("//div[@class=' css-11unzgr']")).getText();
		
	//Converted to String array
	String[] newOptions=optionList.split("\n");
	Reporter.log("***********************Select Group options**********************************************");
	
	//click element
	for (int i = 0; i <newOptions.length; i++) 
	{			
		if(newOptions[i].contains("option"))
		{
		driver.findElement(By.xpath("//div[text()='"+newOptions[i]+"']")).click();  
		driver.findElement(By.xpath("//div[@class=' css-1hwfws3']//div")).click();
		//check if the element is selected
		if(driver.findElement(By.xpath("(//div[@class=' css-1uccc91-singleValue'])[1][text()='"+newOptions[i]+"']")).isDisplayed())
		Reporter.log(newOptions[i]+ " - select from list");
		}
		
	}
	driver.findElement(By.xpath("//div[@class=' css-1hwfws3']//div")).click();
	Reporter.log("***********************Select Title options**********************************************");
	//click select box
		driver.findElement(By.xpath("(//div[@class=' css-1wa3eu0-placeholder'])[1]")).click();
		
		//get options from list
		String optionList1=driver.findElement(By.xpath("//div[@class=' css-26l3qy-menu']")).getText();
			
		//Converted to String array
		String[] newOptions1=optionList1.split("\n");
		
		for (int i = 1; i <newOptions1.length; i++) 
		{
			//Iterate to click
			driver.findElement(By.xpath("//div[text()='"+newOptions1[i]+"']")).click();  
			driver.findElement(By.xpath("(//div[@class=' css-1uccc91-singleValue'])[2]")).click();
			//check if the element is selected
			if(driver.findElement(By.xpath("(//div[@class=' css-1uccc91-singleValue'])[2][text()='"+newOptions1[i]+"']")).isDisplayed())
			Reporter.log(newOptions1[i]+ " - select from list");
		}
		//back to click
		driver.findElement(By.xpath("(//div[@class=' css-1uccc91-singleValue'])[2]")).click();
			
		Reporter.log("**************************Old Style Select Menu*************************************** ");
		
		//Select menu
		Select selectMenu=new Select(driver.findElement(By.xpath("//select[@id='oldSelectMenu']")));
		
		//get the options count
		String optionCount=driver.findElement(By.xpath("//select[@id='oldSelectMenu']")).getText();
		String[] optionList2=optionCount.split("\n");
		
		for (int i = 0; i < optionList2.length; i++) 
		{
			selectMenu.selectByIndex(i);
			Reporter.log(optionList2[i]+" - Select from List");
		}
		Reporter.log("**************************Multi Select Options*************************************** ");
		
		//click select box
		driver.findElement(By.xpath("//div[@class=' css-1wa3eu0-placeholder']")).click();
		int i=1;
		do
		{				//select options
						driver.findElement(By.xpath("(//div[@class='css-1g6gooi'])[3]/div/input")).sendKeys(Keys.ENTER);
						i++;
						//get option from list
		}
		while(i<=4); 
		//verify all options are selected
		if(driver.findElement(By.xpath("//div[text()='No options']")).isDisplayed())
		{
			Reporter.log("All options are selected");
		}
		//select cars
	Reporter.log("**********************************Select Cars**********************************************");	
	
	//intialize select
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	 js1.executeScript("window.scrollBy(0,1000)");
	Select optionsMulti=new Select(driver.findElement(By.id("cars")));
	String optionsMultiString = driver.findElement(By.id("cars")).getText();
	String[] optionsMultiStringList=optionsMultiString.split("\n");
	
	for (int j = 0; j < optionsMultiStringList.length; j++) 
	{
		optionsMulti.selectByIndex(j);
		Reporter.log(optionsMultiStringList[j]+" - Select from List");
	}
	
}
}
