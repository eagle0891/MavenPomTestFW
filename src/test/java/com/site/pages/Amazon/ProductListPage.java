package com.site.pages.Amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

import static com.site.base.TestBase.driver;

public class ProductListPage {

    public ProductListPage() {
        PageFactory.initElements(driver, this);
    }

    /****************** Page Factory ******************/
    private static final By productTile = By.cssSelector("[data-component-type=\"s-search-result\"]");
    private static final By addToCartButton = By.cssSelector("#add-to-cart-button");
    private static final By miniCart = By.cssSelector("#nav-flyout-ewc .nav-flyout-body");
    private static final By productTileBrandTitle = By.cssSelector(".s-title-instructions-style .a-row.a-size-base.a-color-secondary");

    /******************* Methods ***********************/
    public void clickOnAProduct(String brand) {
        driver.findElements(productTile).stream()
                .filter(product -> product.findElement(productTileBrandTitle).getText().contains(brand))
                .findFirst()
                .get()
                .click();
    }

    public void clickAddToCart() {
        driver.findElement(addToCartButton).click();
    }

    /******************* Booleans ***********************/
    public boolean isMiniCartDisplayed() {
        return driver.findElement(miniCart).isDisplayed();
    }
}
