package stepDefinitions;

import actions.DepositPageObject;
import actions.PageFactoryManager;
import cucumber.api.java.en.Given;
import cucumberConfig.Hooks;
import org.openqa.selenium.WebDriver;

public class DepositSteps {
    WebDriver driver;
    private DepositPageObject depositPageObject;


    public DepositSteps() {
        driver = Hooks.openBrowser();
        depositPageObject = PageFactoryManager.getDepositPageObject(driver);
    }

}
