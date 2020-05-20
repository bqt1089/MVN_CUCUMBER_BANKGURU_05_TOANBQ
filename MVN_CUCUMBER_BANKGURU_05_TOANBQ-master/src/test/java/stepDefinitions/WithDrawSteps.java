package stepDefinitions;

import actions.PageFactoryManager;
import actions.WithdrawPageObject;
import cucumberConfig.Hooks;
import org.openqa.selenium.WebDriver;

public class WithDrawSteps {
    WebDriver driver;
    private WithdrawPageObject withdrawPageObject;


    public WithDrawSteps() {
        driver = Hooks.openBrowser();
        withdrawPageObject = PageFactoryManager.getWithdrawPageObject(driver);
    }

}
