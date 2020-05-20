package stepDefinitions;

import org.openqa.selenium.WebDriver;

import actions.EditCustomerPageObject;
import actions.PageFactoryManager;
import commons.AbstractTest;
import cucumber.api.java.en.When;
import cucumberConfig.Hooks;

public class EditCustomerSteps {
    WebDriver driver;
    private EditCustomerPageObject editCustomerPageObject;
    private AbstractTest abstractTest;

    public EditCustomerSteps() {
        driver = Hooks.openBrowser();
        editCustomerPageObject = PageFactoryManager.getEditCustomerPageDriver(driver);
        abstractTest = new AbstractTest();
    }

    @When("^I input to disable EmailField with data \"([^\"]*)\"$")
    public void iInputToDisableEmailFieldWithData(String value) {
        value = abstractTest.randomNumber() + value;
        editCustomerPageObject.sendTextToEmailField(value);
    }

}