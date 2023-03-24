package edu.training.flipkart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import edu.training.base.BaseClass;

public class SearchPage extends BaseClass {
	public SearchPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@title='Search for products, brands and more']")
	private WebElement searchBox;
	
	public WebElement getSearchBox() {
		return searchBox;
	}
	@FindBy(css="button[class='L0Z3Pu']")
	private WebElement searchButton;
	
	public WebElement getSearchButton() {
		return searchButton;
	}
	
	public void searchFunctionality() {
		sendKeys(getSearchBox(), "boat eardopes");
		jsElementClick(getSearchButton());
	}
	

}
