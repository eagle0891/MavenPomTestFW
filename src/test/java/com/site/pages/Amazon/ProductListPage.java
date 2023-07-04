package com.site.pages.Amazon;

import com.site.models.GenericProduct;
import com.site.models.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


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
    private static final By PLP_PRODUCT_NAME = By.cssSelector("span.a-text-normal");
    private static final By PLP_PRODUCT_WHOLE_PRICE = By.cssSelector(".a-price-whole");
    private static final By PLP_PRODUCT_DECIMAL_PRICE = By.cssSelector(".a-price-fraction");
    private static final By PLP_PRODUCT_IMAGE_LINK = By.cssSelector(".s-image");
    private static final By PLP_PRODUCT_BRAND_NAME = By.cssSelector("h2.s-line-clamp-1 .a-size-base-plus.a-color-base");
    private static final By PLP_PRODUCT_TITLE_LINK = By.cssSelector(".s-underline-link-text");

    /******************* Methods ***********************/
    public void clickOnAProduct(String brand) {
        driver.findElements(productTile).stream()
                .filter(product -> product.findElement(productTileBrandTitle).getText().contains(brand))
                .findFirst()
                .get()
                .click();
    }

    public ArrayList<Product> getProducts() throws InterruptedException {
        Product.ProductCollection = new ArrayList<>();
        List<WebElement> products = driver.findElements(productTile);
        System.out.println("Number of products is: " + products.size());
        for (WebElement product : products) {
            try {
                String productName = product.findElement(PLP_PRODUCT_NAME).getText();
                String productWholePricePart = product.findElement(PLP_PRODUCT_WHOLE_PRICE).getText();
                String productDecimalPricePart = product.findElement(PLP_PRODUCT_DECIMAL_PRICE).getText();
                WebElement productImageLink = product.findElement(PLP_PRODUCT_IMAGE_LINK);
                String productBrandName = product.findElement(PLP_PRODUCT_BRAND_NAME).getText();
                String productTitleLinkUrl = product.findElement(PLP_PRODUCT_TITLE_LINK).getAttribute("href");
                System.out.println("Brand is: " + productBrandName);
                System.out.println("Product title is: " + productName);
                System.out.println("Product Price is: £" + productWholePricePart + "." + productDecimalPricePart);
                boolean isCasio = productBrandName.contains("Casio");
                WebElement casioSelection = null;
                if (isCasio) {
                    casioSelection = product.findElement(PLP_PRODUCT_NAME);
                }
                Product.ProductCollection.add(new Product(productBrandName, productName, productWholePricePart, productDecimalPricePart, product, isCasio, casioSelection, productImageLink));
            } catch (NoSuchElementException e) {
                System.out.println("**** Element does not contain a product ****" + "\n" + e.getMessage());
            }
        }
        System.out.println("Product Collection is: " + Product.ProductCollection);
        return Product.ProductCollection;
    }

    public ArrayList<GenericProduct> getGenericProducts() throws InterruptedException {
        GenericProduct.ProductCollection = new ArrayList<GenericProduct>();
        List<WebElement> genericProducts = driver.findElements(productTile);
        System.out.println("Number of products is: " + genericProducts.size());
        for (WebElement product : genericProducts) {
            try {
                String productName = product.findElement(PLP_PRODUCT_NAME).getText();
                String productWholePricePart = product.findElement(PLP_PRODUCT_WHOLE_PRICE).getText();
                String productDecimalPricePart = product.findElement(PLP_PRODUCT_DECIMAL_PRICE).getText();
                WebElement productImageLink = product.findElement(PLP_PRODUCT_IMAGE_LINK);
                System.out.println("Product title is: " + productName);
                System.out.println("Product Price is: £" + productWholePricePart + "." + productDecimalPricePart);
                GenericProduct.ProductCollection.add(new GenericProduct(productName, productWholePricePart, productDecimalPricePart, product, productImageLink));
            } catch (NoSuchElementException e) {
                System.out.println("**** Element does not contain a product ****" + "\n" + e.getMessage());
            }
        }
        System.out.println("Product Collection is: " + GenericProduct.ProductCollection);
        return GenericProduct.ProductCollection;
    }

    public void findProductTypeAndClick(String productType) throws InterruptedException {
        //clearProductCollectionIfPopulated();
        outer: for (Product product : Product.ProductCollection) {
            System.out.println(productType);
            switch (productType) {
                case "Casio":
                    if (product.isCasio()) {
                        System.out.println("*** Casio switch statement being executed ***");
                        System.out.println("** CASIO PRODUCT FOUND **");
                        product.display();
    //                    waitForElementToBeClickable(driver, product.getProductImageLink(), Duration.ofSeconds(10));
                        product.getProductImageLink().click();
                        System.out.println("** CASIO PDP SHOULD BE DISPLAYED **");
                        break outer;
                    }
                    break;
                default:
                System.out.println("ERROR : Product type " + productType + " is not recognised, please select a valid product type.");
            }
        }
    }

    public void findProductAndClick(String productType) throws InterruptedException {
        //clearProductCollectionIfPopulated();
        System.out.println(productType);
        switch (productType) {
//            case "Casio":
//                for (Product product : Product.ProductCollection) {
//                    if (product.isCasio()) {
//                        System.out.println("*** Casio switch statement being executed ***");
//                        System.out.println("** CASIO PRODUCT FOUND **");
//                        product.display();
//                        //                    waitForElementToBeClickable(driver, product.getProductImageLink(), Duration.ofSeconds(10));
//                        product.getProductImageLink().click();
//                        System.out.println("** CASIO PDP SHOULD BE DISPLAYED **");
//                        break;
//                    }
//                }
//                break;
            default:
//                System.out.println("ERROR : Product type " + productType + " is not recognised, please select a valid product type.");
                for (GenericProduct product : GenericProduct.ProductCollection) {
                    System.out.println(productType);
                    product.getProductImageLink().click();
                }
        }
    }

//    public void findGenericProductTypeAndClick(String productType) throws InterruptedException {
//        //clearProductCollectionIfPopulated();
//        for (GenericProduct product : GenericProduct.ProductCollection) {
//            System.out.println(productType);
//            product.getProductImageLink().click();
//        }
//    }

    public void clickAddToCart() {
        driver.findElement(addToCartButton).click();
    }

    /******************* Booleans ***********************/
    public boolean isMiniCartDisplayed() {
        return driver.findElement(miniCart).isDisplayed();
    }
}
