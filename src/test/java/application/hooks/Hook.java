package application.hooks;

import application.utils.WebDriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

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
    public void setUp(){
        this.webDriverManager.createDriver();
    }

    /**
     * The method tearing down the driver, executed after each test.
     */
    @After
    public void tearDown() {
        this.webDriverManager.quit();
    }





}
