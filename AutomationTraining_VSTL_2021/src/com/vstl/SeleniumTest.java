package com.vstl;

public class SeleniumTest {

	public static void main(String[] args) {
	
		
		SeleniumPgm objSelenium1= new SeleniumPgm();
		objSelenium1.InitiateWebdriver();
		objSelenium1.SalefishHandson();
		objSelenium1.TeardownEnv();

}
}