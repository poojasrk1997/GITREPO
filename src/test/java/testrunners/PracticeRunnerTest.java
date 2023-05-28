package testrunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
(
	features = {"src/test/resources/features"},
	glue = {"stepdefinations", "applicationhooks"},
	monochrome = true,
	plugin = {"pretty",
			"timeline:test-output-thread/",
			"rerun:target/failed run.txt"}
	
		
)

public class PracticeRunnerTest {

}
