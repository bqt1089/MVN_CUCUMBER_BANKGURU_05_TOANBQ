package stepDefinitions;

import actions.PageFactoryManager;
import actions.DeleteAccountPageObject;
import cucumberConfig.Hooks;
import org.openqa.selenium.WebDriver;

public class DeleteAccountSteps {
    WebDriver driver;
    private DeleteAccountPageObject deleteAccountPageObject;


    public DeleteAccountSteps() {
        driver = Hooks.openBrowser();
        deleteAccountPageObject = PageFactoryManager.getDeleteAccountPageObject(driver);
    }

}
