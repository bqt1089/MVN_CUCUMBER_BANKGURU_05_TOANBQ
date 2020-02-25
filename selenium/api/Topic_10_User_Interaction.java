package api;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_10_User_Interaction {
	private WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		Actions action = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void TC_01_() {
	    driver.get("https://www.myntra.com/");
	    
	    WebElement hoverText = driver.findElement(By.xpath(xpathExpression));
	    
		action.moveToElement(toElement)

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

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}