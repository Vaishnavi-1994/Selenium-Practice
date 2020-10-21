package TestCases;

import org.testng.annotations.Test;

import Base.ProjectSpecificMethodsOlay;

import Pages.UrlPageGermany;
import Pages.UrlPageSpanish;
import Pages.UrlPageUk;

public class OlazGermanyLogin extends ProjectSpecificMethodsOlay
{
	@Test
	public void runOlazGermanyLogin() 
	{
				 
	new UrlPageGermany().putUrlPageGermany().clickJoinButton().enterEmail().enterPassword().clickLogin().verifyIncorrectPassword();
	}
}