package TestCases;

import org.testng.annotations.Test;

import Base.ProjectSpecificMethodsOlay;
import Pages.UrlPageUk;

public class OlazUkRegistration extends ProjectSpecificMethodsOlay
{
	@Test
	public void runOlazUkRegistration() 
	{
		new UrlPageUk().putUrlUk().clickJoinButton().enterEmail().enterPassword().
		  clickLogin()
		  .verifyIncorrectPassword().enterFirstName().enterLastName().enterEmailReg().
		  enterPasswordReg()
		  .selectDateOfBirth().clickAgreeButton().clickRegistrationForm();

	}
}
