package application.steps.site;

import application.pages.site.SearchPage;
import application.utils.WebDriverManager;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchStepDefinitionPage {
    private final SearchPage searchPage;

    public SearchStepDefinitionPage(WebDriverManager webDriverManager){
        searchPage = new SearchPage(webDriverManager);
    }

    @Then("L'utilisateur est sur la page search")
    public void lUtilisateurEstSurLaPageSearch() {
        assertTrue(searchPage.search_result_title_bar.isDisplayed(), "L'utilisateur n'est pas sur la page 'Search'.");
    }

    @Then("La page des articles de la catégorie {string} s'affiche")
    public void laPageDesArticlesDeLaCatégorieSAffiche(String categorie) {
        String displayedCategory = searchPage.getDisplayedCategoryName();
        Assertions.assertEquals(categorie.toUpperCase(), displayedCategory.toUpperCase(), "La page de la catégorie '" + categorie + "' ne s'affiche pas correctement !");
    }
}
