package activities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Activity4 {
    AndroidDriver<MobileElement> driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("platformName", "android");
        caps.setCapability("automationName", "UIAutomator2");
        //caps.setCapability("deviceName","AndroidTestEmulator");

        caps.setCapability("deviceName", "RZ8M54DFYWR");
        //caps.setCapability("appPackage","com.android.calculator2");
        //Using the Chrome browser app in my Samsung A30 phone
        caps.setCapability("appPackage","com.android.contacts");
        caps.setCapability("appActivity", ".activities.PeopleActivity");
        caps.setCapability("noReset", true);

        URL serverURL = new URL("http://0.0.0.0:4723/wd/hub");

        driver = new AndroidDriver<MobileElement>(serverURL, caps);
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void addNewContact(){
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("floating_action_button")));
        driver.findElementById("floating_action_button").click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath("//android.widget.EditText[@text='First name']")));
        driver.findElementByXPath("//android.widget.EditText[@text='First name']").sendKeys("Aaditya");
        driver.findElementByXPath("//android.widget.EditText[@text='Last name']").sendKeys("Varma");
        driver.findElementByXPath("//android.widget.EditText[@text='Phone']").sendKeys("999148292");
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.id("editor_menu_save_button")));
        driver.findElementById("editor_menu_save_button").click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.id("toolbar_parent")));
        String savedTitle = driver.findElementById("large_title").getText();
        Assert.assertEquals(savedTitle, "Aaditya Varma");
        System.out.println("New Contact has been successfully added");
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
