package testscripts;

import java.io.IOException;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.HRMLogin;
import utilities.AddEmployee;
import utilities.Browser;
import utilities.ReadData;

public class TC002 {
	WebDriver driver;
	@BeforeClass(groups="sanity")
public void setup()
{
	driver=Browser.launchBrowser();
	Browser.openURL();
}

	@AfterClass(groups="sanity")
public void teardown()
{
	Browser.closeBrowser();
}

	@Test(priority=1,groups="sanity")
public void verifyHRMLogin() throws IOException
{
		DOMConfigurator.configure("log4j.xml");

		String uname=ReadData.getData("logininfo", "username");
		String pass=ReadData.getData("logininfo", "password");

	HRMLogin login=new HRMLogin(driver);
	login.hrmLogin(uname,pass);
}
	

	@Test(priority=2,dependsOnMethods="verifyHRMLogin",groups="smoke")
public void verifyHRMAddEmp() throws IOException
{
		DOMConfigurator.configure("log4j.xml");

		String fname=ReadData.getData("empinfo", "firstname");
		String lname=ReadData.getData("empinfo", "lastname");

	AddEmployee add=new AddEmployee(driver);
	add.hrmaddemp(fname, lname);
}
}
