package application.steps;

import application.pages.AuthentificationPage;
import application.pages.CartPage;
import application.utils.WebDriverManager;

public class CartStepDefinitionPage {

    private final CartPage cartPage;

    public CartStepDefinitionPage(WebDriverManager webDriverManager){
        cartPage = new CartPage(webDriverManager);
    }
}
