package com.inputform;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InputFieldValidationPgm {

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
		By locator = By.xpath("//ul[@class='dropdown-menu']/li/a[text()='" + strDropdownValue + "']");
		driver.findElement(locator).click();
	}

	public void verifyInputFormPageisOpened() {
		WebElement page = driver
				.findElement(By.xpath("//h3[text()='This would be your first example to start with Selenium.']"));
		if (page.isDisplayed()) {
			System.out.println("Simple Input Form Demo Page is opened as expected ");
		} else {
			System.out.println("Simple Input Form Demo Page is not opened ");
		}
	}

	public void tc1selectDropDownHeaderandDropdownValuefromTopupMenu(String strDropdownName, String strDropdownValue) {
		this.selectDropdownHeaderOnTopupMenu(strDropdownName);
		this.selectDropdownValueFromDropdownHeaderTopupMenu(strDropdownValue);
		this.verifyInputFormPageisOpened();
	}

	public void verifyInputfielddemoavailableonInputFormPage(String strInputFielDemodHeader) {

		WebElement fielddemo = driver.findElement(By.xpath(
				"//h3[text()='This would be your first example to start with Selenium.']/following-sibling::div/div[text()='"
						+ strInputFielDemodHeader + "']"));
		if (fielddemo.isDisplayed()) {
			System.out.println(strInputFielDemodHeader + " demo is available on Input Form Page as expected");
		} else {
			System.out.println(strInputFielDemodHeader + " demo is not available on Input Form Page");
		}

	}

	public void provideInputMessageforSingleInputFieldValidation(String strInputMessage) {
		driver.findElement(By.xpath("//label[text()='Enter message']/following-sibling :: input[@id='user-message']"))
				.sendKeys(strInputMessage);
	}

	public void clickOnButtonforInputFieldValidation(String strButtonName) {

		WebElement button = driver.findElement(By.xpath(
				"//label[text()='Enter message']/following-sibling :: input[@id='user-message']/following :: button[text()='"
						+ strButtonName + "']"));
		button.click();
	}

	public void verifyYourMessageforSingleInputFieldValidation(String strExpectedMsg) {

		String strActualMsg = driver
				.findElement(By.xpath("//label[text()='Your Message: ']/following-sibling :: span[@id='display']"))
				.getText();
		System.out.println("Input Message provided by user is : " + strActualMsg);
		if (strExpectedMsg.equals(strActualMsg)) {
			System.out.println("Single Input Field Validation Successful");
		} else {
			System.out.println("Single Input Field Validation Failed");
		}

	}

	public void tc2SingleInputFieldDemoValidation(String strInputFielDemodHeader, String strInputMessage,
			String strButtonName, String strExpectedMsg) {
		this.verifyInputfielddemoavailableonInputFormPage(strInputFielDemodHeader);
		this.provideInputMessageforSingleInputFieldValidation(strInputMessage);
		this.clickOnButtonforInputFieldValidation(strButtonName);
		this.verifyYourMessageforSingleInputFieldValidation(strExpectedMsg);
	}

	public void provideInputValueforTwoInputFieldValidation(String strInputValueField, String strInputValue) {
		WebElement inputValue = driver.findElement(
				By.xpath("//form[@id='gettotal']//label[text()='" + strInputValueField + "']/following :: input[1]"));
		inputValue.sendKeys(strInputValue);
	}

	public String getTotalofTwoInputFields () {
		String strTotal = driver.findElement(By.xpath("//button[text()='Get Total']//following:: label[text()=' Total a + b = ']/following :: span[@id='displayvalue']")).getText();
		return strTotal; 	
		}

	
	public void verifytotalofTwoInputFields(String strValue1, String strValue2) { 
		int expectedTotal = Integer.parseInt(strValue1)+Integer.parseInt(strValue2);
		String actualTotal = this.getTotalofTwoInputFields();
		System.out.println("Total of 2 values : "+actualTotal);
		if (expectedTotal == Integer.parseInt(actualTotal)) {
			System.out.println("Total of two input fields is matching");
		} else {
			System.out.println("Total of two input fields is not matching");
		}
		
	}

	public void tc3TwoInputFieldDemoValidation (String strInputFielDemodHeader,String strInputValueField1,String strInputValue1,String strInputValueField2, String strInputValue2, String strButtonName,String strValue1, String strValue2 ) {
	this.verifyInputfielddemoavailableonInputFormPage(strInputFielDemodHeader);
	this.provideInputValueforTwoInputFieldValidation(strInputValueField1, strInputValue1);
	this.provideInputValueforTwoInputFieldValidation(strInputValueField2, strInputValue2);
	this.clickOnButtonforInputFieldValidation(strButtonName);
	this.verifytotalofTwoInputFields(strValue1,strValue2 );
		
	}
		
	
	
	
	public void closeActiveWebInstance() {
		driver.close();
		System.out.println("Simple Input Form Page validation is completed ");

	}
}
