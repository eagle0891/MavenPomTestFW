package com.site.pages;

import com.site.base.TestBase;
import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage extends TestBase {

    @FindBy(xpath = "//span[contains(@class, 'selectable')]")
    WebElement contactsPageTitle;

    @FindBy(xpath = "//div[contains(@class, 'ui selection scrolling dropdown')]")
    WebElement viewDropdownField;

    @FindBy(xpath = "//button[contains(@class, 'ui linkedin button')]")
    WebElement showFilterButton;

    @FindBy(xpath = "//button[contains(@class, 'ui linkedin button')]/i[contains(@class, 'download icon')]")
    WebElement exportButton;

    @FindBy(xpath = "//button[contains(@class, 'ui linkedin button')]/i[contains(@class, 'edit icon')]")
    WebElement createButton;

    public ContactsPage(){
        PageFactory.initElements(driver, this);
    }

    public Boolean contactsPageHeaderIsDisplayed(){
        return contactsPageTitle.isDisplayed();
    }

    public String contactsPageTitleText(){
        return contactsPageTitle.getText();
    }

    public Boolean viewDropdownFieldIsDisplayed(){
        return viewDropdownField.isDisplayed();
    }

    public Boolean showFilterButtonIsDisplayed(){
        return showFilterButton.isDisplayed();
    }

    public Boolean exportButtonIsDisplayed(){
        return exportButton.isDisplayed();
    }

    public Boolean createButtonIsDisplayed(){
        return createButton.isDisplayed();
    }

}
