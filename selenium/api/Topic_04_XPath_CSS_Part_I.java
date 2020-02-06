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

public class Topic_04_XPath_CSS_Part_I {
	private WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void TC_01_ID() throws Exception {
		driver.get("https://www.facebook.com/");	
		WebElement emailTextbox = driver.findElement(By.id("email"));
		emailTextbox.clear();
		emailTextbox.sendKeys("valsm1711@yahoo.com.vn");
		emailTextbox.isDisplayed();
		Thread.sleep(3000);
	}

	@Test
	public void TC_02_Class() throws Exception {
		driver.get("http://live.demoguru99.com/index.php/customer/account/login/");
		driver.findElement(By.className("validate-password")).sendKeys("123456");
		Thread.sleep(3000);
	}

	@Test
	public void TC_03_Name() throws InterruptedException {
		driver.findElement(By.name("login[username]")).sendKeys("thanh.ngovan@gmail.com");
		Thread.sleep(3000);
	}
	
	@Test
	public void TC_04_TagName() {
		driver.findElement(By.tagName("a")).isDisplayed();
	}
	
	@Test
	public void TC_05_LinkText() {
		driver.findElement(By.linkText("MY ACCOUNT")).isDisplayed();
	}
	
	@Test
	public void TC_06_PartialLinkText() {
		driver.findElement(By.partialLinkText("MY")).isDisplayed();
	}
	
	@Test
	public void TC_07_CSS() {
		driver.findElement(By.cssSelector("#send2")).isDisplayed();
	}
	
	@Test
	public void TC_08_XPath() {
		driver.findElement(By.xpath("//button[@id='send2']")).isDisplayed();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}