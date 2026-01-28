package pl.lismalgorzata.appiumtests.tests;

import org.testng.annotations.Test;
import pl.lismalgorzata.appiumtests.base.BaseTest;

public class AppLaunchTest extends BaseTest {

    @Test
    void shouldLaunchApplication() {
        assert driver != null;
    }
}
