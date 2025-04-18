package application.pages.site;

import application.pages.abstract_pages.BaseSitePage;
import application.utils.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import application.utils.ConfigReader;
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;

/**
 * Page représentant la création/modification d'adresse de l'utilisateur.
 * Permet de vérifier que l'utilisateur est bien sur la page des adresses.
 * Hérite de BaseSitePage pour la navigation commune.
 *
 * @author Fatima Zahrae
 */
public class CreateModifyAddressPage extends BaseSitePage {

    @FindBy(css = "h1.page-subheading")
    private WebElement addressPageTitle;

    @FindBy(id = "phone")
    private WebElement homePhoneInput;

    @FindBy(id = "address1")
    private WebElement addressInput;

    @FindBy(id = "city")
    private WebElement cityInput;

    @FindBy(id = "id_state")
    private WebElement stateDropdown;

    @FindBy(id = "postcode")
    private WebElement postalCodeInput;

    @FindBy(id = "alias")
    private WebElement addressTitleInput;

    @FindBy(id = "submitAddress")
    private WebElement saveButton;

    public CreateModifyAddressPage(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }

    /**
     * Vérifie que le titre "Your addresses" est affiché sur la page.
     *
     * @return true si le titre est visible, sinon false
     */
    public boolean isOnAddressCreationPage() {
        int timeout = Integer.parseInt(ConfigReader.getProperty("timeout"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOf(addressPageTitle));
        return addressPageTitle.isDisplayed() && addressPageTitle.getText().equalsIgnoreCase("Your addresses");
    }

    /**
     * Remplit le formulaire d'ajout/modification d'adresse et valide.
     *
     * @param telephone Numéro de téléphone
     * @param adresse Adresse
     * @param ville Ville
     * @param state État
     * @param codePostal Code postal
     * @param addressTitle Titre d'adresse
     */
    public void fillAddressForm(String telephone, String adresse, String ville, String state, String codePostal, String addressTitle) {
        int timeout = Integer.parseInt(ConfigReader.getProperty("timeout"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));

        wait.until(ExpectedConditions.visibilityOf(homePhoneInput));

        homePhoneInput.clear();
        homePhoneInput.sendKeys(telephone);

        addressInput.clear();
        addressInput.sendKeys(adresse);

        cityInput.clear();
        cityInput.sendKeys(ville);

        new Select(stateDropdown).selectByVisibleText(state);

        postalCodeInput.clear();
        postalCodeInput.sendKeys(codePostal);

        addressTitleInput.clear();
        addressTitleInput.sendKeys(addressTitle);

    }

    /**
     * Clique sur le bouton "Save" pour valider l'adresse.
     */
    public void clickSaveButton() {
        saveButton.click();
    }

}
