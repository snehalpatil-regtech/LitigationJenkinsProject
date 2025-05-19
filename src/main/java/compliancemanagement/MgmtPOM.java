package compliancemanagement;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import login.BasePage;

public class MgmtPOM extends BasePage
{
		private static WebElement mgmt = null;				//WebElement variable created for 'Categories' click
		private static List<WebElement> mgmtList = null;
		
		
		public static WebElement clickMyReport()			//Searching 'Open' Notice link
		{
			
			mgmt = getDriver().	findElement(By.xpath("//*[@id='leftdocumentsmenu1']/a/span[1]"));
			return mgmt;
		}
		public static WebElement clickUserLogReport()			//Searching 'Open' Notice link
		{
			
			mgmt = getDriver().	findElement(By.xpath("//*[@id='Userlogreport']/a"));
			return mgmt;
		}
		public static WebElement clickUserFilter()			//Searching 'Open' Notice link
		{
			
			mgmt = getDriver().	findElement(By.xpath("//*[@id='example']/div[1]/div/div"));
			return mgmt;
		}
		public static WebElement selectUser()			//Searching 'Open' Notice link
		{
			
			mgmt = getDriver().	findElement(By.xpath("//span[normalize-space()='Finance Executive']"));
			return mgmt;
		}
		public static WebElement selectUser1()			//Searching 'Open' Notice link
		{
			
			mgmt = getDriver().	findElement(By.xpath("//span[normalize-space()='Finance Manager']"));
			return mgmt;
		}
		public static WebElement clickapplybtn()			//Searching 'Open' Notice link
		{
			
			mgmt = getDriver().	findElement(By.xpath("//button[@id='Applybtn']"));
			return mgmt;
		}
		public static WebElement clickExport()			//Searching 'Open' Notice link
		{
			
			mgmt = getDriver().	findElement(By.xpath("//*[@id='exportAdvanced']"));
			return mgmt;
		}
		public static WebElement clickLeaveReport()			//Searching 'Open' Notice link
		{
			
			mgmt = getDriver().	findElement(By.xpath("//*[@id='Myreport3']/a"));
			return mgmt;
		}
		public static WebElement clickUserFilter1()			//Searching 'Open' Notice link
		{
			
			mgmt = getDriver().	findElement(By.xpath("//*[@id='example']/div[1]/div[1]/div/div"));
			return mgmt;
		}
		public static WebElement clickLeaveapplybtn()			//Searching 'Open' Notice link
		{
			
			mgmt = getDriver().	findElement(By.xpath("//button[@id='btnApply']"));
			return mgmt;
		}
		public static WebElement clickStartDateCalender()			//Searching 'Open' Notice link
		{
			
			mgmt = getDriver().	findElement(By.xpath("//span[@class='k-icon k-i-calendar']"));
			return mgmt;
		}
		public static WebElement clickDate()			//Searching 'Open' Notice link
		{
			
			mgmt = getDriver().	findElement(By.linkText("9"));
			return mgmt;
		}
		public static WebElement clickStartDatepiker()			//Searching 'Open' Notice link
		{
			
			mgmt = getDriver().	findElement(By.xpath("//*[@id='startDatePicker']"));
			return mgmt;
		}
		public static WebElement clickDate1()			//Searching 'Open' Notice link
		{
			
			mgmt = getDriver().	findElement(By.linkText("11"));
			return mgmt;
		}
		public static WebElement clickEndDatepiker()			//Searching 'Open' Notice link
		{
			
			mgmt = getDriver().	findElement(By.xpath("//*[@id='endDatePicker']"));
			return mgmt;
		}
		public static WebElement clickEndDateCalender()			//Searching 'Open' Notice link
		{
			
			mgmt = getDriver().	findElement(By.xpath("(//span[@class='k-icon k-i-calendar'])[2]"));
			return mgmt;
		}
		public static WebElement clickClearBtn()			//Searching 'Open' Notice link
		{
			
			mgmt = getDriver().	findElement(By.xpath("//*[@id='ClearfilterMain']"));
			return mgmt;
		}
		
}
