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
import static com.pages.CapturePage.*;
import static com.pages.DashBoardPage.*;
import static com.pages.LoginPage.*;
import com.util.ExcelUtility;

public class CapturePageTest extends BasePage {
	
	ExcelUtility reader;
	
	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		login(prop.getProperty("username"), prop.getProperty("password"));
		clickOnCaptureLink();
		reader = new ExcelUtility("./src/main/java/com/testdata/NewiQaptureData.xlsx");
	}
	
	@AfterMethod
	public void tearDown() {
		tldriver.get().quit();
	}

	@Test
	public void CapturePage_Title_Test() {
		String actual = verifyPageTitle();
		String expected = "Capture";
		Assert.assertEquals(actual, expected, "Capture Page Not Opened");
		Reporter.log("Capture Page Opened Successfully", true);
	}

	
	
	
	

	
	
}
