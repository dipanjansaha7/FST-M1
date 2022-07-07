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

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;

public class Activity1 {
    AndroidDriver<MobileElement> driver;

    public void takeScreenshot() throws IOException {
        // Take screenshot
        File scrShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//        String myString = date().toString();
//        System.out.println("The date is"+myString);
        // This specifies the location the screenshot will be saved
        long myTime = System.currentTimeMillis();
        File screenShotName = new File("src/test/resources/screenshot"+myTime+".jpg");
      //  File screenShotName = new File("src/test/resources/screenshot.jpg");
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
        DesiredCapabilities caps =  new DesiredCapabilities();
        caps.setCapability("platformName","android");
        caps.setCapability("automationName","UIAutomator2");
        //caps.setCapability("deviceName","AndroidTestEmulator");

        caps.setCapability("deviceName","RZ8M54DFYWR");
        //caps.setCapability("appPackage","com.android.calculator2");
        //Using the calc app in my Samsung A30 phone
        caps.setCapability("appPackage","com.sec.android.app.popupcalculator");

        caps.setCapability("appActivity",".Calculator");
        caps.setCapability("noReset",true);

        //Server URL
        URL serverURL=new URL("http://localhost:4723/wd/hub");

        driver=new AndroidDriver<>(serverURL,caps);

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
        //Find 5
        //MobileElement digit6 = driver.findElementById("calc_keypad_btn_06");
        //Find 6
        MobileElement digit6 = driver.findElementById("calc_keypad_btn_06");
        digit6.click();
        //Click Equal sign
        driver.findElementByAccessibilityId("Equal").click();
        //Get Result
        String resultValue = driver.findElementById("calc_edt_formula").getText();
        takeScreenshot();
        //Assertion
        Assert.assertEquals(resultValue,"30");
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
