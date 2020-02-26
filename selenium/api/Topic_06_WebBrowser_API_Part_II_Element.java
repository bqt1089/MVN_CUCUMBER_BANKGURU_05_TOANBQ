package api;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Topic_06_WebBrowser_API_Part_II_Element {
	private WebDriver driver;
	By emailTextbox = By.id("mail");
	By ageunder18Radio = By.id("under_18");
	By educationTextArea = By.id("edu");
	By jobrole01Dropdown = By.id("job1");
	By developmentCheckbox = By.id("development");
	By firstSlider = By.id("slider-1");
	By passwordTextbox = By.id("password");
	By disabledRadio = By.id("radio-disabled");
	By biographyTextArea = By.id("bio");
	By jobrole02Dropdown = By.id("job2");
	By disabledCheckbox = By.id("check-disbaled");
	By secondSlider = By.id("slider-2");

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@BeforeMethod
	public void runForEarchTestMethod() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
	}

	@Test
	public void TC_01_Check_isDisplayed() {
		if (driver.findElement(emailTextbox).isDisplayed()) {
			driver.findElement(emailTextbox).sendKeys("Automation Testing");
		}
		if (driver.findElement(educationTextArea).isDisplayed()) {
			driver.findElement(educationTextArea).sendKeys("Automation Testing");
		}		
		if (driver.findElement(ageunder18Radio).isDisplayed()) {
			driver.findElement(ageunder18Radio).click();
		}	
	}

	@Test
	public void TC_02_Check_isEnabled() {	
		isElementEnabled(emailTextbox);
		isElementEnabled(ageunder18Radio);
		isElementEnabled(educationTextArea);
		isElementEnabled(jobrole01Dropdown);
		isElementEnabled(developmentCheckbox);
		isElementEnabled(firstSlider);
		isElementEnabled(passwordTextbox);
		isElementEnabled(disabledRadio);
		isElementEnabled(biographyTextArea);
		isElementEnabled(jobrole02Dropdown);
		isElementEnabled(disabledCheckbox);
		isElementEnabled(secondSlider);
	}	

	@Test
	public void TC_03_CheckisSelected() {		
		if (driver.findElement(ageunder18Radio).isEnabled()) {
			driver.findElement(ageunder18Radio).click();
		}	
		if (driver.findElement(developmentCheckbox).isEnabled()) {
			driver.findElement(developmentCheckbox).click();
		}
		isElenmentSlected(ageunder18Radio);
		isElenmentSlected(developmentCheckbox);	
		if (driver.findElement(developmentCheckbox).isSelected()) {
			driver.findElement(By.id("development")).click();
		}			
		isElenmentSlected(developmentCheckbox);
	}	
	
	public boolean isElenmentSlected(By by) {
		WebElement element = driver.findElement(by);
		if (element.isSelected()) {
			System.out.println("Element ---- " + by + " ---- is selected");
			return true;
		} else {
			System.out.println("Element ---- " + by + " ---- is un-selected");
			return false;
		}
	}	
	
	public boolean isElementEnabled(By by) {
		WebElement element = driver.findElement(by);
		if (element.isEnabled()) {
			System.out.println("Element ---- " + by + " ---- is enabled");
			return true;
		} else {
			System.out.println("Element ---- " + by + " ---- is disabled");
			return false;
		}
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}