package application.pages.external_pages;

import application.pages.abstract_pages.BasePage;
import application.utils.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Page représentant le site partenaire PrestaShop.
 * Vérifie que l'utilisateur est bien redirigé sur la bonne page externe.
 */
public class PrestashopPage extends BasePage {

    @FindBy(css = "h1.color-3.t0--5.t0.title")
    private WebElement pageMainHeading;

    public PrestashopPage(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }

    /**
     * Vérifie que le texte du titre principal correspond au texte attendu.
     *
     * @param expectedText Le texte attendu pour la page PrestaShop.
     * @return true si le texte correspond, false sinon.
     */
    public boolean isMainHeadingCorrect(String expectedText) {
        return pageMainHeading.getText().trim().equals(expectedText);
    }
}
