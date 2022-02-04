package tests.stepdefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import tests.pages.*;
import tests.util.ConfigFile;

import java.net.MalformedURLException;


public class HomePageSteps {

    GetShopFromCsvPage getShopFromCSV = new GetShopFromCsvPage();
    Homepage homepage = new Homepage();

    public HomePageSteps()  {
    }

    @Given( "User goes to Home Page" )
    public void userGoesToHomePage()  {
        homepage.checkIfExistHomePageTitle(ConfigFile.get("websiteTitle"));
    }

    @And( "Wait for pop up" )
    public void closeThePopUp() {
        homepage.closeThePopup();
    }

    @And( "User Hover over {string} and Select {string}" )
    public void navigateToUnder(String mainBox, String dropBox) {
        homepage.getShops(mainBox, dropBox);
    }



}
