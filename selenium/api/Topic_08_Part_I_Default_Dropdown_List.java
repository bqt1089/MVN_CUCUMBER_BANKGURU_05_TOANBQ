package api;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_08_Part_I_Default_Dropdown_List {
	WebDriver driver;
	Select select;
	String email, homePageURL;
	By registerLink = By.xpath("//a[@class='ico-register']");
	By maleRadio = By.xpath("//input[@id='gender-male']");
	By firstNameTextbox = By.xpath("//input[@id='FirstName']");
	By lastNameTextbox = By.xpath("//input[@id='LastName']");
	By dayDropdown = By.name("DateOfBirthDay");
	By monthDropdown = By.name("DateOfBirthMonth");
	By yearDropdown = By.name("DateOfBirthYear");
	By emailTextbox = By.id("Email");
	By companyTextbox = By.id("Company");
	By passTextbox = By.id("Password");
	By passConfirmTextbox = By.id("ConfirmPassword");
	By registerButton = By.id("register-button");
	By continueButton = By.xpath("//input[@name='register-continue']");
	By registrationText = By.xpath("//div[@class='result']");
	
	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		email = "cartoon" + randomNumber() + "@hotmail.com";
		homePageURL = "https://demo.nopcommerce.com/";
		
		
	}

	@Test
	public void TC_01() throws Exception {
		driver.get("https://automationfc.github.io/basic-form/index.html");	
	    
		select = new Select(driver.findElement(By.name("user_job1")));	    
	    Assert.assertFalse(select.isMultiple());

	    select.selectByVisibleText("Mobile Testing");
	    Assert.assertEquals(select.getFirstSelectedOption().getText(), "Mobile Testing");
	    
	    select.selectByValue("manual");
	    Assert.assertEquals(select.getFirstSelectedOption().getText(), "Manual Testing");
	    
	    select.selectByIndex(9);	    
	    Assert.assertEquals(select.getFirstSelectedOption().getText(), "Functional UI Testing");
	    
	    Assert.assertEquals(select.getOptions().size(), 10);
	    
		select = new Select(driver.findElement(By.name("user_job2")));
		Assert.assertTrue(select.isMultiple());
		
		select.selectByVisibleText("Automation");
		select.selectByVisibleText("Mobile");
		select.selectByVisibleText("Desktop");
		
		List <WebElement> optionSelected = select.getAllSelectedOptions();
		List <String> arraySelected = new ArrayList<String>();
		for (WebElement select: optionSelected) {
		     arraySelected.add(select.getText());
		}
		
		Assert.assertTrue(arraySelected.contains("Automation"));
		Assert.assertTrue(arraySelected.contains("Mobile"));
		Assert.assertTrue(arraySelected.contains("Desktop"));
		
		select.deselectAll();
		
		List <WebElement> optionUnselected = select.getAllSelectedOptions();
		Assert.assertEquals(optionUnselected.size(), 0);
	}

	@Test
	public void TC_02() {
		driver.get("https://demo.nopcommerce.com/register");
		
		driver.findElement(registerLink).click();
		
		driver.findElement(maleRadio).click();
		
		driver.findElement(firstNameTextbox).sendKeys("Automation");
		
		driver.findElement(lastNameTextbox).sendKeys("Test");
		
		select = new Select(driver.findElement(dayDropdown));
		select.selectByVisibleText("1");
		Assert.assertEquals(select.getOptions().size(), 32);
		
		select = new Select(driver.findElement(monthDropdown));
		select.selectByVisibleText("May");
		Assert.assertEquals(select.getOptions().size(), 13);
		
		select = new Select(driver.findElement(yearDropdown));
		select.selectByVisibleText("1980");
		Assert.assertEquals(select.getOptions().size(), 112);
		
		driver.findElement(emailTextbox).sendKeys(email);
		
		driver.findElement(companyTextbox).sendKeys("Gameloft");
		
		driver.findElement(passTextbox).sendKeys("123123");
		
		driver.findElement(passConfirmTextbox).sendKeys("123123");
		
		driver.findElement(registerButton).click();
		
		Assert.assertEquals(driver.findElement(registrationText).getText(), "Your registration completed");
		
		driver.findElement(continueButton).click();
		
		Assert.assertEquals(driver.getCurrentUrl(), homePageURL);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	public int randomNumber() {
		Random rand = new Random();
		return rand.nextInt(999999);
	}	
}