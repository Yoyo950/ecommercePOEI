package application.steps;

import application.pages.HomePage;
import application.pages.SearchPage;
import application.utils.WebDriverManager;

public class SearchStepDefinitionPage {
    private final SearchPage searchPage;

    public SearchStepDefinitionPage(WebDriverManager webDriverManager){
        searchPage = new SearchPage(webDriverManager);
    }
}
