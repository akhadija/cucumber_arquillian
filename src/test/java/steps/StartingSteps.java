package steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.commons.io.FileUtils;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.page.Page;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class StartingSteps{
	
	@Drone
	private WebDriver driver;
	
	public StartingSteps() throws Exception {
		super();
	}

	@Before
	public void beforeScenario() throws Exception{
	
	}
	
	@After
	public void afterScenario(Scenario scenario) throws Exception{
		
		if (scenario.isFailed()) {
		      final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		      scenario.embed(screenshot, "image/png");
		}
		
		
	}
	
}
