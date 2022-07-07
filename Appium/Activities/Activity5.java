package activities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
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

public class Activity5 {

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
        caps.setCapability("appPackage", "com.google.android.apps.messaging");
        caps.setCapability("appActivity", ".ui.ConversationListActivity");
        caps.setCapability("noReset", true);

        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(appServer, caps);
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void sendMessage() {
        driver.findElementById("start_new_conversation_button").click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.id("recipient_text_view")));
        driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.apps.messaging:id/recipient_text_view\")")).sendKeys("8087759589");
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.id("compose_message_placeholder")));
        driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.apps.messaging:id/compose_message_text\")")).sendKeys("Message from Appium");
        driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.apps.messaging:id/send_message_button_icon\")")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.apps.messaging:id/message_text\")")));
        String messageText = driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.apps.messaging:id/message_text\")")).getText();
        Assert.assertEquals(messageText, "Message from Appium");
    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
