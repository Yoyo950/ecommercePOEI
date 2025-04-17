package application.steps.site;

import application.pages.site.ArticlePage;
import application.utils.WebDriverManager;

public class ArticleStepDefinitionPage {
    private final ArticlePage articlePage;

    public ArticleStepDefinitionPage(WebDriverManager webDriverManager){
        articlePage = new ArticlePage(webDriverManager);
    }
}
