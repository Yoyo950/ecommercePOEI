package application.steps.site;

import application.pages.site.ContactPage;
import application.utils.WebDriverManager;

public class ContactStepDefinitionPage {
    private final ContactPage contactPage;

    public ContactStepDefinitionPage(WebDriverManager webDriverManager){
        contactPage = new ContactPage(webDriverManager);
    }
}
