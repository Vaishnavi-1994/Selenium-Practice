package Pages;

import Base.ProjectSpecificMethods;

public class CreateLeadPage extends ProjectSpecificMethods
{
public CreateLeadPage enterFirstName()
{
	driver.findElementById("createLeadForm_firstName").sendKeys("Vaishnavi");
	return this;
}
public CreateLeadPage enterLastName()
{
	driver.findElementById("createLeadForm_lastName").sendKeys("Rajendran");
	return this;
}
public CreateLeadPage enterCompanyName()
{
	driver.findElementById("createLeadForm_companyName").sendKeys("TestLeaf");
	return this;
}
public CreateLeadPage clickCreateLeadFinal()
{
driver.findElementByName("submitButton").click();
return this;
}
}
