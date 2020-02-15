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
import org.testng.annotations.Test;

public class Topic_07_Handle_Text_Area_Text_Box {
	private WebDriver driver;
	private String email, userID, password, loginPageURL;
	private String name, dob, address, city, state, pin, phone, gender, customerID;
	private String editAddress, editCity, editState, editPin, editPhone, editEmail;
	private By nameTextbox = By.name("name");
	private By genderTextbox = By.name("gender");
	private By dobTextbox = By.name("dob");
	private By addressTextArea = By.name("addr");
	private By cityTextBox = By.name("city");
	private By stateTextBox = By.name("state");
	private By pinTextBox = By.name("pinno");
	private By phoneTextBox = By.name("telephoneno");
	private By emailTextBox = By.name("emailid");
	private By passwordTextBox = By.name("password");
	private By submitButton = By.name("sub");

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/v4/");
		email = "cartoon" + randomNumber() + "@hotmail.com";
		
		name ="Tom Jerry";
		gender ="male";
		dob ="1996-05-11";
		address ="74 Tran Phu";
		city ="Da Nang";
		state ="Hai Chau";
		pin ="550000";
		phone ="0909090909";
		
		editAddress ="100 Hoang Dieu";
		editCity ="Hai Phone";
		editState ="Bang Lang";
		editPin ="770000";
		editPhone ="0905999999";
		editEmail = "tooncart" + randomNumber() + "@hotmail.com";
	}

	@Test
	public void TC_01_Register_To_System() {
		loginPageURL = driver.getCurrentUrl();
		driver.findElement(By.xpath("//a[text()='here']")).click();
		driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
		userID = driver.findElement(By.xpath("//td[text()='User ID :']//following-sibling::td")).getText();
		System.out.println("User ID at Register page = " + userID);
		password = driver.findElement(By.xpath("//td[text()='Password :']//following-sibling::td")).getText();
		System.out.println("Password at Register page = " + password);
	}    
	
	public void TC_02_Login_To_System() {
		driver.get(loginPageURL);
		driver.findElement(By.xpath("//input[@name='uid']")).sendKeys(userID);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		Assert.assertTrue(driver.findElement(By.xpath("//tr[@class='heading3']//td[text()='Manager ID : + " + userID + "']")).isDisplayed());
		String welcomeMessage = driver.findElement(By.xpath("//marquee[@class='heading3']")).getText();
		Assert.assertEquals(welcomeMessage, "Welcome To Manager's Page of Guru99 Bank");
	}
	
	public void TC_03_New_Customer() {
		driver.findElement(By.xpath("//a[text()='New Customer']")).click();
		driver.findElement(nameTextbox).sendKeys(name);
		driver.findElement(dobTextbox).sendKeys(dob);
		driver.findElement(addressTextArea).sendKeys(address);
		driver.findElement(cityTextBox).sendKeys(city);
		driver.findElement(stateTextBox).sendKeys(state);
		driver.findElement(pinTextBox).sendKeys(pin);
		driver.findElement(phoneTextBox).sendKeys(phone);
		driver.findElement(emailTextBox).sendKeys(email);
		driver.findElement(passwordTextBox).sendKeys(password);
		
		driver.findElement(submitButton).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='heading3' and text()='Customer Registered Successfully!!!']")).isDisplayed());
		
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Customer Name']//following-sibling::td")).getText(), name);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Gender']//following-sibling::td")).getText(), gender);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Birthdate']//following-sibling::td")).getText(), dob);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Address']//following-sibling::td")).getText(), address);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='City']//following-sibling::td")).getText(), city);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='State']//following-sibling::td")).getText(), state);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Pin']//following-sibling::td")).getText(), pin);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Mobile No.']//following-sibling::td")).getText(), phone);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Email']//following-sibling::td")).getText(), email);
		
		customerID = driver.findElement(By.xpath("//td[text()='Customer ID']//following-sibling::td")).getText();
	}
	
	public void TC_04_Edit_Customer() {
		driver.findElement(By.xpath("//a[text()='Edit Customer']")).click();
		driver.findElement(By.name("cusid")).sendKeys(customerID);
		driver.findElement(By.name("AccSubmit")).click();
		
		Assert.assertFalse(driver.findElement(nameTextbox).isEnabled());
		Assert.assertFalse(driver.findElement(genderTextbox).isEnabled());
		Assert.assertFalse(driver.findElement(dobTextbox).isEnabled());
		
		Assert.assertEquals(driver.findElement(addressTextArea).getText(), address);
		Assert.assertEquals(driver.findElement(cityTextBox).getAttribute("value"), city);
		Assert.assertEquals(driver.findElement(stateTextBox).getAttribute("value"), state);
		Assert.assertEquals(driver.findElement(pinTextBox).getAttribute("value"), pin);
		Assert.assertEquals(driver.findElement(phoneTextBox).getAttribute("value"), phone);
		Assert.assertEquals(driver.findElement(emailTextBox).getAttribute("value"), email);
		
		driver.findElement(addressTextArea).clear();
		driver.findElement(addressTextArea).sendKeys(editAddress);
		driver.findElement(cityTextBox).clear();
		driver.findElement(cityTextBox).sendKeys(editCity);
		driver.findElement(stateTextBox).clear();
		driver.findElement(stateTextBox).sendKeys(editState);
		driver.findElement(pinTextBox).clear();
		driver.findElement(pinTextBox).sendKeys(editPin);
		driver.findElement(phoneTextBox).clear();
		driver.findElement(phoneTextBox).sendKeys(editPhone);
		driver.findElement(emailTextBox).clear();
		driver.findElement(emailTextBox).sendKeys(editEmail);
		
		driver.findElement(submitButton).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='heading3' and text()='Customer details updated Successfully!!!']")).isDisplayed());
		
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Customer Name']//following-sibling::td")).getText(), name);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Gender']//following-sibling::td")).getText(), gender);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Birthdate']//following-sibling::td")).getText(), dob);
		
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Address']//following-sibling::td")).getText(), editAddress);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='City']//following-sibling::td")).getText(), editCity);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='State']//following-sibling::td")).getText(), editState);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Pin']//following-sibling::td")).getText(), editPin);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Mobile No.']//following-sibling::td")).getText(), editPhone);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Email']//following-sibling::td")).getText(), editEmail);		
	}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	public int randomNumber() {
		Random rand = new Random();
		return rand.nextInt(999999);
	}
}