package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.page.Page;
import org.openqa.selenium.WebDriver;
import views.GooglePage;

public class GoogleSearchSteps {
	
	@Drone
	WebDriver driver;
	
	@Page
	private GooglePage googlePage;
	
	@Given("^the user on google page$")
	public void the_user_on_google_page() throws Throwable {
		driver.get("http://www.google.com");
	}
	
	@When("^the user inputs \"([^\"]*)\" int the search box$")
	public void the_user_inputs_int_the_search_box(String query) throws Throwable {
		googlePage.searchFor(query);
	}
	
	@When("^the user clicks on search button$")
	public void the_user_clicks_on_search_button() throws Throwable {
		googlePage.clickSearchButton();
	}
	
	@Then("^the results page should be displayed$")
	public void the_results_page_should_be_displayed() throws Throwable {
		googlePage.assertOnSearchResults();
	}
	
}
