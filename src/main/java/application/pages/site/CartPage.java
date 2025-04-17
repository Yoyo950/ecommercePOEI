package application.pages.site;

import application.pages.abstract_pages.BaseSitePage;
import application.utils.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BaseSitePage {
    /**
     * This class represents the Cart page of the application.
     * It extends the BaseSitePage class and contains elements specific to the Cart page.
     */
    public CartPage(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }

    @FindBy(id = "cart_title")
    public WebElement cartTitle;

}
