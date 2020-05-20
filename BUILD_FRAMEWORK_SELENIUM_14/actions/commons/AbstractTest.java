package commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

public class AbstractTest {

    private WebDriver driver;

    String proDir = System.getProperty("user.dir");

    public WebDriver openMultiBrowser(String browser, String url) {
        if (browser.toLowerCase().equals("chrome")) {
            if (checkOs().toLowerCase().contains("mac")) {
                System.setProperty("webdriver.chrome.driver", proDir+ "/resources/driverMac/chromedriver");
//                driver = new ChromeDriver();
//                WebDriverManager.chromedriver().setup();
            } else {
                System.out.println("Not run on Mac");
            }
            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            ChromeOptions options = new ChromeOptions();
//			options.addArguments("-incognito");
            options.addArguments("--disable-extensions");
            options.addArguments("disable-inforbars");
            options.addArguments("start-maximized");
            capabilities.setCapability(ChromeOptions.CAPABILITY, options);
            driver = new ChromeDriver(capabilities);

        } else if (browser.toLowerCase().equals("firefox")) {
//            WebDriverManager.firefoxdriver().setup();
            System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
            FirefoxOptions options = new FirefoxOptions();
            driver = new FirefoxDriver(options);

        } else if (browser.toLowerCase().equals("chromeheadless")) {
            if (checkOs().toLowerCase().contains("mac")) {
//                WebDriverManager.chromedriver().setup();
            } else {
                System.out.println("Not run on Mac");
            }
            ChromeOptions options = new ChromeOptions();
            options.addArguments("headless");
            options.addArguments("window-size=1366x768");
            driver = new ChromeDriver(options);
        } else if (browser.toLowerCase().equals("firefoxheadless")) {
//            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            options.setHeadless(true);
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
                // Kill process
                if (osName.toLowerCase().contains("mac")) {
                    cmd = "pkill chromedriver";
                } else {
                    cmd = "taskkill /F /FI \"IMAGENAME eq chromedriver*\"";
                }
                Process process = Runtime.getRuntime().exec(cmd);
                process.waitFor();
            }
            if (driver.toString().toLowerCase().contains("firefox")) {
                if (osName.toLowerCase().contains("mac")) {
                    cmd = "pkill firefoxdriver";
                } else {
                    cmd = "taskkill /F /FI \"IMAGENAME eq firefoxdriver*\"";
                }
                Process process = Runtime.getRuntime().exec(cmd);
                process.waitFor();
            }
            if (driver.toString().toLowerCase().contains("internetexplorer")) {
                cmd = "taskkill /F /FI \"IMAGENAME eq IEDriverServer*\"";
                Process process = Runtime.getRuntime().exec(cmd);
                process.waitFor();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
