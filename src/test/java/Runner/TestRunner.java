package Runner;

	import net.serenitybdd.cucumber.CucumberWithSerenity;
	import org.junit.runner.RunWith;

	import cucumber.api.CucumberOptions;
	import cucumber.api.junit.Cucumber;


	//@RunWith(Cucumber.class)
	@RunWith(CucumberWithSerenity.class)
	@CucumberOptions(
			features = {"src/test/resources/featurefiles/"},
			glue = {"StepDefinitions"},
			//		glue = {"com.test.java.StepDefinitions"},
			//format = {"html:target/site/cucumber-pretty"},
	       // tags = {"@SmokeTests"},
	        monochrome = true,
	        dryRun = false
			)
	
	public class TestRunner {


}
