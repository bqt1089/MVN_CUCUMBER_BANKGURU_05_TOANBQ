package actions;

import commons.AbstractPage;
import interfaces.RegisterPageUI;

import org.openqa.selenium.WebDriver;

public class RegisterPageObject extends AbstractPage {
    WebDriver driver;

    public RegisterPageObject(WebDriver mappingDriver) {
        driver = mappingDriver;
    }
    public void sendTextToEmailField(String value) {
    	waitForControlVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
    	sendKeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, value);
    }

}
