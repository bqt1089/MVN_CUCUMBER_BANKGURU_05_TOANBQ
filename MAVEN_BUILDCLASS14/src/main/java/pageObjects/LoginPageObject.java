package pageObjects;

import commons.AbstractPage;
import interfaces.LoginPageUI;
import org.openqa.selenium.WebDriver;

public class LoginPageObject extends AbstractPage {
    WebDriver driver;

    public LoginPageObject(WebDriver mapDriver) {
        driver = mapDriver;
    }

    public void inputEmailTxb(String value) {
        sendkeyToElement(driver, LoginPageUI.USERNAME_TXB, value);
    }

    public boolean isTextErrorCorrect(String errorTxt) {
        return getTextElement(driver, LoginPageUI.ERROR_EMAIL_TXT).equals(errorTxt);
    }

    public void clickOnContinueBtn() {
        clickOnElement(driver, LoginPageUI.CONTINUE_BTN);
    }

}
