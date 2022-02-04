package pages;

import com.opencsv.CSVWriter;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Campaigns extends BasePage {

    public Campaigns(WebDriver driver) {
        super(driver);
    }
    List<String[]> AddToList = new ArrayList<>();;

    public void getAllCampaigns() {
        List<WebElement> Products = getProducts(campaignPath);
        List<WebElement> Promotions = getPromotions(promotionPath);

        for (int x = 1; x < Promotions.size(); x++) {

            Products.get(x).click();

            System.out.println(Products.get(x).getText() + " - " + getBigCampaign(x+1).getAttribute("href"));
            AddToList.add(new String[] {Products.get(x).getText() + " - " + getBigCampaign(x+1).getAttribute("href")});
            for(int y = 0; y < getRelatedCampaings(x+1).size(); y++) {

                System.out.println(Products.get(x).getText() + " - " + getRelatedCampaings(x+1).get(y).getAttribute("href"));
                AddToList.add(new String[] { Products.get(x).getText() + " - " + getRelatedCampaings(x+1).get(y).getAttribute("href")});



            }

        }
        try {
            writeToCsv(AddToList);
        }
        catch(Exception e) {
            System.out.println("CSV dosyası oluşturulurken hata oluştu " + e);
        }


    }

    public void writeToCsv(List<String[]> file) throws IOException {

        CSVWriter writer = new CSVWriter(new FileWriter("src/output.csv"));
        writer.writeAll(file);
        writer.close();
    }




}
