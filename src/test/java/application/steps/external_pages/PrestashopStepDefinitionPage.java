package application.steps.external_pages;

import application.pages.external_pages.PrestashopPage;
import application.utils.WebDriverManager;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;

/**
 * Steps liés à la vérification de la page partenaire PrestaShop.
 */
public class PrestashopStepDefinitionPage {

    private final PrestashopPage prestashopPage;

    public PrestashopStepDefinitionPage(WebDriverManager webDriverManager) {
        this.prestashopPage = new PrestashopPage(webDriverManager);
    }

    /**
     * Vérifie que l'utilisateur est bien sur la page partenaire PrestaShop.
     */
    @Then("L'utilisateur est sur la page du site partenaire PrestaShop")
    public void utilisateurEstSurLaPagePrestaShop() {
        Assertions.assertTrue(prestashopPage.isMainHeadingCorrect("Unlock your commerce"),
                "L'utilisateur n'est pas sur la page partenaire PrestaShop !");
    }
}
