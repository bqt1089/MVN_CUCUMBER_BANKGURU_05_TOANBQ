package api;

import java.util.Random;
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
	    By emailTextbox = By.id("email");
	    By passwordTextbox = By.id("pass");
	    By loginButton = By.id("send2");
	        
	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@BeforeMethod
	public void runForEarchTestMethod() throws Exception {
		driver.get("http://live.demoguru99.com/");
	    driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
	}
	
	@Test
	public void TC_01_LoginWithEmptyEmailAndPassword() {
	    driver.findElement(emailTextbox).sendKeys("");
	    driver.findElement(passwordTextbox).sendKeys("");
	    driver.findElement(loginButton).click();
	    Assert.assertEquals(driver.findElement(By.id("advice-required-entry-email")).getText(),"This is a required field.");
	    Assert.assertEquals(driver.findElement(By.id("advice-required-entry-pass")).getText(),"This is a required field.");
	}

	@Test
	public void TC_02_LoginWithInvalidEmail() {
	    driver.findElement(emailTextbox).sendKeys("121123123@1231231");
	    driver.findElement(passwordTextbox).sendKeys("");
	    driver.findElement(loginButton).click();
	    Assert.assertEquals(driver.findElement(By.id("advice-validate-email-email")).getText(),"Please enter a valid email address. For example johndoe@domain.com.");
	    Assert.assertEquals(driver.findElement(By.id("advice-required-entry-pass")).getText(),"This is a required field.");
	}

	@Test
	public void TC_03_LoginWithPasswordLessThan6Characters() {
	    driver.findElement(emailTextbox).sendKeys("automation@gmail.com");
	    driver.findElement(passwordTextbox).sendKeys("123");
	    driver.findElement(loginButton).click();
	    Assert.assertEquals(driver.findElement(By.id("advice-validate-password-pass")).getText(),"Please enter 6 or more characters without leading or trailing spaces."); 
	}
	
	@Test
	public void TC_04_LoginWithIncorrectPassword() throws Exception {
	    driver.findElement(emailTextbox).sendKeys("automation@gmail.com");
	    driver.findElement(passwordTextbox).sendKeys("123123123");
	    driver.findElement(loginButton).click();
	    Assert.assertEquals(driver.findElement(By.xpath("//ul[@class='messages']//span")).getText(),"Invalid login or password.");
	    Thread.sleep(3000);
	}
	
	@Test
	public void TC_05_LoginWithValidEmailAndPassword() {
	    driver.findElement(emailTextbox).sendKeys("automation@gmail.com");
	    driver.findElement(passwordTextbox).sendKeys("123123");
	    driver.findElement(loginButton).click();
	    Assert.assertEquals(driver.findElement(By.xpath("//div[@class='page-title']//h1")).getText(),"MY DASHBOARD");
	    Assert.assertEquals(driver.findElement(By.xpath("//div[@class='welcome-msg']//strong")).getText(),"Hello, Automation Testing!");	    
	    
	    String contactInfo = driver.findElement(By.xpath("//h3[text()='Contact Information']/parent::div/following-sibling::div/p")).getText();
	    System.out.println("Contact = " + contactInfo);
	    Assert.assertTrue(contactInfo.contains("Automation Testing"));
	    Assert.assertTrue(contactInfo.contains("automation@gmail.com"));
	       
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}