package www1alv.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"},
        features={"src/test/resources/features"},
        glue = {"www1alv/steps"},
        tags = {"@product_buy_test"}
)

public class Runner {}
