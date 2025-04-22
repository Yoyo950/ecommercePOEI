package application.steps.site;

import application.pages.site.HomePage;
import application.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

/**
 * Steps liés à la page d'accueil.
 */

public class HomeStepDefinitionPage {

    /**
     * Steps liés à la vérification de la "Page d'accueil".
     */

    private final HomePage homePage;

    /**
     * Constructeur de la classe HomeStepDefinitionPage.
     * @param webDriverManager Instance de WebDriverManager pour gérer le navigateur.
     */

    public HomeStepDefinitionPage(WebDriverManager webDriverManager){
        homePage = new HomePage(webDriverManager);
    }

    /**
     * Vérifie que l'utilisateur est sur la page d'accueil.
     */

    @Given("L'utilisateur est sur la page accueil")
    public void lUtilisateurEstSurLaPageAccueil() {

        Assertions.assertTrue(homePage.homePageTabs.isDisplayed(), "L'utilisateur est sur la page Home.");
    }

    /**
     * Clique sur une publicité à la une de la page d'accueil
     */

    @When("L'utilisateur clique sur une publicité à la une")
    public void lUtilisateurCliqueSurUnePublicitéÀLaUne() {
        // Click on the first advertisement
        homePage.firstAd.click();
    }
}
