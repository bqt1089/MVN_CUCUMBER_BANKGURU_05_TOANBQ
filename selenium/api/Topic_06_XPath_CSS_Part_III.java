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

public class Topic_06_XPath_CSS_Part_III {
	private WebDriver driver;
		By emailTextbox = By.id("email");
		By passwordTextbox = By.id("pass");
		By loginButton = By.id("send2");
	    
	    String email1 = "auto_test" + randomNumber() + "@hotmail.com"; 
	    
	public int randomNumber() {
		Random rand = new Random();
		return rand.nextInt(999999);
    }    

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
	public void TC_06_CreatNewUser() {
		driver.findElement(By.xpath("//div[@class='buttons-set']//span[contains(text(),'Create an Account')]")).click();
		driver.findElement(By.id("firstname")).sendKeys("Ngo");
		driver.findElement(By.id("middlename")).sendKeys("Van");
		driver.findElement(By.id("lastname")).sendKeys("Thanh");
		driver.findElement(By.id("email_address")).sendKeys(email1);
		driver.findElement(By.id("password")).sendKeys("123123123");
		driver.findElement(By.id("confirmation")).sendKeys("123123123");
		driver.findElement(By.xpath("//div[@class='buttons-set']//span[text()='Register']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//ul[@class='messages']//span")).getText(),"Thank you for registering with Main Website Store.");
		driver.findElement(By.xpath("//div[@class='account-cart-wrapper']//span[text()='Account']")).click();
		driver.findElement(By.xpath("//div[@id='header-account']//a[text()='Log Out']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='page']//p[@class='welcome-msg']")).getText(),"DEFAULT WELCOME MSG!");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}