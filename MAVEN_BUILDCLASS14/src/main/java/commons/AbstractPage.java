package commons;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public abstract class AbstractPage {
    private long timeout = 15;
    private long shorTimeout = 5;
    private WebDriverWait explicitWait;
    private Select select;
    private JavascriptExecutor javascriptExecutor;
    private WebElement element;
    private List<WebElement> elements;
    private Actions action;

    protected void openUrl(WebDriver driver, String url) {
        driver.get(url);
    }

    protected String getTitlePage(WebDriver driver) {
        return driver.getTitle();
    }

    protected String getCurrentUrl(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    protected String getPageSource(WebDriver driver) {
        return driver.getPageSource();
    }

    protected void backPreviousPage(WebDriver driver) {
        driver.navigate().back();
    }

    protected void forward(WebDriver driver) {
        driver.navigate().forward();
    }

    protected void refresh(WebDriver driver) {
        driver.navigate().refresh();
    }

    protected void acceptAlert(WebDriver driver) {
        driver.switchTo().alert().accept();
    }

    protected void cancelAlert(WebDriver driver) {
        driver.switchTo().alert().dismiss();
    }

    protected void sendKeyToAlert(WebDriver driver, String value) {
        driver.switchTo().alert().sendKeys(value);
    }

    protected String getTextOnAlert(WebDriver driver) {
        return driver.switchTo().alert().getText();
    }

    protected void waitForAlertPresence(WebDriver driver) {
        explicitWait = new WebDriverWait(driver, timeout);
        explicitWait.until(ExpectedConditions.alertIsPresent());
    }

    protected String getParentWindow(WebDriver driver) {
        return driver.getWindowHandle();
    }

    protected void swithToChildWinDownByIDOnly2Windows(WebDriver driver, String parentWindow) {
        Set<String> allWindowns = driver.getWindowHandles();
        for (String runWindown : allWindowns) {
            if (!runWindown.equals(parentWindow)) {
                driver.switchTo().window(runWindown);
                break;
            }
        }
    }

    protected void customSwitchToChildWindownByTitle(WebDriver driver, String title) {
        Set<String> allWindowns = driver.getWindowHandles();
        for (String runWindow : allWindowns) {
            driver.switchTo().window(runWindow);
            String currentWin = driver.getTitle();
            if (currentWin.equals(title)) {
                break;
            }
        }
    }

    protected boolean closeAllWithoutParentWindows(WebDriver driver, String parentWindow) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindows : allWindows) {
            if (!runWindows.equals(parentWindow)) {
                driver.switchTo().window(runWindows);
                driver.close();
            }
        }
        driver.switchTo().window(parentWindow);
        if (driver.getWindowHandles().size() == 1)
            return true;
        else
            return false;
    }

    /* ================================  WebElement  ============================================ */

    protected By byXpath(String locator) {
        return By.xpath(locator);
    }

    protected WebElement findElementByXpath(WebDriver driver, String locator) {
        return driver.findElement(byXpath(locator));
    }

    protected List<WebElement> findElementsByXpath(WebDriver driver, String locator) {
        return driver.findElements(byXpath(locator));
    }

    protected void clickOnElement(WebDriver driver, String locator) {
        findElementByXpath(driver, locator).click();
    }

    protected void sendkeyToElement(WebDriver driver, String locator, String value) {
        element = findElementByXpath(driver, locator);
        element.clear();
        element.sendKeys(value);
    }

    protected void selectValueInDropDown(WebDriver driver, String locator, String item) {
        select = new Select(findElementByXpath(driver, locator));
        select.deselectByVisibleText(item);
    }

    protected void selectCustomDropdownList(WebDriver driver, String locator, String itemsList, String itemvalue) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        element = findElementByXpath(driver, locator);
        javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
        List<WebElement> allItems = driver.findElements(By.xpath(itemsList));
        wait.until(ExpectedConditions.visibilityOfAllElements(allItems));

        for (WebElement item : allItems) {
            if (item.getText().trim().equals(itemvalue)) {
                javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
                javascriptExecutor.executeScript("arguments[0].click()", item);
                break;
            }
        }
    }

    protected String getSelectedItemInDropdown(WebDriver driver, String locator) {
        select = new Select(findElementByXpath(driver, locator));
        return select.getFirstSelectedOption().getText();
    }

    protected String getAttributeValue(WebDriver driver, String locator, String attribute) {
        element = findElementByXpath(driver, locator);
        return element.getAttribute(attribute);
    }

    protected String getTextElement(WebDriver driver, String locator) {
        element = findElementByXpath(driver, locator);
        return element.getText().trim();
    }

    protected int countElementNumber(WebDriver driver, String locator) {
        elements = findElementsByXpath(driver, locator);
        return elements.size();
    }

    protected void checkTheCheckbox(WebDriver driver, String locator) {
        element = findElementByXpath(driver, locator);
        if (!element.isSelected()) {
            element.click();
        }
    }

    protected void uncheckTheCheckbox(WebDriver driver, String locator) {
        element = findElementByXpath(driver, locator);
        if (element.isSelected()) {
            element.click();
        }
    }

    protected boolean isElementDisplayed(WebDriver driver, String locator) {
        element = findElementByXpath(driver, locator);
        return element.isDisplayed();
    }

    public boolean isElementSelected(WebDriver driver, String locator) {
        element = findElementByXpath(driver, locator);
        return element.isSelected();
    }

    protected boolean isElementEnabled(WebDriver driver, String locator) {
        element = findElementByXpath(driver, locator);
        return element.isEnabled();
    }

    protected void switchIframeByElement(WebDriver driver, String locator) {
        element = findElementByXpath(driver, locator);
        driver.switchTo().frame(element);
    }

    protected void switchToDefaultContent(WebDriver driver) {
        driver.switchTo().defaultContent();
    }

    protected void hoverMouseToElement(WebDriver driver, String locator) {
        element = findElementByXpath(driver, locator);
        action = new Actions(driver);
        action.moveToElement(element).perform();
    }

    protected void doubleClickOnElement(WebDriver driver, String locator) {
        element = findElementByXpath(driver, locator);
        action = new Actions(driver);
        action.doubleClick(element).perform();
    }

    protected void rightClickOnElement(WebDriver driver, String locator) {
        element = findElementByXpath(driver, locator);
        action = new Actions(driver);
        action.contextClick(element).perform();
    }

    protected void sendKeyboardToElement(WebDriver driver, String locator, Keys key) {
        element = findElementByXpath(driver, locator);
        action = new Actions(driver);
        action.sendKeys(element, key).perform();
    }

    protected void dragAndDrop(WebDriver driver, String sourceToDrag, String targetToDrop) {
        WebElement sourceButton = findElementByXpath(driver, sourceToDrag);
        WebElement targetButton = findElementByXpath(driver, targetToDrop);
        action = new Actions(driver);
        action.dragAndDrop(sourceButton, targetButton);
    }

    protected void customDragAndDrop(WebDriver driver, String sourceToDrag, String targetToDrop) {
        WebElement sourceButton = findElementByXpath(driver, sourceToDrag);
        WebElement targetButton = findElementByXpath(driver, targetToDrop);
        action = new Actions(driver);
        action.clickAndHold(sourceButton);
        action.moveToElement(targetButton);
        action.release().perform();
    }

    protected void uploadFileBySendKey(WebDriver driver, String locator, String fileName) {
        String proDir = System.getProperty("user.dir");
        String filePath = proDir + "\\resource\\" + fileName;
        element = findElementByXpath(driver, locator);
        element.sendKeys(filePath);
    }

    protected void uploadMultiFileBySendKey(WebDriver driver, String locator, String[] filesUpload) {
        String proDir = System.getProperty("user.dir");
        element = findElementByXpath(driver, locator);
        for (int i = 0; i < filesUpload.length; i++) {
            String filePath = proDir + "\\resource\\" + filesUpload[i];
            element.sendKeys(filePath);
        }
    }

    protected Object executeForBrowserElement(WebDriver driver, String javaSript) {
        try {
            javascriptExecutor = (JavascriptExecutor) driver;
            return javascriptExecutor.executeScript(javaSript);
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    protected String getDomainByJS(WebDriver driver) {
        javascriptExecutor = (JavascriptExecutor) driver;
        String domain = (String) javascriptExecutor.executeScript("return document.domain");
        return domain;
    }

    protected String getUrlPageByJS(WebDriver driver) {
        javascriptExecutor = (JavascriptExecutor) driver;
        String URL = (String) javascriptExecutor.executeScript("return document.URL");
        return URL;
    }

    protected String getTitlePageByJS(WebDriver driver) {
        javascriptExecutor = (JavascriptExecutor) driver;
        String sText = javascriptExecutor.executeScript("return document.title;").toString();
        return sText;
    }

    protected String getInnerTextByJS(WebDriver driver) {
        javascriptExecutor = (JavascriptExecutor) driver;
        String sText = javascriptExecutor.executeScript("return document.documentElement.innerText;").toString();
        return sText;
    }

    protected void highlightElementByJS(WebDriver driver, String locator) {
        WebElement element = driver.findElement(By.xpath(locator));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='2px groove green'", element);
    }

    protected void refreshBrowserByJS(WebDriver driver) {
        javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("history.go(0)");
    }

    protected void clickElementByJS(WebDriver driver, String locator) {
        element = findElementByXpath(driver, locator);
        javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].click();", element);
    }

    protected Object removeAttributeInDOM(WebDriver driver, String locator, String attribute) {
        try {
            element = findElementByXpath(driver, locator);
            javascriptExecutor = (JavascriptExecutor) driver;
            return javascriptExecutor.executeScript("arguments[0].removeAttribute('" + attribute + "');", element);
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    protected Object scrollToBottomPage(WebDriver driver) {
        try {
            javascriptExecutor = (JavascriptExecutor) driver;
            return javascriptExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    protected void scrollToElementByJS(WebDriver driver, String locator) {
        element = findElementByXpath(driver, locator);
        javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    protected void waitForControlPresence(WebDriver driver, String locator) {
        By xpathLocator = byXpath(locator);
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.presenceOfElementLocated(xpathLocator));
    }

    protected void waitForControlVisible(WebDriver driver, String locator) {
        element = findElementByXpath(driver, locator);
        explicitWait = new WebDriverWait(driver, timeout);
        explicitWait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void waitForControlClickAble(WebDriver driver, String locator) {
        element = findElementByXpath(driver, locator);
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void waitForControlNotVisible(WebDriver driver, String locator) {
        By xpathLocator = byXpath(locator);
        explicitWait = new WebDriverWait(driver, timeout);
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(xpathLocator));
    }

    protected boolean isControlUndisplayed(WebDriver driver, String locator) {
        Date date = new Date();
        System.out.println("Started time = " + date.toString());
        overrideGlobalTimeout(driver, shorTimeout);
        List<WebElement> elements = driver.findElements(By.xpath(locator));
        if (elements.size() == 0) {
            date = new Date();
            System.out.println("End time = " + date.toString());
            overrideGlobalTimeout(driver, timeout);
            return true;
        } else {
            date = new Date();
            System.out.println("End time = " + date.toString());
            overrideGlobalTimeout(driver, timeout);
            return false;
        }
    }

    protected void overrideGlobalTimeout(WebDriver driver, long timeOut) {
        driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
    }

    protected int randomNumber() {
        Random num = new Random();
        int n = num.nextInt(99999999) + 1;
        return n;
    }

}
