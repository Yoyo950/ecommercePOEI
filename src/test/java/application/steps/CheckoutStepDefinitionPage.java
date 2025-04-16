package application.steps;

import application.pages.CartPage;
import application.pages.CheckoutPage;
import application.utils.WebDriverManager;

public class CheckoutStepDefinitionPage {

    private final CheckoutPage checkoutPage;

    public CheckoutStepDefinitionPage(WebDriverManager webDriverManager){
        checkoutPage = new CheckoutPage(webDriverManager);
    }
}
