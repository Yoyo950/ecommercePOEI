package application.pages.external_pages;

import application.pages.abstract_pages.BasePage;
import application.utils.ConfigReader;
import application.utils.WebDriverManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MailJetablePage extends BasePage {

    @FindBy(xpath = "//table[@bgcolor = '#ffffff']//table//a")
    private WebElement findLink;

    @FindBy(name = "ifinbox")
    private WebElement iframeInbox;

    @FindBy(name = "ifmail")
    private WebElement iframeMail;

    @FindBy(name = "login")
    private WebElement login;

    @FindBy(xpath = "//div[@class = 'mctn']/div[2]/button")
    private WebElement firstMail;


    public MailJetablePage(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }

    public void enterMailInLogin() {
        login.sendKeys(ConfigReader.getProperty("mail_temporaire") + Keys.ENTER);
    }

    public void verifyMail(){
        driver.switchTo().frame(iframeMail);
        firstMail.click();
        driver.switchTo().defaultContent();
        driver.switchTo().frame(iframeInbox);

    }
}
