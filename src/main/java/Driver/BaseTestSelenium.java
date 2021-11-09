package Driver;
import TestNg.ListenerSelenium;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import static Driver.DriverCreation.getDriver;

@Listeners({ListenerSelenium.class})
public class BaseTestSelenium {
    public static WebDriver driver;

    @BeforeTest
    public void setupDriver(ITestContext context) {
        driver = getDriver();
    }
}
