package stepDefinitions;

import actions.AbstractPageObject;
import actions.PageFactoryManager;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumberConfig.Hooks;
import org.openqa.selenium.WebDriver;

public class NewAccountSteps {
    WebDriver driver;
    private AbstractPageObject abstractPageObject;

    public NewAccountSteps() {
        driver = Hooks.openBrowser();
        abstractPageObject = PageFactoryManager.getAbstracPageObject(driver);
    }

    @Then("^I get Account ID in \"([^\"]*)\" table$")
    public void iGetAccountIdInTable(String locatorValue) {
        ShareData.accountID = abstractPageObject.getDynamicTextOnTable(driver,locatorValue);
        System.out.println(ShareData.accountID);
    }

    @And("^I get second Account ID in \"([^\"]*)\" table$")
    public void iGetSecondAccountIDInTable(String locatorValue) {
        ShareData.secondAccountID = abstractPageObject.getDynamicTextOnTable(driver,locatorValue);
        System.out.println(ShareData.secondAccountID);
    }


}
