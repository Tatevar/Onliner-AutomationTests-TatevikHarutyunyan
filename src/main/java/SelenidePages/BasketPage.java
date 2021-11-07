package SelenidePages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class BasketPage {
    @FindBy(css = ".button-style.button-style_auxiliary.button-style_small.cart-form__button.cart-form__button_remove")
    SelenideElement removeBtn;
    @FindBy(css = "cart-message__title cart-message__title_big")
    SelenideElement emptyBasketText;

    SelenideElement closeBtn = $(byText("Закрыть"));

    public BasketPage removeTheItem(){
        removeBtn.click();
        closeBtn.click();
        emptyBasketText.should(Condition.matchText("Ваша корзина пуста"));
        return this;
    }
}
