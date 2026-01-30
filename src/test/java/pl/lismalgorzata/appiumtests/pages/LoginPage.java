package pl.lismalgorzata.appiumtests.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import pl.lismalgorzata.appiumtests.base.BasePage;

public class LoginPage extends BasePage {

    private final By usernameInput = AppiumBy.accessibilityId("test-Username");
    private final By passwordInput = AppiumBy.accessibilityId("test-Password");
    private final By loginButton = AppiumBy.accessibilityId("test-LOGIN");
    private final By errorMessageContainer = AppiumBy.accessibilityId("test-Error message");
    private final By errorMessageText = AppiumBy.xpath("//*[@content-desc='test-Error message']//android.widget.TextView");

    public LoginPage(AppiumDriver driver) {
        super(driver);
    }

    public LoginPage enterUsername(String username) {
        type(usernameInput, username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        type(passwordInput, password);
        return this;
    }

    public ProductsPage submitValidLogin(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        tap(loginButton);
        return new ProductsPage(driver);
    }

    public boolean isErrorDisplayed() {
        return isVisible(errorMessageContainer);
    }

    public LoginPage submitInvalidLogin(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        tap(loginButton);
        return this;
    }

    public String getErrorMessageText() {
        return visible(errorMessageText).getText().trim();
    }
}
