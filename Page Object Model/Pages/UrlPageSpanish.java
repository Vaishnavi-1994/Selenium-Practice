package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Reporter;

import Base.ProjectSpecificMethodsOlay;

public class UrlPageSpanish extends ProjectSpecificMethodsOlay
{
public ClickJoin putUrlPageSpanish() 
{
	driver.get("https://www.olay.es/es-es");
	Reporter.log("***********************************************");
	Reporter.log("Website open for Spanish");
	Reporter.log("***********************************************");
	

	return new ClickJoin();

}
}
