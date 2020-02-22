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
import static com.pages.BuildPage.*;
import static com.pages.DashBoardPage.*;
import static com.pages.LoginPage.*;
import com.util.ExcelUtility;

public class BuildPageTest extends BasePage {
	
	ExcelUtility reader;
	
	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		login(prop.getProperty("username"), prop.getProperty("password"));
		clickOnBuildLink();
		reader = new ExcelUtility("./src/main/java/com/testdata/NewiQaptureData.xlsx");
	}
	
	@AfterMethod
	public void tearDown() {
		tldriver.get().quit();
	}
	
	@Test
	public void Verify_BuidPage_Test() {
		Assert.assertTrue(verify_IQuapturePage(), "New IQapture Button is Missing on the Page");
		Reporter.log("New IQapture Button Present - Test PASS", true);
	}

	
	
	
	
	
}
