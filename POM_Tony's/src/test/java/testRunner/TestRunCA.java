package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		
		features=".//Features/CreateAccount.feature",
		glue="stepDefinitions",
		dryRun=false,
	    monochrome = true,
		plugin = {"pretty", "html:target/HtmlReports/report.html"} 
		
		
		
		)

public class TestRunCA {

}
