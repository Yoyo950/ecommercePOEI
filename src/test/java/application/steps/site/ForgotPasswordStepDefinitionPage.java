package application.steps.site;

import application.pages.site.ForgotPasswordPage;
import application.utils.WebDriverManager;

public class ForgotPasswordStepDefinitionPage {
    private final ForgotPasswordPage forgotPasswordPage;

    public ForgotPasswordStepDefinitionPage(WebDriverManager webDriverManager){
        forgotPasswordPage = new ForgotPasswordPage(webDriverManager);
    }
}
