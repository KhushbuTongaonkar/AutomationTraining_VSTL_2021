package com.vstl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class SeleniumPgm {
	
	public WebDriver driver = null;
	
	public void InitiateWebdriver() {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/External Resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://salefish.salefish.ca/");
		driver.manage().window().maximize();
	}
	
	public void SalefishHandson() {
		
		String url = driver.getCurrentUrl();
		System.out.println("URL of the opened webpage is " +url);
		
		driver.navigate().refresh();
		System.out.println("Page is refreshed");
		
		String title = driver.getTitle();
		System.out.println("Title of the opened webpage is "  + title);
		
		driver.navigate().to("http://lmtest.salefish.ca/");
		
		String url1 = driver.getCurrentUrl();
		System.out.println("URL of the opened webpage is " + url1);
	
		String title1= driver.getTitle();
		System.out.println("Title of the opened webpage is " + title1);
	
		driver.navigate().back();
		System.out.println("Navigated back and Url of the opened webpage is "  + driver.getCurrentUrl());
		
	}
	
	public void TeardownEnv() {
		driver.close();
			}
	

}

