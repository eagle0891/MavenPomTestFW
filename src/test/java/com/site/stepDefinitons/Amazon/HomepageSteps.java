package com.site.stepDefinitons.Amazon;

import com.site.base.TestBase;
import com.site.pages.Amazon.Homepage;
import com.site.pages.Amazon.ProductListPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class HomepageSteps extends TestBase {
    Homepage homepage;
    ProductListPage productListPage;

    public HomepageSteps() {
        super();
    }

    @Given("^I am on the Amazon homepage$")
    public void navigateToHomepage() {
        initialization();
        homepage = new Homepage();
    }

    @And("^I accept cookies$")
    public void acceptCookies() {
        homepage.acceptCookies();
    }

    @Then("^I should see the Amazon logo$")
    public void verifyAmazonLogo() {
        Assert.assertTrue(homepage.verifyAmazonLogoIsDisplayed(), "Amazon logo is not displayed");
    }

    @Then("^I should see the header menu links$")
    public void verifyHeaderMenuLinksDisplayed() {
        Assert.assertTrue(homepage.verifyHeaderMenuLinksDisplayed(), "Menu header links are not displayed");
    }

    @And("^the landing page is correct after clicking on the header menu links$")
    public void clickThroughHeaderMenuLinks() {
        homepage.getHeaderMenuLinksAndVerifyUrl();
    }

    @And("^I search for a product '(.*)'$")
    public void searchForAProduct(String searchTerm) {
        homepage.searchForAProduct(searchTerm);
    }

    @And("^I see the search results for '(.*)'$")
    public void verifyTheSearchResultsPage(String searchTerm) throws InterruptedException {
        productListPage = new ProductListPage();
        homepage.verifySearchResultsConfirmationText(searchTerm);
        productListPage.getProducts();

    }
}
