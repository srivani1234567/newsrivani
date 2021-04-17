package TestScripts;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.generic.Baseclass;
import com.generic.ExcelUtility;
import com.generic.FileUtility;
import com.generic.JavaUtilities;
import com.generic.WebdriverUtilities;
import com.pomrepop.CreateNewOrgpage;
import com.pomrepop.Homepage;
import com.pomrepop.Loginpage;
import com.pomrepop.Organizationpage;

public class CreateOrgAndValidate extends Baseclass
{

    @Test
	public void Orgnization() throws InterruptedException, IOException {
    	
    	//To get Random number
	int randomnum = j.getrandomnum(1000);
	String readdatafromExcel = e.readdatafromExcel("EXCELTESTDATASHEET", 1, 3);
	
	//Connect the random with organization name
	String orgname=readdatafromExcel+randomnum;
	
	 //read the data from excel sheet
	 String phonenum = e.readdatafromExcel("EXCELTESTDATASHEET", 2, 3);
	 String industry = e.readdatafromExcel("EXCELTESTDATASHEET", 3, 3);
	 String rating = e.readdatafromExcel("EXCELTESTDATASHEET", 4, 3);
	 String type = e.readdatafromExcel("EXCELTESTDATASHEET", 5, 3);
	 String Indropdown = e.readdatafromExcel("EXCELTESTDATASHEET", 6, 3);
	 
	 
      //click on organization link in homepage
     Homepage hp=new Homepage(driver);
     hp.getOrglink().click();
     
     
     //click on create new organization icon
     Organizationpage og=new Organizationpage(driver);
     og.getCreateorgbtn().click();
     
     //enter the orgnaization name textfield in createNewOrganization page
     CreateNewOrgpage co=new CreateNewOrgpage(driver);
     co.getOrgnametb().sendKeys(orgname);
     
     //enter the phonenumber textfield in createNewOrganization page
      co.getPhonenumtb().sendKeys(phonenum);
      
      //select the onetime from industry listbox in createNewOrganization page
     WebElement industrydd = co.getIndustrydd();
     wd.selectbyvalue(driver, industrydd, industry);
     
     //select the onetime from rating listbox in createNewOrganization page

     WebElement ratingdd = co.getRatingdd();
     wd.selectbyvalue(driver, ratingdd, rating);
     
     //select the onetime from type listbox in createNewOrganization page

     WebElement typedd = co.getTypedd();
     wd.selectbyvalue(driver, typedd, type);
     co.getSavebtn().click();
     
     
     //scroll down
     JavascriptExecutor jse=(JavascriptExecutor)driver;
     jse.executeScript("window.scrollBy(0,4000)");
     
     //wait until click on the organization page
     wd.waitandclick(driver, "//a[text()='Organizations']");
      hp.getOrglink().click();
     
        //enter orgname in search textfiled
       og.getSearchtb().sendKeys(orgname);
     
       //select orgnizationname item from In dropdown
        WebElement indd = og.getIndd();
       wd.selectbyvalue(driver, indd, Indropdown);
       
       //click on searchboxbtn
       og.getSearchbtn().click();
    
       Thread.sleep(2000);
       
       //actualorgnamelist
     WebElement actualorgnamelist = og.getActualorgnamelist();
     String actualorgname1 = actualorgnamelist.getText();
     System.out.println(actualorgname1);
     System.out.println(orgname);
     
     //validation
      Assert.assertEquals(orgname, actualorgname1);
      

      
      //close the browser
      driver.quit();
	}


}

