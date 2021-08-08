package com.radiobuttonvalidation;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButtonDemoPgm {

	public WebDriver driver;
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

	public void initializeWebInstance() {
		this.loadConfigProperties();
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "/External Resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(objconfig.getProperty("URL"));

	}

	public void clickoncloseicononYespleasepopup() {
		driver.findElement(By.xpath("//a[@title='Close']")).click();

	}

	// Single Modular Function to select DropDownHeader
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

	// Single Modular Function to select DropDownValue
	public void selectDropdownValueFromDropdownHeaderTopupMenu(String strDropdownValue) {
		By locator = By.xpath("//ul[@class='dropdown-menu']/li/a[text()='" + strDropdownValue + "']");
		driver.findElement(locator).click();
	}

	// Single Modular function for Demo Page Title
	public void verifyDemoPageisOpened(String strTitleofthepage) {
		WebElement demopage = driver.findElement(By.xpath("//h3[text()='" + strTitleofthepage + "']"));
		if (demopage.isDisplayed()) {
			System.out.println(demopage.getText() + "is opened");
		} else {
			System.out.println("Expected page is not opened");
		}
	}

	public void verifyRadioButtonDemoPageisOpenedwhenRadiobuttonDemoselectedfromDropDown(String strDropdownName,
			String strDropdownValue, String strTitleofthepage) {
		this.selectDropdownHeaderOnTopupMenu(strDropdownName);
		this.selectDropdownValueFromDropdownHeaderTopupMenu(strDropdownValue);
		this.verifyDemoPageisOpened(strTitleofthepage);

	}

	public void verifyRadioButtonDemoAvailableonOpenedDemoPage(String strTitleofthepage, String strDemoHeader) {
		WebElement demoheader = driver.findElement(
				By.xpath("//h3[text()='" + strTitleofthepage + "']//following :: div[text()='" + strDemoHeader + "']"));
		if (demoheader.isDisplayed()) {
			System.out.println(demoheader.getText() + " is available on Radio Button Demo page");
		} else {
			System.out.println("Expected demo is not available on Radio Button Demo page");
		}
	}

	public boolean isRadioButtonSelectedforDemo(String strRadiobuttonType, String strRadiobuttonValue) {
		boolean radiobuttonflag = false;
		WebElement radiobutton = driver.findElement(By.xpath(
				"//input[@type='radio' and @name='" + strRadiobuttonType + "'][@value='" + strRadiobuttonValue + "']"));
		radiobutton.isSelected();
		return radiobuttonflag;
	}

	public void selectRadioButtononRadioButtonDemoPage(String strRadiobuttonType, String strRadiobuttonValue) {
		if (!isRadioButtonSelectedforDemo(strRadiobuttonType, strRadiobuttonValue)) {
			WebElement radiobutton = driver.findElement(By.xpath("//input[@type='radio' and @name='"
					+ strRadiobuttonType + "'][@value='" + strRadiobuttonValue + "']"));
			radiobutton.click();
		} else {
			System.out.println("Radio button is already selected ");
		}
	}

	public void clickOnButtontotoGetSelectedRadioButtonValue(String strGetValueButtonName) {
		driver.findElement(By.xpath("//button[@type='button' and text()='" + strGetValueButtonName + "']")).click();
		;
	}

	public void verifyRadioButtonSelectedValue(String strOutputClass, String strExpectedMsg) {
		String strActualMsg = driver.findElement(By.xpath("//p[@class='" + strOutputClass + "']")).getText();
		System.out.println(strActualMsg);
		if (strExpectedMsg.equals(strActualMsg)) {
			System.out.println("Radio button Validation Successful");
		} else {
			System.out.println("Radio button Validation Failed");
		}

	}

	public void verificationofRadioButtonDemo(String strTitleofthepage, String strDemoHeader, String strRadiobuttonType,
			String strRadiobuttonValue, String strGetValueButtonName, String strOutputClass, String strExpectedMsg) {
		this.verifyRadioButtonDemoAvailableonOpenedDemoPage(strTitleofthepage, strDemoHeader);
		this.selectRadioButtononRadioButtonDemoPage(strRadiobuttonType, strRadiobuttonValue);
		this.clickOnButtontotoGetSelectedRadioButtonValue(strGetValueButtonName);
		this.verifyRadioButtonSelectedValue(strOutputClass, strExpectedMsg);
	}

	public void verificationofGroupRadioButtonDemo(String strTitleofthepage, String strDemoHeader,
			String strRadiobuttonType1, String strRadiobuttonValue1, String strRadiobuttonType2,
			String strRadiobuttonValue2, String strGetValueButtonName, String strOutputClass1, String strExpectedMsg1) {
		this.verifyRadioButtonDemoAvailableonOpenedDemoPage(strTitleofthepage, strDemoHeader);
		this.selectRadioButtononRadioButtonDemoPage(strRadiobuttonType1, strRadiobuttonValue1);
		this.selectRadioButtononRadioButtonDemoPage(strRadiobuttonType2, strRadiobuttonValue2);
		this.clickOnButtontotoGetSelectedRadioButtonValue(strGetValueButtonName);
		this.verifyRadioButtonSelectedValue(strOutputClass1, strExpectedMsg1);

	}

	public void closeWebInstance() {
		driver.close();
		System.out.println("Radio button Demo validation is completed ");
	}

}
