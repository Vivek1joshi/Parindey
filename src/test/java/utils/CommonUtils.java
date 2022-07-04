package utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import io.appium.java_client.android.AndroidElement;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;

public class CommonUtils {

    DesiredCapabilities caps = new DesiredCapabilities();

    public static AndroidDriver<AndroidElement> driver;

    public static AndroidDriver getDrivers() {
        return driver;
    }

    public void setup(String platformName, String deviceName, String uri) throws MalformedURLException {
        caps.setCapability("platformName", platformName);
        caps.setCapability("deviceName", deviceName);
        caps.setCapability("app", uri);
        caps.setCapability("noReset", false);
        caps.setCapability("deviceName", deviceName);
        driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public static Properties read_properties() throws IOException {


        File file = new File("C://Users//VivekJoshi//Desktop//Demo//AmazonAppiumFramework");
        Properties prop = new Properties();


        InputStreamReader is = new InputStreamReader(new FileInputStream(file));
        prop.load(is);
        return prop;
    }
    public static void main(String... args) throws IOException {
        CommonUtils.read_properties();
    }
    public static void getScreenshot(String s) throws IOException {
  File srcfile =  ( (TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
   FileUtils.copyFile(srcfile,new File(("user.dir")+"//screenshot//"+s+".png"));
   }
}