package com.codebind;

import org.testng.annotations.Test;

/**
 * How to run only 2 methods out of 3 methods
 * ans: using@Test(invocationCount=10)
 */
public class TestngMethodsEnable {

	@Test
	public void gmailLogin() {
		System.out.println("gmail login");
	}
	
	@Test
	public void gmailLogin2() {
		System.out.println("gmail login2");
	}
	
	@Test(enabled = false)
	public void gmailLogin3() {
		System.out.println("gmail login3");
	}

}
