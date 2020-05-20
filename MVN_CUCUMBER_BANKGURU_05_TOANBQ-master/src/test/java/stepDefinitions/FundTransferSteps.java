package stepDefinitions;

import actions.FundTransferPageObject;
import actions.PageFactoryManager;
import cucumberConfig.Hooks;
import org.openqa.selenium.WebDriver;

public class FundTransferSteps {
    WebDriver driver;
    private FundTransferPageObject fundTransferPageObject;


    public FundTransferSteps() {
        driver = Hooks.openBrowser();
        fundTransferPageObject = PageFactoryManager.getFundTransferPageObject(driver);
    }

}
