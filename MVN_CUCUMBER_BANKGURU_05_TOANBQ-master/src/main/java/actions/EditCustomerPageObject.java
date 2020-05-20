package actions;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import interfaces.AbstractPageUI;

public class EditCustomerPageObject extends AbstractPage {
	WebDriver driver;
	
	public EditCustomerPageObject  (WebDriver mappingDriver) {
		driver = mappingDriver;
	}
	
	public void sendTextToEmailField(String value) {
		waitForControlVisible(driver, AbstractPageUI.DynamicLocator.DYNAMIC_TEXTBOX, AbstractPageUI.FieldName.EMAIL_FIELD);
		sendKeysToDisableField(driver, AbstractPageUI.DynamicLocator.DYNAMIC_TEXTBOX, value, AbstractPageUI.FieldName.EMAIL_FIELD, value);
	}
	

}
