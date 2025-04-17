package application.steps.site;

import application.pages.abstract_pages.BaseSitePage;
import application.pages.site.ArticlePage;
import application.pages.site.HomePage;
import application.utils.WebDriverManager;

public class BaseSiteStepDefinitionPage {
    private final BaseSitePage baseSitePage;

    public BaseSiteStepDefinitionPage(WebDriverManager webDriverManager){
        baseSitePage = new HomePage(webDriverManager);
    }
}
