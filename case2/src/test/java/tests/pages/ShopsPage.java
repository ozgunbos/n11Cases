package tests.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.junit.Assert;
import tests.util.DriverFactory;

public class ShopsPage {

    public ShopsPage() {
        PageFactory.initElements(DriverFactory.get(), this);

    }

    @FindBy(how = How.LINK_TEXT, using = "Mağaza Yorumları")
    public WebElement changeToComment;
    public void changeToCommentPage(){
        changeToComment.click();
    }

    @FindBy(how = How.CLASS_NAME, using = "selectedReview")
    public WebElement reviewCounts;
    public void checkShopComments(){
        Assert.assertTrue(reviewCounts.isDisplayed());
        String[] splitSentence = reviewCounts.getText().split(" ");
        System.out.println("Toplam yorum sayısı: "+ splitSentence[2]);

    }

}
