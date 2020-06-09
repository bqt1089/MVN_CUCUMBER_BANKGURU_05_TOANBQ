package commons;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

import java.util.concurrent.TimeUnit;

public class AbstractTest {

    private WebDriver driver;
    protected final Log log;

    protected AbstractTest() {
        log = LogFactory.getLog(getClass());
    }

    String proDir = System.getProperty("user.dir");
    DriverType driverType = new DriverType();

    public WebDriver openMultiBrowser(String browser, String url) {
        if (browser.toLowerCase().equals("chrome")) {
            driver = driverType.chromeDriver();
        } else if (browser.toLowerCase().equals("firefox")) {
            driver = driverType.firefoxDriver();
        } else if (browser.toLowerCase().equals("chromeheadless")) {
            driver = driverType.chromeHeadless();
        } else if (browser.toLowerCase().equals("firefoxheadless")) {
            driver = driverType.firefoxDriver();
        }
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        // driver.manage().window().maximize();
        driver.get(url);
        return driver;
    }

    public String checkOs() {
        String osName = System.getProperty("os.name");
        return osName;
    }

    // Hàm close browser driver
    protected void closeBrowser() {
        try {
            // Detect OS (Windows/ Linux/ MAC)
            String osName = System.getProperty("os.name").toLowerCase();
            String cmd = "";
            driver.quit();
            if (driver.toString().toLowerCase().contains("chrome")) {
                driverType.closeChromeDriver();
            }
            if (driver.toString().toLowerCase().contains("firefox")) {
                driverType.closeFirefoxDriver();
            }
            if (driver.toString().toLowerCase().contains("internetexplorer")) {
                driverType.closeIEDriver();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private boolean checkTrue(boolean condition) {
        boolean pass = true;
        try {
            if (condition == true) {
                log.info(" -------------------------- PASSED -------------------------- ");
            } else {
                log.info(" -------------------------- FAILED -------------------------- ");
            }
            Assert.assertTrue(condition);
        } catch (Throwable e) {
            pass = false;

            // Add lỗi vào ReportNG
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }

    protected boolean verifyTrue(boolean condition) {
        return checkTrue(condition);
    }

    private boolean checkFailed(boolean condition) {
        boolean pass = true;
        try {
            if (condition == false) {
                log.info(" -------------------------- PASSED -------------------------- ");
            } else {
                log.info(" -------------------------- FAILED -------------------------- ");
            }
            Assert.assertFalse(condition);
        } catch (Throwable e) {
            pass = false;
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }

    protected boolean verifyFalse(boolean condition) {
        return checkFailed(condition);
    }

    private boolean checkEquals(Object actual, Object expected) {
        boolean pass = true;
        try {
            Assert.assertEquals(actual, expected);
            log.info(" -------------------------- PASSED -------------------------- ");
        } catch (Throwable e) {
            pass = false;
            log.info(" -------------------------- FAILED -------------------------- ");
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }

    protected boolean verifyEquals(Object actual, Object expected) {
        return checkEquals(actual, expected);
    }
}
