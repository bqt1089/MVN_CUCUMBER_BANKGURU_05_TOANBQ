package api;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_10_User_Interaction {
	WebDriver driver;
	// Declare "Actions action" to use "action"
	// Import "'Actions' (org.openqa.selenium.interactions)"
	Actions action;
	WebElement hoverText;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
	//	Initialize "action = new Actions(driver)"
		action = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void TC_01_Hover() {
	    driver.get("https://www.myntra.com/");
	    // Use "moveToElement()" to hover to element
	    // Add ".perform()" to perform the action
	    // Move the mouse during the running process makes the hovering lost of focusing (dispute the event)
	    // Not use the keyboard during the running process also
	    hoverText = driver.findElement(By.xpath("//div[@class='desktop-navLink']//a[text()='Discover']"));
		action.moveToElement(hoverText).perform();
		sleepInSecond(3);	
		driver.findElement(By.xpath("//a[text()='Lacoste']")).click();	
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='breadcrumbs-item']/span[text()='Lacoste Products']")).isDisplayed());
	}

	@Test
	public void TC_02_Click_And_Hold_Block() {
		driver.get("https://jqueryui.com/resources/demos/selectable/display-grid.html");
		// Import 'List'(java.util)	for List<WebElement>
		List<WebElement> allItems = driver.findElements(By.xpath("//ol[@id='selectable']/li"));
		// Print the number of all items
		System.out.println("All Items Number = " + allItems.size());
		// Use "clickAndHold()" to click & hold element
		action.clickAndHold(allItems.get(0)).moveToElement(allItems.get(3)).release().perform();
		sleepInSecond(3);
		List<WebElement> allSelectedItems = driver.findElements(By.xpath("//ol[@id='selectable']/li[contains(@class,'ui-selected')]"));
		// Print the number of all selected items
		System.out.println("Selected Item Number = " +allSelectedItems.size());
		Assert.assertEquals(allSelectedItems.size(), 4);
		// for-each loop
		for (WebElement item: allSelectedItems) {
			// Print each selected item
			System.out.println(item.getText());
		}
	}

	@Test
	public void TC_03_Click_And_Hold_Random() {
		driver.get("https://jqueryui.com/resources/demos/selectable/display-grid.html");
		List<WebElement> allItems = driver.findElements(By.xpath("//ol[@id='selectable']/li"));
		System.out.println("All Items Number = " + allItems.size());
		// Use "action.keyDown()" to press the Control key
		// Use "Keys." to select key
		action.keyDown(Keys.CONTROL).perform();
		// Choose the item to click from allItems
		action.click(allItems.get(0));
		action.click(allItems.get(3));
		action.click(allItems.get(8));
		action.click(allItems.get(9));
		action.click(allItems.get(11));
		// Use "action.keyUp()" to release the Control key
		action.keyUp(Keys.CONTROL).perform();
		sleepInSecond(3);
		List<WebElement> allSelectedItems = driver.findElements(By.xpath("//ol[@id='selectable']/li[contains(@class,'ui-selected')]"));
		System.out.println("Selected Item Number = " +allSelectedItems.size());
		Assert.assertEquals(allSelectedItems.size(), 5);
		for (WebElement item: allSelectedItems) {
			System.out.println(item.getText());
		}
	}
	
	@Test
	public void TC_04_Double_Click() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		action.doubleClick(driver.findElement(By.xpath("//button[text()='Double click me']"))).perform();
		sleepInSecond(3);
		String hiddenText = driver.findElement(By.xpath("//p[@id='demo']")).getText();
		Assert.assertEquals(hiddenText, "Hello Automation Guys!");
		System.out.println("Text = " + hiddenText);
	}
	
	@Test
	public void TC_05_Right_Click() {
		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
		// Use "action.contextClick()" to right-click
		action.contextClick(driver.findElement(By.xpath("//span[text()='right click me']"))).perform();
		action.moveToElement(driver.findElement(By.xpath("//li[contains(@class,'context-menu-icon-quit')]"))).perform();
		Assert.assertTrue(driver.findElement(By.xpath("//li[contains(@class,'context-menu-icon-quit') and contains(@class,'context-menu-hover')]")).isDisplayed());
		action.click(driver.findElement(By.xpath("//li[contains(@class,'context-menu-icon-quit')]"))).perform();
		sleepInSecond(3);
		// Accept the alert
		driver.switchTo().alert().accept();
	}
	
	@Test
	public void TC_06_Drag_And_Drop() {
		driver.get("https://demos.telerik.com/kendo-ui/dragdrop/angular");
		// Use "action.dragAndDrop()" to drag & drop
		action.dragAndDrop(driver.findElement(By.xpath("//div[@id='draggable']")), driver.findElement(By.xpath("//div[@id='droptarget']"))).perform();
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='droptarget']")).getText(), "You did great!");
	}
	
	@Test
	public void TC_07_Drag_And_Drop_HTML5() {
		driver.get("http://the-internet.herokuapp.com/drag_and_drop");
		String sourceCss = "#column-a";
		String targetCss = "#column-b";
		String java_script = readFile(javascriptPath);
		
		

	}
	
	public void sleepInSecond(long timeout) {
		//Use "Surround with Try/Catch"
		try {
			Thread.sleep(timeout * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}