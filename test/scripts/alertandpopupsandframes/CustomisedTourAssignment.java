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
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;

public class CustomisedTourAssignment {
	WebDriver driver; // To be assigned or declared at class level or else it would be at global level

	@BeforeClass
	public void beforeClass() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test // Test Case
	public void customisedTour() throws InterruptedException {
		driver.get("https://nichethyself.com/tourism/home.html");
		String parentWindow = driver.getWindowHandle();
		WebElement customisedTour = driver.findElement(By.xpath("//a[text()='Customized tours']"));
		customisedTour.click();
		Thread.sleep(2000);
		driver.getWindowHandles().forEach(tab->driver.switchTo().window(tab));
		Thread.sleep(2000);
		driver.getTitle();
		assertEquals("Customised tour", driver.getTitle());
		Thread.sleep(2000);
		
		WebElement preferredStayDropdown = driver.findElement(By.id("days"));
		
		Select preferredStay = new Select(preferredStayDropdown);
		preferredStay.selectByVisibleText("Home Stay");
		Thread.sleep(2000);
		
		WebElement englandCheckBox = driver.findElement(By.xpath("//select[@id='days']/following-sibling::div[2]/label"));
		englandCheckBox.click();
		Thread.sleep(2000);
		
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
			loginAlert.sendKeys("London");
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
		Thread.sleep(2000);
		driver.getWindowHandles().forEach(tab->driver.switchTo().window(tab));
		Thread.sleep(2000);
		driver.getTitle();
		assertEquals("Customised tour", driver.getTitle());
		Thread.sleep(2000);
		
		WebElement submit = driver.findElement(By.xpath("//input[@name='countries']/following-sibling::button[1]"));
		submit.click();
		Thread.sleep(2000);
		
		Alert submitAlert;
		try {
			submitAlert = driver.switchTo().alert();
			assertEquals(submitAlert.getText(), "Form is submitted successfully");
			Thread.sleep(3000);
			submitAlert.accept();
			Thread.sleep(3000);
			
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
