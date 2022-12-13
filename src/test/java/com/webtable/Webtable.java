package com.webtable;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Webtable {
	public static WebDriver driver;

	public static void browserLaunch() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\s.vimalraj\\eclipse-workspace\\Adactin_Cucumber\\Driver\\chromedriver_107.exe");
		driver = new ChromeDriver();

		driver.get("https://www.worldometers.info/coronavirus/");
		driver.manage().window().maximize();
	}
		public static void getallData() {
		List<WebElement> table = driver
				.findElements(By.xpath("//table[@id='main_table_countries_today']/tbody[1]/tr/td"));
		for (WebElement a : table) {
			System.out.println(a.getText());

		}
	}

	public static void rowData() {
		List<WebElement> row = driver
				.findElements(By.xpath("//table[@id='main_table_countries_today']/tbody[1]/tr[7]/td"));
		for (WebElement b : row) {
			System.out.println(b.getText());
		}
	}

	public static void columnData() {
		List<WebElement> column = driver
				.findElements(By.xpath("//table[@id='main_table_countries_today']/tbody[1]/tr/td[2]"));
		for (WebElement c : column) {
			System.out.println(c.getText());
		}
	}

	public static void particularData() {
		WebElement particular = driver
				.findElement(By.xpath("//table[@id='main_table_countries_today']/tbody[1]/tr[7]/td[15]"));
		
		System.out.println(particular.getText());
	}

	public static void getHeader() {
List<WebElement> header = driver.findElements(By.xpath("//table[@id='main_table_countries_today']//thead//th"));
	for (WebElement x : header) {
		System.out.println(x.getText());
	}
	}
	
	public static void getHeader_Index() {
		Map<Integer, String> headerMap = new LinkedHashMap<Integer, String>();
		List<WebElement> allHeader = driver.findElements(By.xpath("//table[@id='main_table_countries_today']//thead//tr//th"));
		for (int i = 0; i < allHeader.size(); i++) {
			String header = allHeader.get(i).getText().replace("\n", "");
			headerMap.put(i, header);
		}
	System.out.println(headerMap);
	}
	public static void getColumn_Index() {
		Map<Integer, String> headerMap = new LinkedHashMap<Integer, String>();
		List<WebElement> allColumn = driver.findElements(By.xpath("//table[@id='main_table_countries_today']/tbody[1]/tr/td[2]"));
		for (int i = 0; i < allColumn.size(); i++) {
			String header = allColumn.get(i).getText().replace("\n", "");
			headerMap.put(i, header);
		}
	System.out.println(headerMap);
	}
	

	public static void main(String[] args) {
		browserLaunch();
//		getallData();
//		rowData();
//		columnData();
//		particularData();
//		getHeader();
//		getHeader_Index();
		getColumn_Index();
	}
}
