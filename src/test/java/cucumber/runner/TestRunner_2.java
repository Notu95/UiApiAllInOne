package cucumber.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources", // Corrected feature file path
    glue = "src/test/java/cucumber.stepDef", // Corrected step definitions path
    monochrome = true,
    tags = "@NoParallelRun", // Removed extra comment
    plugin = {
        "pretty",
        "html:target/htmlReports/report.html"
    }
)
public class TestRunner_2 {
}
