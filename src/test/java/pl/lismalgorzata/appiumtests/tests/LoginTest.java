package pl.lismalgorzata.appiumtests.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.lismalgorzata.appiumtests.base.BaseTest;
import pl.lismalgorzata.appiumtests.config.ConfigLoader;
import pl.lismalgorzata.appiumtests.config.TestData;
import pl.lismalgorzata.appiumtests.config.UserCredentials;
import pl.lismalgorzata.appiumtests.pages.LoginPage;
import pl.lismalgorzata.appiumtests.pages.ProductsPage;

public class LoginTest extends BaseTest {
    TestData data = ConfigLoader.testData();
    UserCredentials userStandard = data.users.standard;

    @Test
    public void shouldLoginSuccessfully() {
        ProductsPage productsPage = new LoginPage(driver)
                .login(userStandard.username, userStandard.password);
        Assert.assertTrue(productsPage.isDisplayed(), "Products page should be displayed after successful login");
    }
}
