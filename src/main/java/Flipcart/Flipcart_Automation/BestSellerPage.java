package Flipcart.Flipcart_Automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BestSellerPage {
	public WebDriver driver;
	public BestSellerPage(WebDriver driver) {
		this.driver=driver;
		
	}
	
	public AddToCart SelectSellerProduct(String sellerItem) {
		
	List<WebElement> sellerProductList=	driver.findElements(By.cssSelector(".aok-block span div"));
	WebElement sellerProduct=  sellerProductList.stream().filter(sellerProduct1->sellerProduct1.getText().
			contains(sellerItem)).findFirst().orElse(null);
	sellerProduct.click();
	AddToCart addCart = new AddToCart(driver);
	return addCart;
	}

}
