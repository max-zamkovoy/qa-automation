package com.amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage {

    private final String PRODUCT_DETAIL_URL = "https://www.amazon.com/Apple-iPhone-Fully-Unlocked-128/dp/B07P976BBH/";
    private final By ADD_TO_CART_BUTTON = By.id("add-to-cart-button");

    private final WebDriver DRIVER;

    public ProductDetailsPage(WebDriver driver) {
        this.DRIVER = driver;
        DRIVER.get(PRODUCT_DETAIL_URL);
    }

    public boolean isAddToCartButtonExist() {
        try {
            DRIVER.findElement(ADD_TO_CART_BUTTON);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
