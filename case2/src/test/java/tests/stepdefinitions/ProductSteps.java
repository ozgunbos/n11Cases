package tests.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;
import tests.pages.ProductPage;
import tests.util.DriverFactory;

public class ProductSteps {

    ProductPage productPage = new ProductPage();



    @And("3 Iphone products are added to the basket")
    public void iphone_products_are_added_to_the_basket() {
        productPage.navigateToProductToAdd();
    }
    @When("Navigate to the cart and increase the quantity of the cheaper item by {int}")
    public void navigate_to_the_cart_and_increase_the_quantity_of_the_cheaper_item_by(Integer int1) {
        productPage.goToMyCartPage();
    }


}
