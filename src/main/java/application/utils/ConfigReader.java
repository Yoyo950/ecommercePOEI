package application.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Class used to read the config file and extract the properties
 * @author Yoann DAGAND
 */
public class ConfigReader {

    /**
     * Where the properties are stocked
     */
    private static final Properties properties;

    static {
        //Instantiate the properties with the config.properties file
        try (FileInputStream fileInputStream = new FileInputStream("src/main/resources/config.properties")) {
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load configuration file");
        }
    }

    /**
     * The getter for properties
     * @param key The key of the property searched
     * @return The property searched
     */
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
