package pl.lismalgorzata.appiumtests.driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import pl.lismalgorzata.appiumtests.config.AndroidConfig;
import pl.lismalgorzata.appiumtests.config.ConfigLoader;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;

public class DriverFactory {
    public static AppiumDriver createAndroidDriver() {
        AndroidConfig config = ConfigLoader.android();

        String appPath = System.getProperty("appPath");
        if (appPath == null || appPath.isBlank()) {
            throw new IllegalStateException("appPath is required");
        }

        Path apk = Paths.get(appPath);
        if (!Files.exists(apk)) {
            throw new IllegalStateException("APK not found at appPath: " + apk.toAbsolutePath());
        }

        UiAutomator2Options options = new UiAutomator2Options()
                .setPlatformName(config.platformName)
                .setAutomationName(config.automationName)
                .setDeviceName(config.deviceName)
                .setNoReset(config.noReset)
                .setApp(appPath)
                .setAppPackage(config.appPackage)
                .setAppWaitActivity(config.appWaitActivity);

        try {
            AppiumDriver driver = new AndroidDriver(new URL(config.serverUrl), options);

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
            return driver;

        } catch (Exception e) {
            throw new RuntimeException("Failed to create Android driver", e);
        }
    }
}
