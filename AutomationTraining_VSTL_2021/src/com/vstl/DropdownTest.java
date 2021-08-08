package com.vstl;

public class DropdownTest {

	public static void main(String[] args) {
		
		String strDropdownName="Date pickers";
		String strDropdownValue="Bootstrap Date Picker";
		String strMessage="Testing";
		String a = "10";
		String b = "15";
		
		DropdownPgm objDropdownPgm = new DropdownPgm();
		objDropdownPgm.initializewebdriver();
		objDropdownPgm.clickoncloseicononYespleasepopup();
		objDropdownPgm.tc1selectDropDownHeaderandDropdownValuefromTopupMenu(strDropdownName, strDropdownValue);
	//	objDropdownPgm.verifysingleinputfieldonsimpleformdemo(strMessage);
		//objDropdownPgm.verifytwoinputfieldsoninputsimpleformdemo(a, b);;
		//objDropdownPgm.closetheactivewindow();
	}

}
