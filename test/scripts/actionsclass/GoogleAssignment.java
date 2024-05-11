package scripts.actionsclass;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class GoogleAssignment {
	WebDriver driver; // To be assigned or declared at class level or else it would be at global level
	WebDriverWait wait;

	@BeforeClass
	public void beforeClass() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@Test // Test Case
	public void googleAssign() throws InterruptedException {
		driver.get("https://www.google.com/");
		String parentWindow = driver.getWindowHandle();
		System.out.println("Window Id of parent " + parentWindow);

		WebElement gmailLink = driver.findElement(By.xpath("//a[contains(text(), 'Gmail')]"));

		Actions builder = new Actions(driver);
		builder.keyDown(Keys.CONTROL).click(gmailLink).build().perform();

		Set<String> setofwindowids = driver.getWindowHandles();

		System.out.println(
				"Set of all Window Id's [First Parent Window Id, then all other window id's] " + setofwindowids);
		
		Iterator<String> it = setofwindowids.iterator();
		String parentID = it.next();
		
		String gmailWindow = it.next();
		
		driver.switchTo().window(gmailWindow);
		
		WebElement signIn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), 'Sign in')]")));
		signIn.click();
		
		Set<String> newsetofwindowids = driver.getWindowHandles();

		System.out.println(
				"Set of all Window Id's [First Parent Window Id, then all other window id's] " + newsetofwindowids);
		
		Iterator<String> newit = newsetofwindowids.iterator();
		String newparentID = newit.next();
		
		String newgmailWindow = newit.next();
		
		String newGmailSignWindow = newit.next();
		
		driver.switchTo().window(newGmailSignWindow);
		
		WebElement email = driver.findElement(By.name("identifier"));
		email.sendKeys("abc@xyz.com");
		
		
		driver.switchTo().window(newparentID);
		
		
		WebElement search = driver.findElement(By.id("APjFqb"));
		search.sendKeys("Selenium is Easy");
		
		builder.keyDown(Keys.ENTER).build().perform();
		
		Thread.sleep(4000);
		

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
