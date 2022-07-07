package activities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class Activity6 {

    AndroidDriver<MobileElement> driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("platformName", "android");
        caps.setCapability("automationName", "UIAutomator2");
        //caps.setCapability("deviceName","AndroidTestEmulator");

        caps.setCapability("deviceName", "RZ8M54DFYWR");
        //caps.setCapability("appPackage","com.android.calculator2");
        //Using the Chrome browser app in my Samsung A30 phone

        caps.setCapability("appPackage", "com.android.chrome");
        caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
        caps.setCapability("noReset", true);

        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(appServer, caps);
        driver.get("https://www.training-support.net/selenium/lazy-loading");
    }

    @Test
    public void testTrainingSite(){
        MobileElement pageTitle = driver.findElementByClassName("android.widget.TextView");
        wait.until(ExpectedConditions.textToBePresentInElement(pageTitle, "Lazy Loading"));
        List<MobileElement> numberOfImages = driver.findElementsByXPath("android.webkit.WebView/android.view.View/android.view.View");
        System.out.println("Number of image shown currently: " + numberOfImages.size());
        Assert.assertEquals(numberOfImages.size(), 0);
        driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector()).scrollTextIntoView(\"ade\")"));
        numberOfImages = driver.findElementsByXPath("//android.view.View/android.view.View/android.widget.Image");
        System.out.println("Number of image shown currently: " + numberOfImages.size());
        Assert.assertEquals(numberOfImages.size(), 4);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
