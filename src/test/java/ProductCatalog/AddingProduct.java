package ProductCatalog;

import Driver.BaseTestSelenide;
import SelenidePages.Basket;
import SelenidePages.Catalog;
import SelenidePages.Home;
import org.testng.annotations.Test;


public class AddingProduct extends BaseTestSelenide {

    @Test( priority = 3)
    public void addAProductAndDelete_test(){
        get(Home.class)

                .openBeautyAndSportProduct();
        get(Catalog.class)
                .clickItem()
                .addItemToBasket();
        get(Basket.class)
                .removeTheItem();
    }
    @Test(priority = 2)
    public void compareProducts_test() {
        get(Home.class)
                .openBeautyAndSportProduct();
        get(Catalog.class)
                .tickCheckbox();
    }
    @Test(priority = 5)
    public void emptyTheComparedList_test() {
        get(Home.class)
                .openBeautyAndSportProduct();
        get(Catalog.class)
                .tickCheckbox()
                .EmptyComparedList();
    }
}