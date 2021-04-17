package com.pomrepop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Contactpage {
	
	@FindBy(xpath="//a/img[@title='Create Contact...']")
	private WebElement createcontactbtn;
	
	public Contactpage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreatecontactbtn() {
		return createcontactbtn;
	}
	

}
