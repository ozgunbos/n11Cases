package tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import tests.util.DriverFactory;


public class SearchPage {

    public SearchPage(){
        PageFactory.initElements(DriverFactory.get(),this);
    }



    @FindBy(how = How.ID, using  = "searchData")
    public WebElement searchBox;
    @FindBy(how = How.CLASS_NAME, using = "searchBtn")
    public WebElement searchButton;
    public void searchFor(String wrongSearch) {
        searchBox.click();
        searchBox.sendKeys(wrongSearch);
        searchButton.click();
    }




}
