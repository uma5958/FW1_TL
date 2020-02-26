/**
 * @author UmaMaheswararao
 */

package com.testcases;

import static com.pages.LoginPage.*;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BasePage;

public class LoginPageTest extends BasePage {
	
	@BeforeMethod
	public void setUp() {
		start();
		initialization();
	}
	
	@AfterMethod
	public void tearDown() {
		quit();
	}
	
	@Test
	public void LoginPage_Title_Test(){
		String title = validate_LoginPage_Title();
		Assert.assertEquals(title, "login");
		Reporter.log("LoginPage Title Verified", true);
	}
	
	@Test//(dependsOnMethods="LoginPage_Title_Test")
	public void Login_Test() throws Exception{
		login(prop.getProperty("username"), prop.getProperty("password"));
		Reporter.log("User Loggedin Successfully & Dash Board Page Opened", true);
	}
	
	@Test
	public void LoginPage_Title_Test1(){
		String title = validate_LoginPage_Title();
		Assert.assertEquals(title, "login");
		Reporter.log("LoginPage Title Verified", true);
	}
	
	@Test//(dependsOnMethods="LoginPage_Title_Test")
	public void Login_Test1() throws Exception{
		login(prop.getProperty("username"), prop.getProperty("password"));
		Reporter.log("User Loggedin Successfully & Dash Board Page Opened", true);
	}
	
	@Test(dependsOnMethods="LoginPage_Title_Test", enabled=false)
	public void verify_Valuechain_wesite_navigation_on_clicking_Valuechain_logo_Test() throws Exception{
		verify_Valuechain_wesite_navigation_on_clicking_Valuechain_logo("Valuechain | Smart Manufacturing Software to Create World-Class Supply Chains");
		Reporter.log("User able to navigate valuechain website on clicking Valuechain log", true);
	}
	
	/*
	@DataProvider
	public Iterator<Object[]> getLoginTestData() {
		ArrayList<Object[]> testData = Container.getLoginDataFromExcel();
		return testData.iterator();
	}
	
	@Test(dataProvider="getLoginTestData")
	public void verify_Login_form(String username, String password) throws Exception{
		loginPage.verify_Login_form(username, password);
		Reporter.log("User Loggedin Successfully & DashBoard Page Opened", true);
	}
	*/
	
	
	
	
	
	
	
	

}
