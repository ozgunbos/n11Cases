package tests.runner;



import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "html:target/html-reports",
                "json:target/html-reports/json-report.json"
        },
        glue ="tests/stepdefinitions",
        features = "src/test/resources/features",
        tags = "@homework",
        dryRun = false
)
public class CucumberRunner {
}
