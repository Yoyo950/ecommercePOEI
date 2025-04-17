package application.steps.site;

import application.pages.site.CreateModifyAddressPage;
import application.utils.WebDriverManager;

public class CreateModifyAddressStepDefinitionPage {
    private final CreateModifyAddressPage createModifyAddressPage;

    public CreateModifyAddressStepDefinitionPage(WebDriverManager webDriverManager){
        createModifyAddressPage = new CreateModifyAddressPage(webDriverManager);
    }
}
