package login;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.OperaDriverManager;
import performer.OverduePOM;

public class Login extends BasePage
{
	//public static WebDriver driver = null;				//WebDriver instance created
	public static WebElement upload = null;				//WebElement to get upload button
	
/*	public static void BrowserSetup(String URL) throws InterruptedException
	{
		
			//WebDriverManager.edgedriver().setup();
			//driver = new EdgeDriver();					//Created new Chrome driver instance. 
		
			//WebDriverManager.chromedriver().setup();
			// System.setProperty("webdriver.chrome.driver","E:\\eclips-projects\\Selenium\\chromedriver-win32\\chromedriver.exe");
		  	 
			WebDriverManager.chromedriver().setup();		
		   driver = new ChromeDriver();		
				
			
			//WebDriverManager.firefoxdriver().setup();
			//driver = new FirefoxDriver();
		
			//	WebDriverManager.operadriver().setup();
			//	driver = new OperaDriver();
		
		  /*  System.setProperty("webdriver.opera.driver", "E:\\eclips-projects\\Selenium\\operadriver_win64 -121 version\\operadriver.exe");
		   
		
		
		   
			driver.manage().window().maximize();			//Set window size to maximum.
			Thread.sleep(500);
			
			driver.get(URL);								//Set the URL of WebApplication.
	}*/
	
	
/*	public static void BrowserSetup1(String URL,String browser) throws Exception
	{
		
		
		if(browser.equalsIgnoreCase("firefox"))
		{
			 //create firefox instance
				System.setProperty("webdriver.gecko.driver", "E:\\eclips-projects\\Selenium\\geckodriver-v0.33.0-win64\\geckodriver.exe");
				driver = new FirefoxDriver();
			}
			//Check if parameter passed as 'chrome'
			else if(browser.equalsIgnoreCase("chrome"))
			{
				//set path to chromedriver.exe
				System.setProperty("webdriver.chrome.driver","E:\\eclips-projects\\Selenium\\chromedriver-win64\\chromedriver.exe");
				//create chrome instance
				driver = new ChromeDriver();
			
			}
			else if(browser.equalsIgnoreCase("Opera"))
			{
				//set path to chromedriver.exe
				System.setProperty("webdriver.opera.driver","E:\\eclips-projects\\Selenium\\operadriver_win32\\operadriver.exe");
				//create chrome instance
				driver = new OperaDriver();
			
			}
			//Check if parameter passed as 'Edge'
			else if(browser.equalsIgnoreCase("Edge")) 
			{
			     //set path to Edge.exeMicrosoftWebDriver
			     WebDriverManager.edgedriver().setup();
			     //System.setProperty("webdriver.edge.driver","C:\\Users\\Admin\\Desktop\\eclips-projects\\Selenium\\EdgeDriver\\msedgedriver.exe");
			     //create Edge instance
				 driver = new EdgeDriver();
			}
			else
			{
						//If no browser passed throw exception
						throw new Exception("Browser is not correct");
			}
							 
							 
		               driver.manage().window().maximize();			//Set window size to maximum.
		                driver.get(URL);
		
	}*/
	
	public static WebDriver UserLogin(String username, String password, String method) throws InterruptedException
	{		
		
		WebDriverWait wait = new WebDriverWait( getDriver(),(60));
		Thread.sleep(1000);
		LoginPOM.setUname().sendKeys(username);		//Sent username to input box 
		Thread.sleep(500);
		LoginPOM.setPassword().sendKeys(password);	//Sent password to input box
		LoginPOM.clickSubmit().click();				//Clicked on Sign-in button
		Thread.sleep(500);
		if(!username.equalsIgnoreCase("performer@avantis.info"))
		{
			try
			{
				Thread.sleep(500);
				wait.until(ExpectedConditions.visibilityOf(LoginPOM.clickQALink()));
				wait.until(ExpectedConditions.elementToBeClickable(LoginPOM.clickQALink()));
				LoginPOM.clickQALink().click();				//Clicking on QA Link instead of OTP.
				
				//----------------------------------------------------------------------------//
				
				wait.until(ExpectedConditions.invisibilityOf(LoginPOM.clickQALink()));
			}
			catch(Exception e)
			{
				
			}
			
			Thread.sleep(1000);
			wait.until(ExpectedConditions.visibilityOf(LoginPOM.Question1()));
			wait.until(ExpectedConditions.elementToBeClickable(LoginPOM.Question1()));
			String que1 = LoginPOM.Question1().getText();	//Storing the question in que variable.
			String ans1 = null;
			
			
			
			if(method.equalsIgnoreCase("cfo"))
			{
				ans1 = getAnswerCFO(que1);						//Storing the answer in ans variable.
			}
			else if(method.equalsIgnoreCase("fe"))
			{
				ans1 = getAnswerFE(que1);						//Storing the answer in ans variable.
			}
			else if(method.equalsIgnoreCase("cfo-diy"))
			{
				ans1 = "123";						//Storing the answer in ans variable.
			}
			
			else if(method.equalsIgnoreCase("company"))
			{
				ans1 = "123";						//Storing the answer in ans variable.
			}
			
			
			
			else
			{
				ans1 = getAnswer(que1);							//Storing the answer in ans variable.
			}
			
			
			if(ans1.equalsIgnoreCase("birthplace"))
				LoginPOM.Answer1().sendKeys("place");		//Sending answer to the input box.
			else
				LoginPOM.Answer1().sendKeys(ans1);		//Sending answer to the input box.
			Thread.sleep(1000);
			
			//----------------------------------------------------------//
			
			String que2 = LoginPOM.Question2().getText();	//Storing the question in que variable.
			String ans2 = null;
			if(method.equalsIgnoreCase("cfo"))
			{
				ans2 = getAnswerCFO(que2);						//Storing the answer in ans variable.
			}
			else if(method.equalsIgnoreCase("fe"))
			{
				ans2 = getAnswerFE(que2);						//Storing the answer in ans variable.
			}
			
			else if(method.equalsIgnoreCase("cfo-diy"))
			{
				ans2 = "123";						//Storing the answer in ans variable.
			}
			
			else if(method.equalsIgnoreCase("company"))
			{
				ans2 = "123";						//Storing the answer in ans variable.
			}
			else
			{
				ans2 = getAnswer(que2);							//Storing the answer in ans variable.
			}
			
			
			if(ans2.equalsIgnoreCase("birthplace"))
				LoginPOM.Answer2().sendKeys("place");		//Sending answer to the input box.
			else
				LoginPOM.Answer2().sendKeys(ans2);		//Sending answer to the input box.
			Thread.sleep(100);
			
			LoginPOM.SubmitAnswer().click();				//Clicking on Submit button.
			
			
		
		
		
//		if(!method.equalsIgnoreCase("company"))
//		{
//			//wait1.until(ExpectedConditions.elementToBeClickable(LoginPOM.clickComplicane()));
//			
//			if(method.equalsIgnoreCase("License"))
//			{
//				LoginPOM.clickLicense().click();				//Clicking on Litigation Image.
//			}
//			else if(method.equalsIgnoreCase("Litigation"))
//			{
//				LoginPOM.ClickLitigation().click();			//Clicking on Litigation Image.
//			}
//			else if(method.equalsIgnoreCase("Contract"))
//			{
//				LoginPOM.ClickContract().click();			//Clicking on Litigation Image.
//			}
////			
//			else
//			{
//				LoginPOM.ClickLitigation().click();	
//			//	LoginPOM.clickComplicane().click();			//Clicking on Compliance Image.
//			}
//			
//			
//	
		}
//	Thread.sleep(2000);
//	LoginPOM.ClickLitigation().click();
	
	//WebDriverWait wait1 = new WebDriverWait(getDriver(),(20));
	WebElement litigationBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='dvbtnLitigation']")));
	litigationBtn.click();
	
		return getDriver();
	}
	
	
	public static String getAnswer(String que)				//Method created to extract last word from question
	{														//as it is the answer of the question.
		String last = que.substring(que.lastIndexOf(" "));		//We are selecting word after last " ".
		int len = last.length();							
		String ans = last.substring(1, len-1);				//We are neglecting letters from string of position first " " and last "?"
		return ans.toLowerCase();							//Returning answer and converting to LowerCase too.  
	}
	
	public static String getAnswerCFO(String que)			//Method created to extract last word from question
	{														//as it is the answer of the question.
		String last = que.substring(que.lastIndexOf(" "));	//We are selecting word after last " ".
		int len = last.length();							
		String ans = last.substring(1, len-1);				//We are neglecting letters from string of position first " " and last "?"
		if(ans.equalsIgnoreCase("pet"))
			ans = "dog";
		if(ans.equalsIgnoreCase("car"))
			ans = "red";
		return ans.toLowerCase();							//Returning answer and converting to LowerCase too.  
	}
	public static String getAnswerFE(String que)			//Method created to extract last word from question
	{														//as it is the answer of the question.
		String last = que.substring(que.lastIndexOf(" "));	//We are selecting word after last " ".
		int len = last.length();							
		String ans = last.substring(1, len-1);				//We are neglecting letters from string of position first " " and last "?"
		if(ans.equalsIgnoreCase("pet"))
			ans = "dog";
		if(ans.equalsIgnoreCase("car"))
			ans = "red";
		return ans.toLowerCase();							//Returning answer and converting to LowerCase too.  
	}
	public static WebDriver UserLogin1(String username, String password, String method) throws InterruptedException
	{		
		WebDriverWait wait = new WebDriverWait(getDriver(), 20);
		WebDriverWait wait1 = new WebDriverWait(getDriver(), 60);
		
		LoginPOM.setUname().clear();
		LoginPOM.setUname().sendKeys(username);		//Sent username to input box 
		Thread.sleep(500);
		LoginPOM.setPassword().sendKeys(password);	//Sent password to input box
		LoginPOM.clickSubmit().click();				//Clicked on Sign-in button
		
		return getDriver();
    }
	
	  public static WebDriver forgotPassword() throws InterruptedException, IOException
		
		{
	
		  
		LoginPOM.ClickForgotPass().click();
		
		//LoginPOM.ClickEmailid().sendKeys("");
		
		Thread.sleep(2000);
		LoginPOM.ClickSubmit().click();
		Thread.sleep(2000);
		LoginPOM.ClickBackButton().click();
		return getDriver();
	}
	  
	  public static void AccountLocked(ExtentTest test, String type) throws InterruptedException, IOException
		
		{
		WebDriverWait wait1 = new WebDriverWait(getDriver(), 60);
		
	
		Thread.sleep(2000);
		LoginPOM.ClickAccountLocked().click();
		
		//LoginPOM.ClickEmailid().sendKeys("");
		Thread.sleep(2000);
		LoginPOM.ClickSubmit().click();
		Thread.sleep(2000);
		LoginPOM.ClickBackButton1().click();
	}
	  public static void Google(ExtentTest test, String type) throws InterruptedException, IOException
		
		{
		WebDriverWait wait1 = new WebDriverWait(getDriver(), 60);
		
		
		LoginPOM.ClickGoogle().click();
		
		//LoginPOM.ClickEmailid().sendKeys("");
		//LoginPOM.ClickSubmit().click();
		//LoginPOM.ClickBackButton().click();
	}
	  public static void LoginHelp(ExtentTest test, String type) throws InterruptedException, IOException
		
		{
		WebDriverWait wait1 = new WebDriverWait(getDriver(), 60);
		
		LoginPOM.ClickLoginHelp().click();
		
		
	}
}
