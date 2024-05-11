/*  
 *  This test sets up DesiredCapabilities and then invokes
 *  RemoteWebDriver to send the request to hub *  
 */
package grid;

import org.testng.annotations.Optional;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Platform;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;

public class TheInternetHeroKupp {
	WebDriver driver;

	@Test(description = "LoginTest")
	public void testInternetHeroKuapp() {
		WebElement login = driver.findElement(By.id("username"));
		WebElement pass = driver.findElement(By.id("password"));
		WebElement signin = driver.findElement(By.className("radius"));
		login.sendKeys("tomsmith");
		pass.sendKeys("SuperSecretPassword!");
		signin.click();
	}

	@Parameters({ "platform", "browser", "version", "url" })
	@BeforeTest(alwaysRun = true)
	public void setup(@Optional("Windows") String platform,
			@Optional("Firefox") String browser, @Optional("1") String version,
			@Optional("http://the-internet.herokuapp.com/login") String url){

		DesiredCapabilities caps = new DesiredCapabilities();

		/*
		 * Set the Right Platforms based on value in "platform" variable received
		 * from TestNG configuration file
		 */
		switch (platform.toLowerCase()) {
		case "windows":
			caps.setPlatform(Platform.WINDOWS);
			break;
		case "mac":
			caps.setPlatform(Platform.MAC);
			break;
		case "linux":
			caps.setPlatform(Platform.LINUX);
			break;
		case "android":
			caps.setPlatform(Platform.ANDROID);
			break;
		case "unix":
			caps.setPlatform(Platform.UNIX);
			break;
		default:
			caps.setPlatform(Platform.WINDOWS);
			break;
		}

		
		/* Set the Right browser based on value in "browser" and "version" variable received
		 * from TestNG configuration file */		 
		switch (browser.toLowerCase()) {
		case "firefox":
			caps.setBrowserName("firefox");
			break;
		case "internet explorer":
			caps.setBrowserName("internet explorer");
			break;
		case "safari":
			caps.setBrowserName("safari");
			break;
		case "opera":
			caps.setBrowserName("opera");
			break;
		case "chrome":
			caps.setBrowserName("chrome");
			break;
		case "android":
			caps.setBrowserName("andriod");
			break;
		default:
			caps.setBrowserName("chrome");
			break;
		}

		/*
		 * The version setting in DesiredCapabilities is disabled. If you want
		 * to execute your tests in a specific browser version then uncomment
		 * the below code.
		 */

		 //caps.setVersion(version);

		/*
		 * Make sure you change the hub address below as per your grid and
		 * network setup to run your tests
		 */
		
	
		try {
			driver = new RemoteWebDriver(
					new URL("http://localhost:4444"), caps);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	//	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get(url);

	}

	@AfterTest
	public void afterTest() {
		driver.quit();

	}

}