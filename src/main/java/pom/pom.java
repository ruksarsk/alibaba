package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class pom 
{ //variabls 
	@FindBy(xpath = "(//input[@class='fm-text'])[1]")private WebElement Emailid;
	@FindBy(xpath = "(//input[@class='fm-text'])[2]")private WebElement password;
	@FindBy(xpath = "//input[@name='submit-btn']")private WebElement signinbutton;

	//constructor
	public pom(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//methods
	public void enteremailid(String email)
	{
		Emailid.sendKeys(email);
		Reporter.log("entring emailid", true);
	}
	public void enterpasswrd(String pwd)
	{
		password.sendKeys(pwd);
		Reporter.log("entring password", true);
	}
	public void clickonsignin()
	{
		signinbutton.click();
		Reporter.log("signing", true);
	}
}
