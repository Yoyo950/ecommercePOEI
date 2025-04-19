package application.pages.site;

import application.pages.abstract_pages.BaseSitePage;
import application.utils.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactPage extends BaseSitePage {

    public ContactPage(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }

    @FindBy(css = "h1.page-heading")
    private WebElement contactPageHeading;

    /**
     * Vérifie si l'utilisateur est bien sur la page "Contact Us".
     *
     * @return true si l'élément "Customer service - Contact us" est visible
     */
    public boolean isContactPageDisplayed() {
        return contactPageHeading.isDisplayed() &&
                contactPageHeading.getText().equalsIgnoreCase("Customer service - Contact us");
    }
}
