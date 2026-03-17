package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "./src/test/java/features/Salesforce.feature",
    glue = "stepDef",
    monochrome = true,
    publish = true
)
public class RunnerSales extends AbstractTestNGCucumberTests {
}







