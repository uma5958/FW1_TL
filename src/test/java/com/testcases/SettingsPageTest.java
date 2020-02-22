/**
 * @author UmaMaheswararao
 */

package com.testcases;

import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BasePage;
import static com.pages.DashBoardPage.*;
import static com.pages.LoginPage.*;
import static com.pages.SettingsPage.*;
import com.util.ExcelUtility;

public class SettingsPageTest extends BasePage {
	
	ExcelUtility reader;
	
	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		login(prop.getProperty("username"), prop.getProperty("password"));
		clickOnSettingsLink();
		reader = new ExcelUtility("./src/main/java/com/testdata/NewiQaptureData.xlsx");
	}
	
	@AfterMethod
	public void tearDown() {
		tldriver.get().quit();
	}

	@Test
	public void verify_Navigate_to_Settings_page_Test() {
		verify_Navigate_to_Settings_page();
		Reporter.log("Settings Page Opened Successfully", true);
	}

	
	
	
	
}
