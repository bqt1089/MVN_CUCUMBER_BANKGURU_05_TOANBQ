package actions;

import commons.AbstractPage;
import org.openqa.selenium.WebDriver;

public class DeleteCustomerPageObject extends AbstractPage {
    WebDriver driver;

    public DeleteCustomerPageObject(WebDriver mappingDriver) {
        driver = mappingDriver;
    }

}
