package application.steps.external_pages;

import application.pages.external_pages.MailJetablePage;
import application.utils.WebDriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class MailJetableStepDefinitionPage {

    private final MailJetablePage mailJetablePage;

    public MailJetableStepDefinitionPage(WebDriverManager webDriverManager){
        mailJetablePage = new MailJetablePage(webDriverManager);
    }

    @Given("L'utilisateur crée une adresse mail temporaire")
    public void lUtilisateurCreeUneAdresseMailTemporaire() {
        mailJetablePage.openPage();
        mailJetablePage.enterMailInLogin();
    }

    @When("L'utilisateur clique sur le lien envoyé par mail")
    public void lUtilisateurCliqueSurLeLienEnvoyeParMail() throws InterruptedException {
        mailJetablePage.clickOnLinkAndGoBack();
    }

    @Then("Le mot de passe du compte a été modifié")
    public void leMotDePasseDuCompteAEteModifie() throws InterruptedException {
        Assertions.assertTrue(mailJetablePage.verifyMail());
    }
}
