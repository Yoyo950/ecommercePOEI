package application.pages.external_pages;

import application.pages.abstract_pages.BasePage;
import application.utils.WebDriverManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;

/**
 * La page utilisée pour la boîte mail jetable (utilisée pour la réinitialisation du mdp)
 * @author Yoann DAGAND
 */
public class MailJetablePage extends BasePage {

    /**Le lien qui permet de réinitialiser le mdp, présent dans le premier mail*/
    @FindBy(xpath = "//table[@bgcolor = '#ffffff']//table//a")
    private WebElement findLink;

    /**Pour valider le pop-up si présent*/
    @FindBy(xpath = "/html/body/div[2]/div[2]/div[2]/div[2]/div[2]/button[1]")
    private WebElement acceptButton;

    /**La iFrame contenant la boîte de réception*/
    @FindBy(name = "ifinbox")
    private WebElement iframeInbox;

    /**La iFrame contenant le contenu du mail*/
    @FindBy(name = "ifmail")
    private WebElement iframeMail;

    /**L'élément pour entrer le mail temporaire et accéder à la boîte de réception*/
    @FindBy(name = "login")
    private WebElement login;

    /**Le titre du mail, utilisé pour vérifier que le deuxième mail est bien reçu*/
    @FindBy(xpath = "/html/body/header/div[3]/div[1]")
    private WebElement titleMailMdp;

    /**Bouton permettant de refresh la boîte de réception*/
    @FindBy(id = "refresh")
    private WebElement refresh;

    /**La window handle de la page, utilisée pour changer entre cette page et les pages du site*/
    private String windowHandle;

    /**Constructeur de la classe, hérite de BasePage*/
    public MailJetablePage(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }

    /**
     * Permet d'ouvrir la page de la boîte mail temporaire (yopmail.com)
     */
    public void openPage(){
        driver.switchTo().newWindow(WindowType.TAB);
        windowHandle = driver.getWindowHandle();
        driver.get("https://yopmail.com/fr/");
        acceptButton.click();
    }

    /**
     * Permet d'entrer le mail temporaire dans le champ et de login sur la boîte mail temporaire
     */
    public void enterMailInLogin() {
        System.setProperty("email_temp", "temppoeimailjetable" + System.currentTimeMillis() + "@yopmail.com");
        login.sendKeys(System.getProperty("email_temp") + Keys.ENTER);
    }

    /**
     * Permet de clicker sur le lien permettant de réinitialiser le mot de passe dans le mail
     */
    public void clickOnLinkAndGoBack() throws InterruptedException {
        driver.switchTo().window(windowHandle);
        //Attente le temps de recevoir le mail
        Thread.sleep(20000);
        this.switchToFirstMail();
        //Clique sur le lien de réinitialisation
        findLink.click();
        driver.switchTo().window(windowHandle);
        driver.switchTo().defaultContent();
    }

    /**
     * Permet de vérifier si le mail changement de mot de passe a été reçu
     * @return true si le mail est bien le mail de modification de mdp, false sinon
     */
    public boolean verifyMail() throws InterruptedException {
        driver.switchTo().window(windowHandle);
        //Refresh pour enlever le pop-up si présent
        driver.navigate().refresh();
        //Attente le temps de recevoir le mail
        Thread.sleep(20000);
        this.switchToFirstMail();
        //Vérification du mail
        boolean temp = titleMailMdp.getText().trim().contains("Your new password");
        driver.switchTo().defaultContent();
        return temp;
    }

    /**
     * Permet d'afficher le dernier mail reçu et d'aller dans son iframe
     */
    private void switchToFirstMail() throws InterruptedException {
        refresh.click();
        //Attente pour le refresh
        Thread.sleep(1000);
        driver.switchTo().defaultContent();
        driver.switchTo().frame(iframeMail);
    }
}
