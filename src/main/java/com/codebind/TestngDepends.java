package com.codebind;

import org.testng.annotations.Test;

/**
 * TestNG methods will be depends using 'dependsOnMethods' attribute
 * TestNG annotation attributes are alwaysRun,dependsOnMethods
 */
public class TestngDepends {

	@Test(alwaysRun=true)
	public void gmailLogin() {
		System.out.println("Gmail login");
	}

	@Test(dependsOnMethods="gmailLogin")
	public void composeMail() {
		System.out.println("compose mail");
	}
	@Test(dependsOnMethods="composeMail")
	public void deleteMail() {
		System.out.println("Delete Mail");
	}
	@Test(dependsOnMethods="deleteMail")
	public void logout() {
		System.out.println("Logout mail");
	}

}
