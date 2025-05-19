package performer;

import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
import login.BasePage;

public class MethodsPOM extends BasePage
{
	public static XSSFSheet sheet = null;
	private static List<WebElement> checkboxesList = null;				//WebElement list created for selecting action button from multiple action buttons
	private static List<WebElement> elementsList = null;
	private static List<WebElement> elementsList1 = null;
	
	public static void StatutoryOverdue() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), 60);
		WebDriverWait wait1 = new WebDriverWait(getDriver(), 90);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,2000)"," ");
		
		Thread.sleep(500);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id = 'grid']")));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='k-button k-button-icontext ob-overview k-grid-edit2'])[1]")));
		wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@class='k-button k-button-icontext ob-overview k-grid-edit2'])[1]")));
		elementsList = OverduePOM.ActionButtons();
		wait.until(ExpectedConditions.elementToBeClickable(elementsList.get(2)));
		Thread.sleep(3000);
		elementsList = OverduePOM.ActionButtons();
		elementsList.get(1).click();									//Clicking on Third Action button.
		
		Thread.sleep(1000);
		getDriver().switchTo().frame("iPerformerFrame");						//Switching 1st iFrame.
		
		Thread.sleep(500);
		js.executeScript("window.scrollBy(0,2000)"," ");				//Scrolling down window by 2000 px.
		
		Thread.sleep(500);
		Select status = new Select(OverduePOM.selectStatutoryDropdown());	//Selecting dropdown box
		status.selectByIndex(1);											//Selecting 2nd value from dropdown.
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.complianceDocLink()));
		OverduePOM.complianceDocLink().sendKeys("www.google.com");	//Providing Compliance Documents link
		OverduePOM.buttonAddLink().click();						//Clicking on 'Add Link' button of Compliance Documents
		
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,2500)"," ");				//Scrolling down window by 2000 px.
		
		wait.until(ExpectedConditions.visibilityOf(OverduePOM.selectDateStatutory()));
		OverduePOM.selectDateStatutory().click();					//Click on the Date text box
		OverduePOM.selectLastMonth().click();						//Clicking to get last month
		Thread.sleep(1000);
		OverduePOM.selectDate().click(); 							//Selecting date - second row and fifth column date from calendar
		
		WebElement ele1 = null;
		WebElement ele2 = null;
		try
		{
			ele1 = OverduePOM.valueSystem();
			ele2 = OverduePOM.valueReturn();
		}
		catch(Exception e)
		{
			
		}
		
		if(ele1 != null)
		{
			Thread.sleep(500);
			OverduePOM.valueSystem().sendKeys("100");					//Sending Value as per System textbox
		}
		if(ele2 != null)
		{
			Thread.sleep(500);
			OverduePOM.valueReturn().sendKeys("50");					//Sending Value as per Return textbox
		}
		
		Thread.sleep(500);
		OverduePOM.remark().sendKeys("Automation Testing");			//Sending Remark
		
		Thread.sleep(1000);
		OverduePOM.clickComplianceSubmit().click();				//Click on Submit button.
		
		Thread.sleep(2000);
		getDriver().switchTo().alert().accept();								//Accepting msg of Successful Submittion.
		getDriver().switchTo().parentFrame();								//Switching back to parent frame from iFrame
	}
	
	public static void InternalOverdue() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), 60);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,1000)");
		
		OverduePOM.loadNextPage().click();
		OverduePOM.loadNextPage().click();
		OverduePOM.loadNextPage().click();
		OverduePOM.loadNextPage().click();						//Going to Page Index 5.
		
		elementsList = OverduePOM.clickActionButtonList();		//Getting all action buttons on the page.
		for (int i = 0; i < elementsList.size(); i++)					//Starting from the third button.
		{
			js.executeScript("window.scrollBy(0,1000)");				//Scrolling down window by 2000 px.
			elementsList.get(i).click();								//Clicking on the ith button
			Thread.sleep(500);
			getDriver().switchTo().frame("iInternalPerformerFrame");			//Switching to 1st iFrame.
			WebElement ele = null;
			try
			{
				ele = OverduePOM.msgCheck();						//Loaded message element in 'ele' variable. If element not found then it will do nothing.
			}															//Checking if the Compliance related task is done or not.
			catch(Exception e)
			{
				
			}
			if(ele!=null)												//If message found do the following.
			{
				getDriver().switchTo().parentFrame();						//Switching back to parent frame from iFrame
				OverduePOM.closeCompliance().click();				//Closing the compliance pop up as it has message.
				Thread.sleep(500);
			}			
			else														//We will proceed if the message not shown.
			{
				js.executeScript("window.scrollBy(0,2000)"," ");		//Scrolling down window by 2000 px.
				
				Thread.sleep(500);
				Select status1 = new Select(OverduePOM.selectInternalDropdown());	//Selecting dropdown box.
				status1.selectByIndex(1);								//Selecting 2nd value from dropdown.
				
				js.executeScript("window.scrollBy(0,2000)"," ");		//Scrolling down window by 2000 px.
				
				Thread.sleep(500);
				wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.complianceDocLinkInternal()));
				OverduePOM.complianceDocLinkInternal().sendKeys("www.google.com");	//Providing Compliance Documents link
				OverduePOM.buttonAddLinkInternal().click();		//Clicking on 'Add Link' button of Compliance Documents
				
				Thread.sleep(1000);
				js.executeScript("window.scrollBy(0,2000)"," ");		//Scrolling down window by 2000 px.
				Thread.sleep(500);
				OverduePOM.selectDateInternal().click();			//Clicking on the Date text box
				OverduePOM.selectLastMonth().click();				//Clicking to get last month
				Thread.sleep(1000);
				OverduePOM.selectDate().click(); 					//Selecting date - second row and fifth column date from calendar
				
				Thread.sleep(500);
				OverduePOM.clickComplianceSubmit().click();
				
				Thread.sleep(500);
				getDriver().switchTo().alert().accept();						//Accepting msg of Successful Submission.
				getDriver().switchTo().parentFrame();						//Switching back to parent frame from iFrame
				break;
			}
			if(i==elementsList.size()-1)
			{
				js.executeScript("window.scrollBy(0,2000)"," ");		//Scrolling down window by 2000 px.
				Thread.sleep(500);
				OverduePOM.loadNextPage().click();				//Clicking on next page indicator 'Arrow'
				Thread.sleep(500);
				elementsList = OverduePOM.clickActionButtonList();	//Re-assigning list of action buttons to variable
			}
		}
	}
	
	static void CheckList( String action) throws InterruptedException
	{
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(getDriver(), 90);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid']/div[4]"))); //Waiting until grid/kendo gets visible.
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,4000)");			//Sometimes it doesn't scrolls down so extra query added.
		
		getDriver().findElement(By.xpath("//div[@class = 'k-multiselect-wrap k-floatwrap']")).click();
		Thread.sleep(500);
		//getDriver().findElement(By.xpath("//div[@class='k-grouping-header']")).click();
		OverduePOM.clickAdvancedSearch().sendKeys(Keys.PAGE_DOWN);
		OverduePOM.clickAdvancedSearch().sendKeys(Keys.PAGE_DOWN);
		
		wait.until(ExpectedConditions.visibilityOf(OverduePOM.clickCheckboxesList().get(1)));
		checkboxesList = OverduePOM.clickCheckboxesList();		//Getting multiple check boxes
		checkboxesList.get(1).click();
		//checkboxesList.get(2).click();									//Clicking on 2,3 check box
		
		if(action.equalsIgnoreCase("submit"))
		{
			Thread.sleep(1000);
			OverduePOM.clickSubmit().click();						//Clicking on 'Submit' button on top.
			Thread.sleep(500);
			getDriver().switchTo().alert().accept();							//Clicking on alert to accept the message.
		}
		else
		{
			Thread.sleep(1000);
			OverduePOM.clickCheckboxesNotApplicable().click();	//Clicking on 'Not Applicable' button on top.
			Thread.sleep(500);
			getDriver().switchTo().alert().accept();							//Clicking on alert to accept the message.
		}
		Thread.sleep(2000);
		OverduePOM.clickDashboard().click();						//Clicking on dashboard.
	}
	
	static void Action( String action, String frame) throws InterruptedException
	{
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(getDriver(), 90);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid']/div[4]"))); //Waiting until grid/kendo gets visible.
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,4000)");			//Sometimes it doesn't scrolls down so extra query added.
		
		getDriver().findElement(By.xpath("//div[@class = 'k-multiselect-wrap k-floatwrap']")).click();
		Thread.sleep(500);
		
		OverduePOM.clickAdvancedSearch().sendKeys(Keys.PAGE_DOWN);
		OverduePOM.clickAdvancedSearch().sendKeys(Keys.PAGE_DOWN);
		OverduePOM.clickAdvancedSearch().sendKeys(Keys.PAGE_DOWN);
		
		CFOcountPOM.clickNextPage1().sendKeys(Keys.DOWN);
		
		wait.until(ExpectedConditions.visibilityOf(OverduePOM.clickStatutoryChecklistAction().get(0)));	//Waiting until all Action buttons get visible.
		Thread.sleep(500);
		OverduePOM.clickStatutoryChecklistAction().get(0).click();	//Clicking on first Action button inside Statutory Checklist click
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));	//Switching to iFrame
		js.executeScript("window.scrollBy(0,1500)");
		
		if(action.equalsIgnoreCase("submit"))
		{
			Thread.sleep(500);
			wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.statutoryComplianceDoc()));
			OverduePOM.statutoryComplianceDoc().sendKeys("www.google.com");	//Providing Compliance Documents link
			OverduePOM.statutoryAddLinkButton().click();						//Clicking on 'Add Link' button of Compliance Documents
			
			Thread.sleep(1000);
			js.executeScript("window.scrollBy(0,1500)"," ");				//Scrolling down window by 2000 px.
			
			Thread.sleep(500);
			OverduePOM.clickComplianceSubmit().click();				//Clicking on 'Submit' button.
			
			try
			{
				Thread.sleep(1000);
				getDriver().switchTo().alert().accept();							//Clicking on OK of alert.
			}
			catch(Exception e)
			{
				
			}
			getDriver().switchTo().parentFrame();								//Switching back to parent frame.
		}
		else
		{
			Thread.sleep(500);
			OverduePOM.clickActionNotApplicable().click();		//Clicking on 'Not Applicable' button.
			
			Thread.sleep(500);
			getDriver().switchTo().alert().dismiss();					//Clicking on OK of alert.
			getDriver().switchTo().parentFrame();						//Switching back to parent frame.
		}
		
		Thread.sleep(2000);
		OverduePOM.clickDashboard().click();						//Clicking on Dashboard.
	}

	public static void StatutoryCheckListCheckbox( ExtentTest test) throws InterruptedException
	{
		//-----------------------------Submit after multiple checkbox click--------------------
		
		Thread.sleep(1000);
		int oldStatutoryChecklistValue = Integer.parseInt(OverduePOM.clickStatutoryChecklist().getText());	//Storing old value of Statutory Checkilist.
		
		OverduePOM.clickStatutoryChecklist().click();				//Clicking on Statutory Checklist value
		
		Thread.sleep(500);
		
		CheckList( "Submit");									//Will click on 'Submit' button
		
		Thread.sleep(1000);
		int newStatutoryChecklistValue = Integer.parseInt(OverduePOM.clickStatutoryChecklist().getText());	//Storing new value of Statutory Checkilist.
		
		if(newStatutoryChecklistValue < oldStatutoryChecklistValue)
		{
			test.log(LogStatus.PASS, "Checkbox 'Submit' - Statutory 'Checklist' value decremented. Old value = " +oldStatutoryChecklistValue +" | New Value = "+ newStatutoryChecklistValue);
		}
		else
		{
			test.log(LogStatus.FAIL, "Test Failed.");
		}
		
		//--------------------------------Not Applicable after multiple checkbox click--------------------
		
		Thread.sleep(1000);
		oldStatutoryChecklistValue = Integer.parseInt(OverduePOM.clickStatutoryChecklist().getText());	//Storing old value of Statutory Checkilist.
		
		OverduePOM.clickStatutoryChecklist().click();				//Clicking on Statutory Checklist value
		
		CheckList( "Not Applicable");							//Will click on 'Not Applicable' button
		
		Thread.sleep(1000);
		newStatutoryChecklistValue = Integer.parseInt(OverduePOM.clickStatutoryChecklist().getText());	//Storing new value of Statutory Checkilist.
		
		if(newStatutoryChecklistValue < oldStatutoryChecklistValue)
		{
			test.log(LogStatus.PASS, "Checkbox 'Not Applicable' - Statutory 'Checklist' value decremented. Old value = " +oldStatutoryChecklistValue +" | New Value = "+ newStatutoryChecklistValue);
		}
		else
		{
			test.log(LogStatus.FAIL, "Test Failed.");
		}
	}
	
	public static void StatutoryCheckListAction( ExtentTest test) throws InterruptedException
	{
		
		//---------------------------Submit after Action button click--------------------------
		
		Thread.sleep(1000);
		int oldStatutoryChecklistValue = Integer.parseInt(OverduePOM.clickStatutoryChecklist().getText());	//Storing old value of Statutory Checkilist.
		
		OverduePOM.clickStatutoryChecklist().click();				//Clicking on Statutory Checklist value
		
		Action( "Submit", "iPerformerFrame");					//Will click on 'Action' button
		
		Thread.sleep(1000);
		int newStatutoryChecklistValue = Integer.parseInt(OverduePOM.clickStatutoryChecklist().getText());	//Storing new value of Statutory Checkilist.
		
		if(newStatutoryChecklistValue < oldStatutoryChecklistValue)
		{
			test.log(LogStatus.PASS, "Action 'Submit' - Statutory 'Checklist' value decremented. Old value = " +oldStatutoryChecklistValue +" | New Value = "+ newStatutoryChecklistValue);
		}
		else
		{
			test.log(LogStatus.FAIL, "Test Failed.");
		}
		
		//--------------------------------Not Applicable after Action button click--------------------------
		/*
		Thread.sleep(1000);
		oldStatutoryChecklistValue = Integer.parseInt(OverduePOM.clickStatutoryChecklist().getText());	//Storing old value of Statutory Checkilist.
		
		OverduePOM.clickStatutoryChecklist().click();									//Clicking on Statutory Checklist value
		
		Action( "Not Applicable", "iPerformerFrame");								//Will click on 'Not Applicable' button
		
		Thread.sleep(1000);
		newStatutoryChecklistValue = Integer.parseInt(OverduePOM.clickStatutoryChecklist().getText());	//Storing new value of Statutory Checkilist.
		
		if(newStatutoryChecklistValue < oldStatutoryChecklistValue)
		{
			test.log(LogStatus.PASS, "Action 'Not Applicable' - Statutory 'Checklist' value decremented. Old value = " +oldStatutoryChecklistValue +" | New Value = "+ newStatutoryChecklistValue);
		}
		else
		{
			test.log(LogStatus.FAIL, "Test Failed.");
		}
		*/
	}
	
	public static void InternalCheckListCheckbox( ExtentTest test) throws InterruptedException
	{
		//-----------------------------Submit after multiple checkbox click--------------------
		
		Thread.sleep(1000);
		int oldInternalChecklistValue = Integer.parseInt(OverduePOM.clickInternalChecklist().getText());	//Storing old value of Internal Checkilist.
		OverduePOM.clickInternalChecklist().click();				//Clicking on Internal Checklist value.
		
		CheckList( "Submit");									//Will click on 'Submit' button
		
		Thread.sleep(1000);
		int newInternalChecklistValue = Integer.parseInt(OverduePOM.clickInternalChecklist().getText());	//Storing new value of Internal Checkilist.
		
		if(newInternalChecklistValue < oldInternalChecklistValue)
		{
			test.log(LogStatus.PASS, "Checkbox 'Submit' - Internal 'Checklist' value decremented. Old value = " +oldInternalChecklistValue +" | New Value = "+ newInternalChecklistValue);
		}
		else
		{
			test.log(LogStatus.FAIL, "Test Failed.");
		}
		
		//--------------------------------Not Applicable after multiple checkbox click--------------------
		
		Thread.sleep(1000);
		oldInternalChecklistValue = Integer.parseInt(OverduePOM.clickInternalChecklist().getText());	//Storing old value of Internal Checkilist.
		OverduePOM.clickInternalChecklist().click();				//Clicking on Internal Checklist value.
		
		CheckList( "Not Applicable");							//Will click on 'Not Applicable' button
		
		Thread.sleep(1000);
		newInternalChecklistValue = Integer.parseInt(OverduePOM.clickInternalChecklist().getText());	//Storing new value of Internal Checkilist.
		
		if(newInternalChecklistValue < oldInternalChecklistValue)
		{
			test.log(LogStatus.PASS, "Checkbox 'Not Applicable' - Internal 'Checklist' value decremented. Old value = " +oldInternalChecklistValue +" | New Value = "+ newInternalChecklistValue);
		}
		else
		{
			test.log(LogStatus.FAIL, "Test Failed.");
		}
		
	}
	
	public static void InternalCheckListAction( ExtentTest test) throws InterruptedException
	{
		//--------------------------------Submit after Action button click------------------------------
		
		Thread.sleep(1000);
		int oldInternalChecklistValue = Integer.parseInt(OverduePOM.clickInternalChecklist().getText());		//Storing old value of Internal Checkilist.
		
		OverduePOM.clickInternalChecklist().click();					//Clicking on Internal Checklist Value
		
		WebDriverWait wait = new WebDriverWait(getDriver(), 60);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid']/div[4]"))); //Waiting until grid/kendo gets visible.
		
		Thread.sleep(500);
		js.executeScript("window.scrollBy(0,2000)");
		
		wait.until(ExpectedConditions.visibilityOfAllElements(OverduePOM.clickStatutoryChecklistAction()));	//Waiting until all Action buttons get visible.
		OverduePOM.clickStatutoryChecklistAction().get(0).click();	//Clicking on first Action button inside Internal Checklist click (Using Statutory xpath)
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("iInternalPerformerFrame"));	//Switching to iFrame
		
		Thread.sleep(500);
		js.executeScript("window.scrollBy(0,2000)");
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.statutoryComplianceDoc()));
		OverduePOM.statutoryComplianceDoc().sendKeys("www.google.com");	//Providing Compliance Documents link
		OverduePOM.statutoryAddLinkButton().click();						//Clicking on 'Add Link' button of Compliance Documents
		
		Thread.sleep(500);
		OverduePOM.clickComplianceSubmit().click();				//Clicking on 'Submit' button.	
		
		Thread.sleep(1000);
		getDriver().switchTo().alert().accept();								//Clicking on alert to accept the message.
		getDriver().switchTo().parentFrame();								//Switching back to parent frame.
		
		Thread.sleep(2000);
		OverduePOM.clickDashboard().click();						//Click on Dashboard
		Thread.sleep(1000);
		int newInternalChecklistValue = Integer.parseInt(OverduePOM.clickInternalChecklist().getText());	//Storing old value of Statutory Checkilist.
		
		if(newInternalChecklistValue < oldInternalChecklistValue)
		{
			test.log(LogStatus.PASS, "Action 'Submit' - Internal 'Checklist' value decremented. Old value = " +oldInternalChecklistValue +" New Value = "+ newInternalChecklistValue);
		}
		else
		{
			test.log(LogStatus.FAIL, "Test Failed.");
		}
		
		//--------------------------------Not Applicable after Action button click--------------------------
		
		Thread.sleep(1000);
		oldInternalChecklistValue = Integer.parseInt(OverduePOM.clickInternalChecklist().getText());		//Storing old value of Internal Checkilist.
		OverduePOM.clickInternalChecklist().click();				//Clicking on Internal Checklist Value
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid']/div[4]"))); //Waiting until grid/kendo gets visible.
		
		Thread.sleep(500);
		js.executeScript("window.scrollBy(0,2000)");
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfAllElements(OverduePOM.clickStatutoryChecklistAction()));	//Waiting until all Action buttons get visible.
		OverduePOM.clickStatutoryChecklistAction().get(0).click();	//Clicking on first Action button inside Internal Checklist click (Using Statutory xpath)
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("iInternalPerformerFrame"));	//Switching to iFrame
		
		Thread.sleep(500);
		js.executeScript("window.scrollBy(0,2000)");
		
		Thread.sleep(500);
		OverduePOM.clickActionNotApplicable().click();			//Clicking on 'Not Applicable' button
		
		try
		{
			Thread.sleep(500);
			getDriver().switchTo().alert().dismiss();							//Clicking on OK of alert.
		}
		catch(Exception e)
		{
			
		}
		
		Thread.sleep(500);
		getDriver().switchTo().parentFrame();								//Switching back to parent frame.
		
		wait.until(ExpectedConditions.visibilityOf(OverduePOM.clickDashboard()));
		OverduePOM.clickDashboard().click();						//Clicking on Dashboard
		
		Thread.sleep(1000);
		newInternalChecklistValue = Integer.parseInt(OverduePOM.clickInternalChecklist().getText());	//Storing old value of Statutory Checkilist.
		
		if(newInternalChecklistValue < oldInternalChecklistValue)
		{
			test.log(LogStatus.PASS, "Action 'Not Applicable' - Internal 'Checklist' value decremented. Old value = " +oldInternalChecklistValue +" New Value = "+ newInternalChecklistValue);
		}
		else
		{
			test.log(LogStatus.FAIL, "Test Failed.");
		}
	}

	static void RejectAction( String Compliance) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		elementsList = OverduePOM.clickStatutoryActionButton();
		elementsList.get(2).click();			//Clicking on third Action button.
		int flag = 0;
		if(Compliance.equalsIgnoreCase("Statutory"))
		{
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("iPerformerFrame"));
			
			OverduePOM.selectStatutoryDropdown().click();			//Clicking on statutory Status drop down.
			Select drp = new Select(OverduePOM.selectStatutoryDropdown());
			drp.selectByIndex(1);										//Selecting second index option of drop down.
			
			Thread.sleep(500);
			js.executeScript("window.scrollBy(0,1000)");					//Scrolling down window by 2000 px.
			
			if(OverduePOM.complianceDocLink().isEnabled())
			{
				Thread.sleep(500);
				wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.complianceDocLink()));
				OverduePOM.complianceDocLink().sendKeys("www.google.com");	//Providing Compliance Documents link
				OverduePOM.buttonAddLink().click();						//Clicking on 'Add Link' button of Compliance Documents
			}
			else
			{
				Thread.sleep(1000);
				wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.fileUploadStatutory()));
				String workingDir = System.getProperty("user.dir");
				OverduePOM.fileUploadStatutory().sendKeys(workingDir+"//Reports//PerformerResults.html");	//Uploading file by sending file to Upload Button.
				
				Thread.sleep(500);
				js.executeScript("window.scrollBy(0,500)");					//Scrolling down window by 2000 px.
			}
			js.executeScript("window.scrollBy(0,2000)");					//Scrolling down window by 2000 px.
			OverduePOM.selectDateStatutory().click();				//Clicking on Date inbox
			flag = 1;
		}
		else if(Compliance.equalsIgnoreCase("Internal"))
		{
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("iInternalPerformerFrame"));
			
			OverduePOM.selectInternalDropdown().click();			//Clicking on internal Status drop down.
			Select drp = new Select(OverduePOM.selectInternalDropdown());
			drp.selectByIndex(1);										//Selecting second index option of drop down.
			
			Thread.sleep(500);
			js.executeScript("window.scrollBy(0,1000)");					//Scrolling down window by 2000 px.
			
			if(OverduePOM.complianceDocLinkInternal().isEnabled())
			{
				Thread.sleep(500);
				wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.complianceDocLinkInternal()));
				OverduePOM.complianceDocLinkInternal().sendKeys("www.google.com");	//Providing Compliance Documents link
				OverduePOM.buttonAddLinkInternal().click();						//Clicking on 'Add Link' button of Compliance Documents
			}
			else
			{
				Thread.sleep(1000);
				wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.fileUploadInternal()));
				String workingDir = System.getProperty("user.dir");
				OverduePOM.fileUploadInternal().sendKeys(workingDir+"//Reports//PerformerResults.html");	//Uploading file by sending file to Upload Button.
			}
			Thread.sleep(500);
			js.executeScript("window.scrollBy(0,2000)");					//Scrolling down window by 2000 px.
			OverduePOM.selectDateInternal().click();				//Clicking on Date inbox
			flag = 2;
		}
		
		Thread.sleep(500);
		OverduePOM.selectLastMonth().click();						//Clicking on Last Month Arrow on calendar
		Thread.sleep(500);
		OverduePOM.selectDate().click();							//Clicking on date at second row and fourth column
		
		Thread.sleep(500);
		if(flag == 1)
			OverduePOM.remark().sendKeys("Automation Remark");	//Clicking on remark text area (statutory)
		else
			OverduePOM.clickInternalRemark().sendKeys("Automation Remark");	//Clicking on remark text area (internal)
		
		Thread.sleep(500);
		OverduePOM.clickComplianceSubmit().click();				//clicking on submit button.
		
		Thread.sleep(500);
		getDriver().switchTo().alert().accept();
		getDriver().switchTo().parentFrame();
	}
	
	public static void DashboardRejected( ExtentTest test, String Compliance) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ContentPlaceHolder1_divPerformerRejectedPREOcount']")));	//Waiting for 'Statutory Reject' value to get visible on Dashboard
		
		String string_rejected = null;
		int rejected = 0;
		for(int i = 0; i <= 0; i++)						//For loop used only to get 'break;' functionality in use.
		{
			if(Compliance.equalsIgnoreCase("Statutory"))					//Going for statutory click
			{
				string_rejected = OverduePOM.clickStatutoryRejected().getText();	//Storing old value of Statutory Reject from Dashboard.
				rejected = Integer.parseInt(string_rejected);
				if(rejected == 0)
					break;
				Thread.sleep(500);
				OverduePOM.clickStatutoryRejected().click();			//Clicking on Statutory overdue.
			}
			else															//Going for Internal click
			{
				string_rejected = OverduePOM.clickInternalRejected().getText();	//Storing old value of Internal Reject from Dashboard.
				rejected = Integer.parseInt(string_rejected);
				if(rejected == 0)
					break;
				Thread.sleep(500);
				OverduePOM.clickInternalRejected().click();			//Clicking on Statutory overdue.
			}
		}
		
		if(rejected > 0)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@role='grid'][@data-role='selectable'])[1]")));	//Waiting for records table to get visible.
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,500)");						//Scrolling down window by 2000 px.
			
			CFOcountPOM.readTotalItems1().click();					//Clicking on total items to scroll down
			String item = CFOcountPOM.readTotalItems1().getText();	//Reading total items String value
			String[] bits = item.split(" ");								//Splitting the String
			String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
			int count = 0;
			if(compliancesCount.equalsIgnoreCase("to"))
			{
				Thread.sleep(2000);
				item = CFOcountPOM.readTotalItems1().getText();
				bits = item.split(" ");										//Splitting the String
				compliancesCount = bits[bits.length - 2];
			}
			count = Integer.parseInt(compliancesCount);
			
			if(rejected == count)
			{
				test.log(LogStatus.PASS, "Before Perform ("+ Compliance +"):- Compliances count matches to Dashboard count. Total Compliances count in the grid = " + count + " | Total Compliances count on Dashboard = " + rejected);
			}
			else
			{
				test.log(LogStatus.FAIL, "Before Perform ("+ Compliance +"):- Compliances count doesn't matches to Dashboard count. Total Compliances count in the grid = " + count + " | Total Compliances count on Dashboard = " + rejected);
			}
			
			RejectAction( Compliance);								//Calling method of Action Button click
			
			Thread.sleep(1000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@role='grid'][@data-role='selectable'])[1]")));	//Waiting for records table to get visible.
			
			js.executeScript("window.scrollBy(0,1000)");
			
			Thread.sleep(2000);
			CFOcountPOM.readTotalItems1().click();					//Clicking on total items count
			item = CFOcountPOM.readTotalItems1().getText();			//Reading total items String value
			bits = item.split(" ");											//Splitting the String
			compliancesCount = bits[bits.length - 2];						//Getting the second last word (total number of users)
			int count1 = 0;
			if(compliancesCount.equalsIgnoreCase("to"))
			{
				Thread.sleep(2000);
				item = CFOcountPOM.readTotalItems1().getText();
				bits = item.split(" ");										//Splitting the String
				compliancesCount = bits[bits.length - 2];
			}
			count1 = Integer.parseInt(compliancesCount);
					
			Thread.sleep(500);
			OverduePOM.clickDashboard().click();						//Clicking on Dashboard link. 
			
			Thread.sleep(500);
			wait.until(ExpectedConditions.visibilityOf(OverduePOM.clickStatutoryRejected()));
			
			String string_rejectedNew = null;
			int rejectedNew = 0;
			
			if(Compliance.equalsIgnoreCase("Statutory"))					//Going for statutory click
			{
				string_rejectedNew = OverduePOM.clickStatutoryRejected().getText();	//Storing new value of Statutory Reject.
				rejectedNew = Integer.parseInt(string_rejectedNew);
			}
			else															//Going for Internal click
			{
				string_rejectedNew = OverduePOM.clickInternalRejected().getText();	//Storing old value of Internal Reject.
				rejectedNew = Integer.parseInt(string_rejectedNew);
			}
			if(rejectedNew == count1)
			{
				test.log(LogStatus.PASS, "After Perform ("+ Compliance +"):- Compliances count matches to Dashboard count. Total Compliances count in the grid = " + count1 + " | Total Compliances count on Dashboard = " + rejectedNew);
			}
			else
			{
				test.log(LogStatus.FAIL, "After Perform ("+ Compliance +"):- Compliances count doesn't matches to Dashboard count. Total Compliances count in the grid = " + count1 + " | Total Compliances count on Dashboard = " + rejectedNew);
			}
		}
		else
		{
			test.log(LogStatus.SKIP, Compliance +" Rejected count = "+rejected);
		}
	}
	
	static void AssignTask( String task) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), 20);
		
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(OverduePOM.clickComplianceLocation()));
		OverduePOM.clickComplianceLocation().click();	//Clicking on 'Compliance Location' text box
		Thread.sleep(500);
		CFOcountPOM.clickInternalSubmenu1().click();	//Clicking on first sub menu
		Thread.sleep(500);
		OverduePOM.SelectCheckBox().click();			//Clicking on second sub menu checkbox
		CFOcountPOM.clickInternalSubmenu2().click();	//Clicking on second sub menu name to close filter
		
		Thread.sleep(1000);
		OverduePOM.clickReportingLocation().click();	//Clicking on 'Reporting Location' text box
		elementsList = OverduePOM.clickSubLoacations();	//Getting all sub locations
		Thread.sleep(500);
		elementsList.get(0).click();						//Clicking on first sub location
		Thread.sleep(500);
		elementsList.get(1).click();						//Clicking on second sub location
		
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(OverduePOM.clickStartDate()));
		OverduePOM.clickStartDate().click();			//Clicking on Start Date text box
		OverduePOM.selectLastMonth().click();			//Clicking on arrow to get last month
		OverduePOM.selectDate().click();				//Clicking the actual date on calendar
		
		Thread.sleep(1000);
		//wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.clickSelectPerformer()));
		OverduePOM.clickSelectPerformer().click();	//Clicking the Performer drop down
		Thread.sleep(1000);
		OverduePOM.clickSearchedUser1().click();		//Clicking the first index user
		
		Thread.sleep(1000);
		//wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.clickSelectReviewer()));
		OverduePOM.clickSelectReviewer().click();		//Clicking the Performer drop down
		Thread.sleep(1000);
		if(task.equalsIgnoreCase("Main"))
			OverduePOM.clickSearchedUser2().click();		//Clicking the first index user
		else
			OverduePOM.clickSearchedUser1().click();		//Clicking the first index user
		
		Thread.sleep(700);
		OverduePOM.clickSaveButton1().click();		//Clicking on Save Button.
	}
	
	static void AddTask( XSSFWorkbook workbook, int row, String compliance) throws InterruptedException
	{
		sheet = workbook.getSheetAt(3);					//Retrieving fourth sheet of Workbook(Named - Update Tasks)
		
		Thread.sleep(500);
		Row row0 = sheet.getRow(row);					//Selected 0th index row (First row)
		Cell c1 = null;
		if(compliance.equalsIgnoreCase("Internal"))		//If Task is of Internal
			c1 = row0.getCell(3);						//Selected cell (0 row,3 column)	(3 column = fourth column)
		else
			c1 = row0.getCell(2);						//Selected cell (0 row,2 column)	(2 column = third column)
		OverduePOM.clickTaskTitle().sendKeys(c1.getStringCellValue());	//Writing Task title
		
		row0 = sheet.getRow(1);							//Selected 1st index row (Second row)
		c1 = row0.getCell(2);							//Selected cell (1 row,2 column)
		OverduePOM.clickDescription().sendKeys(c1.getStringCellValue());	//Writing description
		
		row0 = sheet.getRow(2);							//Selected 2nd index row (Third row)
		c1 = row0.getCell(2);							//Selected cell (2 row,2 column)
		int day = (int) c1.getNumericCellValue();
		OverduePOM.clickDueDay().sendKeys(""+day+"");	//Writing Due days
		
		Thread.sleep(1000);
		OverduePOM.clickConditionCheckbox().click();	//Clicking on 'Is Task Conditional' checkbox
		
		row0 = sheet.getRow(3);							//Selected 3rd index row (Fourth row)
		c1 = row0.getCell(2);							//Selected cell (3 row,2 column)
		OverduePOM.clickConditionalMessage().sendKeys(c1.getStringCellValue());	//Writing condition message
		
		row0 = sheet.getRow(4);							//Selected 4th index row (Fifth row)
		c1 = row0.getCell(2);							//Selected cell (4 row,2 column)
		OverduePOM.clickYesMsg().sendKeys(c1.getStringCellValue());	//Writing message in 'Yess message' text box
		
		row0 = sheet.getRow(5);							//Selected 5th index row (Sixth row)
		c1 = row0.getCell(2);							//Selected cell (5 row,2 column)
		OverduePOM.clickNoMsg().sendKeys(c1.getStringCellValue());	//Writing message in 'No message' text box
	}

	public static void UpdateTask( ExtentTest test, XSSFWorkbook workbook, String Compliance) throws InterruptedException
	{
		//-------------------------------Create Main Task--------------------------------------
		
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(getDriver(), 20);
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@onclick='CheckProduct();']")));	//Waiting for 'My Workspace' link to be visible.
		OverduePOM.clickMyWorkspace1().click();		//Clicking on 'My Workspace'
		
		Thread.sleep(500);
		OverduePOM.clickCompliance().click();			//Clicking on 'Compliance' under My Workspace
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@role='grid'][@data-role='selectable'])[1]")));	//Waiting for records table to get visible.
		
		OverduePOM.clickMoreActions().click();				//Clicking on 'More Actions' drop down.
		
		Thread.sleep(500);
		elementsList = OverduePOM.selectAction();				//Getting all 'More Action' drop down option
		elementsList.get(4).click();								//Clicking on fifth option "Update Tasks"
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ContentPlaceHolder1_grdTaskPerformer']")));	//Waiting for records table to get visible
		
		Thread.sleep(500);
		OverduePOM.ClickTaskCreation().click();				//Clicking on 'Task Creation' tab
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ContentPlaceHolder1_grdTask']")));	//Waiting for records table to get visible
		
		int total = Integer.parseInt(OverduePOM.readReminder1().getText());	//Reading total records displayed
		
		OverduePOM.clickAddNew1().click();					//Clicking on 'Add New' button
		
		wait.until(ExpectedConditions.invisibilityOf(OverduePOM.clickAddNew1()));		//Waiting for Add New button to get invisible. 
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.clickInternaRadioButton()));
		try
		{
			if(Compliance.equalsIgnoreCase("Internal"))
			{
				test.log(LogStatus.INFO, "------------- Internal -------------");
				
				OverduePOM.clickInternaRadioButton().click();	//Clicking on Radio button of 'Internal' tasks
				Thread.sleep(500); 
				Select drp = new Select(OverduePOM.clickInternalCompliance());
				drp.selectByIndex(1);
			}
			else
			{
				test.log(LogStatus.INFO, "------------- Statutory -------------");
				
				OverduePOM.clickActFilter().click();					//Clicking on 'Act Filter' drop down.
				Select drp = new Select(OverduePOM.clickActFilter());
				drp.selectByIndex(2);										//Selecting third Act
				
				Thread.sleep(1000);
				wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.clickComplianceDropDown()));
				OverduePOM.clickComplianceDropDown().click();			//Clicking on 'Compliance' drop down.
				drp = new Select(OverduePOM.clickComplianceDropDown());
				drp.selectByIndex(1);										//Selecting first Act	
			}
		}
		catch(Exception e)
		{
			
		}
		
		AddTask( workbook, 0, Compliance);								//0 - indicates Main Task Name row in sheet
		
		Thread.sleep(1000);
		//wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.clickTaskType()));
		OverduePOM.clickTaskType().click();		//Clicking on Task Type drop Down.
		Select drp = new Select(OverduePOM.clickTaskType());
		drp.selectByIndex(3);							//Selecting fourth option
		
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");	//Scrolling down window by 2000 px.
		
		OverduePOM.clickSubTaskType().click();	//Clicking on Sub Task Type drop Down.
		drp = new Select(OverduePOM.clickSubTaskType());
		drp.selectByIndex(1);
		
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.clickIsAfter()));
		OverduePOM.clickIsAfter().click();		//Clicking on Is After/Before drop Down.
		drp = new Select(OverduePOM.clickIsAfter());
		drp.selectByIndex(1);							//Selecting 'After' option
		
		Thread.sleep(1500);
		String workingDir = System.getProperty("user.dir");
		OverduePOM.SampleFormUpload().sendKeys(workingDir+"//Reports//PerformerResults.html");
		
		Thread.sleep(1000);
		OverduePOM.clickSaveButton().click();		//Clicking on 'Save' Button
		
		Thread.sleep(500);
		String saveMsg = OverduePOM.taskSavedMsg().getText();
		OverduePOM.taskSavedMsg().click();
		
		if(saveMsg.equalsIgnoreCase("Task Saved Successfully."))
		{
			test.log(LogStatus.INFO, "Message displayed - 'Task Saved Successfully'");
		}
		else
		{
			test.log(LogStatus.INFO, "Message displayed - 'Task already exist.'");
		}
		
		Thread.sleep(1000);
		OverduePOM.closeUpdateTasks().click();	//Closing the Update Tasks form.
		
		Thread.sleep(1000);
		int total1 = Integer.parseInt(OverduePOM.readReminder().getText());	//Reading total records displayed
		
		if(total1 > total)
		{
			test.log(LogStatus.PASS, "New Task added and displayed successfully.");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Task doesn't added and displayed.");
		}
		
		//-------------------------------Create Sub Task--------------------------------------
		
		Thread.sleep(1500);
		OverduePOM.clickShow().click();						//Clicking on Show dropdown
		Select select = new Select(OverduePOM.clickShow());
		select.selectByIndex(3);									//Selecting 50
		
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,2000)");		//Scrolling down window by 2000 px.
		elementsList1 = OverduePOM.clickSubTask();	//Getting all Sub Task elements list
		int no = elementsList1.size();
		
		Thread.sleep(1000);
		elementsList1.get(no-1).click();
		
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(OverduePOM.clickAddNew2()));	//Wait till 'Add New' button gets visible in Sub Task
		OverduePOM.clickAddNew2().click();			//Clicking on 'Add New' in Sub Task.
		
		Thread.sleep(1500);
		Actions action = new Actions(getDriver());
		//action.moveToElement(OverduePOM.selectAllCheckbox()).click().perform();	//Clicking on Select All check box in Task Mapping
		action.moveToElement(OverduePOM.OK()).click().perform();	//Clicking on OK button
		//OverduePOM.clickTaskMapping().click();		//Clicking on Task Mapping text box								
				
		AddTask( workbook, 6, Compliance);						//6 - indicates Sub Task Name row in sheet
				
		Thread.sleep(1500);			
		OverduePOM.SampleFormUpload().sendKeys(workingDir+"//Reports//PerformerResults.html");
		
		Thread.sleep(1000);
		OverduePOM.clickSaveButton().click();			//Clicking on 'Save' Button
			
		Thread.sleep(500);
		saveMsg = OverduePOM.taskSavedMsg().getText();	//Msg = Subtask Saved Successfully.
		
		test.log(LogStatus.INFO, "Message displayed - '"+ saveMsg +"'");
			
		OverduePOM.closeUpdateTasks().click();		//Closing the Sub Task form.
		
		try
		{
			Thread.sleep(700);
			if(OverduePOM.checkRecordsTable().isDisplayed())
			{
				test.log(LogStatus.PASS, "New Sub Task added and displayed successfully.");
			}
			else
			{
				test.log(LogStatus.FAIL, "New Sub Task doesn't added and displayed.");
			}
		}
		catch(Exception e)
		{
			
		}
		
		Thread.sleep(700);
		OverduePOM.clickMainTaskLink().click();		//CLicking on Main Task name to get back from sub task.
		
		//--------------------------Assign Main Task --------------------------
		
		Thread.sleep(1500);
		OverduePOM.clickShow().click();				//Clicking on Show dropdown
		select = new Select(OverduePOM.clickShow());
		select.selectByIndex(3);							//Selecting 50
		
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,2000)");		//Scrolling down window by 2000 px.
		
		elementsList = OverduePOM.clickAssignTask();	//Getting all Assign buttons
		int n = elementsList.size();
		System.out.println("Assign Main Tasks - "+n);
		elementsList.get(n-1).click();						//Clicking on newly added task's assign button (last button)
		
		AssignTask( "Main");							//Calling assign Task Method
		
		Thread.sleep(1500);
		try
		{
			if(!OverduePOM.checkRecordsTable1().isDisplayed())
			{
				test.log(LogStatus.FAIL, "Main task doesn't assigned to user");
			}
			else
			{
				test.log(LogStatus.PASS, "Main task assigned to user");
			}
		}
		catch(Exception e)
		{
			
		}
		
		OverduePOM.closeUpdateTasks1().click();	//Closing the Assign Compliance form.
		
		//----------------------------Assign Sub Task-----------------------------
		
		Thread.sleep(1500);
		OverduePOM.clickShow().click();				//Clicking on Show dropdown
		select = new Select(OverduePOM.clickShow());
		select.selectByIndex(3);							//Selecting 50
		
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,1500)");		//Scrolling down window by 2000 px.
		elementsList1 = OverduePOM.clickSubTask();	//Getting all Sub Task elements list
		no = elementsList1.size();
		elementsList1.get(no-1).click();
		
		Thread.sleep(700);
		js.executeScript("window.scrollBy(0,700)");			//Scrolling down window by 2000 px.
		
		elementsList = OverduePOM.clickAssignTask();	//Getting all Assign buttons
		n = elementsList.size();
		elementsList.get(n-1).click();						//Clicking on newly added task's assign button (last button)
		
		AssignTask( "Sub");
			
		Thread.sleep(1500);
			
		if(!OverduePOM.checkRecordsTable().isDisplayed())
		{
			test.log(LogStatus.FAIL, "Sub task doesn't assigned to user");
		}
		else
		{
			test.log(LogStatus.PASS, "Sub task assigned to user");
		}
		
		OverduePOM.closeUpdateTasks1().click();		//Closing the Sub Task assignment form.
		Thread.sleep(1000);
	}
	
	static void EventBased_Statutory() throws InterruptedException
	{
		Thread.sleep(1000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,800)");					//Scrolling down window by 2600 px.
		
		OverduePOM.selectStatutoryDropdown().click();
		Select drp = new Select(OverduePOM.selectStatutoryDropdown());
		drp.selectByIndex(1);
		
		WebDriverWait wait = new WebDriverWait(getDriver(), 60);
		Thread.sleep(1000);
		if(OverduePOM.complianceDocLink().isEnabled())
		{
			Thread.sleep(500);
			wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.complianceDocLink()));
			OverduePOM.complianceDocLink().sendKeys("www.google.com");	//Providing Compliance Documents link
			Thread.sleep(300);
			OverduePOM.buttonAddLink().click();						//Clicking on 'Add Link' button of Compliance Documents
		}
		else
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='fuSampleFile']")));	//Waiting till upload button get visible.
			String workingDir = System.getProperty("user.dir");
			OverduePOM.fileUploadStatutory1().sendKeys(workingDir+"//Reports//PerformerResults.html");	//Uploading file by sending file to Upload Button.
		}
		
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,800)");					//Scrolling down window by 2600 px.
		
		OverduePOM.selectDateStatutory().click();				//Clicking on date input box
		OverduePOM.selectLastMonth().click();					//Clicking on Last month arrow
		Thread.sleep(500);
		OverduePOM.selectDate().click();						//Clicking on date at second row and fourth column
	}
	
	public static void MyCalendarCompliance( ExtentTest test) throws InterruptedException
	{
		Thread.sleep(500);
		WebDriverWait wait = new WebDriverWait(getDriver(), 60);
		wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.clickStatutoryChecklist()));
		int oldStatutoryChecklistValue = Integer.parseInt(OverduePOM.clickStatutoryChecklist().getText());	//Storing old value of Statutory Checkilist.
		int oldOverdueStatutoryValue = Integer.parseInt(OverduePOM.clickStatutoryOverdue().getText());
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,650)");					//Scrolling down window by 2600 px.
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='badge badge-warning overdue'])[1]")));	//Waiting till the cornered count of compliance get visible.
		Thread.sleep(300);
		CFOcountPOM.readDateComliance().click();					//Clicking on the compliance value on top corner
		elementsList = CFOcountPOM.clickDateCalendar1();			//Getting all red compliances
		elementsList.get(0).click();							//Clicking on first Red Compliance of the calendar.		
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("calframe"));
		
		Thread.sleep(500);
		elementsList1 = OverduePOM.readCalendarCompType1();		//Getting all values of compliance Type 
		int n = elementsList1.size();
		String type = null;
		int notify = 0;
		int i;
		for(i = 0; i < n; i++)
		{
			elementsList1 = OverduePOM.readCalendarCompType1();
			type = elementsList1.get(i).getText();					//Reading name of Compliance Type
			if(type.contains("Statutory"))							//We will perform only Statutory compliances.
			{
				notify = 1;											//If compliance id Statutory then 1.
				break;
			}
			if(i == n-1)
			{
				if(CFOcountPOM.clickNextPage1().isEnabled())
				{
					CFOcountPOM.clickNextPage1().click();
					Thread.sleep(300);
					i = -1;
				}
			}
		}
		
		System.out.println(type);
		
		if(notify == 1)												//If Statutory compliance found.
		{
			elementsList = OverduePOM.clickCalenderAction();			//Getting all Action buttons
			wait.until(ExpectedConditions.visibilityOf(elementsList.get(0)));
			Thread.sleep(200);
			elementsList.get(i).click();							//Clicking on ith Action Button which is Statutory
			
			getDriver().switchTo().parentFrame();
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
			
			int flag = 0;
			if(type.equalsIgnoreCase("Statutory CheckList"))
			{
				test.log(LogStatus.INFO, "Checklist - Statutory compliance");
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_iChecklistPerformerFrame"));
				
				js.executeScript("window.scrollBy(0,800)");
				
				Thread.sleep(1000);
				if(OverduePOM.statutoryComplianceDoc().isEnabled())
				{
					Thread.sleep(500);
					wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.statutoryComplianceDoc()));
					OverduePOM.statutoryComplianceDoc().sendKeys("www.google.com");	//Providing Compliance Documents link
					Thread.sleep(300);
					OverduePOM.statutoryAddLinkButton().click();						//Clicking on 'Add Link' button of Compliance Documents
				}
				else
				{
					String workingDir = System.getProperty("user.dir");	
					try
					{
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='fuSampleFile']")));	//Waiting till upload button get visible.
						
						OverduePOM.fileUploadStatutory1().sendKeys(workingDir+"//TestData//ComplianceSheet.xlsx");	//Uploading file by sending file to Upload Button.
					}
					catch(Exception e)
					{
						
					}
					
					try
					{
						OverduePOM.fileUploadStatutory().sendKeys(workingDir+"//TestData//PerformerResults.xlsx");	//Uploading file by sending file to Upload Button.
					}
					catch(Exception e)
					{
						
					}
				}
				
				Thread.sleep(1000);
				js.executeScript("window.scrollBy(0,800)");					//Scrolling down window by 2600 px.
				
				flag = 1;
			}
			else if(type.equalsIgnoreCase("Event Based"))
			{
				test.log(LogStatus.INFO, "Overdue - Statutory Event Based compliance");
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_iPerformerFrame"));
				
				Thread.sleep(500);
				
				EventBased_Statutory();								//Calling Method
				
				flag = 2;
			}
			else if(type.equalsIgnoreCase("Statutory"))
			{
				test.log(LogStatus.INFO, "Overdue - Statutory compliance");
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_iPerformerFrame"));
				
				Thread.sleep(500);
				
				EventBased_Statutory();								//Calling method
				flag = 2;
			}
			js.executeScript("window.scrollBy(0,400)");						//Scrolling down window by 2600 px.
			
			Thread.sleep(1000);
			OverduePOM.remark().sendKeys("Automation Testing");		//Sending Remark
				
			Thread.sleep(1000);
			OverduePOM.clickComplianceSubmit().click();				//Click on Submit button.
				
			Thread.sleep(500);
			getDriver().switchTo().alert().accept();								//Accepting msg of Successful Submittion.
			getDriver().switchTo().parentFrame();								//Switching back to parent frame from iFrame
			getDriver().switchTo().parentFrame();								//Switching back to parent frame from iFrame
			
			Thread.sleep(1000);
			OverduePOM.clickDashboard().click();						//Clicking on Dashboard
			
			Thread.sleep(500);
			wait.until(ExpectedConditions.visibilityOf(OverduePOM.clickStatutoryChecklist()));
			int newValue = 0;
			if(flag == 1)
			{
				newValue = Integer.parseInt(OverduePOM.clickStatutoryChecklist().getText());	//Storing new value of Statutory Checkilist.
				
				if(newValue < oldStatutoryChecklistValue)
				{
					test.log(LogStatus.PASS, "Statutory CheckList count decreased. Old count = "+oldStatutoryChecklistValue+ " | New count = "+newValue);
				}
				else
				{
					test.log(LogStatus.FAIL, "Statutory CheckList count doesn't decreased. Old count = "+oldStatutoryChecklistValue+ " | New count = "+newValue);
				}
			}
			else if(flag == 2)
			{
				newValue = Integer.parseInt(OverduePOM.clickStatutoryOverdue().getText());	//Storing new value of Statutory Checkilist.
				
				if(newValue < oldOverdueStatutoryValue)
				{
					test.log(LogStatus.PASS, "Overdue count decreased. Old count = "+oldOverdueStatutoryValue+ " | New count = "+newValue);
				}
				else
				{
					test.log(LogStatus.FAIL, "Overdue count doesn't decreased. Old count = "+oldOverdueStatutoryValue+ " | New count = "+newValue);
				}
			}
		}
		else
		{
			test.log(LogStatus.INFO, "Statutory Compliance didn't found. Skipping the test.");
		}
	}
	
	public static void UpdateLeave( ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), 20);
		wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.clickMyWorkspace()));	//Waiting for 'My Workspace' link to be visible.
		OverduePOM.clickMyWorkspace().click();		//Clicking on 'My Workspace'
		
		Thread.sleep(500);
		OverduePOM.clickCompliance().click();			//Clicking on 'Compliance' under My Workspace
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@role='grid'][@data-role='selectable'])[1]")));	//Waiting for records table to get visible.
		
		OverduePOM.clickMoreActions().click();				//Clicking on 'More Actions' drop down.
		
		Thread.sleep(500);
		elementsList = OverduePOM.selectAction();				//Getting all 'More Action' drop down option
		elementsList.get(4).click();								//Clicking on fifth option "Update Leave"
		
		int total = Integer.parseInt(OverduePOM.readReminder().getText());	//Reading total records displayed
		
		OverduePOM.clickAddNew1().click();					//Clicking on 'Add New' button
		
		Thread.sleep(500);
		OverduePOM.clickStartDate1().click();					//Clicking on Start Date input box 
		OverduePOM.selectNextMonth().click();					//Clicking on Next Month arrow.
		Thread.sleep(500);
		OverduePOM.selectDate().click();						//Clicking on date of second row and fourth column
		
		Thread.sleep(500);
		OverduePOM.clickEndDate().click();					//Clicking on Start Date input box 
		OverduePOM.selectNextMonth().click();					//Clicking on Next Month arrow.
		Thread.sleep(500);
		OverduePOM.selectDate2().click();						//Clicking on date of second row and fifth column
		
		Thread.sleep(500);
		OverduePOM.selectNewPerformer().click();				//Clicking on New Performer drop down
		Select drp = new Select(OverduePOM.selectNewPerformer());
		drp.selectByIndex(1);										//Selecting first performer user.
		
		Thread.sleep(500);
		OverduePOM.selectNewReviewer().click();				//Clicking on New Performer drop down
		drp = new Select(OverduePOM.selectNewReviewer());
		drp.selectByIndex(1);										//Selecting first reviewer user.
		
		Thread.sleep(500);
		OverduePOM.selectNewEventOwner().click();				//Clicking on New Performer drop down
		drp = new Select(OverduePOM.selectNewEventOwner());
		drp.selectByIndex(1);										//Selecting first event owner user.
		
		Thread.sleep(500);
		OverduePOM.clickSaveButton().click();
		
		Thread.sleep(500);
		try
		{
			wait.until(ExpectedConditions.invisibilityOf(OverduePOM.progressGIF()));	//Waiting till progress gif goes off
		}
		catch(Exception e)
		{
			
		}
		String msg = OverduePOM.readMsgLeave().getText();
		test.log(LogStatus.INFO, "Message Diplayed - "+msg);
		
		Thread.sleep(500);
		OverduePOM.closeLeave().click();						//Closing the Leave window.
		
		Thread.sleep(500);
		int total1 = Integer.parseInt(OverduePOM.readReminder().getText());	//Reading total records displayed
		
		if(total1 > total)
		{
			test.log(LogStatus.PASS, "Leave request displayed.");
		}
		else
		{
			test.log(LogStatus.FAIL, "New leave request not added - '"+msg+"'"); 
		}
		
		Thread.sleep(500);
		OverduePOM.clickDashboard().click();					//Clicking on Dashboard
	}
	
	public static void UpcomingCompliance( ExtentTest test, String Compliance) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), 20);
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.clickUpcomingStatutory()));	//Waiting for 'Upcoming Statutory' count to be clickable.
		
		int pendingCount = 0;
		int upcomingStatutory = 0;
		int pendingCountInternal = 0;
		int upcomingInternal = 0;
		
		if(Compliance.equalsIgnoreCase("Statutory"))
		{
			pendingCount = Integer.parseInt(OverduePOM.readPendingReviewStatutory().getText());	//Reading old Pending for Review Count (Statutory)
			Thread.sleep(100);
			upcomingStatutory = Integer.parseInt(OverduePOM.clickUpcomingStatutory().getText());	//Reading Upcoming Statutory count
			
			OverduePOM.clickUpcomingStatutory().click();					//Clicking on Upcoming Statutory count.
		}
		else
		{
			pendingCountInternal = Integer.parseInt(OverduePOM.readPendingReviewInternal().getText());
			upcomingInternal = Integer.parseInt(OverduePOM.clickUpcomingInternal().getText());
			
			OverduePOM.clickUpcomingInternal().click();					//Clicking on Upcoming Statutory count.
		}
		
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.checkTable()));	//Waiting for records table to get displayed.
		
		Thread.sleep(500);
		getDriver().findElement(By.xpath("//div[@class = 'k-multiselect-wrap k-floatwrap']")).click();
		
		Thread.sleep(500);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,2000)");						//Scrolling down window by 2600 px.
		
		OverduePOM.clickAdvancedSearch().sendKeys(Keys.PAGE_DOWN);
		OverduePOM.clickAdvancedSearch().sendKeys(Keys.PAGE_DOWN);
		OverduePOM.clickAdvancedSearch().sendKeys(Keys.PAGE_DOWN);
		
		Thread.sleep(2000);
		CFOcountPOM.readTotalItems1().click();
		String item1 = CFOcountPOM.readTotalItems1().getText();
		String[] bits1 = item1.split(" ");								//Splitting the String
		
		if(bits1.length > 2)
		{
			Thread.sleep(2000);
			CFOcountPOM.readTotalItems1().click();
			item1 = CFOcountPOM.readTotalItems1().getText();
			bits1 = item1.split(" ");								//Splitting the String
		}
		String compliancesCount1 = bits1[bits1.length - 2];				//Getting the second last word (total number of users)
		
		if(compliancesCount1.equalsIgnoreCase("to"))
		{
			Thread.sleep(2000);
			item1 = CFOcountPOM.readTotalItems1().getText();
			bits1 = item1.split(" ");									//Splitting the String
			compliancesCount1 = bits1[bits1.length - 2];
		}
		int count = Integer.parseInt(compliancesCount1);
		if(Compliance.equalsIgnoreCase("Statutory"))
		{
			if(upcomingStatutory == count)
			{
				test.log(LogStatus.PASS, "Before Perform :- Upcoming Statutory count matches to total number of compliances displayed.");
				test.log(LogStatus.INFO, "Total Compliance Count in the Grid = "+count+" | Dashboard Compliance Count = "+upcomingStatutory);
			}
			else
			{
				test.log(LogStatus.FAIL, "Before Perform :- Upcoming Statutory count does not matches to total number of compliances displayed.");
				test.log(LogStatus.INFO, "Total Compliance Count in the Grid = "+count+" | Dashboard Compliance Count = "+upcomingStatutory);
			}
		}
		else
		{
			if(upcomingInternal == count)
			{
				test.log(LogStatus.PASS, "Before Perform :- Upcoming Internal count matches to total number of compliances displayed.");
				test.log(LogStatus.INFO, "Total Compliance Count in the Grid = "+count+" | Dashboard Compliance Count = "+upcomingInternal);
			}
			else
			{
				test.log(LogStatus.FAIL, "Before Perform :- Upcoming Internal count does not matches to total number of compliances displayed.");
				test.log(LogStatus.INFO, "Total Compliance Count in the Grid = "+count+" | Dashboard Compliance Count = "+upcomingInternal);
			}
		}
		
		elementsList1 = OverduePOM.clickCalenderAction();	//Getting all action buttons (Statutory/Internal)
		elementsList1.get(0).click();					//Clicking on ith action button which has blue status 
		
		if(Compliance.equalsIgnoreCase("Statutory"))
		{
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("iPerformerFrame"));
			Thread.sleep(500);
			js.executeScript("window.scrollBy(0,550)");					//Scrolling down window by 2600 px.
			
			Thread.sleep(500);
			Select status = new Select(OverduePOM.selectStatutoryDropdown());	//Selecting dropdown box
			int k = status.getOptions().size();
			System.out.println("Options = "+ k);
			if(k > 1)
			{
				status.selectByIndex(1);
			}
			
			if(OverduePOM.complianceDocLink().isEnabled())
			{
				Thread.sleep(2000);
				wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.complianceDocLink()));
				OverduePOM.complianceDocLink().sendKeys("www.google.com");	//Providing Compliance Documents link
				OverduePOM.buttonAddLink().click();						//Clicking on 'Add Link' button of Compliance Documents
				Thread.sleep(1000);
			}
			else
			{
				String workingDir = System.getProperty("user.dir");			//Getting current user directory.
				OverduePOM.fileUploadStatutory1().sendKeys(workingDir+"//Reports//PerformerResults.html");	//Uploading file by sending file to Upload Button.
			}
			
			js.executeScript("window.scrollBy(0,600)");					//Scrolling down window by 2600 px.
			
			Thread.sleep(500);
			OverduePOM.selectDateStatutory().click();				//Clicking on Date input box
			OverduePOM.selectLastMonth().click();					//Clicking on Last Month arrow
			Thread.sleep(500);
			OverduePOM.selectDate2().click();						//Clicking on date
			
			try
			{
				Thread.sleep(500);
				OverduePOM.valueSystem().sendKeys("100");				//Sending Value as per system.
				Thread.sleep(500);
				OverduePOM.valueReturn().sendKeys("50");				//Sending Value as per return.
			}
			catch(Exception e)
			{
				
			}
			
			wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.remark()));
			OverduePOM.remark().sendKeys("Automation Remark");	//Sending remark to text area.
		}
		else
		{
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("iInternalPerformerFrame"));
			Thread.sleep(500);
			js.executeScript("window.scrollBy(0,550)");					//Scrolling down window by 2600 px.
			
			Thread.sleep(500);
			Select status = new Select(OverduePOM.selectInternalDropdown());	//Selecting dropdown box
			int k = status.getOptions().size();
			System.out.println("Options = "+ k);
			if(k > 1)
			{
				status.selectByIndex(1);
			}
			
			if(OverduePOM.complianceDocLinkInternal().isEnabled())
			{
				Thread.sleep(1000);
				js.executeScript("window.scrollBy(0,700)");					//Scrolling down window by 2600 px.
				
				wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.complianceDocLinkInternal()));
				OverduePOM.complianceDocLinkInternal().sendKeys("www.google.com");	//Providing Compliance Documents link
				OverduePOM.buttonAddLinkInternal().click();						//Clicking on 'Add Link' button of Compliance Documents
				Thread.sleep(1000);
			}
			else
			{
				String workingDir = System.getProperty("user.dir");			//Getting current user directory.
				OverduePOM.fileUploadInternal().sendKeys(workingDir+"//Reports//PerformerResults.html");	//Uploading file by sending file to Upload Button.
			}
			
			js.executeScript("window.scrollBy(0,600)");					//Scrolling down window by 2600 px.
			
			Thread.sleep(500);
			OverduePOM.selectDateInternal().click();				//Clicking on Date input box
			OverduePOM.selectLastMonth().click();					//Clicking on Last Month arrow
			Thread.sleep(500);
			OverduePOM.selectDate2().click();						//Clicking on date
			
			wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.clickInternalRemark()));
			OverduePOM.clickInternalRemark().sendKeys("Automation Remark");	//Sending remark to text area.
		}
		
		Thread.sleep(500);
		OverduePOM.clickComplianceSubmit().click();			//Clicking on 'Submit' button.

		Thread.sleep(1000);
		try
		{
			getDriver().switchTo().alert().accept();
		}
		catch(Exception e)
		{
			
		}
		try
		{
			getDriver().switchTo().alert().dismiss();
		}
		catch(Exception e)
		{
			
		}
		
		Thread.sleep(500);
		getDriver().switchTo().parentFrame();
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.clickDashboard()));
		OverduePOM.clickDashboard().click();					//Clicking on 'Dashboard'
		
		Thread.sleep(1000);
		if(Compliance.equalsIgnoreCase("Statutory"))
		{
			int pendingcount1 = Integer.parseInt(OverduePOM.readPendingReviewStatutory().getText());	//Reading new Pending for Review Count (Statutory)
			int upcomingStatutoryNew = Integer.parseInt(OverduePOM.clickUpcomingStatutory().getText());
			
			if(upcomingStatutory > upcomingStatutoryNew)
			{
				test.log(LogStatus.PASS, "After Perform :- 'Upcoming' Statutory count decreased.");
				test.log(LogStatus.INFO, "Old Compliance Count = "+upcomingStatutory+" | New Compliance Count = "+upcomingStatutoryNew);
			}
			else
			{
				test.log(LogStatus.FAIL, "After Perform :- 'Upcoming' Statutory count doesn't decreased.");
				test.log(LogStatus.INFO, "Old Compliance Count = "+upcomingStatutory+" | New Compliance Count = "+upcomingStatutoryNew);
			}
			
			if(pendingcount1 > pendingCount)
			{
				test.log(LogStatus.PASS, "After Perform :- 'Pending for Review' Statutory count increased.");
				test.log(LogStatus.INFO, "Old Compliance Count = "+pendingCount+" | New Compliance Count = "+pendingcount1);
			}
			else
			{
				test.log(LogStatus.FAIL, "After Perform :- 'Pending for Review' Statutory count doesn't increased.");
				test.log(LogStatus.INFO, "Old Compliance Count = "+pendingCount+" | New Compliance Count = "+pendingcount1);
			}
		}
		else
		{
			int pendingcount1 = Integer.parseInt(OverduePOM.readPendingReviewInternal().getText());	//Reading new Pending for Review Count (Statutory)
			int upcomingInternalNew = Integer.parseInt(OverduePOM.clickUpcomingInternal().getText());
			
			if(upcomingInternal > upcomingInternalNew)
			{
				test.log(LogStatus.PASS, "After Perform :- 'Upcoming' Internal count decreased.");
				test.log(LogStatus.INFO, "Old Compliance Count = "+upcomingInternal+" | New Compliance Count = "+upcomingInternalNew);
			}
			else
			{
				test.log(LogStatus.FAIL, "After Perform :- 'Upcoming' Internal count doesn't decreased.");
				test.log(LogStatus.INFO, "Old Compliance Count = "+upcomingInternal+" | New Compliance Count = "+upcomingInternalNew);
			}
			
			if(pendingcount1 > pendingCountInternal)
			{
				test.log(LogStatus.PASS, "After Perform :- 'Pending for Review' Internal count increased.");
				test.log(LogStatus.INFO, "Old Compliance Count = "+pendingCountInternal+" | New Compliance Count = "+pendingcount1);
			}
			else
			{
				test.log(LogStatus.FAIL, "After Perform :- 'Pending for Review' Internal count doesn't increased.");
				test.log(LogStatus.INFO, "Old Compliance Count = "+pendingCountInternal+" | New Compliance Count = "+pendingcount1);
			}
		}
	}

	public static void WorkspaceOverdueStatutory( ExtentTest test)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), 60);
		Thread.sleep(500);
		OverduePOM.clickMyWorkspace().click();		//Clicking on 'My Workspace'
		
		Thread.sleep(500);
		OverduePOM.clickCompliance().click();			//Clicking on 'Compliance' under My Workspace
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@role='grid'][@data-role='selectable'])[1]")));	//Waiting for records table to get visible.
		
		Thread.sleep(1000);
		OverduePOM.clickUserDropDown().click();		//Clicking on User DropDown
		Thread.sleep(300);
		OverduePOM.clickPerformer().click();			//CLicking on Performer under User DropDown.
		
		Thread.sleep(500);
		OverduePOM.selectType().click();				//Clicking on Overdue dropdown
		Thread.sleep(300);
		OverduePOM.clickStatutory().click();			//Clicking on 'Statutory' under Overdue dropdown
		
		Thread.sleep(500);
		OverduePOM.selectStatus().click();			//Clicking on Status dropdown
		Thread.sleep(500);
		OverduePOM.clickOverdue().click();			//Clicking on 'Overdue' under Status dropdown
		
		Thread.sleep(1000);
		litigationAdditionalOwner.MethodsPOM.progress();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@role='grid'][@data-role='selectable'])[1]")));	//Waiting for records table to get visible.
		
		StatutoryOverdue();							//Called the Method of Dashboard Statutory Overdue.
		
		Thread.sleep(1000);		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,2000)");
		
		CFOcountPOM.readTotalItems1().click();
		Thread.sleep(500);
		String item = CFOcountPOM.readTotalItems1().getText();
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		int count = Integer.parseInt(compliancesCount);
				
		Thread.sleep(1000);
		OverduePOM.clickDashboard().click();						//Clicking on Dashboard link.
		
		Thread.sleep(500);
		OverdueCount.message();
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOf(OverduePOM.clickStatutoryOverdue()));
		String string_overdueStatutory = OverduePOM.clickStatutoryOverdue().getText();		//Storing old value of Statutory overdue.
		int overdueStatutory = Integer.parseInt(string_overdueStatutory);
			
		if(overdueStatutory == count)
		{
			test.log(LogStatus.PASS, "My Workspace - Statutory Overdue count matches to Dashboard Statutory Overdue count.");
			test.log(LogStatus.INFO, "My Workspace - Statutory Overdue count = " + count + " | Dashboard Statutory Overdue count = "+overdueStatutory); 
		}
		else
		{
			test.log(LogStatus.FAIL, "My Workspace - Statutory Overdue count doen not matches to Dashboard Statutory Overdue count.");
			test.log(LogStatus.INFO, "My Workspace - Statutory Overdue count = " + count + " | Dashboard Statutory Overdue count = "+overdueStatutory);
		}
	}
	
	public static void WorkspaceOverdueInternal( ExtentTest test)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), 60);
		Thread.sleep(500);
		//wait.until(ExpectedConditions.visibilityOf(OverduePOM.clickMyWorkspace()));
		OverduePOM.clickMyWorkspace().click();		//Clicking on 'My Workspace'
		
		Thread.sleep(500);
		OverduePOM.clickCompliance().click();			//Clicking on 'Compliance' under My Workspace
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@role='grid'][@data-role='selectable'])[1]")));	//Waiting for records table to get visible.
		
		Thread.sleep(500);
		OverduePOM.clickUserDropDown().click();		//Clicking on User DropDown
		Thread.sleep(300);
		OverduePOM.clickPerformer().click();			//CLicking on Performer under User DropDown.
		
		Thread.sleep(500);
		OverduePOM.selectType().click();				//Clicking on Overdue dropdown
		Thread.sleep(300);
		OverduePOM.clickInternal().click();			//Clicking on 'Internal' under Overdue dropdown
		
		Thread.sleep(2000);
		OverduePOM.selectStatus().click();			//Clicking on Status dropdown
		Thread.sleep(500);
		OverduePOM.clickOverdue().click();			//Clicking on 'Overdue' under Status dropdown
		
		Thread.sleep(500);
		litigationAdditionalOwner.MethodsPOM.progress();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@role='grid'][@data-role='selectable'])[1]")));	//Waiting for records table to get visible.
		
		InternalOverdue();							//Called the Method of Dashboard Statutory Overdue.
		
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,2000)");
		
		CFOcountPOM.readTotalItems1().click();
		Thread.sleep(500);
		String item1 = CFOcountPOM.readTotalItems1().getText();
		String[] bits1 = item1.split(" ");								//Splitting the String
		String compliancesCount1 = bits1[bits1.length - 2];				//Getting the second last word (total number of users)
		int count1 = Integer.parseInt(compliancesCount1);
				
		Thread.sleep(1000);
		OverduePOM.clickDashboard().click();						//Clicking on Dashboard link.
		
		Thread.sleep(500);
		OverdueCount.message();
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOf(OverduePOM.clickInternalOverdue()));
		String string_overdueInternal = OverduePOM.clickInternalOverdue().getText();		//Storing old value of Statutory overdue.
		int overdueInternal = Integer.parseInt(string_overdueInternal);
		
		if(overdueInternal == count1)
		{
			test.log(LogStatus.PASS, "My Workspace - Internal Overdue count matches to Dashboard Internal Overdue count.");
			test.log(LogStatus.INFO, "My Workspace - Internal Overdue count = " + count1 + " | Dashboard Internal Overdue count = "+overdueInternal); 
		}
		else
		{
			test.log(LogStatus.FAIL, "My Workspace - Internal Overdue count doen not matches to Dashboard Internal Overdue count.");
			test.log(LogStatus.INFO, "My Workspace - Internal Overdue count = " + count1 + " | Dashboard Internal Overdue count = "+overdueInternal);
		}
	}
}
