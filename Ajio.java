package Workout;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.runtime.Timeout;

public class Ajio

{
	public static int productCount(String string)

	{

		String totalproduct = string.replaceAll("[^0-9]", "");
		int numberonly = Integer.parseInt(totalproduct);
		return numberonly;
	}

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./Drivers/Drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.ajio.com/shop/sale");
		// Enter Bags in the Search field
		driver.findElementByXPath("//input[@class='react-autosuggest__input react-autosuggest__input--open']")
				.sendKeys("Bags");
		// Select Bags in Women Handbags
		driver.findElementByXPath("(//a[@class='search-suggestionList  '])[2]").click();
		// Click on five grid
		driver.findElementByXPath("//div[@class='five-grid']").click();
		// Select SORT BY as "What's New"
		WebElement filterDropdown = driver.findElement(By.xpath("//div[@class='filter-dropdown']/select"));
		Select dropdown = new Select(filterDropdown);
		dropdown.selectByValue("newn");
		// Enter Price Range Min as 2500 and Max as 5000
		driver.findElementByXPath("(//div[@class='facet-head '])[1]").click();
		// Min as 2500
		driver.findElementByXPath("//input[@name='minPrice']").sendKeys("2500");
		// Max as 5000
		driver.findElementByXPath("//input[@name='maxPrice']").sendKeys("5000");
		driver.findElementByXPath("//button[@class='rilrtl-button ic-toparw']").click();
		Thread.sleep(2000);
		// Click on the product "TOMMY HILFIGER Sling Bag with Chain Strap"
		driver.findElementByXPath("//div[text()='Sling Bag with Chain Strap']").click();
		Thread.sleep(2000);
		// Handle second window
		Set<String> firstAndSecond = driver.getWindowHandles();
		List<String> listhandles = new ArrayList(firstAndSecond);
		driver.switchTo().window(listhandles.get(1));
		// Verify the Coupon code for the price above 2890 is applicable for your
		// product, if applicable then get the Coupon Code and the discount price for
		// the coupon
		String price1 = driver.findElementByXPath("//div[@class='promo-desc']").getText();
		String totalproduct1 = price1.replaceAll("[^0-9,%]", "");
		String[] discAndprice = totalproduct1.split("%", 2);
		int DiscountPercentage = Integer.parseInt(discAndprice[0]);
		int ThresholdAmount = Integer.parseInt(discAndprice[1]);
		// Get the discount percentage
		System.out.println("The Discount percentage is " + DiscountPercentage + "%");
		// the price above 2890 is applicable for your product,
		System.out.println("The product should above Rs." + ThresholdAmount);
		// Product price before applying discount
		String productPrice = driver.findElementByXPath("//div[@class='prod-sp']").getText();
		System.out.println("The product price befor applying discount Rs." + productCount(productPrice));
		// get it for
		String offerPrice = driver.findElementByXPath("//div[@class='promo-discounted-price']").getText();
		System.out.println("The product offer price is Rs." + productCount(offerPrice));
		// if applicable then get the Coupon Code and the discount price for the coupon
		String coupon1 = driver.findElementByClassName("promo-title").getText();
		String coupon2 = coupon1.replaceAll("[\\n]", " ");
		String[] coupon3 = coupon2.split(" ", 3);
		String couponCode = coupon3[2];
		if (productCount(productPrice) > ThresholdAmount) {
			System.out.println("The coupon code is " + couponCode);
		} else
			System.out.println("The dicount price is not exceed Rs.2890");

		// Check the availability of the product for pincode 560043,
		driver.findElementByXPath("//span[text()='Enter Pin-code To Know Estimated Delivery Date']").click();
		driver.findElementByXPath("//input[@name='pincode']").sendKeys("560043");
		driver.findElementByXPath("//button[@class='edd-pincode-modal-submit-btn']").click();
		// Print the expected delivery date if it is available
		String expdate = driver.findElementByXPath("//ul[@class='edd-message-success-details']").getText();
		System.out.println(expdate);
		// Click on Other Informations under Product Details
		driver.findElementByXPath("//div[@class='other-info-toggle']").click();
		// Print the Customer Care address, phone and email
		String cc = driver.findElementByXPath("(//span[@class='other-info'])[7]").getText();
		System.out.println("Customer care address is " + cc);
		// Click on ADD TO BAG
		driver.findElementByXPath("//div[@class='btn-gold']").click();
		Thread.sleep(2000);
		// GO TO BAG
		driver.findElement(By.className("mini-cart-btn")).click();

		// Enter Coupon Code
		driver.navigate().refresh();
		// driver.findElementByXPath("//input[@class='coupon-code-input-vhr-not-apld
		// ']").sendKeys(couponCode);
		driver.findElementById("couponCodeInput").sendKeys(couponCode, Keys.F5);
		Thread.sleep(3000);
		// Click Apply
		driver.findElementByXPath("//button[@class='rilrtl-button button apply-button ']").click();
		Thread.sleep(3000);
		driver.navigate().refresh();
		driver.navigate().refresh();
		driver.navigate().refresh();
		driver.findElementById("couponCodeInput").sendKeys(couponCode, Keys.F5);
		Thread.sleep(3000);
		// Click Apply
		driver.findElementByXPath("//button[@class='rilrtl-button button apply-button ']").click();
		driver.findElementByXPath("//span[@class='ic-delete delete-voucher']").click();
		driver.findElementById("couponCodeInput").sendKeys(couponCode);
		Thread.sleep(3000);
		// Click Apply
		driver.findElementByXPath("//button[@class='rilrtl-button button apply-button ']").click();
		Thread.sleep(3000);
		String netPrice1 = driver.findElementByXPath("//div[@class='net-price best-price-strip']").getText();
		int netprice = productCount(netPrice1.substring(0, netPrice1.length() - 2));
		System.out.println("The product net price is Rs." + netprice);
		if (netprice == productCount(offerPrice)) {
			System.out.println("The offer price and net price is equal Rs." + netprice);
		} else
			System.out.println("The offer price is different from net price");
		// Click on Delete and Delete the item from Bag
		Thread.sleep(3000);
		driver.findElementByXPath("//div[text()='Delete']").click();
		// Close all the browsers
		driver.quit();
	}
}