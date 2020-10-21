package Pages;

import Base.ProjectSpecificMethods;

public class MyHomePage extends ProjectSpecificMethods

{
	public MyHomePage clickLead()
	{
		driver.findElementByClassName("x-panel-header").click();
		return this;
	}
	public CreateLeadPage clickCreateLead()
	{
		driver.findElementByLinkText("Create Lead").click();
		return new CreateLeadPage();
	}
	
}
