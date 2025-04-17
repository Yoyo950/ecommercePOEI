package application.steps;

import application.pages.site.CheckoutPage;
import application.utils.WebDriverManager;

public class CheckoutStepDefinitionPage {

    private final CheckoutPage checkoutPage;

    public CheckoutStepDefinitionPage(WebDriverManager webDriverManager){
        checkoutPage = new CheckoutPage(webDriverManager);
    }
}
