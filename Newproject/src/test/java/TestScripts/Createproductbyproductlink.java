package TestScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.generic.Baseclass;
import com.pomrepop.CreateNewOrgpage;
import com.pomrepop.CreateNewproductpage;
import com.pomrepop.Homepage;
import com.pomrepop.productpage;

public class Createproductbyproductlink extends Baseclass{
	
	@Test
	public void createNewprodbyprodlink() throws EncryptedDocumentException, IOException {
		String prodname = e.readdatafromExcel("EXCELTESTDATASHEET", 16, 3);
		String expprodtext = e.readdatafromExcel("EXCELTESTDATASHEET", 19, 3);

		
		//click on product link in homepage
	     Homepage hp=new Homepage(driver);
	     hp.getProductlink().click();
	     
	     //click on + icon
	     productpage pp=new productpage(driver);
	     pp.getProducticon().click();
	     
	     //enter productname textfield
	     CreateNewproductpage cnp=new CreateNewproductpage(driver);
	     cnp.getProductnametb().sendKeys(prodname);
	     
		 //scrolldown
	     JavascriptExecutor jse=(JavascriptExecutor)driver;
	     jse.executeScript("window.scrollBy(0,4000)");

	     
	     //save btn
	     CreateNewOrgpage co=new CreateNewOrgpage(driver);
	     co.getSavebtn().click();
	     
         //validation
	     productpage p=new productpage(driver);
		String actualproducttext = p.getProductvalidate().getText();
		boolean result = actualproducttext.contains(expprodtext);
		Assert.assertEquals(true, result);


		
	}

}
