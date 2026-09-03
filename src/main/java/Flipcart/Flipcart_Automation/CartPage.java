package Flipcart.Flipcart_Automation;

import java.util.List;
import java.util.stream.Collector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {
	WebDriver driver;
	public CartPage(WebDriver driver) {
		this.driver=driver;
		
		
	}
	
	public boolean cartPageValidation(String expectedItem ) throws InterruptedException {
		Thread.sleep(5000);
		
		List<WebElement> cartItemList=  driver.findElements(By.cssSelector(".sc-grid-item-product-title span"));
		boolean flag=cartItemList.stream().anyMatch(cartItem->cartItem.getText().contains(expectedItem));
		return flag;
		//"
		}
		
	}

