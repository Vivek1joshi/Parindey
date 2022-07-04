package screens.androidpageobjects;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import base.ScreenBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class SignIn extends ScreenBase {
    By Remove_Interest = By.xpath("//android.widget.TextView[@text='Adeventure']");
    By Select_New_Interest = By.xpath("//android.widget.TextView[@text='Photography']");
    By Enter_Name = By.xpath("//android.widget.EditText[@text='What is your Name?']");
    By Click_On_Check_Button = By.xpath("//android.widget.ImageButton[@index=2]");
    By Enter_Born_Place = By.xpath("//android.widget.EditText[@text='When were you born?']");
    By Select_Date_Of_Birth = By.xpath("//android.widget.ImageButton[@index=2]");
    By Click_On_Location = By.id("com.travelpartner.parindey:id/inputLocation");
    By Enter_Location = By.xpath("//android.widget.TextView[@text='#100 Bed and Breakfast']");
    By Click_On_Plus_Tab = By.xpath("//android.widget.ImageButton[@resource-id='com.travelpartner.parindey:id/navigation_chat']");
    By Click_On_LoginWithGoogle = By.xpath("//android.widget.Button[@text='LOGIN WITH GOOGLE']");
    By Select_Gmail_Account = By.xpath("//android.widget.TextView[@text='vivekjoshi840@gmail.com']");
    @Test
    public void SignUp(String entername,String bornplace) throws InterruptedException {
        Actions actions = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        AndroidElement VerifyHomeScreen = (AndroidElement) driver.findElement(By.xpath("//android.widget.TextView[@text='Languages You Love']"));
        String ActualTitle = VerifyHomeScreen.getText();
        String ExpectedTitle = "Languages You Love";
        Assert.assertEquals(ActualTitle, ExpectedTitle, "Homepage  is not verified");
        System.out.println("Successfully navigated to homepage");
        String scrollElement = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"NEXT\").instance(0))";
        driver.findElementByAndroidUIAutomator(scrollElement).click();
        AndroidElement VerifyYourInterestScreen = (AndroidElement) driver.findElement(By.xpath("//android.widget.TextView[@text='Your Interests']"));
        String ActualTitle1 = VerifyYourInterestScreen.getText();
        String ExpectedTitle1 = "Your Interests";
        Assert.assertEquals(ActualTitle, ExpectedTitle, "InterestScreen is not verified");
        System.out.println("Successfully navigated to InterestScreen");
        driver.findElement(Remove_Interest).click();
        driver.findElement(Select_New_Interest).click();
        String scrollElement1 = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"NEXT\").instance(0))";
        driver.findElementByAndroidUIAutomator(scrollElement1).click();
        AndroidElement VerifyTellUsAboutYourselfScreen = (AndroidElement) driver.findElement(By.xpath("//android.widget.TextView[@text='Awesome!']"));
        String ActualTitle2 = VerifyTellUsAboutYourselfScreen.getText();
        String ExpectedTitle2 = "Awesome!";
        Assert.assertEquals(ActualTitle, ExpectedTitle, "TellUsAboutYourselfScreen is not verified");
        System.out.println("Successfully navigated to tell us about screen");
        driver.findElement(Enter_Name).click();
        actions.sendKeys(entername).build().perform();
        driver.findElement(Click_On_Check_Button).click();
        driver.findElement(Enter_Born_Place).click();
        actions.sendKeys(bornplace).build().perform();
        driver.findElement(Select_Date_Of_Birth).click();
        driver.findElement(Click_On_Location).click();
        driver.findElement(Enter_Location).click();
        String clickOnDone = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"DONE\").instance(0))";
        driver.findElementByAndroidUIAutomator(clickOnDone).click();
        AndroidElement VerifyDashboardScreen = (AndroidElement) driver.findElement(By.xpath("//android.widget.TextView[@text='Parindey']"));
        String ActualTitle3 = VerifyDashboardScreen.getText();
        String ExpectedTitle3 = "Parindey";
        Assert.assertEquals(ActualTitle, ExpectedTitle, "DashboardScreen is not verified");
        System.out.println("Successfully navigated to dashboard screen");
        driver.findElement(Click_On_Plus_Tab).click();
        driver.findElement(Click_On_LoginWithGoogle).click();
        driver.findElement(Select_Gmail_Account).click();
    }
}