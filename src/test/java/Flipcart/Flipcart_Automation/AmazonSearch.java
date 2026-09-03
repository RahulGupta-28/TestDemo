package Flipcart.Flipcart_Automation;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AmazonSearch extends TestBase {

	@Test(dataProvider = "getData")

	public void searchMobile(HashMap<String, String> input) throws InterruptedException, IOException {
		ProductSearch prodsearch = landingPage();
		SearchResultPage resultpage = prodsearch.selectsearchedProductCategory(input.get("product"),
				input.get("productCategory"));
		boolean flag = resultpage.resultpagevalidation(input.get("resultItem"));
		Assert.assertTrue(flag);
		

	}

	

	@DataProvider
	public Object[][] getData() throws IOException {

		List<HashMap<String, String>> data = jsonReader("src\\test\\java\\Data\\mobile_search_data.json");
		return new Object[][] { { data.get(0) }, { data.get(1) } };
	}

}
