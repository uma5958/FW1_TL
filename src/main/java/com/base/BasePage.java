/**
 * @author UmaMaheswararao
 */

package com.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Listeners;

import com.util.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(com.Listeners.WebEventListener.class)
public class BasePage {

	public static Properties prop;
	public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<WebDriver>();

	public BasePage(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialization(){
		String browserName = prop.getProperty("browser");

		if(browserName.equalsIgnoreCase("chrome")){
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");	
			setDriver(new ChromeDriver());
		}
		else if(browserName.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");	
			System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE,"true");
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"C:\\temp\\logs.txt");
			setDriver(new FirefoxDriver());
		} 
		else if(browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			setDriver(new EdgeDriver());
		}
		else if(browserName.equalsIgnoreCase("headlessChrome")) {
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");	
			ChromeOptions options = new ChromeOptions();  
			options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors");  
			setDriver(new ChromeDriver(options));
		}

		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		getDriver().manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		getDriver().manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		getDriver().get(prop.getProperty("url"));
	}	


	public static WebDriver getDriver() {
		return tldriver.get();
	}

	public static void setDriver(WebDriver driver) {
		tldriver.set(driver);
	}
	
	public static void start()  {
		if(getDriver()==null)
			try {
			new BasePage();
			}
		catch(Exception e) {
			
		}
	}

	public static void quit() {
		if(getDriver()!=null) {
			getDriver().quit();
		}
	}
	
	
	
	



}
