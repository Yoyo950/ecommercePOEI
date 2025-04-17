package application.steps;

import application.pages.external_pages.FacebookPage;
import application.utils.WebDriverManager;

public class FacebookStepDefinitionPage {

    private final FacebookPage facebookPage;

    public FacebookStepDefinitionPage(WebDriverManager webDriverManager){
        facebookPage = new FacebookPage(webDriverManager);
    }
}
