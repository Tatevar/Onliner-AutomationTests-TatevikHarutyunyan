package PageObject;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class AccountPage extends BasePage {
    private String userDir = System.getProperty("user.dir");
    private By uploadBtn = By.cssSelector(".profile-header__download");
    private By hoverTheImage = By.cssSelector(".profile-header__image.profile-header__image_person.profile-header__image_person_1");
    private By uploadFile = By.cssSelector(".profile-form__control.profile-form__control_condensed-default .button-style.button-style_appendant.button-style_middle.profile-form__button.profile-form__button_narrow.profile-form__button_width_full");

    public AccountPage dragDropUpload(String imgName){
        actions.contextClick(driver.findElement(hoverTheImage)).perform();
        click(uploadBtn);
        click(uploadFile);
        pause(1);
        StringSelection stringSelection = new StringSelection(userDir + "\\files\\" + imgName);
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
        return this;
    }
}
