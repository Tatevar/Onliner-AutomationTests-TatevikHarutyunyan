package Driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import properties.PropertyReader;
/*
    Patten Singleton
 */

public class DriverCreation {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void setDriver(String browserType) {
        if (driver.get() == null) {
            createDriver(browserType);
        }
    }

    private static void createDriver(String browserType) {
        switch (browserType) {
            case "Chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments(PropertyReader.getProperties().getProperty("chrome.driver.options").split(";"));
                driver.set(new ChromeDriver(chromeOptions));
                break;
            case "Mozilla":
                WebDriverManager.firefoxdriver().setup();
                driver.set(new FirefoxDriver());
                break;
            case "IE":
                WebDriverManager.iedriver().setup();
                driver.set(new InternetExplorerDriver());
                break;
        }
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().close();
            driver.get().quit();
            driver.remove();
        }
    }
}
