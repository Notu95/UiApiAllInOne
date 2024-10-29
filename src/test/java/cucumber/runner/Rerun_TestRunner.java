package cucumber.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "@target\\rerun.txt",                   // Path to rerun.txt for failed tests
        glue = "cucumber.stepDef",
        monochrome = true,
        plugin = {
                "pretty",
                "html:target/htmlReports/rerun_report.html",   // Reports for rerun execution
                "json:target/jsonReports/rerun_report.json",
                "junit:target/xmlReports/rerun_report.xml"
        }
)



public class Rerun_TestRunner {

}
