package licenseReviewer;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import login.BasePage;

public class LiReviewerPOM extends BasePage
{
	private static WebElement license = null;		
	private static List<WebElement> elementsList = null;	//WebElement list created for selecting Status-Asc/Desc (Status shows multiple elements back side)
	
	public static WebElement checkTable()
	{
		license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdLicenseList']"));
		return license;
	}
	
	public static WebElement checkTable1()
	{
		license = getDriver().findElement(By.xpath("//*[@class='k-grid-content k-auto-scrollable']/table/tbody/tr[1]"));
		return license;
	}
	
	public static List<WebElement> clickAction()
	{
		elementsList = getDriver().findElements(By.xpath("//*[contains(@id,'ContentPlaceHolder1_grdLicenseList_lnkEditLicense')]"));
		return elementsList;
	}
	
	public static WebElement clickIndexDropDown()
	{
		license = getDriver().findElement(By.xpath("//div[@id='ContentPlaceHolder1_DropDownListPageNo_chosen']"));
		return license;
	}
	
	public static List<WebElement> clickIndexDropDownOption()
	{
		elementsList = getDriver().findElements(By.xpath("//div[@id='ContentPlaceHolder1_DropDownListPageNo_chosen']/div/ul/li"));
		return elementsList;
	}
	
	public static WebElement clickLicenseNo()
	{
		license = getDriver().findElement(By.xpath("//*[@id='txtLicenseNo']"));
		return license;
	}
	
	public static WebElement clickLicenseTitle()
	{
		license = getDriver().findElement(By.xpath("//*[@id='txtLicenseTitle']"));
		return license;
	}
	
	public static WebElement clickStartDate()
	{
		license = getDriver().findElement(By.xpath("//*[@id='txtStartDate']"));
		return license;
	}
	
	public static WebElement clickEndDate()
	{
		license = getDriver().findElement(By.xpath("//*[@id='txtEndDate']"));
		return license;
	}
	
	public static WebElement clickDate()
	{
		license = getDriver().findElement(By.xpath("//*[@id='tbxDate1']"));
		return license;
	}
	
	public static WebElement clickDate1()
	{
		license = getDriver().findElement(By.xpath("//*[@id='tbxDate']"));
		return license;
	}
	
	public static WebElement clikTextArea()
	{
		license = getDriver().findElement(By.xpath("//*[@id='tbxRemarks1']"));
		return license;
	}
	
	public static WebElement clikTextArea1()
	{
		license = getDriver().findElement(By.xpath("//*[@id='tbxRemarks3']"));
		return license;
	}
	
	public static WebElement clickReviewer()
	{
		license = getDriver().findElement(By.xpath("//a[@id='ContentPlaceHolder1_liReviewer']"));
		return license;
	}
	
	public static WebElement clickin()
	{
		license = getDriver().findElement(By.xpath(""));
		return license;
	}
	
	public static WebElement clikAiorn()
	{
		license = getDriver().findElement(By.xpath(""));
		return license;
	}
	
	public static WebElement clictor()
	{
		license = getDriver().findElement(By.xpath(""));
		return license;
	}
	
	public static WebElement clickirn()
	{
		license = getDriver().findElement(By.xpath(""));
		return license;
	}
}
