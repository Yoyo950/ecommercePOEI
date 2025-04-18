package application.steps.site;

import application.pages.site.CreateModifyAddressPage;
import application.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Steps liés à la page de création/modification d'adresse utilisateur.
 */
public class CreateModifyAddressStepDefinitionPage {

    private final CreateModifyAddressPage createModifyAddressPage;

    public CreateModifyAddressStepDefinitionPage(WebDriverManager webDriverManager) {
        this.createModifyAddressPage = new CreateModifyAddressPage(webDriverManager);
    }

    /**
     * Vérifie que l'utilisateur est bien sur la page de création d'adresse.
     */
    @Then("L'utilisateur est sur la page création adresse")
    public void utilisateurEstSurLaPageCreationAdresse() {
        assertTrue(createModifyAddressPage.isOnAddressCreationPage(), "L'utilisateur n'est pas sur la page de création d'adresse !");
    }

    @When("L'utilisateur rentre les informations {string}, {string}, {string}, {string}, {string}, {string}")
    public void utilisateurRentreLesInformations(String telephone, String adresse, String ville, String state, String codePostal, String addressTitle) {
        createModifyAddressPage.fillAddressForm(telephone, adresse, ville, state, codePostal, addressTitle);
    }

    @And("L'utilisateur clique sur le bouton Save")
    public void utilisateurCliqueSurLeBoutonSave() {
        createModifyAddressPage.clickSaveButton();
    }



}
