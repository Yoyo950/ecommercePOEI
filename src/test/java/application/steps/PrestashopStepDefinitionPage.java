package application.steps;

import application.pages.external_pages.PrestashopPage;
import application.utils.WebDriverManager;

public class PrestashopStepDefinitionPage {

    private final PrestashopPage prestashopPage;

    public PrestashopStepDefinitionPage(WebDriverManager webDriverManager){
        prestashopPage = new PrestashopPage(webDriverManager);
    }
}
