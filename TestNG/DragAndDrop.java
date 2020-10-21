package Assigment1Vaishnavi;

import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.formula.functions.Intercept;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.graphbuilder.curve.Point;
@Test (priority=1)
public class DragAndDrop extends CrossBrowserScript
{
	
	public void dragAndDrop() throws InterruptedException
	{
		
		//launch 
		/*
		 * System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		 * ChromeDriver driver=new ChromeDriver();
		 */
		
		//implicitlyWait
		
		
		//maximize window
		driver.manage().window().maximize();
		
		//Url
		driver.get("https://demoqa.com/droppable/");
		Reporter.log("Simple Switch - ");
		//declare source
		WebElement dragElement = driver.findElement(By.xpath("//div[@id='draggable']"));
		//declare target
		WebElement dropElement = driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));
		//Actions
		Actions builder=new Actions(driver);
		builder.click(dragElement).clickAndHold().moveToElement(dropElement).release().perform();
		//Validate
		String getTextDroppedElement = driver.findElement(By.xpath("(//div[@id='droppable'])[1]/p")).getText();
		if(getTextDroppedElement.equals("Dropped!"))
		{
			Reporter.log("The drag me element is dropped");
		}
		else
		{
			Reporter.log("The drag me element is not dropped");
		}
		Reporter.log("Acceptable & Non Acceptable - ");
		//Accept Drag and Drop
		driver.findElement(By.xpath("//a[@id='droppableExample-tab-accept']")).click();
		
		//not acceptable
		WebElement notAcceptableElement=driver.findElement(By.id("notAcceptable"));
		
		//Acceptable Element
		WebElement acceptableElement=driver.findElement(By.id("acceptable"));
		
		//Get Status
		String statusText = driver.findElement(By.xpath("(//div[@id='droppable'])[2]/p")).getText();
		
		//target 
		WebElement targetElement = driver.findElement(By.xpath("(//div[@id='droppable'])[2]"));
		
		///Drop
		do {
			//move NotAcceptable Element
			(new Actions(driver)).dragAndDrop(notAcceptableElement, targetElement).perform();
			(new Actions(driver)).click(acceptableElement).clickAndHold().release(targetElement).perform();
			Reporter.log("The Element has been dropped");
		}
		while(statusText.contains("Dropped!"));
		
		Reporter.log("preventPropogation - ");
		//preventPropogation
		driver.findElement(By.xpath("//a[@id='droppableExample-tab-preventPropogation']")).click();
		
		//Drag Element
		WebElement dragElementPreventPropogation = driver.findElement(By.xpath("//div[@id='dragBox']"));
		
		//Drop notGreedyInnerDropBOx
		WebElement notGreedyInnerDropBox = driver.findElement(By.id("notGreedyInnerDropBox"));
		
		//Drop notGreedyOuterDropBox
		WebElement notGreedyOuterDropBox = driver.findElement(By.id("notGreedyDropBox"));
		//Scroll down
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		//Drop GreedyInnerDropBOx
		WebElement greedyInnerDropBox = driver.findElement(By.id("greedyDropBoxInner"));
				
		//Drop GreedyOuterDropBox
		WebElement greedyOuterDropBox = driver.findElement(By.xpath("//div[@id='greedyDropBox']/p"));
		
							
		//Move Element
		if(driver.findElement(By.xpath("//div[@id='notGreedyDropBox']/p[text()='Outer droppable']")).isDisplayed() && driver.findElement(By.xpath("//div[@id='notGreedyInnerDropBox']/p[text()='Inner droppable (not greedy)']")).isDisplayed())
		{
			(new Actions(driver)).click(dragElementPreventPropogation).clickAndHold().release(notGreedyOuterDropBox).build().perform();
			Thread.sleep(1000);
		}
		if(driver.findElement(By.xpath("//div[@id='notGreedyDropBox']/p[text()='Dropped!']")).isDisplayed() && driver.findElement(By.xpath("//div[@id='notGreedyInnerDropBox']/p[text()='Dropped!']")).isDisplayed())
		{
			
			(new Actions(driver)).click(dragElementPreventPropogation).clickAndHold().release(greedyInnerDropBox).build().perform();
			
			(new Actions(driver)).click(dragElementPreventPropogation).clickAndHold().release(greedyOuterDropBox).build().perform();
		}
		if(driver.findElement(By.xpath("//div[@id='greedyDropBox']/p[text()='Dropped!']")).isDisplayed())
		{
			(new Actions(driver)).click(dragElementPreventPropogation).clickAndHold().release(greedyOuterDropBox).build().perform();
		}
		if(driver.findElement(By.xpath("//div[@id='notGreedyDropBox']/p[text()='Dropped!']")).isDisplayed() 
				&& driver.findElement(By.xpath("//div[@id='notGreedyInnerDropBox']/p[text()='Dropped!']")).isDisplayed() 
				&& driver.findElement(By.xpath("//div[@id='greedyDropBox']/p[text()='Dropped!']")).isDisplayed() 
				&& driver.findElement(By.xpath("//div[@id='greedyDropBoxInner']/p[text()='Dropped!']")).isDisplayed())
		{
			Reporter.log("All Elements are Dropped!");
		}
		else
		{
			Reporter.log("Some Elements are missed to dropped");
		}
		//revert
		Reporter.log("Revert Draggable - ");
		
		//revert Draggable Link
		driver.findElement(By.id("droppableExample-tab-revertable")).click();
		
		//Revert Element
		WebElement revertElement = driver.findElement(By.id("revertable"));
		
		//Not revertElement
		WebElement notRevertElement = driver.findElement(By.id("notRevertable"));
		
		//Drop Box
		WebElement dropHereBox = driver.findElement(By.xpath("(//div[@id='droppable'])[3]"));
		
		//revert Element position
		org.openqa.selenium.Point point = revertElement.getLocation();
		int xcord=point.getX();
		int ycord=point.getY();
			
		(new Actions(driver)).dragAndDrop(revertElement, dropHereBox).build().perform();
		
		org.openqa.selenium.Point point1 = revertElement.getLocation();
		int xcordDropped=point.getX();
		int ycordDropped=point.getY();
		
		if(xcord==xcordDropped && ycord==ycordDropped && driver.findElement(By.xpath("(//div[@id='droppable'])[3]/p[text()='Dropped!']")).isDisplayed())
		{
			(new Actions(driver)).dragAndDrop(notRevertElement, dropHereBox).build().perform();
			Reporter.log("The Element will revert after dropped");
			
		}
		else
		{
			Reporter.log("The element not revert");
		}
		
		
	}
	}
