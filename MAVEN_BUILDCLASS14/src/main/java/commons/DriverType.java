package commons;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverType {
    private static String osName = System.getProperty("os.name").toLowerCase();
    private static String cmd = "";
    private final String workingDir = System.getProperty("user.dir");

    public WebDriver chromeDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("-incognito");
        options.addArguments("--disable-extensions");
        options.addArguments("disable-inforbars");
        options.addArguments("--disable-notifications");
        return new ChromeDriver(options);
    }

    public WebDriver firefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--disable-notifications");
        return new FirefoxDriver(options);
    }

    public WebDriver chromeHeadless() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        options.addArguments("window-size=1366x768");
        return new ChromeDriver(options);
    }

    public void closeChromeDriver() {
        try {
            // Kill process
            if (osName.toLowerCase().contains("mac")) {
                cmd = "pkill chromedriver";
            } else {
                cmd = "taskkill /F /FI \"IMAGENAME eq chromedriver*\"";
            }
            Process process = Runtime.getRuntime().exec(cmd);
            process.waitFor();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void closeFirefoxDriver() {
        try {
            if (osName.toLowerCase().contains("mac")) {
                cmd = "pkill firefoxdriver";
            } else {
                cmd = "taskkill /F /FI \"IMAGENAME eq firefoxdriver*\"";
            }
            Process process = Runtime.getRuntime().exec(cmd);
            process.waitFor();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void closeIEDriver() {
        try {
            cmd = "taskkill /F /FI \"IMAGENAME eq IEDriverServer*\"";
            Process process = Runtime.getRuntime().exec(cmd);
            process.waitFor();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
