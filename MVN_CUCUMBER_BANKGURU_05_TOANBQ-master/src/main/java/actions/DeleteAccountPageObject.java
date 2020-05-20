package actions;

import commons.AbstractPage;
import org.openqa.selenium.WebDriver;

public class DeleteAccountPageObject extends AbstractPage {
    WebDriver driver;

    public DeleteAccountPageObject(WebDriver mappingDriver) {
        driver = mappingDriver;
    }

}
