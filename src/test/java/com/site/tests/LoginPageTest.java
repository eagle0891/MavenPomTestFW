package com.site.tests;

import com.site.base.TestBase;
import com.site.listeners.TestAllureReportListener;
import com.site.pages.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;

@Listeners({TestAllureReportListener.class})
public class LoginPageTest extends TestBase {
    LoginPage loginPage;

    public LoginPageTest(){
        super(); //"super" will allow this class to call the TestBase class' "TestBase" constructor - ctrl+click on "super" to see what it calls
    }

    @BeforeMethod
    public void setUp(){
//        initializeExtentReports();
        initialization();
        loginPage = new LoginPage();
    }

    @Test(priority=1)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test case description: Verify that the log in page title is displayed as expected")
    @Story("Story name: Check that the log in title is displayed")
    public void loginPageTitleTest(){
        System.out.println("login page title test");
        String pageTitle = loginPage.validateLoginPageTitle();
        Assert.assertEquals(pageTitle, "Cogmento CRMs");
    }

    @Test(priority=2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test case description: Verify that the forgot password section is displayed as expected")
    @Story("Story name: Check that the forgot password section is displayed")
    public void verifyForgotPasswordSection(){
        System.out.println("Verifying forgot password section");
        loginPage.forgotPasswordLink().isDisplayed();
        Assert.assertEquals(loginPage.forgotPasswordText(),"Forgot your password?");
    }

    @Test(priority=3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test case description: Verify that the sign up section is displayed as expected")
    @Story("Story name: Check that sign up section is displayed")
    public void verifySignUpSection(){
        System.out.println("Verifying Sign up section");
        Assert.assertEquals(loginPage.signUpMessageText(),"No Account? Registration takes only a few seconds? Sign Up");
        loginPage.getSignUpMessageLink().isDisplayed();
    }

    @Test(priority = 4)
    @Severity(SeverityLevel.BLOCKER)
    @Description("Test case description: Verify that user can log in successfully.")
    @Story("Story name: Check that user can log in successfully")
    public void successfulLogin(){
        System.out.println("Login test");
        loginPage.login(prop.getProperty("email"), prop.getProperty("password") );
    }

    @Test(priority = 5)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test case description: Log in with blank username and password and check error message")
    @Story("Story name: Check that error message is displayed with blank credentials")
    public void blankLoginValidation(){
        loginPage.login("", "");
        Assert.assertTrue(loginPage.failedLoginValidationBlock().isDisplayed());
        Assert.assertEquals(loginPage.failedLoginValidationMessageLineOne(), "Something went wrong...");
        Assert.assertEquals(loginPage.failedLoginValidationMessageLineTwo(), "Invalid request");
    }

    @Test(priority = 6)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test case description: Verify Allure reports is generated as expected.")
    @Story("Story name: Check that allure reports is generated")
    public void extentTest(){
        System.out.println("Allure report is being tested");
    }

    @AfterMethod
    public void tearDown() throws IOException {
        driver.quit();
//        flushExtentReports();
    }
}
