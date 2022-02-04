package tests.stepdefinitions;

import io.cucumber.java.en.And;
import org.openqa.selenium.support.PageFactory;

import tests.pages.SearchPage;
import tests.util.DriverFactory;

public class SearchSteps {
    SearchPage searchPage = new SearchPage();


    @And( "Wrong word is written as {string}" )
    public void wrongWordIsWritten(String wrongSearch) {
        searchPage.searchFor(wrongSearch);
    }




}
