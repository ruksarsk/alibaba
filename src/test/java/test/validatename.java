package test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.baseclass;
import pom.pom;
import utility.utility;
@Listeners(listners.listners.class)
public class validatename extends baseclass {
	 pom signin;
	
	@BeforeClass
 public void lauchbrowser() throws InterruptedException
 {
	 launchbrowser();
	 signin = new pom(driver);
 }

 
 @BeforeMethod
 public void signin() throws EncryptedDocumentException, IOException, InterruptedException
 {
	signin.enteremailid(utility.readdatafromExcel(1, 0));
	utility.waiting(500);
	signin.enterpasswrd(utility.readdatafromExcel(1, 1));
	utility.waiting(500);
	signin.clickonsignin();
	utility.waiting(500);
	
 }
	@Test
  public void f() {
	  
  }
}
