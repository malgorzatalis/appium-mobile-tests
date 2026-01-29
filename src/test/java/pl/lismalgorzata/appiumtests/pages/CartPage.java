package pl.lismalgorzata.appiumtests.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import pl.lismalgorzata.appiumtests.base.BasePage;

public class CartPage extends BasePage {

    private final By cartContainer = AppiumBy.accessibilityId("test-Cart Content");
    private final By continueShoppingButton = AppiumBy.accessibilityId("test-CONTINUE SHOPPING");
    private final By checkoutButton = AppiumBy.accessibilityId("test-CHECKOUT");
    private final By removeButton = AppiumBy.accessibilityId("test-REMOVE");

    public CartPage(AppiumDriver driver) {
        super(driver);
    }

    public boolean isDisplayed() {
        return isVisible(cartContainer);
    }

    public CheckoutInformationPage goToCheckout() {
        tap(checkoutButton);
        return new CheckoutInformationPage(driver);
    }
}
