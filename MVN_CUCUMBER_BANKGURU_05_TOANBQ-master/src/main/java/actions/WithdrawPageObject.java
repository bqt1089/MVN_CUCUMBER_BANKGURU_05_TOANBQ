package actions;

import commons.AbstractPage;
import org.openqa.selenium.WebDriver;

public class WithdrawPageObject extends AbstractPage {
    WebDriver driver;

    public WithdrawPageObject(WebDriver mappingDriver) {
        driver = mappingDriver;
    }

}
