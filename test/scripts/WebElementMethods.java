package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;

public class WebElementMethods {
	WebDriver driver; // To be assigned or declared at class level or else it would be at global level

	@BeforeClass
	public void beforeClass() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}

	/*
	 * @Test // Test Case public void commonWebElementMethods() throws
	 * InterruptedException {
	 * driver.get("https://nichethyself.com/tourism/home.html"); WebElement
	 * user=driver.findElement(By.name("username"));
	 * System.out.println("Is username visible? - " + user.isDisplayed());
	 * System.out.println("Is username enabled? - " + user.isEnabled());
	 * user.sendKeys("abcd"); Thread.sleep(3000); user.clear(); Thread.sleep(3000);
	 * user.sendKeys("abcd1234");
	 * driver.get("https://nichethyself.com/tourism/customised.html"); WebElement
	 * swiss = driver.findElement(By.xpath("//label[text()='Switzerland']/input"));
	 * System.out.println("Is Switzerland enabled? - " + swiss.isEnabled());
	 * WebElement travel = driver.findElement(By.id("travel"));
	 * System.out.println("Is travel dropdown visible? - " + travel.isDisplayed());
	 * WebElement USA = driver.findElement(By.xpath("//label[text()='USA']/input"));
	 * System.out.println("Is USA checkbox selected? - " + USA.isSelected());
	 * USA.click(); Thread.sleep(2000);
	 * System.out.println("Is USA checkbox selected? - " + USA.isSelected()); }
	 */

	/*
	 * @Test // Test Case public void handlingCheckboxAndRadioButton() throws
	 * InterruptedException {
	 * driver.get("https://nichethyself.com/tourism/customised.html"); //TC: Click
	 * USA Button WebElement USA =
	 * driver.findElement(By.xpath("//label[text()='USA']/input"));
	 * System.out.println("Is USA checkbox selected? - " + USA.isSelected());
	 * //Check if not checked if(!USA.isSelected()) { USA.click(); }
	 * System.out.println("Is USA checkbox selected? - " + USA.isSelected());
	 * //Uncheck if already checked if(USA.isSelected()) { USA.click(); }
	 * System.out.println("Is USA checkbox selected? - " + USA.isSelected()); }
	 */

	@Test // Test Case
	public void handlingDropdowns() throws InterruptedException {
		driver.get("https://cookbook.seleniumacademy.com/Config.html");
		WebElement make = driver.findElement(By.name("make"));

		List<WebElement> allDropdown = driver.findElements(By.xpath("//option"));
		System.out.println("Total Dropdowns on the Page: " + allDropdown.size());

		List<WebElement> dropdownSelectMake = driver.findElements(By.xpath("//select[@name='make']/option"));
		System.out.println("Total Dropdown Value Count for Select Make: " + dropdownSelectMake.size());

		for (WebElement dropdownValues : dropdownSelectMake) {
			System.out.println(dropdownValues.getText() + " - " + dropdownValues.getAttribute("value"));
		}

		Select makeCombo = new Select(make);
		Thread.sleep(2000);
		makeCombo.selectByVisibleText("Honda");
		Thread.sleep(3000);
		makeCombo.selectByValue("audi");
		Thread.sleep(2000);
		WebElement selectedOption = makeCombo.getFirstSelectedOption();
		assertEquals(selectedOption.getText(),"Audi");
		
		
		makeCombo.selectByIndex(1);
		Thread.sleep(2000);
		assertEquals(makeCombo.getOptions().size(), 4);
		System.out.println(makeCombo.getOptions().size());

		List<String> expectedMakeOptions, actualMakeOptions;
		expectedMakeOptions = new ArrayList<String>();
		actualMakeOptions = new ArrayList<String>();
		expectedMakeOptions.add("BMW");
		expectedMakeOptions.add("Mercedes");
		expectedMakeOptions.add("Audi");
		expectedMakeOptions.add("Honda");

		List<WebElement> allOpt = makeCombo.getOptions();

		for (WebElement oneOpt : allOpt) {
			actualMakeOptions.add(oneOpt.getText());
		}

		assertEquals(actualMakeOptions, expectedMakeOptions);

	}

	//@Test // Test Case
	public void handlingMultiSelect() throws InterruptedException {
		driver.get("https://cookbook.seleniumacademy.com/Config.html");
		WebElement color = driver.findElement(By.name("color"));

		Select colorMultiSelect = new Select(color);
		Thread.sleep(2000);
		colorMultiSelect.selectByVisibleText("White");
		Thread.sleep(2000);
		colorMultiSelect.selectByValue("sl");
		Thread.sleep(2000);
		colorMultiSelect.selectByIndex(2);
		Thread.sleep(2000);

		List<WebElement> allColorOptions = colorMultiSelect.getOptions();
		List<WebElement> allSelectedColorOptions = colorMultiSelect.getAllSelectedOptions();

		colorMultiSelect.deselectByIndex(4);
		Thread.sleep(2000);
		colorMultiSelect.deselectByVisibleText("Red");
		Thread.sleep(2000);
		colorMultiSelect.deselectByValue("wt");
		Thread.sleep(2000);

		colorMultiSelect.selectByVisibleText("White");
		Thread.sleep(2000);
		colorMultiSelect.selectByValue("sl");
		Thread.sleep(2000);
		colorMultiSelect.selectByIndex(2);
		Thread.sleep(2000);

		colorMultiSelect.deselectAll();

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
