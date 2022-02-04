package tests;


import log.CaseLog;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
//import org.testng.annotations.AfterClass;
import org.testng.annotations.*;
//import org.testng.annotations.BeforeClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import util.Screenshot;


//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//@ExtendWith(CaseLog.class)
public class BaseTest {
     WebDriver driver;


    @BeforeClass
    public void setup () throws InterruptedException {

        Thread.sleep(2000);
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.n11.com/kampanyalar");
        driver.manage().window().maximize();
    }


    @AfterMethod
    public void tearDown(ITestResult result) {
        if (!result.isSuccess()) {
            Screenshot.capture(driver, "src/", result.getName());
            driver.quit();
        }
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }



}