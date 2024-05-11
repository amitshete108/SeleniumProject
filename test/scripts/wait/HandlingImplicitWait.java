package scripts.wait;

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
import org.testng.annotations.AfterClass;

public class HandlingImplicitWait {
	WebDriver driver; // To be assigned or declared at class level or else it would be at global level

	@BeforeClass
	public void beforeClass() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test // Test Case
	public void loginToNicheTourism() throws InterruptedException {
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");
		WebElement start = driver.findElement(By.xpath("//button[text()='Start']"));
		start.click();
		
		WebElement helloWorld = driver.findElement(By.xpath("//h4[text()='Hello World!']"));
		assertEquals(helloWorld.getText(), "Hello World!");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
