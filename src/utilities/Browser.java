package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Browser {
private static WebDriver driver;

public static  WebDriver launchBrowser()
{
	System.setProperty("webdriver.chrome.driver","D:\\software-Testing\\softwarefiles\\chromedriver.exe");
    driver=new ChromeDriver();
    return driver;
}

public static void openURL()
{
	driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
}

public static void closeBrowser()
{
	driver.close();
}

public static void verifyURL(String expectedURL)
{
	String actualURL=driver.getCurrentUrl();
	boolean status=actualURL.contains(expectedURL);
	Assert.assertEquals(status, true ,"actual URL does not match with Expected URL");
    
	/*SoftAssert soft=new SoftAssert();
	soft.assertEquals(status, true,"actual URL does not match with Expected URL");
	
	System.out.println("Welcome");
	soft.assertAll();*/
}
}
