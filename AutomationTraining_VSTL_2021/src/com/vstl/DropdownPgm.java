package com.vstl;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropdownPgm {

	public WebDriver driver = null;

	public void initializewebdriver() {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "/External Resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.seleniumeasy.com/test/");
		driver.manage().window().maximize();

	}

	public void clickoncloseicononYespleasepopup() {
		driver.findElement(By.xpath("//a[@title='Close']")).click();
	}

	public void gettheListofDropdownHeaderOnTopupMenu() {
		By locator = By.xpath("//div[@id='navbar-brand-centered']//li[@class='dropdown']//a[@data-toggle='dropdown']");
		List<WebElement> list = driver.findElements(locator);
		for (WebElement webElement : list) {
			System.out.println("DropdownValues " + webElement.getText());
		}
	}

	public void selectDropdownHeaderOnTopupMenu(String strDropdownName) {
		// here i wanted to call previous method inside this method

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

	public void selectDropDownHeaderandDropdownValuefromTopupMenu(String strDropdownName, String strDropdownValue) {
		this.selectDropdownHeaderOnTopupMenu(strDropdownName);
		this.selectDropdownValueFromDropdownHeaderTopupMenu(strDropdownValue);
	}
}
