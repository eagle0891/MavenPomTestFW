package com.site.tests;

import com.site.base.TestBase;
import com.site.listeners.TestAllureReportListener;
import com.site.pages.HomePage;
import com.site.pages.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({TestAllureReportListener.class})
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
    @Severity(SeverityLevel.NORMAL)
    @Description("Test case description: Verify that the user name is displayed on the homepage as expected")
    @Story("Story name: Check that the user name is displayed")
    public void verifyUserNameIsDisplayed(){
        Assert.assertTrue(homePage.verifyUserNameIsDisplayed(), "Username after log is not displayed");
        Assert.assertEquals(homePage.userNameText(), "Ugo Agwo", "Username does not match expected value");
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test case description: Verify that the menu options are displayed as expected")
    @Story("Story name: Check that the menu options are displayed")
    public void verifyMenuIconsTest(){
        System.out.println("Menu icon tests");
        Assert.assertTrue(homePage.verifyHomeMenuIconIsDisplayed(), "Home Menu icon is NOT displayed");
        Assert.assertTrue(homePage.verifyCalendarMenuIconIsDisplayed(), "Calendar Menu icon is NOT displayed");
        Assert.assertTrue(homePage.verifyContactsMenuIconIsDisplayed(), "Contacts Menu icon is NOT displayed");
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test case description: Verify that the user can click on the homepage menu icon")
    @Story("Story name: Check that the user can click on the homepage menu icon")
    public void clickOnHomeMenuIcon(){
        homePage.clickOnHomeIcon();
    }

    @Test(priority = 4)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test case description: Verify that the user can click on the calendar menu icon")
    @Story("Story name: Check that the user can click on the calendar menu icon")
    public void clickOnCalendarMenuIcon(){
        homePage.clickOnCalendarIcon();
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test case description: Verify that the user can click on the contacts menu icon")
    @Story("Story name: Check that the user can click on the contacts menu icon")
    public void clickOnContactsMenuIcon(){
        homePage.clickOnContactsIcon();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
