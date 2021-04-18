package com.pomrepop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.generic.WebdriverUtilities;

public class Homepage {
	
	WebdriverUtilities wd=new WebdriverUtilities();
	@FindBy(xpath="//td[@align='center']/a[text()='Organizations']")
	private WebElement orglink;
	
	@FindBy(xpath="//td[@align='center']/a[text()='Contacts']")
     private WebElement contactlink;
	
    @FindBy(xpath="//td[@class='genHeaderSmall']/following-sibling::td[1]/img")	
    private WebElement signoutimg;
    
    @FindBy(xpath="//a[text()='Sign Out']")
    private WebElement signoutlink;
    
    @FindBy(xpath="//select[@id='qccombo']")
    private WebElement quickcreatedd;
    
    @FindBy(xpath="//input[@name='productname']")
    private WebElement childcreateproducttb;
    
    @FindBy(xpath="//input[@value='T']")
    private WebElement groupradiobtn;
    
    @FindBy(xpath="//span[@id='assign_team']/select[@name='assigned_group_id']")
    private WebElement Teamsellingdd;
    
    @FindBy(xpath="//input[@value='U']")
    private WebElement userradiobtn;
    
    
    public WebElement getUserradiobtn() {
		return userradiobtn;
	}


	@FindBy(xpath="//input[@type='submit']")
    private WebElement childsavebtn;
    
    @FindBy(xpath="//td[@align='center']/a[text()='Products']")
    private WebElement productlink;
    
	public WebElement getProductlink() {
		return productlink;
	}


	public WebElement getChildsavebtn() {
		return childsavebtn;
	}


	public WebElement getTeamsellingdd() {
		return Teamsellingdd;
	}


	public WebElement getGroupradiobtn() {
		return groupradiobtn;
	}


	public WebElement getChildcreateproducttb() {
		return childcreateproducttb;
	}


	public WebElement getQuickcreatedd() {
		return quickcreatedd;
	}


	public WebElement getSignoutimg() {
		return signoutimg;
	}


	public WebElement getSignoutlink() {
		return signoutlink;
	}


	public Homepage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);


	}


	public WebElement getOrglink() {
		return orglink;
	}

	public WebElement getContactlink() {
		return contactlink;
	}
	
	
   //genric method for signlout
	public void signoutapp(WebDriver driver) {
		wd.movetoelement(driver, signoutimg);
		signoutlink.click();
		
	}
}
