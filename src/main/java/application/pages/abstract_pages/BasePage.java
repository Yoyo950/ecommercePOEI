package application.pages.abstract_pages;

import application.utils.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Classe de base, héritée par toutes les autres pages.
 * Permet d'initialiser le driver et les @FindBy via l'initialisation des éléments avec PageFactory
 * @author Yoann DAGAND
 */
public abstract class BasePage {

    /**
     * Le driver utilisé pour les tests
     */
    protected final WebDriver driver;

    /**
     * Le constructeur de BasePage, initialise le driver et les éléments
     * @param webDriverManager Le WebDriverManager, récupéré via PicoContainer
     */
    public BasePage(WebDriverManager webDriverManager) {
        this.driver = webDriverManager.getWebDriver();
        PageFactory.initElements(driver, this);
    }
}
