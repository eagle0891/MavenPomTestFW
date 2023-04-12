package com.site.tests;

import com.site.base.TestBase;
import com.site.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginPageTest extends TestBase {
    LoginPage loginPage;

    public LoginPageTest(){
        super(); //"super" will allow this class to call the TestBase class' "TestBase" constructor - ctrl+click on "super" to see what it calls
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        loginPage = new LoginPage();
    }

    @Test(priority=1)
    public void loginPageTitleTest(){
        System.out.println("login page title test");
        String pageTitle = loginPage.validateLoginPageTitle();
        Assert.assertEquals(pageTitle, "Cogmento CRM");
    }

    @Test(priority=2)
    public void verifyForgotPasswordSection(){
        System.out.println("Verifying forgot password section");
        loginPage.forgotPasswordLink().isDisplayed();
        Assert.assertEquals(loginPage.forgotPasswordText(),"Forgot your password?");
    }

    @Test(priority=3)
    public void verifySignUpSection(){
        System.out.println("Verifying Sign up section");
        Assert.assertEquals(loginPage.signUpMessageText(),"No Account? Registration takes only a few seconds? Sign Up");
        loginPage.getSignUpMessageLink().isDisplayed();
    }

    @Test(priority = 4)
    public void successfulLogin(){
        System.out.println("Login test");
        loginPage.login(prop.getProperty("email"), prop.getProperty("password") );
    }

    @Test(priority = 5)
    public void blankLoginValidation(){
        loginPage.login("", "");
        Assert.assertTrue(loginPage.failedLoginValidationBlock().isDisplayed());
        Assert.assertEquals(loginPage.failedLoginValidationMessageLineOne(), "Something went wrong...");
        Assert.assertEquals(loginPage.failedLoginValidationMessageLineTwo(), "Invalid request");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
