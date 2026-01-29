package pl.lismalgorzata.appiumtests.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import pl.lismalgorzata.appiumtests.base.BasePage;

public class CheckoutCompletePage extends BasePage {

    private final By checkoutCompleteContainer = AppiumBy.accessibilityId("test-CHECKOUT: COMPLETE!");

    private final By backHomeButton = AppiumBy.accessibilityId("test-BACK HOME");

    public CheckoutCompletePage(AppiumDriver driver) {
        super(driver);
    }

    public boolean isDisplayed() {
        return isVisible(checkoutCompleteContainer);
    }

    public ProductsPage backHome(){
        tap(backHomeButton);
        return new ProductsPage(driver);
    }
}
