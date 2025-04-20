package application.steps.site;

import application.pages.site.MyAccountPage;
import application.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.support.ui.Select;

public class MyAccountStepDefinitionPage {
    private final MyAccountPage myAccountPage;

    public MyAccountStepDefinitionPage(WebDriverManager webDriverManager){
        myAccountPage = new MyAccountPage(webDriverManager);
    }

    @And("L'utilisateur clique sur créer une adresse")
    public void lUtilisateurCliqueSurCréerUneAdresse() {
        myAccountPage.add_a_new_address_button.click();
    }

    @Then("L'utilisateur est sur la page my account")
    public void lUtilisateurEstSurLaPageMyAccount() {
        // Vérifie que l'utilisateur est bien sur la page "My Account" en détectant un élément sûr
        Assertions.assertTrue(myAccountPage.order_history_and_details_button.isDisplayed(), "L'utilisateur n'est pas sur la page My Account.");
    }


//    @Then("L'utilisateur est sur la page my account")
//    public void lUtilisateurEstSurLaPageMyAccount() {
//        Assertions.assertTrue(myAccountPage.add_a_new_address_button.isDisplayed(), "L'utilisateur est sur la page My Account.");
//    }

    @And("L'utilisateur clique sur Update")
    public void lUtilisateurCliqueSurUpdate() {
        myAccountPage.my_update_button.click();
    }

    @And("L'utilisateur clique sur my adresses")
    public void lUtilisateurCliqueSurMyAdresses() {
        myAccountPage.my_adresses_button.click();
    }

    @Then("Un espace my address est affiché sur la page")
    public void unEspaceMyAddressEstAffichéSurLaPage() {
        Assertions.assertTrue(myAccountPage.my_adresses_field.isDisplayed(), "Le petit encadré My address est affiché.");
    }

    @Then("Il n'a enregistré aucune adresse")
    public void ilNAEnregistréAucuneAdresse() {
        Assertions.assertTrue(myAccountPage.no_address_message_field.isDisplayed(), "Le message 'Aucune adresse n'est enregistrée' apparaît.");
    }

    @And("Le bouton add my first address est affiché")
    public void leBoutonAddMyFirstAddressEstAffiché() {
        Assertions.assertTrue(myAccountPage.add_my_first_address_button.isDisplayed(), "Le bouton 'Add my first address' apparaît.");
    }

    @Then("La section {string} est visible")
    public void laSectionEstVisible(String section) {
        switch (section) {
            case "Historique de commandes":
                Assertions.assertTrue(myAccountPage.order_history_and_details_button.isDisplayed(),
                        "La section 'Historique de commandes' n'est pas visible !");
                break;
            case "Avoirs":
                Assertions.assertTrue(myAccountPage.my_credit_slips_button.isDisplayed(),
                        "La section 'Avoirs' n'est pas visible !");
                break;
            case "Adresses de livraison":
                Assertions.assertTrue(myAccountPage.my_addresses_button.isDisplayed(),
                        "La section 'Adresses de livraison' n'est pas visible !");
                break;
            case "Informations personnelles":
                Assertions.assertTrue(myAccountPage.my_personal_information_button.isDisplayed(),
                        "La section 'Informations personnelles' n'est pas visible !");
                break;
            default:
                Assertions.fail("La section " + section + " n'existe pas !");
        }
    }

//    @And("Le message Your account has been created est visible")
//    public void leMessageYourAccountHasBeenCreatedEstVisible() {
//        Assertions.assertTrue(myAccountPage.account_created_message_field.isDisplayed(), "Le message 'Your account has been created' est visible.");
//    }

    @And("Le message Your account has been created est visible")
    public void leMessageYourAccountHasBeenCreatedEstVisible() {
        Assertions.assertTrue(myAccountPage.account_created_message_field.isDisplayed(), "Le message n'est pas visible !");
        String actualMessage = myAccountPage.account_created_message_field.getText().trim();
        Assertions.assertEquals("Your account has been created.", actualMessage, "Le message affiché n'est pas celui attendu !");
    }


    @And("L'adresse a été modifiée avec les informations {string}, {string}, {string}, {string}, {string}, {string}")
    public void lAdresseAÉtéModifiéeAvecLesInformations(String telephone, String adresse, String ville, String state, String code_postal, String address_title) {
        Select selectState = new Select(myAccountPage.state_field);
        Assertions.assertEquals(address_title, myAccountPage.address_title_field.getAttribute("value"), "L'adresse_title_field a été modifiée avec succès.");
        Assertions.assertEquals(adresse, myAccountPage.address_field.getAttribute("value"), "Adress a été modifiée avec succès.");
        Assertions.assertEquals(ville, myAccountPage.city_field.getAttribute("value"), "City a été modifiée avec succès.");
        Assertions.assertEquals(state, selectState.getFirstSelectedOption().getText(), "State a été modifiée avec succès.");
        Assertions.assertEquals(code_postal, myAccountPage.postal_code_field.getAttribute("value"), "Postal_code a été modifiée avec succès.");
        Assertions.assertEquals(telephone, myAccountPage.phone_field.getAttribute("value"), "Phone a été modifiée avec succès.");
    }
}
