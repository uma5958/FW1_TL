/**
 * @author UmaMaheswararao
 */

package com.testcases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BasePage;
import static com.pages.DashBoardPage.*;
import static com.pages.LoginPage.*;
import com.util.ExcelUtility;

public class DashBoardPageTest extends BasePage {
	
	ExcelUtility reader;
	
	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		login(prop.getProperty("username"), prop.getProperty("password"));
		reader = new ExcelUtility("./src/main/java/com/testdata/NewiQaptureData.xlsx");
	}
	
	@AfterMethod
	public void tearDown() {
		tldriver.get().quit();
	}
	
	@Test
	public void Verify_HomePage_Title_Test(){
		String dashBoardTitle = verifyHomePageTitle();
		Assert.assertTrue(dashBoardTitle.contains("Valuechain.com"),"Home page title not matched");
		Reporter.log("Title Verified - Test PASS", true);
	}
	
	@Test
	public void Verify_DashBoardLink_Test(){
		Assert.assertTrue(verifyDashboardLink(), "Dashboard Link Not Present - Test FAIL");
		Reporter.log("DashBoardLink Verified - Test PASS", true);
	}
	
	
	
	
	
	
	

}
