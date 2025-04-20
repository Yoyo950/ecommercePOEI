package application.steps.site;

import application.pages.site.CreateAccountPage;
import application.utils.WebDriverManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 * Steps liés à la création de compte utilisateur.
 */
public class CreateAccountStepDefinitionPage {

    private final CreateAccountPage createAccountPage;

    public CreateAccountStepDefinitionPage(WebDriverManager webDriverManager) {
        this.createAccountPage = new CreateAccountPage(webDriverManager);
    }

    /**
     * Remplit le formulaire de création d'un compte utilisateur.
     */
    @When("Il remplit le formulaire avec {string}, {string}, {string}, {string}, {string}, {string}")
    public void ilRemplitLeFormulaireAvecTousLesChamps(String genre, String prenom, String nom, String motDePasse, String dateNaissance, String newsletter) {
        createAccountPage.remplirFormulaireCreationCompte(genre, prenom, nom, motDePasse, dateNaissance, newsletter);
    }

    @And("Il clique sur le bouton REGISTER")
    public void ilCliqueSurLeBoutonRegister() {
        createAccountPage.clickRegisterButton();
    }

    /**
     * Vérifie que le message d'erreur affiché correspond au message attendu.
     */
    @Then("Le message d'erreur {string} s'affiche")
    public void leMessageErreurSaffiche(String messageAttendu) {
        String messageReel = createAccountPage.getErreurCreationCompte();
        assertEquals(messageAttendu, messageReel, "Le message d'erreur affiché n'est pas celui attendu.");
    }

    /**
     * Vérifie que l'utilisateur est bien sur la page Create an Account.
     */
    @Then("L'utilisateur est sur la page create an account")
    public void verifierUtilisateurSurPageCreateAccount() {
        assertTrue(createAccountPage.estSurPageCreateAccount(), "L'utilisateur n'est pas sur la page Create an Account !");
    }

}
