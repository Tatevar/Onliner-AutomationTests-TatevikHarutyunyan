package SelenidePages;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class BasePageSelenide {
    private WebDriver driver;

    public void pause(Integer seconds) {
        try {
            long time = seconds * 1000;
            log.info("Sleep ::" + time);
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    protected String getElementText(By element) {
        log.info("Get Element Text ::" + element);
        return driver.findElement(element).getText();
    }
}
