package application.steps.site;

import application.pages.site.CartPage;
import application.utils.WebDriverManager;
import dev.failsafe.internal.util.Assert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class CartStepDefinitionPage {

    private final CartPage cartPage;

    public CartStepDefinitionPage(WebDriverManager webDriverManager){
        // Initialize the CartPage object with the provided WebDriverManager instance
        cartPage = new CartPage(webDriverManager);

    }

    @Then("L'utilisateur est sur la page shopping cart summary")
    public void lUtilisateurEstSurLaPageShoppingCartSummary() {
        // Verify that the user is on the shopping cart summary page
        Assertions.assertTrue(cartPage.cartTitle.isDisplayed(), "L'utilisateur est sur la page Shopping Cart Summary.");
    }

}
