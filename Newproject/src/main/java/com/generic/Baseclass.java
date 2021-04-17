package com.generic;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.mysql.cj.jdbc.Driver;
import com.pomrepop.Homepage;
import com.pomrepop.Loginpage;

public class Baseclass {
	
	public WebDriver driver;
	public JavaUtilities j=new JavaUtilities();
	public FileUtility fu=new FileUtility();
	public ExcelUtility e=new ExcelUtility();
	public WebdriverUtilities wd=new WebdriverUtilities();
	

	//Connection con=null;

	//Read the data from properties file
	
	/*String URL = fu.readdatafrompropertiesfile("url");
	 String UN = fu.readdatafrompropertiesfile("username");
	 String PWD = fu.readdatafrompropertiesfile("password");
 */
	
	/*@BeforeSuite

	public void Databaceconnect(Driver driverref,Connection con ) throws SQLException {
		//step1:register to the database
		DriverManager.registerDriver(driverref);
		
		//step2:get connection into data base
		 con=DriverManager.getConnection(IConstance.databasepath, "root", "root");
		 
		 //step3:issue create statement
		 Statement  state = con.createStatement();
		 
		 //step4:excute query
	    ResultSet result=state.executeQuery("select data  from table_name;");
		
	   while(result.next()) {
		
		System.out.println(result.getString(1)+"\t"+result.getString(2));
	
		}
		System.out.println("==Extent report==");

		
	} 
	*/
	
	@BeforeClass
	public void launchbrowser() throws IOException  {
		String value = fu.readdatafrompropertiesfile("browser");
		
		if(value.equals("chrome")) {
			
		       //Launching a chrome browser
		      driver=new ChromeDriver();

		}else if(value.equals("Firefox")){
			//launch a firefoxdriver
			driver= new FirefoxDriver();
		}else if(value.equals("opera")) {
			//launch a opera browser
			
			driver=new OperaDriver();
		}
		
	      
	      //website url
	     driver.get(fu.readdatafrompropertiesfile("url"));
	     
	     //To maximize a window
	     wd.maximizebrowser(driver);
	     
	      //implicit wait
	      wd.implicitwait(driver);
	      



		
		
	}
	
	
	@BeforeMethod
	public void Login() throws IOException {
	     //login to application
	     Loginpage lp=new Loginpage(driver);
	      lp.logintoapp(fu.readdatafrompropertiesfile("username"), fu.readdatafrompropertiesfile("password"));


		
	}
	
	@AfterMethod
	public void Logout() {
		//logout from app
		Homepage hp=new Homepage(driver);
		hp.signoutapp(driver);
		
		
		
	}
	
	@AfterClass
	public void closebrowser() {
		//close browser
		driver.quit();
		
	}
	
	//@AfterSuite
	/*public void Aftersuit() throws SQLException {
		
		//close the database connection
		con.close();
		System.out.println("==close Extent report==");

		
		
	} */

}
