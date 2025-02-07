package com.mqa.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/**
 * This class is the test runner for the regression page feature.
 * It uses TestNG and Cucumber to execute the tests.
 */

@CucumberOptions(
    // Specify the tags to filter the scenarios to be executed
    tags = "@test",
    
    // Specify the feature file to be executed
    features = "./src/test/resources/features/regression.feature",
    
    // Specify the package where the step definitions are located
    glue = "com.mqa.stepdefs",
    
    // Specify the plugins to be used for reporting
    plugin = {
        "summary", // Summary report
        "pretty",  // Pretty report
        "html:target/cucumber-reports.html", // HTML report
        "json:target/cucumber-reports", // JSON report
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" // Extent report
    },
    
    // Set monochrome to true to display the report in a more readable format
    monochrome = true
)

public class LoginPageRunner extends AbstractTestNGCucumberTests {
    // This class does not need any implementation, as it extends AbstractTestNGCucumberTests
}