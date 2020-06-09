package loginPage;

import commons.AbstractTest;
import commons.PageFatoryManager;
import interfaces.LoginPageUI;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.LoginPageObject;

public class Login_01 extends AbstractTest {
    WebDriver driver;
    private LoginPageObject loginPageObject;

    @Parameters({"browser"})
    @BeforeClass
    public void openUrl(String browser) {
        driver = openMultiBrowser(browser, LoginPageUI.URL);
        loginPageObject = PageFatoryManager.getLoginPageObject(driver);
    }

    @AfterClass
    public void close() {
        closeBrowser();
    }

    @Test
    public void TC_01() {
        loginPageObject.inputEmailTxb("does not exits");
        loginPageObject.clickOnContinueBtn();
        verifyTrue(loginPageObject.isTextErrorCorrect("User does not exist. Would you like to create a new account?"));
    }

    @Test
    public void TC_02() {
        verifyTrue(true);
        verifyFalse(true);
        verifyEquals(1, 2);
    }
}
