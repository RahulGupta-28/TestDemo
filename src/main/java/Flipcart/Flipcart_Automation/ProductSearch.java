package Flipcart.Flipcart_Automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductSearch extends ObjectBase {
	WebDriver driver;

	public ProductSearch(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = "[role='row'] span")

	List<WebElement> searchList;

	@FindBy(css = "[placeholder='Search Amazon.in']")
	WebElement searchTextBox;

	By locatorForwait = By.cssSelector("[role='row'] span");
	
	@FindBy(css="[data-csa-c-content-id='nav_cs_bestsellers']")
	WebElement bestsellerOption;

	public WebElement searchAnyProduct(String searchItem,String desiredItem) throws InterruptedException {
		WebElement text = null;

		searchTextBox.sendKeys(searchItem);
		explicitWaitonElementVisibility(locatorForwait);
		List<WebElement> searchList = driver.findElements(locatorForwait);

		System.out.println(searchList.size());
		for (int i = 0; i < searchList.size(); i++) {

			text = searchList.get(i);

			System.out.println(text.getText());
			if (text.getText().contains(desiredItem)) {
				break;
			}

		}
		return text;
	}

	public SearchResultPage selectsearchedProductCategory(String searchItem,String desiredItem ) throws InterruptedException {
		WebElement category=searchAnyProduct(searchItem, desiredItem);
		
		category.click();
		SearchResultPage resultpage= new SearchResultPage(driver);
		return resultpage;

	}
	
	public BestSellerPage bestSelllerOptionClick() {
		bestsellerOption.click();
		BestSellerPage sellerPage =new BestSellerPage(driver);
		return sellerPage;
		
	}

}
