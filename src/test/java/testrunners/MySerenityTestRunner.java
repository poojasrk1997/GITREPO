package testrunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions
(
	features = {"src/test/resources/features"},
	glue = {"stepdefinations", "applicationhooks"},
	monochrome = true,
	plugin = {"pretty"}
	
		
)

public class MySerenityTestRunner {

}
