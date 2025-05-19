package contract;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import login.BasePage;

public class ContractPOM extends BasePage
{
	private static WebElement contract = null;		
	private static List<WebElement> elementsList = null;	//WebElement list created for selecting Status-Asc/Desc (Status shows multiple elements back side)
	
	public static WebElement clickDraft()
	{
		contract = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_divDraftCount']"));
		return contract;
	}
	
	public static WebElement clickAddNew()
	{
		contract = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnAddContract']"));
		return contract;
	}
	
	public static WebElement readTotalRecords()
	{
		contract = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_lblTotalRecord']"));
		return contract;
	}
	
	public static WebElement clickExportReport()
	{
		contract = getDriver().findElement(By.xpath("//a[@id='ContentPlaceHolder1_btnExportExcel']"));
		return contract;
	}
	
	public static WebElement clickDashboard()
	{
		contract = getDriver().findElement(By.xpath("//*[@id='leftdashboardmenu']"));
		return contract;
	}
	
	public static WebElement clickContractNumber()
	{
		contract = getDriver().findElement(By.xpath("//*[@id='txtContractNo']"));
		return contract;
	}
	
	public static WebElement clickContractTitle()
	{
		contract = getDriver().findElement(By.xpath("//*[@id='txtTitle']"));
		return contract;
	}
	
	public static WebElement clickDescription()
	{
		contract = getDriver().findElement(By.xpath("//*[@id='tbxDescription']"));
		return contract;
	}
	
	public static WebElement clickEntityLocation()
	{
		contract = getDriver().findElement(By.xpath("//*[@id='tbxBranch']"));
		return contract;
	}
	
	public static WebElement selectLocation()
	{
		contract = getDriver().findElement(By.xpath("//*[@id='tvBranchest0']"));
		return contract;
	}
	
	public static WebElement clickVendor()
	{
		contract = getDriver().findElement(By.xpath("(//*[@class='multiselect dropdown-toggle btn btn-default'])[1]"));
		return contract;
	}
	
	public static WebElement clickDepartment()
	{
		contract = getDriver().findElement(By.xpath("//*[@id='ddlDepartment_chosen']"));
		return contract;
	}
	
	public static WebElement clickContactPerson()
	{
		contract = getDriver().findElement(By.xpath("//*[@id='ddlCPDepartment_chosen']"));
		return contract;
	}
	
	public static WebElement clickProposalDate()
	{
		contract = getDriver().findElement(By.xpath("//*[@id='txtProposalDate']"));
		return contract;
	}
	
	public static WebElement selectLastMonth()				//Method to click on arrow which shows last month
	{
		contract = getDriver().findElement(By.xpath("//*[@id='ui-datepicker-div']/div/a[1]/span"));
		return contract;
	}
	
	public static WebElement selectNextMonth()			//Method to click on arrow which shows last month
	{
		contract = getDriver().findElement(By.xpath("//*[@id='ui-datepicker-div']/div/a[2]/span"));
		return contract;
	}
	
	public static WebElement selectDate()					//Method to click on date at second row and fourth column
	{
		contract = getDriver().findElement(By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr[3]/td[3]/a"));
		return contract;
	}
	
	public static WebElement clickAgreementDate()
	{
		contract = getDriver().findElement(By.xpath("//*[@id='txtAgreementDate']"));
		return contract;
	}
	
	public static WebElement clickStartDate()
	{
		contract = getDriver().findElement(By.xpath("//*[@id='txtEffectiveDate']"));
		return contract;
	}
	
	public static WebElement clickReviewDate()
	{
		contract = getDriver().findElement(By.xpath("//*[@id='txtReviewDate']"));
		return contract;
	}
	
	public static WebElement clickEndDate()
	{
		contract = getDriver().findElement(By.xpath("//*[@id='txtExpirationDate']"));
		return contract;
	}
	
	public static WebElement clickNoticeTerm()
	{
		contract = getDriver().findElement(By.xpath("//*[@id='txtNoticeTerm']"));
		return contract;
	}
	
	public static WebElement clickNoticeTermPeriod()
	{
		contract = getDriver().findElement(By.xpath("//*[@id='ddlNoticeTerm']"));
		return contract;
	}
	
	public static WebElement clickContractType()
	{
		contract = getDriver().findElement(By.xpath("//*[@id='ddlContractType_chosen']"));
		return contract;
	}
	
	public static WebElement clickContractSubType()
	{
		contract = getDriver().findElement(By.xpath("//*[@id='ddlContractSubType_chosen']"));
		return contract;
	}
	
	public static WebElement clickContractOwner()
	{
		contract = getDriver().findElement(By.xpath("(//*[@class='multiselect dropdown-toggle btn btn-default'])[2]"));
		return contract;
	}
	
	public static WebElement clickContractAmount()
	{
		contract = getDriver().findElement(By.xpath("//*[@id='tbxContractAmt']"));
		return contract;
	}
	
	public static WebElement clickPaymentType()
	{
		contract = getDriver().findElement(By.xpath("//*[@id='ddlPaymentType_chosen']"));
		return contract;
	}
	
	public static WebElement clickSave()
	{
		contract = getDriver().findElement(By.xpath("//*[@value='Save']"));
		return contract;
	}
	
	public static WebElement clickExpired()
	{
		contract = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_divExpiredCount']"));
		return contract;
	}
	
	public static WebElement clickStatusDropDown()
	{
		contract = getDriver().findElement(By.xpath("//div[@id='ContentPlaceHolder1_ddlContractStatus_chosen']"));
		return contract;
	}
	
	public static List<WebElement> selectContractStatus()
	{
		elementsList = getDriver().findElements(By.xpath("//div[@id='ContentPlaceHolder1_ddlContractStatus_chosen']/div/ul/li"));
		return elementsList;
	}
	
	public static WebElement clickAllContractDropDown()
	{
		contract = getDriver().findElement(By.xpath("//div[@id='ContentPlaceHolder1_ddlContract_chosen']"));
		return contract;
	}
	
	public static WebElement selectAssignedToReview()
	{
		contract = getDriver().findElement(By.xpath("//div[@id='ContentPlaceHolder1_ddlContract_chosen']/div/ul/li[2]"));
		return contract;
	}
	
	public static WebElement selectAllContract()
	{
		contract = getDriver().findElement(By.xpath("//div[@id='ContentPlaceHolder1_ddlContract_chosen']/div/ul/li[1]"));
		return contract;
	}
	
	public static WebElement clickMyReports()
	{
		contract = getDriver().findElement(By.xpath("//a[@href='/ContractProduct/Reports/MyReportContract.aspx']"));
		return contract;
	}
	
	public static WebElement selectRenewed()
	{
		contract = getDriver().findElement(By.xpath("//div[@id='ContentPlaceHolder1_ddlContractStatus_chosen']/div/ul/li[10]"));
		return contract;
	}
	
	public static WebElement selectExpired()
	{
		contract = getDriver().findElement(By.xpath("//div[@id='ContentPlaceHolder1_ddlContractStatus_chosen']/div/ul/li[11]"));
		return contract;
	}
	
	public static WebElement readMessage()
	{
		contract = getDriver().findElement(By.xpath("//*[@id='VSContractPopup']"));
		return contract;
	}
	
	public static WebElement clickClose()
	{
		contract = getDriver().findElement(By.xpath("//*[@onclick='closeModal();']"));
		return contract;
	}
	
	public static WebElement clickPendingForReview()
	{
		contract = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_divPendingReviewCount']"));
		return contract;
	}
	
	public static WebElement clickEditDraft()
	{
		contract = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdContractList_lnkEditContract_0']"));
		return contract;
	}
	
	public static WebElement clickDraftEdit()
	{
		contract = getDriver().findElement(By.xpath("//*[@id='btnEditContractDetail']"));
		return contract;
	}
	
	public static WebElement clickDraftStatus()
	{
		contract = getDriver().findElement(By.xpath("//*[@id='ddlContractStatus_chosen']"));
		return contract;
	}
	
	public static WebElement clickDraftStatusTextBox()
	{
		contract = getDriver().findElement(By.xpath("//*[@id='ddlContractStatus_chosen']/div/div/input"));
		return contract;
	}
	
	public static WebElement clickUpdate()
	{
		contract = getDriver().findElement(By.xpath("//*[@value='Update']"));
		return contract;
	}
	
	public static WebElement clickReviewed()
	{
		contract = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_divReviewedCount']"));
		return contract;
	}
	
	public static WebElement clickPendingApproval()
	{
		contract = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_divPendingApprovalCount']"));
		return contract;
	}
	
	public static WebElement clickTasks()
	{
		contract = getDriver().findElement(By.xpath("//*[@id='lnkBtnTask']"));
		return contract;
	}
	
	public static WebElement clickAddNewTask()
	{
		contract = getDriver().findElement(By.xpath("//*[@id='lnkAddNewTask']"));
		return contract;
	}
	
	public static WebElement readContractName()
	{
		contract = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdContractList']/tbody/tr[2]/td[3]/div/span"));
		return contract;
	}
	
	public static WebElement clickReviewRadioButton()
	{
		contract = getDriver().findElement(By.xpath("//input[@id='rbTaskType_0']"));
		return contract;
	}
	
	public static WebElement clickTaskTitle()
	{
		contract = getDriver().findElement(By.xpath("//*[@id='tbxTaskTitle']"));
		return contract;
	}
	
	public static WebElement clickTaskDescription()
	{
		contract = getDriver().findElement(By.xpath("//*[@id='tbxTaskDesc']"));
		return contract;
	}
	
	public static WebElement clickTaskDueDate()
	{
		contract = getDriver().findElement(By.xpath("//*[@id='tbxTaskDueDate']"));
		return contract;
	}
	
	public static WebElement clickAssignTo()
	{
		contract = getDriver().findElement(By.xpath("//*[@title='None selected']"));
		return contract;
	}
	
	public static WebElement clickSearchBox()
	{
		contract = getDriver().findElement(By.xpath("//input[@placeholder='Type to Search for User..']"));
		return contract;
	}
	
	public static WebElement checkProgress()
	{
		contract = getDriver().findElement(By.xpath("//*[@id='imgUpdateProgress']"));
		return contract;
	}
	
	public static WebElement checkDownload()
	{
		contract = getDriver().findElement(By.xpath("//*[@id='grdTaskContractDocuments_lnkBtnDownloadTaskDoc_0']"));
		return contract;
	}
	
	public static WebElement clickAddDocument()
	{
		contract = getDriver().findElement(By.xpath("//*[@id='imgAddNewTaskDoc']"));
		return contract;
	}
	
	public static WebElement clickDocumentType()
	{
		contract = getDriver().findElement(By.xpath("//*[@id='ddlDocType_chosen']"));
		return contract;
	}
	
	public static WebElement clickChooseFile()
	{
		contract = getDriver().findElement(By.xpath("//*[@id='ContractFileUpload']"));
		return contract;
	}
	
	public static WebElement clickUpload()
	{
		contract = getDriver().findElement(By.xpath("//*[@id='lnkDocumentUpload']"));
		return contract;
	}
	
	public static WebElement readMessage1()
	{
		contract = getDriver().findElement(By.xpath("//*[@id='vsContractDocument']"));
		return contract;
	}
	
	public static WebElement clickClose1()
	{
		contract = getDriver().findElement(By.xpath("//*[@onclick='CloseMe();']"));
		return contract;
	}
	
	public static WebElement clickSelectAll()
	{
		contract = getDriver().findElement(By.xpath("//*[@id='grdTaskContractDocuments_chkHeaderTaskDocument']"));
		return contract;
	}
	
	public static WebElement clickCreatAndAssign()
	{
		contract = getDriver().findElement(By.xpath("//*[@id='btnTaskSave']"));
		return contract;
	}
	
	public static WebElement readMessage2()
	{
		contract = getDriver().findElement(By.xpath("//*[@id='vsTaskTab']/ul/li[1]"));
		return contract;
	}
	
	public static WebElement clickApproveRadio()
	{
		contract = getDriver().findElement(By.xpath("//*[@id='rbTaskType_1']"));
		return contract;
	}
	
	public static WebElement clickTaskMenu()
	{
		contract = getDriver().findElement(By.xpath("//*[@id='Tasklistmenu']"));
		return contract;
	}
	
	public static WebElement clickTask()
	{
		contract = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_lnkTask']"));
		return contract;
	}
	
	public static WebElement clickStatus()
	{
		contract = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlTaskStatus_chosen']"));
		return contract;
	}
	
	public static WebElement clickAllTask()
	{
		contract = getDriver().findElement(By.xpath("//div[@id='ContentPlaceHolder1_ddlTaskAssigned_chosen']"));
		return contract;
	}
	
	public static WebElement clickApply()
	{
		contract = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_lnkBtnApplyFilter']"));
		return contract;
	}
	
	public static List<WebElement> readAssignedTo()
	{
		elementsList = getDriver().findElements(By.xpath("//*[@id='ContentPlaceHolder1_grdTaskActivity']/tbody/tr/td[6]/div/span"));
		return elementsList;
	}
	
	public static List<WebElement> clickAction()
	{
		elementsList = getDriver().findElements(By.xpath("//*[contains(@id,'ContentPlaceHolder1_grdTaskActivity_lnkBtnTaskResponse')]"));
		return elementsList;
	}
	
	public static WebElement clickStatus1()
	{
		contract = getDriver().findElement(By.xpath("//*[@id='ddlStatus_chosen']"));
		return contract;
	}
	
	public static WebElement clickComment()
	{
		contract = getDriver().findElement(By.xpath("//*[@id='tbxTaskResComment']"));
		return contract;
	}
	
	public static WebElement clickChooseFile1()
	{
		contract = getDriver().findElement(By.xpath("//*[@id='fuTaskResponseDocUpload']"));
		return contract;
	}
	
	public static WebElement readMsg()
	{
		contract = getDriver().findElement(By.xpath("//*[@id='vsTaskResponse']/ul/li"));
		return contract;
	}
	
	public static WebElement clickClose2()
	{
		contract = getDriver().findElement(By.xpath("//*[@onclick='javascript:reloadTaskList();']"));
		return contract;
	}
	
	public static WebElement clickApproved()
	{
		contract = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_divApprovedcount']"));
		return contract;
	}
	
	public static WebElement clickPendingApprove()
	{
		contract = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_divPendingApprovalCount']"));
		return contract;
	}
	
	public static WebElement clickMyDocuments()
	{
		contract = getDriver().findElement(By.xpath("//*[@id='leftdocumentsmenu']"));
		return contract;
	}
	
	public static WebElement clickMyDocuments1()
	{
		contract = getDriver().findElement(By.xpath("(//*[@id='DocumentShareListNew'])[1]"));
		return contract;
	}
	
	public static WebElement clickCriticalDocuments()
	{
		contract = getDriver().findElement(By.xpath("(//*[@id='DocumentShareListNew'])[2]"));
		return contract;
	}
	
	public static WebElement clickNew()
	{
		contract = getDriver().findElement(By.xpath("//*[@id='menu1']"));
		return contract;
	}
	
	public static WebElement clickNewFolder()
	{
		contract = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_lnkAddNewFolder']"));
		return contract;
	}
	
	public static WebElement clickFolderTextbox()
	{
		contract = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_txtFolderName']"));
		return contract;
	}
	
	public static WebElement clickCreateButton()
	{
		contract = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnCreateFolder']"));
		return contract;
	}
	
	public static WebElement readMsg1()
	{
		contract = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_successmsgaCTemSec']"));
		return contract;
	}
	
	public static WebElement clickAction1()
	{
		contract = getDriver().findElement(By.xpath("//a[@id='ContentPlaceHolder1_grdContractList_lnkEditContract_0']"));
		return contract;
	}
	
	public static WebElement clickEditContract()
	{
		contract = getDriver().findElement(By.xpath("//a[@id='btnEditContractDetail']"));
		return contract;
	}
	
	public static WebElement clickContractStatus()
	{
		contract = getDriver().findElement(By.xpath("//div[@id='ddlContractStatus_chosen']"));
		return contract;
	}
	
	public static WebElement selectRenewedStatus()
	{
		contract = getDriver().findElement(By.xpath("//div[@id='ddlContractStatus_chosen']/div/ul/li[9]"));
		return contract;
	}
	
	public static WebElement clickYes()
	{
		contract = getDriver().findElement(By.xpath("//input[@id='btnRenewContract']"));
		return contract;
	}
	
	public static WebElement clickDraftew()
	{
		contract = getDriver().findElement(By.xpath(""));
		return contract;
	}
	
	public static WebElement clickDrafteq()
	{
		contract = getDriver().findElement(By.xpath(""));
		return contract;
	}
	
	public static WebElement clickDraftwwq()
	{
		contract = getDriver().findElement(By.xpath(""));
		return contract;
	}
	
	public static WebElement clickDraftewq()
	{
		contract = getDriver().findElement(By.xpath(""));
		return contract;
	}
}
