package litigationPerformer;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import login.BasePage;

public class performerPOM extends BasePage
{
	private static WebElement litigation = null;		
	private static List<WebElement> elementsList = null;	//WebElement list created for selecting Status-Asc/Desc (Status shows multiple elements back side)
	
	public static WebElement clickNoticeOpen()			//Searching 'Open' Notice link
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_divOpenNoticeCount']"));
		return litigation;
	}
	
	public static WebElement clickNew()					//Searching 'New'
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_AddNewCaseNotice']"));
		return litigation;
	}
	
	public static WebElement clickDated()				//Searching 'Dated' input box
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='txtNoticeDate']"));
		return litigation;
	}
	
	public static WebElement clickFinancialYear()		//Searching 'Financial Year' drop down
	{
		litigation = getDriver().findElement(By.xpath("(//*[@class='multiselect dropdown-toggle btn btn-default'])[1]"));
		return litigation;
	}
	
	public static List<WebElement> chooseDropDownOption()	//Searching drop down in 'Financial Year'
	{
		elementsList = getDriver().findElements(By.xpath("//*[@id='pnlNotice']/div[1]/div[2]/div[2]/div[2]/span[1]/div/ul/li/a/label"));
		return elementsList;
	}
	
	public static WebElement clickAct()
	{
		litigation = getDriver().findElement(By.xpath("(//*[@class='multiselect dropdown-toggle btn btn-default'])[2]"));
		return litigation;
	}
	
	public static List<WebElement> chooseAct()
	{
//	div.findElement(By.className("multiselect-container dropdown-menu")).findElement(By.className("chosen-results")).findElements(By.tagName("li"));

		elementsList = getDriver().findElements(By.xpath("//*[@id='pnlNotice']/div[3]/div[1]/div[1]/span[1]/div/ul/li/a/label/input"));
		return elementsList;
	}
	
	public static List<WebElement> chooseAct1()
	{
		elementsList = getDriver().findElements(By.xpath("//*[@id='pnlCase']/div[4]/div[1]/div[1]/span[1]/div/ul/li/a/label"));
		return elementsList;
	}
	
	public static WebElement clickRefNo()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='tbxRefNo']"));
		return litigation;
	}
	
	public static WebElement clickNoticeType()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ddlNoticeCategory_chosen']"));
		return litigation;
	}
	
	public static WebElement clickUnderSection()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='tbxSection']"));
		return litigation;
	}
	
	public static WebElement clickSearch()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ddlNoticeCategory_chosen']/div/div/input"));
		return litigation;
	}
	
	public static WebElement clickOpponent()
	{
		litigation = getDriver().findElement(By.xpath("(//*[@class='multiselect dropdown-toggle btn btn-default'])[3]"));
		return litigation;
	}
	
	public static WebElement clickOppLawyer()
	{
		litigation = getDriver().findElement(By.xpath("(//*[@class='multiselect dropdown-toggle btn btn-default'])[4]"));
		return litigation;
	}
	
	public static WebElement clickSearch1()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='pnlNotice']/div[4]/div[1]/div[1]/span[1]/div/ul/li[1]/div/input"));
		return litigation;
	}
	
	public static WebElement clickSearch2()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='pnlNotice']/div[4]/div[2]/span/div/ul/li[1]/div/input"));
		return litigation;
	}
	
	public static WebElement clickSelectAll()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='pnlNotice']/div[4]/div[1]/div[1]/span[1]/div/ul/li[2]/a/label"));
		return litigation;
	}
	
	public static WebElement clickSelectAll1()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='pnlNotice']/div[4]/div[2]/span/div/ul/li[2]/a/label"));
		return litigation;
	}
	
	public static WebElement clickNoticeTitle()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='tbxTitle']"));
		return litigation;
	}
	
	public static WebElement clickNoticeDescription()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='tbxDescription']"));
		return litigation;
	}
	
	public static WebElement clickLocation()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='tbxBranch']"));
		return litigation;
	}
	
	public static WebElement clickPlus()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='tvBranchesn1']"));
		return litigation;
	}
	
	public static List<WebElement> selectLocation()
	{
		elementsList = getDriver().findElements(By.xpath("//*[contains(@id,'tvBranchest')]"));
		return elementsList;
	}
	
	public static WebElement clickJurisdiction()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ddlJurisdiction_chosen']"));
		return litigation;
	}
	
	public static WebElement clickSearch3()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ddlJurisdiction_chosen']/div/div/input"));
		return litigation;
	}
	
	public static WebElement clickDepartment()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ddlDepartment_chosen']"));
		return litigation;
	}
	
	public static WebElement clickSearch4()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ddlDepartment_chosen']/div/div/input"));
		return litigation;
	}
	
	public static WebElement clickContactDept()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ddlCPDepartment_chosen']"));
		return litigation;
	}
	
	public static WebElement clickSearch5()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ddlCPDepartment_chosen']/div/div/input"));
		return litigation;
	}
	
	public static WebElement clickNoticeTerm()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='tbxNoticeTerm']"));
		return litigation;
	}
	
	public static WebElement clickOwner()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ddlOwner_chosen']"));
		return litigation;
	}
	
	public static WebElement clickSearch6()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ddlOwner_chosen']/div/div/input"));
		return litigation;
	}
	
	public static WebElement clickWinningProspect()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ddlNoticeRisk_chosen']/a"));
		return litigation;
	}
	
	public static WebElement clickWinningProspect1()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ddlCaseRisk_chosen']/a"));
		return litigation;
	}
	
	public static WebElement selectRisk()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ddlNoticeRisk_chosen']/div/ul/li[2]"));
		return litigation;
	}
	
	public static WebElement selectRisk1()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ddlCaseRisk_chosen']/div/ul/li[2]"));
		return litigation;
	}
	
	public static WebElement clickNoticeBudget()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='tbxNoticeBudget']"));
		return litigation;
	}
	
	public static WebElement clickClaimedAmount()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='tbxClaimedAmt']"));
		return litigation;
	}
	
	public static WebElement clickState()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ddlState_chosen']"));
		return litigation;
	}
	
	public static WebElement clickSearchState()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ddlState_chosen']/div/div/input"));
		return litigation;
	}
	
	public static WebElement clickProbableAmount()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='tbxProbableAmt']"));
		return litigation;
	}
	
	public static WebElement clickProvisionalAmount()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='txtprovisionalamt']"));
		return litigation;
	}
	
	public static WebElement clickProtestMoney()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='txtprotestmoney']"));
		return litigation;
	}
	
	public static WebElement clickRisk()
	{
		litigation = getDriver().findElement(By.xpath("//div[@id='ddlRisk_chosen']"));
		return litigation;
	}
	
	public static WebElement selectRisk2()
	{
		litigation = getDriver().findElement(By.xpath("//div[@id='ddlRisk_chosen']/div/ul/li[2]"));
		return litigation;
	}
	
	public static WebElement clickPotentialImpactRadio()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='rblPotentialImpact_0']"));
		return litigation;
	}
	
	public static WebElement clickMonetary()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='tbxMonetory']"));
		return litigation;
	}
	
	public static WebElement clickLawFirm()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ddlLawFirm_chosen']"));
		return litigation;
	}
	
	public static WebElement chooseLawFirm()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ddlLawFirm_chosen']/div/div/input"));
		return litigation;
	}
	
	public static WebElement clickInternalUser()
	{
		litigation = getDriver().findElement(By.xpath("(//*[@class='multiselect dropdown-toggle btn btn-default'])[5]"));
		return litigation;
	}
	
	public static List<WebElement> chooseInternalUser()
	{
		elementsList = getDriver().findElements(By.xpath("//*[@id='pnlNoticeAssignment']/div[1]/div/span[1]/div/ul/li/a/label/input"));
		return elementsList;
	}
	
	public static List<WebElement> chooseInternalUser1()
	{
		elementsList = getDriver().findElements(By.xpath("//*[@id='pnlCaseAssignment']/div[1]/div/span[1]/div/ul/li/a/label"));
		return elementsList;
	}
	
	public static WebElement clickLawyer()
	{
		litigation = getDriver().findElement(By.xpath("(//*[@class='multiselect dropdown-toggle btn btn-default'])[6]"));
		return litigation;
	}
	
	public static List<WebElement> chooseLawyer()
	{
		elementsList = getDriver().findElements(By.xpath("//*[@id='UpdatePanel6']/div/span/div/ul/li/a/label"));
		return 		elementsList;
	}
	
	public static WebElement readTotal()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='grid']/div[3]/span"));
		return litigation;
	}
	
	public static WebElement readMessage()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='VSNoticePopup']"));
		return litigation;
	}
	
	public static WebElement readMessage1()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='VSCasePopup']"));
		return litigation;
	}
	
	public static WebElement clickClose()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='btnAddEditcase']"));
		return litigation;
	}
	
	public static WebElement clickLinkNotice()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='lnkLinkNotice']"));
		return litigation;
	}
	
	public static WebElement clickLinkCase()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='lnkLinkCase']"));
		return litigation;
	}
	
	public static WebElement clickViewDoc()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='lnkActDetails']"));
		return litigation;
	}
	
	public static WebElement clickSendMail()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='btnSendMailPopup']"));
		return litigation;
	}
	
	public static WebElement clickSendMail1()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='lnkSendMailWithDoc']"));
		return litigation;
	}
	
	public static WebElement clickEditNotice()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='btnEditNoticeDetail']"));
		return litigation;
	}
	
	public static WebElement clickEditCase()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='btnEditCaseDetail']"));
		return litigation;
	}
	
	public static WebElement clickNoticeClosed()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_divClosedNoticeCount']"));
		return litigation;
	}
	
	public static WebElement clickExcelReport()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='exportReport']"));
		return litigation;
	}
	
	public static WebElement clickCaseOpen()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_divOpenCaseCount']"));
		return litigation;
	}
	
	public static WebElement clickCaseDate()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='txtCaseDate']"));
		return litigation;
	}
	
	public static List<WebElement> clickFinanceSearchCheckbox()
	{
		elementsList = getDriver().findElements(By.xpath("//*[@id='pnlCase']/div[1]/div[2]/div[2]/div[2]/span[1]/div/ul/li/a/label"));
		return elementsList;
	}
	
	public static WebElement clickInternalCaseNo()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='tbxInternalCaseNo']"));
		return litigation;
	}
	
	public static WebElement clickCaseType()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ddlCaseCategory_chosen']"));
		return litigation;
	}
	
	public static WebElement clickSearchCaseType()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ddlCaseCategory_chosen']/div/div/input"));
		return litigation;
	}
	
	public static WebElement clickCaseBudget()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='tbxCaseBudget']"));
		return litigation;
	}
	
	public static WebElement clickSearchBox()
	{
		litigation = getDriver().findElement(By.xpath("(//*[@placeholder='Search'])[3]"));
		return litigation;
	}
	
	public static WebElement clickSearchBox1()
	{
		litigation = getDriver().findElement(By.xpath("(//*[@placeholder='Search'])[4]"));
		return litigation;
	}
	
	public static WebElement clickSelectAll2()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='pnlCase']/div[6]/div[1]/div[1]/span[1]/div/ul/li[2]/a/label"));
		return litigation;
	}
	
	public static WebElement clickSelectAll3()
	{
		litigation = getDriver().findElement(By.xpath("(//*[@value='multiselect-all'])[4]"));
		return litigation;
	}
	
	public static WebElement clickCourt()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ddlCourt_chosen']/a"));
		return litigation;
	}
	
	public static WebElement clickSearchCourt()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ddlCourt_chosen']/div/div/input"));
		return litigation;
	}
	
	public static WebElement clickJudge()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='tbxJudge']"));
		return litigation;
	}
	
	public static WebElement clickCaseClosed()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_divClosedCaseCount']"));
		return litigation;
	}
	
	public static WebElement clickTaskOpen()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_divOpenTaskCount']"));
		return litigation;
	}
	
	public static WebElement clickAddNewTask()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_lnkAdd']"));
		return litigation;
	}
	
	public static WebElement clickTaskTitle()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='tbxTaskTitle']"));
		return litigation;
	}
	
	public static WebElement clickTaskDesc()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='tbxTaskDesc']"));
		return litigation;
	}
	
	public static WebElement clickDueDate()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='tbxTaskDueDate']"));
		return litigation;
	}
	
	public static WebElement clickPriority()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ddlTaskPriorityADD_chosen']"));
		return litigation;
	}
	
	public static WebElement clickExpOutcome()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='tbxExpOutcome']"));
		return litigation;
	}
	
	public static WebElement clickInternalUser1()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ddlTaskLawyerListInternal_chosen']"));
		return litigation;
	}
	
	public static WebElement clickSearchInternalUser1()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ddlTaskLawyerListInternal_chosen']/div/div/input"));
		return litigation;
	}
	
	public static WebElement clickExternalUser()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ddlTaskUserExternal_chosen']"));
		return litigation;
	}
	
	public static WebElement clickSearchExternalUser()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ddlTaskUserExternal_chosen']/div/div/input"));
		return litigation;
	}
	
	public static WebElement clickRemark()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='tbxTaskRemark']"));
		return litigation;
	}
	
	public static WebElement clickUpload()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='fuTaskDocUpload']"));
		return litigation;
	}
	
	public static WebElement clickMessage()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='VsAddTasValidateSuccess']"));
		return litigation;
	}
	
	public static WebElement clickClose1()
	{
		litigation = getDriver().findElement(By.xpath("//*[@onclick='javascript:reloadTaskList();']"));
		return litigation;
	}
	
	public static WebElement clickTaskClosed()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_divClosedTaskCount']"));
		return litigation;
	}
	
	public static WebElement clickStatusDropDown()
	{
		litigation = getDriver().findElement(By.xpath("(//*[@class='k-multiselect-wrap k-floatwrap'])[3]"));
		return litigation;
	}
	
	public static WebElement selectStatusDropDown()
	{
		litigation = getDriver().findElement(By.xpath("(//*[@class='k-group k-treeview-lines']/li[1])[2]"));
		return litigation;
	}
	
	public static WebElement GridLoad()
	{
		litigation = getDriver().findElement(By.xpath("//div[@class='k-grid-content k-auto-scrollable']"));
		return litigation;
	}
	
	public static WebElement clickGridElement()
	{
		litigation = getDriver().findElement(By.xpath("//div[@class='k-grid-content k-auto-scrollable']/table/tbody/tr[2]/td[1]"));
		return litigation;
	}
	
	public static List<WebElement> clickAction()
	{
		elementsList = getDriver().findElements(By.xpath("//*[@class='k-button k-button-icontext ob-edit k-grid-edit']"));
		return elementsList;
	}
	
	public static WebElement clickCheckBox()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='grdNoticeList_LinkNotice_chkRowLinkCases_0']"));
		return litigation;
	}
	
	public static WebElement clickApply()
	{
		litigation = getDriver().findElement(By.xpath("//a[@id='lnkLinkCaseFilter']"));
		return litigation;
	}
	
	public static WebElement clickApply1()
	{
		litigation = getDriver().findElement(By.xpath("//a[@id='lnkLinkNoticeFilter']"));
		return litigation;
	}
	
	public static WebElement clickSave()
	{
		litigation = getDriver().findElement(By.xpath("//*[@value='Save']"));
		return litigation;
	}
	
	public static WebElement readMsg()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='vsLinkCase']"));
		return litigation;
	}
	
	public static WebElement clickClosePopup()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='divLinkNoticePopup']/div/div/div[1]/button"));
		return litigation;
	}
	
	public static WebElement readRef()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='grdNoticeList_LinkNotice']/tbody/tr[2]/td[3]/div/span"));
		return litigation;
	}
	
	public static List<WebElement> readRef1()
	{
		elementsList = getDriver().findElements(By.xpath("//*[contains(@id,'grdLinkedNotices_lblCaseNo')]"));
		return elementsList;
	}
	
	public static WebElement clickMyWorkspace()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='leftworkspacemenu']"));
		return litigation;
	}
	
	public static WebElement clickStatus()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='childrow']/div/div[3]/div/span"));
		return litigation;
	}
	
	public static WebElement clickStatusPayments()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='lnkNoticeStatusPayment']"));
		return litigation;
	}
	
	public static WebElement clickNoticeStatus()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ddlNoticeStatus_chosen']"));
		return litigation;
	}
	
	public static WebElement clickClosedStatus()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ddlNoticeStatus_chosen']/div/ul/li[2]"));
		return litigation;
	}
	
	public static WebElement clickCloseDate()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='tbxNoticeCloseDate']"));
		return litigation;
	}
	
	public static WebElement clickNoticeResult()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ddlNoticeResult_chosen']"));
		return litigation;
	}
	
	public static WebElement clickSelectResult()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ddlNoticeResult_chosen']/div/div/input"));
		return litigation;
	}
	
	public static WebElement clickRemark1()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='tbxCloseRemark']"));
		return litigation;
	}
	
	public static WebElement clickSave1()
	{
		litigation = getDriver().findElement(By.xpath("//input[@id='btnSaveStatus']"));
		return litigation;
	}
	
	public static WebElement readMessage2()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ValidationSummary3']"));
		return litigation;
	}
	
	public static WebElement clickCourtCaseNo()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='tbxAppealCaseNo']"));
		return litigation;
	}
	
	public static WebElement clickSaveConvertCase()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='btnSaveConvertCase']"));
		return litigation;
	}
	
	public static WebElement clickCaseStatusPayments()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='lnkCaseStatus']"));
		return litigation;
	}
	
	public static WebElement clickCaseStatus()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ddlCaseStatus_chosen']"));
		return litigation;
	}
	
	public static WebElement clickCaseStatusClose()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ddlCaseStatus_chosen']/div/ul/li[3]"));
		return litigation;
	}
	
	public static WebElement clickCaseCloseDate()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='tbxCaseCloseDate']"));
		return litigation;
	}
	
	public static WebElement clickCaseResult()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ddlCaseResult_chosen']"));
		return litigation;
	}
	
	public static WebElement clickSelectCaseResult()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ddlCaseResult_chosen']/div/div/input"));
		return litigation;
	}
	
	public static WebElement clickCaseStage()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ddlCaseStage_chosen']"));
		return litigation;
	}
	
	public static WebElement selectCaseStage()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ddlCaseStage_chosen']/div/div/input"));
		return litigation;
	}
	
	public static WebElement clickCaseCheckBox()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='grdCaseList_LinkCase_chkRowLinkCases_0']"));
		return litigation;
	}
	
	public static WebElement readCaseRef()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='grdCaseList_LinkCase']/tbody/tr[2]/td[3]/div/span"));
		return litigation;
	}
	
	public static List<WebElement> readCaseRef1()
	{
		elementsList = getDriver().findElements(By.xpath("//*[contains(@id,'grdLinkedCases_lblCaseNo')]"));
		return elementsList;
	}
	
	public static WebElement clickClosePopupCase()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='divLinkCasePopup']/div/div/div[1]/button"));
		return litigation;
	}
	
	public static WebElement clickMyReports()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='leftreportsmenu']"));
		return litigation;
	}
	
	public static WebElement CheckRecordsTable()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='grid']"));
		return litigation;
	}
	
	public static WebElement clickTypeDropdown()
	{
		litigation = getDriver().findElement(By.xpath("//*[@aria-owns='dropdownType_listbox']"));
		return litigation;
	}
	
	public static WebElement selectTypeCase()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='dropdownType_listbox']/li[2]"));
		return litigation;
	}
	
	public static WebElement selectTypeTask()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='dropdownType_listbox']/li[3]"));
		return litigation;
	}
	
	public static WebElement clickMyReminder()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='leftremindersmenu'][@class='leftdummy']"));
		return litigation;
	}
	
	public static WebElement clickAddNew1()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='Addnew']"));
		return litigation;
	}
	
	public static WebElement clickType()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ddlTypePopup_chosen']"));
		return litigation;
	}
	
	public static WebElement clickTitle()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ddlTitlePopup_chosen']"));
		return litigation;
	}
	
	public static WebElement clickReminderText()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='txtReminderTitle']"));
		return litigation;
	}
	
	public static WebElement clickDescription()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='txtReminderDesc']"));
		return litigation;
	}
	
	public static WebElement clickRemark2()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='txtRemark']"));
		return litigation;
	}
	
	public static WebElement clickDate()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='txtRemindOn']"));
		return litigation;
	}
	
	public static WebElement readMsg1()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='vsReminder']"));
		return litigation;
	}
	
	public static WebElement clickCloseReminder()
	{
		litigation = getDriver().findElement(By.xpath("//*[@onclick='CloseMyReminderPopup();']"));
		return litigation;
	}
	
	public static WebElement clickMasters()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='leftmastermenu']"));
		return litigation;
	}
	
	public static WebElement clickMastersMenu()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='leftmastermenu']/ul"));
		return litigation;
	}
	
	public static WebElement clickAddNew2()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnAddPromotor']"));
		return litigation;
	}
	
	public static WebElement clickCaseNoticeType()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='tbxCaseType']"));
		return litigation;
	}
	
	public static WebElement readMesg()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ValidationSummary1']"));
		return litigation;
	}
	
	public static WebElement clickClose2()
	{
		litigation = getDriver().findElement(By.xpath("//*[@onclick='RefreshParent()']"));
		return litigation;
	}
	
	public static WebElement clickDtei()
	{
		litigation = getDriver().findElement(By.xpath(""));
		return litigation;
	}
	
	public static WebElement clickDtevrt()
	{
		litigation = getDriver().findElement(By.xpath(""));
		return litigation;
	}
	
	public static WebElement clickDteir()
	{
		litigation = getDriver().findElement(By.xpath(""));
		return litigation;
	}
}
