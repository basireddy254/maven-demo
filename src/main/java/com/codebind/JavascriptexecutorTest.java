package com.codebind;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class JavascriptexecutorTest {
	static WebDriver driver;

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
		driver.get("https://www.hdfc.com/");// open application
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();// to maximize the window
	}

	@Test
	public void javaScriptOperations() throws InterruptedException {
		openBrowser("chrome");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		 // js.executeScript("window.scrollBy(0,400)");//using x and y coordinates
		  //js.executeScript("window.scrollBy(0,document.body.scrollHeight)");//scrolling till bottom of the page
		
		  WebElement ele=driver.findElement(By.linkText("Training Center"));
		  js.executeScript("arguments[0].scrollIntoView(true);", ele);//scroll using webelements
		  js.executeScript("arguments[0].click();", ele);//click using js
		  
		  
		  
		
	}

}
