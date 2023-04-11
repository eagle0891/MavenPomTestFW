package com.site.pages;

import com.site.base.TestBase;
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

    public WebElement getHomeMenuIcon(){
        return homeMenuIcon;
    }

    public WebElement getCalendarIcon(){
        return calendarMenuIcon;
    }

    public WebElement getContactsIcon(){
        return contactsMenuIcon;
    }

    public Boolean verifyHomeMenuIconIsDisplayed(){
        return homeMenuIcon.isDisplayed();
    }

    public Boolean verifyCalendarMenuIconIsDisplayed(){
        return calendarMenuIcon.isDisplayed();
    }

    public Boolean verifyContactsMenuIconIsDisplayed(){
        return contactsMenuIcon.isDisplayed();
    }

    public HomePage clickOnHomeIcon(){
        homeMenuIcon.click();
        return new HomePage();
    }

    public CalendarPage clickOnCalendarIcon(){
        calendarMenuIcon.click();
        return new CalendarPage();
    }

    public ContactsPage clickOnContactsIcon(){
        contactsMenuIcon.click();
        return new ContactsPage();
    }

    public Boolean verifyUserNameIsDisplayed(){
        return userNameDisplay.isDisplayed();
    }

    public String userNameText(){
        return userNameDisplay.getText();
    }

}
