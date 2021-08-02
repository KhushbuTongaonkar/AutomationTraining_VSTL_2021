package com.vstl;

public class DropdownTest {

	public static void main(String[] args) {
		
		
		String strDropdownName ="List Box";
		String strDropdownValue = "Data List Filter";
		DropdownPgm objDropdownPgm = new DropdownPgm();
		objDropdownPgm.initializewebdriver();
		objDropdownPgm.clickoncloseicononYespleasepopup();
		objDropdownPgm.gettheListofDropdownHeaderOnTopupMenu();
		objDropdownPgm.selectDropDownHeaderandDropdownValuefromTopupMenu(strDropdownName, strDropdownValue);
	}

}
