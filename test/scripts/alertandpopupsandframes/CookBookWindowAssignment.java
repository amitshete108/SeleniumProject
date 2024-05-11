package scripts.alertandpopupsandframes;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class CookBookWindowAssignment {
	WebDriver driver; // To be assigned or declared at class level or else it would be at global level

	@BeforeClass
	public void beforeClass() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test // Test Case
	public void loginToNicheTourism() throws InterruptedException {
		driver.get("http://www.cookbook.seleniumacademy.com/Config.html");
		String parentWindow = driver.getWindowHandle();
		WebElement helpButton = driver.findElement(By.id("helpbutton"));
		helpButton.click();
		Thread.sleep(2000);
		
		try {
		driver.switchTo().window("HelpWindow");
		WebElement buildMyCarElement = driver.findElement(By.xpath("//h3[text()=' Build my Car - Configuration Help']"));
		assertEquals(buildMyCarElement.getText(), "Build my Car - Configuration Help");
		driver.close();
		}
		catch(NoSuchWindowException e) {
			fail("Expected new 'HelpWindow' but did not opened new window");
		}
		
		/*
		 * driver.switchTo().window(parentWindow);
		 * 
		 * WebElement chatButton = driver.findElement(By.id("chatbutton"));
		 * chatButton.click(); Thread.sleep(2000);
		 */
		
		driver.switchTo().window(parentWindow);
		WebElement visitUsButton = driver.findElement(By.id("visitbutton"));
		visitUsButton.click();
		Thread.sleep(2000);
		
		try {
			driver.switchTo().window("VisitUsWindow");
			WebElement buildMyCarElement1 = driver.findElement(By.xpath("//h3[text()='Build my Car - Configuration - Visit Us']"));
			assertEquals(buildMyCarElement1.getText(), "Build my Car - Configuration - Visit Us");
			driver.close();
			}
			catch(NoSuchWindowException e) {
				fail("Expected new 'HelpWindow' but did not opened new window");
			}
		
		
	}

	@AfterClass
	public void afterClass() {
		
	}

}
