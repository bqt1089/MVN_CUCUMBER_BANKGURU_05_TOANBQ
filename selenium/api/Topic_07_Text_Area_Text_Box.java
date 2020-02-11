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

public class Topic_07_Text_Area_Text_Box {
	private WebDriver driver;
	String userID;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void TC_01_() {
	    driver.get("http://demo.guru99.com/v4/");
	    driver.findElement(By.xpath("//input[@name='uid']")).sendKeys("mngr245459");
	    driver.findElement(By.xpath("//input[@name='password']")).sendKeys("zejAvUd");
	    Assert.assertEquals(driver.getCurrentUrl(), "http://demo.guru99.com/v4/manager/Managerhomepage.php");
	    Assert.assertTrue(driver.findElement(By.xpath("//marquee[@class='heading3']")).getText().contains("Welcome To Manager's Page of Guru99 Bank"));
	    driver.findElement(By.xpath("//a[text()='New Customer']")).click();
	    driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Selenium Online");
	    driver.findElement(By.xpath("//input[@value='m'")).click();
	    driver.findElement(By.xpath("//input[@name='dob'")).sendKeys("10/01/2000");
	    driver.findElement(By.xpath("//textarea[@name='addr']")).sendKeys("123 Address");
	    driver.findElement(By.xpath("//input[@value='city'")).sendKeys("Ho Chi Minh");
	    driver.findElement(By.xpath("//input[@value='state'")).sendKeys("Thu Duc");
	    driver.findElement(By.xpath("//input[@value='pinno'")).sendKeys("123456");
	    driver.findElement(By.xpath("//input[@value='telephoneno'")).sendKeys("0123456987");
	    driver.findElement(By.xpath("//input[@value='emailid'")).sendKeys("seleniumon98779@gmail.com");
	    driver.findElement(By.xpath("//input[@value='password'")).sendKeys("");
	    driver.findElement(By.xpath("")).sendKeys("123123");
	  
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}