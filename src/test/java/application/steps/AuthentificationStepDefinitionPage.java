package application.steps;

import application.pages.AuthentificationPage;
import application.utils.WebDriverManager;

public class AuthentificationStepDefinitionPage {

    private final AuthentificationPage authentificationPage;

    public AuthentificationStepDefinitionPage(WebDriverManager webDriverManager){
        authentificationPage = new AuthentificationPage(webDriverManager);
    }
}
