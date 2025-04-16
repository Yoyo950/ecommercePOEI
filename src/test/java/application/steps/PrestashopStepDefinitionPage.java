package application.steps;

import application.pages.HomePage;
import application.pages.PrestashopPage;
import application.utils.WebDriverManager;

public class PrestashopStepDefinitionPage {

    private final PrestashopPage prestashopPage;

    public PrestashopStepDefinitionPage(WebDriverManager webDriverManager){
        prestashopPage = new PrestashopPage(webDriverManager);
    }
}
