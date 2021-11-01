package Driver;

import TestNg.Listener;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Listeners;
import properties.PropertyReader;

import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.driver;

@Log4j2
@Listeners(Listener.class)
public class BaseTestSelenide {

    public <PageObjectClass> PageObjectClass get(Class<PageObjectClass> pageObjectClassClass) {
        return driver().hasWebDriverStarted() ? page(pageObjectClassClass) : open(PropertyReader.getProperties().getProperty("url"), pageObjectClassClass);
    }
}
