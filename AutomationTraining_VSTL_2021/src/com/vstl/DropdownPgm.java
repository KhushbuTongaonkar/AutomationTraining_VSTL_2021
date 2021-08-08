package com.vstl;

import java.io.FileInputStream;

import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropdownPgm {

	public WebDriver driver = null;
	public Properties objconfigproperties;

	public void loadConfigProperties() {

		objconfigproperties = new Properties();
		try {
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/Config/config.properties");
			objconfigproperties.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void initializewebdriver() {
		this.loadConfigProperties();
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "/External Resources/chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println(objconfigproperties.getProperty("URL"));
		driver.get(objconfigproperties.getProperty("URL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	public void clickoncloseicononYespleasepopup() {
		driver.findElement(By.xpath("//a[@title='Close']")).click();
	}

	public void selectDropdownHeaderOnTopupMenu(String strDropdownName) {
		By locator = By.xpath("//div[@id='navbar-brand-centered']//li[@class='dropdown']//a[@data-toggle='dropdown']");
		List<WebElement> list = driver.findElements(locator);
		for (WebElement webElement : list) {
			String actualDropdownname = webElement.getText();
			if (actualDropdownname.equals(strDropdownName)) {
				webElement.click();
				break;
			}
		}
	}

	public void selectDropdownValueFromDropdownHeaderTopupMenu(String strDropdownValue) {

		By locator = By.xpath("//ul[@class='dropdown-menu']/li/a[text()='"+ strDropdownValue +"']");
		driver.findElement(locator).click();
	}

	public void tc1selectDropDownHeaderandDropdownValuefromTopupMenu(String strDropdownName, String strDropdownValue) {
		this.selectDropdownHeaderOnTopupMenu(strDropdownName);
		this.selectDropdownValueFromDropdownHeaderTopupMenu(strDropdownValue);
	}

	public void verifysingleinputfieldonsimpleformdemo(String strMessage) {
		driver.findElement(By.xpath("//input[@id='user-message']")).sendKeys(strMessage);
		driver.findElement(By.xpath("//button[text()='Show Message']")).click();
		String message = driver.findElement(By.xpath("//span[@id='display']")).getText();
		System.out.println(message);
	}

	public void verifytwoinputfieldsoninputsimpleformdemo(String a, String b) {
		driver.findElement(By.xpath("//input[@id='sum1']")).sendKeys(a);
		driver.findElement(By.xpath("//input[@id='sum2']")).sendKeys(b);
		driver.findElement(By.xpath("//button[text()='Get Total']")).click();
		String sum = driver.findElement(By.xpath("//span[@id='displayvalue']")).getText();
		System.out.println(sum);
	}

	public void closetheactivewindow() {
		driver.close();
	}
}
