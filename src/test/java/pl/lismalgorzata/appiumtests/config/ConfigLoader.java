package pl.lismalgorzata.appiumtests.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import pl.lismalgorzata.appiumtests.testdata.TestData;

import java.io.InputStream;

public class ConfigLoader {
    private static AndroidConfig androidConfig;

    public static AndroidConfig android() {
        if (androidConfig == null) {
            try {
                ObjectMapper mapper = new ObjectMapper();
                InputStream is = ConfigLoader.class
                        .getClassLoader()
                        .getResourceAsStream("config/android.json");
                if (is == null)
                    throw new RuntimeException("config/android.json not found on classpath");
                androidConfig = mapper.readValue(is, AndroidConfig.class);
            } catch (Exception e) {
                throw new RuntimeException("Cannot load android.json", e);
            }
        }
        return androidConfig;
    }

    private static TestData testData;

    public static TestData testData() {
        if (testData == null) {
            try {
                ObjectMapper mapper = new ObjectMapper();
                InputStream is = ConfigLoader.class
                        .getClassLoader()
                        .getResourceAsStream("testdata/testdata.json");

                if (is == null) {
                    throw new RuntimeException("config/testdata.json not found");
                }

                testData = mapper.readValue(is, TestData.class);
            } catch (Exception e) {
                throw new RuntimeException("Cannot load testdata.json", e);
            }
        }
        return testData;
    }
}