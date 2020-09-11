package Week3.Day1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./Drivers/Drivers/chromedriver1.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.leafground.com/pages/table.html");

		// Get the table and store it as a webelement
		List<Integer> progressList = new ArrayList<Integer>();

		WebElement table = driver.findElementById("table_id");

		List<WebElement> tableRows = table.findElements(By.tagName("tr"));
		System.out.println("Table Rows : " + tableRows.size());

		// Find the number of cols based on its tag name and store it in a list
		List<WebElement> tableColumns = table.findElements(By.tagName("td"));
		System.out.println("Table column : " + tableColumns.size());
		
		//Get the progress value of 'Learn to interact with Elements' and store it in a variable
		String text = driver
				.findElementByXPath("//table[@id='table_id']//tr/td[text()='Learn to interact with Elements']/following-sibling::td").getText();
		//Print the text of the variable
		System.out.println("Learn to interact with Elements :" +text);
		
		//Find the vital task for the least completed progress and check the box
		int rows=2,percentage=100;
		for (int i = 2; i <= tableRows.size(); i++) {
			String progress = driver.findElementByXPath("//table[@id='table_id']//tr[" + i + "]/td[2]").getText();
			
			int taskpercentage = Integer.parseInt(progress.substring(0, progress.length()-1));
			if (taskpercentage < percentage) 
			{
				
				rows = i;percentage = taskpercentage;
			}
		}
	
	WebElement least=driver.findElementByXPath("//table[@id='table_id']//tr["+rows+"]/td[3]/input");
	least.click();
	
		

	}
}