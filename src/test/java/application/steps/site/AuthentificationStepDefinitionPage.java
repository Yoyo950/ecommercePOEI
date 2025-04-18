package application.steps.site;

import application.pages.site.AuthentificationPage;
import application.utils.ConfigReader;
import application.utils.WebDriverManager;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 * Classe de Step Definitions pour la page d'authentification.
 * Contient les actions liées à la saisie des identifiants et à la connexion.
 * Utilise ConfigReader pour lire les paramètres depuis le fichier de configuration.
 *
 * @author Fatima Zahrae
 */
public class AuthentificationStepDefinitionPage {

    private final AuthentificationPage authentificationPage;

    public AuthentificationStepDefinitionPage(WebDriverManager webDriverManager){
        authentificationPage = new AuthentificationPage(webDriverManager);
    }

    /**
     * Saisit les identifiants (email et mot de passe) récupérés depuis le fichier de configuration.
     */
    @When("Il entre ses identifiants")
    public void ilEntreSesIdentifiants() {
        String email = ConfigReader.getProperty("email");
        String password = ConfigReader.getProperty("password");
        authentificationPage.enterCredentials(email, password);
    }

    /**
     * Clique sur le bouton "Sign in" pour tenter la connexion.
     */
    @When("Il clique sur le bouton Sign In")
    public void ilCliqueSurLeBoutonSignIn() {
        authentificationPage.clickSignIn();
    }

    /**
     * Vérifie que l'utilisateur est bien sur la page d'authentification.
     */
    @Then("L'utilisateur est sur la page authentification")
    public void lUtilisateurEstSurLaPageAuthentification() {
        assertTrue(authentificationPage.isAuthenticationPageDisplayed(), "L'utilisateur n'est pas sur la page d'authentification.");
    }

    /**
     * Action de cliquer sur "Forgot your password?" pour accéder à la page de réinitialisation.
     */
    @When("L'utilisateur se rend sur la page réinitialisation du mot de passe")
    public void utilisateurSeRendSurLaPageReinitialisationMotDePasse() {
        authentificationPage.clickForgotPassword();
    }
    /**
     * Génère un email unique basé sur le timestamp actuel.
     *
     * @return Un email unique
     */
    private String generateUniqueEmail() {
        long timestamp = System.currentTimeMillis();
        return "testfwy" + timestamp + "@validedefou.com";
    }

    /**
     * Remplit le champ Email de création de compte avec l'email donné.
     *
     * @param email L'adresse email à saisir dans le formulaire de création.
     */
    @When("Il entre l'adresse mail {string} sur le champ de création")
    public void ilEntreAdresseMailSurLeChampDeCreation(String email) {
        if (email.equalsIgnoreCase("random")) {
            email = generateUniqueEmail();
        }
        authentificationPage.enterEmailForAccountCreation(email);
    }


    /**
     * Action de cliquer sur le bouton "Create an account".
     */
    @And("Il clique sur le bouton create an account")
    public void ilCliqueSurLeBoutonCreateAnAccount() {
        authentificationPage.clickCreateAccountButton();
    }

    /**
     * Vérifie que le message d'erreur attendu est affiché.
     *
     * @param expectedMessage Le texte attendu (ex : "Invalid email address.")
     */
    @Then("Le message {string} s'affiche")
    public void leMessageSaffiche(String expectedMessage) {
        String actualMessage = authentificationPage.getAccountCreationErrorMessage();
        assertEquals(expectedMessage, actualMessage, "Le message affiché ne correspond pas.");
    }


}
