package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import utilities.Browser;
import utilities.Log;

public class HRMLogin {

	private WebDriver driver;
	
	public HRMLogin(WebDriver driver)
	{
	this.driver=driver;	
	}
	//Locators
	private By username=By.id("txtUsername");
	private By password=By.id("txtPassword");
	private By login=By.id("btnLogin");
	
	private void setUsername(String uname)
	{
		driver.findElement(username).sendKeys(uname);
	}
	
	
	private void setPassword(String pass)
	{
		driver.findElement(password).sendKeys(pass);
	}
	
	private void clickOnLogin()
	{
		driver.findElement(login).click();
	}
	
	public void hrmLogin(String uname,String pass)
	{
		Reporter.log("HRM Login Method Started Execution");
		Log.info("HRM Login Method Started Execution");
		this.setUsername(uname);
		this.setPassword(pass);
		this.clickOnLogin();
		Browser.verifyURL("dashboard");
		Reporter.log("HRM Login Method  Executed Sucessfully");
		Log.info("HRM Login Method  Executed Sucessfully");

	}
	
	

}
