package com.pomrepop;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Organizationpage {
	
	@FindBy(xpath="//a/img[@title='Create Organization...']")
	private WebElement Createorgbtn;
	
	@FindBy(xpath="//input[@class='txtBox']")
	private WebElement searchtb;
	
	@FindBy(xpath="//div[@id='basicsearchcolumns_real']/select[@id='bas_searchfield']")
	private WebElement Indd;
	
	@FindBy(xpath="//input[@name='submit']")
	private WebElement searchbtn;
	
	@FindBy(xpath="//table[@class='lvt small']/tbody/tr[*]/td[3]//a[@title='Organizations']")
	private WebElement actualorgnamelist;
	
	public WebElement getSearchtb() {
		return searchtb;
	}

	public WebElement getIndd() {
		return Indd;
	}

	public WebElement getSearchbtn() {
		return searchbtn;
	}

	public WebElement getActualorgnamelist() {
		return actualorgnamelist;
	}

	public Organizationpage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);

	}


	public WebElement getCreateorgbtn() {
		return Createorgbtn;
	}
	
	

}
