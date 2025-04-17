package application.steps.site;

import application.pages.site.CartPage;
import application.utils.WebDriverManager;

public class CartStepDefinitionPage {

    private final CartPage cartPage;

    public CartStepDefinitionPage(WebDriverManager webDriverManager){
        cartPage = new CartPage(webDriverManager);
    }
}
