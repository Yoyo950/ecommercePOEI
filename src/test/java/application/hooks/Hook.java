package application.hooks;

import application.utils.WebDriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.net.MalformedURLException;

public class Hook {

    private final WebDriverManager webDriverManager;

    /**
     * Constructor of class, used
     * @param webDriverManager WebDriverManager obtained with PicoContainer
     */
    public Hook(WebDriverManager webDriverManager) {
        this.webDriverManager = webDriverManager;
    }

    /**
     * The method setting up the driver for the tests, executed before each test.
     */
    @Before
    public void setUp() throws MalformedURLException {
        this.webDriverManager.createDriver();
    }

    /**
     * The method tearing down the driver, executed after each test.
     */
    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) this.webDriverManager.getWebDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        this.webDriverManager.quit();
    }





}
