package application.steps.site;

import application.pages.site.SearchPage;
import application.utils.WebDriverManager;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;

public class SearchStepDefinitionPage {
    private final SearchPage searchPage;

    public SearchStepDefinitionPage(WebDriverManager webDriverManager){
        searchPage = new SearchPage(webDriverManager);
    }

    @Then("L'utilisateur est sur la page search")
    public void lUtilisateurEstSurLaPageSearch() {

        // Verify that the user is on the search page
        Assertions.assertTrue(searchPage.search_result_title_bar.isDisplayed(), "L'utilisateur est sur la page 'Search'.");
    }

    @Then("La page des articles de la catégorie {string} s'affiche")
    public void laPageDesArticlesDeLaCatégorieSAffiche(String category) {
        // Verify that the page of items in the specified category is displayed
        Assertions.assertEquals(searchPage.search_result_title_bar.getAttribute("value"), category, "La page de la catégorie de produit voulu s'affiche bien.");
    }
}
