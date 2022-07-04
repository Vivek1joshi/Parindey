package base;
import java.io.File;
import java.net.MalformedURLException;

import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.CommonUtils;
import utils.AppConfigTags;
import utils.Constants;

public class TestBase {

    public static AndroidDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {

        pageObjectConfig();
        System.out.println("Setup TestCase");

        CommonUtils utils = new CommonUtils();

        utils.setup(AppConfigTags.ANDROID, AppConfigTags.SAMSUNG, Constants.ANDROID_URI);
        driver = utils.driver;

    }

    private void pageObjectConfig() {

    }
	@AfterClass
	public void tearDown() {

		driver.quit();

	}

}
