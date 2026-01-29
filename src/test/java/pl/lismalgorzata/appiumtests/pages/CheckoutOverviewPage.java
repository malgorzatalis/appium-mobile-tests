package pl.lismalgorzata.appiumtests.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import pl.lismalgorzata.appiumtests.base.BasePage;

public class CheckoutOverviewPage extends BasePage {
    private final By checkoutContainer = AppiumBy.accessibilityId("test-CHECKOUT: OVERVIEW");
    private final By finishButton = AppiumBy.accessibilityId("test-FINISH");
    private static final String FINISH_A11Y = "test-FINISH";


    public CheckoutOverviewPage(AppiumDriver driver) {
        super(driver);
    }

    public boolean isDisplayed() {
        return isVisible(checkoutContainer);
    }

    public CheckoutCompletePage completeOrder() {
        scrollToAccessibilityId(FINISH_A11Y);
        tap(finishButton);
        return new CheckoutCompletePage(driver);
    }
}
