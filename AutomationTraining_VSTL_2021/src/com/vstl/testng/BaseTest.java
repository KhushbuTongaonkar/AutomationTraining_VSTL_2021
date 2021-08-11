package com.vstl.testng;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

	public WebDriver driver = null;
	public Properties objconfig;

	public void loadConfigProperties() {
		objconfig = new Properties();
		try {
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/Config/config.properties");
			objconfig.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void initializewebdriver() {
		this.loadConfigProperties();
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "/External Resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(objconfig.getProperty("URL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	public void closeActiveWebInstance() {
		driver.close();
		System.out.println("Test execution is completed ");

	}
	
	
}
