package Flipcart.Flipcart_Automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultPage extends ObjectBase {
	public WebDriver driver;
	public SearchResultPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	By locator=By.cssSelector(".s-no-outline h2");
	By resultitemlist=By.cssSelector(".puisg-col-inner h2 span ");
	
	public boolean resultpagevalidation(String expectedresutItem) {
		explicitWaitonElementVisibility(locator);
		
		System.out.println(driver.findElement(locator).getText());
	 List<WebElement> resultList=	driver.findElements(resultitemlist);
	 for(int i=0;i<resultList.size();i++) {
		 
		 WebElement resulttext=resultList.get(i);
		System.out.println(resulttext.getText());
		 if(resulttext.getText().contains(expectedresutItem)) {
			 System.out.println("search pass");
			 break;
		 }
	 }
	 return true;
		
		
	}

}
