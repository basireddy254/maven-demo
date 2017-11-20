package com.codebind;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class GmailLoginTest {

	WebDriver driver;

	@Test 
	@Parameters({"browser"})
	public void openBrowser(String browser) {
		if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver","drivers/geckodriver.exe");
			driver = new FirefoxDriver();// to launch the FF browser
		} else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
			driver = new ChromeDriver();// to launch the Chrome browser
		} else {
			System.setProperty("webdriver.ie.driver","driver/IEDriverServer.exe");
			driver = new InternetExplorerDriver();// to launch the IE browser
		}

		driver.get("https://www.gmail.com");// open application
		driver.manage().window().maximize();// to maximize the window 
	}

	@Test(dependsOnMethods = "openBrowser")
	@Parameters("username")
	public void enterValidUsername(String username) throws InterruptedException {
		driver.findElement(By.cssSelector(Locators.GMAIL_USERNAME_CSS)).sendKeys(username);
		driver.findElement(By.cssSelector(Locators.GMAIL_NEXT_CSS)).click();
		Thread.sleep(4000);

	}

	@Test(dependsOnMethods = "enterValidUsername")
	@Parameters("password")
	public void enterInvalidPwd(String password) {
		driver.findElement(By.cssSelector(Locators.GMAIL_PASSWORD_CSS)).sendKeys(password);
		driver.findElement(By.cssSelector(Locators.GMAIL_NEXT_CSS)).click();
	}

	@Test(dependsOnMethods = "enterInvalidPwd")
	public void validateErrorMsg() {
		String errMsg = driver.findElement(By.cssSelector("div[class='dEOOab RxsGPe']")).getText();
		System.err.println(errMsg);
		org.testng.Assert.assertEquals(errMsg, "Wrong password");

	}
	
	@AfterTest
	public void closeBrowser(){
		driver.close();
		
	}

}
