package com.mytests;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;



public class BrowserStackBaseTest {
	
	
	WebDriver driver;
	public static final String USERNAME = "ramniwas_NnHdEg";
	public static final String AUTOMATE_KEY = "p2ufnB2TvYX85ucqrjw4";
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";

	@Parameters({"browser", "browser_version", "os", "os_version"})
	@BeforeMethod
	public void setUp(String browserName, String browser_version, String os, String os_version,  Method name) {

		System.out.println("browser name is : " + browserName);
		String methodName = name.getName();

		
		if (browserName.equals("Chrome")) {
			ChromeOptions co = new ChromeOptions();
			co.setPlatformName(os);
			co.setBrowserVersion(browser_version);
			co.setCapability("browserName", "Chrome");
			Map<String, Object> cloudOptions = new HashMap<>();
			cloudOptions.put("os", os);
			cloudOptions.put("osVersion", os_version);
			cloudOptions.put("local", "false");
			cloudOptions.put("buildName", methodName);
			co.setCapability("bstack:options", cloudOptions);
			try {
				driver = new RemoteWebDriver(new URL(URL), co);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			
		} else if (browserName.equals("Firefox")) {
			FirefoxOptions fo = new FirefoxOptions();
			 fo.setPlatformName(os);
			fo.setBrowserVersion(browser_version);
			fo.setCapability("browserName", "Firefox");
			Map<String, Object> cloudOptions = new HashMap<>();
			cloudOptions.put("os", os);
			cloudOptions.put("osVersion", os_version);
			cloudOptions.put("local", "false");
			cloudOptions.put("buildName", methodName);
			fo.setCapability("bstack:options", cloudOptions);
			try {
				driver = new RemoteWebDriver(new URL(URL), fo);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		}
		

	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}
	
	
	

}
