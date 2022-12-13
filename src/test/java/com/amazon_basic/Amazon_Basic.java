package com.amazon_basic;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Amazon_Basic {
	public static WebDriver driver;

	public static void searchToys() throws AWTException, IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\s.vimalraj\\eclipse-workspace\\Amazon\\Driver\\chromedriver_107.exe");

		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		
		WebElement all = driver.findElement(By.id("searchDropdownBox"));
		Select s = new Select(all);
		s.selectByValue("search-alias=baby");
		
		WebElement searchbox = driver.findElement(By.name("field-keywords"));
		searchbox.sendKeys("soft toys");
		
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
	
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		Thread.sleep(5000);
		TakesScreenshot ts = (TakesScreenshot) driver;
		File a = ts.getScreenshotAs(OutputType.FILE);
		File b = new File("C:\\Users\\s.vimalraj\\eclipse-workspace\\Amazon\\Screenshot\\amazon.png");
		FileUtils.copyFile(a, b);
		
	}
	public static void main(String[] args) throws AWTException, IOException, InterruptedException {
		searchToys();
	}
}
