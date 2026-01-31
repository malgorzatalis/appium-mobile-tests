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

        String platformName = propertiesOrDefault("platformName", config.platformName);
        String automationName = propertiesOrDefault("automationName", config.automationName);
        String deviceName = propertiesOrDefault("deviceName", config.deviceName);
        String serverUrl = propertiesOrDefault("serverUrl", config.serverUrl);
        boolean noReset = boolProperitesOrDefault("noReset", config.noReset);

        UiAutomator2Options options = new UiAutomator2Options()
                .setPlatformName(platformName)
                .setAutomationName(automationName)
                .setDeviceName(deviceName)
                .setNoReset(noReset)
                .setApp(appPath)
                .setAppPackage(propertiesOrDefault("appPackage", config.appPackage))
                .setAppWaitActivity(propertiesOrDefault("appWaitActivity", config.appWaitActivity));

        try {
            AppiumDriver driver = new AndroidDriver(new URL(serverUrl), options);

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
            return driver;

        } catch (Exception e) {
            throw new RuntimeException("Failed to create Android driver", e);
        }
    }

    private static String propertiesOrDefault(String key, String defaultValue) {
        String value = System.getProperty(key);
        return (value == null || value.isBlank() ? defaultValue : value.trim());
    }

    private static boolean boolProperitesOrDefault(String key, boolean defaultValue) {
        String value = System.getProperty(key);
        return (value == null || value.isBlank()) ? defaultValue : Boolean.parseBoolean(value.trim());
    }
}
