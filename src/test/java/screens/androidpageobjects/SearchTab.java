package screens.androidpageobjects;
import base.ScreenBase;
import org.junit.Assert;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SearchTab extends ScreenBase {
    By Click_On_SearchTab = By.xpath("//android.widget.FrameLayout[@resource-id='com.travelpartner.parindey:id/navigation_explore']");
    By Click_On_User = By.xpath("//android.widget.LinearLayout[@resource-id='com.travelpartner.parindey:id/add_travel_story']");
    By Follow_User =  By.xpath("//android.widget.Button[@text='FOLLOW']");
    By Click_On_TravelShots = By.xpath("//android.widget.TextView[@text='TRAVEL SHOTS']");
    By Click_On_PlannedTrips = By.xpath("//android.widget.TextView[@text='PLANNED TRIPS']");
    By Click_On_MessageButton = By.xpath("//android.widget.Button[@text='MESSAGE']");

    @Test
    public void SearchedUser() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(Click_On_SearchTab).click();
        driver.findElement(Click_On_User).click();
        if (driver.findElements(Follow_User).size()>0) {
            WebElement test = driver.findElement(Follow_User);
            test.click();
        }
        driver.findElement(Click_On_TravelShots).click();
        driver.findElement(Click_On_PlannedTrips).click();
        driver.findElement(Click_On_MessageButton).click();
    }
}

