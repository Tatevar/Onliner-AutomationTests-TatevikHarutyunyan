package ProductCatalog;

import Driver.BaseTestSelenide;
import SelenidePages.CatalogPage;
import SelenidePages.HomePageSelenide;
import org.testng.annotations.Test;
public class AddingProduct extends BaseTestSelenide {
    @Test
    public void addAProduct(){
        get(HomePageSelenide.class)
                .openProduct();

        get(CatalogPage.class)
                .clickItem()
                .addItemToBasket();
    }
}