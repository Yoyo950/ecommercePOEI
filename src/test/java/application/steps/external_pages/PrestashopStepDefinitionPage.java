package application.steps.external_pages;

import application.pages.external_pages.PrestashopPage;
import application.utils.WebDriverManager;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;

/**
 * Classe de Step Definitions pour vérifier la redirection vers le site partenaire PrestaShop.
 * <p>
 * Utilise la page PrestashopPage pour valider que l'utilisateur est bien sur le bon site externe.
 * </p>
 *
 * @author Fatima Zahrae
 */
public class PrestashopStepDefinitionPage {

    private final PrestashopPage prestashopPage;

    /**
     * Constructeur de la classe PrestashopStepDefinitionPage.
     *
     * @param webDriverManager Manager WebDriver utilisé pour initialiser la page PrestaShop.
     */
    public PrestashopStepDefinitionPage(WebDriverManager webDriverManager) {
        this.prestashopPage = new PrestashopPage(webDriverManager);
    }

    /**
     * Vérifie que l'utilisateur est redirigé sur la page du site partenaire PrestaShop.
     *
     * L'étape utilise l'URL pour confirmer la navigation correcte.
     */
    @Then("L'utilisateur est sur la page du site partenaire PrestaShop")
    public void utilisateurEstSurLaPagePrestaShop() {
        Assertions.assertTrue(prestashopPage.isOnPrestashopSite(),
                "L'utilisateur n'est pas sur la page partenaire PrestaShop !");
    }
}
