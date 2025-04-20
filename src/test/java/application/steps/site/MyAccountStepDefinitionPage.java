package application.steps.site;

import application.pages.site.MyAccountPage;
import application.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.time.Duration;

public class MyAccountStepDefinitionPage {
    private final MyAccountPage myAccountPage;

    public MyAccountStepDefinitionPage(WebDriverManager webDriverManager){
        myAccountPage = new MyAccountPage(webDriverManager);
    }

    @And("L'utilisateur clique sur créer une adresse")
    public void lUtilisateurCliqueSurCréerUneAdresse() {

        // Click on the "Create an Address" button
        myAccountPage.add_a_new_address_button.click();
    }

    @Then("L'utilisateur est sur la page my account")
    public void lUtilisateurEstSurLaPageMyAccount() {
        // Verify that the user is on the My Account page
        Assertions.assertTrue(myAccountPage.add_a_new_address_button.isDisplayed(), "L'utilisateur est sur la page My Account.");
    }


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

        Assertions.assertTrue(myAccountPage.my_adresses_field.isDisplayed(), "Le petit encadré My adress est affiché.");

    }

    @Then("Il n'a enregistré aucune adresse")
    public void ilNAEnregistréAucuneAdresse() {

        // Verify that the user has not saved any addresses
        Assertions.assertTrue(myAccountPage.no_address_message_field.isDisplayed(), "Le message 'Aucune adresse n'est enregistrée' apparaît.");
    }

    @And("Le bouton add my first address est affiché")
    public void leBoutonAddMyFirstAddressEstAffiché() {

        Assertions.assertTrue(myAccountPage.add_my_first_address_button.isDisplayed(), "Le bouton 'Add my first address' apparaît.");
    }

    @Then("La section {string} est visible")
    public void laSectionEstVisible(String section) {

        // Verify that the specified section is visible
        switch (section) {
            case "Historique de commandes":
                Assertions.assertTrue(myAccountPage.order_history_and_details_button.isDisplayed(), "La section 'Historique de commandes' est visible.");
                break;
            case "Avoirs":
                Assertions.assertTrue(myAccountPage.my_credit_slips_button.isDisplayed(), "La section 'Avoirs' est visible.");
                break;
            case "Adresses de livraison":
                Assertions.assertTrue(myAccountPage.my_adresses_button.isDisplayed(), "La section 'Adresses de livraison' est visible.");
                break;
            case "Informations personnelles":
                Assertions.assertTrue(myAccountPage.my_personal_information_button.isDisplayed(), "La section 'Informations personnelles' est visible.");
                break;
        }
    }

    @And("Le message Your account has been created est visible")
    public void leMessageYourAccountHasBeenCreatedEstVisible() {
        // Verify that the message "Your account has been created" is visible
        Assertions.assertTrue(myAccountPage.account_created_message_field.isDisplayed(), "Le message 'Your account has been created' est visible.");
    }

    @And("L'adresse a été modifiée avec les informations {string}, {string}, {string}, {string}, {string}, {string}")
    public void lAdresseAÉtéModifiéeAvecLesInformations(String telephone, String adresse, String ville, String state, String code_postal, String address_title) {
        // Verify that the address has been modified with the provided information
        Assertions.assertEquals(myAccountPage.address_title_field.getText(), address_title, "L'adresse_title_field a été modifiée avec succès.");
        Assertions.assertEquals(myAccountPage.address_field.getText(), adresse, "Adress a été modifiée avec succès.");
        Assertions.assertEquals(myAccountPage.city_field.getText().replaceAll("\\p{Punct}", ""), ville, "City a été modifiée avec succès.");
        Assertions.assertEquals(myAccountPage.state_field.getText(), state, "State a été modifiée avec succès.");
        Assertions.assertEquals(myAccountPage.postal_code_field.getText(), code_postal, "Postal_code a été modifiée avec succès.");
        Assertions.assertEquals(myAccountPage.phone_field.getText(), telephone, "Phone a été modifiée avec succès.");
    }

    @And("L'adresse a été créée avec les informations {string}, {string}, {string}, {string}, {string}, {string}")
    public void lAdresseAÉtéCrééeAvecLesInformations(String telephone, String adresse, String ville, String state, String code_postal, String address_title) {

        Assertions.assertEquals(myAccountPage.address_title_field.getText(), address_title, "L'adresse_title_field a été crée avec succès.");
        Assertions.assertEquals(myAccountPage.address_field.getText(), adresse, "Adress a été crée avec succès.");
        Assertions.assertEquals(myAccountPage.city_field.getText().replaceAll("\\p{Punct}", ""), ville, "City a été crée avec succès.");
        Assertions.assertEquals(myAccountPage.state_field.getText(), state, "State a été crée avec succès.");
        Assertions.assertEquals(myAccountPage.postal_code_field.getText(), code_postal, "Postal_code a été crée avec succès.");
        Assertions.assertEquals(myAccountPage.phone_field.getText(), telephone, "Phone a été crée avec succès.");
    }
}
