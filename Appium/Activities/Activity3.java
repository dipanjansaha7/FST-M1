package activities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Activity3 {
    AndroidDriver<MobileElement> driver;

    public void takeScreenshot() throws IOException {
        // Take screenshot
        File scrShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        // This specifies the location the screenshot will be saved
        File screenShotName = new File("src/test/resources/screenshot.jpg");
        // This will copy the screenshot to the file created
        FileUtils.copyFile(scrShot, screenShotName);
        // Set filepath for image
        String filePath = "../" + screenShotName;
        // Set image HTML in the report
        String path = "<img src='" + filePath + "'/>";
        System.out.println(path);
        // Show image in report
        Reporter.log(path);
    }


    @BeforeClass
    public void setUp() throws MalformedURLException {
        //Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "android");
        caps.setCapability("automationName", "UIAutomator2");
        //caps.setCapability("deviceName","AndroidTestEmulator");

        caps.setCapability("deviceName", "RZ8M54DFYWR");
        //caps.setCapability("appPackage","com.android.calculator2");
        //Using the calc app in my Samsung A30 phone
        caps.setCapability("appPackage", "com.sec.android.app.popupcalculator");

        caps.setCapability("appActivity", ".Calculator");
        caps.setCapability("noReset", true);

        //Server URL
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver<>(serverURL, caps);

    }

    @Test
    public void multiplicationTest() throws IOException {
        //Find 5
        //MobileElement digit5 = driver.findElementById("digit_5");
        MobileElement digit5 = driver.findElementById("calc_keypad_btn_05");
        //Click 5
        digit5.click();
        //Find and click Multiplication
        //driver.findElementByAccessibilityId("calc_keypad_btn_mul").click();
        driver.findElementById("calc_keypad_btn_mul").click();
        //Find and clicking on 1 and 00
        //MobileElement digit6 = driver.findElementById("calc_keypad_btn_06");
        MobileElement digit1 = driver.findElementById("calc_keypad_btn_01");
        digit1.click();
        MobileElement digit0 = driver.findElementById("calc_keypad_btn_00");
        digit0.click();
        digit0.click();
        //Click Equal sign
        driver.findElementByAccessibilityId("Equal").click();
        //Get Result
        String resultValue = driver.findElementById("calc_edt_formula").getText();
        takeScreenshot();
        //Assertion
        Assert.assertEquals(resultValue, "500");
    }

    @Test
    public void additionTest() throws IOException {
        //Find 5
        //MobileElement digit5 = driver.findElementById("digit_5");
        MobileElement digit5 = driver.findElementById("calc_keypad_btn_05");
        //Click 5
        digit5.click();
        //Find and click Addition
        driver.findElementById("calc_keypad_btn_add").click();
        //Find and clicking on 9
        //MobileElement digit6 = driver.findElementById("calc_keypad_btn_06");
        MobileElement digit9 = driver.findElementById("calc_keypad_btn_09");
        digit9.click();
        //Click Equal sign
        driver.findElementByAccessibilityId("Equal").click();
        //Get Result
        String resultValue = driver.findElementById("calc_edt_formula").getText();
        takeScreenshot();
        //Assertion
        Assert.assertEquals(resultValue, "14");
    }

    @Test
    public void subtractTest() throws IOException {
        //Find 1 and 0
        //MobileElement digit5 = driver.findElementById("digit_5");
        MobileElement digit1 = driver.findElementById("calc_keypad_btn_01");
        //Click 1
        digit1.click();
        MobileElement digit0 = driver.findElementById("calc_keypad_btn_00");
        //Click 0
        digit0.click();
        //Find and click Subtraction
        driver.findElementById("calc_keypad_btn_sub").click();
        //Find and clicking on 5
        //MobileElement digit6 = driver.findElementById("calc_keypad_btn_06");
        MobileElement digit5 = driver.findElementById("calc_keypad_btn_05");
        digit5.click();
        //Click Equal sign
        driver.findElementByAccessibilityId("Equal").click();
        //Get Result
        String resultValue = driver.findElementById("calc_edt_formula").getText();
        takeScreenshot();
        //Assertion
        Assert.assertEquals(resultValue, "5");
    }

    @Test
    public void divideTest() throws IOException {
        //Find 5 and 0
        //MobileElement digit5 = driver.findElementById("digit_5");
        MobileElement digit5 = driver.findElementById("calc_keypad_btn_05");
        //Click 5
        digit5.click();
        MobileElement digit0 = driver.findElementById("calc_keypad_btn_00");
        //Click 0
        digit0.click();
        //Find and click Subtraction
        driver.findElementById("calc_keypad_btn_div").click();
        //Find and clicking on 2
        //MobileElement digit6 = driver.findElementById("calc_keypad_btn_06");
        MobileElement digit2 = driver.findElementById("calc_keypad_btn_02");
        digit2.click();
        //Click Equal sign
        driver.findElementByAccessibilityId("Equal").click();
        //Get Result
        String resultValue = driver.findElementById("calc_edt_formula").getText();
        takeScreenshot();
        //Assertion
        Assert.assertEquals(resultValue, "25");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}