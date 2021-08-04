package com.inputform;

public class InputFieldValidationTest {

	public static void main(String[] args) {

		InputFieldValidationPgm objInputFieldValidationPgm = new InputFieldValidationPgm();

		objInputFieldValidationPgm.initializewebdriver();
		objInputFieldValidationPgm.clickoncloseicononYespleasepopup();

		objInputFieldValidationPgm.tc1selectDropDownHeaderandDropdownValuefromTopupMenu(
				objInputFieldValidationPgm.objconfig.getProperty("DropDownName"),
				objInputFieldValidationPgm.objconfig.getProperty("DropDownValue"));

		objInputFieldValidationPgm.tc2SingleInputFieldDemoValidation(
				objInputFieldValidationPgm.objconfig.getProperty("SingleInputFldDemo"),
				objInputFieldValidationPgm.objconfig.getProperty("Message"),
				objInputFieldValidationPgm.objconfig.getProperty("SingleInputFldButton"),
				objInputFieldValidationPgm.objconfig.getProperty("Message"));

		objInputFieldValidationPgm.tc3TwoInputFieldDemoValidation(
				objInputFieldValidationPgm.objconfig.getProperty("TwoFldInputDemo"),
				objInputFieldValidationPgm.objconfig.getProperty("InputField1"),
				objInputFieldValidationPgm.objconfig.getProperty("Value1"),
				objInputFieldValidationPgm.objconfig.getProperty("InputField2"),
				objInputFieldValidationPgm.objconfig.getProperty("Value2"),
				objInputFieldValidationPgm.objconfig.getProperty("TwoInputFldButton"),
				objInputFieldValidationPgm.objconfig.getProperty("Value1"),
				objInputFieldValidationPgm.objconfig.getProperty("Value2"));

		objInputFieldValidationPgm.closeActiveWebInstance();

	}
}
