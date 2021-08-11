package com.vstl.testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Annotations {
	
	@BeforeSuite 
	public void beforesuite() {
		System.out.println("BEFORE SUITE");
	}
	
	@AfterSuite
	public void aftersuite() {
		System.out.println("AFTER SUITE");
	}
	@BeforeClass
	public void beforeclass() {
		System.out.println("BEFORE CLASS");
	}
	@AfterClass
	public void afterclass() {
		System.out.println("AFTER CLASS");
	}
	@BeforeTest
	public void beforeTest() {
		System.out.println("BEFORE TEST");
	}
	@AfterTest
	public void afterTest() {
		System.out.println("AFTER TEST");
	}
	@BeforeGroups
	public void beforegroups() {
		System.out.println("BEFORE GROUPS");
	}
	@AfterGroups
	public void aftergroups() {
		System.out.println("AFTER GROUPS");
	}
	@BeforeMethod
	public void beforemethod() {
		System.out.println("BEFORE METHOD");
	}
	@AfterMethod
	public void aftermethod() {
		System.out.println("AFTER METHOD");
	}
	@Test
	public void tc1() {
		System.out.println("TEST 1");
	}
	@Test
	public void tc2() {
		System.out.println("TEST 2");
	}
	

}
