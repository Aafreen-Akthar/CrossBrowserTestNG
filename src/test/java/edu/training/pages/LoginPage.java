package edu.training.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import edu.training.base.BaseClass;

public class LoginPage extends BaseClass {

	public WebElement navList() {
		WebElement navigationList = driver.findElement(By.id("nav-link-accountList"));
		return navigationList;
	}
	public WebElement signIn() {
		WebElement signIn = driver.findElement(By.xpath("//span[text()='Sign in']"));
		return signIn;
	}
	public WebElement email() {
		WebElement email = driver.findElement(By.id("ap_email"));
		return email;
	}
	public WebElement password() {
		WebElement password = driver.findElement(By.id("ap_password"));
		return password;
	}
	public WebElement continueButton() {
		WebElement continueButton = driver.findElement(By.xpath("//input[@id='continue']"));
		return continueButton;
	}
	public WebElement submit() {
		WebElement submitButton = driver.findElement(By.xpath("//input[@id='signInSubmit']"));
		return submitButton;
	}
	public void loginCommon() throws InterruptedException {
		sendUrl("https://www.amazon.in/");
		Thread.sleep(5000);
		//LoginPage objLogin = new LoginPage();
		actionsMouseHover(navList());
		clickOnElement(signIn());
		Thread.sleep(3000);
		sendKeys(email(), "aafreenshahul@gmail.com");
		Thread.sleep(3000);
		clickOnElement(continueButton());
		Thread.sleep(3000);
		sendKeys(password(), "Aafreen@2906");
		Thread.sleep(3000);
		clickOnElement(submit());
		Thread.sleep(3000);
		//quitBrowser();
	}

}
