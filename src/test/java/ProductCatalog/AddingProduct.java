package ProductCatalog;

import Driver.BaseTestSelenide;
import SelenidePages.Basket;
import SelenidePages.Catalog;
import SelenidePages.Home;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class AddingProduct extends BaseTestSelenide {

    @Test(groups = {"smokeTest"},priority = 1)
    public void addAProductAndDelete_test(){
        get(Home.class)
                .addBeautyAndSportProduct();
        get(Catalog.class)
                .clickItem()
                .addItemToBasket();
        get(Basket.class)
                .removeTheItem();
    }

    @Test(groups = {"regressionTest"},priority = 1)
    public void compareProducts_test() {
        get(Home.class)
                .addBeautyAndSportProduct();
        get(Catalog.class)
                .tickCheckbox();
    }
    @Test(groups = {"regressionTest"},priority = 2)
    public void emptyTheComparedList_test() {
        get(Home.class)
                .addBeautyAndSportProduct();
        get(Catalog.class)
                .tickCheckbox()
                .EmptyComparedList();
    }

    @AfterMethod(alwaysRun = true)
    public void post() {
        closeWebDriver();
    }
}