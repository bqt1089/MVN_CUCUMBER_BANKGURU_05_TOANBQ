package stepDefinitions;

import actions.DeleteAccountPageObject;
import actions.DeleteCustomerPageObject;
import actions.PageFactoryManager;
import cucumber.api.java.en.Given;
import cucumberConfig.Hooks;
import org.openqa.selenium.WebDriver;

public class DeleteCustomerSteps {
    WebDriver driver;
    private DeleteCustomerPageObject deleteCustomerPageObject;


    public DeleteCustomerSteps() {
        driver = Hooks.openBrowser();
        deleteCustomerPageObject = PageFactoryManager.getDeleteCustomerPageObject(driver);
    }

}
