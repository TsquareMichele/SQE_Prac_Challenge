package com.mqa.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
/**
 * This class is responsible for managing the WebDriver instance.
 */
public class DriverManager {
	/**
     * Static WebDriver instance.
     */
	public static WebDriver driver;
    /**
     * Returns the WebDriver instance. If the instance doesn't exist, it creates a new one.
     * 
     * @return WebDriver instance
     */
	public static WebDriver getDriver() {
		// Setting up Chrome driver
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
		driver = new ChromeDriver();	
		return driver;
	}
	
}
