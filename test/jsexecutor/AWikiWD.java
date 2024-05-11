package jsexecutor;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

public class AWikiWD {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@BeforeMethod
	public void setUp() throws Exception {

	//	System.setProperty("webdriver.chrome.driver", "test\\resources\\chromedriver.exe");
		driver = new FirefoxDriver();
		baseUrl = "http://www.wikipedia.org/";
	}

	@Test
	public void testTCWikiKetan() throws InterruptedException {
		driver.get(baseUrl);
		WebElement englishLink = driver.findElement(By.id("js-link-box-en"));
		WebElementExtender.highlightElement(englishLink, driver);
		englishLink.click();
		Thread.sleep(2000);
		WebElementExtender.highlightElement(driver.findElement(By.id("searchInput")), driver);
		driver.findElement(By.id("searchInput")).clear();
		driver.findElement(By.id("searchInput")).sendKeys("Selenium");
		Thread.sleep(2000);
		WebElementExtender.highlightElement(driver.findElement(By.id("searchButton")), driver);
		driver.findElement(By.id("searchButton")).click();
		Thread.sleep(2000);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			// fail(verificationErrorString);
		}
	}

}