package stepDefinitions;

import actions.AbstractPageObject;
import actions.PageFactoryManager;
import commons.AbstractTest;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumberConfig.Hooks;
import interfaces.LoginPageUI;
import interfaces.RegisterPageUI;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AbstractSteps {
    WebDriver driver;
    private AbstractPageObject abstractPageObject;
    private AbstractTest abstractTest;
    private ShareData shareData;

    public AbstractSteps() {
        driver = Hooks.openBrowser();
        abstractPageObject = PageFactoryManager.getAbstracPageObject(driver);
        abstractTest = new AbstractTest();
        shareData = new ShareData();
    }

    //Open Any Page
    @Given("^I open \"([^\"]*)\" page$")
    public void iOpenPage(String pageName) {
        abstractPageObject.openDynamicAnyPages(driver, pageName);
    }

    // VERIFY DYNAMIC XPATH
    @Then("^I verify \"([^\"]*)\" display$")
    public void iVerifySomethingDisplay(String expectedValue) {
        abstractTest.verifyTrue(abstractPageObject.isDynamicSuccessTable(driver, expectedValue));
    }

    @Then("^I verify \"([^\"]*)\" correct with data \"([^\"]*)\"$")
    public void iVerifyCorrectWithData(String locatorValue, String expectedValue) {
        abstractTest.verifyEquals(abstractPageObject.getDynamicTextOnTable(driver, locatorValue), expectedValue);
    }

    // INPUT TO DISABLE DYNAMIC XPATH

    @When("^I input to disable \"([^\"]*)\" textarea with data \"([^\"]*)\"$")
    public void iInputToDisableTextareaWithData(String locatorValue, String inputValue) {
        abstractPageObject.sendkeyToDynamicDisableArea(driver, locatorValue, inputValue);
    }

    @When("^I input to disable \"([^\"]*)\" textbox with data \"([^\"]*)\"$")
    public void iInputToDisableTextboxWithData(String locatorValue, String inputValue) {
        abstractPageObject.sendkeyToDynamicDisableField(driver, locatorValue, inputValue);
    }

    @When("^I input userId and password into fields$")
    public void iInputUserIdAndPasswordIntoFields() {
        abstractPageObject.sendkeyToDynamicTextBox(driver, LoginPageUI.USERID_TEXTBOX, ShareData.userId);
        abstractPageObject.sendkeyToDynamicTextBox(driver, LoginPageUI.PASSWORD_TEXTBOX, ShareData.password);
    }

    // INPUT TO ENABLE DYNAMIC XPATH
    @When("^I input to \"([^\"]*)\" textbox with data \"([^\"]*)\"$")
    public void iInputToTextboxWithData(String locatorValue, String value) {
        abstractPageObject.sendkeyToDynamicTextBox(driver, locatorValue, value);
    }

    @When("^I click to \"([^\"]*)\" radio button with Male$")
    public void iClickToRadioButtonWithMale(String locatorValue) {
        abstractPageObject.clickAnyDynamicRadioButton(driver, locatorValue);
    }

    @And("^I input to \"([^\"]*)\" date field with data \"([^\"]*)\"$")
    public void iInputToDateFieldWithData(String locatorValue, String value) {
        abstractPageObject.sendkeyToDynamicDateField(driver, locatorValue, value);
    }


    @When("^I input to \"([^\"]*)\" textarea with data \"([^\"]*)\"$")
    public void iInputToTextareaWithData(String locatorValue, String value) {
        abstractPageObject.sendkeyToDynamicTextArea(driver, locatorValue, value);
    }

    @When("^I click \"([^\"]*)\" button$")
    public void iClickButton(String locatorValue) {
        abstractPageObject.clickToDynamicButton(driver, locatorValue);
    }

    @And("^I select in \"([^\"]*)\" dropdown list with data \"([^\"]*)\"$")
    public void iSelectInDropdownListWithData(String locatorValue, String value) {
        abstractPageObject.selectDynamicDropDown(driver, locatorValue, value);
    }

    @When("^I input Customer ID into \"([^\"]*)\" field$")
    public void iInputCustomerIDIntoField(String locatorValue) {
        abstractPageObject.sendkeyToDynamicTextBox(driver, locatorValue, ShareData.customerId);
    }

    @Then("^I click btn Submit button$")
    public void iClickBtnSubmitButton() {
        abstractPageObject.clickToDynamicButton(driver, RegisterPageUI.SUBMIT_BUTTON);
    }

    @When("^I input to Account ID into \"([^\"]*)\" field$")
    public void iInputToAccountIDIntoField(String locatorValue) {
        abstractPageObject.sendkeyToDynamicTextBox(driver, locatorValue, ShareData.accountID);
    }

    @When("^I input second Account ID into \"([^\"]*)\" field$")
    public void iInputToSecondAccountIDIntoField(String locatorValue) {
        abstractPageObject.sendkeyToDynamicTextBox(driver, locatorValue, ShareData.secondAccountID);
    }

    //Delete Account
    @Then("^I verify text \"([^\"]*)\" on Alert and accept Alert$")
    public void iVerifyTextOnAlertAndAcceptAlert(String expected) {
        abstractTest.verifyTrue(abstractPageObject.isContentTextOnAlert(driver, expected));
    }

    @And("^I click \"([^\"]*)\" button and accept delete$")
    public void iClickSomethingButtonAndAcceptDelete(String locatorValue) {
        abstractPageObject.clickDeleteAccount(driver, locatorValue);
    }

    //Verify Error with actions
    @When("^I leave \"([^\"]*)\" textbox blank$")
    public void iLeaveTextboxBlank(String locatorValue) {
        abstractPageObject.leaveDynamicTextBoxBlank(driver, locatorValue);
    }

    @When("^I leave \"([^\"]*)\" textarea blank$")
    public void iLeaveTextareaBlank(String locatorValue) {
        abstractPageObject.leaveDynamicTextAreaBlank(driver, locatorValue);
    }

    @Then("^I verify \"([^\"]*)\" error with text \"([^\"]*)\" display$")
    public void iVerifyErrorWithTextDisplay(String locatorValue, String errorText) {
        Assert.assertTrue(abstractPageObject.isDynamicErrorTextField(driver, errorText, locatorValue));
    }

    //Wait
    @And("^I wait in \"([^\"]*)\" seconds$")
    public void iwaitInSeconds(String timeSecond) {
        abstractPageObject.waitSleepWithDynamicTime(timeSecond);
    }


}