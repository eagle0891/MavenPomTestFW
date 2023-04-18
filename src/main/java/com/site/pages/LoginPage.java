package com.site.pages;

import com.site.base.TestBase;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class LoginPage extends TestBase {

    //PageFactory
    @FindBy(name="email")
    WebElement emailField;

    @FindBy(name="password")
    WebElement passwordField;

    @FindBy(xpath="//div[contains(@class, 'ui fluid large blue submit button')]")
    WebElement loginButton;

    @FindBy(xpath="//a[contains(@href, 'https://register.cogmento.com/password/reset/request/?lang=en-GB')]")
    WebElement forgotPasswordLink;

    @FindBy(xpath="//div[2][contains(@class, 'ui message')]")
    WebElement signUpMessage;

    @FindBy(xpath="//a[contains(@href, 'https://api.cogmento.com/register?lang=en-GB')]")
    WebElement signUpLink;

    @FindBy(xpath = "//div[contains(@class, 'ui negative message')]")
    WebElement failedLoginValidationBlock;

    @FindBy(xpath = "//div[contains(@class, 'ui negative message')]/div[contains(@class, 'header')]")
    WebElement failedLoginValidationMessageLineOne;

    @FindBy(xpath = "//div[contains(@class, 'ui negative message')]/p")
    WebElement failedLoginValidationMessageLineTwo;

    //Initializing page objects
    public LoginPage(){
        //"driver" will initialise FindBy elements, and "this" is equivalent to current class object i.e. "LoginPage.class"
        PageFactory.initElements(driver, this);
    }

    @Step("Get page title")
    public String validateLoginPageTitle(){
        return driver.getTitle();
    }

    @Step("Get page forgot password link")
    public WebElement forgotPasswordLink(){
        return forgotPasswordLink;
    }

    @Step("Get page forgot password text")
    public String forgotPasswordText(){
        return forgotPasswordLink.getText();
    }

    @Step("Get page sign up message text")
    public String signUpMessageText(){
        return signUpMessage.getText();
    }

    @Step("Get page sign up link")
    public WebElement getSignUpMessageLink(){
        return signUpLink;
    }

    @Step("Login with username: {0}, and password: {1}")
    public HomePage login(String emailAddress, String pass){
        emailField.sendKeys(emailAddress);
        passwordField.sendKeys(pass);
        loginButton.click();
        return new HomePage(); //this method type is "public HomePage" because the login flow should navigate the user to the homepage, and hence return the HomePage
    }

    @Step("Get failed login validation block")
    public WebElement failedLoginValidationBlock(){
        return failedLoginValidationBlock;
    }

    @Step("Get failed login validation message (line one)")
    public String failedLoginValidationMessageLineOne(){
        return failedLoginValidationMessageLineOne.getText();
    }

    @Step("Get failed login validation message (line two)")
    public String failedLoginValidationMessageLineTwo(){
        return failedLoginValidationMessageLineTwo.getText();
    }
}
