package SelenidePages;

import PageObject.BasePage;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.matchText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class Catalog extends BasePage {
    SelenideElement email = $(byXpath("//*[@name='ctl00$ContentPlaceHolderContent$TextBoxEmail']"));
    SelenideElement password = $(byXpath("//*[@name='ctl00$ContentPlaceHolderContent$TextBoxPassword']"));
    SelenideElement loginForm = $(byXpath("//*[@id='UpdateMoodWelcome']/div"));

    @FindBy(css = ".scroll-down > a")
    SelenideElement scrollDownBtn;

    public Catalog EnterUserData() {
        loginForm.should(matchText("Красота"));
        email.setValue("tatevar93@gmail.com");
        password.setValue("tatevar55").pressEnter();
        return this;
    }
}
