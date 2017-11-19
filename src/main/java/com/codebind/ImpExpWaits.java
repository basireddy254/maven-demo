package com.codebind;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ImpExpWaits {
	static WebDriver driver;

	@Test
	@Parameters("browser")
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
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		driver.manage().window().maximize();// to maximize the window
	}

	@Test(dependsOnMethods="openBrowser")
	public void enterValidUsername() throws InterruptedException {
		driver.findElement(By.cssSelector("input[id='identifierId']")).sendKeys("java");
		
		WebDriverWait wait = new WebDriverWait(driver, 15,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='ZFr60d CeoRYcasdfasf']")));
		
		driver.findElement(By.cssSelector("div[class='123ZFr60d CeoRYc']")).click();
	}

}
