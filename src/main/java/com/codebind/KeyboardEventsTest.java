package com.codebind;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class KeyboardEventsTest {
	static WebDriver driver;

	@Test
	@Parameters("browser")
	public void openBrowser(String browser) {
		if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\UC202376\\git\\new\\1p-ui-automation\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();// to launch the FF browser
		} else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\UC202376\\git\\new\\1p-ui-automation\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();// to launch the Chrome browser
		} else {
			System.setProperty("webdriver.ie.driver",
					"C:\\Users\\UC202376\\git\\new\\1p-ui-automation\\drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();// to launch the IE browser
		}

		driver.get("https://www.gmail.com");// open application
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();// to maximize the window
	}

	@Test(dependsOnMethods="openBrowser")
	public void enterValidUsername() throws Exception {
		driver.findElement(By.cssSelector("input#identifierId")).sendKeys("asdfasflkjasklfjaskdkfadsfasd");
		String keyboardAc=Keys.chord(Keys.CONTROL,"a",Keys.DELETE);
		
		driver.findElement(By.cssSelector("input#identifierId")).sendKeys(keyboardAc);
		
		driver.findElement(By.cssSelector("input#identifierId")).sendKeys("chinnareddy.putha");
		driver.findElement(By.cssSelector("span[class='RveJvd snByac']")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("input[aria-label='Enter your password']"))));
		
		driver.findElement(By.cssSelector("input[aria-label='Enter your password']")).sendKeys("afasf");
		driver.findElement(By.cssSelector("span[class='RveJvd snByac']")).click();
		String errMsg=driver.findElement(By.cssSelector("div[class='dEOOab RxsGPe']")).getText();
		
		if(!errMsg.contains("resetdfds")){
			throw new Exception("Error message doesn't have 'reset' button");
		}
	}

}
