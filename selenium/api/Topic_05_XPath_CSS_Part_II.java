package api;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
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
	}

	@Test
	public void TC_02_LoginWithInvalidEmail() {
		Assert.assertTrue(true, "Thạnh ngải heo");

	}

	@Test
	public void TC_03_LoginWithPasswordLessThan6Characters() {
		
	}
	
	@Test
	public void TC_04_LoginWithIncorrectPassword() {
		
	}
	
	@Test
	public void TC_05_LoginWithValidEmailAndPassword() {
		
	}
	
	@Test
	public void TC_06_CreatNewUser() {

	}


	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}