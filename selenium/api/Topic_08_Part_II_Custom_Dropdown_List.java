package api;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_08_Part_II_Custom_Dropdown_List {
	WebDriver driver;
	WebDriverWait explicitWait;
	JavascriptExecutor jsExecutor;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		explicitWait = new WebDriverWait(driver, 10);
		jsExecutor = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void TC_01_Select_One_Item_In_Dropdown() throws Exception {
		Select_One_Item_In_Dropdown("https://jqueryui.com/resources/demos/selectmenu/default.html", "//span[@id='number-button']", "//ul[@id='number-menu']/li", "19");
		Assert.assertTrue(isElementDisplayed("//span[@id='number-button']//span[@class='ui-selectmenu-text' and text()='19']"));
		Select_One_Item_In_Dropdown("https://ej2.syncfusion.com/angular/demos/?_ga=2.262049992.437420821.1575083417-524628264.1575083417#/material/drop-down-list/data-binding", "//ejs-dropdownlist[@id='games']", "//ul[@id='games_options']/li", "Football");
		Assert.assertEquals(getTextByJS("select[name='games'] option"), "Football");
		Select_One_Item_In_Dropdown("https://react.semantic-ui.com/maximize/dropdown-example-selection/", "//div[@role='listbox']", "//div[@role='option']/span", "Christian");
		Assert.assertTrue(isElementDisplayed("//div[@class='text' and text()='Christian']"));
		Select_One_Item_In_Dropdown("https://mikerodham.github.io/vue-dropdowns/", "//li[@class='dropdown-toggle']", "//ul[@class='dropdown-menu']/li/a", "First Option");
		Assert.assertTrue(isElementDisplayed("//li[@class='dropdown-toggle' and contains(text(),'First Option')]"));
		Select_One_Item_In_Dropdown("https://react.semantic-ui.com/maximize/dropdown-example-search-selection/", "//div[@role='alert']", "//div[@class='item']/span", "Bahrain");
		Assert.assertTrue(isElementDisplayed("//div[@class='text' and text()='Bahrain']"));
	}

	@Test
	public void TC_02_Select_Multi_Item_In_Dropdown() throws Exception {
		driver.get("https://multiple-select.wenzhixin.net.cn/examples#basic.html");
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='templates/template.html?v=188&url=basic.html']")));
		String parentXpath = "//div[@class='form-group row'][2]//button";
		String dropdownXpath = "//div[@class='form-group row'][2]//input[@data-name='selectItem']/following-sibling::span";
		String[] months = {"January","February","March", "April"};		
		sleepInSecond(2);
		Select_Multi_Item_In_Dropdown(parentXpath, dropdownXpath, months, "//*[@class='selected']");
		sleepInSecond(2);
		driver.switchTo().defaultContent();
	}
	
	public void Select_One_Item_In_Dropdown(String pageUrl, String parentXpath, String childXpath, String expectedItem) throws Exception {
		driver.get(pageUrl);
		driver.findElement(By.xpath(parentXpath)).click();
		sleepInSecond(2);
		List<WebElement> allItems = driver.findElements(By.xpath(childXpath));
		System.out.println("Item number = " + allItems.size());
		// Wait all items loaded successfully
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(childXpath)));
		for (WebElement webElement : allItems) {
			String itemText = webElement.getText();
			if (itemText.equals(expectedItem)) {
					webElement.click();
					sleepInSecond(2);
				break;
			}
		}
	}
		
	public void Select_Multi_Item_In_Dropdown(String parentXpath, String allItemXpath, String[] expectedValueItem, String itemsSelectedXpath) {
		driver.findElement(By.xpath(parentXpath)).click();
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(allItemXpath)));
		List<WebElement> allItems = driver.findElements(By.xpath(allItemXpath));
		for (WebElement childElement : allItems) {
			for (String item : expectedValueItem) {
				if (childElement.getText().equals(item)) {
					childElement.click();
					List<WebElement> itemSelected = driver.findElements(By.xpath(itemsSelectedXpath));
						if (expectedValueItem.length == itemSelected.size()) {
						break;
						}
					}
				}
			}
		}
	public void sleepInSecond(long timeout) {
		try {
			Thread.sleep(timeout * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public boolean isElementDisplayed(String xpathLocator) {
		if(driver.findElement(By.xpath(xpathLocator)).isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}
	
	public String getTextByJS(String cssLocator) {
		String text = (String) jsExecutor.executeScript("return document.querySelector(\"" + cssLocator + "\").textContent");
		System.out.println("Text = " + text);
		return text;
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}