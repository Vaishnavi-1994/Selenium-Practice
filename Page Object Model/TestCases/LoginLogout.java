package TestCases;

import org.testng.annotations.Test;

import Base.ProjectSpecificMethods;
import Pages.LoginPage;


public class LoginLogout extends ProjectSpecificMethodsOlay
{
	@Test
	public void runLoginLogout() 
	{
		new LoginPage()
		.enterUsername()
		.enterPassword()
		.clickLoginButton()
		.verifyTitle()
		.clickCrmSfa()
		.clickCreateLead()
		.enterFirstName()
		.enterLastName()
		.enterCompanyName().clickCreateLeadFinal();
		
		


	}

}

