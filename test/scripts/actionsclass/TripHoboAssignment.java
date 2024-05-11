package scripts.actionsclass;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class TripHoboAssignment {
	WebDriver driver; // To be assigned or declared at class level or else it would be at global level
	WebDriverWait wait;
	
	@BeforeClass
	public void beforeClass() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver,Duration.ofSeconds(20));
	}

	@Test // Test Case
	public void triphobo() throws InterruptedException {
		driver.get("https://www.triphobo.com/");
		
		WebElement planYourNextVacation = driver.findElement(By.id("plan-my-trip"));
		planYourNextVacation.click();
		
		WebElement search = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Where do you want to go?']")));
		search.sendKeys("Houston");
		
		WebElement houston = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[starts-with(text() ,'Houston, Texas, United States')]")));
		houston.click();
		
		WebElement startDate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Start Date']")));
		startDate.click();
		
		WebElement selectStartDate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id=\"ui-datepicker-div\"]/div[2]/table/tbody/tr[1]/td[7]/a")));
		selectStartDate.click();
		
		WebElement selectEndDate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id=\"ui-datepicker-div\"]/div[2]/table/tbody/tr[3]/td[2]/a")));
		selectEndDate.click();
		
		WebElement startPlanning = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class,'start-planning')]")));
		startPlanning.click();
		
		WebElement next = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@id, 'step') and contains(text(), 'Next')]")));
		next.click();
		
		WebElement skipToAbout = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@id, 'step') and contains(text(), 'Skip to')]")));
		skipToAbout.click();
		
		WebElement skipToTripOverview = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Trip Overview')]")));
		skipToTripOverview.click();
		
		
		WebElement editThisPlan = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(), 'Edit This Plan')]")));
		
		Thread.sleep(9000);
		Actions builder = new Actions(driver);
		builder.moveToElement(editThisPlan).click().build().perform();
		 

		Thread.sleep(9000);
		
		WebElement source = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Johnson Space Center')]")));
		WebElement target = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id=\"calendar\"]/div[2]/div/table/tbody/tr/td/div/div/div[2]/table/tbody/tr[61]/td[2]")));

		builder.dragAndDrop(source, target).build().perform();
		
		Thread.sleep(9000);
		
		
		
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
