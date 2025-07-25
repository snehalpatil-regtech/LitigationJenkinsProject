package litigationMgmt;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import litigationAdditionalOwner.MethodsPOM;
import login.BasePage;

public class Mgmt extends BasePage{
	
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
//		//String workingDir = System.getProperty("user.dir");
//		fis = new FileInputStream("D:\\Litigation-Project 10 April2024\\Litigation-Project 10 April2024\\TestData\\LitigationSheet.xlsx");
//	
//		workbook = new XSSFWorkbook(fis);
//		sheet = workbook.getSheetAt(11);					//Retrieving second sheet of Workbook
//		return sheet;
//	}
	
	@BeforeTest
	void setBrowser() throws InterruptedException, IOException
	{
		String workingDir = System.getProperty("user.dir");
		System.out.println(workingDir);
		extent = new com.relevantcodes.extentreports.ExtentReports(workingDir+"//Reports//LitigationPerformer.html",true);
		test = extent.startTest("Litigation Logging In - Non Admin");
		test.log(LogStatus.PASS, "Test Passed = Verify Chrome browser.");
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 1)
	void Login() throws InterruptedException, IOException
	{
		test = extent.startTest("Litigation Logging In - Company Admin");
		test.log(LogStatus.INFO, "Logging into system");
		
		initialization("mgmt",11);
//		XSSFSheet sheet = ReadExcel();
//		Row row1 = sheet.getRow(1);						//Selected 1st index row (Second row)
//		Cell c1 = row1.getCell(1);						//Selected cell (1 row,1 column)
//		String uname = c1.getStringCellValue();			//Got the URL stored at position 1,1
//		
//		Row row2 = sheet.getRow(2);						//Selected 2nd index row (Third row)
//		Cell c2 = row2.getCell(1);						//Selected cell (2 row,1 column)
//		String password = c2.getStringCellValue();		//Got the URL stored at position 2,1
//		
//		driver = login.Login.UserLogin(uname,password,"company");		//Method of Login class to login user.
//		
//		test.log(LogStatus.PASS, "Test Passed.");
//		extent.endTest(test);
//		extent.flush();
	}
	
	@Test(priority = 2)
 	void CaseAdvocateBillTab() throws InterruptedException, IOException
 	{
 		test = extent.startTest("Case advocate bill verification");
 		
 		
 		MgmtMethod.AdvocateBill(driver, test);
 		
 		extent.endTest(test);
 		extent.flush();
 	}
	//@Test(priority = 3)
	void CaseAdvocateBill() throws InterruptedException, IOException
	{
		test = extent.startTest("Advocate bill verification");
		
		
		MgmtMethod.AdvocateBillTab(driver, test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 4)
	void CaseAdvocateBill1() throws InterruptedException, IOException
	{
		test = extent.startTest("Advocate bill verification");
		
		
		MgmtMethod.ApproverAssignmentLog(driver, test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 5)
	void Masters12() throws InterruptedException, IOException
	{
		test = extent.startTest("Masters - Advocate Bill Approver  verification");
		
		
		MgmtMethod.AdvocateBillApprover(driver, test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 6)
	void MyReports() throws InterruptedException, IOException
	{
		test = extent.startTest("Reports -excel count verification");
		
		
		MethodsPOM.MyReports( test, workbook, "Company Admin");
		
		extent.endTest(test);
		extent.flush();
	}

}
