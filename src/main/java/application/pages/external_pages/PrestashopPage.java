package application.pages.external_pages;

import application.pages.abstract_pages.BasePage;
import application.utils.WebDriverManager;

public class PrestashopPage extends BasePage {

    public PrestashopPage(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }

    /**
     * Vérifie que l'URL actuelle contient "prestashop".
     *
     * @return true si l'URL contient "prestashop", false sinon.
     */
    public boolean isOnPrestashopSite() {
        String currentUrl = driver.getCurrentUrl();
        return currentUrl.contains("prestashop");
    }
}
