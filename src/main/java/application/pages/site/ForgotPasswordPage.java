package application.pages.site;

import application.pages.abstract_pages.BaseSitePage;
import application.utils.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * La page permettant d'entrer son mail afin de recevoir un mail de réinitialisation de mdp
 * Hérite de BaseSitePage
 * @author Yoann DAGAND
 */
public class ForgotPasswordPage extends BaseSitePage {

    /**Le champ avec lequel l'adresse mail est entrée*/
    @FindBy(id = "email")
    private WebElement input;

    /**Le bouton pour valider le formulaire*/
    @FindBy(xpath = "//*[@id=\"form_forgotpassword\"]/fieldset/p/button")
    private WebElement submit;

    /**Le formulaire, utilisé pour vérifier si l'on est bien sur la page*/
    @FindBy(id = "form_forgotpassword")
    private WebElement formForgotPassword;

    /**L'alerte affichant que le mail a été envoyé, utilisé pour vérifier l'envoi du mail*/
    @FindBy(xpath = "//div[@id = 'center_column']/div/p[@class = 'alert alert-success']")
    private WebElement alertSuccess;

    /**Le constructeur de la classe, hérite de celui de BaseSitePage*/
    public ForgotPasswordPage(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }

    /**Entre l'email temporaire dans le champ 'input'*/
    public void enterEmail() {
        input.sendKeys(System.getProperty("email_temp"));
    }

    /**
     * Clique sur le bouton 'submit' du formulaire
     */
    public void submitEmail() {
        submit.click();
    }

    /**
     * Permet de vérifier que l'on est sur la page ForgotPassword
     * @return true si l'on est sur la bonne page, false sinon
     */
    public boolean isOnForgotPasswordPage() {
        return formForgotPassword.isDisplayed();
    }

    /**
     * Permet de vérifier si le mail a été envoyé
     * @return true si le mail a été envoyé, false sinon
     */
    public boolean mailIsSent() {
        return alertSuccess.isDisplayed() && alertSuccess.getText().contains("A confirmation email has been sent to your address");
    }


}