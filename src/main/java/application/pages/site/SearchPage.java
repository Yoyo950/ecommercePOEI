package application.pages.site;

import application.pages.abstract_pages.BaseSitePage;
import application.utils.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BaseSitePage {
    public SearchPage(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }

    @FindBy(xpath= "//*[@id='center_column']/h1")
    public WebElement search_result_title_bar;

    @FindBy(id ="search_query_top")
    public WebElement search_bar;

}
