package com.mqa.stepdefs;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.mqa.managers.DriverManager;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

/**
 * This class contains hooks that are executed before and after each scenario.
 */
public class Hooks {

    // Static WebDriver instance
    public static WebDriver driver;

    /**
     * Setup method that is executed before each scenario.
     * It initializes the WebDriver instance if it's null.
     */
    @Before
    public void setup() {
        // Check if the driver instance is null
        if (driver == null) {
            // Get the WebDriver instance from DriverManager
            driver = DriverManager.getDriver();
        }
    }

    /**
     * Method that is executed after each step.
     * It takes a screenshot and attaches it to the scenario.
     */
    @AfterStep
    public static void takeScreenshot(Scenario scenario) {
        // Take a screenshot as a byte array
        final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        // Attach the screenshot to the scenario
        scenario.attach(screenshot, "image/png", "image");
    }

    /**
     * Teardown method that is executed after each scenario.
     * It closes the WebDriver instance.
     */
    @After
    public static void tearDown() {
        // Check if the driver instance is not null
        if (driver != null) {
            // Close the WebDriver instance
            driver.quit();
            // Set the driver instance to null
            driver = null;
        }
    }
}