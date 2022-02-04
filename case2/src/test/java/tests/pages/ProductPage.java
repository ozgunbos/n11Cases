package tests.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import tests.util.DriverFactory;
import tests.util.Helper;

import java.util.List;

public class ProductPage {

    public ProductPage() {
        PageFactory.initElements(DriverFactory.get(), this);
    }

    By listedIphones = By.xpath("//*[@id=\"view\"]/ul/li/div/div/a");


    @FindBy(how = How.CSS, using = ".btn.btnGrey.addBasketUnify")
    public WebElement addToCartButton;
    @FindBy(how = How.CLASS_NAME, using = "myBasket")
    public WebElement cartButton;
    public void goToMyCartPage() {
        cartButton.click();

    }


    public void navigateToProductToAdd() {
        List<WebElement> listOfShops = DriverFactory.get().findElements(listedIphones);
        List<String> urls =  Helper.getUrls(listOfShops);
        Helper.navigateToProductPage(urls, addToCartButton);
    }



}
