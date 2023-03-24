package edu.training.flipkart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import edu.training.base.BaseClass;

public class PaymentPage extends BaseClass {
	public PaymentPage() {
		PageFactory.initElements(driver, null);
	}
	
	@FindBy(xpath="//span[text()='Credit / Debit / ATM Card']")
	private WebElement cardPayment;
	
	public WebElement getCardPayment() {
		return cardPayment;
	}
	
	@FindBy(xpath="//input[@name='cardNumber']")
	private WebElement cardNumber;
	
	public WebElement getCardNumber() {
		return cardNumber;
	}
	
	@FindBy(xpath="//select[@name='month']")
	private WebElement month;
	
	public WebElement getMonth() {
		return month;
	}
	
	@FindBy(xpath="//select[@name='year']")
	private WebElement year;
	
	public WebElement getYear() {
		return year;
	}
	
	@FindBy(xpath="//input[@type='password']")
	private WebElement cvv;
	
	public WebElement getCvv() {
		return cvv;
	}
	
	@FindBy(xpath="//button[@class='_2KpZ6l _2nejCf _3AWRsL']")
	private WebElement payButton;
	
	public WebElement getPayButton() {
		return payButton;
	}
	
	public void paymentMethod() {
		clickOnElement(getCardPayment());
		sendKeys(getCardNumber(), "6521830908399303");
		selectDropDown(getMonth(), "12");
		selectDropDown(getYear(), "24");
		sendKeys(getCvv(), "877");
		clickOnElement(getPayButton());
	}

}
