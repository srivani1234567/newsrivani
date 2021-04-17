package com.pomrepop;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBys;



public class Login {
	
	@FindBy(xpath="//input[@name='user_name']")
	public WebElement usernametb;
	
	
	@FindAll(value={@FindBy(xpath="//input[@type='passwor']"),@FindBy(xpath="//input[@name='user_password']")})
	public WebElement passwordtb;
	
	@FindBys(value= {@FindBy( id="submitButton"),@FindBy(xpath="//input[@type='submit']")})
	public WebElement loginbtn;
			

}
