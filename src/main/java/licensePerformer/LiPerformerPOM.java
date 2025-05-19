package licensePerformer;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import login.BasePage;

public class LiPerformerPOM extends BasePage
{
	private static WebElement license = null;		
	private static List<WebElement> elementsList = null;	//WebElement list created for selecting Status-Asc/Desc (Status shows multiple elements back side)
	
	public static WebElement clickActive()			//Searching 'My Admins' link
	{
		license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_divActiveCount']"));
		return license;
	}
	
	public static WebElement Progress()
	{
		license = getDriver().findElement(By.xpath("//*[@id='imgUpdateProgress']"));
		return license;
	}
	
	public static WebElement clickAction()
	{
		license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdLicenseList_lnkEditLicense_0']"));
		return license;
	}
	
	public static WebElement clickComplDoc()
	{
		license = getDriver().findElement(By.xpath("//input[@id='TxtUploadocumentlnkLIc']"));
		return license;
	}
	
	public static WebElement clickComplDocInternal()
	{
		license = getDriver().findElement(By.xpath("//input[@id='TxtCompliancedocumentlnk']"));
		return license;
	}
	
	public static WebElement clickComplDocAddButton()
	{
		license = getDriver().findElement(By.xpath("//input[@id='UploadlinkCompliancefile']"));
		return license;
	}
	
	public static WebElement readMessage()
	{
		license = getDriver().findElement(By.xpath("//*[@id='ValidationSummary1']"));
		return license;
	}
	
	public static WebElement clickClose()
	{
		license = getDriver().findElement(By.xpath("//*[@onclick='closeModal();']"));
		return license;
	}
	
	public static WebElement clickPendingForReview()		//Searching 'Pending For Review' image link
	{
		license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_divPendingForReview']"));
		return license;
	}
	
	public static WebElement clickApplied()					//Searching 'Applied' image link
	{
		license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_divAppliedcount']"));
		return license;
	}
	
	public static WebElement readMsg()						//Searching 'Message' after submit
	{
		license = getDriver().findElement(By.xpath("//*[@id='VSLicensePopup']"));
		return license;
	}
	
	public static WebElement clickExpiring()				//Searching 'Expiring' image to click
	{
		license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_divExpiringcount']"));
		return license;
	}
	
	public static WebElement clickCheckbox()				//Searching 'Checkbox' to click
	{
		license = getDriver().findElement(By.xpath("//*[@id='chkPenaltySave']"));
		return license;
	}
	
	public static WebElement clickExpired()					//Searching 'Expired' image link to click
	{
		license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_divExpiredCount']"));
		return license;
	}
	
	public static WebElement clickType()
	{
		license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlComplianceType']"));
		return license;
	}
	
	public static List<WebElement> clickDownload()		//Searching 'Download' button to click.
	{
		elementsList = getDriver().findElements(By.xpath("//*[contains(@id,'ContentPlaceHolder1_grdLicenseList_lblDownLoadfile')]"));
		return elementsList;
	}
	
	public static List<WebElement> clickDownload1()		//Searching 'Download' button to click.
	{
		elementsList = getDriver().findElements(By.xpath("//*[@class='k-grid-content k-auto-scrollable']/table/tbody/tr/td[9]/a[1]"));
		return elementsList;
	}
	
	public static WebElement clickMyDocuments()			//Searching 'My Documents' link
	{
		license = getDriver().findElement(By.xpath("//*[@id='leftdocumentsmenu']"));
		return license;
	}
	
	public static WebElement clickMyDocumentsMenu()			//Searching 'My Documents' link
	{
		license = getDriver().findElement(By.xpath("//li[@id='leftdocumentsmenu']/ul/li[1]"));
		return license;
	}
	
	public static WebElement clickMyReport()
	{
		license = getDriver().findElement(By.xpath("//*[@id='leftreportsmenu']"));
		return license;
	}
	
	public static WebElement clickStatus()
	{
		license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlLicenseStatus_chosen']"));
		return license;
	}
	
	public static WebElement clickStatus1()
	{
		license = getDriver().findElement(By.xpath("//*[@aria-owns='dropdownlistStatus_listbox']"));
		return license;
	}
	
	public static List<WebElement> selectStatus1()
	{
		elementsList = getDriver().findElements(By.xpath("//div[@id='dropdownlistStatus-list']/div[3]/ul/li"));
		return elementsList;
	}
	
	public static List<WebElement> selectStatus()
	{
		elementsList = getDriver().findElements(By.xpath("//*[@id='ContentPlaceHolder1_ddlLicenseStatus_chosen']/div/ul/li"));
		return elementsList;
	}
	
	public static WebElement clickApply()
	{
		license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_lnkBtnApplyFilter']"));
		return license;
	}
	
	public static WebElement clickExcel()
	{
		license = getDriver().findElement(By.xpath("//*[@id='exportReport']"));
		return license;
	}
	
	public static WebElement clickView()
	{
		license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdLicenseList_lnkEditLicense_0']"));
		return license;
	}
	
	public static WebElement clickType1()
	{
		license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlComplianceType']"));
		return license;
	}
	
	public static WebElement clickType2()
	{
		license = getDriver().findElement(By.xpath("//*[@aria-owns='dropdownlistComplianceType_listbox']"));
		return license;
	}
	
	public static WebElement selectInternal()
	{
		license = getDriver().findElement(By.xpath("//*[@id='dropdownlistComplianceType_listbox']/li[2]"));
		return license;
	}
	
	public static WebElement checkTable()
	{
		license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdLicenseList']"));
		return license;
	}
	
	public static WebElement readTotalRecords()
	{
		license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_lblTotalRecord']"));
		return license;
	}
	
	public static WebElement readTotalRecords1()
	{
		license = getDriver().findElement(By.xpath("//span[@class='k-pager-info k-label']"));
		return license;
	}
	
	public static WebElement clickAon()
	{
		license = getDriver().findElement(By.xpath(""));
		return license;
	}
	
	public static WebElement clickAyn()
	{
		license = getDriver().findElement(By.xpath(""));
		return license;
	}
	
	public static WebElement clickAyen()
	{
		license = getDriver().findElement(By.xpath(""));
		return license;
	}
	
	public static WebElement clickAeons()
	{
		license = getDriver().findElement(By.xpath(""));
		return license;
	}
}
