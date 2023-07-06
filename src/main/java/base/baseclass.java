package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

public class baseclass
{ 
	static protected WebDriver driver;
	public void launchbrowser() throws InterruptedException
	{
		driver=new ChromeDriver();
		driver.get("https://passport.alibaba.com/");
		driver.manage().window().maximize();
		Reporter.log("launching browser", true);
		Thread.sleep(1000);
	}
	
	public  void closebrowser()
	{
		Reporter.log("closing browser", true);
		driver.quit();
		
	}
  


}
