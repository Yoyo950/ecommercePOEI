package application.pages.site;

import application.pages.abstract_pages.BaseSitePage;
import application.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BaseSitePage {
    public HomePage(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }

    @FindBy(id ="home-page-tabs")
    public WebElement homePageTabs;

    @FindBy(xpath = "//a[@title='My first address']")
    public WebElement addMyFirstAddressButton;

    @FindBy(xpath ="//*[@id=\"homeslider\"]/li[2]/div")
    public WebElement firstAd;
}
