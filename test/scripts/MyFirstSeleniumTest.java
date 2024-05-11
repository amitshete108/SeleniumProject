package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MyFirstSeleniumTest {

	public static void main(String[] args) throws InterruptedException {
		/*
		 * To open firefox driver= new FirefoxDriver();
		 */

		WebDriver driver;

		// Launch chrome
		driver = new ChromeDriver();
		
		//maximize window
		driver.manage().window().maximize();
		
		Thread.sleep(5000);
		// Navigate to URL
		driver.get("https://nichethyself.com/tourism/home.html");

		// Enter user name
		WebElement user = driver.findElement(By.name("username"));
		user.sendKeys("stc123");

		// Enter password
		WebElement pass = driver.findElement(By.name("password"));
		pass.sendKeys("12345");

		// to submit the form using user
		user.submit();

		// to submit the form using password
		// password.submit

		String expectedPageTitleAfterLogin = "My account"; // This information I will get from requirements document,
															// Stories,
		
		Thread.sleep(3000);
		String actualPageTitleAfterLogin = driver.getTitle();

		if (expectedPageTitleAfterLogin.equals(actualPageTitleAfterLogin)) {
			System.out.println("Login Successful..!!");

		} else {
			System.out.println("Login Failed..!!");
		}
		
		driver.quit();
	}

}
