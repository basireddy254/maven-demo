package com.codebind;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PHPtravels2 {
	WebDriver driver;
	
	@Test()
    @Parameters("browser")
	public void browserOpen(String browser) {
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
	}	
		
	@Test(dependsOnMethods = "browserOpen")
	   public  void openURLandlogin() throws Throwable {
		driver.get("http://www.phptravels.net/supplier");
		driver.manage().window().maximize();
		
		
		driver.findElement(By.xpath("//input[@type=\"text\"]")).sendKeys("supplier@phptravels.com");
		driver.findElement(By.xpath("//input[@type=\"password\"]")).sendKeys("demosupplier");
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		
		
		
		    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	        driver.findElement(By.xpath("//button[@data-target=\"#quickbook\"]")).click();
	 
            Thread.sleep(3000);
			WebElement serv = driver.findElement(By.xpath("//select[@id=\"servicetype\"]"));
			Select service = new Select(serv);
			service.selectByVisibleText("Hotels");
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//div[@class=\"modal-footer\"]/button[@type=\"submit\"]")).click();
			
			driver.findElement(By.xpath("//div[@class=\"col-md-3\"]/input[@name=\"checkin\"]")).sendKeys("09/11/2017");
			driver.findElement(By.xpath("//div[@class=\"col-md-3\"]/input[@name=\"checkout\"]")).sendKeys("10/11/2017");
			
			WebElement cho = driver.findElement(By.xpath("//select[@name=\"item\"]"));
			Select chose = new Select(cho);
			chose.selectByVisibleText(" Hyatt Regency Perth ");
			
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			WebElement roo = driver.findElement(By.xpath("//select[@id=\"poprooms\"]"));
			Select room = new Select(roo);
			room.selectByVisibleText("Standard Room");
			
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			WebElement roocou = driver.findElement(By.xpath("//select[@name=\"roomscount\"]"));
			Select roomcoun = new Select(roocou);
			roomcoun.selectByVisibleText("2");
			
			Thread.sleep(3000);
			
			List<WebElement> sesl = driver.findElements(By.cssSelector("input[type='checkbox']"));
			
			for(int i=0;i<sesl.size();i++) {
				sesl.get(i).click();
			Thread.sleep(3000);
			}
			
			driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
			
			 String parent = driver.getWindowHandle();
			 
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//i[@class=\"fa fa-search-plus\"]")).click();
			
			Set<String> allids = driver.getWindowHandles();
	        System.out.println(allids.size());
	        
		for(String child:allids) {
			if(!(child.equals(parent))) {
				driver.switchTo().window(child);
				System.out.println("in chaild window");
				driver.findElement(By.xpath("//button[@class=\"btn btn-default arrivalpay\"]")).click();
				Thread.sleep(5000);
				driver.switchTo().alert().accept();
				driver.close();
	}
		
		}	
		
		driver.switchTo().window(parent);
		driver.findElement(By.cssSelector("a[class='navbar-brand']")).click();
		driver.quit();
	}
}	
