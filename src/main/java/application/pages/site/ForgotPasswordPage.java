package application.pages.site;

import application.pages.abstract_pages.BaseSitePage;
import application.utils.ConfigReader;
import application.utils.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgotPasswordPage extends BaseSitePage {

    @FindBy(id = "email")
    private WebElement input;

    @FindBy(xpath = "//button[@type = 'submit']")
    private WebElement submit;

    public ForgotPasswordPage(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }

    public void enterEmail() {
        input.sendKeys(ConfigReader.getProperty("mail_temporaire"));
    }

    public void submitEmail() {
        submit.click();
    }


}
