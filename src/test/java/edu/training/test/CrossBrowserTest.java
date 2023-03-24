package edu.training.test;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import edu.training.base.BaseClass;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CrossBrowserTest extends BaseClass{

	//public WebDriver driver;

	@Parameters("browserType")

	@BeforeClass
	public void browserInvoke(String browserType) {
		if (browserType.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserType.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browserType.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
	}

	@Test
	public void login() throws Exception {
		sendUrl("https://www.amazon.in/");
		Thread.sleep(5000);
		//quitBrowser();
	}

	

}
