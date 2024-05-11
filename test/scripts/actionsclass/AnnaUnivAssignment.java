package scripts.actionsclass;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;

public class AnnaUnivAssignment {
	WebDriver driver; // To be assigned or declared at class level or else it would be at global level

	@BeforeClass
	public void beforeClass() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test // Test Case
	public void loginToNicheTourism() throws InterruptedException {
		driver.get("https://annauniv.edu/");
		Thread.sleep(2000);

		String parent = driver.getWindowHandle();

		WebElement department = driver.findElement(By.xpath("//a[starts-with(text(), 'Departments')]"));
		Thread.sleep(2000);
		WebElement mechanicalengineering = driver
				.findElement(By.xpath("//a[contains(text(), 'Mechanical Engineering')]"));

		Actions builder = new Actions(driver);
		builder.moveToElement(department);
		Thread.sleep(2000);
		builder.moveToElement(mechanicalengineering);
		Thread.sleep(2000);
		builder.click().build().perform();
		Thread.sleep(9000);

		Set<String> setofwindowids = driver.getWindowHandles();
		System.out.println(
				"Set of all Window Id's [First Parent Window Id, then all other window id's] " + setofwindowids);
		Iterator<String> it = setofwindowids.iterator();
		String parentID = it.next();
		String mechanicalengineeringpage = it.next();
		driver.switchTo().window(mechanicalengineeringpage);

		Thread.sleep(2000);

		String pageTitlemechanicalengineering = driver.getTitle();
		System.out.println("Page Title for Mechanical Engineering: " + pageTitlemechanicalengineering);

		WebElement facilities = driver.findElement(By.xpath("//a[contains(text(), 'Facilities')]"));
		Thread.sleep(2000);
		builder.moveToElement(facilities);
		Thread.sleep(2000);

		WebElement aufrg = driver.findElement(By.xpath("//a[contains(text(), 'AUFRG')]"));
		Thread.sleep(2000);
		builder.moveToElement(aufrg);
		Thread.sleep(2000);
		builder.click().build().perform();
		Thread.sleep(9000);

		Set<String> newsetofwindowids = driver.getWindowHandles();
		System.out.println(
				"Set of all New Window Id's [First Parent Window Id, then all other window id's] " + newsetofwindowids);
		
		Iterator<String> it1 = newsetofwindowids.iterator();
		String parentIDnew = it1.next();
		String mechanicalengineeringpagenewID = it1.next();
		String pageAUFRG = it1.next();
		driver.switchTo().window(pageAUFRG);
		String pageTitleAUFRG = driver.getTitle();
		
		System.out.println("Page Title for AUFRG: " + pageTitleAUFRG);
		
		driver.switchTo().window(mechanicalengineeringpagenewID);
		Thread.sleep(2000);
		String mechanicalengineeringpageTitle = driver.getTitle();
		System.out.println("Page Title after switching from AUFRG to Mechanical Engineering Page: " + mechanicalengineeringpageTitle);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
