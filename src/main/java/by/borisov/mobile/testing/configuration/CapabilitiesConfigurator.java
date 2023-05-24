package by.borisov.mobile.testing.configuration;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

public class CapabilitiesConfigurator {

    private CapabilitiesConfigurator() {

    }

    public static DesiredCapabilities getLocalCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.UDID,ConfigurationReader.get().udid());
        capabilities.setCapability(AndroidMobileCapabilityType.AVD,ConfigurationReader.get().localDeviceName());
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,ConfigurationReader.get().appPackage());
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,ConfigurationReader.get().appActivity());
        capabilities.setCapability(AndroidMobileCapabilityType.PLATFORM_NAME,ConfigurationReader.get().platformName());
        capabilities.setCapability(AndroidMobileCapabilityType.VERSION,ConfigurationReader.get().platformVersion());
        capabilities.setCapability(MobileCapabilityType.APP,new File(ConfigurationReader.get().appPath()).getAbsolutePath());
        return capabilities;
    }
}
