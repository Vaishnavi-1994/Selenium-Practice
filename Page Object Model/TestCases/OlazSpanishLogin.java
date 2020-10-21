package TestCases;

import org.testng.annotations.Test;

import Base.ProjectSpecificMethodsOlay;

import Pages.UrlPageGermany;
import Pages.UrlPageSpanish;
import Pages.UrlPageUk;

public class OlazSpanishLogin extends ProjectSpecificMethodsOlay
{
	@Test
	public void runOlazSpanishLogin() 
	{
				
		/*
		 * new UrlPageSpanish().putUrlPageSpanish().clickJoinButton().enterEmail().
		 * enterPassword().clickLogin().verifyIncorrectPassword().clickReg().
		 * enterFirstName().genderclick()
		 * .enterLastName().enterEmailReg().enterPasswordReg().enterConfirmPasswordReg()
		 * .selectDateOfBirth().enterPhoneNumber().clickAgreeButton().
		 * clickRegistrationForm();
		 */
		new UrlPageSpanish().putUrlPageSpanish().clickJoinButton().enterEmail().enterPassword().oneButtonHandler().
		clickLogin().verifyIncorrectPassword();	
	}
}
