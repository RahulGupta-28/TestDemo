package Flipcart.Flipcart_Automation;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Bestseller extends TestBase {
	
	@Test(dataProvider = "getData")
	public void bestseller(HashMap<String, String> input) throws IOException, InterruptedException {
			ProductSearch prodsearch = null;

			prodsearch = landingPage();

			BestSellerPage sellerPage = prodsearch.bestSelllerOptionClick();
			AddToCart addCart=sellerPage.SelectSellerProduct(input.get("productItem"));
			CartPage cartPage=  addCart.sellerAddCart();
			boolean flag =cartPage.cartPageValidation(input.get("ExpectedProductItem"));
			Assert.assertTrue(flag);
			
	}
	@DataProvider
	public Object[][] getData() throws IOException {
		
		List<HashMap<String, String>> data= jsonReader("src\\test\\java\\Data\\best_seller_data.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};
		
		
	}

}
