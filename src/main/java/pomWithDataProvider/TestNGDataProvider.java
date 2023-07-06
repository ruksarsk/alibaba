package pomWithDataProvider;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import commonmethoduse.CommonMethodStudy;
import policyBazarUsingPomAndTestng.LoginPage;
import pomPolicyBazzarforUtility.MyAccountPage;

public class TestNGDataProvider 
{
	
	WebDriver driver;
	LoginPage login;
	MyAccountPage myacc;
	
	@BeforeMethod
	public void lunchBroser()
	{
		driver=new ChromeDriver();
		driver.get("https://www.policybazaar.com/");
		driver.manage().window().maximize();
		login=new LoginPage(driver);
		myacc=new MyAccountPage(driver);
	}
    @Test(dataProvider = "policyBazzarData",dataProviderClass = PomWithPolicyBazzarDataProvider.class)
	public void verifyUserName(String mobno,String pwd,String expUN) throws InterruptedException
	{
		
		login.ClickOnHomesignInButton();
		CommonMethodStudy.implicitWait(driver, 2000);
		Reporter.log("Click on first home page sign in button", true);
		login.ClickOnMobileNumber("mobNum");
		
		CommonMethodStudy.implicitWait(driver, 2000);
		Reporter.log("Enter on Mobaile no", true);

		login.ClickonSingInWithPassword();
		CommonMethodStudy.implicitWait(driver, 2000);
		Reporter.log("Click on sign in With password button", true);

		login.enterPassword("pwd");
		CommonMethodStudy.implicitWait(driver, 2000);
		Reporter.log("Enter the password", true);

		login.ClickonPasswordsingInbutton2();
		CommonMethodStudy.implicitWait(driver, 2000);
		Reporter.log("Click on pawword  sign in button2", true);

		login.ClickOnmyAccountButton();
		CommonMethodStudy.implicitWait(driver, 3000);
		Reporter.log("Click on My AccountButton", true);

		login.ClickOnmyProfileButton();
		CommonMethodStudy.implicitWait(driver, 3000);
		Reporter.log("Click on My Profile button", true);

		
		Set<String> allwindowId = driver.getWindowHandles();
		List<String> l=new  ArrayList<>(allwindowId);
		//String mainpageId = l.get(0);
		String childpageid = l.get(1);
	    
	  driver.switchTo().window(childpageid);
    CommonMethodStudy.implicitWait(driver, 10000);			
	
       String ExpectedUn =expUN;
	  String ActualUn = myacc.getActualUserName1();
	  
	  Assert.assertEquals(ExpectedUn, ActualUn,"Expectun and actualun is not match test case is fail");
  }
  @AfterMethod
  public void logoutfromPolicyBazzr()
  {
	myacc.ClickOnlogOut();
	Reporter.log("Click on logoutButton", true);

  }
  @AfterClass
  public void closepolicyBazzar()
  {
	  driver.quit();
  }
}


