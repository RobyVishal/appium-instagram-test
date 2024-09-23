package com.roby;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.URL;

public class FormSubmissionTest {
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
    public void testFormSubmission() {
        // Simulate filling out a form and submitting it
        MobileElement nameField = driver.findElementByAccessibilityId("name");
        nameField.sendKeys("Test User");

        MobileElement emailField = driver.findElementByAccessibilityId("email");
        emailField.sendKeys("test@example.com");

        MobileElement submitButton = driver.findElementByAccessibilityId("submitButton");
        submitButton.click();

        System.out.println("Form Submission Test Completed!");
    }

    @Test
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

