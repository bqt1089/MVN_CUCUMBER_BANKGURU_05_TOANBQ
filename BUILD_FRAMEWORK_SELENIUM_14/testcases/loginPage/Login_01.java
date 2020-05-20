package loginPage;

import commons.AbstractTest;
import commons.PageFatoryManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.LoginPageObject;
import pageUI.LoginPageUI;

public class Login_01 extends AbstractTest {
    WebDriver driver;
    private LoginPageObject loginPageObject;

    @Parameters({"browser"})
    @BeforeClass
    public void openUrl(String browser) {
        driver = openMultiBrowser(browser, LoginPageUI.url);
        loginPageObject = PageFatoryManager.getLoginPageObject(driver);
    }

    @AfterClass
    public void close() {
        closeBrowser();
    }

    @Test
    public void test01() {
        System.out.println("test 01");
        loginPageObject.inputEmailTxb("asdasd");
    }
}
