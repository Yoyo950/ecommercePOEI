package application.pages.site;

import application.pages.abstract_pages.BaseSitePage;
import application.utils.ConfigReader;
import application.utils.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyAccountPage extends BaseSitePage {

    public MyAccountPage(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }

    @FindBy(xpath = "//a[@title='Add an address']")
    public WebElement add_a_new_address_button;

    @FindBy(xpath ="//a[@title='Addresses']")
    public WebElement my_adresses_button;

    @FindBy (xpath = "//*[@id='center_column']/div[1]/div/div/ul/li[9]/a[1]")
    public WebElement my_update_button;

    @FindBy (id= "submitAddress")
    public WebElement save_button;

    @FindBy(xpath="//*[@id=\"center_column\"]/div/div/ul/li[4]/a/span")
    public WebElement my_adresses_field;

    @FindBy (xpath = "//*[@id=\"center_column\"]/p[2]")
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

    @FindBy (xpath = "//ul[@class= \"last_item item box\"]/li[1]/h3")
    public WebElement address_title_field;

    @FindBy(xpath = "//ul[@class= \"last_item item box\"]/li[4]/span[1]")
    public WebElement address_field;

    @FindBy (xpath = "//ul[@class= \"last_item item box\"]/li[5]/span[1]")
    public WebElement city_field;

    @FindBy (xpath = "//ul[@class= \"last_item item box\"]/li[5]/span[2]")
    public WebElement state_field;

    @FindBy (xpath = "//ul[@class= \"last_item item box\"]/li[5]/span[3]")
    public WebElement postal_code_field;

    @FindBy(xpath ="//ul[@class= \"last_item item box\"]/li[7]")
    public WebElement phone_field;

    public void isMyAccountPageDisplayed() {
        int timeout = Integer.parseInt(ConfigReader.getProperty("timeout"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.elementToBeClickable(my_adresses_button));
    }

}
