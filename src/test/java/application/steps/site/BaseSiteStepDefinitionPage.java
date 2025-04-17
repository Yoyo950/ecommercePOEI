package application.steps.site;

import application.pages.abstract_pages.BaseSitePage;
import application.pages.site.ArticlePage;
import application.pages.site.HomePage;
import application.utils.ConfigReader;
import application.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class BaseSiteStepDefinitionPage {
    private final BaseSitePage baseSitePage;

    public BaseSiteStepDefinitionPage(WebDriverManager webDriverManager){
        baseSitePage = new HomePage(webDriverManager);
    }

    @Given("L'utilisateur se rend sur la page authentification")
    public void lUtilisateurSeRendSurLaPageAuthentification() {
        baseSitePage.clickOnSignIn();
    }


    @Then("l'utilisateur est connecté")
    public void lUtilisateurEstConnecte() {
        Assertions.assertTrue(baseSitePage.userIsConnected());
    }

    @When("L'utilisateur se rend sur la page my account")
    public void lUtilisateurSeRendSurLaPageMyAccount() {
        baseSitePage.clickOnAccount();
    }

    @When("L'utilisateur clique sur Sign Out")
    public void lUtilisateurCliqueSurSignOut() {
        baseSitePage.clickOnSignOut();
    }

    @Then("L'utilisateur est déconnecté")
    public void lUtilisateurEstDeconnecte() {
        Assertions.assertFalse(baseSitePage.userIsConnected());
    }

    @When("L'utilisateur se rend sur la page {string}")
    public void lUtilisateurSeRendSurLaPage(String page) {
        //TODO : Do That
    }

    @Then("Le bouton Sign Out avec le lien correspondant doit être présent")
    public void leBoutonSignOutAvecLeLienCorrespondantDoitEtrePresent() {
        Assertions.assertTrue(baseSitePage.signOutIsDisplayed());
    }

    @Then("Le logo {string} est présent")
    public void leLogoYourLogoWhatANewExperienceEstPrésent() {
        Assertions.assertTrue(baseSitePage.logoIsDisplayed());
    }

    @When("L'utilisateur clique sur le logo")
    @And("L'utilisateur se rend sur la page accueil")
    public void lUtilisateurCliqueSurLeLogo() {
        baseSitePage.clickOnLogo();
    }

    @When("Il clique sur l'onglet {string}")
    public void ilCliqueSurLOnglet(String categorie) {
        switch (categorie) {
            case "Women":
                baseSitePage.clickOnWomanCategory();
                break;
            case "Dresses":
                baseSitePage.clickOnDressesCategory();
                break;
            case "T-Shirts":
                baseSitePage.clickOnTShirtCategory();
                break;
        }
    }

    @When("Il clique sur le lien Contact Us")
    public void ilCliqueSurLeLienContactUs() {
        baseSitePage.clickOnContactUs();
    }

    @Then("L'élément {string} est visible")
    public void lElementEstVisible(String element) {
        switch (element) {
            case "Sign in":
                Assertions.assertTrue(baseSitePage.signInIsDisplayed());
                break;
            case "Women":
                Assertions.assertTrue(baseSitePage.womanCategoryIsDisplayed());
                break;
            case "Dresses":
                Assertions.assertTrue(baseSitePage.dressesCategoryIsDisplayed());
                break;
            case "T-Shirts":
                Assertions.assertTrue(baseSitePage.tShirtCategoryIsDisplayed());
                break;
            case "BLOG":
                Assertions.assertTrue(baseSitePage.blogIsDisplayed());
                break;
        }
    }

    @When("L'utilisateur entre {string} dans la barre de recherche")
    public void lUtilisateurEntreDansLaBarreDeRecherche(String input) {
        baseSitePage.enterInSearchBar(input);
    }

    @And("Clique sur la loupe")
    public void cliqueSurLaLoupe() {
        baseSitePage.clickOnSubmitSearch();
    }

    @Then("Le champ de recherche et la loupe doivent être présents")
    @Given("Le champ de recherche et la loupe doivent être présents")
    public void leChampDeRechercheEtLaLoupeDoiventEtrePresents() {
        Assertions.assertTrue(baseSitePage.searchBarAndHandLensIsDisplayed());
    }

    @Then("Le bouton du panier et son lien sont présents")
    public void leBoutonDuPanierEtSonLienSontPresents() {
        Assertions.assertTrue(baseSitePage.cartIsDisplayed());
    }

    @When("L'utilisateur se rend sur la page cart")
    public void lUtilisateurSeRendSurLaPageCart() {
        baseSitePage.clickOnCart();
    }

    @And("Son nom et prénom apparaissent dans la barre de menu")
    public void sonNomEtPrénomApparaissentDansLaBarreDeMenu() {
        Assertions.assertTrue(baseSitePage.nameAndSurnameIsDisplayed(ConfigReader.getProperty("name"), ConfigReader.getProperty("surname")));
    }

    @Then("L'article {string} doit être proposé")
    public void lArticleDoitEtrePropose(String article) {
        Assertions.assertTrue(baseSitePage.articleIsDisplayed(article));
    }


    @When("L'utilisateur clique sur un article {string} proposé")
    public void lUtilisateurCliqueSurUnArticleProposé(String article) {
        baseSitePage.clickOnArticle(article);
    }
}
