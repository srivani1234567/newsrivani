package TestScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.generic.Baseclass;
import com.pomrepop.Homepage;
import com.pomrepop.productpage;

public class CreateNewproduct extends Baseclass {
	
	
	
	@Test
	public void createNewproductwithTeamselling() throws EncryptedDocumentException, IOException {
		String createnewproduct = e.readdatafromExcel("EXCELTESTDATASHEET", 13, 3);
		String prodname = e.readdatafromExcel("EXCELTESTDATASHEET", 14, 3);
		String teamselling = e.readdatafromExcel("EXCELTESTDATASHEET", 15, 3);
		String expprodtext = e.readdatafromExcel("EXCELTESTDATASHEET", 19, 3);

		
		//click on quickcreatedropdown in homepage
	     Homepage hp=new Homepage(driver);
	     WebElement quickcreatedd = hp.getQuickcreatedd();
	     wd.selectbyvalue(driver, quickcreatedd, createnewproduct);
	     
	     //enter the product name
	     hp.getChildcreateproducttb().sendKeys(prodname);
	     
	     //select group id radio button
	     hp.getGroupradiobtn().click();
	     
	     //select teamselling  in dropdown
	     WebElement teamsellingdd = hp.getTeamsellingdd();
	     wd.selectbyvalue(driver, teamsellingdd, teamselling);
	     
	     //click on save btn
	     hp.getChildsavebtn().click();
	     
         //validation
	     productpage p=new productpage(driver);
		String actualproducttext = p.getProductvalidate().getText();
		boolean result = actualproducttext.contains(expprodtext);
		Assert.assertEquals(true, result);


		
	}

}
