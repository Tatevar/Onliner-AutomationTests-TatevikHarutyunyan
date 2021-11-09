package PageObject;

import io.cucumber.java.bs.A;
import org.openqa.selenium.By;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class AccountPage extends BasePage {
    private String userDir = System.getProperty("user.dir");
    private By uploadBtn = By.cssSelector(".profile-header__download");
    private By hoverTheImage = By.cssSelector(".profile-header__image.profile-header__image_person.profile-header__image_person_1");
    private By uploadFile = By.cssSelector(".profile-form__control.profile-form__control_condensed-default .button-style.button-style_appendant.button-style_middle.profile-form__button.profile-form__button_narrow.profile-form__button_width_full");
    private By saveBtn = By.xpath("//a[contains(@class,'button-style button-style_primary button-style_middle')]");
    private By deleteBtn = By.xpath("//button[contains(@class,'button-style button-style_auxiliary button-style')]");
    private By accountHeader = By.cssSelector(".profile-header__details-item");


    public AccountPage dragDropUpload(String imgName){
        actions.contextClick(driver.findElement(hoverTheImage)).perform();
        click(uploadBtn);
        click(uploadFile);
        pause(5);
        StringSelection stringSelection = new StringSelection("C:\\Users\\Tata\\Documents\\AutomationDiploma\\Onliner-AutomationTests-TatevikHarutyunyan\\src\\main\\java\\files\\" + imgName);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        } catch (Exception e) {
            e.printStackTrace();
        }
        pause(3);
        click(saveBtn);
        return this;
    }
    public AccountPage deletePhoto(){
        actions.contextClick(driver.findElement(hoverTheImage)).perform();
        click(uploadBtn);
        click(deleteBtn);
        return this;
    }

}
