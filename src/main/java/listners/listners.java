package listners;

import java.io.IOException;

//import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import base.baseclass;
import utility.utility;

public class listners extends baseclass implements ITestListener
{
	  @Override
	 public  void onTestStart(ITestResult result)
	 { 
		  Reporter.log(result.getName()+"execution is start", true);
		   
     }
	  @Override
	  public void onTestSuccess(ITestResult result) 
	  {
		    Reporter.log(result.getName()+" is pass successful", true);
	  }
	   @Override
	  public void onTestFailure(ITestResult result) 
	   {   
		   //WebDriver driver = null;
		try {
			utility.screenshot(driver, result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   Reporter.log(result.getName()+"is failure", true);
		   
	   }
	   @Override
	  public void onTestSkipped(ITestResult result) 
	   {
		   Reporter.log(result.getName()+"is skipped", true); 
		}


}
