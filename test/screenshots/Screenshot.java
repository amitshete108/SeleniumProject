package screenshots;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import java.io.File;
import java.io.IOException;

//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Screenshot {
	WebDriver driver;
	TakesScreenshot ts;
	@BeforeMethod
	public void setUp() throws Exception {
		ChromeOptions options = new ChromeOptions();
		driver = new ChromeDriver(options);
//		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void tearDown() throws Exception {
		String abc = "1";
		
	}

	@Test
	public void test() throws IOException{
		try
		{
			driver.get("https://nichethyself.com/tourism/home.html");
			driver.findElement(By.name("username1")).sendKeys("stc123");
			ts = (TakesScreenshot)driver;
			File srcFile = ts.getScreenshotAs(OutputType.FILE);			
			Files.copy(srcFile, new File ("c:\\tmp1\\main_page_success.png"));
			assertTrue(true, "Test Case Passed");
	
		} catch(Exception e){
			File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			Files.copy(srcFile, new File ("c:\\tmp1\\main_page_failure.png"));
			fail("Test Case Failed");
		}
			
	}
}
