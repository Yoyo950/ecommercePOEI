package application.steps.external_pages;

import application.pages.external_pages.MailJetablePage;
import application.utils.WebDriverManager;

public class MailJetableStepDefinitionPage {

    private final MailJetablePage mailJetablePage;

    public MailJetableStepDefinitionPage(WebDriverManager webDriverManager){
        mailJetablePage = new MailJetablePage(webDriverManager);
    }
}
