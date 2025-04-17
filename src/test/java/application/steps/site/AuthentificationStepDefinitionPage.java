package application.steps.site;

import application.pages.site.AuthentificationPage;
import application.utils.ConfigReader;
import application.utils.WebDriverManager;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
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
     * Remplit le champ Email de création de compte avec l'email donné.
     *
     * @param email L'adresse email à saisir dans le formulaire de création.
     */
    @When("Il entre l'adresse mail {string} sur le champ de création")
    public void ilEntreAdresseMailSurLeChampDeCreation(String email) {
        authentificationPage.enterEmailForAccountCreation(email);
    }




}
