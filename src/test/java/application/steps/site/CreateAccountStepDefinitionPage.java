package application.steps.site;

import application.pages.site.CreateAccountPage;
import application.utils.WebDriverManager;

public class CreateAccountStepDefinitionPage {
    private final CreateAccountPage createAccountPage;

    public CreateAccountStepDefinitionPage(WebDriverManager webDriverManager){
        createAccountPage = new CreateAccountPage(webDriverManager);
    }
}
