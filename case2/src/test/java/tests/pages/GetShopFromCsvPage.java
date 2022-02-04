package tests.pages;

import org.openqa.selenium.support.PageFactory;
import tests.util.DriverFactory;
import tests.util.Helper;

public class GetShopFromCsvPage {

    public GetShopFromCsvPage(){
        PageFactory.initElements(DriverFactory.get(),this);
    }


    public void selectShopStartsWith(String startsWith){

        Helper.selectShopFromCSV(startsWith);
    }
}
