package com.site.stepDefinitons.Amazon;

import com.site.base.TestBase;
import com.site.pages.Amazon.Homepage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class HomepageSteps extends TestBase {
    Homepage homepage;

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
        Assert.assertTrue(homepage.verifyAmazonLogoIsDisplayed());
    }
}
