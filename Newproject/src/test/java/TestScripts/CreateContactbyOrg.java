

package TestScripts;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.generic.Baseclass;
import com.generic.ExcelUtility;
import com.generic.FileUtility;
import com.generic.JavaUtilities;
import com.generic.WebdriverUtilities;
import com.pomrepop.Contactpage;
import com.pomrepop.CreateNewOrgpage;
import com.pomrepop.CreatenewContact;
import com.pomrepop.Homepage;
import com.pomrepop.Loginpage;

public class CreateContactbyOrg extends Baseclass {

	@Test
	public void CCByOrganization() throws IOException, InterruptedException {
		 //Read the data from Excel
		 String beforename = e.readdatafromExcel("EXCELTESTDATASHEET",7 , 3);
		 String name = e.readdatafromExcel("EXCELTESTDATASHEET", 8, 3);
		 String lastname = e.readdatafromExcel("EXCELTESTDATASHEET", 9, 3);
		 String Organizationname = e.readdatafromExcel("EXCELTESTDATASHEET", 10, 3);
		 String phnum = e.readdatafromExcel("EXCELTESTDATASHEET", 11, 3);

	      
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
         
	     //Tap on organizationname plus icon
	     cc.getSelectorgname().click();
	     
	     //switch to child window 
	     wd.switchtochaildwindow(driver);
	     
	     //select orgname in childwindow
	     cc.selectOrgnizationbysearch(Organizationname);
	     
	     //switch to maindow
		 wd.switchtomainwindow(driver);

		 
		 //enter the mobilenumber textfield
		 cc.getMobiletb().sendKeys(phnum);
		 
		 //scrolldown
	     JavascriptExecutor jse=(JavascriptExecutor)driver;
	     jse.executeScript("window.scrollBy(0,4000)");

	     
	     //save btn
	     CreateNewOrgpage co=new CreateNewOrgpage(driver);
	     co.getSavebtn().click();
	     



		
	}

}
