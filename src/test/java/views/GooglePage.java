package views;

import org.jboss.arquillian.graphene.Graphene;
import org.jboss.arquillian.graphene.findby.FindByJQuery;
import org.jboss.arquillian.graphene.page.Location;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class GooglePage {
	
	@FindBy(name = "q")
	private WebElement searchInput;
	
	@FindBy(name = "btnG")
	private WebElement searchButton;
	
	@FindByJQuery(".rc")
	private List<WebElement> results;
	
	public void searchFor(String query) {
		searchInput.sendKeys(query);
	}
	
	public void clickSearchButton(){
		Graphene.guardAjax(this.searchButton).click();
	}
	
	public void assertOnSearchResults() {
		assertTrue(results.size() > 1 );
	}
}