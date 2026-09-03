package CucumberTopuop;

import java.io.IOException;

import org.testng.Assert;

import Flipcart.Flipcart_Automation.ProductSearch;
import Flipcart.Flipcart_Automation.SearchResultPage;
import Flipcart.Flipcart_Automation.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CucumberStepDefinition extends TestBase {
	ProductSearch prodsearch;
	SearchResultPage resultpage;
	
	@Given("User Should landed on FlipCart Website")
	
	public void user_landed_on_flipcart_website() throws IOException {
		
		prodsearch = landingPage();
		
		}
	@Given("User is on Search Page")
	public void user_is_on_search_page() {
		
	}
	
	
	@When("^User Type any (.+) in search box and select (.+) from search list$")
	
	public void user_type_product_in_search_box_and_select_item(String product, String productCategory ) throws InterruptedException {
		
		resultpage = prodsearch.selectsearchedProductCategory(product,productCategory);
		
	}
	
	@Then("^Selected (.+) visible in Result page$")
	public void result_Page(String productcategoryItem) {
		boolean flag = resultpage.resultpagevalidation(productcategoryItem);
		Assert.assertTrue(flag);
		driver.quit();
	}
	

}
