package SelenidePages;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class BasePageSelenide {
    public void pause(Integer seconds) {
        try {
            long time = seconds * 1000;
            log.info("Sleep ::" + time);
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
