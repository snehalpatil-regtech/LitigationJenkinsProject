package reviewer;

import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cfo.CFOcountPOM;
import login.BasePage;
import performer.OverduePOM;

public class ReMethodsPOM extends BasePage
{
	public static XSSFSheet sheet = null;
	private static List<WebElement> elementsList = null;
	private static List<WebElement> elementsList1 = null;
	private static List<WebElement> elementsList2 = null;
	
	public static void SubmittedInterimReview( ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), 20);
		wait.until(ExpectedConditions.elementToBeClickable(ReviewerPOM.clickStatutoryReview()));	//Waiting for Pending Review Count to be visible.
		
		int oldValue = Integer.parseInt(ReviewerPOM.clickStatutoryReview().getText());			//Reading old value of Statutory Pending For Review
		ReviewerPOM.clickStatutoryReview().click();		//Clicking on Statutory Review value.
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.checkTable()));	//Waiting for records table to get displayed.
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,800)");						//Scrolling down window by 2600 px.
		
		CFOcountPOM.readTotalItems1().click();					//Clicking just to scroll down the window
		
		Thread.sleep(500);
		elementsList = ReviewerPOM.clickStatus();					//CLicking on Status to sort it in ascending order
		elementsList.get(0).click();
		elementsList.get(0).click();									//Double clicking on Status header to get 'Submitted For Interim Review' status compliance on top.
		elementsList = OverduePOM.readStatus();					//Getting all status values (names)
		int n = elementsList.size();
		String status = null;
		int i = 0, flag = 0;
		for(i = 0; i < n; i++)
		{
			elementsList = OverduePOM.readStatus();
			status = elementsList.get(i).getText();
			if(status.equalsIgnoreCase("Submitted For Interim Review"))
			{
				flag = 1;
				break;
			}
		}
		
		if(flag == 1)
		{
			elementsList1 = OverduePOM.clickCalenderAction();		//Getting all action buttons
			elementsList1.get(i).click();								//Clicking on ith action button which has blue status 
			
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("iReviewerFrame"));
			
			Thread.sleep(500);
			js.executeScript("window.scrollBy(0,500)");					//Scrolling down window by 2600 px.
			
			Thread.sleep(500);
			ReviewerPOM.clickDownload1().click();					//Clicking on Download link 
			
			Thread.sleep(500);
			ReviewerPOM.InterimApproveRadio().click();			//Clicking on 'Interim Review Approve' radio button
			
			try
			{
				Thread.sleep(700);
				ReviewerPOM.clickCheckBox().click();
			}
			catch(Exception e)
			{
				
			}
			
			Thread.sleep(500);
			ReviewerPOM.insertTextArea().sendKeys("Automation Remark");	//Sending remark to text area.
			
			Thread.sleep(500);
			OverduePOM.clickComplianceSubmit().click();			//Clicking on 'Submit' button. 
			
			Thread.sleep(1000);
			getDriver().switchTo().alert().accept();
			Thread.sleep(500);
			getDriver().switchTo().parentFrame();
			
			Thread.sleep(500);
			wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.checkTable()));	//Waiting for records table to get displayed.
			
			OverduePOM.clickDashboard().click();					//Clicking on 'Dashboard'
			
			wait.until(ExpectedConditions.elementToBeClickable(ReviewerPOM.clickStatutoryReview()));	//Waiting for Pending Review Count to be visible.
			int newValue = Integer.parseInt(ReviewerPOM.clickStatutoryReview().getText());			//Reading old value of Statutory Pending For Review
			if(newValue < oldValue)
			{
				test.log(LogStatus.PASS, "Statutory value for 'Pending For Review' decremented. Old Statutory Review Value = "+oldValue+ " New Statutory Review Value = "+ newValue);
			}
			else
			{
				test.log(LogStatus.PASS, "Statutory value for 'Pending For Review' doesn't decremented. Old Statutory Review Value = "+oldValue+ " New Statutory Review Value = "+ newValue);
			}
		}
		else
		{
			Thread.sleep(1000);
			OverduePOM.clickDashboard().click();					//Clicking on 'Dashboard'
			test.log(LogStatus.INFO, "No compliance submitted for Interim Review.");
		}
	}
	
	public static void MyEscalationReviewer( ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), 20);
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(ReviewerPOM.clickMyEscalation()));	//Waiting for My Escalation link to be visible.
		
		ReviewerPOM.clickMyEscalation().click();					//Clicking on 'My Escalation'
		wait.until(ExpectedConditions.visibilityOf(CFOcountPOM.loadGrid() ));	//Waiting for records table to be visible.
		
		///----------------- Single Compliance - Through Update Button --------------------------
		
		String no = "25";
		Thread.sleep(1500);
		elementsList = ReviewerPOM.clickWorkFileText();		//Getting all Work File text boxes
		elementsList.get(0).clear();
		elementsList = ReviewerPOM.clickWorkFileText();
		elementsList.get(0).sendKeys(no);
		
		Thread.sleep(500);
		elementsList1 = ReviewerPOM.clickEscalationText();	//Getting all the Escalation text boxes
		elementsList1.get(0).clear();
		elementsList2 = ReviewerPOM.clickEscalationText();
		elementsList2.get(0).sendKeys("21");
		
		ReviewerPOM.clickFirstAction().click();
		ReviewerPOM.clickFirstAction().click();
		
		Thread.sleep(1500);
		ReviewerPOM.clickUpdate().click();
		
		Thread.sleep(1500);
		elementsList = ReviewerPOM.clickWorkFileText();
		int value = Integer.parseInt(elementsList.get(0).getAttribute("value"));
		int no1 = Integer.parseInt(no);
		
		test.log(LogStatus.INFO, "----------- Single Compliance Escallation -----------");
		if(value == no1)					//If Save button renamed to Update
		{
			test.log(LogStatus.PASS, "Update button appeared after Save. Compliance escalated successfully.");
		}
		else
		{
			test.log(LogStatus.FAIL, "Inserted data didn't saved successfully.");
		}
		
		///----------------- Multiple Compliances - Through Save Button --------------------------
		
		elementsList = ReviewerPOM.clickCheckboxes();
		elementsList.get(3).click();
		elementsList.get(4).click();
		
		Thread.sleep(500);
		String num = "9";
		elementsList = ReviewerPOM.clickWorkFileText();			//Getting all Work File text boxes
		elementsList.get(2).clear();
		elementsList = ReviewerPOM.clickWorkFileText();
		elementsList.get(2).sendKeys(num);
		
		Thread.sleep(500);
		elementsList = ReviewerPOM.clickEscalationText();			//Getting all Escalation text boxes
		elementsList.get(2).clear();
		elementsList = ReviewerPOM.clickEscalationText();
		elementsList.get(2).sendKeys("27");
		
		Thread.sleep(500);
		elementsList = ReviewerPOM.clickWorkFileText();			//Getting all Work File text boxes
		elementsList.get(3).clear();
		elementsList = ReviewerPOM.clickWorkFileText();
		elementsList.get(3).sendKeys(num);
		
		Thread.sleep(500);
		elementsList = ReviewerPOM.clickEscalationText();			//Getting all Escalation text boxes
		elementsList.get(3).clear();
		elementsList = ReviewerPOM.clickEscalationText();
		elementsList.get(3).sendKeys("27");
		
		Thread.sleep(1000);
		ReviewerPOM.clickSaveButton().click();
		
		Thread.sleep(1200);
		String msg = getDriver().switchTo().alert().getText();
		getDriver().switchTo().alert().accept();
		String expectedMsg = "Selected Compliance(s) Escalated Successfully.";
		
		test.log(LogStatus.INFO, "----------- Multiple Compliance Escallation -----------");
		if(msg.equalsIgnoreCase(expectedMsg))
		{
			test.log(LogStatus.PASS, "Success message : "+msg);
		}
		else
		{
			test.log(LogStatus.FAIL, "Compliances didn't escalated successfully.");
			test.log(LogStatus.INFO, "Message : "+msg);
		}
		
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.clickDashboard()));
		OverduePOM.clickDashboard().click();
		
		Thread.sleep(500);
		performer.OverdueCount.message();
	}
	
	public static void ReassignPerformer( ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), 60);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.clickMyWorkspace()));	//Waiting for 'My Workspace' link to be visible.
		OverduePOM.clickMyWorkspace().click();				//Clicking on 'My Workspace'
		
		Thread.sleep(300);
		OverduePOM.clickCompliance().click();					//Clicking on 'Compliance' under My Workspace
		
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(OverduePOM.clickMoreActions()));	//Waiting for records table to get visible.
		OverduePOM.clickUserRole().click();
		Thread.sleep(300);
		elementsList = OverduePOM.selectUserRole();
		elementsList.get(1).click();
		
		Thread.sleep(500);
		OverduePOM.clickMoreActions1().click();				//Clicking on 'More Actions' drop down.
		Thread.sleep(500);
		elementsList = OverduePOM.selectAction();				//Getting all 'More Action' drop down option
		elementsList.get(3).click();								//Clicking on fourth option "Reassign Performer"
		
		Thread.sleep(300);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)");					//Scrolling down window by 2600 px.
		
		wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.checkRecordsTable()));	//Waiting for records table to get visible.
		ReviewerPOM.selectUserAssign().click();				//Clicking on 'Select User to Assign' drop down.
		Select drp = new Select(ReviewerPOM.selectUserAssign());
		drp.selectByIndex(1);										//Select first user
		
		Thread.sleep(2000);
		drp = new Select(ReviewerPOM.selectUserAssign());
		String user_dropdown = drp.getFirstSelectedOption().getText();		//Reading selected user name from dropdown.
		String user_table = ReviewerPOM.readAssignedUser().getText();	//Reading already assigned user from table.
		
		if(user_dropdown.equalsIgnoreCase(user_table))				//If user from dropdown matches to user from table
		{
			drp = new Select(ReviewerPOM.selectUserAssign());
			drp.selectByIndex(2);									//Selecting (next) second user of index 2
		}
		
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(ReviewerPOM.clickFirstCheckbox()));
		ReviewerPOM.clickFirstCheckbox().click();				//Clicking on first checkbox (Not select all checkbox)
		
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,300)");					//Scrolling down window by 2600 px.
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOf(OverduePOM.clickSaveButton()));
		OverduePOM.clickSaveButton().click();					//Clicking on 'Save' button.
		
		Thread.sleep(500);
		getDriver().switchTo().alert().accept();
		
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(ReviewerPOM.selectUserAssign()));
		drp = new Select(ReviewerPOM.selectUserAssign());
		String user1 = drp.getFirstSelectedOption().getText();		//Reading the selected user in Drop down
		String user2 = ReviewerPOM.readAssignedUser().getText();	//Reading the assigned user name from table.
		
		if(user1.equalsIgnoreCase(user2))
		{
			test.log(LogStatus.PASS, "Performer user name updated with selected name.");
		}
		else
		{
			test.log(LogStatus.FAIL, "Performer user name doesn't updated with selected name.");
		}
		
		Thread.sleep(500);
		OverduePOM.clickDashboard().click();
	}
	
	public static void PendingReviewInternal( ExtentTest test, XSSFSheet sheet, String clickButton)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), 5);
		
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(ReviewerPOM.clickInternalReview()));	//Wait until Internal Pending For Review count gets visible.
		int oldInternalReviewValue = Integer.parseInt(ReviewerPOM.clickInternalReview().getText());	//Reading old value of Internal Pending For Review
		int oldInternalRejectValue = Integer.parseInt(ReviewerPOM.readInternalReject().getText());	//Reading old value of Internal Reject
		
		ReviewerPOM.clickInternalReview().click();		//Clicking on Statutory Review value.
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@role='grid'][@class='k-selectable']")));
		
		elementsList = ReviewerPOM.clickStatus();			//CLicking on Status to sort it in ascending order
		elementsList.get(0).click();
		
		int flag = 0;
		wait.until(ExpectedConditions.elementToBeClickable(ReviewerPOM.clickAction1()));
		elementsList = ReviewerPOM.clickActions();
		for (int i = 0; i < elementsList.size(); i++)						//Starting from the third button.
		{
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,500)"," ");
			
			Thread.sleep(300);
			elementsList = ReviewerPOM.clickActions();
			elementsList.get(i).click();									//Clicking on ith action button.
			
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("iInternalReviewerFrame"));
			
			js.executeScript("window.scrollBy(0,500)"," ");					//Scrolling down window by 2000 px.
			WebElement download = null;
			try
			{
				wait.until(ExpectedConditions.elementToBeClickable(ReviewerPOM.clickDownloadInternal1()));
				download = ReviewerPOM.clickDownloadInternal1();			//Check if Download link is available or not.		
			}
			catch(Exception e)
			{
				
			}
			
			if(download == null)
			{
				flag = 1;
				getDriver().switchTo().parentFrame();							//Switching back to parent frame from iFrame
				ReviewerPOM.ComplainceInternalReviewer().click();		//Closing the compliance popup as it has message.
				Thread.sleep(1000);
			}
			else
			{
				flag = 0;
				ReviewerPOM.clickDownloadInternal1().click();				//Clicking on Download to download the document
				
				Thread.sleep(500);
				js.executeScript("window.scrollBy(0,400)"," ");					//Scrolling down window by 2000 px.
				
				Thread.sleep(500);
				try
				{
					ReviewerPOM.clickClosedTimelyInternal().click();		//Clicking on Closed-Delay radio button.
				}
				catch(Exception e)
				{
					
				}
				
				WebElement ele1 = null;
				WebElement ele2 = null;
				WebElement ele3 = null;
				try
				{
					wait.until(ExpectedConditions.elementToBeClickable(ReviewerPOM.insertLiability1()));
					ele1 = ReviewerPOM.insertLiability1();			//Loaded element in ele1. So that, if element not found it will do nothing.
					ele2 = ReviewerPOM.insertLiability2();			//Loaded element in ele2. So that, if element not found it will do nothing.
					ele3 = ReviewerPOM.insertLiability3();			//Loaded element in ele3. So that, if element not found it will do nothing.
				}
				catch(Exception e)
				{
					
				}
				if(ele1 != null)
				{
					Row row3 = sheet.getRow(3);											//Selected 3rd index row (Fourth row)
					Cell c1 = row3.getCell(1);											//Selected cell (3 row,1 column)
					int liability1 = (int) c1.getNumericCellValue();					//Got the amount stored at position 3,1
					String l1 = Integer.toString(liability1); 							//Converting int to String
					ReviewerPOM.insertLiability1().clear();				//Clearing the text box.
					ReviewerPOM.insertLiability1().sendKeys(l1);		//Inserting amount in text box
					Thread.sleep(500);
				}
				
				if(ele2 != null)
				{
					Row row4 = sheet.getRow(4);											//Selected 4th index row (Fifth row)
					Cell c2 = row4.getCell(1);											//Selected cell (4 row,1 column)
					int liability2 = (int) c2.getNumericCellValue();					//Got the amount stored at position 4,1
					String l2 = Integer.toString(liability2); 							//Converting int to String
					ReviewerPOM.insertLiability2().clear();				//Clearing the text box.
					ReviewerPOM.insertLiability2().sendKeys(l2);		//Inserting amount in text box
					Thread.sleep(500);
				}
				
				if(ele3 != null)
				{
					Row row5 = sheet.getRow(5);											//Selected 5th index row (Sixth row)
					Cell c3 = row5.getCell(1);											//Selected cell (5 row,1 column)
					int liability3 = (int) c3.getNumericCellValue();					//Got the amount stored at position 5,1
					String l3 = Integer.toString(liability3); 							//Converting int to String
					ReviewerPOM.insertLiability3().clear();				//Clearing the text box.
					ReviewerPOM.insertLiability3().sendKeys(l3);		//Inserting amount in text box
					Thread.sleep(500);
				}
				
				Row row6 = sheet.getRow(6);											//Selected 6th index row (Seventh row)
				Cell c4 = row6.getCell(1);											//Selected cell (6 row,1 column)
				String remark = c4.getStringCellValue();							//Got the URL stored at position 6,1
				try
				{
					wait.until(ExpectedConditions.elementToBeClickable(ReviewerPOM.insertTextAreaInternal()));
					ReviewerPOM.insertTextAreaInternal().sendKeys(remark);		//Inserting remark in Text area
				}
				catch(Exception e)
				{
					
				}
				
				Thread.sleep(500);
				if(clickButton.equalsIgnoreCase("Approve"))
				{
					ReviewerPOM.clickApprove().click();						//Clicking on Approve button.
					Thread.sleep(500);
					getDriver().switchTo().alert().accept();								//Accepting msg of Successful Submission.
				}
				else
				{
					ReviewerPOM.clickReject().click();						//Clicking on Reject button.
					Thread.sleep(500);
				}
				
				getDriver().switchTo().parentFrame();									//Switching back to parent frame from iFrame
				Thread.sleep(1000);
				getDriver().navigate().refresh();
				Thread.sleep(1000);
				wait.until(ExpectedConditions.elementToBeClickable(ReviewerPOM.clickAction1()));
				break;
			}
			Thread.sleep(500);
			if(i == elementsList.size()-1)
			{
				js.executeScript("window.scrollBy(0,500)"," ");
				CFOcountPOM.clickNextPage1().click();
				i = -1;
			}
		}		
		
		Thread.sleep(2500);
		
		getDriver().navigate().refresh();
		
		wait.until(ExpectedConditions.visibilityOf(performer.OverduePOM.clickDashboard()));
		performer.OverduePOM.clickDashboard().click();
		
		Thread.sleep(700);
		wait.until(ExpectedConditions.elementToBeClickable(ReviewerPOM.clickInternalReview()));
		int newInternalReviewValue = Integer.parseInt(ReviewerPOM.clickInternalReview().getText());	//Reading new value of Internal Pending For Review
		int newInternalRejectValue = Integer.parseInt(ReviewerPOM.readInternalReject().getText());	//Reading old value of Internal Reject
		
		if(flag == 0)
		{
			if(newInternalReviewValue < oldInternalReviewValue)
			{
				test.log(LogStatus.PASS, "Internal value for 'Pending For Review' decremented.");
				test.log(LogStatus.INFO, "Old Value = "+oldInternalReviewValue+ " | New Value = "+ newInternalReviewValue);
			}
			else
			{
				test.log(LogStatus.FAIL, "Updated Internal Count doesn't reverted on Dashboard.");
			}
			if(clickButton.equalsIgnoreCase("Reject"))
			{
				if(newInternalRejectValue > oldInternalRejectValue)
				{
					test.log(LogStatus.PASS, "Internal value for 'Rejected : "+clickButton+"' incremented.");
					test.log(LogStatus.INFO, "Old Internal Reject Value = "+oldInternalRejectValue+" | New Internal Reject Value = "+ newInternalRejectValue);
				}
				else
				{
					test.log(LogStatus.FAIL, "Updated Internal value not reverted on Dashboard.");
				}
			}
		}
		else
		{
			test.log(LogStatus.INFO, "Internal Compliance (Pending for Review) doesn't performed as the Compliance Document didn't found.");
		}
	}
}
