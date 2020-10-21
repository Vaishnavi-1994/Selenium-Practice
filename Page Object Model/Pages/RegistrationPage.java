package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import Base.ProjectSpecificMethodsOlay;

public class RegistrationPage extends ProjectSpecificMethodsOlay
{
	public RegistrationPage clickReg()
	{
		Reporter.log("Registartion Started");
		driver.findElement(By.xpath("//a[@class='createOne event_profile_register']")).click();
		Reporter.log("Click the Registartion");
		return this;
	}
public RegistrationPage genderclick() 
{
	driver.findElement(By.xpath("//img[@id='phdesktopbody_0_imgfemale']")).click();
	Reporter.log("Select gender as Female");
	return this;
}
public RegistrationPage enterFirstName() 
{
	driver.findElement(By.xpath("//input[@name='firstName']|//input[@data-key='firstName']")).sendKeys("Vaishnavi");
	Reporter.log("Enter FirstName");
	return this;
}
public RegistrationPage enterLastName() 
{
	driver.findElement(By.xpath("//input[@name='lastName']|//input[@data-key='lastName']")).sendKeys("Rajendran");
	Reporter.log("Enter lastName");
	return this;
}
public RegistrationPage enterEmailReg()
{
	driver.findElement(By.xpath("//input[@name='emailAddress']|//input[@data-key='emailAddress']")).sendKeys("vaishu.rajend@gmail.com");
	Reporter.log("Enter Email Id");
	return this;
}
public RegistrationPage enterPasswordReg()
{
	driver.findElement(By.xpath("//input[@name='newPassword']|//input[@data-key='newPassword']")).sendKeys("Newusersvaishu@94");
	Reporter.log("Enter Password");
	return this;
}
public RegistrationPage enterConfirmPasswordReg()
{
	driver.findElement(By.xpath("(//input[@type='password'])[2]")).sendKeys("Newusersvaishu@94");
	Reporter.log("Confirm password");
	return this;
}
public RegistrationPage selectDateOfBirth()
{
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,300)");
	Select date=new Select(driver.findElement(By.xpath("(//select[@class='FormSelectstyles__Select-e278vr-1 cqhSSS dropdown'])[1]|//select[@data-key='birthdate[dateselect_day]']")));
	date.selectByIndex(9);
	Reporter.log("Selected birthday date");
	Select month=new Select(driver.findElement(By.xpath("(//select[@class='FormSelectstyles__Select-e278vr-1 cqhSSS dropdown'])[2]|//select[@data-key='birthdate[dateselect_month]']")));
	month.selectByIndex(2);
	Reporter.log("Selected birthday month");
	Select year=new Select(driver.findElement(By.xpath("(//select[@class='FormSelectstyles__Select-e278vr-1 cqhSSS dropdown'])[3]|//select[@data-key='birthdate[dateselect_year]']")));
	year.selectByVisibleText("1994");
	Reporter.log("Selected birthday year");
	return this;
}	
public RegistrationPage countryName()
{
	Select country=new Select(driver.findElement(By.xpath("//select[@data-key='addressCountry']")));	
	country.selectByIndex(1);
	Reporter.log("Selected birthday Country");
	return this;
}
public RegistrationPage enterStreetAddress() 
{
	driver.findElement(By.xpath("//input[@data-key='addressStreet1']")).sendKeys("ABCDE Street - 64788");
	Reporter.log("Entered street address");
	return this;
}
public RegistrationPage enterCity() 
{
	driver.findElement(By.xpath("//input[@data-key='addressCity']")).sendKeys("Home");
	Reporter.log("Enter city");
	return this;
}
public RegistrationPage enterPhoneNumber() 
{
	driver.findElement(By.xpath("//input[@data-key='phone']")).sendKeys("+34933334442");
	Reporter.log("Enter Phone number");
	return this;
}
public RegistrationPage clickAgreeButton() 
{
	if(driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).isSelected())
	{
		Reporter.log("Terms and condition Agree button already clicked");
	}
	else
	{
		driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
		Reporter.log("Terms and condition Agree button click");
	}
	return this;
}
public RegistrationPage clickRegistrationForm() 
{
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,300)");
		driver.findElement(By.xpath("(//*[starts-with(@class,'button-link button')])|//button[@class='button-link event_profile_register_submit']")).click();
		Reporter.log("Submit Registration form");
		return this;
}
}
