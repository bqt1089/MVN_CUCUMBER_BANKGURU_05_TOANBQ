package cucumberConfig;

import cucumber.api.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.masterthought.cucumber.Configuration;
import org.apache.commons.lang.StringUtils;
import org.junit.Before;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class Hooks {
    private static WebDriver driver;
    private static final Logger log = Logger.getLogger(Hooks.class.getName());
    private static Scenario scenario;

    @Before
    public synchronized static WebDriver openBrowser() {
        //Run by Maven command line
        String browser = System.getProperty("BROWSER");


        if (driver == null) {
            try {
                //Kiem tra BROWSER = null -> gan = chrome
                if (browser == null) {
                    browser = System.getenv("BROWSER");
                    if (browser == null) {
                        browser = "chrome";
                    }
                }
                switch (browser) {
                    case "chrome":
                        WebDriverManager.chromedriver().setup();
                        driver = new ChromeDriver();
                        break;
                    case "firefox":
                        WebDriverManager.firefoxdriver().setup();
                        driver = new FirefoxDriver();
                        break;
                    case "chrome_headless":
                        WebDriverManager.chromedriver().setup();
                        ChromeOptions options = new ChromeOptions();
                        options.addArguments("headless");
                        options.addArguments("window-size=1366x768");
                        driver = new ChromeDriver(options);
                        break;
                    default:
                        WebDriverManager.chromedriver().setup();
                        driver = new ChromeDriver();
                        break;
                }
            } catch (UnreachableBrowserException e) {
                driver = new ChromeDriver();
            } catch (WebDriverException e) {
                driver = new ChromeDriver();
            } finally {
                Runtime.getRuntime().addShutdownHook(new Thread(new BrowserCleanup()));
            }
            driver.get("http://demo.guru99.com/v4/");
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            log.info("----------- START BRWOSER -----------");

        }
        return driver;
    }

    private static class BrowserCleanup implements Runnable {
        public void run() {
            close();
        }

        private static void close() {
            try {
                if (driver != null) {
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
            } catch (UnreachableBrowserException e) {
                log.info("CAN NOT CLOSE BROWSER");
            }

        }
    }

}
