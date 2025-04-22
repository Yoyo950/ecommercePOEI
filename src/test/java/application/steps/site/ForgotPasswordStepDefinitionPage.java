package application.steps.site;

import application.pages.site.ForgotPasswordPage;
import application.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

/**
 * La classe contenant toutes les steps liées à ForgotPasswordPage
 * @author Yoann DAGAND
 */
public class ForgotPasswordStepDefinitionPage {
    private final ForgotPasswordPage forgotPasswordPage;

    public ForgotPasswordStepDefinitionPage(WebDriverManager webDriverManager){
        forgotPasswordPage = new ForgotPasswordPage(webDriverManager);
    }

    @When("Il saisit son adresse email dans le champ prévu")
    public void ilSaisitSonAdresseEmailDansLeChampPrevu() {
        forgotPasswordPage.enterEmail();
    }


    @And("Il clique sur le bouton retrieve password")
    public void ilCliqueSurLeBoutonRetrievePassword() {
        forgotPasswordPage.submitEmail();
    }

    @Then("La page de réinitialisation du mot de passe s'affiche")
    public void laPageDeReinitialisationDuMotDePasseSAffiche() {
        Assertions.assertTrue(forgotPasswordPage.isOnForgotPasswordPage());
    }

    @Then("Une demande de réinitialisation est envoyée à l'adresse saisie")
    public void uneDemandeDeReinitialisationEstEnvoyeeALAdresseSaisie() throws InterruptedException {
        Assertions.assertTrue(forgotPasswordPage.mailIsSent());
    }
}
