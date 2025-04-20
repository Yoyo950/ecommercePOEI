package application.steps.site;

import application.pages.site.HomePage;
import application.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class HomeStepDefinitionPage {

    private final HomePage homePage;

    public HomeStepDefinitionPage(WebDriverManager webDriverManager){
        homePage = new HomePage(webDriverManager);
    }

    @Given("L'utilisateur est sur la page accueil")
    public void lUtilisateurEstSurLaPageAccueil() {

        Assertions.assertTrue(homePage.homePageTabs.isDisplayed(), "L'utilisateur est sur la page Home.");
    }

    @When("L'utilisateur clique sur une publicité à la une")
    public void lUtilisateurCliqueSurUnePublicitéÀLaUne() {
        // Click on the first advertisement
        homePage.firstAd.click();
    }

    @Given("L{string}accueil")
    public void lUtilisateurEstSurLaPageDAccueil() {
    }
}
