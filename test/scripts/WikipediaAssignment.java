package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class WikipediaAssignment {
	WebDriver driver; // To be assigned or declared at class level or else it would be at global level

	@BeforeClass
	public void beforeClass() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test // Test Case
	public void loginToNicheTourism() throws InterruptedException {
		driver.get("https://www.wikipedia.org/");
		
		WebElement englishButton = driver.findElement(By.xpath("//strong[text()='English']"));
		englishButton.click();
		Thread.sleep(3000);
		
		WebElement search = driver.findElement(By.name("search"));
		search.sendKeys("Selenium");
		Thread.sleep(3000);
		
		WebElement searchButton = driver.findElement(By.xpath("//button[text()='Search']"));
		searchButton.click();
		Thread.sleep(3000);
		
		String expectedPageTitle = "Selenium - Wikipedia";
		String actualPageTitle = driver.getTitle();
		assertEquals(actualPageTitle, expectedPageTitle);
		System.out.println("Page Title is : " + actualPageTitle);
		
		WebElement pageHeading = driver.findElement(By.xpath("//span[text()='Selenium' and contains(@class, 'page-title')]"));
		String actualPageHeading = pageHeading.getText();
		String expectedPageHeading = "Selenium";
		assertEquals(actualPageHeading, expectedPageHeading);
		System.out.println("Page Heading is : " + actualPageHeading);
		
		
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
