package Dataprovider;

import Driver.BaseTestSelenide;
import SelenidePages.ElectronicFilter;
import SelenidePages.Home;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Boundary_tests extends BaseTestSelenide {
    String emptyField = "0";
    String validData = "100";
    String validData2 = "200";
    String notAcceptable = "5555555556";
    String acceptAble = "555555555";
    String notProductText = "Упс! У нас нет таких товаров, попробуйте изменить условия поиска.";

    @DataProvider(name = "User tries to add valid and invalid data to the field", parallel = true)
    public Object[][] data() {
        return new Object[][]{
                {emptyField, emptyField,notProductText },
                {validData, validData2, ""},
                {notAcceptable, notAcceptable, notProductText},
                {acceptAble, acceptAble, notProductText}
        };
    }

    @Test(dataProvider = "User tries to add valid and invalid data to the field")
    public void SignIn_Tests(String priceFrom, String priceTo,String errorText) {
        get(Home.class)
                .addElectronicsProduct();
        get(ElectronicFilter.class)
                .addDataToPriceFiled(priceFrom,priceTo);
        if (errorText.isEmpty()) {
            get(ElectronicFilter.class).checkPriceFilterIsDisplayed();
        } else {
            get(ElectronicFilter.class).checkErrorText(errorText);
        }
    }
    }
