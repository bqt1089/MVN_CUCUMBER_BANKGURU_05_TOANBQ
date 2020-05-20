package commons;

import java.util.Random;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

public class AbstractTest {
    WebDriver driver;
    protected final Log log;

    public AbstractTest() {
        log = LogFactory.getLog(getClass());
    }

    private boolean checkPassed(boolean condition) {
        boolean pass = true;
        try {

            if (condition == true)
                log.info("===PASSED===");
            else
                log.info("===FAILED===");
            Assert.assertTrue(condition);
        } catch (Throwable e) {
            pass = false;
            log.info(e);
            // Add status (true/ false) to Report (ReportNG)
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }

    public boolean verifyTrue(boolean condition) {
        return checkPassed(condition);
    }

    private boolean checkFailed(boolean condition) {
        boolean pass = true;
        try {
            if (condition == true)
                log.info("===PASSED===");
            else
                log.info("===FAILED===");
            Assert.assertFalse(condition);

        } catch (Throwable e) {
            pass = false;
            log.info(e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }

        return pass;
    }

    public boolean verifyFalse(boolean condition) {
        return checkFailed(condition);
    }

    private boolean checkEquals(Object actual, Object expected) {
        boolean pass = true;
        try {
            Assert.assertEquals(actual, expected);
        } catch (Throwable e) {
            pass = false;
            log.info(e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }

    public boolean verifyEquals(Object actual, Object expected) {
        return checkEquals(actual, expected);
    }

    public String randomNumber() {
        Random num = new Random();
        int numbInt = num.nextInt(99999999) + 1;
        String numbStr = String.valueOf(numbInt);
        return numbStr;
    }

    String pathProject = System.getProperty("user.dir");
}
