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

public class CookbookRadioAndCheckBoxAssignment {
	WebDriver driver; // To be assigned or declared at class level or else it would be at global level

	@BeforeClass
	public void beforeClass() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test // Test Case
	public void loginToNicheTourism() throws InterruptedException {
		driver.get("https://cookbook.seleniumacademy.com/Config.html");
		
		WebElement ledHeadLamp = driver.findElement(By.name("ledheadlamp"));
		System.out.println("Is ledheadlamp checkbox enabled? - " + ledHeadLamp.isEnabled());
		assertEquals(ledHeadLamp.isEnabled(), false);
		
		Thread.sleep(2000);
		
		WebElement dieselRadioButton = driver.findElement(By.xpath("//input[@value='Diesel']"));
		dieselRadioButton.click();
		Thread.sleep(2000);
		
		WebElement abs = driver.findElement(By.name("abs"));
		abs.click();
		Thread.sleep(2000);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
