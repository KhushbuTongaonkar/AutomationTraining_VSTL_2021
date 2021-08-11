package com.vstl.testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class InputFormTest extends BaseTest {

	private InputFormPage objInputFormPage;

	public void initiatepageObject() {
		objInputFormPage = new InputFormPage(this);
	}

	@BeforeClass
	public void setupWebEnviornment() {
		this.initiatepageObject();
		this.initializewebdriver();
	}

	@AfterClass
	public void teardownWebEnviornment() {
		this.closeActiveWebInstance();
	}

	@Test
	public void verifyInputformpageisdisplayed() {
		objInputFormPage.selectDropDownHeaderandDropdownValuefromTopupMenu(this.objconfig.getProperty("DropDownName1"),
				this.objconfig.getProperty("DropDownValue1"));
		objInputFormPage.verifyDemoPageisOpened(this.objconfig.getProperty("ForXpathTitle"));
	}
}