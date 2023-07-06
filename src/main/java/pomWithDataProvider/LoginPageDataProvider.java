package pomWithDataProvider;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageDataProvider 
{
	// Variable 
	
		@FindBy(xpath="//a[text()='Sign in']")private WebElement signInButton;
		@FindBy(xpath="(//input[@type='number'])[2]") private WebElement mobileNumber;
		@FindBy(xpath="(//span[text()='Sign in with Password'])[2]")private WebElement signInWithPassword;
		@FindBy(name="password")private WebElement passwordFeild;
		@FindBy(xpath="//span[text()='Sign in']")private WebElement sinInButton2;
		@FindBy(xpath="//div[text()='My Account']") private WebElement myAccount;
		@FindBy(xpath="//span[text()=' My profile ']")private WebElement myProfile;

		
		//Contructor

		public LoginPageDataProvider(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
			
		}
		// Methods
		public void ClickOnHomesignInButton()
		{
			signInButton.click();
		}
		public void ClickOnMobileNumber(String mno)
		{
			mobileNumber.sendKeys(mno);
		}
		
		public void ClickonSingInWithPassword()
		{
			signInWithPassword.click();
		}
		public void enterPassword(String pwd)
		{
			passwordFeild.sendKeys(pwd);
		}
		public void ClickonPasswordsingInbutton2()
		{
			sinInButton2.click();
		}
		public  void ClickOnmyAccountButton()
		{
			myAccount.click();
		}
		public void ClickOnmyProfileButton()
		{
			myProfile.click();
		}
		
	}

