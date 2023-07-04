package com.site.stepDefinitons.Amazon;

import com.site.pages.Amazon.ProductListPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class ProductListPageSteps {

    ProductListPage productListPage;

    public ProductListPageSteps() {
        super();
    }

    @When("^I click on a '(.*)' product$")
    public void clickOnAProduct(String brand) throws InterruptedException {
        productListPage = new ProductListPage();
//        productListPage.clickOnAProduct(brand);
//        productListPage.findProductTypeAndClick(brand);
        productListPage.findProductAndClick(brand);
    }

    @Then("^I should see the product details page for the '(.*)' product$")
    public void iShouldSeeTheProductDetailsPageForTheBrandProduct() {
    }

    @When("^I add item to cart$")
    public void addItemToCart() {
        productListPage.clickAddToCart();
    }

    @Then("^I should see the mini cart$")
    public void confirmMiniCartIsDisplayed() {
        Assert.assertTrue(productListPage.isMiniCartDisplayed(), "Mini cart is NOT displayed");
    }

}
