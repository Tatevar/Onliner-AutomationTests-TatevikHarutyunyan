package Bdd_tests.steps;

import Driver.BaseTestSelenide;
import Patterns.UserBuilder;
import SelenidePages.CatalogPage;
import SelenidePages.ElectronicFilter;
import SelenidePages.LoginPageSelenide;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductPage_steps extends BaseTestSelenide {

    @Given("Product page is opened and details are displayed")
    public void openProductPage_step(){
        get(ElectronicFilter.class)
                .chooseProduct();

    }
    @When("User ticking checkboxes")
    public void addProductToFavAndCompare_step() {
        get(CatalogPage.class)
                .tickCheckboxes();

    }
    @Then("The chosen values are displayed on the page")
    public void checkValues_step() {
        UserBuilder user = UserBuilder
                .builder()
                .email("tatevar93@gmail.com")
                .password("onlinertest")
                .build();
        get(LoginPageSelenide.class)
                .loginWithUserData(user);
        get(CatalogPage.class)
                .checkTheValues();
    }
}
