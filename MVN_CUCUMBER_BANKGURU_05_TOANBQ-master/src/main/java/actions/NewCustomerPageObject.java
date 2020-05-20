package actions;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import interfaces.AbstractPageUI;

public class NewCustomerPageObject extends AbstractPage {
	WebDriver driver;

	public NewCustomerPageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}

	public void sendTextToEmailField(String value) {
		waitForControlVisible(driver, AbstractPageUI.DynamicLocator.DYNAMIC_TEXTBOX, AbstractPageUI.FieldName.EMAIL_FIELD);
		sendKeyToElement(driver, AbstractPageUI.DynamicLocator.DYNAMIC_TEXTBOX, value, AbstractPageUI.FieldName.EMAIL_FIELD);
	}

}
