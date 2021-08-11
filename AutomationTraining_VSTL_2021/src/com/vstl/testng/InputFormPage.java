package com.vstl.testng;

import java.util.Properties;

import org.openqa.selenium.By;
import org.testng.Assert;

public class InputFormPage {

	public Properties objconfig;

	private BaseTest objBaseTest;
	
	public InputFormPage(BaseTest baseTest) {
		this.objBaseTest=baseTest;
	}

	public void clickoncloseicononYespleasepopup() {
		objBaseTest.getDriver().findElement(By.xpath("//a[@title='Close']")).click();

	}

	public void selectDropdownHeaderOnTopupMenu(String strDropdownName) {
		By locator = By.xpath(
				"//div[@id='navbar-brand-centered']//li[@class='dropdown']//a[@data-toggle='dropdown'][normalize-space()='"
						+ strDropdownName + "']");
		objBaseTest.getDriver().findElement(locator).click();
	}

	public void selectDropdownValueFromDropdownHeaderTopupMenu(String strDropdownValue) {
		By locator = By.xpath("//ul[@class='dropdown-menu']/li/a[text()='" + strDropdownValue + "']");
		objBaseTest.getDriver().findElement(locator).click();
	}

	public void selectDropDownHeaderandDropdownValuefromTopupMenu(String strDropdownName, String strDropdownValue) {
		this.selectDropdownHeaderOnTopupMenu(strDropdownName);
		this.selectDropdownValueFromDropdownHeaderTopupMenu(strDropdownValue);
	}
	
	public void verifyDemoPageisOpened(String strTitleofthepage) {
		By locator= By.xpath("//h3[text()='" + strTitleofthepage + "']");
		String strActualmsg = objBaseTest.getDriver().findElement(locator).getText();
		Assert.assertTrue(strActualmsg.equals(strTitleofthepage));	
	}

}
