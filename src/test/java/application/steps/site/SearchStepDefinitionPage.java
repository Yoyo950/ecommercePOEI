package application.steps.site;

import application.pages.site.SearchPage;
import application.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Steps liés à la vérification de la page de recherche.
 */

public class SearchStepDefinitionPage {
    private final SearchPage searchPage;

    /**
     * Constructeur de la classe SearchStepDefinitionPage.
     * @param webDriverManager Instance de WebDriverManager pour gérer le navigateur.
     */

    public SearchStepDefinitionPage(WebDriverManager webDriverManager){
        searchPage = new SearchPage(webDriverManager);
    }

    /**
     * Vérifie que l'utilisateur est sur la page de recherche.
     */

    @Then("L'utilisateur est sur la page search")
    public void lUtilisateurEstSurLaPageSearch() {
        assertTrue(searchPage.search_result_title_bar.isDisplayed(), "L'utilisateur n'est pas sur la page 'Search'.");
    }
    /**
     * Vérifie que l'utilisateur est sur la page de la catégorie testé avec le message d'erreur.
     */

    @Then("La page des articles de la catégorie {string} s'affiche")
    public void laPageDesArticlesDeLaCatégorieSAffiche(String categorie) {
        String displayedCategory = searchPage.getDisplayedCategoryName();
        Assertions.assertEquals(categorie.toUpperCase(), displayedCategory.toUpperCase(), "La page de la catégorie '" + categorie + "' ne s'affiche pas correctement !");
    }

    /**
     * Vérifie que l'utilisateur est sur la page de liste de résultat associé avec le message d'erreur.
     */

    @And("L'article {string} est présent dans la liste de résultats")
    public void lArticleEstPrésentDansLaListeDeRésultats(String article) {
        // Verify that the specified article is present in the search results
        switch (article) {
            case "Blouse":
                Assertions.assertTrue(searchPage.blouse_article.isDisplayed(), "La blouse est visible.");
                break;
            case "Printed Summer Dress":
                Assertions.assertTrue(searchPage.summer_dress_article.isDisplayed(), "La summer dress est visible.");
                break;
        }
    }
}
