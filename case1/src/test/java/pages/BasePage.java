package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



import java.time.Duration;
import java.util.List;


public class BasePage  {

    public WebDriver driver;
    public WebDriverWait wait;
    By campaignPath = new By.ByCssSelector("div.panelContent div.categoryMenuTab:nth-child(1) ul.campPromTab li:not(.disabled) .title");
    By promotionPath = new By.ByXPath("//*[@id=\"contentCampaignPromotion\"]/div/div[2]/div/div[2]/div/section");

    public BasePage(WebDriver driver) {

        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void waitVisibility(By elementBy) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
    }

    public void click(By elementBy) {
        waitVisibility(elementBy);
        driver.findElement(elementBy).click();
    }



    private WebElement getElementBy(By by) {
        return waitForElement(driver,30,by);
    }


    public WebElement waitForElement(WebDriver driver, int seconds, By elementBy) {
        return (new WebDriverWait(driver, Duration.ofSeconds(seconds)))
                .until(ExpectedConditions.presenceOfElementLocated(elementBy));
    }

    public String readText(By elementBy) {
        waitVisibility(elementBy);
        return driver.findElement(elementBy).getText();
    }
    public WebElement find(By locator){
        return driver.findElement(locator);
    }

    public List<WebElement> findAll(By locator){
        return driver.findElements(locator);
    }



    public void type(By locator , String text){
        find(locator).sendKeys(text);
    }

    public Boolean isDisplayed(By locator){
        return find(locator).isDisplayed();
    }



    public String getTextBy(By by){
        return getElementBy(by).getText();
    }

    public List<WebElement> getProducts(By campaignNameLocator){
        return findAll(campaignNameLocator);
    }
    public List<WebElement> getPromotions(By promotionLocator){
        return findAll(promotionLocator);
    }

    public WebElement getBigCampaign(int promotion) {
        By bigCampaign = new By.ByXPath(String.format("//*[@id=\"contentCampaignPromotion\"]/div/div[2]/div/div[2]/div/section[%1$s]/a", promotion));

        return find(bigCampaign);
    }
    public  List<WebElement> getRelatedCampaings(int campaign){
        By minorCampaignLinks = new By.ByXPath((String.format("//*[@id=\"contentCampaignPromotion\"]/div/div[2]/div/div[2]/div/section[%s]/ul/li/a",campaign)));
        return findAll(minorCampaignLinks);
    }
}
