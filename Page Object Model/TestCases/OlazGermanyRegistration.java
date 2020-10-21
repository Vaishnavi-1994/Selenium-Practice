package TestCases;

import org.testng.annotations.Test;

import Base.ProjectSpecificMethodsOlay;
import Pages.UrlPageGermany;

public class OlazGermanyRegistration extends ProjectSpecificMethodsOlay
{
	@Test
public void runOlazGermanyRegistration() 
{
	 new UrlPageGermany().putUrlPageGermany().clickJoinButton().enterEmail().
	  enterPassword().clickLogin().verifyIncorrectPassword().clickReg().genderclick
	  () .enterFirstName().enterLastName().enterEmailReg().enterPasswordReg().
	  enterConfirmPasswordReg().selectDateOfBirth().countryName().
	  enterStreetAddress() .enterCity().clickAgreeButton().clickRegistrationForm();
	 

}
}
