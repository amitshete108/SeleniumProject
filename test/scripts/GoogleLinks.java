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

public class GoogleLinks {
	WebDriver driver; // To be assigned or declared at class level or else it would be at global level

	@BeforeClass
	public void beforeClass() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test // Test Case
	public void loginToNicheTourism() throws InterruptedException {
		// Count the link elements on google.com page and print the output for link and
		// value of link
		driver.get("https://www.google.com");
		// Array list to create link elements on google.com page
		List<WebElement> allGoogleLinks = driver.findElements(By.xpath("//a"));

		// to check size of the array
		System.out.println("Total Links on google.com Page are: " + allGoogleLinks.size());

		// for loop to get all values of link element
		for (WebElement oneElement : allGoogleLinks) {
			System.out.println(oneElement.getText() + " - " + oneElement.getAttribute("href"));

		}
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
