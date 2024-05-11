package scripts.frames;

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

public class NestedandIFrameAssignment {
	WebDriver driver; // To be assigned or declared at class level or else it would be at global level

	@BeforeClass
	public void beforeClass() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test // Test Case
	public void handlingNestedFrames() throws InterruptedException {
		driver.get("https://the-internet.herokuapp.com/frames");
		WebElement nestedFrame = driver.findElement(By.xpath("//a[text()='Nested Frames']"));
		nestedFrame.click();
		
		driver.switchTo().frame(1);
		Thread.sleep(2000);
		driver.switchTo().frame("frame-top");
		
		
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
