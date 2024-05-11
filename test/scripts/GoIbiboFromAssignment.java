package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class GoIbiboFromAssignment {
	WebDriver driver; // To be assigned or declared at class level or else it would be at global level
	WebDriverWait wait;
	
	@BeforeClass
	public void beforeClass() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	}

	@Test // Test Case
	public void loginToNicheTourism() throws InterruptedException {
		driver.get("https://www.goibibo.com/");
		String parentWindow = driver.getWindowHandle();
		Thread.sleep(2000);
		
		WebElement closePopUp = driver.findElement(By.xpath("//span[@role='presentation']"));
		
		if(closePopUp.isDisplayed()) {
			closePopUp.click();
			System.out.println("PopUp closed successfully");
		}else {
			driver.switchTo().window(parentWindow);
		}
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//h2[text()='Domestic and International Flights']")).click();
		Thread.sleep(2000);
		WebElement from =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='From']/following-sibling::p"))); 
		from.click();
		WebElement input = driver.findElement(By.xpath("//input[@type='text']"));
		input.sendKeys("Ben");
		Thread.sleep(2000);
		 
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
