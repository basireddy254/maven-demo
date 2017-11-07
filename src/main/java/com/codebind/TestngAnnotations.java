package com.codebind;


import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * TestNG annotations
 * 
 */
public class TestngAnnotations {
	
	@BeforeSuite
	public void beforeSuite(){
		System.out.println("Before Suite");
	}
	
	@AfterSuite
	public void afterSuite(){
		System.out.println("After Suite");
	}
	
	@BeforeTest
	public void beforeTest(){
		System.out.println("Before Test");
	}
	
	@AfterTest
	public void afterTest(){
		System.out.println("After Test");
	}

	@BeforeClass
	public void beforeClass(){
		System.out.println("Before class");
	}
	
	@AfterClass
	public void afterClass(){
		System.out.println("Afer class");
	}
	
	@Test
	public void gmailLogin() {
		System.out.println("gmail login");
	}
	
	@Test
	public void gmailLogin2() {
		System.out.println("gmail login2");
	}
	
	@AfterMethod
	public void afterMethod(){
		System.out.println("After method");
	}
	
	@BeforeMethod
	public void beforeMethod(){
		System.out.println("Before method");
	}
}
