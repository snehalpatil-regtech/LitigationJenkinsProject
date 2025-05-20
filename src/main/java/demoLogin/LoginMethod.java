package demoLogin;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import licensePerformer.LiPerformerPOM;
import login.BasePage;
import login.LoginPOM;

public class LoginMethod extends BasePage {
	

	private static WebElement litigation = null;		
	//public static WebDriver driver = null;				//WebDriver instance created
	public static WebElement upload = null;				//WebElement to get upload button
	
	
	 public static void correctUnPassword() throws InterruptedException, IOException
		
	 {

		 
		 //WebDriverWait wait= new WebDriverWait(getDriver(),30);
//		 WebElement UsernamePass  =driver.findElement(By.xpath("//*[@id='txtemail']"));
//		 UsernamePass.sendKeys("ganesh123@avantis.info");
				
	    login.LoginPOM.setUname().sendKeys("ganesh123@avantis.info");		//Sent username to input box 
		Thread.sleep(500);
		login.LoginPOM.setPassword().sendKeys("admin@123");	//Sent password to input box
		LoginPOM.clickSubmit().click();				//Clicked on Sign-in button
		
	 }
	
	
		
		  public static void correctPassword() throws InterruptedException, IOException
			
			{
			WebDriverWait wait1 = new WebDriverWait(getDriver(), 60);
			
			LoginPOM.setUname().sendKeys("ganesh12@avantis.info");		//Sent username to input box 
			Thread.sleep(500);
			LoginPOM.setPassword().sendKeys("admin@123");	//Sent password to input box
			LoginPOM.clickSubmit().click();				//Clicked on Sign-in button
			
		}
		  public static void correctUsername(ExtentTest test, String type) throws InterruptedException, IOException
			
			{
			WebDriverWait wait1 = new WebDriverWait(getDriver(), 60);
			
			LoginPOM.setUname().sendKeys("ganesh123@avantis.info");		//Sent username to input box 
			Thread.sleep(500);
			LoginPOM.setPassword().sendKeys("admin13");	//Sent password to input box
			LoginPOM.clickSubmit().click();				//Clicked on Sign-in button
			
		}
		  public static void IncorrectUsernamePassword(ExtentTest test, String type) throws InterruptedException, IOException
			
			{
			WebDriverWait wait1 = new WebDriverWait(getDriver(), 60);
			
			LoginPOM.setUname().sendKeys("companyadmin");		//Sent username to input box 
			Thread.sleep(500);
			LoginPOM.setPassword().sendKeys("admin123");	//Sent password to input box
			LoginPOM.clickSubmit().click();				//Clicked on Sign-in button
			
		}
		  public static void forgotPassword(ExtentTest test, String type) throws InterruptedException, IOException
			
			{
		
			
			LoginPOM.ClickForgotPass().click();
			
			LoginPOM.ClickEmailid().sendKeys("");
			LoginPOM.ClickSubmit().click();
			LoginPOM.ClickBackButton().click();
		}
		  public static void AccountLocked(ExtentTest test, String type) throws InterruptedException, IOException
			
			{
			WebDriverWait wait1 = new WebDriverWait(getDriver(), 60);
			
			LoginPOM.ClickAccountLocked().click();
			
			LoginPOM.ClickEmailid().sendKeys("");
			LoginPOM.ClickSubmit().click();
			LoginPOM.ClickBackButton().click();
		}
		  public static void Google(ExtentTest test, String type) throws InterruptedException, IOException
			
			{
			WebDriverWait wait1 = new WebDriverWait(getDriver(), 60);
			
			LoginPOM.ClickGoogle().click();
			
			LoginPOM.ClickEmailid().sendKeys("");
			LoginPOM.ClickSubmit().click();
			LoginPOM.ClickBackButton().click();
		}
		  public static void LoginHelp(ExtentTest test, String type) throws InterruptedException, IOException
			
			{
			WebDriverWait wait1 = new WebDriverWait(getDriver(), 60);
			
			LoginPOM.ClickLoginHelp().click();
			
			
		}
}
	
	
		


