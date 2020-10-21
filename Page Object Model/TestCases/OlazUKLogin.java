package TestCases;

import org.testng.annotations.Test;

import Base.ProjectSpecificMethodsOlay;

import Pages.UrlPageGermany;
import Pages.UrlPageSpanish;
import Pages.UrlPageUk;

public class OlazUKLogin extends ProjectSpecificMethodsOlay
{
	@Test
	public void ruOlazUkLogin() 
	{
		
	
		new UrlPageUk().putUrlUk().clickJoinButton().enterEmail().enterPassword().clickLogin()
		.verifyIncorrectPassword();

	}
}
