package ReportManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.appium.java_client.android.AndroidDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.CommonUtils;
import java.io.IOException;

public class Listener implements ITestListener {

    ExtentReports extent = ExtentReport.extentReportGenerator();
    ExtentTest test;
    AndroidDriver driver;


    public void onFinish(ITestContext context) {
        extent.flush();
    }


    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
    }

    public void onTestSuccess(ITestResult result) {

        test.log(Status.PASS, "No Issues encountered!");
    }
    public void onTestFailure(ITestResult result) {
        test.fail(result.getThrowable());
            String s = result.getName();
        try {
            CommonUtils.getScreenshot(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void onTestSkipped(ITestResult result) {
    }


    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }


    public void onStart(ITestContext context) {
    }
}


