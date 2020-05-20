package actions;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import interfaces.AbstractPageUI;

public class NewAccountPageObject extends AbstractPage {
	WebDriver driver;

	public NewAccountPageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}

	public String getInforOnTable(String locatorValue) {
		waitForControlVisible(driver, AbstractPageUI.DynamicLocator.DYNAMIC_DETAIL_TABLE, locatorValue);
		return getTextElement(driver, AbstractPageUI.DynamicLocator.DYNAMIC_DETAIL_TABLE, locatorValue);
	}
}
