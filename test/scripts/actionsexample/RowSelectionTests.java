package scripts.actionsexample;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

//import com.thoughtworks.selenium.Wait;

public class RowSelectionTests {

	WebDriver driver;
	WebDriverWait wait;
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "test\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("http://icefaces-showcase.icesoft.org/showcase.jsf");
		driver.findElement(By.linkText("Table")).click();
		//driver.findElement(By.linkText("Datatable")).click();
	    //WebElement selectionLink =	wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Selection")));
		//selectionLink.click();
		//wait.until(ExpectedConditions.visibilityOfElementLocated(null))	;
		//Alert myAlert = wait.until(ExpectedConditions.alertIsPresent());
		
		WebElement rowSelection = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Row Selection")));
		rowSelection.click();
		WebElement selectMultiple = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//table[@class='iceSelOneRb']/tbody/tr/td[2]/label")));
		selectMultiple.click();
	}

	@Test
	public void testRowSelectionUsingControlKey() {

		List<WebElement> tableRows = driver.findElements(By.xpath("//div[@id='form:selectionTable']//tbody/tr"));
		//List<WebElement> tableRows = driver.findElements(By.xpath("tbody[@id='form:selectionTable_body']//tr"));
		//
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
		}
		// Select second and fourth row from Table using Control Key.
		// Row Index start at 0
		Actions builder = new Actions(driver); // builder design pattern
		// builder design pattern
		builder.click(tableRows.get(1))
			   .keyDown(Keys.CONTROL)
			   .click(tableRows.get(3))
			   .click(tableRows.get(5))
			   .keyUp(Keys.CONTROL).build();// build but not perform
		// builder.perform();//Actual action happens on the page
		builder.keyDown(Keys.SHIFT).click(tableRows.get(7)).keyUp(Keys.SHIFT).build().perform();
		
		builder.perform();//Do nothing

		// Verify Selected Row Table shows two rows selected
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<WebElement> rows = driver
				.findElements(By.xpath("//div[@class='icePnlGrp exampleBox']/table[@class='iceDatTbl']/tbody/tr"));
		AssertJUnit.assertEquals(3, rows.size());

		// WebElement someElement = driver.findElement(By.name("ome"));

	}

	@Test
	public void testRowSelectionUsingShiftKey() throws InterruptedException {

		List<WebElement> tableRows = driver.findElements(By.xpath("//table[@class='iceDatTbl']/tbody/tr"));

		// Select first row to fourth row from Table using Shift Key
		// Row Index start at 0
		Actions builder = new Actions(driver);
		builder.click(tableRows.get(0)).keyDown(Keys.SHIFT).click(tableRows.get(1)).click(tableRows.get(2))
				.click(tableRows.get(3)).keyUp(Keys.SHIFT).build();

		Thread.sleep(10000);
		List<WebElement> rows = driver
				.findElements(By.xpath("//div[@class='icePnlGrp exampleBox']/table[@class='iceDatTbl']/tbody/tr"));
		AssertJUnit.assertEquals(4, rows.size());
	}

	@AfterMethod
	public void tearDown() {
		// driver.quit();
	}

}
