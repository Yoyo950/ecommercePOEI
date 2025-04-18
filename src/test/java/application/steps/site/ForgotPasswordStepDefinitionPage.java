package application.steps.site;

import application.pages.site.ForgotPasswordPage;
import application.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

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
}
