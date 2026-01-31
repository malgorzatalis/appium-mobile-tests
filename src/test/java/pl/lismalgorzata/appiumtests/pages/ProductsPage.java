package pl.lismalgorzata.appiumtests.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import pl.lismalgorzata.appiumtests.base.BasePage;

public class ProductsPage extends BasePage {

    private final By productsContainer = AppiumBy.accessibilityId("test-PRODUCTS");
    private final By addToCartButton = AppiumBy.accessibilityId("test-ADD TO CART");
    private final By cartButton = AppiumBy.accessibilityId("test-Cart");

    public ProductsPage(AppiumDriver driver) {
        super(driver);
    }

    public boolean isDisplayed() {
        try {
            visible(productsContainer);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public ProductsPage addFirstProductToCart() {
        tap(addToCartButton);
        return this;
    }

    public CartPage goToCart() {
        tap(cartButton);
        return new CartPage(driver);
    }
}
