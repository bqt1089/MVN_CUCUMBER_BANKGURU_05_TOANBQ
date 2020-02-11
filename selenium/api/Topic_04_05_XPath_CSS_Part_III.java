package api;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Topic_04_05_XPath_CSS_Part_III {
	private WebDriver driver;
		By emailTextbox = By.id("email");
		By passwordTextbox = By.id("pass");
		By loginButton = By.id("send2");
		By myaccountLink = By.xpath("//div[@class='footer']//a[text()='My Account']");
		By createAnAccountButton = By.xpath("//div[@class='buttons-set']//span[contains(text(),'Create an Account')]");
		By firstnameTextbox = By.id("firstname");
		By middlenameTextbox = By.id("middlename");
		By lastnameTextbox = By.id("lastname");
		By email2Textbox = By.id("email_address");
		By password2Textbox = By.id("password");
		By confirmationTextbox = By.id("confirmation");
		By registerButton = By.xpath("//div[@class='buttons-set']//span[text()='Register']");   

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@BeforeMethod
	public void runForEarchTestMethod() throws Exception {
		driver.get("http://live.demoguru99.com/");
		driver.findElement(myaccountLink).click();
	} 
	
	@Test
	public void TC_06_CreatNewUser() throws Exception {
		driver.findElement(createAnAccountButton).click();
		driver.findElement(firstnameTextbox).sendKeys("Ngo");
		driver.findElement(middlenameTextbox).sendKeys("Van");
		driver.findElement(lastnameTextbox).sendKeys("Thanh");
		driver.findElement(email2Textbox ).sendKeys(email1);
		driver.findElement(password2Textbox).sendKeys("123123123");
		driver.findElement(confirmationTextbox).sendKeys("123123123");
		driver.findElement(registerButton).click();
		Assert.assertEquals(driver.findElement(By.xpath("//ul[@class='messages']//span")).getText(),"Thank you for registering with Main Website Store.");
		Thread.sleep(6000);
		driver.findElement(By.xpath("//div[@class='account-cart-wrapper']//span[text()='Account']")).click();
		driver.findElement(By.xpath("//a[text()='Log Out']")).click();
		Thread.sleep(8000);
		Assert.assertEquals(driver.getCurrentUrl(), "http://live.demoguru99.com/index.php/");	
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	String email1 = "auto_test" + randomNumber() + "@hotmail.com"; 
	public int randomNumber() {
		Random rand = new Random();
		return rand.nextInt(999999);
	}	
}