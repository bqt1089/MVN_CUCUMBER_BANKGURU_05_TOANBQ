package api;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_01_02_03_Check_Environment {
    // Khai báo biến
	private WebDriver driver;

	// Chạy đầu tiên 1 lần trước các testcases
	// Pre-condition (Manual)
	@BeforeClass
	public void beforeClass() {
		// Khởi tạo biến driver
		driver = new FirefoxDriver();

		// Wait cho element được hiển thị để thao tác
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		// Phóng to trình duyệt
		driver.manage().window().maximize();

		// Mở app/ aut ra
		driver.get("https://www.google.com/");
	}

	@Test
	public void TC_01_Check_Google_Title() {
		// Get ra title của trang Google
		String googleTitle = driver.getTitle();
		System.out.println("Title = " + googleTitle);
		
		// Verify title này có đúng như mong đợi hay ko
		Assert.assertEquals(googleTitle, "Google");
	}

	@Test
	public void TC_02_Check_Google_Url() {
		// Get ra Url của trang Google
		String googleUrl = driver.getCurrentUrl();
		System.out.println("Url = " + googleUrl);
		
		// Verify url này có đúng như mong đợi hay ko
		Assert.assertEquals(googleUrl, "https://www.google.com/");
	}

	@Test
	public void TC_03_Check_Google_Logo() {
		// Check Google logo displayed
		Assert.assertTrue(driver.findElement(By.cssSelector("#hplogo")).isDisplayed());
	}

	// Chạy cuối cùng sau tất cả các testcases
	// Post-condition (Manual)
	@AfterClass
	public void afterClass() {
		// Tắt browser
		driver.quit();
	}

}