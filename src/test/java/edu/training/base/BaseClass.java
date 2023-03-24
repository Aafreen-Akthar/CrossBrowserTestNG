package edu.training.base;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;
import java.util.Set;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	// initializing driver as a static variable
	public static WebDriver driver;
	
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;

	//static JavascriptExecutor js = (JavascriptExecutor) driver;
	
	// Launching browser
	public static WebDriver browserCall(String browserType) {
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
		return driver;
	}

	// Quit browser
	public static void quitBrowser() {
		driver.quit();
	}

	// Sending URL and maximize window
	public static void sendUrl(String Url) {
		driver.manage().window().maximize();
		driver.get(Url);
	}

	// Send Keys method
	public static void sendKeys(WebElement keyElement, String keys) {
		keyElement.sendKeys(keys);
	}

	// Click an element
	public static void clickOnElement(WebElement element) {
		element.click();
	}

	// Selecting from drop down
	public static void selectDropDown(WebElement dropDown, String visibleText) {
		Select picklist = new Select(dropDown);
		picklist.selectByVisibleText(visibleText);
	}

	// Actions - mouse hover
	public static void actionsMouseHover(WebElement mouseHover) {
		Actions actionHover = new Actions(driver);
		actionHover.moveToElement(mouseHover).perform();
	}

	// Actions - drag and drop
	public static void dragAndDrop(WebElement dd1, WebElement dd2) {
		Actions dragDrop = new Actions(driver);
		dragDrop.dragAndDrop(dd1, dd2);
	}
	
	//Actions - click and hold
	public static void clickAndHold(WebElement ch) {
		Actions clickHold = new Actions(driver);
		clickHold.clickAndHold(ch).perform();
	}

	// Alert handling - accept
	public static void alertAccept() {
		Alert acceptAlert = driver.switchTo().alert();
		acceptAlert.accept();
	}

	// Alert handling - dismiss
	public static void alertDismiss() {
		Alert dismissAlert = driver.switchTo().alert();
		dismissAlert.dismiss();
	}

	// iFrame - switch to frame by web element
	public static void switchFrame(WebElement iframe) {
		driver.switchTo().frame(iframe);
	}
	
	// iFrame - switch to frame by index
	public static void switchFrameIndex(int number) {
		driver.switchTo().frame(number);
	}

	// iFrame - switch to parent frame
	public static void switchParentFrame() {
		driver.switchTo().parentFrame();
	}

	// iFrame - switch to default content
	public static void switchOuterFrame() {
		driver.switchTo().defaultContent();
	}

	// Javascript executor - set attributes
	public static void jsSetAttributes(WebElement jsElement, String input) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','input')", jsElement);
	}

	// Javascript executor - return attributes
	public static void jsRetAttributes(WebElement jsElement, String input) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("return arguments[0].getAttribute('value')", jsElement);
	}

	// Javascript executor - click element
	public static void jsElementClick(WebElement jsClickElement) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", jsClickElement);
	}

	// Javascript executor - scroll down
	public static void jsScrollDown(WebElement scrollDown) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", scrollDown);
	}

	// Javascript executor - scroll up
	public static void jsScrollUp(WebElement scrollUp) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(false)", scrollUp);
	}

	// Javascript executor - highlight
	public static void jsHighlight(WebElement elementHighlight) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style','background: red; border: 2px solid red;')",
				elementHighlight);
	}
	
	//Switch to another window
	public static void switchToWindow () {
		String currentWindowHandle = driver.getWindowHandle();
		System.out.println(currentWindowHandle);
		Set<String> allWindowHandles = driver.getWindowHandles();
		System.out.println(allWindowHandles);
		for (String windowHandle : allWindowHandles) {
			if (!windowHandle.equals(currentWindowHandle)) {
				driver.switchTo().window(windowHandle);
			}
		}
	}
	
	public static String printScreen(String name) throws Exception {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
		File destinationFile = new File(
				"C:\\Users\\AafreenAkthar\\eclipse-workspace\\FrameworkTraining\\ResultFiles\\" + name + ".png");
		String filePath = destinationFile.getPath();
		FileHandler.copy(sourceFile, destinationFile);
		Thread.sleep(10000);
		return filePath;
          
	}
	
	@BeforeSuite
	public static void setExtent() {
		htmlReporter = new ExtentHtmlReporter("C:\\Users\\AafreenAkthar\\eclipse-workspace\\FrameworkTraining\\ResultFiles\\extentReport.html");
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setDocumentTitle("Flipkart Test Report");
		htmlReporter.config().setReportName("Flipkart Test Results");
		htmlReporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Organization", "MST");
		extent.setSystemInfo("Browser", "Chrome");
		extent.setSystemInfo("Author", "Aafreen");;
	}
	
	/*
	 * @AfterSuite public static void endReport() { extent.flush(); }
	 */
	

}
