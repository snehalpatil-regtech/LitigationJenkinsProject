package litigationCompanyAdmin;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import litigationAdditionalOwner.MethodPOM1;
import litigationAdditionalOwner.performerPOM;
import litigationManagement.CFOMethod;
import login.BasePage;
import performer.OverduePOM;

public class CompanyAdmin extends BasePage
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
//		//String workingDir = System.getProperty("user.dir");
//		fis = new FileInputStream("D:\\Litigation-Project 10 April2024\\Litigation-Project 10 April2024\\TestData\\LitigationSheet.xlsx");
//	
//		workbook = new XSSFWorkbook(fis);
//		sheet = workbook.getSheetAt(4);					//Retrieving second sheet of Workbook
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
	
	@BeforeMethod
	
	void Login() throws InterruptedException, IOException
	{
		initialization("companyAdmin",4);
		
//		XSSFSheet sheet = ReadExcel();
//		Row row0 = sheet.getRow(0);						//Selected 0th index row (First row)
//		Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
//		String URL = c1.getStringCellValue();			//Got the URL stored at position 0,1
//		
//		login.Login.BrowserSetup(URL);					//Method of Login class to set browser.
//		
//		
//		Row row1 = sheet.getRow(1);						//Selected 1st index row (Second row)
//		Cell c2 = row1.getCell(1);						//Selected cell (1 row,1 column)
//		String uname = c2.getStringCellValue();			//Got the URL stored at position 1,1
//		
//		Row row2 = sheet.getRow(2);						//Selected 2nd index row (Third row)
//		Cell c3 = row2.getCell(1);						//Selected cell (2 row,1 column)
//		String password = c3.getStringCellValue();		//Got the URL stored at position 2,1
//		
//		driver = login.Login.UserLogin(uname,password,"company");		//Method of Login class to login user.
		
	}

	


	 
 
@Test(priority =0)
 	void NoticeOpen() throws InterruptedException, IOException
 	{
 		test = extent.startTest("Notice - Open Count Verification");
 		
 		
 		MethodsPOM.NoticeOpen( test, workbook, "Company Admin");
 		
 		test.log(LogStatus.PASS, "Test Passed.");
 		extent.endTest(test);
 		extent.flush();
 	}
@Test(priority =1)
		void NoticeWithExistingData() throws InterruptedException, IOException
		{
			test = extent.startTest("Notice With Existing Data verification");
		   MethodsPOM.NoticeWithExistingData( test, workbook);
		  extent.endTest(test);
			extent.flush();
		}
	
@Test(priority =2)
     void NoticeWithInvalidData() throws InterruptedException, IOException
    {
	     test = extent.startTest("Notice With Invalid Data verification");
	
	
	     MethodsPOM.NoticeWithInvalidData( test, workbook);
	
	     extent.endTest(test);
	     extent.flush();
   }
@Test(priority =3)
	   void NoticeWithTwoMandatoryData() throws InterruptedException, IOException
	  {
		     test = extent.startTest("Notice With Two Mandatory Fields verification");
		
		
		     MethodsPOM.NoticeWithTwoMandatoryData( test, workbook);
		
		     extent.endTest(test);
		     extent.flush();
	 }
	 
@Test(priority =4) 
	   void NoticeWithEmptyFields() throws InterruptedException, IOException
	  {
		     test = extent.startTest("Notice With Empty Fields verification");
		
		
		     MethodsPOM.NoticeWithEmptyFields( test);
		
		     extent.endTest(test);
		     extent.flush();
	 }
 
@Test(priority =5)
 	void NoticeClearBtn() throws InterruptedException, IOException
 	{
 		test = extent.startTest("Notice Summary -Clear button verification");
	
	
 		MethodsPOM.NoticeClearBtn( test);
	
	     extent.endTest(test);
	     extent.flush();
 	}
@Test(priority =6)
 void NoticeSendMailWithDoc() throws InterruptedException, IOException
{
	     test = extent.startTest("Notice Summary-Send Mail With Document verification");
	
	
	     MethodsPOM.NoticeSendMailWithDoc( test);
	
	     extent.endTest(test);
	     extent.flush();
}
 
@Test(priority =7)
 void NoticeSendMailWithDocInvalidFields() throws InterruptedException, IOException
 {
     test = extent.startTest(" Notice Summary -Send Mail With Document Invalid Fields verification");


     MethodsPOM.NoticeSendMailWithDocInvalidFields( test);

     extent.endTest(test);
     extent.flush();
 }
@Test(priority =8)
	void NoticeSendMailWithDocEmptyFields() throws InterruptedException, IOException
	{
	     test = extent.startTest("Notice Summary -Send Mail With Document Empty Fields verification");
	
	
	     MethodsPOM.NoticeSendMailWithDocEmptyFields( test);
	
	     extent.endTest(test);
	     extent.flush();
	}
  
//@Test(priority =9)
  	void NoticeUserAssignment() throws InterruptedException, IOException
 	{
	     test = extent.startTest("Notice User Assignment  verification");
	
         MethodsPOM.NoticeUserAssignment( test);
	
	     extent.endTest(test);
	     extent.flush();
 	}

@Test(priority =10)
void NoticeUserAssignmentDelete() throws InterruptedException, IOException
{
	     test = extent.startTest("Notice User Assignment Delete Icon  verification");
	
	
	     MethodsPOM.NoticeDeleteUserAssignment( test);
	
	     extent.endTest(test);
	     extent.flush();
}


 
   @Test(priority =11)
	void NoticeClosed() throws InterruptedException, IOException
	{
		test = extent.startTest("Notice - Closed Count Verification");
		
		
		MethodsPOM.NoticeClosed( test, "Performer");
		
		extent.endTest(test);
		extent.flush();
	}

@Test(priority = 12)
	void CaseOpen() throws InterruptedException, IOException
	{
		test = extent.startTest("Case - Open Count Verification");
		
		
		MethodsPOM.CaseOpen( test, "Performer");
		
		extent.endTest(test);
		extent.flush();
	}

 @Test(priority =13)
	void CaseExistingData() throws InterruptedException, IOException
	{
		test = extent.startTest("Case with Existing Data verification");
		
		
		MethodsPOM.CaseExistingData( test, workbook);
		
		extent.endTest(test);
		extent.flush();
	}
 
@Test(priority =14)
	void CaseWithInvalidData() throws InterruptedException, IOException
	{
		test = extent.startTest("Case with Invalid Data verification");
		
		
		MethodsPOM.CaseWithInvalidData( test, workbook);
		
		extent.endTest(test);
		extent.flush();
	}
@Test(priority =15)
	void CaseWithTwoFieldsData() throws InterruptedException, IOException
	{
		test = extent.startTest("Case with Two Manadatory fields verification");
		
		
		MethodsPOM.CaseWithTwoFieldsData( test);
		
		extent.endTest(test);
		extent.flush();
	}
@Test(priority =16)
	void CaseWithEmptyFields() throws InterruptedException, IOException
	{
		test = extent.startTest("Case with Empty fields verification");
		
		
		MethodsPOM.CaseWithEmptyFields( test);
		
		extent.endTest(test);
		extent.flush();
	}

@Test(priority =17)
	void CaseWithClearBtn() throws InterruptedException, IOException
	{
		test = extent.startTest("Case Summary - Clear button verification");
		
		
		MethodsPOM.CaseWithClearBtn( test);
		
		extent.endTest(test);
		extent.flush();
	}
	
@Test(priority =18)
	void CaseClose() throws InterruptedException, IOException
	{
		test = extent.startTest("Case - Closed Count Verification");
		
		MethodsPOM.CaseClosed( test, "Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	
@Test(priority = 19)
	void TaskOpen() throws InterruptedException, IOException
	{
		test = extent.startTest("Task - Open Count Verification");
		
		
		MethodsPOM.TaskOpen( test, "Performer");
		
		extent.endTest(test);
		extent.flush();
	}
@Test(priority = 20)
		void TaskwithExistingData() throws InterruptedException, IOException
		{
			test = extent.startTest("Task With existing data verification");
			
			
			MethodsPOM.TaskWithExistingData( test);
			
			extent.endTest(test);
			extent.flush();
		}
 @Test(priority =21)
		void TaskwithTwoManadatoryFields() throws InterruptedException, IOException
		{
			test = extent.startTest("Task With Two manadatory fields verification");
			
			
			MethodsPOM.TaskWithTwoMandatoryFields( test, workbook);
			
			extent.endTest(test);
			extent.flush();
		}
	 
  @Test(priority =22)
				void TaskwithoutData() throws InterruptedException, IOException
				{
					test = extent.startTest("Task Without  data verification");
					
					
					MethodsPOM.TaskwithoutData( test);
					
					extent.endTest(test);
					extent.flush();
				}
 @Test(priority =23)
				void TaskwithClearBtn() throws InterruptedException, IOException
				{
					test = extent.startTest("Task Clear button verification");
					
					
					MethodsPOM.TaskwithClearBtn( test);
					
					extent.endTest(test);
					extent.flush();
				}
 @Test(priority =24)
	void TaskShowDetailesClearBtn() throws InterruptedException, IOException
	{
		test = extent.startTest("Task-Show Detailes Icon -Clear button verification");
		
		
		MethodsPOM.TaskShowDetailesClearBtn( test);
		
		extent.endTest(test);
		extent.flush();
	}
  @Test(priority = 25)
		void TaskDelete() throws InterruptedException, IOException
		{
			test = extent.startTest("Task Delete verification");
			
			
			MethodsPOM.TaskDelete( test);
			
			extent.endTest(test);
			extent.flush();
		}
@Test(priority = 26)
	void TaskClosed() throws InterruptedException, IOException
	{
		test = extent.startTest("Task - Closed Count Verification");
		
		
		MethodsPOM.TaskClosed( test, "Performer");
		
		extent.endTest(test);
		extent.flush();
	}
@Test(priority = 26)
	void ClosedTask() throws InterruptedException, IOException
	{
		test = extent.startTest(" Closed Task Count verification");
		
		
		MethodsPOM.CloseNoticeCase( test, "Task","company admin");
		
		extent.endTest(test);
		extent.flush();
	}
@Test(priority = 27)
void LinkNotice() throws InterruptedException, IOException
{
	test = extent.startTest("Link Notice Verification");
	
	
	MethodsPOM.LinkDocument( test, "Notice");
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority =28)
	void LinkNoticeViewIcon() throws InterruptedException, IOException
	{
	     test = extent.startTest("Linked notice view icon  verification");
	
	

	 	MethodsPOM.LinkNoticeViewIcon( test);
	
	     extent.endTest(test);
	     extent.flush();
	}
@Test(priority =29)
  void LinkNoticeDeleteIcon() throws InterruptedException, IOException
	{
	     test = extent.startTest("Linked notice Delete icon  verification");
	
	

	 	MethodsPOM.LinkNoticeDeleteIcon( test);
	
	     extent.endTest(test);
	     extent.flush();
	}
@Test(priority = 30)
	void LinkCase() throws InterruptedException, IOException
	{
	test = extent.startTest("Link Case Verification");
    MethodsPOM.LinkDocument( test, "Case");
    extent.endTest(test);
	extent.flush();
   }
@Test(priority =31)
	   void LinkCaseViewIcon() throws InterruptedException, IOException
	  {
		     test = extent.startTest("Linked case view icon  verification");
		
		
		     MethodsPOM.LinkCaseViewIcon( test);
		
		     extent.endTest(test);
		     extent.flush();
	 }
@Test(priority =32)
	   void LinkCaseDeleteIcon() throws InterruptedException, IOException
	  {
		     test = extent.startTest("Linked case delete icon  verification");
		
		
		     MethodsPOM.LinkCaseDeleteIcon( test);
		
		     extent.endTest(test);
		     extent.flush();
	 }
	
@Test(priority =29)
	void CloseNotice() throws InterruptedException, IOException
	{
	test = extent.startTest("Close Notice Count Verification");
	MethodsPOM.CloseNoticeCase( test,"Notice","company admin");
	extent.endTest(test);
	extent.flush();
	}
@Test(priority = 30)
	void CloseCase() throws InterruptedException, IOException
	{
	test = extent.startTest("Close Case Count Verification");
		
		MethodsPOM.CloseNoticeCase( test,"Case","company admin");
		
	extent.endTest(test);
		extent.flush();
	}

@Test(priority =31)
	void NoticeClosedDoc() throws InterruptedException, IOException
	{
		test = extent.startTest("Close Notice Document verification");
		
		MethodsPOM.NoticeClosedDoc( test);
		
		extent.endTest(test);
		extent.flush();
	}
@Test(priority = 32)
	void NoticeClosedWithoutDoc() throws InterruptedException, IOException
	{
		test = extent.startTest("Close Notice Without Document verification");
		
		MethodsPOM.NoticeClosedWithoutDoc( test);
		
		extent.endTest(test);
		extent.flush();
	}


@Test(priority = 33)
	void CaseClosedDoc() throws InterruptedException, IOException
	{
		test = extent.startTest("Close Case Document verification");
		
		MethodsPOM.CaseClosedDoc( test);
		
		extent.endTest(test);
		extent.flush();
	}


@Test(priority = 34)
	void CaseClosedWithoutDoc() throws InterruptedException, IOException
	{
		test = extent.startTest("Close Case Without Document verification");
		
		MethodsPOM.CaseClosedWithoutDoc( test);
		
		extent.endTest(test);
		extent.flush();
	}
 	 
 	  
	
@Test(priority = 35)
	 	void NoticeDocumentTab() throws InterruptedException, IOException
	 	{
	 		test = extent.startTest("Notice Document verification");
	 		
	 		
	 		MethodsPOM.NoticeDocument( test);
	 		
	 		extent.endTest(test);
	 		extent.flush();
	 	}
	
@Test(priority = 36)
	void NoticeWithoutUploadDocument() throws InterruptedException, IOException
	{
		test = extent.startTest("Notice Without Upload Document verification");
		
		
		MethodsPOM.NoticeWithoutUploadDocument( test);
		
		extent.endTest(test);
		extent.flush();
	}
@Test(priority = 37)
	void NoticeDocumentSearchFields() throws InterruptedException, IOException
	{
		test = extent.startTest("Notice Document Search Fields verification");
		
		
		MethodsPOM.NoticeDocumentSearchFields( test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 38)
	void NoticeDocumentShareInvalidData() throws InterruptedException, IOException
	{
		test = extent.startTest("Notice Document Share with Invalid data verification");
		
		
		MethodsPOM.NoticeDocumentShareInvalidData( test);
		
		extent.endTest(test);
		extent.flush();
	}
	
@Test(priority =39)
		void NoticeDocumentShareWithoutData() throws InterruptedException, IOException
		{
			test = extent.startTest("Notice Document Share without data verification");
			
			
			MethodsPOM.NoticeDocumentShareWithoutData( test);
			
			extent.endTest(test);
			extent.flush();
		}
	
	@Test(priority = 40)
	void NoticeDocumentShareCloseBtn() throws InterruptedException, IOException
	{
		test = extent.startTest("Notice Document Share close button verification");
		
		
		MethodsPOM.NoticeDocumentShareCloseBtn( test);
		
		extent.endTest(test);
		extent.flush();
	}
@Test(priority =41)
	void NoticeTaskActivityTab() throws InterruptedException, IOException
	{
		test = extent.startTest("Notice Task/Activity verification");
		
		
		MethodsPOM.TaskActivtity( test);
		
		extent.endTest(test);
		extent.flush();
	}


@Test(priority =44)
	void TaskActivtityExistingData() throws InterruptedException, IOException
	{
		test = extent.startTest("Notice Task/Activtiy with existing data verification");
		
		
		MethodsPOM.TaskActivtityExistingData( test);
		
		extent.endTest(test);
		extent.flush();
	}

@Test(priority = 43)
	void TaskActivtityWithoutData() throws InterruptedException, IOException
	{
		test = extent.startTest("Notice Task/Activtiy Without data verification");
		
		
		MethodsPOM.TaskActivtityWithoutData( test);
		
		extent.endTest(test);
		extent.flush();
	}

@Test(priority = 44)
	void TaskActivtityResponseWithoutStatus() throws InterruptedException, IOException
	{
		test = extent.startTest("Notice Task/Activtiy Response Without data verification");
		
		
		MethodsPOM.TaskActivtityResponseWithoutStatus( test);
		
		extent.endTest(test);
		extent.flush();
	}

@Test(priority = 45)
	void TaskActivtityResponseClearBtn() throws InterruptedException, IOException
	{
		test = extent.startTest("Notice Task/Activtiy  Response clear button verification");
		
		
		MethodsPOM.TaskActivtityResponseClearBtn( test);
		
		extent.endTest(test);
		extent.flush();
	}

@Test(priority =46)
void TaskActivtityDeleteResponse() throws InterruptedException, IOException
{
	test = extent.startTest("Notice Task/Activtiy Delete Response verification");
	
	
	MethodsPOM.TaskActivtityDeleteResponse( test);
	
	extent.endTest(test);
	extent.flush();
}


@Test(priority = 47)
	void NoticeResponseTab() throws InterruptedException, IOException
	{
		test = extent.startTest("Notice Response tab verification");
		
		
		MethodsPOM.Response( test);
		
		extent.endTest(test);
		extent.flush();
	}

@Test(priority =48)
	void ResponseExistingData() throws InterruptedException, IOException
	{
		test = extent.startTest("Notice Response Existing Data verification");
	
	
		MethodsPOM.ResponseExistingData( test,workbook);
	
		extent.endTest(test);
		extent.flush();
	}

@Test(priority =49)
	void NoticeResponseWithoutData() throws InterruptedException, IOException
	{
		test = extent.startTest("Notice Response Without data verification");

		MethodsPOM.ResponseWithoutData( test);
	    extent.endTest(test);
		extent.flush();
}	

@Test(priority =50)
	void ResponseClearBtn() throws InterruptedException, IOException
	{
		test = extent.startTest("Notice Response Clear button verification");
		MethodsPOM.ResponseClearBtn( test);
	     extent.endTest(test);
	     extent.flush();
  }
@Test(priority = 51)
	void NoticePaymentLogTab() throws InterruptedException, IOException
	{
		test = extent.startTest("Notice PaymentLog tab verification");
		
		
		MethodsPOM.PaymentLog( test);
		
		extent.endTest(test);
		extent.flush();
	}

@Test(priority = 52)
	void PaymentLogwithExistingData() throws InterruptedException, IOException
	{
		test = extent.startTest("Notice Payment with existing data verification");
		MethodsPOM.PaymentLogExistingData(test);
	   extent.endTest(test);
	    extent.flush();
	}


@Test(priority = 53)
	void NoticePaymentWithoutData() throws InterruptedException, IOException
	{
		test = extent.startTest("Notice Payment Without data verification");
	
	
		MethodsPOM.PaymentLogWithoutData(test,workbook);
	
		extent.endTest(test);
		extent.flush();
}

@Test(priority = 54)
void PaymentLogwithInvalidData() throws InterruptedException, IOException
{
	test = extent.startTest("Notice Payment with Invalid data verification");
	
	
	MethodsPOM.PaymentLogwithInvalidData(test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 55)
	void NoticeExternalLawyerTab() throws InterruptedException, IOException
	{
		test = extent.startTest("Notice ExternalLawyerRating tab verification");
		
		
		MethodsPOM.ExternalLawyerRating( test);
		
		extent.endTest(test);
		extent.flush();
	}

@Test(priority = 56)
void ExternalLawyerWithoutRating() throws InterruptedException, IOException
{
	test = extent.startTest("Notice External Lawyer without rating verification");
	
	MethodsPOM.ExternalLawyerWithoutRating( test);
	
	extent.endTest(test);
	extent.flush();
}
	
@Test(priority =57)
	void CriteriaInvalidData() throws InterruptedException, IOException
	{
		test = extent.startTest("Notice Criteria Invalid Data verification");
		
		MethodsPOM.CriteriaInvalidData( test);
		
		extent.endTest(test);
		extent.flush();
	}
	
@Test(priority = 58)
	void CriteriaExistingData() throws InterruptedException, IOException
	{
		test = extent.startTest("Notice Criteria Existing Data verification");
		
		MethodsPOM.CriteriaExistingData( test);
		
		extent.endTest(test);
		extent.flush();
	}
	
@Test(priority =59)
	void CriteriaWithoutData() throws InterruptedException, IOException
	{
		test = extent.startTest("Notice Criteria Without Data verification");
		
		MethodsPOM.CriteriaWithoutData( test);
		
		extent.endTest(test);
		extent.flush();
	}
@Test(priority = 60)
	void NoticeAuditLogTab() throws InterruptedException, IOException
	{
		test = extent.startTest("Notice AuditLog tab verification");
		
	
		MethodsPOM.AuditLog( test);
		
		extent.endTest(test);
		extent.flush();
	}
@Test(priority = 61)
void NoticeDocViewandDownload() throws InterruptedException, IOException
{
	test = extent.startTest("Notice Document verification");
	
	
	MethodsPOM.NoticeDocViewandDownload( test);
	
	extent.endTest(test);
	extent.flush();
}

@Test(priority = 62)
 	void CaseDocumentTab() throws InterruptedException, IOException
 	{
 		test = extent.startTest("Case Document verification");
 		
 		
 		MethodsPOM.Document( test);
 		
 		extent.endTest(test);
 		extent.flush();
 	}
@Test(priority = 63)
 	void CaseWithoutUploadDocument() throws InterruptedException, IOException
 	{
 		test = extent.startTest("Case Document -Without Upload File verification");
 		
 		
 		MethodsPOM.CaseWithoutUploadDocument( test);
 		
 		extent.endTest(test);
 		extent.flush();
 	}
	
@Test(priority =64)
	void CaseDocumentEmptyFields() throws InterruptedException, IOException
	{
		test = extent.startTest("Case Document with empty fields verification");
		
		
		MethodsPOM.CaseDocumentEmptyFields( test);
		
		extent.endTest(test);
		extent.flush();
	}
@Test(priority =65)
	void CaseDocumentSearchFields() throws InterruptedException, IOException
	{
		test = extent.startTest("Case Document Search Fields verification");
		
		
		MethodsPOM.CaseDocumentSearchFields( test);
		
		extent.endTest(test);
		extent.flush();
	}
	
@Test(priority =66)
	void CaseDocumentShareInvalidData() throws InterruptedException, IOException
	{
		test = extent.startTest("Case Document Share with Invalid data verification");
		
		
		MethodsPOM.CaseDocumentShareInvalidData( test);
		extent.endTest(test);
		extent.flush();
	}
@Test(priority =67)
	void CaseDocumentShareWithoutData() throws InterruptedException, IOException
	{
		test = extent.startTest("Case Document Share without data verification");
		
		
		MethodsPOM.CaseDocumentShareWithoutData( test);
		
		extent.endTest(test);
		extent.flush();
	}
@Test(priority = 68)
	void CaseDocumentShareCloseBtn() throws InterruptedException, IOException
	{
		test = extent.startTest("Case Document Share close button verification");
		
		
		MethodsPOM.CaseDocumentShareCloseBtn( test);
		
		extent.endTest(test);
		extent.flush();
	}
	
@Test(priority =69)
    void CaseSendMailWithDoc() throws InterruptedException, IOException
   {
 	     test = extent.startTest("Case Summary-Send Mail With Document verification");
 	
 	    MethodsPOM.CaseSendMailWithDoc( test);
 	
 	     extent.endTest(test);
 	     extent.flush();
  }
 @Test(priority =70)
	    void CaseSendMailWithDocInvalidFields() throws InterruptedException, IOException
	   {
	 	     test = extent.startTest("Case  Summary-Send Mail With Document Invalid Fields verification");
	 	
	 	
	 	    MethodsPOM.CaseSendMailWithDocInvalidFields( test);
	 	
	 	     extent.endTest(test);
	 	     extent.flush();
	  }
@Test(priority =71)
	    void CaseSendMailWithEmptyFields() throws InterruptedException, IOException
	   {
	 	     test = extent.startTest("Case  Summary-Send Mail With Empty Fields verification");
	 	
	 	
	 	    MethodsPOM.CaseSendMailWithEmptyFields( test);
	 	
	 	     extent.endTest(test);
	 	     extent.flush();
	  }

//@Test(priority =72)
void CaseUserAssignment() throws InterruptedException, IOException
	{
		test = extent.startTest("Case User Assignment verification");
	
	
		MethodsPOM.CaseUserAssignment( test,workbook);
	
		extent.endTest(test);
		extent.flush();
	}
@Test(priority =73)
	void CaseUserAssignmentDelete() throws InterruptedException, IOException
	{
		test = extent.startTest("Case User Assignment Delete Icon  verification");

		
		MethodsPOM.CaseUserAssignmentDelete( test);

		extent.endTest(test);
		extent.flush();
	}
@Test(priority = 74)
 	void CaseTaskActivityTab() throws InterruptedException, IOException
 	{
 		test = extent.startTest("Case Task/Activity verification");
 		
 		
 		MethodsPOM.TaskActivity1( test,"Performer");
 		
 		extent.endTest(test);
 		extent.flush();
 	}
 	
@Test(priority = 75)
	void CaseTaskActivityWithoutData() throws InterruptedException, IOException
	{
		test = extent.startTest("Case Task/Activtiy Without data verification");
		
		
		MethodsPOM.CaseTaskActivityWithoutData( test);
		
		extent.endTest(test);
		extent.flush();
	}
 
 
@Test(priority = 76)
	void CaseTaskActivtityResponseWithoutStatus() throws InterruptedException, IOException
	{
		test = extent.startTest("Case Task/Activtiy Response Without data verification");
		
		
		MethodsPOM.CaseTaskActivtityResponseWithoutStatus( test);
		
		extent.endTest(test);
		extent.flush();
	}

@Test(priority =78)
	void CaseTaskActivtityResponseClearBtn() throws InterruptedException, IOException
	{
		test = extent.startTest("Case Task/Activtiy  Response clear button verification");
		
		
		MethodsPOM.CaseTaskActivtityResponseClearBtn( test);
		
		extent.endTest(test);
		extent.flush();
	}
@Test(priority = 79)
 	void CaseHearingTab() throws InterruptedException, IOException
 	{
 		test = extent.startTest("Case Hearing verification");
 		
 		
 		MethodsPOM.CaseHearing( test);
 		
 		extent.endTest(test);
 		extent.flush();
 	}
 	

 	
@Test(priority= 81)
 	  void CaseWithoutHearingData() throws InterruptedException, IOException
 	  {
 		test = extent.startTest("Case without hearing data Verification");
 		
 		
 		MethodsPOM.CaseHearingWithoutData( test);
 		
 		extent.endTest(test);
 		extent.flush();
 	  }
 	 
@Test(priority =82)
 	   void CaseHearingInvalidDate() throws InterruptedException, IOException
 	   {
 	 	test = extent.startTest("Case Invalid Hearing Date Verification");
 	 	
 	 	
 	 	MethodsPOM.CaseHearingInvalidDate( test);
 	 	
 	 	extent.endTest(test);
 	 	extent.flush();
 	   }
@Test(priority =83)
 	   void CaseHearingClearBtn() throws InterruptedException, IOException
 	   {
 	 	test = extent.startTest("Case heraing clear button Verification");
 	 	
 	 	
 	 	MethodsPOM.CaseHearingClearBtn( test);
 	 	
 	 	extent.endTest(test);
 	 	extent.flush();
 	   }


@Test(priority = 84)
 	void CaseOrderTab() throws InterruptedException, IOException
 	{
 		test = extent.startTest("Case Order verification");
 		
 		
 		MethodsPOM.CaseOrder( test,"Performer");
 		
 		extent.endTest(test);
 		extent.flush();
 	}
@Test(priority =85)
 		void CaseOrderExistingData() throws InterruptedException, IOException
 		{
 			test = extent.startTest("To check validation message displayed  for case order with existing data");

 		
 			MethodsPOM.CaseOrderWithExistingData( test);
 		
 			extent.endTest(test);
 			extent.flush();
 		}
@Test(priority =86)
		void CaseOrderWithoutData() throws InterruptedException, IOException
		{
			test = extent.startTest("To check validation message displayed  for case order without data");

		
			MethodsPOM.CaseOrderWithoutData( test);
		
			extent.endTest(test);
			extent.flush();
		}
@Test(priority =87)
	void CaseOrderwithClearBtn() throws InterruptedException, IOException
	{
		test = extent.startTest("Case Order with clear button");

	
		MethodsPOM.CaseOrderwithClearBtn( test);
	
		extent.endTest(test);
		extent.flush();
	}

//@Test(priority = 121)
 	void CaseAdvocateBillTab() throws InterruptedException, IOException
 	{
 		test = extent.startTest("Case advocate bill verification");
 	
 		
 		MethodsPOM.AdvocateBill( test);
 		
 		extent.endTest(test);
 		extent.flush();
 	}
@Test(priority = 88)
 	void StatusPayment() throws InterruptedException, IOException
 	{
 		test = extent.startTest("Case Status/Payment verification");
 	
 		
 		MethodsPOM.StatusPayment( test);
 		
 		extent.endTest(test);
 		extent.flush();
 	}
 	
@Test(priority = 89)
 	void StatusPaymentWithExistingData() throws InterruptedException, IOException
 	{
 		test = extent.startTest("Case Status/Payment with existing data verification");
 	
 		
 		MethodsPOM.StatusPaymentWithExistingData( test,workbook);
 		
 		extent.endTest(test);
 		extent.flush();
 	}
@Test(priority =90)
	void StatusPaymentWithoutdata() throws InterruptedException, IOException
	{
		test = extent.startTest("Case Status/Payment without data ");
		
		
		MethodsPOM.StatusPaymentWithoutdata( test);
		
		extent.endTest(test);
		extent.flush();
	}
@Test(priority =91)
void StatusPaymentwithInvaliddata() throws InterruptedException, IOException
{
	test = extent.startTest("Case Status/Payment with Invalid data ");
	
	
	MethodsPOM.StatusPaymentwithInvaliddata( test,workbook);
	
	extent.endTest(test);
	extent.flush();
}
 @Test(priority =92)
	void CaseStatusAppealtoNextCourt() throws InterruptedException, IOException
	{
		test = extent.startTest("Case Status Appeal to Next Court");
		
		
		MethodsPOM.CaseStatusAppealtoNextCourt( test);
		
		extent.endTest(test);
		extent.flush();
	}
	
@Test(priority =93)
	void CaseStatuswithEmptyFields() throws InterruptedException, IOException
	{
		test = extent.startTest("Case Status With Empty Fields");
		
		
		MethodsPOM.CaseStatuswithEmptyFields( test);
		
		extent.endTest(test);
		extent.flush();
	}
@Test(priority = 93)
 	void ExternalLawyer() throws InterruptedException, IOException
 	{
 		test = extent.startTest("Case External Lawyer verification");
 		
 		
 		MethodsPOM.ExternalLawyer( test,1);
 		
 		extent.endTest(test);
 		extent.flush();
 	}
 	
 	@Test(priority =94)
	void CaseExternalLawyerWitoutRating() throws InterruptedException, IOException
	{
		test = extent.startTest("Case - External Lawyer Without Rating");
		
		
		MethodsPOM.CaseExternalLawyerWitoutRating( test);
		
		extent.endTest(test);
		extent.flush();
	}
 	
@Test(priority =95)
 		void CaseExternalLawyerCriteria() throws InterruptedException, IOException
 		{
 			test = extent.startTest("Case - External Lawyer Rating -Add New Criteria ");
 			
 			
 			MethodsPOM.CaseExternalLawyerCriteria( test);
 			
 			extent.endTest(test);
 			extent.flush();
 		}
 	
@Test(priority = 96)
 	void CaseExistingCriteria() throws InterruptedException, IOException
 	{
 		test = extent.startTest("Case Criteria Existing Data verification");
 		
 		MethodsPOM.CaseExistingCriteria( test);
 		
 		extent.endTest(test);
 		extent.flush();
 	}
 	
	@Test(priority =97)
 		void CaseCriteriaInvalidData() throws InterruptedException, IOException
 		{
 			test = extent.startTest("Case Criteria Invalid Data verification");
 			
 			MethodsPOM.CaseCriteriaInvalidData( test);
 			
 			extent.endTest(test);
 			extent.flush();
 		}
 	
	@Test(priority =98)
 		void CaseCriteriaWithoutData() throws InterruptedException, IOException
 		{
 			test = extent.startTest("Case Criteria Without Data verification");
 			
 			MethodsPOM.CaseCriteriaWithoutData( test);
 			
 			extent.endTest(test);
 			extent.flush();
 		}
 @Test(priority = 99)
 	void Auditlog() throws InterruptedException, IOException
 	{
 		test = extent.startTest("Case Audit Log verification");
 		
 		
 		MethodsPOM.Auditlog(test);
 		
 		extent.endTest(test);
 		extent.flush();
 	}
 
 	
	

 	
 
@Test(priority = 100)
	void CaseHearing() throws InterruptedException, IOException
	{
		test = extent.startTest("Case Hearing  Verification");
		
		
		MethodsPOM.CaseHearing( test,"Performer","Company admin");
		
		extent.endTest(test);
		extent.flush();
	}
	
@Test(priority = 101)
	void AdvancedSearchworkspace() throws InterruptedException, IOException
	{
		test = extent.startTest("Advanced Search Workspace- excel  verification");
		
		MethodPOM1.AdvancedSearchWorkspace( test, "Company Admin");
		
		extent.endTest(test);
		extent.flush();
	}



@Test(priority = 102)
	void HearingCalender() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Case Hearing Calender Verification");
		
		
		MethodsPOM.HearingCalender( test,"Performer","Company admin");
		
		extent.endTest(test);
		extent.flush();
	}
	 @Test(priority = 103)
		void CaseNoticeTypeGraph() throws InterruptedException, IOException
		{
			test = extent.startTest("Select Notice from Notice/Case Filter to verify count of Case/Notice Type Summary graph");
			
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
		 	js.executeScript("window.scrollBy(0,900)");
		 	
		 	Thread.sleep(5000);
			performerPOM.clickDashboardCaseNoticeFilter().click();
			
			Thread.sleep(5000);
			performerPOM.clickDashboardNoticeFilter().click();
		  
		   	 Thread.sleep(5000);
			 performerPOM.clickDashboardApplyBtn().click();
			 
			 Thread.sleep(5000);
			int	OutwardPlaintiff = Integer.parseInt(performerPOM.CaseNoticeTypeOutwardPlaintiff().getText());	//Reading Notice Open count.
			int	InwardDefendent = Integer.parseInt(performerPOM.CaseNoticeTypeInwardDefendantNotice().getText());	//Reading Notice Open count.
			int	Petitioner = Integer.parseInt(performerPOM.CaseNoticeTypePetitionerNotice().getText());	//Reading Notice Open count.
			int	Respondent = Integer.parseInt(performerPOM.CaseNoticeTypeRespondentNotice().getText());	//Reading Notice Open count.
			int	Applicant = Integer.parseInt(performerPOM.CaseNoticeTypeApplicantNotice().getText());	//Reading Notice Open count.
			int	Complainanat = Integer.parseInt(performerPOM.CaseNoticeTypeComplainantNotice().getText());	//Reading Notice Open count.
			int	Defendant = Integer.parseInt(performerPOM.CaseNoticeTypeDefendantNotice().getText());	//Reading Notice Open count.
			int	Plaintiff = Integer.parseInt(performerPOM.CaseNoticeTypePlaintiffNotice().getText());	//Reading Notice Open count.
			
			
			Thread.sleep(3000);
			MethodsPOM.CaseNoticeTypeGraph( test,"Outward/Plaintiff Type",OutwardPlaintiff);
			Thread.sleep(3000);
			MethodsPOM.CaseNoticeTypeGraph(  test,"Inward/Defendent Type",InwardDefendent);
			Thread.sleep(3000);
			MethodsPOM.CaseNoticeTypeGraph( test,"Petitioner Type",Petitioner);
			Thread.sleep(3000);
			MethodsPOM.CaseNoticeTypeGraph(  test,"Respondent Type",Respondent);
			Thread.sleep(3000);
			MethodsPOM.CaseNoticeTypeGraph( test,"Applicant Type",Applicant);
			Thread.sleep(3000);
			MethodsPOM.CaseNoticeTypeGraph(  test,"Complianant Type",Complainanat);
			Thread.sleep(3000);
			MethodsPOM.CaseNoticeTypeGraph(  test,"Defendant Type",Defendant);
			Thread.sleep(3000);
			MethodsPOM.CaseNoticeTypeGraph(  test,"Plaintiff Type",Plaintiff);
			
			Thread.sleep(3000);
			OverduePOM.clickDashboard().click();
			
			extent.endTest(test);
			extent.flush();
		}

@Test(priority = 104)
void CaseNoticeTypeFilter() throws InterruptedException, IOException
{
	
	test = extent.startTest("Case Notice type summary graph Filter Verification");
	JavascriptExecutor js = (JavascriptExecutor) driver;
 	js.executeScript("window.scrollBy(0,900)");
 	
	Thread.sleep(3000);
	CFOMethod.CaseNoticeTypeFilter( test,"CaseNoticeTypeSummaryGraph");
	
	extent.endTest(test);
	extent.flush();
}

@Test(priority = 105)
void CaseNoticeStageGraph() throws InterruptedException, IOException
{
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,900)");
	
	Thread.sleep(5000);
	performerPOM.clickDashboardCaseNoticeFilter().click();

	Thread.sleep(5000);
	performerPOM.clickDashboardNoticeFilter().click();

	
	Thread.sleep(5000);
	performerPOM.clickDashboardApplyBtn().click();
	
	js.executeScript("window.scrollBy(0,850)");

	 String StageName =performerPOM.StageName().getText();
	 test = extent.startTest(" Select Notice from Notice/Case Filter :- "+StageName+" Stage :-  to verify count of Case/Notice Stage Summary graph ");
	
	MethodsPOM.CaseNoticeStageGraph( test,"cfo -");
	
	extent.endTest(test);
	extent.flush();
}
 @Test(priority = 106)
	void CaseNoticeStageFilter() throws InterruptedException, IOException
	{
	 
	 test = extent.startTest("Case Notice Stage summary graph Filter Verification");
		JavascriptExecutor js = (JavascriptExecutor) driver;
	 	js.executeScript("window.scrollBy(0,900)");
	 	
	 	
	 	Thread.sleep(3000);
	 	MethodsPOM.CaseNoticeStageFilter( test,"CaseNoticeStageSummaryHigh");
		
		
		extent.endTest(test);
		extent.flush();
	 	
	 	
	}


	@Test(priority =107)
	void RiskSummaryGraph() throws InterruptedException, IOException
	{
		test = extent.startTest("Select Notice from Notice/Case Filter to verify count of Risk Summary graph");
		
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
     	js.executeScript("window.scrollBy(0,800)");
     	
     	Thread.sleep(5000);
		performerPOM.clickDashboardCaseNoticeFilter().click();
		
		Thread.sleep(5000);
		performerPOM.clickDashboardNoticeFilter().click();
      
       	
		 Thread.sleep(5000);
		 performerPOM.clickDashboardApplyBtn().click();
		 Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,950)");
		

     	Thread.sleep(2000);
	    int	HighRisk = Integer.parseInt(performerPOM.RiskSummaryHigh().getText());	//Reading Notice Open count.
    	int	MediumRisk = Integer.parseInt(performerPOM.RiskSummaryMedium().getText());	//Reading Notice Open count.
    	int	LowRisk = Integer.parseInt(performerPOM.RiskSummaryLow().getText());	//Reading Notice Open count.
    	int	NotApplicableRisk = Integer.parseInt(performerPOM.RiskSummaryNotApplicable().getText());	//Reading Notice Open count.
    	
		
    	Thread.sleep(3000);
		MethodsPOM.RiskSummaryGraph( test,"High Risk",HighRisk);
		Thread.sleep(3000);
		MethodsPOM.RiskSummaryGraph( test,"Medium Risk",MediumRisk);
		Thread.sleep(3000);
		MethodsPOM.RiskSummaryGraph( test,"Low Risk",LowRisk);
		Thread.sleep(3000);
		MethodsPOM.RiskSummaryGraph( test,"Not Applicable Risk",NotApplicableRisk);
		
		
		Thread.sleep(3000);
		OverduePOM.clickDashboard().click();
	
		extent.endTest(test);
		extent.flush();
	}

 @Test(priority = 108)
	void RiskSummaryGraphFilter() throws InterruptedException, IOException
	{
	 
	 test = extent.startTest("Risk summary graph Filter Verification");
		JavascriptExecutor js = (JavascriptExecutor) driver;
	 	js.executeScript("window.scrollBy(0,900)");
	 	
	 	
	 	Thread.sleep(3000);
		CFOMethod.RiskSummaryGraphFilter( test,"RiskSummaryHigh");
		
		
		extent.endTest(test);
		extent.flush();
	 	
	 	
	}
 @Test(priority = 109)
 void DepartmentSummaryGraph() throws InterruptedException, IOException
 {
 	JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,800)");
 
		Thread.sleep(5000);
		performerPOM.clickDashboardCaseNoticeFilter().click();
	
		Thread.sleep(5000);
		performerPOM.clickDashboardNoticeFilter().click();

	
		Thread.sleep(5000);
		performerPOM.clickDashboardApplyBtn().click();
	
		 js.executeScript("window.scrollBy(0,950)");
	
		 String DeptName =performerPOM.DepartName().getText();
		 test = extent.startTest("Select Notice from Notice/Case Filter :- "+DeptName+" Dept :-  to verify count of Department Summary graph");
		
   
    Thread.sleep(3000);
    MethodsPOM.DepartmentSummaryGraph( test,"cfo -");

    extent.endTest(test);
    extent.flush();
 }
 @Test(priority = 110)
	void DepartmentSummaryGraphFilter() throws InterruptedException, IOException
	{
	 
	 test = extent.startTest("Department summary graph Filter Verification");
		JavascriptExecutor js = (JavascriptExecutor) driver;
	 	js.executeScript("window.scrollBy(0,900)");
	 	
	 	
	 	Thread.sleep(3000);
		CFOMethod.DepartmentSummaryGraphFilter( test,"DepartmentSummaryHigh");
		
		
		extent.endTest(test);
		extent.flush();
	 	
	 	
	}

 @Test(priority = 111)
 void LocationSummaryGraph() throws InterruptedException, IOException
 {
 	
 	
 	JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,800)");
		
		
		Thread.sleep(5000);
		performerPOM.clickDashboardCaseNoticeFilter().click();
		
		Thread.sleep(5000);
		performerPOM.clickDashboardNoticeFilter().click();
   
    	
	   Thread.sleep(5000);
	   performerPOM.clickDashboardApplyBtn().click();
	   
	   js.executeScript("window.scrollBy(0,1400)");
 	
 	  String LocationName =performerPOM.LocationName().getText();
		test = extent.startTest("Select Notice from Notice/Case Filter :- "+LocationName+" Location :-  to verify count of Location Summary graph");
		
   
    Thread.sleep(3000);
    MethodsPOM.LocationSummaryGraph( test,"cfo -");

    extent.endTest(test);
    extent.flush();
 }

 @Test(priority =112)
	void LocationSummaryGraphFilter() throws InterruptedException, IOException
	{
	 
	 	test = extent.startTest("Location summary graph Filter Verification");
		JavascriptExecutor js = (JavascriptExecutor) driver;
	 	js.executeScript("window.scrollBy(0,900)");
	 	
	 	
	 	Thread.sleep(3000);
		CFOMethod.LocationSummaryGraphFilter( test,"LocationSummaryHigh");
		
		
		extent.endTest(test);
		extent.flush();
	 	
	 	
	}


 @Test(priority = 113)
 void CategorySummaryGraph() throws InterruptedException, IOException
 {
 	JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,800)");
		
		Thread.sleep(5000);
		performerPOM.clickDashboardCaseNoticeFilter().click();
		
		Thread.sleep(5000);
		performerPOM.clickDashboardNoticeFilter().click();
   
    	
		Thread.sleep(5000);
		performerPOM.clickDashboardApplyBtn().click();
		
	   	js.executeScript("window.scrollBy(0,1700)");
 	
 	
 	
 	Thread.sleep(2000);
	//	String CategoryName =performerPOM.CategoryName().getText();
 	//test = extent.startTest("Select Notice type Filter ="+CategoryName+" Category - To check Category Summary Graph Count Verification");
	test = extent.startTest("Select Notice from Notice/Case Filter :- Company Law Category :-  to verify count of Category Summary graph");
	
    Thread.sleep(3000);
    MethodsPOM.CategorySummaryGraph( test,"cfo -");

    extent.endTest(test);
    extent.flush();
 }
 
 @Test(priority =114)
	void CategorySummaryGraphFilter() throws InterruptedException, IOException
	{
	 
	 	test = extent.startTest("Category summary graph Filter Verification");
		JavascriptExecutor js = (JavascriptExecutor) driver;
	 	js.executeScript("window.scrollBy(0,900)");
	 	
	 	
	 	Thread.sleep(3000);
	 	MethodsPOM.CategorySummaryGraphFilter( test,"CategorySummaryHigh");
		
		
		extent.endTest(test);
		extent.flush();
	 	
	 	
	}





 @Test(priority = 115)
	void InwardDefendantAgeingGraph() throws InterruptedException, IOException
	{
	     test = extent.startTest("Select Notice from Notice/Case Filter to verify count of Ageing(Less than year) Summary graph");
	     
	     JavascriptExecutor js = (JavascriptExecutor) driver;
		     	js.executeScript("window.scrollBy(0,800)");
		     	
		     	Thread.sleep(5000);
				performerPOM.clickDashboardCaseNoticeFilter().click();
				
				Thread.sleep(5000);
				performerPOM.clickDashboardNoticeFilter().click();
	   
	    	
				 Thread.sleep(5000);
				 performerPOM.clickDashboardApplyBtn().click();
				 Thread.sleep(3000);
				js.executeScript("window.scrollBy(0,3700)");
				Thread.sleep(3000);
			    int	InwardDefendent = Integer.parseInt(performerPOM.clickInwardDefendentNoticeCA().getText());	//Reading Notice Open count.
		    	int	OutwardPlaintiff = Integer.parseInt(performerPOM.clickOutwardPlaintiffNoticeAgeing().getText());	//Reading Notice Open count.
		    	int	Petitioner = Integer.parseInt(performerPOM.clickPetitionerNoticeCA().getText());	//Reading Notice Open count.
		    	int	Respondent = Integer.parseInt(performerPOM.clickRespondentNoticeCA().getText());	//Reading Notice Open count.
		    //	int	Defendant = Integer.parseInt(performerPOM.clickDefendantNoticeCA().getText());	//Reading Notice Open count.
				
		    	Thread.sleep(3000);
		    	MethodsPOM.InwardDefendantAgeingGraph( test,"Inward/Defendent",InwardDefendent);
				Thread.sleep(3000);
				MethodsPOM.InwardDefendantAgeingGraph( test,"Outward/Plaintiff",OutwardPlaintiff);
				Thread.sleep(3000);
				MethodsPOM.InwardDefendantAgeingGraph( test,"Petitioner",Petitioner);
				Thread.sleep(3000);
				MethodsPOM.InwardDefendantAgeingGraph( test,"Respondent",Respondent);
				//Thread.sleep(3000);
				//MethodsPOM.InwardDefendantAgeingGraph( test,"Defendant",Defendant);
				
				Thread.sleep(3000);
				OverduePOM.clickDashboard().click();
	    
	      extent.endTest(test);
	      extent.flush();
	}



//@Test(priority =116)
void LessThanYearGraphFilter() throws InterruptedException, IOException
{
 
 	test = extent.startTest("Less Than Year graph Filter Verification");
	JavascriptExecutor js = (JavascriptExecutor) driver;
 	js.executeScript("window.scrollBy(0,900)");
 	
 	
 	Thread.sleep(3000);
 	MethodsPOM.LessThanYearGraphFilter( test,"LessThanYear");
	
	
	extent.endTest(test);
	extent.flush();
 	
 	
}
@Test(priority =117)

void AgeingGraph1to2years() throws InterruptedException, IOException
{
   		test = extent.startTest("Select Notice from Notice/Case Filter to verify count of Ageing(1 to 2 year) Summary graph");
   
   		JavascriptExecutor js = (JavascriptExecutor) driver;
        	js.executeScript("window.scrollBy(0,800)");
 		Thread.sleep(5000);
 		performerPOM.clickDashboardCaseNoticeFilter().click();
	
		Thread.sleep(5000);
		performerPOM.clickDashboardNoticeFilter().click();

	
		Thread.sleep(5000);
		performerPOM.clickDashboardApplyBtn().click();
   
		js.executeScript("window.scrollBy(0,3700)");
		Thread.sleep(5000);
		int Applicant = Integer.parseInt(performerPOM.clickApplicantNoticeCA1To2Years().getText());	//Reading Notice Open count.
		int Complainant = Integer.parseInt(performerPOM.clickComplianantNoticeCA1To2Years().getText());	//Reading Notice Open count.
	    int	InwardDefendent = Integer.parseInt(performerPOM.clickInwardDefendentNoticeCA1to2().getText());	//Reading Notice Open count.
	    int	OutwardPlaintiff = Integer.parseInt(performerPOM.clickOutwardPlaintiffNoticeCA1To2Years().getText());	//Reading Notice Open count.
	    int	Petitioner = Integer.parseInt(performerPOM.clickPetitionerNoticeCA1To2Years().getText());	//Reading Notice Open count.
	   // int	Respondent = Integer.parseInt(performerPOM.clickRespondentNoticeCA1To2Years().getText());	//Reading Notice Open count.
  	
	    
	    
	    Thread.sleep(3000);
	   MethodsPOM.AgeingGraph1to2years( test,"Applicant",Applicant);
  		Thread.sleep(3000);
  		MethodsPOM.AgeingGraph1to2years( test,"Complainant",Complainant);
  		Thread.sleep(3000);
  		MethodsPOM.AgeingGraph1to2years( test,"Inward/Defendent",InwardDefendent);
		Thread.sleep(3000);
		MethodsPOM.AgeingGraph1to2years( test,"Outward/Plaintiff",OutwardPlaintiff);
		Thread.sleep(3000);
		MethodsPOM.AgeingGraph1to2years( test,"Petitioner",Petitioner);
		//Thread.sleep(3000);
		//MethodsPOM.AgeingGraph1to2years( test,"Respondent",Respondent);
		
		Thread.sleep(3000);
		OverduePOM.clickDashboard().click();
  
		extent.endTest(test);
		extent.flush();
}

@Test(priority =117)
void AgeingGraph1to2yearsGraphFilter() throws InterruptedException, IOException
{
 
 	test = extent.startTest("Ageing Graph 1to2years Filter Verification");
	JavascriptExecutor js = (JavascriptExecutor) driver;
 	js.executeScript("window.scrollBy(0,900)");
 	
 	
 	Thread.sleep(3000);
 	MethodsPOM.Ageing1To2YearGraphFilter( test,"AgeingGraph1to2yearsGraph");
	
	
	extent.endTest(test);
	extent.flush();
 	
 	
}




@Test(priority = 118)
void AgeingGraph2to3years() throws InterruptedException, IOException
{
  	test = extent.startTest("Select Notice from Notice/Case Filter to verify count of Ageing(2 to 3 year) Summary graph");
 
   	JavascriptExecutor js = (JavascriptExecutor) driver;
 		js.executeScript("window.scrollBy(0,800)");
 	
 		Thread.sleep(5000);
		performerPOM.clickDashboardCaseNoticeFilter().click();
		
		Thread.sleep(5000);
		performerPOM.clickDashboardNoticeFilter().click();

	
		 Thread.sleep(5000);
		 performerPOM.clickDashboardApplyBtn().click();
		
		 js.executeScript("window.scrollBy(0,4000)");
		 Thread.sleep(5000);
	   
		 int InwardDefendent = Integer.parseInt(performerPOM.clickInwardDefendentNoticeCA2to3().getText());	//Reading Notice Open count.
		 int Applicant = Integer.parseInt(performerPOM.clickApplicantNoticeCA2to3().getText());	//Reading Notice Open count.
		 int OutwardPlainftiff = Integer.parseInt(performerPOM.clickOutwardPlaintiffNoticeCA2to3().getText());	//Reading Notice Open count.
		 int Petitioner = Integer.parseInt(performerPOM.clickPetitionerNoticeCA2to3().getText());	//Reading Notice Open count.
		 int Plaintiff = Integer.parseInt(performerPOM.clickPlaintiffNoticeCA2to3().getText());	//Reading Notice Open count.
		 
	    Thread.sleep(3000);
	    MethodsPOM.AgeingGraph2to3years( test,"Inward/Defendent",InwardDefendent);
		Thread.sleep(3000);
		MethodsPOM.AgeingGraph2to3years(  test,"Applicant",Applicant);
 		Thread.sleep(3000);
 		MethodsPOM.AgeingGraph2to3years(  test,"OutwardPlainftiff",OutwardPlainftiff);
 		Thread.sleep(3000);
 		MethodsPOM.AgeingGraph2to3years(  test,"Petitioner",Petitioner);
 		Thread.sleep(3000);
 		MethodsPOM.AgeingGraph2to3years(  test,"Plaintiff",Plaintiff);
	
		Thread.sleep(3000);
		OverduePOM.clickDashboard().click();

		extent.endTest(test);
		extent.flush();
}	
@Test(priority =119)
void AgeingGraph2to3yearsGraphFilter() throws InterruptedException, IOException
{
 
 	test = extent.startTest("Ageing Graph 2to3years Filter Verification");
	JavascriptExecutor js = (JavascriptExecutor) driver;
 	js.executeScript("window.scrollBy(0,900)");
 	
 	
 	Thread.sleep(3000);
 	MethodsPOM.Ageing2To3YearGraphFilter( test,"AgeingGraph2to3yearsGraph");
	
	
	extent.endTest(test);
	extent.flush();
 	
 	
}
@Test(priority = 120)
void AgeingGraphMorethan3years() throws InterruptedException, IOException
{
    test = extent.startTest("Select Notice from Notice/Case Filter to verify count of Ageing(more than 3 year) Summary graph");
 
    	JavascriptExecutor js = (JavascriptExecutor) driver;
 		js.executeScript("window.scrollBy(0,800)");
 	
 		Thread.sleep(5000);
		performerPOM.clickDashboardCaseNoticeFilter().click();
		
		Thread.sleep(5000);
		performerPOM.clickDashboardNoticeFilter().click();

	
		 Thread.sleep(5000);
		 performerPOM.clickDashboardApplyBtn().click();
		 Thread.sleep(3000);
		 js.executeScript("window.scrollBy(0,3850)");
		 Thread.sleep(3000);
		 int InwardDefendent = Integer.parseInt(performerPOM.clickInwardDefendentMorethan3years().getText());	//Reading Notice Open count.
		 int Complainant = Integer.parseInt(performerPOM.clickComplainantMorethan3years().getText());	//Reading Notice Open count.
		 int OutwardPlaintiff = Integer.parseInt(performerPOM.clickOutwardPlaintiffMorethan3years().getText());	//Reading Notice Open count.
		 int Petitioner = Integer.parseInt(performerPOM.clickPetitionerMorethan3years().getText());	//Reading Notice Open count.
		 int Respondent = Integer.parseInt(performerPOM.clickRespondentMorethan3years().getText());	//Reading Notice Open count.
		 
		 Thread.sleep(3000);
		 MethodsPOM.AgeingGraphMorethan3years( test,"Inward/Defendent",InwardDefendent);
		 MethodsPOM.AgeingGraphMorethan3years( test,"Complainant",Complainant);
		 MethodsPOM.AgeingGraphMorethan3years( test,"Outward/Plaintiff",OutwardPlaintiff);
		 MethodsPOM.AgeingGraphMorethan3years( test,"Petitioner",Petitioner);
		 MethodsPOM.AgeingGraphMorethan3years( test,"Respondent",Respondent);
		 
		  Thread.sleep(3000);
		 OverduePOM.clickDashboard().click();

		 extent.endTest(test);
		 extent.flush();
}	


//@Test(priority =121)
void AgeingMoreThanYearGraphFilter() throws InterruptedException, IOException
{
 
 	test = extent.startTest("Ageing Graph More Than 3 Filter Verification");
	JavascriptExecutor js = (JavascriptExecutor) driver;
 	js.executeScript("window.scrollBy(0,900)");
 	
 	
 	Thread.sleep(3000);
 	MethodsPOM.AgeingMoreThanYearGraphFilter( test,"AgeingGraphMoreThan3yearsGraph");
	
	
	extent.endTest(test);
	extent.flush();
 	
 	
}

@Test(priority =122)
void CaseNoticeTypeGraph1() throws InterruptedException, IOException
{
	test = extent.startTest("Select Case from Notice/Case Filter to verify count of Case/Notice Summary graph");
	
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("window.scrollBy(0,900)");

    Thread.sleep(5000);
	performerPOM.clickDashboardCaseNoticeFilter().click();
	
	Thread.sleep(5000);
	performerPOM.clickDashboardCaseFilter().click();

	
	 Thread.sleep(5000);
	 performerPOM.clickDashboardApplyBtn().click();
	 Thread.sleep(5000);
	
	int	InwardDefendent = Integer.parseInt(performerPOM.CaseNoticeTypeInwardDefendentCase().getText());	//Reading Notice Open count.
	int	Applicant = Integer.parseInt(performerPOM.CaseNoticeTypeApplicantCase().getText());	//Reading Notice Open count.
	int	Appellant = Integer.parseInt(performerPOM.CaseNoticeTypeAppleantCase().getText());	//Reading Notice Open count.
	int	Complianant = Integer.parseInt(performerPOM.CaseNoticeTypeComplianantCase().getText());	//Reading Notice Open count.
	int	Petitioner = Integer.parseInt(performerPOM.CaseNoticeTypePetitionerCase().getText());	//Reading Notice Open count.
	int	OutwardPlaintiff = Integer.parseInt(performerPOM.CaseNoticeTypeOutwardPalintiffCaseGraph().getText());	//Reading Notice Open count.
	int	Respondent = Integer.parseInt(performerPOM.CaseNoticeTypeRespondentCase().getText());	//Reading Notice Open count.

	
    Thread.sleep(3000);
    MethodsPOM.CaseNoticeTypeGraph1( test,"Inward/Defendent Type",InwardDefendent);
    Thread.sleep(3000);
    MethodsPOM.CaseNoticeTypeGraph1( test,"Applicant",Applicant);
	Thread.sleep(3000);
	MethodsPOM.CaseNoticeTypeGraph1( test,"Appellant",Appellant);
	Thread.sleep(3000);
	MethodsPOM.CaseNoticeTypeGraph1( test,"Complianant",Complianant);
	Thread.sleep(3000);
	MethodsPOM.CaseNoticeTypeGraph1( test,"Petitioner",Petitioner);
	Thread.sleep(3000);
	MethodsPOM.CaseNoticeTypeGraph1( test,"Outward/Plaintiff Type",OutwardPlaintiff);
	Thread.sleep(3000);
	MethodsPOM.CaseNoticeTypeGraph1( test,"Respondent",Respondent);
	Thread.sleep(3000);
	MethodsPOM.CaseNoticeTypeGraph1( test,"Petitioner",Petitioner);
	Thread.sleep(3000);
	MethodsPOM.CaseNoticeTypeGraph1( test,"Respondent",Respondent);
	
	
	Thread.sleep(3000);
	OverduePOM.clickDashboard().click();
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 123)
void CaseNoticeStageGraph1() throws InterruptedException, IOException
   { 
	   JavascriptExecutor js = (JavascriptExecutor) driver;
	   js.executeScript("window.scrollBy(0,800)");
  	
	   Thread.sleep(5000);
	   performerPOM.clickDashboardCaseNoticeFilter().click();
	
	   Thread.sleep(3000);
	   performerPOM.clickDashboardCaseFilter().click();
	
	   Thread.sleep(3000);
	   performerPOM.clickDashboardApplyBtn().click();
	
	   js.executeScript("window.scrollBy(0,500)");
	
	   Thread.sleep(3000);
	   String StageName =performerPOM.CaseStageName1().getText();
		test = extent.startTest("Select Case from Notice/Case Filter :- "+StageName+" Stage:- To verify count of Case/Notice Summary graph");
 	
		Thread.sleep(3000);
		MethodsPOM.CaseNoticeStageGraph1( test,"cfo -");
 	
		extent.endTest(test);
		extent.flush();
   }
@Test(priority = 124)
void RiskSummaryGraph1() throws InterruptedException, IOException
{
	test = extent.startTest("Select Case from Notice/Case Filter to verify count of Risk Summary graph");
    
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,800)");
 	
 	Thread.sleep(5000);
	performerPOM.clickDashboardCaseNoticeFilter().click();
	
	Thread.sleep(5000);
	performerPOM.clickDashboardCaseFilter().click();
  
   	
	 Thread.sleep(5000);
	 performerPOM.clickDashboardApplyBtn().click();
	 Thread.sleep(3000);
	js.executeScript("window.scrollBy(0,950)");
	
    int	HighRisk = Integer.parseInt(performerPOM.RiskSummaryHigh().getText());	//Reading Notice Open count.
	int	MediumRisk = Integer.parseInt(performerPOM.RiskSummaryMedium().getText());	//Reading Notice Open count.
	int	LowRisk = Integer.parseInt(performerPOM.RiskSummaryLow().getText());	//Reading Notice Open count.
	int	NotApplicableRisk = Integer.parseInt(performerPOM.RiskSummaryNotApplicable().getText());	//Reading Notice Open count.
	
	
	Thread.sleep(3000);
	MethodsPOM.RiskSummaryGraph1( test,"High Risk",HighRisk);
	Thread.sleep(3000);
	MethodsPOM.RiskSummaryGraph1( test,"Medium Risk",MediumRisk);
	Thread.sleep(3000);
	MethodsPOM.RiskSummaryGraph1( test,"Low Risk",LowRisk);
	Thread.sleep(3000);
	MethodsPOM.RiskSummaryGraph1( test,"Not Applicable Risk",NotApplicableRisk);

	Thread.sleep(3000);
	OverduePOM.clickDashboard().click();
	
	extent.endTest(test);
	extent.flush();
}

@Test(priority = 125)
 void DepartmentSummaryGraph1() throws InterruptedException, IOException
{
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,800)");

	Thread.sleep(5000);
	performerPOM.clickDashboardCaseNoticeFilter().click();

	Thread.sleep(5000);
	performerPOM.clickDashboardCaseFilter().click();

	
	Thread.sleep(5000);
	performerPOM.clickDashboardApplyBtn().click();
	
	 js.executeScript("window.scrollBy(0,950)");

//	 String DeptName =performerPOM.DepartName().getText();
//	 test = extent.startTest("Select type Case Filter :- "+DeptName+" Department -To check Department Summary Graph Count Verification");
	 test = extent.startTest("Select Case from Notice/Case Filter :-HR Department:- To verify count of Department Summary graph");
	 
   Thread.sleep(3000);
   MethodsPOM.DepartmentSummaryGraph1( test,"cfo -");

   extent.endTest(test);
   extent.flush();
}
@Test(priority = 126)
void LocationSummaryGraph1() throws InterruptedException, IOException
{
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,800)");
	
	
	Thread.sleep(5000);
	performerPOM.clickDashboardCaseNoticeFilter().click();
	
	Thread.sleep(5000);
	performerPOM.clickDashboardCaseFilter().click();
  
   	
   Thread.sleep(5000);
   performerPOM.clickDashboardApplyBtn().click();
   
   js.executeScript("window.scrollBy(0,1300)");
	
//	  String LocationName =performerPOM.LocationName().getText();
//		test = extent.startTest("Select Case type Filter :- "+LocationName+" Location - To check Location Summary Graph Count Verification");
		test = extent.startTest("Select Case from Notice/Case Filter :- Branch Pune Location:- To verify count of Location Summary graph");
  
   Thread.sleep(3000);
   MethodsPOM.LocationSummaryGraph1( test,"cfo -");

   extent.endTest(test);
   extent.flush();
}


@Test(priority = 127)
   void CategorySummaryGraph1() throws InterruptedException, IOException
{
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,800)");
	
	Thread.sleep(5000);
	performerPOM.clickDashboardCaseNoticeFilter().click();
	
	Thread.sleep(5000);
	performerPOM.clickDashboardCaseFilter().click();
  
   	
	Thread.sleep(5000);
	performerPOM.clickDashboardApplyBtn().click();
	
   	js.executeScript("window.scrollBy(0,1700)");
	
	
	
	Thread.sleep(2000);
//		String CategoryName =performerPOM.CategoryName().getText();
//	test = extent.startTest("Select Case type Filter ="+CategoryName+" Category - To check Category Summary Graph Count Verification");
	test = extent.startTest("Select Case from Notice/Case Filter :-CNType Category:- To verify count of category Summary graph");
	
   Thread.sleep(3000);
   MethodsPOM.CategorySummaryGraph1( test,"cfo -");

   extent.endTest(test);
   extent.flush();
}

	@Test(priority =128)
		void ExpensesCaseGraph() throws InterruptedException, IOException
		{
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,800)");
     	
	     	Thread.sleep(5000);
			performerPOM.clickDashboardCaseNoticeFilter().click();
			
			Thread.sleep(5000);
			performerPOM.clickDashboardCaseFilter().click();
	      
	       	
			 Thread.sleep(5000);
			 performerPOM.clickDashboardApplyBtn().click();
		
       	
			js.executeScript("window.scrollBy(0,2400)");
		  
		   Thread.sleep(2000);
			String ExpenseCase =performerPOM.ExpensesCaseNo().getText();
			
			test = extent.startTest("Select Case from Notice/Case Filter :- "+ExpenseCase+" :- To verify count of Expense case wise graph");
		   
		   Thread.sleep(3000);
		   MethodsPOM.ExpensesCaseGraph( test,"cfo -");
		
		   extent.endTest(test);
		   extent.flush();
		}
			@Test(priority =129)
		void ExpensesCategoryWiseCaseGraph() throws InterruptedException, IOException
		{
		
				JavascriptExecutor js = (JavascriptExecutor) driver;
				
			 	js.executeScript("window.scrollBy(0,800)");
		     	
		     	Thread.sleep(5000);
				performerPOM.clickDashboardCaseNoticeFilter().click();
				
				Thread.sleep(5000);
				performerPOM.clickDashboardCaseFilter().click();
	          
	           	
				 Thread.sleep(5000);
				 performerPOM.clickDashboardApplyBtn().click();
				
		       	
				js.executeScript("window.scrollBy(0,2500)");
		   
				Thread.sleep(2000);
			String ExpenseCategory =performerPOM.ExpensesCategoryNo().getText();
			
			test = extent.startTest("Select Case from Notice/Case Filter :- "+ExpenseCategory+" :- To verify count of Expense category wise graph");
		   
		   Thread.sleep(3000);
		   MethodsPOM.ExpensesCategoryWiseCaseGraph( test,"cfo -");
		
		   extent.endTest(test);
		   extent.flush();
		}
			@Test(priority =130)
		void ExpensesCounselWiseCaseGraph() throws InterruptedException, IOException
		{
				
				JavascriptExecutor js = (JavascriptExecutor) driver;
		     	js.executeScript("window.scrollBy(0,800)");
		     	
		     	Thread.sleep(5000);
				performerPOM.clickDashboardCaseNoticeFilter().click();
				
				Thread.sleep(5000);
				performerPOM.clickDashboardCaseFilter().click();
	          
	           	
				 Thread.sleep(5000);
				 performerPOM.clickDashboardApplyBtn().click();
				
		       	
					js.executeScript("window.scrollBy(0,3000)");	
					
					Thread.sleep(2000);
					String ExpensesCansilNo =performerPOM.ExpensesCansilNo().getText();
					
					test = extent.startTest("Select Case from Notice/Case Filter :- "+ExpensesCansilNo+" :- To verify count of Expense counsel wise graph");

		
			Thread.sleep(3000);
			MethodsPOM.ExpensesCounselWiseCaseGraph( test,"cfo -");
			
			extent.endTest(test);
			extent.flush();
		}
			@Test(priority =131)
		void UtilizedBudgetGraph() throws InterruptedException, IOException
		{
		test = extent.startTest("Select Case from Notice/Case Filter to verify count of Utilized budget graph");
		
		Thread.sleep(3000);
		MethodsPOM.UtilizedBudgetGraph( test,"cfo -");
		
		extent.endTest(test);
		extent.flush();
		}
@Test(priority =132)
void AgeingGraph() throws InterruptedException, IOException
{
			test = extent.startTest("Select Case from Notice/Case Filter to verify count of Ageing(Less than year) Summary graph");
     
     		JavascriptExecutor js = (JavascriptExecutor) driver;
	     	js.executeScript("window.scrollBy(0,800)");
	     	
	     	Thread.sleep(5000);
			performerPOM.clickDashboardCaseNoticeFilter().click();
			
			Thread.sleep(5000);
			performerPOM.clickDashboardCaseFilter().click();
   
    	
			 Thread.sleep(5000);
			 performerPOM.clickDashboardApplyBtn().click();
			 Thread.sleep(3000);
			js.executeScript("window.scrollBy(0,3700)");
			 Thread.sleep(3000);
			 
			 int Applicant = Integer.parseInt(performerPOM.clickApplicantLessThanYearCase().getText());	//Reading Notice Open count.
			 int Complainant = Integer.parseInt(performerPOM.clickComplainantLessThanYearCase().getText());	//Reading Notice Open count.
			 int InwardDefendent = Integer.parseInt(performerPOM.clickInwardDefendentLessThanYearCase().getText());	//Reading Notice Open count.
			 int Appellant = Integer.parseInt(performerPOM.clickAppellantLessThanYearCase().getText());	//Reading Notice Open count.
			 int OutwardPlaintiff = Integer.parseInt(performerPOM.clickOutwardPlaintiffLessthanyearCase().getText());	//Reading Notice Open count.
	    	 int Petitioner = Integer.parseInt(performerPOM.clickPetitionerLeassThanYearCase().getText());	//Reading Notice Open count.
	    	 int Respondent = Integer.parseInt(performerPOM.clickRespondentLessThanYearCase().getText());	//Reading Notice Open count.
	    	
			
	    	 
	    	 Thread.sleep(3000);
	    	 MethodsPOM.AgeingGraphLessThanYear( test,"Applicant",Applicant);
		    Thread.sleep(3000);
		    MethodsPOM.AgeingGraphLessThanYear( test,"Complainant",Complainant);
	    	Thread.sleep(3000);
	    	MethodsPOM.AgeingGraphLessThanYear( test,"Inward/Defendent",InwardDefendent);
	    	Thread.sleep(3000);
	    	MethodsPOM.AgeingGraphLessThanYear( test,"Appellant",Appellant);
			Thread.sleep(3000);
			MethodsPOM.AgeingGraphLessThanYear( test,"Outward/Plaintiff",OutwardPlaintiff);
			Thread.sleep(3000);
			MethodsPOM.AgeingGraphLessThanYear( test,"Petitioner",Petitioner);
			Thread.sleep(3000);
			MethodsPOM.AgeingGraphLessThanYear( test,"Respondent",Respondent);
			
			
			Thread.sleep(3000);
			OverduePOM.clickDashboard().click();
    
			extent.endTest(test);
			extent.flush();
}

@Test(priority =133)
void AgeingGraph1to2yearsCase() throws InterruptedException, IOException
{
     	test = extent.startTest("Select Case from Notice/Case Filter to verify count of Ageing(1 to 2 year) Summary graph");
     
     	JavascriptExecutor js = (JavascriptExecutor) driver;
     	js.executeScript("window.scrollBy(0,800)");
     	
     	Thread.sleep(5000);
		performerPOM.clickDashboardCaseNoticeFilter().click();
		
		Thread.sleep(5000);
		performerPOM.clickDashboardCaseFilter().click();
		
		Thread.sleep(5000);
		 performerPOM.clickDashboardApplyBtn().click();
		
		 js.executeScript("window.scrollBy(0,3700)");
		 Thread.sleep(3000);
	    int	Complianant = Integer.parseInt(performerPOM.clickComplianant1to2yearCase().getText());	//Reading Notice Open count.
    	int	InwardDefendent = Integer.parseInt(performerPOM.clickInwardOutward1to2yearsCase().getText());	//Reading Notice Open count.
    	int	Appleant = Integer.parseInt(performerPOM.clickAppleant1to2YearCase().getText());	//Reading Notice Open count.
    	int	Outwardplaintiff = Integer.parseInt(performerPOM.clickOutwardplaintiff1toyearCase().getText());	//Reading Notice Open count.
    	int	Petitioner = Integer.parseInt(performerPOM.clickPetitioner1toyearCase().getText());	//Reading Notice Open count.
    	int	Respondent = Integer.parseInt(performerPOM.clickRespondent1toyearCase().getText());	//Reading Notice Open count.
    	
    	Thread.sleep(3000);
    	MethodsPOM.AgeingGraph1to2yearsCase(test,"Complianant",Complianant);
		Thread.sleep(3000);
		MethodsPOM.AgeingGraph1to2yearsCase(test,"Inward/Defendent",InwardDefendent);
		Thread.sleep(3000);
		MethodsPOM.AgeingGraph1to2yearsCase(test,"Appleant",Appleant);
		Thread.sleep(3000);
		MethodsPOM.AgeingGraph1to2yearsCase(test,"Outward/plaintiff",Outwardplaintiff);
		Thread.sleep(3000);
		MethodsPOM.AgeingGraph1to2yearsCase(test,"Petitioner",Petitioner);
		Thread.sleep(3000);
		MethodsPOM.AgeingGraph1to2yearsCase(test,"Respondent",Respondent);
		
		Thread.sleep(3000);
		OverduePOM.clickDashboard().click();
    
      extent.endTest(test);
      extent.flush();
 }


@Test(priority =134)
void AgeingGraph2to3yearsCase() throws InterruptedException, IOException
{
     	test = extent.startTest("Select Case from Notice/Case Filter to verify count of Ageing(2 to 3 year) Summary graph");
     
     	JavascriptExecutor js = (JavascriptExecutor) driver;
     	js.executeScript("window.scrollBy(0,800)");
     	
     	Thread.sleep(5000);
		performerPOM.clickDashboardCaseNoticeFilter().click();
		
		Thread.sleep(5000);
		performerPOM.clickDashboardCaseFilter().click();
   
    	
		 Thread.sleep(5000);
		 performerPOM.clickDashboardApplyBtn().click();
		
		js.executeScript("window.scrollBy(0,3850)");
		 Thread.sleep(3000);
	    int	Applicant = Integer.parseInt(performerPOM.clickApplicant2to3yearCase().getText());	//Reading Notice Open count.
    	int	OutwardPlaintiff = Integer.parseInt(performerPOM.clickOutwardPlaintiff2To3YearCase().getText());	//Reading Notice Open count.
    	int	Respondent = Integer.parseInt(performerPOM.clickRespondent2To3YearCase().getText());	//Reading Notice Open count.
    
		Thread.sleep(3000);
		MethodsPOM.AgeingGraph2to3yearsCase( test,"Applicant",Applicant);
		Thread.sleep(3000);
		MethodsPOM.AgeingGraph2to3yearsCase( test,"Outward/Plaintiff",OutwardPlaintiff);
		Thread.sleep(3000);
		MethodsPOM.AgeingGraph2to3yearsCase( test,"Respondent",Respondent);
		
		
		
		Thread.sleep(3000);
		OverduePOM.clickDashboard().click();
    
		extent.endTest(test);
		extent.flush();
 }
@Test(priority =135)
void AgeingGraphMoreThan3yearsCase() throws InterruptedException, IOException
{
     test = extent.startTest("Select Case from Notice/Case Filter to verify count of Ageing(more than 3 year) Summary graph");
     
     JavascriptExecutor js = (JavascriptExecutor) driver;
     	js.executeScript("window.scrollBy(0,800)");
     	
     	Thread.sleep(5000);
		performerPOM.clickDashboardCaseNoticeFilter().click();
		
		Thread.sleep(5000);
		performerPOM.clickDashboardCaseFilter().click();
   
    	
		 Thread.sleep(5000);
		 performerPOM.clickDashboardApplyBtn().click();
		 Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,3850)");
		
	    int	InwardDefendent = Integer.parseInt(performerPOM.clickInwardDefendentCAMoreThan3yearsCase().getText());	//Reading Notice Open count.
    	int	Appleant = Integer.parseInt(performerPOM.clickAppleantCaseCAMoreThan3years().getText());	//Reading Notice Open count.
    	int	Petitioner = Integer.parseInt(performerPOM.clickPetitionerCaseCAMoreThan3years().getText());	//Reading Notice Open count.

		
    	Thread.sleep(3000);
    	MethodsPOM.AgeingGraphMoreThan3yearsCase( test,"Inward/Defendent",InwardDefendent);
		Thread.sleep(3000);
		MethodsPOM.AgeingGraphMoreThan3yearsCase( test,"Appleant",Appleant);
		Thread.sleep(3000);
		MethodsPOM.AgeingGraphMoreThan3yearsCase( test,"Petitioner",Petitioner);
		
		Thread.sleep(3000);
		OverduePOM.clickDashboard().click();
    
      extent.endTest(test);
      extent.flush();
 }
	  
@Test(priority = 141)
	void MyDocument() throws InterruptedException, IOException
	{
		test = extent.startTest("My Document-Download and View Document");
		
		
		MethodsPOM.MyDocument( test, workbook);
		
		extent.endTest(test);
		extent.flush();
	}
	
 //@Test(priority = 142)
		void ClosedCaseDoc() throws InterruptedException, IOException
		{
			test = extent.startTest("Closed case document verification");
					 	
			MethodsPOM.ClosedCaseDoc( test);
			extent.endTest(test);
		     extent.flush();
		}
// @Test(priority = 143)
	void ClosedNoticeDoc() throws InterruptedException, IOException
	{
		test = extent.startTest("Closed notice document verification");
				 	
		MethodsPOM.ClosedNoticeDoc( test);
		extent.endTest(test);
	     extent.flush();
	}
@Test(priority = 142)
	void ShareCaseDocument() throws InterruptedException, IOException
	{
		test = extent.startTest("My Document-Share Case Document Verification");
	
		
		MethodsPOM.ShareCaseDocument( test, workbook);
		
		extent.endTest(test);
		extent.flush();
	}
	
	
@Test(priority = 143)
		void ShareNoticeDocument() throws InterruptedException, IOException
		{
			test = extent.startTest("My Document-Share Notice Document Verification");
		
			MethodsPOM.ShareNoticeDocument( test, workbook);
			
			extent.endTest(test);
			extent.flush();
		}
@Test(priority =144)
		void ShareTaskDocument() throws InterruptedException, IOException
		{
			test = extent.startTest("My Document-Share Task Document Verification");
		
			
			MethodsPOM.ShareTaskDocument( test, workbook);
			
			extent.endTest(test);
			extent.flush();
		}
	
@Test(priority = 145)
	void AdvancedSearchDoc() throws InterruptedException, IOException
	{
		test = extent.startTest("Advanced Search Document-Download and View Document");
		
		
		MethodsPOM.AdvancedSearchDocument( test, "Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	
@Test(priority = 146)
	void AdvancedSearchShareCaseDocument() throws InterruptedException, IOException
	{
		test = extent.startTest("My Document-Advanced search-Share Case Document Verification");
	
		
		MethodsPOM.AdvancedSearchShareCaseDocument( test);
		
		extent.endTest(test);
		extent.flush();
	}
@Test(priority =147)
			void AdvancedSearchShareNoticeDocument() throws InterruptedException, IOException
			{
				test = extent.startTest("My Document-Advanced search-Share Notice Document Verification");
			
				
				MethodsPOM.AdvancedSearchShareNoticeDocument( test);
				
				extent.endTest(test);
				extent.flush();
			}

//@Test(priority = 148)
void AdvancedSearchClosedNoticeDoc() throws InterruptedException, IOException
{
	test = extent.startTest("My Document-Advanced search- Closed notice document verification");
			 	
	MethodsPOM.AdvancedSearchClosedNoticeDoc( test);
	extent.endTest(test);
     extent.flush();
}
//@Test(priority = 148)
void AdvancedSearchClosedCaseDoc() throws InterruptedException, IOException
{
	test = extent.startTest("My Document-Advanced search- Closed case document verification");
			 	
	MethodsPOM.AdvancedSearchClosedCaseDoc( test);
	extent.endTest(test);
     extent.flush();
}
@Test(priority =148)
			void AdvancedSearchShareTaskDocument() throws InterruptedException, IOException
			{
				test = extent.startTest("My Document-Advanced search-Share Task Document Verification");
			
				
				MethodsPOM.AdvancedSearchShareTaskDocument( test);
				
				extent.endTest(test);
				extent.flush();
			}
@Test(priority = 149) 		//Sever is blocking and not allowing to upload the file.
			void CriticalDocuments() throws InterruptedException, IOException
			{
				test = extent.startTest(" Critical Document Verification");
				
				MethodsPOM.CriticalDocuments( test);
				
				extent.endTest(test);
				extent.flush();
			}
			
	@Test(priority = 150) 		//Sever is blocking and not allowing to upload the file.
			void CriticalDocuments1() throws InterruptedException, IOException
			{
				test = extent.startTest(" Critical Document Verification");
				
				MethodsPOM.CriticalDocuments1( test);
				
				extent.endTest(test);
				extent.flush();
			}

	@Test(priority = 151)
	void MyReports() throws InterruptedException, IOException
	{
		test = extent.startTest("Reports -excel count verification");
		
		
		MethodsPOM.MyReports( test, "Company Admin");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 152)
	void AdvancedSearch() throws InterruptedException, IOException
	{
		test = extent.startTest("Advanced Search Reports excel  verification");
		
		
		MethodPOM1.AdvancedSearchReport( test, "Company Admin");
		
		extent.endTest(test);
		extent.flush();
	}
  
@Test(priority = 153)
	void MoreReports() throws InterruptedException, IOException
	{
		test = extent.startTest("More Report-Reports excel  verification");
		
		
		MethodsPOM.MoreReport( test, "Company Admin");
		
		extent.endTest(test);
		extent.flush();
	}
    
	
@Test(priority = 154)
	void MyReminder() throws InterruptedException, IOException
	{
		test = extent.startTest("My Reminder verification");
		
		
		MethodsPOM.MyReminder( test);
		
		extent.endTest(test);
		extent.flush();
	}

@Test(priority =155)
void ReminderWithoutData() throws InterruptedException, IOException
{
	test = extent.startTest("My Reminder Without data verification");
	
	MethodsPOM.ReminderWithoutData( test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 156)
	void ImportUtility() throws InterruptedException, IOException
	{
		test = extent.startTest("Import Utility verification");
	
		
		MethodsPOM.ImportUtility(test);
		extent.endTest(test);
		extent.flush();
	}

@Test(priority = 157)
void ImportUtilityWithoutData() throws InterruptedException, IOException
{
	test = extent.startTest("Upload Empty File Import Utility verification");
	
	
	MethodsPOM.ImportUtilityWithoutData(test);
	extent.endTest(test);
	extent.flush();
}

@Test(priority = 158)
void ImportUtilityInvalidData() throws InterruptedException, IOException
{
	test = extent.startTest("Enter Invalid data in Upload File Import Utility verification");
	
	
	MethodsPOM.ImportUtilityInvalidData(test);
	extent.endTest(test);
	extent.flush();
}

@Test(priority = 159)
void ImportUtilityTwoManadtoryFileds() throws InterruptedException, IOException
{
	test = extent.startTest("Enter Two Manadtory fields in Upload File Import Utility verification");
	
	
	MethodsPOM.ImportUtilityTwoManadtoryFileds(test);
	extent.endTest(test);
	extent.flush();
}


@Test(priority = 160)
	void CaseUpdationImportUtility() throws InterruptedException, IOException
	{
		test = extent.startTest("Case Updation Import Utility verification");
		
		
		MethodsPOM.CaseUpdationImportUtility(test);
		extent.endTest(test);
		extent.flush();
	}
@Test(priority = 161)
	void CaseUpdationUploadEmtyFile() throws InterruptedException, IOException
	{
		test = extent.startTest("Case Updation -Empty File Import Utility verification");
		
		
		MethodsPOM.CaseUpdationUploadEmtyFile(test);
		extent.endTest(test);
		extent.flush();
	}
@Test(priority = 162)
	void CaseUpdationUploadInvalidData() throws InterruptedException, IOException
	{
		test = extent.startTest("Case Updation -Invalid Data Import Utility verification");
		
		MethodsPOM.CaseUpdationUploadInvalidData(test);
		extent.endTest(test);
		extent.flush();
	}
@Test(priority = 163)
	void CaseUpdationUploadInvalidFile() throws InterruptedException, IOException
	{
		test = extent.startTest("Case Updation -Invalid File Import Utility verification");
		
		
		MethodsPOM.CaseUpdationUploadInvalidFile(test);
		extent.endTest(test);
		extent.flush();
	}

@Test(priority = 164)
	void NoticeUpdation() throws InterruptedException, IOException
	{
		test = extent.startTest("Notice Updation Import Utility verification");
		
		
		MethodsPOM.NoticeUpdation(test);
		extent.endTest(test);
		extent.flush();
	}
@Test(priority = 165)
void NoticeUpdationUploadEmtyFile() throws InterruptedException, IOException
{
	test = extent.startTest("Notice Updation-Empty File Import Utility verification");
	
	
	MethodsPOM.NoticeUpdationUploadEmtyFile(test);
	extent.endTest(test);
	extent.flush();
}
@Test(priority =166)
void NoticeUpdationUploadInvalidData() throws InterruptedException, IOException
{
	test = extent.startTest("Notice Updation -Invalid Data Import Utility verification");
	
	
	MethodsPOM.NoticeUpdationUploadInvalidData(test);
	extent.endTest(test);
	extent.flush();
}

@Test(priority = 167)
void NoticeUpdationUploadInvalidFile() throws InterruptedException, IOException
{
	test = extent.startTest("Notice Updation -Invalid File Import Utility verification");
	
	
	MethodsPOM.NoticeUpdationUploadInvalidFile(test);
	extent.endTest(test);
	extent.flush();
}

	
//@Test(priority = 153)
		void CaseAdvocateBill() throws InterruptedException, IOException
		{
			test = extent.startTest("Advocate bill verification");
			
			
			MethodsPOM.AdvocateBillTab( test);
			
			extent.endTest(test);
			extent.flush();
		}
	//	@Test(priority = 154)
		void CaseAdvocateBill1() throws InterruptedException, IOException
		{
			test = extent.startTest("Advocate bill verification");
			
			
			MethodsPOM.ApproverAssignmentLog( test);
			
			extent.endTest(test);
			extent.flush();
		}
	

@Test(priority = 168)
	void Masters() throws InterruptedException, IOException
	{
		test = extent.startTest("Masters - Legal Entity  verification");
		
		
		MethodsPOM.LegalEntity( test);
		
		extent.endTest(test);
		extent.flush();
	}
@Test(priority = 169)
void MastersLegalEntity() throws InterruptedException, IOException
	{
		test = extent.startTest("Masters - Legal Entity Without data verification");
		
		MethodsPOM.LegalEntityWithoutData( test);
		
		extent.endTest(test);
		extent.flush();
	}
@Test(priority =170)
void MastersLegalEntity1() throws InterruptedException, IOException
	{
		test = extent.startTest("Masters - Legal Entity Invalid data verification");
		
		MethodsPOM.LegalEntityInvalidData( test);
		
		extent.endTest(test);
		extent.flush();
	}

@Test(priority =171)
void MastersLegalEntity2() throws InterruptedException, IOException
	{
		test = extent.startTest("Masters - Legal Entity Two Manadatory Fields verification");
		
		MethodsPOM.LegalEntityTwoManadatoryFields( test);
		
		extent.endTest(test);
		extent.flush();
	}
@Test(priority =172)
		void MastersLegalEntity3() throws InterruptedException, IOException
			{
				test = extent.startTest("Masters - Legal Entity Close Button verification");
				
				MethodsPOM.LegalEntityCloseButton( test);
				
				extent.endTest(test);
				extent.flush();
			}

@Test(priority =173)
void UnitEntity() throws InterruptedException, IOException
	{
		test = extent.startTest("Masters - Add Unit Entity verification");
		
		MethodsPOM.AddUnitType( test);
		
		extent.endTest(test);
		extent.flush();
	}
	
@Test(priority = 174)
	void Masters1() throws InterruptedException, IOException
	{
		test = extent.startTest("Masters - Law Firm verification");
		
		
		MethodsPOM.LawFirm( test);
		
		extent.endTest(test);
		extent.flush();
	}

@Test(priority =175)
void MastersLawFirm() throws InterruptedException, IOException
{
	test = extent.startTest("Law Firm Masters - Enter Without Data verification");
	
	
	MethodsPOM.LawFirmWithoutData( test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority =176)
void MastersLawFirm1() throws InterruptedException, IOException
{
	test = extent.startTest("Masters - Law Firm Invalid Data verification");
	
	
	MethodsPOM.LawFirmInvalidData( test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority =177)
void MastersLawFirm2() throws InterruptedException, IOException
{
	test = extent.startTest("Masters - Law Firm Two Manadtory fields verification");
	
	
	MethodsPOM.LawFirmTwoManadatoryFields( test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority =178)
void MastersLawFirm3() throws InterruptedException, IOException
{
	test = extent.startTest("Masters - Law Firm Close button verification");
	
	
	MethodsPOM.LawFirmCloseButton( test);
	
	extent.endTest(test);
	extent.flush();
}

@Test(priority =179)
void LawyerWithoutData() throws InterruptedException, IOException
{
	test = extent.startTest("Lawyer  - Enter Without Data verification");
	
	
	MethodsPOM.LawyerWithoutData( test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority =180)
void LawyerInvalidData() throws InterruptedException, IOException
{
	test = extent.startTest("Lawyer  - Enter Invalid Data verification");
	
	
	MethodsPOM.LawyerInvalidData( test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 181)
void LawyerTwoManadatoryFileds() throws InterruptedException, IOException
{
	test = extent.startTest("Lawyer  - Enter Two Manadatory fields verification");
	
	
	MethodsPOM.LawyerTwoManadatoryFileds( test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 182)
void LawyerCloseButton() throws InterruptedException, IOException
{
	test = extent.startTest("Lawyer  - Enter close button verification");
	
	
	MethodsPOM.LawyerCloseButton( test);
	
	extent.endTest(test);
	extent.flush();
}
	@Test(priority = 183)
	void Masters2() throws InterruptedException, IOException
	{
		test = extent.startTest("Masters - 	User  verification");
		
		MethodsPOM.User( test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 184)
	void UserWithoutData() throws InterruptedException, IOException
	{
		test = extent.startTest("User Master-  without data verification");
		
		
		MethodsPOM.UserWithoutData( test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 185)
	void UserInvalidData() throws InterruptedException, IOException
	{
		test = extent.startTest("User Master-  Invalid data verification");
		
		
		MethodsPOM.UserInvalidData( test);
		
		extent.endTest(test);
		extent.flush();
	}
@Test(priority =186)
	void UserTwoManadatoryFields() throws InterruptedException, IOException
	{
		test = extent.startTest("User Master- Two manadatory fields verification");
		
		
		MethodsPOM.UserTwoManadatoryFields( test);
		
		extent.endTest(test);
		extent.flush();
	}
@Test(priority =187)
	void UserCloseButton() throws InterruptedException, IOException
	{
		test = extent.startTest("User Master- Close Button  verification");
		
		
		MethodsPOM.UserCloseButton( test);
		
		extent.endTest(test);
		extent.flush();
	}
@Test(priority = 188)
	void Masters3() throws InterruptedException, IOException
	{
		test = extent.startTest("Masters - Opponent  verification");
		
		
		MethodsPOM.Opponent( test);
		
		extent.endTest(test);
		extent.flush();
	}

	@Test(priority =189)
	void OpponentWithoutData() throws InterruptedException, IOException
	{
		test = extent.startTest("Opponent Masters -Without Data verification");
	
		MethodsPOM.OpponentWithoutData( test);
	   extent.endTest(test);
	  extent.flush();
   }
  @Test(priority =190)
  void OpponentInvalidData() throws InterruptedException, IOException
  {
	  test = extent.startTest("Opponent Masters -Invalid Data verification");


	  MethodsPOM.OpponentInvalidData( test);

	  extent.endTest(test);
	  extent.flush();
  }
   @Test(priority = 191)
   void OpponentCloseButton() throws InterruptedException, IOException
   {
	   test = extent.startTest("Opponent Masters -Close button verification");

	   MethodsPOM.OpponentCloseButton( test);

	   extent.endTest(test);
	   extent.flush();
   }
@Test(priority = 192)
	void Masters4() throws InterruptedException, IOException
	{
		test = extent.startTest("Masters - Court  verification");
		
		MethodsPOM.Court( test);
		
		extent.endTest(test);
		extent.flush();
	}
 
 
 @Test(priority =193)
	void CourtWithoutData() throws InterruptedException, IOException
	{
		test = extent.startTest("Court Master- Without enter Data verification");
		
		
		MethodsPOM.CourtWithoutData( test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 194)
	void CourtInvalidData() throws InterruptedException, IOException
	{
		test = extent.startTest("Court Master- Enter Invalid Data verification");
		
		
		MethodsPOM.CourtInvalidData( test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 195)
	void CourtTwomanadatoryFields() throws InterruptedException, IOException
	{
		test = extent.startTest("Court Master- Enter Two Manadtory Fields verification");
		
		
		MethodsPOM.CourtTwomanadatoryFields( test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority =196)
	void CourtCloseButton() throws InterruptedException, IOException
	{
		test = extent.startTest("Court Master- Close button verification");
		
		
		MethodsPOM.CourtCloseButton( test);
		
		extent.endTest(test);
		extent.flush();
	}
	

	
@Test(priority = 197)
	void Masters5() throws InterruptedException, IOException
	{
		test = extent.startTest("Masters - Case/NoticeType  verification");
		
		
		MethodsPOM.CaseNoticeType( test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 198)
	void CaseNoticeTypeWithoutData() throws InterruptedException, IOException
	{
		test = extent.startTest("Case/NoticeType Master -Without Enter Data  verification");

		MethodsPOM.CaseNoticeTypeWithoutData( test);
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 199)
	void CaseNoticeTypeInvaliData() throws InterruptedException, IOException
	{
		test = extent.startTest("Case/NoticeType Master - Enter Invalid Data  verification");
		MethodsPOM.CaseNoticeTypeInvaliData( test);
        extent.endTest(test);
        extent.flush();
    }
	@Test(priority = 200)
	void CaseNoticeTypeCloseBuuton() throws InterruptedException, IOException
	{
		test = extent.startTest("Case/NoticeType Master - Close Button  verification");
		MethodsPOM.CaseNoticeTypeCloseButton( test);
        extent.endTest(test);
        extent.flush();
	}
	@Test(priority = 201)
	void Masters6() throws InterruptedException, IOException
	{
		test = extent.startTest("Masters - Payment Type  verification");
		
		
		MethodsPOM.PaymentType( test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 202)
    void PaymentTypeWithouData() throws InterruptedException, IOException
   {
       test = extent.startTest("Payment Type Master- Without Enter Data  verification");


       MethodsPOM.PaymentTypeWithoutData( test);

        extent.endTest(test);
        extent.flush();
   }
@Test(priority = 203)
void PaymentTypeInvalidData() throws InterruptedException, IOException
{
 test = extent.startTest("Payment Type Master-Enter Invalid Data  verification");


 MethodsPOM.PaymentTypeInvalidData( test);

  extent.endTest(test);
  extent.flush();
}
@Test(priority = 204)
void PaymentTypeCloseButton() throws InterruptedException, IOException
{
 test = extent.startTest("Payment Type Master-Close button verification");


 MethodsPOM.PaymentTypeCloseButton( test);

  extent.endTest(test);
  extent.flush();
}
	
@Test(priority = 205)
	void Masters7() throws InterruptedException, IOException
	{
		test = extent.startTest("Masters - Custom Parameter  verification");
		
		
		MethodsPOM.customParameter( test);
		
		extent.endTest(test);
		extent.flush();
	}

@Test(priority = 206)
	void customParameterWithoutData() throws InterruptedException, IOException
	{
		test = extent.startTest("Custom Parameter Master -Without Enter Data  verification");

	
		CFOMethod.customParameterWithoutData( test);
	
		extent.endTest(test);
		extent.flush();
	}
     @Ignore
	@Test(priority = 207)
	void customParameterInvalidData() throws InterruptedException, IOException
	{
		test = extent.startTest("Custom Parameter Master -Enter Invalid Data verification");

	
		CFOMethod.customParameterInvalidData( test);
	
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 208)
	void customParameterCloseButton() throws InterruptedException, IOException
	{
		test = extent.startTest("Custom Parameter Master -Close  button  verification");

	
		CFOMethod.customParameterCloseButton( test);
	
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 209)
	void Masters8() throws InterruptedException, IOException
	{
		test = extent.startTest("Masters - Case Stage  verification");
		
		
		MethodsPOM.CaseStage( test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority =210)
	void CaseStageWithoutData() throws InterruptedException, IOException
	{
		test = extent.startTest("Case Stage Masters - Without Enter Data  verification");
	
		
		MethodsPOM.CaseStageWithoutData( test);
		
		extent.endTest(test);
		extent.flush();
	}
@Test(priority = 211)
	void CaseStageInvalidData() throws InterruptedException, IOException
	{
		test = extent.startTest("Case Stage Masters - Enter Invalid Data  verification");
	
		
		MethodsPOM.CaseStageInvalidData( test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 212)
	void CaseStageCloseButton() throws InterruptedException, IOException
	{
		test = extent.startTest("Case Stage Masters - Close Button verification");
	
		
		MethodsPOM.CaseStageCloseButton( test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 213)
	void Masters9() throws InterruptedException, IOException
	{
		test = extent.startTest("Masters - Document Type  verification");
		
		
		MethodsPOM.DocumentType( test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 214)
	void DocumentTypeWithoutData() throws InterruptedException, IOException
	{
		test = extent.startTest("Document Type Masters-Without data  verification");
		
		
		MethodsPOM.DocumentTypeWithoutData( test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority =215)
	void DocumentTypeInvalidData() throws InterruptedException, IOException
	{
		test = extent.startTest("Document Type Masters-Enter Invalid Data verification");
		
		
		MethodsPOM.DocumentTypeInvalidData( test);
		
		extent.endTest(test);
		extent.flush();
	}
@Test(priority = 216)
	void DocumentTypeCloseButton() throws InterruptedException, IOException
	{
		test = extent.startTest("Document Type Masters-Close button verification");
		
		MethodsPOM.DocumentTypeCloseButton( test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 217)
	void Masters10() throws InterruptedException, IOException
	{
		test = extent.startTest("Masters - Rating Criteria  verification");
		
		
		MethodsPOM.RatingCriteria( test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 218)
	void RatingCriteriaWithoutData() throws InterruptedException, IOException
	{
		test = extent.startTest("Rating Criteria Masters-Without Enter Data  verification");
	
		
		MethodsPOM.RatingCriteriaWithoutData( test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 219)
	void RatingCriteriaInvalidData() throws InterruptedException, IOException
	{
		test = extent.startTest("Rating Criteria Masters-Enter Invalid Data  verification");
	
		
		MethodsPOM.RatingCriteriaInvalidData( test);
		
		extent.endTest(test);
		extent.flush();
	}		
	@Test(priority =220)
	void RatingCriteriaCloseButton() throws InterruptedException, IOException
	{
		test = extent.startTest("Rating Criteria Master-Close button verification");
	
		
		MethodsPOM.RatingCriteriaCloseButton( test);
		
		extent.endTest(test);
		extent.flush();
	}		
	@Test(priority = 221)
	void Masters11() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Masters - PageAuthorization   verification");
		
		
		MethodsPOM.PageAuthorization( test);
		
		extent.endTest(test);
		extent.flush();
	}
@Test(priority = 222)
	void AnnualBudget() throws InterruptedException, IOException
	{
		test = extent.startTest("Masters - Annual Budget verification");
		
		
		MethodsPOM.AnnualBudget( test);
		
		extent.endTest(test);
		extent.flush();
	}
@Test(priority = 223)
void ExistingAnnualBudget() throws InterruptedException, IOException
{
	test = extent.startTest("Masters - Existing Annual Budget verification");
	
	
	MethodsPOM.AnnualBudget( test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 224)
void UpdateAnnualBudget() throws InterruptedException, IOException
{
	test = extent.startTest("Masters - Update Annual Budget verification");
	
	
	MethodsPOM.UpdateAnnualBudget( test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 225)
void DeleteAnnualBudget() throws InterruptedException, IOException
{
	test = extent.startTest("Masters - Delete Annual Budget verification");
	
	
	MethodsPOM.DeleteAnnualBudget( test);
	
	extent.endTest(test);
	extent.flush();
}
//@Test(priority = 226)
void WithoutEnterFY() throws InterruptedException, IOException
{
	test = extent.startTest("Masters - Without Enter FY verification");
	
	
	MethodsPOM.WithoutEnterFY( test);
	
	extent.endTest(test);
	extent.flush();
}
//@Test(priority = 227)
void SearchFilterAnnualBudget() throws InterruptedException, IOException
{
	test = extent.startTest("Masters - Search Filter - Annual Budget verification");
	
	
	MethodsPOM.SearchFilterAnnualBudget( test,"2022-2023");
	
	extent.endTest(test);
	extent.flush();
}
//@Test(priority =228)
	void Masters12() throws InterruptedException, IOException
	{
		test = extent.startTest("Masters - Advocate Bill Approver  verification");
		
		
		MethodsPOM.AdvocateBillApprover( test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority =229)
	void Masters13() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Masters - UserReassignment  verification");
	
		MethodsPOM.UserReassignment( test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	
@Test(priority =230)
	void Masters14() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Masters - Notice Stage  verification");
		
		
		MethodsPOM.NoticeStage( test);
		
		extent.endTest(test);
		extent.flush();
	}
@Test(priority = 231)
	void Masters15() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Masters - Mail Authorization  verification");
		
		
		MethodsPOM.MailAuthorization(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	
	
	

	
//	@Test(priority = 40)
	void CustomerMgmt() throws InterruptedException, IOException
	{
		test = extent.startTest("City-Customer Management verification");
		test.log(LogStatus.INFO, "Test Initiated");
		
		MethodPOM1.CustomerMgmt( test);
		
		extent.endTest(test);
		extent.flush();
	}
//	@Test(priority = 41)
	void CustomerMgmtCustomer() throws InterruptedException, IOException
	{
		test = extent.startTest("Customer Mgmt Customer-Customer Management verification");
		test.log(LogStatus.INFO, "Test Initiated");
		
		MethodPOM1.CustomerMgmtCustomer( test);
		
		extent.endTest(test);
		extent.flush();
	}
//	@Test(priority = 42)
	void CustomerMgmtPlanVisit() throws InterruptedException, IOException
	{
		test = extent.startTest("Customer Mgmt Plan Visit-Customer Management verification");
		test.log(LogStatus.INFO, "Test Initiated");
		
		MethodPOM1.CustomerMgmtPalnVisit( test);
		
		extent.endTest(test);
		extent.flush();
	}	
//	@Test(priority = 43)
	void UpdateCommitmentsafterremarks() throws InterruptedException, IOException
	{
		test = extent.startTest("Update Commitments after remarks-Customer Management verification");
		test.log(LogStatus.INFO, "Test Initiated");
		
		MethodPOM1.UpdateCommitmentsafterremarks( test);
		
		extent.endTest(test);
		extent.flush();
	}
//	@Test(priority = 44)
	void UpdateCommitmentsStatus() throws InterruptedException, IOException
	{
		test = extent.startTest("Update Commitments Status - Customer Management verification");
		test.log(LogStatus.INFO, "Test Initiated");
		
		MethodPOM1.UpdateCommitmentsStatus( test);
		
		extent.endTest(test);
		extent.flush();
	}
//	@Test(priority = 45)
	void Report() throws InterruptedException, IOException
	{
		test = extent.startTest("Report-Customer Management verification");
		test.log(LogStatus.INFO, "Test Initiated");
		
		MethodPOM1.Report( test);
		
		extent.endTest(test);
		extent.flush();
	}
//	 @Test(priority = 41)
		void DashBoardFilter() throws InterruptedException, IOException
		{
			test = extent.startTest("All Filters verification");
			test.log(LogStatus.INFO, "Test Initiated");
			
			MethodPOM1.DashBoardFilter( test, "Company Admin");
			
			extent.endTest(test);
			extent.flush();
		}
@Test(priority = 232)
		void WorkspaceFilter() throws InterruptedException, IOException
		{
			test = extent.startTest("My Workspace - Notice - Multiple Filters verification");
			
			
			//MethodPOM1.WorkspaceFilter( test);
			CFOMethod.WorkspaceNoticeFilter( test);
			
			extent.endTest(test);
			extent.flush();
		}
@Test(priority = 233)
void CaseWorkspaceFilter() throws InterruptedException, IOException
{
	test = extent.startTest("My Workspace - Case - Multiple Filters verification");
	
	
	//MethodPOM1.CaseWorkspaceFilter( test);
	
	CFOMethod.WorkspaceCaseFilter( test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 234)
void WorkspaceTaskFilter() throws InterruptedException, IOException
{
	test = extent.startTest("My Workspace - Task - Multiple Filters verification");
	
	
	//MethodPOM1.WorkspaceTaskFilter( test);
	
	CFOMethod.WorkspaceTaskFilter( test);
	
	extent.endTest(test);
	extent.flush();
}

@Test(priority = 235)
void WorkspaceCaseHearingFilter() throws InterruptedException, IOException
{
	test = extent.startTest("My Workspace = Case Hearing = Search box  Filter verification");
	
	
	CFOMethod.WorkspaceCaseHearingFilter( test,"Regtrack ABC");
	
	extent.endTest(test);
	extent.flush();
}

@Test(priority = 236)
		void DocumentNoticeFilter() throws InterruptedException, IOException
		{
			test = extent.startTest("My Document Tab - Notice - Multiple Filters verification");
			
			
			//MethodPOM1.DocumentNoticeFilter( test);
			CFOMethod.DocumentNoticeFilter( test);
			
			extent.endTest(test);
			extent.flush();
		}
 @Test(priority =237)
	void DocumentCaseFilter() throws InterruptedException, IOException
	{
		test = extent.startTest(" My Document = Case = Multiple  Filters verification");
	
		
		//MethodPOM1.DocumentCaseFilter( test);
		CFOMethod.DocumentCaseFilter( test);
		
		extent.endTest(test);
		extent.flush();
	}
 
 @Test(priority = 238)
	void DocumentTaskFilter() throws InterruptedException, IOException
	{
		test = extent.startTest(" My Document = Task = Multiple  Filters verification");
	
		
		//MethodPOM1.DocumentTaskFilter( test);
		CFOMethod.DocumentTaskFilter( test);
		
		extent.endTest(test);
		extent.flush();
	}
 @Test(priority = 239)
		void ReportFilter() throws InterruptedException, IOException
		{
			test = extent.startTest("My Report - Notice - Multiple Filters verification");
			
			MethodPOM1.ReportFilter( test);
			
			extent.endTest(test);
			extent.flush();
		}
 @Test(priority = 240)
	void ReportCaseFilter() throws InterruptedException, IOException
	{
		test = extent.startTest("My Report - Case - Multiple Filters verification");
		
		//MethodPOM1.ReportCaseFilter( test);
		CFOMethod.ReportCaseFilter( test);
		
		extent.endTest(test);
		extent.flush();
	}
 
 @Test(priority =241)
	void ReportTaskFilter() throws InterruptedException, IOException
	{
		test = extent.startTest("My Report = Task =  Filters verification");
		
		
		//MethodPOM1.ReportTaskFilter( test);
		CFOMethod.ReportTaskFilter( test);
		
		extent.endTest(test);
		extent.flush();
	}
	@AfterMethod
	 
	 void Close()
	 {
		 driver.close(); 
	 }
	 
	
	

	

	

	

	

	 

	



    
    
	

	

}
