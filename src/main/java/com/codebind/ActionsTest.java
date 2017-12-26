package com.codebind;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ActionsTest {
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
		driver.get("https://www.flipkart.com");// open application
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();// to maximize the window
	}

	@Test(dependsOnMethods="openBrowser")
	public void enterValidUsername() throws InterruptedException {
		WebElement ele=driver.findElement(By.xpath("//span[text()='Electronics']"));
		
		Actions act = new Actions(driver);
		act.moveToElement(ele).build().perform();
		act.contextClick(ele).build().perform();
		
		
		
	}

}
