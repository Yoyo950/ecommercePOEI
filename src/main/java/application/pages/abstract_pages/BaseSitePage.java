package application.pages.abstract_pages;

import application.utils.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BaseSitePage extends BasePage {

    @FindBy(id = "header_logo")
    private WebElement logo;

    @FindBy(id = "search_query_top")
    private WebElement search_bar;

    @FindBy(name = "submit_search")
    private WebElement submit_search;

    @FindBy(xpath = "//div[@class = 'shopping_cart']/a")
    private WebElement cart_link;

    @FindBy(xpath = "//a[@class = 'logout']")
    private WebElement sign_out;

    public BaseSitePage(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }
}
