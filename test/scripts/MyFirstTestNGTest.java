package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class MyFirstTestNGTest {
	WebDriver driver; // To be assigned or declared at class level or else it would be at global level

	@BeforeMethod // Executes before test
	public void beforeMethod() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://nichethyself.com/tourism/home.html");
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

	@Test // Test Case
	public void loginToNicheTourism() throws InterruptedException {
		Thread.sleep(5000);
		WebElement user = driver.findElement(By.name("username"));
		user.sendKeys("stc123");

		WebElement pass = driver.findElement(By.name("password"));
		pass.sendKeys("12345");

		user.submit();
		// to submit the form using password
		// password.submit

		String expectedPageTitleAfterLogin = "My account1"; // This information I will get from requirements document,
															// Stories,

		Thread.sleep(3000);
		String actualPageTitleAfterLogin = driver.getTitle();
		assertEquals(actualPageTitleAfterLogin, expectedPageTitleAfterLogin, "Login Failed");
	}
}
