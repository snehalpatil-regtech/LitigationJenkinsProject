package licensePerformer;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cfo.CFOcountPOM;
import login.BasePage;

public class LicensePerformerInternal extends BasePage
{
	public static WebDriver driver = null;		//WebDriver instance created
	public static WebElement upload = null;		//WebElement to get upload button
	public static ExtentReports extent;			//Instance created for report file
	public static ExtentTest test;				//Instance created for tests
	public static FileInputStream fis = null;	//File input stream variable
	public static XSSFWorkbook workbook = null;	//Excel sheet workbook variable
	public static XSSFSheet sheet = null;		//Sheet variable
	public static List<WebElement> elementsList = null;
	
//	public static XSSFSheet ReadExcel() throws IOException
//	{
//		String workingDir = System.getProperty("user.dir");
//		fis = new FileInputStream(workingDir+"//TestData//ComplianceSheet.xlsx");
//		workbook = new XSSFWorkbook(fis);
//		sheet = workbook.getSheetAt(0);					//Retrieving second sheet of Workbook
//		return sheet;
//	}
	
	@BeforeTest
	void setBrowser() throws InterruptedException, IOException
	{
		String workingDir = System.getProperty("user.dir");
		extent = new com.relevantcodes.extentreports.ExtentReports(workingDir+"//Reports//LitigationCompanyAdmin.html",true);
		test = extent.startTest("Litigation Logging In - Company Admin");
		test.log(LogStatus.PASS, "Test Passed = Verify chrome browser.");
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 1)
	void Login() throws InterruptedException, IOException
	{   
		test = extent.startTest("Logging In - Performer (Internal)");
		test.log(LogStatus.INFO, "Logging into system");
		
		initialization("companyAdmin",0);
//		XSSFSheet sheet = ReadExcel();
//		Row row1 = sheet.getRow(1);							//Selected 1st index row (Second row)
//		Cell c1 = row1.getCell(1);							//Selected cell (1 row,1 column)
//		String uname = c1.getStringCellValue();				//Got the URL stored at position 1,1
//		
//		Row row2 = sheet.getRow(2);							//Selected 2nd index row (Third row)
//		Cell c2 = row2.getCell(1);							//Selected cell (2 row,1 column)
//		String password = c2.getStringCellValue();			//Got the URL stored at position 2,1
//		
//		driver = login.Login.UserLogin(uname,password,"License");		//Method of Login class to login user.
//		
//		test.log(LogStatus.PASS, "Test Passed 2.");
//		extent.endTest(test);
//		extent.flush();
	}
	
	@Test(priority = 2)
	void Active() throws InterruptedException
	{
		test = extent.startTest("Active License Count Verification");
		test.log(LogStatus.INFO, "Test Initiated");
		
		WebDriverWait wait = new WebDriverWait(getDriver(),50);
		wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickType()));
		LiPerformerPOM.clickType().click();				//Clicking on 'Type' drop down.
		
		Select drp = new Select(LiPerformerPOM.clickType());
		drp.selectByIndex(1);
		
		try
		{
			Thread.sleep(400);
			wait.until(ExpectedConditions.invisibilityOf(LiPerformerPOM.Progress()));
		}
		catch(Exception e)
		{
			
		}
		
		Thread.sleep(500);
		CFOcountPOM.clickApply1().click();				//Clicking on Apply.
		
		LiPeMethodsPOM.ActiveLicense(test, "Internal");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 3)
	void Expiring() throws InterruptedException
	{
		test = extent.startTest("Expiring License Count Verification");
		test.log(LogStatus.INFO, "Test Initiated");
		
		WebDriverWait wait = new WebDriverWait(getDriver(),20);
		wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickType()));
		LiPerformerPOM.clickType().click();				//Clicking on 'Type' drop down.
		
		Select drp = new Select(LiPerformerPOM.clickType());
		drp.selectByIndex(1);
		
		try
		{
			Thread.sleep(400);
			wait.until(ExpectedConditions.invisibilityOf(LiPerformerPOM.Progress()));
		}
		catch(Exception e)
		{
			
		}
		
		Thread.sleep(500);
		CFOcountPOM.clickApply1().click();				//Clicking on Apply.
		
		LiPeMethodsPOM.ExpiringCount(test, "Internal");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 4)
	void Expired() throws InterruptedException
	{
		test = extent.startTest("Expired License Count Verification");
		test.log(LogStatus.INFO, "Test Initiated");
		
		WebDriverWait wait = new WebDriverWait(getDriver(),20);
		wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickType()));
		LiPerformerPOM.clickType().click();				//Clicking on 'Type' drop down.
		
		Select drp = new Select(LiPerformerPOM.clickType());
		drp.selectByIndex(1);
		
		try
		{
			Thread.sleep(400);
			wait.until(ExpectedConditions.invisibilityOf(LiPerformerPOM.Progress()));
		}
		catch(Exception e)
		{
			
		}
		
		Thread.sleep(500);
		CFOcountPOM.clickApply1().click();				//Clicking on Apply.
		
		LiPeMethodsPOM.ExpiredCount(test, "Internal");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 5)
	void Applied() throws InterruptedException
	{
		test = extent.startTest("Applied Count Verification");
		test.log(LogStatus.INFO, "Test Initiated");
		
		WebDriverWait wait = new WebDriverWait(getDriver(),20);
		wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickType()));
		LiPerformerPOM.clickType().click();				//Clicking on 'Type' drop down.
		
		Select drp = new Select(LiPerformerPOM.clickType());
		drp.selectByIndex(1);
		
		try
		{
			Thread.sleep(400);
			wait.until(ExpectedConditions.invisibilityOf(LiPerformerPOM.Progress()));
		}
		catch(Exception e)
		{
			
		}
		
		Thread.sleep(500);
		CFOcountPOM.clickApply1().click();				//Clicking on Apply.
		
		LiPeMethodsPOM.AppliedCount(test, "Internal");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 6)
	void MyDocuments() throws InterruptedException
	{
		test = extent.startTest("My Documents Download Verification");
		test.log(LogStatus.INFO, "Test Initiated");
		
		LiPeMethodsPOM.Documents(test, "Internal");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 7)
	void MyReports() throws InterruptedException, IOException
	{
		test = extent.startTest("My Reports Download verification");
		test.log(LogStatus.INFO, "Test Initiated");
		
		LiPeMethodsPOM.Reports(test, "Internal");
		
		extent.endTest(test);
		extent.flush();
	}
}
