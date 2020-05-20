package actions;


import commons.AbstractPage;
import interfaces.AbstractPageUI;
import org.openqa.selenium.WebDriver;

public class AbstractPageObject extends AbstractPage {
    WebDriver driver;

    public AbstractPageObject(WebDriver mappingDriver) {
        driver = mappingDriver;
    }

    // DYNAMIC ACTION

    public void sendkeyToDynamicTextBox(WebDriver driver, String locatorValue, String inputValue) {
        waitForControlVisible(driver, AbstractPageUI.DynamicLocator.DYNAMIC_TEXTBOX, locatorValue);
        scrollToElementByJS(driver, AbstractPageUI.DynamicLocator.DYNAMIC_TEXTBOX, locatorValue);
        sendKeyToElement(driver, AbstractPageUI.DynamicLocator.DYNAMIC_TEXTBOX, inputValue, locatorValue);
    }

    public void sendkeyToDynamicDateField(WebDriver driver, String locatorValue, String inputValue) {
        waitForControlVisible(driver, AbstractPageUI.DynamicLocator.DYNAMIC_TEXTBOX, locatorValue);
        scrollToElementByJS(driver, AbstractPageUI.DynamicLocator.DYNAMIC_TEXTBOX, locatorValue);
        sendKeyToDateField(driver, AbstractPageUI.DynamicLocator.DYNAMIC_TEXTBOX, inputValue, locatorValue);
    }

    public void sendkeyToDynamicDisableField(WebDriver driver, String locatorValue, String inputValue) {
        waitForControlVisible(driver, AbstractPageUI.DynamicLocator.DYNAMIC_TEXTBOX, locatorValue);
        scrollToElementByJS(driver, AbstractPageUI.DynamicLocator.DYNAMIC_TEXTBOX, locatorValue);
        sendKeysToDisableField(driver, AbstractPageUI.DynamicLocator.DYNAMIC_TEXTBOX, inputValue, locatorValue);
    }

    public void sendkeyToDynamicTextArea(WebDriver driver, String locatorValue, String inputValue) {
        waitForControlVisible(driver, AbstractPageUI.DynamicLocator.DYNAMIC_TEXTAREA, locatorValue);
        scrollToElementByJS(driver, AbstractPageUI.DynamicLocator.DYNAMIC_TEXTAREA, locatorValue);
        sendKeyToElement(driver, AbstractPageUI.DynamicLocator.DYNAMIC_TEXTAREA, inputValue, locatorValue);
    }

    public void sendkeyToDynamicDisableArea(WebDriver driver, String locatorValue, String inputValue) {
        waitForControlVisible(driver, AbstractPageUI.DynamicLocator.DYNAMIC_TEXTAREA, locatorValue);
        scrollToElementByJS(driver, AbstractPageUI.DynamicLocator.DYNAMIC_TEXTAREA, locatorValue);
        sendKeysToDisableField(driver, AbstractPageUI.DynamicLocator.DYNAMIC_TEXTAREA, inputValue, locatorValue);
    }

    public void clickAnyDynamicRadioButton(WebDriver driver, String locatorValue) {
        waitForControlVisible(driver, AbstractPageUI.DynamicLocator.DYNAMIC_RADIO_BUTTON, locatorValue);
        scrollToElementByJS(driver, AbstractPageUI.DynamicLocator.DYNAMIC_RADIO_BUTTON, locatorValue);
        clickToElement(driver, AbstractPageUI.DynamicLocator.DYNAMIC_RADIO_BUTTON, locatorValue);
    }

    public void clickToDynamicButton(WebDriver driver, String locatorValue) {
        waitForControlVisible(driver, AbstractPageUI.DynamicLocator.DYNAMIC_TEXTBOX, locatorValue);
        scrollToElementByJS(driver, AbstractPageUI.DynamicLocator.DYNAMIC_TEXTBOX, locatorValue);
        clickToElement(driver, AbstractPageUI.DynamicLocator.DYNAMIC_TEXTBOX, locatorValue);

    }

    public boolean isDynamicSuccessTable(WebDriver driver, String expectedValue) {
        waitForControlVisible(driver, AbstractPageUI.DynamicLocator.SUCCESS_TEXT_ON_TABLE);
        boolean isCompairContainsText = getTextElement(driver, AbstractPageUI.DynamicLocator.SUCCESS_TEXT_ON_TABLE).contains(expectedValue);
        return isCompairContainsText;
    }

    public String getDynamicTextOnTable(WebDriver driver, String locatorValue) {
        waitForControlVisible(driver, AbstractPageUI.DynamicLocator.DYNAMIC_DETAIL_TABLE, locatorValue);
        return getTextElement(driver, AbstractPageUI.DynamicLocator.DYNAMIC_DETAIL_TABLE, locatorValue);
    }

    public void selectDynamicDropDown(WebDriver driver, String locatorValue, String itemName) {
        waitForControlVisible(driver, AbstractPageUI.DynamicLocator.DYNAMIC_SELECT_DROPDOWN, locatorValue);
        selectItemInDropDown(driver, itemName, AbstractPageUI.DynamicLocator.DYNAMIC_SELECT_DROPDOWN, locatorValue);
    }

    public void clickDeleteAccount(WebDriver driver, String locatorValue) {
        clickToDynamicButton(driver, locatorValue);
        acceptAlert(driver);
    }

    public boolean isContentTextOnAlert(WebDriver driver, String expected) {
        boolean alertText = getTextAlert(driver).equals(expected);
        System.out.println(getTextAlert(driver));
        clickAcceptAlert(driver);
        return alertText;
    }

    public HomePageObject clickAcceptAlert(WebDriver driver) {
        acceptAlert(driver);
        return PageFactoryManager.getHomePageDriver(driver);
    }

    public void openDynamicAnyPages(WebDriver driver, String pageName) {
        waitForControlVisible(driver, AbstractPageUI.DynamicLocator.DYNAMIC_XPATH_OPENPAGE, pageName);
        clickToElement(driver, AbstractPageUI.DynamicLocator.DYNAMIC_XPATH_OPENPAGE, pageName);
    }

    public void leaveDynamicTextBoxBlank(WebDriver driver, String locatorValue) {
        waitForControlVisible(driver, AbstractPageUI.DynamicLocator.DYNAMIC_TEXTBOX, locatorValue);
        clickToElement(driver, AbstractPageUI.DynamicLocator.DYNAMIC_TEXTBOX, locatorValue);
        clearFieldText(driver, AbstractPageUI.DynamicLocator.DYNAMIC_TEXTBOX, locatorValue);
        keyTabPressDown(driver);
    }

    public void leaveDynamicTextAreaBlank(WebDriver driver, String locatorValue) {
        waitForControlVisible(driver, AbstractPageUI.DynamicLocator.DYNAMIC_TEXTAREA, locatorValue);
        clickToElement(driver, AbstractPageUI.DynamicLocator.DYNAMIC_TEXTAREA, locatorValue);
        clearFieldText(driver, AbstractPageUI.DynamicLocator.DYNAMIC_TEXTAREA, locatorValue);
        keyTabPressDown(driver);
    }

    public boolean isDynamicErrorTextField(WebDriver driver, String expectedValue, String... locatorValues) {
        waitForControlVisible(driver, AbstractPageUI.DynamicLocator.DYNAMIC_ERROR_MESS, locatorValues);
        return getTextElement(driver, AbstractPageUI.DynamicLocator.DYNAMIC_ERROR_MESS, locatorValues).equals(expectedValue);
    }

    public void waitSleepWithDynamicTime(String timeSecond) {
        long time = Long.parseLong(timeSecond);
        try {
            Thread.sleep(time * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
