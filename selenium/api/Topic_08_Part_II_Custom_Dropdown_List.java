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
	JavascriptExecutor js = (JavascriptExecutor) driver;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		explicitWait = new WebDriverWait(driver, 10);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void TC_01() throws Exception {
		Select__One_Item_In_Dropdown("https://jqueryui.com/resources/demos/selectmenu/default.html", "//span[@id='number-button']", "//ul[@id='number-menu']/li", "19");
		Select__One_Item_In_Dropdown("https://ej2.syncfusion.com/angular/demos/?_ga=2.262049992.437420821.1575083417-524628264.1575083417#/material/drop-down-list/data-binding", "//ejs-dropdownlist[@id='games']", "//ul[@id='games_options']/li", "Football");
		Select__One_Item_In_Dropdown("https://react.semantic-ui.com/maximize/dropdown-example-selection/", "//div[@role='listbox']", "//div[@role='option']/span", "Christian");
		Select__One_Item_In_Dropdown("https://mikerodham.github.io/vue-dropdowns/", "//li[@class='dropdown-toggle']", "//ul[@class='dropdown-menu']/li/a", "First Option");
		Select__One_Item_In_Dropdown("https://react.semantic-ui.com/maximize/dropdown-example-search-selection/", "//div[@role='alert']", "//div[@class='item']/span", "Bahrain");
	}

	@Test
	public void TC_02() throws Exception {
		driver.get("https://multiple-select.wenzhixin.net.cn/examples#basic.html");
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='templates/template.html?v=188&url=basic.html']")));
		String parentXpath = "//div[@class='form-group row'][2]//button";
		String dropdownXpath = "//div[@class='form-group row'][2]//input[@data-name='selectItem']/following-sibling::span";
		String[] months = {"January","February","March", "April"};		
		Thread.sleep(2000);	
		Custom_Dropdown_List_Multi_Item(parentXpath, dropdownXpath, months, "//*[@class='selected']");
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
	}
	
	public void Select__One_Item_In_Dropdown(String pageUrl, String parentXpath, String childXpath, String expectedItem) throws Exception {
		driver.get(pageUrl);
		driver.findElement(By.xpath(parentXpath)).click();
		List<WebElement> allItems = driver.findElements(By.xpath(childXpath));
		System.out.println("Item number = " + allItems.size());
		// Wait all items loaded successfully
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(childXpath)));
		for (WebElement childElement : allItems) {
			if (childElement.getText().equals(expectedItem)) {
				if (childElement.isDisplayed()) {
					childElement.click();
				} else {					
					js.executeScript("arguments[0].scrollIntoView(true);", childElement);
					Thread.sleep(1000);
					js.executeScript("arguments[0].click();", childElement);
				}
				break;
				}
			}
		}
		
	public void Custom_Dropdown_List_Multi_Item(String parentXpath, String allItemXpath, String[] expectedValueItem, String itemsSelectedXpath) {
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

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}