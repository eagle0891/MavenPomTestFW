package com.site.pages;

import com.site.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {

    //PageFactory
    @FindBy(name="email")
    WebElement emailField;

    @FindBy(name="password")
    WebElement passwordField;

    @FindBy(xpath="//div[contains(@class, 'sui fluid large blue submit button')]")
    WebElement loginButton;

    @FindBy(xpath="//div/a[contains(@href, 'https://register.cogmento.com/password/reset/request/?lang=en-GB']")
    WebElement forgotPasswordLink;

    @FindBy(xpath="//div[contains(@class, 'ui message')]")
    WebElement signUpMessage;

    //Initializing page objects
    public LoginPage(){
        //"driver" will initialise FindBy elements, and "this" is equivalent to current class object i.e. "LoginPage.class"
        PageFactory.initElements(driver, this);
    }

    public String validateLoginPageTitle(){
        return driver.getTitle();
    }

    public boolean validateForgotPasswordLink(){
        return forgotPasswordLink.isDisplayed();
    }

    public String validateForgotPasswordText(){
        return forgotPasswordLink.getText();
    }

    public String validateSignUpMessage(){
        return signUpMessage.getText();
    }

    public HomePage login(String emailAddress, String pass){
        emailField.sendKeys(emailAddress);
        passwordField.sendKeys(pass);
        loginButton.click();

        return new HomePage(); //this method type is "public HomePage" because the login flow should navigate the user to the homepage, and hence return the HomePage
    }
}
