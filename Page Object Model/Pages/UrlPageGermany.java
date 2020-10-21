package Pages;



import org.openqa.selenium.By;
import org.testng.Reporter;

import Base.ProjectSpecificMethodsOlay;

public class UrlPageGermany extends ProjectSpecificMethodsOlay
{
public ClickJoin putUrlPageGermany() 
{
driver.get("https://www.olaz.de/de-de");
Reporter.log("***********************************************");
Reporter.log("Website open for Germany");
Reporter.log("***********************************************");
/*
 * try { driver.findElement(By.xpath(
 * "//button[contains(@id,'onetrust-accept-btn-handler')]")).click(); } catch
 * (Exception e) { e.printStackTrace(); }
 */
return new ClickJoin();
}
}
