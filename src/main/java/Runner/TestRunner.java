package Runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "Features",
		glue = { "StepDefinition" },
		stepNotifications = true,
		dryRun = false,
		monochrome = false,
		plugin = {"pretty", "html:target/cucumber.html"},
		tags = "@smoke")
public class TestRunner {

}
