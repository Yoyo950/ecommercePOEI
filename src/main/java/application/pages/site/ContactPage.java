package application.pages.site;

import application.pages.abstract_pages.BaseSitePage;
import application.utils.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactPage extends BaseSitePage {

    public ContactPage(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }

    @FindBy(id = "id_contact")
    public WebElement SubjectHeading_List_box;
}
