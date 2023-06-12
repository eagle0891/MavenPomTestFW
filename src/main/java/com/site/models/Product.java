package com.site.models;

import com.site.base.TestBase;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product extends TestBase {
    public static ArrayList<Product> ProductCollection;
    boolean isCasio;
    String name;
    String description;
    String wholePrice;
    String decimalPricePart;
//    String productTitleLinkUrl;
    WebElement productWebElement;
    WebElement casioSelection;
    WebElement productImageLink;

    public Product(String productName, String productWholePricePart, String productDecimalPricePart, /*String productTitleLinkURL,*/ WebElement product, boolean isCasio, WebElement casioSelection, WebElement productImageLink) {
        this.name = productName;
        this.wholePrice = productWholePricePart;
        this.decimalPricePart = productDecimalPricePart;
        this.productWebElement = product;
        this.casioSelection = casioSelection;
        this.isCasio = isCasio;
        this.productImageLink = productImageLink;
//        this.productTitleLinkUrl = productTitleLinkURL;
        //add the image selector here somewhere as a webelement
    }

    public void display(){
        System.out.println("****************************");
        System.out.println("PRODUCT NAME : " + getName());
        System.out.println("PRODUCT PRICE : " + getWholePrice() + "." + getDecimalPricePart());
        System.out.println("PRODUCT SAMSUNG : " + isCasio);
    }

}