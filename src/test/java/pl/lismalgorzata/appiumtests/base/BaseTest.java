package pl.lismalgorzata.appiumtests.base;

import io.appium.java_client.AppiumDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pl.lismalgorzata.appiumtests.driver.DriverFactory;

public class BaseTest {
    protected AppiumDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = DriverFactory.createAndroidDriver();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
