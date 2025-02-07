# Functional Web Automation 

## Prerequisities 

Ensure you have Java Development Kit (JDK) (JDK 8 or later) and Apache Maven (3.6 or later) installed on your machine.By having these prerequisites installed and configured correctly, you'll be able to build and run your project successfully.


## Project Overview

This project implements a Java-based Selenium automation testing framework, leveraging Cucumber for behavior-driven development, TestNG for test execution, JUnit for assertions, and Extent Reports for comprehensive reporting.


Test Scenarios

The project features a single Cucumber feature file containing seven test scenarios:

	1.Invalid Login: Attempt to log in with an incorrect password.
	2.Valid Login: Log in with a correct password.
	3. A locked out user cannot login
	4.User clicks Login without entering username and password
	5.A Test to show failure case
	6.User wants to filter inventory by Name (Z to A)
	7.User wants to filter inventory by Price (high to low)
	
	
Reporting

Upon test execution, the framework generates an Extent Report, which includes:

	*Step-by-step test execution details
	*Screenshot attachments for visual verification
	
To view the generated report, simply refresh your project (F5) to access the newly created report folder.

## Installation

To run this project on your machine, follow these steps:

	1.Clone the repository: Download a copy of this project onto your local machine.
	2.Verify Maven installation: Ensure you have Apache Maven installed on your machine.
	3.Open in IDE: Import the project into your preferred Integrated Development Environment (IDE), such as VSCode or Eclipse.
	4.Install dependencies: Open the project terminal and run the command mvn install to install the required project dependencies.
	5.Run the tests: To execute the test scenarios, type mvn verify in the project terminal.
	6.Test execution: The tests will run automatically using the Chrome Test Browser (chromedriver), executing the predefined test scenarios.



