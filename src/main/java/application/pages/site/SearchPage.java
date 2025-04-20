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

    @FindBy(css = "span.cat-name")
    private WebElement categoryNameElement;

    /**
     * Récupère directement le texte du span contenant uniquement le nom de la catégorie.
     */
    public String getDisplayedCategoryName() {
        return categoryNameElement.getText().trim();
    }
}
