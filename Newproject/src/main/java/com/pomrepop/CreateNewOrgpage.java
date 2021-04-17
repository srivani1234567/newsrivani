package com.pomrepop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewOrgpage {
	
	@FindBy(xpath="//input[@name='accountname']")
	private WebElement Orgnametb;
	
	@FindBy(xpath="//input[@id='phone']")
	private WebElement Phonenumtb;
	
	@FindBy(xpath="//select[@name='industry']")
	private WebElement industrydd;
	

	public WebElement getOrgnametb() {
		return Orgnametb;
	}

	public WebElement getPhonenumtb() {
		return Phonenumtb;
	}

	public WebElement getIndustrydd() {
		return industrydd;
	}

	public WebElement getRatingdd() {
		return ratingdd;
	}

	public WebElement getTypedd() {
		return typedd;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}

	@FindBy(xpath="//select[@name='rating']")
	private WebElement ratingdd;
	
	@FindBy(xpath="//select[@name='accounttype']")
	private WebElement typedd;
	
	@FindBy(xpath="(//input[@accesskey='S'])[last()]")
	private WebElement savebtn;
	
	public CreateNewOrgpage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);

		
	}
	

}
