package Flipcart.Flipcart_Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddToCart extends ObjectBase {
	public WebDriver driver;
	public AddToCart(WebDriver driver) {
		super(driver);
		
		this.driver=driver;
	}
	
	
	public CartPage sellerAddCart() {
		explicitWaitonElementVisibility(By.cssSelector("[id='submit.add-to-cart-announce']"));
		
		driver.findElement(By.cssSelector("[id='add-to-cart-button']")).click();
		driver.findElement(By.cssSelector("[id='nav-cart-count']")).click();
		CartPage cartPage = new CartPage(driver);
		return cartPage;
	}

}
