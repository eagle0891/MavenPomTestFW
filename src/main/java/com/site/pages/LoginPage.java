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

    public String validateLoginPageTitle(){
        return driver.getTitle();
    }

    public WebElement forgotPasswordLink(){
        return forgotPasswordLink;
    }

    public String forgotPasswordText(){
        return forgotPasswordLink.getText();
    }

    public String signUpMessageText(){
        return signUpMessage.getText();
    }

    public WebElement getSignUpMessageLink(){
        return signUpLink;
    }

    public HomePage login(String emailAddress, String pass){
        emailField.sendKeys(emailAddress);
        passwordField.sendKeys(pass);
        loginButton.click();

        return new HomePage(); //this method type is "public HomePage" because the login flow should navigate the user to the homepage, and hence return the HomePage
    }

    public WebElement failedLoginValidationBlock(){
        return failedLoginValidationBlock;
    }

    public String failedLoginValidationMessageLineOne(){
        return failedLoginValidationMessageLineOne.getText();
    }

    public String failedLoginValidationMessageLineTwo(){
        return failedLoginValidationMessageLineTwo.getText();
    }
}
