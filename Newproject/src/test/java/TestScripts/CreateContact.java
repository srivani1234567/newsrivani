package TestScripts;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.generic.ExcelUtility;
import com.generic.FileUtility;
import com.generic.JavaUtilities;
import com.generic.WebdriverUtilities;
import com.pomrepop.Contactpage;
import com.pomrepop.CreateNewOrgpage;
import com.pomrepop.CreatenewContact;
import com.pomrepop.Homepage;
import com.pomrepop.Loginpage;

public class CreateContact
{
	public static WebDriver driver;
	FileUtility fu=new FileUtility();
	ExcelUtility e=new ExcelUtility();
	WebdriverUtilities wd=new WebdriverUtilities();

	@Test
	public void CreateCon() throws IOException, InterruptedException
	{    
		//Read the data from propertiesfile
		String URL = fu.readdatafrompropertiesfile("url");
		 String UN = fu.readdatafrompropertiesfile("username");
		 String PWD = fu.readdatafrompropertiesfile("password");
		 
		 //Read the data from Excelsheet
		 String beforename = e.readdatafromExcel("EXCELTESTDATASHEET",7 , 3);
		 String name = e.readdatafromExcel("EXCELTESTDATASHEET", 8, 3);
		 String lastname = e.readdatafromExcel("EXCELTESTDATASHEET", 9, 3);
         
	       //Launching a browser
	      driver=new ChromeDriver();
	      
	      //implicit wait
	      wd.implicitwait(driver);
	      
	      //website url
	     driver.get(URL);
	     
	     //To maximize a window
	     wd.maximizebrowser(driver);
	     
	     //login to application
	     Loginpage lp=new Loginpage(driver);
	      lp.logintoapp(UN, PWD);
	      
	      //click on organization link in homepage
	     Homepage hp=new Homepage(driver);
	     hp.getContactlink().click();
	     
	     
	     //click on createcontacticon
	     Contactpage cp=new Contactpage(driver);
	     cp.getCreatecontactbtn().click();
	    
	     //select salutationtype listbox
	     CreatenewContact cc=new CreatenewContact(driver);
	     WebElement salutationtypedd = cc.getSalutationtypedd();
	     wd.selectbyvalue(driver, salutationtypedd, beforename);
	     
	     //enter firstname in contactpage
	     cc.getFirstnametb().sendKeys(name);
	     
	     //enterlastname
	     cc.getLastnametb().sendKeys(lastname);
       

	     //scrolldown
	     JavascriptExecutor jse=(JavascriptExecutor)driver;
	     jse.executeScript("window.scrollBy(0,4000)");
	     
        //save button
	     CreateNewOrgpage co=new CreateNewOrgpage(driver);
	     co.getSavebtn().click();
	     
	     //signout
	     wd.movetoelement(driver, hp.getSignoutimg());
	     hp.getSignoutlink().click();
	     
	     
	     //close browser
	     driver.quit();

	}

}
