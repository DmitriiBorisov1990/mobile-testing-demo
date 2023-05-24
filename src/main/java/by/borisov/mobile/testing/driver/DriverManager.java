package by.borisov.mobile.testing.driver;

import by.borisov.mobile.testing.configuration.AddressConfigurator;
import by.borisov.mobile.testing.configuration.CapabilitiesConfigurator;
import by.borisov.mobile.testing.configuration.ConfigurationReader;
import by.borisov.mobile.testing.configuration.EnvironmentType;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.io.IOException;
import java.util.Optional;

public class DriverManager {

    private static final EnvironmentType ENVIRONMENT_TYPE = EnvironmentType.valueOf(ConfigurationReader.get().env().toUpperCase());
    private static AppiumDriver<MobileElement> driver;

    private DriverManager() {

    }

    public static AppiumDriver<MobileElement> getDriver() {
        if (driver == null) {
            driver = createDriver();
        }
        return driver;
    }

    private static AppiumDriver<MobileElement> createDriver() {
        switch (ENVIRONMENT_TYPE) {
            case LOCAL:
                driver = new AndroidDriver<>(AddressConfigurator.getAppiumDriverLocalService(ConfigurationReader.get().appiumPort()),
                        CapabilitiesConfigurator.getLocalCapabilities());
                break;
            default:
                throw new RuntimeException();
        }
        return driver;
    }

    public static void closeDriver() {
        Optional.ofNullable(getDriver()).ifPresent(driverInstance -> {
            driver.quit();
            driver = null;
        });
    }

    public static void closeEmulator() {
        try {
            Runtime.getRuntime().exec(String.format("adb -s %s emu kill", ConfigurationReader.get().udid()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void closeAppium() {
        AddressConfigurator.stopService();
    }
}
