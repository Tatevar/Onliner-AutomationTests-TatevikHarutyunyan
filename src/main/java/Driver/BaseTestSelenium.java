package Driver;
import TestNg.ListenerSelenium;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import static Driver.DriverCreation.getDriver;
import static Driver.DriverCreation.quitDriver;

@Listeners({ListenerSelenium.class})
public class BaseTestSelenium {
    public static WebDriver driver;
    public static WebDriver browser;

    @BeforeTest
    public void setupDriver(ITestContext context) {
        driver = getDriver();
    }
}
