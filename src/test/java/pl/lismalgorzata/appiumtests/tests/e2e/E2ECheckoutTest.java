package pl.lismalgorzata.appiumtests.tests.e2e;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.lismalgorzata.appiumtests.base.BaseTest;
import pl.lismalgorzata.appiumtests.config.ConfigLoader;
import pl.lismalgorzata.appiumtests.config.DeliveryData;
import pl.lismalgorzata.appiumtests.config.TestData;
import pl.lismalgorzata.appiumtests.config.UserCredentials;
import pl.lismalgorzata.appiumtests.pages.*;

public class E2ECheckoutTest extends BaseTest {

    @Test
    public void shouldCompleteCheckoutSuccessfully() {
        TestData data = ConfigLoader.testData();
        UserCredentials user = data.users.standard;
        DeliveryData checkoutInfo = data.deliveryData;

        ProductsPage productsPage = new LoginPage(driver)
                .login(user.username, user.password);
        Assert.assertTrue(productsPage.isDisplayed(), "Products page should be displayed after login");

        CartPage cartPage = productsPage
                .addFirstProductToCart()
                .goToCart();
        Assert.assertTrue(cartPage.isDisplayed(), "Cart page should be displayed");

        CheckoutInformationPage infoPage = cartPage.goToCheckout();
        Assert.assertTrue(infoPage.isDisplayed(), "Checkout information page should be displayed");

        CheckoutOverviewPage overviewPage = infoPage
                .enterFirstNameInput(checkoutInfo.firstName)
                .enterLastNameInput(checkoutInfo.lastName)
                .enterPostCode(checkoutInfo.postalCode)
                .goToCheckoutOverview();
        Assert.assertTrue(overviewPage.isDisplayed(), "Checkout overview page should be displayed");

        CheckoutCompletePage completePage = overviewPage.completeOrder();
        Assert.assertTrue(completePage.isDisplayed(), "Checkout complete page should be displayed");

        ProductsPage backHome = completePage.backHome();
        Assert.assertTrue(backHome.isDisplayed(), "Products page should be displayed after back home");
    }
}
