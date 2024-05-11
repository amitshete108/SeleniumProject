package scripts;

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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class DemoQAAssignment {
	WebDriver driver; // To be assigned or declared at class level or else it would be at global level
	WebDriverWait wait;
	
	@BeforeClass
	public void beforeClass() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	}

	@Test // Test Case
	public void practiceFormDataEntry() throws InterruptedException {
		driver.get("https://demoqa.com/automation-practice-form");
		
		WebElement firstName = driver.findElement(By.id("firstName"));
		firstName.sendKeys("Travis");
		
		WebElement lastName = driver.findElement(By.id("lastName"));
		lastName.sendKeys("Head");
		
		WebElement userEmail = driver.findElement(By.id("userEmail"));
		userEmail.sendKeys("travis.head@abc.com");
				
		WebElement maleRadiobutton = driver.findElement(By.xpath("//label[text()='Male']"));
		maleRadiobutton.click();
				
		WebElement mobileNumber = driver.findElement(By.id("userNumber"));
		mobileNumber.sendKeys("9876543210");
				
		/*
		 * WebElement dateOfBirth = driver.findElement(By.id("dateOfBirthInput"));
		 * dateOfBirth.click();
		 * 
		 * WebElement monthDropdown = driver.findElement(By.xpath(
		 * "//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[1]/select"
		 * )); monthDropdown.click();
		 * 
		 * Select month = new Select(monthDropdown); month.selectByValue("7");
		 * 
		 * WebElement yearDropdown = driver.findElement(By.xpath(
		 * "//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[2]/select"
		 * )); yearDropdown.click();
		 * 
		 * Select year = new Select(yearDropdown); year.selectByValue("1992");
		 * Thread.sleep(2000);
		 * 
		 * WebElement date =
		 * driver.findElement(By.xpath("//*[@id=\"dateOfBirth\"]//div[text()='24']"));
		 * date.click(); Thread.sleep(2000);
		 */
		
		/*
		 * WebElement subjects = driver.findElement(By.id("subjectsContainer"));
		 * subjects.sendKeys("Selenium with Java"); Thread.sleep(2000);
		 */
		
		WebElement sports = driver.findElement(By.xpath("//label[text()='Sports']"));
		sports.click();
		WebElement reading = driver.findElement(By.xpath("//label[text()='Reading']"));
		reading.click();
		WebElement music = driver.findElement(By.xpath("//label[text()='Music']"));
		music.click();
		
		WebElement currentAddress = driver.findElement(By.id("currentAddress"));
		currentAddress.sendKeys("Street 123, Lane 456, Pune");
				
		WebElement state = driver.findElement(By.id("state"));
		state.sendKeys("NCR");
		Thread.sleep(4000);
		
		WebElement cityDropdown = driver.findElement(By.id("city"));
		System.out.println("Is cityDropdown disabled? - " + cityDropdown.isDisplayed());
		cityDropdown.sendKeys("Delhi");
		Thread.sleep(4000); 
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
