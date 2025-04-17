package application.steps.site;

import application.pages.site.ContactPage;
import application.utils.WebDriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;

public class ContactStepDefinitionPage {
    private final ContactPage contactPage;

    public ContactStepDefinitionPage(WebDriverManager webDriverManager){
        contactPage = new ContactPage(webDriverManager);
    }

    @Then("L'utilisateur est sur la page contact")
    public void lUtilisateurEstSurLaPageContact() {
        // Verify that the user is on the contact page
        Assertions.assertTrue(contactPage.SubjectHeading_List_box.isDisplayed(), "L'utilisateur est sur la page Contact.");
    }
}
