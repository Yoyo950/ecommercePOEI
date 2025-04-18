package application.pages.site;

import application.pages.abstract_pages.BaseSitePage;
import application.utils.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class MyAccountPage extends BaseSitePage {

    public MyAccountPage(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }

    @FindBy(xpath = "//*[@id='center_column']/div[2]/a")
    public WebElement add_a_new_address_button;

    @FindBy(xpath ="//*[@id='center_column']/div/div/ul/li[3]/a")
    public WebElement my_adresses_button;

    @FindBy (xpath = "//*[@id='center_column']/div[1]/div/div/ul/li[9]/a[1]")
    public WebElement my_update_button;

    @FindBy (id= "submitAddress")
    public WebElement save_button;

    @FindBy(xpath="//*[@id='center_column']/div[1]/div/div/ul")
    public WebElement my_adresses_field;

    @FindBy (css = "//*[@id=\"center_column\"]/p[2]")
    public WebElement no_address_message_field;

    @FindBy (xpath = "//*[@id='center_column']/div/div/ul/li[1]/a")
    public WebElement add_my_first_address_button;

    @FindBy (xpath = "//*[@id='center_column']/div/div/ul/li[2]/a/span")
    public WebElement order_history_and_details_button;

    @FindBy (xpath = "//*[@id='center_column']/div/div/ul/li[3]/a/span")
    public WebElement my_credit_slips_button;

    @FindBy (xpath ="//*[@id='center_column']/div/div/ul/li[5]/a/span")
    public  WebElement my_personal_information_button;

    @FindBy (xpath = "//*[@id='center_column']/p[1]")
    public WebElement account_created_message_field;

    @FindBy (id="alias")
    public WebElement address_title_field;

    @FindBy(id="address1")
    public WebElement address_field;

    @FindBy (id="city")
    public WebElement city_field;

    @FindBy (id="id_state")
    public WebElement state_field;
    public Select selectState = new Select(state_field);

    @FindBy (id = "postcode")
    public WebElement postal_code_field;

    @FindBy(id ="phone")
    public WebElement phone_field;

}
