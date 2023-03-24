package edu.training.flipkart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import edu.training.base.BaseClass;

public class LoginPage extends BaseClass {
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()='Login']")
	private WebElement loginButton;

	public WebElement getLoginButton() {
		return loginButton;
	}

	@FindBy(xpath = "//input[@class='_2IX_2- VJZDxU']")
	private WebElement mobileNumber;

	public WebElement getMobileNumber() {
		return mobileNumber;
	}

	@FindBy(xpath = "//input[@class='_2IX_2- _3mctLh VJZDxU']")
	private WebElement password;

	public WebElement getPassword() {
		return password;
	}

	@FindBy(xpath = "//button[@class='_2KpZ6l _2HKlqd _3AWRsL']")
	private WebElement submitLogin;

	public WebElement getSubmitLogin() {
		return submitLogin;
	}

	public void loginFunctionality() {
		// clickOnElement(getLoginButton());
		sendKeys(getMobileNumber(), "7010362719");
		sendKeys(getPassword(), "Rooh!3108");
		clickOnElement(getSubmitLogin());
	}

}
