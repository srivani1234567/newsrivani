package com.pomrepop;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	
	//WebDriver driver;
	@FindBy(xpath="//input[@name='user_name']")
	private WebElement usernametb;
	
	@FindBy(xpath="//input[@name='user_password']")
	private WebElement passwordtb;
	
	@FindBy(xpath="//input[@id='submitButton']")
	private WebElement loginbtn;
	
	public Loginpage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}


	public WebElement getUsernametb() {
		return usernametb;
	}

	public WebElement getPasswordtb() {
		return passwordtb;
	}

	public WebElement getLoginbtn() {
		return loginbtn;
	}
	
	//generic method for login
	public void logintoapp(String username, String password) {
		usernametb.sendKeys(username);
		passwordtb.sendKeys(password);
		loginbtn.click();
		
		
	}
	

}


