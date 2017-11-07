package com.codebind;

import org.testng.annotations.Test;

/**
 * TestNG method will executed on alphabetical order
 */
public class TestExample {

	@Test
	public void btest1() {
		System.out.println("TestExample.test1()");
	}

	@Test(enabled = false)
	public void ctest2() {
		System.out.println("TestExample.test2()");
	}
	@Test
	public void dtest3() {
		System.out.println("TestExample.test3()");
	}
	@Test
	public void atest4() {
		System.out.println("TestExample.test4()");
	}

}
