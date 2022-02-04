package tests.stepdefinitions;


import tests.util.ConfigFile;
import tests.util.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import tests.util.Helper;


public class BaseSteps {

    @Before
    public void setup(){
        String docker = ConfigFile.get("runDocker");

        DriverFactory.get(docker).get(ConfigFile.get("baseURI"));

    }


    @After
    public void teardown(Scenario scenario){
        if(scenario.isFailed()){
            Helper.getScreenShot(scenario);
        }
        DriverFactory.closeDriver();
    }
}
