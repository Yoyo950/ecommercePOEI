package application.steps.site;

import application.pages.site.MyAccountPage;
import application.utils.ConfigReader;
import application.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Steps liés à la vérification de la page "My Account".
 */

public class MyAccountStepDefinitionPage {

    /**
     * Page object for the My Account page.
     */

    private final MyAccountPage myAccountPage;

    /**
     * Constructeur de la classe MyAccountStepDefinitionPage.
     * @param webDriverManager Instance de WebDriverManager pour gérer le navigateur.
     */

    public MyAccountStepDefinitionPage(WebDriverManager webDriverManager){
        myAccountPage = new MyAccountPage(webDriverManager);
    }
    /**
     *  L'utilisateur clique sur le bouton "Add a new adress" pour créer une nouvelle adresse.
     */

    @And("L'utilisateur clique sur créer une adresse")
    public void lUtilisateurCliqueSurCréerUneAdresse() {
        myAccountPage.add_a_new_address_button.click();
    }

    /**
     * Vrérification que l'utilisateur est sur la page "My Account".
     */

    @Then("L'utilisateur est sur la page my account")
    public void lUtilisateurEstSurLaPageMyAccount() {
        int timeout = Integer.parseInt(ConfigReader.getProperty("timeout"));
        WebDriverWait wait = new WebDriverWait(myAccountPage.getDriver(), Duration.ofSeconds(timeout)); // <-- ICI getDriver()
        wait.until(ExpectedConditions.visibilityOf(myAccountPage.order_history_and_details_button));

        Assertions.assertTrue(myAccountPage.order_history_and_details_button.isDisplayed(),
                "L'utilisateur n'est pas sur la page My Account.");
    }



//    @Then("L'utilisateur est sur la page my account")
//    public void lUtilisateurEstSurLaPageMyAccount() {
//        // Vérifie que l'utilisateur est bien sur la page "My Account" en détectant un élément sûr
//        Assertions.assertTrue(myAccountPage.order_history_and_details_button.isDisplayed(), "L'utilisateur n'est pas sur la page My Account.");
//    }


//    @Then("L'utilisateur est sur la page my account")
//    public void lUtilisateurEstSurLaPageMyAccount() {
//        Assertions.assertTrue(myAccountPage.add_a_new_address_button.isDisplayed(), "L'utilisateur est sur la page My Account.");
//    }

    /**
     * L'utilisateur clique sur le bouton "Update" pour mettre à jour ses informations.
     */

    @And("L'utilisateur clique sur Update")
    public void lUtilisateurCliqueSurUpdate() {
        myAccountPage.my_update_button.click();
    }

    /**
     * L'utilisateur clique sur le bouton "My Adresses" pour enregistrer ses informations.
     */

    @And("L'utilisateur clique sur my adresses")
    public void lUtilisateurCliqueSurMyAdresses() {
        myAccountPage.my_adresses_button.click();
    }

    /**
     * Vérification que l'utilisateur est sur la bonne page "My Adresses".
     */

    @Then("Un espace my address est affiché sur la page")
    public void unEspaceMyAddressEstAffichéSurLaPage() {
        Assertions.assertTrue(myAccountPage.my_adresses_field.isDisplayed(), "Le petit encadré My address est affiché.");
    }

    /**
     * Vérification que l'utilisateur n'a pas enregistré d'adresse et qu'un message d'erreur s'affiche pour l'avertir.
     */

    @Then("Il n'a enregistré aucune adresse")
    public void ilNAEnregistréAucuneAdresse() {
        Assertions.assertTrue(myAccountPage.no_address_message_field.isDisplayed(), "Le message 'Aucune adresse n'est enregistrée' apparaît.");
    }

    /**
     * Vérification que le bouton "Add my first address" est affiché.
     */

    @And("Le bouton add my first address est affiché")
    public void leBoutonAddMyFirstAddressEstAffiché() {
        int timeout = Integer.parseInt(ConfigReader.getProperty("timeout"));
        WebDriverWait wait = new WebDriverWait(myAccountPage.getDriver(), Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOf(myAccountPage.add_my_first_address_button));
        Assertions.assertTrue(myAccountPage.add_my_first_address_button.isDisplayed(),
                "Le bouton 'Add my first address' n'est pas affiché !");
    }

    /**
     * L'utilisateur clique sur le bouton "Add my first address".
     */

    @And("Il clique sur le bouton add my first address")
    public void ilCliqueSurLeBoutonAddMyFirstAddress() {
        myAccountPage.add_my_first_address_button.click();
    }


//    @And("Le bouton add my first address est affiché")
//    public void leBoutonAddMyFirstAddressEstAffiché() {
//        Assertions.assertTrue(myAccountPage.add_my_first_address_button.isDisplayed(), "Le bouton 'Add my first address' apparaît.");
//    }

    /**
     * Vérification que la page "My Account" contient les boutons "Historique de commandes", "Avoirs", "Adresses de livraison", "Informations personelles" et qu'ils sont visibles.
     */

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

    /**
     * Vérification que le message "Your account has been created" est affiché.
     */

    @And("Le message Your account has been created est visible")
    public void leMessageYourAccountHasBeenCreatedEstVisible() {
        Assertions.assertTrue(myAccountPage.account_created_message_field.isDisplayed(), "Le message n'est pas visible !");
        String actualMessage = myAccountPage.account_created_message_field.getText().trim();
        Assertions.assertEquals("Your account has been created.", actualMessage, "Le message affiché n'est pas celui attendu !");
    }

    /**
     * Vérification que les informations modifiées après concordent avec les informations fournies lors de la modification des inforamtions.
     */


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

    /**
     * Vérification que l'adresse a bien été crée avec les informations fournies.
     */

    @And("L'adresse a été créée avec les informations {string}, {string}, {string}, {string}, {string}, {string}")
    public void lAdresseAÉtéCrééeAvecLesInformations(String telephone, String adresse, String ville, String state, String code_postal, String address_title) {

        Assertions.assertEquals(myAccountPage.address_title_field.getText(), address_title, "L'adresse_title_field a été crée avec succès.");
        Assertions.assertEquals(myAccountPage.address_field.getText(), adresse, "Adress a été crée avec succès.");
        Assertions.assertEquals(myAccountPage.city_field.getText().replaceAll("\\p{Punct}", ""), ville, "City a été crée avec succès.");
        Assertions.assertEquals(myAccountPage.state_field.getText(), state, "State a été crée avec succès.");
        Assertions.assertEquals(myAccountPage.postal_code_field.getText(), code_postal, "Postal_code a été crée avec succès.");
        Assertions.assertEquals(myAccountPage.phone_field.getText(), telephone, "Phone a été crée avec succès.");
    }

    /*
     * Vérification que l'utilisateur est sur la page "My Addresses".
     */

    @Then("L'utilisateur est sur la page my addresses")
    public void lUtilisateurEstSurLaPageMyAddresses() {
        Assertions.assertTrue(myAccountPage.add_a_new_address_button.isDisplayed());
    }
}
