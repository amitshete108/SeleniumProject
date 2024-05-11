package scripts.wait;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class OrangeHRMAssignmentTestNGImplicitWait {
	// Declaring variable at class level (Global Variable)
	WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {
		// Launch Browser
		driver = new ChromeDriver();
		driver.manage().window().maximize();// Maximize the window
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test
	public void loginToOrangeHRM() throws InterruptedException {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");// navigate to URL
		
		//Thread.sleep(2000); // Wait to load page

		WebElement user = driver.findElement(By.name("username"));// Locate Element username
		user.sendKeys("Admin"); // Send username

		WebElement pass = driver.findElement(By.name("password")); // Locate element password
		pass.sendKeys("admin123"); // Send password

		user.submit();// Click submit

		String expectedPageTitleAfterLogin = "OrangeHRM";

		String actualPageTitleAfterLogin = driver.getTitle(); // get page Title

		assertEquals(actualPageTitleAfterLogin, expectedPageTitleAfterLogin, "Login Failed");
		// assertEquals(actualResult, expectedResult, "Message in case of failure");
		if (expectedPageTitleAfterLogin.equals(actualPageTitleAfterLogin)) {
			System.out.println("Login Successful..!!");

		} else {
			System.out.println("Login Failed..!!");
		}

	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

	@BeforeClass
	public void beforeClass() {
	}

	@AfterClass
	public void afterClass() {
	}

}
