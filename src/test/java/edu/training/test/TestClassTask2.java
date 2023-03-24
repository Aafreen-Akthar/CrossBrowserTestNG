package edu.training.test;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import edu.training.base.BaseClass;
import edu.training.flipkart.pages.LoginPage;
import edu.training.flipkart.pages.PaymentPage;
import edu.training.flipkart.pages.ProductPage;
import edu.training.flipkart.pages.SearchPage;

public class TestClassTask2 extends BaseClass {

	@BeforeSuite
	public void browserlaunch() throws Exception {
		test = extent.createTest("Browser Launch");
		browserCall("chrome");
		sendUrl("https://www.flipkart.com/");
		Thread.sleep(5000);
	}

	@Test(priority = 0)
	public void login() throws Exception {
		test = extent.createTest("Login");
		LoginPage objLogin = new LoginPage();
		objLogin.loginFunctionality();
		Thread.sleep(5000);
	}

	@Test(priority = 1)
	public void search() throws Exception {
		test = extent.createTest("Search");
		SearchPage objSearch = new SearchPage();
		objSearch.searchFunctionality();
		Thread.sleep(5000);
	}

	@Test(priority = 2)
	public void product() throws Exception {
		test = extent.createTest("Add to Cart");
		ProductPage objProdPage = new ProductPage();
		objProdPage.addToCart();
		Thread.sleep(5000);
	}

	@Test(priority = 3)
	public void payment() throws Exception {
		test = extent.createTest("Payment");
		PaymentPage objPay = new PaymentPage();
		objPay.paymentMethod();
		Thread.sleep(3000);
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) throws Exception {
		if(result.getStatus()==ITestResult.FAILURE) {
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName(), ExtentColor.RED));
			test.log(Status.FAIL, "Screenshot of failed scenario is given below:");
			test.addScreenCaptureFromPath(printScreen(result.getName()));
			//printScreen(result.getName());
		}
		else if(result.getStatus()==ITestResult.SUCCESS) {
			//test.log(Status.PASS,MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));
			test.log(Status.PASS, "Passed Testcase is " + result.getName());
		}
	}

	@AfterSuite
	public void closeAll() {
		quitBrowser();
	}

}
