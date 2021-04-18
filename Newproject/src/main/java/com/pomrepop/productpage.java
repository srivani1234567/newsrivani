package com.pomrepop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class productpage {
	
	@FindBy(xpath="//img[@title='Create Product...']")
	private WebElement producticon;
	
	@FindBy(xpath="//span[@class='lvtHeaderText']")
	private WebElement productvalidate;
	
	public WebElement getProductvalidate() {
		return productvalidate;
	}

	public WebElement getProducticon() {
		return producticon;
	}

	public productpage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}

}
