package litigationExternalLawyer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cfo.CFOcountPOM;
import licensePerformer.LiPerformerPOM;

import litigationAdditionalOwner.performerPOM;
import login.BasePage;
import performer.OverduePOM;

public class MethodPOM  extends BasePage

{
	
	   private static List<WebElement> elementsList = null;
	    public static FileInputStream fis = null;	//File input stream variable
		public static XSSFWorkbook workbook = null;	//Excel sheet workbook variable
		public static XSSFSheet sheet = null;		//Sheet variable
		public static XSSFSheet sheet1 = null;		//Sheet variable

		 static String filePath ="D:\\Litigation-Project 10 April2024\\Litigation-Project 10 April2024\\TestData\\LitigationSheet.xlsx";
		public static void progress() throws InterruptedException
		{
			WebDriverWait wait = new WebDriverWait(getDriver(), 180);
			try
			{
				Thread.sleep(300);
				wait.until(ExpectedConditions.invisibilityOf(LiPerformerPOM.Progress()));
			}
			catch(Exception e)
			{
				
			}
		}
		
//		public static XSSFSheet ReadExcel() throws IOException
//		{
//			//String workingDir = System.getProperty("user.dir");
//			fis = new FileInputStream("C:\\Users\\Admin\\Desktop\\Snehal\\ComplianceLatest\\ComplianceLatest\\TestData\\LitigationSheet.xlsx");
//			
//			workbook = new XSSFWorkbook(fis);
//			sheet = workbook.getSheetAt(9);					//Retrieving second sheet of Workbook
//			return sheet;
//		}
		
		static void perform( ExtentTest test, XSSFSheet sheet, int open, int gridRecords, String type, String noticeCategory) throws InterruptedException, EncryptedDocumentException, IOException
		{
			WebDriverWait wait = new WebDriverWait(getDriver(), 50);
			WebDriverWait wait1 = new WebDriverWait(getDriver(), 300);
			progress();
			
			Thread.sleep(500);
			JavascriptExecutor js = (JavascriptExecutor) getDriver();
//			CFOcountPOM.clickNextPage1().sendKeys(Keys.UP);
//			js.executeScript("window.scrollBy(0,-700)");		
			Thread.sleep(4000);
			clickNewNotice();
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
			clickDated();
			clickFinancialYear();
			clickRefNo();
			selectNoticeType();
			Thread.sleep(300);
			clickAct();
			Thread.sleep(6000);
			//clickOpponentcfo();
			selectOpponent();
			Thread.sleep(300);
			selectCategory();
			clickNoticeTitle();
			Thread.sleep(3000);
			clickNoticeDescription();
			Thread.sleep(7000);
			selectLocation();
			Thread.sleep(10000);
			clickDepartment();
			//clickJurisdiction();
			//Thread.sleep(3000);
			clickNoticeTerm();
			clickOwner();
			clickNoticeBudget();
			clickClaimedAmount();
			clickState();
			clickProvisionalAmount();
			clickProtestMoney();
			selectRisk();
			Thread.sleep(500);
			performerPOM.clickPotentialImpactRadio().click();			//Clicking on 'Monetary' radio button
			Thread.sleep(400);
			performerPOM.clickMonetary().sendKeys("Automation1232");
			Thread.sleep(3000);
			clickLawFirm();
			//Thread.sleep(3000);
			//selectSapCode();
			 Thread.sleep(5000);
			selectNoticeRecipetDate();
			 Thread.sleep(5000);
			clickInternalUser();
			 Thread.sleep(5000);
			clickLawyer();
	        Thread.sleep(3000);
			performerPOM.selectNoticeUploadDocument(); 
			Thread.sleep(3000);
			OverduePOM.clickSaveButton().click();						//Clicking on 'Save'button.
			Thread.sleep(1000);
			wait1.until(ExpectedConditions.visibilityOf(performerPOM.readMessage()));
			
			Thread.sleep(500);
			String msg = performerPOM.readMessage().getText();		//Reading Message appeared after save button
			
			if(msg.equalsIgnoreCase("Notice Created Successfully."))
			{
				test.log(LogStatus.PASS, "Message displayed = "+msg);
				
			}
			else
			{
				test.log(LogStatus.FAIL, "Message displayed = "+msg);
			}
			
//			WebElement ele1 = null;
//			WebElement ele2 = null;
//			WebElement ele3 = null;
//			WebElement ele4 = null;
//			
//			if(flag == 1)
//			{
//				try
//				{
//					ele1 = performerPOM.clickLinkNotice();
//					ele2 = performerPOM.clickViewDoc();
//					ele3 = performerPOM.clickSendMail();
//					ele4 = performerPOM.clickEditNotice();
//				}
//				catch(Exception e)
//				{
//					
//				}
//				
//				if(ele1 != null && ele2 != null && ele3 != null && ele4 != null)
//				{
//					test.log(LogStatus.PASS, "Icons displayed are :- Link Notice, View Document, Send Mail with Document, Edit Notice");
//				}
//				else
//				{
//					test.log(LogStatus.FAIL, "All icons are not displayed.");
//				}
//			}
		
		
			getDriver().switchTo().parentFrame();
			Thread.sleep(3000);
			wait.until(ExpectedConditions.elementToBeClickable(performerPOM.clickClose()));	
			performerPOM.clickClose().click();//Clicking on 'Close' 
			

			Thread.sleep(3000);
			performerPOM.clickExcelReport().sendKeys(Keys.PAGE_DOWN);
			js.executeScript("window.scrollBy(0,700)");

	      Thread.sleep(5000);
	      CFOcountPOM.readTotalItems1().click();
	      String item = CFOcountPOM.readTotalItems1().getText();
	      String[] bits = item.split(" ");								//Splitting the String
	      String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
	      int count1 = 0;
	      if(compliancesCount.equalsIgnoreCase("to"))
	     {
	        Thread.sleep(5000);
	        item = CFOcountPOM.readTotalItems1().getText();
	         bits = item.split(" ");								//Splitting the String
	        compliancesCount = bits[bits.length - 2];
	     }
	      Thread.sleep(5000); 
	       count1 = Integer.parseInt(compliancesCount);
	       
	       Thread.sleep(5000); 
	     if(count1 > gridRecords)
	     {
	       //test.log(LogStatus.PASS, "Total Case Count increased in grid after adding New Case.");
	       test.log(LogStatus.PASS, "Total Notice Count increased in grid after adding New Notice= Old Notice Count from Grid = "+gridRecords+" | New Notice Count from Grid = "+count1);
	     }
	     else
	     {
	        //test.log(LogStatus.FAIL, "Total Case Count doesn't increased in grid after adding New Case.");
	        test.log(LogStatus.FAIL, "Total Notice Count doesn't increased in grid after adding New Notice =Old Notice Count from Grid = "+gridRecords+" | New Notice Count from Grid = "+count1);
	     }
	     
			

	       Thread.sleep(3000);
	       OverduePOM.clickDashboard().click();			//Clicking on 'Dashboard'

	       Thread.sleep(3000);
	       wait.until(ExpectedConditions.visibilityOf(performerPOM.clickNoticeOpen()));
	       int open1 = Integer.parseInt(performerPOM.clickNoticeOpen().getText());	//Reading Notice Open count.

	       if(open1 > open)
	       {
	          test.log(LogStatus.PASS, type+" Dashboard Count increamented. Old count = "+open+", New Count = "+open1);
	       }
	       else
	      {
	          test.log(LogStatus.FAIL, type+" Dashboard Count doesn't increamented. Old count = "+open+", New Count = "+open1);
	       }
			
		}

			public  static void clickNewNotice() throws InterruptedException 
			  {
					Thread.sleep(3000);
//					JavascriptExecutor js = (JavascriptExecutor) getDriver();
//					CFOcountPOM.clickNextPage1().sendKeys(Keys.UP);
//					js.executeScript("window.scrollBy(0,-700)");
					performerPOM.clickNew().click();	//Clicking on 'New' button
	          }
					
			public static void clickDated()
			{
			performerPOM.clickDated().click();					//Clicking on 'Dated' button
			OverduePOM.selectLastMonth().click();					//Clicking last month arrow.
			OverduePOM.selectDate3().click();	//Clicking particular date.
			}
			
			public static void clickFinancialYear() throws InterruptedException
			{
			Thread.sleep(300);
			performerPOM.clickFinancialYear().click();			//Clicking on 'Financial Year' drop down.
			elementsList = performerPOM.chooseDropDownOption();
			elementsList.get(10).click();								//Clicking third option
			performerPOM.clickFinancialYear().click();			//Clicking on 'Financial Year' drop down.
	         }
			
			public static void clickRefNo() throws InterruptedException, EncryptedDocumentException, IOException
			{
				 FileInputStream fis = new FileInputStream(filePath);
			        Workbook workbook = WorkbookFactory.create(fis);
			        Sheet sheet = workbook.getSheetAt(6);
					Thread.sleep(500);
					Row row0 = sheet.getRow(5);						//Selected 0th index row (First row)
					Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
					String refno = c1.getStringCellValue();
					performerPOM.clickRefNo().sendKeys(refno);			//Writing 'Reference No'
			}
			
			public static void selectNoticeType() 
			{
				WebElement type = performerPOM.clickNoticeType();
				type.click();
				
				performerPOM.chooseNoticeType().click(); 
				
			}	

			public static void clickAct() throws InterruptedException, EncryptedDocumentException, IOException
			{
			   Thread.sleep(300);
			   FileInputStream fis = new FileInputStream(filePath);
		        Workbook workbook = WorkbookFactory.create(fis);
		        Sheet sheet = workbook.getSheetAt(6);
			   progress();
			   Row row0 = sheet.getRow(7);						//Selected 0th index row (First row)
			   	Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
			   int actNo = (int) c1.getNumericCellValue();
			   performerPOM.clickAct().click();						//Clicking on 'Act' drop down.
			   elementsList = performerPOM.chooseAct();
			   elementsList.get(3).click();							//Selecting particular act no
			   performerPOM.clickAct().click();						//Clicking on 'Act' drop down.
			}
			

			
		
			 public static void clickOpponentcfo() throws InterruptedException, EncryptedDocumentException, IOException
			   {
				 FileInputStream fis = new FileInputStream(filePath);
			        Workbook workbook = WorkbookFactory.create(fis);
			        Sheet sheet = workbook.getSheetAt(6);
		           Thread.sleep(300);
		           Row row0 = sheet.getRow(9);						//Selected 0th index row (First row)
		           Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		            String Opponent = c1.getStringCellValue();
	               performerPOM.clickOpponentcfo().sendKeys(Opponent);
			   }
		
		   public static void selectOpponent() throws InterruptedException, EncryptedDocumentException, IOException
		   {
			   FileInputStream fis = new FileInputStream(filePath);
		        Workbook workbook = WorkbookFactory.create(fis);
		        Sheet sheet = workbook.getSheetAt(6);
			  Thread.sleep(300);
			   Row row1 = sheet.getRow(9);						//Selected 0th index row (First row)
			   Cell c1 = row1.getCell(1);						//Selected cell (0 row,1 column)
			   String opponent = c1.getStringCellValue();
			   selectOpponent(opponent);
		    }
		   
		   public  static void selectOpponent(String opponentName)
		   {
				
				WebElement Opponent = performerPOM.clickOpponent();
				Opponent.click();
				
				performerPOM.chooseOpponent().click(); 

			}
		   
			public static void selectCategory() 
			{
				WebElement Category =  performerPOM.clickNoticeCategory();
				Category.click();
				 performerPOM.chooseCategory().click();
				 
		
			}
		   
		//	performerPOM.clickOpponent().click();					//Clicking on 'Opponent'
//			performerPOM.chooseOpponent().stream().filter(option -> option.getText().equals("Abcde")).toList().get(0).click();	//Writing 'Opponent' name
//			Thread.sleep(300);
//			performerPOM.clickSelectAll().click();
//			performerPOM.clickOpponent().click();
		
//			String Category = c1.getStringCellValue();
//			selectCategory(driver, Category);
//			Thread.sleep(300);
//			performerPOM.clickNoticeCategory().click();
//			performerPOM.chooseCategory();	
			
//			Thread.sleep(300);
//			row0 = sheet.getRow(5);						//Selected 0th index row (First row)
//			c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
//			String oppoLawyer = c1.getStringCellValue();
//			performerPOM.clickOppLawyer().click();				//Clicking on 'Opponent'
//			performerPOM.clickSearch2().sendKeys(oppoLawyer);		//Writing 'Opposition Lawyer' name
//			Thread.sleep(300);
//			performerPOM.clickSelectAll1().click();
//			performerPOM.clickOppLawyer().click();
			
			
			public static void clickNoticeTitle() throws InterruptedException, EncryptedDocumentException, IOException
			{
				 FileInputStream fis = new FileInputStream(filePath);
			        Workbook workbook = WorkbookFactory.create(fis);
			        Sheet sheet = workbook.getSheetAt(6);
			  Thread.sleep(300);
			  Row row0 = sheet.getRow(11);						//Selected 0th index row (First row)
			  Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
			  String title = c1.getStringCellValue();
			  performerPOM.clickNoticeTitle().sendKeys(title);		//Writing 'Notice Title'
			}
			
			public static void clickNoticeDescription() throws InterruptedException, EncryptedDocumentException, IOException
			{
				 FileInputStream fis = new FileInputStream(filePath);
			        Workbook workbook = WorkbookFactory.create(fis);
			        Sheet sheet = workbook.getSheetAt(6);
				Thread.sleep(300);
				Row row0 = sheet.getRow(12);						//Selected 0th index row (First row)
				Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
				String desc = c1.getStringCellValue();
				performerPOM.clickNoticeDescription().sendKeys(desc);	//Writing 'Notice Description'
				Thread.sleep(300);		
				performerPOM.clickNoticeDescription().sendKeys(Keys.PAGE_DOWN);
	        }
			
			public static void selectLocation() throws InterruptedException
			{
			Thread.sleep(7000);
			performerPOM.clickLocation().click();					//Clicking on Location drop down
			Thread.sleep(3000);
			//performerPOM.clickPlus().click();
			performerPOM.selectLocation().click();
									
			}
			
//			Thread.sleep(300);
//			wait.until(ExpectedConditions.visibilityOf(performerPOM.clickDated()));
//			wait.until(ExpectedConditions.elementToBeClickable(performerPOM.clickLocation()));
			
		//	performerPOM.clickNoticeDescription().sendKeys(Keys.PAGE_DOWN);
			
			public static void clickJurisdiction() throws InterruptedException, EncryptedDocumentException, IOException
			{
				 FileInputStream fis = new FileInputStream(filePath);
			        Workbook workbook = WorkbookFactory.create(fis);
			        Sheet sheet = workbook.getSheetAt(6);
				 Thread.sleep(300);
				Row row0 = sheet.getRow(13);						//Selected 0th index row (First row)
				Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
				String jurisdiction = c1.getStringCellValue();
				performerPOM.clickJurisdiction().click();					//Clicking on 'Jurisdiction' drop down
				Thread.sleep(600);
				performerPOM.clickSearch3().sendKeys(jurisdiction, Keys.ENTER);	//Writing 'Jurisdiction' name
			
			}
			
			public static void clickDepartment() throws InterruptedException, EncryptedDocumentException, IOException
			{
				 FileInputStream fis = new FileInputStream(filePath);
			        Workbook workbook = WorkbookFactory.create(fis);
			        Sheet sheet = workbook.getSheetAt(6);
				Thread.sleep(1000);
				Row row0 = sheet.getRow(14);						//Selected 0th index row (First row)
				Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
				String dept = c1.getStringCellValue();
				performerPOM.clickDepartment().click();					//Clicking on 'Department' drop down
				performerPOM.clickSearch4().sendKeys(dept, Keys.ENTER);	//Writing 'Department' name
			}
			
			public static void clickContactDept() throws InterruptedException, EncryptedDocumentException, IOException
			{
				 FileInputStream fis = new FileInputStream(filePath);
			        Workbook workbook = WorkbookFactory.create(fis);
			        Sheet sheet = workbook.getSheetAt(6);
				Thread.sleep(300);
				Row row0 = sheet.getRow(15);					//Selected 0th index row (First row)
				Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
				String ContactDept = c1.getStringCellValue();
				performerPOM.clickContactDept().click();					//Clicking on 'Contact Person of Department' drop down
				performerPOM.clickSearch5().sendKeys(ContactDept, Keys.ENTER);	//Writing 'Contact Person' name
			
			}
			
			public static void clickNoticeTerm() throws InterruptedException, EncryptedDocumentException, IOException
			{
				 FileInputStream fis = new FileInputStream(filePath);
			        Workbook workbook = WorkbookFactory.create(fis);
			        Sheet sheet = workbook.getSheetAt(6);
				Thread.sleep(300);
				Row row0 = sheet.getRow(16);					//Selected 0th index row (First row)
				Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
				int noticeTerm = (int) c1.getNumericCellValue();
				performerPOM.clickNoticeTerm().sendKeys(noticeTerm+"");		//Writing 'Notice Term'
			}
			
			public static void clickOwner() throws InterruptedException, EncryptedDocumentException, IOException
			{
				
				 FileInputStream fis = new FileInputStream(filePath);
			        Workbook workbook = WorkbookFactory.create(fis);
			        Sheet sheet = workbook.getSheetAt(6);
				Thread.sleep(300);
				Row row0 = sheet.getRow(17);					//Selected 0th index row (First row)
				Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
				String owner = c1.getStringCellValue();
				performerPOM.clickOwner().click();					//Clicking on 'Owner' drop down
				performerPOM.clickSearch6().sendKeys(owner, Keys.ENTER);	//Writing 'Owner' name
			}
			
			public static void selectRisk() throws InterruptedException
			{
//			Thread.sleep(300);
//			performerPOM.clickWinningProspect().click();
			//Thread.sleep(100);
		//	performerPOM.selectRisk().click();	          //Selecting 'Medium' Winning Prospect'
			Thread.sleep(500);
			performerPOM.clickRisk().click();							//Clicking on 'Risk' drop down.
			Thread.sleep(500);
			performerPOM.selectRisk().click();						//Selecting second option 'High' risk.
		
			
			}
			
			public static void clickNoticeBudget() throws InterruptedException, EncryptedDocumentException, IOException
			{
				 FileInputStream fis = new FileInputStream(filePath);
			        Workbook workbook = WorkbookFactory.create(fis);
			        Sheet sheet = workbook.getSheetAt(6);
				Thread.sleep(300);
				Row row0 = sheet.getRow(18);					//Selected 0th index row (First row)
				Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
				int noticeBudget = (int) c1.getNumericCellValue();
				performerPOM.clickNoticeBudget().sendKeys(noticeBudget+"");	//Writing 'Notice Budget'
			
			}
			
			public static void clickClaimedAmount() throws InterruptedException, EncryptedDocumentException, IOException
			{
				 FileInputStream fis = new FileInputStream(filePath);
			        Workbook workbook = WorkbookFactory.create(fis);
			        Sheet sheet = workbook.getSheetAt(6);
				Thread.sleep(300);
				Row row0 = sheet.getRow(19);					//Selected 0th index row (First row)
				Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
				int claimedAmount = (int) c1.getNumericCellValue();
				performerPOM.clickClaimedAmount().sendKeys(claimedAmount+"");	//Writing 'Claimed Amount'
				
			}
			
			public static void clickState() throws InterruptedException, EncryptedDocumentException, IOException
			{
				 FileInputStream fis = new FileInputStream(filePath);
			        Workbook workbook = WorkbookFactory.create(fis);
			        Sheet sheet = workbook.getSheetAt(6);
				Thread.sleep(300);
				Row row0 = sheet.getRow(20);					//Selected 0th index row (First row)
				Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
				String state = c1.getStringCellValue();
				performerPOM.clickState().click();					//Clicking on 'Owner' drop down
				performerPOM.clickSearchState().sendKeys(state, Keys.ENTER);	//Writing 'State' name
			}
			
			public static void clickProbableAmount() throws InterruptedException, EncryptedDocumentException, IOException
			{
				 FileInputStream fis = new FileInputStream(filePath);
			        Workbook workbook = WorkbookFactory.create(fis);
			        Sheet sheet = workbook.getSheetAt(6);
				Thread.sleep(300);
				Row row0 = sheet.getRow(21);					//Selected 0th index row (First row)
				Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
				int probAmount = (int) c1.getNumericCellValue();
				performerPOM.clickProbableAmount().sendKeys(probAmount+"");	//Writing 'Probable Amount'
			}
			
			public static void clickProvisionalAmount() throws InterruptedException, EncryptedDocumentException, IOException
			{
				 FileInputStream fis = new FileInputStream(filePath);
			        Workbook workbook = WorkbookFactory.create(fis);
			        Sheet sheet = workbook.getSheetAt(6);
				Thread.sleep(300);
				Row row0 = sheet.getRow(22);					//Selected 0th index row (First row)
				Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
				int provAmount = (int) c1.getNumericCellValue();
				performerPOM.clickProvisionalAmount().sendKeys(provAmount+"");	//Writing 'Provisional Amount'
			}
			
			public static void clickProtestMoney() throws InterruptedException, EncryptedDocumentException, IOException
			{
				 FileInputStream fis = new FileInputStream(filePath);
			        Workbook workbook = WorkbookFactory.create(fis);
			        Sheet sheet = workbook.getSheetAt(6);
				Thread.sleep(300);
				Row row0 = sheet.getRow(23);					//Selected 0th index row (First row)
				Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
				int protestAmount = (int) c1.getNumericCellValue();
				performerPOM.clickProtestMoney().sendKeys(protestAmount+"");	//Writing 'Protest Amount'
				Thread.sleep(500);
				performerPOM.clickProtestMoney().sendKeys(Keys.PAGE_DOWN);
			}

//			Thread.sleep(500);
//			performerPOM.clickPotentialImpactRadio().click();			//Clicking on 'Monetary' radio button
//			
//			Thread.sleep(400);
//			performerPOM.clickMonetary().sendKeys("Automation123");
			
			public static void clickLawFirm() throws InterruptedException, EncryptedDocumentException, IOException
			{
				 FileInputStream fis = new FileInputStream(filePath);
			        Workbook workbook = WorkbookFactory.create(fis);
			        Sheet sheet = workbook.getSheetAt(6);
				Thread.sleep(300);
				Row row0 = sheet.getRow(24);					//Selected 0th index row (First row)
				Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
				String lawFirm = c1.getStringCellValue();
				performerPOM.clickLawFirm().click();		//Clicking on 'Law Firm' drop down.
				performerPOM.chooseLawFirm().sendKeys(lawFirm, Keys.DOWN, Keys.ENTER);	//Writing & selecting 'Law Firm' name
			}
			

			
			
			public  static void selectNoticeRecipetDate()
		      {
		    	 	
		          WebElement openDate= performerPOM.selectNoticeRecipetDate();
		          openDate.sendKeys("30-09-2021");
		        
		      }
			public static void clickInternalUser() throws InterruptedException, EncryptedDocumentException, IOException
			{
				 FileInputStream fis = new FileInputStream(filePath);
			        Workbook workbook = WorkbookFactory.create(fis);
			        Sheet sheet = workbook.getSheetAt(6);
				Thread.sleep(300);
				Row row0 = sheet.getRow(25);						//Selected 0th index row (First row)
				Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
				int internalUserNo = (int) c1.getNumericCellValue();
				performerPOM.clickInternalUser().click();						//Clicking on 'Internal User' drop down.
				elementsList = performerPOM.chooseInternalUser();
				elementsList.get(internalUserNo).click();							//Selecting particular user no
				performerPOM.clickInternalUser().click();	//Clicking on 'Internal User' drop down.
			}
			
			public static void clickLawyer() throws InterruptedException, EncryptedDocumentException, IOException
			{
				 FileInputStream fis = new FileInputStream(filePath);
			        Workbook workbook = WorkbookFactory.create(fis);
			        Sheet sheet = workbook.getSheetAt(6);
				Thread.sleep(300);
				Row row0 = sheet.getRow(26);						//Selected 0th index row (First row)
				Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
				int lawyerNo = (int) c1.getNumericCellValue();
				performerPOM.clickLawyer().click();						//Clicking on 'Lawyer' drop down.
				elementsList = performerPOM.chooseLawyer();
				elementsList.get(lawyerNo).click();								//Selecting particular lawyer no
				performerPOM.clickLawyer().click();		//Clicking on 'Lawyer' drop down.
			}
			

			public static void NoticeOpen( ExtentTest test, XSSFWorkbook workbook, String login) throws InterruptedException, IOException
			{
				
				
			    
				
				Thread.sleep(3000);
				int open = CountExcel( test, "Notice - Open");
				
				Thread.sleep(3000);
				performerPOM.clickExcelReport().sendKeys(Keys.PAGE_DOWN);
				JavascriptExecutor js = (JavascriptExecutor) getDriver();
				js.executeScript("window.scrollBy(0,700)");
				
				Thread.sleep(5000);
				CFOcountPOM.readTotalItems1().click();
				String item = CFOcountPOM.readTotalItems1().getText();
				String[] bits = item.split(" ");								//Splitting the String
				String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
				int gridRecords = 0;
				if(compliancesCount.equalsIgnoreCase("to"))
				{
					Thread.sleep(2000);
					item = CFOcountPOM.readTotalItems1().getText();
					bits = item.split(" ");								//Splitting the String
					compliancesCount = bits[bits.length - 2];
				}
				if(compliancesCount.equalsIgnoreCase("to"))
				{
					gridRecords = 0;
				}
				else
				{
					gridRecords = Integer.parseInt(compliancesCount);
				}
				//sheet = workbook.getSheetAt(6);
				getDriver().navigate().refresh();
				perform( test, sheet, open, gridRecords, "Notice - Open",compliancesCount);
			}
			static int CountExcel(ExtentTest test, String type) throws InterruptedException, IOException
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				progress();
				
				//wait.until(ExpectedConditions.visibilityOf(performerPOM.clickNoticeOpen()));
				
				
				int open = 0;
				if(type.equalsIgnoreCase("Notice - Open"))
				{
					open = Integer.parseInt(performerPOM.clickNoticeOpen().getText());	//Reading Notice Open count.
					performerPOM.clickNoticeOpen().click();						//Clicking on 'Open' notice
				}
				else if(type.equalsIgnoreCase("Notice - Closed"))
				{
					open = Integer.parseInt(performerPOM.clickNoticeClosed().getText());	//Reading Notice Closed count.
					performerPOM.clickNoticeClosed().click();						//Clicking on 'Closed' notice
				}
				else if(type.equalsIgnoreCase("Case - Open"))
				{
					open = Integer.parseInt(performerPOM.clickCaseOpencfo().getText());	//Reading Case Open count.
					performerPOM.clickCaseOpencfo().click();						//Clicking on 'Open' Case
				}
				else if(type.equalsIgnoreCase("Case - Closed"))
				{
					open = Integer.parseInt(performerPOM.clickCaseClosedCFO().getText());	//Reading Case Open count.
					performerPOM.clickCaseClosedCFO().click();						//Clicking on 'Open' Case
				}
				
				else if(type.equalsIgnoreCase("Task - Open"))
				{
					open = Integer.parseInt(performerPOM.clickTaskOpen().getText());	//Reading Case Open count.
					performerPOM.clickTaskOpen().click();						//Clicking on 'Open' Case
				}
				
				else if(type.equalsIgnoreCase("Task - Closed"))
				{
					open = Integer.parseInt(performerPOM.clickTaskClosed().getText());	//Reading Case Open count.
					performerPOM.clickTaskClosed().click();						//Clicking on 'Open' Case
				}
				
				
				
				
				
				Thread.sleep(5000);
				progress();
				
				Thread.sleep(5000);
				wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
				
				Thread.sleep(2000);
				JavascriptExecutor js = (JavascriptExecutor) getDriver();
				try
				{
					performerPOM.clickExcelReport().sendKeys(Keys.PAGE_DOWN);
				}
				catch(Exception e)
				{
					
				}
				js.executeScript("window.scrollBy(0,1000)");
				
				Thread.sleep(7000);
				CFOcountPOM.readTotalItems1().click();
				String item = CFOcountPOM.readTotalItems1().getText();
				String[] bits = item.split(" ");								//Splitting the String
				String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
//	   			int count1 = 0;
//				if(compliancesCount.equalsIgnoreCase("to"))
//				{
//					Thread.sleep(2000);
//				   item = CFOcountPOM.readTotalItems1().getText();
//					bits = item.split(" ");								//Splitting the String
//				   compliancesCount = bits[bits.length - 2];
//				}
//				if(compliancesCount.equalsIgnoreCase("to"))
//				{
//					count1 = 0;
//				}
//				else
//	   			{
					int count1 = Integer.parseInt(compliancesCount);
//	  			}
				
				if(open == count1)
				{
					//test.log(LogStatus.PASS, type+" count matches to number of records displayed.");
					test.log(LogStatus.PASS, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
				}
				else
				{
					//test.log(LogStatus.FAIL, type+" count doesn't matches to number of records displayed.");
					test.log(LogStatus.FAIL, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
				}
				
				Thread.sleep(100);
				File dir = new File("C://Users//snehalp//Downloads");
				File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
				
				Thread.sleep(500);
				CFOcountPOM.clickNextPage1().sendKeys(Keys.PAGE_UP);
				Thread.sleep(5000);
				performerPOM.clickExcelReport().click();					//Clicking on 'Excel Report' image.
				//performerPOM.clickExcelReport().click();					//Clicking on 'Excel Report' image.
				
				Thread.sleep(5500);
				File dir1 = new File("C://Users//snehalp//Downloads");
				File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download
				
				if(dirContents.length < allFilesNew.length)
				{
					test.log(LogStatus.PASS, "File downloaded successfully.");
					
					File lastModifiedFile = allFilesNew[0];			//Storing any 0th index file in 'lastModifiedFile' file name.
				    for (int i = 1; i < allFilesNew.length; i++) 	//For loop till the number of files in directory.
				    {
				       if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) 	//If allFilesNew[i] file is having large/latest time time of update then latest modified file be allFilesNew[i] file.
				       {
				           lastModifiedFile = allFilesNew[i];
				       }
				    }
					
					Thread.sleep(5000);
					fis = new FileInputStream(lastModifiedFile);
					workbook = new XSSFWorkbook(fis);
					sheet = workbook.getSheetAt(0);					//Retrieving first sheet of Workbook
					
					int no = sheet.getLastRowNum();
					Row row = sheet.getRow(no);
					Cell c1 = row.getCell(0);
					String records =c1.getStringCellValue();
					int SheetRecords = 0;
				
					try
					{
						SheetRecords = Integer.parseInt(records);
						
					}
					catch(Exception e)
					{
						
					}
					
//					if(flag == 0)
//					{
//						row = sheet.getRow(no-1);
//						c1 = row.getCell(0);
//						records = c1.getStringCellValue();
//						SheetRecords = Integer.parseInt(records);
//					}
					fis.close();
					
			if(count1 == SheetRecords)
					{
						//test.log(LogStatus.PASS, "No of records from grid matches to no of records in Excel Sheet.");
						test.log(LogStatus.PASS, "Total records from Grid = "+count1+" | Total records from Report = "+SheetRecords);
					}
					else
					{
						//test.log(LogStatus.FAIL, "No of records from grid doesn't matches to no of records in Excel Sheet.");
						test.log(LogStatus.FAIL, "Total records from Grid = "+count1+" | Total records from Excel Sheet = "+SheetRecords);
					}
				}
				else
				{
					Thread.sleep(5000);
					test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
				}
				return open;
			}
			public static void NoticeDocument( ExtentTest test) throws InterruptedException
			{
				
				WebDriverWait wait=new WebDriverWait(getDriver(),300); 
				
				 Thread.sleep(8000);
					performerPOM.clickNoticeOpen().click();
					
					Thread.sleep(8000);
					wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
				    
					Thread.sleep(8000);
					performerPOM.clickEditNotice().click();//click edit notice
				
			       wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
			       
			       Thread.sleep(8000);
			       performerPOM.clickNoticeDocument().click();     //click notice document
			       Thread.sleep(8000);
			       performerPOM.clickNewDocument().click();        //click new document button
			
			Thread.sleep(7000);
			getDriver().switchTo().frame("IFrameManageDocument");
			performerPOM.selectDocumentType();
			Thread.sleep(3000);
			performerPOM.chooseDocumentType();
			Thread.sleep(1000);
			performerPOM.selectUploadDocument(); 
			Thread.sleep(1000);
			performerPOM.clickUploadDocument().click(); 
			
			
			Thread.sleep(1000);
			wait.until(ExpectedConditions.visibilityOf(performerPOM.readDocMsg()));
			
			Thread.sleep(3000);
			String msg= performerPOM.readDocMsg().getText();		//Reading Message appeared after save button
			
			if(msg.equalsIgnoreCase("Document(s) uploaded successfully"))
			{
				test.log(LogStatus.PASS, "Message displayed = "+msg);
		
			}
			else
			{
				test.log(LogStatus.FAIL, "Message displayed = "+msg);
			}
			
			Thread.sleep(1000);
			performerPOM.clickClosedDocument().click();
			
			getDriver().switchTo().parentFrame();
		      Thread.sleep(3000);
	        performerPOM.clickNoticeDocumentDownloadcfo().click();
	        
	        test.log(LogStatus.PASS, "Document download succssesfully");
	        
	        Thread.sleep(3000);
	        performerPOM.clickNoticeDocumentViewcfo().click();
	        
	       
	        
	        Thread.sleep(3000);
	        performerPOM.clickNoticeDocumentViewClosepopupcfo().click();
	        
	        test.log(LogStatus.PASS, "Document View popup open  succssesfully"); 
	       
	        
	     /*   Thread.sleep(3000);
	        performerPOM.clickNoticeDocumentsharecfo().click();
	        
	        Thread.sleep(5000);
		    // Switching to Alert        
	        Alert alert1 = getDriver().switchTo().alert();		
	        		
	        // Capturing alert message.    
	        String alertMessage1= getDriver().switchTo().alert().getText();	
	        
	        
	        test.log(LogStatus.PASS, alertMessage1);
	        		
	        // Displaying alert message		
	        System.out.println(alertMessage1);
	        
	     // Accepting alert		
	        alert1.accept();	
	        
	        
	   wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("Iframe_Docshare"));
	        
	        Thread.sleep(4000);
	        performerPOM.clickNoticeDocumentshareemailcfo().sendKeys("admin@itc.com");
	        
	        Thread.sleep(3000);
	        performerPOM.clickNoticeDocumentsharecontactnocfo().sendKeys("5768798045");
	        
	        Thread.sleep(3000);
	        performerPOM.clickNoticeDocumentsharesavecfo().click();
	        
	        
	        Thread.sleep(3000);
	        String msg1= performerPOM.clickNoticeDocumentsharereadmsgcfo().getText();		//Reading Message appeared after save button
	       
       	if(msg1.equalsIgnoreCase("Document shared successfully."))
       	{
	        	test.log(LogStatus.PASS, "Message displayed = "+msg1);
	         
	        }
	      else
	        {
		       test.log(LogStatus.FAIL, "Message displayed = "+msg1);
	        }
	        
	        
	        getDriver().switchTo().parentFrame();
	        Thread.sleep(3000);
	        performerPOM. clickNoticeDocumentshareclosepopupcfo().click();*/
	        
	        
	        Thread.sleep(3000);
	        performerPOM.clickNoticeDocumentdeletecfo().click();
	        
	        Thread.sleep(5000);
		    // Switching to Alert        
	        Alert alert = getDriver().switchTo().alert();		
	        		
	        // Capturing alert message.    
	        String alertMessage= getDriver().switchTo().alert().getText();	
	        
	        
	        test.log(LogStatus.PASS, alertMessage);
	        		
	        // Displaying alert message		
	        System.out.println(alertMessage);
	        
	 		
	        // Accepting alert		
	        alert.accept();	
	        
	       
	        
	        getDriver().switchTo().parentFrame();
	    }
			
			
		 public  static void TaskActivtity( ExtentTest test) throws InterruptedException, EncryptedDocumentException, IOException
				{
			 		WebDriverWait wait=new WebDriverWait(getDriver(),300); 
				
			 		//sheet = workbook.getSheetAt(6);
			 		Thread.sleep(8000);
			 		performerPOM.clickNoticeOpen().click();
				
			 		Thread.sleep(8000);
			 		wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
			    
			 		Thread.sleep(8000);
			 		performerPOM.clickEditNotice().click();//click edit notice
					
					   Thread.sleep(1000);
					   wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
					  Thread.sleep(1000);
					  performerPOM.clickTaskorActivity().click();
					  Thread.sleep(1000);
					  performerPOM.clickNewTask().click(); 
					 
					  
					  FileInputStream fis = new FileInputStream(filePath);
				        Workbook workbook = WorkbookFactory.create(fis);
				        Sheet sheet = workbook.getSheetAt(6);
					Thread.sleep(3000);
					Row row0 = sheet.getRow(29);								//Selected 0th index row (First row)
					Cell c1 = row0.getCell(1);								//Selected cell (0 row,1 column)
					String title = c1.getStringCellValue();
					performerPOM.clickTaskTitle().sendKeys(title);	//Writing 'Task Title'
					
					Thread.sleep(3000);
					row0 = sheet.getRow(30);									//Selected 0th index row (First row)
					c1 = row0.getCell(1);									//Selected cell (0 row,1 column)
					String desc = c1.getStringCellValue();
					performerPOM.clickTaskDesc().sendKeys(desc);		//Writing 'Task Description'
					
					Thread.sleep(3000);
					performerPOM.clickDueDate().click();				//Clicking on 'Due Date' text box
					OverduePOM.selectNextMonth().click();
					OverduePOM.selectDate().click();					//Selecting particular date.
					
					Thread.sleep(500);
					Actions action = new Actions(getDriver());
//					action.moveToElement(performerPOM.clickPriority()).click().sendKeys(Keys.DOWN,Keys.ENTER).perform();
					
					Thread.sleep(500);
					row0 = sheet.getRow(31);									//Selected 0th index row (First row)
					c1 = row0.getCell(1);									//Selected cell (0 row,1 column)
					String outcome = c1.getStringCellValue();
					performerPOM.clickExpOutcome().sendKeys(outcome);	//Writing 'Expected Outcome'
					
					Thread.sleep(500);
					row0 = sheet.getRow(32);									//Selected 0th index row (First row)
					c1 = row0.getCell(1);									//Selected cell (0 row,1 column)
					String internalUser = c1.getStringCellValue();
					performerPOM.clickInternalUser2().click();
					//performerPOM.selectInternalUser2().click();
					performerPOM.selectInternalUser2().sendKeys(internalUser, Keys.ENTER);	//Selecting 'Internal User'
					
		
					
					Thread.sleep(1000);
					row0 = sheet.getRow(33);									//Selected 0th index row (First row)
					c1 = row0.getCell(1);									//Selected cell (0 row,1 column)
					String externalUser = c1.getStringCellValue();
					try
					{
						Thread.sleep(300);
						performerPOM.clickExternalUser().click();
						Thread.sleep(500);
						action.moveToElement(performerPOM.clickSearchExternalUser()).sendKeys(externalUser, Keys.ENTER).perform();
					}
					catch(Exception e)
					{
						
					}
				
					Thread.sleep(2000);
					row0 = sheet.getRow(34);									//Selected 0th index row (First row)
					c1 = row0.getCell(1);									//Selected cell (0 row,1 column)
					String remark = c1.getStringCellValue();
					performerPOM.clickRemark().sendKeys(remark);		//Writing 'Remark'
					
					//Thread.sleep(300);
					//String workingDir = System.getProperty("user.dir");
					//performerPOM.clickUpload().sendKeys(workingDir+"//Reports//PerformerResults.html");	//Uploading file
					
					Thread.sleep(3000);
					OverduePOM.clickSaveButton().click();				//Clicking on 'Save' button.
					//Thread.sleep(3000);
					//wait.until(ExpectedConditions.visibilityOf(performerPOM.readTaskMsg1()));
					
					try
					{
					   Thread.sleep(8000);
					    String msg = performerPOM.readTaskMsg1().getText();
					
					    test.log(LogStatus.PASS, "Add Task ="+msg);
						
					}	
	                 catch(Exception e)
					{
						Thread.sleep(8000);
						String msg = performerPOM.readTaskMsg().getText();
						
							test.log(LogStatus.PASS, "Add Task =" +msg);
						
				    }
					Thread.sleep(3000);
					performerPOM.clickNoticeEditTaskcfo().click();
					Thread.sleep(3000);
					performerPOM.clickTaskTitle().clear();
					
					Thread.sleep(3000);
					performerPOM.clickTaskTitle().sendKeys("Automation test 1520423");	//Writing 'Task Title'
					
					Thread.sleep(4000);
					OverduePOM.clickSaveButton().click();				//Clicking on 'Save' button.
					
					try
					{
						Thread.sleep(300);
						wait.until(ExpectedConditions.visibilityOf(performerPOM.readTaskMsg1()));
					
						Thread.sleep(300);
						String msg2 = performerPOM.readTaskMsg1().getText();
			
					
						test.log(LogStatus.PASS, "Update Task :-"+msg2);
					}
					catch(Exception e)
					{
					
						Thread.sleep(300);
						wait.until(ExpectedConditions.visibilityOf(performerPOM.readTaskMsg()));
					
						Thread.sleep(300);
						String msg3 = performerPOM.readTaskMsg().getText();
						
						test.log(LogStatus.FAIL, "Update Task :-"+msg3);
					}
					
					
				
					
					Thread.sleep(5000);
					performerPOM.clickNoticeTaskEditResponsecfo().click();
					
					Thread.sleep(1000);
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
					
					Thread.sleep(3000);
					performerPOM.clickNoticeTaskstatusResponsecfo().click();
					
					Thread.sleep(3000);
					performerPOM.clickNoticeTaskstatusResponsecfo1().click();
					
					Thread.sleep(3000);
					performerPOM.clickNoticeTaskcmtResponsecfo().sendKeys("Automate Test 12242");
					
					Thread.sleep(3000);
					performerPOM.clickNoticeTaskSaveResponsecfo().click();
					
					
					
					test.log(LogStatus.PASS,"Task Response Saved Successfully.");
					
					getDriver().switchTo().parentFrame();
					
					Thread.sleep(3000);
					performerPOM.clickNoticeTaskCloseResponsecfo().click();
					
	                Thread.sleep(3000);
					performerPOM.clickNoticeTaskClosecfo().click();
					
					 Thread.sleep(5000);
					    // Switching to Alert        
				        Alert alert = getDriver().switchTo().alert();		
				        		
				        // Capturing alert message.    
				        String alertMessage= getDriver().switchTo().alert().getText();	
				        
				        
				        test.log(LogStatus.PASS, alertMessage);
				        		
				        // Displaying alert message		
				        System.out.println(alertMessage);
				        
				     // Accepting alert		
				        alert.accept();
					
					Thread.sleep(3000);
					performerPOM.clickNoticeTaskdeletecfo().click();
					
					 Thread.sleep(5000);
					    // Switching to Alert        
				        Alert alert1 = getDriver().switchTo().alert();		
				        		
				        // Capturing alert message.    
				        String alertMessage1= getDriver().switchTo().alert().getText();	
				        
				        
				        test.log(LogStatus.PASS, alertMessage1);
				        		
				        // Displaying alert message		
				        System.out.println(alertMessage1);
				        
				     // Accepting alert		
				        alert1.accept(); 
				        getDriver().switchTo().parentFrame();
					
					
					
					
				}
			   
	 public static void Response( ExtentTest test) throws InterruptedException, EncryptedDocumentException, IOException
				{
				   WebDriverWait wait = new WebDriverWait(getDriver(), 60);
				  
				   Thread.sleep(8000);
	 				performerPOM.clickNoticeOpen().click();
	 				
	 		      	Thread.sleep(8000);
	 	 	        	wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
	 			    
	 				Thread.sleep(8000);
	 				performerPOM.clickEditNotice().click();//click edit notice

	 			      Thread.sleep(8000);
	 			      wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
	 				   
				  
					   
					    // Thread.sleep(3000);
						  performerPOM. clickResponse().click();
						  Thread.sleep(3000);
						  performerPOM. clickNewResponse().click();
						  Thread.sleep(3000);
						  performerPOM. selectSentNotice();
						  Thread.sleep(3000);
						  performerPOM. selectReplyDueDate();
						  Thread.sleep(3000);
						  performerPOM. selectRespondedDate();
						  FileInputStream fis = new FileInputStream(filePath);
					        Workbook workbook = WorkbookFactory.create(fis);
					        Sheet sheet = workbook.getSheetAt(6);
						 		 
						  Thread.sleep(500);
						  Row row1 = sheet.getRow(37);								//Selected 0th index row (First row)
						  Cell c2 = row1.getCell(1);								//Selected cell (0 row,1 column)
						  String DeliveryMode= c2.getStringCellValue();
						  performerPOM.clickDeliveryMode().click();
						  performerPOM.selectDeliveryMode().sendKeys(DeliveryMode);
						  
						  
						  Thread.sleep(500);
						  Row row0 = sheet.getRow(38);								//Selected 0th index row (First row)
						  Cell c1 = row0.getCell(1);								//Selected cell (0 row,1 column)
						  String CourierCompany= c1.getStringCellValue();
						  performerPOM.clickCourierCompany().sendKeys(CourierCompany);
							 
						  Thread.sleep(500);
							Row row2 = sheet.getRow(39);								//Selected 0th index row (First row)
							Cell c3 = row2.getCell(1);								//Selected cell (0 row,1 column)
							String RefNo= c3.getStringCellValue();
							performerPOM.RefTrackingNo().sendKeys(RefNo);
								 
							Thread.sleep(500);
							Row row3 = sheet.getRow(40);								//Selected 0th index row (First row)
							Cell c4 = row3.getCell(1);								//Selected cell (0 row,1 column)
							String Description= c4.getStringCellValue();
							 performerPOM.Description().sendKeys(Description);
								
							  JavascriptExecutor jse=(JavascriptExecutor)getDriver();
								jse.executeScript("arguments[0].click();",  performerPOM.clickSaveResponse());
							  //performerPOM.clickSaveResponse().click();
								
							
								
								
								try
								{
									
									Thread.sleep(8000);
									wait.until(ExpectedConditions.visibilityOf(performerPOM.readResponseMsg()));
									Thread.sleep(8000);
									String msg3 = performerPOM.readResponseMsg().getText();		//Reading Message appeared after save button
								
									if(msg3.equalsIgnoreCase(msg3))
									{
										test.log(LogStatus.PASS, "Add Response= "+msg3);
									
									}
									
								}
								catch(Exception e)
								{
									Thread.sleep(8000);
									performerPOM.clickMinimizeResponse().click();
									Thread.sleep(8000);
									String msg3 = performerPOM.readResponseInvalidMsg().getText();		//Reading Message appeared after save button
								
									if(msg3.equalsIgnoreCase(msg3))
									{
										test.log(LogStatus.FAIL, "Add Response= "+msg3);
									
									}
									
								}
								
								  Thread.sleep(3000);
					                performerPOM.clickNoticeEditResponsecfo().click();
					
				                   	performerPOM.clickCourierCompany().clear();
				                  
									  performerPOM.clickCourierCompany().sendKeys("LAATDSD");
					                Thread.sleep(3000);
					               performerPOM.clickNoticeResponseDocUploadtcfo();
					
					  
					               jse.executeScript("arguments[0].click();",  performerPOM.clickSaveResponse());
					               
					  
					             Thread.sleep(1000);
					           	wait.until(ExpectedConditions.visibilityOf(performerPOM.readResponseMsg()));
					 		
						        Thread.sleep(500);
						        String msg4 = performerPOM.readResponseMsg().getText();		//Reading Message appeared after save button
						
						        if(msg4.equalsIgnoreCase("Response Details Saved Successfully."))
						       {
							      test.log(LogStatus.PASS, "Message displayed = "+msg4);
							
						        }
							  else
							  {
								test.log(LogStatus.FAIL, "Message displayed = "+msg4);
							   }
						
						     Thread.sleep(4000);
						     performerPOM.clickNoticeDownloadResponsecfo().click();
						
						   test.log(LogStatus.PASS, "Document download succssesfully");
						
						    Thread.sleep(4000);
						     performerPOM.clickNoticeViewResponsecfo().click();
						
						      Thread.sleep(6000);
						      performerPOM.clickNoticeclosePopupResponsecfo().click();
						
						      test.log(LogStatus.PASS, "Document view popup open succssesfully");
						
						     Thread.sleep(4000);
						     performerPOM.clickNoticeDeleteResponsecfo().click();
						
						      Thread.sleep(5000);
						    // Switching to Alert        
					        Alert alert1 = getDriver().switchTo().alert();		
					        		
					        // Capturing alert message.    
					        String alertMessage1= getDriver().switchTo().alert().getText();	
					        
					        
					        test.log(LogStatus.PASS, alertMessage1);
					        		
					        // Displaying alert message		
					        System.out.println(alertMessage1);
					        
					     // Accepting alert		
					        alert1.accept();
					        
					        getDriver().switchTo().parentFrame(); 
								
				       }
		  public static void PaymentLog( ExtentTest test) throws InterruptedException
			{
			   WebDriverWait wait = new WebDriverWait(getDriver(), 60);
			   
			   Thread.sleep(8000);
				performerPOM.clickNoticeOpen().click();
				
				Thread.sleep(8000);
				wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
			    
				Thread.sleep(8000);
				performerPOM.clickEditNotice().click();//click edit notice
				Thread.sleep(8000);
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
					Thread.sleep(8000);
					performerPOM.clickStatusPayments().click();			//Clicking on 'Status/Payments'
				

				
								
					Thread.sleep(3000);
					performerPOM.clickInvoiceNo().sendKeys("48579");
					
					
					Thread.sleep(3000);
//					Row r5 = sheet.getRow(45);
//					Cell c5 = r5.getCell(1);
//					String PaymentType = c5.getStringCellValue();
					performerPOM.clickPaymentType().click();
//					performerPOM.selectPaymentType().sendKeys(PaymentType,Keys.ENTER);
					List<WebElement> PaymentType1= getDriver().findElements(By.xpath("//*[@id='grdNoticePayment_ddlPaymentType_chosen']/div/ul/li"));
					PaymentType1.get(2).click();
						
					Thread.sleep(5000);
//					Row r6 = sheet.getRow(46);
//					Cell c6 = r6.getCell(1);
//					String Amount = c6.getStringCellValue();
		
					performerPOM.clickAmount().sendKeys("7000");
				
					Thread.sleep(300);
					performerPOM.clickSavePaymentLog().click();
					

					 Thread.sleep(1000);
					  
					 wait.until(ExpectedConditions.visibilityOf(performerPOM.readPymentmsg()));
						
						Thread.sleep(500);
						String msg4 = performerPOM.readPymentmsg().getText();		//Reading Message appeared after save button
						
						if(msg4.equalsIgnoreCase("Payment Details Saved Successfully."))
						{
							test.log(LogStatus.PASS, "Message displayed = "+msg4);
							
						}
						else
						{
							test.log(LogStatus.FAIL, "Message displayed = "+msg4);
						}
						try
						{
							Thread.sleep(8000);
							performerPOM.clickNoticeViewPaymentDoccfo().click();
						
							Thread.sleep(8000);
							performerPOM.clickNoticeclosePaymentDocpopupcfo().click();
						
							test.log(LogStatus.PASS, "Payment Document popup open successfully");
						}
						catch(Exception e)
						{
							Thread.sleep(8000);
							String msg =performerPOM.readPymentmsg().getText();
							test.log(LogStatus.PASS,"Message displayed :-"+msg);
						}
						
						
						
						
						try
						{
							Thread.sleep(8000);
					        performerPOM.clickNoticeDownloadPaymentcfo().click();
							Thread.sleep(8000);
							String msg =performerPOM.readPymentmsg().getText();
							test.log(LogStatus.PASS,"Message displayed :-"+msg);
						
						}
						catch(Exception e)
						{
							Thread.sleep(8000);
					        performerPOM.clickNoticeDownloadPaymentcfo().click();
					        
					        test.log(LogStatus.PASS, "Payment Document Download Successfully.");
						}
						
						
						Thread.sleep(3000);
						performerPOM.clickNoticeEditPaymentcfo().click();
						
						performerPOM.clickInvoiceNo().clear();
						 Thread.sleep(3000);
					    performerPOM.clickInvoiceNo().sendKeys("Invoice No 578");
					    
					    Thread.sleep(6000);
						performerPOM.clickNoticeStatusPaymentUploadtcfo();
					    
					    Thread.sleep(3000);
						performerPOM.clickSavePaymentLog().click();
						
						
						
						 Thread.sleep(3000);
						performerPOM.clickNoticeDeletePaymentcfo().click();
						
						 Thread.sleep(5000);
						    // Switching to Alert        
					        Alert alert1 = getDriver().switchTo().alert();		
					        		
					        // Capturing alert message.    
					        String alertMessage1= getDriver().switchTo().alert().getText();	
					        
					        
					        test.log(LogStatus.PASS, alertMessage1);
					        		
					        // Displaying alert message		
					        System.out.println(alertMessage1);
					        
					     // Accepting alert		
					        alert1.accept();
					        
					        Thread.sleep(500);
							String msg5 = performerPOM.readPymentmsg().getText();		//Reading Message appeared after save button
						
							if(msg5.equalsIgnoreCase("Payment Details Deleted Successfully."))
							{
								test.log(LogStatus.PASS, "Message displayed = "+msg5);
							
							}
							else
							{
								test.log(LogStatus.FAIL, "Message displayed = "+msg5);
							}
					        
					       
							
					        getDriver().switchTo().parentFrame(); 
					    	
					
					
				 
				}
			
			
		static void ExternalLawyerRating( ExtentTest test) throws InterruptedException
			{
				
			
			
				 WebDriverWait wait = new WebDriverWait(getDriver(), 100);
			  Thread.sleep(3000);
			   performerPOM. clickExternalLawyerRating().click();
			   Thread.sleep(3000);
			   performerPOM.selectExternalLawyerRating();
			   
			
			   Thread.sleep(3000);
			   performerPOM.clickNewCriteria().click();
			   Thread.sleep(3000);
			   wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IframeLayerRatingCriteria"));
			   performerPOM.clickCriteria().sendKeys(" Rating New Automate Test	`	`	");
			   Thread.sleep(3000);
			   performerPOM.clickSaveCriteria().click();
			   Thread.sleep(3000);
			   getDriver().switchTo().parentFrame();
			   performerPOM.clickclosecriteria().click();
			   Thread.sleep(3000);
			   performerPOM. clickstar().click();
			   Thread.sleep(3000);
			   performerPOM. clickstar1().click();
			   Thread.sleep(3000);
			   performerPOM. clickSaveRating().click();
			   

				  Thread.sleep(1000);
					wait.until(ExpectedConditions.visibilityOf(performerPOM.readRatingmsg()));
					
					Thread.sleep(500);
					String msg5 = performerPOM.readRatingmsg().getText();		//Reading Message appeared after save button
					int flag5= 0;
					if(msg5.equalsIgnoreCase("Rating Saved Successfully."))
					{
						test.log(LogStatus.PASS, "Message displayed = "+msg5);
						flag5 = 1;
					}
					else
					{
						test.log(LogStatus.FAIL, "Message displayed = "+msg5);
					}
			}
			   
			   
		public static void AuditLog(ExtentTest test) throws InterruptedException
		{
		WebDriverWait wait = new WebDriverWait(getDriver(), 60);
		
		 Thread.sleep(8000);
			performerPOM.clickNoticeOpen().click();
			
		  	Thread.sleep(8000);
	        	wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
		    
			Thread.sleep(8000);
			performerPOM.clickEditNotice().click();//click edit notice
			Thread.sleep(8000);
		   wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
		   Thread.sleep(8000);
		   performerPOM. clickAuditLog().click();
		   Thread.sleep(8000);
		   performerPOM.clickExport().click();		   
	
	
		   test.log(LogStatus.PASS, "File download Successfully");
		   
		   Thread.sleep(8000);
		   getDriver().switchTo().parentFrame();
		   performerPOM.clickclosebutton().click();
			Thread.sleep(8000);
		       OverduePOM.clickDashboard().click();
		}
		static void perform1( ExtentTest test,  int open, int gridRecords, String type) throws InterruptedException, EncryptedDocumentException, IOException
		{
			WebDriverWait wait = new WebDriverWait(getDriver(), 50);
			WebDriverWait wait1 = new WebDriverWait(getDriver(), 300);
			
//			
//			Thread.sleep(5000);
//		performerPOM.clickcategory().click();
	//	
//		Thread.sleep(5000);
//		performerPOM.clickcategory2().click();
		
		
//		if(performerPOM.clearButton().isEnabled())
//			{
//				performerPOM.clearButton().click();
//				test.log(LogStatus.PASS, "Clear button working successfully");
//			}
//			else
//			{
//				test.log(LogStatus.FAIL, "Clear button not working successfully");
//			}
			Thread.sleep(500);
			JavascriptExecutor js = (JavascriptExecutor) getDriver();
		
			js.executeScript("window.scrollBy(0,-700)");
			
			Thread.sleep(3000);
			clickNewCase();
					
			progress();
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
			
			Thread.sleep(1000);
			selectCaseType();
			Thread.sleep(3000);
			clickDated1();
			Thread.sleep(3000);
			clickFinanicialYear();
			Thread.sleep(3000);
			clickRefNo1();
			Thread.sleep(3000);
			clickInternalCaseNo();
			Thread.sleep(3000);
			clickCaseTitle();
			Thread.sleep(3000);
			clickCaseAct();
			Thread.sleep(3000);
			clickUnderSection();
			Thread.sleep(3000);
			clickSearchCaseCategory();
			Thread.sleep(3000);
			clickCaseBudget();
			Thread.sleep(3000);
			clickCaseOpponent();
//			Thread.sleep(3000);
//			clickCaseOppLawyer();
			Thread.sleep(3000);
			clickCaseCourt();
			Thread.sleep(3000);
			clickCaseDescription();
			Thread.sleep(5000);
			selectCaseLocation();
			Thread.sleep(3000);
			clickCaseDepartment();
			Thread.sleep(3000);
			clickCaseOwner();
			Thread.sleep(3000);
			clickCaseRisk();
			Thread.sleep(3000);
			clickLawFirm1();
			Thread.sleep(4000);
			clickCaseInternalUser();
			Thread.sleep(3000);
			clickLawyer1( ) ;
			Thread.sleep(3000);
			OverduePOM.clickSaveButton().click();						//Clicking on 'Save'button.
			
			Thread.sleep(1000);
			wait.until(ExpectedConditions.visibilityOf(performerPOM.readMessage1()));
			
			Thread.sleep(500);
			String msg = performerPOM.readMessage1().getText();		//Reading Message appeared after save button
			
			if(msg.equalsIgnoreCase("Case Created Successfully."))
			{
				test.log(LogStatus.PASS, "Message displayed = "+msg);
				
			}
		else
			{
				test.log(LogStatus.PASS, "Message displayed = "+msg);
			}
		
		/*	WebElement ele1 = null;
			WebElement ele2 = null;
			WebElement ele3 = null;
			WebElement ele4 = null;
			
			if(flag == 1)
			{
				try
				{
					Thread.sleep(700);
					wait.until(ExpectedConditions.visibilityOf(performerPOM.clickEditCase()));
					ele1 = performerPOM.clickLinkCase();
					ele2 = performerPOM.clickViewDoc();
					ele3 = performerPOM.clickSendMail1();
				ele4 = performerPOM.clickEditCase();
				}
				catch(Exception e)
				{
					
				}
				
				if(ele1 != null && ele2 != null && ele3 != null && ele4 != null)
				{
					test.log(LogStatus.PASS, "Icons displayed are :- Link Notice, View Document, Send Mail with Document, Edit Notice");
				}
				else
				{
					test.log(LogStatus.FAIL, "All icons are not displayed.");
				}
			}*/
			
			
		
			getDriver().switchTo().parentFrame();
			Thread.sleep(3000);
			wait.until(ExpectedConditions.elementToBeClickable(performerPOM.clickClose()));	
			Thread.sleep(3000);
			performerPOM.clickClose().click();//Clicking on 'Close' 
			
			Thread.sleep(3000);
			performerPOM.clickExcelReport().sendKeys(Keys.PAGE_DOWN);
			js.executeScript("window.scrollBy(0,700)");
			
			

	      Thread.sleep(3000);
	      CFOcountPOM.readTotalItems1().click();
	      String item = CFOcountPOM.readTotalItems1().getText();
	      String[] bits = item.split(" ");								//Splitting the String
	      String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
	      int count1 = 0;
	      if(compliancesCount.equalsIgnoreCase("to"))
	     {
	        Thread.sleep(2000);
	        item = CFOcountPOM.readTotalItems1().getText();
	         bits = item.split(" ");								//Splitting the String
	        compliancesCount = bits[bits.length - 2];
	     }
	       count1 = Integer.parseInt(compliancesCount);

	    if(count1 > gridRecords)
	     {
	       //test.log(LogStatus.PASS, "Total Case Count increased in grid after adding New Case.");
	       test.log(LogStatus.PASS, "Total Case Count increased in grid after adding New Case = Old Case Count from Grid = "+gridRecords+" | New Case Count from Grid = "+count1);
	     }
	     else
	     {
	        //test.log(LogStatus.FAIL, "Total Case Count doesn't increased in grid after adding New Case.");
	        test.log(LogStatus.FAIL, "Total Case Count doesn't increased in grid after adding New Case= Old Case Count from Grid = "+gridRecords+" | New Case Count from Grid = "+count1);
	     }

	       Thread.sleep(3000);
	       OverduePOM.clickDashboard().click();			//Clicking on 'Dashboard'

	 
	       
	       
	       Thread.sleep(500);
	    
	       int open1 = Integer.parseInt(performerPOM.clickCaseOpencfo().getText());	//Reading Notice Open count.
	       
	   	Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(performerPOM.clickNoticeOpen()));
		
		if(type.equalsIgnoreCase("Case - Open"))
		{
			open1 = Integer.parseInt(performerPOM.clickCaseOpencfo().getText());	//Reading Notice Open count.
		}
		else
		{
			open1 = Integer.parseInt(performerPOM.clickCaseClosed().getText());	//Reading Notice Open count.
		}

	      if(open1 > open)
	       {
	          test.log(LogStatus.PASS, type+" Dashboard Count increamented. Old count = "+open+", New Count = "+open1);
	       }
	       else
	      {
	          test.log(LogStatus.FAIL, type+" Dashboard Count doesn't increamented. Old count = "+open+", New Count = "+open1);
	       }
	     }


			  public  static void clickNewCase() throws InterruptedException 
			  {
					Thread.sleep(3000);
					performerPOM.clickNew().click();	//Clicking on 'New' button

	           }
			  public  static void clickCaseskip() throws InterruptedException 
			  {
					Thread.sleep(3000);
					
					performerPOM.clickCaseskipfo().click();
	           }
			 
			
			  public  static void clickDated1() throws InterruptedException 
			  {
				  Thread.sleep(3000);
			      performerPOM.clickCaseDate().click();					//Clicking on 'Dated' button
			      OverduePOM.selectLastMonth().click();					//Clicking last month arrow.
			      OverduePOM.selectDate3().click();						//Clicking particular date.
			  }
			
			  public  static void clickFinanicialYear() throws InterruptedException 
			  {
			      Thread.sleep(3000);
			      performerPOM.clickFinancialYear().click();			//Clicking on 'Financial Year' drop down.
			      elementsList = performerPOM.clickFinanceSearchCheckbox();
			      elementsList=performerPOM.chooseDropDownOption();
			      elementsList.get(10).click();								//Clicking third option
			      performerPOM.clickFinancialYear().click();			//Clicking on 'Financial Year' drop down.
			  }
			
			

				
			  public  static void clickRefNo1() throws InterruptedException, EncryptedDocumentException, IOException 
			  {
				  FileInputStream fis = new FileInputStream(filePath);
			        Workbook workbook = WorkbookFactory.create(fis);
			        Sheet sheet = workbook.getSheetAt(6);
			       Thread.sleep(3000);
			       Row row0 = sheet.getRow(52);								//Selected 0th index row (First row)
			      Cell c1 = row0.getCell(1);								//Selected cell (0 row,1 column)
			      String refno = c1.getStringCellValue();
			      performerPOM.clickRefNo().sendKeys(refno);			//Writing 'Court Case No'
			  }
				
			  public  static void clickInternalCaseNo() throws InterruptedException, EncryptedDocumentException, IOException 
			  {
				  FileInputStream fis = new FileInputStream(filePath);
			        Workbook workbook = WorkbookFactory.create(fis);
			        Sheet sheet = workbook.getSheetAt(6);
			       Thread.sleep(3000);
			      Row row0 = sheet.getRow(53);								//Selected 0th index row (First row)
			      Cell c1 = row0.getCell(1);								//Selected cell (0 row,1 column)
			       String caseNo = c1.getStringCellValue();
			       performerPOM.clickInternalCaseNo().sendKeys(caseNo);	//Writing 'Court Case No'
			  }
			  public  static void clickCaseTitle() throws InterruptedException, EncryptedDocumentException, IOException 
			  {
				  FileInputStream fis = new FileInputStream(filePath);
			        Workbook workbook = WorkbookFactory.create(fis);
			        Sheet sheet = workbook.getSheetAt(6);
			       Thread.sleep(3000);
			       Row row0 = sheet.getRow(54);								//Selected 0th index row (First row)
			       Cell c1 = row0.getCell(1);								//Selected cell (0 row,1 column)
			      String title = c1.getStringCellValue();
			       performerPOM.clickNoticeTitle().sendKeys(title);		//Writing 'Case Title'
			  }

		 	
			  public  static void clickCaseAct() throws InterruptedException, EncryptedDocumentException, IOException 
			  {
				  FileInputStream fis = new FileInputStream(filePath);
			        Workbook workbook = WorkbookFactory.create(fis);
			        Sheet sheet = workbook.getSheetAt(6);
	   	      Thread.sleep(3000);
		         Row row0 = sheet.getRow(55);								//Selected 0th index row (First row)
		         Cell c1 = row0.getCell(1);								//Selected cell (0 row,1 column)
	 	          int actNo = (int) c1.getNumericCellValue();
			     performerPOM.clickAct().click();						//Clicking on 'Act' drop down.
//		       //	elementsList = performerPOM.chooseAct();
			    elementsList = performerPOM.chooseAct1();
		        elementsList.get(2).click();							//Selecting particular act no
			     performerPOM.clickAct().click();	                  //Clicking on 'Act' drop down.
			  }
			  
			  public  static void clickUnderSection() throws InterruptedException, EncryptedDocumentException, IOException 
			  { 
				  FileInputStream fis = new FileInputStream(filePath);
			        Workbook workbook = WorkbookFactory.create(fis);
			        Sheet sheet = workbook.getSheetAt(6);
			     Thread.sleep(3000);
			     Row row0 = sheet.getRow(56);								//Selected 0th index row (First row)
			     Cell c1 = row0.getCell(1);								//Selected cell (0 row,1 column)
			     String underSection = c1.getStringCellValue();
			      performerPOM.clickUnderSection().sendKeys(underSection);	//Writing 'Under section'
			  }
			  public  static void clickSearchCaseCategory() throws InterruptedException, EncryptedDocumentException, IOException 
			  { 
				  FileInputStream fis = new FileInputStream(filePath);
			        Workbook workbook = WorkbookFactory.create(fis);
			        Sheet sheet = workbook.getSheetAt(6);
			     Thread.sleep(3000);
			     Row row0 = sheet.getRow(57);								//Selected 0th index row (First row)
			    Cell c1 = row0.getCell(1);								//Selected cell (0 row,1 column)
			    String caseType = c1.getStringCellValue();
			    performerPOM.clickCaseCategory().click();
			    performerPOM.clickSearchCaseCategory().sendKeys(caseType, Keys.ENTER);	//Writing 'Case Type'
			  }
			  public  static void clickCaseBudget() throws InterruptedException, EncryptedDocumentException, IOException 
			  {
				  FileInputStream fis = new FileInputStream(filePath);
			        Workbook workbook = WorkbookFactory.create(fis);
			        Sheet sheet = workbook.getSheetAt(6);
			      Thread.sleep(3000);
			     Row row0 = sheet.getRow(58);								//Selected 0th index row (First row)
			      Cell c1 = row0.getCell(1);								//Selected cell (0 row,1 column)
			      int caseBudget = (int) c1.getNumericCellValue();
			     performerPOM.clickCaseBudget().sendKeys(caseBudget+"");
			  }
			
			  public  static void clickCaseOpponent() throws InterruptedException 
			  {
				  Thread.sleep(3000);
				   performerPOM.clickOpponent().click();
				   Thread.sleep(3000);
				   performerPOM.chooseOpponent().click(); 
				   Thread.sleep(3000);
				  performerPOM.clickOpponent().click();	
			
			  }

			  public  static void clickCaseOppLawyer() throws InterruptedException, EncryptedDocumentException, IOException 
			  {
				  FileInputStream fis = new FileInputStream(filePath);
			        Workbook workbook = WorkbookFactory.create(fis);
			        Sheet sheet = workbook.getSheetAt(6);
		          Thread.sleep(3000);
			      Row row0 = sheet.getRow(60);								//Selected 0th index row (First row)
			      Cell c1 = row0.getCell(1);								//Selected cell (0 row,1 column)
			       String oppoLawyer = c1.getStringCellValue();
			       performerPOM.clickOppLawyer().click();				//Clicking on 'Opponent'
			       performerPOM.clickSearchBox1().sendKeys(oppoLawyer);	//Writing 'Opposition Lawyer' name
			       Thread.sleep(300);
			        performerPOM.clickSelectAll3().click();
			        performerPOM.clickOppLawyer().click();
			  }
			  public  static void clickCaseCourt() throws InterruptedException, EncryptedDocumentException, IOException 
			  {
				  FileInputStream fis = new FileInputStream(filePath);
			        Workbook workbook = WorkbookFactory.create(fis);
			        Sheet sheet = workbook.getSheetAt(6);
			         Thread.sleep(3000);
			        Row row0 = sheet.getRow(61);								//Selected 0th index row (First row)
			         Cell c1 = row0.getCell(1);								//Selected cell (0 row,1 column)
			       String court = c1.getStringCellValue();
			       performerPOM.clickCourt().click();
			       performerPOM.clickSearchCourt().sendKeys(court, Keys.ENTER);
			  }
			
			
		
			  public  static void clickCaseDescription() throws InterruptedException, EncryptedDocumentException, IOException 
			  {
				  FileInputStream fis = new FileInputStream(filePath);
			        Workbook workbook = WorkbookFactory.create(fis);
			        Sheet sheet = workbook.getSheetAt(6);
			        Thread.sleep(3000);
			       Row row0 = sheet.getRow(63);							//Selected 0th index row (First row)
			       Cell  c1 = row0.getCell(1);								//Selected cell (0 row,1 column)
			       String casedesc = c1.getStringCellValue();
			      performerPOM.clickNoticeDescription().sendKeys(casedesc);
			  }
			  
			  public static void selectCaseLocation() throws InterruptedException
				{
				Thread.sleep(7000);
				performerPOM.clickLocation().click();					//Clicking on Location drop down
				Thread.sleep(7000);
			//	performerPOM.clickPlus().click();
				performerPOM.selectLocationCfo().click();;
				//elementsList.get(2).click();								//Selecting third visible location
				}
				public static void clickCaseDepartment() throws InterruptedException
				{
					Thread.sleep(4000);
				performerPOM.clickDeptCfo().click();					//Clicking on 'Department' drop down
				performerPOM.selectDeptCfo().click();	//Writing 'Department' name
				}
				public static void clickCaseOwner() throws InterruptedException
				{
				
				performerPOM.clickOwnerCfo().click();					//Clicking on 'Owner' drop down
				performerPOM.selectOwnerCfo().click();	//Writing 'Owner' name
				}
			 
			 public  static void clickCaseRisk() throws InterruptedException 
			  { 
			    Thread.sleep(3000);
			    performerPOM.clickWinningProspect1().click();
		 	   Thread.sleep(100);
		       performerPOM.selectRisk1().click();			//Selecting 'Medium' Winning Prospect'
			  }
			 
		
		 public  static void clickCaseInternalUser() throws InterruptedException, EncryptedDocumentException, IOException 
			  { 
				 FileInputStream fis = new FileInputStream(filePath);
			        Workbook workbook = WorkbookFactory.create(fis);
			        Sheet sheet = workbook.getSheetAt(6);
				       Thread.sleep(3000);
		            Row row0 = sheet.getRow(74);						//Selected 0th index row (First row)
			       Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
			       int internalUserNo = (int) c1.getNumericCellValue();
			      performerPOM.clickInternalUser().click();						//Clicking on 'Internal User' drop down.
			      elementsList = performerPOM.chooseInternalUser1();
			       elementsList.get(internalUserNo).click();							//Selecting particular user no
			      performerPOM.clickInternalUser().click();						//Clicking on 'Internal User' drop down.
			  }
		 
			public static void clickLawyer1() throws InterruptedException, EncryptedDocumentException, IOException
			{
				 FileInputStream fis = new FileInputStream(filePath);
			        Workbook workbook = WorkbookFactory.create(fis);
			        Sheet sheet = workbook.getSheetAt(6);
			Thread.sleep(300);
			Row row0 = sheet.getRow(75);						//Selected 0th index row (First row)
			Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
			int lawyerNo = (int) c1.getNumericCellValue();
			performerPOM.clickLawyer().click();	
			Thread.sleep(300);//Clicking on 'Lawyer' drop down.
			elementsList = performerPOM.chooseLawyer();
			elementsList.get(lawyerNo).click();								//Selecting particular lawyer no
			Thread.sleep(300);
			performerPOM.clickLawyer().click();		//Clicking on 'Lawyer' drop down.
			}
			
			public static void clickLawFirm1() throws InterruptedException, EncryptedDocumentException, IOException
			{
				 FileInputStream fis = new FileInputStream(filePath);
			        Workbook workbook = WorkbookFactory.create(fis);
			        Sheet sheet = workbook.getSheetAt(6);
			 Thread.sleep(3000);
			 Row row1 = sheet.getRow(73);					//Selected 0th index row (First row)
			 Cell c2 = row1.getCell(1);						//Selected cell (0 row,1 column)
			 String lawFirm = c2.getStringCellValue();
			 performerPOM.clickLawFirm().click();		//Clicking on 'Law Firm' drop down.
			 performerPOM.chooseLawFirm().sendKeys(lawFirm, Keys.DOWN, Keys.ENTER);	//Writing & selecting 'Law Firm' name
			}
	  
			

			public static void Document(ExtentTest test) throws InterruptedException
			{
	           			
			
	          WebDriverWait wait = new WebDriverWait(getDriver(), 50);
	          Thread.sleep(4000);
	          performerPOM.clickCaseOpen().click();
	          Thread.sleep(3000);
	          performerPOM.clickEditNotice().click();
			  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
			  Thread.sleep(2000);
			  performerPOM.clickNoticeDocument().click();     //click notice document
			  Thread.sleep(1000);
			  performerPOM.clickNewDocument().click();        //click new document button
			
	 
				Thread.sleep(1000);
				getDriver().switchTo().frame("IFrameManageDocument");
				performerPOM.selectDocumentType();
				Thread.sleep(3000);
				performerPOM.chooseDocumentType();
				Thread.sleep(1000);
				performerPOM.selectUploadDocument(); 
				Thread.sleep(1000);
				performerPOM.clickUploadDocument().click(); 
			
			
			  Thread.sleep(1000);
			  wait.until(ExpectedConditions.visibilityOf(performerPOM.readDocMsg()));
			
			  Thread.sleep(500);
			  String msg=performerPOM.readDocMsg().getText();		//Reading Message appeared after save button
			  int flag = 0;
			  if(msg.equalsIgnoreCase("Document(s) uploaded successfully"))
			 {
				 test.log(LogStatus.PASS, "Message displayed = "+msg);
				 flag = 1;
			 }
			 else
			 {
				 test.log(LogStatus.FAIL, "Message displayed = "+msg);
			 }
			
			  Thread.sleep(1000);
			  performerPOM.clickClosedDocument().click(); 
			  
			  getDriver().switchTo().parentFrame();
			    Thread.sleep(3000);
		        performerPOM.clickCaseDownloadDocumentcfo().click();
		        
		        test.log(LogStatus.PASS, "Document download succssesfully");
		        
		        Thread.sleep(3000);
		        performerPOM.clickCaseDocumentViewcfo().click();
		        
		        Thread.sleep(3000);
		        performerPOM.clickNoticeDocumentViewClosepopupcfo().click();
		        
		        test.log(LogStatus.PASS, "Document View popup open  succssesfully");
		        
		        
		       
		        
		        Thread.sleep(3000);
		        performerPOM.clickCaseDocumentsharecfo().click();
		        
		        
		     	  
		        Thread.sleep(5000);
			    // Switching to Alert        
		        Alert alert1 = getDriver().switchTo().alert();		
		        		
		        // Capturing alert message.    
		        String alertMessage1= getDriver().switchTo().alert().getText();	
		        
		        
		        test.log(LogStatus.PASS, alertMessage1);
		        		
		        // Displaying alert message		
		        System.out.println(alertMessage1);
		        
		     // Accepting alert		
		        alert1.accept();	
		        
              wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("Iframe_Docshare"));
		        
		        Thread.sleep(3000);
		        performerPOM.clickNoticeDocumentshareemailcfo().sendKeys("admin@gmail.com");
		        
		        Thread.sleep(3000);
		        performerPOM.clickNoticeDocumentsharecontactnocfo().sendKeys("5768798045");
		        
		        Thread.sleep(3000);
		        performerPOM.clickNoticeDocumentsharesavecfo().click();
		        
		        
		        Thread.sleep(3000);
		        String msg1= performerPOM.clickNoticeDocumentsharereadmsgcfo().getText();		//Reading Message appeared after save button
		       
	         	if(msg1.equalsIgnoreCase("Document shared successfully."))
	         	{
		        	test.log(LogStatus.PASS, "Message displayed = "+msg1);
		         
		        }
		      else
		        {
			       test.log(LogStatus.FAIL, "Message displayed = "+msg1);
		        }
		        
	         	  
	  	        Thread.sleep(3000);
	  	        performerPOM. clickNoticeDocumentshareclosepopupcfo().click();
	  	      getDriver().switchTo().parentFrame();
	  	       
	         	
		        
		        Thread.sleep(3000);
		        performerPOM.clickCaseDocumentdeletecfo().click();
		        
		        Thread.sleep(5000);
			    // Switching to Alert        
		        Alert alert = getDriver().switchTo().alert();		
		        		
		        // Capturing alert message.    
		        String alertMessage= getDriver().switchTo().alert().getText();	
		        
		        
		        test.log(LogStatus.PASS, alertMessage);
		        		
		        // Displaying alert message		
		        System.out.println(alertMessage);
		        
		 		
		        // Accepting alert		
		        alert.accept();	

		     getDriver().switchTo().parentFrame();
			  
			  
		 }
			
			public static void TaskActivity1( ExtentTest test,String login) throws InterruptedException, IOException
			{
				
				
			    WebDriverWait wait=new WebDriverWait(getDriver(),20);
			    Thread.sleep(8000);
			    performerPOM.clickCaseOpen().click();
		          Thread.sleep(8000);
		          performerPOM.clickEditNotice().click();
		      	//sheet = workbook.getSheetAt(6);	
			    Thread.sleep(8000);
			    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
			    Thread.sleep(8000);
			    performerPOM.clickCaseTask().click();
			    Thread.sleep(8000);
			    performerPOM.clickCaseNewTask().click(); 
			    
			    
			    Thread.sleep(8000);
			    performerPOM.clickHearingDate().sendKeys("27-06-2025");
			    Thread.sleep(8000);
			    performerPOM.clickSaveHearingDate().click();
			  
			    FileInputStream fis = new FileInputStream(filePath);
		        Workbook workbook = WorkbookFactory.create(fis);
		        Sheet sheet = workbook.getSheetAt(6);
			  
				Thread.sleep(8000);
				Row row0 = sheet.getRow(29);								//Selected 0th index row (First row)
				Cell c1 = row0.getCell(1);								//Selected cell (0 row,1 column)
				String title = c1.getStringCellValue();
				performerPOM.clickTaskTitle().sendKeys(title);	//Writing 'Task Title'
				
				Thread.sleep(8000);
				row0 = sheet.getRow(30);									//Selected 0th index row (First row)
				c1 = row0.getCell(1);									//Selected cell (0 row,1 column)
				String desc = c1.getStringCellValue();
				performerPOM.clickTaskDesc().sendKeys(desc);		//Writing 'Task Description'
				
				
				Thread.sleep(8000);
				performerPOM.clickDueDate().click();				//Clicking on 'Due Date' text box
				Thread.sleep(8000);
				OverduePOM.selectNextMonth().click();
				Thread.sleep(8000);
				OverduePOM.selectDate().click();					//Selecting particular date.
				
				Thread.sleep(8000);
				Actions action = new Actions(getDriver());
//				action.moveToElement(performerPOM.clickPriority()).click().sendKeys(Keys.DOWN,Keys.ENTER).perform();
				
				
				Thread.sleep(8000);
				 row0 = sheet.getRow(31);									//Selected 0th index row (First row)
				 c1 = row0.getCell(1);									//Selected cell (0 row,1 column)
				String outcome = c1.getStringCellValue();
				performerPOM.clickExpOutcome().sendKeys(outcome);	//Writing 'Expected Outcome'
				
				
				
				Thread.sleep(1000);
				row0 = sheet.getRow(32);									//Selected 0th index row (First row)
				c1 = row0.getCell(1);									//Selected cell (0 row,1 column)
				String internalUser = c1.getStringCellValue();
				performerPOM.clickInternalUser3().click();
				
//				Thread.sleep(1000);
//				performerPOM.selectInternalUser4().click();
				//performerPOM.selectInternalUser2().click();
				performerPOM.selectInternalUser3().sendKeys(internalUser, Keys.ENTER);	//Selecting 'Internal User'
				
//				Thread.sleep(1000);
//				row0 = sheet.getRow(33);									//Selected 0th index row (First row)
//				c1 = row0.getCell(1);									//Selected cell (0 row,1 column)
//				String externalUser = c1.getStringCellValue();
				try
				{
					Thread.sleep(300);
					performerPOM.clickExternalUser().click();
					Thread.sleep(300);
					performerPOM.selectExternalUser1().click();
					
//					Thread.sleep(500);
//					action.moveToElement(performerPOM.clickSearchExternalUser()).sendKeys(externalUser, Keys.ENTER).perform();
				}
				catch(Exception e)
				{
					
				}
				Thread.sleep(5000);
				row0 = sheet.getRow(34);									//Selected 0th index row (First row)
				c1 = row0.getCell(1);									//Selected cell (0 row,1 column)
				String remark = c1.getStringCellValue();
				performerPOM.clickRemark().sendKeys(remark);		//Writing 'Remark'
	         	Thread.sleep(1000);
				OverduePOM.clickSaveButton().click();				//Clicking on 'Save' button.
				
			
					Thread.sleep(8000);
					String msg = performerPOM.readTaskMsg1().getText();
					if(msg.equalsIgnoreCase(msg))
					{
						test.log(LogStatus.PASS, "Add Task =" +msg);
					}
					else
					{
						test.log(LogStatus.FAIL, "Add Task =" +msg);
					}
					
					//*********************Edit Task*****************************************************************************************//	
					
					Thread.sleep(3000);
					performerPOM.clickMinimize().click();	
					
					Thread.sleep(3000);
					performerPOM.clickMinimize1().click();	
							
					Thread.sleep(8000);
					performerPOM.clickNoticeEditTask().click();
					
				
					
					Actions a = new Actions(getDriver());
					//scroll down a page
					a.sendKeys(Keys.PAGE_DOWN).build().perform();
					
					Thread.sleep(8000);
					performerPOM.clickTaskTitle().clear();
					
					Thread.sleep(8000);
					performerPOM.clickTaskTitle().sendKeys(" Task 27july");	//Writing 'Task Title'
							
					
					Thread.sleep(8000);
					OverduePOM.clickSaveButton().click();				//Clicking on 'Save' button.
					
					Thread.sleep(8000);
					wait.until(ExpectedConditions.visibilityOf(performerPOM.readTaskMsg1()));
					
					Thread.sleep(8000);
					String msg2 = performerPOM.readTaskMsg1().getText();
			
					if(msg2.contains(msg2))
					{
						test.log(LogStatus.PASS, "Update Task =" +msg2);
					}
					
					else if(msg2.contains(msg2))
					{
						test.log(LogStatus.FAIL, "Update Task =" +msg2);
					}
					
					
					try
					{
						Thread.sleep(8000);
						performerPOM.clickNoticeTaskEditResponse1().click();
					
						Thread.sleep(8000);
						wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
					
						Thread.sleep(8000);
						performerPOM.clickNoticeTaskstatusResponsecfo().click();
					
						Thread.sleep(8000);
						performerPOM.clickNoticeTaskstatusResponsecfo1().click();
					
						Thread.sleep(8000);
						performerPOM.clickNoticeTaskcmtResponsecfo().sendKeys("Test 19Jan2024");
					
						Thread.sleep(8000);
						performerPOM.clickNoticeTaskSaveResponsecfo().click();
					
					
					
						test.log(LogStatus.PASS,"Task Response Saved Successfully.");
					}
						
						catch(Exception e)
						{
							test.log(LogStatus.PASS,"Task Respose :- Already Task closed.");
						}
					
					
					
		
			//*********************Existing Data*******************************************************************************************//
					  
				
					
					   	Thread.sleep(8000);
					    performerPOM.clickCaseNewTask().click(); 
					    Thread.sleep(8000);
					    performerPOM.clickHearingDatecfo().click(); 
					    Thread.sleep(8000);
					    performerPOM.clickHearingDatedropdowncfo().click(); 

					  
					  
						Thread.sleep(8000);
						Row row1 = sheet.getRow(29);								//Selected 0th index row (First row)
						Cell c2 = row1.getCell(1);								//Selected cell (0 row,1 column)
						String title1 = c2.getStringCellValue();
						performerPOM.clickTaskTitle().sendKeys(title1);	//Writing 'Task Title'
						
						Thread.sleep(8000);
						Row row2 = sheet.getRow(30);									//Selected 0th index row (First row)
						Cell c3 = row2.getCell(1);									//Selected cell (0 row,1 column)
						String desc1 = c3.getStringCellValue();
						performerPOM.clickTaskDesc().sendKeys(desc1);		//Writing 'Task Description'
						
						
						Thread.sleep(8000);
						performerPOM.clickDueDate().click();				//Clicking on 'Due Date' text box
						Thread.sleep(8000);
						OverduePOM.selectNextMonth().click();
						Thread.sleep(8000);
						OverduePOM.selectDate().click();					//Selecting particular date.
			
						
						
						
//						Thread.sleep(8000);
//						row0 = sheet.getRow(31);									//Selected 0th index row (First row)
//						c1 = row0.getCell(1);									//Selected cell (0 row,1 column)
//						String internalUser1 = c1.getStringCellValue();
//						performerPOM.clickInternalUser3().click();
//						//performerPOM.selectInternalUser2().click();
//						performerPOM.selectInternalUser3().sendKeys(internalUser1, Keys.ENTER);	//Selecting 'Internal User'
						
//						Thread.sleep(8000);
//						performerPOM.clickInternalUser3().click();
//						
//						Thread.sleep(1000);
//						performerPOM.selectInternalUser4().click();
						
						
						
						Thread.sleep(1000);
						row0 = sheet.getRow(32);									//Selected 0th index row (First row)
						c1 = row0.getCell(1);									//Selected cell (0 row,1 column)
						String internalUser1 = c1.getStringCellValue();
						performerPOM.clickInternalUser3().click();
						
//						Thread.sleep(1000);
//						performerPOM.selectInternalUser4().click();
						//performerPOM.selectInternalUser2().click();
						performerPOM.selectInternalUser3().sendKeys(internalUser1, Keys.ENTER);	//Selecting 'Internal User'
						
//						Thread.sleep(1000);
//						row0 = sheet.getRow(33);									//Selected 0th index row (First row)
//						c1 = row0.getCell(1);									//Selected cell (0 row,1 column)
//						String externalUser = c1.getStringCellValue();
						try
						{
							Thread.sleep(300);
							performerPOM.clickExternalUser().click();
							Thread.sleep(300);
							performerPOM.selectExternalUser1().click();
							
//							Thread.sleep(500);
//							action.moveToElement(performerPOM.clickSearchExternalUser()).sendKeys(externalUser, Keys.ENTER).perform();
						}
						catch(Exception e)
						{
							
						}
						
						Thread.sleep(8000);
						OverduePOM.clickSaveButton().click();				//Clicking on 'Save' button.
					
						Thread.sleep(8000);
						String msg1 = performerPOM.readTaskMsgcfo().getText();
						if(msg1.contains(msg1))
						{
							test.log(LogStatus.PASS, "Case -Task/Activitiy with existing data =" +msg1);
						}
						
						else 
						{
							test.log(LogStatus.FAIL, "Case -Task/Activitiy with existing data =" +msg1);
						}
						
						
			getDriver().switchTo().parentFrame();
				
			}
		

		
		public	static void CaseHearing( ExtentTest test) throws InterruptedException, EncryptedDocumentException, IOException
			{
				
			WebDriverWait wait=new WebDriverWait(getDriver(),20);
			 
		     Thread.sleep(8000);
	          performerPOM.clickCaseOpen().click();
	          
	      	Thread.sleep(8000);
			wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));		
	          Thread.sleep(8000);
	          performerPOM.clickEditNotice().click();
	          
	         // sheet = workbook.getSheetAt(6);	
		    
			 //getDriver().switchTo().parentFrame();
		    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
		    
		       Thread.sleep(8000);
			   performerPOM.clickCaseHearing().click();
				Thread.sleep(8000);
				performerPOM.clickNewCaseHearing().click();
				
				
				
			Thread.sleep(8000);
//				Row row0 = sheet.getRow(35);					//Selected 0th index row (First row)
//				Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
//				int HearingDate = (int) c1.getNumericCellValue();
//				performerPOM.clickCaseHearingDate().sendKeys(HearingDate+"");	//Writing 'HearingDate'
//				
				performerPOM.clickCaseHearingDate().sendKeys("13-06-2025");	//Writing 'HearingDate'
				
			
			    Thread.sleep(8000);
			    performerPOM.clickSaveCaseHearingDate().click();
			
				
			    FileInputStream fis = new FileInputStream(filePath);
		        Workbook workbook = WorkbookFactory.create(fis);
		        Sheet sheet = workbook.getSheetAt(6);
				Thread.sleep(8000);
				Row row1 = sheet.getRow(78);									//Selected 0th index row (First row)
				Cell c2 = row1.getCell(1);									//Selected cell (0 row,1 column)
				String HearingDescription = c2.getStringCellValue();
				performerPOM.clickCaseHearingDecsri().sendKeys(HearingDescription);		//Writing 'HearingDescription'
				
			   
				Thread.sleep(8000);
			    performerPOM.clickSaveCaseHearing().click();
			    
				Thread.sleep(8000);
				String msg = performerPOM.clickReadHearingMsg().getText();
				if(msg.contains(msg))
				{
					test.log(LogStatus.PASS, "Add Hearing ="+msg);
				}
				else
				{
					test.log(LogStatus.FAIL,  "Add Hearing ="+msg);
				}
				
			//*****************************Existing Hearing date**********************************************************************//
				
	 		
	 				Thread.sleep(8000);
	 				performerPOM.clickNewCaseHearing().click();
	 				  Thread.sleep(8000);
 	 				performerPOM.clickCaseHearingDate().sendKeys("13-05-2025");	//Writing 'HearingDate'
	 				
	 			
	 			    Thread.sleep(8000);
	 			    performerPOM.clickSaveCaseHearingDate().click();
	 			    
	 			
	 			    Thread.sleep(8000);
	 				String msg1 = performerPOM.clickReadHearingMsg1().getText();
	 				if(msg.contains(msg))
	 				{
	 					test.log(LogStatus.PASS, "Enter Existing Hearing Date ="+msg1 );
	 				}
	 				else
	 				{
	 					test.log(LogStatus.FAIL,"Enter Existing Hearing Date ="+msg1);
	 				}
				
				
				
				
				
			//****************************Update Hearing************************************************************************
	 				
	 			Thread.sleep(3000);
				performerPOM.clickminimize().click();
				
			    Thread.sleep(8000);
			    performerPOM.clickEditCaseHearingcfo().click();
			    
			    Thread.sleep(8000);
			    performerPOM.clickCaseHearingDecsri().clear();
			    Thread.sleep(8000);
			    performerPOM.clickCaseHearingDecsri().sendKeys("Case Hearing 18Jan 2024");		//Writing 'HearingDescription'
			    
			    Thread.sleep(8000);
			    performerPOM.clickSaveCaseHearing().click();
			    
			    Thread.sleep(8000);
				String msg2 = performerPOM.clickReadHearingMsg().getText();
				if(msg1.contains(msg1))
				{
					test.log(LogStatus.PASS, "Update Hearing ="+msg2);
				}
				else
				{
					test.log(LogStatus.FAIL, "Update Hearing ="+msg2);
				}
				
				   
			    Thread.sleep(8000);
			    performerPOM.clickDeleteCaseHearingcfo().click();
			    
				 Thread.sleep(8000);
				    // Switching to Alert        
			        Alert alert = getDriver().switchTo().alert();		
			        		
			        // Capturing alert message.    
			        String alertMessage= getDriver().switchTo().alert().getText();	
			        
			        
			        test.log(LogStatus.PASS, alertMessage);
			        		
			        // Displaying alert message		
			        System.out.println(alertMessage);
			        
			     // Accepting alert		
			        alert.accept();
			} 
				 
			public static void CaseOrder( ExtentTest test, String login) throws InterruptedException, EncryptedDocumentException, IOException
			{
				
				 WebDriverWait wait=new WebDriverWait(getDriver(),20);
				 
			     Thread.sleep(8000);
		          performerPOM.clickCaseOpen().click();
		          
		      	Thread.sleep(8000);
				wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));		
		          Thread.sleep(8000);
		          performerPOM.clickEditNotice().click();
		          
		          //sheet = workbook.getSheetAt(6);	
				 
				// getDriver().switchTo().parentFrame();
				  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
				 Thread.sleep(8000);
				 performerPOM.clickCaseOrder().click();
				 Thread.sleep(8000);
				 performerPOM.clickNewCaseOrder().click();
				 Thread.sleep(8000);
				 performerPOM. clickCaseOrderDate().sendKeys("13-10-2024");
				 Thread.sleep(8000);
				 performerPOM.clickOrderPanel().click();
				 Thread.sleep(8000);
				 performerPOM. clickCaseOrderType().click();
				 Thread.sleep(8000);
				 performerPOM.selectCaseOrderType().click();
				
				 
				 FileInputStream fis = new FileInputStream(filePath);
			        Workbook workbook = WorkbookFactory.create(fis);
			        Sheet sheet = workbook.getSheetAt(6);
					
					Thread.sleep(8000);
					Row row0 = sheet.getRow(82);					//Selected 0th index row (First row)
					Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
					int OrderTitle = (int) c1.getNumericCellValue();
					performerPOM.clickCaseOrderTitle().sendKeys(OrderTitle+"");	//Writing 'HearingDate'
					
//			     Thread.sleep(2000);
//				 Row row1 = sheet.getRow(40);									//Selected 0th index row (First row)
//				 Cell c2 = row1.getCell(1);									//Selected cell (0 row,1 column)
//				 String OrderTitle = c2.getStringCellValue();
//				 performerPOM.clickCaseOrderTitle().sendKeys(OrderTitle);   //click order title
//				 
				 Thread.sleep(8000);
				 Row row2 = sheet.getRow(83);									//Selected 0th index row (First row)
				 Cell c2 = row2.getCell(1);									//Selected cell (0 row,1 column)
				 String OrderDecri = c2.getStringCellValue();
				 performerPOM.clickCaseOrderDecri().sendKeys(OrderDecri);     //click oder description
				
				 Thread.sleep(8000);;
				 performerPOM.clickCaseorderFile();

				 Thread.sleep(8000);
				 performerPOM.clickSaveCaseOrder().click();
				 
				 
				 Thread.sleep(8000);
					String msg = performerPOM.clickReadOrderMsg().getText();
					if(msg.contains("Order Details Saved Successfully."))
					{
						test.log(LogStatus.PASS, "Message displayed :-"+msg);
					}
					else
					{
						test.log(LogStatus.FAIL, "Message displayed :-"+msg);
					}
					
					try
					{
					
					 Thread.sleep(8000);
					 performerPOM.clickDownloadCaseOrdercfo().click();
					 
					
				      test.log(LogStatus.PASS, "Case Document Download Successfully");
					}
					catch(Exception e)
					{
						String msg1 = performerPOM.clickReadOrderMsg().getText();
						if(msg.contains(msg1))
						{
							test.log(LogStatus.PASS, "Message displayed :-"+msg1);
						}
						else
						{
							test.log(LogStatus.FAIL, "Message displayed :-"+msg1);
						}
					}
				         
				        
			     	 Thread.sleep(8000);
					 performerPOM.clickViewCaseOrdercfo().click();
					 
					 Thread.sleep(8000);
				     performerPOM.clickNoticeDocumentViewClosepopupcfo().click();
				     
				     test.log(LogStatus.PASS,"Case View Document Popup Open Successfully");
				     
				     Thread.sleep(8000);
				     performerPOM.clickDeleteCaseOrdercfo().click();
				     
					 Thread.sleep(8000);
					    // Switching to Alert        
				        Alert alert = getDriver().switchTo().alert();		
				        		
				        // Capturing alert message.    
				        String alertMessage= getDriver().switchTo().alert().getText();	
				        
				        
				        test.log(LogStatus.PASS, alertMessage);
				        		
				        // Displaying alert message		
				        System.out.println(alertMessage);
				        
				     // Accepting alert		
				        alert.accept();
			}	 
				 
			public static void AdvocateBill(ExtentTest test) throws InterruptedException
			{
				 WebDriverWait wait=new WebDriverWait(getDriver(),20);
				 
//				 Thread.sleep(4000);
//		          performerPOM.clickCaseOpen().click();
//		          Thread.sleep(3000);
//		          performerPOM.clickEditNotice().click();
		          
		     	 getDriver().switchTo().parentFrame();
		          Thread.sleep(3000);
				    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
				    
				   
				   
			      Thread.sleep(3000);
				 performerPOM.clickAdvocateBill().click();
				 
				 Thread.sleep(3000);
				 performerPOM.clickExportAdvocateBill().click();
				 Thread.sleep(3000);
				 performerPOM. clickNewAdvocateBill().click();
				
				 Thread.sleep(5000);
			     performerPOM. clickInvoiceNum().sendKeys("5234234");
				 Thread.sleep(4000);
				 performerPOM. clickInvoiceDate().sendKeys("13-04-2023");
				 Thread.sleep(4000);
				 performerPOM.clickAdvocateBillPanel().click();
				 Thread.sleep(4000);
				 performerPOM. clickInvoiceAmount().sendKeys("30000");
				 Thread.sleep(4000);
				 performerPOM.clickLawFirm1().click();
				 performerPOM.selectLawFirm2().click();
				 Thread.sleep(4000);
				 performerPOM.clickApprover1().click();
			      Thread.sleep(4000);
			      performerPOM.selectApprover1().get(5).click();
				 Thread.sleep(4000);
				 performerPOM.clickApprover2().click();
			     Thread.sleep(4000);
				 performerPOM.selectApprover2().get(5).click();
				 
				 Thread.sleep(4000);
				 performerPOM.clickUploadDoc().click();
				
				 Thread.sleep(4000);
				 performerPOM.clickSaveAdvocateBill().click();
				 
				 Thread.sleep(500);
					String msg4 = performerPOM.clickReadAdvocateMsg().getText();		//Reading Message appeared after save button
					String msg6 = performerPOM.clickReadAdvocateMsg1().getText();		//Reading Message appeared after save button
					if(msg4.equalsIgnoreCase("Advocate Bill Added Successfully."))
					{
						test.log(LogStatus.PASS, "Message displayed = "+msg4);
					
					}
					
					else
					{
						test.log(LogStatus.FAIL, "Message displayed = "+msg6);
					}
					performerPOM.clickeditAdvocatebill().click();
					
					 Thread.sleep(5000);
				     performerPOM. clickInvoiceNum().clear();
					 Thread.sleep(5000);
				     performerPOM. clickInvoiceNum().sendKeys("4");
				     
				     Thread.sleep(4000);
					 performerPOM.clickSaveAdvocateBill().click();
				     
					 Thread.sleep(500);
						String msg5 = performerPOM.clickReadAdvocateMsg().getText();		//Reading Message appeared after save button
					
						if(msg5.equalsIgnoreCase("Advocate Bill Updated Successfully."))
						{
							test.log(LogStatus.PASS, "Message displayed = "+msg5);
						
						}
						else
						{
							test.log(LogStatus.FAIL, "Message displayed = "+msg5);
						}
						
						Thread.sleep(2000);
						performerPOM.clickDownloadDocAdvocatebill().click();
						
						 test.log(LogStatus.PASS, "Advocate Bill Document Download Successfully");
						 
						 Thread.sleep(2000);
						performerPOM.clickViewDocAdvocatebill().click();
				         
						 test.log(LogStatus.PASS, "Advocate Bill Document View Successfully");
						 
						 Thread.sleep(2000);
						performerPOM.clickViewDocAdvocatebillClose().click();
				 
						 Thread.sleep(2000);
						performerPOM.clickViewDocAdvocatebillPdf().click();
							
					    Thread.sleep(2000);
						performerPOM.clickViewDocAdvocatebillPdfClose().click();
						
						 test.log(LogStatus.PASS, "Advocate Bill Document Pdf Successfully");
						
						Thread.sleep(2000);
						performerPOM.clickAdvocateBillDelete().click();
						
						Thread.sleep(5000);
					    // Switching to Alert        
				        Alert alert = getDriver().switchTo().alert();		
				        		
				        // Capturing alert message.    
				        String alertMessage= getDriver().switchTo().alert().getText();	
				        
				        
				        test.log(LogStatus.PASS, alertMessage);
				        		
				        // Displaying alert message		
				        System.out.println(alertMessage);
				        
				     // Accepting alert		
				        alert.accept();
				 
						 test.log(LogStatus.PASS, "Advocate Bill Document Deleted Successfully");
				 
	      }

	      public static void StatusPayment( ExtentTest test) throws InterruptedException, EncryptedDocumentException, IOException
	      {	

	    	 // sheet = workbook.getSheetAt(6);
 	         WebDriverWait wait=new WebDriverWait(getDriver(),50);
 	         Thread.sleep(8000);
 	          performerPOM.clickCaseOpen().click();
 	          
 	      	Thread.sleep(8000);
				wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));		
 	          Thread.sleep(8000);
 	          performerPOM.clickEditNotice().click();
 	        	
 	       
	              Thread.sleep(8000);
			      wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
			     Thread.sleep(8000);
               performerPOM.clickCaseStatusPayments().click();		//Clicking on 'Status/Payments'
				
				  //wait.until(ExpectedConditions.visibilityOf(performerPOM.clickCaseStatus()));
               FileInputStream fis = new FileInputStream(filePath);
		        Workbook workbook = WorkbookFactory.create(fis);
		        Sheet sheet = workbook.getSheetAt(6);
				
				Thread.sleep(8000);
				Row row0 = sheet.getRow(95);					//Selected 0th index row (First row)
				Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
				int InvoiceNo = (int) c1.getNumericCellValue();
				performerPOM.clickCaseInvoiceNo1().sendKeys(InvoiceNo+"");	//Writing 'Invoice No'
				
			    
//				Thread.sleep(5000);
//				performerPOM.clickPaymentTyp1();
//				List<WebElement> PaymentType1= getDriver().findElements(By.xpath("//*[@id='grdCasePayment_ddlPaymentType_chosen']/div/ul/li"));
//				PaymentType1.get(2).click();
				
				Thread.sleep(8000);
				Row r5 = sheet.getRow(97);
				Cell c5 = r5.getCell(1);
				String PaymentType = c5.getStringCellValue();
				performerPOM.clickPaymentTyp1().click();
				performerPOM.selectPaymentTypeCase().sendKeys(PaymentType,Keys.ENTER);

				Thread.sleep(8000);
				performerPOM.clickAmount1().sendKeys("5000");
				
				Thread.sleep(8000);
				performerPOM.clickAmountPaid().sendKeys("2000");
			
	
				Thread.sleep(8000);
				performerPOM.clickSavePaymentLog1().click();
				
				Thread.sleep(8000);
				String msg4 = performerPOM.readPymentmsg().getText();		//Reading Message appeared after save button
			
				if(msg4.equalsIgnoreCase(msg4))
				{
					test.log(LogStatus.PASS, "Add Payment = "+msg4);
				
				}
				else
				{
					test.log(LogStatus.FAIL, "Add Payment= "+msg4);
				}
				
				try
				{
					
					
					Thread.sleep(8000);
					performerPOM.clickViewPaymentDoccfo().click();
					Thread.sleep(8000);
					String msg =performerPOM.readPymentmsg().getText();
					test.log(LogStatus.PASS,"Message displayed :-"+msg);
					
				}
				catch(Exception e)
				{
					Thread.sleep(8000);
					performerPOM.clickViewPaymentDoccfo().click();
				
					test.log(LogStatus.PASS, "Payment Document popup open successfully");
				}
				
				
				
				
				try
				{
					Thread.sleep(8000);
			        performerPOM.clickdownloadPaymentDoccfo().click();
					Thread.sleep(8000);
					String msg =performerPOM.readPymentmsg().getText();
					test.log(LogStatus.PASS,"Message displayed :-"+msg);
				
				}
				catch(Exception e)
				{
					Thread.sleep(8000);
			        performerPOM.clickdownloadPaymentDoccfo().click();
			        
			        test.log(LogStatus.PASS, "Payment Document Download Successfully.");
				}
			
				
				
			
				Thread.sleep(8000);
				performerPOM.clickEditPaymentDoccfo().click();
				
				Thread.sleep(8000);
				performerPOM.clickCaseInvoiceNo1().clear();
				 Thread.sleep(8000);
			    performerPOM.clickCaseInvoiceNo1().sendKeys("Invoice No 4352");
			    
			    Thread.sleep(8000);
				performerPOM.clickCaseStatusPaymentUploadtcfo();
			    

				Thread.sleep(8000);
				performerPOM.clickSavePaymentLog1().click();
				
				  Thread.sleep(8000);
					String msg = performerPOM.readPymentmsg().getText();		//Reading Message appeared after save button
				
					if(msg.equalsIgnoreCase(msg))
					{
						test.log(LogStatus.PASS, "Update Payment = "+msg);
					
					}
					else
					{
						test.log(LogStatus.FAIL, "Update Payment = "+msg);
					}
				
				
				
				
				Thread.sleep(8000);
				performerPOM.clickDeletePaymentDoccfo1().click();
				
				 Thread.sleep(8000);
				    // Switching to Alert        
			        Alert alert1 = getDriver().switchTo().alert();		
			        		
			        // Capturing alert message.    
			        String alertMessage1= getDriver().switchTo().alert().getText();	
			        
			        
			        test.log(LogStatus.PASS, alertMessage1);
			        		
			        // Displaying alert message		
			        System.out.println(alertMessage1);
			        
			     // Accepting alert		
			        alert1.accept();
			        
			        Thread.sleep(8000);
					String msg6 = performerPOM.readPymentmsg().getText();		//Reading Message appeared after save button
				
					if(msg6.equalsIgnoreCase(msg6))
					{
						test.log(LogStatus.PASS, "Message displayed = "+msg6);
					
					}
					else
					{
						test.log(LogStatus.FAIL, "Message displayed = "+msg6);
					}
					
					/*Thread.sleep(3000);
					performerPOM.clickViewPaymentDoccfo().click();
					
					Thread.sleep(3000);
					performerPOM.clickNoticeclosePaymentDocpopupcfo().click();
					
					test.log(LogStatus.PASS, "Payment Document popup open successfully");*/
					 Thread.sleep(8000);
					   getDriver().switchTo().parentFrame();
				     Thread.sleep(8000);
					 performerPOM.clickclosebutton().click();
					
					
				
	      }
	      

	      static void ExternalLawyer(ExtentTest test,int opp) throws InterruptedException
	      {
	    	  
	    	           WebDriverWait wait=new WebDriverWait(getDriver(),50);
	    	           getDriver().switchTo().parentFrame();
	    		          Thread.sleep(3000);
	    				    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
					  Thread.sleep(3000);
					   performerPOM. clickExternalLawyerRating1().click();
					   
//					   Thread.sleep(4000);
//					   performerPOM.selectCaseExternalLawyer();
					   
					   WebElement ExternalLawyer = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='ddlLayerType_chosen']")));
					   if(ExternalLawyer.isEnabled())
					   {
						   
					     Select ExternalLawyer1=new Select(ExternalLawyer);
					     ExternalLawyer1.selectByIndex(1);
					     List<WebElement> ExternalLawyer2= getDriver().findElements(By.xpath("//*[@id='ddlLayerType_chosen']/div/ul/li"));
					     int op = ExternalLawyer2.size();
//					      int size = op.size();
					     if(op>=1) 
					     {
					    	 ExternalLawyer2.get(opp).click();
					        
			
					    Thread.sleep(3000);
					    performerPOM.selectExternalLawyerRating();
					   Thread.sleep(3000);
					   performerPOM.clickNewCriteria().click();
					   Thread.sleep(3000);
					   wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IframeLayerRatingCriteria"));
					   performerPOM.clickCriteria().sendKeys("Test Test New");
					   Thread.sleep(3000);
					   performerPOM.clickSaveCriteria().click();
					   Thread.sleep(3000);
					   getDriver().switchTo().parentFrame();
					   performerPOM.clickclosecriteria().click();
					   Thread.sleep(3000);
					   performerPOM. clickstar().click();
				       Thread.sleep(3000);
					   performerPOM. clickstar1().click();
					   Thread.sleep(3000);
					   performerPOM. clickSaveRating().click();
					   
	               
				   	  Thread.sleep(1000);
					 wait.until(ExpectedConditions.visibilityOf(performerPOM.readRatingmsg()));
								
						Thread.sleep(500);
						String msg5 = performerPOM.readRatingmsg().getText();		//Reading Message appeared after save button
						
						if(msg5.equalsIgnoreCase("Rating Saved Successfully"))
							{
									test.log(LogStatus.PASS, "Message displayed = "+msg5);
									
							}
						else
							{
									test.log(LogStatus.FAIL, "Message displayed = "+msg5);
							}
					   }
					   }
					   else
					   {
						   test.log(LogStatus.PASS, "Case Closed");
					   }
					      
			  }	   
		   
	     public static void Auditlog(ExtentTest test) throws InterruptedException
	      {
	    	  WebDriverWait wait=new WebDriverWait(getDriver(),20);
				
			   Thread.sleep(8000);
				performerPOM.clickCaseOpencfo().click();//click edit notice
				
				Thread.sleep(8000);
				wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
		     
		        Thread.sleep(8000);
				performerPOM.clickEditNotice().click();//click edit notice
			  
			   wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
					   Thread.sleep(3000);
					   performerPOM. clickAuditLog().click();
					   Thread.sleep(3000);
					   performerPOM.clickExport().click();		   
					   Thread.sleep(3000);
					   getDriver().switchTo().parentFrame();
					   
					   test.log(LogStatus.PASS,"Export report download sucssesfully ");
					   performerPOM.clickclosebutton().click();
	      }	 
	      public static void CaseOpen( ExtentTest test, XSSFWorkbook workbook, String login) throws InterruptedException, IOException
	  	{
	  		
	  		
	  		int open = CountExcel(test, "Case - Open");
	  		
	  		
	  		Thread.sleep(500);
	  		performerPOM.clickExcelReport().sendKeys(Keys.PAGE_DOWN);
	  		JavascriptExecutor js = (JavascriptExecutor) getDriver();
	  		js.executeScript("window.scrollBy(0,700)");
	  		
	  		Thread.sleep(300);
	  		CFOcountPOM.readTotalItems1().click();
	  		String item = CFOcountPOM.readTotalItems1().getText();
	  		String[] bits = item.split(" ");								//Splitting the String
	  		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
	  		int gridRecords = 0;
	  		if(compliancesCount.equalsIgnoreCase("to"))
	  		{
	  			Thread.sleep(2000);
	  			item = CFOcountPOM.readTotalItems1().getText();
	  			bits = item.split(" ");								//Splitting the String
	  			compliancesCount = bits[bits.length - 2];
	  		}
	  		if(compliancesCount.equalsIgnoreCase("to"))
	  		{
	  			gridRecords = 0;
	  		}
	  		else
	  		{
	  			gridRecords = Integer.parseInt(compliancesCount);
	  		}
	  		
	  		//sheet = workbook.getSheetAt(6);
	  		getDriver().navigate().refresh();
	  		perform1(test, open, gridRecords, "Case - Open");
	  	}
	      public static void CloseNoticeCase( ExtentTest test,String type,String Login) throws InterruptedException, IOException
	  	{
	  		WebDriverWait wait = new WebDriverWait(getDriver(), 180);
	  		progress();
	  		//sheet = workbook.getSheetAt(6);
	  		wait.until(ExpectedConditions.visibilityOf(performerPOM.clickNoticeOpen()));
	  		int closed = 0;
	  		int open = 0;
	  		int caseOpen = 0;
	  		if(type.equals("Notice"))
	  		{
	  			closed = Integer.parseInt(performerPOM.clickNoticeClosed().getText());	//Reading Notice Closed count.
	  			open = Integer.parseInt(performerPOM.clickNoticeOpen().getText());		//Reading Notice Open count.
	  			caseOpen = Integer.parseInt(performerPOM.clickCaseOpen().getText());
	  			
	  			performerPOM.clickNoticeOpen().click();									//Clicking on 'Open' notice
	  		}
	  		else if(type.equals("Case"))
	  		{
	  			open = Integer.parseInt(performerPOM.clickCaseOpen().getText());			//Reading Case Open count.
	  			closed = Integer.parseInt(performerPOM.clickCaseClosed().getText());		//Reading Case Closed count.
	  			
	  			performerPOM.clickCaseOpen().click();										//Clicking on 'Open' case
	  		}
	  		else if(type.equals("Task"))
	  		{
	  			open = Integer.parseInt(performerPOM.clickTaskOpen().getText());			//Reading Task Open count.
	  			closed = Integer.parseInt(performerPOM.clickTaskClosed().getText());		//Reading Task Closed count.
	  			
	  			performerPOM.clickTaskOpen().click();										//Clicking on 'Open' task
	  		}
	  		
	  		Thread.sleep(300);
	  		wait.until(ExpectedConditions.visibilityOf(performerPOM.clickExcelReport()));	//Waiting until visibility of Excel Report button.
	  		
	  		Thread.sleep(1000);
	  		JavascriptExecutor js = (JavascriptExecutor) getDriver();
	  		js.executeScript("window.scrollBy(0,500)");
	  		
	  		Thread.sleep(3000);
	  		performerPOM.GridLoad().click();
	  		elementsList = performerPOM.clickAction();			//Getting all action buttons.
	  		//js.executeScript("arguments[0].scrollIntoView();", elementsList.get(0));
	  		
	  		Thread.sleep(500);
	  		elementsList = performerPOM.clickAction();			//Getting all action buttons.
	  		elementsList.get(0).click();								//Clicking on first action button.
	  		
	  		Thread.sleep(500);
	  		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Waiting and switching to IFrame
	  		
	  		Thread.sleep(300);
	  		if(type.equals("Notice"))
	  		{
	  			
	  			Thread.sleep(3000);
	  			performerPOM.clickStatusPayments().click();			//Clicking on 'Status/Payments'
	  			
	  			Thread.sleep(3000);
				performerPOM.clicknoticeStage().click();
				Thread.sleep(3000);
				performerPOM.selectNoticetage1().click();
	  			Thread.sleep(3000);
	  			wait.until(ExpectedConditions.visibilityOf(performerPOM.clickNoticeStatus()));
	  			Thread.sleep(3000);
	  			performerPOM.clickNoticeStatus().click();				//Clicking on 'Notice Status' drop down.
	  			Thread.sleep(3000);
	  			performerPOM.clickClosedStatus().click();				//Selecting 'Closed' option from drop down.
	  			
	  			Thread.sleep(3000);
	  			wait.until(ExpectedConditions.visibilityOf(performerPOM.clickCloseDate()));
	  			
	  			performerPOM.clickCloseDate().click();				//Clicking on 'Closed Date' date box
	  			
	  			OverduePOM.selectLastMonth().click();					//Getting last month
	  			
	  			OverduePOM.selectDate2().click();						//Selecting particular date.
	  			
	  			Thread.sleep(300);
	  			performerPOM.clickNoticeResult().click();
	  			performerPOM.clickSelectResult().sendKeys("In Progress", Keys.ENTER);
	  			
	  			 FileInputStream fis = new FileInputStream(filePath);
			        Workbook workbook = WorkbookFactory.create(fis);
			        Sheet sheet = workbook.getSheetAt(6);
	  			Thread.sleep(3000);
	  			Row r1 = sheet.getRow(43);
	  			Cell c1 = r1.getCell(1);
	  			String remark = c1.getStringCellValue();
	  			performerPOM.clickRemark1().sendKeys(remark);
	  			
	  			Thread.sleep(3000);
	  			r1 = sheet.getRow(44);
	  			c1 = r1.getCell(1);
	  			String CaseNo = c1.getStringCellValue();
	  			performerPOM.clickCourtCaseNo().sendKeys(CaseNo);
	  			
	  			Thread.sleep(3000);
	  			performerPOM.clickSaveConvertCase().click();	
	  			
//	  			Thread.sleep(300);
//	  		Row r1 = sheet.getRow(25);
//	  			Cell c1 = r1.getCell(1);
//	  			String remark = c1.getStringCellValue();
//	  			performerPOM.clickRemark1().sendKeys(remark);
//	  			
//	  			Thread.sleep(300);
//	  			r1 = sheet.getRow(26);
//	  			c1 = r1.getCell(1);
//	  			String CaseNo = c1.getStringCellValue();
//	  			performerPOM.clickCourtCaseNo().sendKeys(CaseNo);
//	  			
//	  			Thread.sleep(300);
//	  			performerPOM.clickSaveConvertCase().click();
	  		}
	  		else if(type.equals("Case"))
	  		{
	  			Thread.sleep(3000);
	  			performerPOM.clickCaseStatusPayments().click();		//Clicking on 'Status/Payments'
	  			Thread.sleep(3000);
	  			wait.until(ExpectedConditions.visibilityOf(performerPOM.clickCaseStatus()));
	  			Thread.sleep(3000);
	  			performerPOM.clickCaseStage().click();
	  			Thread.sleep(3000);
	  			performerPOM.selectCaseStage1().sendKeys("Hearing", Keys.ENTER);
	  			
	  			Thread.sleep(3000);
	  			performerPOM.clickCaseStatus().click();				//Clicking on 'Case Status' drop down.
	  			Thread.sleep(3000);
	  			performerPOM.clickCaseStatusClose().click();			//Selecting 'Closed' option from drop down.
	  			
	  			Thread.sleep(3000);
	  			wait.until(ExpectedConditions.visibilityOf(performerPOM.clickCaseCloseDate()));
	  			performerPOM.clickCaseCloseDate().click();				//Clicking on 'Closed Date' date box
	  			OverduePOM.selectLastMonth().click();					//Getting last month
	  			OverduePOM.selectDate2().click();						//Selecting particular date.
	  			
	  			Thread.sleep(3000);
	  			performerPOM.clickCaseResult().click();
	  			performerPOM.clickSelectCaseResult().sendKeys("In Progress", Keys.ENTER);
	  			
	  			Thread.sleep(3000);
	  			performerPOM.clickRemark1().sendKeys("Automation Testing");
	  			
	  			Thread.sleep(3000);
	  			performerPOM.clickSave1().click();
	  		}
	  		else if(type.equals("Task"))
	  		{
	  			
	  		}
	  		
	  		Thread.sleep(3000);
	  		wait.until(ExpectedConditions.visibilityOf(performerPOM.readMessage2()));
	  		String msg = performerPOM.readMessage2().getText();
	  		
	  		if(msg.contains("Successfully"))
	  		{
	  			test.log(LogStatus.PASS, "Message displayed - "+msg);
	  		}
//	  		else if(msg.contains("already exist"))
//	  		{
//	  			test.log(LogStatus.SKIP, "Message displayed - "+msg);
//	  		}
	  		else
	  		{
	  			test.log(LogStatus.FAIL, "Message displayed - "+msg);
	  		}
	  		
	  		Thread.sleep(3000);
	  		getDriver().switchTo().parentFrame();
	  		
	  		Thread.sleep(3000);
	  		performerPOM.clickClose().click();
	  		
	  		Thread.sleep(5000);
	  		OverduePOM.clickDashboard().click();
	  		
	  		wait.until(ExpectedConditions.visibilityOf(performerPOM.clickNoticeOpen()));
	  		int closed1 = 0;
	  		int open1 = 0;
	  		int caseOpen1 = 0;
	  		if(type.equals("Notice"))
	  		{
	  			closed1 = Integer.parseInt(performerPOM.clickNoticeClosed().getText());	//Reading Notice Open count.
	  			open1 = Integer.parseInt(performerPOM.clickNoticeOpen().getText());		//Reading Notice Open count.
	  			caseOpen1 = Integer.parseInt(performerPOM.clickCaseOpen().getText());
	  			
	  			if(open > open1 && closed1 > closed && caseOpen1 > caseOpen)
	  			{
	  			//test.log(LogStatus.PASS, "Notice-Closed count increased.");
					test.log(LogStatus.PASS, "Notice-Closed count increased :- Old Count = "+closed+" | New Count = "+closed1);
					//test.log(LogStatus.PASS, "Notice-Open count decreased.");
					test.log(LogStatus.PASS, "Notice-Open count decreased :- Old Count = "+open+" | New Count = "+open1);
					//test.log(LogStatus.PASS, "Case-Open count increased.");
					test.log(LogStatus.PASS, "Case-Open count increased :- Old Count = "+caseOpen+" | New Count = "+caseOpen1);
				}
				else
				{
					//test.log(LogStatus.FAIL, "Notice-Closed count doesn't increased.");
					test.log(LogStatus.FAIL, "Notice-Closed count doesn't increased:-Old Count = "+closed+" | New Count = "+closed1);
					//test.log(LogStatus.FAIL, "Notice-Open count doesn't decreased.");
					test.log(LogStatus.FAIL, "Notice-Open count doesn't decreased.:-Old Count = "+open+" | New Count = "+open1);
					//test.log(LogStatus.FAIL, "Case-Open count doesn't increased.");
					test.log(LogStatus.FAIL, "Case-Open count doesn't increased:-Old Count = "+caseOpen+" | New Count = "+caseOpen1);
				}
	  		}
	  		else if(type.equals("Case"))
	  		{
	  			open1 = Integer.parseInt(performerPOM.clickCaseOpen().getText());			//Reading Case Open count.
	  			closed1 = Integer.parseInt(performerPOM.clickCaseClosed().getText());		//Reading Case Closed count.
	  			
	  			if(open > open1 && closed1 > closed)
	  			{
	  				//test.log(LogStatus.PASS, "Case-Closed count increased.");
	  				test.log(LogStatus.PASS, "Case-Closed count increased.:-Old Count = "+closed+" | New Count = "+closed1);
	  				//test.log(LogStatus.PASS, "Case-Open count decreased.");
	  				test.log(LogStatus.PASS, "Case-Open count decreased.:-Old Count = "+open+" | New Count = "+open1);
	  			}
	  			else
	  			{
	  				//test.log(LogStatus.FAIL, "Case-Closed count doesn't increased.");
	  				test.log(LogStatus.FAIL, "Case-Closed count doesn't increased.:-Old Count = "+closed+" | New Count = "+closed1);
	  				//test.log(LogStatus.FAIL, "Case-Open count doesn't decreased.");
	  				test.log(LogStatus.FAIL, "Case-Open count doesn't decreased.:-Old Count = "+open+" | New Count = "+open1);
	  			}
	  		}
	  		else if(type.equals("Task"))
	  		{
	  			open1 = Integer.parseInt(performerPOM.clickTaskOpen().getText());			//Reading Task Open count.
	  			closed1 = Integer.parseInt(performerPOM.clickTaskClosed().getText());		//Reading Task Closed count.
	  			
	  			if(open > open1 && closed1 > closed)
	  			{
	  				//test.log(LogStatus.PASS, "Task-Closed count increased.");
	  				test.log(LogStatus.PASS, "Task-Closed count increased = Old Count = "+closed+" | New Count = "+closed1);
	  				//test.log(LogStatus.PASS, "Task-Open count decreased.");
	  				test.log(LogStatus.PASS, "Task-Open count decreased = Old Count = "+open+" | New Count = "+open1);
	  			}
	  			else
	  			{
	  				//test.log(LogStatus.FAIL, "Task-Closed count doesn't increased.");
	  				test.log(LogStatus.FAIL, "Task-Closed count doesn't increased = Old Count = "+closed+" | New Count = "+closed1);
	  				//test.log(LogStatus.FAIL, "Task-Open count doesn't decreased.");
	  				test.log(LogStatus.FAIL, "Task-Open count doesn't decreased = Old Count = "+open+" | New Count = "+open1);
	  			}
	  		}
	  	}
	      public static void LinkDocument( ExtentTest test, XSSFWorkbook workbook, String type) throws InterruptedException, IOException
	  	{
	  		WebDriverWait wait = new WebDriverWait(getDriver(), 180);
	  		progress();
	  		
	  		wait.until(ExpectedConditions.visibilityOf(performerPOM.clickNoticeOpen()));
	  		if(type.equals("Notice"))
	  		{
	  			performerPOM.clickNoticeOpen().click();							//Clicking on 'Open' notice
	  		}
	  		else if(type.equals("Case"))
	  		{
	  			performerPOM.clickCaseOpen().click();								//Clicking on 'Open' case
	  		}
	  		
	  		progress();
	  		wait.until(ExpectedConditions.visibilityOf(performerPOM.clickExcelReport()));
	  		
	  		Thread.sleep(400);
	  		JavascriptExecutor js = (JavascriptExecutor) getDriver();
	  		js.executeScript("window.scrollBy(0,500)");
	  		
	  		Thread.sleep(1500);
	  		wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
	  		//performerPOM.GridLoad().click();
	  		elementsList = performerPOM.clickAction();			//Getting all action buttons.
	  		//js.executeScript("arguments[0].scrollIntoView();", elementsList.get(0));
	  		
	  		Thread.sleep(600);
	  		elementsList = performerPOM.clickAction();			//Getting all action buttons.
	  		elementsList.get(0).click();								//Clicking on first action button.
	  		
	  		String refNo = null;
	  		Thread.sleep(3000);
	  		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Waiting and switching to IFrame		
	  		if(type.equals("Notice"))
	  		{
	  			performerPOM.clickLinkNotice().click();			//Clicking on Link Notice icon
	  			
	  			Thread.sleep(300);
	  			progress();
	  			
	  			Thread.sleep(300);
	  			wait.until(ExpectedConditions.elementToBeClickable(performerPOM.clickCheckBox()));	//Waiting for Checkbox to get visible.
	  			refNo = performerPOM.readRef().getText();			//Reading ref no.
	  			
	  			Thread.sleep(3000);
	  			performerPOM.clickCheckBox().click();			//CLicking on first checkbox
	  		}
	  		else if(type.equals("Case"))
	  		{
	  			performerPOM.clickLinkCase().click();			//Clicking on Link Notice icon
	  			
	  			Thread.sleep(300);
	  			progress();
	  			
	  			Thread.sleep(300);
	  			wait.until(ExpectedConditions.elementToBeClickable(performerPOM.clickCaseCheckBox()));	//Waiting for Checkbox to get visible.
	  			refNo = performerPOM.readCaseRef().getText();			//Reading ref no.
	  			
	  			Thread.sleep(300);
	  			performerPOM.clickCaseCheckBox().click();		//CLicking on first checkbox
	  		}
	  		
	  		Thread.sleep(300);
	  		if(type.equals("Case"))
	  		{
	  			performerPOM.clickApply().sendKeys(Keys.PAGE_DOWN);
	  		}
	  		else
	  		{
	  			performerPOM.clickApply1().sendKeys(Keys.PAGE_DOWN);
	  		}
	  		
	  		Thread.sleep(300);
	  		performerPOM.clickSave().click();				//Clicking on Save button.
	  		
	  		Thread.sleep(300);
	  		progress();
	  		
	  		Thread.sleep(500);
	  		try
	  		{
	  			wait.until(ExpectedConditions.elementToBeClickable(performerPOM.readMsg()));
	  		}
	  		catch(Exception e)
	  		{
	  			wait.until(ExpectedConditions.elementToBeClickable(performerPOM.readMsg()));
	  		}
	  		Thread.sleep(300);
	  		String msg = performerPOM.readMsg().getText();
	  		if(msg.contains("Linked Successfully"))
	  		{
	  			test.log(LogStatus.PASS, "Message displayed = "+msg);
	  		}
	  		else
	  		{
	  			test.log(LogStatus.FAIL, "Message displayed = "+msg);
	  		}
	  		
	  		
	  		if(type.equals("Notice"))
	  		{
	  			performerPOM.clickClosePopup().click();
	  			
	  			Thread.sleep(300);
	  			performerPOM.clickLinkNotice().sendKeys(Keys.PAGE_DOWN);
	  			performerPOM.clickLinkNotice().sendKeys(Keys.PAGE_DOWN);
	  			performerPOM.clickLinkNotice().sendKeys(Keys.PAGE_DOWN);
	  			
	  			
	  			

	  		}
	  		else if(type.equals("Case"))
	  		{
	  			performerPOM.clickClosePopupCase().click();
	  			
	  			Thread.sleep(300);
	  			performerPOM.clickLinkCase().sendKeys(Keys.PAGE_DOWN);
	  			performerPOM.clickLinkCase().sendKeys(Keys.PAGE_DOWN);
	  			performerPOM.clickLinkCase().sendKeys(Keys.PAGE_DOWN);


	  		}

	  			
	  			

	  		if(type.equals("Notice"))
	  		{
	  			performerPOM.clickLinkNotice().sendKeys(Keys.PAGE_UP);
	  			performerPOM.clickLinkNotice().sendKeys(Keys.PAGE_UP);
	  			performerPOM.clickLinkNotice().sendKeys(Keys.PAGE_UP);
	  		}
	  		else if(type.equals("Case"))
	  		{
	  			performerPOM.clickLinkCase().sendKeys(Keys.PAGE_UP);
	  			performerPOM.clickLinkCase().sendKeys(Keys.PAGE_UP);
	  			performerPOM.clickLinkCase().sendKeys(Keys.PAGE_UP);
	  		}
	  		
	  		
	  		
	  	/*	int flag = 0;
	  		int n = 0;
	  		if(type.equals("Notice"))
	  		{
	  			performerPOM.clickClosePopup().click();
	  			
	  			Thread.sleep(300);
	  			performerPOM.clickLinkNotice().sendKeys(Keys.PAGE_DOWN);
	  			performerPOM.clickLinkNotice().sendKeys(Keys.PAGE_DOWN);
	  			performerPOM.clickLinkNotice().sendKeys(Keys.PAGE_DOWN);
	  			
	  			Thread.sleep(300);
	  			elementsList = performerPOM.readRef1();
	  			n = elementsList.size();
	  			
	  			if(n > 0)
	  			{
	  				for(int i = 0; i < n; i++)
	  				{
	  					String ref = elementsList.get(i).getText();
	  					if(refNo.equalsIgnoreCase(ref))
	  					{
	  						flag = 1;
	  						break;
	  					}
	  				}
	  			}
	  		}
	  		else if(type.equals("Case"))
	  		{
	  			performerPOM.clickClosePopupCase().click();
	  			
	  			Thread.sleep(300);
	  			performerPOM.clickLinkCase().sendKeys(Keys.PAGE_DOWN);
	  			performerPOM.clickLinkCase().sendKeys(Keys.PAGE_DOWN);
	  			performerPOM.clickLinkCase().sendKeys(Keys.PAGE_DOWN);
	  			
	  			Thread.sleep(300);
	  			elementsList = performerPOM.readCaseRef1();
	  			n = elementsList.size();
	  			
	  			if(n > 0)
	  			{
	  				for(int i = 0; i < n; i++)
	  				{
	  					String ref = elementsList.get(i).getText();
	  					if(refNo.equalsIgnoreCase(ref))
	  					{
	  						flag = 1;
	  						break;
	  					}
	  				}
	  			}
	  		}
	  		
	  		
	  		
	  		
	  		if(flag == 1)
	  		{
	  			test.log(LogStatus.PASS, "Linked "+type+" displayed in "+type+" Summary. Reference No = "+refNo);
	  		}
	  		else
	  		{
	  			test.log(LogStatus.FAIL, "Linked "+type+" doesn't displayed in "+type+" Summary. Reference No = "+refNo);
	  		}
	  		
	  		if(type.equals("Notice"))
	  		{
	  			performerPOM.clickLinkNotice().sendKeys(Keys.PAGE_UP);
	  			performerPOM.clickLinkNotice().sendKeys(Keys.PAGE_UP);
	  			performerPOM.clickLinkNotice().sendKeys(Keys.PAGE_UP);
	  		}
	  		else if(type.equals("Case"))
	  		{
	  			performerPOM.clickLinkCase().sendKeys(Keys.PAGE_UP);
	  			performerPOM.clickLinkCase().sendKeys(Keys.PAGE_UP);
	  			performerPOM.clickLinkCase().sendKeys(Keys.PAGE_UP);
	  		}*/
	  		
	  		Thread.sleep(300);
	  		getDriver().switchTo().parentFrame();
	  		performerPOM.clickClose().click();
	  		
	  		Thread.sleep(1000);
	  		OverduePOM.clickDashboard().click();
	  	}
	  	public static void TaskOpen( ExtentTest test,  String login) throws InterruptedException, IOException
		{
		
		//  performerPOM.clickTaskOpen().click();
			int open = CountExcel(test, "Task - Open");
			
			Thread.sleep(500);
			performerPOM.clickExcelReport().sendKeys(Keys.PAGE_DOWN);
			JavascriptExecutor js = (JavascriptExecutor) getDriver();
			js.executeScript("window.scrollBy(0,700)");
			
			Thread.sleep(300);
			CFOcountPOM.readTotalItems1().click();
			String item = CFOcountPOM.readTotalItems1().getText();
			String[] bits = item.split(" ");								//Splitting the String
			String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
			int gridRecords = 0;
			if(compliancesCount.equalsIgnoreCase("to"))
			{
				Thread.sleep(2000);
				item = CFOcountPOM.readTotalItems1().getText();
				bits = item.split(" ");								//Splitting the String
				compliancesCount = bits[bits.length - 2];
			}
			if(compliancesCount.equalsIgnoreCase("to"))
			{
				gridRecords = 0;
			}
			else
			{
				gridRecords = Integer.parseInt(compliancesCount);
			}
			
			//sheet = workbook.getSheetAt(6);
			
			TaskAdd(test, open, gridRecords, "Task - Open");
		}
	  	static void TaskAdd( ExtentTest test,  int open, int gridRecords, String type) throws InterruptedException, EncryptedDocumentException, IOException
		{
			WebDriverWait wait = new WebDriverWait(getDriver(), 60);
			
			Thread.sleep(500);
			JavascriptExecutor js = (JavascriptExecutor) getDriver();
			CFOcountPOM.clickNextPage1().sendKeys(Keys.UP);
			js.executeScript("window.scrollBy(0,-700)");
			performerPOM.clickAddNewTask().click();				//Clicking on 'New' button
			
			progress();
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IframeAddTask"));
			
//			
//			Thread.sleep(300);
//			performerPOM.clickDueDate().click();				//Clicking on 'Due Date' text box
//			OverduePOM.selectNextMonth().click();
//			OverduePOM.selectDate().click();					//Selecting particular date.
//			
			 FileInputStream fis = new FileInputStream(filePath);
		        Workbook workbook = WorkbookFactory.create(fis);
		        Sheet sheet = workbook.getSheetAt(6);	 
			Thread.sleep(3000);
			Row row0 = sheet.getRow(29);								//Selected 0th index row (First row)
			Cell c1 = row0.getCell(1);								//Selected cell (0 row,1 column)
			String title = c1.getStringCellValue();
			performerPOM.clickTaskTitle().sendKeys(title);	//Writing 'Task Title'
			
			Thread.sleep(3000);
			row0 = sheet.getRow(30);									//Selected 0th index row (First row)
			c1 = row0.getCell(1);									//Selected cell (0 row,1 column)
			String desc = c1.getStringCellValue();
			performerPOM.clickTaskDesc().sendKeys(desc);		//Writing 'Task Description'
			
			Thread.sleep(3000);
			performerPOM.clickDueDate().click();				//Clicking on 'Due Date' text box
			OverduePOM.selectNextMonth().click();
			OverduePOM.selectDate().click();					//Selecting particular date.
			
			Thread.sleep(3000);
			Actions action = new Actions(getDriver());
			action.moveToElement(performerPOM.clickPriority()).click().sendKeys(Keys.DOWN,Keys.ENTER).perform();
			
			Thread.sleep(3000);
			row0 = sheet.getRow(31);									//Selected 0th index row (First row)
			c1 = row0.getCell(1);									//Selected cell (0 row,1 column)
			String outcome = c1.getStringCellValue();
			performerPOM.clickExpOutcome().sendKeys(outcome);	//Writing 'Expected Outcome'
			
			Thread.sleep(3000);
			row0 = sheet.getRow(32);									//Selected 0th index row (First row)
			c1 = row0.getCell(1);									//Selected cell (0 row,1 column)
			String internalUser = c1.getStringCellValue();
			performerPOM.clickInternalUser1().click();
			performerPOM.clickSearchInternalUser1().sendKeys(internalUser, Keys.ENTER);	//Selecting 'Internal User'
			
			Thread.sleep(1000);
			row0 = sheet.getRow(33);									//Selected 0th index row (First row)
			c1 = row0.getCell(1);									//Selected cell (0 row,1 column)
			String externalUser = c1.getStringCellValue();
			try
			{
				Thread.sleep(300);
				performerPOM.clickExternalUser().click();
				Thread.sleep(500);
				action.moveToElement(performerPOM.clickSearchExternalUser()).sendKeys(externalUser, Keys.ENTER).perform();
			}
			catch(Exception e)
			{
				
			}
			
			Thread.sleep(2000);
			row0 = sheet.getRow(34);									//Selected 0th index row (First row)
			c1 = row0.getCell(1);									//Selected cell (0 row,1 column)
			String remark = c1.getStringCellValue();
			performerPOM.clickRemark().sendKeys(remark);		//Writing 'Remark'
			
			//Thread.sleep(300);
			//String workingDir = System.getProperty("user.dir");
			//performerPOM.clickUpload().sendKeys(workingDir+"//Reports//PerformerResults.html");	//Uploading file
			
			Thread.sleep(300);
			OverduePOM.clickSaveButton().click();				//Clicking on 'Save' button.
			
			
			try 
			{
				Thread.sleep(8000);
				wait.until(ExpectedConditions.visibilityOf(performerPOM.clickMessage()));
				Thread.sleep(8000);
				String msg = performerPOM.clickMessage().getText();
				test.log(LogStatus.PASS, "Message displayed:-"+msg);
			}
			catch(Exception e)
			{
				Thread.sleep(8000);
				wait.until(ExpectedConditions.visibilityOf(performerPOM.clickTaskInvalidMessage()));
				Thread.sleep(8000);
			
				String msg = performerPOM.clickTaskInvalidMessage().getText();
			     test.log(LogStatus.FAIL, "Message displayed :-"+msg);
			}
			
			getDriver().switchTo().parentFrame();
			performerPOM.clickClose1().click();			//Clicking on 'Close'
			
			Thread.sleep(500);
			wait.until(ExpectedConditions.visibilityOf(performerPOM.clickExcelReport()));
			
			Thread.sleep(300);
			performerPOM.clickStatusDropDown().click();		//Clicking on 'Status drop down.
			Thread.sleep(500);
			//performerPOM.selectStatusDropDown().click();		//Selecting 'Pending/Open' status
			
			Thread.sleep(500);
			performerPOM.clickExcelReport().sendKeys(Keys.PAGE_DOWN);
			js.executeScript("window.scrollBy(0,700)");
			
			Thread.sleep(1000);
			CFOcountPOM.readTotalItems1().click();
			String item = CFOcountPOM.readTotalItems1().getText();
			String[] bits = item.split(" ");								//Splitting the String
			String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
			int count1 = 0;
			if(compliancesCount.equalsIgnoreCase("to"))
			{
				Thread.sleep(2000);
				item = CFOcountPOM.readTotalItems1().getText();
				bits = item.split(" ");								//Splitting the String
				compliancesCount = bits[bits.length - 2];
			}
			count1 = Integer.parseInt(compliancesCount);
			
			if(count1 > gridRecords)
			{
				//test.log(LogStatus.PASS, "Total Task Count increased in grid after adding New Task.");
				test.log(LogStatus.PASS, "Total Task Count increased in grid after adding New Task = Old Task Count from Grid = "+gridRecords+" | New Task Count from Grid = "+count1);
			}
			else
			{
				//test.log(LogStatus.FAIL, "Total Task Count doesn't increased in grid after adding New Task.");
				test.log(LogStatus.FAIL, "Total Task Count doesn't increased in grid after adding New Task = Old Task Count from Grid = "+gridRecords+" | New Task Count from Grid = "+count1);
			}
			
			Thread.sleep(500);
			OverduePOM.clickDashboard().click();			//Clicking on 'Dashboard'
			
			Thread.sleep(500);
			wait.until(ExpectedConditions.visibilityOf(performerPOM.clickTaskOpen()));
			int open1 = Integer.parseInt(performerPOM.clickTaskOpen().getText());	//Reading Notice Open count.
			
			if(open1 > open)
			{
				//test.log(LogStatus.PASS, type+" Dashboard Count Increased.");
				test.log(LogStatus.PASS, "Dashboard Count Increased = Old Count = "+open+" | New Count = "+open1);
			}
			else
			{
				//test.log(LogStatus.FAIL, type+" Dashboard Count doesn't increased.");
				test.log(LogStatus.FAIL, "Dashboard Count doesn't increased = Old Count = "+open+" | New Count = "+open1);
			}
			
		}
		public static void TaskClosed( ExtentTest test, XSSFWorkbook workbook, String login) throws InterruptedException, IOException
		{
			WebDriverWait wait = new WebDriverWait(getDriver(), 50);
			
			CountExcel( test, "Task - Closed");
			
			Thread.sleep(500);
			wait.until(ExpectedConditions.visibilityOf(performerPOM.clickAddNewTask()));
			OverduePOM.clickDashboard().click();			//Clicking on 'Dashboard'
		}
		 public static void NoticeDocViewandDownload( ExtentTest test) throws InterruptedException, IOException
         {    
	  
	          WebDriverWait wait=new WebDriverWait(getDriver(),20);
	          Thread.sleep(3000);
	          performerPOM.clickNoticeOpen().click();
	   
	          Thread.sleep(1000);
	           wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
	  
	           Thread.sleep(3000);
	            performerPOM.clickEditNotice().click();
	  
	
	           wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
	
	  
	          Thread.sleep(3000);
	           performerPOM.clickEditNotice1().click();
	  
	            JavascriptExecutor js = (JavascriptExecutor) getDriver();
	             js.executeScript("window.scrollBy(0,1000)");
	  
	               Thread.sleep(3000);
	           performerPOM.clickViewNoticeDoc().click();
	  
	         
             getDriver().switchTo().frame("IframeNoticeDocument");
	  
	   
//	          Thread.sleep(5000);
//	          performerPOM.clickViewNoticeDocpopup().click();
//	  
//	 
//	           //getDriver().switchTo().parentFrame();
//	  
//	         Thread.sleep(3000);
//	          performerPOM.clickViewNoticeDocpopupclose1().click();
	  
	  
	            Thread.sleep(3000);
	           performerPOM.clickDownloadNoticeDocpopup().click();
	  
	           getDriver().switchTo().parentFrame();
	  
	         Thread.sleep(3000);
	          performerPOM.clickViewNoticeDocpopupclose().click();
	  
	           test.log(LogStatus.PASS,"View Notice Document Popup open successfully");
	  
	          Thread.sleep(3000);
	         performerPOM.clickDownloadNoticeDoc().click();
	   
	         test.log(LogStatus.PASS,"Notice Document Download successfully");
	  
	              	Thread.sleep(3000);
		         getDriver().switchTo().parentFrame();
		        performerPOM.clickClose().click();//Clicking on 'Close'
		
		       Thread.sleep(500);
		            OverduePOM.clickDashboard().click();
	  
	  }
			public static void MyDocument( ExtentTest test, XSSFWorkbook workbook) throws InterruptedException, IOException
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 60);
				progress();
				
				//wait.until(ExpectedConditions.visibilityOf(performerPOM.clickNoticeOpen()));	//Wait until 'Notice-Open' count get visible
							
				performerPOM.clickMyDocument().click();					//Clicking on 'My Document'
				performerPOM.clickmyDocument().click();	                    //Clicking on 'My Document'
				
				
				/*Thread.sleep(3000);
				performerPOM.clickDocTypeFilter().click();
				
				Thread.sleep(3000);
				performerPOM.clickDocTypeFilter1().click();

				Thread.sleep(5000);
				if(performerPOM.clearButton().isEnabled())
				{
					performerPOM.clearButton().click();
					 test.log(LogStatus.PASS, "My Document = clear button Work Successfully");
				}
				else
				{
					test.log(LogStatus.PASS, "My Document = clear button not Work Successfully");
				}*/
				   
				
				Thread.sleep(3000);
				wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));	//Wait until records table gets visible.
				
				//--------------------------------Case----------------------------------
				     
				
					Thread.sleep(4000);
				       performerPOM.clickDownloadDocument().click();	
				       test.log(LogStatus.PASS, "Case=Document  Downloaded Successfully.");
				       
				       try
				       {
				    	    Thread.sleep(4000);
				            performerPOM.clickViewDocument().click();	
				            Thread.sleep(3000);
				            performerPOM.clickcloseViewDocument().click();
				           Thread.sleep(3000);
				          test.log(LogStatus.PASS, "Case=Document  View Successfully.");
				       }
				       catch(Exception e)
				       {
				    	   
				       Thread.sleep(5000);
					    // Switching to Alert        
				        Alert alert = getDriver().switchTo().alert();		
				        		
				        // Capturing alert message.    
				        String alertMessage= getDriver().switchTo().alert().getText();	
				        
				        Thread.sleep(3000);
				        test.log(LogStatus.PASS, alertMessage);
				        		
				        // Displaying alert message		
				        System.out.println(alertMessage);	
				        // Accepting alert		
				        alert.accept();
				       }
						
						//driver.navigate().refresh();
			
				//--------------------------------Notice----------------------------------
		 
				       Thread.sleep(5000);
					   // JavascriptExecutor js = (JavascriptExecutor) getDriver();
						//js.executeScript("window.scrollBy(500,0)");
						Thread.sleep(3000);
						performerPOM.clickTypeDropdown().click();					//Clicking on Type drop down box (i.e. Notice, Case, Task)
						Thread.sleep(6000);
						performerPOM.selectTypeNotice().click();					//Selecting 'Case' option.
						 Thread.sleep(4000);
					       performerPOM.clickDownloadDocumentNotice().click();	
					       test.log(LogStatus.PASS, "Notice=Document Downloaded Successfully.");
					      try
					      {
					         Thread.sleep(4000);
					         performerPOM.clickViewDocumentNotice().click();	
					         Thread.sleep(4000);
					         performerPOM.clickcloseViewDocument().click();
					         test.log(LogStatus.PASS, "Notice=Document view Successfully.");
					      }
					      catch(Exception e)
					      {
					    	  Thread.sleep(5000);
							    // Switching to Alert        
						        Alert alert1 = getDriver().switchTo().alert();		
						        		
						        // Capturing alert message.    
						        String alertMessage1= getDriver().switchTo().alert().getText();	
						        
						        Thread.sleep(3000);
						        test.log(LogStatus.PASS, alertMessage1);
						        		
						        // Displaying alert message		
						        System.out.println(alertMessage1);	
						        
					      		
						        // Accepting alert		
						        alert1.accept();
					      }
					       
						     // driver.navigate().refresh();
										
		          ////--------------------------------Task----------------------------------
						
					    
						Thread.sleep(5000);
						performerPOM.clickTypeDropdown().click();					//Clicking on Type drop down box (i.e. Notice, Case, Task)
						Thread.sleep(6000);
						performerPOM.selectTypeTask().click();					//Selecting 'Task' option.
									 
					     try
					     {
					    	 Thread.sleep(5000);
					    	 performerPOM.clickViewDocumentTask().click();	
					    	 Thread.sleep(3000);
					    	 performerPOM.clickcloseViewDocument().click();

					    	 	Thread.sleep(1000);
					       		test.log(LogStatus.PASS, "Task=Document view Successfully.");
					     }
					   catch(Exception e)
					   {
						   Thread.sleep(5000);
						    // Switching to Alert        
					        Alert alert2 = getDriver().switchTo().alert();		
					        		
					        // Capturing alert message.    
					        String alertMessage2= getDriver().switchTo().alert().getText();	
					        
					        Thread.sleep(3000);
					        test.log(LogStatus.PASS, alertMessage2);
					        		
					        // Displaying alert message		
					        System.out.println(alertMessage2);	
					        
				      		
					        // Accepting alert		
					        alert2.accept();
					   }
					     
					     Thread.sleep(4000);
					     performerPOM.clickDownloadDocumentTask().click();
					     
						try
							{
								   Thread.sleep(5000);
								    // Switching to Alert        
							        Alert alert2 = getDriver().switchTo().alert();		
							        		
							        // Capturing alert message.    
							        String alertMessage2= getDriver().switchTo().alert().getText();	
							        
							        Thread.sleep(3000);
							        test.log(LogStatus.PASS, "Task=" +alertMessage2);
							        		
							        // Displaying alert message		
							        System.out.println(alertMessage2);	
							        
						      		
							        // Accepting alert		
							        alert2.accept();
							}
							
							catch(Exception e)
							{
								
							     
							     test.log(LogStatus.PASS, "Task=Document  Downloaded Successfully.");
							}
					  
					      getDriver().navigate().refresh();
					       
					       Thread.sleep(1000);
						   OverduePOM.clickDashboard().click();				//Clicking on 'My Dashboard'
			}   
			
		 public static void AdvancedSearchWorkspace(ExtentTest test, String type) throws InterruptedException
			{
				WebDriverWait wait=new WebDriverWait(getDriver(),60);
		 		
				
				Thread.sleep(3000);
				performerPOM.clickMyWorkspace().click();
				
				Thread.sleep(3000);
				performerPOM.clickCaseNotice1().click();
			
				Thread.sleep(5000);
				wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));	//Wait until records table gets visible.
				
				Thread.sleep(5000);
				
				performerPOM.AdvancedSearchReports().click();
				
			//-------------------------------------------Notice--------------------------------------------------
				
				Thread.sleep(4000);
				performerPOM.startDate().sendKeys("05/01/2022");
				
				Thread.sleep(4000);
				performerPOM.endDate().sendKeys("05/07/2022");
				
				Thread.sleep(4000);
				performerPOM.clickApplyButton().click();
				
				
				Thread.sleep(5000);
				wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));	//Wait until records table gets visible.
				
				
				Thread.sleep(5000);
				performerPOM.clickExportAdavanced().click();
				test.log(LogStatus.PASS, "File downloaded successfully.");
				
				
				Thread.sleep(4000);
				performerPOM.clickeditButton().click();
				
				test.log(LogStatus.PASS,"edit notice details icon open successfully");
				
				
				Thread.sleep(5000);
				performerPOM.Actionclosepopup().click();
				
				
			/*	Thread.sleep(4000);
				performerPOM.clickdeleteButton().click();
				
				  Thread.sleep(5000);
				    // Switching to Alert        
			        Alert alert = getDriver().switchTo().alert();		
			        		
			        // Capturing alert message.    
			        String alertMessage= getDriver().switchTo().alert().getText();	
			        
			        Thread.sleep(3000);
			        test.log(LogStatus.PASS, alertMessage);
			        		
			        // Displaying alert message		
			        System.out.println(alertMessage);	
			        
			        		
			        // Accepting alert		
			        alert.accept();		*/
			      //-------------------------------------------Case--------------------------------------------------
					Thread.sleep(4000);
					wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));	//Wait until records table gets visible.
					
					Thread.sleep(4000);
					performerPOM.clickTypeDropdown1().click();					//Clicking on Type drop down box (i.e. Notice, Case, Task)
					Thread.sleep(4000);
					performerPOM.selectTypeCase1().click();
					
					Thread.sleep(3000);
					performerPOM.clickExportAdavanced().click();					//Clicking on 'Excel Report' image.
					test.log(LogStatus.PASS, "File downloaded successfully.");
				
					Thread.sleep(4000);
					performerPOM.clickeditButton().click();
					
					test.log(LogStatus.PASS,"edit case details icon open successfully");
					
					
					Thread.sleep(5000);
					performerPOM.Actionclosepopup().click();
					
					
			/*		Thread.sleep(4000);
					performerPOM.clickdeleteButton().click();
					
					  Thread.sleep(5000);
					    // Switching to Alert        
				        Alert alert1 = getDriver().switchTo().alert();		
				        		
				        // Capturing alert message.    
				        String alertMessage1= getDriver().switchTo().alert().getText();	
				        
				        Thread.sleep(3000);
				        test.log(LogStatus.PASS, alertMessage1);
				        		
				        // Displaying alert message		
				        System.out.println(alertMessage1);	
				        
				        		
				        // Accepting alert		
				        alert1.accept();	*/
				        
		          //-------------------------------------------Task--------------------------------------------------
						Thread.sleep(3000);
					wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));	//Wait until records table gets visible.
					
					
					Thread.sleep(4000);
					performerPOM.clickTypeDropdown1().click();					//Clicking on Type drop down box (i.e. Notice, Case, Task)
					Thread.sleep(4000);
					performerPOM.selectTypeTask1().click();
					
					Thread.sleep(3000);
					performerPOM.clickExcelReport().click();					//Clicking on 'Excel Report' image.
					test.log(LogStatus.PASS, "File downloaded successfully.");
					
					Thread.sleep(3000);
					performerPOM.viewTaskDetails1().click();	
					test.log(LogStatus.PASS, "Show details Task popup open successfully.");
					
					Thread.sleep(3000);
					performerPOM.ActioncloseTaskpopup().click();
					
					Thread.sleep(1000);
					OverduePOM.clickDashboard().click();
				        
			}
		  public static void AdvancedSearchDocument( ExtentTest test,String login) throws InterruptedException, IOException
		   {
				 		WebDriverWait wait = new WebDriverWait(getDriver(), 60);
				 		progress();
				 		
				 		//wait.until(ExpectedConditions.visibilityOf(performerPOM.clickNoticeOpen()));	//Wait until 'Notice-Open' count get visible
				 		performerPOM.clickMyDocument().click();					//Clicking on 'My Document'
				 		performerPOM.clickmyDocument().click();	                    //Clicking on 'My Document'
				 		
				 		Thread.sleep(3000);
				 		wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));	//Wait until records table gets visible.
				 		
					  //--------------------------------Case----------------------------------
						
					 Thread.sleep(3000);
					 performerPOM.AdvancedSearchReports().click();
				      Thread.sleep(4000);
				       performerPOM.clickDownloadDocument1().click();	
				       Thread.sleep(4000);
				       performerPOM.clickViewDocument1().click();	
				       Thread.sleep(10000);
				       performerPOM.clickcloseViewDocument1().click();
					
				       Thread.sleep(3000);
				       test.log(LogStatus.PASS, "Advanced Search-Document  View Successfully.");
				       test.log(LogStatus.PASS, "Advanced Search-Document  Downloaded Successfully.");
						
					
			
						//--------------------------------Notice----------------------------------
		 
						
						Thread.sleep(3000);
						performerPOM.clickTypeDropdown3().click();					//Clicking on Type drop down box (i.e. Notice, Case, Task)
						Thread.sleep(3000);
						performerPOM.selectTypeCase2().click();					//Selecting 'Case' option.
						 Thread.sleep(3000);
					       performerPOM.clickDownloadDocument1().click();	
					       Thread.sleep(3000);
					       performerPOM.clickViewDocument1().click();	
					       Thread.sleep(3000);
					       performerPOM.clickcloseViewDocument1().click();
					       
					       Thread.sleep(3000);
					       test.log(LogStatus.PASS, "Advanced Search-Document view Successfully.");
					       test.log(LogStatus.PASS, "Advanced Search-Document Downloaded Successfully.");
							
										
		               ////--------------------------------Task----------------------------------
						
					   
						Thread.sleep(3000);
						performerPOM.clickTypeDropdown3().click();					//Clicking on Type drop down box (i.e. Notice, Case, Task)
						Thread.sleep(3000);
						performerPOM.selectTypeTask2().click();					//Selecting 'Task' option.
						
						
						 Thread.sleep(3000);
					     performerPOM.clickViewDocument1().click();	
					     Thread.sleep(3000);
					     performerPOM.clickcloseViewDocument1().click();
					     
					     test.log(LogStatus.PASS, "Advanced Search-Document view Successfully.");
						
						 Thread.sleep(3000);
					     performerPOM.clickDownloadDocument1().click();	
					     
					      try 
					      {      Thread.sleep(2000);
								String msg = getDriver().switchTo().alert().getText();
								Thread.sleep(2000);
								getDriver().switchTo().alert().accept();							//Clicking on OK of alert.
								test.log(LogStatus.PASS, "Message displayed -:- " + msg);
										
							}
						catch(Exception e)
								{
									test.log(LogStatus.PASS, "Advanced Search-Document  Downloaded Successfully.");	
								}
					       
				         getDriver().navigate().refresh();
				       
				       Thread.sleep(1000);
					   OverduePOM.clickDashboard().click();				//Clicking on 'My Dashboard'
		}

		  public static void MyReports( ExtentTest test, XSSFWorkbook workbook, String login) throws InterruptedException, IOException
			{
			  WebDriverWait wait = new WebDriverWait(getDriver(), 60);
				progress();
				
				
				Thread.sleep(8000);
				performerPOM.clickMyReports().click();					//Clicking on 'My Reports'
				
				Thread.sleep(8000);
				wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));	//Wait until records table gets visible.
				
				/*Thread.sleep(4000);
				performerPOM.clickReportTypeFilter().click();
				
				Thread.sleep(4000);
				performerPOM.clickReportTypeFilter5().click(); */
				
			
				
			/*	Thread.sleep(5000);
				if(performerPOM.clearButton().isEnabled())
				{
					performerPOM.clearButton().click();
					 test.log(LogStatus.PASS, "My Report = clear button Work Successfully");
				}
				else
				{
					test.log(LogStatus.PASS, "My Report = clear button not Work Successfully");
				}*/
				   
				
				
				
				
				//--------------------------------Notice----------------------------------
				
				Thread.sleep(10000);
				JavascriptExecutor js = (JavascriptExecutor) getDriver();
				performerPOM.clickExcelReport().sendKeys(Keys.PAGE_DOWN);
				performerPOM.clickExcelReport().sendKeys(Keys.END);
				js.executeScript("arguments[0].scrollIntoView();", CFOcountPOM.readTotalItems1());
				
				Thread.sleep(10000);
				CFOcountPOM.readTotalItems1().click();
				String item = CFOcountPOM.readTotalItems1().getText();
				String[] bits = item.split(" ");								//Splitting the String
				if(bits.length < 2)
				{
					performerPOM.clickExcelReport().sendKeys(Keys.END);
					Thread.sleep(8000);
					item = CFOcountPOM.readTotalItems1().getText();
					bits = item.split(" ");									//Splitting the String
				}
				String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
				int count1 = 0;
				if(compliancesCount.equalsIgnoreCase("to"))
				{
					Thread.sleep(8000);
					item = CFOcountPOM.readTotalItems1().getText();
					bits = item.split(" ");										//Splitting the String
					compliancesCount = bits[bits.length - 2];					//Getting the second last word (total number of users)
				}
				else if(compliancesCount.equalsIgnoreCase("to"))
				{
					count1 = 0;
				}
				else
				{
					count1 = Integer.parseInt(compliancesCount);
				} 
				
				
				Thread.sleep(8000);
				Report( test, count1, "Notice");
				
				
				Thread.sleep(8000);
				js.executeScript("window.scrollBy(0,500)");
				js.executeScript("document.querySelector(\"div[id='grid'] div[class='k-grid-content k-auto-scrollable']\").scrollLeft=5000");
			  
				Thread.sleep(10000);
				performerPOM.viewNoticeDetails1().click();
				test.log(LogStatus.PASS, "View details Notice popup open successfully.");
				
				
				Thread.sleep(8000);
				performerPOM.Actionclosepopup1().click();
				
				js.executeScript("document.querySelector(\"div[id='grid'] div[class='k-grid-content k-auto-scrollable']\").scrollLeft=5000");
				
				Thread.sleep(8000);
				performerPOM.showResponseDetailIcon1().click();
				test.log(LogStatus.PASS, "Show response details Notice  popup open successfully.");
				
				Thread.sleep(8000);
				performerPOM.Actionclosepopup1().click();
				
				//driver.navigate().refresh();
				
				//--------------------------------Case----------------------------------
			
//				Thread.sleep(1000);
//				wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));	//Wait until records table gets visible.
				
				Thread.sleep(8000);
				performerPOM.clickTypeDropdown().click();					//Clicking on Type drop down box (i.e. Notice, Case, Task)
				Thread.sleep(8000);
				performerPOM.selectTypeNotice().click();					//Selecting 'Case' option.
				
				Thread.sleep(8000);
				wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));	//Wait until records table gets visible.
				Thread.sleep(8000);
				performerPOM.clickExcelReport().sendKeys(Keys.END);
				js.executeScript("arguments[0].scrollIntoView();", CFOcountPOM.clickNextPage1());
				js.executeScript("window.scrollBy(0,500)");
				
				Thread.sleep(8000);
				item = CFOcountPOM.readTotalItems1().getText();
				bits = item.split(" ");									//Splitting the String
				if(bits.length < 2)
				{
					performerPOM.clickExcelReport().sendKeys(Keys.END);
					Thread.sleep(8000);
					item = CFOcountPOM.readTotalItems1().getText();
					bits = item.split(" ");									//Splitting the String
					
				}
				compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
				count1 = 0;
				if(compliancesCount.equalsIgnoreCase("to"))
				{
					Thread.sleep(8000);
					item = CFOcountPOM.readTotalItems1().getText();
					bits = item.split(" ");										//Splitting the String
					compliancesCount = bits[bits.length - 2];					//Getting the second last word (total number of users)
				}
				else if(compliancesCount.equalsIgnoreCase("to"))
				{
					count1 = 0;
				}
				else
				{
					count1 = Integer.parseInt(compliancesCount);
				}
				Thread.sleep(8000);
				Report( test, count1, "Case");
				
				
				
				
				js.executeScript("document.querySelector(\"div[id='grid'] div[class='k-grid-content k-auto-scrollable']\").scrollLeft=5000");
				Thread.sleep(8000);
				performerPOM.viewNoticeDetails1().click();
				test.log(LogStatus.PASS, "View details Case popup open successfully.");
				
				Thread.sleep(8000);
				performerPOM.Actionclosepopup1().click();
				
				js.executeScript("document.querySelector(\"div[id='grid'] div[class='k-grid-content k-auto-scrollable']\").scrollLeft=5000");
				
				Thread.sleep(8000);
				performerPOM.showResponseDetailIcon1().click();
				test.log(LogStatus.PASS, "Show Hearing details Case popup open successfully.");
				
				Thread.sleep(8000);
				performerPOM.Actionclosepopup1().click();
				
//				Thread.sleep(500);
//				Report(driver, test, count1, "Case");
				
				//driver.navigate().refresh();

				//--------------------------------Task----------------------------------
				
			//	Thread.sleep(1000);
			//	wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));	//Wait until records table gets visible.
				
				Thread.sleep(10000);
				performerPOM.clickTypeDropdown().click();					//Clicking on Type drop down box (i.e. Notice, Case, Task)
				Thread.sleep(10000);
				performerPOM.selectTypeTask().click();					//Selecting 'Task' option.
				
				Thread.sleep(8000);
				wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));	//Wait until records table gets visible.
				Thread.sleep(8000);
				performerPOM.clickExcelReport().sendKeys(Keys.END);
				js.executeScript("arguments[0].scrollIntoView();", CFOcountPOM.readTotalItems1());
				
				Thread.sleep(8000);
				item = CFOcountPOM.readTotalItems1().getText();
				bits = item.split(" ");								//Splitting the String
				if(bits.length < 2)
				{
					performerPOM.clickExcelReport().sendKeys(Keys.END);
					Thread.sleep(8000);
					item = CFOcountPOM.readTotalItems1().getText();
					bits = item.split(" ");									//Splitting the String
					
				}
				compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
				count1 = 0;
				if(compliancesCount.equalsIgnoreCase("to"))
				{
					count1 = 0;
				}
				else
				{
					count1 = Integer.parseInt(compliancesCount);
				}
				
					
				Thread.sleep(8000);
				Report( test, count1, "Task");
				
				Thread.sleep(8000);
				performerPOM.viewTaskDetails().click();	
				test.log(LogStatus.PASS, "Show details Task popup open successfully.");
				
				Thread.sleep(8000);
				performerPOM.ActioncloseTaskpopup().click();
				
//				Thread.sleep(500);
//				Report(driver, test, count1, "Task");
				
				Thread.sleep(8000);
				   OverduePOM.clickDashboard().click();				//Clicking on 'My Dashboard'
				
				
				
				
			}
		  static void Report( ExtentTest test, int count1, String type) throws InterruptedException, IOException
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 60);
				Thread.sleep(7000);
				File dir = new File("C://Users//snehalp//Downloads");
				File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
				
//				Thread.sleep(2000);
//				CFOcountPOM.clickNextPage1().sendKeys(Keys.PAGE_UP);
				Thread.sleep(6000);
				performerPOM.clickExcelReport().click();					//Clicking on 'Excel Report' image.
				
				Thread.sleep(7000);
				wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));	
				
				Thread.sleep(9000);
				File dir1 = new File("C://Users//snehalp//Downloads");
				File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download
				
				
				Thread.sleep(6000);
				if(dirContents.length < allFilesNew.length)
				{
					test.log(LogStatus.PASS, type + ":- File Downloaded Successfully.");
					
					File lastModifiedFile = allFilesNew[0];			//Storing any 0th index file in 'lastModifiedFile' file name.
				    for (int i = 1; i < allFilesNew.length; i++) 	//For loop till the number of files in directory.
				    {
				       if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) 	//If allFilesNew[i] file is having large/latest time time of update then latest modified file be allFilesNew[i] file.
				       {
				           lastModifiedFile = allFilesNew[i];
				       }
				    }
					
					Thread.sleep(4000);
					fis = new FileInputStream(lastModifiedFile);
					workbook = new XSSFWorkbook(fis);
					sheet = workbook.getSheetAt(0);					//Retrieving first sheet of Workbook
					int no = sheet.getLastRowNum();
					int SheetRecords = 0;
					for(int i = 0; i <= 5; i++)
					{
						Row row = sheet.getRow(no-i);
						Cell c1 = row.getCell(0);
						String records = c1.getStringCellValue();
						if(records.equals("") || records.equals(null))
						{
							
						}
						else
						{
							SheetRecords = Integer.parseInt(records);
							break;
						}
					}
					fis.close();
					
					if(count1 == SheetRecords)
					{
						//test.log(LogStatus.PASS, type+" - No of records displayed matches to no of records in Excel Sheet.");
						test.log(LogStatus.PASS, "Total records displayed = "+count1+". Total records in Excel sheet = "+SheetRecords);
					}
					else
					{
						//test.log(LogStatus.FAIL, type+" - No of records displayed doesn't matches to no of records in Excel Sheet.");
						test.log(LogStatus.FAIL, "Total records displayed = "+count1+". Total records in Excel sheet = "+SheetRecords);
					}
				}
				else
				{
					test.log(LogStatus.FAIL, type+" - File doesn't downloaded successfully.");
				}
			}
			
			public static void MoreReport( ExtentTest test, String type) throws InterruptedException
			{
				
				WebDriverWait wait = new WebDriverWait(getDriver(), 180);
				
				Thread.sleep(8000);
				performerPOM.clickMyReports().click();
				
				Thread.sleep(8000);
				wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));	//Wait until records table gets visible.
				
				JavascriptExecutor js = (JavascriptExecutor) getDriver();
		        js.executeScript("window.scrollBy(0,-500)");
				
				Thread.sleep(8000);
				performerPOM.clickMoreReports().click();
				//--------------------------------Case Report------------------------------------------
//				Thread.sleep(3000);
//				performerPOM.clicklocationFilterReports().click();
//				
//				Thread.sleep(3000);
//				performerPOM.selectlocationFilterReports().click();
				
				Thread.sleep(8000);
				performerPOM.FromDateReports().sendKeys("01-12-2022");
				
//				Thread.sleep(3000);
//				performerPOM.selectFromDate().click();
				
				Thread.sleep(8000);
				performerPOM.ToDateReports().sendKeys("21-12-2022");
				
//				Thread.sleep(3000);
//				performerPOM.selectToDate().click();
				
				
				//--------------------------MIS Report------------------------------
				
			    Thread.sleep(3000);
				File dir = new File("C://Users//snehalp//Downloads");
			//	File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
				
				Thread.sleep(3000);
				performerPOM.MISReports().click();					//Clicking on 'Excel Report' image.
				test.log(LogStatus.PASS, "Case :- MIS Report downloaded successfully.");
				
				
			    //--------------------------closed Cases Reports------------------------------
				
				Thread.sleep(3000);
				File dir1 = new File("C://Users//snehalp//Downloads");
			//	File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
				
				Thread.sleep(3000);
				performerPOM.closedCasesReports().click();					//Clicking on 'Excel Report' image.
				test.log(LogStatus.PASS, "Case :- closed Cases Reports downloaded successfully.");
				
				
			    //--------------------------Ext LawyerPerformance Reports------------------------------
			/*	Thread.sleep(100);
				File dir2 = new File("C://Users//snehalp//Downloads");
			//	File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
				
				Thread.sleep(250);
				performerPOM.ExtLawyerPerformanceReports().click();					//Clicking on 'Excel Report' image.
				test.log(LogStatus.PASS, "Case :- Ext Lawyer Performance Reports downloaded successfully.");*/
				
				
				//--------------------------Budget Reports-----------------------------------
				
				
				Thread.sleep(3000);
				File dir3 = new File("C://Users//snehalp//Downloads");
			//	File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
				
				Thread.sleep(3000);
				performerPOM.BudgetReports().click();					//Clicking on 'Excel Report' image.
				test.log(LogStatus.PASS, "Case :- Budget Reports downloaded successfully.");
				
				
				//--------------------------Lawyer Details Reports------------------------------
				
				
				
				Thread.sleep(3000);
				File dir4 = new File("C://Users//snehalp//Downloads");
			//	File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
				
				Thread.sleep(3000);
				performerPOM.LawyerDetailsReports().click();					//Clicking on 'Excel Report' image.
				test.log(LogStatus.PASS, "Case :- Lawyer Details Reports downloaded successfully.");
				
				//--------------------------Case Payment Reports------------------------------
				
				
				Thread.sleep(3000);
				File dir5 = new File("C://Users//snehalp//Downloads");
			//	File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
				
				Thread.sleep(3000);
				performerPOM.CasePaymentReports().click();					//Clicking on 'Excel Report' image.
				test.log(LogStatus.PASS, "Case :- Case Payment Reports downloaded successfully.");

				
			//--------------------------Case Hearing Reports------------------------------
				
				
				Thread.sleep(3000);
				File dir6 = new File("C://Users//snehalp//Downloads");
			//	File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
				
				Thread.sleep(3000);
				performerPOM.CaseHearingReports().click();					//Clicking on 'Excel Report' image.
				test.log(LogStatus.PASS, "Case :- Case Hearing Reports downloaded successfully.");

				
				//--------------------------CourtCaseReports------------------------------
				
				
				 Thread.sleep(3000);
				 File dir7 = new File("C://Users//snehalp//Downloads");
			 //	File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
						
				Thread.sleep(3000);
				performerPOM.CourtCaseReports().click();					//Clicking on 'Excel Report' image.
				test.log(LogStatus.PASS, "Case :- Court Case Reports downloaded successfully.");

				
				//--------------------------CourtOrderReports------------------------------
				
				
				 Thread.sleep(3000);
				 File dir8 = new File("C://Users//snehalp//Downloads");
			 //	File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
						
				Thread.sleep(3000);
				performerPOM.CourtOrderReports().click();					//Clicking on 'Excel Report' image.
				test.log(LogStatus.PASS, "Case :- Case Order Reports downloaded successfully.");
				
				
				//-------------------------CourtDoumentReports------------------------------
				
				
				 Thread.sleep(3000);
				 File dir9 = new File("C://Users//snehalp//Downloads");
			 //	File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
						
				Thread.sleep(3000);
				performerPOM.CourtDoumentReports().click();					//Clicking on 'Excel Report' image.
				test.log(LogStatus.PASS, "Case :- Court Doument Reports downloaded successfully.");
				
				//-------------------------noticeCovertedToCaseReports------------------------------
				
				
				 Thread.sleep(3000);
				 File dir10 = new File("C://Users//snehalp//Downloads");
			     //	File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
						
				Thread.sleep(3000);
				performerPOM.noticeCovertedToCaseReports().click();					//Clicking on 'Excel Report' image.
				test.log(LogStatus.PASS, "Case :- Notice converted To Case Reports downloaded successfully.");
			
				
				//-------------------------AllReports------------------------------
				
				
				 Thread.sleep(3000);
				 File dir11 = new File("C://Users//snehalp//Downloads");
			     //	File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
						
				Thread.sleep(8000);
				performerPOM.AllReports().click();					//Clicking on 'Excel Report' image.
				test.log(LogStatus.PASS, "Case :- All Reports downloaded successfully.");
			
				
			
				//----------------------------------------Notice Report------------------------------------------------
				
				Thread.sleep(8000);
				performerPOM.clickNoticeReport().click();
				Thread.sleep(3000);
				performerPOM.clickNoticeReport().click();
//				Thread.sleep(3000);
//				performerPOM.clicklocationFilterReports().click();
//				
//				Thread.sleep(3000);
//				performerPOM.selectlocationFilterReports().click();
				
				//Thread.sleep(3000);
			//	performerPOM.FromDateReports().sendKeys("01-12-2022");
				
//				Thread.sleep(3000);
//				performerPOM.selectFromDate().click();
				
				//Thread.sleep(3000);
				//performerPOM.ToDateReports().sendKeys("21-12-2022");
				
				//------------------------MISReports------------------------------
				
				
				 Thread.sleep(8000);
				 File dir15 = new File("C://Users//snehalp//Downloads");
			     //	File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
						
				Thread.sleep(3000);
				performerPOM.MISReports().click();					//Clicking on 'Excel Report' image.
				test.log(LogStatus.PASS, "Notice :- MIS Reports downloaded successfully.");
				
				
				//------------------------closedCasesReports------------------------------
				
				
				 Thread.sleep(3000);
				 File dir20 = new File("C://Users//snehalp//Downloads");
			     //	File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
						
				Thread.sleep(3000);
				performerPOM.closedCasesReports().click();					//Clicking on 'Excel Report' image.
				test.log(LogStatus.PASS, "Notice :- closed Notice Reports downloaded successfully.");
				
				
				
			
				//------------------------MISReports------------------------------
				
				
				 Thread.sleep(3000);
				 File dir19 = new File("C://Users//snehalp//Downloads");
			     //	File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
						
				Thread.sleep(3000);
				performerPOM.MISReports().click();					//Clicking on 'Excel Report' image.
				test.log(LogStatus.PASS, "Notice :- MIS All Reports downloaded successfully.");
				
				
				//------------------------ExtLawyerPerformanceReports------------------------------
				
				
			/* Thread.sleep(100);
				 File dir18 = new File("C://Users//snehalp//Downloads");
			     //	File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
						
				Thread.sleep(250);
				performerPOM.ExtLawyerPerformanceReports().click();					//Clicking on 'Excel Report' image.
				test.log(LogStatus.PASS, "Notice :- Ext Lawyer Performance Reports downloaded successfully.");*/
				
				
				
				
				//------------------------BudgetReports------------------------------
				
				
				 Thread.sleep(3000);
				 File dir17 = new File("C://Users//snehalp//Downloads");
			     //	File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
						
				Thread.sleep(3000);
				performerPOM.BudgetReports().click();					//Clicking on 'Excel Report' image.
				test.log(LogStatus.PASS, "Notice :- Budget Reports downloaded successfully.");
				
				
				
				
				//------------------------clickNoticePaymentReport------------------------------
				
				
				 Thread.sleep(3000);
				 File dir16 = new File("C://Users//snehalp//Downloads");
			     //	File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
						
				Thread.sleep(3000);
				performerPOM.LawyerDetailsReports().click();					//Clicking on 'Excel Report' image.
				test.log(LogStatus.PASS, "Notice :- Lawyer Details downloaded successfully.");
				
				
				//------------------------clickNoticePaymentReport------------------------------
				
				
				 Thread.sleep(4000);
				 File dir13 = new File("C://Users//snehalp//Downloads");
			     //	File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
						
				Thread.sleep(4000);
				performerPOM.clickNoticePaymentReport().click();					//Clicking on 'Excel Report' image.
				test.log(LogStatus.PASS, "Notice :- Notice Payment Report downloaded successfully.");
				
				
				
				//------------------------clickNoticeResponseReport------------------------------
				
				
				 Thread.sleep(4000);
				 File dir14 = new File("C://Users//snehalp//Downloads");
			     //	File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
						
				Thread.sleep(4000);
				performerPOM.clickNoticeResponseReport().click();					//Clicking on 'Excel Report' image.
				test.log(LogStatus.PASS, "Notice :- Notice Response Report downloaded successfully.");
				
					
				
				
				//-------------------------AllReports------------------------------
				
				
				 Thread.sleep(4000);
				 File dir12 = new File("C://Users//snehalp//Downloads");
			     //	File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
						
				Thread.sleep(4000);
				performerPOM.AllReports().click();					//Clicking on 'Excel Report' image.
				test.log(LogStatus.PASS, " Notice :- All Report downloaded successfully.");
				
			}
			
			static void NewReminder( ExtentTest test, String type) throws InterruptedException
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 180);
				
				Thread.sleep(500);
				wait.until(ExpectedConditions.visibilityOf(performerPOM.clickAddNew1()));
				performerPOM.clickAddNew1().click();		//Clicking on 'Add New' button.
				
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_showReminderDetail"));
				wait.until(ExpectedConditions.visibilityOf(performerPOM.clickType()));
				Actions action = new Actions(getDriver());
				
				if(type.equalsIgnoreCase("Notice"))
				{
					action.moveToElement(performerPOM.clickType()).click().sendKeys(Keys.ARROW_DOWN, Keys.ENTER).perform();
				}
				else if(type.equalsIgnoreCase("Task"))
				{
					action.moveToElement(performerPOM.clickType()).click().sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER).perform();
				}
				
				Thread.sleep(2000);
				action.moveToElement(performerPOM.clickTitle()).click().sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER).perform();
				
				Thread.sleep(3000);
				performerPOM.clickReminderText().sendKeys("Reminder as on  test 19");
				
				Thread.sleep(3000);
				performerPOM.clickDescription().sendKeys("Reminder as on  test 19");
				
				Thread.sleep(3000);
				performerPOM.clickRemark2().sendKeys("Reminder as on test 19");
				
				Thread.sleep(3000);
				performerPOM.clickDate().click();
				Thread.sleep(3000);
				OverduePOM.selectNextMonth().click();
				OverduePOM.selectDate().click();
				
				Thread.sleep(3000);
				performerPOM.clickSave().click();				//Clicking on Save button.
				

				Thread.sleep(3000);
				String msg = performerPOM.readMsg1().getText();

				
				if(msg.equalsIgnoreCase("Reminder Saved Successfully."))
				{
					test.log(LogStatus.PASS, "Message displayed = "+msg);
				
				}
				else
				{
					test.log(LogStatus.FAIL, "Message displayed = "+msg);
				}
				
				Thread.sleep(300);
				getDriver().switchTo().parentFrame();
				
				Thread.sleep(300);
				performerPOM.clickCloseReminder().click();
				
				Thread.sleep(3000);
				performerPOM.clickEditReminder().click();
				
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_showReminderDetail"));
				
				
		         Actions action1 = new Actions(getDriver());
				
				if(type.equalsIgnoreCase("Notice"))
				{
					action1.moveToElement(performerPOM.clickType()).click().sendKeys(Keys.ARROW_DOWN, Keys.ENTER).perform();
				}
//				else if(type.equalsIgnoreCase("Task"))
//				{
//					action1.moveToElement(performerPOM.clickType()).click().sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER).perform();
//				}
				
				Thread.sleep(2000);
				action1.moveToElement(performerPOM.clickTitle()).click().sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER).perform();
				
				Thread.sleep(3000);
				performerPOM.clickReminderText().clear();
				
				Thread.sleep(3000);
				performerPOM.clickReminderText().sendKeys("Reminder as on  test 1");
				
				Thread.sleep(3000);
				performerPOM.clickDate().click();
				Thread.sleep(3000);
				OverduePOM.selectNextMonth().click();
				OverduePOM.selectDate().click();
				
				Thread.sleep(3000);
				performerPOM.clickSave().click();				//Clicking on Save button.
				
				
				Thread.sleep(3000);
				wait.until(ExpectedConditions.visibilityOf(performerPOM.readMsg2()));
				
				Thread.sleep(500);
				String msg5 = performerPOM.readMsg2().getText();		//Reading Message appeared after save button
			
				if(msg5.equalsIgnoreCase("Reminder Updated Successfully"))
				{
					test.log(LogStatus.PASS, "Message displayed = "+msg5);
				
				}
				else
				{
					test.log(LogStatus.FAIL, "Message displayed = "+msg5);
				}
				

				Thread.sleep(300);
				getDriver().switchTo().parentFrame();
				
				Thread.sleep(300);
				performerPOM.clickCloseReminder().click();
				
				Thread.sleep(300);
				performerPOM.clickDeleteReminder().click();
				
				 Thread.sleep(5000);
				    // Switching to Alert        
			        Alert alert = getDriver().switchTo().alert();		
			        		
			        // Capturing alert message.    
			        String alertMessage= getDriver().switchTo().alert().getText();	
			        
			        Thread.sleep(3000);
			        test.log(LogStatus.PASS, alertMessage);
			        		
			        // Displaying alert message		
			        System.out.println(alertMessage);	
			        
			        		
			        // Accepting alert		
			        alert.accept();		
			}
			
			public static void AdvancedSearchReport(ExtentTest test, String type) throws InterruptedException
			{
				WebDriverWait wait=new WebDriverWait(getDriver(),180);
				
				Thread.sleep(2000);
		        performerPOM.clickMyReports().click();					//Clicking on 'My Reports'
		        
		        
//		        Thread.sleep(500);
//		        performerPOM.clickExcelReport1().click();
//		        test.log(LogStatus.PASS, "Usage Report downloaded successfully.");
				
				Thread.sleep(5000);
				wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));	//Wait until records table gets visible.
				
				Thread.sleep(5000);
				
				performerPOM.AdvancedSearchReports().click();
				
			//-------------------------------------------Notice--------------------------------------------------
				
				Thread.sleep(3000);
				performerPOM.startDate().sendKeys("05/01/2022");
				
				Thread.sleep(3000);
				performerPOM.endDate().sendKeys("05/05/2022");
				
				Thread.sleep(3000);
				performerPOM.clickApplyButton().click();
				
				
				Thread.sleep(3000);
				wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));	//Wait until records table gets visible.
				
				Thread.sleep(3000);
				JavascriptExecutor js = (JavascriptExecutor) getDriver();
				js.executeScript("document.querySelector(\"div[id='grid1'] div[class='k-grid-content k-auto-scrollable']\").scrollLeft=2000");
				
				
				Thread.sleep(3000);
				performerPOM.clickExportAdavanced().click();
				test.log(LogStatus.PASS, "File downloaded successfully.");
				
				
				  By locator = By.xpath("(//a[@class='k-button k-button-icontext ob-hearing1 k-grid-hearing1'])[1]");
					
					wait.until(ExpectedConditions.presenceOfElementLocated(locator));
					Thread.sleep(4000);
					
					WebElement ViewButton = getDriver().findElement(locator);	
					Thread.sleep(4000);
				    JavascriptExecutor jse=(JavascriptExecutor) getDriver();
				    jse.executeScript("arguments[0].click();", ViewButton);
				
				
				
//				Thread.sleep(3000);
//				performerPOM.viewNoticeDetails().click();
				test.log(LogStatus.PASS, "Show details notice popup open successfully.");
				
				
				Thread.sleep(3000);
				performerPOM.Actionclosepopup().click();
				
				
				Thread.sleep(2000);
				By locator1 = By.xpath("//a[@class='k-button k-button-icontext ob-edit1 k-grid-edit1']");
					
			    wait.until(ExpectedConditions.presenceOfElementLocated(locator1));
				Thread.sleep(4000);
					
				WebElement ViewButton1 = getDriver().findElement(locator1);	
				Thread.sleep(4000);
			    JavascriptExecutor jse1=(JavascriptExecutor)getDriver();
				jse1.executeScript("arguments[0].click();", ViewButton1);
				
				
				//Thread.sleep(3000);
				//performerPOM.showResponseDetailIcon().click();
				test.log(LogStatus.PASS, "Show response details notice popup open successfully.");
				
				Thread.sleep(3000);
				performerPOM.Actionclosepopup().click();
				
			//-------------------------------------------Case--------------------------------------------------
				Thread.sleep(3000);
				wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));	//Wait until records table gets visible.
				
				Thread.sleep(3000);
				performerPOM.clickTypeDropdown1().click();					//Clicking on Type drop down box (i.e. Notice, Case, Task)
				Thread.sleep(4000);
				performerPOM.selectTypeCase1().click();
				
				Thread.sleep(3000);
				performerPOM.clickExportAdavanced().click();					//Clicking on 'Excel Report' image.
				test.log(LogStatus.PASS, "File downloaded successfully.");
				
				Thread.sleep(3000);
				//JavascriptExecutor js = (JavascriptExecutor) getDriver();
				js.executeScript("document.querySelector(\"div[id='grid1'] div[class='k-grid-content k-auto-scrollable']\").scrollLeft=2000");
			
				
				
				Thread.sleep(2000);
				By locator2 = By.xpath("//a[@class='k-button k-button-icontext ob-hearing1 k-grid-hearing1']");
					
			    wait.until(ExpectedConditions.presenceOfElementLocated(locator2));
				Thread.sleep(4000);
					
				WebElement ViewButton2 = getDriver().findElement(locator2);	
				Thread.sleep(4000);
			    JavascriptExecutor jse2=(JavascriptExecutor)getDriver();
			    jse2.executeScript("arguments[0].click();", ViewButton2);
				
				
				
				//Thread.sleep(3000);
				//performerPOM.viewNoticeDetails().click();
				test.log(LogStatus.PASS, "Show details case popup open successfully.");
				
				Thread.sleep(3000);
				performerPOM.Actionclosepopup().click();
				
				Thread.sleep(2000);
				By locator3 = By.xpath("//a[@class='k-button k-button-icontext ob-edit1 k-grid-edit1']");
				 wait.until(ExpectedConditions.presenceOfElementLocated(locator3));
				Thread.sleep(1000);
				WebElement ViewButton3 = getDriver().findElement(locator3);	
				Thread.sleep(1000);
			    JavascriptExecutor jse3=(JavascriptExecutor)getDriver();
			    jse3.executeScript("arguments[0].click();", ViewButton3);
				
				
				
				//Thread.sleep(3000);
				//performerPOM.showResponseDetailIcon().click();
				test.log(LogStatus.PASS, "Show response details Case popup open successfully.");
				
				Thread.sleep(3000);
				performerPOM.Actionclosepopup().click();
				
			//-------------------------------------------Task--------------------------------------------------
					Thread.sleep(3000);
				wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));	//Wait until records table gets visible.
				
				
				Thread.sleep(3000);
				performerPOM.clickTypeDropdown1().click();					//Clicking on Type drop down box (i.e. Notice, Case, Task)
				Thread.sleep(3000);
				performerPOM.selectTypeTask1().click();
				
				Thread.sleep(3000);
				performerPOM.clickExcelReport().click();					//Clicking on 'Excel Report' image.
				test.log(LogStatus.PASS, "File downloaded successfully.");
				
				Thread.sleep(2000);
				By locator4 = By.xpath("//a[@class='k-button k-button-icontext ob-edit k-grid-edit']");
					
			    wait.until(ExpectedConditions.presenceOfElementLocated(locator4));
				Thread.sleep(4000);
					
				WebElement ViewButton4 = getDriver().findElement(locator4);	
				Thread.sleep(4000);
			    JavascriptExecutor jse4=(JavascriptExecutor)getDriver();
			    jse4.executeScript("arguments[0].click();", ViewButton4);
				
				
				//Thread.sleep(3000);
				//performerPOM.viewTaskDetails().click();	
				test.log(LogStatus.PASS, "Show details Task popup open successfully.");
				
				Thread.sleep(3000);
				performerPOM.ActioncloseTaskpopup().click();
				
				Thread.sleep(1000);
				OverduePOM.clickDashboard().click();
			}
		 	public static void AdvocateBillTab(ExtentTest test) throws InterruptedException, IOException
	    	{
	      		WebDriverWait wait=new WebDriverWait(getDriver(),20);
	      		
	    	     Thread.sleep(3000);
	      		performerPOM.clickAdvocateBillTab().click();
	      		 Thread.sleep(3000);
	      		performerPOM.clickAdvocateBillTabViewIcon().click();
	      		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
	      		Thread.sleep(2000);
	      		performerPOM.clickAdvocateBillTabAuditLog().click();
	      		getDriver().switchTo().parentFrame();
	      		Thread.sleep(2000);
	      		performerPOM.clickAdvocateBillTabclose().click();
	      		Thread.sleep(2000);
	      		performerPOM.clickAdvocateBillTabTriangle1().click();
	      		Thread.sleep(2000);
	      		performerPOM.clearButton().click();

	      		
				Thread.sleep(10000);
				CFOcountPOM.readTotalItems1().click();
				String item1 = CFOcountPOM.readTotalItems1().getText();
				String[] bits1 = item1.split(" ");								//Splitting the String
				String compliancesCount1 = bits1[bits1.length - 2];				//Getting the second last word (total number of users)
				int count2 = Integer.parseInt(compliancesCount1);
				
			    try
				{
					performerPOM.clickExportAdavanced().sendKeys(Keys.PAGE_DOWN);
				}
				catch(Exception e)
				{
					
				}
			
			
				Thread.sleep(100);
				File dir = new File("C://Users//Admin//Downloads");
				File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
				
				Thread.sleep(500);
				CFOcountPOM.clickNextPage1().sendKeys(Keys.PAGE_UP);
				Thread.sleep(250);
				performerPOM.clickExportAdavanced().click();					//Clicking on 'Excel Report' image.
				test.log(LogStatus.PASS, "File downloaded successfully.");
				
				Thread.sleep(5500);
				File dir1 = new File("C://Users//Admin//Downloads");
				File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download
				
				if(dirContents.length < allFilesNew.length)
				{
					test.log(LogStatus.PASS, "File downloaded successfully.");
					
					File lastModifiedFile = allFilesNew[0];			//Storing any 0th index file in 'lastModifiedFile' file name.
				    for (int i = 1; i < allFilesNew.length; i++) 	//For loop till the number of files in directory.
				    {
				       if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) 	//If allFilesNew[i] file is having large/latest time time of update then latest modified file be allFilesNew[i] file.
				       {
				           lastModifiedFile = allFilesNew[i];
				       }
				    }
					
					Thread.sleep(100);
					fis = new FileInputStream(lastModifiedFile);
					workbook = new XSSFWorkbook(fis);
					sheet = workbook.getSheetAt(0);					//Retrieving first sheet of Workbook
					
					int no = sheet.getLastRowNum();
					Row row = sheet.getRow(no);
					Cell c1 = row.getCell(0);
					int records =(int) c1.getNumericCellValue();
					fis.close();
					
					if(count2 == records)
					{
						//test.log(LogStatus.PASS, "No of records from grid matches to no of records in Excel Sheet.");
						test.log(LogStatus.PASS, "Total records from Grid = "+count2+" | Total records from Report = "+records);
					}
					else
					{
						//test.log(LogStatus.FAIL, "No of records from grid doesn't matches to no of records in Excel Sheet.");
						test.log(LogStatus.FAIL, "Total records from Grid = "+count2+" | Total records from Excel Sheet = "+records);
					}
				}
				
				
	    		
	    	}
		 	
		 	public static void ApproverAssignmentLog(ExtentTest test) throws InterruptedException, IOException
	    	{
			
				WebDriverWait wait=new WebDriverWait(getDriver(),20);
	    	     Thread.sleep(3000);
	      		performerPOM.clickAdvocateBillTab().click();
			Thread.sleep(3000);
      		performerPOM.clickApproverAssignmentLog().click();
      		

		
		
			Thread.sleep(100);
			File dir2 = new File("C://Users//Admin//Downloads");
			File[] dirContents1 = dir2.listFiles();							//Counting number of files in directory before download 

			Thread.sleep(250);
			performerPOM.clickExportAdavanced().click();					//Clicking on 'Excel Report' image.
			
			
			Thread.sleep(5500);
			File dir3 = new File("C://Users//Admin//Downloads");
			File[] allFilesNew1 = dir3.listFiles();							//Counting number of files in directory after download
			
			if(dirContents1.length < allFilesNew1.length)
			{
				test.log(LogStatus.PASS, "Approver Assignment Log - File downloaded successfully.");
				
				File lastModifiedFile = allFilesNew1[0];			//Storing any 0th index file in 'lastModifiedFile' file name.
			    for (int i = 1; i < allFilesNew1.length; i++) 	//For loop till the number of files in directory.
			    {
			       if (lastModifiedFile.lastModified() < allFilesNew1[i].lastModified()) 	//If allFilesNew[i] file is having large/latest time time of update then latest modified file be allFilesNew[i] file.
			       {
			           lastModifiedFile = allFilesNew1[i];
			       }
			    }
				
				Thread.sleep(100);
				fis = new FileInputStream(lastModifiedFile);
				workbook = new XSSFWorkbook(fis);
				sheet = workbook.getSheetAt(0);					//Retrieving first sheet of Workbook
				
				int no = sheet.getLastRowNum();
				Row row = sheet.getRow(no);
				Cell c1 = row.getCell(0);
				int records =(int) c1.getNumericCellValue();
				fis.close();
				
				Thread.sleep(3000);
	    		performerPOM.clickExportAdavanced().sendKeys(Keys.PAGE_DOWN);
	    		JavascriptExecutor js = (JavascriptExecutor) getDriver();
	    		js.executeScript("window.scrollBy(0,700)");
	      		
	      		
	      		
				
				Thread.sleep(3000);
				CFOcountPOM.readTotalItems2().click();
				String item = CFOcountPOM.readTotalItems2().getText();
				String[] bits = item.split(" ");								//Splitting the String
				String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
				int count = Integer.parseInt(compliancesCount);
				
				if(count == records)
				{
					//test.log(LogStatus.PASS, "No of records from grid matches to no of records in Excel Sheet.");
					test.log(LogStatus.PASS, "Total records from Grid = "+count+" | Total records from Report = "+records);
				}
				else
				{
					//test.log(LogStatus.FAIL, "No of records from grid doesn't matches to no of records in Excel Sheet.");
					test.log(LogStatus.FAIL, "Total records from Grid = "+count+" | Total records from Excel Sheet = "+records);
				}
			}
      		
      		
      		Thread.sleep(500);
      		OverduePOM.clickDashboard().click();
      		
	    	}		
		 	
		 	
		       public static void WorkspaceFilter(ExtentTest test, String type) throws InterruptedException
		      	{
		      		
		      		WebDriverWait wait=new WebDriverWait(getDriver(),20);
		   		 JavascriptExecutor js = (JavascriptExecutor) getDriver();
		   		Thread.sleep(3000);
		   		performerPOM.clickMyWorkspace().click();
		   		
		   		Thread.sleep(3000);
		   		performerPOM.clickCaseNotice1().click();
		   		
		   		  Thread.sleep(3000);
		   			performerPOM.clicklocationFilter().click();
		   			Thread.sleep(3000);
		   			performerPOM.clickExpand().click();
		   			Thread.sleep(3000);
		   	       String locationtext =performerPOM.SelectLocationWorkspaceNonAdmin().getText();
		   	       Thread.sleep(3000);
		   	       performerPOM. SelectLocationWorkspaceNonAdmin().click();
		   	       
		   	       
		             Thread.sleep(500);
		   	       performerPOM.clickDepartmentFilterWorkspace().click();
		   	       Thread.sleep(500);
		   	       String DeptText = performerPOM.selectDepartmentFilterWorkspacecNonAdmin().getText();
		   	       Thread.sleep(500);
		   	       performerPOM. selectDepartmentFilterWorkspacecNonAdmin().click();
		   	       				        
		   	       Thread.sleep(500);
		   	       performerPOM.clickTypeFilter().click();
		   	       Thread.sleep(500);
		   	       String Typetext = performerPOM.selectDocTypeFilterCA().getText();
		   	       Thread.sleep(500);
		   	       performerPOM.selectDocTypeFilterCA().click();
		   	           
		   	       
		   	        List<String> li=new ArrayList<String>();
		   	        li.add(locationtext);
		   	         li.add(DeptText);
		   	         li.add(Typetext);
		   	        
		   	        Thread.sleep(3000);
		   	        
		   			List<String> filter=new ArrayList<String>();	
		   			filter.add("Location");
		   			filter.add("Dept");
		   			filter.add("Type");
		   			
		   			
		   			 Thread.sleep(500);
		   			 performerPOM.clickTrignle().click();
		   		     Thread.sleep(500);
		   		     performerPOM.clickCol().click();

		   		     
		   		     By dept = By.xpath("//input[@data-field='Department']");
		               wait.until(ExpectedConditions.presenceOfElementLocated(dept));
		   		     Thread.sleep(4000);
		               WebElement ViewButton = getDriver().findElement(dept);	
		   			 Thread.sleep(4000);
		   			 JavascriptExecutor jse=(JavascriptExecutor)getDriver();
		   			 jse.executeScript("arguments[0].click();", ViewButton);

		   			
		   			 Thread.sleep(1000);
		   			js.executeScript("window.scrollBy(0,200)");	
		   		     Thread.sleep(3000);
		   			CFOcountPOM.readTotalItems1().click();					//Clicking on Text of total items just to scroll down.
		   			String s = CFOcountPOM.readTotalItems1().getText();
		   			Thread.sleep(2000);

		   			if(!s.equalsIgnoreCase("No items to display")) {
		   			Thread.sleep(5000);
		   		
		   			List<WebElement> entitycol=getDriver().findElements(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr/td[2]"));
		   			List<WebElement> Dept=getDriver().findElements(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr/td[14]"));
		   			List<WebElement> Type=getDriver().findElements(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr/td[3]"));
		   			
		   			Thread.sleep(2000);

		   			for(int i=0; i<li.size(); i++){
		   				
		   				List<String> text= new ArrayList<String>();
		   				HashSet<String> pass=new LinkedHashSet<>();
		   				HashSet<String> fail=new LinkedHashSet<>();
		   				List<WebElement> raw=new ArrayList<WebElement>();

		   					if(i==0)
		   					{
		   						raw.addAll(entitycol);
		   					}
		   				
		   				   else if(i==1)
		   				   {
		   					 raw.addAll(Dept);
		   				   }
		   				   else if(i==2)
		   				   {
		   					   raw.addAll(Type);
		   				   }
		   				  
		   							
		   				for(int k=0;k<raw.size();k++)
		   					{
		   						text.add(raw.get(k).getText());
		   					}

		   					for(int l=0;l<text.size();l++)
		   					{
		   						
//		   						if(i==2)
//		   						{
//		   							pass.add(text.get(l));	
//		   						}
//		   						else
//		   						{
		   							
		   						
		   					if(text.get(l).equals(li.get(i)))
		   						{
		   						
		   						
		   							pass.add(text.get(l));	
		   							System.out.println("pass : "+text.get(l)+" : "+li.get(i));

		   						}
		   					else
		   					{
		   						fail.add(text.get(l));		
		   						System.out.println("fail : "+text.get(l)+" : "+li.get(i));
		   						System.out.println(i);

		   					}
		   					 }
		   					//}
		   			 
		   		for(String Fal : fail)
		   			 {
		   					test.log(LogStatus.FAIL, filter.get(i)+" column shows incorrect value : "+Fal);
		   			 }	
		   			 for(String Pas : pass)
		   			 {
		   				 test.log(LogStatus.PASS,  filter.get(i)+" dropdown working properly.");
		   					test.log(LogStatus.PASS, filter.get(i)+" displayed : "+Pas);	
		   					System.out.println(filter.get(i)+" : "+Pas);
		   		 }
		   			text.clear();
		   			pass.clear();
		   			fail.clear();
		   			raw.clear();
		   			
		   			
		   			}
		   			}else {
		   				test.log(LogStatus.PASS,"No records found");	
		   			}
		      	}
		          
		   	public static void DocumentFilter(ExtentTest test, String type) throws InterruptedException
		    	{
		   		WebDriverWait wait=new WebDriverWait(getDriver(),20);
				progress();
				 JavascriptExecutor js = (JavascriptExecutor) getDriver();
			
				 performerPOM.clickMyDocument().click();					//Clicking on 'My Document'
				 performerPOM.clickmyDocument().click();	                    //Clicking on 'My Document'
			
				 Thread.sleep(3000);
				 wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));	//Wait until records table gets visible.
			
			
				/* Thread.sleep(3000);
				 performerPOM.clickTypeDropdown().click();
				 Thread.sleep(3000);
				performerPOM.selectTypeNotice().click();*/
			
				/*Thread.sleep(3000);
				performerPOM.clickDocStatusFilter().click();
				Thread.sleep(3000);
				String Statustext =performerPOM.selectDocStatusFilter().getText();
				Thread.sleep(3000);
				performerPOM. selectDocStatusFilter().click();*/
		   

				Thread.sleep(3000);
				performerPOM.clickDocTypeFilter().click();
				Thread.sleep(3000);
				String typetext =performerPOM.selectDocTypeFilterCA().getText();
				Thread.sleep(3000);
				performerPOM. selectDocTypeFilterCA().click();
		     
		     
		     
		  
				Thread.sleep(3000);
				performerPOM.clickDocLocFilter().click();
				Thread.sleep(3000);
				performerPOM.clickExpand().click();
				Thread.sleep(3000);
				String locationtext =performerPOM.SelectLocationWorkspaceNonAdmin().getText();
				Thread.sleep(3000);
				performerPOM. SelectLocationWorkspaceNonAdmin().click();
				Thread.sleep(3000);
				performerPOM.clickDocLocFilter().click();
		       
			    List<String> li=new ArrayList<String>();
		        // li.add(Statustext);
		         li.add(typetext);
		         li.add(locationtext);
		        
				List<String> filter=new ArrayList<String>();	
				//filter.add("Status");
				filter.add("Type");
				filter.add("Loaction");
			
				 
				  By Tringle = By.xpath("//span[@class='k-icon k-i-more-vertical']");
		          wait.until(ExpectedConditions.presenceOfElementLocated(Tringle));
				  Thread.sleep(4000);
		          WebElement ViewButton = getDriver().findElement(Tringle);	
				  Thread.sleep(4000);
				  JavascriptExecutor jse=(JavascriptExecutor)getDriver();
				  jse.executeScript("arguments[0].click();", ViewButton);
			     
				 Thread.sleep(3000);
			     performerPOM.clickCol().click();

			     
			     By dept = By.xpath("//input[@data-field='Status']");
		         wait.until(ExpectedConditions.presenceOfElementLocated(dept));
			     Thread.sleep(4000);
		         WebElement ViewButton1 = getDriver().findElement(dept);	
				 Thread.sleep(4000);
				 JavascriptExecutor jse1=(JavascriptExecutor)getDriver();
				 jse1.executeScript("arguments[0].click();", ViewButton1);
			    
				
				js.executeScript("window.scrollBy(0,150)");	
				Thread.sleep(3000);

				CFOcountPOM.readTotalItems1().click();					//Clicking on Text of total items just to scroll down.
				String s = CFOcountPOM.readTotalItems1().getText();
				Thread.sleep(2000);

				if(!s.equalsIgnoreCase("No items to display")) {
				Thread.sleep(5000);
			
				//List<WebElement> statuscol=getDriver().findElements(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr/td[13]"));
				List<WebElement> Type=getDriver().findElements(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr/td[4]"));
				List<WebElement> Location=getDriver().findElements(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr/td[3]"));
				
				Thread.sleep(2000);

				for(int i=0; i<li.size(); i++){
					
					List<String> text= new ArrayList<String>();
					HashSet<String> pass=new LinkedHashSet<>();
					HashSet<String> fail=new LinkedHashSet<>();
					List<WebElement> raw=new ArrayList<WebElement>();

//						if(i==0)
//						{
//							raw.addAll(statuscol);
//						}
					
					  if(i==0)
					   {
						 raw.addAll(Type);
					   }
					   else if(i==1)
					   {
						   raw.addAll(Location);
					   }
					  
								
					for(int k=0;k<raw.size();k++)
						{
							text.add(raw.get(k).getText());
						}

						for(int l=0;l<text.size();l++)
						{
							
//							if(i==2)
//							{
//								pass.add(text.get(l));	
//							}
//							else
//							{
								
							
						if(text.get(l).equals(li.get(i)))
							{
							
							
								pass.add(text.get(l));	
								System.out.println("pass : "+text.get(l)+" : "+li.get(i));

							}
						else
						{
							fail.add(text.get(l));		
							System.out.println("fail : "+text.get(l)+" : "+li.get(i));
							System.out.println(i);

						}
						 }
						//}
				 
			for(String Fal : fail)
				 {
						test.log(LogStatus.FAIL, filter.get(i)+" column shows incorrect value : "+Fal);
				 }	
				 for(String Pas : pass)
				 {
					 test.log(LogStatus.PASS,  filter.get(i)+" dropdown working properly.");
						test.log(LogStatus.PASS, filter.get(i)+" displayed : "+Pas);	
						System.out.println(filter.get(i)+" : "+Pas);
			 }
				text.clear();
				pass.clear();
				fail.clear();
				raw.clear();
				
				
				}
				}else {
					test.log(LogStatus.PASS,"No records found");	
				}
		    	}
		      	
		   	public static void ReportFilter(ExtentTest test, String type) throws InterruptedException
		    	{
		    		WebDriverWait wait=new WebDriverWait(getDriver(),20);
				performerPOM.clickMyReports().click();					//Clicking on 'My Reports'
				
				Thread.sleep(500);
				wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));	//Wait until records table gets visible.
				
				 JavascriptExecutor js = (JavascriptExecutor) getDriver();
					js.executeScript("window.scrollBy(0,-150)");	
				
				Thread.sleep(3000);
				performerPOM.clickReportStatusFilter().click();
				//Thread.sleep(3000);
		       // String Statustext =performerPOM.selectReportStatusFilter().getText();
		        Thread.sleep(3000);
		         performerPOM. selectReportStatusFilter().click();
		       
			
		         Thread.sleep(3000);
				performerPOM.clickReportDeptFilter().click();
				Thread.sleep(3000);
			    String depttext =performerPOM.selectDepartmentFilterDocNonAdmin().getText();
			    Thread.sleep(3000);
			     performerPOM. selectDepartmentFilterDocNonAdmin().click();
		         
			     Thread.sleep(3000);
					performerPOM.clickReportTypeFilter().click();
					Thread.sleep(3000);
				    String typetext =performerPOM.selectDocTypeFilterCA().getText();
				    Thread.sleep(3000);
				     performerPOM. selectDocTypeFilterCA().click();
			         
		         
		         
		      
				    Thread.sleep(3000);
					performerPOM.clickReportLocFilter().click();
					Thread.sleep(3000);
					performerPOM.clickExpand().click();
					Thread.sleep(3000);
			       String locationtext =performerPOM.SelectLocationWorkspaceNonAdmin().getText();
			       Thread.sleep(3000);
			       performerPOM. SelectLocationWorkspaceNonAdmin().click();
			      
					Thread.sleep(3000);
					performerPOM.clickReportFYFilter().click();
					Thread.sleep(3000);
				    String FYtext =performerPOM.selectReportFYFilter().getText();
				    Thread.sleep(3000);
				     performerPOM. selectReportFYFilter().click();
			       
			        List<String> li=new ArrayList<String>();
			        // li.add(Statustext);
			         li.add(depttext);
			         li.add(typetext);
			         li.add(locationtext);
			         li.add(FYtext);
			        
					List<String> filter=new ArrayList<String>();	
					//filter.add("Status");
					filter.add("Dept");
					filter.add("Type");
					filter.add("Loaction");
					filter.add("FY");
				
					js.executeScript("window.scrollBy(0,200)");	
					CFOcountPOM.readTotalItems1().click();					//Clicking on Text of total items just to scroll down.
					String s = CFOcountPOM.readTotalItems1().getText();
					Thread.sleep(2000);

					if(!s.equalsIgnoreCase("No items to display"))
					{
					Thread.sleep(3000);
				
					//List<WebElement> statuscol=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[4]"));
					List<WebElement> deptcol=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[7]"));
					List<WebElement> typecol=getDriver().findElements(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr/td[3]"));
					List<WebElement> loctioncol=getDriver().findElements(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr/td[2]"));
					List<WebElement> FYcol=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[14]"));
					
					js.executeScript("document.querySelector(\"div[id='grid'] div[class='k-grid-content k-auto-scrollable']\").scrollLeft=400");
					
					Thread.sleep(2000);
		            for(int i=0; i<li.size(); i++)
					{
						
						List<String> text= new ArrayList<String>();
						HashSet<String> pass=new LinkedHashSet<>();
						HashSet<String> fail=new LinkedHashSet<>();
						List<WebElement> raw=new ArrayList<WebElement>();

//							if(i==0)
//							{
//								raw.addAll(statuscol);
//							}
							 if(i==0)
							{
								raw.addAll(deptcol);
							}
						   else if(i==1)
						   {
							 raw.addAll(typecol);
						   }
						   else if(i==2)
						   {
							   raw.addAll(loctioncol);
						   }
						   else if(i==3)
						   {
							   Thread.sleep(5000);
							   js.executeScript("document.querySelector(\"div[id='grid'] div[class='k-grid-content k-auto-scrollable']\").scrollLeft=5000");
							   raw.addAll(FYcol);
						   }
									
						for(int k=0;k<raw.size();k++)
							{
								text.add(raw.get(k).getText());
							}

							for(int l=0;l<text.size();l++)
							{	
								
							if(text.get(l).equals(li.get(i)))
								{
								
								
									pass.add(text.get(l));	
									System.out.println("pass : "+text.get(l)+" : "+li.get(i));

								}
							else
							{
								fail.add(text.get(l));		
								System.out.println("fail : "+text.get(l)+" : "+li.get(i));
								System.out.println(i);

							}
							 }
						
					 
				for(String Fal : fail)
					 {
							test.log(LogStatus.FAIL, filter.get(i)+" column shows incorrect value : "+Fal);
					 }	
					 for(String Pas : pass)
					 {
						 test.log(LogStatus.PASS,  filter.get(i)+" dropdown working properly.");
							test.log(LogStatus.PASS, filter.get(i)+" displayed : "+Pas);	
							System.out.println(filter.get(i)+" : "+Pas);
				 }
					text.clear();
					pass.clear();
					fail.clear();
					raw.clear();
					
					
					}
					}else {
						test.log(LogStatus.PASS,"No records found");	
					}
		    		
		    		
		    		
		       }
		      	public static void CaseClosed( ExtentTest test, XSSFWorkbook workbook, String login) throws InterruptedException, IOException
		    	{
		    		WebDriverWait wait = new WebDriverWait(getDriver(), 50);
		    		
		    		CountExcel( test, "Case - Closed");
		    		
		    		Thread.sleep(500);
		    		wait.until(ExpectedConditions.visibilityOf(performerPOM.clickNew()));
		    		OverduePOM.clickDashboard().click();			//Clicking on 'Dashboard'
		    	}
		      	public static void NoticeClosed( ExtentTest test, XSSFWorkbook workbook, String login) throws InterruptedException, IOException
		    	{
		    		WebDriverWait wait = new WebDriverWait(getDriver(), 50);
		    		
		    		CountExcel( test, "Notice - Closed");
		    		
		    		Thread.sleep(500);
		    		wait.until(ExpectedConditions.visibilityOf(performerPOM.clickNew()));
		    		
		    		Thread.sleep(1000);
		    		OverduePOM.clickDashboard().click();			//Clicking on 'Dashboard'
		    	}
		      	
		      	 public static void NoticeWithExistingData( ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException
		 		{
		 			sheet = workbook.getSheetAt(6);		
		         	
		 			WebDriverWait wait1 = new WebDriverWait(getDriver(), 300);
		 			progress();
		 			
		 			Thread.sleep(500);
		 			JavascriptExecutor js = (JavascriptExecutor) getDriver();
		             js.executeScript("window.scrollBy(0,-700)");
		             Thread.sleep(500);
		         	performerPOM.clickNoticeOpen().click();		
		 			
		             Thread.sleep(4000);
		 			clickNewNotice();
		 			
		 			wait1.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
		 			
		 			 Thread.sleep(4000);
		 			selectNoticeType();
		 			Thread.sleep(3000);
		 			clickDated();

		 			Thread.sleep(3000);
		 			clickFinancialYear();

		 			Thread.sleep(3000);
		 			clickRefNo();
		 			

		 			Thread.sleep(3000);
		 			selectCategory();

		 			Thread.sleep(3000);
		 			clickAct();

		 			Thread.sleep(3000);
		 			selectOpponent();

		 			Thread.sleep(3000);
		 			selectCategory();

		 			Thread.sleep(3000);
		 			clickNoticeTitle();

		 			Thread.sleep(3000);
		 			clickNoticeDescription();

		 			Thread.sleep(3000);
		 			selectLocation();

		 			Thread.sleep(3000);
		 			clickDepartment();

		 			Thread.sleep(3000);
		 			clickOwner();

		 			Thread.sleep(3000);
		             selectRisk();

		 			Thread.sleep(3000);
		             selectNoticeRecipetDate();
		             
		             Thread.sleep(5000);
		             clickInternalUser();
		             
		             Thread.sleep(3000);
		     		performerPOM.selectNoticeUploadDocument(); 
		     		
		        	 	Thread.sleep(3000);
		     		OverduePOM.clickSaveButton().click();		
		     		
		     		Thread.sleep(1000);
		     		wait1.until(ExpectedConditions.visibilityOf(performerPOM.readMessage()));
		     		
		     		Thread.sleep(2000);
		     		String msg = performerPOM.readMessage().getText();		//Reading Message appeared after save button
		     		
		     		if(msg.equalsIgnoreCase("Notice with Same Reference No. already exists"))
		     		{
		     			test.log(LogStatus.PASS, "Message displayed = "+msg);
		     		
		     		}
		     		else
		     		{
		     			test.log(LogStatus.PASS, "Message displayed = "+msg);
		     		}
		     		
		     		Thread.sleep(3000);
		     		getDriver().switchTo().parentFrame();
		     		performerPOM.clickClose().click();//Clicking on 'Close'
		     		
		     		Thread.sleep(3000);
		     		OverduePOM.clickDashboard().click();
		     		
		   }
		 	  
		 	     public static void NoticeWithInvalidData( ExtentTest test, XSSFWorkbook workbook) throws InterruptedException, IOException
		 	 		{
		 	 		   
		 	        	 //sheet = workbook.getSheetAt(6);					//Retrieving second sheet of Workbook
		 	 			WebDriverWait wait1 = new WebDriverWait(getDriver(), 300);
		 	 			progress();
		 	 			
		 	 			Thread.sleep(500);
		 	 			JavascriptExecutor js = (JavascriptExecutor) getDriver();
		 	            js.executeScript("window.scrollBy(0,-700)");
		 	            Thread.sleep(500);
		 	        	performerPOM.clickNoticeOpen().click();		
		 	 			
		 	             Thread.sleep(4000);
		 	 			clickNewNotice();
		 	 			
		 	 			wait1.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
		 	 			
		 	 			
		 	 			
		 	 			Thread.sleep(3000);
		 	 			clickDated();

		 	 			Thread.sleep(3000);
		 	 			clickFinancialYear();

		 	 			Thread.sleep(3000);
		 	 			clickRefNo();

		 	 			Thread.sleep(3000);
		 	 			selectNoticeType();

		 	 			Thread.sleep(3000);
		 	 			clickAct();

		 	 			Thread.sleep(3000);
		 	 			clickOpponentcfo();

		 	 			Thread.sleep(3000);
		 	 			selectCategory();

		 	 			Thread.sleep(3000);
		 	 			clickNoticeTitle();

		 	 			Thread.sleep(3000);
		 	 			clickNoticeDescription();

		 	 			Thread.sleep(5000);
		 	 			selectLocation();

		 	 			Thread.sleep(3000);
		 	 			clickDepartment();

		 	 			Thread.sleep(3000);
		 	 			clickOwner();

		 	 			Thread.sleep(3000);
		 	             selectRisk();

		 	 			Thread.sleep(3000);
		 	            selectNoticeRecipetDate1();
		 	             
		 	            Thread.sleep(3000);
		 	            clickInternalUser();
		 	             
		 	            Thread.sleep(6000);
		 	     		performerPOM.selectNoticeUploadDocument(); 
		 	     		
		 	        		
		 	        	Thread.sleep(6000);
		 	     		OverduePOM.clickSaveButton().click();		
		 	     		
		 	     		Thread.sleep(1000);
		 	     		wait1.until(ExpectedConditions.visibilityOf(performerPOM.readMessage()));
		 	     		
		 	     		Thread.sleep(2000);
		 	     		String msg = performerPOM.readMessage().getText();		//Reading Message appeared after save button
		 	     		
		 	     		if(msg.equalsIgnoreCase(msg))
		 	     		{
		 	     			test.log(LogStatus.PASS, "Message displayed = "+msg);
		 	     		
		 	     		}
		 	     		else
		 	     		{
		 	     			test.log(LogStatus.FAIL, "Message displayed = "+msg);
		 	     		}
		 	     		Thread.sleep(3000);
		 	     		getDriver().switchTo().parentFrame();
		 	     		performerPOM.clickClose().click();//Clicking on 'Close'
		 	     		
		 	     		Thread.sleep(3000);
		 	     		OverduePOM.clickDashboard().click();
		 	     		}
		 	    		
		 	 			public  static void selectNoticeRecipetDate1()
		 	 		      {
		 	 		    	 	
		 	 		          WebElement openDate= performerPOM.selectNoticeRecipetDate();
		 	 		          openDate.sendKeys("30-09-202");
		 	 		        
		 	 		      }
		 	 			
		 	 			  public static void NoticeWithTwoMandatoryData( ExtentTest test, XSSFWorkbook workbook) throws InterruptedException, IOException
		 	 	 	 	 {
		 	 	 	 	 		   
		 	 	 	 	        	// sheet = workbook.getSheetAt(6);					//Retrieving second sheet of Workbook
		 	 	 	 	 			WebDriverWait wait1 = new WebDriverWait(getDriver(), 300);
		 	 	 	 	 			progress();
		 	 	 	 	 			
		 	 	 	 	 			Thread.sleep(500);
		 	 	 	 	 			JavascriptExecutor js = (JavascriptExecutor) getDriver();
		 	 	 	 	            js.executeScript("window.scrollBy(0,-700)");
		 	 	 	 	            Thread.sleep(500);
		 	 	 	 	        	performerPOM.clickNoticeOpen().click();		
		 	 	 	 	 			
		 	 	 	 	             Thread.sleep(4000);
		 	 	 	 	 			clickNewNotice();
		 	 	 	 	 			
		 	 	 	 	 			wait1.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
		 	 	 	 	 			
		 	 	 	 	 			
		 	 	 	 	 			
		 	 	 	 	 			Thread.sleep(3000);
		 	 	 	 	 			clickDated();

		 	 	 	 	 			Thread.sleep(3000);
		 	 	 	 	 			clickFinancialYear();
		 	 	 	 	 			
		 	 	 	 	 			Thread.sleep(3000);
		 	 	 	 	     		OverduePOM.clickSaveButton().click();		
		 	 	 	 	     		
		 	 	 	 	     		Thread.sleep(1000);
		 	 	 	 	     		wait1.until(ExpectedConditions.visibilityOf(performerPOM.readMessage()));
		 	 	 	 	     		
		 	 	 	 	     		Thread.sleep(2000);
		 	 	 	 	     		String msg = performerPOM.readInvalidMessage().getText();		//Reading Message appeared after save button
		 	 	 	 	     		
		 	 	 	 	     	
		 	 	 	 	     		test.log(LogStatus.PASS, "Message displayed = "+msg);
		 	 	 	 	     		
		 	 	 	 	     		
		 	 	 	 	 
		 	 	 	 	     		Thread.sleep(3000);
		 	 	 	 	     		getDriver().switchTo().parentFrame();
		 	 	 	 	     		performerPOM.clickClose().click();//Clicking on 'Close'
		 	 	 	 	     		
		 	 	 	 	     		Thread.sleep(3000);
		 	 	 	 	     		OverduePOM.clickDashboard().click();
		 	 	 	 	 }

		 	 			 public static void NoticeWithEmptyFields( ExtentTest test) throws InterruptedException, IOException
		  	 	 	 	 {
		  	 	 	 	 		   
		  	 	 	 	        	
		  	 	 	 	 			WebDriverWait wait1 = new WebDriverWait(getDriver(), 300);
		  	 	 	 	 			progress();
		  	 	 	 	 			
		  	 	 	 	 			Thread.sleep(500);
		  	 	 	 	 			JavascriptExecutor js = (JavascriptExecutor) getDriver();
		  	 	 	 	            js.executeScript("window.scrollBy(0,-700)");
		  	 	 	 	            Thread.sleep(500);
		  	 	 	 	        	performerPOM.clickNoticeOpen().click();		
		  	 	 	 	 			
		  	 	 	 	             Thread.sleep(4000);
		  	 	 	 	 			clickNewNotice();
		  	 	 	 	 			
		  	 	 	 	 			wait1.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
		  	 	 	 	 			
		  	 	 	 	 		
		  	 	 	 	 			Thread.sleep(3000);
		  	 	 	 	     		OverduePOM.clickSaveButton().click();		
		  	 	 	 	     		
		  	 	 	 	     		Thread.sleep(1000);
		  	 	 	 	     		wait1.until(ExpectedConditions.visibilityOf(performerPOM.readMessage()));
		  	 	 	 	     		
		  	 	 	 	     		Thread.sleep(2000);
		  	 	 	 	     		String msg = performerPOM.readInvalidMessage().getText();		//Reading Message appeared after save button
		  	 	 	 	     		
		  	 	 	 	     	
		  	 	 	 	     		test.log(LogStatus.PASS, "Message displayed = "+msg);
		  	 	 	 	     		
		  	 	 	 	     		
		  	 	 	 	 
		  	 	 	 	     		Thread.sleep(3000);
		  	 	 	 	     		getDriver().switchTo().parentFrame();
		  	 	 	 	     		performerPOM.clickClose().click();//Clicking on 'Close'
		  	 	 	 	     		
		  	 	 	 	     		Thread.sleep(3000);
		  	 	 	 	     		OverduePOM.clickDashboard().click();
		  	 	 	 	 }
		 	 			 
		 	 			  public static void NoticeClearBtn( ExtentTest test) throws InterruptedException, IOException
		 		 	 	 	 {
		 		 	 	 	 		   
		 		 	 	 	        	 
		 		 	 	 	 			WebDriverWait wait1 = new WebDriverWait(getDriver(), 300);
		 		 	 	 	 			progress();
		 		 	 	 	 			
		 		 	 	 	 			Thread.sleep(500);
		 		 	 	 	 			JavascriptExecutor js = (JavascriptExecutor) getDriver();
		 		 	 	 	            js.executeScript("window.scrollBy(0,-700)");
		 		 	 	 	            Thread.sleep(500);
		 		 	 	 	        	performerPOM.clickNoticeOpen().click();		
		 		 	 	 	 			
		 		 	 	 	             Thread.sleep(4000);
		 		 	 	 	 			clickNewNotice();
		 		 	 	 	 			
		 		 	 	 	 			wait1.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
		 		 	 	 	 		    Thread.sleep(3000);
		 		 	 	 			    clickDated();

		 		 	 	 		     	 Thread.sleep(3000);
		 		 	 	 			     clickFinancialYear();
		 		 	 	 	 		 
		 		 	 	 	 			
		 		 	 	 	     	      Thread.sleep(2000);
		 		 	 	 	             if(performerPOM.clickNoticeClearBtn().isEnabled())
		 		 	 			          {
		 		 	 			            Thread.sleep(2000);
		 		 	 			              performerPOM.clickNoticeClearBtn().click();
		 		 	 			              test.log(LogStatus.PASS, "Clear Button is clickable");
		 		 	 			           }
		 		 	 			         else
		 		 	 			         {
		 		 	 			    	   test.log(LogStatus.FAIL, "Clear Button is not clickable");
		 		 	 			         }
		 		 	 	 	 
		 		 	 	 	     		Thread.sleep(3000);
		 		 	 	 	     		getDriver().switchTo().parentFrame();
		 		 	 	 	     		performerPOM.clickClose().click();//Clicking on 'Close'
		 		 	 	 	     		
		 		 	 	 	     		Thread.sleep(3000);
		 		 	 	 	     		OverduePOM.clickDashboard().click();
		 		 	 	 	 }
		 	 			  
		 	 			 public static void NoticeSendMailWithDoc( ExtentTest test) throws InterruptedException, IOException
		 	 	 	 	 {
		 	 	 	 	 		  
		 	 	 	 	 			WebDriverWait wait = new WebDriverWait(getDriver(), 300);
		 	 	 	 	 			progress();
		 	 	 	 	 	
		 	 	 	 	            Thread.sleep(500);
		 	 	 	 	        	performerPOM.clickNoticeOpen().click();		
		 	 	 	 	 			
		 	 	 	 	        	
		 	 	 	 	        	Thread.sleep(1000);
		 			 				wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
		 			 			/*	Thread.sleep(3000);
		 	 	 	 	        	performerPOM.clickTrignle1().click();		
		 	 	 	 	 			
		 			 				
		 	 	 	 	        	Thread.sleep(3000);
		 	 	 	 	        	performerPOM.clickFilter().click();		
		 	 	 	 	        	
		 	 	 	 	        	Thread.sleep(2000);
		 	 	 	 	     		wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
		 	 	 	 	 			
		 			 				
		 	 	 	 	        	Thread.sleep(5000);
		 	 	 	 	        	performerPOM.clickSearchFilterworkspace().sendKeys("12344");	
		 	 	 	 	        	
		 	 	 	 	        	Thread.sleep(5000);
		 	 	 	 	     		performerPOM.clickCheckbox().click();	
		  	 	 	        	
		 	 	 	 	        	
		 	 	 	 	        	Thread.sleep(5000);
		 	 	 	 	        	performerPOM.clickFilter1().click();	*/
		 	 	 	 	        	
		 	 	 	 	        	
		 	 	 	 	 			
		 	 	 	 	             Thread.sleep(4000);
		 	 	 	 	         
		 	 	 			      	performerPOM.clickEditNotice().click();
		 	 	 	 	 			
		 	 	 	 	 			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
		 	 	 	 	 			
		 	 	 	 	 		   Thread.sleep(4000);
		 	 	 	 	 		   performerPOM.clickSendMail().click();
		 	 	 	 	 		   
		 	 	 	 	 		 Thread.sleep(4000);
		 		 	 	 		 performerPOM.clickSelectCheckbox().click();
		 		 	 	 		 
		 		 	 	 		 Thread.sleep(4000);
		 		 	 	 		 performerPOM.clickMailTo().sendKeys("admin@gmail.com");
		 		 	 	 		 
		 		 	 	 		 Thread.sleep(4000);
		 		 	 	 		 performerPOM.clickMessageMail().sendKeys("Test");
		 		 	 	 		 
		 		 	 	 		 
		 		 	 	 		 Thread.sleep(4000);
		 		 	 	 		 performerPOM.clickSend().click();
		 		 	 	 		 
		 		 	 	 		Thread.sleep(4000);
		 		 	 	 		String msg= performerPOM.clickSendMailMsg().getText();
		 		 	 	 		
		 		 	 	 		if(msg.equalsIgnoreCase("E-Mail Sent Successfully."))
		 		 	 	 		{
		 		 	 	 			test.log(LogStatus.PASS ,"Message displayed =" +msg);
		 		 	 	 		}
		 		 	 	 		else
		 		 	 	 		{
		 		 	 	 			test.log(LogStatus.FAIL ,"Message displayed =" +msg);
		 		 	 	 		}
		 		 	 	 		
		 		 	 			Thread.sleep(3000);
		 		 	 	     
		 		 	 	     	performerPOM.clickcloseBtn().click();//Clicking on 'Close'
		 		 	 	     	Thread.sleep(3000);
		 		 	 	     	getDriver().switchTo().parentFrame();
		 		 	 	     	performerPOM.clickClose().click();//Clicking on 'Close'
		 		 	 	     	
		 		 	 	     	Thread.sleep(3000);
		 		 	 	     	OverduePOM.clickDashboard().click(); 
		 	 	 	 	 }
		 	 			 
		 	 			 public static void NoticeSendMailWithDocInvalidFields( ExtentTest test) throws InterruptedException, IOException
		 	 	 	 	 {
		 	 	 	 	 		   
		 	 	 	 	        	
		 	 	 	 	 			WebDriverWait wait = new WebDriverWait(getDriver(), 300);
		 	 	 	 	 			progress();
		 	 	 	 	 			
		 	 	 	 	 		
		 	 	 	 	 			
		 	 	 	 	            Thread.sleep(500);
		 	 	 	 	        	performerPOM.clickNoticeOpen().click();	
		 	 	 	 	        	
		 	 	 	 	        	
		 	 	 	 	        	Thread.sleep(1000);
		 	 	 	 	        	wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
		 	 	 	 	        	/*Thread.sleep(3000);
		 	 	 	 	        	performerPOM.clickTrignle1().click();		
		  	 	 	 			
		 	 	 	 	        	
		 	 	 	 	        	Thread.sleep(3000);
		 	 	 	 	        	performerPOM.clickFilter().click();		
		  	 	 	        	
		 	 	 	 	        	Thread.sleep(2000);
		 	 	 	 	        	wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
		  	 	 	 			
		 		 				
		 	 	 	 	        	Thread.sleep(6000);
		 	 	 	 	        	performerPOM.clickSearchFilterworkspace().sendKeys("12344");	
		  	 	 	        	
		 	 	 	 	        	Thread.sleep(5000);
		 	 	 	 	        	performerPOM.clickCheckbox().click();	
		 	 	 	        	
		  	 	 	        	
		 	 	 	 	        	Thread.sleep(5000);
		 	 	 	 	        	performerPOM.clickFilter1().click();	*/
		 	 	 	 	        	
		 	 	 	 	       
		 	 	 	 	             Thread.sleep(4000);
		 	 	 	 	         
		 	 	 			      	performerPOM.clickEditNotice().click();
		 	 	 	 	 			
		 	 	 	 	 			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
		 	 	 	 	 			
		 	 	 	 	 		   Thread.sleep(4000);
		 	 	 	 	 		   performerPOM.clickSendMail().click();
		 	 	 	 	 		   
		 	 	 	 	 		 Thread.sleep(4000);
		 		 	 	 		 performerPOM.clickSelectCheckbox().click();
		 		 	 	 		 
		 		 	 	 		 Thread.sleep(4000);
		 		 	 	 		 performerPOM.clickMailTo().sendKeys("admin");
		 		 	 	 		 
		 		 	 	 		 Thread.sleep(4000);
		 		 	 	 		 performerPOM.clickMessageMail().sendKeys("Test");
		 		 	 	 		 
		 		 	 	 		 
		 		 	 	 		 Thread.sleep(4000);
		 		 	 	 		 performerPOM.clickSend().click();
		 		 	 	 		 
		 		 	 	 		Thread.sleep(4000);
		 		 	 	 		String msg= performerPOM.clickSendMailMsg().getText();
		 		 	 	 		
		 		 	 	 		if(msg.equalsIgnoreCase("Please enter a valid email."))
		 		 	 	 		{
		 		 	 	 			test.log(LogStatus.PASS ,"Message displayed =" +msg);
		 		 	 	 		}
		 		 	 	 		else
		 		 	 	 		{
		 		 	 	 			test.log(LogStatus.FAIL ,"Message displayed =" +msg);
		 		 	 	 		}
		 		 	 	 		
		 		 	 			Thread.sleep(3000);
		 		 	 	     
		 		 	 	     	performerPOM.clickcloseBtn().click();//Clicking on 'Close'
		 		 	 	     	Thread.sleep(3000);
		 		 	 	     		getDriver().switchTo().parentFrame();
		 		 	 	     		performerPOM.clickClose().click();//Clicking on 'Close'
		 		 	 	     	
		 		 	 	     	Thread.sleep(3000);
		 		 	 	     		OverduePOM.clickDashboard().click();
		 	 	 	 	 
		 	 	 	 	 }
		 	 			 public static void NoticeSendMailWithDocEmptyFields( ExtentTest test) throws InterruptedException, IOException
		 	 	 	 	 {
		 	 	 	 	 		   
		 	 	 	 	        	
		 	 	 	 	 			WebDriverWait wait = new WebDriverWait(getDriver(), 300);
		 	 	 	 	 			progress();	
		 	 	 	 	            Thread.sleep(500);
		 	 	 	 	        	performerPOM.clickNoticeOpen().click();	
		 	 	 	 	        	
		 	 	 	 	        	
		 	 	 	 	       	Thread.sleep(1000);
		  	 	 	        	wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
		  	 	 	        	/*Thread.sleep(3000);
		  	 	 	        	performerPOM.clickTrignle1().click();		
		 	 	 	 			
		  	 	 	        	
		  	 	 	        	Thread.sleep(3000);
		  	 	 	        	performerPOM.clickFilter().click();		
		 	 	 	        	
		  	 	 	        	Thread.sleep(2000);
		  	 	 	        	wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
		 	 	 	 			
		 	 				
		  	 	 	        	Thread.sleep(5000);
		  	 	 	        	performerPOM.clickSearchFilterworkspace().sendKeys("12344");	
		 	 	 	        	
		  	 	 	        	Thread.sleep(5000);
		  	 	 	        	performerPOM.clickCheckbox().click();	
		  	 	        	
		 	 	 	        	
		  	 	 	        	Thread.sleep(5000);
		  	 	 	        	performerPOM.clickFilter1().click();	*/
		 	 	 	 	        	
		 	 	 	 	        	
		 	 	 	 	        	Thread.sleep(6000);
		 	 	 	 	         
		 	 	 			      	performerPOM.clickEditNotice().click();
		 	 	 	 	 			
		 	 	 	 	 			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
		 	 	 	 	 			
		 	 	 	 	 		   Thread.sleep(4000);
		 	 	 	 	 		   performerPOM.clickSendMail().click();
		 	 	 	 	 		   
		 	 	 	 	 		 Thread.sleep(4000);
		 		 	 	 		 performerPOM.clickSelectCheckbox().click();
		 		 	 	 		 
		 		 	 	 		
		 		 	 	 		 
		 		 	 	 		 Thread.sleep(4000);
		 		 	 	 		 performerPOM.clickSend().click();
		 		 	 	 		 
		 		 	 	 		Thread.sleep(4000);
		 		 	 	 		String msg= performerPOM.clickSendMailMsg1().getText();
		 		 	 	 		
		 		 	 	 		
		 		 	 	 			test.log(LogStatus.PASS ,"Message displayed =" +msg);
		 		 	 	 		
		 		 	 	 		
		 		 	 			Thread.sleep(3000);
		 		 	 	     
		 		 	 	     	performerPOM.clickcloseBtn().click();//Clicking on 'Close'
		 		 	 	     	Thread.sleep(3000);
		 		 	 	     		getDriver().switchTo().parentFrame();
		 		 	 	     		performerPOM.clickClose().click();//Clicking on 'Close'
		 		 	 	     	
		 		 	 	     	Thread.sleep(3000);
		 		 	 	     		OverduePOM.clickDashboard().click();
		 	 	 	 	 
		 	 	 	 	 }
		 	 			 
		 	 			 public static void NoticeUserAssignment( ExtentTest test) throws InterruptedException, IOException
		 	 	 	 	 {
		 	 	 	 	 		     
		 	 	 	 	 			WebDriverWait wait = new WebDriverWait(getDriver(), 300);
		 	 	 	 	            Thread.sleep(500);
		 	 	 	 	        	performerPOM.clickNoticeOpen().click();	
		 	 	 	 	        	
		 	 	 	 	        	
		 	 	 	 	       	Thread.sleep(5000);
		  	 	 	        	wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
		  	 	 	        	/*Thread.sleep(3000);
		  	 	 	        	performerPOM.clickTrignle1().click();		
		 	 	 	 			
		  	 	 	        	
		  	 	 	        	Thread.sleep(3000);
		  	 	 	        	performerPOM.clickFilter().click();		
		 	 	 	        	
		  	 	 	        	Thread.sleep(2000);
		  	 	 	        	wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
		 	 	 	 			
		 	 				
		  	 	 	        	Thread.sleep(5000);
		  	 	 	        	performerPOM.clickSearchFilterworkspace().sendKeys("12344");	
		 	 	 	        	
		  	 	 	        	Thread.sleep(5000);
		  	 	 	        	performerPOM.clickCheckbox().click();	
		  	 	        	
		 	 	 	        	
		  	 	 	        	Thread.sleep(5000);
		  	 	 	        	performerPOM.clickFilter1().click();	*/
		 	 	 	 	        	
		 	 	 	 	        	
		 	 	 	 	 			
		 	 	 	 	            Thread.sleep(4000);
		 	 	 	 	            performerPOM.clickEditNotice().click();
		 	 	 	 	            
//		 	 	 	 	         Thread.sleep(4000);
//		 	 	 	 	            performerPOM.clickEditNotice1().click();
		 	 	 	 	            
		 	 	 	 	            try
		 	 	 	 	            {
		 	 	 	 	            	Thread.sleep(4000);
		 	 	 	 	              	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
		 	 	 	 	 			
		 	 	 	 	 	            Thread.sleep(4000);
		 		 	 	                 performerPOM.clickEditUserAssign().click();
		 		 	 	                 
		 		 	 	                  Thread.sleep(3000);
		 		 	 	                performerPOM.clickInternalUser().click();	
		 		 	 	                Thread.sleep(3000);
		 		 	 	                elementsList = performerPOM.chooseInternalUser();
		 		 	 	    		   elementsList.get(5).click();							//Selecting particular user no
		 		 	 	    		   performerPOM.clickInternalUser().click();	//Clicking on 'Internal User' drop down.
		 		 	                   Thread.sleep(3000);
		 		 	 	               performerPOM.clickSaveCriteria().click();   //Click Update Btn
		 		 	             
		 	 	 	 	    		
		 	 	 	 	    		   String msg = performerPOM.readMessage().getText();		//Reading Message appeared after save button
		 	 	 	 	    		   Thread.sleep(3000);
		 	 	 	 	    		   if(msg.equalsIgnoreCase("Notice Details Updated Successfully."))
		 	 	 	 	    		   {
		 	 	 	 	    			 test.log(LogStatus.PASS, "Message displayed = "+msg);
		 	 	 	 	    			
		 	 	 	 	    		   }
		 	 	 	 	    		  else
		 	 	 	 	    		  {
		 	 	 	 	    			 test.log(LogStatus.FAIL, "Message displayed = "+msg);
		 	 	 	 	    		   }
		 	 	 	 	    	
		 	 	 	 	            } 
		 	 	 	 	            
		 	 	 	 	       catch(Exception e)
		 	 	 	 	       {
		 	 	 	 	            test.log(LogStatus.PASS, "Record not displayed in Notice-User assignment");
		 	 	 	 	       }
		 	 	 	 	            	   
		 	 	 	            
		 	 	 	      	    Thread.sleep(3000);
		 	 	 	     		getDriver().switchTo().parentFrame();
		 	 	 	     		performerPOM.clickClose().click();//Clicking on 'Close'
		 	 	 	          
		 	 	 	     	    Thread.sleep(3000);
		 	 	 	     		OverduePOM.clickDashboard().click();
		 	 	 	    }
		 	 			 
		 	 	 public static void NoticeDeleteUserAssignment( ExtentTest test) throws InterruptedException, IOException
		 	 	 	 {
		 	 	 	 	 		     
		 	 	 	 	 			WebDriverWait wait = new WebDriverWait(getDriver(), 300);
		 	 	 	 	            Thread.sleep(500);
		 	 	 	 	        	performerPOM.clickNoticeOpen().click();	
		 	 	 	 	        	
		 	 	 	 	        	
		 	 	 	 	       	Thread.sleep(4000);
		  	 	 	        	wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
		  	 	 	        	/*Thread.sleep(3000);
		  	 	 	        	performerPOM.clickTrignle1().click();		
		 	 	 	 			
		  	 	 	        	
		  	 	 	        	Thread.sleep(3000);
		  	 	 	        	performerPOM.clickFilter().click();		
		 	 	 	        	
		  	 	 	        	Thread.sleep(2000);
		  	 	 	        	wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
		 	 	 	 			
		 	 				
		  	 	 	        	Thread.sleep(5000);
		  	 	 	        	performerPOM.clickSearchFilterworkspace().sendKeys("12344");	
		 	 	 	        	
		  	 	 	        	Thread.sleep(5000);
		  	 	 	        	performerPOM.clickCheckbox().click();	
		  	 	        	
		 	 	 	        	
		  	 	 	        	Thread.sleep(5000);
		  	 	 	        	performerPOM.clickFilter1().click();	*/
		 	 	 	 	        	
		 	 	 	 	        	
		 	 	 	 	        	
		 	 	 	 	 			
		 	 	 	 	            Thread.sleep(4000);
		 	 	 	 	            performerPOM.clickEditNotice().click();
		 	 	 	 	            
//		 	 	 	 	            Thread.sleep(4000);
//		 	 	 	 	            performerPOM.clickEditNotice1().click();
		 	 	 	 	            
		 	 		 	 	 	      try
		 	 		 	 	 	      {
		 	 		 	 	 	            
		 	 		 	 	 	             Thread.sleep(4000);
		 	 		 	 	                 performerPOM.clickDeleteUserAssign().click();
		 	 		 	 	             
		 	 		 	 	                 Thread.sleep(2000);
		 	 		 	 	    	 	     String msg = performerPOM.clickDeleteUserAssignValidMsg().getText();		//Reading Message appeared after save button
		 	 		 	 	    		
		 	 		 	 	    		    if(msg.equalsIgnoreCase("User Assignment Detail Deleted"))
		 	 		 	 	    		    {
		 	 		 	 	    			     test.log(LogStatus.PASS, "Message displayed = "+msg);
		 	 		 	 	    			
		 	 		 	 	    		    }
		 	 		 	 	    		    else
		 	 		 	 	    		      {
		 	 		 	 	    			         test.log(LogStatus.FAIL, "Message displayed = "+msg);
		 	 		 	 	    		        }
		 	 		 	 	            
		 	 		 	 	        
		 	 		 	 	    	
		 	 		 	 	          }
		 	 		 	 	            catch(Exception e)
		 	 		 	 	            {
		 	 		 	 	            	test.log(LogStatus.PASS, "Record not displayed in Notice-User assignment");
		 	 		 	 	           
		 	 		 	 	            }
		 	 		 	 	            
		 	 		 	 	      	    Thread.sleep(3000);
		 	 		 	 	     		getDriver().switchTo().parentFrame();
		 	 		 	 	     		performerPOM.clickClose().click();//Clicking on 'Close'
		 	 		 	 	          
		 	 		 	 	     	    Thread.sleep(3000);
		 	 		 	 	     		OverduePOM.clickDashboard().click();
		 	 		 	 	    }
		 	 		 			 
		 	 			 
		 	 			 
		 	 			 
		 	 	 	  

		               
		 	public static void NoticeWithoutUploadDocument( ExtentTest test) throws InterruptedException
		 		{
		 			WebDriverWait wait = new WebDriverWait(getDriver(), 50);
		       
		 			Thread.sleep(8000);
		 			OverduePOM.clickDashboard().click();			//Clicking on 'Dashboard'
		 			
		 			Thread.sleep(8000);
		 			performerPOM.clickNoticeOpen().click();//click edit notice
		 			
		 			
		 	      	Thread.sleep(8000);
		 	        	wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
		 	       /* 	Thread.sleep(3000);
		 	        	performerPOM.clickTrignle1().click();		
		 			
		 	        	
		 	        	Thread.sleep(3000);
		 	        	performerPOM.clickFilter().click();		
		        	
		 	        	Thread.sleep(2000);
		 	        	wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
		 			
		 			
		 	        	Thread.sleep(5000);
		 	        	performerPOM.clickSearchFilterworkspace().sendKeys("12344");	
		        	
		 	        	Thread.sleep(5000);
		 	        	performerPOM.clickCheckbox().click();	
		       	
		        	
		 	        	Thread.sleep(5000);
		 	        	performerPOM.clickFilter1().click();	*/
		   
		 			Thread.sleep(8000);
		 			performerPOM.clickEditNotice().click();//click edit notice
		 			Thread.sleep(8000);
		 			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
		 		
		 			Thread.sleep(8000);
		 			performerPOM.clickNoticeDocument().click();     //click notice document
		 			Thread.sleep(8000);
		 			performerPOM.clickNewDocument().click();        //click new document button

		 			Thread.sleep(8000);
		 			getDriver().switchTo().frame("IFrameManageDocument");
		 			performerPOM.selectDocumentType();
		 			Thread.sleep(8000);
		 			performerPOM.chooseDocumentType();
		    	
		 			Thread.sleep(8000);
		 			performerPOM.clickUploadDocument().click(); 


		 			Thread.sleep(8000);
		 			wait.until(ExpectedConditions.visibilityOf(performerPOM.readDocMsg()));

		 			Thread.sleep(8000);
		 			String msg= performerPOM.readDocMsg().getText();		//Reading Message appeared after save button
		     
		 			if(msg.equalsIgnoreCase("Please select file to upload"))
		 			{
		 				test.log(LogStatus.PASS, "Message displayed = "+msg);
		       
		 			}
		 			else
		 			{
		 				test.log(LogStatus.FAIL, "Message displayed = "+msg);
		 			}

		 			Thread.sleep(8000);
		 			performerPOM.clickClosedDocument().click();
		      
		 			getDriver().switchTo().parentFrame();
		     
		 			Thread.sleep(8000);
		 			getDriver().switchTo().parentFrame();
		 			performerPOM.clickClose().click();//Clicking on 'Close'
		 	}
		 	
		 	
		 	public static void NoticeDocumentSearchFields( ExtentTest test) throws InterruptedException
		     	{
		  		WebDriverWait wait = new WebDriverWait(getDriver(), 50);
		           
		  		
		 	        Thread.sleep(8000);
		 			performerPOM.clickNoticeOpen().click();//click edit notice
		 			Thread.sleep(8000);
		 	        	wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
		 	        	/*Thread.sleep(3000);
		 	        	performerPOM.clickTrignle1().click();		
		 			
		 	        	
		 	        	Thread.sleep(3000);
		 	        	performerPOM.clickFilter().click();		
		        	
		 	        	Thread.sleep(2000);
		 	        	wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
		 			
		 			
		 	        	Thread.sleep(5000);
		 	        	performerPOM.clickSearchFilterworkspace().sendKeys("12344");	
		        	
		 	        	Thread.sleep(5000);
		 	        	performerPOM.clickCheckbox().click();	
		       	
		        	
		 	        	Thread.sleep(5000);
		 	        	performerPOM.clickFilter1().click();	*/
		 	     
		 	        Thread.sleep(8000);
		 			performerPOM.clickEditNotice().click();//click edit notice
		 			
		 			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));

		 	        Thread.sleep(8000);
		 			 performerPOM.clickNoticeDocument().click();     //click notice document
		 			
		 			Thread.sleep(8000);
		 			performerPOM.clickSearchDocument().sendKeys("Approver Test Case.xlsx");
		 			
		 			Thread.sleep(8000);
		 			performerPOM.clickApplyBtn().click();
		 			
		 			String msg=performerPOM.clickDocName().getText();
		 			if(msg.equalsIgnoreCase(msg)) 
		 			{
		 				test.log(LogStatus.PASS,"Document Filter Apply =" +msg);
		 			}
		 			else
		 			{
		 				test.log(LogStatus.FAIL,"Document Filter Apply  =" +msg);
		 			}
		 			
		 			Thread.sleep(8000);
		    		getDriver().switchTo().parentFrame();
		    		performerPOM.clickClose().click();//Clicking on 'Close'
		 	}
		 	public static void NoticeDocumentShareInvalidData( ExtentTest test) throws InterruptedException
		     	{
		  		WebDriverWait wait = new WebDriverWait(getDriver(), 50);
		           
		  		
		 	        Thread.sleep(8000);
		 			performerPOM.clickNoticeOpen().click();//click edit notice
		 	      	Thread.sleep(8000);
		 	        	wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
		 	        	/*Thread.sleep(3000);
		 	        	performerPOM.clickTrignle1().click();		
		 			
		 	        	
		 	        	Thread.sleep(3000);
		 	        	performerPOM.clickFilter().click();		
		        	
		 	        	Thread.sleep(2000);
		 	        	wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
		 			
		 			
		 	        	Thread.sleep(5000);
		 	        	performerPOM.clickSearchFilterworkspace().sendKeys("12344");	
		        	
		 	        	Thread.sleep(5000);
		 	        	performerPOM.clickCheckbox().click();	
		       	
		        	
		 	        	Thread.sleep(5000);
		 	        	performerPOM.clickFilter1().click();	*/
		 			
		 	        Thread.sleep(8000);
		 			performerPOM.clickEditNotice().click();//click edit notice
		 			
		 			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));

		 	        Thread.sleep(8000);
		 			 performerPOM.clickNoticeDocument().click();     //click notice document
		 			 
		 			 Thread.sleep(8000);
		 	        performerPOM.clickNoticeDocumentsharecfo().click();
		 	        
		 	        Thread.sleep(8000);
		 		    // Switching to Alert        
		 	        Alert alert1 = getDriver().switchTo().alert();		
		 	        		
		 	        // Capturing alert message.    
		 	        String alertMessage1= getDriver().switchTo().alert().getText();	
		 	        
		 	        
		 	        test.log(LogStatus.PASS, alertMessage1);
		 	        		
		 	        // Displaying alert message		
		 	        System.out.println(alertMessage1);
		 	        
		 	     // Accepting alert		
		 	        alert1.accept();	
		 	        
		 	        Thread.sleep(8000);
		 	        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("Iframe_Docshare"));
		 	        
		 	        Thread.sleep(8000);
		 	        performerPOM.clickNoticeDocumentshareemailcfo().sendKeys("admin");
		 	        
		 	        Thread.sleep(8000);
		 	        performerPOM.clickNoticeDocumentsharecontactnocfo().sendKeys("576879");
		 	        
		 	        Thread.sleep(8000);
		 	        performerPOM.clickNoticeDocumentsharesavecfo().click();
		 	        
		 	        
		 	        Thread.sleep(8000);
		 	        String msg1= performerPOM.clickNoticeDocumentshareInvalidmsgcfo().getText();		//Reading Message appeared after save button
		 	       
		       
		 	        	test.log(LogStatus.PASS, "Message displayed = "+msg1);
		 	      
		 	        
		 	        Thread.sleep(8000);
		 	        performerPOM. clickNoticeDocumentshareclosepopupcfo().click();
		 	        
		 	       getDriver().switchTo().parentFrame();
		 	      
		 	        Thread.sleep(8000);
		     		getDriver().switchTo().parentFrame();
		     		performerPOM.clickClose().click();//Clicking on 'Close'
		      	}
		 	
		 	public static void NoticeDocumentShareWithoutData( ExtentTest test) throws InterruptedException
		     	{
		  		WebDriverWait wait = new WebDriverWait(getDriver(), 50);
		           
		  		
		 	        Thread.sleep(8000);
		 			performerPOM.clickNoticeOpen().click();//click edit notice
		 			
		 			
		 	      	Thread.sleep(8000);
		 	        	wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
		 	        	/*Thread.sleep(3000);
		 	        	performerPOM.clickTrignle1().click();		
		 			
		 	        	
		 	        	Thread.sleep(3000);
		 	        	performerPOM.clickFilter().click();		
		        	
		 	        	Thread.sleep(2000);
		 	        	wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
		 			
		 			 Thread.sleep(5000);
		 	        	performerPOM.clickSearchFilterworkspace().sendKeys("12344");	
		        	
		 	        	Thread.sleep(5000);
		 	        	performerPOM.clickCheckbox().click();	
		       	
		        	
		 	        	Thread.sleep(5000);
		 	        	performerPOM.clickFilter1().click();	*/
		 	        Thread.sleep(8000);
		 			performerPOM.clickEditNotice().click();//click edit notice
		 			
		 			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));

		 	        Thread.sleep(8000);
		 			 performerPOM.clickNoticeDocument().click();     //click notice document
		 			 
		 			 Thread.sleep(8000);
		 	        performerPOM.clickNoticeDocumentsharecfo().click();
		 	        
		 	        Thread.sleep(8000);
		 		    // Switching to Alert        
		 	        Alert alert1 = getDriver().switchTo().alert();		
		 	        		
		 	        // Capturing alert message.    
		 	        String alertMessage1= getDriver().switchTo().alert().getText();	
		 	        
		 	        
		 	        test.log(LogStatus.PASS, alertMessage1);
		 	        		
		 	        // Displaying alert message		
		 	        System.out.println(alertMessage1);
		 	        
		 	     // Accepting alert		
		 	        alert1.accept();	
		 	        
		 	       Thread.sleep(8000);
		         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("Iframe_Docshare"));
		 	        
		 	      
		 	        
		 	        Thread.sleep(8000);
		 	        performerPOM.clickNoticeDocumentsharesavecfo().click();
		 	        
		 	        
		 	        Thread.sleep(8000);
		 	        String msg1= performerPOM.clickNoticeDocumentshareInvalidmsgcfo().getText();		//Reading Message appeared after save button
		 	        if(msg1.equalsIgnoreCase("Please Enter Email."))
		 	        {
		       
		 	        	test.log(LogStatus.PASS, "Message displayed = "+msg1);
		 	        }
		 	        else
		 	        {
		 	        	test.log(LogStatus.FAIL, "Message displayed = "+msg1);
		 	        }
		 	        
		 	        Thread.sleep(8000);
		 	        performerPOM. clickNoticeDocumentshareclosepopupcfo().click();
		 	        
		 	       getDriver().switchTo().parentFrame();
		 	      
		 	        Thread.sleep(8000);
		     		getDriver().switchTo().parentFrame();
		     		performerPOM.clickClose().click();//Clicking on 'Close'
		      	}
		 	
		 	public static void NoticeDocumentShareCloseBtn( ExtentTest test) throws InterruptedException
		     	{
		  		WebDriverWait wait = new WebDriverWait(getDriver(), 50);
		           
		  		
		 	        Thread.sleep(8000);
		 			performerPOM.clickNoticeOpen().click();//click edit notice
		 			
		 	      	Thread.sleep(8000);
		 	        	wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
		 	        /*	Thread.sleep(3000);
		 	        	performerPOM.clickTrignle1().click();		
		 			
		 	        	
		 	        	Thread.sleep(3000);
		 	        	performerPOM.clickFilter().click();		
		        	
		 	        	Thread.sleep(2000);
		 	        	wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
		 			
		 			
		 	        	Thread.sleep(5000);
		 	        	performerPOM.clickSearchFilterworkspace().sendKeys("12344");	
		        	
		 	        	Thread.sleep(5000);
		 	        	performerPOM.clickCheckbox().click();	
		       	
		        	
		 	        	Thread.sleep(5000);
		 	        	performerPOM.clickFilter1().click();	*/
		 	     
		 	        Thread.sleep(8000);
		 			performerPOM.clickEditNotice().click();//click edit notice
		 			
		 			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));

		 	        Thread.sleep(8000);
		 			 performerPOM.clickNoticeDocument().click();     //click notice document
		 			 
		 			 
		 			 Thread.sleep(8000);
		 	        performerPOM.clickNoticeDocumentsharecfo().click();
		 	        
		 	       Thread.sleep(8000);
		 	    // Switching to Alert        
		         Alert alert1 = getDriver().switchTo().alert();		
		         		
		         // Capturing alert message.    
		         String alertMessage1= getDriver().switchTo().alert().getText();	
		         
		         
		         // test.log(LogStatus.PASS, alertMessage1);
		         		
		         // Displaying alert message		
		         System.out.println(alertMessage1);
		         
		      // Accepting alert		
		         alert1.accept();	
		         
		        Thread.sleep(8000);
		         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("Iframe_Docshare"));

		  	      Thread.sleep(8000);
		          if(performerPOM.clickNoticeDocumentshareclosepopupcfo().isEnabled())
		          {
		           Thread.sleep(8000);
		           performerPOM.clickNoticeDocumentshareclosepopupcfo().click();
		           test.log(LogStatus.PASS, "Close Button is clickable");
		          }
		         else
		        {
		 	     test.log(LogStatus.FAIL, "Close Button is not clickable");
		        }
		        
		 	     		getDriver().switchTo().parentFrame();
		 	     	getDriver().switchTo().parentFrame();
		 	     	   Thread.sleep(3000);
		 	     		performerPOM.clickClose().click();//Clicking on 'Close'
		 	     	
		     }
		 	
		 	 public  static void TaskActivtityExistingData( ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException
		 		{
		 		 
		 		 WebDriverWait wait = new WebDriverWait(getDriver(), 60);
		 		  
		 		  sheet = workbook.getSheetAt(6);		
		 		  
		 		  Thread.sleep(8000);
		 			performerPOM.clickNoticeOpen().click();
		 			
		 			
		 	      	Thread.sleep(8000);
		 	        	wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
		 	        /*	Thread.sleep(3000);
		 	        	performerPOM.clickTrignle1().click();		
		 			
		 	        	
		 	        	Thread.sleep(3000);
		 	        	performerPOM.clickFilter().click();		
		        	
		 	        	Thread.sleep(2000);
		 	        	wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
		 			
		 			
		 	        	Thread.sleep(5000);
		 	        	performerPOM.clickSearchFilterworkspace().sendKeys("12344");	
		        	
		 	        	Thread.sleep(5000);
		 	        	performerPOM.clickCheckbox().click();	
		       	
		        	
		 	        	Thread.sleep(5000);
		 	        	performerPOM.clickFilter1().click();	*/		
		 	        	Thread.sleep(8000);
			 			performerPOM.clickEditNotice().click();//click edit notice
			 		
			 		   Thread.sleep(8000);
			 		   wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
			 		  Thread.sleep(8000);
			 		  performerPOM.clickTaskorActivity().click();
			 		  Thread.sleep(8000);
			 		  performerPOM.clickNewTask().click(); 
		 		 
		 		  
		 		  
			 		Thread.sleep(8000);
			 		Row row0 = sheet.getRow(29);								//Selected 0th index row (First row)
			 		Cell c1 = row0.getCell(1);								//Selected cell (0 row,1 column)
			 		String title = c1.getStringCellValue();
			 		performerPOM.clickTaskTitle().sendKeys(title);	//Writing 'Task Title'
			 		
			 		Thread.sleep(8000);
			 		row0 = sheet.getRow(30);									//Selected 0th index row (First row)
			 		c1 = row0.getCell(1);									//Selected cell (0 row,1 column)
			 		String desc = c1.getStringCellValue();
			 		performerPOM.clickTaskDesc().sendKeys(desc);		//Writing 'Task Description'
			 		
			 		Thread.sleep(8000);
			 		performerPOM.clickDueDate().click();				//Clicking on 'Due Date' text box
			 		OverduePOM.selectNextMonth().click();
			 		OverduePOM.selectDate().click();					//Selecting particular date.
			 		
			 		Thread.sleep(8000);
			 		Actions action = new Actions(getDriver());
	//		 		action.moveToElement(performerPOM.clickPriority()).click().sendKeys(Keys.DOWN,Keys.ENTER).perform();
			 		
			 		Thread.sleep(8000);
			 		row0 = sheet.getRow(31);									//Selected 0th index row (First row)
			 		c1 = row0.getCell(1);									//Selected cell (0 row,1 column)
			 		String outcome = c1.getStringCellValue();
			 		performerPOM.clickExpOutcome().sendKeys(outcome);	//Writing 'Expected Outcome'
			 		
			 		Thread.sleep(8000);
			 		row0 = sheet.getRow(32);									//Selected 0th index row (First row)
			 		c1 = row0.getCell(1);									//Selected cell (0 row,1 column)
			 		String internalUser = c1.getStringCellValue();
			 		performerPOM.clickInternalUser2().click();
			 		//performerPOM.selectInternalUser2().click();
			 		performerPOM.selectInternalUser2().sendKeys(internalUser, Keys.ENTER);	//Selecting 'Internal User'
			 	
			 		Thread.sleep(8000);
			 		row0 = sheet.getRow(30);									//Selected 0th index row (First row)
			 		c1 = row0.getCell(1);									//Selected cell (0 row,1 column)
			 		String externalUser = c1.getStringCellValue();
			 		try
			 		{
			 			Thread.sleep(8000);
			 			performerPOM.clickExternalUser().click();
			 			Thread.sleep(500);
			 			action.moveToElement(performerPOM.clickSearchExternalUser()).sendKeys(externalUser, Keys.ENTER).perform();
			 		}
			 		catch(Exception e)
			 		{
			 			
			 		}
	
			 		Thread.sleep(8000);
			 		OverduePOM.clickSaveButton().click();				//Clicking on 'Save' button.
			 		
			 	
			 		Thread.sleep(8000);
			 		String msg = performerPOM.readTaskMsg2().getText();
			 		
			 		 if(msg.contains(msg))
			 			{
			 				test.log(LogStatus.PASS, "Message displayed ="+msg);
			 			}
			 		 else
			 		 {
			 			 test.log(LogStatus.FAIL,  "Message displayed ="+msg);
			 		 }
		 		
				 		getDriver().switchTo().parentFrame();
			 		    performerPOM.clickclosebutton().click();
			 			Thread.sleep(8000);
			 		    OverduePOM.clickDashboard().click();
		 		}
		 	 
		 	 public  static void TaskActivtityWithoutData( ExtentTest test) throws InterruptedException, IOException
		 		{
		 		
			 		 		WebDriverWait wait = new WebDriverWait(getDriver(), 60);
			 		 		Thread.sleep(8000);
			 				performerPOM.clickNoticeOpen().click();//click edit notice
			 		      	Thread.sleep(8000);
		 	 	        	wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
		 	 	        	/*Thread.sleep(3000);
		 	 	        	performerPOM.clickTrignle1().click();		
		 	 			
		 	 	        	
		 	 	        	Thread.sleep(3000);
		 	 	        	performerPOM.clickFilter().click();		
		 	        	
		 	 	        	Thread.sleep(2000);
		 	 	        	wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
		 	 			
		 				
		 	 	        	Thread.sleep(5000);
		 	 	        	performerPOM.clickSearchFilterworkspace().sendKeys("12344");	
		 	        	
		 	 	        	Thread.sleep(5000);
		 	 	        	performerPOM.clickCheckbox().click();	
		 	        	
		 	        	
		 	 	        	Thread.sleep(5000);
		 	 	        	performerPOM.clickFilter1().click();	*/
			 		        Thread.sleep(8000);
			 				performerPOM.clickEditNotice().click();//click edit notice
			 			   Thread.sleep(8000);
			 			   wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
			 			  Thread.sleep(8000);
			 			  performerPOM.clickTaskorActivity().click();
			 			  Thread.sleep(8000);
			 			  performerPOM.clickNewTask().click(); 
			 			
			 			  Thread.sleep(8000);
			 			  OverduePOM.clickSaveButton().click();				//Clicking on 'Save' button.
		 			
			 			  //Thread.sleep(8000);
			 			  //performerPOM.clickMinimize().click();
		 			

			 			  Thread.sleep(8000);
		 			
			 			  String msg1 = performerPOM.readTaskMsg2().getText();
		 			
			 			  test.log(LogStatus.PASS, "Without data ="+msg1);
			 			  getDriver().switchTo().parentFrame();
		 				  
		 					Thread.sleep(8000);
		 			     	performerPOM.clickClose().click();//Clicking on 'Close'
		 				}
		 			
		 		
		 	 public  static void TaskActivtityResponseWithoutStatus( ExtentTest test) throws InterruptedException, IOException
		 		{ 
		 		      WebDriverWait wait = new WebDriverWait(getDriver(), 60);
		 			    Thread.sleep(8000);
		 				performerPOM.clickNoticeOpen().click();//click edit notice
		 				
		 		      	Thread.sleep(8000);
		 	 	        	wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
		 	 	    
		 		        Thread.sleep(8000);
		 				performerPOM.clickEditNotice().click();//click edit notice
		 				
		 				Thread.sleep(8000);
		 				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
		 			   
		 			  Thread.sleep(8000);
		 			  performerPOM.clickTaskorActivity().click();

		 			Thread.sleep(8000);
		 			performerPOM.clickNoticeTaskEditResponsecfo().click();
		 			
		 			Thread.sleep(8000);
		 			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
		 			
		 			Thread.sleep(8000);
		 			performerPOM.clickNoticeTaskcmtResponsecfo().sendKeys("Automate Test");
		 			
		 			Thread.sleep(8000);
		 			performerPOM.clickNoticeTaskSaveResponsecfo().click();
		 			
		 			Thread.sleep(8000);
		 			String msg=performerPOM.clickInvalidResponsemsg().getText();
		 			if(msg.equalsIgnoreCase(msg))
		 			{
		 			    test.log(LogStatus.PASS, "Mesaage displayed ="+msg);
		 			}
		 			else
		 			{
		 				 test.log(LogStatus.FAIL, "Mesaage displayed ="+msg);
		 			}
		 			getDriver().switchTo().parentFrame();
		 			
		 			Thread.sleep(8000);
		 			performerPOM.clickNoticeTaskCloseResponsecfo().click();
		 			
		 			getDriver().switchTo().parentFrame();
		 	     	Thread.sleep(8000);
		 	     	performerPOM.clickClose().click();//Clicking on 'Close'
		 		}
		 	 
		 		 public  static void TaskActivtityDeleteResponse( ExtentTest test) throws InterruptedException, IOException
		 	     { 
		 			 
		 		        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
		 			    Thread.sleep(8000);
		 				 performerPOM.clickNoticeOpen().click();//click edit notice
		 				 
		 			      	Thread.sleep(8000);
		 	 	 	        	wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));

		 		     
		 		         Thread.sleep(8000);
		 				 performerPOM.clickEditNotice().click();//click edit notice
		 			    Thread.sleep(8000);
		 			    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
		 			   Thread.sleep(8000);
		 			   performerPOM.clickTaskorActivity().click();

		 			  Thread.sleep(8000);
		 			  performerPOM.clickNoticeTaskEditResponsecfo().click();
		 			  
		 			 Thread.sleep(8000);
		 			 wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
		 			
		 			 Thread.sleep(8000);
		 			 performerPOM.clickDeleteResponse().click();
		 			
		 		    Thread.sleep(8000);
		 		    // Switching to Alert        
		 	        Alert alert1 = getDriver().switchTo().alert();		
		 	        		
		 	        // Capturing alert message.    
		 	        String alertMessage1= getDriver().switchTo().alert().getText();	
		 	        
		 	        
//		 	        test.log(LogStatus.PASS, alertMessage1);
		 	        		
		 	        // Displaying alert message		
		 	        System.out.println(alertMessage1);
		 	        
		 	     // Accepting alert	
		 	        alert1.accept();
		 	        
		 	    	
		 			   Thread.sleep(8000);
		 	        String msg=performerPOM.clickTaskResponse().getText();
		 	        if(msg.equalsIgnoreCase("Response Deleted Successfully."))
		 	        {
		 	              test.log(LogStatus.PASS,"Message displayed ="+msg);
		 	        }
		 	        else
		 	        {
		 	        	 test.log(LogStatus.FAIL,"Message displayed ="+msg);
		 	        }
		 	        
		 	        
		 	        getDriver().switchTo().parentFrame();
		 			Thread.sleep(8000);
		 			performerPOM.clickNoticeTaskCloseResponsecfo().click();
		 	       
		 	         Thread.sleep(8000);
		 			performerPOM.clickNoticeTaskClosecfo().click();
		 			
		 			 Thread.sleep(5000);
		 			    // Switching to Alert        
		 		        Alert alert = getDriver().switchTo().alert();		
		 		        		
		 		        // Capturing alert message.    
		 		        String alertMessage= getDriver().switchTo().alert().getText();	
		 		        
		 		        
		 		        test.log(LogStatus.PASS, alertMessage);
		 		        		
		 		        // Displaying alert message		
		 		        System.out.println(alertMessage);
		 		        
		 		     // Accepting alert		
		 		        alert.accept();
		 			
		 			Thread.sleep(8000);
		 			performerPOM.clickNoticeTaskdeletecfo().click();
		 			
		 			 Thread.sleep(8000);
		 			    // Switching to Alert        
		 		        Alert alert2 = getDriver().switchTo().alert();		
		 		        		
		 		        // Capturing alert message.    
		 		        String alertMessage2= getDriver().switchTo().alert().getText();	
		 		        
		 		        
		 		        test.log(LogStatus.PASS, alertMessage2);
		 		        		
		 		        // Displaying alert message		
		 		        System.out.println(alertMessage2);
		 		        
		 		     // Accepting alert		
		 		        alert2.accept();
		 		        
		 		      
		 		        getDriver().switchTo().parentFrame();
		 		     	Thread.sleep(8000);
		 		     	performerPOM.clickClose().click();//Clicking on 'Close'
		 		  }
		 		 public  static void TaskActivtityResponseClearBtn( ExtentTest test) throws InterruptedException, IOException
		 			{ 
		 	 		   WebDriverWait wait = new WebDriverWait(getDriver(), 60);
		 	 			  Thread.sleep(8000);
		 	 				performerPOM.clickNoticeOpen().click();//click edit notice
		 	 				
		 	 		      	/*Thread.sleep(8000);
		 	 	 	        	wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
		 	 	 	        	Thread.sleep(3000);
		 	 	 	        	performerPOM.clickTrignle1().click();		
		 	 	 			
		 	 	 	        	
		 	 	 	        	Thread.sleep(8000);
		 	 	 	        	performerPOM.clickFilter().click();		
		 	 	        	
		 	 	 	        	Thread.sleep(8000);
		 	 	 	        	wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
		 	 	 			
		  				
		 	 	 	        	Thread.sleep(8000);
		 	 	 	        	performerPOM.clickSearchFilterworkspace().sendKeys("12344");	
		 	 	        	
		 	 	 	        	Thread.sleep(8000);
		 	 	 	        	performerPOM.clickCheckbox().click();	
		 	 	        	
		 	 	        	
		 	 	 	        	Thread.sleep(8000);
		 	 	 	        	performerPOM.clickFilter1().click();	*/
		 	 		     
		 	 		        Thread.sleep(8000);
		 	 				performerPOM.clickEditNotice().click();//click edit notice
		 	 			   Thread.sleep(8000);
		 				   wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
		 	 			  Thread.sleep(9000);
		 				  performerPOM.clickTaskorActivity().click();

		 				Thread.sleep(8000);
		 				performerPOM.clickNoticeTaskEditResponsecfo().click();
		 				
		 				Thread.sleep(8000);
		 				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
		 				
		 				Thread.sleep(8000);
		 				performerPOM.clickNoticeTaskstatusResponsecfo().click();
		 				
		 				Thread.sleep(8000);
		 				performerPOM.clickNoticeTaskstatusResponsecfo1().click();
		 				
		 				
		 				if(performerPOM.clickClearResponse().isEnabled())
		 		  		{
		 					Thread.sleep(8000);
		 		  			performerPOM.clickClearResponse().click();
		 		  			test.log(LogStatus.PASS, "Clear button working successfully");
		 		  		}
		 		  		else
		 		  		{
		 		  			test.log(LogStatus.FAIL, "Clear button not working successfully");
		 		  		}
		 				getDriver().switchTo().parentFrame();
		 				  getDriver().switchTo().parentFrame();
		 		   	     	Thread.sleep(8000);
		 		   	     	performerPOM.clickClose().click();//Clicking on 'Close'
		 			}
		 		 
		 		  public static void ResponseExistingData( ExtentTest test,XSSFWorkbook workbook) throws InterruptedException
		 			{
		 			   WebDriverWait wait = new WebDriverWait(getDriver(), 60);
		 			  // sheet = workbook.getSheetAt(6);
		 			   
		 			   Thread.sleep(8000);
		 				performerPOM.clickNoticeOpen().click();
		 				
		 		      	Thread.sleep(8000);
		 	 	        	wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
		 			    
		 				Thread.sleep(8000);
		 				performerPOM.clickEditNotice().click();//click edit notice

		 			      Thread.sleep(8000);
		 			      wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
		 				   
		 				   Thread.sleep(8000);
		 					  performerPOM. clickResponse().click();
		 					  Thread.sleep(8000);
		 					  performerPOM. clickNewResponse().click();
		 					  Thread.sleep(8000);
		 					  performerPOM. selectSentNotice();
		 					  Thread.sleep(8000);
		 					  performerPOM. selectReplyDueDate();
		 					  Thread.sleep(8000);
		 					  performerPOM. selectRespondedDate();
		 				
		 					 		 
		 					  Thread.sleep(8000);
		 					  Row row1 = sheet.getRow(37);								//Selected 0th index row (First row)
		 					  Cell c2 = row1.getCell(1);								//Selected cell (0 row,1 column)
		 					  String DeliveryMode= c2.getStringCellValue();
		 					  performerPOM.clickDeliveryMode().click();
		 					  performerPOM.selectDeliveryMode().sendKeys(DeliveryMode);
		 					  
		 					  
		 					  Thread.sleep(8000);
		 					  Row row0 = sheet.getRow(38);								//Selected 0th index row (First row)
		 					  Cell c1 = row0.getCell(1);								//Selected cell (0 row,1 column)
		 					  String CourierCompany= c1.getStringCellValue();
		 					  performerPOM.clickCourierCompany().sendKeys(CourierCompany);
		 						 
		 					  Thread.sleep(8000);
		 						Row row2 = sheet.getRow(39);								//Selected 0th index row (First row)
		 						Cell c3 = row2.getCell(1);								//Selected cell (0 row,1 column)
		 						String RefNo= c3.getStringCellValue();
		 						performerPOM.RefTrackingNo().sendKeys(RefNo);
		 							 
		 						Thread.sleep(8000);
		 						Row row3 = sheet.getRow(40);								//Selected 0th index row (First row)
		 						Cell c4 = row3.getCell(1);								//Selected cell (0 row,1 column)
		 						String Description= c4.getStringCellValue();
		 						 performerPOM.Description().sendKeys(Description);
		 							
		 						  JavascriptExecutor jse=(JavascriptExecutor) getDriver();
		 							jse.executeScript("arguments[0].click();",  performerPOM.clickSaveResponse());
		 							Thread.sleep(8000);
		 							performerPOM.clickSaveResponse().click();
		 							
//		 							 Thread.sleep(8000);
//		 							performerPOM.clickMinimizeResponse().click();
		 							
		 							
		 							 Thread.sleep(8000);
		 							wait.until(ExpectedConditions.visibilityOf(performerPOM.readResponseInvalidMsg()));
		 								
		 							Thread.sleep(8000);
		 							String msg3 = performerPOM.readResponseInvalidMsg().getText();		//Reading Message appeared after save button
		 						
		 							if(msg3.equalsIgnoreCase(msg3))
		 							{
		 								test.log(LogStatus.PASS, "Message displayed = "+msg3);
		 								
		 							}
		 							else
		 							{
		 									test.log(LogStatus.FAIL, "Message displayed = "+msg3);
		 							}
		 							
		 							getDriver().switchTo().parentFrame();
		 				   	     	Thread.sleep(8000);
		 				   	     	performerPOM.clickClose().click();//Clicking on 'Close'
		 	 		
		 			}
		 		  
		 			public static void ResponseWithoutData( ExtentTest test) throws InterruptedException, IOException
		 			{
		 			   WebDriverWait wait = new WebDriverWait(getDriver(), 60);
		 			  
		 			    Thread.sleep(8000);
		 				performerPOM.clickNoticeOpen().click();//click edit notice
		 				
		 		      	Thread.sleep(8000);
		 	 	        	wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
		 	 	        	/*Thread.sleep(3000);
		 	 	        	performerPOM.clickTrignle1().click();		
		 	 			
		 	 	        	
		 	 	        	Thread.sleep(3000);
		 	 	        	performerPOM.clickFilter().click();		
		 	        	
		 	 	        	Thread.sleep(2000);
		 	 	        	wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
		 	 			
		 				
		 	 	        	Thread.sleep(5000);
		 	 	        	performerPOM.clickSearchFilterworkspace().sendKeys("12344");	
		 	        	
		 	 	        	Thread.sleep(5000);
		 	 	        	performerPOM.clickCheckbox().click();	
		 	        	
		 	        	
		 	 	        	Thread.sleep(5000);
		 	 	        	performerPOM.clickFilter1().click();	*/
		 		     
		 		        Thread.sleep(8000);
		 				performerPOM.clickEditNotice().click();//click edit notice
		 			 
		 			   
		 			    Thread.sleep(8000);
		 			    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
		 			    Thread.sleep(8000);
		 				performerPOM. clickResponse().click();
		 			    Thread.sleep(8000);
		 			    performerPOM. clickNewResponse().click();
		 					 
		 			    Thread.sleep(8000);		
		 			   JavascriptExecutor jse=(JavascriptExecutor) getDriver();
		 			   jse.executeScript("arguments[0].click();",  performerPOM.clickSaveResponse());
		 			   performerPOM.clickSaveResponse().click();
		 							
//		 			  Thread.sleep(8000);
//		 			  performerPOM.clickMinimizeResponse().click();
		 						 
		 			  Thread.sleep(8000);
		 			   wait.until(ExpectedConditions.visibilityOf(performerPOM.readResponseMsg1()));
		 								
		 			 Thread.sleep(8000);
		 			 String msg4 = performerPOM.readResponseMsg1().getText();		//Reading Message appeared after save button
		 							
		 							
		 			test.log(LogStatus.PASS, "Message displayed = "+msg4);
		 							
		 			getDriver().switchTo().parentFrame();
		 			Thread.sleep(8000);
		 			performerPOM.clickClose().click();//Clicking on 'Close'
		 	 }
		 			
		 			 public static void ResponseClearBtn( ExtentTest test) throws InterruptedException, IOException
		 				{
		 				   WebDriverWait wait = new WebDriverWait(getDriver(), 60);
		 				   
		 				 
		 				  
		 				   Thread.sleep(8000);
		 					performerPOM.clickNoticeOpen().click();//click edit notice
		 			     
		 			      	Thread.sleep(8000);
		 	 	 	        	wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
		 	 	 	        /*	Thread.sleep(3000);
		 	 	 	        	performerPOM.clickTrignle1().click();		
		 	 	 			
		 	 	 	        	
		 	 	 	        	Thread.sleep(3000);
		 	 	 	        	performerPOM.clickFilter().click();		
		 	 	        	
		 	 	 	        	Thread.sleep(2000);
		 	 	 	        	wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
		 	 	 			
		  				
		 	 	 	        	Thread.sleep(5000);
		 	 	 	        	performerPOM.clickSearchFilterworkspace().sendKeys("12344");	
		 	 	        	
		 	 	 	        	Thread.sleep(5000);
		 	 	 	        	performerPOM.clickCheckbox().click();	
		 	 	        	
		 	 	        	
		 	 	 	        	Thread.sleep(5000);
		 	 	 	        	performerPOM.clickFilter1().click();	*/
		 					
		 					
		 			        Thread.sleep(8000);
		 					performerPOM.clickEditNotice().click();//click edit notice
		 				  
		 				   
		 				           Thread.sleep(8000);
		 				           wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
		 				           Thread.sleep(8000);
		 						  performerPOM. clickResponse().click();
		 						  Thread.sleep(8000);
		 						  performerPOM. clickNewResponse().click();
		 						  Thread.sleep(8000);
		 						  performerPOM. selectSentNotice();
		 						  Thread.sleep(8000);
		 						  performerPOM. selectReplyDueDate();
		 						  Thread.sleep(8000);
		 						  performerPOM. selectRespondedDate();
		 					
		 						
		 							if(performerPOM.clickClearNoticeResponse().isEnabled())
		 					  		{
		 								Thread.sleep(8000);
		 								 JavascriptExecutor jse=(JavascriptExecutor) getDriver();
		 		 						 jse.executeScript("arguments[0].click();",  performerPOM.clickClearNoticeResponse());
		 								
		 					  			test.log(LogStatus.PASS, "Clear button working successfully");
		 					  		}
		 					  		else
		 					  		{
		 					  			test.log(LogStatus.FAIL, "Clear button not working successfully");
		 					  		}
		 						
		 							  getDriver().switchTo().parentFrame();
		 					   	     	Thread.sleep(8000);
		 					   	     	performerPOM.clickClose().click();//Clicking on 'Close'
		 			 			}
		 			 
		 			 public static void PaymentLogExistingData( ExtentTest test) throws InterruptedException
		 				{
		 			   WebDriverWait wait = new WebDriverWait(getDriver(), 60);
		 			   
		 			   Thread.sleep(8000);
		 				performerPOM.clickNoticeOpen().click();
		 			    
		 		      	Thread.sleep(8000);
		 	 	        	wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
		 	 	       /* 	Thread.sleep(3000);
		 	 	        	performerPOM.clickTrignle1().click();		
		 	 			
		 	 	        	
		 	 	        	Thread.sleep(3000);
		 	 	        	performerPOM.clickFilter().click();		
		 	        	
		 	 	        	Thread.sleep(2000);
		 	 	        	wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
		 	 			
		 				
		 	 	        	Thread.sleep(5000);
		 	 	        	performerPOM.clickSearchFilterworkspace().sendKeys("12344");	
		 	        	
		 	 	        	Thread.sleep(5000);
		 	 	        	performerPOM.clickCheckbox().click();	
		 	        	
		 	        	
		 	 	        	Thread.sleep(5000);
		 	 	        	performerPOM.clickFilter1().click();	*/
		 				
		 				Thread.sleep(8000);
		 				performerPOM.clickEditNotice().click();//click edit notice
		 			   Thread.sleep(8000);
		 			   wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
		 			   Thread.sleep(8000);
		 				   performerPOM.clickStatusPayments().click();			//Clicking on 'Status/Payments'
		 					Thread.sleep(8000);
		 					performerPOM.clickInvoiceNo().sendKeys("67457");
		 					
		 					
		 					Thread.sleep(8000);
		 					performerPOM.clickPaymentType().click();

		 					List<WebElement> PaymentType1= getDriver().findElements(By.xpath("//*[@id='grdNoticePayment_ddlPaymentType_chosen']/div/ul/li"));
		 					PaymentType1.get(4).click();
		 					
		 					Thread.sleep(8000);
		 					performerPOM.clickAmount().sendKeys("7000");
		 					Thread.sleep(8000);
		 					performerPOM.clickNoticAmountPaid().sendKeys("2000");
		 				
		 					Thread.sleep(8000);
		 					performerPOM.clickSavePaymentLog().click();
		 					

		 					 // Thread.sleep(1000);
		 					  WebDriverWait wait1 = new WebDriverWait(getDriver(), 300);
		 					 wait1.until(ExpectedConditions.visibilityOf(performerPOM.readPymentmsg()));
		 						
		 						Thread.sleep(8000);
		 						String msg4 = performerPOM.readPymentmsg().getText();		//Reading Message appeared after save button
		 						
		 						if(msg4.equalsIgnoreCase("Payment Details Saved Successfully."))
		 						{
		 							test.log(LogStatus.PASS, "Message displayed = "+msg4);
		 							
		 						}
		 						else
		 						{
		 							test.log(LogStatus.FAIL, "Message displayed = "+msg4);
		 						}
		 						
		 						getDriver().switchTo().parentFrame();
		 			   	     	Thread.sleep(8000);
		 			   	     	performerPOM.clickClose().click();//Clicking on 'Close'
		 				}
		 			 
		 		 	 public static void PaymentLogWithoutData( ExtentTest test, XSSFWorkbook workbook) throws InterruptedException, IOException
		 				{
		 	 		 
		 	 		 
		 	 		        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
		 				   
		 	 		         Thread.sleep(8000);
		 				     performerPOM.clickNoticeOpen().click();//click edit notice
		 				     
		 				      	Thread.sleep(8000);
		  	 	 	        	wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
		  	 	 	      /*  	Thread.sleep(3000);
		  	 	 	        	performerPOM.clickTrignle1().click();		
		 	 	 	 			
		  	 	 	        	
		  	 	 	        	Thread.sleep(3000);
		  	 	 	        	performerPOM.clickFilter().click();		
		 	 	 	        	
		  	 	 	        	Thread.sleep(2000);
		  	 	 	        	wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
		 	 	 	 			
		 	 				
		  	 	 	        	Thread.sleep(5000);
		  	 	 	        	performerPOM.clickSearchFilterworkspace().sendKeys("12344");	
		 	 	 	        	
		  	 	 	        	Thread.sleep(5000);
		  	 	 	        	performerPOM.clickCheckbox().click();	
		  	 	        	
		 	 	 	        	
		  	 	 	        	Thread.sleep(5000);
		  	 	 	        	performerPOM.clickFilter1().click();	*/
		 		     
		 		             Thread.sleep(8000);
		 				     performerPOM.clickEditNotice().click();//click edit notice
		 			  
		 				      getDriver().switchTo().parentFrame();
		 				      wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
		 				     
		 				     Thread.sleep(8000);
		 				    performerPOM.clickStatusPayments().click();			//Clicking on 'Status/Payments'
		 				    
		 					Thread.sleep(8000);
		 					performerPOM.clickSavePaymentLog().click();
		 					

		 					
		 					 WebDriverWait wait1 = new WebDriverWait(getDriver(), 300);
		 					 wait1.until(ExpectedConditions.visibilityOf(performerPOM.readPymentmsg1()));
		 						
		 						Thread.sleep(8000);
		 						String msg4 = performerPOM.readPymentmsg1().getText();		//Reading Message appeared after save button
		 					
		 					
		 							test.log(LogStatus.PASS, "Message displayed = "+msg4);
		 							
		 							 getDriver().switchTo().parentFrame();
		 					   	     	Thread.sleep(8000);
		 					   	     	performerPOM.clickClose().click();//Clicking on 'Close'
		 				}
		 		 	 
		 		 	 public static void PaymentLogwithInvalidData( ExtentTest test) throws InterruptedException, IOException
		 				{
		 			 
		 			 
		 	 			 	WebDriverWait wait = new WebDriverWait(getDriver(), 60);
		 				   
		 	 			 	
		 				   
		 	 			 	Thread.sleep(8000);
		 				     performerPOM.clickNoticeOpen().click();//click edit notice
		 				     
		 				 	Thread.sleep(8000);
		 	 	 	        	wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
		 		     
		 		             Thread.sleep(8000);
		 				     performerPOM.clickEditNotice().click();//click edit notice
		 			  
		 				     getDriver().switchTo().parentFrame();
		 				     wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
		 				     
		 				     Thread.sleep(8000);
		 				    performerPOM.clickStatusPayments().click();			//Clicking on 'Status/Payments'
		 				
		 				    Thread.sleep(8000);
		 					performerPOM.clickInvoiceNo().sendKeys("abc");
		 					
		 					
		 					Thread.sleep(8000);
		 					performerPOM.clickPaymentType().click();

		 					List<WebElement> PaymentType1= getDriver().findElements(By.xpath("//*[@id='grdNoticePayment_ddlPaymentType_chosen']/div/ul/li"));
		 					PaymentType1.get(4).click();
		 						
		 					Thread.sleep(8000);
		 					performerPOM.clickAmount().sendKeys("abc");
		 					
		 					Thread.sleep(8000);
		 					performerPOM.clickNoticeStatusPaymentUploadtcfo();
		 				
		 					Thread.sleep(8000);
		 					performerPOM.clickSavePaymentLog().click();
		 					
		 					try
		 					{
		 							
		 					 
		 					   wait.until(ExpectedConditions.visibilityOf(performerPOM.readPymentmsg()));
		 					   Thread.sleep(8000);
		 					   String msg4 = performerPOM.readPymentmsg().getText();		//Reading Message appeared after save button
		 					   test.log(LogStatus.PASS, "Message displayed = "+msg4);
		 								
		 					}
		 					catch(Exception e)
		 					{
		 						test.log(LogStatus.FAIL, "Invalid Payment = Validation message not displayed");
		 					}
		 							
		 					getDriver().switchTo().parentFrame();
		 				   	Thread.sleep(8000);
		 				   	 performerPOM.clickClose().click();//Clicking on 'Close'
		 				}
		 		 	 
		 		 	 
		 		 	 public static void CriteriaInvalidData(ExtentTest test) throws InterruptedException
		 	         {
		 	       	  
		 	   		         WebDriverWait wait = new WebDriverWait(getDriver(), 300);
		 			  
		 				          Thread.sleep(8000);
		 						  performerPOM.clickNoticeOpen().click();//click edit notice
		 						  
		 			 			     
		 					      	Thread.sleep(8000);
		 	 	 	 	        	wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
		 	 	 	 	       /* 	Thread.sleep(3000);
		 	 	 	 	        	performerPOM.clickTrignle1().click();		
		  	 	 	 			
		 	 	 	 	        	
		 	 	 	 	        	Thread.sleep(3000);
		 	 	 	 	        	performerPOM.clickFilter().click();		
		  	 	 	        	
		 	 	 	 	        	Thread.sleep(2000);
		 	 	 	 	        	wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
		  	 	 	 			
		 		 				
		 	 	 	 	        	Thread.sleep(5000);
		 	 	 	 	        	performerPOM.clickSearchFilterworkspace().sendKeys("12344");	
		  	 	 	        	
		 	 	 	 	        	Thread.sleep(5000);
		 	 	 	 	        	performerPOM.clickCheckbox().click();	
		 	 	 	        	
		  	 	 	        	
		 	 	 	 	        	Thread.sleep(5000);
		 	 	 	 	        	performerPOM.clickFilter1().click();	*/
		 				     
		 				           Thread.sleep(8000);
		 						   performerPOM.clickEditNotice().click();//click edit notice
		 					  
		 						   getDriver().switchTo().parentFrame();
		 						   wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
		 	       	          
		 	   			           Thread.sleep(8000);
		 	   				       performerPOM. clickExternalLawyerRating().click();
		 	   			          Thread.sleep(8000);
		 	   				      performerPOM.selectExternalLawyerRating();
		 	   				     Thread.sleep(8000);
		 	   				     performerPOM.clickNewCriteria().click();
		 	   				     Thread.sleep(8000);
		 	   				     wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IframeLayerRatingCriteria"));
		 	   				     Thread.sleep(8000);
		 	   				     performerPOM.clickCriteria().sendKeys("342");
		 	   				 
		 	   				    Thread.sleep(8000);
		 	   				    performerPOM.clickSaveCriteria().click();
		 	   				    Thread.sleep(8000);
		 	   				    String msg = performerPOM.clickCriteriaInvalidMsg().getText();
		 	   				   
		 	   				   if(msg.equalsIgnoreCase("Only alphabets allowed."))
		 	   				   {
		 	   					   test.log(LogStatus.PASS, "Meassag Displayed ="+msg);
		 	   				   }
		 	   				   else
		 	   				   {
		 	   					   test.log(LogStatus.FAIL, "Meassag Displayed ="+msg);
		 	   				   }
		 	   				   
		 	   				   Thread.sleep(8000);
		 	   				   getDriver().switchTo().parentFrame();
		 	   				   performerPOM.clickclosecriteria().click();
		 	         }
		 		 	 
		 		 	 public static void CriteriaExistingData(ExtentTest test) throws InterruptedException
		 	         {
		 	       	  
		 	   		         WebDriverWait wait = new WebDriverWait(getDriver(), 300);
		 			   
		 	   		         Thread.sleep(10000);
		 	   			     performerPOM.clickNoticeOpen().click();//click edit notice
		 	   			     
		 	   		      	Thread.sleep(8000);
		 	 	 	        	wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
		 	 	 	        	/*Thread.sleep(3000);
		 	 	 	        	performerPOM.clickTrignle1().click();		
		 	 	 			
		 	 	 	        	
		 	 	 	        	Thread.sleep(3000);
		 	 	 	        	performerPOM.clickFilter().click();		
		 	 	        	
		 	 	 	        	Thread.sleep(2000);
		 	 	 	        	wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
		 	 	 			
		  				
		 	 	 	        	Thread.sleep(5000);
		 	 	 	        	performerPOM.clickSearchFilterworkspace().sendKeys("12344");	
		 	 	        	
		 	 	 	        	Thread.sleep(5000);
		 	 	 	        	performerPOM.clickCheckbox().click();	
		 	 	        	
		 	 	        	
		 	 	 	        	Thread.sleep(5000);
		 	 	 	        	performerPOM.clickFilter1().click();	*/
		 	  			
		 	   	     
		 	   	             Thread.sleep(8000);
		 	   			     performerPOM.clickEditNotice().click();//click edit notice
		 	   		  
		 	   			      getDriver().switchTo().parentFrame();
		 	   			      wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
		 	   		         
		 				          
		 	       	          
		 	   			       Thread.sleep(8000);
		 	   				   performerPOM. clickExternalLawyerRating().click();
		 	   				   

		 	   				   
		 	   				  Thread.sleep(8000);
		 	   				  performerPOM.selectExternalLawyerRating();
		 	   				   Thread.sleep(8000);
		 	   				   performerPOM.clickNewCriteria().click();
		 	   				   Thread.sleep(8000);
		 	   				   wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IframeLayerRatingCriteria"));
		 	   				   performerPOM.clickCriteria().sendKeys("Test Test New");
		 	   				   Thread.sleep(8000);
		 	   				   performerPOM.clickSaveCriteria().click();
		 	   				   String msg = performerPOM.readOppoenentMsg().getText();
		 	   				   
		 	   				   if(msg.equalsIgnoreCase("Criteria already exists."))
		 	   				   {
		 	   					   test.log(LogStatus.PASS, "Meassag Displayed ="+msg);
		 	   				   }
		 	   				   else
		 	   				   {
		 	   					   String msg1 = performerPOM.readMesg().getText();
		 	   					   test.log(LogStatus.PASS, "Meassag Displayed ="+msg1);
		 	   				   }
		 	   				   Thread.sleep(8000);
		 	   				   getDriver().switchTo().parentFrame();
		 	   				   performerPOM.clickclosecriteria().click();
		 	   				   
		 	   				   getDriver().switchTo().parentFrame();
		 			   	     	Thread.sleep(8000);
		 			   	     	performerPOM.clickClose().click();//Clicking on 'Close'
		 	         }
		 		 	 
		 			 public static void CriteriaWithoutData(ExtentTest test) throws InterruptedException
		 	         {
		 	       	  
		 	   		         WebDriverWait wait = new WebDriverWait(getDriver(), 300);
		 			  
		 				          Thread.sleep(8000);
		 						     performerPOM.clickNoticeOpen().click();//click edit notice
		 						     
		 						      	Thread.sleep(8000);
		 		 	 	 	        	wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
		 		 	 	 	       /* 	Thread.sleep(3000);
		 		 	 	 	        	performerPOM.clickTrignle1().click();		
		 	 	 	 	 			
		 		 	 	 	        	
		 		 	 	 	        	Thread.sleep(3000);
		 		 	 	 	        	performerPOM.clickFilter().click();		
		 	 	 	 	        	
		 		 	 	 	        	Thread.sleep(2000);
		 		 	 	 	        	wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
		 	 	 	 	 			
		 			 				
		 		 	 	 	        	Thread.sleep(5000);
		 		 	 	 	        	performerPOM.clickSearchFilterworkspace().sendKeys("12344");	
		 	 	 	 	        	
		 		 	 	 	        	Thread.sleep(5000);
		 		 	 	 	        	performerPOM.clickCheckbox().click();	
		 		 	 	        	
		 	 	 	 	        	
		 		 	 	 	        	Thread.sleep(5000);
		 		 	 	 	        	performerPOM.clickFilter1().click();	*/
		 				     
		 				             Thread.sleep(8000);
		 						     performerPOM.clickEditNotice().click();//click edit notice
		 					  
		 						      getDriver().switchTo().parentFrame();
		 						      wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
		 	       	          
		 	   			       Thread.sleep(8000);
		 	   				   performerPOM. clickExternalLawyerRating().click();
		 	   				   

		 	   				   
		 	   				  Thread.sleep(8000);
		 	   				  performerPOM.selectExternalLawyerRating();
		 	   				   Thread.sleep(8000);
		 	   				   performerPOM.clickNewCriteria().click();
		 	   				   Thread.sleep(8000);
		 	   				   wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IframeLayerRatingCriteria"));
		 	   				
		 	   				 
		 	   				   Thread.sleep(8000);
		 	   				   performerPOM.clickSaveCriteria().click();
		 	   				   Thread.sleep(8000);
		 	   				   String msg = performerPOM.readOppoenentMsg().getText();
		 	   				   
		 	   				   if(msg.equalsIgnoreCase("Criteria can not be empty."))
		 	   				   {
		 	   					   test.log(LogStatus.PASS, "Meassag Displayed ="+msg);
		 	   				   }
		 	   				   else
		 	   				   {
		 	   					   test.log(LogStatus.FAIL, "Meassag Displayed ="+msg);
		 	   				   }
		 	   				   
		 	   				   Thread.sleep(8000);
		 	   				   getDriver().switchTo().parentFrame();
		 	   				   performerPOM.clickclosecriteria().click();
		 	         }
		 			 
		 			public static void CaseExistingData( ExtentTest test, XSSFWorkbook workbook) throws InterruptedException, EncryptedDocumentException, IOException
					{
			 			
			 			//sheet = workbook.getSheetAt(6);		
						WebDriverWait wait = new WebDriverWait(getDriver(), 50);
						
								
						
						Thread.sleep(8000);
						JavascriptExecutor js = (JavascriptExecutor) getDriver();
					
						js.executeScript("window.scrollBy(0,-700)");
						Thread.sleep(8000);
						performerPOM.clickCaseOpencfo().click();						//Clicking on 'Open' Case
						Thread.sleep(8000);
						clickNewCase();
						

						
						progress();
						wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
						
						Thread.sleep(8000);
						selectCaseType();
						Thread.sleep(8000);
						clickDated1();
						Thread.sleep(8000);
						clickFinanicialYear();
						Thread.sleep(8000);
						clickRefNo1();
						Thread.sleep(3000);
						clickInternalCaseNo();
						Thread.sleep(3000);
						clickCaseTitle();
						Thread.sleep(3000);
						clickCaseAct();
						Thread.sleep(3000);
						clickUnderSection();
						Thread.sleep(3000);
						clickSearchCaseCategory();
						Thread.sleep(3000);
						clickCaseBudget();
						Thread.sleep(3000);
						clickCaseOpponent();
//						Thread.sleep(3000);
//						clickCaseOppLawyer();
						Thread.sleep(3000);
						clickCaseCourt();
						Thread.sleep(3000);
						clickCaseDescription();
						Thread.sleep(3000);
						selectCaseLocation();
						Thread.sleep(3000);
						clickCaseDepartment();
						Thread.sleep(3000);
						clickCaseOwner();
						Thread.sleep(3000);
						clickCaseRisk();
						Thread.sleep(3000);
						clickCaseInternalUser();
						
						Thread.sleep(3000);
						OverduePOM.clickSaveButton().click();						//Clicking on 'Save'button.
						
						Thread.sleep(1000);
						wait.until(ExpectedConditions.visibilityOf(performerPOM.CaseInvalidreadMessage()));
						
						Thread.sleep(500);
						String msg = performerPOM.CaseInvalidreadMessage().getText();		//Reading Message appeared after save button
						
						if(msg.equalsIgnoreCase("Case with Same Court Case No already exists"))
						{
							test.log(LogStatus.PASS, "Message displayed = "+msg);
							
						}
					else
						{
							test.log(LogStatus.FAIL, "Message displayed = "+msg);
						}
					

					
						getDriver().switchTo().parentFrame();
						performerPOM.clickClose().click();			//Clicking on 'Close'
						
					}
					
		 				public static void CaseWithInvalidData( ExtentTest test) throws InterruptedException, EncryptedDocumentException, IOException
		 				{
		 		 			
		 		 			//sheet = workbook.getSheetAt(6);		
		 					WebDriverWait wait = new WebDriverWait(getDriver(), 50);
		 					
		 					Thread.sleep(500);
		 					JavascriptExecutor js = (JavascriptExecutor) getDriver();
		 				
		 					js.executeScript("window.scrollBy(0,-700)");
		 					Thread.sleep(3000);
		 					performerPOM.clickCaseOpencfo().click();						//Clicking on 'Open' Case
		 					Thread.sleep(3000);
		 					clickNewCase();
		 					progress();
		 					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
		 					
		 					Thread.sleep(1000);
							selectCaseType();
							Thread.sleep(3000);
							clickInvalidDate();
							Thread.sleep(3000);
							clickFinanicialYear();
							Thread.sleep(3000);
							clickRefNo1();
							Thread.sleep(3000);
							clickInternalCaseNo();
							Thread.sleep(3000);
							clickCaseTitle();
							Thread.sleep(3000);
							clickCaseAct();
							Thread.sleep(3000);
							clickUnderSection();
							Thread.sleep(3000);
							clickSearchCaseCategory();
							Thread.sleep(3000);
							clickCaseBudget();
							Thread.sleep(3000);
							clickCaseOpponent();
//							Thread.sleep(3000);
//							clickCaseOppLawyer();
							Thread.sleep(3000);
							clickCaseCourt();
							Thread.sleep(3000);
							clickCaseDescription();
							Thread.sleep(3000);
							selectCaseLocation();
							Thread.sleep(3000);
							clickCaseDepartment();
							Thread.sleep(3000);
							clickCaseOwner();
							Thread.sleep(3000);
							clickCaseRisk();
							Thread.sleep(3000);
							clickCaseInternalUser();
		 					Thread.sleep(3000);
		 					OverduePOM.clickSaveButton().click();						//Clicking on 'Save'button.
		 					
		 					Thread.sleep(1000);
		 					wait.until(ExpectedConditions.visibilityOf(performerPOM.readMessageCase()));
		 					
		 					Thread.sleep(500);
		 					String msg = performerPOM.readMessageCase().getText();		//Reading Message appeared after save button
		 					
		 					if(msg.equalsIgnoreCase("Server Error Occurred. Please try again."))
		 					{
		 						test.log(LogStatus.FAIL, "Message displayed = "+msg);
		 						
		 					}
		 				else
		 					{
		 						test.log(LogStatus.PASS, "Message displayed = "+msg);
		 					}
		 				

		 				
		 					getDriver().switchTo().parentFrame();
		 					performerPOM.clickClose().click();			//Clicking on 'Close'
		 				}
		 				 public  static void clickInvalidDate() throws InterruptedException 
		 				  {
		 					  Thread.sleep(3000);
		 				      performerPOM.clickCaseDate().sendKeys("22-01-202");					//Clicking on 'Dated' button
		 				  }
		 				 
		 				 public static void CaseWithTwoFieldsData( ExtentTest test) throws InterruptedException
		 					{
		 			 			
		 			 				
		 						WebDriverWait wait = new WebDriverWait(getDriver(), 50);
		 						
		 						Thread.sleep(500);
		 						JavascriptExecutor js = (JavascriptExecutor) getDriver();
		 					
		 						js.executeScript("window.scrollBy(0,-700)");
		 						Thread.sleep(3000);
		 						performerPOM.clickCaseOpencfo().click();						//Clicking on 'Open' Case
		 						Thread.sleep(3000);
		 						clickNewCase();
		 						progress();
		 						wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
		 						
		 						Thread.sleep(1000);
								selectCaseType();
								Thread.sleep(3000);
								clickDated1();
		 						
		 						Thread.sleep(3000);
		 						OverduePOM.clickSaveButton().click();						//Clicking on 'Save'button.
		 						
		 						Thread.sleep(500);
		 						String msg = performerPOM.readMessageCase1().getText();		//Reading Message appeared after save button
		 						
		 						test.log(LogStatus.PASS, "Case With Two Manadatory Fields = "+msg);
		 							
		 					
		 					

		 					
		 						getDriver().switchTo().parentFrame();
		 						performerPOM.clickClose().click();			//Clicking on 'Close'
		 						
		 					}
		 				 
		 				 public static void CaseWithEmptyFields( ExtentTest test) throws InterruptedException
		 					{
		 			 			
		 						WebDriverWait wait = new WebDriverWait(getDriver(), 50);
		 						Thread.sleep(500);
		 						JavascriptExecutor js = (JavascriptExecutor) getDriver();
		 					
		 						js.executeScript("window.scrollBy(0,-700)");
		 						Thread.sleep(3000);
		 						performerPOM.clickCaseOpencfo().click();						//Clicking on 'Open' Case
		 						Thread.sleep(3000);
		 						clickNewCase();
		 						progress();
		 						wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
		 						Thread.sleep(3000);
		 						OverduePOM.clickSaveButton().click();						//Clicking on 'Save'button.
		 						
		 						Thread.sleep(500);
		 						String msg = performerPOM.readMessageCase1().getText();		//Reading Message appeared after save button
		 						
		 						test.log(LogStatus.PASS, "Case With Empty Fields = "+msg);
		 							
		 						getDriver().switchTo().parentFrame();
		 						performerPOM.clickClose().click();			//Clicking on 'Close'
		 					}
		 				 
		 					public static void CaseWithClearBtn( ExtentTest test) throws InterruptedException
		 					{
		 			 			
		 						WebDriverWait wait = new WebDriverWait(getDriver(), 50);
		 						
		 								
		 						
		 						Thread.sleep(500);
		 						JavascriptExecutor js = (JavascriptExecutor) getDriver();
		 					
		 						js.executeScript("window.scrollBy(0,-700)");
		 						Thread.sleep(3000);
		 						performerPOM.clickCaseOpencfo().click();						//Clicking on 'Open' Case
		 						Thread.sleep(3000);
		 						clickNewCase();
		 						
		 						progress();
		 						wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
		 				 	 		Thread.sleep(3000);
		 				 			clickDated();

		 				 			Thread.sleep(3000);
		 				 			clickFinancialYear();
		 				 	 		
		 				 			js.executeScript("window.scrollBy(0,-700)");
		 						 
		 				             if(performerPOM.clickCaseClearBtn().isEnabled())
		 					          {
		 					            Thread.sleep(2000);
		 					              performerPOM.clickCaseClearBtn().click();
		 					              test.log(LogStatus.PASS, "Clear Button is clickable");
		 					           }
		 					         else
		 					         {
		 					    	   test.log(LogStatus.FAIL, "Clear Button is not clickable");
		 					         }
		 				 
		 				     		Thread.sleep(3000);
		 				     		getDriver().switchTo().parentFrame();
		 				     		performerPOM.clickClose().click();//Clicking on 'Close'
		 				     		
		 				     		Thread.sleep(3000);
		 				     		OverduePOM.clickDashboard().click();
		 					}
		 					
		 					
		 					 public static void CaseSendMailWithDoc( ExtentTest test) throws InterruptedException, IOException
		 			 	 	 {
		 			 	 	 		   
		 			 	 	        	
		 			 	 	 			WebDriverWait wait = new WebDriverWait(getDriver(), 300);
		 			 	 	 			progress();
		 			 	 	 			
		 			 	 	 		
		 			 	 	 			
		 			 	 	 		  Thread.sleep(8000);
		 			 	 	          performerPOM.clickCaseOpen().click();
		 			 	 	     	Thread.sleep(8000);
		 			 				wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
		 			 				/*Thread.sleep(3000);
		 	 	 	 	        	performerPOM.clickTrignle1().click();		
		 	 	 	 	 			
		 			 				
		 	 	 	 	        	Thread.sleep(3000);
		 	 	 	 	        	performerPOM.clickFilter().click();		
		 	 	 	 	        	
		 	 	 	 	        	Thread.sleep(2000);
		 	 	 	 	     		wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
		 	 	 	 	 			
		 			 				
		 	 	 	 	        	Thread.sleep(5000);
		 	 	 	 	        	performerPOM.clickSearchFilterworkspace().sendKeys("4658461");	
		 	 	 	 	        	
		 	 	 	 	        	Thread.sleep(5000);
		 	 	 	 	     		performerPOM.clickCheckbox1().click();	
		  	 	 	        	
		 	 	 	 	        	
		 	 	 	 	        	Thread.sleep(5000);
		 	 	 	 	        	performerPOM.clickFilter1().click();	*/
		 			 				Thread.sleep(8000);
		 			 			      	performerPOM.clickEditNotice().click();
		 			 	 	 			
		 			 	 	 			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
		 			 	 	 			
		 			 	 	 		   Thread.sleep(8000);
		 			 	 	 		   performerPOM.clickSendMailCase().click();
		 			 	 	 		   
		 			 	 	 		 Thread.sleep(8000);
		 		 	 	 		 performerPOM.clickSelectCheckbox().click();
		 		 	 	 		
		 		 	 	 		 
		 		 	 	 		 Thread.sleep(8000);
		 		 	 	 		 performerPOM.clickMailTo().sendKeys("admin@gmail.com");
		 		 	 	 		 
		 		 	 	 		 Thread.sleep(8000);
		 		 	 	 		 performerPOM.clickMessageMail().sendKeys("Test");
		 		 	 	 		 
		 		 	 	 		 
		 		 	 	 		 Thread.sleep(8000);
		 		 	 	 		 performerPOM.clickSend().click();
		 		 	 	 		 
		 		 	 	 		Thread.sleep(8000);
		 		 	 	 		String msg= performerPOM.clickSendMailMsg().getText();
		 		 	 	 		
		 		 	 	 		if(msg.equalsIgnoreCase("E-Mail Sent Successfully."))
		 		 	 	 		{
		 		 	 	 			test.log(LogStatus.PASS ,"Message displayed =" +msg);
		 		 	 	 		}
		 		 	 	 		else
		 		 	 	 		{
		 		 	 	 			test.log(LogStatus.PASS ,"Message displayed =" +msg);
		 		 	 	 		}
		 		 	 	 		
		 		 	 			Thread.sleep(8000);
		 		 	 	     
		 		 	 	     	performerPOM.clickcloseBtn().click();//Clicking on 'Close'
		 		 	 	     	Thread.sleep(8000);
		 		 	 	     		getDriver().switchTo().parentFrame();
		 		 	 	     		performerPOM.clickClose().click();//Clicking on 'Close'
		 		 	 	     	
		 		 	 	     	Thread.sleep(8000);
		 		 	 	     		OverduePOM.clickDashboard().click();
		 			 	 	 
		 			 	 	 }
		 					 public static void CaseSendMailWithDocInvalidFields( ExtentTest test) throws InterruptedException, IOException
					 	 	 {
					 	 	
					 	 	 			WebDriverWait wait = new WebDriverWait(getDriver(), 300);
					 	 	 			progress();
					 	 	 			
					 	 	            Thread.sleep(8000);
					 	 	        	performerPOM.clickCaseOpencfo().click();		
					 	 	        	
					 	
					 	 	        	
					 	 	        	Thread.sleep(8000);
					 				wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
					 			/*	Thread.sleep(3000);
			 	 	 	        	performerPOM.clickTrignle1().click();		
			 	 	 	 			
					 				
			 	 	 	        	Thread.sleep(3000);
			 	 	 	        	performerPOM.clickFilter().click();		
			 	 	 	        	
			 	 	 	        	Thread.sleep(2000);
			 	 	 	     		wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
			 	 	 	 			
					 				
			 	 	 	        	Thread.sleep(5000);
			 	 	 	        	performerPOM.clickSearchFilterworkspace().sendKeys("4658461");	
			 	 	 	        	
			 	 	 	        	Thread.sleep(5000);
			 	 	 	     		performerPOM.clickCheckbox1().click();	
		 	 	 	        	
			 	 	 	        	
			 	 	 	        	Thread.sleep(5000);
			 	 	 	        	performerPOM.clickFilter1().click();	*/
					 	 	 			
					 	 	             Thread.sleep(8000);
					 	 	         
					 			      	performerPOM.clickEditNotice().click();
					 	 	 			
					 	 	 			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
					 	 	 			
					 	 	 		   Thread.sleep(8000);
					 	 	 		   performerPOM.clickSendMailCase().click();
					 	 	 		   
					 	 	 		 Thread.sleep(8000);
				 	 	 		 performerPOM.clickSelectCheckbox().click();
				 	 	 		 
				 	 	 		 Thread.sleep(8000);
				 	 	 		 performerPOM.clickMailTo().sendKeys("admin");
				 	 	 		 
				 	 	 		 Thread.sleep(8000);
				 	 	 		 performerPOM.clickMessageMail().sendKeys("Test");
				 	 	 		 
				 	 	 		 
				 	 	 		 Thread.sleep(8000);
				 	 	 		 performerPOM.clickSend().click();
				 	 	 		 
				 	 	 		Thread.sleep(8000);
				 	 	 		String msg= performerPOM.clickSendMailMsg().getText();
				 	 	 		
				 	 	 		if(msg.equalsIgnoreCase("Please enter a valid email."))
				 	 	 		{
				 	 	 			test.log(LogStatus.PASS ,"Message displayed =" +msg);
				 	 	 		}
				 	 	 		else
				 	 	 		{
				 	 	 			test.log(LogStatus.FAIL ,"Message displayed =" +msg);
				 	 	 		}
				 	 	 		
				 	 			Thread.sleep(8000);
				 	 	     
				 	 	     	performerPOM.clickcloseBtn().click();//Clicking on 'Close'
				 	 	     	Thread.sleep(8000);
				 	 	     		getDriver().switchTo().parentFrame();
				 	 	     		performerPOM.clickClose().click();//Clicking on 'Close'
				 	 	     	
				 	 	     	Thread.sleep(8000);
				 	 	     		OverduePOM.clickDashboard().click();
					 	 	 
					 	 	 }
							 public static void CaseSendMailWithEmptyFields( ExtentTest test) throws InterruptedException, IOException
					 	 	 {
					 	 	
					 	 	 			WebDriverWait wait = new WebDriverWait(getDriver(), 300);
					 	 	 			progress();
					 	 	 			
					 	 	            Thread.sleep(8000);
					 	 	        	performerPOM.clickCaseOpencfo().click();		
					 	 	        	
					 	 	       	Thread.sleep(8000);
					 				wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
					 			/*	Thread.sleep(3000);
			 	 	 	        	performerPOM.clickTrignle1().click();		
			 	 	 	 			
					 				
			 	 	 	        	Thread.sleep(3000);
			 	 	 	        	performerPOM.clickFilter().click();		
			 	 	 	        	
			 	 	 	        	Thread.sleep(2000);
			 	 	 	     		wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
			 	 	 	 			
					 				
			 	 	 	        	Thread.sleep(5000);
			 	 	 	        	performerPOM.clickSearchFilterworkspace().sendKeys("4658461");	
			 	 	 	        	
			 	 	 	        	Thread.sleep(5000);
			 	 	 	     		performerPOM.clickCheckbox1().click();	
		 	 	 	        	
			 	 	 	        	
			 	 	 	        	Thread.sleep(5000);
			 	 	 	        	performerPOM.clickFilter1().click();	*/
					 	 	 			
					 	 	             Thread.sleep(8000);
					 	 	         
					 			      	performerPOM.clickEditNotice().click();
					 	 	 			
					 	 	 			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
					 	 	 			
					 	 	 		   Thread.sleep(8000);
					 	 	 		   performerPOM.clickSendMailCase().click();
					 	 	 		   
					 	 	 		    Thread.sleep(8000);
				 	 	 		        performerPOM.clickSelectCheckbox().click();
				 	 	 		 
				 	 	 		         Thread.sleep(8000);
				 	 	 	        	 performerPOM.clickSend().click();
				 	 	 		 
				 	 	 		Thread.sleep(8000);
				 	 	 		String msg= performerPOM.clickSendMailMsg1().getText();
				 	 	 		
				 	 	 		test.log(LogStatus.PASS ,"Message displayed =" +msg);
				 	 	 		
				 	 	 		
				 	 			Thread.sleep(8000);
				 	 	     
				 	 	     	performerPOM.clickcloseBtn().click();//Clicking on 'Close'
				 	 	     	Thread.sleep(8000);
				 	 	     		getDriver().switchTo().parentFrame();
				 	 	     		performerPOM.clickClose().click();//Clicking on 'Close'
				 	 	     	
				 	 	     	Thread.sleep(8000);
				 	 	     		OverduePOM.clickDashboard().click();
					 	 	 
					 	 	 }
							 
							 public static void LinkCaseViewIcon( ExtentTest test) throws InterruptedException, IOException
					 	 	 {
					 	 	 		   
					 	 	        	
					 	 	 			WebDriverWait wait = new WebDriverWait(getDriver(), 300);
					 	 	 			progress();
					 	 	 			
					 	 	 		
					 	 	 			
					 	 	            Thread.sleep(8000);
					 	 	        	performerPOM.clickCaseOpencfo().click();	
					 	 	        	
					 	 	        	
					 	 	      	Thread.sleep(8000);
					 				wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
					 				/*Thread.sleep(3000);
			 	 	 	        	performerPOM.clickTrignle1().click();		
			 	 	 	 			
					 				
			 	 	 	        	Thread.sleep(3000);
			 	 	 	        	performerPOM.clickFilter().click();		
			 	 	 	        	
			 	 	 	        	Thread.sleep(2000);
			 	 	 	     		wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
			 	 	 	 			
					 				
			 	 	 	        	Thread.sleep(5000);
			 	 	 	        	performerPOM.clickSearchFilterworkspace().sendKeys("4658461");	
			 	 	 	        	
			 	 	 	        	Thread.sleep(5000);
			 	 	 	     		performerPOM.clickCheckbox1().click();	
		 	 	 	        	
			 	 	 	        	
			 	 	 	        	Thread.sleep(5000);
			 	 	 	        	performerPOM.clickFilter1().click();	*/
			 	 	 	        	
					 	 	 			
					 	 	            Thread.sleep(8000);
					 	 	            performerPOM.clickEditNotice().click();
					 	 	 			
					 	 	 			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
					 	 	 			
					 	 	 		
					 	 	 			Actions a = new Actions(getDriver());
					 	 				//scroll down a page
					 	 				a.sendKeys(Keys.PAGE_DOWN).build().perform();
					 	 				
					 	 	 			
					 	 	 		    Thread.sleep(8000);
					 	 	            performerPOM.clickLinkedCaseViewIcon().click();
				 			      	
				 			      	Thread.sleep(8000);
				 	 	 	        performerPOM.clickViewPopup().click();
				 	 	 	        
				 	 	 	        String msg="Linked Case Details";
				 	 	 	        
				 	 	 	        if(msg.equalsIgnoreCase(msg))
				 	 	 	        {
				 	 	 	        	test.log(LogStatus.PASS, "View Case Detailes icon open succssefully");
				 	 	 	        }
				 	 	 	        else
				 	 	 	        {
				 	 	 	        	test.log(LogStatus.FAIL, "View Case Detailes icon not open succssefully");

				 	 	 	        }
				 	 	 	        

					 	 	 		Thread.sleep(8000);
					 	 	        performerPOM.clickClosePopup1().click();
					 	 	     	Thread.sleep(8000);
					 	     		getDriver().switchTo().parentFrame();
					 	     		performerPOM.clickClose().click();//Clicking on 'Close'
					 	     	
					 	     	    Thread.sleep(8000);
					 	     		OverduePOM.clickDashboard().click();
					 	 	 			
					 	 	 }
							 public static void LinkCaseDeleteIcon( ExtentTest test) throws InterruptedException, IOException
					 	 	 {
					 	 
					 	 	 			WebDriverWait wait = new WebDriverWait(getDriver(), 300);
					 	 	 			progress();
					 	 	 			
					 	 	            Thread.sleep(500);
					 	 	        	performerPOM.clickCaseOpencfo().click();	
					 	 	        	
					 	 	        	
					 	 	       	Thread.sleep(1000);
					 				wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
					 				/*Thread.sleep(3000);
			 	 	 	        	performerPOM.clickTrignle1().click();		
			 	 	 	 			
					 				
			 	 	 	        	Thread.sleep(3000);
			 	 	 	        	performerPOM.clickFilter().click();		
			 	 	 	        	
			 	 	 	        	Thread.sleep(2000);
			 	 	 	     		wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
			 	 	 	 			
					 				
			 	 	 	        	Thread.sleep(5000);
			 	 	 	        	performerPOM.clickSearchFilterworkspace().sendKeys("4658461");	
			 	 	 	        	
			 	 	 	        	Thread.sleep(5000);
			 	 	 	     		performerPOM.clickCheckbox1().click();	
		 	 	 	        	
			 	 	 	        	
			 	 	 	        	Thread.sleep(5000);
			 	 	 	        	performerPOM.clickFilter1().click();	*/
					 	 	        	
					 	 	 			
					 	 	            Thread.sleep(4000);
					 	 	            performerPOM.clickEditNotice().click();
					 	 	 			
					 	 	 			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
					 	 	 			
					 	 	 		   	
					 	 	 						 	 	 			
					 	 	 		    Thread.sleep(4000);
					 	 	            performerPOM.clickLinkedCaseDeleteIcon().click();
				 			      	
					 	 	         Thread.sleep(5000);
					 			    // Switching to Alert        
					 		        Alert alert1 = getDriver().switchTo().alert();		
					 		        		
					 		        // Capturing alert message.    
					 		        String alertMessage1= getDriver().switchTo().alert().getText();	
					 		        
					 		        
					 		        test.log(LogStatus.PASS, alertMessage1);
					 		        		
					 		        // Displaying alert message		
					 		        System.out.println(alertMessage1);
					 		        
					 		       // Accepting alert		
					 		        alert1.accept();	
					 		        
					 		  /*   Thread.sleep(4000);
				 	 	       String msg= performerPOM.clickLinkedCaseDeleteIconValidMsg().getText();
				 	 	       
				 	 	       test.log(LogStatus.PASS, "Message Displayed =" +msg);*/
				 	 	 	        

					 	 	     	Thread.sleep(3000);
					 	     		getDriver().switchTo().parentFrame();
					 	     		performerPOM.clickClose().click();//Clicking on 'Close'
					 	     	
					 	     	    Thread.sleep(3000);
					 	     		OverduePOM.clickDashboard().click();
					 	 	 			
					 	 	 }
							 
							 public static void CaseWithoutUploadDocument(ExtentTest test) throws InterruptedException
								{
						           			
								
						          WebDriverWait wait = new WebDriverWait(getDriver(), 50);
						          Thread.sleep(8000);
						          performerPOM.clickCaseOpen().click();
						          
					 			     
						       	Thread.sleep(8000);
				 				wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
				 				/*Thread.sleep(3000);
		 	 	 	        	performerPOM.clickTrignle1().click();		
		 	 	 	 			
				 				
		 	 	 	        	Thread.sleep(3000);
		 	 	 	        	performerPOM.clickFilter().click();		
		 	 	 	        	
		 	 	 	        	Thread.sleep(2000);
		 	 	 	     		wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
		 	 	 	 			
				 				
		 	 	 	        	Thread.sleep(5000);
		 	 	 	        	performerPOM.clickSearchFilterworkspace().sendKeys("4658461");	
		 	 	 	        	
		 	 	 	        	Thread.sleep(5000);
		 	 	 	     		performerPOM.clickCheckbox1().click();	
			 	 	        	
		 	 	 	        	
		 	 	 	        	Thread.sleep(5000);
		 	 	 	        	performerPOM.clickFilter1().click();	*/
		 	 	 	        	
						          Thread.sleep(8000);
						          performerPOM.clickEditNotice().click();
								  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
								  Thread.sleep(8000);
								  performerPOM.clickNoticeDocument().click();     //click notice document
								  Thread.sleep(8000);
								  performerPOM.clickNewDocument().click();        //click new document button
								
						 
									Thread.sleep(8000);
									getDriver().switchTo().frame("IFrameManageDocument");
									
									performerPOM.selectDocumentType();
							           Thread.sleep(8000);
								        performerPOM.chooseDocumentType();
							          	
								        Thread.sleep(8000);
							         	performerPOM.clickUploadDocument().click(); 
								
								
							         	Thread.sleep(8000);
							         	wait.until(ExpectedConditions.visibilityOf(performerPOM.readDocMsg()));
								
							        	Thread.sleep(8000);
								        String msg= performerPOM.readDocMsg().getText();		//Reading Message appeared after save button
								       
							         	if(msg.equalsIgnoreCase("Please select file to upload"))
							         	{
								        	test.log(LogStatus.PASS, "Message displayed = "+msg);
								         
								        }
								      else
								        {
									       test.log(LogStatus.FAIL, "Message displayed = "+msg);
								        }
								
								        Thread.sleep(8000);
								        performerPOM.clickClosedDocument().click();
								        
								       getDriver().switchTo().parentFrame();
								      
								      Thread.sleep(8000);
							     		getDriver().switchTo().parentFrame();
							     		performerPOM.clickClose().click();//Clicking on 'Close'
							       	}
							 
								public static void CaseDocumentEmptyFields( ExtentTest test) throws InterruptedException
						       	{
						    		WebDriverWait wait = new WebDriverWait(getDriver(), 50);
						             
						    	
						    		
							        Thread.sleep(8000);
									performerPOM.clickCaseOpencfo().click();//click edit notice
									
								 	Thread.sleep(8000);
					 				wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
					 				/*Thread.sleep(3000);
			 	 	 	        	performerPOM.clickTrignle1().click();		
			 	 	 	 			
					 				
			 	 	 	        	Thread.sleep(3000);
			 	 	 	        	performerPOM.clickFilter().click();		
			 	 	 	        	
			 	 	 	        	Thread.sleep(2000);
			 	 	 	     		wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
			 	 	 	 			
					 				
			 	 	 	        	Thread.sleep(5000);
			 	 	 	        	performerPOM.clickSearchFilterworkspace().sendKeys("4658461");	
			 	 	 	        	
			 	 	 	        	Thread.sleep(5000);
			 	 	 	     		performerPOM.clickCheckbox1().click();	
		 	 	 	        	
			 	 	 	        	
			 	 	 	        	Thread.sleep(5000);
			 	 	 	        	performerPOM.clickFilter1().click();	*/
							     
							        Thread.sleep(8000);
									performerPOM.clickEditNotice().click();//click edit notice
									
									wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
									
									 Thread.sleep(8000);
							        performerPOM.clickNoticeDocument().click();     //click notice document
							        Thread.sleep(8000);
							        performerPOM.clickNewDocument().click();        //click new document button
							
							        Thread.sleep(8000);
						           	getDriver().switchTo().frame("IFrameManageDocument");
						  
							        Thread.sleep(8000);
						         	performerPOM.clickUploadDocument().click(); 
							
							
						         	Thread.sleep(8000);
						         	wait.until(ExpectedConditions.visibilityOf(performerPOM.readDocMsg()));
							
						        	Thread.sleep(8000);
							        String msg= performerPOM.readDocMsgInvalidMsg().getText();		//Reading Message appeared after save button
							       
						         	if(msg.equalsIgnoreCase("Please select document type"))
						         	{
							        	test.log(LogStatus.PASS, "Message displayed = "+msg);
							         
							        }
							      else
							        {
								       test.log(LogStatus.FAIL, "Message displayed = "+msg);
							        }
							
						         	
							        Thread.sleep(8000);
							        performerPOM.clickClosedDocument().click(); 
							       getDriver().switchTo().parentFrame();
							      
							      Thread.sleep(8000);
						     		getDriver().switchTo().parentFrame();
						     		performerPOM.clickClose().click();//Clicking on 'Close'
						    }
								
								public static void CaseDocumentSearchFields( ExtentTest test) throws InterruptedException
						       	{
						    		WebDriverWait wait = new WebDriverWait(getDriver(), 50);
						             
						    		
							        Thread.sleep(8000);
									performerPOM.clickCaseOpencfo().click();//click edit notice
							     
					 			     
						   			  Thread.sleep(8000);
						  			wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
							        Thread.sleep(8000);
									performerPOM.clickEditNotice().click();//click edit notice
									
									wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));

							        Thread.sleep(8000);
									 performerPOM.clickNoticeDocument().click();     //click notice document
									
									Thread.sleep(8000);
						 			performerPOM.clickSearchDocument().sendKeys("Approver Test Case.xlsx");
						 			
						 			Thread.sleep(8000);
									performerPOM.clickApplyBtn().click();
									Thread.sleep(8000);
									String msg=performerPOM.clickDocName1().getText();
									if(msg.equalsIgnoreCase(msg)) 
									{
										test.log(LogStatus.PASS,"Document Filter Apply =" +msg);
									}
									else
									{
										test.log(LogStatus.FAIL,"Document Filter Apply  =" +msg);
									}
									
									Thread.sleep(8000);
						     		getDriver().switchTo().parentFrame();
						     		performerPOM.clickClose().click();//Clicking on 'Close'
									
									
						       	}
								
								public static void CaseDocumentShareInvalidData( ExtentTest test) throws InterruptedException
						       	{
						    		WebDriverWait wait = new WebDriverWait(getDriver(), 50);
						             
						    		
							        Thread.sleep(8000);
									performerPOM.clickCaseOpencfo().click();//click edit notice
					 			     
								 	Thread.sleep(8000);
					 				wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
					 				/*Thread.sleep(3000);
			 	 	 	        	performerPOM.clickTrignle1().click();		
			 	 	 	 			
					 				
			 	 	 	        	Thread.sleep(3000);
			 	 	 	        	performerPOM.clickFilter().click();		
			 	 	 	        	
			 	 	 	        	Thread.sleep(2000);
			 	 	 	     		wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
			 	 	 	 			
					 				
			 	 	 	        	Thread.sleep(5000);
			 	 	 	        	performerPOM.clickSearchFilterworkspace().sendKeys("4658461");	
			 	 	 	        	
			 	 	 	        	Thread.sleep(5000);
			 	 	 	     		performerPOM.clickCheckbox1().click();	
		 	 	 	        	
			 	 	 	        	
			 	 	 	        	Thread.sleep(5000);
			 	 	 	        	performerPOM.clickFilter1().click();	*/
			 	 	 	        	
							        Thread.sleep(8000);
									performerPOM.clickEditNotice().click();//click edit notice
									
									wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));

							        Thread.sleep(8000);
									 performerPOM.clickNoticeDocument().click();     //click notice document
									 
									 Thread.sleep(8000);
							        performerPOM.clickCaseDocumentsharecfo().click();
							        
							        Thread.sleep(8000);
								    // Switching to Alert        
							        Alert alert1 = getDriver().switchTo().alert();		
							        		
							        // Capturing alert message.    
							        String alertMessage1= getDriver().switchTo().alert().getText();	
							        
							        
							        test.log(LogStatus.PASS, alertMessage1);
							        		
							        // Displaying alert message		
							        System.out.println(alertMessage1);
							        
							     // Accepting alert		
							        alert1.accept();	
							        
							        Thread.sleep(8000);
							        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("Iframe_Docshare"));
							        
							        Thread.sleep(8000);
							        performerPOM.clickNoticeDocumentshareemailcfo().sendKeys("admin");
							        
							        Thread.sleep(8000);
							        performerPOM.clickNoticeDocumentsharecontactnocfo().sendKeys("576879");
							        
							        Thread.sleep(8000);
							        performerPOM.clickNoticeDocumentsharesavecfo().click();
							        
							        
							        Thread.sleep(8000);
							        String msg1= performerPOM.clickNoticeDocumentshareInvalidmsgcfo().getText();		//Reading Message appeared after save button
							       
						         
							        	test.log(LogStatus.PASS, "Message displayed = "+msg1);
							      
							        
							        Thread.sleep(8000);
							        performerPOM. clickNoticeDocumentshareclosepopupcfo().click();
							        
							       getDriver().switchTo().parentFrame();
							      
							        Thread.sleep(8000);
						     		getDriver().switchTo().parentFrame();
						     		performerPOM.clickClose().click();//Clicking on 'Close'
						       	}
					 		
					 		public static void CaseDocumentShareWithoutData( ExtentTest test) throws InterruptedException
						       	{
						    		WebDriverWait wait = new WebDriverWait(getDriver(), 50);
						             
						    		
							        Thread.sleep(8000);
									performerPOM.clickCaseOpencfo().click();//click edit notice
								 	Thread.sleep(8000);
					 				wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
					 				/*Thread.sleep(3000);
			 	 	 	        	performerPOM.clickTrignle1().click();		
			 	 	 	 			
					 				
			 	 	 	        	Thread.sleep(3000);
			 	 	 	        	performerPOM.clickFilter().click();		
			 	 	 	        	
			 	 	 	        	Thread.sleep(2000);
			 	 	 	     		wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
			 	 	 	 			
					 				
			 	 	 	        	Thread.sleep(5000);
			 	 	 	        	performerPOM.clickSearchFilterworkspace().sendKeys("4658461");	
			 	 	 	        	
			 	 	 	        	Thread.sleep(6000);
			 	 	 	     		performerPOM.clickCheckbox1().click();	
		 	 	 	        	
			 	 	 	        	
			 	 	 	        	Thread.sleep(5000);
			 	 	 	        	performerPOM.clickFilter1().click();	*/
			 	 	 	        	
							        Thread.sleep(8000);
									performerPOM.clickEditNotice().click();//click edit notice
									
									wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));

							        Thread.sleep(8000);
									 performerPOM.clickNoticeDocument().click();     //click notice document
									 
									 Thread.sleep(8000);
							        performerPOM.clickCaseDocumentsharecfo().click();
							        
							        Thread.sleep(8000);
								    // Switching to Alert        
							        Alert alert1 = getDriver().switchTo().alert();		
							        		
							        // Capturing alert message.    
							        String alertMessage1= getDriver().switchTo().alert().getText();	
							        
							        
							        test.log(LogStatus.PASS, alertMessage1);
							        		
							        // Displaying alert message		
							        System.out.println(alertMessage1);
							        
							     // Accepting alert		
							        alert1.accept();	
							        
							       Thread.sleep(8000);
						        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("Iframe_Docshare"));
							        
							      
							        
							        Thread.sleep(8000);
							        performerPOM.clickNoticeDocumentsharesavecfo().click();
							        
							        
							        Thread.sleep(8000);
							        String msg1= performerPOM.clickNoticeDocumentsharereadmsgcfo().getText();		//Reading Message appeared after save button
							        if(msg1.equalsIgnoreCase(msg1))
							        {
						         
							        	test.log(LogStatus.PASS, "Message displayed = "+msg1);
							        }
							        else
							        {
							        	test.log(LogStatus.FAIL, "Message displayed = "+msg1);
							        }
							        
							        Thread.sleep(8000);
							        performerPOM. clickNoticeDocumentshareclosepopupcfo().click();
							        
							       getDriver().switchTo().parentFrame();
							      
							        Thread.sleep(8000);
						     		getDriver().switchTo().parentFrame();
						     		performerPOM.clickClose().click();//Clicking on 'Close'
						       	}
					 		public static void CaseDocumentShareCloseBtn( ExtentTest test) throws InterruptedException
						       	{
						    		WebDriverWait wait = new WebDriverWait(getDriver(), 50);
						             
						    		
							        Thread.sleep(8000);
									performerPOM.clickCaseOpencfo().click();//click edit notice
									
								 	Thread.sleep(8000);
					 				wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
					 			/*	Thread.sleep(3000);
			 	 	 	        	performerPOM.clickTrignle1().click();		
			 	 	 	 			
					 				
			 	 	 	        	Thread.sleep(3000);
			 	 	 	        	performerPOM.clickFilter().click();		
			 	 	 	        	
			 	 	 	        	Thread.sleep(2000);
			 	 	 	     		wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
			 	 	 	 			
					 				
			 	 	 	        	Thread.sleep(5000);
			 	 	 	        	performerPOM.clickSearchFilterworkspace().sendKeys("4658461");	
			 	 	 	        	
			 	 	 	        	Thread.sleep(5000);
			 	 	 	     		performerPOM.clickCheckbox1().click();	
		 	 	 	        	
			 	 	 	        	
			 	 	 	        	Thread.sleep(5000);
			 	 	 	        	performerPOM.clickFilter1().click();	*/
							     
							        Thread.sleep(8000);
									performerPOM.clickEditNotice().click();//click edit notice
									
									wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));

							        Thread.sleep(8000);
									 performerPOM.clickNoticeDocument().click();     //click notice document
									 
									 
									 Thread.sleep(8000);
							        performerPOM.clickCaseDocumentsharecfo().click();
							        
							       Thread.sleep(8000);
							    // Switching to Alert        
						        Alert alert1 = getDriver().switchTo().alert();		
						        		
						        // Capturing alert message.    
						        String alertMessage1= getDriver().switchTo().alert().getText();	
						        
						        
//						        test.log(LogStatus.PASS, alertMessage1);
						        		
						        // Displaying alert message		
						        System.out.println(alertMessage1);
						        
						     // Accepting alert		
						        alert1.accept();	
						        
						       Thread.sleep(8000);
						        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("Iframe_Docshare"));

					     	      Thread.sleep(8000);
					             if(performerPOM.clickNoticeDocumentshareclosepopupcfo().isEnabled())
					             {
					              Thread.sleep(8000);
					              performerPOM.clickNoticeDocumentshareclosepopupcfo().click();
					              test.log(LogStatus.PASS, "Close Button is clickable");
					             }
					            else
					           {
					    	     test.log(LogStatus.FAIL, "Close Button is not clickable");
					           }
					           
					   	     		getDriver().switchTo().parentFrame();
					   	     	getDriver().switchTo().parentFrame();
					   	     	   Thread.sleep(8000);
					   	     		performerPOM.clickClose().click();//Clicking on 'Close'
					   	     	
						       }
					 		 public static void CaseTaskActivityWithoutData( ExtentTest test) throws InterruptedException, IOException
								{
								    WebDriverWait wait=new WebDriverWait(getDriver(),20);
								    
							       Thread.sleep(8000);
									performerPOM.clickCaseOpencfo().click();//click edit notice
								 	Thread.sleep(8000);
					 				wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
					 			/*	Thread.sleep(3000);
			 	 	 	        	performerPOM.clickTrignle1().click();		
			 	 	 	 			
					 				
			 	 	 	        	Thread.sleep(3000);
			 	 	 	        	performerPOM.clickFilter().click();		
			 	 	 	        	
			 	 	 	        	Thread.sleep(2000);
			 	 	 	     		wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
			 	 	 	 			
					 				
			 	 	 	        	Thread.sleep(5000);
			 	 	 	        	performerPOM.clickSearchFilterworkspace().sendKeys("4658461");	
			 	 	 	        	
			 	 	 	        	Thread.sleep(5000);
			 	 	 	     		performerPOM.clickCheckbox1().click();	
		 	 	 	        	
			 	 	 	        	
			 	 	 	        	Thread.sleep(5000);
			 	 	 	        	performerPOM.clickFilter1().click();	*/
							        Thread.sleep(8000);
									performerPOM.clickEditNotice().click();//click edit notice
							      
								    Thread.sleep(8000);
								   
								    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
								    Thread.sleep(8000);
								    performerPOM.clickCaseTask().click();
								    Thread.sleep(8000);
								    performerPOM.clickCaseNewTask().click();
								    
								    Thread.sleep(8000);
					  				OverduePOM.clickSaveButton().click();				//Clicking on 'Save' button.
					  				
//					  			  Thread.sleep(3000);
//									performerPOM.clickMinimize().click();
								    

					  				Thread.sleep(8000);
					  				String msg1 = performerPOM.readTaskMsg2().getText();
					  				
					  					test.log(LogStatus.PASS, "Task/Activity Without data ="+msg1);
					  				
					  				
					  					Thread.sleep(8000);
					  		     		getDriver().switchTo().parentFrame();
					  		     		performerPOM.clickClose().click();//Clicking on 'Close'
					  				
					  			}
					 		 
					 	
					 		 public  static void CaseTaskActivtityResponseWithoutStatus( ExtentTest test) throws InterruptedException, IOException
								{ 
						 		   WebDriverWait wait = new WebDriverWait(getDriver(), 60);
						 			  Thread.sleep(8000);
						 				performerPOM.clickCaseOpencfo().click();//click edit notice
						 			 	Thread.sleep(8000);
						 				wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
						 			
						 		        Thread.sleep(8000);
						 				performerPOM.clickEditNotice().click();//click edit notice
						 			   
									   wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
									    Thread.sleep(8000);
									    performerPOM.clickCaseTask().click();
									  

									Thread.sleep(8000);
									performerPOM.clickNoticeTaskEditResponsecfo1().click();
									
									//Thread.sleep(8000);
//									performerPOM.clickMinimize().click();	
									
									Thread.sleep(8000);
									wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
									
									
									
									Thread.sleep(8000);
									performerPOM.clickNoticeTaskcmtResponsecfo().sendKeys("Automate Test");
									
									Thread.sleep(8000);
									performerPOM.clickNoticeTaskSaveResponsecfo().click();
									
									Thread.sleep(8000);
									String msg=performerPOM.clickInvalidResponsemsg().getText();
									if(msg.equalsIgnoreCase("Provide Response Status."))
									{
									    test.log(LogStatus.PASS, "Mesaage displayed ="+msg);
									}
									else
									{
										 test.log(LogStatus.FAIL, "Mesaage displayed ="+msg);
									}
									getDriver().switchTo().parentFrame();
									
									Thread.sleep(8000);
									performerPOM.clickNoticeTaskCloseResponsecfo().click();
									
									getDriver().switchTo().parentFrame();
						   	     	Thread.sleep(8000);
						   	     	performerPOM.clickClose().click();//Clicking on 'Close'
									
					          
								}
					 		 
					 		 public  static void CaseTaskActivtityResponseClearBtn( ExtentTest test) throws InterruptedException, IOException
								{ 
						 		   WebDriverWait wait = new WebDriverWait(getDriver(), 60);
						 			  Thread.sleep(8000);
						 				performerPOM.clickCaseOpencfo().click();//click edit notice
						 				
						 			 	Thread.sleep(8000);
						 				wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
						 				/*Thread.sleep(3000);
				 	 	 	        	performerPOM.clickTrignle1().click();		
				 	 	 	 			
						 				
				 	 	 	        	Thread.sleep(3000);
				 	 	 	        	performerPOM.clickFilter().click();		
				 	 	 	        	
				 	 	 	        	Thread.sleep(2000);
				 	 	 	     		wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
				 	 	 	 			
						 				
				 	 	 	        	Thread.sleep(5000);
				 	 	 	        	performerPOM.clickSearchFilterworkspace().sendKeys("4658461");	
				 	 	 	        	
				 	 	 	        	Thread.sleep(5000);
				 	 	 	     		performerPOM.clickCheckbox1().click();	
			 	 	 	        	
				 	 	 	        	
				 	 	 	        	Thread.sleep(5000);
				 	 	 	        	performerPOM.clickFilter1().click();	*/
						 		     
						 		        Thread.sleep(8000);
						 				performerPOM.clickEditNotice().click();//click edit notice
						 				  Thread.sleep(8000);
									   wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
									   
									   Thread.sleep(8000);
									    performerPOM.clickCaseTask().click();
								

									Thread.sleep(8000);
									performerPOM.clickNoticeTaskEditResponsecfo1().click();
									
									Thread.sleep(8000);
									wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
									
									Thread.sleep(8000);
									performerPOM.clickNoticeTaskstatusResponsecfo().click();
									
									Thread.sleep(8000);
									performerPOM.clickNoticeTaskstatusResponsecfo1().click();
									
									
									if(performerPOM.clickClearResponse().isEnabled())
							  		{
										Thread.sleep(8000);
							  			performerPOM.clickClearResponse().click();
							  			test.log(LogStatus.PASS, "Clear button working successfully");
							  		}
							  		else
							  		{
							  			test.log(LogStatus.FAIL, "Clear button not working successfully");
							  		}
									 
		                            getDriver().switchTo().parentFrame();
									
									Thread.sleep(8000);
									performerPOM.clickNoticeTaskCloseResponsecfo().click();
									
									getDriver().switchTo().parentFrame();
						   	     	Thread.sleep(8000);
						   	     	performerPOM.clickClose().click();//Clicking on 'Close'
			              }
					 		 

					 	
					 		
					 		 public static void CaseHearingWithoutData( ExtentTest test) throws InterruptedException, IOException
								{
								       WebDriverWait wait=new WebDriverWait(getDriver(),20);
								   
								       
								       Thread.sleep(8000);
						 				performerPOM.clickCaseOpencfo().click();//click edit notice
						 			 	Thread.sleep(8000);
						 				wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
						 			/*	Thread.sleep(3000);
				 	 	 	        	performerPOM.clickTrignle1().click();		
				 	 	 	 			
						 				
				 	 	 	        	Thread.sleep(3000);
				 	 	 	        	performerPOM.clickFilter().click();		
				 	 	 	        	
				 	 	 	        	Thread.sleep(2000);
				 	 	 	     		wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
				 	 	 	 			
						 				
				 	 	 	        	Thread.sleep(5000);
				 	 	 	        	performerPOM.clickSearchFilterworkspace().sendKeys("4658461");	
				 	 	 	        	
				 	 	 	        	Thread.sleep(5000);
				 	 	 	     		performerPOM.clickCheckbox1().click();	
			 	 	 	        	
				 	 	 	        	
				 	 	 	        	Thread.sleep(5000);
				 	 	 	        	performerPOM.clickFilter1().click();	*/ 
						 		        Thread.sleep(8000);
						 				performerPOM.clickEditNotice().click();//click edit notice
						 			  
									   wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
									    performerPOM.clickCaseHearing().click();
										Thread.sleep(8000);
										performerPOM.clickNewCaseHearing().click();
										Thread.sleep(8000);
									    performerPOM.clickSaveCaseHearing().click();
									    Thread.sleep(8000);
										performerPOM.clickMinimizeHearing().click();	
										 
										String msg = performerPOM.clickReadHearingMsg1().getText();
										test.log(LogStatus.PASS, "Case  without hearing data =" +msg);
										 Thread.sleep(8000);
										  getDriver().switchTo().parentFrame();
								   	     	Thread.sleep(8000);
								   	     	performerPOM.clickClose().click();//Clicking on 'Close'
								}
					 		 
					 		public static void CaseHearingInvalidDate( ExtentTest test) throws InterruptedException, IOException
							{
							       WebDriverWait wait=new WebDriverWait(getDriver(),20);
							      
							       
							       Thread.sleep(10000);
									performerPOM.clickCaseOpencfo().click();//click edit notice
									
								 	Thread.sleep(8000);
					 				wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
					 				/*Thread.sleep(3000);
			 	 	 	        	performerPOM.clickTrignle1().click();		
			 	 	 	 			
					 				
			 	 	 	        	Thread.sleep(3000);
			 	 	 	        	performerPOM.clickFilter().click();		
			 	 	 	        	
			 	 	 	        	Thread.sleep(2000);
			 	 	 	     		wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
			 	 	 	 			
					 				
			 	 	 	        	Thread.sleep(5000);
			 	 	 	        	performerPOM.clickSearchFilterworkspace().sendKeys("4658461");	
			 	 	 	        	
			 	 	 	        	Thread.sleep(5000);
			 	 	 	     		performerPOM.clickCheckbox1().click();	
		 	 	 	        	
			 	 	 	        	
			 	 	 	        	Thread.sleep(5000);
			 	 	 	        	performerPOM.clickFilter1().click();	*/
							     
							        Thread.sleep(8000);
									performerPOM.clickEditNotice().click();//click edit notice
								  
								   wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
							       
							       Thread.sleep(8000);
								   performerPOM.clickCaseHearing().click();
									Thread.sleep(8000);
									performerPOM.clickNewCaseHearing().click();
									
									Thread.sleep(8000);
									performerPOM.clickCaseHearingDate().sendKeys("31-05-202");	//Writing 'HearingDate'
								   Thread.sleep(8000);
								    performerPOM.clickSaveCaseHearingDate().click();
								
							
								    Thread.sleep(8000);
									String msg = performerPOM.clickReadHearingMsg1().getText();
									if(msg.contains("Server Error Occurred. Please try again."))
									{
										test.log(LogStatus.FAIL, "Case with Invalid Hearing Date=" +msg);
									}
									else
									{
										test.log(LogStatus.PASS, "Case with Invalid Hearing Date=" +msg);
									}
									
									  getDriver().switchTo().parentFrame();
							   	     	Thread.sleep(8000);
							   	     	performerPOM.clickClose().click();//Clicking on 'Close'
							}
					 		
					 		 public static void CaseHearingClearBtn( ExtentTest test) throws InterruptedException, IOException
								{
								       WebDriverWait wait=new WebDriverWait(getDriver(),20);
								     
								       
								       Thread.sleep(8000);
										performerPOM.clickCaseOpencfo().click();//click edit notice
										
									 	Thread.sleep(8000);
						 				wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
						 				/*Thread.sleep(3000);
				 	 	 	        	performerPOM.clickTrignle1().click();		
				 	 	 	 			
						 				
				 	 	 	        	Thread.sleep(3000);
				 	 	 	        	performerPOM.clickFilter().click();		
				 	 	 	        	
				 	 	 	        	Thread.sleep(2000);
				 	 	 	     		wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
				 	 	 	 			
						 				
				 	 	 	        	Thread.sleep(5000);
				 	 	 	        	performerPOM.clickSearchFilterworkspace().sendKeys("4658461");	
				 	 	 	        	
				 	 	 	        	Thread.sleep(5000);
				 	 	 	     		performerPOM.clickCheckbox1().click();	
			 	 	 	        	
				 	 	 	        	
				 	 	 	        	Thread.sleep(5000);
				 	 	 	        	performerPOM.clickFilter1().click();	*/
								     
								        Thread.sleep(8000);
										performerPOM.clickEditNotice().click();//click edit notice
									  
									   wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
								       Thread.sleep(8000);
									   performerPOM.clickCaseHearing().click();
										Thread.sleep(8000);
										performerPOM.clickNewCaseHearing().click();
										Thread.sleep(8000);
										performerPOM.clickCaseHearingDecsri().sendKeys("abc");		//Writing 'HearingDescription'
										
										if(performerPOM.clickHearingClearBtn().isEnabled())
										{

											Thread.sleep(8000);
										   performerPOM.clickHearingClearBtn().click();
										   
										   test.log(LogStatus.PASS,"After clicking the clear button the data should be remove");
										}
										else
										{
											 test.log(LogStatus.FAIL,"After clicking the clear button the data should not be remove");
										}

										  getDriver().switchTo().parentFrame();
								   	     	Thread.sleep(8000);
								   	     	performerPOM.clickClose().click();//Clicking on 'Close'
								}
					 		 
					 		public static void CaseOrderWithExistingData( ExtentTest test) throws InterruptedException, EncryptedDocumentException, IOException
							{
								
								
								 WebDriverWait wait=new WebDriverWait(getDriver(),20);
								 
							     Thread.sleep(8000);
						          performerPOM.clickCaseOpen().click();
						          
						       	Thread.sleep(8000);
				 				wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
				 			/*	Thread.sleep(3000);
		 	 	 	        	performerPOM.clickTrignle1().click();		
		 	 	 	 			
				 				
		 	 	 	        	Thread.sleep(3000);
		 	 	 	        	performerPOM.clickFilter().click();		
		 	 	 	        	
		 	 	 	        	Thread.sleep(2000);
		 	 	 	     		wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
		 	 	 	 			
				 				
		 	 	 	        	Thread.sleep(5000);
		 	 	 	        	performerPOM.clickSearchFilterworkspace().sendKeys("4658461");	
		 	 	 	        	
		 	 	 	        	Thread.sleep(5000);
		 	 	 	     		performerPOM.clickCheckbox1().click();	
			 	 	        	
		 	 	 	        	
		 	 	 	        	Thread.sleep(5000);
		 	 	 	        	performerPOM.clickFilter1().click();	*/
		 	 	 	        	
						          Thread.sleep(8000);
						          performerPOM.clickEditNotice().click();
						          
						         // sheet = workbook.getSheetAt(6);	
								 
								// getDriver().switchTo().parentFrame();
								  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
								 Thread.sleep(8000);
								 performerPOM.clickCaseOrder().click();
								 Thread.sleep(8000);
								 performerPOM.clickNewCaseOrder().click();
								 Thread.sleep(8000);
								 performerPOM. clickCaseOrderDate().sendKeys("16-05-2023");
								 Thread.sleep(8000);
								 performerPOM.clickOrderPanel().click();
								 Thread.sleep(8000);
								 performerPOM. clickCaseOrderType().click();
								 Thread.sleep(8000);
								 performerPOM.selectCaseOrderType().click();
								
								 FileInputStream fis = new FileInputStream(filePath);
							        Workbook workbook = WorkbookFactory.create(fis);
							        Sheet sheet = workbook.getSheetAt(6);
								 Thread.sleep(8000);
								Row row0 = sheet.getRow(153);					//Selected 0th index row (First row)
							    Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
								int OrderTitle = (int) c1.getNumericCellValue();
								performerPOM.clickCaseOrderTitle().sendKeys(OrderTitle+"");	//Writing 'HearingDate'
						
								 Thread.sleep(8000);
								 Row row2 = sheet.getRow(154);									//Selected 0th index row (First row)
								 Cell c2 = row2.getCell(1);									//Selected cell (0 row,1 column)
								 String OrderDecri = c2.getStringCellValue();
								 performerPOM.clickCaseOrderDecri().sendKeys(OrderDecri);     //click oder description
								
								 Thread.sleep(8000);;
								 performerPOM.clickCaseorderFile();

								 Thread.sleep(8000);
								 performerPOM.clickSaveCaseOrder().click();
								 
								 
								 Thread.sleep(8000);
									String msg = performerPOM.clickReadOrderMsg().getText();
									if(msg.contains(msg))
									{
										test.log(LogStatus.FAIL, "Existing Order =" +msg);
									}
									else
									{
										test.log(LogStatus.PASS, "Existing Order =" +msg);
									}
									

									 getDriver().switchTo().parentFrame();
							   	     	Thread.sleep(8000);
							   	     	performerPOM.clickClose().click();//Clicking on 'Close'
						}
					 		
					public static void CaseOrderWithoutData( ExtentTest test) throws InterruptedException, IOException
							{
								  WebDriverWait wait=new WebDriverWait(getDriver(),20);
								
								    Thread.sleep(8000);
									performerPOM.clickCaseOpencfo().click();//click edit notice
									
								 	Thread.sleep(8000);
					 				wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
					 				/*Thread.sleep(3000);
			 	 	 	        	performerPOM.clickTrignle1().click();		
			 	 	 	 			
					 				
			 	 	 	        	Thread.sleep(3000);
			 	 	 	        	performerPOM.clickFilter().click();		
			 	 	 	        	
			 	 	 	        	Thread.sleep(2000);
			 	 	 	     		wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
			 	 	 	 			
					 				
			 	 	 	        	Thread.sleep(5000);
			 	 	 	        	performerPOM.clickSearchFilterworkspace().sendKeys("4658461");	
			 	 	 	        	
			 	 	 	        	Thread.sleep(5000);
			 	 	 	     		performerPOM.clickCheckbox1().click();	
		 	 	 	        	
			 	 	 	        	
			 	 	 	        	Thread.sleep(5000);
			 	 	 	        	performerPOM.clickFilter1().click();	*/
							     
							        Thread.sleep(8000);
									performerPOM.clickEditNotice().click();//click edit notice
								  
								   wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
								
								     Thread.sleep(8000);
								 performerPOM.clickCaseOrder().click();
								 Thread.sleep(8000);
								 performerPOM.clickNewCaseOrder().click();
								  Thread.sleep(8000);
								 performerPOM.clickSaveCaseOrder().click();
								 Thread.sleep(8000);
								 String msg= performerPOM.readResponseMsgOrder().getText();
								 String msg1= performerPOM.readResponseMsgOrder1().getText();
								 String msg2= performerPOM.readResponseMsgOrder2().getText();
								
									 test.log(LogStatus.PASS," Without data in Case Order = " +msg +"," +msg1 +"," +msg2);
							
								   getDriver().switchTo().parentFrame();
						   	     	Thread.sleep(8000);
						   	     	performerPOM.clickClose().click();//Clicking on 'Close'
							}
					public static void CaseOrderwithClearBtn( ExtentTest test) throws InterruptedException, IOException
					{
						WebDriverWait wait=new WebDriverWait(getDriver(),20);
						
						
						 Thread.sleep(8000);
							performerPOM.clickCaseOpencfo().click();//click edit notice
							
						 	Thread.sleep(8000);
			 				wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
			 				/*Thread.sleep(3000);
			 	 	        	performerPOM.clickTrignle1().click();		
			 	 	 			
			 				
			 	 	        	Thread.sleep(3000);
			 	 	        	performerPOM.clickFilter().click();		
			 	 	        	
			 	 	        	Thread.sleep(2000);
			 	 	     		wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
			 	 	 			
			 				
			 	 	        	Thread.sleep(5000);
			 	 	        	performerPOM.clickSearchFilterworkspace().sendKeys("4658461");	
			 	 	        	
			 	 	        	Thread.sleep(5000);
			 	 	     		performerPOM.clickCheckbox1().click();	
			 	        	
			 	 	        	
			 	 	        	Thread.sleep(5000);
			 	 	        	performerPOM.clickFilter1().click();	*/
					     
					        Thread.sleep(8000);
							performerPOM.clickEditNotice().click();//click edit notice
						  
						   wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
						
						 Thread.sleep(8000);
						 performerPOM.clickCaseOrder().click();
						 Thread.sleep(8000);
						 performerPOM.clickNewCaseOrder().click();
						 Thread.sleep(8000);
						 performerPOM. clickCaseOrderDate().sendKeys("25-02-2023");
						 
						 if(performerPOM.clickClearCaseOrderBtn().isEnabled())
						 {
							 Thread.sleep(8000);
							 performerPOM.clickClearCaseOrderBtn().click();
							test.log(LogStatus.PASS, "After clicking on the clear button the data should be remove");
						 }
						 else
						 {
							 test.log(LogStatus.FAIL, "After clicking on the clear button the data should not be remove");
						 }
						 
						 getDriver().switchTo().parentFrame();
				   	     	Thread.sleep(8000);
				   	     	performerPOM.clickClose().click();//Clicking on 'Close'
						  
					}
					
					public static void CaseStatusAppealtoNextCourt( ExtentTest test) throws InterruptedException
					{
						WebDriverWait wait=new WebDriverWait(getDriver(),20);
						
						 Thread.sleep(8000);
							performerPOM.clickCaseOpencfo().click();//click edit notice
							
							Thread.sleep(8000);
			 				wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
					     
					        Thread.sleep(8000);
							performerPOM.clickEditNotice().click();//click edit notice
						  
						   wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
						   Thread.sleep(8000);
						performerPOM.clickCaseStatusPayments().click();		//Clicking on 'Status/Payments'
						
						wait.until(ExpectedConditions.visibilityOf(performerPOM.clickCaseStatus()));
						Thread.sleep(8000);
						performerPOM.clickCaseStage().click();
						Thread.sleep(8000);
						performerPOM.selectCaseStage().sendKeys("Hearing", Keys.ENTER);
						
						Thread.sleep(8000);
						performerPOM.clickCaseStatus().click();				//Clicking on 'Case Status' drop down.
						Thread.sleep(8000);
						performerPOM.clickCaseStatusClose().click();			//Selecting 'Closed' option from drop down.
						
						Thread.sleep(8000);
						wait.until(ExpectedConditions.visibilityOf(performerPOM.clickCaseCloseDate()));
						Thread.sleep(8000);
						performerPOM.clickCaseCloseDate().click();				//Clicking on 'Closed Date' date box
						Thread.sleep(8000);
						OverduePOM.selectLastMonth().click();					//Getting last month
						Thread.sleep(8000);
						OverduePOM.selectDate2().click();						//Selecting particular date.
						
						Thread.sleep(8000);
						performerPOM.clickCaseResult().click();
						performerPOM.clickSelectCaseResult().sendKeys("In Progress", Keys.ENTER);
						
						Thread.sleep(8000);
						performerPOM.clickRemark1().sendKeys("Automation Testing");
						
						
						Thread.sleep(8000);
						performerPOM.clickCaseAppealToNextCourt().click();	
						
						Thread.sleep(8000);
						String msg=performerPOM.clickCasereadMsg().getText();
						
						if(msg.equalsIgnoreCase(msg))
						{
							test.log(LogStatus.PASS, "Message dispalyed =" +msg);
						}
						else
						{
							test.log(LogStatus.FAIL, "Message dispalyed =" +msg);
						}
						 getDriver().switchTo().parentFrame();
				   	     	Thread.sleep(8000);
				   	     	performerPOM.clickClose().click();//Clicking on 'Close'
					}
					
					public static void CaseStatuswithEmptyFields( ExtentTest test) throws InterruptedException
					{
						  WebDriverWait wait=new WebDriverWait(getDriver(),20);
						
						   Thread.sleep(8000);
							performerPOM.clickCaseOpencfo().click();//click edit notice
							
							Thread.sleep(8000);
			 				wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
					     
					        Thread.sleep(8000);
							performerPOM.clickEditNotice().click();//click edit notice
						  
						   wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
						   Thread.sleep(8000);
						   performerPOM.clickCaseStatusPayments().click();		//Clicking on 'Status/Payments'
						
						   wait.until(ExpectedConditions.visibilityOf(performerPOM.clickCaseStatus()));
						   Thread.sleep(8000);
							performerPOM.clickCaseStage().click();
							Thread.sleep(8000);
							performerPOM.selectCaseStage().sendKeys("Select Stage", Keys.ENTER);
							
							 Thread.sleep(8000);
							    performerPOM.clickSave1().click();
							Thread.sleep(8000);
							String msg=performerPOM.clickCasereadMsg().getText();
							
							if(msg.equalsIgnoreCase(msg))
							{
								test.log(LogStatus.PASS, "Case Stage with Empty fields =" +msg);
							}
							else
							{
								test.log(LogStatus.FAIL, "Case Stage with Empty fields =" +msg);
							}
							 
							
							Thread.sleep(8000);
							performerPOM.clickCaseStatus().click();				//Clicking on 'Case Status' drop down.
							Thread.sleep(8000);
							performerPOM.clickCaseStatus1().click();			//Selecting 'Closed' option from drop down.
						   
						   Thread.sleep(8000);
						    performerPOM.clickSave1().click();
						    
							Thread.sleep(8000);
							String msg1=performerPOM.clickCasereadMsg().getText();
							
							if(msg1.equalsIgnoreCase(msg1))
							{
								test.log(LogStatus.PASS, "Case Status with Empty fields =" +msg1);
							}
							else
							{
								test.log(LogStatus.FAIL, "Case Status with Empty fields =" +msg1);
							}
							 
							 getDriver().switchTo().parentFrame();
					   	     	Thread.sleep(8000);
					   	     	performerPOM.clickClose().click();//Clicking on 'Close'
						    
				}
					
					  public static void StatusPaymentWithExistingData( ExtentTest test) throws InterruptedException, EncryptedDocumentException, IOException
				      {
				    	         WebDriverWait wait=new WebDriverWait(getDriver(),50);
				    	         Thread.sleep(8000);
				    	          performerPOM.clickCaseOpen().click();
				    	   
				    	          
				    	          
				    	          Thread.sleep(8000);
				    	          performerPOM.clickEditNotice().click();
				    	         // sheet = workbook.getSheetAt(6);	
				    	       
				 	              Thread.sleep(8000);
				 			      wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
				 			     Thread.sleep(8000);
				                  performerPOM.clickCaseStatusPayments().click();		//Clicking on 'Status/Payments'
								
								  wait.until(ExpectedConditions.visibilityOf(performerPOM.clickCaseStatus()));

								  FileInputStream fis = new FileInputStream(filePath);
							        Workbook workbook = WorkbookFactory.create(fis);
							        Sheet sheet = workbook.getSheetAt(6);
								Thread.sleep(8000);
								Row row0 = sheet.getRow(95);					//Selected 0th index row (First row)
								Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
								int InvoiceNo = (int) c1.getNumericCellValue();
								performerPOM.clickCaseInvoiceNo1().sendKeys(InvoiceNo+"");	//Writing 'Invoice No'
								
							    
								Thread.sleep(8000);
								Row r5 = sheet.getRow(54);
								Cell c5 = r5.getCell(1);
								String PaymentType = c5.getStringCellValue();
								performerPOM.clickPaymentTyp1().click();
								performerPOM.selectPaymentTypeCase().sendKeys(PaymentType,Keys.ENTER);

								Thread.sleep(8000);
								performerPOM.clickAmount1().sendKeys("5000");
								
								Thread.sleep(8000);
								performerPOM.clickAmountPaid().sendKeys("2000");
							
					
								Thread.sleep(8000);
								performerPOM.clickSavePaymentLog1().click();
								
								Thread.sleep(8000);
								String msg4 = performerPOM.readPymentmsg().getText();		//Reading Message appeared after save button
							
								if(msg4.equalsIgnoreCase("Payment Details Saved Successfully."))
								{
									test.log(LogStatus.PASS, "Message displayed = "+msg4);
								
								}
								else
								{
									test.log(LogStatus.FAIL, "Message displayed = "+msg4);
								}
								
								 getDriver().switchTo().parentFrame();
						   	     	Thread.sleep(8000);
						   	     	performerPOM.clickClose().click();//Clicking on 'Close'
			      }
					  
					   public static void StatusPaymentWithoutdata( ExtentTest test) throws InterruptedException, IOException
					      {	
					    	       WebDriverWait wait=new WebDriverWait(getDriver(),50);
					       
					    	       Thread.sleep(8000);
									performerPOM.clickCaseOpencfo().click();//click edit notice
									
								 	Thread.sleep(8000);
					 				wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
					 			/*	Thread.sleep(3000);
			 	 	 	        	performerPOM.clickTrignle1().click();		
			 	 	 	 			
					 				
			 	 	 	        	Thread.sleep(3000);
			 	 	 	        	performerPOM.clickFilter().click();		
			 	 	 	        	
			 	 	 	        	Thread.sleep(2000);
			 	 	 	     		wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
			 	 	 	 			
					 				
			 	 	 	        	Thread.sleep(5000);
			 	 	 	        	performerPOM.clickSearchFilterworkspace().sendKeys("4658461");	
			 	 	 	        	
			 	 	 	        	Thread.sleep(5000);
			 	 	 	     		performerPOM.clickCheckbox1().click();	
		 	 	 	        	
			 	 	 	        	
			 	 	 	        	Thread.sleep(5000);
			 	 	 	        	performerPOM.clickFilter1().click();	*/
							     
							        Thread.sleep(8000);
									performerPOM.clickEditNotice().click();//click edit notice
								  
								   wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
								  
					    	       Thread.sleep(8000);
					               performerPOM.clickCaseStatusPayments().click();		//Clicking on 'Status/Payments'
					               
					               Thread.sleep(8000);
									performerPOM.clickSavePaymentLog1().click();
									
									
									   Thread.sleep(8000);
										String msg5 = performerPOM.readPymentmsg().getText();		//Reading Message appeared after save button
									
										if(msg5.equalsIgnoreCase("Payment Details Saved Successfully."))
										{
											test.log(LogStatus.FAIL, "Message displayed = "+msg5);
										
										}
										else
										{
											test.log(LogStatus.PASS, "Message displayed = "+msg5);
										}
										
										 getDriver().switchTo().parentFrame();
								   	     	Thread.sleep(8000);
								   	     	performerPOM.clickClose().click();//Clicking on 'Close'
					      }
					   
					   public static void StatusPaymentwithInvaliddata( ExtentTest test) throws InterruptedException, IOException
					      {	
					    	       WebDriverWait wait=new WebDriverWait(getDriver(),50);
					    	     //  XSSFSheet sheet=ReadExcel();
					    	       
					    	       Thread.sleep(8000);
									performerPOM.clickCaseOpencfo().click();//click edit notice
									
									Thread.sleep(8000);
					 				wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
							     
							        Thread.sleep(8000);
									performerPOM.clickEditNotice().click();//click edit notice
								  
								   wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
								  
					    	       Thread.sleep(8000);
					               performerPOM.clickCaseStatusPayments().click();		//Clicking on 'Status/Payments'
									
									wait.until(ExpectedConditions.visibilityOf(performerPOM.clickCaseStatus()));
									
									 FileInputStream fis = new FileInputStream(filePath);
								        Workbook workbook = WorkbookFactory.create(fis);
								        Sheet sheet = workbook.getSheetAt(6);
									Thread.sleep(8000);
									Row row0 = sheet.getRow(95);					//Selected 0th index row (First row)
									Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
									int InvoiceNo = (int) c1.getNumericCellValue();
									performerPOM.clickCaseInvoiceNo1().sendKeys(InvoiceNo+"");	//Writing 'Invoice No'
									
								    Thread.sleep(8000);
									performerPOM.clickPaymentTyp1().click();
									Thread.sleep(8000);
									List<WebElement> PaymentType1= getDriver().findElements(By.xpath("//*[@id='grdCasePayment_ddlPaymentType_chosen']/div/ul/li"));
									selectOptionFromDropDown_bs(PaymentType1, "Checks");
									Thread.sleep(8000);
									performerPOM.clickAmount1().sendKeys("abc");	//Writing 'Amount'
								
									Thread.sleep(8000);
									performerPOM. clickAmountPaid().sendKeys("asf");
									Thread.sleep(8000);
									performerPOM.clickSavePaymentLog1().click();
									
									try
									{
									   Thread.sleep(8000);
										String msg5 = performerPOM.readPymentmsg1().getText();		//Reading Message appeared after save button
									    test.log(LogStatus.PASS, "Message displayed = "+msg5);
									}
										
									catch(Exception e)
									{
										test.log(LogStatus.FAIL, "Validation message not displayed");
									}
										
									getDriver().switchTo().parentFrame();
								    Thread.sleep(8000);
								   	performerPOM.clickClose().click();//Clicking on 'Close'
					      }
					 	  public static void CaseExternalLawyerCriteria(ExtentTest test) throws InterruptedException
				          {
				        	  
				    		         WebDriverWait wait = new WebDriverWait(getDriver(), 300);
						   
				    		         Thread.sleep(10000);
										performerPOM.clickCaseOpencfo().click();//click edit notice
										
									 	Thread.sleep(8000);
						 				wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
						 				/*Thread.sleep(3000);
				 	 	 	        	performerPOM.clickTrignle1().click();		
				 	 	 	 			
						 				
				 	 	 	        	Thread.sleep(3000);
				 	 	 	        	performerPOM.clickFilter().click();		
				 	 	 	        	
				 	 	 	        	Thread.sleep(2000);
				 	 	 	     		wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
				 	 	 	 			
						 				
				 	 	 	        	Thread.sleep(5000);
				 	 	 	        	performerPOM.clickSearchFilterworkspace().sendKeys("4658461");	
				 	 	 	        	
				 	 	 	        	Thread.sleep(5000);
				 	 	 	     		performerPOM.clickCheckbox1().click();	
			 	 	 	        	
				 	 	 	        	
				 	 	 	        	Thread.sleep(5000);
				 	 	 	        	performerPOM.clickFilter1().click();	*/
								     
								        Thread.sleep(8000);
										performerPOM.clickEditNotice().click();//click edit notice
									    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
				    		            Thread.sleep(8000);
				    				    performerPOM. clickExternalLawyerRating1().click();
				    				    
				    				    Thread.sleep(8000);
				    				  performerPOM.selectExternalLawyerRating();
				    				   Thread.sleep(8000);
				    				   performerPOM.clickNewCriteria().click();
				    				   Thread.sleep(8000);
				    				   wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IframeLayerRatingCriteria"));
				    				   performerPOM.clickCriteria().sendKeys("AFG");
				    				   Thread.sleep(8000);
				    				   performerPOM.clickSaveCriteria().click();
				    				   Thread.sleep(8000);
				    				   String msg = performerPOM.readOppoenentMsg().getText();
				    				   
				    				   if(msg.equalsIgnoreCase("Criteria Saved Successfully."))
				    				   {
				    					   test.log(LogStatus.PASS, "Meassag Displayed ="+msg);
				    				   }
				    				   else
				    				   {
				    					   String msg1 = performerPOM.readMesg().getText();
				    					   test.log(LogStatus.PASS, "Meassag Displayed ="+msg1);
				    				   }
				    				   
				    				   Thread.sleep(8000);
				    				   getDriver().switchTo().parentFrame();
				    				   performerPOM.clickclosecriteria().click();
				    				   
				    					 getDriver().switchTo().parentFrame();
								   	     	Thread.sleep(8000);
								   	     	performerPOM.clickClose().click();//Clicking on 'Close'
				          }
					 	  
					 	 public static void CaseCriteriaInvalidData(ExtentTest test) throws InterruptedException
				         {
				       	  
				   		            WebDriverWait wait = new WebDriverWait(getDriver(), 300);
						  
				   		            Thread.sleep(8000);
								   performerPOM.clickCaseOpencfo().click();//click edit notice
								   
								 /*	Thread.sleep(1000);
					 				wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
					 				Thread.sleep(3000);
			 	 	 	        	performerPOM.clickTrignle1().click();		
			 	 	 	 			
					 				
			 	 	 	        	Thread.sleep(3000);
			 	 	 	        	performerPOM.clickFilter().click();		
			 	 	 	        	
			 	 	 	        	Thread.sleep(2000);
			 	 	 	     		wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
			 	 	 	 			
					 				
			 	 	 	        	Thread.sleep(5000);
			 	 	 	        	performerPOM.clickSearchFilterworkspace().sendKeys("4658461");	
			 	 	 	        	
			 	 	 	        	Thread.sleep(5000);
			 	 	 	     		performerPOM.clickCheckbox1().click();	
		 	 	 	        	
			 	 	 	        	
			 	 	 	        	Thread.sleep(5000);
			 	 	 	        	performerPOM.clickFilter1().click();	*/
							             Thread.sleep(8000);
									     performerPOM.clickEditNotice().click();//click edit notice
								  
									      getDriver().switchTo().parentFrame();
									      wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
				       	          
				   			       Thread.sleep(8000);
				   				   performerPOM. clickExternalLawyerRating1().click();
				   				   
				   				  Thread.sleep(8000);
				   				  performerPOM.selectExternalLawyerRating();
				   				   Thread.sleep(8000);
				   				   performerPOM.clickNewCriteria().click();
				   				   Thread.sleep(8000);
				   				   wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IframeLayerRatingCriteria"));
				   				 Thread.sleep(8000);
				   				  performerPOM.clickCriteria().sendKeys("342");
				   				 
				   				   Thread.sleep(8000);
				   				   performerPOM.clickSaveCriteria().click();
				   				   Thread.sleep(8000);
				   				   String msg = performerPOM.clickCriteriaInvalidMsg().getText();
				   				   
				   				   if(msg.equalsIgnoreCase("Only alphabets allowed."))
				   				   {
				   					   test.log(LogStatus.PASS, "Meassag Displayed ="+msg);
				   				   }
				   				   else
				   				   {
				   					   test.log(LogStatus.FAIL, "Meassag Displayed ="+msg);
				   				   }
				   				   
				   				   Thread.sleep(8000);
				   				   getDriver().switchTo().parentFrame();
				   				   performerPOM.clickclosecriteria().click();
				         }
					 	 
					 	  public static void CaseExistingCriteria(ExtentTest test) throws InterruptedException
				          {
				        	  
				    		         WebDriverWait wait = new WebDriverWait(getDriver(), 300);
						   
				    		         Thread.sleep(8000);
										performerPOM.clickCaseOpencfo().click();//click edit notice
										
									 	/*Thread.sleep(1000);
						 				wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
						 				Thread.sleep(3000);
				 	 	 	        	performerPOM.clickTrignle1().click();		
				 	 	 	 			
						 				
				 	 	 	        	Thread.sleep(3000);
				 	 	 	        	performerPOM.clickFilter().click();		
				 	 	 	        	
				 	 	 	        	Thread.sleep(2000);
				 	 	 	     		wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
				 	 	 	 			
						 				
				 	 	 	        	Thread.sleep(5000);
				 	 	 	        	performerPOM.clickSearchFilterworkspace().sendKeys("4658461");	
				 	 	 	        	
				 	 	 	        	Thread.sleep(5000);
				 	 	 	     		performerPOM.clickCheckbox1().click();	
			 	 	 	        	
				 	 	 	        	
				 	 	 	        	Thread.sleep(5000);
				 	 	 	        	performerPOM.clickFilter1().click();	*/
								     
								        Thread.sleep(8000);
										performerPOM.clickEditNotice().click();//click edit notice
									    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
				    		            Thread.sleep(8000);
				    				    performerPOM. clickExternalLawyerRating1().click();
				    				  
				    				    Thread.sleep(8000);
				    				  performerPOM.selectExternalLawyerRating();
				    				   Thread.sleep(8000);
				    				   performerPOM.clickNewCriteria().click();
				    				   Thread.sleep(8000);
				    				   wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IframeLayerRatingCriteria"));
				    				   performerPOM.clickCriteria().sendKeys("Test Test New");
				    				   Thread.sleep(8000);
				    				   performerPOM.clickSaveCriteria().click();
				    				   String msg = performerPOM.readOppoenentMsg().getText();
				    				   
				    				   if(msg.equalsIgnoreCase("Criteria already exists."))
				    				   {
				    					   test.log(LogStatus.PASS, "Meassag Displayed ="+msg);
				    				   }
				    				   else
				    				   {
				    					   String msg1 = performerPOM.readMesg().getText();
				    					   test.log(LogStatus.PASS, "Meassag Displayed ="+msg1);
				    				   }
				    				   
				    				   Thread.sleep(8000);
				    				   getDriver().switchTo().parentFrame();
				    				   performerPOM.clickclosecriteria().click();
				    				   
				    					 getDriver().switchTo().parentFrame();
								   	     	Thread.sleep(8000);
								   	     	performerPOM.clickClose().click();//Clicking on 'Close'
				          }
					 	 public static void CaseCriteriaWithoutData(ExtentTest test) throws InterruptedException
				         {
				       	  
				   		         WebDriverWait wait = new WebDriverWait(getDriver(), 300);
						  
				   		      Thread.sleep(8000);
								performerPOM.clickCaseOpencfo().click();//click edit notice
								
							 	Thread.sleep(8000);
				 				wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
				 			/*	Thread.sleep(3000);
		 	 	 	        	performerPOM.clickTrignle1().click();		
		 	 	 	 			
				 				
		 	 	 	        	Thread.sleep(3000);
		 	 	 	        	performerPOM.clickFilter().click();		
		 	 	 	        	
		 	 	 	        	Thread.sleep(2000);
		 	 	 	     		wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
		 	 	 	 			
				 				
		 	 	 	        	Thread.sleep(5000);
		 	 	 	        	performerPOM.clickSearchFilterworkspace().sendKeys("4658461");	
		 	 	 	        	
		 	 	 	        	Thread.sleep(5000);
		 	 	 	     		performerPOM.clickCheckbox1().click();	
			 	 	        	
		 	 	 	        	
		 	 	 	        	Thread.sleep(5000);
		 	 	 	        	performerPOM.clickFilter1().click();	*/
							     
							             Thread.sleep(8000);
									     performerPOM.clickEditNotice().click();//click edit notice
								  
									      getDriver().switchTo().parentFrame();
									      wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
				       	          
				   			       Thread.sleep(8000);
				   				   performerPOM. clickExternalLawyerRating1().click();
				   				    
				   				  Thread.sleep(8000);
				   				  performerPOM.selectExternalLawyerRating();
				   				   Thread.sleep(8000);
				   				   performerPOM.clickNewCriteria().click();
				   				   Thread.sleep(8000);
				   				   wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IframeLayerRatingCriteria"));
				   				
				   				 
				   				   Thread.sleep(8000);
				   				   performerPOM.clickSaveCriteria().click();
				   				   Thread.sleep(8000);
				   				   String msg = performerPOM.readOppoenentMsg().getText();
				   				   
				   				   if(msg.equalsIgnoreCase("Criteria can not be empty."))
				   				   {
				   					   test.log(LogStatus.PASS, "Meassag Displayed ="+msg);
				   				   }
				   				   else
				   				   {
				   					   test.log(LogStatus.FAIL, "Meassag Displayed ="+msg);
				   				   }
				   				   
				   				   Thread.sleep(8000);
				   				   getDriver().switchTo().parentFrame();
				   				   performerPOM.clickclosecriteria().click();
				         }
					 	 
					 	public static void TaskWithExistingData( ExtentTest test) throws InterruptedException, EncryptedDocumentException, IOException
						{
					 		
					 		//sheet = workbook.getSheetAt(6);
							WebDriverWait wait = new WebDriverWait(getDriver(), 60);
							Thread.sleep(8000);
							performerPOM.clickTaskOpen().click();	
							
							Thread.sleep(8000);
							wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
							Thread.sleep(5000);
							JavascriptExecutor js = (JavascriptExecutor) getDriver();
							CFOcountPOM.clickNextPage1().sendKeys(Keys.UP);
							js.executeScript("window.scrollBy(0,-700)");
							performerPOM.clickAddNewTask().click();				//Clicking on 'New' button
							
							progress();
							wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IframeAddTask"));
								
							 FileInputStream fis = new FileInputStream(filePath);
						        Workbook workbook = WorkbookFactory.create(fis);
						        Sheet sheet = workbook.getSheetAt(6);
							Thread.sleep(8000);
							Row row0 = sheet.getRow(29);								//Selected 0th index row (First row)
							Cell c1 = row0.getCell(1);								//Selected cell (0 row,1 column)
							String title = c1.getStringCellValue();
							performerPOM.clickTaskTitle().sendKeys(title);	//Writing 'Task Title'
							
							Thread.sleep(8000);
							row0 = sheet.getRow(30);									//Selected 0th index row (First row)
							c1 = row0.getCell(1);									//Selected cell (0 row,1 column)
							String desc = c1.getStringCellValue();
							performerPOM.clickTaskDesc().sendKeys(desc);		//Writing 'Task Description'
							
							Thread.sleep(8000);
							performerPOM.clickDueDate().click();				//Clicking on 'Due Date' text box
							Thread.sleep(8000);
							OverduePOM.selectNextMonth().click();
							Thread.sleep(3000);
							OverduePOM.selectDate().click();					//Selecting particular date.
							
							Thread.sleep(8000);
							Actions action = new Actions(getDriver());
							action.moveToElement(performerPOM.clickPriority()).click().sendKeys(Keys.DOWN,Keys.ENTER).perform();
							
							Thread.sleep(8000);
							row0 = sheet.getRow(31);									//Selected 0th index row (First row)
							c1 = row0.getCell(1);									//Selected cell (0 row,1 column)
							String outcome = c1.getStringCellValue();
							performerPOM.clickExpOutcome().sendKeys(outcome);	//Writing 'Expected Outcome'
							
							Thread.sleep(8000);
							row0 = sheet.getRow(32);									//Selected 0th index row (First row)
							c1 = row0.getCell(1);									//Selected cell (0 row,1 column)
							String internalUser = c1.getStringCellValue();
							performerPOM.clickInternalUser1().click();
							performerPOM.clickSearchInternalUser1().sendKeys(internalUser, Keys.ENTER);	//Selecting 'Internal User'
							
							Thread.sleep(8000);
							row0 = sheet.getRow(33);									//Selected 0th index row (First row)
							c1 = row0.getCell(1);									//Selected cell (0 row,1 column)
							String externalUser = c1.getStringCellValue();
							try
							{
								Thread.sleep(8000);
								performerPOM.clickExternalUser().click();
								Thread.sleep(8000);
								action.moveToElement(performerPOM.clickSearchExternalUser()).sendKeys(externalUser, Keys.ENTER).perform();
							}
							catch(Exception e)
							{
								
							}
							
							Thread.sleep(8000);
							row0 = sheet.getRow(34);									//Selected 0th index row (First row)
							c1 = row0.getCell(1);									//Selected cell (0 row,1 column)
							String remark = c1.getStringCellValue();
							performerPOM.clickRemark().sendKeys(remark);		//Writing 'Remark'
							
						
							Thread.sleep(8000);
							OverduePOM.clickSaveButton().click();				//Clicking on 'Save' button.
							
							Thread.sleep(3000);
							wait.until(ExpectedConditions.visibilityOf(performerPOM.clickTaskInvalidMessage()));
							
							Thread.sleep(8000);
							String msg = performerPOM.clickTaskInvalidMessage().getText();
							if(msg.contains(msg))
							{
								test.log(LogStatus.PASS, "Task with Existing Data ="+msg);
							}
							else
							{
								test.log(LogStatus.FAIL, "Task with Existing Data ="+msg);
							}
							
							getDriver().switchTo().parentFrame();
							performerPOM.clickClose1().click();			//Clicking on 'Close'
						}
					 	
					 	public static void TaskWithTwoMandatoryFields( ExtentTest test) throws InterruptedException, EncryptedDocumentException, IOException
						{
					 		
					 		//sheet = workbook.getSheetAt(6);
							WebDriverWait wait = new WebDriverWait(getDriver(), 60);
							Thread.sleep(8000);
							performerPOM.clickTaskOpen().click();	
							Thread.sleep(8000);
							JavascriptExecutor js = (JavascriptExecutor) getDriver();
							CFOcountPOM.clickNextPage1().sendKeys(Keys.UP);
							js.executeScript("window.scrollBy(0,-700)");
							performerPOM.clickAddNewTask().click();				//Clicking on 'New' button
							
							progress();
							wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IframeAddTask"));
									
							 FileInputStream fis = new FileInputStream(filePath);
						        Workbook workbook = WorkbookFactory.create(fis);
						        Sheet sheet = workbook.getSheetAt(6);
							Thread.sleep(8000);
							Row row0 = sheet.getRow(29);								//Selected 0th index row (First row)
							Cell c1 = row0.getCell(1);								//Selected cell (0 row,1 column)
							String title = c1.getStringCellValue();
							performerPOM.clickTaskTitle().sendKeys(title);	//Writing 'Task Title'
							
							Thread.sleep(8000);
							row0 = sheet.getRow(30);									//Selected 0th index row (First row)
							c1 = row0.getCell(1);									//Selected cell (0 row,1 column)
							String desc = c1.getStringCellValue();
							performerPOM.clickTaskDesc().sendKeys(desc);		//Writing 'Task Description'
							
							Thread.sleep(8000);
							OverduePOM.clickSaveButton().click();				//Clicking on 'Save' button.
							
							Thread.sleep(8000);
							wait.until(ExpectedConditions.visibilityOf(performerPOM.clickMessage1()));
							
							Thread.sleep(8000);
							String msg = performerPOM.clickMessage1().getText();
							if(msg.contains(msg))
							{
								test.log(LogStatus.PASS, "Task with two mandatory fields ="+msg);
							}
							else
							{
								test.log(LogStatus.FAIL, "Task with two mandatory fields ="+msg);
							}
							
							getDriver().switchTo().parentFrame();
							performerPOM.clickClose1().click();			//Clicking on 'Close'
						}
					 	
						public static void TaskwithoutData( ExtentTest test) throws InterruptedException
						{
							WebDriverWait wait = new WebDriverWait(getDriver(), 60);
							Thread.sleep(8000);
							performerPOM.clickTaskOpen().click();	
							Thread.sleep(8000);
							JavascriptExecutor js = (JavascriptExecutor) getDriver();
							CFOcountPOM.clickNextPage1().sendKeys(Keys.UP);
							js.executeScript("window.scrollBy(0,-700)");
							performerPOM.clickAddNewTask().click();				//Clicking on 'New' button
							
							progress();
							wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IframeAddTask"));
							
							Thread.sleep(300);
							OverduePOM.clickSaveButton().click();				//Clicking on 'Save' button.
							
							Thread.sleep(300);
							wait.until(ExpectedConditions.visibilityOf(performerPOM.clickMessage2()));
							
							Thread.sleep(300);
							String msg = performerPOM.clickMessage2().getText();
							if(msg.contains(msg))
							{
								test.log(LogStatus.PASS, "Task without data ="+msg);
							}
							else
							{
								test.log(LogStatus.FAIL, "Task without data ="+msg);
							}
							
							getDriver().switchTo().parentFrame();
							performerPOM.clickClose1().click();			//Clicking on 'Close'
						}
						public static void TaskwithClearBtn( ExtentTest test) throws InterruptedException
						{
							WebDriverWait wait = new WebDriverWait(getDriver(), 60);
							Thread.sleep(8000);
							performerPOM.clickTaskOpen().click();
							Thread.sleep(8000);
							JavascriptExecutor js = (JavascriptExecutor) getDriver();
							CFOcountPOM.clickNextPage1().sendKeys(Keys.UP);
							js.executeScript("window.scrollBy(0,-700)");
							performerPOM.clickAddNewTask().click();				//Clicking on 'New' button
							
							progress();
							wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IframeAddTask"));
							
							Thread.sleep(8000);
							Actions action = new Actions(getDriver());
							action.moveToElement(performerPOM.clickPriority()).click().sendKeys(Keys.DOWN,Keys.ENTER).perform();
							
							Thread.sleep(8000);
							
							if(performerPOM.clickTaskClearBtn().isEnabled())
							{
								performerPOM.clickTaskClearBtn().click();
								test.log(LogStatus.PASS, "After clicking the clear button the data should be remove");
							}
							else
							{
								test.log(LogStatus.FAIL, "After clicking the clear button the data should not be remove");
							}
							
							getDriver().switchTo().parentFrame();
							performerPOM.clickClose1().click();			//Clicking on 'Close'
						}
						public static void TaskShowDetailesClearBtn( ExtentTest test) throws InterruptedException
						{
							WebDriverWait wait = new WebDriverWait(getDriver(), 60);
							Thread.sleep(8000);
							performerPOM.clickTaskOpen().click();
							Thread.sleep(8000);
							JavascriptExecutor js = (JavascriptExecutor) getDriver();
							CFOcountPOM.clickNextPage1().sendKeys(Keys.UP);
							
							js.executeScript("window.scrollBy(0,-700)");
							Thread.sleep(8000);
							performerPOM.clickTaskShowDetailes().click();				
							
							wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
							
							
							Thread.sleep(8000);
							wait.until(ExpectedConditions.visibilityOf(performerPOM.clickStatus1()));
							performerPOM.clickStatus1().click();
							
							
							List<WebElement>SeletcStatus = getDriver().findElements(By.xpath("//*[@id='ddlStatus_chosen']/div/ul/li[2]"));
							 selectOptionFromDropDown_bs(SeletcStatus, "Approve/Closed");
							
							/*Thread.sleep(3000);
							Actions action = new Actions(getDriver());
							action.moveToElement(performerPOM.clickPriority()).click().sendKeys(Keys.DOWN,Keys.ENTER).perform();*/
							
							Thread.sleep(8000);
							
							if(performerPOM.clickClearResponse().isEnabled())
							{
								performerPOM.clickClearResponse().click();
								test.log(LogStatus.PASS, "After clicking the clear button the data should be remove");
							}
							else
							{
								test.log(LogStatus.FAIL, "After clicking the clear button the data should not be remove");
							}
							
							Thread.sleep((8000));
							getDriver().switchTo().parentFrame();
							performerPOM.CaseHearingPopupClose().click();			//Clicking on 'Close'
						}
						public static void TaskDelete( ExtentTest test) throws InterruptedException
						{
							
							Thread.sleep(8000);
							performerPOM.clickTaskOpen().click();
							Thread.sleep(8000);
							performerPOM.clickTaskdelete().click();	
							
							 Thread.sleep(8000);
							    // Switching to Alert        
						        Alert alert1 = getDriver().switchTo().alert();		
						        		
						        // Capturing alert message.    
						        String alertMessage1= getDriver().switchTo().alert().getText();	
						        
						        
						        test.log(LogStatus.PASS, alertMessage1);
						        		
						        // Displaying alert message		
						        System.out.println(alertMessage1);
						        
						     // Accepting alert		
						        alert1.accept();	
						}
						
						
						 public static void CaseUserAssignment( ExtentTest test) throws InterruptedException, IOException
				 	 	 {

			  			           	

				 	 	 			WebDriverWait wait = new WebDriverWait(getDriver(), 300);
				 	 	 			progress();
				 	 	 			
				 	 	 		  Thread.sleep(500);
				 	 	        	performerPOM.clickCaseOpencfo().click();		
				 	 	        	
				 	 	       	Thread.sleep(1000);
				 				wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
				 				/*Thread.sleep(3000);
			 	 	        	performerPOM.clickTrignle1().click();		
			 	 	 			
				 				
			 	 	        	Thread.sleep(3000);
			 	 	        	performerPOM.clickFilter().click();		
			 	 	        	
			 	 	        	Thread.sleep(2000);
			 	 	     		wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
			 	 	 			
				 				
			 	 	        	Thread.sleep(5000);
			 	 	        	performerPOM.clickSearchFilterworkspace().sendKeys("4658461");	
			 	 	        	
			 	 	        	Thread.sleep(5000);
			 	 	     		performerPOM.clickCheckbox1().click();	
			 	        	
			 	 	        	
			 	 	        	Thread.sleep(5000);
			 	 	        	performerPOM.clickFilter1().click();	*/
			 	 	        	
				 	 	            Thread.sleep(4000);
				 	 	            performerPOM.clickEditNotice().click();
				 	 	            
				 	 	          try
				 	 	            {
				 	 	            
				 	 	              	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
				 	 	              	Actions a = new Actions(getDriver());
				 	 	              	//scroll down a page
				 	 	              	a.sendKeys(Keys.PAGE_DOWN).build().perform();
				 	 	              	
				 	 	 	            Thread.sleep(4000);
				 	 	                 performerPOM.clickEditUserAssign().click();
				 	 	 			 
				 	 	                
				 	 	                 Thread.sleep(3000);
				 	 	                 performerPOM.clickInternalUser().click();
				 	 	        
				 	 	                
				 	 	                 
				 	 	                 elementsList = performerPOM.chooseInternalUser1();
				 	 	                 elementsList.get(5).click();							//Selecting particular user no
				 	 	                 

				 	 	                 Thread.sleep(3000);
				 	 	                 performerPOM.clickInternalUser().click();
				 	 	                 
				 	 	                 Thread.sleep(3000);
				 	 	                  OverduePOM.clickUpdateButton().click();
				 	 	        
				 	 	                 Thread.sleep(2000);
				 	 	                 String msg = performerPOM.CaseInvalidreadMessage().getText();		//Reading Message appeared after update button
				 	 	    		
				 	 	                 if(msg.equalsIgnoreCase("Case Details Updated Successfully."))
				 	 	                 {
				 	 	                	 test.log(LogStatus.PASS, "Message displayed = "+msg);
				 	 	    			
				 	 	                 }
				 	 	                 else
				 	 	                 {
				 	 	                	 test.log(LogStatus.FAIL, "Message displayed = "+msg);
				 	 	                 }
				 	 	    	
				 	 	            } 
				 	 	            
				 	 	            catch(Exception e)
				 	 	            {
				 	 	            	test.log(LogStatus.PASS, "Record not displayed in Case-User assignment");
				 	 	            }
				 	 	          
				 	 	        JavascriptExecutor js = (JavascriptExecutor) getDriver();

				 	 			js.executeScript("window.scrollBy(0,-700)");	
				 	 	            
				 	 	          Thread.sleep(3000);
				 	 	     		getDriver().switchTo().parentFrame();
				 	 	     		/*performerPOM.clickClose3().click();//Clicking on 'Close'
				 	 	     		
				 	 	     	
				 	 	     	    Thread.sleep(3000);
				 	 	     		OverduePOM.clickDashboard().click();*/
				 	 	    }
						 
						 public static void CaseUserAssignmentDelete( ExtentTest test) throws InterruptedException, IOException
				 	 	 {
				 	 	 		   
				 			     			
				 	 	 			WebDriverWait wait = new WebDriverWait(getDriver(), 300);
				 	 	 			progress();
				 	 	 			
				 	 	 		  Thread.sleep(500);
				 	 	        	performerPOM.clickCaseOpencfo().click();		
				 	 	        	
				 	 	       	Thread.sleep(1000);
				 				wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
				 			/*	Thread.sleep(3000);
			 	 	        	performerPOM.clickTrignle1().click();		
			 	 	 			
				 				
			 	 	        	Thread.sleep(3000);
			 	 	        	performerPOM.clickFilter().click();		
			 	 	        	
			 	 	        	Thread.sleep(2000);
			 	 	     		wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
			 	 	 			
				 				
			 	 	        	Thread.sleep(5000);
			 	 	        	performerPOM.clickSearchFilterworkspace().sendKeys("4658461");	
			 	 	        	
			 	 	        	Thread.sleep(5000);
			 	 	     		performerPOM.clickCheckbox1().click();	
			 	        	
			 	 	        	
			 	 	        	Thread.sleep(5000);
			 	 	        	performerPOM.clickFilter1().click();	*/
				 	 	        	
				 	 	            Thread.sleep(4000);
			 	 	                performerPOM.clickEditNotice().click();
			 	 	            
			 	 	         	    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
				 	 	 			
				 	 	            Thread.sleep(4000);
				 	 	            performerPOM.clickDeleteUserAssign().click();
				 	 	            
				 	 	         Thread.sleep(2000);
			 	 	    		String msg = performerPOM.clickDeleteUserAssignValidMsg1().getText();		//Reading Message appeared after save button
			 	 	    		
			 	 	    		if(msg.equalsIgnoreCase("User Assignment Detail Deleted"))
			 	 	    		{
			 	 	    			test.log(LogStatus.PASS, "Message displayed = "+msg);
			 	 	    			
			 	 	    		}
			 	 	    		else
			 	 	    		{
			 	 	    			test.log(LogStatus.FAIL, "Message displayed = "+msg);
			 	 	    		}
				 	 	            
				 	 	        	Thread.sleep(3000);
				 	 	     		getDriver().switchTo().parentFrame();
				 	 	     		performerPOM.clickClose().click();//Clicking on 'Close'
				 	 	     	
				 	 	     	    Thread.sleep(3000);
				 	 	     		OverduePOM.clickDashboard().click();
				 	 	    }
						 
						 public static void NoticeClosedDoc( ExtentTest test) throws InterruptedException, IOException
				 	 	 {
				 	 	 		   
				 			     			
				 			 	WebDriverWait wait = new WebDriverWait(getDriver(), 300);
				 			   Thread.sleep(8000);
				 				performerPOM.clickNoticeOpen().click();
				 				
				 				Thread.sleep(8000);
				 				wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
				 			    
				 				Thread.sleep(8000);
				 				performerPOM.clickEditNotice().click();//click edit notice
				 				Thread.sleep(8000);
				 			   	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
				 			   	Thread.sleep(8000);
				 				 performerPOM.clickStatusPayments().click();
				 				 
				 				
				 				Thread.sleep(8000);
				 				wait.until(ExpectedConditions.visibilityOf(performerPOM.clickNoticeStatus()));
				 				performerPOM.clickNoticeStatus().click();				//Clicking on 'Notice Status' drop down.
				 				Thread.sleep(4000);
				 				performerPOM.clickClosedStatus().click();				//Selecting 'Closed' option from drop down.
				 				
				 				Thread.sleep(4000);
				 				wait.until(ExpectedConditions.visibilityOf(performerPOM.clickCloseDate()));
				 				performerPOM.clickCloseDate().click();				//Clicking on 'Closed Date' date box
				 				OverduePOM.selectLastMonth().click();					//Getting last month
				 				OverduePOM.selectDate2().click();						//Selecting particular date.
				 				

				 				Thread.sleep(4000);
				 				performerPOM.clickClosedNoticeDoc();
				 				
				 				Thread.sleep(4000);
				 				performerPOM.clickSave1().click();
				 				
				 				Thread.sleep(3000);
				 				wait.until(ExpectedConditions.visibilityOf(performerPOM.readMessage2()));
				 				String msg = performerPOM.readMessage2().getText();
				 			
				 				if(msg.contains(msg))
				 				{
				 					test.log(LogStatus.PASS, "Notice Closed Document - "+msg);
				 				}
				 				else if(msg.contains(msg))
				 				{
				 					test.log(LogStatus.FAIL, "Notice Closed Document - "+msg);
				 				}
				 				else
				 				{
				 					test.log(LogStatus.FAIL, "Notice Closed Document- "+msg);
				 				}
				 				
				 				
				 				
				 				  Thread.sleep(4000);
				 					if(performerPOM.clickClosedNoticeViewDoc().isEnabled())
				 					{
				 						 Thread.sleep(4000);
				 						performerPOM.clickClosedNoticeViewDoc().click();
				 						 test.log(LogStatus.PASS, "Closed Notice document view successfully.");
				 					}
				 					else
				 					{
				 						test.log(LogStatus.PASS, "Closed Notice document not view successfully.");
				 					}
				 					Thread.sleep(4000);
			 						performerPOM.clickClosedNoticeViewDocClosedaPopup().click();
			 						
			 						
				 		
			 		 				  Thread.sleep(4000);
			 		 					if(performerPOM.clickDownloadDoc().isEnabled())
			 		 					{
			 		 						 Thread.sleep(4000);
			 		 						performerPOM.clickDownloadDoc().click();
			 		 						 test.log(LogStatus.PASS, "Closed Notice document download successfully.");
			 		 					}
			 		 					else
			 		 					{
			 		 						test.log(LogStatus.PASS, "Closed Notice document not download successfully.");
			 		 					}

				 				Thread.sleep(4000);
				 				getDriver().switchTo().parentFrame();
				 			
				 				Thread.sleep(4000);
				 				performerPOM.clickClose().click();
				 			
				 			
				 				Thread.sleep(4000);
				 				OverduePOM.clickDashboard().click();
				 				
						
				 	 	 }
						 
						 public static void NoticeClosedWithoutDoc( ExtentTest test) throws InterruptedException, IOException
				 	 	 {
				 	 	 		   
				 			     			
				 			 	WebDriverWait wait = new WebDriverWait(getDriver(), 300);
				 			   Thread.sleep(8000);
				 				performerPOM.clickNoticeOpen().click();
				 				
				 				Thread.sleep(8000);
				 				wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
				 			    
				 				Thread.sleep(8000);
				 				performerPOM.clickEditNotice().click();//click edit notice
				 				Thread.sleep(8000);
				 			   	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
				 			   	Thread.sleep(8000);
				 				 performerPOM.clickStatusPayments().click();
				 				 
				 				
				 			   	Thread.sleep(8000);
				 				wait.until(ExpectedConditions.visibilityOf(performerPOM.clickNoticeStatus()));
				 				performerPOM.clickNoticeStatus().click();				//Clicking on 'Notice Status' drop down.
				 				Thread.sleep(4000);
				 				performerPOM.clickClosedStatus().click();				//Selecting 'Closed' option from drop down.
				 				
				 				Thread.sleep(4000);
				 				wait.until(ExpectedConditions.visibilityOf(performerPOM.clickCloseDate()));
				 				performerPOM.clickCloseDate().click();				//Clicking on 'Closed Date' date box
				 				OverduePOM.selectLastMonth().click();					//Getting last month
				 				OverduePOM.selectDate2().click();						//Selecting particular date.
				 				

				 				Thread.sleep(4000);
				 				performerPOM.clickClosedNoticeDoc();
				 				
				 				Thread.sleep(4000);
				 				performerPOM.clickSave1().click();
				 				
				 				Thread.sleep(3000);
				 				wait.until(ExpectedConditions.visibilityOf(performerPOM.readMessage2()));
				 				String msg = performerPOM.readMessage2().getText();
				 			
				 				if(msg.contains(msg))
				 				{
				 					test.log(LogStatus.PASS, "Notice Closed Without Document - "+msg);
				 				}
				 				else if(msg.contains(msg))
				 				{
				 					test.log(LogStatus.FAIL, "Notice Closed Without Document - "+msg);
				 				}
				 				else
				 				{
				 					test.log(LogStatus.FAIL, "Notice Closed Without Document- "+msg);
				 				}

				 				Thread.sleep(4000);
				 				getDriver().switchTo().parentFrame();
				 			
				 				Thread.sleep(4000);
				 				performerPOM.clickClose().click();
				 			
				 			
				 				Thread.sleep(4000);
				 				OverduePOM.clickDashboard().click();
				 			}
				 				
						 public static void CaseClosedDoc( ExtentTest test) throws InterruptedException, IOException
				 	 	 {
				 			 
				 			 	WebDriverWait wait = new WebDriverWait(getDriver(), 300);
				 			   Thread.sleep(8000);
				 				performerPOM.clickCaseOpen().click();
				 				
				 				Thread.sleep(8000);
				 				wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
				 			    
				 				Thread.sleep(8000);
				 				performerPOM.clickEditNotice().click();//click edit notice
				 				Thread.sleep(8000);
				 			   	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
				 			   	Thread.sleep(8000);
				 			
				 			   	performerPOM.clickCaseStatusPayments().click();		//Clicking on 'Status/Payments'
				 			   	Thread.sleep(8000);
				 			   	wait.until(ExpectedConditions.visibilityOf(performerPOM.clickCaseStatus()));
							
				 			   	performerPOM.clickCaseStage().click();
				 			   	Thread.sleep(300);
				 			   	performerPOM.selectCaseStage().sendKeys("Hearing", Keys.ENTER);
							
				 			   	Thread.sleep(300);
				 			   	performerPOM.clickCaseStatus().click();				//Clicking on 'Case Status' drop down.
				 			   	Thread.sleep(300);
				 			   	performerPOM.clickCaseStatusClose().click();			//Selecting 'Closed' option from drop down.
							
				 			   	Thread.sleep(3000);
				 			   	wait.until(ExpectedConditions.visibilityOf(performerPOM.clickCaseCloseDate()));
				 			   	performerPOM.clickCaseCloseDate().click();				//Clicking on 'Closed Date' date box
				 			   	OverduePOM.selectLastMonth().click();					//Getting last month
				 			   	OverduePOM.selectDate2().click();						//Selecting particular date.
							
				 			   	Thread.sleep(3000);
				 			   	performerPOM.clickCaseResult().click();
				 			   	performerPOM.clickSelectCaseResult().sendKeys("In Progress", Keys.ENTER);
							
				 			   	Thread.sleep(3000);
				 			   	performerPOM.clickRemark1().sendKeys("Automation Testing");
							
				 			   	Thread.sleep(4000);
				 			   	performerPOM.clickClosedNoticeDoc();
			 				
				 			   	Thread.sleep(4000);
				 			   	performerPOM.clickSave1().click();
			 				
				 			   	Thread.sleep(3000);
				 			   	wait.until(ExpectedConditions.visibilityOf(performerPOM.readMessage2()));
				 			   	String msg = performerPOM.readMessage2().getText();
				 			   	
				 			   	if(msg.contains(msg))
				 			   	{
				 			   		test.log(LogStatus.PASS, "Case Closed Document - "+msg);
				 			   	}
				 			   	else if(msg.contains(msg))
				 			   	{
				 			   		test.log(LogStatus.FAIL, "Case Closed Document - "+msg);
				 			   	}
				 			   	else
				 			   	{
				 			   		test.log(LogStatus.FAIL, "Case Closed Document- "+msg);
				 			   	}
			 				
			 				
			 				  Thread.sleep(4000);
			 					if(performerPOM.clickClosedNoticeViewDoc().isEnabled())
			 					{
			 						 Thread.sleep(4000);
			 						performerPOM.clickClosedNoticeViewDoc().click();
			 						 test.log(LogStatus.PASS, "Closed Case document view successfully.");
			 					}
			 					else
			 					{
			 						test.log(LogStatus.PASS, "Closed Case document not view successfully.");
			 					}
			 					Thread.sleep(4000);
								performerPOM.clickClosedNoticeViewDocClosedaPopup().click();
									
								Thread.sleep(4000);
					 			if(performerPOM.clickDownloadDoc().isEnabled())
					 		     {
					 					Thread.sleep(4000);
					 				    performerPOM.clickDownloadDoc().click();
					 					test.log(LogStatus.PASS, "Closed Case document download successfully.");
					 			}
					 			else
					 			{
					 					test.log(LogStatus.PASS, "Closed Case document not download successfully.");
					 			}

			 				Thread.sleep(4000);
			 				getDriver().switchTo().parentFrame();
			 			
			 				Thread.sleep(4000);
			 				performerPOM.clickClose().click();
			 			
			 			
			 				Thread.sleep(4000);
			 				OverduePOM.clickDashboard().click();
				 	  }
						 public static void CaseClosedWithoutDoc( ExtentTest test) throws InterruptedException, IOException
				 	 	 {
				 			 
				 			 	WebDriverWait wait = new WebDriverWait(getDriver(), 300);
				 			   Thread.sleep(8000);
				 				performerPOM.clickCaseOpen().click();
				 				
				 				Thread.sleep(8000);
				 				wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
				 			    
				 				Thread.sleep(8000);
				 				performerPOM.clickEditNotice().click();//click edit notice
				 				Thread.sleep(8000);
				 			   	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
				 			   	Thread.sleep(8000);
				 			
				 			   	performerPOM.clickCaseStatusPayments().click();		//Clicking on 'Status/Payments'
							
				 			   	wait.until(ExpectedConditions.visibilityOf(performerPOM.clickCaseStatus()));
							
				 			   	performerPOM.clickCaseStage().click();
				 			   	Thread.sleep(300);
				 			   	performerPOM.selectCaseStage().sendKeys("Hearing", Keys.ENTER);
							
				 			   	Thread.sleep(300);
				 			   	performerPOM.clickCaseStatus().click();				//Clicking on 'Case Status' drop down.
				 			   	Thread.sleep(300);
				 			   	performerPOM.clickCaseStatusClose().click();			//Selecting 'Closed' option from drop down.
							
				 			   	Thread.sleep(3000);
				 			   	wait.until(ExpectedConditions.visibilityOf(performerPOM.clickCaseCloseDate()));
				 			   	performerPOM.clickCaseCloseDate().click();				//Clicking on 'Closed Date' date box
				 			   	OverduePOM.selectLastMonth().click();					//Getting last month
				 			   	OverduePOM.selectDate2().click();						//Selecting particular date.
							
				 			   	Thread.sleep(3000);
				 			   	performerPOM.clickCaseResult().click();
				 			   	performerPOM.clickSelectCaseResult().sendKeys("In Progress", Keys.ENTER);
							
				 			   	Thread.sleep(3000);
				 			   	performerPOM.clickRemark1().sendKeys("Automation Testing");
							
				 			   	Thread.sleep(4000);
				 			   	performerPOM.clickClosedNoticeDoc();
			 				
				 			   	Thread.sleep(4000);
				 			   	performerPOM.clickSave1().click();
			 				
				 			   	Thread.sleep(3000);
				 			   	wait.until(ExpectedConditions.visibilityOf(performerPOM.readMessage2()));
				 			   	String msg = performerPOM.readMessage2().getText();
				 			   	
				 			   	if(msg.contains(msg))
				 			   	{
				 			   		test.log(LogStatus.PASS, "Case Closed Without Document - "+msg);
				 			   	}
				 			   	else if(msg.contains(msg))
				 			   	{
				 			   		test.log(LogStatus.FAIL, "Case Closed Without Document - "+msg);
				 			   	}
				 			   	else
				 			   	{
				 			   		test.log(LogStatus.FAIL, "Case Closed Without Document- "+msg);
				 			   	}
				 			   	
				 			   Thread.sleep(4000);
				 				getDriver().switchTo().parentFrame();
				 			
				 				Thread.sleep(4000);
				 				performerPOM.clickClose().click();
				 			
				 			
				 				Thread.sleep(4000);
				 				OverduePOM.clickDashboard().click();
					 	  }
						 public static void ClosedCaseDoc( ExtentTest test) throws InterruptedException, IOException
					 		{
					 			
					 			
					 			WebDriverWait wait = new WebDriverWait(getDriver(), 300);
					 			Thread.sleep(3000);
					 			performerPOM.clickMyDocument().click();					//Clicking on 'My Document'
					 			Thread.sleep(3000);
					 			performerPOM.clickmyDocument().click();	                    //Clicking on 'My Document'
					 			
					 			//--------------------------------Case----------------------------------
							       
					 			
					 		    
							       Thread.sleep(3000);
							       performerPOM.clickTrignle3().click();
							       
							       Thread.sleep(3000);
							       performerPOM.clickFilter2().click();
							      
							        Thread.sleep(8000);
							       performerPOM.clickSearchFilterworkspace().sendKeys("5435");
							       
							       Thread.sleep(3000);
							       performerPOM. selectCheckbox().click();
							       
							       Thread.sleep(3000);
							       performerPOM.clickFilter3().click();
							       

							       Thread.sleep(3000);
							       performerPOM.clickDoc().click();
							       
							       Thread.sleep(7000);
							       performerPOM.selectDoc().click();
							       
							       
							       Thread.sleep(8000);
									if(performerPOM.clickDownloadDocument().isEnabled())
									{
										  Thread.sleep(3000);
										performerPOM.clickDownloadDocument().click();
										 test.log(LogStatus.PASS, "Closed Case Document  Downloaded Successfully.");
									}
									else
									{
										test.log(LogStatus.PASS, "Closed Case Document not Downloaded Successfully.");
									}
							       
							       
							     
							       
							       Thread.sleep(3000);
									if(performerPOM.clickViewDocument().isEnabled())
									{
										 Thread.sleep(3000);
										performerPOM.clickViewDocument().click();
										 test.log(LogStatus.PASS, "Closed Case Document view Successfully.");
									}
									else
									{
										test.log(LogStatus.PASS, "Closed Case Document not view Successfully.");
									}
									
									 Thread.sleep(3000);
								       performerPOM.clickcloseViewDocument().click();
								       
								       Thread.sleep(8000);
										performerPOM.shareDocumentIcon().click();
										
										   wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("OverViews1"));
										   
										   Thread.sleep(8000);
											performerPOM.clickNoticeDocumentshareemailcfo().sendKeys("admin@gmail.com");
											Thread.sleep(8000);
											performerPOM.clickNoticeDocumentsharecontactnocfo().sendKeys("5555555555");
											Thread.sleep(8000);
											performerPOM. clickNoticeDocumentsharesavecfo().click();
										
											Thread.sleep(8000);
											String msg=performerPOM. clickNoticeDocumentsharereadmsgcfo1().getText();
											if(msg.equalsIgnoreCase(msg))
											{
												test.log(LogStatus.PASS, " Documents for respective case should be shared =" +msg);
											}
											else
											{
												test.log(LogStatus.FAIL, " Documents for respective case should be shared =" +msg);
											}
											getDriver().switchTo().parentFrame();
											Thread.sleep(8000);
											performerPOM. clickViewDocAdvocatebillPdfClose().click();
							   
					 		}
					 		 public static void ClosedNoticeDoc( ExtentTest test) throws InterruptedException, IOException
						 		{
						 			
						 			
						 			WebDriverWait wait = new WebDriverWait(getDriver(), 300);
						 			Thread.sleep(3000);
						 			performerPOM.clickMyDocument().click();					//Clicking on 'My Document'
						 			Thread.sleep(3000);
						 			performerPOM.clickmyDocument().click();	                    //Clicking on 'My Document'
						 			
						 			//--------------------------------Notice----------------------------------
						 			
						 			Thread.sleep(8000);
								    JavascriptExecutor js = (JavascriptExecutor) getDriver();
									js.executeScript("window.scrollBy(500,0)");
									Thread.sleep(8000);
									performerPOM.clickTypeDropdown().click();					//Clicking on Type drop down box (i.e. Notice, Case, Task)
									Thread.sleep(8000);
									performerPOM.selectTypeNotice().click();					//Selecting 'Case' option.
									
						 			
						 		    
								       Thread.sleep(3000);
								       performerPOM.clickTrignle3().click();
								       
								       Thread.sleep(3000);
								       performerPOM.clickFilter2().click();
								      
								        Thread.sleep(8000);
								       performerPOM.clickSearchFilterworkspace().sendKeys("6052024");
								       
								       Thread.sleep(3000);
								       performerPOM. selectCheckboxcfo().click();
								       
								       Thread.sleep(3000);
								       performerPOM.clickFilter3().click();
								       

								       Thread.sleep(3000);
								       performerPOM.clickDoc().click();
								       
								       Actions a = new Actions(getDriver());
								       //scroll down a page
								       a.sendKeys(Keys.PAGE_DOWN).build().perform();
								       
								       Thread.sleep(7000);
								       performerPOM.selectDoc1().click();
								       
								       
								       Thread.sleep(8000);
										if(performerPOM.clickDownloadDocument().isEnabled())
										{
											  Thread.sleep(3000);
											performerPOM.clickDownloadDocument().click();
											 test.log(LogStatus.PASS, "Closed Notice Document  Downloaded Successfully.");
										}
										else
										{
											test.log(LogStatus.PASS, "Closed Notice Document not Downloaded Successfully.");
										}
								       
								       
								     
								       
								       Thread.sleep(3000);
										if(performerPOM.clickViewDocument().isEnabled())
										{
											 Thread.sleep(3000);
											performerPOM.clickViewDocument().click();
											 test.log(LogStatus.PASS, "Closed Notice Document view Successfully.");
										}
										else
										{
											test.log(LogStatus.PASS, "Closed Notice Document not view Successfully.");
										}
										
										 Thread.sleep(3000);
									       performerPOM.clickcloseViewDocument().click();
									       
									       Thread.sleep(8000);
											performerPOM.shareDocumentIcon().click();
											
											   wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("OverViews1"));
											   
											   Thread.sleep(8000);
												performerPOM.clickNoticeDocumentshareemailcfo().sendKeys("admin@gmail.com");
												Thread.sleep(8000);
												performerPOM.clickNoticeDocumentsharecontactnocfo().sendKeys("5555555555");
												Thread.sleep(8000);
												performerPOM. clickNoticeDocumentsharesavecfo().click();
											
												Thread.sleep(8000);
												String msg=performerPOM. clickNoticeDocumentsharereadmsgcfo1().getText();
												if(msg.equalsIgnoreCase(msg))
												{
													test.log(LogStatus.PASS, " Documents for respective case should be shared =" +msg);
												}
												else
												{
													test.log(LogStatus.FAIL, " Documents for respective case should be shared =" +msg);
												}
												getDriver().switchTo().parentFrame();
												Thread.sleep(8000);
												performerPOM. clickViewDocAdvocatebillPdfClose().click();
								   
						 		}
						 		  
					 		 public static void AdvancedSearchClosedNoticeDoc( ExtentTest test) throws InterruptedException, IOException
						 		{
						 			
						 			
						 			WebDriverWait wait = new WebDriverWait(getDriver(), 300);
						 			Thread.sleep(3000);
						 			performerPOM.clickMyDocument().click();					//Clicking on 'My Document'
						 			Thread.sleep(3000);
						 			performerPOM.clickmyDocument().click();	                    //Clicking on 'My Document'
						 			 Thread.sleep(8000);
									 performerPOM.AdvancedSearchReports().click();
						 			
						 			//--------------------------------Notice----------------------------------
						 			
						 			Thread.sleep(8000);
								    JavascriptExecutor js = (JavascriptExecutor) getDriver();
									js.executeScript("window.scrollBy(500,0)");
									Thread.sleep(8000);
									performerPOM.clickTypeDropdown2().click();					//Clicking on Type drop down box (i.e. Notice, Case, Task)
									Thread.sleep(8000);
									performerPOM.selectTypeCase2().click();					//Selecting 'Case' option.
									
									
									wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
						 			
						 		    
								       Thread.sleep(3000);
								       performerPOM.clickTrignle4().click();
								       
								       Thread.sleep(3000);
								       performerPOM.clickFilter2().click();
								      
								        Thread.sleep(8000);
								       performerPOM.clickSearchFilterworkspace().sendKeys("6052024");
								       
								       Thread.sleep(3000);
								       performerPOM. selectCheckboxcfo().click();
								       
								       Thread.sleep(3000);
								       performerPOM.clickFilter3().click();
								       

								       Thread.sleep(3000);
								       performerPOM.clickDoc1().click();
								       
//								       Actions a = new Actions(getDriver());
//								       //scroll down a page
//								       a.sendKeys(Keys.PAGE_DOWN).build().perform();
								       
								       Thread.sleep(7000);
								       performerPOM.selectDoc1().click();
								       
								      
								       
								       
								       
								       Thread.sleep(8000);
										if(performerPOM.clickDownloadDocument1().isEnabled())
										{
											  Thread.sleep(3000);
											performerPOM.clickDownloadDocument1().click();
											 test.log(LogStatus.PASS, "Advanced Search - Closed Notice Document  Downloaded Successfully.");
										}
										else
										{
											test.log(LogStatus.PASS, "Advanced Search -Closed Notice Document not Downloaded Successfully.");
										}
								       
								       
								     
								       
								       Thread.sleep(3000);
										if(performerPOM.clickViewDocument1().isEnabled())
										{
											 Thread.sleep(3000);
											performerPOM.clickViewDocument1().click();
											 test.log(LogStatus.PASS, "Advanced Search  - Closed Notice Document view Successfully.");
										}
										else
										{
											test.log(LogStatus.PASS, "Advanced Search  - Closed Notice Document not view Successfully.");
										}
										
										 Thread.sleep(3000);
									       performerPOM.clickcloseViewDocument1().click();
									       
									       Thread.sleep(8000);
											performerPOM.shareDocumentIcon1().click();
											
											  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("OverViews3"));
											   
											   Thread.sleep(8000);
												performerPOM.clickNoticeDocumentshareemailcfo().sendKeys("admin@gmail.com");
												Thread.sleep(8000);
												performerPOM.clickNoticeDocumentsharecontactnocfo().sendKeys("5555555555");
												Thread.sleep(8000);
												performerPOM. clickNoticeDocumentsharesavecfo().click();
											
												Thread.sleep(8000);
												String msg=performerPOM. clickNoticeDocumentsharereadmsgcfo1().getText();
												if(msg.equalsIgnoreCase(msg))
												{
													test.log(LogStatus.PASS, " Documents for respective notice should be shared =" +msg);
												}
												else
												{
													test.log(LogStatus.FAIL, " Documents for respective notice should be shared =" +msg);
												}
												
												getDriver().switchTo().parentFrame();
												Thread.sleep(8000);
												performerPOM. CloseSharePopup().click();
								   
						 		}
						 		     
					 		 public static void AdvancedSearchClosedCaseDoc( ExtentTest test) throws InterruptedException, IOException
						 		{
						 			
						 			
						 			WebDriverWait wait = new WebDriverWait(getDriver(), 300);
						 			Thread.sleep(3000);
						 			performerPOM.clickMyDocument().click();					//Clicking on 'My Document'
						 			Thread.sleep(3000);
						 			performerPOM.clickmyDocument().click();	                    //Clicking on 'My Document'
						 			 Thread.sleep(8000);
									 performerPOM.AdvancedSearchReports().click();
						 			
						 			//--------------------------------Case----------------------------------
						 			
						 	
									
									wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
						 			
						 		    
								       Thread.sleep(3000);
								       performerPOM.clickTrignle4().click();
								       
								       Thread.sleep(3000);
								       performerPOM.clickFilter2().click();
								      
								        Thread.sleep(8000);
								       performerPOM.clickSearchFilterworkspace().sendKeys("5435");
								       
								       Thread.sleep(3000);
								       performerPOM. selectCheckbox().click();
								       
								       Thread.sleep(3000);
								       performerPOM.clickFilter3().click();
								       

								       Thread.sleep(3000);
								       performerPOM.clickDoc1().click();
								       
						
								       
								       Thread.sleep(7000);
								       performerPOM.selectDoc().click();
								       
								      
								       
								       
								       
								       Thread.sleep(8000);
										if(performerPOM.clickDownloadDocument1().isEnabled())
										{
											  Thread.sleep(3000);
											performerPOM.clickDownloadDocument1().click();
											 test.log(LogStatus.PASS, "Advanced Search - Closed Case Document  Downloaded Successfully.");
										}
										else
										{
											test.log(LogStatus.PASS, "Advanced Search -Closed Case Document not Downloaded Successfully.");
										}
								       
								       
								     
								       
								       Thread.sleep(3000);
										if(performerPOM.clickViewDocument1().isEnabled())
										{
											 Thread.sleep(3000);
											performerPOM.clickViewDocument1().click();
											 test.log(LogStatus.PASS, "Advanced Search  - Closed Case Document view Successfully.");
										}
										else
										{
											test.log(LogStatus.PASS, "Advanced Search  - Closed Case Document not view Successfully.");
										}
										
										 Thread.sleep(3000);
									       performerPOM.clickcloseViewDocument1().click();
									       
									       Thread.sleep(8000);
											performerPOM.shareDocumentIcon1().click();
											
											  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("OverViews3"));
											   
											   Thread.sleep(8000);
												performerPOM.clickNoticeDocumentshareemailcfo().sendKeys("admin@gmail.com");
												Thread.sleep(8000);
												performerPOM.clickNoticeDocumentsharecontactnocfo().sendKeys("5555555555");
												Thread.sleep(8000);
												performerPOM. clickNoticeDocumentsharesavecfo().click();
											
												Thread.sleep(8000);
												String msg=performerPOM. clickNoticeDocumentsharereadmsgcfo1().getText();
												if(msg.equalsIgnoreCase(msg))
												{
													test.log(LogStatus.PASS, " Documents for respective case should be shared =" +msg);
												}
												else
												{
													test.log(LogStatus.FAIL, " Documents for respective case should be shared =" +msg);
												}
												
												getDriver().switchTo().parentFrame();
												Thread.sleep(8000);
												performerPOM. CloseSharePopup().click();
								   
						 		}
						 		     
							           
			public static void CriticalDocuments( ExtentTest test) throws InterruptedException
			{
									WebDriverWait wait = new WebDriverWait(getDriver(), 60);
									Thread.sleep(8000);
									performerPOM.clickMyDocument().click();					//Clicking on 'My Documents'
									
									Thread.sleep(8000);
									performerPOM.clickcriticalDocument().click();	             //clicking on 'critical document'
									
									
									wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ContentPlaceHolder1_grdFolderDetail']")));	//Wating till the content table gets visible
									
									Thread.sleep(8000);
									String name = OverduePOM.readFolderName().getText();		//Reading the folder name to create new folder.
									
									String folder = name+"Doc09mar24"; 
									
									OverduePOM.clickNew().click();							//Clicking on '+New' button.
									
									Thread.sleep(8000);
									litigationAdditionalOwner.MethodsPOM.progress();
									
									Thread.sleep(8000);
									OverduePOM.clickNewFolder().click();						//Clicking on 'New Folder'
									
									Thread.sleep(8000);
									litigationAdditionalOwner.MethodsPOM.progress();
									
									Thread.sleep(8000);
									OverduePOM.clickIsUniversal().click();
									
									Thread.sleep(8000);
									OverduePOM.writeFolderName().sendKeys(folder);			//Writing Folder name.
									
									Thread.sleep(8000);
									OverduePOM.clickCreate().click();						//Clicking on create button.
								
									
									Thread.sleep(8000);
									litigationAdditionalOwner.MethodsPOM.progress();
									
									
									//String msg = getDriver().switchTo().alert().getText();
									//test.log(LogStatus.PASS,"Message displayed=" +msg);
									
								//	driver.switchTo().alert().accept();
									Thread.sleep(8000);
									wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@align='left'])[1]")));
									name = OverduePOM.readFolderName().getText();				//Reading the folder name we had created
									
									if(folder.equalsIgnoreCase(name))
									{
										test.log(LogStatus.PASS, "Folder Created Succesfully.='"+folder+"' displayed in the records.");
									}
									else
									{
										test.log(LogStatus.FAIL, "Folder Created Succesfully.='"+folder+"' doesn't displayed in the records.");
									}
									
									//without Enter folder Name
									
									Thread.sleep(8000);
									OverduePOM.clickNew().click();	
									
									Thread.sleep(8000);
									OverduePOM.clickNewFolder().click();						//Clicking on 'New Folder'
									
									Thread.sleep(8000);
									OverduePOM.clickCreate().click();						//Clicking on create button.
									Thread.sleep(8000);
									String msg=performerPOM.ClickInvalidMsg().getText();
									if(msg.equalsIgnoreCase(msg))
									{
										test.log(LogStatus.PASS,"Without Enter Folder Name =" +msg);
									}
									else
									{
										test.log(LogStatus.FAIL,"Without Enter Folder Name =" +msg);
									}
									
									Thread.sleep(8000);
									OverduePOM.closeFolderPoppup().click();	
									
									///Share Document in Main Folder 
									
									Thread.sleep(8000);
									wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@align='left'])[1]")));
									if(OverduePOM.readFolderName().isDisplayed())			//Checking if file got created or not.
										test.log(LogStatus.PASS, "Uploaded file displayed.");
									else
										test.log(LogStatus.PASS, "Uploaded file does not displayed.");
									Thread.sleep(8000);
									OverduePOM.readFolderName().click();					//Clicking on file we had uploaded.
											
									Thread.sleep(8000);
									OverduePOM.clickShareFolder().click();					//Clicking on Share Folder image.
									
									wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.clickPeople()));
									Thread.sleep(8000);
									OverduePOM.clickPeople().click();						//Clicking on People drop down 
									Thread.sleep(8000);
									OverduePOM.clickSearchPeople().click();					//Clicking on Search People drop down.
									
									Thread.sleep(8000);
									OverduePOM.clickSearchPeople().sendKeys("Akshay jadhav");			//Writing user name to search for
									
									Thread.sleep(8000);
									OverduePOM.clickPeopleCheckBox1().click();				//Clicking on label to get out from people search box
									
									Thread.sleep(8000);
									OverduePOM.clickDone().click();	  //Clicking on 'Done' to share folder.
									
									String msg3 = getDriver().switchTo().alert().getText();
								    test.log(LogStatus.PASS,"Message displayed=" +msg3);
									
									getDriver().switchTo().alert().accept(); 
									
									//Delete Folder
									
									Thread.sleep(8000);
									OverduePOM.readFolderName().click();						//Clicking on folder name we had created.
									
									Thread.sleep(8000);
									performerPOM.ClickDeleteFile().click();
									
									String msg1 = getDriver().switchTo().alert().getText();
								    test.log(LogStatus.PASS,"Message displayed=" +msg1);
									
									getDriver().switchTo().alert().accept();
									
									
									
					
									Thread.sleep(8000);
									wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.clickDashboard()));
									OverduePOM.clickDashboard().click();	
									
							}
								
				 	 	            
			public static void CriticalDocuments1( ExtentTest test) throws InterruptedException
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 60);
		
				Thread.sleep(8000);
				performerPOM.clickMyDocument().click();					//Clicking on 'My Documents'
				
				Thread.sleep(8000);
				performerPOM.clickcriticalDocument().click();	             //clicking on 'critical document'
				
				//Create Sub folder
				
					Thread.sleep(8000);
					OverduePOM.readFolderName().click();						//Clicking on file name we had uploaded.
					Thread.sleep(8000);
					OverduePOM.readFolderName().click();						//Clicking on file name we had uploaded.
					//Thread.sleep(500);
					//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ContentPlaceHolder1_grdFolderDetail_LinkButton1_0']")));	//Wating till the content table gets visible
					

					Thread.sleep(8000);
					OverduePOM.clickNew().click();							//Clicking on '+New' button.
					
					Thread.sleep(8000);
					OverduePOM.clickNewFolder().click();						//Clicking on 'New Folder'
					
					Thread.sleep(8000);
					OverduePOM.writeFolderName().sendKeys("Sub Document 9mar2024");			//Writing Folder name.
					
					Thread.sleep(8000);
					OverduePOM.clickCreate1().click();						//Clicking on create button.
					
					try
					{
						Thread.sleep(2000);
						String msg1=performerPOM.ClickSuccessMsg().getText();
						test.log(LogStatus.PASS, " sub-folder should get created =" +msg1);
					}
					catch(Exception e)
					{
						Thread.sleep(3000);
						String msg1=performerPOM.ClickInvalidMsg().getText();
						test.log(LogStatus.FAIL, " sub-folder should not get  created =" +msg1);
					}
					
					Thread.sleep(8000);
					OverduePOM.closeFolderPoppup().click();	
					
					//Without enter sub-folder 
					

					Thread.sleep(8000);
					OverduePOM.clickNew().click();			
					
					Thread.sleep(8000);
					OverduePOM.clickNewFolder().click();						//Clicking on 'New Folder'
					
					
					Thread.sleep(8000);
					OverduePOM.clickCreate1().click();						//Clicking on create button.
					String msg=performerPOM.ClickInvalidMsg().getText();
					if(msg.equalsIgnoreCase(msg))
					{
						test.log(LogStatus.PASS,"Without Enter Sub-Folder Name =" +msg);
					}
					else
					{
						test.log(LogStatus.FAIL,"Without Enter Sub-Folder Name =" +msg);
					}
					
					Thread.sleep(8000);
					OverduePOM.closeFolderPoppup().click();	
					
					
					
					
					
				
				//Upload Document File
				
				Thread.sleep(8000);
				OverduePOM.readFolderName().click();						//Clicking on folder name we had created.
				Thread.sleep(8000);
				OverduePOM.readFolderName().click();						//Clicking on folder name we had created.
				
				Thread.sleep(8000);
				litigationAdditionalOwner.MethodsPOM.progress();
				
				Thread.sleep(8000);
				wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.clickNew()));
				OverduePOM.clickNew().click();							//Clicking on 'New'
				
				Thread.sleep(8000);
				litigationAdditionalOwner.MethodsPOM.progress();
				
				Thread.sleep(8000);
				wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.clickNewFile()));
				OverduePOM.clickNewFile().click();						//CLicking on 'New File'
				
				Thread.sleep(8000);
				litigationAdditionalOwner.MethodsPOM.progress();
				
				Thread.sleep(8000);
				
				OverduePOM.uploadNewFile().sendKeys("E:\\Snehal\\ComplianceLatest\\Litigation-Project-main (1)\\Litigation-Project-main\\TestData\\LitigationSheet.xlsx");	//uploading new file		
				
				Thread.sleep(8000);
				wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.clickUploadDocument()));
				OverduePOM.clickUploadDocument().click();				//Clicking on 'Upload Document'
				
			
				
				String msg1 = getDriver().switchTo().alert().getText();
			    test.log(LogStatus.PASS,"Message displayed=" +msg1);
				
				getDriver().switchTo().alert().accept();
				
				
				//Share Document 
				Thread.sleep(8000);
				litigationAdditionalOwner.MethodsPOM.progress();
				
			Thread.sleep(8000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@align='left'])[1]")));
				/*if(OverduePOM.readFolderName().isDisplayed())			//Checking if file got created or not.
					test.log(LogStatus.PASS, "Uploaded file displayed.");
				else
					test.log(LogStatus.PASS, "Uploaded file does not displayed.");*/
				
				OverduePOM.readFolderName().click();					//Clicking on file we had uploaded.
						
				Thread.sleep(8000);
				OverduePOM.clickShareFolder().click();					//Clicking on Share Folder image.
				
				Thread.sleep(8000);
				litigationAdditionalOwner.MethodsPOM.progress();
				
				Thread.sleep(8000);
				wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.clickPeople()));
				Thread.sleep(8000);
				OverduePOM.clickPeople().click();						//Clicking on People drop down 
				Thread.sleep(8000);
				OverduePOM.clickSearchPeople().click();					//Clicking on Search People drop down.
				
				Thread.sleep(8000);
				OverduePOM.clickSearchPeople().sendKeys("Akshay jadhav");			//Writing user name to search for
				
				Thread.sleep(8000);
				OverduePOM.clickPeopleCheckBox1().click();				//Clicking on label to get out from people search box
				
				Thread.sleep(8000);
				OverduePOM.clickDone().click();	  //Clicking on 'Done' to share folder.
				
				String msg3 = getDriver().switchTo().alert().getText();
			    test.log(LogStatus.PASS,"Message displayed=" +msg3);
				
				getDriver().switchTo().alert().accept();
				
				//view Document File

				Thread.sleep(8000);
	
			OverduePOM.readFolderName().click();						//Clicking on file name we had uploaded.
			
			test.log(LogStatus.PASS, "View Popup open successfully");
			
			//Download Document file
			
			Thread.sleep(8000);
			performerPOM.ClickDownloadfile().click();
			
			test.log(LogStatus.PASS, "File Download successfully");
			
			//Update Document Details
			
		/*	Thread.sleep(2000);
			OverduePOM.readFolderName().click();	
			
			
			Thread.sleep(2000);
			performerPOM.ClickEditDetailesFile().click();	
			
			Thread.sleep(500);
			performerPOM.ClickHeader().clear();	
			
			
			Thread.sleep(500);
			performerPOM.ClickHeader().sendKeys("ABCD");
			
			Thread.sleep(500);
			performerPOM.ClickUpdateInfo().click();	
			Thread.sleep(500);
			String msg4=performerPOM.ClickUpdateSuccessmsg().getText();
			
			if(msg4.equalsIgnoreCase(msg4))
			{
				test.log(LogStatus.PASS, "Message Displayed =" +msg4);
			}
			else
			{
				test.log(LogStatus.FAIL, "Message Displayed =" +msg4);
			}*/
				
					
				//Delete Document file
				Thread.sleep(8000);
				performerPOM.ClickDeleteFile().click();
				
				String msg2 = getDriver().switchTo().alert().getText();
			    test.log(LogStatus.PASS,"Message displayed=" +msg2);
				
				getDriver().switchTo().alert().accept();
				
				
				Thread.sleep(8000);
				wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.clickDashboard()));
				OverduePOM.clickDashboard().click();			//Clicking on Dashboard
			}
			
			
			 public static void AdvancedSearchShareCaseDocument( ExtentTest test) throws InterruptedException, IOException
				{
					WebDriverWait wait = new WebDriverWait(getDriver(), 60);
					progress();
					
					 Thread.sleep(8000);
					performerPOM.clickMyDocument().click();					//Clicking on 'My Document'
					 Thread.sleep(8000);
					performerPOM.clickmyDocument().click();	                    //Clicking on 'My Document'
					 Thread.sleep(8000);
					 performerPOM.AdvancedSearchReports().click();
					
//					Thread.sleep(1000);
//					performerPOM.selectDocument().click();	
					Thread.sleep(8000);
					//performerPOM.selectDocument1().click();
					
				     //Select t=new Select(driver.findElement(By.xpath("/html/body/div[77]/div/div[2]/ul/li[2]")));
				  //  t.selectByIndex(1);
				
					
//   		       List<WebElement>SeletcRisk = getDriver().findElements(By.xpath("//li[@class='k-item']"));
//   			   selectOptionFromDropDown_bs(SeletcRisk, "Case Documents");
					Thread.sleep(8000);
					performerPOM.shareDocumentIcon1().click();
					
					   wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("OverViews3"));
					   
					   Thread.sleep(8000);
						performerPOM.clickNoticeDocumentshareemailcfo().sendKeys("admin@gmail.com");
						Thread.sleep(8000);
						performerPOM.clickNoticeDocumentsharecontactnocfo().sendKeys("5555555555");
						Thread.sleep(8000);
						performerPOM. clickNoticeDocumentsharesavecfo().click();
					
						Thread.sleep(8000);
						String msg=performerPOM. clickNoticeDocumentsharereadmsgcfo1().getText();
						if(msg.equalsIgnoreCase(msg))
						{
							test.log(LogStatus.PASS, " Documents for respective case should be shared =" +msg);
						}
						else
						{
							test.log(LogStatus.FAIL, " Documents for respective case should be shared =" +msg);
						}
						getDriver().switchTo().parentFrame();
						Thread.sleep(8000);
						performerPOM. CloseSharePopup().click();
						
				}
				
				
				public static void AdvancedSearchShareNoticeDocument( ExtentTest test) throws InterruptedException, IOException
				{
					WebDriverWait wait = new WebDriverWait(getDriver(), 60);
					progress();
					 Thread.sleep(8000);
					performerPOM.clickMyDocument().click();					//Clicking on 'My Document'
					 Thread.sleep(8000);
					performerPOM.clickmyDocument().click();	                    //Clicking on 'My Document'
					
					 Thread.sleep(8000);
					 performerPOM.AdvancedSearchReports().click();
					

			       Thread.sleep(8000);
				    JavascriptExecutor js = (JavascriptExecutor) getDriver();
					js.executeScript("window.scrollBy(500,0)");
					Thread.sleep(8000);
					performerPOM.clickTypeDropdown2().click();					//Clicking on Type drop down box (i.e. Notice, Case, Task)
					Thread.sleep(8000);
					performerPOM.selectTypeCase2().click();					//Selecting 'Case' option.
//					Thread.sleep(1000);
//					performerPOM.selectDocument().click();	
					Thread.sleep(8000);
					performerPOM.shareDocumentIcon1().click();
					
					   wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("OverViews3"));
					   
					   Thread.sleep(8000);
						performerPOM.clickNoticeDocumentshareemailcfo().sendKeys("admin@gmail.com");
						Thread.sleep(8000);
						performerPOM.clickNoticeDocumentsharecontactnocfo().sendKeys("5555555555");
						Thread.sleep(8000);
						performerPOM. clickNoticeDocumentsharesavecfo().click();
					
						Thread.sleep(8000);
						String msg=performerPOM. clickNoticeDocumentsharereadmsgcfo1().getText();
						if(msg.equalsIgnoreCase(msg))
						{
							test.log(LogStatus.PASS, " Documents for respective Notice should be shared =" +msg);
						}
						else
						{
							test.log(LogStatus.FAIL, " Documents for respective Notice should be shared =" +msg);
						}
						getDriver().switchTo().parentFrame();
						Thread.sleep(8000);
						performerPOM. CloseSharePopup().click();
				}
				       
				public static void AdvancedSearchShareTaskDocument( ExtentTest test) throws InterruptedException, IOException
				{
					WebDriverWait wait = new WebDriverWait(getDriver(), 60);
					progress();
					 Thread.sleep(8000);
					performerPOM.clickMyDocument().click();					//Clicking on 'My Document'
					 Thread.sleep(8000);
					performerPOM.clickmyDocument().click();	                    //Clicking on 'My Document'
					 Thread.sleep(8000);
					 performerPOM.AdvancedSearchReports().click();
					
			       Thread.sleep(8000);
				    JavascriptExecutor js = (JavascriptExecutor) getDriver();
					js.executeScript("window.scrollBy(500,0)");
					Thread.sleep(8000);
					performerPOM.clickTypeDropdown2().click();					//Clicking on Type drop down box (i.e. Notice, Case, Task)
					Thread.sleep(8000);
					performerPOM.selectTypeTask2().click();					//Selecting 'Task' option.						
					try
					{
						
						
						Thread.sleep(8000);
						performerPOM.shareDocumentIcon1().click();
					
						wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("OverViews3"));
					   
						Thread.sleep(8000);
						performerPOM.clickNoticeDocumentshareemailcfo().sendKeys("admin@gmail.com");
						Thread.sleep(8000);
						performerPOM.clickNoticeDocumentsharecontactnocfo().sendKeys("5555555555");
						Thread.sleep(8000);
						performerPOM. clickNoticeDocumentsharesavecfo().click();
					
						Thread.sleep(8000);
						String msg=performerPOM. clickNoticeDocumentsharereadmsgcfo1().getText();
						if(msg.equalsIgnoreCase(msg))
						{
							test.log(LogStatus.PASS, " Documents for respective Task should be shared =" +msg);
						}
						else
						{
							test.log(LogStatus.FAIL, " Documents for respective Task should be shared =" +msg);
						}
						
						getDriver().switchTo().parentFrame();
						Thread.sleep(8000);
						performerPOM. CloseSharePopup().click();

					}
					catch(Exception e)
					{
						 Thread.sleep(8000);
						    // Switching to Alert        
					        Alert alert = getDriver().switchTo().alert();		
					        		
					        // Capturing alert message.    
					        String alertMessage= getDriver().switchTo().alert().getText();	
					        
					        Thread.sleep(8000);
					        test.log(LogStatus.PASS, alertMessage);
					        		
					        // Displaying alert message		
					        System.out.println(alertMessage);	
					        
					        		
					        // Accepting alert		
					        alert.accept();	
						
					}
				}
				
				 public static void LinkNoticeViewIcon( ExtentTest test) throws InterruptedException, IOException
			 	 {
			 	 		   
			 	        	
			 	 			WebDriverWait wait = new WebDriverWait(getDriver(), 300);
			 	 			progress();
			 	 			
			 	 		
			 	 			
			 	            Thread.sleep(500);
			 	        	performerPOM.clickNoticeOpen().click();	
			 	        	
			 	         	Thread.sleep(4000);
			 	 	        	wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
			 	 	        /*	Thread.sleep(3000);
			 	 	        	performerPOM.clickTrignle1().click();		
			 	 			
			 	 	        	
			 	 	        	Thread.sleep(3000);
			 	 	        	performerPOM.clickFilter().click();		
			 	        	
			 	 	        	Thread.sleep(2000);
			 	 	        	wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
			 	 			
		 				
			 	 	        	Thread.sleep(5000);
			 	 	        	performerPOM.clickSearchFilterworkspace().sendKeys("12344");	
			 	        	
			 	 	        	Thread.sleep(5000);
			 	 	        	performerPOM.clickCheckbox().click();	
			 	        	
			 	        	
			 	 	        	Thread.sleep(5000);
			 	 	        	performerPOM.clickFilter1().click();	*/
			 	 			
			 	            Thread.sleep(4000);
			 	            performerPOM.clickEditNotice().click();
			 	 			
			 	 			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
			 	 			
			 	 		    Thread.sleep(4000);
			 	            performerPOM.clickLinkedNoticeViewIcon().click();
					      	
					      	Thread.sleep(4000);
			 	 	        performerPOM.clickViewPopup().click();
			 	 	        
			 	 	        String msg="Linked Notice Details";
			 	 	        
			 	 	        if(msg.equalsIgnoreCase(msg))
			 	 	        {
			 	 	        	test.log(LogStatus.PASS, "View Notice Detailes icon open succssefully");
			 	 	        }
			 	 	        else
			 	 	        {
			 	 	        	test.log(LogStatus.FAIL, "View Notice Detailes icon not open succssefully");

			 	 	        }
			 	 	        

			 	 		Thread.sleep(4000);
			 	        performerPOM.clickClosePopup1().click();
			 	     	Thread.sleep(3000);
			     		getDriver().switchTo().parentFrame();
			     		performerPOM.clickClose().click();//Clicking on 'Close'
			     	
			     	    Thread.sleep(3000);
			     		OverduePOM.clickDashboard().click();
			 	 			
			 	 }
				 public static void LinkNoticeDeleteIcon( ExtentTest test) throws InterruptedException, IOException
			 	 {
			 	 		   
			 	        	
			 	 			WebDriverWait wait = new WebDriverWait(getDriver(), 300);
			 	 			progress();
			 	 			
			 	 		
			 	 			
			 	            Thread.sleep(500);
			 	        	performerPOM.clickNoticeOpen().click();
			 	        	
			 	        	
			 	        	
			 	         	Thread.sleep(1000);
			 	 	        	wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
			 	 	        /*	Thread.sleep(3000);
			 	 	        	performerPOM.clickTrignle1().click();		
			 	 			
			 	 	        	
			 	 	        	Thread.sleep(3000);
			 	 	        	performerPOM.clickFilter().click();		
			 	        	
			 	 	        	Thread.sleep(2000);
			 	 	        	wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
			 	 			
		 				
			 	 	        	Thread.sleep(5000);
			 	 	        	performerPOM.clickSearchFilterworkspace().sendKeys("12344");	
			 	        	
			 	 	        	Thread.sleep(5000);
			 	 	        	performerPOM.clickCheckbox().click();	
			 	        	
			 	        	
			 	 	        	Thread.sleep(5000);
			 	 	        	performerPOM.clickFilter1().click();	*/
			 	        	
			 	 			
			 	            Thread.sleep(4000);
			 	            performerPOM.clickEditNotice().click();
			 	 			
			 	 			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
			 	 			
			 	 		    Thread.sleep(4000);
			 	            performerPOM.clickLinkedNoticeDeleteIcon().click();
					      	
			 	         Thread.sleep(5000);
					    // Switching to Alert        
				        Alert alert1 = getDriver().switchTo().alert();		
				        		
				        // Capturing alert message.    
				        String alertMessage1= getDriver().switchTo().alert().getText();	
				        
				        
				        test.log(LogStatus.PASS, alertMessage1);
				        		
				        // Displaying alert message		
				        System.out.println(alertMessage1);
				        
				       // Accepting alert		
				        alert1.accept();	
				        
				   /*   Thread.sleep(4000);
			 	       String msg= performerPOM.clickLinkedNoticeDeleteIconValidMsg().getText();
			 	       
			 	       test.log(LogStatus.PASS, "Message Displayed =" +msg); */
			 	 	        

			 	     	Thread.sleep(3000);
			     		getDriver().switchTo().parentFrame();
			     		performerPOM.clickClose().click();//Clicking on 'Close'
			     	
			     	    Thread.sleep(3000);
			     		OverduePOM.clickDashboard().click();
			 	 			
			 	 }
				 
				 public static void MyReminder( ExtentTest test, XSSFWorkbook workbook) throws InterruptedException, IOException
					{
						WebDriverWait wait = new WebDriverWait(getDriver(), 180);
						progress();
						
						//wait.until(ExpectedConditions.visibilityOf(performerPOM.clickNoticeOpen()));	//Wait until 'Notice-Open' count get visible
						
						 Thread.sleep(8000);
						performerPOM.clickMyReminder().click();					//Clicking on 'My Reports'
						
						wait.until(ExpectedConditions.visibilityOf(performerPOM.CheckRecordsTable()));	//Wait until records table gets visible.
						
						NewReminder( test, "Case");
						
						NewReminder( test, "Notice");
						
						NewReminder(test, "Task");
						
						Thread.sleep(8000);
						OverduePOM.clickDashboard().click();
					}
					public static void ReminderWithoutData( ExtentTest test) throws InterruptedException, IOException
					{
						WebDriverWait wait = new WebDriverWait(getDriver(), 180);
						progress();
						
						Thread.sleep(8000);
						performerPOM.clickMyReminder().click();					//Clicking on 'My Reports'
						
						wait.until(ExpectedConditions.visibilityOf(performerPOM.CheckRecordsTable()));	//Wait until records table gets visible.
						
						NewReminder(test, "Case");
						
						NewReminder( test, "Notice");
						
						NewReminder(test, "Task");
						
						
						//Close Button
						
						Thread.sleep(8000);
						wait.until(ExpectedConditions.visibilityOf(performerPOM.clickAddNew1()));
						Thread.sleep(8000);
						performerPOM.clickAddNew1().click();		//Clicking on 'Add New' button.
						
						wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_showReminderDetail"));
						
						Thread.sleep(8000);
						  if(performerPOM.clickClosedDocument().isEnabled())
					  		{
					  			performerPOM.clickClosedDocument().click();
					  			test.log(LogStatus.PASS, "Close button working successfully");
					  		}
					  		else
					  		{
					  			test.log(LogStatus.FAIL, "Close button not working successfully");
					  		}
						  
							Thread.sleep(8000);
							getDriver().switchTo().parentFrame();
						
						
						
						
						
						Thread.sleep(8000);
						OverduePOM.clickDashboard().click();
					}
					public static void ImportUtility(ExtentTest test) throws InterruptedException
					{
					
						performerPOM.ClickImportUtility().click();
						Thread.sleep(3000);
						performerPOM.ChooseCaseType().click();
						Thread.sleep(3000);
						performerPOM.ChooseCaseFile();
						Thread.sleep(3000);
						performerPOM.UploadCaseFile().click();
						
						
						WebDriverWait wait=new WebDriverWait(getDriver(),30);
						Thread.sleep(3000);
						wait.until(ExpectedConditions.visibilityOf(performerPOM.readCaseMsg()));
						
						Thread.sleep(500);
						String msg5 = performerPOM.readCaseMsg().getText();		//Reading Message appeared after save button
						
						  if(msg5.equalsIgnoreCase(msg5))
							 {
								 test.log(LogStatus.PASS, "Message displayed = "+msg5);
								 
							 }
							 else
							 {
								 test.log(LogStatus.FAIL, "Message displayed = "+msg5);
							 }
					
						
						Thread.sleep(3000);
						performerPOM.ClickcaseHearing().click();
						Thread.sleep(3000);
						performerPOM.ChooseCaseFile();
						Thread.sleep(3000);
						performerPOM.UploadCaseFile().click();
						
//						
//						WebDriverWait wait1=new WebDriverWait(getDriver(),30);
//						Thread.sleep(3000);
//						wait.until(ExpectedConditions.visibilityOf(performerPOM.readCaseMsg()));
//						
						Thread.sleep(3000);
						//wait.until(ExpectedConditions.visibilityOf(performerPOM.readCaseMsg()));
						
						Thread.sleep(500);
					try
					{			
						String msg = performerPOM.readCaseMsg2().getText();		//Reading Message appeared after save button

						if(msg.equalsIgnoreCase(msg))
						{
							test.log(LogStatus.PASS, "Message displayed = "+msg);
						
						}
						else
						{
							test.log(LogStatus.FAIL, "Message displayed = "+msg);
						}
						
					}
						catch(Exception e)
						{
							test.log(LogStatus.FAIL, "Case Hearing = Validation message not displayed");
						}
					
						
						
						Thread.sleep(3000);
						performerPOM.ClickcaseOrder().click();
						Thread.sleep(3000);
						performerPOM.ChooseCaseFile();
						Thread.sleep(3000);
						performerPOM.UploadCaseFile().click();
						
						
						Thread.sleep(3000);
						wait.until(ExpectedConditions.visibilityOf(performerPOM.readCaseMsg()));
						
						Thread.sleep(500);
						String msg7 = performerPOM.readCaseMsg().getText();		//Reading Message appeared after save button
						
						if(msg7.equalsIgnoreCase(msg7))
						{
							test.log(LogStatus.PASS, "Message displayed = "+msg7);
							
						}
						else
						{
							test.log(LogStatus.PASS, "Message displayed = "+msg7);
						}
						
						
						Thread.sleep(3000);
						performerPOM.ClickcasePayment().click();
						Thread.sleep(3000);
						performerPOM.ChooseCaseFile();
						Thread.sleep(3000);
						performerPOM.UploadCaseFile().click();
						Thread.sleep(3000);
						
								
						Thread.sleep(500);
						String msg8 = performerPOM.readCaseMsg().getText();		//Reading Message appeared after save button
						
						if(msg8.equalsIgnoreCase(msg8))
						{
							test.log(LogStatus.PASS, "Message displayed = "+msg8);
						
						}
						else
						{
							test.log(LogStatus.FAIL, "Message displayed = "+msg8);
						}
						
						
						performerPOM.clickNotice().click();
						Thread.sleep(3000);
						performerPOM.ChooseNoticeType().click();
						Thread.sleep(3000);
						performerPOM.ChooseNoticeFile();
						Thread.sleep(3000);
						performerPOM.UploadNoticeFile().click();
						
						
						
						Thread.sleep(500);
						String msg1 = performerPOM.readNoticeMsg().getText();		//Reading Message appeared after save button
						
						if(msg1.equalsIgnoreCase(msg1))
						{
							test.log(LogStatus.PASS, "Message displayed = "+msg1);
						
						}
						else
						{
							test.log(LogStatus.FAIL, "Message displayed = "+msg1);
						}
						
						Thread.sleep(3000);
						performerPOM.ChooseNoticeResponse().click();
						Thread.sleep(3000);
						performerPOM.ChooseNoticeFile();
						Thread.sleep(3000);
						performerPOM.UploadNoticeFile().click();
						
						
						Thread.sleep(500);
						String msg2= performerPOM.readNoticeMsg().getText();		//Reading Message appeared after save button
					
						if(msg2.equalsIgnoreCase(msg2))
						{
							test.log(LogStatus.PASS, "Message displayed = "+msg2);
							
						}
						else
						{
							test.log(LogStatus.FAIL, "Message displayed = "+msg2);
						}
					
//						
						Thread.sleep(3000);
						performerPOM.ChoosePaymentInfo().click();
						Thread.sleep(3000);
						performerPOM.ChooseNoticeFile();
						Thread.sleep(3000);
						performerPOM.UploadNoticeFile().click();
						Thread.sleep(3000);
//						
//							
//						
//						WebDriverWait wait4=new WebDriverWait(getDriver(),30);
//						Thread.sleep(3000);
//						wait1.until(ExpectedConditions.visibilityOf(performerPOM.readNoticeMsg()));
						
						Thread.sleep(500);
						String msg3 = performerPOM.readNoticeMsg().getText();		//Reading Message appeared after save button
						
						if(msg3.equalsIgnoreCase(msg3))
						{
							test.log(LogStatus.PASS, "Message displayed = "+msg3);
						
						}
						else
						{
							test.log(LogStatus.FAIL, "Message displayed = "+msg3);
						}
						Thread.sleep(300);
						OverduePOM.clickDashboard().click();
						
						
					}
					
					public static void ImportUtilityWithoutData(ExtentTest test) throws InterruptedException
					{
						Thread.sleep(8000);
						performerPOM.ClickImportUtility().click();
						Thread.sleep(8000);
						performerPOM.ChooseCaseType().click();
						Thread.sleep(8000);
						performerPOM.ChooseCaseFile1();
						Thread.sleep(8000);
						performerPOM.UploadCaseFile().click();
						
						
						try
						{
							
						  Thread.sleep(8000);
						  String msg7 = performerPOM.readCaseMsg1().getText();		//Reading Message appeared after save button
			              test.log(LogStatus.PASS, "Court Case =  Upload Empty File = "+msg7);
							
						  }
						catch(Exception e)
						{
							test.log(LogStatus.FAIL, "Court Case = Validation message not displayed");
						}
					
						
				     	Thread.sleep(8000);
						performerPOM.ClickcaseHearing().click();
						Thread.sleep(8000);
						performerPOM.ChooseCaseFile1();
						Thread.sleep(8000);
						performerPOM.UploadCaseFile().click();
						
			        	try
						{
							
						  Thread.sleep(8000);
						  String msg7 = performerPOM.readCaseMsg1().getText();		//Reading Message appeared after save button
			              test.log(LogStatus.PASS, "Case Hearing =  Upload Empty File = "+msg7);
							
						  }
						catch(Exception e)
						{
							test.log(LogStatus.FAIL, "Case Hearing = Validation message not displayed");
						}
						
					
						
						
						Thread.sleep(8000);
						performerPOM.ClickcaseOrder().click();
						Thread.sleep(8000);
						performerPOM.ChooseCaseFile1();
						Thread.sleep(8000);
						performerPOM.UploadCaseFile().click();
							
						try
						{
							
						  Thread.sleep(8000);
						  String msg7 = performerPOM.readCaseMsg1().getText();		//Reading Message appeared after save button
			              test.log(LogStatus.PASS, "Case Order =  Upload Empty File = "+msg7);
							
						  }
						catch(Exception e)
						{
							test.log(LogStatus.FAIL, "Case Order = Validation message not displayed");
						}
						
						
						Thread.sleep(8000);
						performerPOM.ClickcasePayment().click();
						Thread.sleep(8000);
						performerPOM.ChooseCaseFile1();
						Thread.sleep(8000);
						performerPOM.UploadCaseFile().click();
						Thread.sleep(8000);
											
						try
						{
							
						  Thread.sleep(8000);
						  String msg7 = performerPOM.readCaseMsg1().getText();		//Reading Message appeared after save button
			              test.log(LogStatus.PASS, "Case Payment =  Upload Empty File = "+msg7);
							
						  }
						catch(Exception e)
						{
							test.log(LogStatus.FAIL, "Case Payment = Validation message not displayed");
						}
						
						
						Thread.sleep(8000);
						performerPOM.clickNotice().click();
						Thread.sleep(8000);
						performerPOM.ChooseNoticeType().click();
						Thread.sleep(8000);
						performerPOM.ChooseNoticeFile1();
						Thread.sleep(8000);
						performerPOM.UploadNoticeFile().click();
						
						
						
						try
						{
							
						  Thread.sleep(8000);
						  String msg7 = performerPOM.readNoticeMsg1().getText();		//Reading Message appeared after save button
			              test.log(LogStatus.PASS, "Legal Notice =  Upload Empty File = "+msg7);
							
						  }
						catch(Exception e)
						{
							test.log(LogStatus.FAIL, "Legal Notice = Validation message not displayed");
						}
						
						Thread.sleep(8000);
						performerPOM.ChooseNoticeResponse().click();
						Thread.sleep(8000);
						performerPOM.ChooseNoticeFile1();
						Thread.sleep(8000);
						performerPOM.UploadNoticeFile().click();
						
						
						try
						{
							
						  Thread.sleep(8000);
						  String msg7 = performerPOM.readNoticeMsg1().getText();		//Reading Message appeared after save button
			              test.log(LogStatus.PASS, " Notice Response =  Upload Empty File = "+msg7);
							
						  }
						catch(Exception e)
						{
							test.log(LogStatus.FAIL, "Notice Response =Validation message not displayed");
						}
					
					
						Thread.sleep(8000);
						performerPOM.ChoosePaymentInfo().click();
						Thread.sleep(8000);
						performerPOM.ChooseNoticeFile1();
						Thread.sleep(8000);
						performerPOM.UploadNoticeFile().click();
						Thread.sleep(8000);
						
						try
						{
							
						  Thread.sleep(8000);
						  String msg7 = performerPOM.readNoticeMsg1().getText();		//Reading Message appeared after save button
			              test.log(LogStatus.PASS, "Notice Payment =  Upload Empty File = "+msg7);
							
						  }
						catch(Exception e)
						{
							test.log(LogStatus.FAIL, "Notice Payment = Validation message not displayed");
						}
						Thread.sleep(8000);
						OverduePOM.clickDashboard().click();
						
						
					}
					
					public static void ImportUtilityInvalidData(ExtentTest test) throws InterruptedException
					{
						Thread.sleep(8000);
						performerPOM.ClickImportUtility().click();
						Thread.sleep(8000);
						performerPOM.ChooseCaseType().click();
						Thread.sleep(8000);
						performerPOM.ChooseCaseFile2();
						Thread.sleep(8000);
						performerPOM.UploadCaseFile().click();
						
						
						WebDriverWait wait=new WebDriverWait(getDriver(),30);
						Thread.sleep(8000);
						wait.until(ExpectedConditions.visibilityOf(performerPOM.readCaseMsg1()));
						
						Thread.sleep(8000);
						String msg5 = performerPOM.readCaseMsg1().getText();		//Reading Message appeared after save button
					
						if(msg5.equalsIgnoreCase(msg5))
						{
							test.log(LogStatus.PASS, "Court Case = Enter Invalid Data in Upload File = "+msg5);
						
						}
						else
						{
							test.log(LogStatus.FAIL, "Court Case = Enter Invalid Data in Upload File  = "+msg5);
						}
					
						
						Thread.sleep(8000);
						performerPOM.ClickcaseHearing().click();
						Thread.sleep(8000);
						performerPOM.ChooseCaseFile2();
						Thread.sleep(8000);
						performerPOM.UploadCaseFile().click();
						
			
						Thread.sleep(8000);
						String msg6 = performerPOM.readCaseMsg1().getText();		//Reading Message appeared after save button
						
						if(msg6.equalsIgnoreCase(msg6))
						{
							test.log(LogStatus.PASS, "Case Hearing  = Enter Invalid Data in Upload File = "+msg6);
						
						}
						else
						{
							test.log(LogStatus.FAIL, "Case Hearing = Enter Invalid Data in Upload File  = "+msg6);
						}
					
						
						
						Thread.sleep(8000);
						performerPOM.ClickcaseOrder().click();
						Thread.sleep(8000);
						performerPOM.ChooseCaseFile2();
						Thread.sleep(8000);
						performerPOM.UploadCaseFile().click();
						
					
						Thread.sleep(8000);
						wait.until(ExpectedConditions.visibilityOf(performerPOM.readCaseMsg1()));
						
						Thread.sleep(8000);
						String msg7 = performerPOM.readCaseMsg1().getText();		//Reading Message appeared after save button
						
						if(msg7.equalsIgnoreCase(msg7))
						{
							test.log(LogStatus.PASS, "Case Order = Enter Invalid Data in Upload File  = "+msg7);
							
						}
						else
						{
							test.log(LogStatus.FAIL, "Case Order = Enter Invalid Data in Upload File  = "+msg7);
						}
						
						
						Thread.sleep(8000);
						performerPOM.ClickcasePayment().click();
						Thread.sleep(8000);
						performerPOM.ChooseCaseFile2();
						Thread.sleep(8000);
						performerPOM.UploadCaseFile().click();
						Thread.sleep(8000);
						
												
						Thread.sleep(8000);
						String msg8 = performerPOM.readCaseMsg1().getText();		//Reading Message appeared after save button
						
						if(msg8.equalsIgnoreCase(msg8))
						{
							test.log(LogStatus.PASS, "Case Payment = Enter Invalid Data in Upload File  = "+msg8);
						
						}
						else
						{
							test.log(LogStatus.FAIL, "Case Payment = Enter Invalid Data in Upload File = "+msg8);
						}
						
						Thread.sleep(8000);
						performerPOM.clickNotice().click();
						Thread.sleep(8000);
						performerPOM.ChooseNoticeType().click();
						Thread.sleep(8000);
						performerPOM.ChooseNoticeFile2();
						Thread.sleep(8000);
						performerPOM.UploadNoticeFile().click();
						
						
						
						Thread.sleep(8000);
						String msg = performerPOM.readNoticeMsg1().getText();		//Reading Message appeared after save button
						
						if(msg.equalsIgnoreCase(msg))
						{
							test.log(LogStatus.PASS, "Leagl Notice = Enter Invalid Data in Upload File  = "+msg);
						
						}
						else
						{
							test.log(LogStatus.FAIL, "Leagl Notice  = Enter Invalid Data in Upload File = "+msg);
						}
						
						Thread.sleep(8000);
						performerPOM.ChooseNoticeResponse().click();
						Thread.sleep(8000);
						performerPOM.ChooseNoticeFile2();
						Thread.sleep(8000);
						performerPOM.UploadNoticeFile().click();
						
						
						Thread.sleep(8000);
						String msg1= performerPOM.readNoticeMsg1().getText();		//Reading Message appeared after save button
						
						if(msg1.equalsIgnoreCase(msg1))
						{
							test.log(LogStatus.PASS, "Notice Reposnse = Enter Invalid Data in Upload File = "+msg1);
							
						}
						else
						{
							test.log(LogStatus.FAIL, "Notice Reposnse = Enter Invalid Data in Upload File = "+msg1);
						}
					
//						
						Thread.sleep(8000);
						performerPOM.ChoosePaymentInfo().click();
						Thread.sleep(8000);
						performerPOM.ChooseNoticeFile2();
						Thread.sleep(8000);
						performerPOM.UploadNoticeFile().click();
						Thread.sleep(8000);

						Thread.sleep(8000);
						String msg3 = performerPOM.readNoticeMsg1().getText();		//Reading Message appeared after save button
						
						if(msg3.equalsIgnoreCase(msg3))
						{
							test.log(LogStatus.PASS, "Notice Payment = Enter Invalid Data in Upload File = "+msg3);
						
						}
						else
						{
							test.log(LogStatus.FAIL, "Notice Payment = Enter Invalid Data in Upload File  = "+msg3);
						}
						Thread.sleep(8000);
						OverduePOM.clickDashboard().click();
						
						
					}
					
					public static void ImportUtilityTwoManadtoryFileds(ExtentTest test) throws InterruptedException
					{
						Thread.sleep(8000);
						performerPOM.ClickImportUtility().click();
						Thread.sleep(8000);
						performerPOM.ChooseCaseType().click();
						Thread.sleep(8000);
						performerPOM.ChooseCaseFile3();
						Thread.sleep(8000);
						performerPOM.UploadCaseFile().click();
						
						
						WebDriverWait wait=new WebDriverWait(getDriver(),30);
						Thread.sleep(8000);
						wait.until(ExpectedConditions.visibilityOf(performerPOM.readCaseMsg1()));
						
						Thread.sleep(8000);
						String msg5 = performerPOM.readCaseMsg1().getText();		//Reading Message appeared after save button
					
						if(msg5.equalsIgnoreCase(msg5))
						{
							test.log(LogStatus.PASS, "Court Case = Enter Two Manadatory fields in Upload File = "+msg5);
						
						}
						else
						{
							test.log(LogStatus.FAIL, "Court Case =Enter Two Manadatory fields in Upload File  = "+msg5);
						}
					
						
						Thread.sleep(8000);
						performerPOM.ClickcaseHearing().click();
						Thread.sleep(8000);
						performerPOM.ChooseCaseFile3();
						Thread.sleep(8000);
						performerPOM.UploadCaseFile().click();
						
			
						Thread.sleep(8000);
						String msg6 = performerPOM.readCaseMsg1().getText();		//Reading Message appeared after save button
						
						if(msg6.equalsIgnoreCase(msg6))
						{
							test.log(LogStatus.PASS, "Case Hearing  = Enter Two Manadatory fields in Upload File = "+msg6);
						
						}
						else
						{
							test.log(LogStatus.FAIL, "Case Hearing = Enter Two Manadatory fields in Upload File = "+msg6);
						}
					
						
						
						Thread.sleep(8000);
						performerPOM.ClickcaseOrder().click();
						Thread.sleep(8000);
						performerPOM.ChooseCaseFile3();
						Thread.sleep(8000);
						performerPOM.UploadCaseFile().click();
						
					
						Thread.sleep(8000);
						wait.until(ExpectedConditions.visibilityOf(performerPOM.readCaseMsg1()));
						
						Thread.sleep(8000);
						String msg7 = performerPOM.readCaseMsg1().getText();		//Reading Message appeared after save button
						
						if(msg7.equalsIgnoreCase(msg7))
						{
							test.log(LogStatus.PASS, "Case Order =Enter Two Manadatory fields in Upload File  = "+msg7);
							
						}
						else
						{
							test.log(LogStatus.FAIL, "Case Order = Enter Two Manadatory fields in Upload File  = "+msg7);
						}
						
						
						Thread.sleep(8000);
						performerPOM.ClickcasePayment().click();
						Thread.sleep(8000);
						performerPOM.ChooseCaseFile3();
						Thread.sleep(8000);
						performerPOM.UploadCaseFile().click();
						Thread.sleep(8000);
						
												
						Thread.sleep(8000);
						String msg8 = performerPOM.readCaseMsg1().getText();		//Reading Message appeared after save button
						
						if(msg8.equalsIgnoreCase(msg8))
						{
							test.log(LogStatus.PASS, "Case Payment = Enter Two Manadatory fields in Upload File  = "+msg8);
						
						}
						else
						{
							test.log(LogStatus.FAIL, "Case Payment = Enter Two Manadatory fields in Upload File = "+msg8);
						}
						
						Thread.sleep(8000);
						performerPOM.clickNotice().click();
						Thread.sleep(8000);
						performerPOM.ChooseNoticeType().click();
						Thread.sleep(8000);
						performerPOM.ChooseNoticeFile3();
						Thread.sleep(8000);
						performerPOM.UploadNoticeFile().click();
						
						
						
						Thread.sleep(8000);
						String msg = performerPOM.readNoticeMsg1().getText();		//Reading Message appeared after save button
						
						if(msg.equalsIgnoreCase(msg))
						{
							test.log(LogStatus.PASS, "Leagl Notice = Enter Two Manadatory Fileds  in Upload File  = "+msg);
						
						}
						else
						{
							test.log(LogStatus.FAIL, "Leagl Notice  = Enter Two Manadatory Fileds  in Upload File = "+msg);
						}
						
						Thread.sleep(8000);
						performerPOM.ChooseNoticeResponse().click();
						Thread.sleep(8000);
						performerPOM.ChooseNoticeFile3();
						Thread.sleep(8000);
						performerPOM.UploadNoticeFile().click();
						
						
						Thread.sleep(8000);
						String msg1= performerPOM.readNoticeMsg1().getText();		//Reading Message appeared after save button
						
						if(msg1.equalsIgnoreCase(msg1))
						{
							test.log(LogStatus.PASS, "Notice Reposnse = Enter Two Manadatory Fileds  in Upload File = "+msg1);
							
						}
						else
						{
							test.log(LogStatus.FAIL, "Notice Reposnse = Enter Two Manadatory Fileds  in Upload File = "+msg1);
						}
					
						
						Thread.sleep(8000);
						performerPOM.ChoosePaymentInfo().click();
						Thread.sleep(8000);
						performerPOM.ChooseNoticeFile3();
						Thread.sleep(8000);
						performerPOM.UploadNoticeFile().click();
						Thread.sleep(8000);

						Thread.sleep(8000);
						String msg3 = performerPOM.readNoticeMsg1().getText();		//Reading Message appeared after save button
						
						if(msg3.equalsIgnoreCase(msg3))
						{
							test.log(LogStatus.PASS, "Notice Payment = Enter Two Manadatory Fileds in Upload File = "+msg3);
						
						}
						else
						{
							test.log(LogStatus.FAIL, "Notice Payment = Enter Two Manadatory Fileds  in Upload File  = "+msg3);
						}
						Thread.sleep(8000);
						OverduePOM.clickDashboard().click();
						
						
					}
					public static void CaseUpdationImportUtility(ExtentTest test) throws InterruptedException
					{
						
						performerPOM.ClickImportUtility().click();
						Thread.sleep(3000);
						performerPOM.ChooseCaseUpdationType().click();
						Thread.sleep(3000);
						performerPOM.ChooseCaseUpdationFile();
						Thread.sleep(3000);
						performerPOM.UploadCaseFile().click();
						
						
						WebDriverWait wait=new WebDriverWait(getDriver(),30);
						Thread.sleep(3000);
						wait.until(ExpectedConditions.visibilityOf(performerPOM.readCaseMsg()));
						
						Thread.sleep(500);
						String msg5 = performerPOM.readCaseMsg().getText();		//Reading Message appeared after save button
					
						if(msg5.equalsIgnoreCase(msg5))
						{
							test.log(LogStatus.PASS, "Message displayed = "+msg5);
						
						}
						else
						{
							test.log(LogStatus.FAIL, "Message displayed = "+msg5);
						}
						
						Thread.sleep(300);
						OverduePOM.clickDashboard().click();
					}
					
					public static void CaseUpdationUploadEmtyFile(ExtentTest test) throws InterruptedException
					{
					
						performerPOM.ClickImportUtility().click();
						Thread.sleep(3000);
						performerPOM.ChooseCaseUpdationType().click();
						Thread.sleep(3000);
						performerPOM.ChooseCaseUpdationFile1();
						Thread.sleep(3000);
						performerPOM.UploadCaseFile().click();
						
						
						try
						{
							
						  Thread.sleep(500);
						  String msg7 = performerPOM.readCaseMsg1().getText();		//Reading Message appeared after save button
				          test.log(LogStatus.PASS, "Case Updation =  Upload Empty File = "+msg7);
							
						  }
						catch(Exception e)
						{
							test.log(LogStatus.FAIL, "Case Updation = Validation message not displayed");
						}
						Thread.sleep(300);
						OverduePOM.clickDashboard().click();
					}
					public static void CaseUpdationUploadInvalidData(ExtentTest test) throws InterruptedException
					{
					
						performerPOM.ClickImportUtility().click();
						Thread.sleep(3000);
						performerPOM.ChooseCaseUpdationType().click();
						Thread.sleep(3000);
						performerPOM.ChooseCaseUpdationFile2();
						Thread.sleep(3000);
						performerPOM.UploadCaseFile().click();
						
						
						try
						{
							
						  Thread.sleep(500);
						  String msg7 = performerPOM.readCaseMsg1().getText();		//Reading Message appeared after save button
				          test.log(LogStatus.PASS, "Case Updation =  Upload Empty File = "+msg7);
							
						  }
						catch(Exception e)
						{
							test.log(LogStatus.FAIL, "Case Updation = Validation message not displayed");
						}
						Thread.sleep(300);
						OverduePOM.clickDashboard().click();
					}
							
					public static void CaseUpdationUploadInvalidFile(ExtentTest test) throws InterruptedException
					{
					
						performerPOM.ClickImportUtility().click();
						Thread.sleep(3000);
						performerPOM.ChooseCaseUpdationType().click();
						Thread.sleep(3000);
						performerPOM.ChooseCaseFile3();
						Thread.sleep(3000);
						performerPOM.UploadCaseFile().click();
						
						
						try
						{
							
						  Thread.sleep(500);
						  String msg7 = performerPOM.readCaseMsg1().getText();		//Reading Message appeared after save button
				          test.log(LogStatus.PASS, "Case Updation =  Upload Invalid File = "+msg7);
							
						  }
						catch(Exception e)
						{
							test.log(LogStatus.FAIL, "Case Updation = Validation message not displayed");
						}
						Thread.sleep(300);
						OverduePOM.clickDashboard().click();
					}
							
				public static void NoticeUpdation(ExtentTest test) throws InterruptedException
				{
					
					performerPOM.ClickImportUtility().click();
					Thread.sleep(3000);
					performerPOM.clickNotice().click();
					Thread.sleep(3000);
					performerPOM.ChooseNoticeUpdationType().click();
					Thread.sleep(3000);
					performerPOM.ChooseNoticeUpdationFile();
					Thread.sleep(3000);
					performerPOM.UploadNoticeFile().click();
					
					
					
					Thread.sleep(500);
					String msg = performerPOM.readNoticeMsg().getText();		//Reading Message appeared after save button
					
					if(msg.equalsIgnoreCase(msg))
					{
						test.log(LogStatus.PASS, "Message displayed = "+msg);
					
					}
					else
					{
						test.log(LogStatus.FAIL, "Message displayed = "+msg);
					}
					Thread.sleep(300);
					OverduePOM.clickDashboard().click();
				}
				
				public static void NoticeUpdationUploadEmtyFile(ExtentTest test) throws InterruptedException
				{
				
					performerPOM.ClickImportUtility().click();
					Thread.sleep(3000);
					performerPOM.clickNotice().click();
					Thread.sleep(3000);
					performerPOM.ChooseNoticeUpdationType().click();
					Thread.sleep(3000);
					performerPOM.ChooseNoticeUpdtionEmptyFile();
					Thread.sleep(3000);
					performerPOM.UploadNoticeFile().click();
					
					try
					{
						
					  Thread.sleep(500);
					  String msg7 = performerPOM.readCaseMsg1().getText();		//Reading Message appeared after save button
				      test.log(LogStatus.PASS, "Notice Updation =  Upload Empty File = "+msg7);
						
					  }
					catch(Exception e)
					{
						test.log(LogStatus.FAIL, "Notice Updation = Validation message not displayed");
					}
					Thread.sleep(300);
					OverduePOM.clickDashboard().click();
				}
				public static void NoticeUpdationUploadInvalidData(ExtentTest test) throws InterruptedException
				{
				
					performerPOM.ClickImportUtility().click();
					Thread.sleep(3000);
					performerPOM.clickNotice().click();
					Thread.sleep(3000);
					performerPOM.ChooseNoticeUpdationType().click();
					Thread.sleep(3000);
					performerPOM.ChooseNoticeUpdtionInvalidData();
					Thread.sleep(3000);
					performerPOM.UploadNoticeFile().click();
					
					
					try
					{
						
					  Thread.sleep(500);
					  String msg7 = performerPOM.readCaseMsg1().getText();		//Reading Message appeared after save button
				      test.log(LogStatus.PASS, "Notice Updation =  Upload Empty File = "+msg7);
						
					  }
					catch(Exception e)
					{
						test.log(LogStatus.FAIL, "Notice Updation = Validation message not displayed");
					}
					Thread.sleep(300);
					OverduePOM.clickDashboard().click();
				}
				public static void NoticeUpdationUploadInvalidFile(ExtentTest test) throws InterruptedException
				{
					performerPOM.ClickImportUtility().click();
					Thread.sleep(3000);
					performerPOM.clickNotice().click();
					Thread.sleep(3000);
					performerPOM.ChooseNoticeUpdationType().click();
					Thread.sleep(3000);
					performerPOM.ChooseCaseFile3();
					Thread.sleep(3000);
					performerPOM.UploadNoticeFile().click();
					
					
					
					try
					{
						
					  Thread.sleep(500);
					  String msg7 = performerPOM.readCaseMsg1().getText();		//Reading Message appeared after save button
				      test.log(LogStatus.PASS, "Notice Updation =  Upload Invalid File = "+msg7);
						
					  }
					catch(Exception e)
					{
						test.log(LogStatus.FAIL, "Notice Updation = Validation message not displayed");
					}
					Thread.sleep(300);
					OverduePOM.clickDashboard().click();
				}
					public static void selectCaseType() 
						{
							//WebDriverWait wait = new WebDriverWait(getDriver(), 20);
							//WebElement CaseType = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("rbCaseInOutType_chosen")));
							WebElement CaseType = performerPOM.clickCaseType1();
							CaseType.click();
							
							performerPOM.chooseCaseType().click();
						}
						
						 static void selectOptionFromDropDown_bs(List<WebElement> options, String value)
		            	  {
		          			
		          			for(WebElement option:options) 
		          			{
		          				if(option.getText().equals(value))
		          				{
		          					option.click();
		          					
		          					break;
		          				}
		          			}
		          		 }
						

	  	
			

}
