package Pages;

import org.testng.Assert;

import Base.ProjectSpecificMethods;

public class HomePage extends ProjectSpecificMethods
{
			public HomePage verifyTitle()
		{
			Assert.assertTrue(driver.findElementByPartialLinkText("CRM").isDisplayed());
			return this;
		}
		public MyHomePage clickCrmSfa()
		{
			
			driver.findElementByPartialLinkText("CRM").click();
			return new MyHomePage();
			
		}
}

