package contract;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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

import litigationAdditionalOwner.performerPOM;
import login.BasePage;

public class MethodsPOM extends BasePage
{
	private static List<WebElement> elementsList = null;
	private static List<WebElement> elementsList1 = null;
	
	public static FileInputStream fis = null;	//File input stream variable
	public static XSSFWorkbook wb = null;	//Excel sheet workbook variable
	public static XSSFSheet sheet = null;		//Sheet variable
	public static XSSFSheet sheet1 = null;		//Sheet variable
	
	static void progress()
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		try
		{
			Thread.sleep(500);
			wait.until(ExpectedConditions.invisibilityOf(ContractPOM.checkProgress()));
			Thread.sleep(500);
		}
		catch(Exception e)
		{
			
		}
	}
	
	public static void DraftCount( ExtentTest test, XSSFWorkbook workbook) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		wait.until(ExpectedConditions.visibilityOf(ContractPOM.clickDraft()));
		
		Thread.sleep(300);
		int draft = Integer.parseInt(ContractPOM.clickDraft().getText());
		ContractPOM.clickDraft().click();
		
		wait.until(ExpectedConditions.visibilityOf(ContractPOM.clickAddNew()));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		
		Thread.sleep(300);
		int total = Integer.parseInt(ContractPOM.readTotalRecords().getText());
		js.executeScript("window.scrollBy(0,-1000)");
		
		if(draft == total)
		{
			test.log(LogStatus.PASS, "Dashboard count matches to total number of records displayed. Total records = "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "Dashboard count doesn't matches to total number of records displayed. Dashboard count ="+ draft+", Total records = "+total);
		}
		
		Thread.sleep(300);
		ContractPOM.clickAddNew().click();
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
		
		String workingDir = System.getProperty("user.dir");
		fis = new FileInputStream(workingDir+"//TestData//Contract.xlsx");
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheetAt(1);					//Retrieving second sheet of Workbook
		
		Row row0 = sheet.getRow(0);						//Selected 0th index row (First row)
		Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		String ContractNumber = c1.getStringCellValue();	//Getting Contract Number from sheet.
		ContractPOM.clickContractNumber().sendKeys(ContractNumber);
		
		row0 = sheet.getRow(1);						//Selected 0th index row (First row)
		c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		String ContractTitle = c1.getStringCellValue();	//Getting Contract Title from sheet.
		ContractPOM.clickContractTitle().sendKeys(ContractTitle);
		
		row0 = sheet.getRow(2);						//Selected 0th index row (First row)
		c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		String Description = c1.getStringCellValue();	//Getting Contract Description from sheet.
		ContractPOM.clickDescription().sendKeys(Description);
		
		ContractPOM.clickEntityLocation().click();	//Clicking on Entity/Branch/Location text box
		Thread.sleep(300);
		ContractPOM.selectLocation().click();		//Selecting first location (ABC Mall Thane)
		
		Thread.sleep(300);
		ContractPOM.clickVendor().click();		//Clicking on Vendor
		Thread.sleep(300);
		ContractPOM.clickVendor().sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
		ContractPOM.clickVendor().click();		//Clicking on Vendor
		
		Thread.sleep(300);
		ContractPOM.clickDepartment().click();	//Clicking on Department drop down
		Thread.sleep(300);
		action.keyDown(Keys.CONTROL).sendKeys(Keys.ARROW_DOWN, Keys.ENTER).keyUp(Keys.CONTROL).perform();
		
		Thread.sleep(300);
		ContractPOM.clickContactPerson().click();	//Clicking on Contact Person of Department drop down
		Thread.sleep(300);
		action.keyDown(Keys.CONTROL).sendKeys(Keys.ARROW_DOWN, Keys.ENTER).keyUp(Keys.CONTROL).perform();
		
		Thread.sleep(300);
		ContractPOM.clickProposalDate().click();	//Clicking on Proposal Date
		ContractPOM.selectLastMonth().click();	//Clicking on Last Month arrow
		Thread.sleep(300);
		ContractPOM.selectDate().click();			//Selecting particular date
		
		Thread.sleep(300);
		ContractPOM.clickAgreementDate().click();	//Clicking on Agreement Date
		ContractPOM.selectLastMonth().click();	//Clicking on Last Month arrow
		Thread.sleep(300);
		ContractPOM.selectDate().click();			//Selecting particular date
		
		Thread.sleep(300);
		ContractPOM.clickStartDate().click();		//Clicking on Start Date
		ContractPOM.selectLastMonth().click();	//Clicking on Last Month arrow
		Thread.sleep(300);
		ContractPOM.selectDate().click();			//Selecting particular date
		
		Thread.sleep(300);
		ContractPOM.clickReviewDate().click();	//Clicking on Review Date
		ContractPOM.selectLastMonth().click();	//Clicking on Last Month arrow
		Thread.sleep(300);
		ContractPOM.selectDate().click();			//Selecting particular date
		
		Thread.sleep(300);
		ContractPOM.clickEndDate().click();		//Clicking on End Date
		ContractPOM.selectNextMonth().click();	//Clicking on Last Month arrow
		Thread.sleep(300);
		ContractPOM.selectDate().click();			//Selecting particular date
		
		Thread.sleep(300);
		row0 = sheet.getRow(3);						//Selected 0th index row (First row)
		c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		String NoticeTerm = Integer.toString((int) c1.getNumericCellValue());	//Getting Notice Term value from sheet.
		ContractPOM.clickNoticeTerm().sendKeys(NoticeTerm);
		
		Thread.sleep(300);
		ContractPOM.clickNoticeTermPeriod().click();	//Clicking on Notice Term drop down.
		ContractPOM.clickNoticeTermPeriod().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);	//Selecting 'Week' from drop down.
		
		Thread.sleep(300);
		js.executeScript("window.scrollBy(0,500)");
		
		ContractPOM.clickContractType().click();		//Clicking on Contract Type drop down.
		action.keyDown(Keys.CONTROL).sendKeys(Keys.ARROW_DOWN, Keys.ENTER).keyUp(Keys.CONTROL).perform();	//Selecting second option Conditional Contract
		
		Thread.sleep(1500);
		wait.until(ExpectedConditions.elementToBeClickable(ContractPOM.clickContractSubType()));
		action.moveToElement(ContractPOM.clickContractSubType()).click().perform();
		action.keyDown(Keys.CONTROL).sendKeys(Keys.ENTER).keyUp(Keys.CONTROL).perform();	//Selecting first - already selecting option.
		
		Thread.sleep(500);
		ContractPOM.clickContractOwner().click();		//Clicking on Contract Owner
		Thread.sleep(300);
		ContractPOM.clickContractOwner().sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
		ContractPOM.clickContractOwner().click();		//Clicking on Contract Owner
		
		Thread.sleep(300);
		row0 = sheet.getRow(3);						//Selected 0th index row (First row)
		c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		String ContractAmount = Integer.toString((int) c1.getNumericCellValue());	//Getting Contract Amount/Value from sheet.
		ContractPOM.clickContractAmount().sendKeys(ContractAmount);
		
		Thread.sleep(300);
		ContractPOM.clickPaymentType().click();		//Clicking on Payment Type drop down
		Thread.sleep(300);
		action.keyDown(Keys.CONTROL).sendKeys(Keys.ARROW_DOWN, Keys.ENTER).keyUp(Keys.CONTROL).perform();
		
		Thread.sleep(300);
		js.executeScript("window.scrollBy(0,500)");
		workbook.close();
		
		Thread.sleep(300);
		ContractPOM.clickSave().click();		//Clicking on Save button.
		
		wait.until(ExpectedConditions.visibilityOf(ContractPOM.readMessage()));
		String msg = ContractPOM.readMessage().getText();
		
		if(msg.contains("Successfully"))
		{
			test.log(LogStatus.PASS, "Message displayed = "+msg);
		}
		else
		{
			test.log(LogStatus.FAIL, "Message displayed = "+msg);
		}
		
		Thread.sleep(300);
		getDriver().switchTo().parentFrame();
		ContractPOM.clickClose().click();
		
		Thread.sleep(500);
		js.executeScript("window.scrollBy(0,1000)");
		
		Thread.sleep(300);
		int totalNew = Integer.parseInt(ContractPOM.readTotalRecords().getText());
		
		if(totalNew > total)
		{
			test.log(LogStatus.PASS, "Records count in grid have been increased. Old count = "+total+", New count = "+totalNew);
		}
		else
		{
			test.log(LogStatus.FAIL, "Records count in grid have not been increased. Old count = "+total+", New count = "+totalNew);
		}
		
		Thread.sleep(300);
		ContractPOM.clickDashboard().click();
		
		wait.until(ExpectedConditions.visibilityOf(ContractPOM.clickDraft()));
		
		Thread.sleep(300);
		int draftNew = Integer.parseInt(ContractPOM.clickDraft().getText());
		
		if(draftNew > draft)
		{
			test.log(LogStatus.PASS, "Dashboard count of 'Draft' have been increased. Old count = "+draft+", New count = "+draftNew);
		}
		else
		{
			test.log(LogStatus.FAIL, "Dashboard count of 'Draft' have not been increased. Old count = "+draft+", New count = "+draftNew);
		}
	}
	
	public static void PendingReviewApprovalCount( ExtentTest test, XSSFWorkbook workbook, String type) throws InterruptedException, IOException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		wait.until(ExpectedConditions.visibilityOf(ContractPOM.clickPendingForReview()));
		
		Thread.sleep(300);
		int pending = 0;
		if(type.equalsIgnoreCase("Pending Approval"))
		{
			pending = Integer.parseInt(ContractPOM.clickPendingApproval().getText());
			ContractPOM.clickPendingApproval().click();				//Clicked on "Pending Approval" count
		}
		else
		{
			pending = Integer.parseInt(ContractPOM.clickPendingForReview().getText());
			ContractPOM.clickPendingForReview().click();				//Clicked on "Pending Review" count
		}
		
		wait.until(ExpectedConditions.visibilityOf(ContractPOM.clickAddNew()));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		
		Thread.sleep(300);
		int total = Integer.parseInt(ContractPOM.readTotalRecords().getText());	//Reading total "Pending Review" records
		js.executeScript("window.scrollBy(0,-1000)");
		
		if(pending == total)
		{
			test.log(LogStatus.PASS, "Dashboard '"+type+"' count matches to total number of records displayed. Total '"+type+"' records = "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "Dashboard '"+type+"' count doesn't matches to total number of records displayed.");
			test.log(LogStatus.INFO, "Dashboard count ="+ pending+", Total records = "+total);
		}
		
		Thread.sleep(300);
		ContractPOM.clickDashboard().click();
		
		wait.until(ExpectedConditions.visibilityOf(ContractPOM.clickDraft()));
		ContractPOM.clickDraft().click();
		
		wait.until(ExpectedConditions.visibilityOf(ContractPOM.clickAddNew()));
		String title = ContractPOM.readContractName().getText()+" Test1";
		String Description = ContractPOM.readContractName().getText()+" Description";
		js.executeScript("window.scrollBy(0,1000)");
		
		Thread.sleep(300);
		int totalDraft = Integer.parseInt(ContractPOM.readTotalRecords().getText());	//Reading total "Pending Review" records
		
		Thread.sleep(300);
		js.executeScript("window.scrollBy(0,-1000)");
		ContractPOM.clickEditDraft().click();			//Clicking on first draft's edit button.
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
		ContractPOM.clickTasks().click();
		
		wait.until(ExpectedConditions.visibilityOf(ContractPOM.clickAddNewTask()));
		ContractPOM.clickAddNewTask().click();
		
		progress();
		
		wait.until(ExpectedConditions.visibilityOf(ContractPOM.clickTaskTitle()));
		if(type.equalsIgnoreCase("Pending Approval"))
		{
			ContractPOM.clickApproveRadio().click();				//Clicked on "Approve" radio button
		}
		else
		{
			ContractPOM.clickReviewRadioButton().click();			//Clicked on "Review" radio button
		}
		
		Thread.sleep(300);
		ContractPOM.clickTaskTitle().sendKeys(title);
		
		Thread.sleep(300);
		ContractPOM.clickTaskDescription().sendKeys(Description);
		
		Thread.sleep(300);
		ContractPOM.clickTaskDueDate().click();
		Thread.sleep(300);
		ContractPOM.selectNextMonth().click();
		Thread.sleep(300);
		ContractPOM.selectDate().click();
		
		Thread.sleep(300);
		ContractPOM.clickAssignTo().click();
		Thread.sleep(500);
		ContractPOM.clickSearchBox().sendKeys("Company Admin");
		Thread.sleep(300);
		ContractPOM.clickAssignTo().click();
		Thread.sleep(300);
		ContractPOM.clickAssignTo().click();
		Thread.sleep(300);
		Actions action = new Actions(getDriver());
		action.keyDown(Keys.CONTROL).sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER).keyUp(Keys.CONTROL).perform();
		
		Thread.sleep(500);
		int flag = 1;
		try
		{
			WebElement ele = ContractPOM.checkDownload();
			System.out.println("Element - "+ele);
			if(ele.equals(null))
			{
				flag = 0;
			}
		}
		catch(Exception e)
		{
			
		}
		
		if(flag == 0) //(flag == 0) Temporarily disabled.
		{
			Thread.sleep(300);
			ContractPOM.clickAddDocument().click();
			
			progress();
			
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IframeAddDocuments"));
			
			Thread.sleep(300);
			ContractPOM.clickDocumentType().click();
			action.keyDown(Keys.CONTROL).sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER).keyUp(Keys.CONTROL).perform();
			
			Thread.sleep(300);
			String workingDir = System.getProperty("user.dir");
			ContractPOM.clickChooseFile().sendKeys(workingDir+"//Reports//PerformerResults.html");
			
			Thread.sleep(300);
			ContractPOM.clickUpload().click();
			
			Thread.sleep(300);
			wait.until(ExpectedConditions.visibilityOf(ContractPOM.readMessage1()));
			
			Thread.sleep(300);
			ContractPOM.clickClose1().click();
			getDriver().switchTo().parentFrame();
			
			Thread.sleep(300);
			progress();
			
			Thread.sleep(300);
			ContractPOM.clickSelectAll().click();			
		}
		
		ContractPOM.clickCreatAndAssign().click();
		
		Thread.sleep(300);
		progress();
		
		String msg = ContractPOM.readMessage2().getText();
		if(msg.contains("Task Saved Successfully."))
		{
			test.log(LogStatus.PASS, "Task Saved Successfully.");
		}
		else
		{
			test.log(LogStatus.FAIL, msg);
		}
		
		Thread.sleep(300);
		getDriver().switchTo().parentFrame();
		ContractPOM.clickClose().click();
		
		Thread.sleep(500);
		js.executeScript("window.scrollBy(0,1000)");
		
		Thread.sleep(300);
		int totalDraftNew = Integer.parseInt(ContractPOM.readTotalRecords().getText());
		
		if(totalDraftNew < totalDraft)
		{
			test.log(LogStatus.PASS, "Records count in Draft grid have been decreased.");
			test.log(LogStatus.INFO, "Old count = "+totalDraft+" | New count = "+totalDraftNew);
		}
		else
		{
			test.log(LogStatus.FAIL, "Records count in Draft grid doesn't decreased.");
			test.log(LogStatus.INFO, "Old count = "+totalDraft+" | New count = "+totalDraftNew);
		}
		
		Thread.sleep(500);
		ContractPOM.clickDashboard().click();
		
		wait.until(ExpectedConditions.visibilityOf(ContractPOM.clickDraft()));
		
		Thread.sleep(300);
		int pendingNew = 0;
		if(type.equalsIgnoreCase("Pending Approval"))
		{
			pendingNew = Integer.parseInt(ContractPOM.clickPendingApproval().getText());
		}
		else
		{
			pendingNew = Integer.parseInt(ContractPOM.clickPendingForReview().getText());
		}
		
		if(pendingNew > pending)
		{
			test.log(LogStatus.PASS, "Dashboard count of '"+type+"' have been increased.");
			test.log(LogStatus.INFO, "Old Count = "+pending+" | New Count = "+pendingNew);
		}
		else
		{
			test.log(LogStatus.FAIL, "Dashboard count of '"+type+"' doesn't increased.");
			test.log(LogStatus.INFO, "Old Count = "+pending+" | New Count = "+pendingNew);
		}
	}
	
	public static void ReviewedApprovedCount( ExtentTest test, XSSFWorkbook workbook, String type) throws InterruptedException, IOException
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		wait.until(ExpectedConditions.visibilityOf(ContractPOM.clickReviewed()));
		
		Thread.sleep(300);
		int reviewed = Integer.parseInt(ContractPOM.clickReviewed().getText());
		int pendingReview = Integer.parseInt(ContractPOM.clickPendingForReview().getText());
		int approved = Integer.parseInt(ContractPOM.clickApproved().getText());
		int pendingApprove = Integer.parseInt(ContractPOM.clickPendingApprove().getText());
		
		Thread.sleep(500);
		performerPOM.clickMyWorkspace().click();
		
		Thread.sleep(300);
		ContractPOM.clickTaskMenu().click();
		
		wait.until(ExpectedConditions.visibilityOf(ContractPOM.clickStatus()));
		
		ContractPOM.clickStatus().click();
		Thread.sleep(300);
		Actions action = new Actions(getDriver());
		if(type.equals("Reviewed"))
		{
			action.keyDown(Keys.SHIFT).sendKeys("Submitted for Review", Keys.ENTER).keyUp(Keys.SHIFT).perform();
		}
		else
		{
			action.keyDown(Keys.SHIFT).sendKeys("Submitted for Approval", Keys.ENTER).keyUp(Keys.SHIFT).perform();
		}
		
		Thread.sleep(300);
		ContractPOM.clickAllTask().click();				//Clicking on 'All Tasks' drop down.
		Thread.sleep(300);
		action.keyDown(Keys.SHIFT).sendKeys(Keys.ARROW_DOWN, Keys.ENTER).keyUp(Keys.SHIFT).perform();	//Selecting 'My Tasks'
		
		Thread.sleep(300);
		ContractPOM.clickApply().click();
		
		int flag = 0;
		try
		{
			Thread.sleep(500);
			elementsList = ContractPOM.readAssignedTo();
			for(int i = 0; i < elementsList.size(); i++)
			{
				String name = elementsList.get(i).getText();
				if(name.contains("company admin"))
				{
					elementsList1 = ContractPOM.clickAction();
					elementsList1.get(i).click();
					flag = 1;
					break;
				}
			}
		}
		catch(Exception e)
		{
			
		}
		
		if(flag == 1)
		{
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
			
			Thread.sleep(300);
			js.executeScript("window.scrollBy(0,1000)");		
			
			ContractPOM.clickStatus1().click();
			Thread.sleep(300);
			action.keyDown(Keys.SHIFT).sendKeys(Keys.ARROW_DOWN, Keys.ENTER).keyUp(Keys.SHIFT).perform();
			
			Thread.sleep(300);
			ContractPOM.clickComment().sendKeys("Automation Testing");
			
			Thread.sleep(300);
			String workingDir = System.getProperty("user.dir");
			ContractPOM.clickChooseFile1().sendKeys(workingDir+"//Reports//PerformerResults.html");
			
			Thread.sleep(300);
			ContractPOM.clickSave().click();
			
			Thread.sleep(700);
			js.executeScript("window.scrollBy(0,-1000)");
			wait.until(ExpectedConditions.visibilityOf(ContractPOM.readMsg()));
			
			String msg = ContractPOM.readMsg().getText();
			if(msg.contains("Successfully"))
			{
				test.log(LogStatus.PASS, "Message displayed = "+msg);
			}
			else
			{
				test.log(LogStatus.FAIL, "Message displayed = "+msg);
			}
			
			Thread.sleep(300);
			getDriver().switchTo().parentFrame();
			
			ContractPOM.clickClose2().click();
			
			Thread.sleep(500);
			ContractPOM.clickDashboard().click();
			
			wait.until(ExpectedConditions.visibilityOf(ContractPOM.clickDraft()));
			
			Thread.sleep(300);			
			if(type.equals("Reviewed"))
			{
				int reviewedNew = Integer.parseInt(ContractPOM.clickReviewed().getText());
				int pendingReviewNew = Integer.parseInt(ContractPOM.clickPendingForReview().getText());
				if(reviewedNew > reviewed && pendingReview > pendingReviewNew)
				{
					test.log(LogStatus.PASS, "Dashboard count of 'Reviewed' increased.");
					test.log(LogStatus.INFO, "Old Count = "+reviewed+" | New Count = "+reviewedNew);
					test.log(LogStatus.PASS, "Dashboard count of 'Pending For Review' decreased.");
					test.log(LogStatus.INFO, "Old Count = "+pendingReview+" | New Count = "+pendingReviewNew);
				}
				else
				{
					test.log(LogStatus.FAIL, "Dashboard count of 'Reviewed' doesn't increased.");
					test.log(LogStatus.INFO, "Old Count = "+reviewed+" | New Count = "+reviewedNew);
					test.log(LogStatus.FAIL, "Dashboard count of 'Pending For Review' doesn't decreased.");
					test.log(LogStatus.INFO, "Old Count = "+pendingReview+" | New Count = "+pendingReviewNew);
				}
			}
			else
			{
				int approvedNew = Integer.parseInt(ContractPOM.clickApproved().getText());
				int pendingApproveNew = Integer.parseInt(ContractPOM.clickPendingApprove().getText());
				if(approvedNew > approved && pendingApprove > pendingApproveNew)
				{
					test.log(LogStatus.PASS, "Dashboard count of 'Approved' increased.");
					test.log(LogStatus.INFO, "Old Count = "+approved+" | New Count = "+approvedNew);
					test.log(LogStatus.PASS, "Dashboard count of 'Pending Approval' decreased.");
					test.log(LogStatus.INFO, "Old Count = "+pendingApprove+" | New Count = "+pendingApproveNew);
				}
				else
				{
					test.log(LogStatus.FAIL, "Dashboard count of 'Approved' doesn't increased.");
					test.log(LogStatus.INFO, "Old Count = "+approved+" | New Count = "+approvedNew);
					test.log(LogStatus.FAIL, "Dashboard count of 'Pending Approval' doesn't decreased.");
					test.log(LogStatus.INFO, "Old Count = "+pendingApprove+" | New Count = "+pendingApproveNew);
				}
			}
		}
		else
		{
			test.log(LogStatus.SKIP, "No 'Contract - Task' found which is assigned to Company Admin.");
			ContractPOM.clickDashboard().click();
		}
	}
	
	public static void ExpiredCount( ExtentTest test, XSSFWorkbook workbook) throws InterruptedException, IOException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), 50);
		wait.until(ExpectedConditions.visibilityOf(ContractPOM.clickDraft()));
		
		Thread.sleep(300);
		int expired = Integer.parseInt(ContractPOM.clickExpired().getText());
		ContractPOM.clickExpired().click();
		
		wait.until(ExpectedConditions.visibilityOf(ContractPOM.clickAddNew()));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		
		Thread.sleep(300);
		int total = Integer.parseInt(ContractPOM.readTotalRecords().getText());
		js.executeScript("window.scrollBy(0,-1000)");
		
		if(expired == total)
		{
			test.log(LogStatus.PASS, "Dashboard 'Expired' count matches to the total number of records displayed in grid.");
			test.log(LogStatus.INFO, "Dashboard 'Expired' count = "+expired+" | Total records in grid = "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "Dashboard 'Expired' count doesn't matches to the total number of records displayed in grid.");
			test.log(LogStatus.INFO, "Dashboard 'Expired' count = "+expired+" | Total records in grid = "+total);
		}
		
		Thread.sleep(500);
		ContractPOM.clickStatusDropDown().click();		//Clicking on 'Select Status' drop down.
		Thread.sleep(300);
		ContractPOM.selectRenewed().click();				//Clicking on 'Renewed' option.
		Thread.sleep(500);
		ContractPOM.clickApply().click();					//Clicking on 'Apply' button.
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOf(ContractPOM.clickAction1()));	//Waiting till the 'Action' button gets visible.
		
		Thread.sleep(700);
		js.executeScript("window.scrollBy(0,1000)");
		int totalRenewed = Integer.parseInt(ContractPOM.readTotalRecords().getText());	//Read the total 'Renewed' contracts.
		
		Thread.sleep(500);
		js.executeScript("window.scrollBy(0,-1000)");
		Thread.sleep(500);
		ContractPOM.clickStatusDropDown().click();		//Clicking on 'Select Status' drop down.
		Thread.sleep(300);
		ContractPOM.selectExpired().click();				//Clicking on 'Expired' option.
		
		Thread.sleep(500);
		ContractPOM.clickAllContractDropDown().click();	//Clicking on 'All Contract' drop down.
		Thread.sleep(400);
		ContractPOM.selectAssignedToReview().click();		//Selecting 'Assigned To Review'.
		Thread.sleep(400);
		
		ContractPOM.clickApply().click();					//Clicking on 'Apply' button.
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOf(ContractPOM.clickAction1()));	//Waiting till the 'Action' button gets visible.
		
		Thread.sleep(500);
		ContractPOM.clickAction1().click();				//Clicking on first action button.
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
		wait.until(ExpectedConditions.visibilityOf(ContractPOM.clickEditContract()));
		
		Thread.sleep(500);
		ContractPOM.clickEditContract().click();
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(ContractPOM.clickContractStatus()));
		
		ContractPOM.clickContractStatus().click();		//Clicking on 'Contract Status' drop down
		Thread.sleep(300);
		ContractPOM.selectRenewedStatus().click();		//Selecting 'Expired' status
		
		Thread.sleep(500);
		ContractPOM.clickYes().click();					//Clicking on 'Yes' button 
		
		Thread.sleep(500);
		String title = ContractPOM.clickContractTitle().getAttribute("value");
		ContractPOM.clickContractTitle().clear();
		ContractPOM.clickContractTitle().sendKeys(title+" - Renewed");
		
		Thread.sleep(500);
		ContractPOM.clickDescription().sendKeys(" - Renewed");
		
		Thread.sleep(500);
		js.executeScript("window.scrollBy(0,500)");
		
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");		//Setting format of date which we want the date into.
		DateFormat date1 = new SimpleDateFormat("dd");
		DateFormat month1 = new SimpleDateFormat("MM");
		DateFormat year1 = new SimpleDateFormat("yyyy");
		Date date = new Date();							//Getting current date.
		
		String StartDate= dateFormat.format(date); 		//Getting whole date as "23-07-2021" from current date
		String Date = date1.format(date);				//Getting day only  as "23" from current date
		String Month = month1.format(date);				//Getting month only  as "07" from current date
		String Year = year1.format(date);				//Getting year only  as "2021" from current date
		
		int year = Integer.parseInt(Year);
		int newYear = year + 2;							//Increasing year by 2.
		String EndDate = Date+"-"+Month+"-"+newYear;
		
		Thread.sleep(500);
		ContractPOM.clickStartDate().clear();					//Clearing Start Date field.
		ContractPOM.clickStartDate().sendKeys(StartDate);		//Providing Start Date
		Thread.sleep(400);
		ContractPOM.clickStartDate().sendKeys(Keys.ENTER);
		
		Thread.sleep(500);
		ContractPOM.clickEndDate().clear();					//Clearing End Date field.
		ContractPOM.clickEndDate().sendKeys(EndDate);			//Providing End Date
		Thread.sleep(400);
		ContractPOM.clickEndDate().sendKeys(Keys.TAB);
		
		Thread.sleep(300);
		js.executeScript("arguments[0].scrollIntoView(true);", ContractPOM.clickUpdate());
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(300);
		ContractPOM.clickUpdate().click();						//Clicking on Update button.
		
		Thread.sleep(500);
		js.executeScript("window.scrollBy(0,-1000)");
		wait.until(ExpectedConditions.visibilityOf(ContractPOM.readMessage()));
		String msg = ContractPOM.readMessage().getText();
		
		if(msg.contains("Successfully"))
		{
			test.log(LogStatus.PASS, "Message displayed = "+msg);
		}
		else
		{
			test.log(LogStatus.FAIL, "Message displayed = "+msg);
		}
		
		Thread.sleep(300);
		getDriver().switchTo().parentFrame();
		ContractPOM.clickClose().click();
		
		Thread.sleep(800);
		ContractPOM.clickAllContractDropDown().click();	//Clicking on 'All Contract' drop down.
		Thread.sleep(400);
		ContractPOM.selectAllContract().click();		//Selecting 'Assigned To Review'.
		Thread.sleep(400);
		ContractPOM.clickApply().click();					//Clicking on 'Apply' button.
		Thread.sleep(800);
		
		js.executeScript("window.scrollBy(0,1000)");
		
		Thread.sleep(300);
		int totalNew = Integer.parseInt(ContractPOM.readTotalRecords().getText());
		if(totalNew < total)
		{
			test.log(LogStatus.PASS, "The total number of 'Expired' Contracts in grid is decreased.");
			test.log(LogStatus.INFO, "Old 'Expired' Contracts count = "+total+" | New 'Expired' Contracts count = "+totalNew);
		}
		else
		{
			test.log(LogStatus.FAIL, "The total number of 'Expired' Contracts in grid doesn't decreased.");
			test.log(LogStatus.INFO, "Old 'Expired' Contracts count = "+total+" | New 'Expired' Contracts count = "+totalNew);
		}
		
		Thread.sleep(500);
		js.executeScript("window.scrollBy(0,-1000)");
		Thread.sleep(500);
		ContractPOM.clickStatusDropDown().click();		//Clicking on 'Select Status' drop down.
		Thread.sleep(300);
		ContractPOM.selectRenewed().click();				//Clicking on 'Renewed' option.
		Thread.sleep(500);
		ContractPOM.clickApply().click();					//Clicking on 'Apply' button.
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOf(ContractPOM.clickAction1()));	//Waiting till the 'Action' button gets visible.
		
		Thread.sleep(700);
		js.executeScript("window.scrollBy(0,1000)");
		int totalRenewedNew = Integer.parseInt(ContractPOM.readTotalRecords().getText());
		
		if(totalRenewedNew > totalRenewed)
		{
			test.log(LogStatus.PASS, "The total number of 'Renewed' Contracts from grid is increased.");
			test.log(LogStatus.INFO, "Old 'Renewed' Contracts count from grid = "+totalRenewed+" | New 'Renewed' Contracts count from grid = "+totalRenewedNew);
		}
		else
		{
			test.log(LogStatus.FAIL, "The total number of 'Renewed' Contracts from grid doesn't increased.");
			test.log(LogStatus.INFO, "Old 'Renewed' Contracts count from grid = "+totalRenewed+" | New 'Renewed' Contracts count from grid = "+totalRenewedNew);
		}
		
		Thread.sleep(500);
		ContractPOM.clickDashboard().click();
		
		wait.until(ExpectedConditions.visibilityOf(ContractPOM.clickDraft()));
		int expiredNew = Integer.parseInt(ContractPOM.clickExpired().getText());
		if(expiredNew < expired)
		{
			test.log(LogStatus.PASS, "Dashboard 'Expired' count is decreased");
			test.log(LogStatus.INFO, "Old count = "+expired+" | New count = "+expiredNew);
		}
		else
		{
			test.log(LogStatus.FAIL, "Dashboard 'Expired' count doesn't decreased");
			test.log(LogStatus.INFO, "Old count = "+expired+" | New count = "+expiredNew);
		}
	}
	
	public static void MyReports( ExtentTest test, XSSFWorkbook workbook) throws InterruptedException, IOException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), 50);
		wait.until(ExpectedConditions.visibilityOf(ContractPOM.clickDraft()));
		
		Thread.sleep(500);
		ContractPOM.clickMyReports().click();
		
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOf(ContractPOM.clickStatusDropDown()));
		
		MyReportsCounts( test, 1, "Draft");
		
		MyReportsCounts( test, 2, "Pending For Review");
		
		MyReportsCounts( test, 3, "Review Completed");
		
		MyReportsCounts( test, 4, "Pending Approval");
		
		MyReportsCounts( test, 5, "Approval Completed");
		
		MyReportsCounts( test, 7, "Active");
		
		Thread.sleep(500);
		performer.OverduePOM.clickDashboard().click();
	}
	
	public static void MyReportsCounts( ExtentTest test, int no, String type) throws InterruptedException, IOException
	{
		Thread.sleep(500);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-1000)");
		
		
		Thread.sleep(500);
		ContractPOM.clickStatusDropDown().click();
		Thread.sleep(400);
		elementsList = ContractPOM.selectContractStatus();	//Getting all Contract Status.
		elementsList.get(no).click();
		
		Thread.sleep(400);
		ContractPOM.clickApply().click();						//CLicking on 'Apply' button.
		
		Thread.sleep(1000);

		js.executeScript("window.scrollBy(0,1000)");
		
		Thread.sleep(500);
		ContractPOM.readTotalRecords().click();
		int total = Integer.parseInt(ContractPOM.readTotalRecords().getText());
		
		File dir = new File("C://Users//jiya//Downloads");
		File[] allFiles = dir.listFiles();					//Counting number of files in directory before download
		
		js.executeScript("window.scrollBy(0,-1000)");
		Thread.sleep(300);
		ContractPOM.clickExportReport().click();
		
		Thread.sleep(4000);
		File dir1 = new File("C://Users//jiya//Downloads");
		File[] allFilesNew = dir1.listFiles();				//Counting number of files in directory after download
		
		if(allFiles.length < allFilesNew.length)
		{
			test.log(LogStatus.PASS, type+" :- File downloaded successfully.");
			
			File lastModifiedFile = allFilesNew[0];			//Storing any 0th index file in 'lastModifiedFile' file name.
		    for (int i = 1; i < allFilesNew.length; i++) 	//For loop till the number of files in directory.
		    {
		       if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) 	//If allFilesNew[i] file is having large/latest time time of update then latest modified file be allFilesNew[i] file.
		       {
		           lastModifiedFile = allFilesNew[i];
		       }
		    }
			
		    Thread.sleep(500);		
			fis = new FileInputStream(lastModifiedFile);	//Provided last modified / latest downloaded file.
			wb = new XSSFWorkbook(fis);
			sheet = wb.getSheetAt(0);						//Retrieving first sheet of Workbook
			//Row row4 = sheet.getRow(3);						//Selected 3rd index row (Fourth row)
			//Cell c1 = row4.createCell(0);					//Selected cell (4th row, 1st column)
			//c1.setCellValue("Test");						//Entered temp data at empty row, so that it could make easy to get Last Row Number
			FileOutputStream fos = new FileOutputStream(lastModifiedFile);
			wb.write(fos);
			fos.close();
			
			int excelTotal = sheet.getLastRowNum();
			int SheetRecords = excelTotal - 4;				//Sheet have extra 5 lines of information at top (But row count started from 0, so 4)
			
			if(total == SheetRecords)
			{
				test.log(LogStatus.PASS, type + " :- No of Records in sheet matches to the number of contracts in grid.");
				test.log(LogStatus.INFO, "Number of records in downloaded sheet = " +SheetRecords+ " | No of contracts in grid = "+total);
			}
			else
			{
				test.log(LogStatus.FAIL, type + " :- No of Records in sheet doesn't matches to the number of contracts in grid.");
				test.log(LogStatus.INFO, "Number of records in downloaded sheet = " +SheetRecords+ " | No of contracts in grid = "+total);
			}
		}
		else
		{
			test.log(LogStatus.FAIL, type+" :- File does not downloaded.");
		}
	}
	
	public static void CriticalDocuments(ExtentTest test, XSSFWorkbook workbook) throws InterruptedException, IOException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		wait.until(ExpectedConditions.visibilityOf(ContractPOM.clickReviewed()));
		
		ContractPOM.clickMyDocuments().click();
		Thread.sleep(300);
		ContractPOM.clickCriticalDocuments().click();
		
		wait.until(ExpectedConditions.visibilityOf(ContractPOM.clickNew()));
		Thread.sleep(300);
		ContractPOM.clickNew().click();
		Thread.sleep(300);
		ContractPOM.clickNewFolder().click();
		
		String name = "Test 123";
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOf(ContractPOM.clickFolderTextbox()));
		Thread.sleep(300);
		ContractPOM.clickFolderTextbox().sendKeys(name);
		
		Thread.sleep(300);
		ContractPOM.clickCreateButton().click();
		
		Thread.sleep(500);
		String msg = ContractPOM.readMsg1().getText();
		
		if(msg.contains("Succesfully"))
		{
			test.log(LogStatus.PASS, msg);
		}
		else
		{
			test.log(LogStatus.FAIL, msg);
		}
	}
}