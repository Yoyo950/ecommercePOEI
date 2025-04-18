package application.pages.site;

import application.pages.abstract_pages.BaseSitePage;
import application.utils.WebDriverManager;
import application.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Page représentant la création d'un compte utilisateur sur l'application.
 * @author Fatima Zahrae
 */
public class CreateAccountPage extends BaseSitePage {

    /**
     * Identifiants des éléments de la page de création de compte.
     */
    @FindBy(xpath = "//div[@id = 'noSlide']/h1")
    private WebElement pageHeading;

    @FindBy(id = "id_gender1")
    private WebElement titleMrRadioButton;

    @FindBy(id = "id_gender2")
    private WebElement titleMrsRadioButton;

    @FindBy(id = "customer_firstname")
    private WebElement firstNameInput;

    @FindBy(id = "customer_lastname")
    private WebElement lastNameInput;

    @FindBy(id = "passwd")
    private WebElement passwordInput;

    @FindBy(id = "days")
    private WebElement dayOfBirthSelect;

    @FindBy(id = "months")
    private WebElement monthOfBirthSelect;

    @FindBy(id = "years")
    private WebElement yearOfBirthSelect;

    @FindBy(id = "newsletter")
    private WebElement newsletterCheckbox;

    @FindBy(css = "div.alert.alert-danger ol li")
    private WebElement errorMessage;


    public CreateAccountPage(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }

    @FindBy(id = "submitAccount")
    private WebElement registerButton;


    /**
     * Remplit le formulaire de création d'un compte.
     */
    public void remplirFormulaireCreationCompte(String genre, String prenom, String nom, String motDePasse, String dateNaissance, String newsletter) {
        int timeout = Integer.parseInt(ConfigReader.getProperty("timeout"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOf(firstNameInput));

        if (genre.equalsIgnoreCase("Mr")) {
            titleMrRadioButton.click();
        } else if (genre.equalsIgnoreCase("Mrs")) {
            titleMrsRadioButton.click();
        }

        firstNameInput.clear();
        firstNameInput.sendKeys(prenom);

        lastNameInput.clear();
        lastNameInput.sendKeys(nom);

        passwordInput.clear();
        passwordInput.sendKeys(motDePasse);

        if (!dateNaissance.isEmpty()) {
            String[] parts = dateNaissance.split("/");
            new Select(dayOfBirthSelect).selectByValue(parts[0]);
            new Select(monthOfBirthSelect).selectByValue(String.valueOf(Integer.parseInt(parts[1])));
            new Select(yearOfBirthSelect).selectByValue(parts[2]);
        }

        if (newsletter.equalsIgnoreCase("coché") && !newsletterCheckbox.isSelected()) {
            newsletterCheckbox.click();
        } else if (newsletter.equalsIgnoreCase("non coché") && newsletterCheckbox.isSelected()) {
            newsletterCheckbox.click();
        }
    }

    /**
     * Clique sur le bouton "Register" pour finaliser la création du compte.
     */
    public void clickRegisterButton() throws InterruptedException {
        registerButton.click();
        Thread.sleep(2000);
    }

    /**
     * Récupère le message d'erreur affiché lors de la création d'un compte.
     *
     * @return Le texte du message d'erreur affiché.
     */
    public String getErreurCreationCompte() {
        int timeout = Integer.parseInt(ConfigReader.getProperty("timeout"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOf(errorMessage));
        return errorMessage.getText().trim();
    }

    /**
     * Vérifie si l'utilisateur est sur la page "Create an Account".
     *
     * @return true si le titre de la page est "Create an account", false sinon.
     */
    public boolean estSurPageCreateAccount() {
        int timeout = Integer.parseInt(ConfigReader.getProperty("timeout"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOf(pageHeading));
        return pageHeading.getText().trim().equalsIgnoreCase("Create an account");
    }
}
