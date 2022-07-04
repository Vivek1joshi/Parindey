package screens.androidpageobjects;

import base.ScreenBase;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FindTravelPartner extends ScreenBase {
    By Click_On_Plus_Tab = By.xpath("//android.widget.FrameLayout[@resource-id='com.travelpartner.parindey:id/navigation_addpost']");
    By Click_Find_Travel_Partner = By.xpath("//android.widget.TextView[@text='Find Travel Partner']");
    By Write_Trip_Paln = By.xpath("//android.widget.EditText[@resource-id='com.travelpartner.parindey:id/captionInput']");
    By Click_On_Location = By.xpath("//android.widget.LinearLayout[@resource-id='com.travelpartner.parindey:id/chooseLocation']");
    By Select_Location = By.xpath("//android.widget.TextView[@text='1589 Generation X']");
    By Choose_Travel_Date = By.xpath("//android.widget.LinearLayout[@resource-id='com.travelpartner.parindey:id/chooseDate']");
    By Select_Gender = By.xpath("//android.widget.FrameLayout[@index=2]");
    By Click_On_Checkbox = By.xpath("//android.widget.TextView[@resource-id='com.travelpartner.parindey:id/publish_action']");
    By Click_Okk_Button = By.xpath("//android.widget.Button[@text='OK']");

    @Test
    public void ClickOnPlusTab() {
        driver.findElement(Click_On_Plus_Tab).click();
        AndroidElement VerifyTravelScreen = (AndroidElement) driver.findElement(By.xpath("//android.widget.TextView[@text='Add A Travel Story']"));
        String ActualTitle = VerifyTravelScreen.getText();
        String ExpectedTitle = "Add A Travel Story";
        Assert.assertEquals(ActualTitle, ExpectedTitle, "Travel story screen  is not verified");
        System.out.println("Dialog box is displayed on screen ");
    }

    @Test
    public void TravelPartner(String writeplan) {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Actions action = new Actions(driver);
        driver.findElement(Click_Find_Travel_Partner).click();
        driver.findElement(Write_Trip_Paln).click();
        action.sendKeys(writeplan).build().perform();
        driver.findElement(Click_On_Location).click();
        driver.findElement(Select_Location).click();
        String bookingdate = "17-JANUARY-2023";
        String[] temp = bookingdate.split("-");
        int date = Integer.parseInt(temp[0]) - 1;
        String month = temp[1];
        String year = temp[2];
        String newdate = month + " " + year;
        driver.findElement(Choose_Travel_Date).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//android.widget.FrameLayout[@resource-id='com.travelpartner.parindey:id/mtrl_calendar_frame']")));
        while (true) {
            if (driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.travelpartner.parindey:id/month_navigation_fragment_toggle']")).getText().equals(newdate)) {
                driver.findElement(By.xpath("//android.widget.TextView[@index='" + date + "']")).click();
                break;
            } else {
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@resource-id='com.travelpartner.parindey:id/month_navigation_next']"))).click();
            }
        }
        driver.findElement(Click_Okk_Button).click();
        driver.findElement(Select_Gender).click();
        driver.findElement(Click_On_Checkbox).click();
    }
}


