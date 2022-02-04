package tests.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import tests.pages.FilterPage;
import tests.pages.SearchPage;

public class FilterSteps {

    SearchPage searchPage = new SearchPage();
    FilterPage filterPage = new FilterPage();

    @And("{string} is searched")
    public void is_searched(String search) {
        searchPage.searchFor(search);


    }


    @And("On the product listing screen the second brand is selected from the filters")
    public void on_the_product_listing_screen_the_second_brand_is_selected_from_the_filters() {
            filterPage.listByBrand();
    }


    @And("Select List by comments from filters")
    public void select_List_by_comments_from_filters() {
        filterPage.listByComments();

    }

    @Then("List all products by free shipping")
    public void list_all_products_by_free_shipping() {
        filterPage.listByFreeShipping();



    }

}
