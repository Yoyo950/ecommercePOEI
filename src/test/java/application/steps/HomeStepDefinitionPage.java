package application.steps;

import application.pages.site.HomePage;
import application.utils.WebDriverManager;

public class HomeStepDefinitionPage {

    private final HomePage homePage;

    public HomeStepDefinitionPage(WebDriverManager webDriverManager){
        homePage = new HomePage(webDriverManager);
    }
}
