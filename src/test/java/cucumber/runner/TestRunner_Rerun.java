package cucumber.runner;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="file:src/test/resources/featureFiles/googleSearch1.feature:33",
		glue="cucumber.stepDef",
		monochrome=true,
		dryRun = true,
//		tags="@NoParallelRun",
		plugin= {
				"pretty",
				"html:target/htmlReports/rerun_report.html"
//				,"json:target/jsonReports/rerun_report.json",
//				"junit:target/xmlReports/rerun_report.xml"
//				,"rerun:target/rerun.txt"
				
		}
		)

public class TestRunner_Rerun {
	static {
        try {
            System.out.println("Contents of rerun.txt:");
            Files.lines(Paths.get("target/rerun.txt")).forEach(System.out::println);
        } catch (IOException e) {
            System.err.println("Could not read rerun.txt: " + e.getMessage());
        }

}}
