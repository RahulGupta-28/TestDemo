package Flipcart.Flipcart_Automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ObjectBase {
	WebDriver driver;
	public ObjectBase(WebDriver driver) {
		this.driver=driver;
		
	}
	
	public void explicitWaitonElementVisibility(By locator) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

}
