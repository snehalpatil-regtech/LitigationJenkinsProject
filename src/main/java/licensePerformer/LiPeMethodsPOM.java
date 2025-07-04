package licensePerformer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
import licenseReviewer.LiReviewerPOM;
import login.BasePage;
import performer.OverduePOM;

public class LiPeMethodsPOM extends BasePage
{
	private static List<WebElement> elementsList = null;
	
	public static FileInputStream fis = null;	//File input stream variable
	public static XSSFWorkbook workbook = null;	//Excel sheet workbook variable
	public static XSSFSheet sheet = null;		//Sheet variable
	public static XSSFSheet sheet1 = null;		//Sheet variable
	
	public static void ActiveLicense( ExtentTest test, String type) throws InterruptedException
	{		
		WebDriverWait wait = new WebDriverWait(getDriver(), 20);
		progress();
		
		wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickActive()));
		int active = Integer.parseInt(LiPerformerPOM.clickActive().getText());	//Reading Active count.
		
		int pending = Integer.parseInt(LiPerformerPOM.clickPendingForReview().getText());
		
		LiPerformerPOM.clickActive().click();					//Clicking on 'Active' image
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickAction()));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,2000)");				//Scrolling down window by 2000 px.
		
		int total = Integer.parseInt(OverduePOM.readReminder().getText());
		if(active == total)
		{
			test.log(LogStatus.PASS, "Dashboard 'Active' count matches to total records displayed in Grid.");
			test.log(LogStatus.INFO, "Dashboard 'Active' count = "+active+" | Total records in Grid = "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "Dashboard 'Active' count matches doesn't to total records displayed in Grid.");
			test.log(LogStatus.INFO, "Dashboard 'Active' count = "+active+" | Total records in Grid = "+total);
		}
		
		Thread.sleep(500);
		js.executeScript("window.scrollBy(2000,0)");				//Scrolling up window by 2000 px.
		
		LiPerformerPOM.clickAction().click();					//Clicking on first Action button.
		
		Thread.sleep(700);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
		
		Thread.sleep(500);
		js.executeScript("window.scrollBy(0,2000)");				//Scrolling down window by 2000 px.
		
		if(type.equalsIgnoreCase("Internal"))
		{
			wait.until(ExpectedConditions.visibilityOf(OverduePOM.selectInternalDropdown()));
			Select status = new Select(OverduePOM.selectInternalDropdown());	//Selecting Status dropdown box.
			status.selectByIndex(1);									//Selecting 2nd value from dropdown.
		}
		else
		{
			wait.until(ExpectedConditions.visibilityOf(OverduePOM.selectStatutoryDropdown()));
			Select status = new Select(OverduePOM.selectStatutoryDropdown());	//Selecting Status dropdown box.
			status.selectByIndex(1);									//Selecting 2nd value from dropdown.
		}
		
		progress();
		
		try
		{
			Thread.sleep(500);
			if(type.equalsIgnoreCase("Internal"))
			{
				LiPerformerPOM.clickComplDocInternal().sendKeys("www.google.com");	//Providing Compliance Document link.
			}
			else
			{
				LiPerformerPOM.clickComplDoc().sendKeys("www.google.com");	//Providing Compliance Document link.
			}
			Thread.sleep(500);
			LiPerformerPOM.clickComplDocAddButton().click();				//Clicking on 'Add Link' button
			Thread.sleep(500);
			js.executeScript("arguments[0].scrollIntoView();", OverduePOM.clickComplianceSubmit());
		}
		catch(Exception e)
		{
			
		}
		
		try
		{
			Thread.sleep(500);
			if(type.equalsIgnoreCase("Internal"))
			{
				String workingDir = System.getProperty("user.dir");
				OverduePOM.fileUploadInternal().sendKeys(workingDir+"//Reports//PerformerResults.html");	//Uploading file by sending file to Upload Button. (Internal)
				Thread.sleep(1000);
			}
			else
			{
				String workingDir = System.getProperty("user.dir");
				OverduePOM.fileUploadStatutory().sendKeys(workingDir+"//Reports//PerformerResults.html");	//Uploading file by sending file to Upload Button.
				Thread.sleep(1000);
			}
		}
		catch(Exception e)
		{
			
		}
		
		Thread.sleep(500);
		if(type.equalsIgnoreCase("Internal"))
		{
			OverduePOM.selectDateInternal().click();				//Clicking on Date text box
		}
		else
		{
			OverduePOM.selectDateStatutory().click();				//Clicking on Date text box
		}
		Thread.sleep(300);
		OverduePOM.selectLastMonth().click();					//CLicking on Last month arrow.
		Thread.sleep(300);
		OverduePOM.selectDate2().click();						//Clicking on date at third row and second column
		
		Thread.sleep(500);
		if(type.equalsIgnoreCase("Internal"))
		{
			OverduePOM.clickInternalRemark().sendKeys("Automation Remark");
		}
		else
		{
			OverduePOM.remark().sendKeys("Automation Remark");
		}
		
		Thread.sleep(500);
		OverduePOM.clickComplianceSubmit().click();			//Clicking on 'Submit' button.
		
		Thread.sleep(700);
		if(type.equalsIgnoreCase("Statutory"))
		{
			js.executeScript("window.scrollBy(0,-2000)");
			//js.executeScript("arguments[0].scrollIntoView();", LiPerformerPOM.readMessage());
			wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.readMessage()));
			
			Thread.sleep(300);
			String msg = LiPerformerPOM.readMessage().getText();
			if(msg.equalsIgnoreCase("Saved Sucessfully."))
			{
				test.log(LogStatus.PASS, "Message displayed - "+msg);
			}
			else
			{
				test.log(LogStatus.INFO, "Message displayed - "+msg);
			}
		}
		
		getDriver().switchTo().parentFrame();
		if(type.equalsIgnoreCase("Statutory"))
		{
			Thread.sleep(500);
			LiPerformerPOM.clickClose().click();				//Clicking on Close (Cross)
		}
		
		progress();
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.clickDashboard()));
		OverduePOM.clickDashboard().click();

		Thread.sleep(700);
		if(type.equalsIgnoreCase("Internal"))
		{
			wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickType()));
			LiPerformerPOM.clickType().click();				//Clicking on 'Type' drop down.
			Select drp = new Select(LiPerformerPOM.clickType());
			drp.selectByIndex(1);
			
			progress();
			
			Thread.sleep(500);
			CFOcountPOM.clickApply1().click();				//Clicking on Apply.
		}
		
		Thread.sleep(700);
		wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickActive()));
		int active1 = Integer.parseInt(LiPerformerPOM.clickActive().getText());	//Reading Active count.
		int pending1 = Integer.parseInt(LiPerformerPOM.clickPendingForReview().getText());
		if(active1 < active)
		{
			test.log(LogStatus.PASS, "Dashboard 'Active' count decreased.");
			test.log(LogStatus.INFO, "Old Count = "+active+" | New Count = "+active1);
		}
		else
		{
			test.log(LogStatus.FAIL, "Dashboard 'Active' count doesn't decreased.");
			test.log(LogStatus.INFO, "Old Count = "+active+" | New Count = "+active1);
		}
		
		if(pending1 > pending)
		{
			test.log(LogStatus.PASS, "Dashboard 'Pending Review' count increased.");
			test.log(LogStatus.INFO, "Old Count = "+pending+" | New Count = "+pending1);
		}
		else
		{
			test.log(LogStatus.FAIL, "Dashboard 'Pending Review' count doesn't increased.");
			test.log(LogStatus.INFO, "Old Count = "+pending+" | New Count = "+pending1);
		}
	}
	
	public static void AppliedCount( ExtentTest test, String type) throws InterruptedException
	{		
		WebDriverWait wait = new WebDriverWait(getDriver(), 20);
		progress();
		
		wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickApplied()));
		int applied = Integer.parseInt(LiPerformerPOM.clickApplied().getText());	//Reading Applied count.
		
		LiPerformerPOM.clickApplied().click();						//Clicking on 'Applied'
		
		progress();
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOf(LiReviewerPOM.checkTable()));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,2000)");				//Scrolling down window by 2000 px.
		
		int total = Integer.parseInt(OverduePOM.readReminder().getText());
		if(applied == total)
		{
			test.log(LogStatus.PASS, "Dashboard 'Applied' count matches to the total records displayed.");
			test.log(LogStatus.INFO, "Dashboard 'Applied' count = "+applied+" | Total records = "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "Dashboard 'Applied' count matches doesn't to the total records displayed.");
			test.log(LogStatus.INFO, "Dashboard 'Applied' count = "+applied+" | Total records = "+total);
		}
		
		Thread.sleep(300);
		LiPerformerPOM.clickAction().click();					//Clicking on first action button.
		
		progress();
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
		
		licenseReviewer.LiReMethodsPOM.perform( test);		//Calling perform method of Reviewer.
		
		if(type.equalsIgnoreCase("Internal"))
		{
			Thread.sleep(500);
			LiPerformerPOM.clickComplDoc().clear();
			LiPerformerPOM.clickComplDoc().sendKeys("www.google.com");	//Providing compliance document link.
		}
		
		Thread.sleep(500);
		OverduePOM.clickComplianceSubmit().click();			//Clicking on 'Submit' button.
		try
		{
			Thread.sleep(500);
			getDriver().switchTo().alert().dismiss();
		}
		catch(Exception e)
		{
			
		}
		
		Thread.sleep(500);
		js.executeScript("window.scrollBy(2000,0)");				//Scrolling down window by 2000 px.
		
		//if(type.equalsIgnoreCase("Statutory"))
		try
		{
			String msg = LiPerformerPOM.readMsg().getText();
			if(msg.equalsIgnoreCase("Compliance Created and Assigned Sucessfully"))
			{
				test.log(LogStatus.PASS, "Message Displayed = "+msg);
			}
			else
			{
				test.log(LogStatus.FAIL, "Message Displayed = "+msg);
			}
		}
		catch(Exception e)
		{
			
		}
		
		getDriver().switchTo().parentFrame();
		
		Thread.sleep(500);
		js.executeScript("window.scrollBy(1000,0)");				//Scrolling down window by 1000 px.
		
		Thread.sleep(500);
		LiPerformerPOM.clickClose().click();				//Clicking on Close (Cross)
		
		progress();
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.clickDashboard()));
		OverduePOM.clickDashboard().click();
		
		if(type.equalsIgnoreCase("Internal"))			//Opening 'Internal' Dashboard
		{
			Thread.sleep(500);
			wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickType()));
			LiPerformerPOM.clickType().click();				//Clicking on 'Type' drop down.
			
			Select drp = new Select(LiPerformerPOM.clickType());
			drp.selectByIndex(1);
			
			progress();
			
			Thread.sleep(500);
			CFOcountPOM.clickApply1().click();				//Clicking on Apply.
		}
		
		wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickActive()));
		int applied1 = Integer.parseInt(LiPerformerPOM.clickApplied().getText());	//Reading Active count.
		if(applied1 < applied)
		{
			test.log(LogStatus.PASS, "Dashboard 'Applied' count decreased.");
			test.log(LogStatus.INFO, "Old Count = "+applied+". New Count = "+applied1);
		}
		else
		{
			test.log(LogStatus.FAIL, "Dashboard 'Applied' count doesn't decreased.");
			test.log(LogStatus.INFO, "Old Count = "+applied+". New Count = "+applied1);
		}
	}
	
	public static void ExpiringCount( ExtentTest test, String type) throws InterruptedException
	{		
		WebDriverWait wait = new WebDriverWait(getDriver(), 20);
		progress();
		
		wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickExpiring()));
		int expiring = Integer.parseInt(LiPerformerPOM.clickExpiring().getText());	//Reading Expiring count.
		int pending = Integer.parseInt(LiPerformerPOM.clickPendingForReview().getText());
		
		LiPerformerPOM.clickExpiring().click();						//Clicking on 'Expiring'
		
		progress();
		
		Thread.sleep(300);
		wait.until(ExpectedConditions.visibilityOf(LiReviewerPOM.checkTable()));
		Thread.sleep(500);
		int flag = 0;
		try
		{
			if(LiPerformerPOM.clickAction().isDisplayed())
			{
				flag = 1;
			}
		}
		catch(Exception e)
		{
			
		}
		if(flag == 1)
		{
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,2000)");				//Scrolling down window by 2000 px.
			
			int total = Integer.parseInt(OverduePOM.readReminder().getText());
			if(expiring == total)
			{
				test.log(LogStatus.PASS, "Dashboard 'Expiring' count matches to total records displayed. Total records = "+total);
			}
			else
			{
				test.log(LogStatus.FAIL, "Dashboard 'Expiring' count matches doesn't to total records displayed. Total records = "+total);
			}
			
			Thread.sleep(300);
			LiPerformerPOM.clickAction().click();					//Clicking on first action button.
			
			progress();
			
			Thread.sleep(500);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
			
			Thread.sleep(500);
			if(type.equalsIgnoreCase("Statutory"))
			{
				js.executeScript("window.scrollBy(0,700)");
				wait.until(ExpectedConditions.visibilityOf(OverduePOM.selectStatutoryDropdown()));
				Select status = new Select(OverduePOM.selectStatutoryDropdown());	//Selecting Status dropdown box.
				status.selectByIndex(2);									//Selecting 2nd value from dropdown.
			}
			else
			{
				js.executeScript("window.scrollBy(0,500)");
				wait.until(ExpectedConditions.visibilityOf(OverduePOM.selectInternalDropdown()));
				Select status = new Select(OverduePOM.selectInternalDropdown());	//Selecting Status dropdown box.
				status.selectByIndex(2);									//Selecting 2nd value from dropdown.
			}
			
			progress();
			
			licenseReviewer.LiReMethodsPOM.perform( test);		//Calling perform method of Reviewer.
			
			try
			{
				Thread.sleep(500);
				LiPerformerPOM.clickCheckbox().click();			//Clicking on checkbox of Penalty values
			}
			catch(Exception e)
			{
				
			}
			Thread.sleep(1000);
			js.executeScript("window.scrollBy(0,500)");				//Scrolling down window by 2000 px.
			
			Thread.sleep(500);
			OverduePOM.clickComplianceSubmit().click();			//Clicking on 'Submit' button.
			
			Thread.sleep(1000);
			js.executeScript("window.scrollBy(0,-1000)");				//Scrolling down window by 2000 px.
			
			if(type.contains("Statutory"))
			{
				Thread.sleep(300);
				LiPerformerPOM.readMessage().click();
				String msg = LiPerformerPOM.readMessage().getText();
				if(msg.equalsIgnoreCase("Save Sucessfully."))
				{
					test.log(LogStatus.PASS, "Message Displayed = "+msg);
				}
				else
				{
					test.log(LogStatus.INFO, "Message Displayed = "+msg);
				}
				
				getDriver().switchTo().parentFrame();
				Thread.sleep(500);
				LiPerformerPOM.clickClose().click();				//Clicking on Close (Cross)
				
				progress();
			}
		}
		else
		{
			test.log(LogStatus.SKIP, "No records to perform task.");
		}
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.clickDashboard()));
		OverduePOM.clickDashboard().click();
		
		if(type.contains("Internal"))
		{
			WebDriverWait wait1 = new WebDriverWait(getDriver(), 5);
			wait1.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickType()));
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
		}
		
		wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickExpiring()));
		int expiring1 = Integer.parseInt(LiPerformerPOM.clickExpiring().getText());	//Reading Active count.
		int pending1 = Integer.parseInt(LiPerformerPOM.clickPendingForReview().getText());
		
		if(expiring1 < expiring)
		{
			test.log(LogStatus.PASS, "Dashboard 'Expiring' count decreased.");
			test.log(LogStatus.INFO, "Old count = "+expiring+" | New Count = "+expiring1);
		}
		else
		{
			test.log(LogStatus.FAIL, "Dashboard 'Expiring' count doesn't decreased.");
			test.log(LogStatus.INFO, "Old count = "+expiring+" | New Count = "+expiring1);
		}
		if(pending1 > pending)
		{
			test.log(LogStatus.PASS, "Dashboard 'Pending Review' count increased.");
			test.log(LogStatus.INFO, "Old Count = "+pending+" | New Count = "+pending1);
		}
		else
		{
			test.log(LogStatus.FAIL, "Dashboard 'Pending Review' count doesn't increased.");
			test.log(LogStatus.INFO, "Old Count = "+pending+" | New Count = "+pending1);
		}
	}
	
	public static void ExpiredCount( ExtentTest test, String type) throws InterruptedException
	{		
		WebDriverWait wait = new WebDriverWait(getDriver(), 20);
		
		progress();
		
		wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickExpired()));
		int expired = Integer.parseInt(LiPerformerPOM.clickExpired().getText());	//Reading Expiring count.
		
		LiPerformerPOM.clickExpired().click();						//Clicking on 'Expiring'
		
		progress();
		
		Thread.sleep(300);
		wait.until(ExpectedConditions.visibilityOf(LiReviewerPOM.checkTable()));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,2000)");				//Scrolling down window by 2000 px.
		
		int total = Integer.parseInt(OverduePOM.readReminder().getText());
		if(expired == total)
		{
			test.log(LogStatus.PASS, "Dashboard 'Expired' count matches to the total records displayed in grid.");
			test.log(LogStatus.INFO, "Dashboard 'Expired' count = "+expired+" | Total records in grid = "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "Dashboard 'Expired' count doesn't matches to the total records displayed in grid.");
			test.log(LogStatus.INFO, "Dashboard 'Expired' count = "+expired+" | Total records in grid = "+total);
		}
		
		Thread.sleep(300);
		LiPerformerPOM.clickAction().click();					//Clicking on first action button.
		
		progress();
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
		
		if(type.equalsIgnoreCase("Internal"))
		{
			js.executeScript("window.scrollBy(0,700)");
			wait.until(ExpectedConditions.visibilityOf(OverduePOM.selectInternalDropdown()));
			Select status = new Select(OverduePOM.selectInternalDropdown());	//Selecting Status dropdown box.
			status.selectByIndex(2);									//Selecting 2nd value from dropdown.
		}
		else
		{
			js.executeScript("window.scrollBy(0,700)");
			wait.until(ExpectedConditions.visibilityOf(OverduePOM.selectStatutoryDropdown()));
			Select status = new Select(OverduePOM.selectStatutoryDropdown());	//Selecting Status dropdown box.
			status.selectByIndex(2);									//Selecting 2nd value from dropdown.
		}
		
		try
		{
			Thread.sleep(300);
			wait.until(ExpectedConditions.invisibilityOf(LiPerformerPOM.Progress()));
		}
		catch(Exception e)
		{
			
		}
		
		licenseReviewer.LiReMethodsPOM.perform( test);			//Calling perform method of Reviewer.
		
		try
		{
			Thread.sleep(500);
			LiPerformerPOM.clickCheckbox().click();			//Clicking on checkbox of Penalty values
			js.executeScript("window.scrollBy(0,300)");
		}
		catch(Exception e)
		{
			
		}
		
		Thread.sleep(500);
		js.executeScript("window.scrollBy(0,700)");
		Thread.sleep(300);
		OverduePOM.clickComplianceSubmit().click();			//Clicking on 'Submit' button.
		
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(1000,0)");				//Scrolling down window by 2000 px.
		
		Thread.sleep(300);
		if(type.equalsIgnoreCase("Statutory"))
		{
			String msg = LiPerformerPOM.readMessage().getText();
			if(msg.equalsIgnoreCase("Save Sucessfully."))
			{
				test.log(LogStatus.PASS, "Message Displayed = "+msg);
			}
			else
			{
				test.log(LogStatus.INFO, "Message Displayed = "+msg);
			}
			
			Thread.sleep(500);
			js.executeScript("window.scrollBy(2000,0)");			//Scrolling up window by 2000 px.
			
			getDriver().switchTo().parentFrame();
			
			Thread.sleep(700);
			LiPerformerPOM.clickClose().click();				//Clicking on Close (Cross)
		}
		
		//progress();
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,2000)");
		wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.readReminder()));
		int total1 = Integer.parseInt(OverduePOM.readReminder().getText());
		
		if(total1 < total)
		{
			test.log(LogStatus.PASS, "Count of records in grid decreased.");
			test.log(LogStatus.INFO, "Old Count = "+total+" | New Count = "+total1);
		}
		else
		{
			test.log(LogStatus.FAIL, "Count of records in grid doesn't decreased.");
			test.log(LogStatus.INFO, "Old Count = "+total+" | New Count = "+total1);
		}
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.clickDashboard()));
		OverduePOM.clickDashboard().click();
		
		Thread.sleep(700);
		if(type.equalsIgnoreCase("Internal"))
		{
			wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickType()));
			LiPerformerPOM.clickType().click();				//Clicking on 'Type' drop down.
			Select drp = new Select(LiPerformerPOM.clickType());
			drp.selectByIndex(1);
			
			progress();
			
			Thread.sleep(500);
			CFOcountPOM.clickApply1().click();				//Clicking on Apply.
		}
		
		Thread.sleep(700);
		wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickExpired()));
		int expired1 = Integer.parseInt(LiPerformerPOM.clickExpired().getText());	//Reading Active count.
		if(expired1 < expired)
		{
			test.log(LogStatus.PASS, "Dashboard 'Expired' count decreased.");
			test.log(LogStatus.INFO, "Old Count = "+expired+" | New Count = "+expired1);
		}
		else
		{
			test.log(LogStatus.FAIL, "Dashboard 'Expired' count doesn't decreased.");
			test.log(LogStatus.INFO, "Old Count = "+expired+" | New Count = "+expired1);
		}
	}
	
	public static void progress() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), 40);
		try
		{
			Thread.sleep(400);
			wait.until(ExpectedConditions.invisibilityOf(LiPerformerPOM.Progress()));
		}
		catch(Exception e)
		{
			
		}
	}
	
	public static void Documents( ExtentTest test, String type) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), 20);
		
		progress();
		
		wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickExpired()));
		
		LiPerformerPOM.clickMyDocuments().click();		//Clicking on 'My Documents'
		Thread.sleep(500);
		LiPerformerPOM.clickMyDocumentsMenu().click();	//Clicking on 'My Documents'
		
		progress();
		
		wait.until(ExpectedConditions.visibilityOf(LiReviewerPOM.checkTable1()));	//Waiting until records table gets visible.
		
		if(type.equalsIgnoreCase("Internal"))
		{
			LiPerformerPOM.clickType2().click();			//Clicking on 'Type' drop down.
			Thread.sleep(500);
			LiPerformerPOM.selectInternal().click();//Selecting 'Internal' option.
			Thread.sleep(1000);
			progress();
		}
		
		Thread.sleep(500);
		elementsList = LiPerformerPOM.clickDownload1();
		
		File dir = new File("C://Users//jiya//Downloads//");
		File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
		
		Thread.sleep(500);
		elementsList.get(1).click();							//Clicking on first 'Download' link.
		
		Thread.sleep(3000);
		File dir1 = new File("C://Users//jiya//Downloads//");
		File[] dirContents1 = dir1.listFiles();							//Counting number of files in directory after download
		
		if(dirContents.length < dirContents1.length)
		{
			test.log(LogStatus.PASS, "File downloaded successfully.");
		}
		else
		{
			test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
		}
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.clickDashboard()));
		OverduePOM.clickDashboard().click();
	}
	
	public static void Reports( ExtentTest test, String type) throws InterruptedException, IOException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), 20);
		
		wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickExpired()));
		
		LiPerformerPOM.clickMyReport().click();		//Clicking on 'My Reports'
		
		progress();
		
		wait.until(ExpectedConditions.visibilityOf(LiReviewerPOM.checkTable1()));	//Waiting until records table gets visible.
		
		if(type.equalsIgnoreCase("Internal"))
		{
			LiPerformerPOM.clickType2().click();			//Clicking on 'Type' drop down.
			Thread.sleep(500);
			LiPerformerPOM.selectInternal().click();//Selecting 'Internal' option.
			Thread.sleep(1000);
			progress();
		}
		
		CheckReports( test, 1, "Active");
		
		CheckReports( test, 2, "Expired");
		
		CheckReports( test, 3, "Expiring");
		
		CheckReports( test, 4, "Applied");
		
		CheckReports( test, 5, "Applied but Pending for Renewal");
		
		CheckReports( test, 6, "Renewed");
		
		CheckReports( test, 7, "Rejected");
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.clickDashboard()));
		OverduePOM.clickDashboard().click();
	}
	
	public static void CheckReports( ExtentTest test, int status, String type) throws InterruptedException, IOException
	{		
		WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-1000)");
		
		LiPerformerPOM.clickStatus1().click();			//Clicking on 'Status' drop down.
		Thread.sleep(500);
		elementsList = LiPerformerPOM.selectStatus1();	//Selecting Status.
		elementsList.get(status).click();
		
		Thread.sleep(1000);
		progress();
		
		int flag = 0;
		try
		{
			wait.until(ExpectedConditions.visibilityOf(LiReviewerPOM.checkTable1()));	//Waiting until records table gets visible.
			flag = 1;
		}
		catch(Exception e)
		{
			
		}
		
		if(flag == 1)
		{
			js.executeScript("window.scrollBy(0,2000)");				//Scrolling down window by 2000 px.
			
			Thread.sleep(700);
			String item = LiPerformerPOM.readTotalRecords1().getText();
			String[] bits = item.split(" ");								//Splitting the String
			String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
			int count = 0;
			if(compliancesCount.equalsIgnoreCase("to"))
			{
				Thread.sleep(2500);
				item = CFOcountPOM.readTotalItems1().getText();
				bits = item.split(" ");										//Splitting the String
				compliancesCount = bits[bits.length - 2];					//Getting the second last word (total number of users)
			}
			count = Integer.parseInt(compliancesCount);
			
			File dir = new File("C://Users//jiya//Downloads//");
			File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
			
			js.executeScript("window.scrollBy(0,-2000)");				//Scrolling down window by 2000 px.
			Thread.sleep(500);
			LiPerformerPOM.clickExcel().click();						//Clicking on Excel Image.
			
			Thread.sleep(3000);
			File dir1 = new File("C://Users//jiya//Downloads//");
			File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download
			
			File lastModifiedFile = allFilesNew[0];			//Storing any 0th index file in 'lastModifiedFile' file name.
		    for (int i = 1; i < allFilesNew.length; i++) 	//For loop till the number of files in directory.
		    {
		       if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) 	//If allFilesNew[i] file is having large/latest time time of update then latest modified file be allFilesNew[i] file.
		       {
		           lastModifiedFile = allFilesNew[i];
		       }
		    }
			
			if(dirContents.length < allFilesNew.length)
			{
				test.log(LogStatus.PASS, type+" :- File downloaded successfully.");
				
				fis = new FileInputStream(lastModifiedFile);
				workbook = new XSSFWorkbook(fis);
				sheet = workbook.getSheetAt(0);					//Retrieving first sheet of Workbook
				int no = sheet.getLastRowNum();
				int SheetRecords = no - 0;						//Sheet have extra 5 lines of information at top (But row count started from 0, so -4)
				fis.close();
				
				if(count == SheetRecords)
				{
					test.log(LogStatus.PASS, "Count of records displayed from grid matches to number records in Excel Sheet.");
					test.log(LogStatus.INFO, "Total records from grid = "+count+" | Total records in Excel Sheet = "+SheetRecords);
				}
				else
				{
					test.log(LogStatus.FAIL, "Count of records displayed from grid doesn't matches to number records in Excel Sheet.");
					test.log(LogStatus.INFO, "Total records from grid = "+count+" | Total records in Excel Sheet = "+SheetRecords);
				}
			}
			else
			{
				test.log(LogStatus.FAIL, type+" :- File doesn't downloaded successfully.");
			}
		}
		else
		{
			test.log(LogStatus.SKIP, type+" :- Records not displayed (available). Excel sheet didn't downloaded");
		}
	}
	
	public static void PendingReview( ExtentTest test, String type) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), 20);
		Actions action = new Actions(getDriver());
		
		progress();
		
		wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickExpired()));
		int pending = Integer.parseInt(LiPerformerPOM.clickPendingForReview().getText());
		System.out.println("Pending = "+pending);
		
		LiPerformerPOM.clickPendingForReview().click();
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.checkTable()));
		
		action.keyDown(Keys.CONTROL).sendKeys(Keys.PAGE_DOWN).perform();
		action.keyUp(Keys.CONTROL).perform();
		
		int total = Integer.parseInt(LiPerformerPOM.readTotalRecords().getText());
		
		if(pending == total)
		{
			test.log(LogStatus.PASS, "Dashboard 'Pending For Review' count matches to Total noof Records. Dashboard count = "+pending+", Total Records count = "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "Dashboard 'Pending For Review' count doesn't matches to Total no of Records. Dashboard count = "+pending+", Total Records count = "+total);
		}
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.clickDashboard()));
		OverduePOM.clickDashboard().click();
		
		Thread.sleep(700);
		if(type.equalsIgnoreCase("Internal"))
		{
			wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickType()));
			LiPerformerPOM.clickType().click();				//Clicking on 'Type' drop down.
			Select drp = new Select(LiPerformerPOM.clickType());
			drp.selectByIndex(1);
			
			progress();
			
			Thread.sleep(500);
			CFOcountPOM.clickApply1().click();				//Clicking on Apply.
		}
	}
}
