package com.site.tests;

import com.site.base.TestBase;
import com.site.pages.ContactsPage;
import com.site.pages.HomePage;
import com.site.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContactsPageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    ContactsPage contactsPage;

    public ContactsPageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        contactsPage = new ContactsPage();
        loginPage = new LoginPage();
        homePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
        homePage.clickOnContactsIcon();
    }

    @Test(priority = 1)
    public void contactsPageHealthCheck() {
        Assert.assertTrue(contactsPage.contactsPageHeaderIsDisplayed(), "Contacts page header is not displayed");
        Assert.assertEquals(contactsPage.contactsPageTitleText(), "Contacts", "Contacts header does not match expected value");
        Assert.assertTrue(contactsPage.viewDropdownFieldIsDisplayed(), "The view dropdown field is not displayed");
        Assert.assertTrue(contactsPage.showFilterButtonIsDisplayed(), "The show filter button is not displayed");
        Assert.assertTrue(contactsPage.createButtonIsDisplayed(), "The create button is not displayed");
        Assert.assertTrue(contactsPage.exportButtonIsDisplayed(), "The export button is not displayed");
        System.out.println("Contacts page health-check complete");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
