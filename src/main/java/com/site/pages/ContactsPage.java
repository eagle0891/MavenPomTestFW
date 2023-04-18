package com.site.pages;

import com.site.base.TestBase;
import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class ContactsPage extends TestBase {

    @FindBy(xpath = "//span[contains(@class, 'selectable')]")
    @CacheLookup
    WebElement contactsPageTitle;

    @FindBy(xpath = "//div[contains(@class, 'ui selection scrolling dropdown')]")
    WebElement viewDropdownField;

    @FindBy(xpath = "//button[contains(@class, 'ui linkedin button')]")
    WebElement showFilterButton;

    @FindBy(xpath = "//button[contains(@class, 'ui linkedin button')]/i[contains(@class, 'download icon')]")
    WebElement exportButton;

    @FindBy(xpath = "//button[contains(@class, 'ui linkedin button')]/i[contains(@class, 'edit icon')]")
    WebElement createButton;

    @FindBy(xpath = "//button[contains(@class, 'ui button')]/i[contains(@class, 'cancel icon')]")
    WebElement cancelButton;

    @FindBy(xpath = "//div[contains(@class, 'ui active visible selection scrolling dropdown')]//span[contains(@class, 'text')]")
    WebElement defaultViewDropdownOption;

    @FindBy(xpath = "//div[contains(@class, 'ui top attached menu')]//div[contains(@class, 'ui header')]")
    WebElement filterFieldHeader;

    @FindBy(xpath = "//div[contains(@class, 'ui search selection dropdown')]")
    WebElement searchDropdownField;

    @FindBy(xpath = "//div[contains(@class, 'visible menu transition')]")
    WebElement searchDropdownList;

    @FindBy(xpath = "//div[contains(@class, 'visible menu transition')]//span[contains(@class, 'text')]")
    WebElement searchOption;

    @FindBy(xpath = "//thead[contains(@class, 'full-width')]")
    WebElement contactTableHeader;

    @FindBy(xpath = "//div[contains(@class, 'visible menu transition')]//span[contains(@class, 'text')]")
    List<WebElement> searchDropdownListBlock;

    @FindBy(xpath = "//input[@name='first_name']")
    WebElement firstNameField;

    @FindBy(xpath = "//input[@name='last_name']")
    WebElement lastNameField;

    @FindBy(xpath = "//input[@name='middle_name']")
    WebElement middleNameField;

    @FindBy(xpath = "//button[@class='ui linkedin button']/i[@class='save icon']")
    WebElement saveButton;

    @FindBy(xpath = "//span[@class='selectable ']")
    WebElement contactName;

    @FindBy(xpath = "//div[@class='ui active inline loader']")
    WebElement inlineLoader;

    @FindBy(xpath = "//div[@class='ui attached tabular menu']")
    WebElement contactsTable;

    public ContactsPage(){
        PageFactory.initElements(driver, this);
    }

    /***************** WEBELEMENTS *******************/

    public WebElement getViewDropdownField(){
        return viewDropdownField;
    }

    public WebElement getFilterFieldHeader(){
        return filterFieldHeader;
    }

    public WebElement getSearchDropdownField(){
        return searchDropdownField;
    }

    public WebElement getSearchDropdownList(){
        return searchDropdownList;
    }

    public WebElement getFirstNameField(){
        return firstNameField;
    }

    public WebElement getLastNameField(){
        return lastNameField;
    }

    public WebElement getMiddleNameField(){
        return middleNameField;
    }

    public WebElement getCancelButton(){
        return cancelButton;
    }

    public WebElement getCreateContactButton(){
        return createButton;
    }

    public WebElement getInlineLoader(){
        return inlineLoader;
    }

    public WebElement getContactsTable(){
        return contactsTable;
    }

    /***************** BOOLEANS *******************/

    public Boolean contactsPageHeaderIsDisplayed(){
        return contactsPageTitle.isDisplayed();
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

    public boolean firstNameFieldIsDisplayed(){
        return waitForElementToBeVisible(driver, firstNameField, Duration.ofSeconds(20)).isDisplayed();
    }

    public boolean contactNameIsDisplayed(){
        return contactName.isDisplayed();
    }

    public boolean contactsTableIsDisplayed(){
        return waitForElementToBeVisible(driver, getContactsTable(), Duration.ofSeconds(10)).isDisplayed();
    }

    /***************** STRINGS ********************/

    public String contactsPageTitleText(){
        return contactsPageTitle.getText();
    }

    public String getFilterFieldHeaderText(){
        return filterFieldHeader.getText();
    }

    public String getContactNameText(){
        return waitForElementToBeVisible(driver, contactName, Duration.ofSeconds(20)).getText();
    }

    /****************** VOIDS ********************/

    public void selectDefaultDropdownView(){
        Actions action = new Actions(driver);
        action.moveToElement(defaultViewDropdownOption).build().perform();
        defaultViewDropdownOption.click();
    }

    public void clickSearchDropdownField(){
        searchDropdownField.click();
    }

    public boolean contactTableHeaderIsDisplayed(){
        return contactTableHeader.isDisplayed();
    }

    public void selectSearchOptionFromDropdown(String searchOptionText){
        for (WebElement searchOption : searchDropdownListBlock) {
            System.out.println(searchOption.getText());
            if (searchOption.getText().equals(searchOptionText)){
                searchOption.click();
            }
        }
    }

    public void clickShowFilterButton(){
        showFilterButton.click();
    }

    public void clickCreateContactButton(){
        waitForElementToBeClickable(driver, getCreateContactButton(), Duration.ofSeconds(10)).click();
    }

    public void clickCancelButton(){
        waitForElementToBeClickable(driver, getCancelButton(), Duration.ofSeconds(10)).click();
    }

    public void populateCreateContactForm(String firstName, String middleName, String lastName){
        getFirstNameField().sendKeys(firstName);
        getLastNameField().sendKeys(lastName);
        getMiddleNameField().sendKeys(middleName);
    }

    public void clickSaveButton(){
        saveButton.click();
    }

    public void waitForElementToAppearAndDisappear(){
        waitForElementToBeVisible(driver, getInlineLoader(), Duration.ofSeconds(2));
        waitForElementToBeInvisible(driver, getInlineLoader(), Duration.ofSeconds(2));
    }
}

