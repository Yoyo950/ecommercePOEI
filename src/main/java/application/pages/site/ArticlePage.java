package application.pages.site;

import application.pages.abstract_pages.BaseSitePage;
import application.utils.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import application.utils.ConfigReader;

import java.time.Duration;

/**
 * Page représentant une page d'article individuel.
 * Permet de vérifier le titre de l'article affiché.
 * Hérite de BaseSitePage pour les éléments communs.
 *
 * @author Fatima Zahrae
 */
public class ArticlePage extends BaseSitePage {

    @FindBy(css = "h1[itemprop='name']")
    private WebElement articleTitle;

    public ArticlePage(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }

    /**
     * Vérifie que l'utilisateur est bien sur la page de l'article attendu.
     *
     * @param expectedArticleName Le nom de l'article attendu
     * @return true si le titre de l'article correspond, sinon false
     */
    public boolean isOnArticlePage(String expectedArticleName) {
        int timeout = Integer.parseInt(ConfigReader.getProperty("timeout"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOf(articleTitle));
        return articleTitle.getText().trim().equalsIgnoreCase(expectedArticleName);
    }
}
