package application.steps;

import application.pages.SearchPage;
import application.pages.TwitterPage;
import application.utils.WebDriverManager;

public class TwitterStepDefinitionPage {

    private final TwitterPage twitterPage;

    public TwitterStepDefinitionPage(WebDriverManager webDriverManager){
        twitterPage = new TwitterPage(webDriverManager);
    }
}
