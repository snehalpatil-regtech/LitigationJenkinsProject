package reviewer;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import login.BasePage;

public class ReviewerPOM extends BasePage
{
	private static WebElement statutoryReview = null;		//WebElement variable created for clicking on value of Statutory 'Pending for Review'
	private static WebElement statutoryAction = null;		//WebElement variable created for clicking on Action button.
	private static WebElement download = null;				//WebElement variable created for clicking on 'Download' link.
	private static WebElement view = null; 					//WebElement variable created for clicking on 'View' link.
	private static WebElement closeView = null;				//WebElement variable created for clicking on Close View cross button.
	private static WebElement closedDelay = null;			//WebElement variable created for clicking on Closed-Delayed radio button.
	private static WebElement closedTimely = null;			//WebElement variable created for clicking on Closed-Timely radio button.
	private static WebElement checkBox = null;				//WebElement variable created for clicking on Checkbox
	private static WebElement liability1 = null;			//WebElement variable created for inserting Liability as per system
	private static WebElement liability2 = null;			//WebElement variable created for inserting Liability as per return
	private static WebElement liability3 = null;			//WebElement variable created for inserting Liability paid
	private static WebElement textArea = null;				//WebElement variable created for inserting Remark
	private static WebElement approve = null;				//WebElement variable created for clicking on Approve button
	private static WebElement reject = null;				//WebElement variable created for clicking on Reject button
	private static WebElement statutoryRejectValue = null;	//WebElement variable created for reading Statutory Reject value 
	private static WebElement dashboard = null;				//WebElement variable created for clicking on dashboard link
	private static WebElement internalReview = null;		//WebElement variable created for clicking on value of Internal 'Pending For Review'
	private static WebElement closeViewInternal = null;		//WebElement variable created for clicking on Close View cross button.
	private static WebElement closedTimelyInternal = null;	//WebElement variable created for clicking on Closed-Timely radio button.
	private static WebElement textAreaInternal = null;		//WebElement variable created for inserting Remark for Internal click Text area
	private static WebElement internalRejectValue = null;	//WebElement variable created for reading Internal Reject value.
	private static List<WebElement> elementsList = null;	//WebElement list created for selecting Status-Asc/Desc (Status shows multiple elements back side)
	
	public static WebElement ComplainceInternalReviewer()
	{
		statutoryReview = getDriver().findElement(By.xpath("//*[@id='ComplainceInternalReviewer']/div/div/div[1]/button"));
		return statutoryReview;
	}
	
	public static WebElement clickStatutoryReview()		//Method for searching Statutory Review value element.
	{
		statutoryReview = getDriver().findElement(By.xpath("//div[@id='ContentPlaceHolder1_divReviewerPendingforReviewePREOcount']"));
		return statutoryReview;
	}
	
	public static WebElement clickAction()			//Method for searching action button
	{
		statutoryAction = getDriver().findElement(By.xpath("//div[@id='grid']/div[4]/table/tbody/tr[1]/td[17]/a"));	//XPath for clicking third action button  
		return statutoryAction;
	}
	
	public static WebElement clickAction1()			//Method for searching action button
	{
		statutoryAction = getDriver().findElement(By.xpath("(//*[@class='k-button k-button-icontext ob-overview k-grid-edit2'])[1]"));	//XPath for clicking first action button  
		return statutoryAction;
	}
	
	public static List<WebElement> clickActions()
	{
		elementsList = getDriver().findElements(By.xpath("//*[@class='k-button k-button-icontext ob-overview k-grid-edit2']"));
		return elementsList;
	}
	
	public static WebElement clickDownload()		//Method searching Download link
	{
		download = getDriver().findElement(By.linkText("Download"));
		return download;
	}
	
	public static WebElement clickDownload1()		//Method searching Download link
	{
		download = getDriver().findElement(By.xpath("//*[@id = 'rptComplianceVersion_lblpathDownload_0']"));
		return download;
	}
	
	public static WebElement clickDownload1Document()		//Method searching Download link
	{
		download = getDriver().findElement(By.xpath("//a[@id='rptComplianceDocumnets_lblCompDocpathDownload_0']"));
		return download;
	}
	
	public static WebElement clickDownload2()				//Method searching Download link
	{
		download = getDriver().findElement(By.xpath("//*[@id = 'rptComplianceVersion_btnComplinceVersionDoc_0']"));
		return download;
	}
	
	public static WebElement clickDownloadInternal1()		//Method searching Download link
	{
		download = getDriver().findElement(By.xpath("//*[@id = 'rptComplianceVersion3_lblInternalpathDownload_0']"));
		return download;
	}
	
	public static WebElement clickView()			//Method for searching View link
	{
		view = getDriver().findElement(By.linkText("View"));
		return view;
	}
	
	public static WebElement clickView1()			//Method for searching View link
	{
		view = getDriver().findElement(By.xpath("//a[@id='rptComplianceVersion_lnkViewDoc_0']"));
		return view;
	}
	
	public static WebElement clickCloseView()		//Method for searching Close View cross
	{
		closeView = getDriver().findElement(By.xpath("//div[@id='DocumentReviewPopUp1']/div/div/div[1]/button"));
		return closeView;
	}
	
	public static WebElement clickCloseView1()		//Method for searching Close View cross
	{
		closeView = getDriver().findElement(By.xpath("//div[@id='DocumentPopUpSampleForm']/div/div/div[1]/button"));
		return closeView;
	}
	
	public static WebElement clickCloseViewInternal()	//Method for searching Internal Close View cross 
	{
		closeViewInternal = getDriver().findElement(By.xpath("//div[@id='DocumentReviewPopUp']/div/div/div[1]/button"));
		return closeViewInternal;
	}
	
	public static WebElement clickCloseViewInternal1()	//Method for searching Internal Close View cross 
	{
		closeViewInternal = getDriver().findElement(By.xpath("//*[@id='modalDocumentReviewerViewerInternal']/div/div/div[1]/button"));
		return closeViewInternal;
	}
	
	public static WebElement clickClosedDelayed()		//Method searching Closed-Delayed radio button
	{
		closedDelay = getDriver().findElement(By.xpath("//*[@id = 'rdbtnStatus1_0']"));
		return closedDelay;
	}
	
	public static WebElement clickClosedTimely()		//Method for searching Closed-Timely radio button
	{
		closedTimely = getDriver().findElement(By.xpath("//*[@id='rdbtnStatus1']/tbody/tr/td[2]/label"));
		return closedTimely;
	}
	
	public static WebElement clickClosedTimelyInternal()	//Method for closing View opened in Internal View
	{
		closedTimelyInternal = getDriver().findElement(By.xpath("//*[@id='rdbtnStatus3_1']"));
		return closedTimelyInternal;
	}
	
	public static WebElement clickCheckBox()			//Method for searching check box
	{
		checkBox = getDriver().findElement(By.xpath("//*[@id='chkPenaltySaveReview']"));
		return checkBox;
	}
	
	public static WebElement insertLiability1()			//Method for searching Liability for System text box
	{
		liability1 = getDriver().findElement(By.xpath("//input[@id='txtValueAsPerSystem']"));
		return liability1;
	}
	
	public static WebElement insertLiability2()			//Method for searching Liability for return text box
	{
		liability2 = getDriver().findElement(By.xpath("//input[@id='txtValueAsPerReturn']"));
		return liability2;
	}
	
	public static WebElement insertLiability3()			//Method for searching Liability Paid text box
	{
		liability3 = getDriver().findElement(By.xpath("//input[@id='txtLiabilityPaid']"));
		return liability3;
	}
	
	public static WebElement insertTextArea()			//Method for searching text area
	{
		textArea = getDriver().findElement(By.xpath("//*[@id='tbxRemarks1']"));
		return textArea;
	}
	
	public static WebElement insertTextAreaInternal()	//Method for searching Internal text area
	{
		textAreaInternal = getDriver().findElement(By.xpath("//textarea[@id='tbxRemarks3']"));
		return textAreaInternal;
	}
	
	public static WebElement clickApprove()				//Method for searching Approve button
	{
		approve = getDriver().findElement(By.xpath("//input[@value='Approve']"));
		return approve;
	}
	
	public static WebElement clickReject()				//Method searching Reject button
	{
		reject = getDriver().findElement(By.xpath("//input[@value='Reject']"));
		return reject;
	}
	
	public static WebElement readStatutoryReject()		//Method for searching Statutory Reject button to read statutory value  
	{
		statutoryRejectValue = getDriver().findElement(By.xpath("//div[@id='ContentPlaceHolder1_divReviewerRejectedPREOcount']"));
		return statutoryRejectValue;
	}
	
	public static WebElement clickDashboard()			//Method for searching 'My Dashboard' link
	{
		dashboard = getDriver().findElement(By.linkText("My Dashboard "));
		return dashboard;
	}
	
	public static WebElement clickInternalReview()		//Method for searching Internal Review value element.
	{
		internalReview = getDriver().findElement(By.xpath("//div[@id='ContentPlaceHolder1_divReviewerPendingforRevieweInternalPREOcount']"));
		return internalReview;
	}
	
	public static WebElement readInternalReject()
	{
		internalRejectValue = getDriver().findElement(By.xpath("//div[@id='ContentPlaceHolder1_divReviewerRejectedInternalPREOcount']"));
		return internalRejectValue;
	}
	
	public static List<WebElement> clickStatus() 		//Method to get list of action buttons on web page
	{
		elementsList = getDriver().findElements(By.xpath("//*[contains(text(),'Status')][@class='k-link']"));
		return elementsList;
	}
	
	public static WebElement clickLastPage()			//Searching Last Page arrow button
	{
		statutoryAction = getDriver().findElement(By.xpath("//*[@title='Go to the last page']"));
		return statutoryAction;
	}
	
	public static WebElement InterimApproveRadio()		//Searching radio button for Interim Approve
	{
		statutoryAction = getDriver().findElement(By.xpath("//*[@id='rdbtnStatus1_0']"));
		return statutoryAction;
	}
	
	public static WebElement clickMyEscalation()		//Searching 'My Escalation' link
	{
		statutoryAction = getDriver().findElement(By.linkText("My Escalation"));
		return statutoryAction;
	}
	
	public static WebElement clickShowDropdown()		//Clicking on Show dropdown
	{
		statutoryAction = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlPageSize']"));
		return statutoryAction;
	}
	
	public static WebElement checkEscalationTable()		//Searching records table to check visibility
	{
		statutoryAction = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdReviewerComplianceDocument']"));
		return statutoryAction;
	}
	
	public static List<WebElement> clickWorkFileText()	//Searching all 'Work File Timeline' text boxes
	{
		elementsList = getDriver().findElements(By.xpath("//*[@class='k-grid-content k-auto-scrollable']/table/tbody/tr/td[9]/input"));
		return elementsList;
	}
	
	public static List<WebElement> clickEscalationText()	//Searching all 'Escalation' text boxes
	{
		elementsList = getDriver().findElements(By.xpath("//*[@class='k-grid-content k-auto-scrollable']/table/tbody/tr/td[10]/input"));
		return elementsList;
	}
	
	public static WebElement loadNextPage()				//Searching Next Page load button.
	{
		statutoryAction = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_lBNext']"));
		return statutoryAction;
	}
	
	public static List<WebElement> getAllButtons()		//Searching all 'Action' buttons
	{
		elementsList = getDriver().findElements(By.xpath("//*[@class='k-button k-button-icontext ob-edit k-grid-edit']"));
		return elementsList;
	}
	
	public static WebElement clickFirstAction()		//Searching all 'Action' buttons
	{
		statutoryAction = getDriver().findElement(By.xpath("(//*[@class='k-button k-button-icontext ob-edit k-grid-edit' and not(@disabled)])[1]"));
		return statutoryAction;
	}
	
	public static WebElement clickUpdate()
	{
		statutoryAction = getDriver().findElement(By.xpath("//*[@class='k-button k-button-icontext k-primary k-grid-update']"));
		return statutoryAction;
	}
	
	public static List<WebElement> clickCheckboxes()
	{
		elementsList = getDriver().findElements(By.xpath("//*[@class = 'k-checkbox-label k-no-text']"));
		return elementsList;
	}
	
	public static WebElement clickSaveButton()			//Searching drop down of User to Assign
	{
		statutoryAction = getDriver().findElement(By.xpath("//*[@id = 'btnsave']"));
		return statutoryAction;
	}
	
	public static WebElement selectUserAssign()			//Searching drop down of User to Assign
	{
		statutoryAction = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlNewUsers']"));
		return statutoryAction;
	}
	
	public static WebElement readAssignedUser()			//Searching name of user assigned in first row.
	{
		statutoryAction = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdComplianceInstances_lbluser_0']"));
		return statutoryAction;
	}
	
	public static WebElement clickFirstCheckbox()		//Searching first checkbox
	{
		statutoryAction = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdComplianceInstances_chkCompliances_0']"));
		return statutoryAction;
	}
	
	public static WebElement sledtre()					//
	{
		statutoryAction = getDriver().findElement(By.xpath(""));
		return statutoryAction;
	}
	
	public static WebElement seletldere()				//
	{
		statutoryAction = getDriver().findElement(By.xpath(""));
		return statutoryAction;
	}
}