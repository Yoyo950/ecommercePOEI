package application.steps;

import application.pages.CartPage;
import application.pages.FacebookPage;
import application.utils.WebDriverManager;

public class FacebookStepDefinitionPage {

    private final FacebookPage facebookPage;

    public FacebookStepDefinitionPage(WebDriverManager webDriverManager){
        facebookPage = new FacebookPage(webDriverManager);
    }
}
