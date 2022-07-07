package activities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Activity2 {

    AndroidDriver<MobileElement> driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        //Desired Capabilities
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

        //Server URL
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver<>(serverURL, caps);
    }

    @Test
    public void getHeading(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        driver.get("https://www.training-support.net/");
        //wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByAccessibilityId("About Us")));
        String pageTitle = driver.findElementByXPath("//android.widget.TextView[@text='Training Support']").getText();
        System.out.println("The Title of the Page is: "+pageTitle);
        Reporter.log("The Title of the Page is: "+pageTitle);

        System.out.println("Clicking the About Us Button");
        driver.findElementByAccessibilityId("About Us").click();
        //driver.findElementById("about-link").click();

        wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//android.widget.TextView[@text='About Us']")));
        String newPageTitle = driver.findElementByXPath("//android.widget.TextView[@text='About Us']").getText();
        System.out.println("The Title of the Page is: "+newPageTitle);
        Reporter.log("The Title of the Page is: "+newPageTitle);

        Assert.assertEquals(pageTitle, "Training Support");
        Assert.assertEquals(newPageTitle, "About Us");


    }

    @AfterClass
    public void tearDown () {
        driver.quit();
    }
}