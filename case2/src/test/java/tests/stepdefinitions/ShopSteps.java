package tests.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tests.pages.FetchingShopsPage;
import tests.pages.GetShopFromCsvPage;
import tests.pages.ShopsPage;

import java.net.MalformedURLException;

public class ShopSteps {
    FetchingShopsPage fetchingShopsPage = new FetchingShopsPage();
    GetShopFromCsvPage getShopFromCSV = new GetShopFromCsvPage();
    ShopsPage shopsPage = new ShopsPage();

    public ShopSteps() throws MalformedURLException {
    }

    @And( "Write all shops to csv" )
    public void exportAllStoreNameToCsvFile() {
        fetchingShopsPage.exportCSV();
    }

    @When( "Go to the second shop that starts with the letter {string}" )
    public void selectShopFromCSV(String startsWith) {
        getShopFromCSV.selectShopStartsWith(startsWith);
    }

    @Then("Total Reviews checked")
    public void totalReviewsChecked() {
        shopsPage.changeToCommentPage();
        shopsPage.checkShopComments();
    }

}
