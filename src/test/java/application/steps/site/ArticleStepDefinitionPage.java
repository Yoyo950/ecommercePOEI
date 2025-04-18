package application.steps.site;

import application.pages.site.ArticlePage;
import application.utils.WebDriverManager;
import io.cucumber.java.en.Then;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Steps liés à la vérification de la page article.
 */
public class ArticleStepDefinitionPage {
    private final ArticlePage articlePage;

    public ArticleStepDefinitionPage(WebDriverManager webDriverManager){
        this.articlePage = new ArticlePage(webDriverManager);
    }

    /**
     * Vérifie que l'utilisateur est sur la page de l'article attendu.
     */
    @Then("L'utilisateur est sur la page article de {string}")
    public void utilisateurEstSurPageArticleDe(String articleAttendu) {
        assertTrue(articlePage.isOnArticlePage(articleAttendu), "L'utilisateur n'est pas sur la bonne page article !");
    }
}
