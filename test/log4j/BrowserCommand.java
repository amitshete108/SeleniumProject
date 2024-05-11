package log4j;

import org.testng.annotations.Test;

//import modularNDDT.log4j.LogTest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.util.NoSuchElementException;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class BrowserCommand {
	WebDriver driver;
	Logger log;//Log4j
	
	 @BeforeMethod
	  public void beforeMethod() {
			/*
			 * System.setProperty("webdriver.gecko.driver",
			 * "test\\resources\\geckodriver64bit.exe");
			 * System.setProperty("webdriver.chrome.driver",
			 * "test\\resources\\chromedriver.exe");
			 * 
			 */		//	driver = new FirefoxDriver();
			driver = new FirefoxDriver();
			DOMConfigurator.configure("log4j-alternate.xml");
			//DOMConfigurator.configure("test/resources/log4j/log4j-alternate.xml");
			log = Logger.getLogger(BrowserCommand.class.getName());
			
	  }
	 
  @Test (description = "Browser Commands")
  public void f() throws InterruptedException  {
	  driver.get("https://nichethyself.com/tourism/home.html");
	  log.info("Opening Url");
	  driver.manage().window().maximize();
	  log.trace("Maximized window");
	  driver.get("http://www.google.com");
	  log.debug("Going to google.com");
	  System.out.println("Current Url is - " + driver.getCurrentUrl());
	  driver.findElement(By.name("q")).sendKeys("Selenium");
	  try {
		Thread.sleep(3000);
		throw new InterruptedException();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		log.fatal("Code is in a place where it is not supposed to be.");
		
	}
	  driver.navigate().refresh();
	  log.error("This is after refresh.");
	  Thread.sleep(3000);
	  driver.navigate().back();
	  log.fatal("This is after back.");
	  Thread.sleep(3000);
	  driver.navigate().forward();
	  Thread.sleep(3000);
	  driver.navigate().to("http://www.yahoomail.com");
	//  System.out.println(driver.getPageSource());
	  
  }
  
//  @Test
  public void loginToPortal() throws InterruptedException {
	  driver.get("https://nichethyself.com/tourism/home.html");
	  log.info("Going to HomePage");
	  driver.findElement(By.name("username")).sendKeys("stc123");
	  log.trace("Entered Username");
	  driver.findElement(By.name("password")).sendKeys("12345");
	  log.trace("Entered Password");
	  Thread.sleep(3000);
	  driver.findElement(By.name("username")).clear();
	  log.debug("Cleared username field");
	  Thread.sleep(3000);
	  driver.findElement(By.name("username")).sendKeys("stc123");
//	  WebElement submitButton = driver.findElement(By.xpath("//form[@name='loginform']/button[text()='Submit']"));
	  System.out.println(driver.findElement(By.name("username")).getAttribute("value"));
	  System.out.println(driver.findElement(By.name("password")).getAttribute("value"));
	  
	  try {
	  driver.findElement(By.name("loginform")).findElement(By.tagName("button")).click();
	  } catch (NoSuchElementException e) {
		  log.error("Element with name attribute loginform not found" );	  
	  }

	  //submitButton.click();
	  //driver.findElement(By.cssSelector("form[name='loginform']>button")).click();
	  
  }
  
  
//  @Test
  public void handleVariousElements() throws InterruptedException {
	  driver.get("http://the-internet.herokuapp.com");
	  driver.findElement(By.linkText("Checkboxes")).click();
	  
	  WebElement secondCheckbox = driver.findElement(By.xpath("//form/input[2]"));
	  if (!secondCheckbox.isSelected())
		  secondCheckbox.click();
	  WebElement firstCheckbox = driver.findElement(By.xpath("//form/input[1]"));
	  if (!firstCheckbox.isSelected())
		  firstCheckbox.click();
	  if (secondCheckbox.isSelected())
		  secondCheckbox.click();

	  Thread.sleep(4000);
  }
  
 // @Test 
  public void learnRadioButton() throws InterruptedException {
	  driver.get("http://cookbook.seleniumacademy.com/Config.html");
	  driver.findElement(By.xpath("//input[@value='Petrol']")).click();
	  driver.findElement(By.xpath("//input[@value='Diesel']")).click();
	  Thread.sleep(3000);	  
	  
	  WebElement ledHeadLamp = driver.findElement(By.name("ledheadlamp"));
	  if (ledHeadLamp.isEnabled()){
		  if (!ledHeadLamp.isSelected()){
			  ledHeadLamp.click();
		  }
	  } else		  
		  System.out.println("Checkbox LED is disabled.");
	  Thread.sleep(3000);

  }
  
 // @Test
  public void testForVisibility() throws InterruptedException {
	  driver.get("http://the-internet.herokuapp.com/dynamic_loading/1");
//	  driver.findElement(By.linkText("Dynamic Loading")).click();
	  WebElement finish = driver.findElement(By.xpath("//div[@id='finish']/h4"));
	  if (finish.isDisplayed())
		  System.out.println(finish.getText());
	  else
		  System.out.println("Finish is not visible.");
	  driver.findElement(By.xpath("//div[@id='start']/button")).click();
	  Thread.sleep(6000);
	  if (finish.isDisplayed())
		  System.out.println(finish.getText());
	  else
		  System.out.println("Finish is not visible.");	  
  }
  
  
 

  @AfterMethod
  public void afterMethod() {
  }

  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
  }

}
