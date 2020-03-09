package api;

import java.util.concurrent.TimeUnit;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_12_Windows {
	private WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void TC_01_() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		driver.findElement(By.xpath("//a[@href='https://google.com.vn']")).click();
		switchToWindowByTitle("Google");
		switchToWindowByTitle("SELENIUM WEBDRIVER FORM DEMO");
		driver.findElement(By.xpath("//a[@href='https://facebook.com']")).click();
		switchToWindowByTitle("Facebook - Đăng nhập hoặc đăng ký");
		switchToWindowByTitle("SELENIUM WEBDRIVER FORM DEMO");
		driver.findElement(By.xpath("//a[@href='https://tiki.vn']")).click();
		switchToWindowByTitle("Mua Hàng Trực Tuyến Uy Tín với Giá Rẻ Hơn tại Tiki.vn");
		switchToWindowByTitle("SELENIUM WEBDRIVER FORM DEMO");
		String parentWindow = driver.getWindowHandle();
		closeAllWinDowsWithoutParentWindow(parentWindow);
		Assert.assertEquals(driver.getCurrentUrl(), "https://automationfc.github.io/basic-form/index.html");
		Assert.assertEquals(driver.getTitle(), "SELENIUM WEBDRIVER FORM DEMO");
	}

	@Test
	public void TC_02_() {

	}

	@Test
	public void TC_03_() {
		
	}
	
	@Test
	public void TC_04_() {
		
	}
	
	@Test
	public void TC_05() {
		
	}
	
	@Test
	public void TC_06() {
		
	}
	
	@Test
	public void TC_07() {
		
	}
	
	@Test
	public void TC_08() {

	}
	
	public boolean closeAllWinDowsWithoutParentWindow(String parentWindow) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindow : allWindows) {
			if (!runWindow.equals(parentWindow)) {
				driver.switchTo().window(runWindow);
				driver.close();
			}
		}
		driver.switchTo().window(parentWindow);
		if (driver.getWindowHandles().size() == 1) {
			return true;			
		} else return false;
	}

	public void switchToWindowByTitle(String title) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindow : allWindows) {
			driver.switchTo().window(runWindow);
			String currentWindow = driver.getTitle();
			if (currentWindow.equals(title)) {
				break;
			}
		}
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}