package stepDefinitions;

import actions.BalanceEquiryPageObject;
import actions.PageFactoryManager;
import cucumberConfig.Hooks;
import org.openqa.selenium.WebDriver;

public class BalanceEquirySteps {
    WebDriver driver;
    private BalanceEquiryPageObject balanceEquiryPageObject;

    public BalanceEquirySteps() {
        driver = Hooks.openBrowser();
        balanceEquiryPageObject = PageFactoryManager.getBalanceEquiryPageObject(driver);
    }
}
