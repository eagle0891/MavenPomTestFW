package com.site.pages.Amazon;

import com.site.base.TestBase;
import com.site.pages.HomePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage extends TestBase {

    public Homepage(){
        PageFactory.initElements(driver, this);
    }

    /****************** Page Factory ******************/

    @FindBy(css="#sp-cc-accept")
    WebElement acceptCookiesButton;

    @FindBy(css="[id=\"nav-logo-sprites\"][aria-label=\"Amazon.co.uk\"]")
    WebElement amazonLogo;

    /******************* Getters ***********************/

    public WebElement getAcceptCookiesButton(){
        return acceptCookiesButton;
    }

    public WebElement getAmazonLogo(){
        return amazonLogo;
    }

    /****************** Actions ******************/

    public void acceptCookies(){
        acceptCookiesButton.click();
    }

    public Boolean verifyAmazonLogoIsDisplayed(){
        return amazonLogo.isDisplayed();
    }
}
