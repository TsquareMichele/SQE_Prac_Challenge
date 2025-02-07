package config;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * This class reads properties from a configuration file.
 */
public class PropertiesFile {

    /**
     * Reads the properties file and returns the value of the "url" property.
     * 
     * @return The value of the "url" property
     */
    public String readPropertiesFile() {
        // Initialize the URL variable
        String url = null;

        // Specify the location of the properties file
        String fileLocation = "/Users/tmichele/Downloads/mqa-selenium-cucumber-testng-main/src/test/java/config/config.properties";

        // Create a new Properties object
        Properties prop = new Properties();

        try {
            // Create an input stream to read the properties file
            InputStream input = new FileInputStream(fileLocation);

            // Load the properties from the file
            prop.load(input);

            // Get the value of the "url" property
            url = prop.getProperty("url");
        } catch (Exception e) {
            // Print the exception message if an error occurs
            e.printStackTrace();
        }

        // Return the URL value
        return url;
    }
}