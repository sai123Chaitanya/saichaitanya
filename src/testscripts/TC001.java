package testscripts;

import java.io.IOException;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.HRMLogin;
import utilities.Browser;
import utilities.ReadData;

public class TC001 {
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

	@Test(groups="sanity")
public void verifyLogin() throws IOException
{
		DOMConfigurator.configure("log4j.xml");
		String uname=ReadData.getData("logininfo", "username");
		String pass=ReadData.getData("logininfo", "password");

	HRMLogin login=new HRMLogin(driver);
	login.hrmLogin(uname,pass);
}
}
