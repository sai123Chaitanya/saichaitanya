package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class AddEmployee {

	private WebDriver driver;
	public AddEmployee( WebDriver driver)
	{
		this.driver=driver;
		wait=new WebDriverWait(driver,30);
	}
	private WebDriverWait wait;
	private By pim=By.linkText("PIM");
	private By addemployee=By.linkText("Add Employee");
	private By firstname=By.id("firstName");
	private By lastname=By.id("lastName");
	private By savebtn=By.id("btnSave");
	
	private void mousehover()
	{
		WebElement pimtab=driver.findElement(pim);
		Actions action=new Actions(driver);
		action.moveToElement(pimtab).build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(addemployee));
	}
	
	private void clickOnAddEmp()
	{
		driver.findElement(addemployee).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(firstname));

	}
	
	private void setfirstname(String fname)
	{
		driver.findElement(firstname).sendKeys(fname);
	}
	
	private void setlastname(String lname)
	{
		driver.findElement(lastname).sendKeys(lname);
	}
	

	private void clickOnsave()
	{
		driver.findElement(savebtn).click();
		wait.until(ExpectedConditions.urlContains("empNumber"));

	}
	
	public void hrmaddemp(String fname,String lname)
	{
		Reporter.log("HRM Add employee started execution....");
		Log.info("HRM Add employee started execution....");
		this.mousehover();
		this.clickOnAddEmp();
		this.setfirstname(fname);
		this.setlastname(lname);
		this.clickOnsave();
		Browser.verifyURL("empNumber");
		Reporter.log("HRM Add employee executed....");
		Log.info("HRM Add employee executed....");


	}

}
