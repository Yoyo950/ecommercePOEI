package application.steps.site;

import application.pages.site.SearchPage;
import application.utils.WebDriverManager;

public class SearchStepDefinitionPage {
    private final SearchPage searchPage;

    public SearchStepDefinitionPage(WebDriverManager webDriverManager){
        searchPage = new SearchPage(webDriverManager);
    }
}
