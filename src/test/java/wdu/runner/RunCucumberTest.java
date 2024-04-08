package wdu.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features"
        , glue={"wdu.steps"}
        , plugin = { "pretty", "json:target/cucumber-reports/cucumber.json" }
        , monochrome = true
)

public class RunCucumberTest {

}