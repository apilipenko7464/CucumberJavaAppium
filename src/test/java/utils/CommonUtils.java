package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Created by idorovskikh on 1/18/16.
 */
public class CommonUtils {
    private static Properties prop = new Properties();
    private static String APPIUM_PORT;
    private static DesiredCapabilities capabilities = new DesiredCapabilities();
    private static URL serverUrl;
    private static AppiumDriver driver;
    public static String loadPropertyFile = "iOS.properties";


    public static void setIOSCapabilities() throws IOException {
        FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/properties/" + loadPropertyFile);
        prop.load(file);
        APPIUM_PORT = prop.getProperty("appium.server.port");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,
                prop.getProperty("platform.version"));
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,
                prop.getProperty("platform.name"));
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,
                prop.getProperty("device.name"));
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,
                prop.getProperty("automation.instumentation"));
        capabilities.setCapability(MobileCapabilityType.APP, prop.getProperty("application.app"));
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,
                Integer.valueOf(prop.getProperty("new.command.timeout")));
        capabilities.setCapability(MobileCapabilityType.DEVICE_READY_TIMEOUT,
                prop.getProperty("device.ready.timeout"));
        capabilities.setCapability(MobileCapabilityType.APP,
                System.getProperty("user.dir") + prop.getProperty("application.path"));
    }

    public static AppiumDriver getIOSDriver() throws MalformedURLException {
        serverUrl = new URL("http://localhost:" + APPIUM_PORT + "/wd/hub");
        driver = new IOSDriver(serverUrl, capabilities);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver;
    }
}
