package tests.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import tests.util.DriverFactory;
import tests.util.Helper;

import java.util.List;

public class FilterPage {



    public FilterPage(){
        PageFactory.initElements(DriverFactory.get(),this);
    }


    @FindBy(how = How.XPATH, using = "//*[@id=\"contentListing\"]/div/div/div[1]/section[5]/div[2]/div[2]//input")
    public WebElement filterItem;
    public void listByBrand(){
        Helper.selectSecondItem(filterItem);

    }

    public void listByComments () {
        Helper.listByComments();
    }

    public void listByFreeShipping() {
        Helper.listByFreeShipping();
    }



}
