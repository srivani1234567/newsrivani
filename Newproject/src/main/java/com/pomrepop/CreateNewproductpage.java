package com.pomrepop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewproductpage {
	
	@FindBy(xpath="//input[@name='productname']")
	private WebElement productnametb;
	
	public WebElement getProductnametb() {
		return productnametb;
	}

	public CreateNewproductpage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	

}
