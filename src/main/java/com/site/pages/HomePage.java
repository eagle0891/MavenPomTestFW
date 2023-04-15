package com.site.pages;

import com.site.base.TestBase;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {

    @FindBy(xpath="//i[contains(@class, 'home ico')]")
    WebElement homeMenuIcon;

    @FindBy(xpath = "//i[contains(@class, 'calendar icon')]")
    WebElement calendarMenuIcon;

    @FindBy(xpath = "//i[contains(@class, 'users icon')]")
    WebElement contactsMenuIcon;

    @FindBy(xpath = "//i[contains(@class, 'building icon')]")
    WebElement companiesMenuIcon;

    @FindBy(xpath = "//i[contains(@class, 'money icon')]")
    WebElement dealsMenuIcon;

    @FindBy(xpath = "//span[contains(@class, 'user-display')]")
    WebElement userNameDisplay;

    public HomePage(){
        PageFactory.initElements(driver, this);
    }

    @Step("Get Home menu icon")
    public WebElement getHomeMenuIcon(){
        return homeMenuIcon;
    }


    @Step("Get Calendar menu icon")
    public WebElement getCalendarIcon(){
        return calendarMenuIcon;
    }

    @Step("Get Contacts menu icon")
    public WebElement getContactsIcon(){
        return contactsMenuIcon;
    }

    @Step("Verify home menu icon is displayed")
    public Boolean verifyHomeMenuIconIsDisplayed(){
        return homeMenuIcon.isDisplayed();
    }

    @Step("Verify calendar menu icon is displayed")
    public Boolean verifyCalendarMenuIconIsDisplayed(){
        return calendarMenuIcon.isDisplayed();
    }

    @Step("Verify contacts menu icon is displayed")
    public Boolean verifyContactsMenuIconIsDisplayed(){
        return contactsMenuIcon.isDisplayed();
    }

    @Step("Click on home menu icon")
    public HomePage clickOnHomeIcon(){
        homeMenuIcon.click();
        return new HomePage();
    }

    @Step("Click on calendar menu icon")
    public CalendarPage clickOnCalendarIcon(){
        calendarMenuIcon.click();
        return new CalendarPage();
    }

    @Step("Click on contacts menu icon")
    public ContactsPage clickOnContactsIcon(){
        contactsMenuIcon.click();
        return new ContactsPage();
    }

    @Step("Verify username is displayed")
    public Boolean verifyUserNameIsDisplayed(){
        return userNameDisplay.isDisplayed();
    }

    @Step("Get the username display text")
    public String userNameText(){
        return userNameDisplay.getText();
    }

}
