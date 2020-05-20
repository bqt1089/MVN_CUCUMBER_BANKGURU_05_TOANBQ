package actions;

import commons.AbstractPage;
import org.openqa.selenium.WebDriver;

public class DepositPageObject extends AbstractPage {
    WebDriver driver;

    public DepositPageObject(WebDriver mappingDriver) {
        driver = mappingDriver;
    }

}
