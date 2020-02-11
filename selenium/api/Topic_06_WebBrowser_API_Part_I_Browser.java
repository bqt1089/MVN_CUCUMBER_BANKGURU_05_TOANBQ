package api;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Topic_06_WebBrowser_API_Part_I_Browser {
	private WebDriver driver;
	By createButton = By.xpath("//div[@class='buttons-set']//span[contains(text(),'Create an Account')]");
	By myaccountLink = By.xpath("//div[@class='footer']//a[text()='My Account']");

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@BeforeMethod
	public void runForEarchTestMethod() {
		driver.get("http://live.demoguru99.com/");
		driver.findElement(myaccountLink).click();
	}	

	@Test
	public void TC_01_Verify_URL() {
	    Assert.assertEquals(driver.getCurrentUrl(), "http://live.demoguru99.com/index.php/customer/account/login/");
	    driver.findElement(createButton).click();
	    Assert.assertEquals(driver.getCurrentUrl(), "http://live.demoguru99.com/index.php/customer/account/create/");
	}

	@Test
	public void TC_02_Verify_Title() {
		Assert.assertEquals(driver.getTitle(), "Customer Login");
		driver.findElement(createButton).click();
		Assert.assertEquals(driver.getTitle(), "Create New Customer Account");
	}

	@Test
	public void TC_03_Navigate_Function() {
		driver.findElement(createButton).click();
		Assert.assertEquals(driver.getCurrentUrl(), "http://live.demoguru99.com/index.php/customer/account/create/");
		driver.navigate().back();
		Assert.assertEquals(driver.getCurrentUrl(), "http://live.demoguru99.com/index.php/customer/account/login/");
		driver.navigate().forward();
		Assert.assertEquals(driver.getTitle(), "Create New Customer Account");
	}
	
	@Test
	public void TC_04_Get_Page_Source_Code() {
		Assert.assertTrue(driver.getPageSource().contains("Login or Create an Account"));
		driver.findElement(createButton).click();
		Assert.assertTrue(driver.getPageSource().contains("Create an Account"));
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}