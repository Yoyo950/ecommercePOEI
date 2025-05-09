package application.pages.site;

import application.pages.abstract_pages.BaseSitePage;
import application.utils.ConfigReader;
import application.utils.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Page représentant le formulaire d'authentification de l'application e-commerce.
 * Permet de saisir les identifiants utilisateur (email et mot de passe) et de se connecter.
 * Hérite de BaseSitePage pour inclure les éléments de navigation communs.
 *
 * @author Fatima Zahrae
 */
public class AuthentificationPage extends BaseSitePage {

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "passwd")
    private WebElement passwordInput;

    @FindBy(id = "SubmitLogin")
    private WebElement signInButton;

    @FindBy(css = "a.account")
    private WebElement accountNameLink;

    @FindBy(xpath = "//h1[text()='Authentication']")
    private WebElement authenticationTitle;

    @FindBy(linkText = "Forgot your password?")
    private WebElement forgotPasswordLink;

    @FindBy(id = "email_create")
    private WebElement emailCreateInput;

    @FindBy(id = "SubmitCreate")
    private WebElement createAccountButton;

    @FindBy(id = "create_account_error")
    private WebElement accountCreationError;

    @FindBy(id = "customer_firstname")
    private WebElement createAccountFirstNameField;

    @FindBy(xpath = "//*[@id = 'center_column']/div[@class = 'alert alert-danger']")
    private WebElement errorConnexion;


    /**
     * Constructeur de la page Authentification.
     *
     * @param webDriverManager Manager du WebDriver pour initialiser les éléments de la page.
     */
    public AuthentificationPage(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }

    /**
     * Remplit les champs Email et Password avec les valeurs fournies.
     *
     * @param email Adresse email de l'utilisateur.
     * @param password Mot de passe de l'utilisateur.
     */
    public void enterCredentials(String email, String password) {
        emailInput.clear();
        emailInput.sendKeys(email);

        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    /**
     * Clique sur le bouton "Sign In" pour soumettre le formulaire de connexion.
     */
    public void clickSignIn() throws InterruptedException {
        signInButton.click();
        Thread.sleep(2000);
    }

    /**
     * Vérifie que l'utilisateur est sur la page d'authentification.
     *
     * @return true si le titre "Authentication" est visible, false sinon.
     */
    public boolean isAuthenticationPageDisplayed() {
//        int timeout = Integer.parseInt(ConfigReader.getProperty("timeout"));
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
//        wait.until(ExpectedConditions.visibilityOf(authenticationTitle));
        System.out.println("debugage; "+authenticationTitle.getText());
        return authenticationTitle.isDisplayed();
    }

    /**
     * Clique sur le lien "Forgot your password?" pour accéder à la page de réinitialisation.
     */
    public void clickForgotPassword() throws InterruptedException {
        forgotPasswordLink.click();
    }

    /**
     * Remplit le champ Email pour créer un compte avec l'email fourni.
     *
     * @param email Email à saisir dans le champ de création de compte.
     */
    public void enterEmailForAccountCreation(String email) {
        emailCreateInput.clear();
        emailCreateInput.sendKeys(email);
    }

    /**
     * Clique sur le bouton "Create an account" pour démarrer la création de compte.
     */
//    public void clickCreateAccountButton() {
//        int timeout = Integer.parseInt(ConfigReader.getProperty("timeout"));
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
//
//        wait.until(ExpectedConditions.elementToBeClickable(createAccountButton));
//        createAccountButton.click();
//
//        wait.until(ExpectedConditions.visibilityOf(createAccountFirstNameField));
//    }

    public void clickCreateAccountButton() {
        int timeout = Integer.parseInt(ConfigReader.getProperty("timeout"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));

        // Clic sur le bouton
        wait.until(ExpectedConditions.elementToBeClickable(createAccountButton));
        createAccountButton.click();

        // Maintenant attendre soit le champ prénom soit le message d'erreur
        try {
            wait.until(ExpectedConditions.or(
                    ExpectedConditions.visibilityOf(createAccountFirstNameField),
                    ExpectedConditions.visibilityOf(accountCreationError)
            ));
        } catch (Exception e) {
            System.out.println("Ni formulaire, ni erreur affichée après création de compte");
        }
    }



    /**
     * Récupère le message d'erreur affiché lors de la création de compte.
     *
     * @return le texte du message d'erreur.
     */
    public String getAccountCreationErrorMessage() {
        return accountCreationError.getText().trim();
    }

    /**
     * Permet de vérifier si le message d'erreur de connexion est bien présent sur la page
     * @param message Le message attendu
     * @return true si présent, false sinon
     */
    public boolean messageErrorIsPresent(String message) {
        return errorConnexion.getText().contains(message);
    }

}
