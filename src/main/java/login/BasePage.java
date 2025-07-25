package login;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import javax.xml.datatype.Duration;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ThreadGuard;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;


import cfo.CFOcountPOM;
import performer.OverduePOM;

	

	public class BasePage {

		public Properties prop;
		protected static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
		String URL;
		public String browser= "chrome";	
		public String website;
		public static ExtentReports extent;			//Instance created for report file
		public static ExtentTest test;
		public static FileInputStream fis = null;	//File input stream variable
		public static XSSFWorkbook workbook = null;	//Excel sheet workbook variable
		public static XSSFSheet sheet = null;		//Sheet variable
		private final ReadWriteLock lock;
	    protected String uname;
	    protected   String password;
	    protected String url;
	    
	    String filePath ="D:\\Litigation-Project 10 April2024\\Litigation-Project 10 April2024\\TestData\\LitigationSheet.xlsx";
	    
		public static WebDriver getDriver() {
			return driver.get();
		}

		public static XSSFSheet ReadExcel(int no) throws IOException
		{
			//String workingDir = System.getProperty("webdriver.chrome.driver","C:/March2022/PerformerPom/Driver/chromedriver.exe");
			fis = new FileInputStream("D:\\Litigation-Project 10 April2024\\Litigation-Project 10 April2024\\TestData\\LitigationSheet.xlsx");
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheetAt(no);					//Retrieving third sheet of Workbook
			return sheet;
		}

		

		
	
	
	public  BasePage() {
		   // this.filePath = filePath;
		    this.lock = new ReentrantReadWriteLock();
		}
	
	public String read_Login_url(int no) throws IOException {
		  lock.readLock().lock();
	    try {
	        FileInputStream fis = new FileInputStream(filePath);
	        Workbook workbook = WorkbookFactory.create(fis);
	        Sheet sheet = workbook.getSheetAt(no);
	        Row row1 = sheet.getRow(0);
	        Cell c1 = row1.getCell(1);
	         url = c1.getStringCellValue();
	         
	        workbook.close();
	        fis.close();
	        return url;
	        
	    }
	    
	    finally {
	        lock.readLock().unlock();
	    }

	}

	
	public String read_Login_username(int no) throws IOException {
		  lock.readLock().lock();
	    try {
	        FileInputStream fis = new FileInputStream(filePath);
	        Workbook workbook = WorkbookFactory.create(fis);
	        Sheet sheet = workbook.getSheetAt(no);
	        Row row1 = sheet.getRow(1);
	        Cell c1 = row1.getCell(1);
	         uname = c1.getStringCellValue();
	        workbook.close();
	        fis.close();
	        return uname;
	    }
	    
	    finally {
	        lock.readLock().unlock();
	    }

	}

	public String read_Login_password(int no) throws IOException {
		  lock.readLock().lock();
	  try {
	      FileInputStream fis = new FileInputStream(filePath);
	      Workbook workbook = WorkbookFactory.create(fis);
	      Sheet sheet = workbook.getSheetAt(no);
	      Row row2 = sheet.getRow(2);
	      Cell c2 = row2.getCell(1);
	       password = c2.getStringCellValue();
	      workbook.close();
	      fis.close();
	      return password;
	  }
	  
	  finally {
	      lock.readLock().unlock();
	  }
	}
	
	private void openBrower(int no) throws IOException {

		if (browser.contains("chrome")) {
					System.setProperty("webdriver.chrome.driver", "D:\\eclips-projects\\eclips-projects\\Selenium\\chromedriver-win64\\chromedriver.exe");
					//WebDriverManager.chromedriver().setup();
					ChromeOptions options = new ChromeOptions();
					options.addArguments("--remote-allow-origins=*");
					driver.set(new ChromeDriver(options));		
	}
				
				else {
					System.out.println("please select valid browser");
				}
		
			getDriver().manage().window().maximize();
			getDriver().manage().deleteAllCookies();
			getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			//getDriver().get(url);
			read_Login_url(no);
			getDriver().get(url);
			

	 }

	public void initialization(String link,int no) throws InterruptedException, IOException {
		try {
		//loadProperties(no);
		openBrower(no);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	
		
		read_Login_username( no);
		read_Login_password( no);
		
		login.Login.UserLogin(uname,password,link);		//Method of Login class to login user.
		

		
	//	CFOcountPOM.RefreshNow().click();
		Thread.sleep(3000);
		
	}
	
	public void closeBrowser() {
		getDriver().quit();
		driver.remove();
	}
	}


