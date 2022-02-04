package tests.stepdefinitions;

import io.cucumber.java.en.Then;
import tests.pages.CartPage;

import java.text.ParseException;

public class CartSteps {

  CartPage cartPage = new CartPage();


    @Then("Try to buy products entering wrong credit card credentials")
    public void try_to_buy_products_entering_wrong_credit_card_credentials() {

        cartPage.closeInformationalPopUp();
        cartPage.comparePrices();
        cartPage.continueShopping();
        cartPage.makePayment();
    }
}
