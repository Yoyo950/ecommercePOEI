package application.steps;

import application.pages.external_pages.TwitterPage;
import application.utils.WebDriverManager;

public class TwitterStepDefinitionPage {

    private final TwitterPage twitterPage;

    public TwitterStepDefinitionPage(WebDriverManager webDriverManager){
        twitterPage = new TwitterPage(webDriverManager);
    }
}
