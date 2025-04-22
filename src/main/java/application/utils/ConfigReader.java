package application.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Classe utilisée pour lire le config.properties et extraire ses données.
 * @author Yoann DAGAND
 */
public class ConfigReader {

    /**
     * Là où les propriétés sont stockées.
     */
    private static final Properties properties;

    static {
        //Instantie les propriétés via le config.properties
        try (FileInputStream fileInputStream = new FileInputStream("src/main/resources/config.properties")) {
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load configuration file");
        }
    }

    /**
     * Le Getter des propriétés
     * @param key La clé de la propriété recherchée
     * @return La propriété recherchée.
     */
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
