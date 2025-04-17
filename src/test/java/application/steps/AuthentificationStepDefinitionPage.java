package application.steps;

import application.pages.site.AuthentificationPage;
import application.utils.WebDriverManager;

public class AuthentificationStepDefinitionPage {

    private final AuthentificationPage authentificationPage;

    public AuthentificationStepDefinitionPage(WebDriverManager webDriverManager){
        authentificationPage = new AuthentificationPage(webDriverManager);
    }
}
