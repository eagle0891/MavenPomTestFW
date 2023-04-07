package com.site.tests;

import com.site.base.TestBase;
import com.site.pages.LoginPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

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
}
