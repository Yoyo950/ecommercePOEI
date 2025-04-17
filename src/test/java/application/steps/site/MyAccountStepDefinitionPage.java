package application.steps.site;

import application.pages.site.MyAccountPage;
import application.utils.WebDriverManager;

public class MyAccountStepDefinitionPage {
    private final MyAccountPage myAccountPage;

    public MyAccountStepDefinitionPage(WebDriverManager webDriverManager){
        myAccountPage = new MyAccountPage(webDriverManager);
    }
}
