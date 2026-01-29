package pl.lismalgorzata.appiumtests.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import pl.lismalgorzata.appiumtests.base.BasePage;

public class CheckoutInformationPage extends BasePage {
    private final By checkoutContainer = AppiumBy.accessibilityId("test-Checkout: Your Info");
    private final By firstNameInput = AppiumBy.accessibilityId("test-First Name");
    private final By lastNameInput = AppiumBy.accessibilityId("test-Last Name");
    private final By postCodeInput = AppiumBy.accessibilityId("test-Zip/Postal Code");
    private final By continueButton = AppiumBy.accessibilityId("test-CONTINUE");

    public CheckoutInformationPage(AppiumDriver driver) {
        super(driver);
    }

    public boolean isDisplayed() {
        return isVisible(checkoutContainer);
    }

    public CheckoutInformationPage enterFirstNameInput(String firstName) {
        type(firstNameInput, firstName);
        return this;
    }

    public CheckoutInformationPage enterLastNameInput(String lastName) {
        type(lastNameInput, lastName);
        return this;
    }

    public CheckoutInformationPage enterPostCode(String postCode) {
        type(postCodeInput, postCode);
        return this;
    }

    public CheckoutOverviewPage goToCheckoutOverview() {
        tap(continueButton);
        return new CheckoutOverviewPage(driver);
    }
}
