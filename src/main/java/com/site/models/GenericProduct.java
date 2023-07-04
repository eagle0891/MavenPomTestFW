package com.site.models;

import com.site.base.TestBase;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GenericProduct extends TestBase {
    public static ArrayList<GenericProduct> ProductCollection;
    String name;
    String description;
    String wholePrice;
    String decimalPricePart;
    WebElement productWebElement;
    WebElement productImageLink;

    public GenericProduct(String productName, String productWholePricePart, String productDecimalPricePart, WebElement product, WebElement productImageLink) {
        this.name = productName;
        this.wholePrice = productWholePricePart;
        this.decimalPricePart = productDecimalPricePart;
        this.productWebElement = product;
        this.productImageLink = productImageLink;
    }

}