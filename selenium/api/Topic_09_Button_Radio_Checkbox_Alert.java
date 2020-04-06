package api;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_09_Button_Radio_Checkbox_Alert {
	WebDriver driver;
	JavascriptExecutor jsExecutor;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		jsExecutor = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void TC_01_Button() {
	    driver.get("http://live.demoguru99.com/");	
	    WebElement myAccountLink = driver.findElement(By.xpath("//div[@class='footer-container']//a[text()='My Account']"));
	    clickElementByJS(myAccountLink);
	    Assert.assertEquals(driver.getCurrentUrl(), "http://live.demoguru99.com/index.php/customer/account/login/");
	    WebElement createAnAccountLink = driver.findElement(By.xpath("//span[contains(text(),'Create an Account')]"));
	    clickElementByJS(createAnAccountLink);
	    Assert.assertEquals(driver.getCurrentUrl(), "http://live.demoguru99.com/index.php/customer/account/create/");
	}

	@Test
	public void TC_02_Default_Checkbox_Radio() {
		driver.get("https://demos.telerik.com/kendo-ui/checkbox/index");
		WebElement dualZoneCheckbox = driver.findElement(By.xpath("//input[@id='eq5']"));
		dualZoneCheckbox.click();
		Assert.assertTrue(dualZoneCheckbox.isSelected());
		dualZoneCheckbox.click();
		Assert.assertFalse(dualZoneCheckbox.isSelected());
		driver.get("https://demos.telerik.com/kendo-ui/radiobutton/index");
		WebElement petrolRadio = driver.findElement(By.xpath("//input[@id='engine3']"));
		petrolRadio.click();
		Assert.assertTrue(petrolRadio.isSelected());
		if (petrolRadio.isSelected()) {
			System.out.println("Petro Radio is Selected");
		}else {
			System.out.println("Petro Radio is Un-Selected");
			petrolRadio.click();
			Assert.assertTrue(petrolRadio.isSelected());
		}
	}

	@Test
	public void TC_03_Custom_Checkbox_Radio() {
		driver.get("https://material.angular.io/components/radio/examples");
		WebElement summerRadio = driver.findElement(By.xpath("//input[@id='mat-radio-4-input']"));
		clickElementByJS(summerRadio);
		Assert.assertTrue(summerRadio.isSelected());
		if (summerRadio.isSelected()) {
			System.out.println("Summer Radio is Selected");
		}else {
			System.out.println("Summer Radio is Un-Selected");
			summerRadio.click();
			Assert.assertTrue(summerRadio.isSelected());
		}		
		driver.get("https://material.angular.io/components/checkbox/examples");
		WebElement checkedCheckbox = driver.findElement(By.xpath("//input[@id='mat-checkbox-1-input']"));
		WebElement indeterminateCheckbox = driver.findElement(By.xpath("//input[@id='mat-checkbox-2-input']"));
		checkedCheckbox.click();
		indeterminateCheckbox.click();
		Assert.assertTrue(checkedCheckbox.isSelected());
		Assert.assertTrue(indeterminateCheckbox.isSelected());
		checkedCheckbox.click();
		indeterminateCheckbox.click();
		Assert.assertFalse(checkedCheckbox.isSelected());
		Assert.assertFalse(indeterminateCheckbox.isSelected());
	}
	
	@Test
	public void TC_04_Accept_Alert() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		WebElement clickForJSAlertAlert = driver.findElement(By.xpath("//button[text()='Click for JS Alert']"));
		clickForJSAlertAlert.click();
		Alert alert = driver.switchTo().alert();
		String textOnAlert = alert.getText();
		Assert.assertEquals("I am a JS Alert", textOnAlert);
		alert.accept();
		Assert.assertEquals(driver.findElement(By.xpath("//p[@id='result']")).getText(), "You clicked an alert successfully");
	}
	
	@Test
	public void TC_05_Confirm_Alert() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		WebElement clickForJSConfirmAlert = driver.findElement(By.xpath("//button[text()='Click for JS Confirm']"));
		clickForJSConfirmAlert.click();
		Alert alert = driver.switchTo().alert();
		String textOnAlert = alert.getText();
		Assert.assertEquals("I am a JS Confirm", textOnAlert);
		alert.dismiss();
		Assert.assertEquals(driver.findElement(By.xpath("//p[@id='result']")).getText(), "You clicked: Cancel");
	}
	
	@Test
	public void TC_06_Prompt_Alert() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		WebElement clickForJSPromptAlert = driver.findElement(By.xpath("//button[text()='Click for JS Prompt']"));
		clickForJSPromptAlert.click();
		Alert alert = driver.switchTo().alert();
		String textOnAlert = alert.getText();
		Assert.assertEquals("I am a JS prompt", textOnAlert);
		String text = "I am Thanh";
		alert.sendKeys(text);
		alert.accept();
		Assert.assertEquals(driver.findElement(By.xpath("//p[@id='result']")).getText(), "You entered: " + text);
	}
	
	@Test
	public void TC_07_Authentication_Alert() {
		String username = "admin";
		String password = "admin";
		driver.get("http://"+ username + ":"+ password + "@" +"the-internet.herokuapp.com/basic_auth");
		Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(), 'Congratulations! You must have the proper credentials.')]")).isDisplayed());
	}
	
	public void clickElementByJS (WebElement element) {
		jsExecutor.executeScript("arguments[0].click()", element);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}