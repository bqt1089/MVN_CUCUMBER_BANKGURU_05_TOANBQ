package pageObjects;

import commons.AbstractPage;
import org.openqa.selenium.WebDriver;
import pageUI.LoginPageUI;

public class LoginPageObject extends AbstractPage {
    WebDriver driver;

    public LoginPageObject(WebDriver mapDriver) {
        driver = mapDriver;
    }

    public void inputEmailTxb(String value) {
        sendkeyToElement(driver, LoginPageUI.usernameTxb, value);
    }

    public boolean isTextErrorCorrect(String errorTxt) {
        return getTextElement(driver, LoginPageUI.errorEmailTxt).equals(errorTxt);
    }

}
