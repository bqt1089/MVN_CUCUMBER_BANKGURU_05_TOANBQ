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

public class Topic_05_XPath_CSS_Part_II {
	private WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@Test
	public void TC_01_LoginWithEmptyEmailAndPassword() {
	    driver.get("http://live.demoguru99.com/");
	    driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
	    driver.findElement(By.id("email")).sendKeys("");
	    driver.findElement(By.id("pass")).sendKeys("");
	    driver.findElement(By.id("send2")).click();
	    Assert.assertTrue(driver.findElement(By.id("advice-required-entry-email")).getText().equals("This is a required field."));
	    Assert.assertTrue(driver.findElement(By.id("advice-required-entry-pass")).getText().equals("This is a required field."));
	}

	@Test
	public void TC_02_LoginWithInvalidEmail() {
		driver.get("http://live.demoguru99.com/");
	    driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
	    driver.findElement(By.id("email")).sendKeys("121123123@1231231");
	    driver.findElement(By.id("pass")).sendKeys("");
	    driver.findElement(By.id("send2")).click();
	    Assert.assertTrue(driver.findElement(By.id("advice-validate-email-email")).getText().equals("Please enter a valid email address. For example johndoe@domain.com."));
	    Assert.assertTrue(driver.findElement(By.id("advice-required-entry-pass")).getText().equals("This is a required field."));
	}

	@Test
	public void TC_03_LoginWithPasswordLessThan6Characters() {
		driver.get("http://live.demoguru99.com/");
	    driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
	    driver.findElement(By.id("email")).sendKeys("auttomation@gmail.com");
	    driver.findElement(By.id("pass")).sendKeys("123");
	    driver.findElement(By.id("send2")).click();
	    Assert.assertTrue(driver.findElement(By.id("advice-validate-password-pass")).getText().equals("Please enter 6 or more characters without leading or trailing spaces.")); 
	}
	
	@Test
	public void TC_04_LoginWithIncorrectPassword() {
		driver.get("http://live.demoguru99.com/");
	    driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
	    driver.findElement(By.id("email")).sendKeys("auttomation@gmail.com");
	    driver.findElement(By.id("pass")).sendKeys("123123123");
	    driver.findElement(By.id("send2")).click();
	    Assert.assertTrue(driver.findElement(By.xpath("//li[@class='errpr-msg']//span")).getText().equals("Invalid login or password.")); 
	}
	
	@Test
	public void TC_05_LoginWithValidEmailAndPassword() {
		driver.get("http://live.demoguru99.com/");
	    driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
	    driver.findElement(By.id("email")).sendKeys("auttomation@gmail.com");
	    driver.findElement(By.id("pass")).sendKeys("123123");
	    driver.findElement(By.id("send2")).click();
	    Assert.assertTrue(driver.findElement(By.xpath("//div[@class='page-title']//h1")).getText().equals("My Dashboard"));
	    Assert.assertTrue(driver.findElement(By.xpath("//p[@class='hello']//strong")).getText().equals("Hello, Automation Testing!"));	    
	    Assert.assertTrue(driver.findElement(By.xpath("///h3[text()='Contact Information']/parent::div/following-sibling::div/p")).getText().equals("My Dashboard"));
	    
	    String contactInfo = driver.findElement(By.xpath("///h3[text()='Contact Information']/parent::div/following-sibling::div/p")).getText();
	    System.out.println("Contact = " + contactInfo);
	    Assert.assertTrue(contactInfo.contains("Automation Testing"));
	    Assert.assertTrue(contactInfo.contains("automation_13@gmail.com"));
	}
	
	@Test
	public void TC_06_CreatNewUser() {
		driver.get("http://live.demoguru99.com/");
	    driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
	    driver.findElement(By.xpath("//div[@class='buttons-set']//a[@title='Create an Account']")).click();
	    driver.findElement(By.id("firstname")).sendKeys("Van");
	    driver.findElement(By.id("middlename")).sendKeys("Thanh");
	    driver.findElement(By.id("email_address")).sendKeys("thanh123123123@gmail.com");
	    driver.findElement(By.id("password")).sendKeys("123123123");
	    driver.findElement(By.id("confirmation")).sendKeys("123123123");
	    Assert.assertTrue(driver.findElement(By.xpath("//div[@class='buttons-set']//button[@title='Register']")).getText().equals("Thank you for registering with Main Website Store."));
	    driver.findElement(By.xpath("//div[@class='account-cart-wrapper']//span[text()='Account']")).click();
	    driver.findElement(By.xpath("//a[@title=\"Log Out\"]")).click();
	    driver.findElement(By.xpath("//div[@class='account-cart-wrapper']//span[text()='Account']")).click();
	    Assert.assertTrue(driver.findElement(By.xpath("//a[@title=\"Log In\"]")).getText().equals("Log In"));
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}