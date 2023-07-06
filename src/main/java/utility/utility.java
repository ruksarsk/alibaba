package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
//import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

import net.bytebuddy.utility.RandomString;

public class utility 
{
	public static String readdatafromExcel(int row,int cell) throws EncryptedDocumentException, IOException
	{   
		FileInputStream myfile=new FileInputStream("D:\\Ruksar_Testing_work\\Ruksar_eclipse_Workspace\\mAlibaba\\testdataexcel\\Testdata.xlsx");
		String data = WorkbookFactory.create(myfile).getSheet("testdata").getRow(row).getCell(cell).getStringCellValue();
		Reporter.log("reading data from excel sheet", true);
		return data;
		
	}
	
	public static void screenshot( WebDriver driver,String myfile) throws IOException
	{ 
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String myss = RandomString.make(2);
		File des=new File("D:\\Ruksar_Testing_work\\Ruksar_eclipse_Workspace\\mAlibaba\\screenshot"+myfile+""+myss+".png");
		FileHandler.copy(src, des);
		Reporter.log("taking screenshot", true);
		
	}
	public static void waiting(int time) throws InterruptedException
	{
		Thread.sleep(time);
		Reporter.log("waiting for "+ time+"mili sec", true);
	}

}
