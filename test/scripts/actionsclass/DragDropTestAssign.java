package scripts.actionsclass;

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
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;

public class DragDropTestAssign {
	WebDriver driver; // To be assigned or declared at class level or else it would be at global level

	@BeforeClass
	public void beforeClass() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test // Test Case
	public void loginToNicheTourism() throws InterruptedException {
		driver.get("https://cookbook.seleniumacademy.com/DragDropDemo.html");

		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));

		Actions builder = new Actions(driver);
		builder.dragAndDrop(source, target).build().perform();

		Thread.sleep(2000);

		WebElement dropped = driver.findElement(By.xpath("//p[text()='Dropped!']"));
		boolean dropcheck = dropped.isDisplayed();
		System.out.println("Is drop successsful? " + dropcheck);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
