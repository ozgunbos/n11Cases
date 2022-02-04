package tests;

import log.CaseLog;
import org.junit.jupiter.api.Order;
//import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.testng.Assert;
import pages.CampaignMainPage;
import org.testng.annotations.Test;
import pages.Campaigns;


public class CoreTest extends BaseTest {
    CampaignMainPage campaignMainPage;
    Campaigns campaigns;



    @Test(priority = 1)
    public void openCampaignMainPage() throws InterruptedException {

        campaignMainPage = new CampaignMainPage(driver);


        campaignMainPage
               .controlMainPage();
        campaignMainPage
                .isCampaignPage();


        System.out.println("Kampanya test sayfası başarılı şekilde çalıştı ve kampanyalar listelendi");



    }

    @Test(priority = 2)
    public void getCampaignsAndWriteToCsv() throws InterruptedException {
        //Hata durumunda screenshot alınması için assert.fail() denendi ve sonuç alındı
        //Assert.fail();
        campaigns = new Campaigns(driver);

        campaigns.getAllCampaigns();

        System.out.println("Kampanyalar başarılı bir şekilde konsola ve csv dosyasına yazdırıldı");

    }

}