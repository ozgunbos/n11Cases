package tests.util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nullable;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Objects;



public class DriverFactory {

    private DriverFactory() {

    }

    private static WebDriver driver;
    public static WebDriver get() {
        return get("");

    }
    public static WebDriver get(String docker)  {

        if (driver == null) {
            String browser=ConfigFile.get("browserName");


            if(browser.equalsIgnoreCase("chrome") & ConfigFile.get("runDocker").equalsIgnoreCase("docker") & docker != "") {
                WebDriverManager.chromedriver().setup();
                driver= WebDriverManager.chromedriver().remoteAddress("http://localhost:4444/wd/hub").create();

                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
                driver.manage().window().maximize();
            }
            else if(browser.equalsIgnoreCase("firefox")) {

                if(!Objects.equals(docker, "")) {
                    driver= WebDriverManager.firefoxdriver().remoteAddress("http://localhost:4444/wd/hub").create();

                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
                    driver.manage().window().maximize();
                }else {
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                }


            }
            else {
                WebDriverManager.chromedriver().setup();

                driver = new ChromeDriver();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
                driver.manage().window().maximize();
            }
        }
        return driver;
    }



    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}
