package cucumber.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src\\test\\resources\\featureFiles\\googleSearch1.feature",
		glue="cucumber.stepDef",
		monochrome=true,
		tags="@NoParallelRun",
		plugin= {
				"pretty",
				"html:target/htmlReports/report.html",
				"json:target/jsonReports/report.json",
				"junit:target/xmlReports/report.xml",
				"rerun:target/rerun.txt"
				
		}
		)

public class TestRunner {

}
