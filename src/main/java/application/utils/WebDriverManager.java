package application.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

/**
 * Class used to manage the WebDriver
 * Instantiate a WebDriver corresponding to parameters in config
 * Using PicoContainer for access to other classes
 * @author Yoann DAGAND
 */
public class WebDriverManager {

    /**
     * The WebDriver used for the tests
     */
    private WebDriver driver;

    /**
     * Used Before the test, this method instantiate the WebDriver using the private 'getDriverConfig' method
     */
    public void createDriver() {
        driver = this.getDriverConfig();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(ConfigReader.getProperty("url")); // Lecture dynamique de l'URL
    }

    /**
     * Method used to instantiate the WebDriver,
     * @return WebDriver according to the config
     */
    private WebDriver getDriverConfig() {
        //Determines if the execution of tests is in headless or not
        boolean isHeadless = Boolean.parseBoolean(System.getenv("HL"));
        WebDriver tempDriver;
        //Depending on 'browser' property, change browser used in WebDriver
        switch (System.getenv("BRWSR")) {
            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                if(isHeadless){
                    //To execute in headless
                    edgeOptions.addArguments("--headless");
                }
                tempDriver = new EdgeDriver(edgeOptions);
                break;
            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                if(isHeadless){
                    //To execute in headless
                    firefoxOptions.addArguments("--headless");
                }
                tempDriver = new FirefoxDriver(firefoxOptions);
                break;
            default:
                ChromeOptions chromeOptions = new ChromeOptions();
                if(isHeadless){
                    //To execute in headless
                    chromeOptions.addArguments("--headless");
                }
                tempDriver = new ChromeDriver(chromeOptions);
                break;
        }
        return tempDriver;
    }

    /**
     * Getter for the WebDriver
     * @return The WebDriver
     */
    public WebDriver getWebDriver() {
        return driver;
    }

    /**
     * Used After the test to quit the WebDriver
     */
    public void quit() {
        driver.quit();
    }
}
