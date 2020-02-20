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

public class Topic_08_Handle_Default_Dropdown_List {
	WebDriver driver;
	Select select;
	String email = "cartoon" + randomNumber() + "@hotmail.com";
	String homePageURL = "https://demo.nopcommerce.com/";

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
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
		
		driver.findElement(By.xpath("//a[@class='ico-register']")).click();
		
		driver.findElement(By.xpath("//input[@id='gender-male']")).click();
		
		driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Automation");
		
		driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Test");
		
		select = new Select(driver.findElement(By.name("DateOfBirthDay")));
		select.selectByVisibleText("1");
		Assert.assertEquals(select.getOptions().size(), 32);
		
		select = new Select(driver.findElement(By.name("DateOfBirthMonth")));
		select.selectByVisibleText("May");
		Assert.assertEquals(select.getOptions().size(), 13);
		
		select = new Select(driver.findElement(By.name("DateOfBirthYear")));
		select.selectByVisibleText("1980");
		Assert.assertEquals(select.getOptions().size(), 112);
		
		driver.findElement(By.id("Email")).sendKeys(email);
		
		driver.findElement(By.id("Email")).sendKeys("Gameloft");
		
		driver.findElement(By.id("Password")).sendKeys("123123");
		
		driver.findElement(By.id("ConfirmPassword")).sendKeys("123123");
		
		driver.findElement(By.id("register-button")).click();
		
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='result']")).getText(), "Your registration completed");
		
		driver.findElement(By.xpath("//input[@name='register-continue']")).click();
		
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