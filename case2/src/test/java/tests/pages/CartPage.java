package tests.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import tests.util.DriverFactory;
import tests.util.Helper;

import java.util.List;

public class CartPage {

    public CartPage() {
        PageFactory.initElements(DriverFactory.get(), this);
    }

    @FindBy(how = How.XPATH, using = "//*[@id=\"userKvkkModal\"]/div/div[2]/span")
    public WebElement closeButton;
    public void closeInformationalPopUp() {
        closeButton.click();
        Helper.waitFor(5);

    }

    @FindBy(how = How.CSS, using = ".priceArea")
    public List<WebElement> prices;
    public void comparePrices()  {
        String lowestPrice = Helper.comparePrices(prices);
        Helper.increaseQuantity(lowestPrice);

    }


    public void continueShopping() {

        Helper.clickToContinueToPayment();


        Helper.waitFor(5);
    }

    public void makePayment() {

        Helper.paymentMethod();
    }



}
