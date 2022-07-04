package screens.androidpageobjects;
import base.ScreenBase;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DashBoardScreen extends ScreenBase {
    By Click_On_MenuBar = By.xpath("//android.widget.ImageButton[@resource-id='com.travelpartner.parindey:id/more_options']");
    By Click_On_Report = By.xpath("//android.widget.TextView[@text='Report']");
    By Click_On_Comment = By.xpath("//android.widget.TextView[@text='Comment']");
    By Write_Comment = By.xpath("//android.widget.EditText[@resource-id='com.travelpartner.parindey:id/commentInput']");
    By Click_On_PostButton = By.xpath("//android.widget.TextView[@text='Post']");
    By Click_On_BackButton = By.xpath("//android.widget.ImageButton[@resource-id='com.travelpartner.parindey:id/home_up']");
    By Click_On_CopLink = By.xpath("//android.widget.TextView[@text='Copy link']");
    By Click_On_Screen = By.xpath("//android.view.View[@resource-id='com.travelpartner.parindey:id/touch_outside']");
   // By Click_On_Interest = By.xpath("//android.widget.TextView[@text='I'm Interested']");

    @Test
    public void MenuBar(String comment) {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Actions actions = new Actions(driver);
        driver.findElement(Click_On_MenuBar).click();
      //  driver.findElement(Click_On_Report).click();
//        Alert alert = driver.switchTo().alert();
//        alert.accept();
        driver.findElement(Click_On_Comment).click();
        driver.findElement(Write_Comment).click();
        actions.sendKeys(comment).build().perform();
        driver.findElement(Click_On_PostButton).click();
        driver.findElement(Click_On_BackButton).click();
        driver.findElement(Click_On_CopLink).click();
        driver.findElement(Click_On_Screen).click();
        String scrollElement = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"I'm Interested\").instance(0))";
        driver.findElementByAndroidUIAutomator(scrollElement).click();

    }
}

