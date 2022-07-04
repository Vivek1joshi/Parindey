package screens.androidpageobjects;
import base.ScreenBase;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class AddStory extends ScreenBase {
    By Click_On_Plus_Tab = By.xpath("//android.widget.FrameLayout[@resource-id='com.travelpartner.parindey:id/navigation_addpost']");
    By Click_AddTravelStory = By.xpath("//android.widget.TextView[@text='Add A Travel Story']");
    By Add_Image = By.xpath("//android.widget.TextView[@index=2]");
    By Click_On_Complete_Button = By.xpath("//android.widget.TextView[@text='Complete(1/6)']");
    By Click_On_Check_Button = By.xpath("//android.widget.TextView[@resource-id='com.travelpartner.parindey:id/menu_crop']");
    By Write_Story = By.xpath("//android.widget.EditText[@text='Type Something Here..']");
    By Click_Location = By.xpath("//android.widget.LinearLayout[@resource-id='com.travelpartner.parindey:id/textLocation']");
    By Select_Location = By.xpath("//android.widget.TextView[@text='100 Feet Hospital']");
    By Click_Add_Interests = By.xpath("//android.widget.TextView[@text='Add Interests']");
    By Select_Interests = By.xpath("//android.widget.TextView[@text='Hiking']");
    By Click_On_Screen = By.xpath("//android.view.View[@resource-id='com.travelpartner.parindey:id/touch_outside']");
    By Click_On_CheckButton = By.xpath("//android.view.View[@resource-id='com.travelpartner.parindey:id/publish_action']");

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
    public void AddTravelStory(String writestory) {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Actions action = new Actions(driver);
        driver.findElement(Click_AddTravelStory).click();
        Alert alert = driver.switchTo().alert();
        String alertMessage = driver.switchTo().alert().getText();
        System.out.println(alertMessage);
        alert.accept();
        driver.findElement(Add_Image).click();
        driver.findElement(Click_On_Complete_Button).click();
        driver.findElement(Click_On_Check_Button).click();
        driver.findElement(Write_Story).click();
        action.sendKeys(writestory).build().perform();
        driver.findElement(Click_Location).click();
        driver.findElement(Select_Location).click();
        driver.findElement(Click_Add_Interests).click();
        driver.findElement(Select_Interests).click();
        driver.switchTo().defaultContent();
       // driver.switch_to.frame( driver.findElement(Click_On_Screen).click());
        driver.findElement(Click_On_Screen).click();
        driver.findElement(Click_On_CheckButton).click();
        AndroidElement Verifying_Post_Uploaded_Successfully = (AndroidElement) driver.findElement(By.xpath("//android.widget.TextView[@text='Explore']"));
        String ActualTitle = Verifying_Post_Uploaded_Successfully.getText();
        String ExpectedTitle = "Explore";
        Assert.assertEquals(ActualTitle, ExpectedTitle, "Post is not uploaded");
        System.out.println("Post Uploaded successfully ");
    }
}
