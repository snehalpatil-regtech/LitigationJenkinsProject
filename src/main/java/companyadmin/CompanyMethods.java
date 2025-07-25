package companyadmin;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;



import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cfo.CFOcountPOM;
import litigationAdditionalOwner.performerPOM;
import login.BasePage;



public class CompanyMethods extends BasePage

{
	
	public static FileInputStream fis = null;	//File input stream variable
	public static XSSFWorkbook workbook = null;	//Excel sheet workbook variable
	public static XSSFSheet sheet = null;		//Sheet variable
	public static XSSFSheet sheet1 = null;		//Sheet variable

	public static void UserLogReport( ExtentTest test) throws InterruptedException, IOException
	{
	
		
		try
		{
			Thread.sleep(5000);
	       	CompanyPOM.clickAlertpopup().click();	
	       	//test.log(LogStatus.PASS, "Alert Popup should be displayed");
		}
		catch(Exception e)
		{
			test.log(LogStatus.PASS, "Alert Popup should  not be displayed");
		}
		
		Thread.sleep(5000);
       	CompanyPOM.clickNotificatonpopup().click();	
		
		
       	SwitchtoChild(test);
     	
    	Thread.sleep(5000);
       	CompanyPOM.clickReport().click();
       	
       
       	if(CompanyPOM.clickUserLogReport().isDisplayed())
		{
			Thread.sleep(7000);
			CompanyPOM.clickUserLogReport().click();
			test.log(LogStatus.PASS, "The tab of User Log Report should be seen under the tab of Report dropdown.");
		}
		else
		{
			test.log(LogStatus.FAIL, "The tab of User Log Report should not be seen under the tab of Report dropdown.");
		}
       	
       	SwitchtoParent(test);
       	
       	
       	
	}
	public static void ExportButton( ExtentTest test) throws InterruptedException, IOException
	{
		
		
			Thread.sleep(5000);
	       	CompanyPOM.clickAlertpopup().click();	
	       	
		
	      
		Thread.sleep(5000);
       	CompanyPOM.clickNotificatonpopup().click();	
		
		
       	SwitchtoChild(test);
     	
    	Thread.sleep(5000);
       	CompanyPOM.clickReport().click();
       	
     
       	
       	Thread.sleep(7000);
		CompanyPOM.clickUserLogReport().click();
		
		SwitchtoParent(test);
		
	 	Thread.sleep(2000);
		SwitchtoChild1(test);
		
		Thread.sleep(7000);
		CompanyPOM.clickUsers().click();
		
		Thread.sleep(7000);
		CompanyPOM.clickUserName().click();
		
		Thread.sleep(7000);
		CompanyPOM.clickAppyButton().click();
	
		Actions a = new Actions(getDriver());
		//scroll down a page
		a.sendKeys(Keys.PAGE_DOWN).build().perform();
		
		Thread.sleep(1000);
		CFOcountPOM.readTotalItems1().click();
		String item1 = CFOcountPOM.readTotalItems1().getText();
		String[] bits1 = item1.split(" ");								//Splitting the String
		String compliancesCount1 = bits1[bits1.length - 2];				//Getting the second last word (total number of users)
		int count2 = Integer.parseInt(compliancesCount1);
		
	    try
		{
	    	CompanyPOM.clickExport().sendKeys(Keys.PAGE_DOWN);
		}
		catch(Exception e)
		{
			
		}
		//js.executeScript("window.scrollBy(0,1000)");
		
	
		Thread.sleep(100);
		File dir = new File("C:\\Users\\snehalp\\Downloads");
		File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
		
		Thread.sleep(500);
		CFOcountPOM.clickNextPage1().sendKeys(Keys.PAGE_UP);
		Thread.sleep(250);
		CompanyPOM.clickExport().click();					//Clicking on 'Excel Report' image.
		test.log(LogStatus.PASS, "File downloaded successfully.");
		
		Thread.sleep(5500);
		File dir1 = new File("C:\\Users\\snehalp\\Downloads");
		File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download
		
		if(dirContents.length < allFilesNew.length)
		{
			
			
			File lastModifiedFile = allFilesNew[0];			//Storing any 0th index file in 'lastModifiedFile' file name.
		    for (int i = 1; i < allFilesNew.length; i++) 	//For loop till the number of files in directory.
		    {
		       if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) 	//If allFilesNew[i] file is having large/latest time time of update then latest modified file be allFilesNew[i] file.
		       {
		           lastModifiedFile = allFilesNew[i];
		       }
		    }
			
			Thread.sleep(100);
			fis = new FileInputStream(lastModifiedFile);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheetAt(0);					//Retrieving first sheet of Workbook
			
			int no = sheet.getLastRowNum();
			Row row = sheet.getRow(no);
			Cell c1 = row.getCell(0);
			int records =(int) c1.getNumericCellValue();
			fis.close();
			
			if(count2 == records)
			{
				//test.log(LogStatus.PASS, "No of records from grid matches to no of records in Excel Sheet.");
				test.log(LogStatus.PASS, "Total records from Grid = "+count2+" | Total records from Report = "+records);
			}
			else
			{
				//test.log(LogStatus.FAIL, "No of records from grid doesn't matches to no of records in Excel Sheet.");
				test.log(LogStatus.FAIL, "Total records from Grid = "+count2+" | Total records from Excel Sheet = "+records);
			}
		}
		else
		{
			test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
		}
		
		SwitchtoParent(test);
	}
	public static void SelectMultipleUsers( ExtentTest test) throws InterruptedException, IOException
	{
		
		Thread.sleep(5000);
	    CompanyPOM.clickAlertpopup().click();	
	      
		Thread.sleep(5000);
       	CompanyPOM.clickNotificatonpopup().click();	
		
		
       	SwitchtoChild(test);
     	
    	Thread.sleep(5000);
       	CompanyPOM.clickReport().click();
       	
       	Thread.sleep(7000);
		CompanyPOM.clickUserLogReport().click();
		
		SwitchtoParent(test);
		
	 	Thread.sleep(2000);
		SwitchtoChild1(test);
		
		Thread.sleep(7000);
		CompanyPOM.clickUsers().click();
		
		Thread.sleep(7000);
		CompanyPOM.clickUserName().click();
		
		Thread.sleep(7000);
		CompanyPOM.clickUserName1().click();
		
		
		Thread.sleep(4000);
	  	if(CompanyPOM.clickAppyButton().isEnabled())
			{
				Thread.sleep(4000);
				CompanyPOM.clickAppyButton().click();
				test.log(LogStatus.PASS, " Multiple users selected  from the user dropdown.");
			}
			else
			{
				test.log(LogStatus.FAIL, " Multiple users not selected  from the user dropdown.");
			}
	  	Thread.sleep(4000);
	       	SwitchtoParent(test);
	  }
	public static void UserFilter( ExtentTest test) throws InterruptedException, IOException
	{
		
			Thread.sleep(5000);
			CompanyPOM.clickAlertpopup().click();	
	      
			Thread.sleep(5000);
			CompanyPOM.clickNotificatonpopup().click();	
		
		
       		SwitchtoChild(test);
     	
       		Thread.sleep(5000);
    		CompanyPOM.clickReport().click();
       	
       		Thread.sleep(7000);
       		CompanyPOM.clickUserLogReport().click();
		
			SwitchtoParent(test);
			
	 		Thread.sleep(2000);
	 		SwitchtoChild1(test);
		
		
		  	Thread.sleep(500);
		  	CompanyPOM.clickUsers().click();
		   	Thread.sleep(500);
	       	String user=CompanyPOM.clickUserName().getText();
	       	Thread.sleep(500);
	       	CompanyPOM.clickUserName().click();
	       	Thread.sleep(500);
			  CompanyPOM.clickAppyButton().click();
			  
			  
			  List<String> li=new ArrayList<String>();
		        li.add(user);
		        
		        List<String> filter=new ArrayList<String>();	
				filter.add("user");
				
				Actions a = new Actions(getDriver());
				//scroll down a page
				a.sendKeys(Keys.PAGE_DOWN).build().perform();
				
				CFOcountPOM.readTotalItems1().click();					//Clicking on Text of total items just to scroll down.
				String s = CFOcountPOM.readTotalItems1().getText();
				Thread.sleep(2000);

				if(!s.equalsIgnoreCase("No items to display")) {
				Thread.sleep(5000);
			
				List<WebElement> usercol=getDriver().findElements(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr/td[1]"));
				
				for(int i=0; i<li.size(); i++){
					
					List<String> text= new ArrayList<String>();
					HashSet<String> pass=new LinkedHashSet<>();
					HashSet<String> fail=new LinkedHashSet<>();
					List<WebElement> raw=new ArrayList<WebElement>();

						if(i==0)
						{
							raw.addAll(usercol);
						}
						
						for(int k=0;k<raw.size();k++)
						{
							text.add(raw.get(k).getText());
						}

						for(int l=0;l<text.size();l++)
						{
							
				
							
							if(text.get(l).equals(li.get(i)))
							{
							
							
								pass.add(text.get(l));	
								System.out.println("pass : "+text.get(l)+" : "+li.get(i));

							}
							else
							{
								fail.add(text.get(l));		
								System.out.println("fail : "+text.get(l)+" : "+li.get(i));
								System.out.println(i);

							}
						 }
						
					for(String Fal : fail)
					{
							test.log(LogStatus.FAIL, filter.get(i)+" column shows incorrect value : "+Fal);
					}	
					for(String Pas : pass)
					{
						test.log(LogStatus.PASS,  filter.get(i)+" dropdown working properly.");
						test.log(LogStatus.PASS, filter.get(i)+" displayed : "+Pas);	
						System.out.println(filter.get(i)+" : "+Pas);
					}
						text.clear();
						pass.clear();
						fail.clear();
						raw.clear();
				
				
					}
					}
					else 
					{
						test.log(LogStatus.PASS,"No records found");	
					}
				Thread.sleep(4000);
		       	SwitchtoParent(test);
	}
		
		
	public static void SwitchtoChild(ExtentTest test) throws InterruptedException, IOException
	{		
		Thread.sleep(3000);
		CompanyPOM.clickMyAdmin().click();
		Set w = getDriver().getWindowHandles();    // window handles
		Thread.sleep(3000);
	      Iterator t = w.iterator();  // window handles iterate
	      String pw = (String) t.next();
	      String ch = (String) t.next();
	      
	      getDriver().switchTo().window(ch);         // switching child window
	  }
	public static void SwitchtoChild1(ExtentTest test) throws InterruptedException, IOException
	{		
		//Thread.sleep(3000);
		//CompanyPOM.clickMyAdmin().click();
		Set w = getDriver().getWindowHandles();    // window handles
		Thread.sleep(3000);
	      Iterator t = w.iterator();  // window handles iterate
	      String pw = (String) t.next();
	      String ch = (String) t.next();
	      
	      getDriver().switchTo().window(ch);         // switching child window
	  }


public static void SwitchtoParent(ExtentTest test) throws InterruptedException, IOException
	{		
		Thread.sleep(3000);
		
		Set w = getDriver().getWindowHandles();    // window handles
		Thread.sleep(3000);
	      Iterator t = w.iterator();  // window handles iterate
	      String pw = (String) t.next();
	      String ch = (String) t.next();
	      getDriver().close();
	      Thread.sleep(3000);
	      getDriver().switchTo().window(pw);         // switching child window
	       
	}




}
