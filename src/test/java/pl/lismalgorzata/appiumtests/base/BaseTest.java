package pl.lismalgorzata.appiumtests.base;

import io.appium.java_client.AppiumDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pl.lismalgorzata.appiumtests.driver.DriverFactory;

public class BaseTest {
    protected AppiumDriver driver;

    @BeforeMethod
    protected void setUp() {
        driver = DriverFactory.createAndroidDriver();
    }

    @AfterMethod
    protected void tearDown() {
        if (driver != null) driver.quit();
    }
}
