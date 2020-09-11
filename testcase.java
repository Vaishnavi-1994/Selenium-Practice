package Week2.Day2;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ff {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./Drivers/Drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.findElementByXPath("//label/following-sibling::input").sendKeys("demosalesmanager");
		driver.findElementByXPath("(//label)[2]/following-sibling::input").sendKeys("crmsfa");
		driver.findElementByXPath("//p[3]/input").click();
		driver.findElementByXPath("//div[@id='label']/a").click();
		driver.findElementByXPath("//a[text()='Create Lead']").click();
		driver.findElementByXPath("//a[text()='Find Leads']").click();
		driver.findElementByXPath("(//input[@name='firstName'])[3]").sendKeys("Kavitha");
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(5000);
		driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]").click();
		String text = driver.findElementByXPath("//div[@id='sectionHeaderTitle_leads']").getText();
		System.out.println("Title of the page is: "+text);		
		driver.findElementByXPath("//a[text()='Edit']").click();
		WebElement companyName = driver.findElementById("updateLeadForm_companyName");
		companyName.clear();
		String name="AbcCompany";
		companyName.sendKeys(name);
		driver.findElementByXPath("//input[@value='Update']").click();
		boolean updated = driver.findElementByXPath("//span[@id='viewLead_companyName_sp'][contains(text(),name)]").isDisplayed();
		if(updated==true) {
			System.out.println("company name is changed");
		}
		driver.close();
	}

}