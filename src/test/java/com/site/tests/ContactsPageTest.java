package com.site.tests;

import com.site.base.TestBase;
import com.site.pages.ContactsPage;
import com.site.pages.HomePage;
import com.site.pages.LoginPage;
import com.site.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ContactsPageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    ContactsPage contactsPage;
    TestUtil testUtil;

    String sheetName = "Contacts";

    public ContactsPageTest(){
        super();
    }

    @BeforeMethod
    public void setUp() throws InterruptedException {
        initialization();
        contactsPage = new ContactsPage();
        loginPage = new LoginPage();
        homePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));

        Thread.sleep(5000);
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

    @Test(priority = 2)
    public void selectDefaultDropdownView() {
        contactsPage.getViewDropdownField().click();
        contactsPage.selectDefaultDropdownView();
    }

    @Test(priority = 3)
    public void selectSearchOptionTest() {
        Assert.assertTrue(contactsPage.contactTableHeaderIsDisplayed(), "The contact table header is not displayed");
        contactsPage.clickShowFilterButton();
        contactsPage.clickSearchDropdownField();
        contactsPage.selectSearchOptionFromDropdown("Department");
    }

    @DataProvider
    public Object[][] getCRMTestData(){
        Object data[][] = TestUtil.getTestData(sheetName);
        return data;
    }

    @Test(priority = 4, dataProvider = "getCRMTestData")
    public void createContactTest(String firstName, String middleName, String lastName) throws InterruptedException {
        contactsPage.clickCreateContactButton();
        Assert.assertTrue(contactsPage.firstNameFieldIsDisplayed(), "First name field is not displayed");
        contactsPage.populateCreateContactForm(firstName, middleName, lastName);
        contactsPage.clickSaveButton();
        contactsPage.contactNameIsDisplayed();
        Thread.sleep(2000);
        Assert.assertEquals(contactsPage.getContactNameText(), firstName + " " + lastName, "Contact name does not match expected value");
        Thread.sleep(5000);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
