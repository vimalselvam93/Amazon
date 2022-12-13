package com.webtable;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Webtable_Dynamic {
	public static WebDriver driver;
	static int PopulationIndex;
	static int CountryIndex;
	
	public static void browserLaunch() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\s.vimalraj\\eclipse-workspace\\Adactin_Cucumber\\Driver\\chromedriver_107.exe");
		driver = new ChromeDriver();
		driver.get("https://www.worldometers.info/coronavirus/");
		driver.manage().window().maximize();
	
}
	
	public static void allHeader() {
		Map<Integer, String> headerMap = new LinkedHashMap<Integer, String>();
		List<WebElement> allHeader = driver.findElements(By.xpath("//table[@id='main_table_countries_today']//thead//tr//th"));
		for (int i = 0; i < allHeader.size(); i++) {
			String header = allHeader.get(i).getText().replace("\n", "");
			headerMap.put(i, header);
			if(header.contains("Country"))	{
				CountryIndex = i;
			}else if (header.equalsIgnoreCase("Population"))	{
				PopulationIndex = i;	
			}
		}
	System.out.println(headerMap);
	}
	
	public static void main(String[] args) {
		browserLaunch();
		allHeader();
	}
}
