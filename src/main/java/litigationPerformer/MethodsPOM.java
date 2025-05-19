package litigationPerformer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cfo.CFOcountPOM;
import licensePerformer.LiPerformerPOM;
import login.BasePage;
import performer.OverduePOM;

public class MethodsPOM extends BasePage
{
	private static List<WebElement> elementsList = null;
	
	public static FileInputStream fis = null;	//File input stream variable
	public static XSSFWorkbook workbook = null;	//Excel sheet workbook variable
	public static XSSFSheet sheet = null;		//Sheet variable
	public static XSSFSheet sheet1 = null;		//Sheet variable
	
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
	
	static void perform( ExtentTest test, XSSFSheet sheet, int open, int gridRecords, String type) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), 50);
		WebDriverWait wait1 = new WebDriverWait(getDriver(), 300);
		
		Thread.sleep(500);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		CFOcountPOM.clickNextPage1().sendKeys(Keys.UP);
		js.executeScript("window.scrollBy(0,-700)");
		performerPOM.clickNew().click();						//Clicking on 'New' button
		
		progress();
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
		
		performerPOM.clickDated().click();					//Clicking on 'Dated' button
		OverduePOM.selectLastMonth().click();					//Clicking last month arrow.
		OverduePOM.selectDate3().click();						//Clicking particular date.
		
		Thread.sleep(300);
		performerPOM.clickFinancialYear().click();			//Clicking on 'Financial Year' drop down.
		elementsList = performerPOM.chooseDropDownOption();
		elementsList.get(2).click();								//Clicking third option
		performerPOM.clickFinancialYear().click();			//Clicking on 'Financial Year' drop down.
		
		Thread.sleep(500);
		Row row0 = sheet.getRow(0);						//Selected 0th index row (First row)
		Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		String refno = c1.getStringCellValue();
		performerPOM.clickRefNo().sendKeys(refno);			//Writing 'Reference No'
		
		Thread.sleep(300);
		row0 = sheet.getRow(1);						//Selected 0th index row (First row)
		c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		String noticeType = c1.getStringCellValue();
		performerPOM.clickNoticeType().click();
		performerPOM.clickSearch().sendKeys(noticeType, Keys.ENTER);	//Writing 'Notice Type'
		
		Thread.sleep(300);
		progress();
		
		Thread.sleep(300);
		row0 = sheet.getRow(2);						//Selected 0th index row (First row)
		c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		int actNo = (int) c1.getNumericCellValue();
		performerPOM.clickAct().click();						//Clicking on 'Act' drop down.
		elementsList = performerPOM.chooseAct();
		elementsList.get(actNo).click();							//Selecting particular act no
		performerPOM.clickAct().click();						//Clicking on 'Act' drop down.
		
		Thread.sleep(300);
		row0 = sheet.getRow(3);						//Selected 0th index row (First row)
		c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		String underSection = c1.getStringCellValue();
		performerPOM.clickUnderSection().sendKeys(underSection);	//Writing 'Under section'
		
		Thread.sleep(300);
		row0 = sheet.getRow(4);						//Selected 0th index row (First row)
		c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		String opponent = c1.getStringCellValue();
		performerPOM.clickOpponent().click();					//Clicking on 'Opponent'
		performerPOM.clickSearch1().sendKeys(opponent);		//Writing 'Opponent' name
		Thread.sleep(300);
		performerPOM.clickSelectAll().click();
		performerPOM.clickOpponent().click();
		
		Thread.sleep(300);
		row0 = sheet.getRow(5);						//Selected 0th index row (First row)
		c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		String oppoLawyer = c1.getStringCellValue();
		performerPOM.clickOppLawyer().click();				//Clicking on 'Opponent'
		performerPOM.clickSearch2().sendKeys(oppoLawyer);		//Writing 'Opposition Lawyer' name
		Thread.sleep(300);
		performerPOM.clickSelectAll1().click();
		performerPOM.clickOppLawyer().click();
		
		Thread.sleep(300);
		row0 = sheet.getRow(6);						//Selected 0th index row (First row)
		c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		String title = c1.getStringCellValue();
		performerPOM.clickNoticeTitle().sendKeys(title);		//Writing 'Notice Title'
		
		Thread.sleep(300);
		row0 = sheet.getRow(7);						//Selected 0th index row (First row)
		c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		String desc = c1.getStringCellValue();
		performerPOM.clickNoticeDescription().sendKeys(desc);	//Writing 'Notice Description'
		
		Thread.sleep(300);		
		performerPOM.clickNoticeDescription().sendKeys(Keys.PAGE_DOWN);
		
		Thread.sleep(300);
		performerPOM.clickLocation().click();					//Clicking on Location drop down
		Thread.sleep(300);
		//performerPOM.clickPlus().click();
		elementsList = performerPOM.selectLocation();
		elementsList.get(2).click();								//Selecting third visible location
		
		Thread.sleep(300);
		wait.until(ExpectedConditions.visibilityOf(performerPOM.clickDated()));
		wait.until(ExpectedConditions.elementToBeClickable(performerPOM.clickLocation()));
		
		performerPOM.clickNoticeDescription().sendKeys(Keys.PAGE_DOWN);
		
		Thread.sleep(300);
		row0 = sheet.getRow(8);						//Selected 0th index row (First row)
		c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		String jurisdiction = c1.getStringCellValue();
		performerPOM.clickJurisdiction().click();					//Clicking on 'Jurisdiction' drop down
		Thread.sleep(600);
		performerPOM.clickSearch3().sendKeys(jurisdiction, Keys.ENTER);	//Writing 'Jurisdiction' name
		
		Thread.sleep(300);
		row0 = sheet.getRow(9);						//Selected 0th index row (First row)
		c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		String dept = c1.getStringCellValue();
		performerPOM.clickDepartment().click();					//Clicking on 'Department' drop down
		performerPOM.clickSearch4().sendKeys(dept, Keys.ENTER);	//Writing 'Department' name
		
		Thread.sleep(300);
		row0 = sheet.getRow(10);					//Selected 0th index row (First row)
		c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		String ContactDept = c1.getStringCellValue();
		performerPOM.clickContactDept().click();					//Clicking on 'Contact Person of Department' drop down
		performerPOM.clickSearch5().sendKeys(ContactDept, Keys.ENTER);	//Writing 'Contact Person' name
		
		Thread.sleep(300);
		row0 = sheet.getRow(11);					//Selected 0th index row (First row)
		c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		int noticeTerm = (int) c1.getNumericCellValue();
		performerPOM.clickNoticeTerm().sendKeys(noticeTerm+"");		//Writing 'Notice Term'
		
		Thread.sleep(300);
		row0 = sheet.getRow(12);					//Selected 0th index row (First row)
		c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		String owner = c1.getStringCellValue();
		performerPOM.clickOwner().click();					//Clicking on 'Owner' drop down
		performerPOM.clickSearch6().sendKeys(owner, Keys.ENTER);	//Writing 'Owner' name
		
		Thread.sleep(300);
		performerPOM.clickWinningProspect().click();
		Thread.sleep(100);
		performerPOM.selectRisk().click();	//Selecting 'Medium' Winning Prospect'
		
		Thread.sleep(300);
		row0 = sheet.getRow(13);					//Selected 0th index row (First row)
		c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		int noticeBudget = (int) c1.getNumericCellValue();
		performerPOM.clickNoticeBudget().sendKeys(noticeBudget+"");	//Writing 'Notice Budget'
		
		Thread.sleep(300);
		row0 = sheet.getRow(14);					//Selected 0th index row (First row)
		c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		int claimedAmount = (int) c1.getNumericCellValue();
		performerPOM.clickClaimedAmount().sendKeys(claimedAmount+"");	//Writing 'Claimed Amount'
		
		Thread.sleep(300);
		row0 = sheet.getRow(15);					//Selected 0th index row (First row)
		c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		String state = c1.getStringCellValue();
		performerPOM.clickState().click();					//Clicking on 'Owner' drop down
		performerPOM.clickSearchState().sendKeys(state, Keys.ENTER);	//Writing 'State' name
		
		Thread.sleep(300);
		row0 = sheet.getRow(16);					//Selected 0th index row (First row)
		c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		int probAmount = (int) c1.getNumericCellValue();
		performerPOM.clickProbableAmount().sendKeys(probAmount+"");	//Writing 'Probable Amount'
		
		Thread.sleep(300);
		row0 = sheet.getRow(17);					//Selected 0th index row (First row)
		c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		int provAmount = (int) c1.getNumericCellValue();
		performerPOM.clickProvisionalAmount().sendKeys(provAmount+"");	//Writing 'Provisional Amount'
		
		Thread.sleep(300);
		row0 = sheet.getRow(18);					//Selected 0th index row (First row)
		c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		int protestAmount = (int) c1.getNumericCellValue();
		performerPOM.clickProtestMoney().sendKeys(protestAmount+"");	//Writing 'Protest Amount'
		
		Thread.sleep(500);
		performerPOM.clickProtestMoney().sendKeys(Keys.PAGE_DOWN);
		
		Thread.sleep(500);
		performerPOM.clickRisk().click();							//Clicking on 'Risk' drop down.
		Thread.sleep(300);
		performerPOM.selectRisk2().click();						//Selecting second option 'High' risk.
		
		Thread.sleep(500);
		performerPOM.clickPotentialImpactRadio().click();			//Clicking on 'Monetary' radio button
		
		Thread.sleep(400);
		performerPOM.clickMonetary().sendKeys("Automation123");
		
		Thread.sleep(300);
		row0 = sheet.getRow(19);					//Selected 0th index row (First row)
		c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		String lawFirm = c1.getStringCellValue();
		performerPOM.clickLawFirm().click();		//Clicking on 'Law Firm' drop down.
		performerPOM.chooseLawFirm().sendKeys(lawFirm, Keys.DOWN, Keys.ENTER);	//Writing & selecting 'Law Firm' name
		
		Thread.sleep(300);
		progress();
		
		Thread.sleep(300);
		row0 = sheet.getRow(20);						//Selected 0th index row (First row)
		c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		int internalUserNo = (int) c1.getNumericCellValue();
		performerPOM.clickInternalUser().click();						//Clicking on 'Internal User' drop down.
		elementsList = performerPOM.chooseInternalUser();
		elementsList.get(internalUserNo).click();							//Selecting particular user no
		performerPOM.clickInternalUser().click();						//Clicking on 'Internal User' drop down.
		
		Thread.sleep(300);
		row0 = sheet.getRow(21);						//Selected 0th index row (First row)
		c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		int lawyerNo = (int) c1.getNumericCellValue();
		performerPOM.clickLawyer().click();						//Clicking on 'Lawyer' drop down.
		elementsList = performerPOM.chooseLawyer();
		elementsList.get(lawyerNo).click();								//Selecting particular lawyer no
		performerPOM.clickLawyer().click();						//Clicking on 'Lawyer' drop down.
		
		Thread.sleep(500);
		OverduePOM.clickSaveButton().click();						//Clicking on 'Save'button.
		
		Thread.sleep(500);
		wait1.until(ExpectedConditions.visibilityOf(performerPOM.readMessage()));
		
		Thread.sleep(500);
		String msg = performerPOM.readMessage().getText();		//Reading Message appeared after save button
		int flag = 0;
		if(msg.equalsIgnoreCase("Notice Created Successfully."))
		{
			test.log(LogStatus.PASS, "Message displayed = "+msg);
			flag = 1;
		}
		else
		{
			test.log(LogStatus.FAIL, "Message displayed = "+msg);
		}
		
		WebElement ele1 = null;
		WebElement ele2 = null;
		WebElement ele3 = null;
		WebElement ele4 = null;
		
		if(flag == 1)
		{
			try
			{
				ele1 = performerPOM.clickLinkNotice();
				ele2 = performerPOM.clickViewDoc();
				ele3 = performerPOM.clickSendMail();
				ele4 = performerPOM.clickEditNotice();
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
		}
		
		getDriver().switchTo().parentFrame();
		performerPOM.clickClose().click();			//Clicking on 'Close'
		
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
			test.log(LogStatus.PASS, "Total Notice Count increased in grid after adding New Notice.");
			test.log(LogStatus.INFO, "Old Notice Count from Grid = "+gridRecords+" | New Notice Count from Grid = "+count1);
		}
		else
		{
			test.log(LogStatus.FAIL, "Total Notice Count doesn't increased in grid after adding New Notice.");
			test.log(LogStatus.INFO, "Old Notice Count from Grid = "+gridRecords+" | New Notice Count from Grid = "+count1);
		}
		
		Thread.sleep(500);
		OverduePOM.clickDashboard().click();			//Clicking on 'Dashboard'
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOf(performerPOM.clickNoticeOpen()));
		int open1 = 0;
		if(type.equalsIgnoreCase("Notice - Open"))
		{
			open1 = Integer.parseInt(performerPOM.clickNoticeOpen().getText());	//Reading Notice Open count.
		}
		else
		{
			open1 = Integer.parseInt(performerPOM.clickNoticeClosed().getText());	//Reading Notice Open count.
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
	
	static void perform1( ExtentTest test, XSSFSheet sheet, int open, int gridRecords, String type) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), 50);
		WebDriverWait wait1 = new WebDriverWait(getDriver(), 300);
		
		Thread.sleep(500);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		CFOcountPOM.clickNextPage1().sendKeys(Keys.UP);
		js.executeScript("window.scrollBy(0,-700)");
		performerPOM.clickNew().click();						//Clicking on 'New' button
		
		progress();
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
		
		performerPOM.clickCaseDate().click();					//Clicking on 'Dated' button
		OverduePOM.selectLastMonth().click();					//Clicking last month arrow.
		OverduePOM.selectDate3().click();						//Clicking particular date.
		
		Thread.sleep(300);
		performerPOM.clickFinancialYear().click();			//Clicking on 'Financial Year' drop down.
		elementsList = performerPOM.clickFinanceSearchCheckbox();
		elementsList.get(2).click();								//Clicking third option
		performerPOM.clickFinancialYear().click();			//Clicking on 'Financial Year' drop down.
		
		Thread.sleep(300);
		Row row0 = sheet.getRow(0);								//Selected 0th index row (First row)
		Cell c1 = row0.getCell(1);								//Selected cell (0 row,1 column)
		String refno = c1.getStringCellValue();
		performerPOM.clickRefNo().sendKeys(refno);			//Writing 'Court Case No'
		
		Thread.sleep(300);
		row0 = sheet.getRow(1);								//Selected 0th index row (First row)
		c1 = row0.getCell(1);								//Selected cell (0 row,1 column)
		String caseNo = c1.getStringCellValue();
		performerPOM.clickInternalCaseNo().sendKeys(caseNo);	//Writing 'Court Case No'
		
		Thread.sleep(300);
		row0 = sheet.getRow(2);								//Selected 0th index row (First row)
		c1 = row0.getCell(1);								//Selected cell (0 row,1 column)
		String title = c1.getStringCellValue();
		performerPOM.clickNoticeTitle().sendKeys(title);		//Writing 'Case Title'
		
		Thread.sleep(300);
		row0 = sheet.getRow(3);								//Selected 0th index row (First row)
		c1 = row0.getCell(1);								//Selected cell (0 row,1 column)
		int actNo = (int) c1.getNumericCellValue();
		performerPOM.clickAct().click();						//Clicking on 'Act' drop down.
		elementsList = performerPOM.chooseAct1();
		elementsList.get(actNo).click();							//Selecting particular act no
		performerPOM.clickAct().click();						//Clicking on 'Act' drop down.
		
		Thread.sleep(300);
		row0 = sheet.getRow(4);								//Selected 0th index row (First row)
		c1 = row0.getCell(1);								//Selected cell (0 row,1 column)
		String underSection = c1.getStringCellValue();
		performerPOM.clickUnderSection().sendKeys(underSection);	//Writing 'Under section'
		
		Thread.sleep(300);
		row0 = sheet.getRow(5);								//Selected 0th index row (First row)
		c1 = row0.getCell(1);								//Selected cell (0 row,1 column)
		String caseType = c1.getStringCellValue();
		performerPOM.clickCaseType().click();
		performerPOM.clickSearchCaseType().sendKeys(caseType, Keys.ENTER);	//Writing 'Case Type'
		
		Thread.sleep(500);
		progress();
		
		Thread.sleep(300);
		row0 = sheet.getRow(6);								//Selected 0th index row (First row)
		c1 = row0.getCell(1);								//Selected cell (0 row,1 column)
		int caseBudget = (int) c1.getNumericCellValue();
		performerPOM.clickCaseBudget().sendKeys(caseBudget+"");
		
		Thread.sleep(300);
		row0 = sheet.getRow(7);								//Selected 0th index row (First row)
		c1 = row0.getCell(1);								//Selected cell (0 row,1 column)
		String opponent = c1.getStringCellValue();
		performerPOM.clickOpponent().click();					//Clicking on 'Opponent'
		performerPOM.clickSearchBox().sendKeys(opponent);		//Writing 'Opponent' name
		Thread.sleep(300);
		performerPOM.clickSelectAll2().click();
		performerPOM.clickOpponent().click();
		
		Thread.sleep(300);
		row0 = sheet.getRow(8);								//Selected 0th index row (First row)
		c1 = row0.getCell(1);								//Selected cell (0 row,1 column)
		String oppoLawyer = c1.getStringCellValue();
		performerPOM.clickOppLawyer().click();				//Clicking on 'Opponent'
		performerPOM.clickSearchBox1().sendKeys(oppoLawyer);	//Writing 'Opposition Lawyer' name
		Thread.sleep(300);
		performerPOM.clickSelectAll3().click();
		performerPOM.clickOppLawyer().click();
		
		Thread.sleep(300);
		row0 = sheet.getRow(9);								//Selected 0th index row (First row)
		c1 = row0.getCell(1);								//Selected cell (0 row,1 column)
		String court = c1.getStringCellValue();
		performerPOM.clickCourt().click();
		performerPOM.clickSearchCourt().sendKeys(court, Keys.ENTER);
		
		Thread.sleep(300);
		row0 = sheet.getRow(10);							//Selected 0th index row (First row)
		c1 = row0.getCell(1);								//Selected cell (0 row,1 column)
		String judge = c1.getStringCellValue();
		performerPOM.clickJudge().sendKeys(judge);
		
		Thread.sleep(300);		
		performerPOM.clickCaseBudget().sendKeys(Keys.PAGE_DOWN);
		
		Thread.sleep(300);
		row0 = sheet.getRow(11);							//Selected 0th index row (First row)
		c1 = row0.getCell(1);								//Selected cell (0 row,1 column)
		String caseDesc = c1.getStringCellValue();
		performerPOM.clickNoticeDescription().sendKeys(caseDesc);
		
		Thread.sleep(300);
		performerPOM.clickLocation().click();					//Clicking on Location drop down
		//performerPOM.clickPlus().click();
		Thread.sleep(300);
		elementsList = performerPOM.selectLocation();
		elementsList.get(2).click();								//Selecting third visible location
		
		Thread.sleep(700);
		wait.until(ExpectedConditions.visibilityOf(performerPOM.clickCaseDate()));
		wait.until(ExpectedConditions.elementToBeClickable(performerPOM.clickCaseDate()));
		
		Thread.sleep(700);
		js.executeScript("window.scrollBy(0,600)");
		
		Thread.sleep(300);
		row0 = sheet.getRow(12);							//Selected 0th index row (First row)
		c1 = row0.getCell(1);								//Selected cell (0 row,1 column)
		String jurisdiction = c1.getStringCellValue();
		performerPOM.clickJurisdiction().click();					//Clicking on 'Jurisdiction' drop down
		Thread.sleep(600);
		performerPOM.clickSearch3().sendKeys(jurisdiction, Keys.ENTER);	//Writing 'Jurisdiction' name
		
		Thread.sleep(300);
		row0 = sheet.getRow(13);							//Selected 0th index row (First row)
		c1 = row0.getCell(1);								//Selected cell (0 row,1 column)
		String dept = c1.getStringCellValue();
		performerPOM.clickDepartment().click();					//Clicking on 'Department' drop down
		performerPOM.clickSearch4().sendKeys(dept, Keys.ENTER);	//Writing 'Department' name
		
		Thread.sleep(300);
		row0 = sheet.getRow(14);							//Selected 0th index row (First row)
		c1 = row0.getCell(1);								//Selected cell (0 row,1 column)
		String ContactDept = c1.getStringCellValue();
		performerPOM.clickContactDept().click();					//Clicking on 'Contact Person of Department' drop down
		performerPOM.clickSearch5().sendKeys(ContactDept, Keys.ENTER);	//Writing 'Contact Person' name
		
		Thread.sleep(300);
		row0 = sheet.getRow(15);							//Selected 0th index row (First row)
		c1 = row0.getCell(1);								//Selected cell (0 row,1 column)
		String owner = c1.getStringCellValue();
		performerPOM.clickOwner().click();					//Clicking on 'Owner' drop down
		performerPOM.clickSearch6().sendKeys(owner, Keys.ENTER);	//Writing 'Owner' name
		
		Thread.sleep(300);
		performerPOM.clickWinningProspect1().click();
		Thread.sleep(100);
		performerPOM.selectRisk1().click();			//Selecting 'Medium' Winning Prospect'
		
		Thread.sleep(300);
		row0 = sheet.getRow(16);					//Selected 0th index row (First row)
		c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		int claimedAmount = (int) c1.getNumericCellValue();
		performerPOM.clickClaimedAmount().sendKeys(claimedAmount+"");	//Writing 'Claimed Amount'
		
		Thread.sleep(300);
		row0 = sheet.getRow(17);					//Selected 0th index row (First row)
		c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		int probAmount = (int) c1.getNumericCellValue();
		performerPOM.clickProbableAmount().sendKeys(probAmount+"");	//Writing 'Probable Amount'
		
		Thread.sleep(300);
		row0 = sheet.getRow(18);					//Selected 0th index row (First row)
		c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		int provAmount = (int) c1.getNumericCellValue();
		performerPOM.clickProvisionalAmount().sendKeys(provAmount+"");	//Writing 'Provisional Amount'
		
		Thread.sleep(300);
		row0 = sheet.getRow(19);					//Selected 0th index row (First row)
		c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		int protestAmount = (int) c1.getNumericCellValue();
		performerPOM.clickProtestMoney().sendKeys(protestAmount+"");	//Writing 'Protest Amount'
		
		Thread.sleep(500);
		performerPOM.clickProtestMoney().sendKeys(Keys.PAGE_DOWN);
		
		Thread.sleep(500);
		performerPOM.clickPotentialImpactRadio().click();			//Clicking on 'Monetary' radio button
		
		Thread.sleep(400);
		performerPOM.clickMonetary().sendKeys("Automation123");
		
		Thread.sleep(300);
		row0 = sheet.getRow(20);					//Selected 0th index row (First row)
		c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		String state = c1.getStringCellValue();
		performerPOM.clickState().click();					//Clicking on 'Owner' drop down
		performerPOM.clickSearchState().sendKeys(state, Keys.ENTER);	//Writing 'State' name
		
		Thread.sleep(300);
		row0 = sheet.getRow(21);					//Selected 0th index row (First row)
		c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		String lawFirm = c1.getStringCellValue();
		performerPOM.clickLawFirm().click();		//Clicking on 'Law Firm' drop down.
		performerPOM.chooseLawFirm().sendKeys(lawFirm, Keys.DOWN, Keys.ENTER);	//Writing & selecting 'Law Firm' name
		
		Thread.sleep(300);
		progress();
		
		Thread.sleep(500);
		performerPOM.clickRisk().click();							//Clicking on 'Risk' drop down.
		Thread.sleep(300);
		performerPOM.selectRisk2().click();						//Selecting second option 'High' risk.
		
		Thread.sleep(300);
		row0 = sheet.getRow(22);						//Selected 0th index row (First row)
		c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		int internalUserNo = (int) c1.getNumericCellValue();
		performerPOM.clickInternalUser().click();						//Clicking on 'Internal User' drop down.
		elementsList = performerPOM.chooseInternalUser1();
		elementsList.get(internalUserNo).click();							//Selecting particular user no
		performerPOM.clickInternalUser().click();						//Clicking on 'Internal User' drop down.
		
		Thread.sleep(300);
		row0 = sheet.getRow(23);						//Selected 0th index row (First row)
		c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		int lawyerNo = (int) c1.getNumericCellValue();
		performerPOM.clickLawyer().click();						//Clicking on 'Lawyer' drop down.
		elementsList = performerPOM.chooseLawyer();
		elementsList.get(lawyerNo).click();								//Selecting particular lawyer no
		performerPOM.clickLawyer().click();						//Clicking on 'Lawyer' drop down.
		
		Thread.sleep(500);
		OverduePOM.clickSaveButton().click();						//Clicking on 'Save'button.
		
		Thread.sleep(1000);
		wait1.until(ExpectedConditions.visibilityOf(performerPOM.readMessage1()));
		
		Thread.sleep(500);
		String msg = performerPOM.readMessage1().getText();		//Reading Message appeared after save button
		int flag = 0;
		if(msg.equalsIgnoreCase("Case Created Successfully."))
		{
			test.log(LogStatus.PASS, "Message displayed = "+msg);
			flag = 1;
		}
		else
		{
			test.log(LogStatus.FAIL, "Message displayed = "+msg);
		}
		
		WebElement ele1 = null;
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
		}
		
		getDriver().switchTo().parentFrame();
		performerPOM.clickClose().click();			//Clicking on 'Close'
		
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
			test.log(LogStatus.PASS, "Total Case Count increased in grid after adding New Case.");
			test.log(LogStatus.INFO, "Old Case Count from Grid = "+gridRecords+" | New Case Count from Grid = "+count1);
		}
		else
		{
			test.log(LogStatus.FAIL, "Total Case Count doesn't increased in grid after adding New Case.");
			test.log(LogStatus.INFO, "Old Case Count from Grid = "+gridRecords+" | New Case Count from Grid = "+count1);
		}
		
		Thread.sleep(500);
		OverduePOM.clickDashboard().click();			//Clicking on 'Dashboard'
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOf(performerPOM.clickNoticeOpen()));
		int open1 = Integer.parseInt(performerPOM.clickCaseOpen().getText());	//Reading Notice Open count.
		
		if(open1 > open)
		{
			test.log(LogStatus.PASS, type+" Dashboard Count increamented. Old count = "+open+", New Count = "+open1);
		}
		else
		{
			test.log(LogStatus.FAIL, type+" Dashboard Count doesn't increamented. Old count = "+open+", New Count = "+open1);
		}
	}
	
	static void TaskAdd( ExtentTest test, XSSFSheet sheet, int open, int gridRecords, String type) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), 60);
		
		Thread.sleep(500);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		CFOcountPOM.clickNextPage1().sendKeys(Keys.UP);
		js.executeScript("window.scrollBy(0,-700)");
		performerPOM.clickAddNewTask().click();				//Clicking on 'New' button
		
		progress();
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IframeAddTask"));
		
		Thread.sleep(500);
		Row row0 = sheet.getRow(0);								//Selected 0th index row (First row)
		Cell c1 = row0.getCell(1);								//Selected cell (0 row,1 column)
		String title = c1.getStringCellValue();
		performerPOM.clickTaskTitle().sendKeys(title);	//Writing 'Task Title'
		
		Thread.sleep(300);
		row0 = sheet.getRow(1);									//Selected 0th index row (First row)
		c1 = row0.getCell(1);									//Selected cell (0 row,1 column)
		String desc = c1.getStringCellValue();
		performerPOM.clickTaskDesc().sendKeys(desc);		//Writing 'Task Description'
		
		Thread.sleep(300);
		performerPOM.clickDueDate().click();				//Clicking on 'Due Date' text box
		OverduePOM.selectNextMonth().click();
		OverduePOM.selectDate().click();					//Selecting particular date.
		
		Thread.sleep(300);
		Actions action = new Actions(getDriver());
		action.moveToElement(performerPOM.clickPriority()).click().sendKeys(Keys.DOWN,Keys.ENTER).perform();
		
		Thread.sleep(300);
		row0 = sheet.getRow(2);									//Selected 0th index row (First row)
		c1 = row0.getCell(1);									//Selected cell (0 row,1 column)
		String outcome = c1.getStringCellValue();
		performerPOM.clickExpOutcome().sendKeys(outcome);	//Writing 'Expected Outcome'
		
		Thread.sleep(300);
		row0 = sheet.getRow(3);									//Selected 0th index row (First row)
		c1 = row0.getCell(1);									//Selected cell (0 row,1 column)
		String internalUser = c1.getStringCellValue();
		performerPOM.clickInternalUser1().click();
		performerPOM.clickSearchInternalUser1().sendKeys(internalUser, Keys.ENTER);	//Selecting 'Internal User'
		
		Thread.sleep(1000);
		row0 = sheet.getRow(4);									//Selected 0th index row (First row)
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
		row0 = sheet.getRow(5);									//Selected 0th index row (First row)
		c1 = row0.getCell(1);									//Selected cell (0 row,1 column)
		String remark = c1.getStringCellValue();
		performerPOM.clickRemark().sendKeys(remark);		//Writing 'Remark'
		
		//Thread.sleep(300);
		//String workingDir = System.getProperty("user.dir");
		//performerPOM.clickUpload().sendKeys(workingDir+"//Reports//PerformerResults.html");	//Uploading file
		
		Thread.sleep(300);
		OverduePOM.clickSaveButton().click();				//Clicking on 'Save' button.
		
		Thread.sleep(300);
		wait.until(ExpectedConditions.visibilityOf(performerPOM.clickMessage()));
		
		Thread.sleep(300);
		String msg = performerPOM.clickMessage().getText();
		if(msg.contains("Task Saved Successfully."))
		{
			test.log(LogStatus.PASS, "Task Saved Successfully.");
		}
		else
		{
			test.log(LogStatus.FAIL, "Task didn't saved successfully.");
		}
		
		getDriver().switchTo().parentFrame();
		performerPOM.clickClose1().click();			//Clicking on 'Close'
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOf(performerPOM.clickExcelReport()));
		
		Thread.sleep(300);
		performerPOM.clickStatusDropDown().click();		//Clicking on 'Status drop down.
		Thread.sleep(500);
		performerPOM.selectStatusDropDown().click();		//Selecting 'Pending/Open' status
		
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
			test.log(LogStatus.PASS, "Total Task Count increased in grid after adding New Task.");
			test.log(LogStatus.INFO, "Old Task Count from Grid = "+gridRecords+" | New Task Count from Grid = "+count1);
		}
		else
		{
			test.log(LogStatus.FAIL, "Total Task Count doesn't increased in grid after adding New Task.");
			test.log(LogStatus.INFO, "Old Task Count from Grid = "+gridRecords+" | New Task Count from Grid = "+count1);
		}
		
		Thread.sleep(500);
		OverduePOM.clickDashboard().click();			//Clicking on 'Dashboard'
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOf(performerPOM.clickTaskOpen()));
		int open1 = Integer.parseInt(performerPOM.clickTaskOpen().getText());	//Reading Notice Open count.
		
		if(open1 > open)
		{
			test.log(LogStatus.PASS, type+" Dashboard Count Increased.");
			test.log(LogStatus.INFO, "Old Count = "+open+" | New Count = "+open1);
		}
		else
		{
			test.log(LogStatus.FAIL, type+" Dashboard Count doesn't increased.");
			test.log(LogStatus.INFO, "Old Count = "+open+" | New Count = "+open1);
		}
	}
	
	static int CountExcel( ExtentTest test, String type) throws InterruptedException, IOException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), 50);
		progress();
		
		wait.until(ExpectedConditions.visibilityOf(performerPOM.clickNoticeOpen()));
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
			open = Integer.parseInt(performerPOM.clickCaseOpen().getText());	//Reading Case Open count.
			performerPOM.clickCaseOpen().click();						//Clicking on 'Open' Case
		}
		else if(type.equalsIgnoreCase("Case - Closed"))
		{
			open = Integer.parseInt(performerPOM.clickCaseClosed().getText());	//Reading Case Open count.
			performerPOM.clickCaseClosed().click();						//Clicking on 'Open' Case
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
		
		Thread.sleep(500);
		progress();
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
		
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			performerPOM.clickExcelReport().sendKeys(Keys.PAGE_DOWN);
		}
		catch(Exception e)
		{
			
		}
		js.executeScript("window.scrollBy(0,700)");
		
		Thread.sleep(500);
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
		if(compliancesCount.equalsIgnoreCase("to"))
		{
			count1 = 0;
		}
		else
		{
			count1 = Integer.parseInt(compliancesCount);
		}
		
		if(open == count1)
		{
			test.log(LogStatus.PASS, type+" count matches to number of records displayed.");
			test.log(LogStatus.INFO, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
		}
		else
		{
			test.log(LogStatus.FAIL, type+" count doesn't matches to number of records displayed.");
			test.log(LogStatus.INFO, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
		}
		
		Thread.sleep(100);
		File dir = new File("C://Users//jiya//Downloads//");
		File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
		
		Thread.sleep(500);
		CFOcountPOM.clickNextPage1().sendKeys(Keys.PAGE_UP);
		Thread.sleep(250);
		performerPOM.clickExcelReport().click();					//Clicking on 'Excel Report' image.
		
		Thread.sleep(5500);
		File dir1 = new File("C://Users//jiya//Downloads//");
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
			String records = c1.getStringCellValue();
			int SheetRecords = 0;
			int flag = 0;
			try
			{
				SheetRecords = Integer.parseInt(records);
				flag = 1;
			}
			catch(Exception e)
			{
				
			}
			
			if(flag == 0)
			{
				row = sheet.getRow(no-1);
				c1 = row.getCell(0);
				records = c1.getStringCellValue();
				SheetRecords = Integer.parseInt(records);
			}
			fis.close();
			
			if(count1 == SheetRecords)
			{
				test.log(LogStatus.PASS, "No of records from grid matches to no of records in Excel Sheet.");
				test.log(LogStatus.INFO, "Total records from Grid = "+count1+" | Total records from Report = "+SheetRecords);
			}
			else
			{
				test.log(LogStatus.FAIL, "No of records from grid doesn't matches to no of records in Excel Sheet.");
				test.log(LogStatus.INFO, "Total records from Grid = "+count1+" | Total records from Excel Sheet = "+SheetRecords);
			}
		}
		else
		{
			test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
		}
		return open;
	}
	
	public static void NoticeOpen( ExtentTest test, XSSFWorkbook workbook, String login) throws InterruptedException, IOException
	{
		int sheetNo = 0;
	    if(login.equalsIgnoreCase("Performer"))
	    {
	    	sheetNo = 1;
	    }
	    else if(login.equalsIgnoreCase("Company Admin"))
	    {
	    	sheetNo = 5;
	    }
		
		int open = CountExcel( test, "Notice - Open");
		
		Thread.sleep(500);
		performerPOM.clickExcelReport().sendKeys(Keys.PAGE_DOWN);
		JavascriptExecutor js = (JavascriptExecutor) driver;
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
		
		sheet = workbook.getSheetAt(sheetNo);
		
		perform( test, sheet, open, gridRecords, "Notice - Open");
	}
	
	public static void NoticeClosed( ExtentTest test, XSSFWorkbook workbook, String login) throws InterruptedException, IOException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), 50);
		
		CountExcel( test, "Notice - Closed");
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOf(performerPOM.clickNew()));
		OverduePOM.clickDashboard().click();			//Clicking on 'Dashboard'
	}
	
	public static void CaseOpen( ExtentTest test, XSSFWorkbook workbook, String login) throws InterruptedException, IOException
	{
		int sheetNo = 0;
	    if(login.equalsIgnoreCase("Performer"))
	    {
	    	sheetNo = 2;
	    }
	    else if(login.equalsIgnoreCase("Company Admin"))
	    {
	    	sheetNo = 6;
	    }
		
		int open = CountExcel( test, "Case - Open");
		
		Thread.sleep(500);
		performerPOM.clickExcelReport().sendKeys(Keys.PAGE_DOWN);
		JavascriptExecutor js = (JavascriptExecutor) driver;
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
		
		sheet = workbook.getSheetAt(sheetNo);
		
		perform1( test, sheet, open, gridRecords, "Case - Open");
	}
	
	public static void CaseClosed( ExtentTest test, XSSFWorkbook workbook, String login) throws InterruptedException, IOException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), 50);
		
		CountExcel( test, "Case - Closed");
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOf(performerPOM.clickNew()));
		OverduePOM.clickDashboard().click();			//Clicking on 'Dashboard'
	}
	
	public static void TaskOpen( ExtentTest test, XSSFWorkbook workbook, String login) throws InterruptedException, IOException
	{
		int sheetNo = 0;
	    if(login.equalsIgnoreCase("Performer"))
	    {
	    	sheetNo = 3;
	    }
	    else if(login.equalsIgnoreCase("Company Admin"))
	    {
	    	sheetNo = 7;
	    }
	    
		int open = CountExcel( test, "Task - Open");
		
		Thread.sleep(500);
		performerPOM.clickExcelReport().sendKeys(Keys.PAGE_DOWN);
		JavascriptExecutor js = (JavascriptExecutor) driver;
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
		
		sheet = workbook.getSheetAt(sheetNo);
		
		TaskAdd( test, sheet, open, gridRecords, "Task - Open");
	}
	
	public static void TaskClosed( ExtentTest test, XSSFWorkbook workbook, String login) throws InterruptedException, IOException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), 50);
		
		CountExcel( test, "Task - Closed");
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOf(performerPOM.clickAddNewTask()));
		OverduePOM.clickDashboard().click();			//Clicking on 'Dashboard'
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
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		
		Thread.sleep(1500);
		wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
		//performerPOM.GridLoad().click();
		elementsList = performerPOM.clickAction();			//Getting all action buttons.
		js.executeScript("arguments[0].scrollIntoView();", elementsList.get(0));
		
		Thread.sleep(600);
		elementsList = performerPOM.clickAction();			//Getting all action buttons.
		elementsList.get(0).click();								//Clicking on first action button.
		
		String refNo = null;
		Thread.sleep(500);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Waiting and switching to IFrame		
		if(type.equals("Notice"))
		{
			performerPOM.clickLinkNotice().click();			//Clicking on Link Notice icon
			
			Thread.sleep(300);
			progress();
			
			Thread.sleep(300);
			wait.until(ExpectedConditions.elementToBeClickable(performerPOM.clickCheckBox()));	//Waiting for Checkbox to get visible.
			refNo = performerPOM.readRef().getText();			//Reading ref no.
			
			Thread.sleep(300);
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
		
		int flag = 0;
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
		}
		
		Thread.sleep(300);
		getDriver().switchTo().parentFrame();
		performerPOM.clickClose().click();
		
		Thread.sleep(500);
		OverduePOM.clickDashboard().click();
	}
	
	public static void CloseNoticeCase( ExtentTest test, XSSFWorkbook workbook, String type) throws InterruptedException, IOException
	{
		
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(getDriver(), 180);
		progress();
		
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
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		
		Thread.sleep(500);
		performerPOM.GridLoad().click();
		elementsList = performerPOM.clickAction();			//Getting all action buttons.
		js.executeScript("arguments[0].scrollIntoView();", elementsList.get(0));
		
		Thread.sleep(2000);
		elementsList = performerPOM.clickAction();			//Getting all action buttons.
		elementsList.get(0).click();								//Clicking on first action button.
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Waiting and switching to IFrame
		
		Thread.sleep(300);
		if(type.equals("Notice"))
		{
			sheet = workbook.getSheetAt(1);
			
			performerPOM.clickStatusPayments().click();			//Clicking on 'Status/Payments'
			
			wait.until(ExpectedConditions.visibilityOf(performerPOM.clickNoticeStatus()));
			performerPOM.clickNoticeStatus().click();				//Clicking on 'Notice Status' drop down.
			Thread.sleep(300);
			performerPOM.clickClosedStatus().click();				//Selecting 'Closed' option from drop down.
			
			Thread.sleep(300);
			wait.until(ExpectedConditions.visibilityOf(performerPOM.clickCloseDate()));
			performerPOM.clickCloseDate().click();				//Clicking on 'Closed Date' date box
			OverduePOM.selectLastMonth().click();					//Getting last month
			OverduePOM.selectDate2().click();						//Selecting particular date.
			
			Thread.sleep(300);
			performerPOM.clickNoticeResult().click();
			performerPOM.clickSelectResult().sendKeys("In Progress", Keys.ENTER);
			
			Thread.sleep(300);
			Row r1 = sheet.getRow(25);
			Cell c1 = r1.getCell(1);
			String remark = c1.getStringCellValue();
			performerPOM.clickRemark1().sendKeys(remark);
			
			Thread.sleep(300);
			r1 = sheet.getRow(26);
			c1 = r1.getCell(1);
			String CaseNo = c1.getStringCellValue();
			performerPOM.clickCourtCaseNo().sendKeys(CaseNo);
			
			Thread.sleep(300);
			performerPOM.clickSaveConvertCase().click();
		}
		else if(type.equals("Case"))
		{
			performerPOM.clickCaseStatusPayments().click();		//Clicking on 'Status/Payments'
			
			wait.until(ExpectedConditions.visibilityOf(performerPOM.clickCaseStatus()));
			
			performerPOM.clickCaseStage().click();
			Thread.sleep(300);
			performerPOM.selectCaseStage().sendKeys("Hearing", Keys.ENTER);
			
			Thread.sleep(300);
			performerPOM.clickCaseStatus().click();				//Clicking on 'Case Status' drop down.
			Thread.sleep(300);
			performerPOM.clickCaseStatusClose().click();			//Selecting 'Closed' option from drop down.
			
			Thread.sleep(300);
			wait.until(ExpectedConditions.visibilityOf(performerPOM.clickCaseCloseDate()));
			performerPOM.clickCaseCloseDate().click();				//Clicking on 'Closed Date' date box
			OverduePOM.selectLastMonth().click();					//Getting last month
			OverduePOM.selectDate2().click();						//Selecting particular date.
			
			Thread.sleep(300);
			performerPOM.clickCaseResult().click();
			performerPOM.clickSelectCaseResult().sendKeys("In Progress", Keys.ENTER);
			
			Thread.sleep(300);
			performerPOM.clickRemark1().sendKeys("Automation Testing");
			
			Thread.sleep(300);
			performerPOM.clickSave1().click();
		}
		else if(type.equals("Task"))
		{
			
		}
		
		Thread.sleep(300);
		wait.until(ExpectedConditions.visibilityOf(performerPOM.readMessage2()));
		String msg = performerPOM.readMessage2().getText();
		
		if(msg.contains("Successfully"))
		{
			test.log(LogStatus.PASS, "Message displayed - "+msg);
		}
		else if(msg.contains("already exist"))
		{
			test.log(LogStatus.FAIL, "Message displayed - "+msg);
		}
		else
		{
			test.log(LogStatus.FAIL, "Message displayed - "+msg);
		}
		
		Thread.sleep(300);
		getDriver().switchTo().parentFrame();
		
		Thread.sleep(300);
		performerPOM.clickClose().click();
		
		Thread.sleep(500);
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
				test.log(LogStatus.PASS, "Notice-Closed count increased.");
				test.log(LogStatus.INFO, "Old Count = "+closed+" | New Count = "+closed1);
				test.log(LogStatus.PASS, "Notice-Open count decreased.");
				test.log(LogStatus.INFO, "Old Count = "+open+" | New Count = "+open1);
				test.log(LogStatus.PASS, "Case-Open count increased.");
				test.log(LogStatus.INFO, "Old Count = "+caseOpen+" | New Count = "+caseOpen1);
			}
			else
			{
				test.log(LogStatus.FAIL, "Notice-Closed count doesn't increased.");
				test.log(LogStatus.INFO, "Old Count = "+closed+" | New Count = "+closed1);
				test.log(LogStatus.FAIL, "Notice-Open count doesn't decreased.");
				test.log(LogStatus.INFO, "Old Count = "+open+" | New Count = "+open1);
				test.log(LogStatus.FAIL, "Case-Open count doesn't increased.");
				test.log(LogStatus.INFO, "Old Count = "+caseOpen+" | New Count = "+caseOpen1);
			}
		}
		else if(type.equals("Case"))
		{
			open1 = Integer.parseInt(performerPOM.clickCaseOpen().getText());			//Reading Case Open count.
			closed1 = Integer.parseInt(performerPOM.clickCaseClosed().getText());		//Reading Case Closed count.
			
			if(open > open1 && closed1 > closed)
			{
				test.log(LogStatus.PASS, "Case-Closed count increased.");
				test.log(LogStatus.INFO, "Old Count = "+closed+" | New Count = "+closed1);
				test.log(LogStatus.PASS, "Case-Open count decreased.");
				test.log(LogStatus.INFO, "Old Count = "+open+" | New Count = "+open1);
			}
			else
			{
				test.log(LogStatus.FAIL, "Case-Closed count doesn't increased.");
				test.log(LogStatus.INFO, "Old Count = "+closed+" | New Count = "+closed1);
				test.log(LogStatus.FAIL, "Case-Open count doesn't decreased.");
				test.log(LogStatus.INFO, "Old Count = "+open+" | New Count = "+open1);
			}
		}
		else if(type.equals("Task"))
		{
			open1 = Integer.parseInt(performerPOM.clickTaskOpen().getText());			//Reading Task Open count.
			closed1 = Integer.parseInt(performerPOM.clickTaskClosed().getText());		//Reading Task Closed count.
			
			if(open > open1 && closed1 > closed)
			{
				test.log(LogStatus.PASS, "Task-Closed count increased.");
				test.log(LogStatus.INFO, "Old Count = "+closed+" | New Count = "+closed1);
				test.log(LogStatus.PASS, "Task-Open count decreased.");
				test.log(LogStatus.INFO, "Old Count = "+open+" | New Count = "+open1);
			}
			else
			{
				test.log(LogStatus.PASS, "Task-Closed count doesn't increased.");
				test.log(LogStatus.INFO, "Old Count = "+closed+" | New Count = "+closed1);
				test.log(LogStatus.PASS, "Task-Open count doesn't decreased.");
				test.log(LogStatus.INFO, "Old Count = "+open+" | New Count = "+open1);
			}
		}
	}
	
	static void Report( ExtentTest test, int count1, String type) throws InterruptedException, IOException
	{
		Thread.sleep(700);
		File dir = new File("C://Users//jiya//Downloads//");
		File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
		
		Thread.sleep(500);
		CFOcountPOM.clickNextPage1().sendKeys(Keys.PAGE_UP);
		Thread.sleep(300);
		performerPOM.clickExcelReport().click();					//Clicking on 'Excel Report' image.
		
		Thread.sleep(6000);
		File dir1 = new File("C://Users//jiya//Downloads//");
		File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download
		
		if(dirContents.length < allFilesNew.length)
		{
			test.log(LogStatus.PASS, "File Downloaded Successfully.");
			
			File lastModifiedFile = allFilesNew[0];			//Storing any 0th index file in 'lastModifiedFile' file name.
		    for (int i = 1; i < allFilesNew.length; i++) 	//For loop till the number of files in directory.
		    {
		       if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) 	//If allFilesNew[i] file is having large/latest time time of update then latest modified file be allFilesNew[i] file.
		       {
		           lastModifiedFile = allFilesNew[i];
		       }
		    }
			
			Thread.sleep(700);
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
				test.log(LogStatus.PASS, type+" - No of records displayed matches to no of records in Excel Sheet.");
				test.log(LogStatus.INFO, "Total records displayed = "+count1+". Total records in Excel sheet = "+SheetRecords);
			}
			else
			{
				test.log(LogStatus.FAIL, type+" - No of records displayed doesn't matches to no of records in Excel Sheet.");
				test.log(LogStatus.INFO, "Total records displayed = "+count1+". Total records in Excel sheet = "+SheetRecords);
			}
		}
		else
		{
			test.log(LogStatus.FAIL, type+" - File doesn't downloaded successfully.");
		}
	}
	
	public static void MyReports( ExtentTest test, XSSFWorkbook workbook, String login) throws InterruptedException, IOException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), 60);
		progress();
		
		wait.until(ExpectedConditions.visibilityOf(performerPOM.clickNoticeOpen()));	//Wait until 'Notice-Open' count get visible
		performerPOM.clickMyReports().click();					//Clicking on 'My Reports'
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));	//Wait until records table gets visible.
		
		//--------------------------------Notice----------------------------------
		
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		performerPOM.clickExcelReport().sendKeys(Keys.PAGE_DOWN);
		performerPOM.clickExcelReport().sendKeys(Keys.END);
		js.executeScript("arguments[0].scrollIntoView();", CFOcountPOM.readTotalItems1());
		
		Thread.sleep(1000);
		CFOcountPOM.readTotalItems1().click();
		String item = CFOcountPOM.readTotalItems1().getText();
		String[] bits = item.split(" ");								//Splitting the String
		if(bits.length < 2)
		{
			performerPOM.clickExcelReport().sendKeys(Keys.END);
			Thread.sleep(300);
			item = CFOcountPOM.readTotalItems1().getText();
			bits = item.split(" ");									//Splitting the String
		}
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		int count1 = 0;
		if(compliancesCount.equalsIgnoreCase("to"))
		{
			Thread.sleep(2500);
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
		
		Thread.sleep(500);
		Report( test, count1, "Notice");
		
		getDriver().navigate().refresh();
		
		//--------------------------------Case----------------------------------
		
		Thread.sleep(1500);
		js.executeScript("window.scrollBy(500,0)");
		
		performerPOM.clickTypeDropdown().click();					//Clicking on Type drop down box (i.e. Notice, Case, Task)
		Thread.sleep(300);
		performerPOM.selectTypeCase().click();					//Selecting 'Case' option.
		
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));	//Wait until records table gets visible.
		Thread.sleep(500);
		performerPOM.clickExcelReport().sendKeys(Keys.END);
		js.executeScript("arguments[0].scrollIntoView();", CFOcountPOM.clickNextPage1());
		js.executeScript("window.scrollBy(0,500)");
		
		Thread.sleep(1000);
		item = CFOcountPOM.readTotalItems1().getText();
		bits = item.split(" ");									//Splitting the String
		if(bits.length < 2)
		{
			performerPOM.clickExcelReport().sendKeys(Keys.END);
			Thread.sleep(300);
			item = CFOcountPOM.readTotalItems1().getText();
			bits = item.split(" ");									//Splitting the String
			
		}
		compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		count1 = 0;
		if(compliancesCount.equalsIgnoreCase("to"))
		{
			Thread.sleep(2500);
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
		
		Thread.sleep(500);
		Report(test, count1, "Case");
		
		getDriver().navigate().refresh();

		//--------------------------------Task----------------------------------
		
		Thread.sleep(1500);
		js.executeScript("window.scrollBy(500,0)");
		
		performerPOM.clickTypeDropdown().click();					//Clicking on Type drop down box (i.e. Notice, Case, Task)
		Thread.sleep(300);
		performerPOM.selectTypeTask().click();					//Selecting 'Task' option.
		
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));	//Wait until records table gets visible.
		Thread.sleep(500);
		performerPOM.clickExcelReport().sendKeys(Keys.END);
		js.executeScript("arguments[0].scrollIntoView();", CFOcountPOM.readTotalItems1());
		
		Thread.sleep(1000);
		item = CFOcountPOM.readTotalItems1().getText();
		bits = item.split(" ");								//Splitting the String
		if(bits.length < 2)
		{
			performerPOM.clickExcelReport().sendKeys(Keys.END);
			Thread.sleep(300);
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
		
		Thread.sleep(500);
		Report( test, count1, "Task");
		
		Thread.sleep(500);
		OverduePOM.clickDashboard().click();				//Clicking on 'My Dashboard'
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
		
		Thread.sleep(2000);
		performerPOM.clickReminderText().sendKeys("Auomation Testing reminder message2.");
		
		Thread.sleep(300);
		performerPOM.clickDescription().sendKeys("Automation reminder description2.");
		
		Thread.sleep(300);
		performerPOM.clickRemark2().sendKeys("Automation reminder remark2.");
		
		Thread.sleep(300);
		performerPOM.clickDate().click();
		Thread.sleep(300);
		OverduePOM.selectNextMonth().click();
		OverduePOM.selectDate().click();
		
		Thread.sleep(300);
		performerPOM.clickSave().click();				//Clicking on Save button.
		
		Thread.sleep(500);
		try
		{
			wait.until(ExpectedConditions.visibilityOf(performerPOM.readMsg1()));
		}
		catch(Exception e)
		{
			wait.until(ExpectedConditions.visibilityOf(performerPOM.readMsg1()));
		}
		Thread.sleep(300);
		String msg = performerPOM.readMsg1().getText();
		if(msg.contains("Successfully"))
		{
			test.log(LogStatus.PASS, type+" Message Displayed - "+msg);
		}
		else if(msg.contains("already exists"))
		{
			test.log(LogStatus.PASS, type+" Message Displayed - "+msg);
		}
		else
		{
			test.log(LogStatus.FAIL, type+" Message Displayed - "+msg);
		}
		
		Thread.sleep(300);
		getDriver().switchTo().parentFrame();
		
		Thread.sleep(300);
		performerPOM.clickCloseReminder().click();
	}
	
	public static void MyReminder( ExtentTest test, XSSFWorkbook workbook) throws InterruptedException, IOException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), 180);
		progress();
		
		wait.until(ExpectedConditions.visibilityOf(performerPOM.clickNoticeOpen()));	//Wait until 'Notice-Open' count get visible
		performerPOM.clickMyReminder().click();					//Clicking on 'My Reports'
		
		wait.until(ExpectedConditions.visibilityOf(performerPOM.CheckRecordsTable()));	//Wait until records table gets visible.
		
		NewReminder( test, "Case");
		
		NewReminder( test, "Notice");
		
		NewReminder(test, "Task");
		
		Thread.sleep(300);
		OverduePOM.clickDashboard().click();
	}
	
	public static void Masters( ExtentTest test, XSSFWorkbook workbook) throws InterruptedException, IOException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), 180);
		progress();
		
		wait.until(ExpectedConditions.visibilityOf(performerPOM.clickNoticeOpen()));	//Wait until 'Notice-Open' count get visible
		performerPOM.clickMasters().click();
		
		Thread.sleep(300);
		performerPOM.clickMastersMenu().click();
		
		Thread.sleep(300);
		wait.until(ExpectedConditions.visibilityOf(performerPOM.clickAddNew2()));
		performerPOM.clickAddNew2().click();
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_IframeCaseType"));
		
		Thread.sleep(300);
		performerPOM.clickCaseNoticeType().sendKeys("New Admin2");
		
		Thread.sleep(300);
		performerPOM.clickSave().click();				//Clicking on Save button.
		
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(performerPOM.readMesg()));
		String msg = performerPOM.readMesg().getText();
		if(msg.contains("Successfully"))
		{
			test.log(LogStatus.PASS, " Message Displayed - "+msg);
		}
		else
		{
			test.log(LogStatus.FAIL, " Message Displayed - "+msg);
		}
		
		Thread.sleep(300);
		getDriver().switchTo().parentFrame();
		
		Thread.sleep(300);
		performerPOM.clickClose2().click();
		
		Thread.sleep(300);
		OverduePOM.clickDashboard().click();
	}
}
