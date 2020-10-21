package TestCases;

import org.testng.annotations.Test;

import Base.ProjectSpecificMethodsOlay;
import Pages.UrlPageSpanish;
import Pages.UrlPageUk;

public class OlazSpanishRegistration extends ProjectSpecificMethodsOlay
{
	@Test
public void runOlazSpanishRegistration() 
{
	String url1=driver.getCurrentUrl();
	if(url1.contains("https://olay.es/"))
{
		new UrlPageUk().putUrlUk().clickJoinButton().enterEmail().enterPassword().
		  clickLogin()
		  .verifyIncorrectPassword().enterFirstName().enterLastName().enterEmailReg().
		  enterPasswordReg()
		  .selectDateOfBirth().clickAgreeButton().clickRegistrationForm();
	 
}
else if(url1.contains("https://www.olay.es/es-es"))
{
	 new UrlPageSpanish().putUrlPageSpanish().clickJoinButton().enterEmail().
	  enterPassword().clickLogin().verifyIncorrectPassword().clickReg().
	  enterFirstName().genderclick()
	 .enterLastName().enterEmailReg().enterPasswordReg().enterConfirmPasswordReg()
	 .selectDateOfBirth().enterPhoneNumber().clickAgreeButton().
	  clickRegistrationForm();
}
}
}
