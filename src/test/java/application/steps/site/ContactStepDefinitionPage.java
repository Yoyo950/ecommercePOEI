package application.steps.site;

import application.pages.site.ContactPage;
import application.utils.WebDriverManager;
import io.cucumber.java.en.Then;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ContactStepDefinitionPage {

    private final ContactPage contactPage;

    public ContactStepDefinitionPage(WebDriverManager webDriverManager) {
        this.contactPage = new ContactPage(webDriverManager);
    }

    @Then("L'utilisateur est sur la page contact")
    public void lUtilisateurEstSurLaPageContact() {
        assertTrue(contactPage.isContactPageDisplayed(), "L'utilisateur n'est pas sur la page Contact !");
    }
}
