package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {"src/test/resources/features"},
		glue= {"stepdef"},
		plugin = {
		        "pretty",
		        "html:target/htmlreports/report.html",
		        "json:target/jsonReports/report.json",
		        "rerun:target/failed_scenarios1.txt"
		    },
		monochrome = false,
		dryRun = false,
		tags= "@A or @B"
		)
public class TestRunner extends AbstractTestNGCucumberTests{

}