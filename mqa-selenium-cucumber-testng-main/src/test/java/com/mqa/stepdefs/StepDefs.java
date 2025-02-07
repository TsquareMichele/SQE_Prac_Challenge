package com.mqa.stepdefs;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import config.PropertiesFile;


/**
 * This class contains step definitions for the login and inventory features.
 */
public class StepDefs {
	
	// Initialize the PropertiesFile class to read the properties file
	PropertiesFile prop = new PropertiesFile();
	// Read the URL from the properties file
	String url = prop.readPropertiesFile();
	
	// Initialize the WebDriver instance
	public static WebDriver driver;
    /**
     * Step definition for the "The user is on the login screen" step.
     */
	@Given("The user is on the login screen")
	public void user_is_on_the_login_screen() {	
		// Get the WebDriver instance from the Hooks class
		driver = Hooks.driver;
		// Navigate to the login page
		driver.get(url);
        // Set the implicit wait timeout
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Verify that the username field is displayed
        WebElement usernameTextBox = driver.findElement(By.id("user-name"));
        assertEquals("User is on the Home Page", usernameTextBox.isDisplayed(), true);
    }

    /**
     * Step definition for the "the user enters {string} in username input field" step.
     * 
     * @param strUsername The username to enter
     */
    @When("the user enters {string} in username input field")
    public void user_enters_in_username_field(String strUsername) {
        // Find the username field
        WebElement usernameTextBox = driver.findElement(By.id("user-name"));
        // Click on the username field
        usernameTextBox.click();
        // Clear the username field
        usernameTextBox.clear();
        // Enter the username
        usernameTextBox.sendKeys(strUsername);
    }
    
    /**
     * Step definition for the "the user enters {string} in the password input field" step.
     * 
     * @param strPassword The password to enter
     */
    @When("the user enters {string} in the password input field")
    public void the_user_enters_in_the_password_field(String strPassword) {
        // Find the password field
        WebElement passwordTextBox = driver.findElement(By.id("password"));
        // Click on the password field
        passwordTextBox.click();
        // Clear the password field
        passwordTextBox.clear();
        // Enter the password
        passwordTextBox.sendKeys(strPassword);
    }
	
    /**
     * Step definition for the "the user clicks the Log in button" step.
     */
    @When("the user clicks the Log in button")
    public void user_clicks_the_log_in_button() {
        // Find the login button
        WebElement signInButton = driver.findElement(By.id("login-button"));
        // Click on the login button
        signInButton.click();
        // Wait for 4 seconds
        Wait(4000);
    }

    /**
     * Step definition for the "the inventory page is displayed" step.
     */
    @Then("the inventory page is displayed")
    public void inventory_page_is_displayed() {
        // Find the page title
        WebElement pageTitle = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span"));
        // Verify that the page title matches "Products"
        assertEquals("User is on the Product Page", pageTitle.getText().matches("Products"), true);
    }
	
    /**
     * Step definition for the "the system displays an error message" step.
     */
    @Then("the system displays an error message")
    public void system_displays_an_error() {
        // Find the error message
        WebElement errorMessage = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3"));
        // Print the error message
        System.out.println(errorMessage.getText());
        // Verify that the error message matches the expected text
        assertEquals("Error message displayed", errorMessage.getText().contains("Epic sadface: Username and password do not match any user in this service"), true);
    }
	
    /**
     * Step definition for the "the user clicks on the hamburger menu" step.
     */
    @When("the user clicks on the hamburger menu")
    public void user_clicks_the_hamburger_menu() {
        // Find the hamburger menu button
        WebElement signInButton = driver.findElement(By.id("react-burger-menu-btn"));
        // Click on the hamburger menu button
        signInButton.click();
        // Wait for 2 seconds
        Wait(2000);
    }
	
    /**
     * Step definition for the "the user clicks on Logout link" step.
     */
    @Then("the user clicks on Logout link")
    public void user_clicks_logout_link() {
        // Find the logout link
        WebElement signInButton = driver.findElement(By.id("logout_sidebar_link"));
        // Click on the logout link
        signInButton.click();
        // Wait for 2 seconds
        Wait(2000);
    }

    /**
     * Step definition for the "the system displays an locked out error message" step.
     */
    @Then("the system displays an locked out error message")
    public void system_displays_an_locked_out_error() {
        // Find the error message
        WebElement errorMessage = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3"));
        // Print the error message
        System.out.println(errorMessage.getText());
        // Verify that the error message matches the expected text
        assertEquals("Error message displayed", errorMessage.getText().contains("Epic sadface: Sorry, this user has been locked out."), true);
    }

    /**
     * Step definition for the "the system displays username required error message" step.
     */
    @Then("the system displays username required error message")
    public void system_displays_username_required_error() {
        // Find the error message
        WebElement errorMessage = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3"));
        // Print the error message
        System.out.println(errorMessage.getText());
        // Verify that the error message matches the expected text
        assertEquals("Error message displayed", errorMessage.getText().contains("Epic sadface: Username is required"), true);
    }

    /**
     * Step definition for the "the user selects the filter dropdown" step.
     */
    @When("the user selects the filter dropdown")
    public void user_clicks_filter_dropdown() {
        // Find the filter dropdown
        WebElement signInButton = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select"));
        // Click on the filter dropdown
        signInButton.click();
        // Wait for 1 second
        Wait(1000);
    }

    /**
     * Step definition for the "user selects the filter option {string}" step.
     * 
     * @param dropDownOption The filter option to select
     */
    @Then("user selects the filter option {string}")
    public void user_selects_dropdown_option(String dropDownOption) {
        // Create a new Select object for the filter dropdown
        Select dropdown = new Select(driver.findElement(By.className("product_sort_container")));
        // Select the specified filter option
        dropdown.selectByValue(dropDownOption);
        // Wait for 2 seconds
        Wait(2000);
    }


    /**
     * Method to wait for a specified amount of time.
     * 
     * @param ms The time to wait in milliseconds
     */
    public void Wait(int ms) {
        try {
            // Wait for the specified amount of time
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            // Print the exception message
            e.printStackTrace();
        }
    }
}