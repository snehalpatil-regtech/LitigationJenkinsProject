package implementation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import login.BasePage;

public class ImplementPOM extends BasePage
{
	
private static WebElement implement = null;				//WebElement variable created for 'Categories' click
	
private static List<WebElement> implementList = null;


public static WebElement clickReport()		//Searching 'Open' Notice link
{
	
	implement = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar']/ul/li[4]/a"));
	return implement;
}
public static WebElement clickUserLogReport()		//Searching 'Open' Notice link
{
	
	implement = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:95']/li[9]/a"));
	return implement;
}
public static WebElement clickCustomer()		//Searching 'Open' Notice link
{
	
	implement = getDriver().findElement(By.xpath("//*[@id='example']/div[1]/span/span/span[1]"));
	return implement;
}
public static WebElement selectCustomer()		//Searching 'Open' Notice link
{
	
	implement = getDriver().findElement(By.xpath("(//span[normalize-space()='Bitademopune'])[1]"));
	return implement;
}
public static WebElement clickUser()		//Searching 'Open' Notice link
{
	
	implement = getDriver().findElement(By.xpath("//*[@id='example']/div[1]/div/div"));
	return implement;
}
public static WebElement selectUser()		//Searching 'Open' Notice link
{
	
	implement = getDriver().findElement(By.xpath("(//span[normalize-space()='Aakash Singh'])[1]"));
	return implement;
}
public static WebElement selectUser1()		//Searching 'Open' Notice link
{
	
	implement = getDriver().findElement(By.xpath("(//span[@class='k-in'][normalize-space()='aarav sharma'])[1]"));
	return implement;
}
public static WebElement clickApplyBtn()		//Searching 'Open' Notice link
{
	
	implement = getDriver().findElement(By.xpath("//*[@id='Applybtn']"));
	return implement;
}

public static WebElement clickExport()		//Searching 'Open' Notice link
{
	
	implement = getDriver().findElement(By.xpath("//*[@id='exportAdvanced']"));
	return implement;
}

}
