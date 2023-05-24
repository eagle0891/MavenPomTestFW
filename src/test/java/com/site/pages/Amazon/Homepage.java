package com.site.pages.Amazon;

import com.site.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Homepage extends TestBase {

    public Homepage(){
        PageFactory.initElements(driver, this);
    }

    /****************** Page Factory ******************/

    @FindBy(css="#sp-cc-accept")
    WebElement acceptCookiesButton;

    @FindBy(css="[id=\"nav-logo-sprites\"][aria-label=\"Amazon.co.uk\"]")
    WebElement amazonLogo;

    @FindBy(css="#nav-xshop-container")
    WebElement headerMenuLinksContainer;

    @FindBy(css=".nav-a")
    WebElement headerMenuLink;

    @FindBy(css="#twotabsearchtextbox")
    WebElement searchBox;

    @FindBy(css="#nav-search-submit-button")
    WebElement searchButton;

    @FindBy(css=".s-breadcrumb span:first-child")
    WebElement searchResultsConfrmationTextPt1;

    @FindBy(css=".s-breadcrumb span:nth-child(3)")
    WebElement searchResultsConfrmationTextPt2;

    /******************* Getters ***********************/

    public WebElement getAcceptCookiesButton(){
        return acceptCookiesButton;
    }

    public WebElement getAmazonLogo(){
        return amazonLogo;
    }

    public WebElement getHeaderMenuLinksContainer(){
        return headerMenuLinksContainer;
    }

    public WebElement getSearchBox(){
        return searchBox;
    }

    public WebElement getSearchButton(){
        return searchButton;
    }

    public WebElement getSearchResultsConfrmationTextPt1(){
        return searchResultsConfrmationTextPt1;
    }

    public WebElement getSearchResultsConfrmationTextPt2(){
        return searchResultsConfrmationTextPt2;
    }

    /****************** Actions ******************/
    //Clicks
    public void acceptCookies(){
        getAcceptCookiesButton().click();
    }

    public void clickSearchButton(){
        getSearchButton().click();
    }

    //Verify element is displayed
    public Boolean verifyAmazonLogoIsDisplayed(){
        return getAmazonLogo().isDisplayed();
    }

    public Boolean verifyHeaderMenuLinksDisplayed(){
        return getHeaderMenuLinksContainer().isDisplayed();
    }

    //Searches
    public void searchForAProduct(String searchTerm){
        getSearchBox().sendKeys(searchTerm);
        clickSearchButton();
    }

    //Navigation
    public void getHeaderMenuLinksAndVerifyUrl() {
        for(int i = 0; i < getHeaderMenuLinksContainer().findElements(By.cssSelector(".nav-a")).size(); i++) {
            String linkHref = getHeaderMenuLinksContainer().findElements(By.cssSelector(".nav-a")).get(i).getAttribute("href");
            try {
                getHeaderMenuLinksContainer().findElements(By.cssSelector(".nav-a")).get(i).click();
                String truncatedHref = linkHref.substring(linkHref.indexOf("?"));
                Assert.assertTrue(driver.getCurrentUrl().contains(truncatedHref), "Page URL is not correct");
            } catch (Exception e) {
                System.out.println("Element is not visible. Exception: " + e);
                break;
            }
        }
    }

    public void verifySearchResultsConfirmationText(String searchTerm){
        Assert.assertTrue(getSearchResultsConfrmationTextPt1().getText().contains("results for"), "Search results confirmation text is not correct");
        Assert.assertEquals("\"" + searchTerm + "\"", getSearchResultsConfrmationTextPt2().getText(),
                "Search results confirmation text does not contain search term");
    }


}
