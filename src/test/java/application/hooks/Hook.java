package application.hooks;

import application.utils.WebDriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.net.MalformedURLException;

/**
 * La classe définissant les Hook utilisés pour les tests
 * @author Yoann DAGAND
 */
public class Hook {

    /**
     * Le WebDriverManager, nous permettant de gérer le driver
     */
    private final WebDriverManager webDriverManager;

    /**
     * Le constructeur de la classe, utilisé pour initialiser le webDriverManager
     * @param webDriverManager WebDriverManager obtenu via PicoContainer
     */
    public Hook(WebDriverManager webDriverManager) {
        this.webDriverManager = webDriverManager;
    }

    /**
     * Méthode utilisée pour setup le WebDriver, appelée avant chaque test
     */
    @Before
    public void setUp() throws MalformedURLException {
        this.webDriverManager.createDriver();
    }

    /**
     * La méthode utilisée pour détruire le WebDriver, appelée après chaque test.
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
