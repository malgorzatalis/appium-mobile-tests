package pl.lismalgorzata.appiumtests.tests.feature;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.lismalgorzata.appiumtests.base.BaseTest;
import pl.lismalgorzata.appiumtests.config.ConfigLoader;
import pl.lismalgorzata.appiumtests.testdata.TestData;
import pl.lismalgorzata.appiumtests.testdata.UserCredentials;
import pl.lismalgorzata.appiumtests.pages.LoginPage;
import pl.lismalgorzata.appiumtests.pages.ProductsPage;

public class LoginTest extends BaseTest {
    TestData data = ConfigLoader.testData();
    UserCredentials userStandard = data.users.standard;
    UserCredentials userLocked = data.users.locked;

    @Test
    public void shouldLoginSuccessfully() {
        ProductsPage productsPage = new LoginPage(driver)
                .submitValidLogin(userStandard.username, userStandard.password);
        Assert.assertTrue(productsPage.isDisplayed(), "Products page should be displayed after successful login");
    }

    @Test
    public void shouldShowErrorForLockedUser() {
        LoginPage loginPage = new LoginPage(driver)
                .submitInvalidLogin(userLocked.username, userLocked.password);
        Assert.assertTrue(loginPage.isErrorDisplayed(), "Message error should be displayed after login with locked user");
        Assert.assertEquals(loginPage.getErrorMessageText(), "Sorry, this user has been locked out.");
    }

    @Test
    public void shouldShowErrorForEmptyPassword() {
        LoginPage loginPage = new LoginPage(driver)
                .submitInvalidLogin(userStandard.username, "");
        Assert.assertTrue(loginPage.isErrorDisplayed(), "Message error should be displayed after login without password");
        Assert.assertEquals(loginPage.getErrorMessageText(), "Password is required");
    }
}
