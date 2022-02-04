package tests.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tests.util.DriverFactory;
import tests.util.Helper;
import org.openqa.selenium.support.How;

public class Homepage {
    //PageFactory ile singleton mantığıyla tek bir driverı Objeler arasında kullanabiliyoruz
    //Bunu istersek extends ederek constructor'a ilettikten sonra da kullanabilirdik ancak bu model yapısı daha kullanışlı ve stabil

    public Homepage(){
        PageFactory.initElements(DriverFactory.get(),this);
    }

    public void checkIfExistHomePageTitle(String title) {
        Assert.assertEquals(title, DriverFactory.get().getTitle());
    }

    public void getShops(String mainBox, String dropBox){
        Helper.openDropDownMenu(mainBox);
        Helper.clickText(dropBox);
    }

    @FindBy(how = How.CLASS_NAME, using = "dn-slide-deny-btn")
    public WebElement closeButton;
    public void closeThePopup(){

        Helper.waitFor(5);

        closeButton.click();
    }





}