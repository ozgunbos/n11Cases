package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CampaignMainPage extends BasePage {
    public CampaignMainPage(WebDriver driver) {
        super(driver);
    }
    By CookiePolicy = By.id("cookieUsagePopIn");
    By campaignPath = By.xpath("//*[@id=\"contentCampaignPromotion\"]/div/div[2]/div/div[2]/div");




    public void controlMainPage() {
        Assert.assertTrue(isDisplayed(CookiePolicy));
    }

    public void isCampaignPage() { Assert.assertTrue(isDisplayed(campaignPath)); }

}
