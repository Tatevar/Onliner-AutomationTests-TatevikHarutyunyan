package Driver;

import TestNg.ListenerSelenide;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Listeners;
import properties.PropertyReader;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.driver;

@Log4j2
@Listeners(ListenerSelenide.class)
public class BaseTestSelenide {

    public <Type> Type get(Class<Type> pageObjectClassClass) {
        return driver().hasWebDriverStarted() ? page(pageObjectClassClass) : open(PropertyReader.getProperties().getProperty("url"), pageObjectClassClass);
    }

    public <PageObjectClass> PageObjectClass get(Class<PageObjectClass> pageObjectClassClass, String env) {
        PropertyReader propertyReader = new PropertyReader();
        propertyReader.setProperties(env);
        return get(pageObjectClassClass);
    }
}
