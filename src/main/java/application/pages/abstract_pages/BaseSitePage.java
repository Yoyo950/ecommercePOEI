package application.pages.abstract_pages;

import application.utils.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Objects;

/**
 * Classe Mère de toutes les pages du site, contient les boutons communs ainsi que des méthodes pour les manipuler
 * @author Yoann DAGAND
 */
public abstract class BaseSitePage extends BasePage {

    /**Elément Web du logo du site*/
    @FindBy(id = "header_logo")
    private WebElement logo;

    /**Elément Web de la barre de recherche du site*/
    @FindBy(id = "search_query_top")
    private WebElement search_bar;

    /**Elément Web de la loupe à cliquer pour lancer la recherche*/
    @FindBy(name = "submit_search")
    private WebElement submit_search;

    /**Lien permettant d'accéder au shopping cart*/
    @FindBy(xpath = "//div[@class = 'shopping_cart']/a")
    private WebElement cart_link;

    /**Lien permettant d'accéder à la page 'My Account' (si l'utilisateur est connecté)*/
    @FindBy(xpath = "//a[@class = 'account']/span")
    private WebElement account;

    /**Lien permettant d'accéder à la page 'Contact Us'*/
    @FindBy(xpath = "//div[@id = 'contact-link']/a")
    private WebElement contact;

    /**Lien permettant d'accéder à la page d'authentification (si l'utilisateur n'est pas connecté*/
    @FindBy(xpath = "//a[@class = 'login']")
    private WebElement sign_in;

    /**Lien permettant de se déconnecter (si l'utilisateur est connecté*/
    @FindBy(xpath = "//a[@class = 'logout']")
    private WebElement sign_out;

    /**Bouton permettant d'accéder à la liste de produits de la catégorie 'Woman'*/
    @FindBy(xpath = "//div[@id = 'block_top_menu']/ul/li[1]/a")
    private WebElement women_category;

    /**Bouton permettant d'accéder à la liste de produits de la catégorie 'Dresses'*/
    @FindBy(xpath = "//div[@id = 'block_top_menu']/ul/li[2]/a")
    private WebElement dresses_category;

    /**Bouton permettant d'accéder à la liste de produits de la catégorie 'T-Shirts'*/
    @FindBy(xpath = "//div[@id = 'block_top_menu']/ul/li[3]/a")
    private WebElement tshirt_category;

    /**Bouton permettant d'accéder au blog de Prestashop*/
    @FindBy(xpath = "//div[@id = 'block_top_menu']/ul/li[4]/a")
    private WebElement blog;

    /**Liste de résultats de recherche*/
    @FindBy(xpath = "//div[@class = 'ac_results']/ul")
    private WebElement list_results;

    private final String windowHandle;

    public BaseSitePage(WebDriverManager webDriverManager) {
        super(webDriverManager);
        windowHandle = webDriverManager.getWebDriver().getWindowHandle();
    }

    public String getWindowHandle() {
        return windowHandle;
    }

    /**
     * Permet de vérifier si le logo est bien visible
     * @return true si présent, false sinon.
     */
    public boolean logoIsDisplayed(){
        return logo.isDisplayed();
    }

    /**
     * Permet de cliquer sur le logo du site.
     */
    public void clickOnLogo() {
        logo.click();
    }

    /**
     * Permet de vérifier la présence de la barre de recherche et de la loupe
     * @return true si présent, false sinon.
     */
    public boolean searchBarAndHandLensIsDisplayed(){
        return search_bar.isDisplayed() && submit_search.isDisplayed();
    }

    /**
     * Permet d'entrer une chaine de caractères dans la barre de recherche
     * @param input String saisi dans la barre de recherche
     */
    public void enterInSearchBar(String input){
        search_bar.sendKeys(input);
    }

    /**
     * Permet de submit une recherche tapée dans la barre de recherche
     */
    public void clickOnSubmitSearch() {
        submit_search.click();
    }

    /**
     * Permet de vérifier la présence du panier dans la page
     * @return true si présent, false sinon.
     */
    public boolean cartIsDisplayed() {
        return cart_link.isDisplayed();
    }

    /**
     * Permet de cliquer sur le cart afin de se rendre sur la page cart
     */
    public void clickOnCart(){
        cart_link.click();
    }

    /**
     * Permet de vérifier si le prénom et nom sont bien affichés
     * @param name Le prénom de l'utilisateur
     * @param surname Le nom de famille de l'utilisateur
     * @return true si présent, false sinon
     */
    public boolean nameAndSurnameIsDisplayed(String name, String surname) {
        return account.isDisplayed() && account.getText().equals(name + " " + surname);
    }

    /**
     * Permet de se rendre sur la page 'My Account'
     */
    public void clickOnAccount() {
        account.click();
    }

    /**
     * Permet de se rendre sur la page 'Contact Us'
     */
    public void clickOnContactUs() {
        contact.click();
    }

    /**
     * Permet de savoir si l'utilisateur est connecté
     * @return true si connecté, false sinon
     */
    public boolean userIsConnected() {
        return sign_out.isDisplayed();
    }

    /**
     * Permet de savoir si l'utilisateur n'est pas connecté
     * @return true si non connecté, false sinon
     */
    public boolean userIsNotConnected() {
        return sign_in.isDisplayed();
    }

    /**
     * Permet de vérifier si le bouton 'Sign In' est présent
     * @return true si présent, false sinon
     */
    public boolean signInIsDisplayed() {
        return sign_in.isDisplayed();
    }

    /**
     * Permet de se rendre sur la page 'Authentification' (si l'utilisateur n'est pas connecté)
     */
    public void clickOnSignIn() {
        sign_in.click();
    }

    /**
     * Permet de vérifier si le bouton 'Sign Out' est présent, avec le lien correspondant
     * @return true si présent et conforme, false sinon
     */
    public boolean signOutIsDisplayed() {
        return sign_out.isDisplayed() && Objects.equals(sign_out.getDomAttribute("href"), "http://www.automationpractice.pl/index.php?mylogout=");
    }

    /**
     * Permet de se déconnecter (si l'utilisateur est connecté)
     */
    public void clickOnSignOut() {
        sign_out.click();
    }

    /**
     * Permet de vérifier que la catégorie 'Woman' est présente
     * @return true si présente, false sinon.
     */
    public boolean womanCategoryIsDisplayed() {
        return women_category.isDisplayed();
    }

    /**
     * Permet de consulter la catégorie 'Woman'
     */
    public void clickOnWomanCategory() {
        women_category.click();
    }

    /**
     * Permet de vérifier que la catégorie 'Dresses' est présente
     * @return true si présente, false sinon.
     */
    public boolean dressesCategoryIsDisplayed() {
        return dresses_category.isDisplayed();
    }

    /**
     * Permet de consulter la catégorie 'Dresses'
     */
    public void clickOnDressesCategory() {
        dresses_category.click();
    }

    /**
     * Permet de vérifier que la catégorie 'T-Shirt' est présente
     * @return true si présente, false sinon.
     */
    public boolean tShirtCategoryIsDisplayed() {
        return tshirt_category.isDisplayed();
    }

    /**
     * Permet de consulter la catégorie 'T-Shirt'
     */
    public void clickOnTShirtCategory() {
        tshirt_category.click();
    }

    /**
     * Permet de vérifier que l'accès au blog est présent
     * @return true si présent, false sinon.
     */
    public boolean blogIsDisplayed() {
        return blog.isDisplayed();
    }

    /**
     * Permet de consulter le blog Prestashop
     */
    public void clickOnBlog() {
        blog.click();
    }

    /**
     * Permet de vérifier si l'article est proposé dans la barre de recherche
     * @param article Le nom de l'article
     * @return true si présent, false sinon
     */
    public boolean articleIsDisplayed(String article) {
        List<WebElement> list = list_results.findElements(By.xpath("//li"));
        for(WebElement elem : list) {
            if(elem.getText().contains(article)){
                return true;
            }
        }
        return false;
    }

    /**
     * Permet de cliquer sur l'article proposé par rapport au param
     * @param article Le nom de l'article
     */
    public void clickOnArticle(String article) {
        List<WebElement> list = list_results.findElements(By.xpath("//li"));
        for(WebElement elem : list) {

            if(elem.getText().contains(article)){
                elem.click();
                break;
            }
        }
    }
}
