package CriticalTestCases;

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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import litigationAdditionalOwner.performerPOM;
import litigationCompanyAdmin.MethodsPOM;
import litigationManagement.CFOMethod;
import login.BasePage;
import performer.OverduePOM;


public class CompanyAdminLogin extends BasePage

{
		//public static WebDriver getDriver= null;		//Web instance created
		public static WebElement upload = null;		//WebElement to get upload button
		public static ExtentReports extent;			//Instance created for report file
		public static ExtentTest test;				//Instance created for tests
		public static FileInputStream fis = null;	//File input stream variable
		public static XSSFWorkbook workbook = null;	//Excel sheet workbook variable
		public static XSSFSheet sheet = null;		//Sheet variable
		public static List<WebElement> elementsList = null;
		
//		public static XSSFSheet ReadExcel() throws IOException
//		{
//			//String workingDir = System.getProperty("user.dir");
//			fis = new FileInputStream("D:\\Litigation-Project 10 April2024\\Litigation-Project 10 April2024\\TestData\\LitigationSheet.xlsx");
//		
//			workbook = new XSSFWorkbook(fis);
//			sheet = workbook.getSheetAt(4);					//Retrieving second sheet of Workbook
//			return sheet;
//		}
		
		@BeforeTest
		void setBrowser() throws InterruptedException, IOException
		{
			String workingDir = System.getProperty("user.dir");
			extent = new com.relevantcodes.extentreports.ExtentReports(workingDir+"//Reports//LitigationCompanyAdmin.html",true);
			test = extent.startTest("Litigation Logging In - Company Admin");
			test.log(LogStatus.PASS, "Test Passed = Verify Chrome browser.");
			test.log(LogStatus.PASS, "URL = https://login.teamleaseregtech.com/Login.aspx?ReturnUrl=%2fLogin.aspx");
			test.log(LogStatus.PASS, "Username = companyadmin@regtrack.com");
			test.log(LogStatus.PASS, "Password = admin@123");
			extent.endTest(test);
			extent.flush();
		}
		
		@BeforeMethod
		
		void Login() throws InterruptedException, IOException
		{
			initialization("company",4);
//			XSSFSheet sheet = ReadExcel();
//			Row row0 = sheet.getRow(0);						//Selected 0th index row (First row)
//			Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
//			String URL = c1.getStringCellValue();			//Got the URL stored at position 0,1
//			
//			login.Login.BrowserSetup(URL);					//Method of Login class to set browser.
//			
//			
//			Row row1 = sheet.getRow(1);						//Selected 1st index row (Second row)
//			Cell c2 = row1.getCell(1);						//Selected cell (1 row,1 column)
//			String uname = c2.getStringCellValue();			//Got the URL stored at position 1,1
//			
//			Row row2 = sheet.getRow(2);						//Selected 2nd index row (Third row)
//			Cell c3 = row2.getCell(1);						//Selected cell (2 row,1 column)
//			String password = c3.getStringCellValue();		//Got the URL stored at position 2,1
//			
//			getDriver = login.Login.UserLogin(uname,password,"company");		//Method of Login class to login user.
			
		}

		
	
		@Test(priority =1)				
	
				 	void NoticeOpen() throws InterruptedException, IOException
				 	{
				 		test = extent.startTest("Notice - Open Count Verification");
				 		
				 		
				 		MethodsPOM.NoticeOpen(test, workbook, "Performer");
				 		
				 		test.log(LogStatus.PASS, "Test Passed.");
				 		extent.endTest(test);
				 		extent.flush();
				 	}
			
					 @Test(priority =2)
					     	void CaseOpen() throws InterruptedException, IOException
					     	{
					     		test = extent.startTest("Case - Open Count verification");
					     		
					     		
					     		MethodsPOM.CaseOpen( test, "CFO -");
					     		
					     		extent.endTest(test);
					     		extent.flush();
					     	}
					
				
					 @Test(priority =2)
					     			void TaskOpen() throws InterruptedException, IOException
					     			{
					     				test = extent.startTest("Task - Open Count verification");
					     				
					     				
					     				MethodsPOM.TaskOpen( test, "CFO");
					     				
					     				extent.endTest(test);
					     				extent.flush();
					     			}
			
					 		 @Test(priority = 3)
					 			void TaskDelete() throws InterruptedException, IOException
					 			{
					 				test = extent.startTest("Task Delete verification");
					 				
					 				
					 				MethodsPOM.TaskDelete( test);
					 				
					 				extent.endTest(test);
					 				extent.flush();
					 			}
					    	
					 @Test(priority = 4)
					     	void NoticeClosed() throws InterruptedException, IOException
					     	{
					     		test = extent.startTest("Notice - Closed Count verification");
					     		
					     		
					     		MethodsPOM.NoticeClosed( test, "Performer");
					     		
					     		extent.endTest(test);
					     		extent.flush();
					     	}
					@Test(priority =5)
						void CaseClose() throws InterruptedException, IOException
						{
							test = extent.startTest("Case - Closed Count Verification");
							
							MethodsPOM.CaseClosed( test, "Performer");
							
							extent.endTest(test);
							extent.flush();
						}
					 	
				
					 	   
					 @Test(priority =6)
					     	void CloseNotice() throws InterruptedException, IOException
					     	{
					     		test = extent.startTest("Close Notice Count verification");
					     		
					     		MethodsPOM.CloseNoticeCase( test,"Notice","company admin");
					     		
					     		extent.endTest(test);
					     		extent.flush();
					     	}
					
					 
				 @Test(priority = 7)
				 void CloseCase() throws InterruptedException, IOException
					{
					 	test = extent.startTest("Close Case Count Verification");
					 				
					 	MethodsPOM.CloseNoticeCase( test, "Case","company admin");
					 				
					 	extent.endTest(test);
					 	extent.flush();
					 }
				 
				
					 @Test(priority = 8)
					 			void TaskClosed() throws InterruptedException, IOException
					 			{
					 				test = extent.startTest("Task - Closed Count verification");
					 				
					 				
					 				MethodsPOM.TaskClosed( test, "CFO");
					 				
					 				extent.endTest(test);
					 				extent.flush();
					 			}
					 			@Test(priority = 9)
					 			void ClosedTask() throws InterruptedException, IOException
					 			{
					 				test = extent.startTest(" Closed Task Count verification");
					 				
					 				
					 				MethodsPOM.CloseNoticeCase( test, "Task","company admin");
					 				
					 				extent.endTest(test);
					 				extent.flush();
					 			}
				 	@Test(priority = 10)
					     	void NoticeDocument() throws InterruptedException, IOException
					     	{
					     		test = extent.startTest("Notice Document verification");
					     		
					     		
					     		MethodsPOM.NoticeDocument( test);
					     		
					     		extent.endTest(test);
					     		extent.flush();

					     	}
					
					 	@Test(priority = 11)
					 	void NoticeTaskActivity() throws InterruptedException, IOException
					 	{
					 		test = extent.startTest("Notice TaskActivtiy verification");
					 		
					 		
					 		MethodsPOM.TaskActivtity( test);
					 		
					 		extent.endTest(test);
					 		extent.flush();
					 	}
					 //@Test(priority = 12)
					 void TaskActivtityDeleteResponse() throws InterruptedException, IOException
					 {
					 	test = extent.startTest("Notice Task/Activtiy Delete Response verification");
					 	
					 	
					 	MethodsPOM.TaskActivtityDeleteResponse( test);
					 	
					 	extent.endTest(test);
					 	extent.flush();
					 }
				
					 @Test(priority =13)
					 void NoticeResponse() throws InterruptedException, IOException
					 {
					 	test = extent.startTest("Notice Response verification");
					 	
					 	
					 	MethodsPOM.Response( test);
					 	
					 	extent.endTest(test);
					 	extent.flush();
					 }
					
					 @Test(priority = 14)
					 void NoticePayment() throws InterruptedException, IOException
					 {
					 	test = extent.startTest("Notice Payment verification");
					 	
					 	
					 	MethodsPOM.PaymentLog(test);
					 	
					 	extent.endTest(test);
					 	extent.flush();
					 }
					
					 @Test(priority = 15)
					 void NoticeExternalLawyer() throws InterruptedException, IOException
					 {
					 	test = extent.startTest("Notice Lawyer verification");
					 	
					 	MethodsPOM.ExternalLawyerRating( test);
					 	
					 	extent.endTest(test);
					 	extent.flush();
					 }
				
					
					 @Test(priority = 16)
					 void NoticeAuditLog() throws InterruptedException, IOException
					 {
					 	test = extent.startTest("Notice Audit Log verification");

					 	
					 	MethodsPOM.AuditLog( test);
					 	
					 	extent.endTest(test);
					 	extent.flush();
					 }
					 @Test(priority =16)
					 void CaseDocument() throws InterruptedException, IOException
					 {
					 	test = extent.startTest("Case - Document Tab");
					 	
					 	
					 	MethodsPOM.Document( test);
					 	
					 	extent.endTest(test);
					 	extent.flush();
					 }
			
					@Test(priority = 17)
					 	void CaseTaskActivityTab() throws InterruptedException, IOException
					 	{
					 		test = extent.startTest("Case Task/Activity verification");
					 		
					 		
					 		MethodsPOM.TaskActivity1( test,"Performer");
					 		
					 		extent.endTest(test);
					 		extent.flush();
					 	}

			
					 	@Test(priority =18)
					 	void CaseHearingcfo() throws InterruptedException, IOException
					 	{
					 		test = extent.startTest("Case - CaseHearing Tab");
					 		
					 		
					 		MethodsPOM.CaseHearing( test);
					 		
					 		extent.endTest(test);
					 		extent.flush();
					 	}
					
					
					@Test(priority = 19)
					 	void CaseOrderTab() throws InterruptedException, IOException
					 	{
					 		test = extent.startTest("Case Order verification");
					 		
					 		
					 		MethodsPOM.CaseOrder( test,"Performer");
					 		
					 		extent.endTest(test);
					 		extent.flush();
					 	}
				
				 @Test(priority =20)
					 void CaseStatusPayment() throws InterruptedException, IOException
					 {
					 	test = extent.startTest("Case - Status/Payment Tab");
					 	
					 	
					 	MethodsPOM.StatusPayment( test);
					 	
					 	extent.endTest(test);
					 	extent.flush();
					 }
			
						@Test(priority =21)
					 	void ExternalLawyer() throws InterruptedException, IOException
					 	{
					 		test = extent.startTest("Case External Lawyer verification");
					 		
					 		
					 		MethodsPOM.ExternalLawyer( test,1);
					 		
					 		extent.endTest(test);
					 		extent.flush();
					 	}
				
					 @Test(priority =22)
					 	void CaseAuditLog() throws InterruptedException, IOException
					 	{
					 		test = extent.startTest("Case - Audit Log Tab");
					 		
					 		
					 		MethodsPOM.Auditlog( test);
					 		
					 		extent.endTest(test);
					 		extent.flush();
					 	}
					 @Test(priority = 23)
						void HearingCalender() throws InterruptedException, IOException, AWTException
						{
							test = extent.startTest("Case Hearing Calender Verification");
							
							
							MethodsPOM.HearingCalender( test,"Performer","Company admin");
							
							extent.endTest(test);
							extent.flush();
						}
					 @Test(priority = 24)
						void CaseNoticeTypeGraph() throws InterruptedException, IOException
						{
							test = extent.startTest("Select Notice from Notice/Case Filter to verify count of Case/Notice Type Summary graph");
							
							

					   		JavascriptExecutor js = (JavascriptExecutor)getDriver() ;
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
							//int	Defendant = Integer.parseInt(performerPOM.CaseNoticeTypeDefendantNotice().getText());	//Reading Notice Open count.
							int	Plaintiff = Integer.parseInt(performerPOM.CaseNoticeTypePlaintiffNotice().getText());	//Reading Notice Open count.
							
							
							Thread.sleep(3000);
							MethodsPOM.CaseNoticeTypeGraph( test,"Outward/Plaintiff Type",OutwardPlaintiff);
							Thread.sleep(3000);
							MethodsPOM.CaseNoticeTypeGraph(  test,"Inward/Defendent Type",InwardDefendent);
							Thread.sleep(4000);
							MethodsPOM.CaseNoticeTypeGraph(  test,"Petitioner Type",Petitioner);
							Thread.sleep(3000);
							MethodsPOM.CaseNoticeTypeGraph(  test,"Respondent Type",Respondent);
							Thread.sleep(3000);
							MethodsPOM.CaseNoticeTypeGraph(  test,"Applicant Type",Applicant);
							Thread.sleep(3000);
							MethodsPOM.CaseNoticeTypeGraph(  test,"Complianant Type",Complainanat);
							//Thread.sleep(3000);
							//MethodsPOM.CaseNoticeTypeGraph(  test,"Defendant Type",Defendant);
							Thread.sleep(3000);
							MethodsPOM.CaseNoticeTypeGraph(  test,"Plaintiff Type",Plaintiff);
							
							Thread.sleep(3000);
							OverduePOM.clickDashboard().click();
							
							extent.endTest(test);
							extent.flush();
						}
						
					//  @Test(priority = 25)
						void CaseNoticeTypeFilter() throws InterruptedException, IOException
						{

					   		JavascriptExecutor js = (JavascriptExecutor)getDriver() ;
						 	js.executeScript("window.scrollBy(0,900)");
						 	
							//Thread.sleep(3000);
						//	MethodsPOM.CaseNoticeTypeFilter( test,"CaseNoticeTypeSummaryGraph");
							//Thread.sleep(3000);
							//MethodsPOM.CaseNoticeTypeFilter( test,"CaseNoticeStageHearingGraph");
						//	Thread.sleep(3000);
						//	MethodsPOM.CaseNoticeTypeFilter( test,"RiskSummaryHigh");
						//	Thread.sleep(3000);
						//	MethodsPOM.CaseNoticeTypeFilter( test,"DepartmentSummaryGraph");
							//Thread.sleep(3000);
						//	MethodsPOM.CaseNoticeTypeFilter( test,"LocationSummaryGraph");
						//	Thread.sleep(3000);
							//MethodsPOM.CaseNoticeTypeFilter( test,"CategorySummaryGraph");
						//	Thread.sleep(3000);
						//	MethodsPOM.CaseNoticeTypeFilter( test,"LessThanSummaryGraph");
						//	Thread.sleep(3000);
						//	MethodsPOM.CaseNoticeTypeFilter( test,"1To2YearSummaryGraph");
						//	Thread.sleep(3000);
						//	MethodsPOM.CaseNoticeTypeFilter( test,"2to3YearAgeingGraph");
						//	Thread.sleep(3000);
						//	MethodsPOM.CaseNoticeTypeFilter( test,"MoreThan3YearAgeingGraph");

							
							test = extent.startTest("Case Notice type summary graph Filter Verification");
							extent.endTest(test);
							extent.flush();
						}

						@Test(priority = 26)
						void CaseNoticeStageGraph() throws InterruptedException, IOException
						{
							

					   		JavascriptExecutor js = (JavascriptExecutor)getDriver() ;
							js.executeScript("window.scrollBy(0,900)");
							
							Thread.sleep(5000);
							performerPOM.clickDashboardCaseNoticeFilter().click();
						
							Thread.sleep(5000);
							performerPOM.clickDashboardNoticeFilter().click();
					  
					   	
							Thread.sleep(5000);
							performerPOM.clickDashboardApplyBtn().click();
							
							js.executeScript("window.scrollBy(0,850)");

							 String StageName =performerPOM.StageName().getText();
							 test = extent.startTest("Select Notice from Notice/Case Filter :- "+StageName+" Stage :-  to verify count of Case/Notice Stage Summary graph");
							
							MethodsPOM.CaseNoticeStageGraph( test,"cfo -");
							
							extent.endTest(test);
							extent.flush();
						}
						


						@Test(priority =27)
						void RiskSummaryGraph() throws InterruptedException, IOException
						{
							test = extent.startTest("Select Notice from Notice/Case Filter to verify count of Risk Summary graph");
							
							

					   		JavascriptExecutor js = (JavascriptExecutor)getDriver() ;
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
						@Test(priority = 28)
					    void DepartmentSummaryGraph() throws InterruptedException, IOException
					    {

					   		JavascriptExecutor js = (JavascriptExecutor)getDriver() ;
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

						@Test(priority = 29)
					    void LocationSummaryGraph() throws InterruptedException, IOException
					    {
					    	
					    	

					   		JavascriptExecutor js = (JavascriptExecutor)getDriver() ;
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


						@Test(priority = 30)
					    void CategorySummaryGraph() throws InterruptedException, IOException
					    {

					   		JavascriptExecutor js = (JavascriptExecutor)getDriver() ;
							js.executeScript("window.scrollBy(0,800)");
							
							Thread.sleep(5000);
							performerPOM.clickDashboardCaseNoticeFilter().click();
							
							Thread.sleep(5000);
							performerPOM.clickDashboardNoticeFilter().click();
					      
					       	
							Thread.sleep(5000);
							performerPOM.clickDashboardApplyBtn().click();
							
						   	js.executeScript("window.scrollBy(0,1700)");
					    	
					    	
					    	
					    	Thread.sleep(2000);
					  		//String CategoryName =performerPOM.CategoryName().getText();
					    	//test = extent.startTest("Select notice type filter ="+CategoryName+" Category -To check Category Summary Graph Count Verification");
					    	test = extent.startTest("Select Notice from Notice/Case Filter :- Company Law Category :-  to verify count of Category Summary graph");
					    	
					       Thread.sleep(3000);
					       MethodsPOM.CategorySummaryGraph( test,"cfo -");

					       extent.endTest(test);
					       extent.flush();
					    }
					    





					@Test(priority = 31)
					void InwardDefendantAgeingGraph() throws InterruptedException, IOException
					{
					     test = extent.startTest("Select Notice from Notice/Case Filter to verify count of Ageing(Less than year) Summary graph\"");
					     

					   		JavascriptExecutor js = (JavascriptExecutor)getDriver() ;
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



					@Test(priority =32)

					void AgeingGraph1to2years() throws InterruptedException, IOException
					{
					   		test = extent.startTest("Select Notice from Notice/Case Filter to verify count of Ageing(1 to 2 year) Summary graph");
					   
					   		JavascriptExecutor js = (JavascriptExecutor)getDriver() ;
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



					@Test(priority = 33)
					void AgeingGraph2to3years() throws InterruptedException, IOException
					{
					  	test = extent.startTest("Select Notice from Notice/Case Filter to verify count of Ageing(2 to 3 year) Summary graph");
					 

				   		JavascriptExecutor js = (JavascriptExecutor)getDriver() ;
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
							// int Applicant = Integer.parseInt(performerPOM.clickApplicantNoticeCA2to3().getText());	//Reading Notice Open count.
							 int OutwardPlainftiff = Integer.parseInt(performerPOM.clickOutwardPlaintiffNoticeCA2to3().getText());	//Reading Notice Open count.
							 int Petitioner = Integer.parseInt(performerPOM.clickPetitionerNoticeCA2to3().getText());	//Reading Notice Open count.
							 int Plaintiff = Integer.parseInt(performerPOM.clickPlaintiffNoticeCA2to3().getText());	//Reading Notice Open count.
							 
						    Thread.sleep(3000);
						    MethodsPOM.AgeingGraph2to3years( test,"Inward/Defendent",InwardDefendent);
							//Thread.sleep(3000);
							//MethodsPOM.AgeingGraph2to3years(  test,"Applicant",Applicant);
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
					@Test(priority = 34)
					void AgeingGraphMorethan3years() throws InterruptedException, IOException
					{
					    test = extent.startTest("Select Notice from Notice/Case Filter to verify count of Ageing(more than 3 year) Summary graph");
					 

				   		JavascriptExecutor js = (JavascriptExecutor)getDriver() ;
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

						@Test(priority =35)
						void CaseNoticeTypeGraph1() throws InterruptedException, IOException
						{
							test = extent.startTest("Select Case from Notice/Case Filter to verify count of Case/Notice Summary graph");
							
							

					   		JavascriptExecutor js = (JavascriptExecutor)getDriver() ;
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
//							Thread.sleep(3000);
//							MethodsPOM.CaseNoticeTypeGraph1( test,"Petitioner",Petitioner);
//							Thread.sleep(3000);
//							MethodsPOM.CaseNoticeTypeGraph1( test,"Respondent",Respondent);
							
							
							Thread.sleep(3000);
							OverduePOM.clickDashboard().click();
							
							extent.endTest(test);
							extent.flush();
						}
						@Test(priority = 36)
						void CaseNoticeStageGraph1() throws InterruptedException, IOException
						   { 

					   		JavascriptExecutor js = (JavascriptExecutor)getDriver() ;
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
						@Test(priority = 37)
						void RiskSummaryGraph1() throws InterruptedException, IOException
						{
							test = extent.startTest("Select Case from Notice/Case Filter to verify count of Risk Summary graph");
					        

					   		JavascriptExecutor js = (JavascriptExecutor)getDriver() ;
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
					    	int	MediumRisk = Integer.parseInt(performerPOM.RiskSummaryMedium1().getText());	//Reading Notice Open count.
					    	int	LowRisk = Integer.parseInt(performerPOM.RiskSummaryLowCA().getText());	//Reading Notice Open count.
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
						
						@Test(priority = 38)
						 void DepartmentSummaryGraph1() throws InterruptedException, IOException
					    {

					   		JavascriptExecutor js = (JavascriptExecutor)getDriver() ;
					    	
							js.executeScript("window.scrollBy(0,800)");
					     	
					     	Thread.sleep(5000);
							performerPOM.clickDashboardCaseNoticeFilter().click();
							
							Thread.sleep(5000);
							performerPOM.clickDashboardCaseFilter().click();
					      
					       	
							 Thread.sleep(5000);
							 performerPOM.clickDashboardApplyBtn().click();
							 Thread.sleep(3000);
							js.executeScript("window.scrollBy(0,950)");
						
							 String DeptName =performerPOM.DepartName().getText();
							 //test = extent.startTest("Select Case Filter ="+DeptName+" Department - Department Summary Graph Count Verification");
							 test = extent.startTest("Select Case from Notice/Case Filter :-HR Department:- To verify count of Department Summary graph");
					       Thread.sleep(3000);
					       MethodsPOM.DepartmentSummaryGraph1( test,"cfo -");

					       extent.endTest(test);
					       extent.flush();
					    }
						@Test(priority = 39)
						void LocationSummaryGraph1() throws InterruptedException, IOException
					    {

					   		JavascriptExecutor js = (JavascriptExecutor)getDriver() ;
							js.executeScript("window.scrollBy(0,800)");
							
							
							Thread.sleep(5000);
							performerPOM.clickDashboardCaseNoticeFilter().click();
							
							Thread.sleep(5000);
							performerPOM.clickDashboardCaseFilter().click();
					      
					       	
						   Thread.sleep(5000);
						   performerPOM.clickDashboardApplyBtn().click();
						   
						   js.executeScript("window.scrollBy(0,1300)");
					    	
//					    	  String LocationName =performerPOM.LocationName().getText();
//					  		test = extent.startTest("Select Case Filter = "+LocationName+" Location- Location Summary Graph Count Verification");
					  		test = extent.startTest("Select Case from Notice/Case Filter :- A Pvt Ltd Location:- To verify count of Location Summary graph");
					      
					       Thread.sleep(3000);
					       MethodsPOM.LocationSummaryGraph1( test,"cfo -");

					       extent.endTest(test);
					       extent.flush();
					    }
						
						
						@Test(priority = 40)
						   void CategorySummaryGraph1() throws InterruptedException, IOException
					    {

					   		JavascriptExecutor js = (JavascriptExecutor)getDriver() ;
							js.executeScript("window.scrollBy(0,800)");
							
							Thread.sleep(5000);
							performerPOM.clickDashboardCaseNoticeFilter().click();
							
							Thread.sleep(5000);
							performerPOM.clickDashboardCaseFilter().click();
					      
					       	
							Thread.sleep(5000);
							performerPOM.clickDashboardApplyBtn().click();
							
						   	js.executeScript("window.scrollBy(0,1700)");
					    	
					    	
					    	
					    	Thread.sleep(2000);
					  		//String CategoryName =performerPOM.CategoryName().getText();
					    	//test = extent.startTest("Select Case Filter ="+CategoryName+" Category - Category Summary Graph Count Verification");
					    	test = extent.startTest("Select Case from Notice/Case Filter :-Civil Category:- To verify count of category Summary graph");
					    	
					       Thread.sleep(3000);
					       MethodsPOM.CategorySummaryGraph1( test,"cfo -");

					       extent.endTest(test);
					       extent.flush();
					    }
						
						@Test(priority =41)
						void ExpensesCaseGraph() throws InterruptedException, IOException
						{
							

					   		JavascriptExecutor js = (JavascriptExecutor)getDriver() ;
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
							@Test(priority =42)
						void ExpensesCategoryWiseCaseGraph() throws InterruptedException, IOException
						{


						   		JavascriptExecutor js = (JavascriptExecutor)getDriver() ;
								
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
							@Test(priority =43)
						void ExpensesCounselWiseCaseGraph() throws InterruptedException, IOException
						{
								

						   		JavascriptExecutor js = (JavascriptExecutor)getDriver() ;
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
					@Test(priority =44)
					 void UtilizedBudgetGraph() throws InterruptedException, IOException
					 {
					    test = extent.startTest("Select Case from Notice/Case Filter to verify count of Utilized budget graph");
					   
					    Thread.sleep(3000);
					    MethodsPOM.UtilizedBudgetGraph( test,"cfo -");

					    extent.endTest(test);
					    extent.flush();
					 }
						@Test(priority =45)
						void AgeingGraph() throws InterruptedException, IOException
						{
									test = extent.startTest("Select Case from Notice/Case Filter to verify count of Ageing(Less than year) Summary graph");
						     

							   		JavascriptExecutor js = (JavascriptExecutor)getDriver() ;
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
									 
									 int Applicant = Integer.parseInt(performerPOM.clickApplicantLessThanYearCaseCA().getText());	//Reading Notice Open count.
									 int Complainant = Integer.parseInt(performerPOM.clickComplainantLessThanYearCaseCA().getText());	//Reading Notice Open count.
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

						@Test(priority =45)
						void AgeingGraph1to2yearsCase() throws InterruptedException, IOException
						{
						     	test = extent.startTest("Select Case from Notice/Case Filter to verify count of Ageing(1 to 2 year) Summary graph");
						     

						   		JavascriptExecutor js = (JavascriptExecutor)getDriver() ;
						     	js.executeScript("window.scrollBy(0,800)");
						     	
						     	Thread.sleep(5000);
								performerPOM.clickDashboardCaseNoticeFilter().click();
								
								Thread.sleep(5000);
								performerPOM.clickDashboardCaseFilter().click();
								
								Thread.sleep(5000);
								 performerPOM.clickDashboardApplyBtn().click();
								
								 js.executeScript("window.scrollBy(0,3700)");
								 Thread.sleep(3000);
							    int	Complianant = Integer.parseInt(performerPOM.clickComplianant1to2yearCaseCA().getText());	//Reading Notice Open count.
						    	int	InwardDefendent = Integer.parseInt(performerPOM.clickInwardOutward1to2yearsCaseCA().getText());	//Reading Notice Open count.
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


						@Test(priority =46)
						void AgeingGraph2to3yearsCase() throws InterruptedException, IOException
						{
						     	test = extent.startTest("Select Case from Notice/Case Filter to verify count of Ageing(2 to 3 year) Summary graph");
						     

						   		JavascriptExecutor js = (JavascriptExecutor)getDriver() ;
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
						@Test(priority =47)
						void AgeingGraphMoreThan3yearsCase() throws InterruptedException, IOException
						{
						     test = extent.startTest("Select Case from Notice/Case Filter to verify count of Ageing(more than 3 year) Summary graph");
						     

						   		JavascriptExecutor js = (JavascriptExecutor)getDriver() ;
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
					 @Test(priority = 48)
					 	void MyDocument() throws InterruptedException, IOException
					 	{
					 		test = extent.startTest("My Document-Download and View Document");
					 	
					 		
					 		MethodsPOM.MyDocument( test, workbook);
					 		
					 		extent.endTest(test);
					 		extent.flush();
					 	}
				
					 
				
						@Test(priority = 49)
						void MyReports() throws InterruptedException, IOException
						{
							test = extent.startTest("Reports -excel count verification");
							
							
							MethodsPOM.MyReports( test, "Company Admin");
							
							extent.endTest(test);
							extent.flush();
						}
					  
					@Test(priority = 50)
						void MoreReports() throws InterruptedException, IOException
						{
							test = extent.startTest("More Report-Reports excel  verification");
							
							
							MethodsPOM.MoreReport( test, "Company Admin");
							
							extent.endTest(test);
							extent.flush();
						}
				 @Test(priority =51)
					 	void MyReminder() throws InterruptedException, IOException
					 	{
					 		test = extent.startTest("My Reminder verification");
					 		
					 		MethodsPOM.MyReminder( test);
					 		
					 		extent.endTest(test);
					 		extent.flush();
					 	}
					 	
					 @Test(priority = 52)
					 	void ImportUtility() throws InterruptedException, IOException
					 	{
					 		test = extent.startTest("Import Utility verification");
					 		
					 		
					 		MethodsPOM.ImportUtility(test);
					 		extent.endTest(test);
					 		extent.flush();
					 	}
					 
					 @Test(priority = 53)
					 void CaseUpdationImportUtility() throws InterruptedException, IOException
					 {
					 	test = extent.startTest("Case Updation Import Utility verification");
					 	
					 	
					 	CFOMethod.CaseUpdationImportUtility(test);
					 	extent.endTest(test);
					 	extent.flush();
					 }

					 @Test(priority = 54)
					 void NoticeUpdation() throws InterruptedException, IOException
					 {
					 test = extent.startTest("Notice Updation Import Utility verification");


					 CFOMethod.NoticeUpdation(test);
					 extent.endTest(test);
					 extent.flush();
					 }
					
					 @Test(priority = 55)
						void Masters() throws InterruptedException, IOException
						{
							test = extent.startTest("Masters - Legal Entity  verification");
							
							
							MethodsPOM.LegalEntity( test);
							
							extent.endTest(test);
							extent.flush();
						}
				
					@Test(priority = 56)
					void Masters1() throws InterruptedException, IOException
					{
						test = extent.startTest("Masters - Law Firm verification");
						
						
						MethodsPOM.LawFirm( test);
						
						extent.endTest(test);
						extent.flush();
					}

			
				@Test(priority = 57)
				void Masters2() throws InterruptedException, IOException
				{
					test = extent.startTest("Masters - 	User  verification");
					
					MethodsPOM.User( test);
					
					extent.endTest(test);
					extent.flush();
				}
				

		@Test(priority = 58)
			void Masters3() throws InterruptedException, IOException
			{
				test = extent.startTest("Masters - Opponent  verification");
				
				
				MethodsPOM.Opponent( test);
				
				extent.endTest(test);
				extent.flush();
			}

		
		  @Test(priority = 59)
			void Masters4() throws InterruptedException, IOException
			{
				test = extent.startTest("Masters - Court  verification");
				
				MethodsPOM.Court( test);
				
				extent.endTest(test);
				extent.flush();
			}
		 
		 
	
			@Test(priority = 60)
			void Masters5() throws InterruptedException, IOException
			{
				test = extent.startTest("Masters - Case/NoticeType  verification");
				
				
				MethodsPOM.CaseNoticeType( test);
				
				extent.endTest(test);
				extent.flush();
			}
			
			
		
	@Test(priority = 61)
			void Masters6() throws InterruptedException, IOException
			{
				test = extent.startTest("Masters - Payment Type  verification");
				
				
				MethodsPOM.PaymentType( test);
				
				extent.endTest(test);
				extent.flush();
			}
		
		
@Test(priority = 62)
		void Masters7() throws InterruptedException, IOException
		{
			test = extent.startTest("Masters - Custom Parameter  verification");
			
			
			MethodsPOM.customParameter( test);
			
			extent.endTest(test);
			extent.flush();
		}

	
	 	@Test(priority = 63)
		void Masters8() throws InterruptedException, IOException
		{
			test = extent.startTest("Masters - Case Stage  verification");
			
			
			MethodsPOM.CaseStage( test);
			
			extent.endTest(test);
			extent.flush();
		}
		
	
	@Test(priority = 64)
	void Masters9() throws InterruptedException, IOException
	{
		test = extent.startTest("Masters - Document Type  verification");
		
		
		MethodsPOM.DocumentType( test);
		
		extent.endTest(test);
		extent.flush();
	}

	@Test(priority = 65)
	void Masters10() throws InterruptedException, IOException
	{
		test = extent.startTest("Masters - Rating Criteria  verification");
		
		
		MethodsPOM.RatingCriteria( test);
		
		extent.endTest(test);
		extent.flush();
	}
	

			
	@Test(priority = 66)
	void Masters11() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Masters - PageAuthorization   verification");
		
		
		MethodsPOM.PageAuthorization( test);
		
		extent.endTest(test);
		extent.flush();
	}
//@Test(priority = 67)
	void AnnualBudget() throws InterruptedException, IOException
	{
		test = extent.startTest("Masters - Annual Budget verification");
		
		
		MethodsPOM.AnnualBudget( test);
		
		extent.endTest(test);
		extent.flush();
	}

//@Test(priority = 68)
void UpdateAnnualBudget() throws InterruptedException, IOException
{
	test = extent.startTest("Masters - Update Annual Budget verification");
	
	
	MethodsPOM.UpdateAnnualBudget( test);
	
	extent.endTest(test);
	extent.flush();
}
//@Test(priority = 69)
void DeleteAnnualBudget() throws InterruptedException, IOException
{
	test = extent.startTest("Masters - Delete Annual Budget verification");
	
	
	MethodsPOM.DeleteAnnualBudget( test);
	
	extent.endTest(test);
	extent.flush();
}


//@Test(priority =70)
void Masters12() throws InterruptedException, IOException
{
	test = extent.startTest("Masters - Advocate Bill Approver  verification");
	
	
	MethodsPOM.AdvocateBillApprover( test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 71)
void Masters13() throws InterruptedException, IOException, AWTException
{
	test = extent.startTest("Masters - UserReassignment  verification");

	MethodsPOM.UserReassignment( test);
	
	extent.endTest(test);
	extent.flush();
}


@Test(priority =72)
void Masters14() throws InterruptedException, IOException, AWTException
{
	test = extent.startTest("Masters - Notice Stage  verification");
	
	
	MethodsPOM.NoticeStage( test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 73)
void Masters15() throws InterruptedException, IOException, AWTException
{
	test = extent.startTest("Masters - Mail Authorization  verification");
	
	
	MethodsPOM.MailAuthorization(test);
	
	extent.endTest(test);
	extent.flush();
}
@AfterMethod

void Close()
{
	 getDriver().close(); 
}				 	
	
	

}
