package com.pomrepop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatenewContact {
	
	@FindBy(xpath="//select[@name='salutationtype']")
	private WebElement salutationtypedd;
    
	@FindBy(xpath="//input[@name='firstname']")
	private WebElement firstnametb;
	
	@FindBy(xpath="//input[@name='lastname']")
	private WebElement lastnametb;
	
	@FindBy(xpath="//input[@name='account_id']/following-sibling::img[@title='Select']")
	private WebElement selectorgname;
	
	@FindBy(xpath="//input[@id='search_txt']")
	private WebElement searchchildtb;
	
	public WebElement getSalutationtypedd() {
		return salutationtypedd;
	}

	public WebElement getFirstnametb() {
		return firstnametb;
	}

	public WebElement getLastnametb() {
		return lastnametb;
	}

	public WebElement getSelectorgname() {
		return selectorgname;
	}

	public WebElement getSearchchildtb() {
		return searchchildtb;
	}

	public WebElement getSearchchildbtn() {
		return searchchildbtn;
	}

	public WebElement getSelectorgiteminchild() {
		return selectorgiteminchild;
	}

	public WebElement getMobiletb() {
		return Mobiletb;
	}

	@FindBy(xpath="//input[@name='search']")
	private WebElement searchchildbtn;
	
	@FindBy(xpath="//a[text()='TATA motors']")
	private WebElement selectorgiteminchild;
	
	@FindBy(xpath="//input[@id='phone']")
	private WebElement Mobiletb;
	
	public CreatenewContact(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	//generic method for after switch the window from Create contact page to select orgnaization page
	public void selectOrgnizationbysearch(String organizationname) {
		searchchildtb.sendKeys(organizationname);
		searchchildbtn.click();
		selectorgiteminchild.click();
		
	}
	
}
