package tests.util;

import com.opencsv.CSVReader;
import io.cucumber.java.eo.Se;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.Scenario;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Helper {


    public static void openDropDownMenu(String text){
        By clickDropDown = new By.ByXPath((String.format("//span[@title='%s']",text)));

        DriverFactory.get().findElement(clickDropDown).click();
    }

    public static void clickText(String linkText){
        DriverFactory.get().findElement(By.linkText(linkText)).click();
    }

    public static boolean checkIfPageExist(String cell) {
        DriverFactory.get().get("https://n11.com/magaza/"+cell);
        WebElement locators = DriverFactory.get().findElement(By.cssSelector("div[id='error404']"));
        if(locators.isDisplayed()) {
            System.out.println(cell + "adlı site çalışmıyor");
            return true;
        }
        return false;
    }


    public static void getScreenShot(Scenario scenario) {
        final byte[] screenshot = ((TakesScreenshot) DriverFactory.get()).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", "screenshot");
    }
    public static void selectShopFromCSV(String startsWith) {
        try {



            FileReader filereader = new FileReader("Shops.csv");


            CSVReader csvReader = new CSVReader(filereader);
            String[] nextRecord;
            int checkOrder = 0;
            boolean breakLoop = true;
            while ((nextRecord = csvReader.readNext()) != null) {
                        if(breakLoop) {


                            for (String cell : nextRecord) {

                                if(cell.startsWith(startsWith)) {

                                    checkOrder++;
                                    continue;
                                }
                                if(checkOrder == 3 ) {

                                        navigateToSelectedShop(cell);
                                        breakLoop = false;
                                       break;

                                }
                            }

                        }else {
                            break;
                        }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void navigateToSelectedShop(String shopName)
        {

            DriverFactory.get().get("https://www.n11.com/magaza/"+shopName);

            Helper.waitFor(5);

        }

    public static void exportShopsToCSV(List <WebElement> listOfShops, String file_Location, String titleCSV, String xpathForEachElement){
        try {
            By elementXpathForEach = By.xpath(xpathForEachElement);
            FileWriter csvWriter=new FileWriter(file_Location);
            csvWriter.append(titleCSV);
            csvWriter.append("\n");

            for (WebElement element : listOfShops) {
                element.click();
                Helper.waitFor(5);
                List<WebElement> elements= DriverFactory.get().findElements(elementXpathForEach);
                for (int i=0; i < elements.size(); i++) {
                    csvWriter.append(elements.get(i).getText().replace("\"", "-").replace(",", "-").trim());
                    csvWriter.append("\n");
                }
            }
            csvWriter.flush();
            csvWriter.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }


    public static void navigateToProductPage(List<String> urls, WebElement addToCartButton)
    {
        int count = 0;
        for(int i = 0; i < urls.size(); i++) {
            if(count != 3) {
                DriverFactory.get().get(urls.get(i));
                addToCartButton.click();
                Helper.waitFor(3);

                count++;
            }

        }

    }

    public static String comparePrices(List<WebElement> prices) {
        String[] price;

        List<Integer>pricesCompare
                = new ArrayList<Integer>();

        for(int i = 0; i < prices.size(); i++) {

         price =  prices.get(i).getText().split("TL");

            pricesCompare.add(Integer.parseInt(price[0].replace(".","").replace(",","").trim()));

        }


         Collections.sort(pricesCompare);
        int length = (int)(Math.log10(pricesCompare.get(0))+1);

        String lowestPrice;
        if(length == 6) {
             lowestPrice = pricesCompare.get(0).toString().substring(0,1)+"."+pricesCompare.get(0).toString().substring(1,4)+","+pricesCompare.get(0).toString().substring(4);
        }else {
             lowestPrice = pricesCompare.get(0).toString().substring(0,2)+"."+pricesCompare.get(0).toString().substring(2,5)+","+pricesCompare.get(0).toString().substring(5);
        }


        return lowestPrice;
    }


    public static List<String > getUrls (List<WebElement> products){

        List<String>urls
                = new ArrayList<String>();


        for(int i = 0; i < products.size(); i++) {
           String url =  products.get(i).getAttribute("href");
           urls.add(url);


        }
        return urls;


    }

    public static void increaseQuantity (String locator) {

        String path = String.format("//*[@class='prodPrice']//span[contains(.,'%s')]", locator);

        List<WebElement>  tdList = DriverFactory.get().findElements(new By.ByClassName("prodPrice"));

        String path2 = String.format("//*[@class='prodPrice']//span[contains(.,'%s')]", locator);


        String path3 = String.format("//div//span[contains(.,'%s')]/parent::div[@class=\"priceArea\"]/parent::div/parent::td//div/div/span[1]", locator);

        DriverFactory.get().findElement(By.xpath(path3)).click();



    }

    public static void clickToContinueToPayment ()  {


        Helper.waitFor(5);
        WebDriverWait wait = new WebDriverWait(DriverFactory.get(), Duration.ofSeconds(5));

        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"js-buyBtn\"]")));
        element.click();

        WebElement continueShoppingBtn = wait.until(ExpectedConditions.elementToBeClickable(By.className("btn-continue")));
        continueShoppingBtn.click();

        WebElement guestEmail = wait.until(ExpectedConditions.elementToBeClickable(By.id("guestEmail")));
        guestEmail.sendKeys("randomemailaddress@email.com");

        WebElement clickGuestEmail = wait.until(ExpectedConditions.elementToBeClickable(By.id("js-guestEmailCheck")));
        clickGuestEmail.click();
        waitFor(2);
        WebElement firstName = wait.until(ExpectedConditions.elementToBeClickable(By.id("fullName")));
        firstName.sendKeys("random firstname and last");

        Select dropCity = new Select(DriverFactory.get().findElement(By.name("shippingAddress.cityId")));
        dropCity.selectByIndex(7);
        waitFor(2);
        Select district = new Select(DriverFactory.get().findElement(By.name("shippingAddress.districtId")));
        district.selectByIndex(3);
        waitFor(2);

        Select neighbor = new Select(DriverFactory.get().findElement(By.name("shippingAddress.neighborhoodId")));
        neighbor.selectByIndex(4);
        waitFor(2);



        WebElement addressDetail = DriverFactory.get().findElement(By.id("addressDetail"));
        addressDetail.sendKeys("cok keyifli bi adres girmek isterdim ancak test asamasındayım");

        WebElement gsm = DriverFactory.get().findElement(By.name("shippingAddress.gsm"));
        gsm.click();
        waitFor(1);
        gsm.sendKeys("523652365");

        WebElement addressTc = DriverFactory.get().findElement(By.id("shippingAddresstcNO"));
        addressTc.sendKeys("36574636314");

        WebElement nameAddress = DriverFactory.get().findElement(By.name("shippingAddress.title"));
        nameAddress.sendKeys("denemetest");

        WebElement passToPayment = DriverFactory.get().findElement(By.id("js-goToPaymentBtn"));
        passToPayment.click();


    }

    public static void paymentMethod() {
        Helper.waitFor(2);
        List<WebElement> enterCc = DriverFactory.get().findElements(By.cssSelector(".cardNumberInput.-metrika-nokeys.ui-input-numpad"));
        enterCc.get(0).sendKeys("5153");
        enterCc.get(1).sendKeys("4444");
        enterCc.get(2).sendKeys("3333");
        enterCc.get(3).sendKeys("0000");

        WebElement firstAndLastName = DriverFactory.get().findElement(By.id("cardOwnerName"));
        firstAndLastName.sendKeys("deneme test");
        waitFor(2);

        Select month = new Select(DriverFactory.get().findElement(By.name("paymentModel.creditCardModel.expireMonth")));
        month.selectByIndex(4);

        waitFor(2);

        Select year = new Select(DriverFactory.get().findElement(By.name("paymentModel.creditCardModel.expireYear")));
        year.selectByIndex(4);
        waitFor(2);

        WebElement ccv = DriverFactory.get().findElement(By.id("securityCode"));
        ccv.sendKeys("225");
        waitFor(1);
        WebElement acceptAgreement = DriverFactory.get().findElement(By.xpath("//*[@id=\"newCheckout\"]/div/div/div[3]/div/section[1]/div[6]/div/label"));
        acceptAgreement.click();

        waitFor(2);


        WebElement paymentBtn = DriverFactory.get().findElement(By.id("js-paymentBtn"));
        paymentBtn.click();

        Helper.waitFor(5);
    }


    public static void selectSecondItem(WebElement filterItem) {
        isItClickable();
        filterItem.click();

    }

    public static void listByComments() {

        isItClickable();


        Select neighbor = new Select(DriverFactory.get().findElement(By.id("sortingType")));
        neighbor.selectByIndex(4);

    }

    public static void listByFreeShipping() {
        isItClickable();

        WebElement freeShipping = DriverFactory.get().findElement(By.id("freeShippingOption"));
        freeShipping.click();

        isItClickable();
    }

    public static void isItClickable(){
        WebDriverWait wait = new WebDriverWait(DriverFactory.get(), Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a//h3[@class='productName']")));
    }

    public static void waitFor(int seconds){
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
