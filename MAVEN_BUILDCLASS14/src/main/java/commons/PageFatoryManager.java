package commons;

import org.openqa.selenium.WebDriver;
import pageObjects.LoginPageObject;

public class PageFatoryManager {

    public static LoginPageObject getLoginPageObject(WebDriver driver) {
        return new LoginPageObject(driver);
    }

}
