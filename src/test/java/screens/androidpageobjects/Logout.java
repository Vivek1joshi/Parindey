package screens.androidpageobjects;

import base.ScreenBase;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Logout extends ScreenBase {
    By Profile = By.xpath("//android.widget.FrameLayout[@index=4]");
    By MenuBar = By.xpath("//android.widget.FrameLayout[@index=4]");
    By LogOutButton = By.xpath("//android.widget.TextView[@text='Logout']");
    By YesButton =By.xpath("//android.widget.TextView[@text='Yes logout']");
    @Test
    public void logout(){
        driver.findElement(Profile).click();
        driver.findElement(MenuBar).click();
        driver.findElement(LogOutButton).click();
        driver.findElement(YesButton).click();
    }
}
