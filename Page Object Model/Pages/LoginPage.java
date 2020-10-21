package Pages;

import Base.ProjectSpecificMethods;

public class LoginPage extends ProjectSpecificMethods
{
public LoginPage enterUsername() 
{
	driver.findElementById("username").sendKeys("Demosalesmanager");
	return this;
}
public LoginPage enterPassword()
{
	driver.findElementById("password").sendKeys("crmsfa");
	return this;
}
public HomePage clickLoginButton()
{
	driver.findElementByClassName("decorativeSubmit").click();
	return new HomePage();
}
}
