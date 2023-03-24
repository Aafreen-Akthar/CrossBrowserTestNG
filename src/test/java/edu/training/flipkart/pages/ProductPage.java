package edu.training.flipkart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import edu.training.base.BaseClass;

public class ProductPage extends BaseClass {
	public ProductPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(css="a[title='boAt Airdopes 131 with upto 15 Hours Playback, 13mm Drivers and IWP Technology Bluetooth Headset']")
	private WebElement product;
	
	public WebElement getProduct() {
		return product;
	}
	
	@FindBy(xpath="//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")
	private WebElement addToCart;
	
	public WebElement getAddToCart() {
		return addToCart;
	}
	
	@FindBy(xpath="//span[text()='Place Order']")
	private WebElement placeOrder;
	
	public WebElement getPlaceOrder() {
		return placeOrder;
	}
	
	@FindBy(xpath="//(iframe[@title='Human verification challenge'])[5]") 
	private WebElement verification;
	 
	public WebElement getVerification() {
    return verification; 
    }
	 
	
	@FindBy(css="div[id='CELiOtYdmGIPvgu']p[id='ndfcppyzqZQcykw']")
	private WebElement pressAndHold;
	
	public WebElement getPressAndHold() {
		return pressAndHold;
	}
	
	@FindBy(xpath="//button[text()='CONTINUE']")
	private WebElement continueButton;
	
	public WebElement getContinueButton() {
		return continueButton;
	}
	
	@FindBy(xpath="//button[text()='Accept & Continue']")
	private WebElement popupContinue;
	
	public WebElement getPopupContinue() {
		return popupContinue;
	}
	
	public void addToCart() throws InterruptedException {
		jsElementClick(getProduct());
		switchToWindow();
		clickOnElement(getAddToCart());
		Thread.sleep(3000);
		clickOnElement(getPlaceOrder());
		Thread.sleep(3000);
		switchFrame(getVerification());
		//switchFrameIndex(4);
		clickAndHold(getPressAndHold());
		//switchOuterFrame();
		clickOnElement(getContinueButton());
		clickOnElement(getPopupContinue());
	}

}
