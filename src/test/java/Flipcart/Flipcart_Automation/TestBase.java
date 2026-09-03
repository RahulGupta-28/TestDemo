package Flipcart.Flipcart_Automation;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestBase {
	public WebDriver driver;

	public String readPropertyFile() throws IOException {
		Properties prop = new Properties();
		File propfile = new File("src\\test\\java\\Data\\config.properties");
		FileInputStream fis = new FileInputStream(propfile);
		prop.load(fis);
		return prop.getProperty("browser");

	}

	public WebDriver initBrowser() throws IOException {
		String browser = System.getProperty("browser") != null ? System.getProperty("browser") : readPropertyFile();

		// String browser=readPropertyFile();
		if (browser.contains("chrome")) {
			ChromeOptions options = new ChromeOptions();
			if (browser.contains("headless")) {
				options.addArguments("headless");
				driver = new ChromeDriver(options);
				driver.manage().window().setSize(new Dimension(1920, 1080));

				this.driver = driver;
			}
			else {
				driver = new ChromeDriver();
				driver.manage().window().maximize();

				this.driver = driver;
			}
		
			
//			driver = new ChromeDriver(options);
//
//			this.driver = driver;
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			this.driver = driver;
		}
		
		//driver.manage().window().setSize(new Dimension(1920, 1080));
		//driver.manage().window().maximize();

		return driver;
	}

	public List<HashMap<String, String>> jsonReader(String filePath) throws IOException {
		File file = new File(filePath);
		String filecontent = FileUtils.readFileToString(file, "UTF-8");
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(filecontent,
				new TypeReference<List<HashMap<String, String>>>() {
				});
		return data;
	}

	public ProductSearch landingPage() throws IOException {

		initBrowser();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		// driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		ProductSearch prodsearch = new ProductSearch(driver);
		return prodsearch;
	}

	public String takeScreenShot(WebDriver driver, String testCaseName) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String filepath = "src\\test\\java\\Report" + "\\" + testCaseName + ".png";
		File des = new File(filepath);
		FileUtils.copyFile(source, des);
		return filepath;
	}

	@AfterMethod
	public void closeBrowser() {

		driver.quit();
	}

}
