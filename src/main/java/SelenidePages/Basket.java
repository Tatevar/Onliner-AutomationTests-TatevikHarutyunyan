package SelenidePages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;

public class Basket extends BasePageSelenide {

    @FindBy(css = ".button-style.button-style_auxiliary.button-style_small.cart-form__button.cart-form__button_remove")
    SelenideElement removeBtn;

    @FindBy(css = ".cart-message__title.cart-message__title_big")
    SelenideElement emptyBasketText;

    SelenideElement fullBasket = $(By.cssSelector(".cart-form__offers-part.cart-form__offers-part_data"));

    SelenideElement closeBtn = $(byText("Закрыть"));


    public Basket removeTheItem() {
        actions().moveToElement(removeBtn).perform();
        pause(2);
        $(".cart-form__offers-part.cart-form__offers-part_action").hover();
        removeBtn.click();
        closeBtn.click();
        emptyBasketText.should(Condition.matchText("Ваша корзина пуста"));
        return this;
    }

    public Basket checkProductsAreNotDisplayed() {
        emptyBasketText.should(Condition.matchText("Ваша корзина пуста"));
        return this;
    }
    public Basket checkProductsDisplayed() {
        pause(3);
        fullBasket.isDisplayed();
        return this;
    }
}
