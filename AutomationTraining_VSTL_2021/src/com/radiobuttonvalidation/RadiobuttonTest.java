package com.radiobuttonvalidation;

public class RadiobuttonTest {

	public static void main(String[] args) {

		RadioButtonDemoPgm objRadioButtonDemoPgm = new RadioButtonDemoPgm();

		objRadioButtonDemoPgm.initializeWebInstance();
		objRadioButtonDemoPgm.clickoncloseicononYespleasepopup();

		objRadioButtonDemoPgm.verifyRadioButtonDemoPageisOpenedwhenRadiobuttonDemoselectedfromDropDown(
				objRadioButtonDemoPgm.objconfig.getProperty("DropDownName1"),
				objRadioButtonDemoPgm.objconfig.getProperty("DropDownValue3"),
				objRadioButtonDemoPgm.objconfig.getProperty("RadioButtonTitle"));

		objRadioButtonDemoPgm.verificationofRadioButtonDemo(
				objRadioButtonDemoPgm.objconfig.getProperty("RadioButtonTitle"),
				objRadioButtonDemoPgm.objconfig.getProperty("RadioDemo1"),
				objRadioButtonDemoPgm.objconfig.getProperty("RadioButtontype1"),
				objRadioButtonDemoPgm.objconfig.getProperty("Gender1"),
				objRadioButtonDemoPgm.objconfig.getProperty("GetvalueButton1"),
				objRadioButtonDemoPgm.objconfig.getProperty("Classname1"),
				objRadioButtonDemoPgm.objconfig.getProperty("RadioButtonResult1"));

		objRadioButtonDemoPgm.verificationofGroupRadioButtonDemo(
				objRadioButtonDemoPgm.objconfig.getProperty("RadioButtonTitle"),
				objRadioButtonDemoPgm.objconfig.getProperty("RadioDemo2"),
				objRadioButtonDemoPgm.objconfig.getProperty("RadioButtontype2"),
				objRadioButtonDemoPgm.objconfig.getProperty("Gender1"),
				objRadioButtonDemoPgm.objconfig.getProperty("RadioButtontype3"),
				objRadioButtonDemoPgm.objconfig.getProperty("AgeGroup1"),
				objRadioButtonDemoPgm.objconfig.getProperty("GetValueButton2"),
				objRadioButtonDemoPgm.objconfig.getProperty("Classname2"),
				objRadioButtonDemoPgm.objconfig.getProperty("GrpRadioButtonResult1"));
		
		
		objRadioButtonDemoPgm.closeWebInstance();

	}
}