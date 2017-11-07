package com.codebind;

import org.testng.annotations.Test;

/**
 * How to execute same test case with same set of data no.of times
 * ans: using@Test(invocationCount=10)
 */
public class TestngInvocationCount {

	@Test(invocationCount=10)
	public void gmailLogin() {
		System.out.println("gmail login");
	}

}
