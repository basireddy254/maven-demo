package com.codebind;

import org.testng.annotations.Test;

/**
 * How to execute 10th method at first place and 1st method at 10th place
 * ans: using @Test(priority=3)
 */
public class TestngPriority {

	@Test(priority=3)
	public void method1() {
		System.out.println("method1");
	}

	@Test(priority=1)
	public void method2() {
		System.out.println("method2");
	}

	@Test(priority=2)
	public void method3() {
		System.out.println("method3");
	}

	@Test(priority=0)
	public void method4() {
		System.out.println("method4");
	}

}
