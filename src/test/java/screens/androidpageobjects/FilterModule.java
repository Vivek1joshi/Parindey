package screens.androidpageobjects;

import base.ScreenBase;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FilterModule extends ScreenBase {
    By MenuBar = By.xpath("//android.widget.ImageButton[@resource-id='com.travelpartner.parindey:id/menu']");
    By Select_Gender = By.xpath("//android.widget.FrameLayout[@index=1]");
    By Click_On_Location = By.xpath("//android.widget.LinearLayout[@resource-id='com.travelpartner.parindey:id/chooseLocation']");
    By Story_Card = By.xpath("//android.widget.LinearLayout[@resource-id='com.travelpartner.parindey:id/travel_story_card']");
    By Post_Card = By.xpath("//android.widget.LinearLayout[@resource-id='com.travelpartner.parindey:id/travel_post_card']");
    By Any_Card = By.xpath("//android.widget.LinearLayout[@resource-id='com.travelpartner.parindey:id/travel_any_card']");
    By Apply_Button = By.xpath("//android.widget.TextView[@text='Apply']");
    By Clear_Button = By.xpath("//android.widget.TextView[@text='Clear']");

    @Test
    public void ApplyFilter() {
        driver.findElement(MenuBar).click();
        AndroidElement VerifyFilterScreen = (AndroidElement) driver.findElement(By.xpath("//android.widget.TextView[@text='Filter By Gender']"));
        String ActualTitle = VerifyFilterScreen.getText();
        String ExpectedTitle = "Filter By Gender";
        Assert.assertEquals(ActualTitle, ExpectedTitle, "Filter screen is not verified");
        System.out.println("Successfully navigated to filter screen");
        driver.findElement(Select_Gender).click();
        driver.findElement(Click_On_Location).click();
        String scrollElement = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"3 R Distributary\").instance(0))";
        driver.findElementByAndroidUIAutomator(scrollElement).click();
        driver.findElement(Story_Card).click();
        driver.findElement(Post_Card).click();
        driver.findElement(Any_Card).click();
        driver.findElement(Apply_Button).click();
        AndroidElement VerifyHomeScreen = (AndroidElement) driver.findElement(By.xpath("//android.widget.TextView[@text='Parindey']"));
        String ActualTitle1 = VerifyHomeScreen.getText();
        String ExpectedTitle1 = "Parindey";
        Assert.assertEquals(ActualTitle1, ExpectedTitle1, "Home screen is not verified");
        System.out.println("Successfully navigated to home screen");
    }

    @Test
    public void ClearFilter() {
        driver.findElement(MenuBar).click();
        driver.findElement(Select_Gender).click();
        driver.findElement(Click_On_Location).click();
        String scrollElement = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"3 R Distributary\").instance(0))";
        driver.findElementByAndroidUIAutomator(scrollElement).click();
        driver.findElement(Story_Card).click();
        driver.findElement(Post_Card).click();
        driver.findElement(Any_Card).click();
        driver.findElement(Clear_Button).click();
        AndroidElement VerifyHomeScreen = (AndroidElement) driver.findElement(By.xpath("//android.widget.TextView[@text='Parindey']"));
        String ActualTitle1 = VerifyHomeScreen.getText();
        String ExpectedTitle1 = "Parindey";
        Assert.assertEquals(ActualTitle1, ExpectedTitle1, "Home screen is not verified");
        System.out.println("Successfully navigated to home screen");
    }
}
