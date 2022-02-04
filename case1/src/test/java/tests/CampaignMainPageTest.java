package tests;


import org.testng.annotations.Test;

import pages.CampaignMainPage;

public class CampaignMainPageTest extends BaseTest {
    @Test
    public void controlMainPage() throws InterruptedException {
        CampaignMainPage homePage = new CampaignMainPage(driver);


        homePage
                .controlMainPage();


        System.out.println("Kampanya test sayfası başarılı şekilde çalıştı");


    }
}
