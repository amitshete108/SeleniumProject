package scripts.alertandpopupsandframes;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class CookBookAlertHandlingAssignment {
	WebDriver driver; // To be assigned or declared at class level or else it would be at global level

	@BeforeClass
	public void beforeClass() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test // Test Case
	public void handlingAlert() throws InterruptedException {
		driver.get("http://www.cookbook.seleniumacademy.com/Alerts.html");
		WebElement showAlertBox = driver.findElement(By.id("simple"));
		showAlertBox.click();
		
		Alert showAlertBoxAlert;
		try {
			showAlertBoxAlert = driver.switchTo().alert();
			assertEquals(showAlertBoxAlert.getText(), "Hello! I am an alert box!");
			Thread.sleep(3000);
			showAlertBoxAlert.accept();
			Thread.sleep(3000);
			}
		catch (NoAlertPresentException e) {
			fail("Alert is absent");
		}
		
		WebElement tryIt = driver.findElement(By.xpath("//input[@id='simple']/following-sibling::button[@id='confirm']"));
		tryIt.click();
		
		Alert tryItAlert;
		try {
			tryItAlert = driver.switchTo().alert();
			assertEquals(tryItAlert.getText(), "Press a button!");
			Thread.sleep(3000);
			tryItAlert.accept();
			Thread.sleep(3000);
			WebElement alertSucccessMessage = driver.findElement(By.id("demo"));
			assertEquals(alertSucccessMessage.getText(), "You Accepted Alert!");
		}
		catch (NoAlertPresentException e) {
			fail("Alert is absent");
		}
		
		
		WebElement tryItPrompt = driver.findElement(By.id("prompt"));
		tryItPrompt.click();
		
		Alert tryItPromptAlert;
		try {
			tryItPromptAlert = driver.switchTo().alert();
			assertEquals(tryItPromptAlert.getText(), "Please enter your name");
			Thread.sleep(3000);
			tryItPromptAlert.sendKeys("Harry Potter");
			tryItPromptAlert.accept();
			Thread.sleep(3000);
			WebElement alertSucccessMessage1 = driver.findElement(By.id("prompt_demo"));
			assertEquals(alertSucccessMessage1.getText(), "Hello Harry Potter! How are you today?");
		}
		catch (NoAlertPresentException e) {
			fail("Alert is absent");
		}
		
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
