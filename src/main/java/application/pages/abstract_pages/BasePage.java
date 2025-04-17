package application.pages.abstract_pages;

import application.utils.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    protected final WebDriver driver;

    public BasePage(WebDriverManager webDriverManager) {
        this.driver = webDriverManager.getWebDriver();
        PageFactory.initElements(driver, this);
    }
}
