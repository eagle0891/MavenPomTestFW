package com.site.tests;

import com.site.base.TestBase;
import com.site.pages.HomePage;
import com.site.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;

    public HomePageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        loginPage = new LoginPage();
        homePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
    }

    @Test(priority=1)
    public void verifyUserNameIsDisplayed(){
        Assert.assertTrue(homePage.verifyUserNameIsDisplayed(), "Username after log is not displayed");
        Assert.assertEquals(homePage.userNameText(), "Ugo Agwo", "Username does not match expected value");
    }

    @Test(priority = 2)
    public void verifyMenuIconsTest(){
        System.out.println("Menu icon tests");
        Assert.assertTrue(homePage.verifyHomeMenuIconIsDisplayed(), "Home Menu icon is NOT displayed");
        Assert.assertTrue(homePage.verifyCalendarMenuIconIsDisplayed(), "Calendar Menu icon is NOT displayed");
        Assert.assertTrue(homePage.verifyContactsMenuIconIsDisplayed(), "Contacts Menu icon is NOT displayed");
    }

    @Test(priority = 3)
    public void clickOnHomeMenuIcon(){
        homePage.clickOnHomeIcon();
    }

    @Test(priority = 4)
    public void clickOnCalendarMenuIcon(){
        homePage.clickOnCalendarIcon();
    }

    @Test(priority = 3)
    public void clickOnContactsMenuIcon(){
        homePage.clickOnContactsIcon();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
