/**

 * @author UmaMaheswararao
 */

package com.testcases;

import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BasePage;
import static com.pages.AnalysePage.*;
import static com.pages.DashBoardPage.*;
import static com.pages.LoginPage.*;
import com.util.ExcelUtility;

public class AnalysePageTest extends BasePage {
	
	ExcelUtility reader;
	
	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		login(prop.getProperty("username"), prop.getProperty("password"));
		clickOnAnalyseLink();
		reader = new ExcelUtility("./src/main/java/com/testdata/NewiQaptureData.xlsx");
	}
	
	@AfterMethod
	public void tearDown() {
		tldriver.get().quit();
	}
	
	@Test
	public void AnalysePage_Test() throws Exception {
		verify_AnalysePage();
		Reporter.log("Analyse Page Verified Successfully",true);
	}
	
	
	
	
	
	
	
	
}
