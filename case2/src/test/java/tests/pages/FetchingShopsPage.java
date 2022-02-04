package tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import tests.util.DriverFactory;
import tests.util.Helper;

import java.util.List;

public class FetchingShopsPage {

    public FetchingShopsPage(){
        PageFactory.initElements(DriverFactory.get(),this);
    }

    By locatedShops = By.xpath("//*[@class=\"letters\"]/span");
    String xpathForEachElement = "//*[@class=\"tabPanel allSellers\"]//ul/li/a";


    public void exportCSV() {
        List<WebElement> listOfShops = DriverFactory.get().findElements(locatedShops);
        Helper.exportShopsToCSV(listOfShops, "Shops.csv", "Shops", xpathForEachElement);
    }


}
