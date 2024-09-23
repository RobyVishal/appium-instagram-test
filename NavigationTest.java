package com.roby;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.URL;

public class NavigationTest {
    AndroidDriver<MobileElement> driver;

    @BeforeTest
    public void setUp() throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("deviceName", "Android Emulator");
        caps.setCapability("app", "resources/Instagram_349.3.0.42.104_APKPure.apk");  // Path to Instagram APK
        driver = new AndroidDriver<>(new URL("http://localhost:4723"), caps);
    }

    @Test
    public void testNavigation() {
        // Simulate navigation through different pages
        MobileElement menuButton = driver.findElementByAccessibilityId("menuButton");
        menuButton.click();

        MobileElement settingsOption = driver.findElementByAccessibilityId("settingsOption");
        settingsOption.click();

        System.out.println("Navigation Test Completed!");
    }

    @Test
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

