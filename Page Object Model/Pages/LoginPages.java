package Pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Parameters;

import Base.ProjectSpecificMethodsOlay;

public class LoginPages  extends ProjectSpecificMethodsOlay  
{
	
public LoginPages enterEmail()
{
	Reporter.log("Start Login");
	driver.findElement(By.xpath("(//input[@name='signInEmailAddress'])[2]|//input[@data-key='signInEmailAddress']")).sendKeys("Vaishu.rajend@gmail.com",
			Keys.TAB,"Newusersvaishu@94");
	
	return this;
}
public LoginPages enterPassword()
{
	driver.findElement(By.xpath("(//input[@name='signInEmailAddress'])[2]|//input[@data-key='signInEmailAddress']")).sendKeys(Keys.TAB,"Newusersvaishu@94");
	
	return this;
}
public LoginPages clickLogin() 
{
	
	driver.findElement(By.xpath("(//button[@type='submit'])[3]|//div[@class='form-container']//button[text()='Log in']|//input[@type='submit']")).click();
	Reporter.log("Email id is Vaishu.rajend@gmail.com");
	Reporter.log("Entered password is Newusersvaishu@94");
	Reporter.log("Click Login");
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return this;
}
public LoginPages oneButtonHandler() {
	try {
		driver.findElement(By.xpath("(//button[@id='onetrust-accept-btn-handler'])[1]")).click();
	} catch (Exception e) {
		e.printStackTrace();
	}
	return this;
}
public RegistrationPage verifyIncorrectPassword()  
{
	String incorrectGermany1="Die eingegebene Kombination aus Passwort und E-Mail-Adresse ist ungültig. Bitte versuchen Sie es erneut oder klicken Sie auf den Link unten, um ein neues Konto zu erstellen.";
	String incorrectSpanish1="La combinación de correo electrónico y la contraseña que has introducido es incorrecta. Por favor, inténtalo de nuevo, o haz clic en el siguiente enlace para crear una cuenta.";
	String incorrectUK1="Incorrect username or password. Please try again.";
	String ExpectedResult="WELCOME TO YOUR PROFILE";	
	String ActualResult = driver.findElement(By.xpath("(//header[@class='profile-header']/p)[1]")).getText();
	
	assertEquals(ExpectedResult,ActualResult,"Successfully Login");
		if(driver.findElement(By.xpath("//p[@class='FormErrorstyles__ErrorSentence-sc-1r4gczu-2 bvzjfU']|//span[@class='pc_error-message2']")).getText().equals(incorrectUK1))
		{
					Reporter.log(incorrectUK1);
					try {
						Thread.sleep(500);
					} catch (Exception e) {
						e.printStackTrace();
					}
															
		}	
		else if(driver.findElement(By.xpath("//p[@class='FormErrorstyles__ErrorSentence-sc-1r4gczu-2 bvzjfU']|//span[@class='pc_error-message2']")).getText().equals(incorrectSpanish1))
		{
			Reporter.log(incorrectSpanish1);
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				e.printStackTrace();
			}
					
					
		}
		
		else if(driver.findElement(By.xpath("//p[@class='FormErrorstyles__ErrorSentence-sc-1r4gczu-2 bvzjfU']|//span[@class='pc_error-message2']")).getText().equals(incorrectGermany1))
		{
			
			Reporter.log(incorrectGermany1);
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				e.printStackTrace();
			}
								
		}
		else if(driver.findElement(By.xpath("//header[@class='profile-header']/p[text()='Welcome To Your Profile']")).isDisplayed());
		{
			Reporter.log("Successfully logged in");
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				e.printStackTrace();
			}
					
		}
		
		
		return new RegistrationPage();
		
		
}
}
