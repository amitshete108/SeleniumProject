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
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class AlertsandPopUpsandFrames {
	WebDriver driver; // To be assigned or declared at class level or else it would be at global level

	@BeforeClass
	public void beforeClass() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	//@Test // Test Case
	public void handlingAlerts() throws InterruptedException {
		driver.get("https://nichethyself.com/tourism/home.html");
		WebElement user = driver.findElement(By.name("username"));
		user.sendKeys("stc123");
		WebElement pass = driver.findElement(By.name("password"));
		//pass.sendKeys("12345");
		pass.submit();
		Thread.sleep(3000);
		
		Alert loginAlert;
		
		try {
		loginAlert = driver.switchTo().alert();
		assertEquals(loginAlert.getText(), "Please enter Password");
		loginAlert.accept();
		Thread.sleep(3000);
		}
		
		catch(NoAlertPresentException e) {
			fail("Alert is absent");
		}
		
		pass.sendKeys("12345");
		pass.submit();
		
		
		
	}
	
	
	@Test // Test Case
	public void handlingWindowPopups() throws InterruptedException {
		driver.get("https://nichethyself.com/tourism/home.html");
		String parentWindow = driver.getWindowHandle();
		WebElement contactUs = driver.findElement(By.xpath("//button[text()='Contact us!']"));
		contactUs.click();
		//WebElement searchIcon = driver.findElement(By.cssSelector(".glyphicon-search"));
		//WebElement searchIcon = driver.findElement(By.className("glyphicon glyphicon-search"));//throws exception as there are two class
		
		try {
		driver.switchTo().window("Contact");
		WebElement searchIcon = driver.findElement(By.className("glyphicon-search"));
		searchIcon.click();
		Thread.sleep(3000);
		
		Alert loginAlert;

		try {
			loginAlert = driver.switchTo().alert();
			assertEquals(loginAlert.getText(), "Enter your location:");
			Thread.sleep(3000);
			loginAlert.sendKeys("Pune");
			Thread.sleep(3000);
			loginAlert.accept();
			Thread.sleep(3000);
			driver.close();
		}

		catch (NoAlertPresentException e) {
			fail("Alert is absent");
		}
		}
		catch(NoSuchWindowException e) {
			fail("Expected new 'Contact' window but did not opened new window");
		}
		
		driver.switchTo().window(parentWindow);
		driver.findElement(By.cssSelector("form[name='loginform']>button")).click();
		
	}
	
	
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
