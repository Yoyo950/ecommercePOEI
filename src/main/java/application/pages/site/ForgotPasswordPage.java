package application.pages.site;

import application.pages.abstract_pages.BaseSitePage;
import application.utils.ConfigReader;
import application.utils.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgotPasswordPage extends BaseSitePage {

    @FindBy(id = "email")
    private WebElement input;

    @FindBy(xpath = "//*[@id=\"form_forgotpassword\"]/fieldset/p/button")
    private WebElement submit;

    @FindBy(id = "form_forgotpassword")
    private WebElement formForgotPassword;

    @FindBy(xpath = "//div[@id = 'center_column']/div/p[@class = 'alert alert-success']")
    private WebElement alertSuccess;

    public ForgotPasswordPage(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }

    public void enterEmail() {
        input.sendKeys(System.getProperty("email_temp"));
    }

    public void submitEmail() {
        submit.click();
    }

    public boolean isOnForgotPasswordPage() {
        return formForgotPassword.isDisplayed();
    }

    public boolean mailIsSent() {
        return alertSuccess.isDisplayed() && alertSuccess.getText().contains("A confirmation email has been sent to your address");
    }


}