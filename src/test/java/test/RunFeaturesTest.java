package test;

import cucumber.api.CucumberOptions;
import cucumber.runtime.arquillian.CukeSpace;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunAsClient
@RunWith(CukeSpace.class)
@CucumberOptions (features = "src/test/java/features/", glue = { "steps" }, plugin  = { "pretty", "html:target/cucumber", "json:target/cucumber.json"})
public class RunFeaturesTest {
	
	@Drone
	WebDriver driver;
}



