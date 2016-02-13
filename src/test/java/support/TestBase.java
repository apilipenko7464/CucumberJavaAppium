package support;



import hooks.TestHooks;
import io.appium.java_client.AppiumDriver;

import org.testng.annotations.BeforeSuite;


public class TestBase {

	public static AppiumDriver driver;

    @BeforeSuite
	public void setUp(){
		System.out.println("Starting Appium driver.....");
		driver = TestHooks.getDriver();
	}
}
