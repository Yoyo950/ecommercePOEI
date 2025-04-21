package application.pages.external_pages;

import application.pages.abstract_pages.BasePage;
import application.utils.ConfigReader;
import application.utils.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;

public class MailJetablePage extends BasePage {

    @FindBy(xpath = "//table[@bgcolor = '#ffffff']//table//a")
    private WebElement findLink;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div[2]/div[2]/div[2]/button[1]")
    private WebElement acceptButton;

    @FindBy(name = "ifinbox")
    private WebElement iframeInbox;

    @FindBy(name = "ifmail")
    private WebElement iframeMail;

    @FindBy(name = "login")
    private WebElement login;

    @FindBy(xpath = "/html/body/header/div[3]/div[1]")
    private WebElement titleMailMdp;

    @FindBy(id = "refresh")
    private WebElement refresh;

    @FindBy(id = "dismiss-button")
    private WebElement dismissPopUp;

    private String windowHandle;


    public MailJetablePage(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }

    public void openPage(){
        driver.switchTo().newWindow(WindowType.TAB);
        windowHandle = driver.getWindowHandle();
        driver.get("https://yopmail.com/fr/");
        acceptButton.click();
    }

    public void enterMailInLogin() {
        login.sendKeys(ConfigReader.getProperty("mail_temporaire") + Keys.ENTER);
    }

    public void clickOnLinkAndGoBack() throws InterruptedException {
        driver.switchTo().window(windowHandle);
        Thread.sleep(20000);
        this.switchToFirstMail();
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
        driver.navigate().refresh();
        Thread.sleep(20000);
        this.switchToFirstMail();
        boolean temp = titleMailMdp.getText().trim().contains("Your new password");
        driver.switchTo().defaultContent();
        return temp;
    }

    private void switchToFirstMail() throws InterruptedException {
        refresh.click();
        Thread.sleep(2000);
        driver.switchTo().defaultContent();
        driver.switchTo().frame(iframeMail);
    }
}
